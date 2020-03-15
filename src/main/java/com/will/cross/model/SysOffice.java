package com.will.cross.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_office")
public class SysOffice {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 父级编号
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 所有父级编号
     */
    @Column(name = "parent_ids")
    private String parentIds;

    /**
     * 名称
     */
    private String name;

    /**
     * 排序
     */
    private Long sort;

    /**
     * 是否叶子节点
     */
    @Column(name = "tree_leaf")
    private String treeLeaf;

    /**
     * 树形层级
     */
    @Column(name = "tree_level")
    private Integer treeLevel;

    /**
     * 归属区域
     */
    @Column(name = "area_id")
    private String areaId;

    /**
     * 区域编码
     */
    private String code;

    /**
     * 机构类型
     */
    private String type;

    /**
     * 机构等级
     */
    private String grade;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 邮政编码
     */
    @Column(name = "zip_code")
    private String zipCode;

    /**
     * 负责人
     */
    private String master;

    /**
     * 电话
     */
    private String phone;

    /**
     * 传真
     */
    private String fax;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 是否启用
     */
    @Column(name = "USEABLE")
    private String useable;

    /**
     * 主负责人
     */
    @Column(name = "PRIMARY_PERSON")
    private String primaryPerson;

    /**
     * 副负责人
     */
    @Column(name = "DEPUTY_PERSON")
    private String deputyPerson;

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
     * 备注信息
     */
    private String remarks;

    /**
     * 删除标记
     */
    @Column(name = "del_flag")
    private String delFlag;

    /**
     * 0 使用  1未使用
     */
    private String status;

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
     * 获取父级编号
     *
     * @return parent_id - 父级编号
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父级编号
     *
     * @param parentId 父级编号
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取所有父级编号
     *
     * @return parent_ids - 所有父级编号
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * 设置所有父级编号
     *
     * @param parentIds 所有父级编号
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Long getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Long sort) {
        this.sort = sort;
    }

    /**
     * 获取是否叶子节点
     *
     * @return tree_leaf - 是否叶子节点
     */
    public String getTreeLeaf() {
        return treeLeaf;
    }

    /**
     * 设置是否叶子节点
     *
     * @param treeLeaf 是否叶子节点
     */
    public void setTreeLeaf(String treeLeaf) {
        this.treeLeaf = treeLeaf;
    }

    /**
     * 获取树形层级
     *
     * @return tree_level - 树形层级
     */
    public Integer getTreeLevel() {
        return treeLevel;
    }

    /**
     * 设置树形层级
     *
     * @param treeLevel 树形层级
     */
    public void setTreeLevel(Integer treeLevel) {
        this.treeLevel = treeLevel;
    }

    /**
     * 获取归属区域
     *
     * @return area_id - 归属区域
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * 设置归属区域
     *
     * @param areaId 归属区域
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取区域编码
     *
     * @return code - 区域编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置区域编码
     *
     * @param code 区域编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取机构类型
     *
     * @return type - 机构类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置机构类型
     *
     * @param type 机构类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取机构等级
     *
     * @return grade - 机构等级
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 设置机构等级
     *
     * @param grade 机构等级
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * 获取联系地址
     *
     * @return address - 联系地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置联系地址
     *
     * @param address 联系地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取邮政编码
     *
     * @return zip_code - 邮政编码
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 设置邮政编码
     *
     * @param zipCode 邮政编码
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * 获取负责人
     *
     * @return master - 负责人
     */
    public String getMaster() {
        return master;
    }

    /**
     * 设置负责人
     *
     * @param master 负责人
     */
    public void setMaster(String master) {
        this.master = master;
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取传真
     *
     * @return fax - 传真
     */
    public String getFax() {
        return fax;
    }

    /**
     * 设置传真
     *
     * @param fax 传真
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取是否启用
     *
     * @return USEABLE - 是否启用
     */
    public String getUseable() {
        return useable;
    }

    /**
     * 设置是否启用
     *
     * @param useable 是否启用
     */
    public void setUseable(String useable) {
        this.useable = useable;
    }

    /**
     * 获取主负责人
     *
     * @return PRIMARY_PERSON - 主负责人
     */
    public String getPrimaryPerson() {
        return primaryPerson;
    }

    /**
     * 设置主负责人
     *
     * @param primaryPerson 主负责人
     */
    public void setPrimaryPerson(String primaryPerson) {
        this.primaryPerson = primaryPerson;
    }

    /**
     * 获取副负责人
     *
     * @return DEPUTY_PERSON - 副负责人
     */
    public String getDeputyPerson() {
        return deputyPerson;
    }

    /**
     * 设置副负责人
     *
     * @param deputyPerson 副负责人
     */
    public void setDeputyPerson(String deputyPerson) {
        this.deputyPerson = deputyPerson;
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

    /**
     * 获取0 使用  1未使用
     *
     * @return status - 0 使用  1未使用
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置0 使用  1未使用
     *
     * @param status 0 使用  1未使用
     */
    public void setStatus(String status) {
        this.status = status;
    }
}