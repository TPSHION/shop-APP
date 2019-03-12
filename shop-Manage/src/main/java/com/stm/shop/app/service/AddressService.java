package com.stm.shop.app.service;

import com.stm.shop.entity.Address;

import java.util.List;

/**
 * @author:liuxinxing Date:2018/12/28 0028
 * Time:14:54
 */
public interface AddressService {
    /**
     * 增添收货地址
     * @param address
     * @return
     */
    int insertAddress(Address address);

    /**
     * 查询用户所有的地址
     * @param id
     * @return
     */
    List<Address> selectAll(Integer id);

    /**
     *查询地址详情
     * @param id
     * @return
     */
    Address selectById(Integer id);

    /**
     * 修改地址信息
     * @param address
     * @return
     */
    int updateById(Address address);

    /**
     * 删除单个地址
     */
    int deleteById(Integer kid);
}
