package org.taru.lanqiao.mmmm.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.taru.lanqiao.mmmm.model.user;

import org.taru.lanqiao.mmmm.service.UserService;
import org.taru.lanqiao.vo.jsonresult;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class userApi {
    private static final Logger logger= LoggerFactory.getLogger(userApi.class);
    @Autowired
    UserService us;
    jsonresult result=null;


    @RequestMapping("/login")
    public jsonresult login(user u, HttpSession session){
       try {
           user u1=us.login(u);
           if(u1!=null){
               session.setMaxInactiveInterval(0);
               session.setAttribute("loginkey",u1);
               result=new jsonresult("200","登录成功",u1);
               logger.info("[{}]登录成功",u.getUserName());
           }else {

               result=new jsonresult("400","用户名或密码错误",null);
           }

       }catch (Exception e){
           e.printStackTrace();
           result=new jsonresult("500","异常",e.getMessage());
       }
        return result;
    }

    @RequestMapping("/zhuxiao")
    public jsonresult zhuxiao(HttpSession session){
       try {
           session.invalidate();
           result=new jsonresult("200","注销成功",null);
       }catch (Exception e){
           e.printStackTrace();
           result=new jsonresult("500","异常",e.getMessage());
       }
        return result;
    }

    @RequestMapping("/menu")
    public jsonresult querymenu(user u){
        try {
            List list=us.queryMenu(u);
            result =new jsonresult("200","查询成功",list);
        }catch (Exception e){
            e.printStackTrace();
            result=new jsonresult("500","异常",e.getMessage());
        }
        return result;
    }

    @RequestMapping("/pri")
    public jsonresult querypri(String userId,String priFatherId){
        try {
            List list=us.queryPri(userId,priFatherId);
            result =new jsonresult("200","查询成功",list);
        }catch (Exception e){
            e.printStackTrace();
            result=new jsonresult("500","异常",e.getMessage());
        }
        return result;
    }

    @RequestMapping("/list")
    public jsonresult queryAllUser(Integer pageNum,Integer pageSize ){
        try {
           // PageHelper.startPage(pageNum,pageSize);
            List list=us.queryAllUser();
          //  PageInfo pageInfo = new PageInfo(list);

            result =new jsonresult("200","查询成功",list);
        }catch (Exception e){
            e.printStackTrace();
            result=new jsonresult("500","异常",e.getMessage());
        }
        return result;
    }

    @RequestMapping("/delete")
    public jsonresult delete(user u){
        try {
            int i=us.delete(u);
            if (i>0){
                result =new jsonresult("200","删除成功",i);
            }else {
                result =new jsonresult("400","删除失败",i);
            }

        }catch (Exception e){
            e.printStackTrace();
            result=new jsonresult("500","异常",e.getMessage());
        }
        return result;
    }
    @RequestMapping("/update")
    public jsonresult updateuser(user u,String roleId,String AorD){
        if("add".equals(AorD)){
            try {
                int i=us.addrole(u.getUserId(),roleId);
                if (i>0){
                    result =new jsonresult("200","添加角色成功",i);
                }else {
                    result =new jsonresult("400","添加角色失败",i);
                }

            }catch (Exception e){
                e.printStackTrace();
                result=new jsonresult("500","异常",e.getMessage());
            }
            return result;
        }
        if("delete".equals(AorD)){
            try {
                int i=us.deleterole(u.getUserId(),roleId);
                if (i>0){
                    result =new jsonresult("200","删除角色成功",i);
                }else {
                    result =new jsonresult("400","删除角色失败",i);
                }

            }catch (Exception e){
                e.printStackTrace();
                result=new jsonresult("500","异常",e.getMessage());
            }
            return result;
        }
        try {
            int i=us.update(u);
            if (i>0){
                result =new jsonresult("200","修改成功",i);
            }else {
                result =new jsonresult("400","修改失败",i);
            }

        }catch (Exception e){
            e.printStackTrace();
            result=new jsonresult("500","异常",e.getMessage());
        }
        return result;
    }



    @RequestMapping("/adduser")
    public jsonresult deleterole(user u){
        try {
            int i=us.adduser(u);
            if (i>0){
                result =new jsonresult("200","增加用户成功",u);
            }else {
                result =new jsonresult("400","增加用户失败",i);
            }

        }catch (Exception e){
            e.printStackTrace();
            result=new jsonresult("500","异常",e.getMessage());
        }
        return result;
    }

    @RequestMapping("/manydelete")
    public jsonresult manydelete(String list){
        String[] list1=list.split(",");
        System.out.println(list1);
        try {
            int i=us.manydelete(list1);
            if (i>0){
                result =new jsonresult("200","删除用户成功",i);
            }else {
                result =new jsonresult("400","删除用户失败",i);
            }

        }catch (Exception e){
            e.printStackTrace();
            result=new jsonresult("500","异常",e.getMessage());
        }
        return result;
    }

}
