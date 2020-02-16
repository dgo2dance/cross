package com.will.cross.dto;

import javax.persistence.*;
import java.util.Date;

@Table(name = "schedule_person_org_relate")
public class SchedulePersonOrgRelateDTO {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 编号
     */
    @Column(name = "person_id")
    private String personId;

    /**
     * 编号
     */
    @Column(name = "org_id")
    private String orgId;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    /**
     * 状态  0:启用   1 未启用
     */
    private String status;

    /**
     * 状态  0:是   1 否
     */
    @Column(name = "is_admin")
    private String isAdmin;

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
     * 电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String mail;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * 类型 0：参与排班 1不参与排班
     */
    private String type;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 名字
     */
    private String name;


    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getCurrentUserFlag() {
        return currentUserFlag;
    }

    public void setCurrentUserFlag(String currentUserFlag) {
        this.currentUserFlag = currentUserFlag;
    }

    /**
     * openid
     */
    private String openid;

    /*
    * 是否为当前用户表示
     */
    private String currentUserFlag;




    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


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
     * 人员姓名
     */
    @Column(name = "person_name")
    private String personName;

    /**
     * 组织名称
     */
    @Column(name = "org_name")
    private String orgName;

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
     * 获取编号
     *
     * @return person_id - 编号
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * 设置编号
     *
     * @param personId 编号
     */
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    /**
     * 获取编号
     *
     * @return org_id - 编号
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 设置编号
     *
     * @param orgId 编号
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
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
     * 获取状态  0:是   1 否
     *
     * @return is_admin - 状态  0:是   1 否
     */
    public String getIsAdmin() {
        return isAdmin;
    }

    /**
     * 设置状态  0:是   1 否
     *
     * @param isAdmin 状态  0:是   1 否
     */
    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
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
     * 获取人员姓名
     *
     * @return person_name - 人员姓名
     */
    public String getPersonName() {
        return personName;
    }

    /**
     * 设置人员姓名
     *
     * @param personName 人员姓名
     */
    public void setPersonName(String personName) {
        this.personName = personName;
    }

    /**
     * 获取组织名称
     *
     * @return org_name - 组织名称
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置组织名称
     *
     * @param orgName 组织名称
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }




}