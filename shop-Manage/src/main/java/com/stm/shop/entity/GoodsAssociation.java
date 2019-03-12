package com.stm.shop.entity;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 14:50 2018/12/28.
 * @ModifyBy：
 */
public class GoodsAssociation extends Goods {

    private Gclassify gclassify;

    public Gclassify getGclassify() {
        return gclassify;
    }

    public void setGclassify(Gclassify gclassify) {
        this.gclassify = gclassify;
    }
}
