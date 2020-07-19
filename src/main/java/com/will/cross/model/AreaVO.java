package com.will.cross.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "schedule_area")
public class AreaVO {

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    /**
     * 编号
     */

    private String keyName;

    /**
     * 区域名字
     */
    private String name;


    private String remark;



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