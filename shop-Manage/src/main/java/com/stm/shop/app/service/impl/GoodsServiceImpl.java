package com.stm.shop.app.service.impl;

import com.stm.shop.app.dao.GoodsDao;
import com.stm.shop.app.service.GoodsService;
import com.stm.shop.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:liuxinxing Date:2019/1/1 0001
 * Time:13:26
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> searchKey(String goodsName) {
        return goodsDao.searchKey(goodsName);
    }

    /**
     * @author chen
     * @param name 商品分类名称
     * @return
     */
    @Override
    public List<Goods> showGoodsByGclassifyNmae(String name) {
        return goodsDao.slectByClassifyNmae(name);
    }

    /**
     * @author chen
     * @param id 商品id
     * @return 商品信息
     */
    @Override
    public Goods showGood(Integer id) {
        return goodsDao.selectById(id);
    }

    /**
     * @author chen
     * @param id 商品类型id
     * @return 商品列表
     */
    @Override
    public List<Goods> showGoodsByClassifyId(Integer id) {
        return goodsDao.selectByClassifyId(id);
    }

    /**
     * @author chen
     * @param key 关键字
     * @return 商品列表
     */
    @Override
    public List<Goods> showGoodsByKey(String key) {
        return goodsDao.selectByKey(key);
    }
}
