package com.stm.shop.entity;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 14:52 2018/12/28.
 * @ModifyBy：
 */
public class AddressAssociation extends Address {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
