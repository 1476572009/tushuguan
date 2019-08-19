package org.taru.lanqiao.mmmm.service;

import org.taru.lanqiao.mmmm.model.user;

import java.util.List;


public interface UserService {

    public user login(user u);

    public List queryMenu(user u);

    public List queryPri(String uid,String priFatherId);

    public List queryAllUser();

    public List queryAllPri(user u);

    public int delete(user u);

    public int update(user u);

    public int addrole(String userId,String roleId);

    public int deleterole(String userId,String roleId);

    public int adduser(user u);

    public int manydelete(String[] list);

}
