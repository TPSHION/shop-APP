package com.stm.shop.admin.service;

import com.stm.shop.entity.Gclassify;
import com.stm.shop.entity.GclassifyAssociation;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 17:38 2018/12/28.
 * @ModifyBy：
 */
public interface GclassifyService {

    /**
     * @author 飞鸿
     * @Description 根据id查询种类
     * @Date 21:57 2018/12/28
     * @MethodName findById
     * @param id
     * @return com.stm.shop.entity.GclassifyAssociation
     **/
    GclassifyAssociation findById(Integer id);

    /**
     * @author 飞鸿
     * @Description 获取可用状态的种类列表
     * @Date 17:38 2018/12/28
     * @MethodName getList
     * @param
     * @return java.util.List<com.stm.shop.entity.Gclassify>
     **/
    List<GclassifyAssociation> getList();

    /**
     * @author 飞鸿
     * @Description 通过种类名称查询
     * @Date 21:22 2018/12/28
     * @MethodName findByClassifyName
     * @param classifyName
     * @return java.util.List<com.stm.shop.entity.GclassifyAssociation>
     **/
    List<GclassifyAssociation> findByClassifyName(String classifyName);


    /**
     * @author 飞鸿
     * @Description 插入种类
     * @Date 21:26 2018/12/28
     * @MethodName addClassify
     * @param classifyName
     * @param fid
     * @return java.lang.Integer
     **/
    Integer addClassify(String classifyName,Integer fid);

    /**
     * @author 飞鸿
     * @Description 根据父级id（fid）查询
     * @Date 22:04 2018/12/28
     * @MethodName findByFid
     * @param fid
     * @return java.util.List<com.stm.shop.entity.Gclassify>
     **/
    List<Gclassify> findByFid(Integer fid);

    /**
    * @author 飞鸿
    * @Description 软删除当前所有set中的id的类别
    * @Date 22:29 2018/12/28
    * @MethodName recycleClassifyAndChildren
    * @param idSet 
    * @return java.lang.Integer
    **/
    Integer recycleClassifyAndChildren(Set<Integer> idSet);

    /**
    * @author 飞鸿
    * @Description 恢复当前种类及其父类别
    * @Date 22:49 2018/12/28
    * @MethodName recoverClassifyAndParents
    * @param idSet
    * @return java.lang.Integer
    **/
    Integer recoverClassifyAndParents(Set<Integer> idSet);
    
    /**
    * @author 飞鸿
    * @Description 获取软删除的种类信息
    * @Date 23:41 2018/12/28
    * @MethodName getSoftDelList
    * @param  
    * @return java.util.List<com.stm.shop.entity.GclassifyAssociation>
    **/
    List<GclassifyAssociation> getSoftDelList();

    /**
    * @author 飞鸿
    * @Description 修改种类信息
    * @Date 0:16 2018/12/29
    * @MethodName update
    * @param gclassify
    * @return java.lang.Integer
    **/
    Integer update(Gclassify gclassify);

    /**
     * @author 飞鸿
     * @Description 根据id集合彻底删除种类信息
     * @Date 0:55 2018/12/29
     * @MethodName hardDeleteByGclassIds
     * @param idSet
     * @return java.lang.Integer
     **/
    Integer hardDeleteByGclassIds(Set<Integer> idSet);

    /**
    * @author 飞鸿
    * @Description 获取种类及其商品数量
    * @Date 15:44 2019/1/7
    * @MethodName classifyCount
    * @param  
    * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
    **/
    List<Map<String,Object>> classifyCount();
}
