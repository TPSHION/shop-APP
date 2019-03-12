package com.stm.shop.app.controller;

import com.stm.shop.app.service.AddressService;
import com.stm.shop.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:liuxinxing Date:2018/12/28 0028
 * Time:15:00
 */
@RestController
@RequestMapping(value="/app/address")
public class AddressController {
    @Autowired
    private AddressService addressService;


    /**
     * 添加地址信息
     * @param userId
     * @param name
     * @param tel
     * @param city
     * @param province
     * @param district
     * @param detail
     * @return
     */
    @PostMapping(value = "/addAddress")
    public Object insertAddress(@RequestParam("userId") Integer userId,
                                @RequestParam("name") String name,
                                @RequestParam("tel") String tel,
                                @RequestParam("city") String city,
                                @RequestParam("province") String province,
                                @RequestParam("district") String district,
                                @RequestParam("detail") String detail){
        Address address=new Address();
        address.setCity(city);
        address.setDetial(detail);
        address.setDistrict(district);
        address.setName(name);
        address.setTel(tel);
        address.setProvince(province);
        address.setUserId(userId);
        int flag=addressService.insertAddress(address);
        if(flag==1){
            return "{\"status\":1,\"message\":\"success\"}";
        }else
            return "{\"status\":0,\"message\":\"error\"}";
    }

    /**
     * 查询用户所有的地址
     * @param uid
     * @return
     */
    @GetMapping(value="/viewAllAddress/{uid}")
    public Object selectAll(@PathVariable("uid") Integer uid){
        List<Address> addresses= addressService.selectAll(uid);
        if(addresses!=null)
            {
            return addresses;
        }
        else
            return "{\"status\":0,\"message\":\"error\"}";
    }

    /**
     * 查询地址详细信息
     * @param id
     * @return
     */
    @GetMapping(value="/addressDetail/{id}")
    public Object findyId( @PathVariable("id") Integer id) {
        Address address=addressService.selectById(id);
        if(address!=null)
        {
            return address;
        }else
            return "{\"status\":0,\"message\":\"error\"}";

    }

    /**
     * 修改地址信息
     * @param address
     * @return
     */
    @PostMapping(value="/updateAddress")
    public Object updateByAddress(Address address) {
        int flag=addressService.updateById(address);
        if(flag==1){
            return "{\"status\":1,\"message\":\"success\"}";
        }else
            return "{\"status\":0,\"message\":\"error\"}";
    }

    /**
     * 删除地址信息
     */
    @GetMapping(value="/deleteAddress/{id}")
    public Object deleteByAddress(@PathVariable("id") Integer id){
        int flag=addressService.deleteById(id);
        if(flag==1){
            return "{\"status\":1,\"message\":\"success\"}";
        }else
            return "{\"status\":0,\"message\":\"error\"}";
    }

}
