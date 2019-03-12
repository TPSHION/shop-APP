package com.stm.shop.admin.service.impl;

import com.stm.shop.admin.dao.GradeMapper;
import com.stm.shop.admin.service.GradeService;
import com.stm.shop.entity.GradeAssociation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 10:56 2019/1/7.
 * @ModifyBy：
 */
@Service("admGradeService")
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public GradeAssociation findByGoodsId(Integer goodsId) {
        return gradeMapper.findByGoodsId(goodsId);
    }
}
