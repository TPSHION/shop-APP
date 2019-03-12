package com.stm.shop.admin.controller;

import com.stm.shop.admin.service.AdminService;
import com.stm.shop.admin.service.GorderService;
import com.stm.shop.entity.Admin;
import com.stm.shop.utils.DateUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 11:42 2018/12/26.
 * @ModifyBy：
 */
@Controller("admAdminController")
@RequestMapping("admin/admin")
public class AdminController{

    @Autowired
    private AdminService adminService;

    @Autowired
    private GorderService gorderService;

    /**
     * @author 飞鸿
     * @Description 登录页面渲染
     * @Date 11:44 2018/12/26
     * @MethodName loginView
     * @param
     * @return java.lang.String
     **/
    @RequestMapping("/login")
    public String loginView(){
        return "admin/login";
    }

    /**
    * @author 飞鸿
    * @Description 主页渲染
    * @Date 16:47 2018/12/27
    * @MethodName index
    * @param session
    * @return java.lang.String
    **/
    @RequestMapping("/index")
    public String index(HttpSession session,Model model){
        if (session.getAttribute("admin")==null)
            return this.loginView();
        model.addAttribute("list",this.getSumOrderInfo());
        return "admin/index";
    }

    /**
    * @author 飞鸿
    * @Description 管理员列表渲染
    * @Date 16:44 2018/12/27
    * @MethodName adminList
    * @param session
    * @return java.lang.String
    **/
    @RequestMapping("/adminList")
    public String adminList(HttpSession session,Model model){
        if (session.getAttribute("admin")==null)
            return this.loginView();
        model.addAttribute("list",adminService.getList());
        return "admin/admin-list";
    }

    /**
    * @author 飞鸿
    * @Description 登录验证
    * @Date 1:31 2018/12/29
    * @MethodName checkLogin
    * @param name
    * @param password
    * @param session
    * @return java.util.Map<java.lang.String,java.lang.String>
    **/
    @PostMapping("/checkLogin")
    @ResponseBody
    public Map<String,String> checkLogin(@Param("name") String name,
                             @Param("password") String password,
                             HttpSession session){
        Admin admin = adminService.checkLogin(name,password);
        Map<String,String> map = new HashMap<String,String>();
        String state = "0";
        String msg = "登录失败！";
        if (admin == null){
            msg = "用户名或密码错误，请重新登录！";
        }else {
            state = "1";
            msg = "登录成功！";
        }
        session.setAttribute("admin",admin);
        map.put("state",state);
        map.put("msg",msg);
        return map;
    }


    /**
    * @author 飞鸿
    * @Description 管理员登出
    * @Date 10:50 2018/12/27
    * @MethodName logOut
    * @param session
    * @return java.lang.String
    **/
    @RequestMapping("/logOut")
    public String logOut(HttpSession session){
        session.removeAttribute("admin");
        return "redirect:login";
    }
    
    /**
    * @author 飞鸿
    * @Description 添加管理员页面渲染
    * @Date 17:49 2018/12/27
    * @MethodName adminAddView
    * @param session 
    * @return java.lang.String
    **/
    @RequestMapping("/adminAddView")
    public String adminAddView(HttpSession session){
        if (session.getAttribute("admin")==null)
            return this.loginView();
        return "admin/admin-add";
    }

    /**
    * @author 飞鸿
    * @Description 检查当前名称管理员是否存在
    * @Date 18:32 2018/12/27
    * @MethodName isExist
    * @param name
    * @return java.lang.Boolean 存在返回true，否则返回false
    **/
    public Boolean isExist(String name){
        List<Admin> list = adminService.findByName(name);
        if (list!=null && !list.isEmpty())
            return true;
        return false;
    }

    /**
    * @author 飞鸿
    * @Description 添加管理员
    * @Date 1:31 2018/12/29
    * @MethodName adminAdd
    * @param admin
    * @return java.util.Map<java.lang.String,java.lang.String>
    **/
    @PostMapping("/adminAdd")
    @ResponseBody
    public Map<String,String> adminAdd(Admin admin){
        //添加前检测是否重名
        Map<String,String> map = new HashMap<String,String>();
        String state = "0";
        String msg = "添加失败，请稍后再试！";
        boolean  checkName = this.isExist(admin.getName());
        if (checkName){
            msg = "当前管理员名称已存在，请更换！";
        }else {
            int res = adminService.adminAdd(admin);
            if (res >= 1) {
                msg = "添加成功！";
                state = "1";
            }
        }
        map.put("state",state);
        map.put("msg",msg);
        return map;
    }

    /**
    * @author 飞鸿
    * @Description 软删除管理员
    * @Date 21:18 2018/12/27
    * @MethodName adminDel
    * @param id
    * @return java.util.Map<java.lang.String,java.lang.String>
    **/
    @GetMapping("/adminRecycle")
    @ResponseBody
    public Map<String,String> adminRecycle(@Param("id") Integer id){
        Map map = new HashMap();
        int deleteTime = DateUtil.getSecondTimestamp(new Date());
        int res = adminService.softDeleteById(id, deleteTime);
        if (res>=1){
            map.put("state","1");
            map.put("msg","删除成功！");
        }else{
            map.put("state","0");
            map.put("msg","删除失败！");
        }
        return map;
    }

    /**
    * @author 飞鸿
    * @Description 管理员信息编辑页面渲染
    * @Date 22:12 2018/12/27
    * @MethodName adminEditView
    * @param id
    * @param model
    * @return java.lang.String
    **/
    @RequestMapping("/adminEditView")
    public String adminEditView(@Param("id") Integer id,Model model){
        Admin admin = adminService.findById(id);
        model.addAttribute("admin",admin);
        return "admin/admin-edit";
    }

    /**
    * @author 飞鸿
    * @Description 编辑管理员信息
    * @Date 10:00 2018/12/28
    * @MethodName adminEdit
    * @param admin 
    * @return java.util.Map<java.lang.String,java.lang.String>
    **/
    @PostMapping("/adminEdit")
    @ResponseBody
    public Map<String,String> adminEdit(Admin admin){
        Map map = new HashMap();
        //检测管理员名称是否重名
        List<Admin> list = adminService.findByName(admin.getName());

        String state = "0";
        String msg = "修改失败！";

        if (list.isEmpty() || (list.size()==1&&list.get(0).getAdminId()==admin.getAdminId())){
            int res = adminService.updateById(admin);
            if (res>=1){
                state = "1";
                msg = "修改成功！";
            }
        }else{
            msg = "管理员名称不可用，请修改！";
        }
        map.put("state",state);
        map.put("msg",msg);
        return map;
    }

    /**
    * @author 飞鸿
    * @Description 获取删除状态的管理员列表
    * @Date 9:12 2018/12/28
    * @MethodName adminRecycleList
    * @param session
    * @param model
    * @return java.lang.String
    **/
    @RequestMapping("/adminRecycleList")
    public String adminRecycleList(HttpSession session,Model model) {
        if (session.getAttribute("admin") == null)
            return this.loginView();
        model.addAttribute("list", adminService.getRecycleList());
        return "admin/admin-recycle";
    }


    /**
    * @author 飞鸿
    * @Description 从回收站恢复管理员
    * @Date 9:47 2018/12/28
    * @MethodName adminRecover
    * @param id
    * @return java.util.Map<java.lang.String,java.lang.String>
    **/
    @GetMapping("/adminRecover")
    @ResponseBody
    public Map<String,String> adminRecover(@Param("id") Integer id){
        Map map = new HashMap();
        int res = adminService.recoverById(id);
        if (res>=1){
            map.put("state","1");
            map.put("msg","恢复成功！");
        }else{
            map.put("state","0");
            map.put("msg","恢复失败！");
        }
        return map;
    }


    /**
    * @author 飞鸿
    * @Description 彻底删除管理员信息
    * @Date 9:46 2018/12/28
    * @MethodName adminDel
    * @param id
    * @return java.util.Map<java.lang.String,java.lang.String>
    **/
    @GetMapping("/adminDel")
    @ResponseBody
    public Map<String,String> adminDel(@Param("id") Integer id){
        Map map = new HashMap();
        int res = adminService.deleteById(id);
        if (res>=1){
            map.put("state","1");
            map.put("msg","删除成功！");
        }else{
            map.put("state","0");
            map.put("msg","删除失败！");
        }
        return map;
    }


    /**
    * @author 飞鸿
    * @Description 获取当日和历史订单汇总信息和历史订单汇总信息
    * @Date 2:44 2018/12/29
    * @MethodName getToDayOrderInfo
    * @param  
    * @return java.util.Map<java.lang.String,java.lang.Object>
    **/
    @RequestMapping("/getSumOrderInfo")
    @ResponseBody
    public Map<String,Object> getSumOrderInfo(){
        Map<String,Object> map = gorderService.getToDayOrderInfo();
        map.putAll(gorderService.getHistoryOrderInfo());
        return map;
    }

}
