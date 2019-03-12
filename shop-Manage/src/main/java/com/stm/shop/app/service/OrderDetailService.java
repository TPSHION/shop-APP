package com.stm.shop.app.service;

import com.stm.shop.entity.Orderdetial;
import com.stm.shop.entity.OrderdetialAssociation;

import java.util.List;

/**
 * @author:liuxinxing Date:2018/12/31 0031
 * Time:21:47
 */
public interface OrderDetailService {
    /**
     * 根据订单id查询订单详细信息
     * @param id
     * @return
     */
    List<OrderdetialAssociation> SelectById(Integer id);

    //添加订单详细
    int addOrder(List<Orderdetial> orderdetials);
}
