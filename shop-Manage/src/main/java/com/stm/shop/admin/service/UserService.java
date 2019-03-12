package com.stm.shop.admin.service;

import com.stm.shop.entity.User;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 10:24 2018/12/28.
 * @ModifyBy：
 */
public interface UserService {

    /**
     * @author 飞鸿
     * @Description 根据id查询用户信息
     * @Date 10:27 2018/12/28
     * @MethodName findById
     * @param id
     * @return com.stm.shop.entity.User
     **/
    User findById(Integer id);
}
