package com.stm.shop.app.service;

import com.stm.shop.entity.Goods;

import java.util.List;

/**
 * @author:liuxinxing Date:2019/1/1 0001
 * Time:13:25
 */
public interface GoodsService {
    List<Goods> searchKey(String goodsName);

    /**
     * @author chen
     * @param name 商品分类名称
     * @return 显示所属类型商品信息
     */
    List<Goods> showGoodsByGclassifyNmae(String name);

    /**
     * @author chen
     * @param id 商品id
     * @return 商品信息
     */
    Goods showGood(Integer id);

    /**
     * @author chen
     * @param id 商品类型id
     * @return 商品列表
     */
    List<Goods> showGoodsByClassifyId(Integer id);

    List<Goods> showGoodsByKey(String key);
}
