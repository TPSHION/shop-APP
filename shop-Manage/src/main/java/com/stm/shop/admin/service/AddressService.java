package com.stm.shop.admin.service;

import com.stm.shop.entity.Address;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 10:24 2018/12/28.
 * @ModifyBy：
 */
public interface AddressService {

    /**
     * @author 飞鸿
     * @Description 根据id查询地址信息
     * @Date 10:29 2018/12/28
     * @MethodName findById
     * @param id
     * @return com.stm.shop.entity.Address
     **/
    Address findById(Integer id);
}
