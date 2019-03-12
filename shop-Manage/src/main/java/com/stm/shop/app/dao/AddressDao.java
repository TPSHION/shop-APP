package com.stm.shop.app.dao;

import com.stm.shop.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author:liuxinxing Date:2018/12/28 0028
 * Time:14:51
 */
public interface AddressDao {
    int insertSelective(Address address);

    List<Address> selectByUid(@Param("userId")Integer id);

    Address selectByPrimaryKey(@Param("addressId")Integer id);

    int updateByPrimaryKey(Address address);

    int updateById(@Param("addressId")Integer id);
}