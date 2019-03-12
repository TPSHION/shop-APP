package com.stm.shop.app.service.impl;

import com.stm.shop.app.dao.CartDao;
import com.stm.shop.entity.Cart;
import com.stm.shop.app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartMapper;

    /**
     * @author chen
     * @param id 用户id
     * @return
     */
    @Override
    public List<Cart> showByUserId(Integer id) {
        return cartMapper.selectByUserId(id);
    }

    @Override
    public int addToCart(Cart cart) {
       return cartMapper.insertCart(cart);
    }

    @Override
    public int deleteGoodsBash(List<Integer> list) {
        return cartMapper.deleteGoodsBash(list);
    }
}
