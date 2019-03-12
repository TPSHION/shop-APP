package com.stm.shop.admin.dao;

import com.stm.shop.entity.Address;
import org.apache.ibatis.annotations.Param;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 10:24 2018/12/28.
 * @ModifyBy：
 */
public interface AddressMapper {

    /**
    * @author 飞鸿
    * @Description 根据id查询地址信息
    * @Date 10:30 2018/12/28
    * @MethodName findById
    * @param id
    * @return com.stm.shop.entity.Address
    **/
    Address findById(@Param("addressId") Integer id);
}
