/**
 * Description: PtUser数据库实体/领域对象
 * Copyright:   Copyright (c)2015
 * Company:     SUNIVO
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-01-07 上午 11:38:43
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2012-12-21   caoyx   1.0         Initial
 */
package com.env.dto;

//import javax.validation.constraints.*;
//import org.hibernate.validator.constraints.*;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.env.core.domain.DomainObject;

/**
 * PtUser数据库实体/领域对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-01-07
 * @see
 * @since 1.0
 */
public class PtUser extends DomainObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	/**
	 * username
	 */
	//@Length(max=100)
	private java.lang.String username;
	
	/**
	 * companyId
	 */
	//
	private java.lang.Integer companyId;
	
	/**
	 * loginId
	 */
	//@Length(max=100)
	private java.lang.String loginId;
	
	/**
	 * pwd
	 */
	//@Length(max=100)
	private java.lang.String pwd;
	

	private List<PtRole> roles;

	
	/**
	 * 记录版本号，每次修改递增1
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
	 * 修改者ID
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
	public PtUser(){
	}

	public PtUser(
		java.lang.Integer id
	){
		this.id = id;
	}

    */

	/**
	 * 设置username
	 * @param username username
	 */
	public void setUsername(java.lang.String username) {
		this.username = username;
	}

	public List<PtRole> getRoles() {
		return roles;
	}

	public void setRoles(List<PtRole> roles) {
		this.roles = roles;
	}

	/**
	 * 获取username
	 * @return username
	 */
	public java.lang.String getUsername() {
		return this.username;
	}

	/**
	 * 设置companyId
	 * @param companyId companyId
	 */
	public void setCompanyId(java.lang.Integer companyId) {
		this.companyId = companyId;
	}

	/**
	 * 获取companyId
	 * @return companyId
	 */
	public java.lang.Integer getCompanyId() {
		return this.companyId;
	}

	/**
	 * 设置loginId
	 * @param loginId loginId
	 */
	public void setLoginId(java.lang.String loginId) {
		this.loginId = loginId;
	}

	/**
	 * 获取loginId
	 * @return loginId
	 */
	public java.lang.String getLoginId() {
		return this.loginId;
	}

	/**
	 * 设置pwd
	 * @param pwd pwd
	 */
	public void setPwd(java.lang.String pwd) {
		this.pwd = pwd;
	}

	/**
	 * 获取pwd
	 * @return pwd
	 */
	public java.lang.String getPwd() {
		return this.pwd;
	}

	/**
	 * 设置记录版本号，每次修改递增1
	 * @param version 记录版本号，每次修改递增1
	 */
	public void setVersion(java.lang.Integer version) {
		this.version = version;
	}

	/**
	 * 获取记录版本号，每次修改递增1
	 * @return 记录版本号，每次修改递增1
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
	 * 设置修改者ID
	 * @param updateUserid 修改者ID
	 */
	public void setUpdateUserid(java.lang.Integer updateUserid) {
		this.updateUserid = updateUserid;
	}

	/**
	 * 获取修改者ID
	 * @return 修改者ID
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
			.append("Username",getUsername())
			.append("CompanyId",getCompanyId())
			.append("LoginId",getLoginId())
			.append("Pwd",getPwd())
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
		if(obj instanceof PtUser == false) return false;
		if(this == obj) return true;
//		PtUserEntity other = (PtUserEntity)obj;
		PtUser other = (PtUser)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

