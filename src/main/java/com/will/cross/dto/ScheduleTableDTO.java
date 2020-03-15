package com.will.cross.dto;

import com.will.cross.model.ScheduleTimeTable;

import java.util.List;

public class ScheduleTableDTO {

    /*
    资源ID,即用户ID
     */
    private String resourceId;


    /*
        资源名字
         */
    private  String resourceName;


    /*
    资源对应下的班表情况；
     */

    public List<ScheduleTimeTableDTO> getTable() {
        return table;
    }

    public void setTable(List<ScheduleTimeTableDTO> table) {
        this.table = table;
    }

    List<ScheduleTimeTableDTO> table;





    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }


    public String getResourceId() {
        return resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

}
