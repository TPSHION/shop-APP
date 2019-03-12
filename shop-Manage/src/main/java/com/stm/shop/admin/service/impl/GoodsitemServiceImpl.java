package com.stm.shop.admin.service.impl;

import com.stm.shop.admin.dao.GoodsitemMapper;
import com.stm.shop.admin.service.GoodsitemService;
import com.stm.shop.entity.Goodsitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 11:03 2018/12/29.
 * @ModifyBy：
 */
@Service("admGoodsitemService")
public class GoodsitemServiceImpl implements GoodsitemService {

    @Autowired
    private GoodsitemMapper goodsitemMapper;

    @Override
    public List<Goodsitem> findByGoodsId(Integer goodsId) {
        return goodsitemMapper.findByGoodsId(goodsId);
    }

    @Override
    public Integer insert(Goodsitem goodsitem) {
        return goodsitemMapper.insert(goodsitem);
    }

    @Override
    public Integer deleteById(Integer itemId) {
        return goodsitemMapper.deleteById(itemId);
    }
}
