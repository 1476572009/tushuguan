package org.taru.lanqiao.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;


public class SqlUtil {
	
	private  static  final  String  DRIVER="driver";
	private  static  final  String  URL ="url";
	private  static  final  String  USERNAME="username";
	private  static  final  String  PASSWORD="password";
	static  Properties proper =new Properties();

	static  ThreadLocal<Connection>   container=new  ThreadLocal<Connection>();
		
static{
		
		try {
			proper.load(SqlUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			System.out.println("初始化配置文件成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//1����������
	static {
		try {
			Class.forName(proper.getProperty(DRIVER));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//2����ȡ����
	public static Connection   getConnection(){
		Connection  conn =container.get();
		try {
			if(conn==null  || conn.isClosed()){
				conn =	DriverManager.getConnection(proper.getProperty(URL),
						proper.getProperty(USERNAME),proper.getProperty(PASSWORD));
				container.set(conn);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  conn;
	}
	
	public  static ArrayList<HashMap<String,Object>>    executeQuery(String sql,Object ... params){
		ArrayList<HashMap<String,Object>>  list=new  ArrayList<HashMap<String,Object>>();
		Connection conn =	getConnection();
		PreparedStatement pst=null;
		ResultSet  rs=null;
		try {
			pst  =	conn.prepareStatement(sql);
			
			if(params!=null){
				for(int i =0;i<params.length;i++){
					pst.setObject(i+1, params[i]);
				}
			}
			rs =  pst.executeQuery();
			
			int count = rs.getMetaData().getColumnCount(); 
		 
			while(rs.next()){
				HashMap<String ,Object>  row =new  HashMap<String ,Object> ();
				for(int i=0;i<count;i++){
					String key =rs.getMetaData().getColumnLabel(i+1);
					Object  value =rs.getObject(key);
					row.put(key, value);
				}
				list.add(row);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return  list;
		
		
	}
	
	
	
	public  static int    executeUpdate(String sql,Object ... params){
		Connection conn =	getConnection();
		int row=0;
		PreparedStatement pst=null;
		
		try {
			pst  =	conn.prepareStatement(sql);
			if(params!=null){
				for(int i =0;i<params.length;i++){
					pst.setObject(i+1, params[i]);
				}
			}
			row =  pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pst!=null){
				try {
					pst.close();
					pst=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return  row;
		
		
	}
	

	public  static void   close(){
		if(container.get()!=null){
			try {
				container.get().close();
				container.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
}
