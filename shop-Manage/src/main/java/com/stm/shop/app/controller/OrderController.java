package com.stm.shop.app.controller;

import com.stm.shop.app.service.GorderService;
import com.stm.shop.entity.Gorder;
import com.stm.shop.entity.GorderAssociation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:liuxinxing Date:2018/12/29 0029
 * Time:12:14
 */
@RestController
@RequestMapping(value = "/app/gorder")
public class OrderController {
    @Autowired
    private GorderService gorderService;

    /**
     * 获取用户所有的订单
     * @param id
     * @return
     */
    @GetMapping(value="/orderList/{id}")
    public Object selectAllOrders(@PathVariable("id") Integer id){
        List<Gorder> gorderList=gorderService.selectAll(id);
        if (gorderList!=null)
        {
            return gorderList;
        }else
            return "{\"status\":0,\"message\":\"error\"}";

    }

    /**
     * 获取订单详细信息
     * @param id
     * @return
     */
    @GetMapping(value="/selectById/{id}")
    public Object selectById(@PathVariable("id") Integer id){
        List<GorderAssociation> gorderAssociationList=gorderService.selectById(id);
        if (gorderAssociationList!=null){
            return gorderAssociationList;
        }else
            return "{\"status\":0,\"message\":\"error\"}";

    }

    @RequestMapping("/orderChangeState")
    @ResponseBody
    public Object orderChangeState(@RequestParam("gorderId")Integer id,
                                   @RequestParam("gorderState")Integer gorderState){
        int res = gorderService.orderChangeState(id,gorderState);
        System.out.println(res);
        if(res==1){
            return "{\"status\":1,\"message\":\"success\"}";
        }else
            return "{\"status\":0,\"message\":\"error\"}";
    }

    @RequestMapping("/addGorder")
    public Map<String,Object> addGorder(@RequestParam(name = "userId",required = true) Integer userId,
                                        @RequestParam(name = "total",required = true) Float total,
                                        @RequestParam(name = "addressId",required = true) Integer addressId){
        Map<String,Object> map = new HashMap<>();
        Gorder gorder = new Gorder();
        gorder.setUserId(userId);
        gorder.setTotal(total);
        gorder.setAddressId(addressId);
        int state = gorderService.addGorder(gorder);
        map.put("gorderId",gorder.getGorderId());
        map.put("state",state);
        return map;
    }

}
