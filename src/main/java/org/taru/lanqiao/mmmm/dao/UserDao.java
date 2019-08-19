package org.taru.lanqiao.mmmm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.taru.lanqiao.mmmm.model.user;


import java.util.List;

@Mapper
public interface UserDao {
    public user login(user u);

    /**
     * 根据用户ID查询菜单
     * @param u
     * @return
     */
    public List queryMenu(user u);

    /**
     * 查询全部权限
     * @param u
     * @return
     */
    public List queryAllPri(user u);

    /**
     * 根据ID和菜单ID查询具体权限
     * @param priFatherId
     * @return
     */
    public List queryPri(@Param("userId") String userId,@Param("priFatherId") String priFatherId);


    /**
     * 查询全部用户
     * @return
     */
    public List queryAllUser();

    /**
     * 根据ID删除用户
     * @param u
     * @return
     */
    public int delete(user u);

    /**
     * 根据用户id修改用户信息
     * @param u
     * @return
     */
    public int updateuser(user u);

    /**
     * 根据用户id添加用户角色
     * @param
     * @return
     */
    public int AddRole(@Param("userId") String userId,@Param("roleId")String roleId);

    /**
     * 根据用户id删除角色
     * @param userId
     * @param roleId
     * @return
     */
    public int deleterole(@Param("userId")String userId,@Param("roleId")String roleId);

    /**
     * 添加用户
     * @param u
     * @return
     */
    public int adduser(user u);

    public int manydelete(String[] list);
}
