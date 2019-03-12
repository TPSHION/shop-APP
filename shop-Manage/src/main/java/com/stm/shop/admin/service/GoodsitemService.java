package com.stm.shop.admin.service;

import com.stm.shop.entity.Goodsitem;

import java.util.List;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 11:03 2018/12/29.
 * @ModifyBy：
 */
public interface GoodsitemService {
    /**
     * @author 飞鸿
     * @Description 根据商品id查询商品颜色数量等信息
     * @Date 11:03 2018/12/29
     * @MethodName findByGoodsId
     * @param goodsId
     * @return java.util.List<com.stm.shop.entity.Goodsitem>
     **/
    List<Goodsitem> findByGoodsId(Integer goodsId);

    /**
     * @author 飞鸿
     * @Description 插入商品尺寸等信息
     * @Date 20:00 2018/12/29
     * @MethodName insert
     * @param goodsitem
     * @return java.lang.Integer
     **/
    Integer insert(Goodsitem goodsitem);

    /**
    * @author 飞鸿
    * @Description 根据id删除
    * @Date 9:11 2019/1/7
    * @MethodName deleteById
    * @param itemId
    * @return java.lang.Integer
    **/
    Integer deleteById(Integer itemId);
}
