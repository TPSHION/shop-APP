package com.stm.shop.app.service;

import com.stm.shop.entity.Gorder;
import com.stm.shop.entity.GorderAssociation;

import java.util.List;

/**
 * @author:liuxinxing Date:2018/12/29 0029
 * Time:18:34
 */
public interface GorderService {

    /**
     * 获取用户所有的订单
     * @param id
     * @return
     */
    List<Gorder> selectAll(Integer id);

    List<GorderAssociation> selectById(Integer id);

    Integer orderChangeState(Integer gorderId, Integer state);
    //添加订单
    int addGorder(Gorder gorder);
}
