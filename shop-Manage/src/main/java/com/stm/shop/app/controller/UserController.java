package com.stm.shop.app.controller;

import com.alibaba.fastjson.JSONObject;
import com.stm.shop.entity.User;
import com.stm.shop.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author：liuxinxing
 * @Description：
 * @Date：Created on 15:09 2018/12/26.
 * @ModifyBy：
 */
@RestController
@RequestMapping("/app/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    @GetMapping(value = "/login/{username}/{password}")
    public Object userlogin(@PathVariable("username") String username,@PathVariable("password") String password){
        User userOptional=userService.userLogin(username,password);
        if(userOptional!=null){
            return "{\"status\":1,\"data\":"+JSONObject.toJSONString(userOptional)+"}";
        }
            return "{\"status\":0,\"message\":\"登陆失败\"}";
    }


    /**
     * 插入用户信息
     * @param phone
     * @param userName
     * @param email
     * @param nickName
     * @param password
     * @param idCard
     * @param truename
     * @return
     */
    @PostMapping(value ="/register")
    public Object userRegister(@RequestParam("phone") String phone,
                               @RequestParam("userName") String userName,
                               @RequestParam("email") String email,
                               @RequestParam("nickName") String nickName,
                               @RequestParam("password") String password,
                               @RequestParam("idCard") String idCard,
                               @RequestParam("truename") String truename){
       User user =new User();
       user.setNickName(nickName);
       user.setEmail(email);
       user.setUserName(userName);
       user.setPhone(Long.parseLong(phone));
       user.setPassword(password);
       user.setIdCard(idCard);
       user.setTureName(truename);
       int flag=userService.userInsert(user);
       System.out.println(flag);
       if (flag==1)
       {
           return "{\"status\":1,\"message\":\"success\"}";
       }else
        return "{\"status\":0,\"message\":\"error\"}";
    }

    /**
     * 获取用户个人信息
     * @param id
     * @return
     */
    @GetMapping(value="/getUserInfo/{id}")
    public Object getUserInfo(@PathVariable("id") Integer id){
        User userInfo=userService.selectUserInfoById(id);
        if(userInfo!=null){
            return "{\"status\":1,\"data\":"+JSONObject.toJSONString(userInfo)+"}";
        }else
        return "{\"status\":0,\"message\":\"登陆失败\"}";
    }


}
