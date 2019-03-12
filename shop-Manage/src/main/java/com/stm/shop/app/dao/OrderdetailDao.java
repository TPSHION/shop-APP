package com.stm.shop.app.dao;

import com.stm.shop.entity.Orderdetial;
import com.stm.shop.entity.OrderdetialAssociation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author:liuxinxing Date:2018/12/31 0031
 * Time:21:43
 */
public interface OrderdetailDao {
    List<OrderdetialAssociation> selectByPrimaryKey(@Param("gorderId")Integer id);

    List<OrderdetialAssociation> findByGorderId(@Param("gorderId") Integer id);

    //添加订单详细
    int insertOrder(List<Orderdetial> orderdetials);
}
