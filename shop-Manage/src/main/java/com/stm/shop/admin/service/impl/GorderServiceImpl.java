package com.stm.shop.admin.service.impl;

import com.stm.shop.admin.dao.GorderMapper;
import com.stm.shop.admin.service.GorderService;
import com.stm.shop.entity.GorderAssociation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 10:02 2018/12/28.
 * @ModifyBy：
 */
@Service("admGorderService")
public class GorderServiceImpl implements GorderService {
    @Autowired
    private GorderMapper gorderMapper;

    @Override
    public List<GorderAssociation> findOrderList(Integer state) {
        return gorderMapper.findOrderList(state);
    }

    @Override
    public List<GorderAssociation> getSoftDeleteList() {
        return gorderMapper.getSoftDeleteList();
    }

    @Override
    public Integer orderChangeState(Integer gorderId, Integer state) {
        return gorderMapper.orderChangeState(gorderId,state);
    }

    @Override
    public Map<String, Object> getToDayOrderInfo() {
        return gorderMapper.getToDayOrderInfo();
    }

    @Override
    public Map<String, Object> getHistoryOrderInfo() {
        return gorderMapper.getHistoryOrderInfo();
    }

    @Override
    public List<Map<String, Object>> getOrderCountByDay(Integer state) {
        return gorderMapper.getOrderCountByDay(state);
    }
}
