package com.will.cross.dto;

import com.will.cross.model.ScheduleTimeTable;

import java.util.List;

public class ScheduleTableDTO {

    /*
    资源ID,即用户ID
     */
    private String resourceId;

    public List<ScheduleTimeTable> getTable() {
        return table;
    }

    /*
        资源名字
         */
    private  String resourceName;


    /*
    资源对应下的班表情况；
     */

    List<ScheduleTimeTable> table;





    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public void setTable(List<ScheduleTimeTable> table) {
        this.table = table;
    }

    public String getResourceId() {
        return resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

}
