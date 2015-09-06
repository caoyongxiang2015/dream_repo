/**
 * Description: 意见反馈数据库实体/领域对象
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
 * 意见反馈数据库实体/领域对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class PtFeedback extends DomainObject{
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
	 * 反馈内容
	 */
	//@Length(max=4000)
	private java.lang.String content;
	
	/**
	 * 反馈者id
	 */
	//
	private java.lang.Integer userId;
	
	/**
	 * 反馈者名称
	 */
	//@Length(max=100)
	private java.lang.String userName;
	
	/**
	 * 称呼（未登录者填写）
	 */
	//@Length(max=100)
	private java.lang.String callerName;
	
	/**
	 * 联系方式
	 */
	//@Length(max=20)
	private java.lang.String contactType;
	
	/**
	 * 提交时间
	 */
	//
	private java.util.Date submitTime;
	
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
	public PtFeedback(){
	}

	public PtFeedback(
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
	 * 设置反馈内容
	 * @param content 反馈内容
	 */
	public void setContent(java.lang.String content) {
		this.content = content;
	}

	/**
	 * 获取反馈内容
	 * @return 反馈内容
	 */
	public java.lang.String getContent() {
		return this.content;
	}

	/**
	 * 设置反馈者id
	 * @param userId 反馈者id
	 */
	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	/**
	 * 获取反馈者id
	 * @return 反馈者id
	 */
	public java.lang.Integer getUserId() {
		return this.userId;
	}

	/**
	 * 设置反馈者名称
	 * @param userName 反馈者名称
	 */
	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}

	/**
	 * 获取反馈者名称
	 * @return 反馈者名称
	 */
	public java.lang.String getUserName() {
		return this.userName;
	}

	/**
	 * 设置称呼（未登录者填写）
	 * @param callerName 称呼（未登录者填写）
	 */
	public void setCallerName(java.lang.String callerName) {
		this.callerName = callerName;
	}

	/**
	 * 获取称呼（未登录者填写）
	 * @return 称呼（未登录者填写）
	 */
	public java.lang.String getCallerName() {
		return this.callerName;
	}

	/**
	 * 设置联系方式
	 * @param contactType 联系方式
	 */
	public void setContactType(java.lang.String contactType) {
		this.contactType = contactType;
	}

	/**
	 * 获取联系方式
	 * @return 联系方式
	 */
	public java.lang.String getContactType() {
		return this.contactType;
	}

	/**
	 * 设置提交时间
	 * @param submitTime 提交时间
	 */
	public void setSubmitTime(java.util.Date submitTime) {
		this.submitTime = submitTime;
	}

	/**
	 * 设置提交时间字符串格式
	 * @param submitTime 提交时间
	 */
	public void setSubmitTimeStr(String submitTime) {
		if (!org.apache.commons.lang.StringUtils.isBlank(submitTime)) {
			try {
				this.submitTime = java.text.DateFormat.getDateTimeInstance().parse(submitTime);
			} catch (java.text.ParseException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 获取提交时间
	 * @return 提交时间
	 */
	public java.util.Date getSubmitTime() {
		return this.submitTime;
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
			.append("Content",getContent())
			.append("UserId",getUserId())
			.append("UserName",getUserName())
			.append("CallerName",getCallerName())
			.append("ContactType",getContactType())
			.append("SubmitTime",getSubmitTime())
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
		if(obj instanceof PtFeedback == false) return false;
		if(this == obj) return true;
//		PtFeedbackEntity other = (PtFeedbackEntity)obj;
		PtFeedback other = (PtFeedback)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

