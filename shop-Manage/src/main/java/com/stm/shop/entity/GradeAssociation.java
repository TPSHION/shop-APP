package com.stm.shop.entity;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 14:47 2018/12/28.
 * @ModifyBy：
 */
public class GradeAssociation extends Grade {

    private User user;

    private Goods goods;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

}
