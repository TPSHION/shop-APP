package com.stm.shop.admin.dao;

import com.stm.shop.entity.GradeAssociation;
import org.apache.ibatis.annotations.Param;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 10:55 2019/1/7.
 * @ModifyBy：
 */
public interface GradeMapper {

    /**
    * @author 飞鸿
    * @Description 根据商品id查看评论
    * @Date 11:05 2019/1/7
    * @MethodName findByGoodsId
    * @param goodsId
    * @return com.stm.shop.entity.GradeAssociation
    **/
    GradeAssociation findByGoodsId(@Param("goodsId") Integer goodsId);
}
