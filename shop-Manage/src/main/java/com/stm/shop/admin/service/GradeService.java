package com.stm.shop.admin.service;

import com.stm.shop.entity.GradeAssociation;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 10:56 2019/1/7.
 * @ModifyBy：
 */
public interface GradeService {

    /**
     * @author 飞鸿
     * @Description 根据商品id查看评论
     * @Date 11:05 2019/1/7
     * @MethodName findByGoodsId
     * @param goodsId
     * @return com.stm.shop.entity.GradeAssociation
     **/
    GradeAssociation findByGoodsId(Integer goodsId);
}
