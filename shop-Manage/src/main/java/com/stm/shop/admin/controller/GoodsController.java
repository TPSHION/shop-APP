package com.stm.shop.admin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stm.shop.admin.service.GclassifyService;
import com.stm.shop.admin.service.GoodsService;
import com.stm.shop.admin.service.GoodsitemService;
import com.stm.shop.entity.Goods;
import com.stm.shop.entity.Goodsitem;
import com.stm.shop.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 11:18 2018/12/29.
 * @ModifyBy：
 */
@Controller("admGoodsController")
@RequestMapping("admin/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private AdminController adminController;

    @Autowired
    private GclassifyService gclassifyService;

    @Autowired
    private GoodsitemService goodsitemService;

    /**
    * @author 飞鸿
    * @Description 获取商品信息列表
    * @Date 11:41 2018/12/29
    * @MethodName getGoodsList
    * @param session
    * @param model
    * @return java.lang.String
    **/
    @RequestMapping("/getGoodsList")
    public String getGoodsList(HttpSession session,Model model){
        if (session.getAttribute("admin")==null)
            return adminController.loginView();
        model.addAttribute("list",goodsService.getList());
        return "admin/goods-list";
    }

    
    /**
    * @author 飞鸿
    * @Description 软删除商品信息，放入回收站
    * @Date 12:31 2018/12/29
    * @MethodName recycleGoods
    * @param goodsId 
    * @return java.util.Map<java.lang.String,java.lang.String>
    **/
    @RequestMapping("/recycleGoods")
    @ResponseBody
    public Map<String,String> recycleGoods(@RequestParam("id")Integer goodsId){
        Map<String,String> map = new HashMap<String,String>();
        String state = "0";
        String msg = "删除失败！";
        int res = goodsService.softDelByGoodsId(goodsId);
        if (res>=1){
            state = "1";
            msg = "删除成功！";
        }
        map.put("state", state);
        map.put("msg",msg);
        return map;
    }


    /**
    * @author 飞鸿
    * @Description 获取被软删除的商品信息
    * @Date 12:38 2018/12/29
    * @MethodName getRecycleList
    * @param session
    * @param model
    * @return java.lang.String
    **/
    @RequestMapping("/goodsRecycleList")
    public String getRecycleList(HttpSession session,Model model){
        if (session.getAttribute("admin")==null)
            return adminController.loginView();
        model.addAttribute("list",goodsService.getRecycleList());
        return "admin/goods-recycle";
    }


    /**
    * @author 飞鸿
    * @Description 添加商品页面渲染
    * @Date 15:09 2019/1/6
    * @MethodName goodsAddView
    * @param session
    * @param model
    * @return java.lang.String
    **/
    @RequestMapping("/goodsAddView")
    public String goodsAddView(HttpSession session,Model model){
        if (session.getAttribute("admin")==null)
            return adminController.loginView();
        model.addAttribute("list",gclassifyService.getList());
        return "admin/goods-add";
    }
    
    /**
    * @author 飞鸿
    * @Description 插入商品信息，插入成功后返回主键id
    * @Date 13:43 2018/12/29
    * @MethodName goodsAdd
    * @param goods
    * @return java.util.Map<java.lang.String,java.lang.Object>
    **/
    @RequestMapping("goodsAdd")
    @ResponseBody
    public Map<String,Object> goodsAdd(Goods goods){
        int res = goodsService.insert(goods);
        int state = 0,step=1;
        String msg = "添加失败！";
        if (res >= 1){
            state = 1;
            step = 2;//可以进行第二步
            msg = "添加成功！";
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("state",state);
        map.put("msg",msg);
        map.put("goodsId",goods.getGoodsId());
        map.put("step",step);//进行到第一步
        return map;
    }

    /**
    * @author 飞鸿
    * @Description 恢复回收站的商品
    * @Date 20:08 2018/12/29
    * @MethodName recoverGoods
    * @param goodsId
    * @return java.util.Map<java.lang.String,java.lang.String>
    **/
    @RequestMapping("/recoverGoods")
    @ResponseBody
    public Map<String,String> recoverGoods(@RequestParam("id")Integer goodsId){
        Map<String,String> map = new HashMap<String,String>();
        String state = "0";
        String msg = "恢复失败！";
        int res = goodsService.recoverByGoodsId(goodsId);
        if (res>=1){
            state = "1";
            msg = "恢复成功！";
        }
        map.put("state", state);
        map.put("msg",msg);
        return map;
    }


    /**
    * @author 飞鸿
    * @Description 添加商品详细信息
    * @Date 20:08 2018/12/29
    * @MethodName addGoodsDetial
    * @param goodsId
    * @param type
    * @param material
    * @param files
    * @return java.util.Map<java.lang.String,java.lang.Object>
    **/
    @RequestMapping("/addGoodsDetial")
    @ResponseBody
    public Map<String,Object> addGoodsDetial(@RequestParam("goodsId")Integer goodsId,
                                             @RequestParam("type")String type,
                                             @RequestParam("material")String material,
                                             @RequestParam("imgs[]") MultipartFile []files)throws IOException{
        String msg = "添加失败！";
        int state = 0,step=2;
        Map<String,Object> map = new HashMap<String,Object>();
        if (goodsId==null||goodsId==0) {
            msg = "请先添加商品基础信息！";
            map.put("state",state);
            map.put("msg",msg);
            map.put("step",step);
            return map;
        }
        if (type==null||type=="") {
            msg = "请输入类别！";
            map.put("state",state);
            map.put("msg",msg);
            map.put("step",step);
            return map;
        }
        if (material==null||material=="") {
            msg = "请输入材质信息！";
            map.put("state",state);
            map.put("msg",msg);
            map.put("step",step);
            return map;
        }
        if (files==null||files.length<=0){
            msg = "请选择图片！";
            map.put("state",state);
            map.put("msg",msg);
            map.put("step",step);
            return map;
        }

        String rootPath = ResourceUtils.getURL("classpath:").getPath()+"/static/upload/goodsimg";
        List<String> imgList = new ArrayList<String>();
        for (MultipartFile item:files){
            String filePath = FileUploadUtils.upload(item,rootPath,"goods_");
            imgList.add("/upload/goodsimg/"+filePath);
        }
        Map<String,Object> content = new HashMap<String,Object>();
        content.put("material",material);
        content.put("type",type);
        content.put("imgDetails",imgList);
        //数据库字段content存储的字符串
        String contentJson = JSONObject.toJSONString(content);

        Goods goods = new Goods();
        goods.setGoodsId(goodsId);
        goods.setContent(contentJson);
        goods.setImageUrl(imgList.get(0));

        int res = goodsService.update(goods);
        System.out.println(contentJson);
        if (res>=1){
            msg = "添加成功！";
            state = 1;
            step = 3;
        }
        map.put("state",state);
        map.put("msg",msg);
        map.put("step",step);
        return map;
    }

    /**
    * @author 飞鸿
    * @Description 添加商品尺寸颜色等信息
    * @Date 20:08 2018/12/29
    * @MethodName goodsitemAdd
    * @param goodsitem
    * @return java.util.Map<java.lang.String,java.lang.Object>
    **/
    @RequestMapping("/goodsitemAdd")
    @ResponseBody
    public Map<String,Object> goodsitemAdd(Goodsitem goodsitem){
        String msg = "添加失败！";
        int state = 0;
        Map<String,Object> map = new HashMap<String,Object>();

        int res = goodsitemService.insert(goodsitem);
        if (res>=1){
            state = 1;
            msg = "添加成功！";
        }
        List<Goodsitem> items = goodsitemService.findByGoodsId(goodsitem.getGoodsId());
        map.put("state",state);
        map.put("msg",msg);
        map.put("goodsItems",items);
        return map;
    }

    /**
    * @author 飞鸿
    * @Description 渲染商品编辑页面
    * @Date 16:06 2019/1/6
    * @MethodName goodsEditView
    * @param id
    * @param session
    * @param model
    * @return java.lang.String
    **/
    @RequestMapping("/goodsEditView")
    public String goodsEditView(@RequestParam("id") Integer id,
                                HttpSession session,
                                Model model){
        if (session.getAttribute("admin")==null)
            return adminController.loginView();

        Goods goods = goodsService.findById(id);

        JSONObject detial = JSON.parseObject(goods.getContent());

        model.addAttribute("goods",goods);
        model.addAttribute("itemList",goodsitemService.findByGoodsId(id));
        model.addAttribute("classifyList",gclassifyService.getList());
        model.addAttribute("detial",detial);
        return "admin/goods-edit";
    }

    /**
    * @author 飞鸿
    * @Description 编辑商品基础信息
    * @Date 9:09 2019/1/7
    * @MethodName goodsEditBase
    * @param goods
    * @return java.util.Map<java.lang.String,java.lang.Object>
    **/
    @RequestMapping("/goodsEditBase")
    @ResponseBody
    public Map<String,Object> goodsEditBase(Goods goods){
        String msg = "修改失败！";
        int state = 0;
        Map<String,Object> map = new HashMap<String,Object>();

        int res = goodsService.update(goods);
        if (res>=1){
            state = 1;
            msg = "修改成功！";
        }
        map.put("state",state);
        map.put("msg",msg);
        return map;
    }


    /**
    * @author 飞鸿
    * @Description 根据id删除item
    * @Date 9:13 2019/1/7
    * @MethodName deleteItem
    * @param itemId
    * @return java.util.Map<java.lang.String,java.lang.Object>
    **/
    @RequestMapping("/deleteItem")
    @ResponseBody
    public Map<String,Object> deleteItem(@RequestParam("id") Integer itemId){
        String msg = "删除失败！";
        int state = 0;
        Map<String,Object> map = new HashMap<String,Object>();

        int res = goodsitemService.deleteById(itemId);
        if (res>=1){
            state = 1;
            msg = "删除成功！";
        }
        map.put("state",state);
        map.put("msg",msg);
        return map;
    }


    /**
    * @author 飞鸿
    * @Description 编辑商品详细信息
    * @Date 10:04 2019/1/7
    * @MethodName editGoodsDetial
    * @param goodsId
    * @param type
    * @param material
    * @param files
    * @return java.util.Map<java.lang.String,java.lang.Object>
    **/
    @RequestMapping("/editGoodsDetial")
    @ResponseBody
    public Map<String,Object> editGoodsDetial(@RequestParam("goodsId")Integer goodsId,
                                             @RequestParam("type")String type,
                                             @RequestParam("material")String material,
                                             @RequestParam("imgs[]") MultipartFile []files)throws IOException{
        String msg = "编辑失败！";
        int state = 0;
        Goods goods = goodsService.findById(goodsId);
        Map detial = JSON.parseObject(goods.getContent());
        System.out.println(detial.get("imgDetails").toString());
        Map<String,Object> map = new HashMap<String,Object>();
        if (type==null||type=="") {
            msg = "请输入类别！";
            map.put("state",state);
            map.put("msg",msg);
            return map;
        }
        if (material==null||material=="") {
            msg = "请输入材质信息！";
            map.put("state",state);
            map.put("msg",msg);
            return map;
        }
        if (files==null||files.length<=0){//没上传图片默认不修改图片信息
            Map<String,Object> content = new HashMap<String,Object>();
            content.put("material",material);
            content.put("type",type);
            content.put("imgDetails",detial.get("imgDetails"));
            //数据库字段content存储的字符串
            String contentJson = JSONObject.toJSONString(content);
            goods.setContent(contentJson);
            int res = goodsService.update(goods);
            if (res>=1){
                msg = "修改成功！";
                state = 1;
            }
            map.put("state",state);
            map.put("msg",msg);
        }else{//上传有图片删除原图后修改信息
            String rootPath = ResourceUtils.getURL("classpath:").getPath()+"static/upload/goodsimg";
            List<String> imgList = new ArrayList<String>();
            for (MultipartFile item:files){
                String filePath = FileUploadUtils.upload(item,rootPath,"goods_");
                imgList.add("/upload/goodsimg/"+filePath);
            }

            Map<String,Object> content = new HashMap<String,Object>();
            content.put("material",material);
            content.put("type",type);
            content.put("imgDetails",detial.get("imgDetails"));//防止图片上传失败，先不修改原图，上传成功才修改


            //删除原来的图片
            if (imgList.size()>0){
                content.put("imgDetails",imgList);
                String delRootPath = ResourceUtils.getURL("classpath:").getPath()+"static";
                for (String delpath:(List<String>)detial.get("imgDetails")){
                    String delRes = FileUploadUtils.delFile(delRootPath+delpath);
                    System.out.println(delRootPath+delpath+delRes);
                }
            }

            //数据库字段content存储的字符串
            String contentJson = JSONObject.toJSONString(content);
            goods.setContent(contentJson);
            goods.setImageUrl(imgList.get(0));
            int res = goodsService.update(goods);
            if (res>=1){
                msg = "修改成功！";
                state = 1;
            }
            map.put("state",state);
            map.put("msg",msg);
        }

        return map;
    }

    @RequestMapping("/goodsCommonList")
    public String goodsCommonList(@RequestParam("id")Integer goodsId){

        return "admin/goods-common";
    }



}
