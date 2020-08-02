package com.will.cross.dto;

import java.util.List;

public class LocaAreaTreeDTO {



    /*
        标题
         */
    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<LocaAreaTreeDTO> getChildren() {
        return children;
    }

    public void setChildren(List<LocaAreaTreeDTO> children) {
        this.children = children;
    }

    /*
            ID
             */
    private  String value;


    private List<LocaAreaTreeDTO> children;


}
