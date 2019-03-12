package com.stm.shop.app.service.impl;

import com.stm.shop.app.dao.GorderDao;
import com.stm.shop.app.service.GorderService;
import com.stm.shop.entity.Gorder;
import com.stm.shop.entity.GorderAssociation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:liuxinxing Date:2018/12/29 0029
 * Time:18:34
 */
@Service
public class GorderServiceImpl implements GorderService {
    @Autowired
    private GorderDao gorderDao;

    @Override
    public List<Gorder> selectAll(Integer id) {
        List<Gorder> gorderList=gorderDao.selectAll(id);
        return gorderList;
    }

    @Override
    public List<GorderAssociation> selectById(Integer id) {
        List<GorderAssociation> gorderAssociationList=gorderDao.selectByPrimaryKey(id);
        return gorderAssociationList;
    }

    @Override
    public Integer orderChangeState(Integer gorderId, Integer state) {
        return gorderDao.orderChangeState(gorderId,state);
    }

    @Override
    public int addGorder(Gorder gorder) {
        return gorderDao.insertGorder(gorder);
    }
}
