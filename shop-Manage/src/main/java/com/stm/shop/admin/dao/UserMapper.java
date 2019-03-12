package com.stm.shop.admin.dao;

import com.stm.shop.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 10:23 2018/12/28.
 * @ModifyBy：
 */
public interface UserMapper {

    /**
    * @author 飞鸿
    * @Description 根据id查询用户信息
    * @Date 10:28 2018/12/28
    * @MethodName findById
    * @param id
    * @return com.stm.shop.entity.User
    **/
    User findById(@Param("userId") Integer id);
}
