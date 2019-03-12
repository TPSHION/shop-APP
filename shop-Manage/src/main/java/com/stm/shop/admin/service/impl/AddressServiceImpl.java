package com.stm.shop.admin.service.impl;

import com.stm.shop.admin.dao.AddressMapper;
import com.stm.shop.admin.service.AddressService;
import com.stm.shop.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 10:30 2018/12/28.
 * @ModifyBy：
 */
@Service("admAddressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Address findById(Integer id) {
        return addressMapper.findById(id);
    }
}
