package com.will.cross.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "schedule_shift")
public class ScheduleShift {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 班次名字
     */
    private String name;

    /**
     * 状态  0:启用   1 未启用
     */
    private String status;

    /**
     * 起始日期_1
     */
    @Column(name = "begin_date_1")
    private String beginDate1;

    /**
     * 结束日期_1
     */
    @Column(name = "end_date_1")
    private String endDate1;

    /**
     * 起始日期_2
     */
    @Column(name = "begin_date_2")
    private String beginDate2;

    /**
     * 结束日期_2
     */
    @Column(name = "end_date_2")
    private String endDate2;

    /**
     * 时长
     */
    @Column(name = "hour_count")
    private Integer hourCount;

    /**
     * 颜色
     */
    private String color;

    /**
     * 备注
     */
    private String remark;

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
     * 班次类型：0当天，1跨天
     */
    @Column(name = "date_type_1")
    private String dateType1;

    /**
     * 班次类型：0当天，班次类型：0当天，1跨天
     */
    @Column(name = "date_type_2")
    private String dateType2;

    /**
     * 租户
     */
    private String master;

    /**
     * 班次类型：0启用，1休息
     */
    private String type;

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
     * 获取班次名字
     *
     * @return name - 班次名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置班次名字
     *
     * @param name 班次名字
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
     * 获取起始日期_1
     *
     * @return begin_date_1 - 起始日期_1
     */
    public String getBeginDate1() {
        return beginDate1;
    }

    /**
     * 设置起始日期_1
     *
     * @param beginDate1 起始日期_1
     */
    public void setBeginDate1(String beginDate1) {
        this.beginDate1 = beginDate1;
    }

    /**
     * 获取结束日期_1
     *
     * @return end_date_1 - 结束日期_1
     */
    public String getEndDate1() {
        return endDate1;
    }

    /**
     * 设置结束日期_1
     *
     * @param endDate1 结束日期_1
     */
    public void setEndDate1(String endDate1) {
        this.endDate1 = endDate1;
    }

    /**
     * 获取起始日期_2
     *
     * @return begin_date_2 - 起始日期_2
     */
    public String getBeginDate2() {
        return beginDate2;
    }

    /**
     * 设置起始日期_2
     *
     * @param beginDate2 起始日期_2
     */
    public void setBeginDate2(String beginDate2) {
        this.beginDate2 = beginDate2;
    }

    /**
     * 获取结束日期_2
     *
     * @return end_date_2 - 结束日期_2
     */
    public String getEndDate2() {
        return endDate2;
    }

    /**
     * 设置结束日期_2
     *
     * @param endDate2 结束日期_2
     */
    public void setEndDate2(String endDate2) {
        this.endDate2 = endDate2;
    }

    /**
     * 获取时长
     *
     * @return hour_count - 时长
     */
    public Integer getHourCount() {
        return hourCount;
    }

    /**
     * 设置时长
     *
     * @param hourCount 时长
     */
    public void setHourCount(Integer hourCount) {
        this.hourCount = hourCount;
    }

    /**
     * 获取颜色
     *
     * @return color - 颜色
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置颜色
     *
     * @param color 颜色
     */
    public void setColor(String color) {
        this.color = color;
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
     * 获取班次类型：0当天，1跨天
     *
     * @return date_type_1 - 班次类型：0当天，1跨天
     */
    public String getDateType1() {
        return dateType1;
    }

    /**
     * 设置班次类型：0当天，1跨天
     *
     * @param dateType1 班次类型：0当天，1跨天
     */
    public void setDateType1(String dateType1) {
        this.dateType1 = dateType1;
    }

    /**
     * 获取班次类型：0当天，班次类型：0当天，1跨天
     *
     * @return date_type_2 - 班次类型：0当天，班次类型：0当天，1跨天
     */
    public String getDateType2() {
        return dateType2;
    }

    /**
     * 设置班次类型：0当天，班次类型：0当天，1跨天
     *
     * @param dateType2 班次类型：0当天，班次类型：0当天，1跨天
     */
    public void setDateType2(String dateType2) {
        this.dateType2 = dateType2;
    }

    /**
     * 获取租户
     *
     * @return master - 租户
     */
    public String getMaster() {
        return master;
    }

    /**
     * 设置租户
     *
     * @param master 租户
     */
    public void setMaster(String master) {
        this.master = master;
    }

    /**
     * 获取班次类型：0启用，1休息
     *
     * @return type - 班次类型：0启用，1休息
     */
    public String getType() {
        return type;
    }

    /**
     * 设置班次类型：0启用，1休息
     *
     * @param type 班次类型：0启用，1休息
     */
    public void setType(String type) {
        this.type = type;
    }
}