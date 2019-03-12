package com.stm.shop.app.dao;

import com.stm.shop.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author:liuxinxing Date:2018/12/27 0027
 * Time:9:51
 */
public interface UserDao {

    int deleteByPrimaryKey(@Param("userId") Integer userId);

    /**
     * 用户注册
     * @param record
     * @return
     */
    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(@Param("userId")Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 用户登陆
     * @param userName
     * @param password
     * @return
     */

    User login(@Param("username") String userName, @Param("password") String password);

}
