package com.stm.shop.app.controller;

import com.stm.shop.app.service.GoodsService;
import com.stm.shop.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:liuxinxing Date:2019/1/1 0001
 * Time:13:27
 */
@RestController
@RequestMapping(value="/app/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @PostMapping(value="/searchKey")
    public Object searchKey(@RequestParam("key") String goodsName){
        List<Goods> goodsList=goodsService.searchKey(goodsName);
        if(goodsList!=null){
            return  goodsList;
        }else
            return "{\"status\":0,\"message\":\"error\"}";
    }

    @RequestMapping(value = "/showGoodsByName")
    public Map<String,Object> showGoodsByName(@RequestParam(name = "name",required = true) String name){
        Map<String,Object> map = new HashMap<>();
        List<Goods> goodsList = goodsService.showGoodsByGclassifyNmae(name);
        map.put("goods",goodsList);
        return map;
    }

    /**
     * 更具商品id显示所属商品信息
     * @return
     */
    @RequestMapping(value = "/showGood")
    public Map<String,Object> showGood(@RequestParam(name = "gId",required = true) Integer id){
        Map<String,Object> map = new HashMap<>();
        Goods good = goodsService.showGood(id);
        map.put("good",good);
        return map;
    }

    @RequestMapping(value = "/showGoodsByClassifyId")
    public Map<String,Object> showGoodsByClassifyId(@RequestParam(name = "gClassId",required = true) Integer id){
        Map<String,Object> map = new HashMap<>();
        List<Goods> goodsList = goodsService.showGoodsByClassifyId(id);
        map.put("goods",goodsList);
        return map;
    }

    @RequestMapping(value = "/showGoodsByKey")
    public Map<String,Object> showGoodsByKey(@RequestParam(name = "key",required = true) String key){
        Map<String,Object> map = new HashMap<>();
        List<Goods> goodsList = goodsService.showGoodsByKey(key);
        map.put("goods",goodsList);
        return map;
    }
}
