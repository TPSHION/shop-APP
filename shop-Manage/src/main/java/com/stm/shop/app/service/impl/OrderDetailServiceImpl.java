package com.stm.shop.app.service.impl;

import com.stm.shop.app.dao.OrderdetailDao;
import com.stm.shop.app.service.OrderDetailService;
import com.stm.shop.entity.Orderdetial;
import com.stm.shop.entity.OrderdetialAssociation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:liuxinxing Date:2018/12/31 0031
 * Time:22:02
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderdetailDao orderDetailDao;

    @Override
    public List<OrderdetialAssociation> SelectById(Integer id) {
        List<OrderdetialAssociation> orderdetialAssociationList=orderDetailDao.selectByPrimaryKey(id);

        return orderdetialAssociationList;
    }

    @Override
    public int addOrder(List<Orderdetial> orderdetials) {
        return orderDetailDao.insertOrder(orderdetials);
    }


}
