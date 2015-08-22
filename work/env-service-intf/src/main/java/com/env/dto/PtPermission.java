/**
 * Description: PtPermission数据库实体/领域对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:51
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
 * PtPermission数据库实体/领域对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class PtPermission extends DomainObject{
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
//	private java.lang.Long id;
	
	/**
	 * permissionCode
	 */
	//@Length(max=50)
	private java.lang.String permissionCode;
	
	/**
	 * permissionName
	 */
	//@Length(max=50)
	private java.lang.String permissionName;
	
	/**
	 * permissionSequence
	 */
	//
	private java.lang.Long permissionSequence;
	
	/**
	 * resource
	 */
	//@Length(max=500)
	private java.lang.String resource;
	
	/**
	 * appId
	 */
	//@NotNull 
	private java.lang.Long appId;
	
	/**
	 * parentId
	 */
	//
	private java.lang.Long parentId;
	
	/**
	 * type
	 */
	//
	private java.lang.Boolean type;
	
	/**
	 * 记录版本号，每次修改递增1
	 */
	//@NotNull 
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
	public PtPermission(){
	}

	public PtPermission(
		java.lang.Long id
	){
		this.id = id;
	}

    */

	/**
	 * 设置permissionCode
	 * @param permissionCode permissionCode
	 */
	public void setPermissionCode(java.lang.String permissionCode) {
		this.permissionCode = permissionCode;
	}

	/**
	 * 获取permissionCode
	 * @return permissionCode
	 */
	public java.lang.String getPermissionCode() {
		return this.permissionCode;
	}

	/**
	 * 设置permissionName
	 * @param permissionName permissionName
	 */
	public void setPermissionName(java.lang.String permissionName) {
		this.permissionName = permissionName;
	}

	/**
	 * 获取permissionName
	 * @return permissionName
	 */
	public java.lang.String getPermissionName() {
		return this.permissionName;
	}

	/**
	 * 设置permissionSequence
	 * @param permissionSequence permissionSequence
	 */
	public void setPermissionSequence(java.lang.Long permissionSequence) {
		this.permissionSequence = permissionSequence;
	}

	/**
	 * 获取permissionSequence
	 * @return permissionSequence
	 */
	public java.lang.Long getPermissionSequence() {
		return this.permissionSequence;
	}

	/**
	 * 设置resource
	 * @param resource resource
	 */
	public void setResource(java.lang.String resource) {
		this.resource = resource;
	}

	/**
	 * 获取resource
	 * @return resource
	 */
	public java.lang.String getResource() {
		return this.resource;
	}

	/**
	 * 设置appId
	 * @param appId appId
	 */
	public void setAppId(java.lang.Long appId) {
		this.appId = appId;
	}

	/**
	 * 获取appId
	 * @return appId
	 */
	public java.lang.Long getAppId() {
		return this.appId;
	}

	/**
	 * 设置parentId
	 * @param parentId parentId
	 */
	public void setParentId(java.lang.Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取parentId
	 * @return parentId
	 */
	public java.lang.Long getParentId() {
		return this.parentId;
	}

	/**
	 * 设置type
	 * @param type type
	 */
	public void setType(java.lang.Boolean type) {
		this.type = type;
	}

	/**
	 * 获取type
	 * @return type
	 */
	public java.lang.Boolean getType() {
		return this.type;
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
			.append("PermissionCode",getPermissionCode())
			.append("PermissionName",getPermissionName())
			.append("PermissionSequence",getPermissionSequence())
			.append("Resource",getResource())
			.append("AppId",getAppId())
			.append("ParentId",getParentId())
			.append("Type",getType())
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
		if(obj instanceof PtPermission == false) return false;
		if(this == obj) return true;
//		PtPermissionEntity other = (PtPermissionEntity)obj;
		PtPermission other = (PtPermission)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

