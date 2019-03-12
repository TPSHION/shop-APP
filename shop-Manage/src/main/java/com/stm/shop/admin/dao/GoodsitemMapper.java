package com.stm.shop.admin.dao;

import com.stm.shop.entity.Goodsitem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 11:00 2018/12/29.
 * @ModifyBy：
 */
public interface GoodsitemMapper {

    /**
    * @author 飞鸿
    * @Description 根据商品id查询商品颜色数量等信息
    * @Date 11:04 2018/12/29
    * @MethodName findByGoodsId
    * @param goodsId
    * @return java.util.List<com.stm.shop.entity.Goodsitem>
    **/
    List<Goodsitem> findByGoodsId(@Param("goodsId")Integer goodsId);

    /**
    * @author 飞鸿
    * @Description 插入商品尺寸等信息
    * @Date 20:01 2018/12/29
    * @MethodName insert
    * @param goodsitem
    * @return java.lang.Integer
    **/
    Integer insert(Goodsitem goodsitem);

    /**
     * @author 飞鸿
     * @Description 根据id删除
     * @Date 9:10 2019/1/7
     * @MethodName deleteById
     * @param itemId
     * @return java.lang.Integer
     **/
    Integer deleteById(@Param("itemId") Integer itemId);
}
