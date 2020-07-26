package com.will.cross.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 归属公司
     */
    @Column(name = "company_id")
    private String companyId;

    /**
     * 归属部门
     */
    @Column(name = "office_id")
    private String officeId;

    /**
     * 登录名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 工号
     */
    private String no;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 用户类型
     */
    @Column(name = "user_type")
    private String userType;

    /**
     * 用户头像
     */
    private String photo;

    /**
     * 最后登陆IP
     */
    @Column(name = "login_ip")
    private String loginIp;

    /**
     * 最后登陆时间
     */
    @Column(name = "login_date")
    private Date loginDate;

    /**
     * 是否可登录
     */
    @Column(name = "login_flag")
    private String loginFlag;

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
     * openid
     */
    @Column(name = "openId")
    private String openid;

    @Column(name = "nickName")
    private String nickname;

    private String gender;

    private String language;

    private String city;

    private String province;

    private String country;

    @Column(name = "avatarUrl")
    private String avatarurl;

    @Column(name = "locationId")
    private String locationid;

    @Column(name = "locationName")
    private String locationname;

    /**
     * 0管理员 1一般员工
     */
    private String role;

    /**
     * 07/24  1每周最多工作24小时
     */
    private String stress;

    /**
     * 技能
     */
    private String skill;

    /**
     * 紧急联系方式
     */
    private String concact;

    /**
     * 紧急联系人
     */
    @Column(name = "concactPerson")
    private String concactperson;

    /**
     * 0 按小时 1 按天 2固定
     */
    private String paytype;

    /**
     * 支付额度
     */
    private Float pay;

    /**
     * 聘任起始时间
     */
    @Column(name = "otherBegin")
    private Date otherbegin;

    /**
     * 描述
     */
    @Column(name = "descRemark")
    private String descremark;

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
     * 获取归属公司
     *
     * @return company_id - 归属公司
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * 设置归属公司
     *
     * @param companyId 归属公司
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取归属部门
     *
     * @return office_id - 归属部门
     */
    public String getOfficeId() {
        return officeId;
    }

    /**
     * 设置归属部门
     *
     * @param officeId 归属部门
     */
    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    /**
     * 获取登录名
     *
     * @return login_name - 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登录名
     *
     * @param loginName 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取工号
     *
     * @return no - 工号
     */
    public String getNo() {
        return no;
    }

    /**
     * 设置工号
     *
     * @param no 工号
     */
    public void setNo(String no) {
        this.no = no;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
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
     * 获取手机
     *
     * @return mobile - 手机
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机
     *
     * @param mobile 手机
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取用户类型
     *
     * @return user_type - 用户类型
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置用户类型
     *
     * @param userType 用户类型
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * 获取用户头像
     *
     * @return photo - 用户头像
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 设置用户头像
     *
     * @param photo 用户头像
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * 获取最后登陆IP
     *
     * @return login_ip - 最后登陆IP
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 设置最后登陆IP
     *
     * @param loginIp 最后登陆IP
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    /**
     * 获取最后登陆时间
     *
     * @return login_date - 最后登陆时间
     */
    public Date getLoginDate() {
        return loginDate;
    }

    /**
     * 设置最后登陆时间
     *
     * @param loginDate 最后登陆时间
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * 获取是否可登录
     *
     * @return login_flag - 是否可登录
     */
    public String getLoginFlag() {
        return loginFlag;
    }

    /**
     * 设置是否可登录
     *
     * @param loginFlag 是否可登录
     */
    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
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
     * 获取openid
     *
     * @return openId - openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置openid
     *
     * @param openid openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * @return nickName
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return avatarUrl
     */
    public String getAvatarurl() {
        return avatarurl;
    }

    /**
     * @param avatarurl
     */
    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    /**
     * @return locationId
     */
    public String getLocationid() {
        return locationid;
    }

    /**
     * @param locationid
     */
    public void setLocationid(String locationid) {
        this.locationid = locationid;
    }

    /**
     * @return locationName
     */
    public String getLocationname() {
        return locationname;
    }

    /**
     * @param locationname
     */
    public void setLocationname(String locationname) {
        this.locationname = locationname;
    }

    /**
     * 获取0管理员 1一般员工
     *
     * @return role - 0管理员 1一般员工
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置0管理员 1一般员工
     *
     * @param role 0管理员 1一般员工
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * 获取07/24  1每周最多工作24小时
     *
     * @return stress - 07/24  1每周最多工作24小时
     */
    public String getStress() {
        return stress;
    }

    /**
     * 设置07/24  1每周最多工作24小时
     *
     * @param stress 07/24  1每周最多工作24小时
     */
    public void setStress(String stress) {
        this.stress = stress;
    }

    /**
     * 获取技能
     *
     * @return skill - 技能
     */
    public String getSkill() {
        return skill;
    }

    /**
     * 设置技能
     *
     * @param skill 技能
     */
    public void setSkill(String skill) {
        this.skill = skill;
    }

    /**
     * 获取紧急联系方式
     *
     * @return concact - 紧急联系方式
     */
    public String getConcact() {
        return concact;
    }

    /**
     * 设置紧急联系方式
     *
     * @param concact 紧急联系方式
     */
    public void setConcact(String concact) {
        this.concact = concact;
    }

    /**
     * 获取紧急联系人
     *
     * @return concactPerson - 紧急联系人
     */
    public String getConcactperson() {
        return concactperson;
    }

    /**
     * 设置紧急联系人
     *
     * @param concactperson 紧急联系人
     */
    public void setConcactperson(String concactperson) {
        this.concactperson = concactperson;
    }

    /**
     * 获取0 按小时 1 按天 2固定
     *
     * @return paytype - 0 按小时 1 按天 2固定
     */
    public String getPaytype() {
        return paytype;
    }

    /**
     * 设置0 按小时 1 按天 2固定
     *
     * @param paytype 0 按小时 1 按天 2固定
     */
    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    /**
     * 获取支付额度
     *
     * @return pay - 支付额度
     */
    public Float getPay() {
        return pay;
    }

    /**
     * 设置支付额度
     *
     * @param pay 支付额度
     */
    public void setPay(Float pay) {
        this.pay = pay;
    }

    /**
     * 获取聘任起始时间
     *
     * @return otherBegin - 聘任起始时间
     */
    public Date getOtherbegin() {
        return otherbegin;
    }

    /**
     * 设置聘任起始时间
     *
     * @param otherbegin 聘任起始时间
     */
    public void setOtherbegin(Date otherbegin) {
        this.otherbegin = otherbegin;
    }

    /**
     * 获取描述
     *
     * @return descRemark - 描述
     */
    public String getDescremark() {
        return descremark;
    }

    /**
     * 设置描述
     *
     * @param descremark 描述
     */
    public void setDescremark(String descremark) {
        this.descremark = descremark;
    }
}