package com.stm.shop.app.controller;

import com.stm.shop.entity.Cart;
import com.stm.shop.app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen
 * 购物车模块 controller层
 */
@RestController
@RequestMapping("/app/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/showByUserId")
    public Map<String,Object> showByUserId(@RequestParam(name = "userId",required = true) Integer id){
        Map<String,Object> map = new HashMap<>();
        List<Cart> cartList = cartService.showByUserId(id);
        map.put("carts",cartList);
        return map;
    }

    @RequestMapping("/addToCart")
    public Map<String,Object> addToCart(@RequestParam(name = "userId",required = true) Integer userId,
                                        @RequestParam(name = "goodsId",required = true) Integer goodsId,
                                        @RequestParam(name = "itemId",required = true) Integer gooditemId
    ){
        Map<String,Object> map = new HashMap<>();
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setGoodsId(goodsId);
        cart.setGooditemId(gooditemId);
        int state = cartService.addToCart(cart);
        map.put("state",state);
        return map;
    }
}
