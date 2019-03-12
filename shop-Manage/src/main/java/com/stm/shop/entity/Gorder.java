package com.stm.shop.entity;

import java.util.Date;

public class Gorder {
    private Integer gorderId;

    private Integer addressId;

    private Integer userId;

    private Float total;

    private Integer gorderState;

    private Date createtime;

    private Integer deleteflag;

    public Integer getGorderId() {
        return gorderId;
    }

    public void setGorderId(Integer gorderId) {
        this.gorderId = gorderId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Integer getGorderState() {
        return gorderState;
    }

    public void setGorderState(Integer gorderState) {
        this.gorderState = gorderState;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Integer deleteflag) {
        this.deleteflag = deleteflag;
    }
}