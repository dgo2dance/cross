package com.will.cross.dto;

import com.will.cross.model.ScheduleTimeTable;

import java.util.List;

public class SchedulePlanningDTO {

    private String name;
    private int hoursPerWeek;
    private double hoursWorked;

    // 一周原则休息天数
    private int restCNT;

    private String id;

    private String manager;

    //最后一周的最后一次休假星期
    private String lastNOIndex;

    private  List<ScheduleTimeTable> aiSCH;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getRestCNT() {
        return restCNT;
    }

    public void setRestCNT(int restCNT) {
        this.restCNT = restCNT;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getLastNOIndex() {
        return lastNOIndex;
    }

    public void setLastNOIndex(String lastNOIndex) {
        this.lastNOIndex = lastNOIndex;
    }

    public List<ScheduleTimeTable> getAiSCH() {
        return aiSCH;
    }

    public void setAiSCH(List<ScheduleTimeTable> aiSCH) {
        this.aiSCH = aiSCH;
    }



}
