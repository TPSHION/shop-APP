package com.stm.shop.admin.service.impl;

import com.stm.shop.admin.dao.OrderDetialMapper;
import com.stm.shop.admin.service.OrderDetialService;
import com.stm.shop.entity.OrderdetialAssociation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 14:40 2018/12/28.
 * @ModifyBy：
 */
@Service("admOrderDetialService")
public class OrderDetialServiceImpl implements OrderDetialService{

    @Autowired
    private OrderDetialMapper orderDetialMapper;

    @Override
    public List<OrderdetialAssociation> findByGorderId(Integer id) {
        return orderDetialMapper.findByGorderId(id);
    }
}
