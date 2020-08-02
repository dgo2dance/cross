package com.will.cross.dto;

import com.will.cross.model.ScheduleTimeTable;

import java.util.List;

public class ScheduleSaleDTO {

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTableData() {
        return tableData;
    }

    public void setTableData(String tableData) {
        this.tableData = tableData;
    }

    /*
        日期
         */
    private String date;


    /*
        单元板内容
         */
    private  String tableData;


}
