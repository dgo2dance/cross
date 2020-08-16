package com.will.cross.model;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class SysSolveVO {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;


    //人员
    private List<Employee> agents;

    //天数
    private List<String> days;

    // 每天需求量
    private List<Hours> hoursVolume;

    private int weekCNT;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Employee> getAgents() {
        return agents;
    }

    public void setAgents(List<Employee> agents) {
        this.agents = agents;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public List<Hours> getHoursVolume() {
        return hoursVolume;
    }

    public void setHoursVolume(List<Hours> hoursVolume) {
        this.hoursVolume = hoursVolume;
    }

    public int getWeekCNT() {
        return weekCNT;
    }

    public void setWeekCNT(int weekCNT) {
        this.weekCNT = weekCNT;
    }





}