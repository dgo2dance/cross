package com.will.cross.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "schedule_area")
public class AreaVO {
    /**
     * 编号
     */

    private String key_name;

    /**
     * 区域名字
     */
    private String name;


    private String remark;

    public String getKey_name() {
        return key_name;
    }

    public void setKey_name(String key_name) {
        this.key_name = key_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}