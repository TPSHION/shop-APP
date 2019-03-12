package com.stm.shop.admin.controller;

import com.stm.shop.admin.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 11:08 2019/1/7.
 * @ModifyBy：
 */
@Controller("admGradeController")
@RequestMapping("admin/grade")
public class GradeController {

    @Autowired
    private AdminController adminController;

    @Autowired
    private GradeService gradeService;
    
    /**
    * @author 飞鸿
    * @Description 根据商品id获取用户的评价
    * @Date 11:10 2019/1/7
    * @MethodName goodsCommonList
    * @param goodsId 
    * @return java.lang.String
    **/
    @RequestMapping("goodsCommonList")
    public String goodsCommonList(@RequestParam("id") Integer goodsId, HttpSession session, Model model){
        if (session.getAttribute("admin")==null)
            return adminController.loginView();
        model.addAttribute("list",gradeService.findByGoodsId(goodsId));
        return "admin/goods-comment";
    }
}
