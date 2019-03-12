package com.stm.shop.admin.service.impl;

import com.stm.shop.admin.dao.AdminMapper;
import com.stm.shop.entity.Admin;
import com.stm.shop.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 14:44 2018/12/26.
 * @ModifyBy：
 */
@Service("admAminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findById(Integer id) {
        return adminMapper.findById(id);
    }

    @Override
    public Admin checkLogin(String name, String password) {
        return adminMapper.findByNameAndPassword(name,password);
    }

    @Override
    public List<Admin> getList() {
        return adminMapper.getList();
    }

    @Override
    public List<Admin> findByName(String name) {
        return adminMapper.findByName(name);
    }

    @Override
    public Integer adminAdd(Admin admin) {
        return adminMapper.insertAdmin(admin);
    }

    @Override
    public Integer softDeleteById(Integer id, Integer deleteTime) {
        return adminMapper.softDeleteById(id,deleteTime);
    }

    @Override
    public Integer updateById(Admin admin) {
        return adminMapper.updateById(admin);
    }

    @Override
    public List<Admin> getRecycleList() {
        return adminMapper.getDeleteList();
    }

    @Override
    public Integer deleteById(Integer id) {
        return adminMapper.deleteById(id);
    }

    @Override
    public Integer recoverById(Integer id) {
        return adminMapper.recoverById(id);
    }
}
