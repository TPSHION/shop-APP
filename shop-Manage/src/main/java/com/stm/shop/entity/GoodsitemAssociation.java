package com.stm.shop.entity;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 14:49 2018/12/28.
 * @ModifyBy：
 */
public class GoodsitemAssociation extends Goodsitem {

    private Goods goods;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
