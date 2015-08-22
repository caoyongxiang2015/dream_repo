/**
 * Description: 用户注册的公司信息数据库实体/领域对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:46
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-21   caoyx   1.0         Initial
 */
package com.env.dto;

//import javax.validation.constraints.*;
//import org.hibernate.validator.constraints.*;
import com.env.core.domain.DomainObject;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 用户注册的公司信息数据库实体/领域对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class DrmCompany extends DomainObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	/**
	 * 主键
	 */
	//
	private java.lang.Integer id;
	
	/**
	 * 用户ID
	 */
	//
	private java.lang.Integer userId;
	
	/**
	 * 公司名称
	 */
	//@Length(max=200)
	private java.lang.String companyName;
	
	/**
	 * 公司简称
	 */
	//@Length(max=100)
	private java.lang.String companyShotname;
	
	/**
	 * 部门名称
	 */
	//@Length(max=200)
	private java.lang.String deptName;
	
	/**
	 * 我的岗位名称（预留）
	 */
	//@Length(max=100)
	private java.lang.String postname;
	
	/**
	 * 在职时长
	 */
	//@Length(max=100)
	private java.lang.String jobDuration;
	
	/**
	 * 提供的信息
	 */
	//@Length(max=4000)
	private java.lang.String provideContent;
	
	/**
	 * 公司信息字数统计（预留）
	 */
	//
	private java.lang.Integer wordCount;
	
	/**
	 * 是否提供QQ方式（预留）
	 */
	//
	private java.lang.Integer qq;
	
	/**
	 * 是否提供weixin方式（预留）
	 */
	//
	private java.lang.Integer weixin;
	
	/**
	 * 是否提供电话方式（预留）
	 */
	//
	private java.lang.Integer phone;
	
	/**
	 * 是否提供email方式（预留）
	 */
	//@Email
	private java.lang.Integer email;
	
	/**
	 * 是否提供站内信方式（预留）
	 */
	//
	private java.lang.Integer zhanneixin;
	
	/**
	 * 直接在平台展示（预留）
	 */
	//
	private java.lang.Integer ptshow;
	
	/**
	 * 标价
	 */
	//
	private Long price;
	
	/**
	 * 线下服务价格（预留）
	 */
	//
	private Long faceprice;
	
	/**
	 * 备注信息
	 */
	//@Length(max=4000)
	private java.lang.String remark;
	
	/**
	 * 版本号
	 */
	//
	private java.lang.Integer version;
	
	/**
	 * 逻辑删除标志，1删除0可用
	 */
	//
	private java.lang.Integer disabled;
	
	/**
	 * 创建者ID
	 */
	//
	private java.lang.Integer createUserid;
	
	/**
	 * 创建时间
	 */
	//
	private java.util.Date createTime;
	
	/**
	 * 修改者id
	 */
	//
	private java.lang.Integer updateUserid;
	
	/**
	 * 修改时间
	 */
	//
	private java.util.Date updateTime;
	
	//columns END
	/*
	public DrmCompany(){
	}

	public DrmCompany(
		java.lang.Integer id
	){
		this.id = id;
	}

    */

	/**
	 * 设置主键
	 * @param id 主键
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	/**
	 * 获取主键
	 * @return 主键
	 */
	public java.lang.Integer getId() {
		return this.id;
	}

	/**
	 * 设置用户ID
	 * @param userId 用户ID
	 */
	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	/**
	 * 获取用户ID
	 * @return 用户ID
	 */
	public java.lang.Integer getUserId() {
		return this.userId;
	}

	/**
	 * 设置公司名称
	 * @param companyName 公司名称
	 */
	public void setCompanyName(java.lang.String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 获取公司名称
	 * @return 公司名称
	 */
	public java.lang.String getCompanyName() {
		return this.companyName;
	}

	/**
	 * 设置公司简称
	 * @param companyShotname 公司简称
	 */
	public void setCompanyShotname(java.lang.String companyShotname) {
		this.companyShotname = companyShotname;
	}

	/**
	 * 获取公司简称
	 * @return 公司简称
	 */
	public java.lang.String getCompanyShotname() {
		return this.companyShotname;
	}

	/**
	 * 设置部门名称
	 * @param deptName 部门名称
	 */
	public void setDeptName(java.lang.String deptName) {
		this.deptName = deptName;
	}

	/**
	 * 获取部门名称
	 * @return 部门名称
	 */
	public java.lang.String getDeptName() {
		return this.deptName;
	}

	/**
	 * 设置我的岗位名称（预留）
	 * @param postname 我的岗位名称（预留）
	 */
	public void setPostname(java.lang.String postname) {
		this.postname = postname;
	}

	/**
	 * 获取我的岗位名称（预留）
	 * @return 我的岗位名称（预留）
	 */
	public java.lang.String getPostname() {
		return this.postname;
	}

	/**
	 * 设置在职时长
	 * @param jobDuration 在职时长
	 */
	public void setJobDuration(java.lang.String jobDuration) {
		this.jobDuration = jobDuration;
	}

	/**
	 * 获取在职时长
	 * @return 在职时长
	 */
	public java.lang.String getJobDuration() {
		return this.jobDuration;
	}

	/**
	 * 设置提供的信息
	 * @param provideContent 提供的信息
	 */
	public void setProvideContent(java.lang.String provideContent) {
		this.provideContent = provideContent;
	}

	/**
	 * 获取提供的信息
	 * @return 提供的信息
	 */
	public java.lang.String getProvideContent() {
		return this.provideContent;
	}

	/**
	 * 设置公司信息字数统计（预留）
	 * @param wordCount 公司信息字数统计（预留）
	 */
	public void setWordCount(java.lang.Integer wordCount) {
		this.wordCount = wordCount;
	}

	/**
	 * 获取公司信息字数统计（预留）
	 * @return 公司信息字数统计（预留）
	 */
	public java.lang.Integer getWordCount() {
		return this.wordCount;
	}

	/**
	 * 设置是否提供QQ方式（预留）
	 * @param qq 是否提供QQ方式（预留）
	 */
	public void setQq(java.lang.Integer qq) {
		this.qq = qq;
	}

	/**
	 * 获取是否提供QQ方式（预留）
	 * @return 是否提供QQ方式（预留）
	 */
	public java.lang.Integer getQq() {
		return this.qq;
	}

	/**
	 * 设置是否提供weixin方式（预留）
	 * @param weixin 是否提供weixin方式（预留）
	 */
	public void setWeixin(java.lang.Integer weixin) {
		this.weixin = weixin;
	}

	/**
	 * 获取是否提供weixin方式（预留）
	 * @return 是否提供weixin方式（预留）
	 */
	public java.lang.Integer getWeixin() {
		return this.weixin;
	}

	/**
	 * 设置是否提供电话方式（预留）
	 * @param phone 是否提供电话方式（预留）
	 */
	public void setPhone(java.lang.Integer phone) {
		this.phone = phone;
	}

	/**
	 * 获取是否提供电话方式（预留）
	 * @return 是否提供电话方式（预留）
	 */
	public java.lang.Integer getPhone() {
		return this.phone;
	}

	/**
	 * 设置是否提供email方式（预留）
	 * @param email 是否提供email方式（预留）
	 */
	public void setEmail(java.lang.Integer email) {
		this.email = email;
	}

	/**
	 * 获取是否提供email方式（预留）
	 * @return 是否提供email方式（预留）
	 */
	public java.lang.Integer getEmail() {
		return this.email;
	}

	/**
	 * 设置是否提供站内信方式（预留）
	 * @param zhanneixin 是否提供站内信方式（预留）
	 */
	public void setZhanneixin(java.lang.Integer zhanneixin) {
		this.zhanneixin = zhanneixin;
	}

	/**
	 * 获取是否提供站内信方式（预留）
	 * @return 是否提供站内信方式（预留）
	 */
	public java.lang.Integer getZhanneixin() {
		return this.zhanneixin;
	}

	/**
	 * 设置直接在平台展示（预留）
	 * @param ptshow 直接在平台展示（预留）
	 */
	public void setPtshow(java.lang.Integer ptshow) {
		this.ptshow = ptshow;
	}

	/**
	 * 获取直接在平台展示（预留）
	 * @return 直接在平台展示（预留）
	 */
	public java.lang.Integer getPtshow() {
		return this.ptshow;
	}

	/**
	 * 设置标价
	 * @param price 标价
	 */
	public void setPrice(Long price) {
		this.price = price;
	}

	/**
	 * 获取标价
	 * @return 标价
	 */
	public Long getPrice() {
		return this.price;
	}

	/**
	 * 设置线下服务价格（预留）
	 * @param faceprice 线下服务价格（预留）
	 */
	public void setFaceprice(Long faceprice) {
		this.faceprice = faceprice;
	}

	/**
	 * 获取线下服务价格（预留）
	 * @return 线下服务价格（预留）
	 */
	public Long getFaceprice() {
		return this.faceprice;
	}

	/**
	 * 设置备注信息
	 * @param remark 备注信息
	 */
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	/**
	 * 获取备注信息
	 * @return 备注信息
	 */
	public java.lang.String getRemark() {
		return this.remark;
	}

	/**
	 * 设置版本号
	 * @param version 版本号
	 */
	public void setVersion(java.lang.Integer version) {
		this.version = version;
	}

	/**
	 * 获取版本号
	 * @return 版本号
	 */
	public java.lang.Integer getVersion() {
		return this.version;
	}

	/**
	 * 设置逻辑删除标志，1删除0可用
	 * @param disabled 逻辑删除标志，1删除0可用
	 */
	public void setDisabled(java.lang.Integer disabled) {
		this.disabled = disabled;
	}

	/**
	 * 获取逻辑删除标志，1删除0可用
	 * @return 逻辑删除标志，1删除0可用
	 */
	public java.lang.Integer getDisabled() {
		return this.disabled;
	}

	/**
	 * 设置创建者ID
	 * @param createUserid 创建者ID
	 */
	public void setCreateUserid(java.lang.Integer createUserid) {
		this.createUserid = createUserid;
	}

	/**
	 * 获取创建者ID
	 * @return 创建者ID
	 */
	public java.lang.Integer getCreateUserid() {
		return this.createUserid;
	}

	/**
	 * 设置创建时间
	 * @param createTime 创建时间
	 */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 设置创建时间字符串格式
	 * @param createTime 创建时间
	 */
	public void setCreateTimeStr(String createTime) {
		if (!org.apache.commons.lang.StringUtils.isBlank(createTime)) {
			try {
				this.createTime = java.text.DateFormat.getDateTimeInstance().parse(createTime);
			} catch (java.text.ParseException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 获取创建时间
	 * @return 创建时间
	 */
	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * 设置修改者id
	 * @param updateUserid 修改者id
	 */
	public void setUpdateUserid(java.lang.Integer updateUserid) {
		this.updateUserid = updateUserid;
	}

	/**
	 * 获取修改者id
	 * @return 修改者id
	 */
	public java.lang.Integer getUpdateUserid() {
		return this.updateUserid;
	}

	/**
	 * 设置修改时间
	 * @param updateTime 修改时间
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 设置修改时间字符串格式
	 * @param updateTime 修改时间
	 */
	public void setUpdateTimeStr(String updateTime) {
		if (!org.apache.commons.lang.StringUtils.isBlank(updateTime)) {
			try {
				this.updateTime = java.text.DateFormat.getDateTimeInstance().parse(updateTime);
			} catch (java.text.ParseException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 获取修改时间
	 * @return 修改时间
	 */
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}

    /**
     * 实体的toString方法
     * @return 实体字符串
     */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("UserId",getUserId())
			.append("CompanyName",getCompanyName())
			.append("CompanyShotname",getCompanyShotname())
			.append("DeptName",getDeptName())
			.append("Postname",getPostname())
			.append("JobDuration",getJobDuration())
			.append("ProvideContent",getProvideContent())
			.append("WordCount",getWordCount())
			.append("Qq",getQq())
			.append("Weixin",getWeixin())
			.append("Phone",getPhone())
			.append("Email",getEmail())
			.append("Zhanneixin",getZhanneixin())
			.append("Ptshow",getPtshow())
			.append("Price",getPrice())
			.append("Faceprice",getFaceprice())
			.append("Remark",getRemark())
			.append("Version",getVersion())
			.append("Disabled",getDisabled())
			.append("CreateUserid",getCreateUserid())
			.append("CreateTime",getCreateTime())
			.append("UpdateUserid",getUpdateUserid())
			.append("UpdateTime",getUpdateTime())
			.toString();
	}

	/**
	 * 获取hash码
	 * @return HASH码
	 */
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}

	/**
	 * 对象比较
	 * @param obj 待比较对象
	 * @return 是否相同<li>true--相同<li>false--不相同
	 */
	public boolean equals(Object obj) {
		if(obj instanceof DrmCompany == false) return false;
		if(this == obj) return true;
//		DrmCompanyEntity other = (DrmCompanyEntity)obj;
		DrmCompany other = (DrmCompany)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

