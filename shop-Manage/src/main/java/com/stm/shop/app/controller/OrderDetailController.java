package com.stm.shop.app.controller;

import com.stm.shop.app.service.CartService;
import com.stm.shop.app.service.OrderDetailService;
import com.stm.shop.entity.Orderdetial;
import com.stm.shop.entity.OrderdetialAssociation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:liuxinxing Date:2018/12/31 0031
 * Time:21:42
 */
@RestController
@RequestMapping(value = "/app/orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private CartService cartService;

    @GetMapping(value = "/getOrderDetailById/{id}")
    public Object getOrderDetailById(@PathVariable("id") Integer id){
        List<OrderdetialAssociation> orderdetialAssociationList=orderDetailService.SelectById(id);
        if (orderdetialAssociationList!=null){
            return orderdetialAssociationList;
        }else
            return "{\"status\":0,\"message\":\"error\"}";
    }


    @RequestMapping("/addOrder")
    public Map<String,Object> addOrder(@RequestBody List<Orderdetial> orderdetials){
        Map<String,Object> map = new HashMap<>();
        List<Integer> idList=new ArrayList();
        for (Orderdetial list:orderdetials){
            idList.add(list.getGoodsId());
        }
        System.out.println(idList.get(0));
        int state = orderDetailService.addOrder(orderdetials);
        int flag= cartService.deleteGoodsBash(idList);
        System.out.println(flag);
        map.put("state",state);
        return map;
    }

}
