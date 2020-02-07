package com.will.cross.dto;

import java.util.List;

public class ScheduleTimeTableIamDTO {


    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    /*
          month
        */
    private String month;

    /*
       day
     */
    private String day;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }

    /*
                班次ID
                 */
    private  String shiftId;


    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    /*
         班次 名字
          */
    private  String shiftName;


    private String beginDate1;
    private String endDate1;

    public String getBeginDate1() {
        return beginDate1;
    }

    public void setBeginDate1(String beginDate1) {
        this.beginDate1 = beginDate1;
    }

    public String getEndDate1() {
        return endDate1;
    }

    public void setEndDate1(String endDate1) {
        this.endDate1 = endDate1;
    }

    public String getBeginDate2() {
        return beginDate2;
    }

    public void setBeginDate2(String beginDate2) {
        this.beginDate2 = beginDate2;
    }

    public String getEndDate2() {
        return endDate2;
    }

    public void setEndDate2(String endDate2) {
        this.endDate2 = endDate2;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    private String beginDate2;
    private String endDate2;

    private String remark;





}
