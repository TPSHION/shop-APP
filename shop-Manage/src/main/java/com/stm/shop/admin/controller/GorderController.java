package com.stm.shop.admin.controller;

import com.stm.shop.admin.service.GorderService;
import com.stm.shop.admin.service.OrderDetialService;
import com.stm.shop.entity.OrderdetialAssociation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 10:00 2018/12/28.
 * @ModifyBy：
 */
@RequestMapping("/admin/order")
@Controller("admGorderController")
public class GorderController {
    @Autowired
    private GorderService gorderService;

    @Autowired
    private OrderDetialService orderDetialService;

    @Autowired
    private AdminController adminController;


    /**
    * @author 飞鸿
    * @Description 根据订单状态获取订单信息
    * @Date 13:42 2018/12/28
    * @MethodName orderList
    * @param orderState
    * @param model
    * @param session
    * @return java.lang.String
    **/
    @RequestMapping("/orderList")
    public String orderList(@RequestParam("orderState") Integer orderState, Model model, HttpSession session){
        if (session.getAttribute("admin")==null)
            return adminController.loginView();
        Map<Integer,String> stateMap = new HashMap<Integer,String>();
        stateMap.put(0,"待付款");
        stateMap.put(1,"待发货");
        stateMap.put(2,"待收货");
        stateMap.put(3,"待评价");
        stateMap.put(4,"已完成");
        model.addAttribute("title",stateMap.get(orderState));
        model.addAttribute("list",gorderService.findOrderList(orderState));
        return "admin/order-list";
    }

    /**
    * @author 飞鸿
    * @Description 获取已删除订单数据
    * @Date 13:44 2018/12/28
    * @MethodName getSoftDeleteList
    * @param model
    * @param session
    * @return java.lang.String
    **/
    @RequestMapping("/orderRecycleList")
    public String getSoftDeleteList(Model model,HttpSession session){
        if (session.getAttribute("admin")==null)
            return adminController.loginView();
        model.addAttribute("list",gorderService.getSoftDeleteList());
        return "admin/order-recycle";
    }

    /**
    * @author 飞鸿
    * @Description 修改订单状态
    * @Date 18:47 2019/1/7
    * @MethodName orderChangeState
    * @param id
    * @param gorderState
    * @return java.util.Map<java.lang.String,java.lang.String>
    **/
    @RequestMapping("/orderChangeState")
    @ResponseBody
    public Map<String,String> orderChangeState(@RequestParam("id")Integer id,
                                                @RequestParam("state")Integer gorderState){
        Map<String,String> map = new HashMap<String,String>();
        int res = gorderService.orderChangeState(id,gorderState);
        String state = "0";
        String msg = "发货失败！";
        if (res>=1){
            state = "1";
            msg = "发货成功！";
        }
        map.put("state",state);
        map.put("msg",msg);
        return map;
    }

    /**
    * @author 飞鸿
    * @Description 查看订单详情
    * @Date 18:47 2019/1/7
    * @MethodName orderDetial
    * @param gorderId
    * @param model
    * @return java.lang.String
    **/
    @RequestMapping("/orderDetial")
    public String orderDetial(@RequestParam("id")Integer gorderId,Model model){
        List<OrderdetialAssociation> list = orderDetialService.findByGorderId(gorderId);
        model.addAttribute("list",list);
        return "admin/order-detial";
    }

    /**
    * @author 飞鸿
    * @Description 查询近七天各个状态的交易情况
    * @Date 18:52 2019/1/7
    * @MethodName getOrderCountByDay
    * @param  
    * @return java.util.List<java.util.Map<java.lang.String,java.lang.Integer>>
    **/
    @RequestMapping("/getOrderCountByDay")
    @ResponseBody
    public List<Map<String,Object>> getOrderCountByDay(){
        List<Map<String,Object>> list = new ArrayList<>();
        for (int i=0; i<5; i++){
            List<Map<String,Object>> item = gorderService.getOrderCountByDay(i);
            if (item != null && item.size()>0) {
                list.addAll(item);
            }
        }
        return list;
    }
}
