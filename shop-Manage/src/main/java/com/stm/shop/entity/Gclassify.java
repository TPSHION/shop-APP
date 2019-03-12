package com.stm.shop.entity;

import java.util.Date;

public class Gclassify {
    private Integer gclassId;

    private String classifyName;

    private Integer fid;

    private Date createtime;

    private Integer deleteflag;

    public Integer getGclassId() {
        return gclassId;
    }

    public void setGclassId(Integer gclassId) {
        this.gclassId = gclassId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName == null ? null : classifyName.trim();
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
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