package com.stm.shop.admin.service.impl;

import com.stm.shop.admin.dao.GoodsMapper;
import com.stm.shop.admin.service.GoodsService;
import com.stm.shop.entity.Goods;
import com.stm.shop.entity.GoodsAssociation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 15:51 2018/12/28.
 * @ModifyBy：
 */
@Service("admGoodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods findById(Integer id) {
        return goodsMapper.findById(id);
    }

    @Override
    public List<GoodsAssociation> findByGclassId(Integer id) {
        return goodsMapper.findByGclassId(id);
    }

    @Override
    public List<GoodsAssociation> findByGclassIds(Set<Integer> idSet) {
        return goodsMapper.findByGclassIds(idSet);
    }

    @Override
    public List<GoodsAssociation> getList() {
        return goodsMapper.getList();
    }

    @Override
    public Integer softDelByGoodsId(Integer goodsId) {
        return goodsMapper.softDelByGoodsId(goodsId);
    }

    @Override
    public List<GoodsAssociation> getRecycleList() {
        return goodsMapper.getRecycleList();
    }

    @Override
    public Integer insert(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public Integer recoverByGoodsId(Integer goodsId) {
        return goodsMapper.recoverByGoodsId(goodsId);
    }

    @Override
    public Integer update(Goods goods) {
        return goodsMapper.update(goods);
    }
}
