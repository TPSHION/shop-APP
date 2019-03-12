package com.stm.shop.entity;

import java.util.List;

/**
 * @Author：飞鸿
 * @Description：
 * @Date：Created on 11:10 2018/12/28.
 * @ModifyBy：
 */
public class GorderAssociation extends Gorder {

    private Address address;

    private User user;

    private Orderdetial orderdetial;

    private List<Orderdetial> orderdetialList;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Orderdetial getOrderdetial() {
        return orderdetial;
    }

    public void setOrderdetial(Orderdetial orderdetial) {
        this.orderdetial = orderdetial;
    }

    public List<Orderdetial> getOrderdetialList() {
        return orderdetialList;
    }

    public void setOrderdetialList(List<Orderdetial> orderdetialList) {
        this.orderdetialList = orderdetialList;
    }
}
