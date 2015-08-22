/**
 * Description: 给哪些用户发需求通知，我接收到的需求数据库实体/领域对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:50
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
 * 给哪些用户发需求通知，我接收到的需求数据库实体/领域对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class DrmReqNotice extends DomainObject{
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
	 * drm_req表的注解
	 */
	//
	private java.lang.Integer reqId;
	
	/**
	 * 发布需求的用户id
	 */
	//
	private java.lang.Integer sendUserId;
	
	/**
	 * 匹配到需求的用户id
	 */
	//
	private java.lang.Integer receiveUserId;
	
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
	 * 创建时间(需求发布时间）
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
	public DrmReqNotice(){
	}

	public DrmReqNotice(
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
	 * 设置drm_req表的注解
	 * @param reqId drm_req表的注解
	 */
	public void setReqId(java.lang.Integer reqId) {
		this.reqId = reqId;
	}

	/**
	 * 获取drm_req表的注解
	 * @return drm_req表的注解
	 */
	public java.lang.Integer getReqId() {
		return this.reqId;
	}

	/**
	 * 设置发布需求的用户id
	 * @param sendUserId 发布需求的用户id
	 */
	public void setSendUserId(java.lang.Integer sendUserId) {
		this.sendUserId = sendUserId;
	}

	/**
	 * 获取发布需求的用户id
	 * @return 发布需求的用户id
	 */
	public java.lang.Integer getSendUserId() {
		return this.sendUserId;
	}

	/**
	 * 设置匹配到需求的用户id
	 * @param receiveUserId 匹配到需求的用户id
	 */
	public void setReceiveUserId(java.lang.Integer receiveUserId) {
		this.receiveUserId = receiveUserId;
	}

	/**
	 * 获取匹配到需求的用户id
	 * @return 匹配到需求的用户id
	 */
	public java.lang.Integer getReceiveUserId() {
		return this.receiveUserId;
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
	 * 设置创建时间(需求发布时间）
	 * @param createTime 创建时间(需求发布时间）
	 */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 设置创建时间(需求发布时间）字符串格式
	 * @param createTime 创建时间(需求发布时间）
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
	 * 获取创建时间(需求发布时间）
	 * @return 创建时间(需求发布时间）
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
			.append("ReqId",getReqId())
			.append("SendUserId",getSendUserId())
			.append("ReceiveUserId",getReceiveUserId())
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
		if(obj instanceof DrmReqNotice == false) return false;
		if(this == obj) return true;
//		DrmReqNoticeEntity other = (DrmReqNoticeEntity)obj;
		DrmReqNotice other = (DrmReqNotice)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

