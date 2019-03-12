package com.stm.shop.admin.service;

import com.stm.shop.entity.Goods;
import com.stm.shop.entity.GoodsAssociation;

import java.util.List;
import java.util.Set;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 15:50 2018/12/28.
 * @ModifyBy：
 */
public interface GoodsService {

    /**
     * @author 飞鸿
     * @Description 通过id查询商品信息
     * @Date 15:50 2018/12/28
     * @MethodName findById
     * @param id
     * @return com.stm.shop.entity.Goods
     **/
    Goods findById(Integer id);

    /**
     * @author 飞鸿
     * @Description 根据商品类别id查询商品列表
     * @Date 0:39 2018/12/29
     * @MethodName findByGclassId
     * @param id
     * @return java.util.List<com.stm.shop.entity.GoodsAssociation>
     **/
    List<GoodsAssociation> findByGclassId(Integer id);

    /**
    * @author 飞鸿
    * @Description 根据商品id集合查找商品信息
    * @Date 0:43 2018/12/29
    * @MethodName findByGclassIds
    * @param idSet
    * @return java.util.List<com.stm.shop.entity.GoodsAssociation>
    **/
    List<GoodsAssociation> findByGclassIds(Set<Integer> idSet);
    
    /**
    * @author 飞鸿
    * @Description
    * @Date 10:47 2018/12/29
    * @MethodName getList
    * @param  
    * @return java.util.List<com.stm.shop.entity.GoodsAssociation>
    **/
    List<GoodsAssociation> getList();

    /**
     * @author 飞鸿
     * @Description 根据商品id软删除
     * @Date 12:20 2018/12/29
     * @MethodName softDelByGoodsId
     * @param goodsId
     * @return java.lang.Integer
     **/
    Integer softDelByGoodsId(Integer goodsId);

    /**
     * @author 飞鸿
     * @Description 获取被软删除的商品信息
     * @Date 12:35 2018/12/29
     * @MethodName getRecycleList
     * @param
     * @return java.util.List<com.stm.shop.entity.GoodsAssociation>
     **/
    List<GoodsAssociation> getRecycleList();

    /**
    * @author 飞鸿
    * @Description 添加商品信息
    * @Date 13:18 2018/12/29
    * @MethodName insert
    * @param goods
    * @return java.lang.Integer
    **/
    Integer insert(Goods goods);

    /**
     * @author 飞鸿
     * @Description 根据id恢复回收站的商品
     * @Date 15:22 2018/12/29
     * @MethodName recoverByGoodsId
     * @param goodsId
     * @return java.lang.Integer
     **/
    Integer recoverByGoodsId(Integer goodsId);

    /**
     * @author 飞鸿
     * @Description 修改
     * @Date 20:37 2018/12/29
     * @MethodName update
     * @param goods
     * @return java.lang.Integer
     **/
    Integer update(Goods goods);
}
