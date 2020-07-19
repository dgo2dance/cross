package com.will.cross.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "schedule_location")
public class ScheduleLocationRVO {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 位置名字
     */
    private String name;

    /**
     * 状态  0:启用   1 未启用
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


    public List<ScheduleArea> getArea() {
        return Area;
    }

    public void setArea(List<ScheduleArea> area) {
        Area = area;
    }

    private List<ScheduleArea> Area;


    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 删除标记
     */
    @Column(name = "del_flag")
    private String delFlag;

    /**
     * org-ID，位置关联的组织ID
     */
    private String master;

    /**
     * 地点
     */
    private String place;

    /**
     * 开始时间
     */
    @Column(name = "begTime")
    private Date begtime;

    /**
     * 结束时间
     */
    @Column(name = "endTime")
    private Date endtime;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public String getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取位置名字
     *
     * @return name - 位置名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置位置名字
     *
     * @param name 位置名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取状态  0:启用   1 未启用
     *
     * @return status - 状态  0:启用   1 未启用
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态  0:启用   1 未启用
     *
     * @param status 状态  0:启用   1 未启用
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取删除标记
     *
     * @return del_flag - 删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     *
     * @param delFlag 删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取org-ID，位置关联的组织ID
     *
     * @return master - org-ID，位置关联的组织ID
     */
    public String getMaster() {
        return master;
    }

    /**
     * 设置org-ID，位置关联的组织ID
     *
     * @param master org-ID，位置关联的组织ID
     */
    public void setMaster(String master) {
        this.master = master;
    }

    /**
     * 获取地点
     *
     * @return place - 地点
     */
    public String getPlace() {
        return place;
    }

    /**
     * 设置地点
     *
     * @param place 地点
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * 获取开始时间
     *
     * @return begTime - 开始时间
     */
    public Date getBegtime() {
        return begtime;
    }

    /**
     * 设置开始时间
     *
     * @param begtime 开始时间
     */
    public void setBegtime(Date begtime) {
        this.begtime = begtime;
    }

    /**
     * 获取结束时间
     *
     * @return endTime - 结束时间
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * 设置结束时间
     *
     * @param endtime 结束时间
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}