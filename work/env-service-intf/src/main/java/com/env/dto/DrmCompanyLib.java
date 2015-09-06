/**
 * Description: 公司库，搜索使用数据库实体/领域对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:47
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
 * 公司库，搜索使用数据库实体/领域对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class DrmCompanyLib extends DomainObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	/**
	 * id
	 */
	//
	private java.lang.Integer id;
	
	/**
	 * 公司全称
	 */
	//@Length(max=200)
	private java.lang.String companyName;
	
	/**
	 * 公司简称
	 */
	//@Length(max=100)
	private java.lang.String companyShotname;
	
	/**
	 * 公司门户网址
	 */
	//@Length(max=500)
	private java.lang.String website;
	
	/**
	 * 公司规模
	 */
	//@Length(max=50)
	private java.lang.String employeeSum;
	
	/**
	 * 公司所在城市
	 */
	//@Length(max=100)
	private java.lang.String city;
	
	/**
	 * 公司创建时间
	 */
	//
	private java.util.Date establishDate;
	
	/**
	 * 公司简介
	 */
	//@Length(max=4000)
	private java.lang.String introduction;
	
	/**
	 * 专长领域
	 */
	//@Length(max=2000)
	private java.lang.String fields;
	
	/**
	 * 已收录的员工数
	 */
	//
	private java.lang.Integer contactUsernum;
	
	/**
	 * remark
	 */
	//@Length(max=500)
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
	public DrmCompanyLib(){
	}

	public DrmCompanyLib(
		java.lang.Integer id
	){
		this.id = id;
	}

    */

	/**
	 * 设置id
	 * @param id id
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	/**
	 * 获取id
	 * @return id
	 */
	public java.lang.Integer getId() {
		return this.id;
	}

	/**
	 * 设置公司全称
	 * @param companyName 公司全称
	 */
	public void setCompanyName(java.lang.String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 获取公司全称
	 * @return 公司全称
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
	 * 设置公司门户网址
	 * @param website 公司门户网址
	 */
	public void setWebsite(java.lang.String website) {
		this.website = website;
	}

	/**
	 * 获取公司门户网址
	 * @return 公司门户网址
	 */
	public java.lang.String getWebsite() {
		return this.website;
	}

	/**
	 * 设置公司规模
	 * @param employeeSum 公司规模
	 */
	public void setEmployeeSum(java.lang.String employeeSum) {
		this.employeeSum = employeeSum;
	}

	/**
	 * 获取公司规模
	 * @return 公司规模
	 */
	public java.lang.String getEmployeeSum() {
		return this.employeeSum;
	}

	/**
	 * 设置公司所在城市
	 * @param city 公司所在城市
	 */
	public void setCity(java.lang.String city) {
		this.city = city;
	}

	/**
	 * 获取公司所在城市
	 * @return 公司所在城市
	 */
	public java.lang.String getCity() {
		return this.city;
	}

	/**
	 * 设置公司创建时间
	 * @param establishDate 公司创建时间
	 */
	public void setEstablishDate(java.util.Date establishDate) {
		this.establishDate = establishDate;
	}

	/**
	 * 设置公司创建时间字符串格式
	 * @param establishDate 公司创建时间
	 */
	public void setEstablishDateStr(String establishDate) {
		if (!org.apache.commons.lang.StringUtils.isBlank(establishDate)) {
			try {
				this.establishDate = java.text.DateFormat.getDateTimeInstance().parse(establishDate);
			} catch (java.text.ParseException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 获取公司创建时间
	 * @return 公司创建时间
	 */
	public java.util.Date getEstablishDate() {
		return this.establishDate;
	}

	/**
	 * 设置公司简介
	 * @param introduction 公司简介
	 */
	public void setIntroduction(java.lang.String introduction) {
		this.introduction = introduction;
	}

	/**
	 * 获取公司简介
	 * @return 公司简介
	 */
	public java.lang.String getIntroduction() {
		return this.introduction;
	}

	/**
	 * 设置专长领域
	 * @param fields 专长领域
	 */
	public void setFields(java.lang.String fields) {
		this.fields = fields;
	}

	/**
	 * 获取专长领域
	 * @return 专长领域
	 */
	public java.lang.String getFields() {
		return this.fields;
	}

	/**
	 * 设置已收录的员工数
	 * @param contactUsernum 已收录的员工数
	 */
	public void setContactUsernum(java.lang.Integer contactUsernum) {
		this.contactUsernum = contactUsernum;
	}

	/**
	 * 获取已收录的员工数
	 * @return 已收录的员工数
	 */
	public java.lang.Integer getContactUsernum() {
		return this.contactUsernum;
	}

	/**
	 * 设置remark
	 * @param remark remark
	 */
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	/**
	 * 获取remark
	 * @return remark
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
			.append("CompanyName",getCompanyName())
			.append("CompanyShotname",getCompanyShotname())
			.append("Website",getWebsite())
			.append("EmployeeSum",getEmployeeSum())
			.append("City",getCity())
			.append("EstablishDate",getEstablishDate())
			.append("Introduction",getIntroduction())
			.append("Fields",getFields())
			.append("ContactUsernum",getContactUsernum())
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
		if(obj instanceof DrmCompanyLib == false) return false;
		if(this == obj) return true;
//		DrmCompanyLibEntity other = (DrmCompanyLibEntity)obj;
		DrmCompanyLib other = (DrmCompanyLib)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

