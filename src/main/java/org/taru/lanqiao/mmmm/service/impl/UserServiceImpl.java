package org.taru.lanqiao.mmmm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.taru.lanqiao.mmmm.dao.UserDao;
import org.taru.lanqiao.mmmm.model.user;
import org.taru.lanqiao.mmmm.service.UserService;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao ud;

    public user login(user u){
        return ud.login(u);
    }
    public List queryMenu(user u){
        return ud.queryMenu(u);
    }
    public List queryPri(String uid,String priFatherId){return ud.queryPri(uid,priFatherId);}
    public List queryAllUser(){return ud.queryAllUser();}
    public List queryAllPri(user u){return ud.queryAllPri(u);}
    public int delete(user u){return ud.delete(u);}
    public int update(user u){return ud.updateuser(u);}
    public int addrole(String userId,String roleId){return ud.AddRole(userId,roleId);}
    public int deleterole(String userId,String roleId){return ud.deleterole(userId,roleId);}
    public int adduser(user u){return ud.adduser(u);}
    public int manydelete(String[] list){return ud.manydelete(list);}


}
