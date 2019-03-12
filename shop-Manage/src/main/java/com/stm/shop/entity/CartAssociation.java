package com.stm.shop.entity;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 14:53 2018/12/28.
 * @ModifyBy：
 */
public class CartAssociation extends Cart {

    private Goodsitem goodsitem;

    private User user;

    private Goods goods;

    public Goodsitem getGoodsitem() {
        return goodsitem;
    }

    public void setGoodsitem(Goodsitem goodsitem) {
        this.goodsitem = goodsitem;
    }

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
