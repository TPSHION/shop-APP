package com.stm.shop.app.service;

import com.stm.shop.entity.User;

import java.util.List;

/**
 * @author:liuxinxing Date:2018/12/27 0027
 * Time:9:14
 */
public interface UserService {
    User userLogin(String username, String password);

    int userInsert(User record);

   User selectUserInfoById(Integer id);
}
