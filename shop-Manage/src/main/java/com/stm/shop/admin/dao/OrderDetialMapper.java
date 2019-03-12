package com.stm.shop.admin.dao;

import com.stm.shop.entity.OrderdetialAssociation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 14:40 2018/12/28.
 * @ModifyBy：
 */
public interface OrderDetialMapper {

    /**
    * @author 飞鸿
    * @Description 根据订单id查询包含的商品信息
    * @Date 15:12 2018/12/28
    * @MethodName findByGorderId
    * @param id
    * @return java.util.List<com.stm.shop.entity.OrderdetialAssociation>
    **/
    List<OrderdetialAssociation> findByGorderId(@Param("gorderId")Integer id);
}
