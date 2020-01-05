package com.will.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "schedule_time_table")
public class ScheduleTimeTable {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 起始日期
     */
    @Column(name = "begin_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginDate;

    /**
     * 结束日期-- 未使用
     */
    @Column(name = "end_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    /**
     * 排班时间段表id
     */
    @Column(name = "time_table_list_id")
    private String timeTableListId;

    /**
     * 人员id
     */
    @Column(name = "person_id")
    private String personId;

    /**
     * 班次id
     */
    @Column(name = "shift_id")
    private String shiftId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态-- 未使用
     */
    private String status;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 删除标记
     */
    @Column(name = "del_flag")
    private String delFlag;


    /**
     * master_id
     */
    @Column(name = "master_id")
    private String masterId;


    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * org_id
     */
    @Column(name = "org_id")
    private String orgId;






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
     * 获取起始日期
     *
     * @return begin_date - 起始日期
     */
    public Date getBeginDate() {
        return beginDate;
    }

    /**
     * 设置起始日期
     *
     * @param beginDate 起始日期
     */
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * 获取结束日期-- 未使用
     *
     * @return end_date - 结束日期-- 未使用
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置结束日期-- 未使用
     *
     * @param endDate 结束日期-- 未使用
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取排班时间段表id
     *
     * @return time_table_list_id - 排班时间段表id
     */
    public String getTimeTableListId() {
        return timeTableListId;
    }

    /**
     * 设置排班时间段表id
     *
     * @param timeTableListId 排班时间段表id
     */
    public void setTimeTableListId(String timeTableListId) {
        this.timeTableListId = timeTableListId;
    }

    /**
     * 获取人员id
     *
     * @return person_id - 人员id
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * 设置人员id
     *
     * @param personId 人员id
     */
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    /**
     * 获取班次id
     *
     * @return shift_id - 班次id
     */
    public String getShiftId() {
        return shiftId;
    }

    /**
     * 设置班次id
     *
     * @param shiftId 班次id
     */
    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
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
     * 获取状态-- 未使用
     *
     * @return status - 状态-- 未使用
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态-- 未使用
     *
     * @param status 状态-- 未使用
     */
    public void setStatus(String status) {
        this.status = status;
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
     * 获取备注信息
     *
     * @return remarks - 备注信息
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注信息
     *
     * @param remarks 备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
}