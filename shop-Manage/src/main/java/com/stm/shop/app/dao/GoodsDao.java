package com.stm.shop.app.dao;

import com.stm.shop.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author:liuxinxing Date:2019/1/1 0001
 * Time:13:22
 */
public interface GoodsDao {
    /**
     * 模糊查询
     * @param GoodsName
     * @return
     */
   List<Goods> searchKey(@Param("goodsName") String GoodsName);

    /**
     * @author chen
     * @param name 商品分类名称
     * @return 所属类型商品信息
     */
    List<Goods> slectByClassifyNmae(@Param("name")String name);

    /**
     * @author chen
     * @param id 商品id
     * @return 商品信息
     */
    Goods selectById(@Param("id")Integer id);

    /**
     * @author chen
     * @param id 商品类型id
     * @return 商品列表
     */
    List<Goods> selectByClassifyId(@Param("id")Integer id);

    /**
     * @author chen
     * @param key 搜索关键字
     * @return
     */
    List<Goods> selectByKey(@Param("key")String key);
}
