package com.stm.shop.entity;

import java.util.List;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 10:56 2018/12/29.
 * @ModifyBy：
 */
public class GoodsAssociaGoodsitem extends GoodsAssociation {

    private List<Goodsitem> goodsitems;

    public List<Goodsitem> getGoodsitems() {
        return goodsitems;
    }

    public void setGoodsitems(List<Goodsitem> goodsitems) {
        this.goodsitems = goodsitems;
    }
}
