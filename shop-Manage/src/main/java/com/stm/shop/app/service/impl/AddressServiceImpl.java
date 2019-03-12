package com.stm.shop.app.service.impl;

import com.stm.shop.app.dao.AddressDao;
import com.stm.shop.app.service.AddressService;
import com.stm.shop.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:liuxinxing Date:2018/12/28 0028
 * Time:14:57
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;

    @Override
    public int insertAddress(Address address) {
        int flag=addressDao.insertSelective(address);
        return flag;
    }

    @Override
    public List<Address> selectAll(Integer id) {
        List<Address> addresses=addressDao.selectByUid(id);
        return addresses;
    }

    @Override
    public Address selectById(Integer id) {
        Address address=addressDao.selectByPrimaryKey(id);
        return address;
    }

    @Override
    public int updateById(Address address) {
        int flag=addressDao.updateByPrimaryKey(address);
        return flag;
    }

    @Override
    public int deleteById(Integer id) {
        int flag=addressDao.updateById(id);
        return flag;
    }
}
