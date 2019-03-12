package com.stm.shop.admin.service.impl;

import com.stm.shop.admin.dao.UserMapper;
import com.stm.shop.admin.service.UserService;
import com.stm.shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 10:32 2018/12/28.
 * @ModifyBy：
 */
@Service("admUserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
