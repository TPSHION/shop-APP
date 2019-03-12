package com.stm.shop.app.service;

import com.stm.shop.entity.Cart;

import java.util.List;

/**
 * @author chen
 * 购车车模块 service层
 */
public interface CartService {

    /**
     * @author chen
     * @param id 用户id
     * @return
     */
    List<Cart> showByUserId(Integer id);

    /**
     * @author chen
     * @param cart 商品添加购物车
     * @return
     */
    int addToCart(Cart cart);

    int deleteGoodsBash(List<Integer> list);
}
