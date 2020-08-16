package com.will.cross.model;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Table(name = "sys_user")
public class Hours {
    /**
     * 编号
     */
    @Id
    private String date;

    private List<String> num;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getNum() {
        return num;
    }

    public void setNum(List<String> num) {
        this.num = num;
    }
}