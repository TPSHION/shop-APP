package com.stm.shop.app.service.impl;
import com.stm.shop.entity.User;
import com.stm.shop.app.dao.UserDao;
import com.stm.shop.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:liuxinxing Date:2018/12/27 0027
 * Time:9:19
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User userLogin(String username, String password) {
      User user=userDao.login(username,password);
        return user;
    }

    @Override
    public int userInsert(User record) {
        int flag=userDao.insert(record);
        return flag;
    }

    @Override
    public User selectUserInfoById(Integer id) {
        User userInfo=userDao.selectByPrimaryKey(id);
        return userInfo;
    }
}
