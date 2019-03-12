package com.stm.shop.app.dao;

import com.stm.shop.entity.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chen
 * 购物车模块
 */
public interface CartDao {

    /**
     * @author chen
     * @param id 用户id
     * @return 用户id对应的购物车信息列表
     */
    List<Cart> selectByUserId(@Param("id")Integer id);

    /**
     * @author chen
     * @param cart
     * @return
     */
    int insertCart(Cart cart);

    int deleteGoodsBash(List<Integer> list);

}
