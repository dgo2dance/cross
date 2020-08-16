package com.will.cross.model;


/**
 *
 * @author betaiotazeta
 */
public class Employee implements Cloneable {
    
    public Employee(String name, int hoursPerWeek) {
        this.name = name;
        this.hoursPerWeek = hoursPerWeek;
        hoursWorked = 0;
    }

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

    @Override
    protected Employee clone() {
        try {
            return (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", hPW=" + hoursPerWeek + ", hW=" + hoursWorked + "}";
    }

    private String name;
    private int hoursPerWeek;
    private double hoursWorked;

    // 一周原则休息天数
    private int restCNT;

    private String id;

    private String manager;

    //最后一周的最后一次休假星期
    private String lastNOIndex;

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

    public String getLastDaySCH() {
        return lastDaySCH;
    }

    public void setLastDaySCH(String lastDaySCH) {
        this.lastDaySCH = lastDaySCH;
    }

    public int getCph() {
        return cph;
    }

    public void setCph(int cph) {
        this.cph = cph;
    }

    //最后一次上班的班名
    private String lastDaySCH;

    //每小时处理量
    private int cph;







}