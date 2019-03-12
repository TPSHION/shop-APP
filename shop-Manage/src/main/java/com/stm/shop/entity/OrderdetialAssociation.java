package com.stm.shop.entity;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 14:44 2018/12/28.
 * @ModifyBy：
 */
public class OrderdetialAssociation extends Orderdetial {

    private Gorder gorder;

    private Goods goods;

    public Gorder getGorder() {
        return gorder;
    }

    public void setGorder(Gorder gorder) {
        this.gorder = gorder;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
