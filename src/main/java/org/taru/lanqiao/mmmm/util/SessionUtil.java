package org.taru.lanqiao.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SessionUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static
    {
        String resource ="mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设计模式？？sql 工厂生产sql Session（connecttion） 一次链接数据库的过程
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    public static SqlSession openSqlSession(){
        return sqlSessionFactory.openSession();
    }


}
