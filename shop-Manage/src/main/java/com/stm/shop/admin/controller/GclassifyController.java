package com.stm.shop.admin.controller;

import com.stm.shop.admin.service.GclassifyService;
import com.stm.shop.admin.service.GoodsService;
import com.stm.shop.entity.Gclassify;
import com.stm.shop.entity.GclassifyAssociation;
import com.stm.shop.entity.GoodsAssociation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 17:54 2018/12/28.
 * @ModifyBy：
 */
@Controller("admGclassifyController")
@RequestMapping("admin/classify")
public class GclassifyController {

    @Autowired
    private GclassifyService gclassifyService;

    @Autowired
    private AdminController adminController;

    @Autowired
    private GoodsService goodsService;

    /**
    * @author 飞鸿
    * @Description 获取所有可用商品种类
    * @Date 17:57 2018/12/28
    * @MethodName getList
    * @param session
    * @param model
    * @return java.lang.String
    **/
    @GetMapping("/getList")
    public String getList(HttpSession session, Model model){
        if (session.getAttribute("admin")==null)
            return adminController.loginView();
        model.addAttribute("list",gclassifyService.getList());
        return "admin/classify-list";
    }

    /**
    * @author 飞鸿
    * @Description 添加种类页面渲染
    * @Date 21:14 2018/12/28
    * @MethodName addClassifyView
    * @param session
    * @param model
    * @return java.lang.String
    **/
    @RequestMapping("classifyAddView")
    public String addClassifyView(HttpSession session,Model model){
        if (session.getAttribute("admin")==null)
            return adminController.loginView();

        model.addAttribute("list",gclassifyService.getList());
        return "admin/classify-add";
    }

    /**
    * @author 飞鸿
    * @Description 检测种类名称是否存在，存在返回true，否则返回false
    * @Date 21:35 2018/12/28
    * @MethodName isExist
    * @param classifyName
    * @return java.lang.Boolean
    **/
    public Boolean isExist(String classifyName){
        List<GclassifyAssociation> list = gclassifyService.findByClassifyName(classifyName);
        if (list!=null && list.size()>0)
            return true;
        return false;
    }

    @RequestMapping("/classifyAdd")
    @ResponseBody
    public Map<String,String> classifyAdd(@RequestParam("classifyName")String classifyName,
                                           @RequestParam("fid")Integer fid){
        Map<String,String> map = new HashMap<String,String>();
        String state = "0";
        String msg = "添加失败！";
        Boolean checkName = this.isExist(classifyName);
        if (checkName){
            msg = "种类名称已存在，请修改！";
        }else{
            int res = gclassifyService.addClassify(classifyName,fid);
            if (res>=1){
                state = "1";
                msg = "添加成功！";
            }
        }
        map.put("state",state);
        map.put("msg",msg);
        return map;
    }

    /**
    * @author 飞鸿
    * @Description 根据种类id找出当前子类所有id，存储到list中
    * @Date 22:14 2018/12/28
    * @MethodName getChildrenId
    * @param fid 
    * @param idSet
    * @return java.util.Set<java.lang.Integer>
    **/
    public Set<Integer> getChildrenId(Integer fid,Set<Integer> idSet){
        idSet.add(fid);
        List<Gclassify> gList = gclassifyService.findByFid(fid);

        for (Gclassify item:gList){
            this.getChildrenId(item.getGclassId(),idSet);
        }
        return idSet;
    }

    /**
    * @author 飞鸿
    * @Description 根据当前种类id查询所有父类别id
    * @Date 23:30 2018/12/28
    * @MethodName getParentsId
    * @param gclassify
    * @param idSet
    * @return java.util.Set<java.lang.Integer>
    **/
    public Set<Integer> getParentsId(GclassifyAssociation gclassify,Set<Integer> idSet){
        idSet.add(gclassify.getGclassId());
        if (gclassify.getFid()==0 )
            return idSet;
        return this.getParentsId((GclassifyAssociation)gclassify.getGclassify(),idSet);
    }
    
    /**
    * @author 飞鸿
    * @Description 删除当前种类及其包含的子类别
    * @Date 22:18 2018/12/28
    * @MethodName softDelClassifyAndChild
    * @param id 
    * @return java.util.Map<java.lang.String,java.lang.String>
    **/
    @RequestMapping("/recycleClassify")
    @ResponseBody
    public Map<String,String> softDelClassifyAndChild(@RequestParam("id")Integer id){
        Set<Integer> idSet = new HashSet<Integer>();
        this.getChildrenId(id,idSet);
        int res = gclassifyService.recycleClassifyAndChildren(idSet);
        String state = "0";
        String msg = "删除失败！";
        Map<String,String> map = new HashMap<String,String>();
        if (res>=1){
            state = "1";
            msg = "删除成功！";
        }
        map.put("state",state);
        map.put("msg",msg);
        return map;
    }

    /**
    * @author 飞鸿
    * @Description 恢复当前类别及其子类别
    * @Date 23:01 2018/12/28
    * @MethodName recoverClassifyAndParents
    * @param id
    * @return java.lang.String
    **/
    @RequestMapping("/recoverClassify")
    @ResponseBody
    public Map<String,String> recoverClassifyAndParents(@Param("id") Integer id){
        GclassifyAssociation gclassify = gclassifyService.findById(id);
        Set<Integer> idSet = new HashSet<Integer>();
        this.getParentsId(gclassify,idSet);
        int res = gclassifyService.recoverClassifyAndParents(idSet);

        String state = "0";
        String msg = "恢复失败！";
        Map<String,String> map = new HashMap<String,String>();

        if (res>=1){
            state = "1";
            msg = "恢复成功！";
        }
        map.put("state",state);
        map.put("msg",msg);
        return map;
    }

    /**
    * @author 飞鸿
    * @Description 获取回收站种类信息
    * @Date 23:43 2018/12/28
    * @MethodName getRecycleList
    * @param session
    * @param model
    * @return java.lang.String
    **/
    @RequestMapping("/getRecycleList")
    public String getRecycleList(HttpSession session,Model model){
        if (session.getAttribute("admin")==null)
            return adminController.loginView();

        model.addAttribute("list",gclassifyService.getSoftDelList());
        return "admin/classify-recycle";
    }

    /**
    * @author 飞鸿
    * @Description 种类编辑页面渲染
    * @Date 0:01 2018/12/29
    * @MethodName classifyEditView
    * @param id
    * @param session
    * @param model
    * @return java.lang.String
    **/
    @RequestMapping("/classifyEditView")
    public String classifyEditView(@Param("id")Integer id, HttpSession session,Model model){
        if (session.getAttribute("admin")==null)
            return adminController.loginView();
        model.addAttribute("classify",gclassifyService.findById(id));
        model.addAttribute("list",gclassifyService.getList());
        return "admin/classify-edit";
    }

    /**
    * @author 飞鸿
    * @Description 编辑种类信息
    * @Date 0:02 2018/12/29
    * @MethodName classifyEdit
    * @param gclassify
    * @return java.util.Map<java.lang.String,java.lang.String>
    **/
    @RequestMapping("/classifyEdit")
    @ResponseBody
    public Map<String,String> classifyEdit(Gclassify gclassify){
        Map<String,String> map = new HashMap<String,String>();

        List<GclassifyAssociation> list = gclassifyService.findByClassifyName(gclassify.getClassifyName());
        String state = "0";
        String msg = "修改失败！";
        if (list.size()>1 || (list.size()==1&&list.get(0).getGclassId()!=gclassify.getGclassId())){
            msg = "当前种类名称已存在，请更换！";
        }else{
            int res = gclassifyService.update(gclassify);
            if (res>=1){
                state = "1";
                msg = "修改成功！";
            }
        }
        map.put("state",state);
        map.put("msg",msg);
        return map;
    }


    /**
    * @author 飞鸿
    * @Description 硬删除数据
    * @Date 15:25 2019/1/7
    * @MethodName hardDelete
    * @param id
    * @return java.util.Map<java.lang.String,java.lang.String>
    **/
    @RequestMapping("/hardDelete")
    @ResponseBody
    public Map<String,String> hardDelete(@RequestParam("id")Integer id){

        Set<Integer> idSet = new HashSet<Integer>();
        this.getChildrenId(id,idSet);
        List<GoodsAssociation> goodsList = goodsService.findByGclassIds(idSet);
        String state = "0";
        String msg = "修改失败！";
        Map<String,String> map = new HashMap<String,String>();

        if (goodsList.size()>0){
            msg = "当前类别或其子类别有商品存在，不可删除，请先修改商品信息后再删除！";
        }else{
            int res = gclassifyService.hardDeleteByGclassIds(idSet);
            if (res>=1){
                state = "1";
                msg = "删除成功！";
            }
        }

        map.put("state",state);
        map.put("msg",msg);
        return map;
    }


    /**
    * @author 飞鸿
    * @Description 获取商品种类及其商品数量
    * @Date 15:47 2019/1/7
    * @MethodName getClassifyCount
    * @param  
    * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
    **/
    @RequestMapping("/getClassifyCount")
    @ResponseBody
    public List<Map<String,Object>> getClassifyCount(){
        List<Map<String,Object>> list = gclassifyService.classifyCount();
        return list;
    }

}
