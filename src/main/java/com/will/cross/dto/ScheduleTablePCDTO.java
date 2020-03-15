package com.will.cross.dto;

import java.util.List;

public class ScheduleTablePCDTO {

    /*
    ID
     */
    private String id;


    /*
        开始时间
      */
    private  String start;



    /*
      结束时间
    */
    private  String end;



    /*
      资源id
    */
    private  String resourceId;



    /*
      标题
    */
    private  String title;


    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    /*
          背景颜色
        */
    private  String bgColor;


    private  Boolean showPopover;

    private Boolean resizable;

    private Boolean movable;

    private Boolean startResizable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public Boolean getShowPopover() {
        return showPopover;
    }

    public void setShowPopover(Boolean showPopover) {
        this.showPopover = showPopover;
    }

    public Boolean getResizable() {
        return resizable;
    }

    public void setResizable(Boolean resizable) {
        this.resizable = resizable;
    }

    public Boolean getMovable() {
        return movable;
    }

    public void setMovable(Boolean movable) {
        this.movable = movable;
    }

    public Boolean getStartResizable() {
        return startResizable;
    }

    public void setStartResizable(Boolean startResizable) {
        this.startResizable = startResizable;
    }

    public Boolean getEndResizable() {
        return endResizable;
    }

    public void setEndResizable(Boolean endResizable) {
        this.endResizable = endResizable;
    }

    public Boolean getRrule() {
        return rrule;
    }

    public void setRrule(Boolean rrule) {
        this.rrule = rrule;
    }

    private Boolean endResizable;

    private Boolean rrule;




}
