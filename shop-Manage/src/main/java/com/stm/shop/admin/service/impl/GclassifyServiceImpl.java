package com.stm.shop.admin.service.impl;

import com.stm.shop.admin.dao.GclassifyMapper;
import com.stm.shop.admin.service.GclassifyService;
import com.stm.shop.entity.Gclassify;
import com.stm.shop.entity.GclassifyAssociation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 17:39 2018/12/28.
 * @ModifyBy：
 */
@Service("admGclassifyService")
public class GclassifyServiceImpl implements GclassifyService {

    @Autowired
    private GclassifyMapper gclassifyMapper;

    @Override
    public List<GclassifyAssociation> getList() {
        return gclassifyMapper.getList();
    }

    @Override
    public List<GclassifyAssociation> findByClassifyName(String classifyName) {
        return gclassifyMapper.findByClassifyName(classifyName);
    }

    @Override
    public Integer addClassify(String classifyName, Integer fid) {
        return gclassifyMapper.addClassify(classifyName,fid);
    }

    @Override
    public GclassifyAssociation findById(Integer id) {
        return gclassifyMapper.findById(id);
    }

    @Override
    public List<Gclassify> findByFid(Integer fid) {
        return gclassifyMapper.findByFid(fid);
    }

    @Override
    public Integer recycleClassifyAndChildren(Set<Integer> idSet) {
        return gclassifyMapper.recycleClassifyAndChildren(idSet);
    }

    @Override
    public Integer recoverClassifyAndParents(Set<Integer> idSet) {
        return gclassifyMapper.recoverClassifyAndParents(idSet);
    }

    @Override
    public List<GclassifyAssociation> getSoftDelList() {
        return gclassifyMapper.getSoftDelList();
    }

    @Override
    public Integer update(Gclassify gclassify) {
        return gclassifyMapper.update(gclassify);
    }

    @Override
    public Integer hardDeleteByGclassIds(Set<Integer> idSet) {
        return gclassifyMapper.hardDeleteByGclassIds(idSet);
    }

    @Override
    public List<Map<String, Object>> classifyCount() {
        return gclassifyMapper.classifyCount();
    }
}
