package com.will.cross.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "schedule_require_stuff")
public class ScheduleRequireStuff {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 区域ID
     */
    @Column(name = "area_id")
    private String areaId;

    /**
     * 区域名字
     */
    @Column(name = "area_name")
    private String areaName;

    /**
     * 位置ID
     */
    @Column(name = "location_id")
    private String locationId;

    /**
     * 位置名字
     */
    @Column(name = "location_name")
    private String locationName;

    /**
     * 需要人数
     */
    private Integer amount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 粒度，0 15分钟   1半小时   2小时
     */
    private String grain;

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
     * 开始时间
     */
    @Column(name = "beg_time")
    private Date begTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 组织ID
     */
    @Column(name = "master_id")
    private String masterId;

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
     * 获取区域ID
     *
     * @return area_id - 区域ID
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * 设置区域ID
     *
     * @param areaId 区域ID
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取区域名字
     *
     * @return area_name - 区域名字
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置区域名字
     *
     * @param areaName 区域名字
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 获取位置ID
     *
     * @return location_id - 位置ID
     */
    public String getLocationId() {
        return locationId;
    }

    /**
     * 设置位置ID
     *
     * @param locationId 位置ID
     */
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    /**
     * 获取位置名字
     *
     * @return location_name - 位置名字
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * 设置位置名字
     *
     * @param locationName 位置名字
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * 获取需要人数
     *
     * @return amount - 需要人数
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * 设置需要人数
     *
     * @param amount 需要人数
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
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
     * 获取粒度，0 15分钟   1半小时   2小时
     *
     * @return grain - 粒度，0 15分钟   1半小时   2小时
     */
    public String getGrain() {
        return grain;
    }

    /**
     * 设置粒度，0 15分钟   1半小时   2小时
     *
     * @param grain 粒度，0 15分钟   1半小时   2小时
     */
    public void setGrain(String grain) {
        this.grain = grain;
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
     * 获取开始时间
     *
     * @return beg_time - 开始时间
     */
    public Date getBegTime() {
        return begTime;
    }

    /**
     * 设置开始时间
     *
     * @param begTime 开始时间
     */
    public void setBegTime(Date begTime) {
        this.begTime = begTime;
    }

    /**
     * 获取结束时间
     *
     * @return end_time - 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     *
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取组织ID
     *
     * @return master_id - 组织ID
     */
    public String getMasterId() {
        return masterId;
    }

    /**
     * 设置组织ID
     *
     * @param masterId 组织ID
     */
    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }
}