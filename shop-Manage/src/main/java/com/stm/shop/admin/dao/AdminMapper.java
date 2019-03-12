package com.stm.shop.admin.dao;

import com.stm.shop.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 14:45 2018/12/26.
 * @ModifyBy：
 */
public interface AdminMapper {

    /**
    * @author 飞鸿
    * @Description 通过id查询管理员
    * @Date 14:46 2018/12/26
    * @MethodName findById
    * @param id
    * @return com.stm.shop.entity.Admin
    **/
    Admin findById(Integer id);

    /**
     * @author 飞鸿
     * @Description 根据用户名和密码查找admin
     * @Date 8:52 2018/12/27
     * @MethodName findByNameAndPassword
     * @param name
     * @param password
     * @return com.stm.shop.app.entity.Admin
     **/
    Admin findByNameAndPassword(@Param("name") String name, @Param("password") String password);

    /**
     * @author 飞鸿
     * @Description 获取管理员列表
     * @Date 16:54 2018/12/27
     * @MethodName getList
     * @return java.util.List<com.stm.shop.entity.Admin>
     **/
    List<Admin> getList();

    /**
     * @author 飞鸿
     * @Description 根据管理员名称查找
     * @Date 18:29 2018/12/27
     * @MethodName findByName
     * @param name
     * @return java.util.List<com.stm.shop.entity.Admin>
     **/
    List<Admin> findByName(@Param("name") String name);

    /**
     * @author 飞鸿
     * @Description 添加管理员。返回受影响数据条数
     * @Date 19:39 2018/12/27
     * @MethodName insertAdmin
     * @param admin
     * @return java.lang.Integer
     **/
    Integer insertAdmin(Admin admin);
    
    /**
    * @author 飞鸿
    * @Description 根据id软删除管理员
    * @Date 21:24 2018/12/27
    * @MethodName softDeleteById
    * @param id
    * @param deleteTime
    * @return java.lang.Integer
    **/
    Integer softDeleteById(@Param("adminId") Integer id,@Param("deleteTime") Integer deleteTime);
    
    /**
    * @author 飞鸿
    * @Description 修改管理员信息
    * @Date 22:40 2018/12/27
    * @MethodName updateById
    * @param admin 
    * @return java.lang.Integer
    **/
    Integer updateById(Admin admin);

    /**
    * @author 飞鸿
    * @Description 获取删除状态的管理员列表
    * @Date 9:11 2018/12/28
    * @MethodName getDeleteList
    * @param
    * @return java.util.List<com.stm.shop.entity.Admin>
    **/
    List<Admin> getDeleteList();

    /**
    * @author 飞鸿
    * @Description 根据ID硬删除管理员
    * @Date 9:30 2018/12/28
    * @MethodName deleteById
    * @param id
    * @return java.lang.Integer
    **/
    Integer deleteById(@Param("adminId") Integer id);

    /**
    * @author 飞鸿
    * @Description 根据id撤销删除状态
    * @Date 9:39 2018/12/28
    * @MethodName recoverById
    * @param id
    * @return java.lang.Integer
    **/
    Integer recoverById(@Param("adminId") Integer id);
}
