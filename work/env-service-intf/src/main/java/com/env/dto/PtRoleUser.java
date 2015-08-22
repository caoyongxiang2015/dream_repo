/**
 * Description: PtRoleUser数据库实体/领域对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:52
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
 * PtRoleUser数据库实体/领域对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class PtRoleUser extends DomainObject{
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
	 * userId
	 */
	//
	private java.lang.Integer userId;
	
	/**
	 * roleId
	 */
	//
	private java.lang.Integer roleId;
	
	//columns END
	/*
	public PtRoleUser(){
	}

	public PtRoleUser(
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
	 * 设置userId
	 * @param userId userId
	 */
	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	/**
	 * 获取userId
	 * @return userId
	 */
	public java.lang.Integer getUserId() {
		return this.userId;
	}

	/**
	 * 设置roleId
	 * @param roleId roleId
	 */
	public void setRoleId(java.lang.Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * 获取roleId
	 * @return roleId
	 */
	public java.lang.Integer getRoleId() {
		return this.roleId;
	}

    /**
     * 实体的toString方法
     * @return 实体字符串
     */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("UserId",getUserId())
			.append("RoleId",getRoleId())
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
		if(obj instanceof PtRoleUser == false) return false;
		if(this == obj) return true;
//		PtRoleUserEntity other = (PtRoleUserEntity)obj;
		PtRoleUser other = (PtRoleUser)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

