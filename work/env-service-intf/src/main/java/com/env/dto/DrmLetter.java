/**
 * Description: DrmLetter数据库实体/领域对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:49
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
 * DrmLetter数据库实体/领域对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class DrmLetter extends DomainObject{
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
	 * 私信标题
	 */
	//@Length(max=2000)
	private java.lang.String title;
	
	/**
	 * 私信内容
	 */
	//@Length(max=4000)
	private java.lang.String content;
	
	/**
	 * 发送人id
	 */
	//
	private java.lang.Integer sendUserid;
	
	/**
	 * 发送人姓名
	 */
	//@Length(max=200)
	private java.lang.String sendUsername;
	
	/**
	 * 接收人id
	 */
	//
	private java.lang.Integer receiveUserid;
	
	/**
	 * 接收人姓名
	 */
	//@Length(max=200)
	private java.lang.String receiveUsername;
	
	/**
	 * 发送时间
	 */
	//
	private java.util.Date sendTime;
	
	/**
	 * 0未读1已读
	 */
	//
	private java.lang.Integer readed;
	
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
	public DrmLetter(){
	}

	public DrmLetter(
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
	 * 设置私信标题
	 * @param title 私信标题
	 */
	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	/**
	 * 获取私信标题
	 * @return 私信标题
	 */
	public java.lang.String getTitle() {
		return this.title;
	}

	/**
	 * 设置私信内容
	 * @param content 私信内容
	 */
	public void setContent(java.lang.String content) {
		this.content = content;
	}

	/**
	 * 获取私信内容
	 * @return 私信内容
	 */
	public java.lang.String getContent() {
		return this.content;
	}

	/**
	 * 设置发送人id
	 * @param sendUserid 发送人id
	 */
	public void setSendUserid(java.lang.Integer sendUserid) {
		this.sendUserid = sendUserid;
	}

	/**
	 * 获取发送人id
	 * @return 发送人id
	 */
	public java.lang.Integer getSendUserid() {
		return this.sendUserid;
	}

	/**
	 * 设置发送人姓名
	 * @param sendUsername 发送人姓名
	 */
	public void setSendUsername(java.lang.String sendUsername) {
		this.sendUsername = sendUsername;
	}

	/**
	 * 获取发送人姓名
	 * @return 发送人姓名
	 */
	public java.lang.String getSendUsername() {
		return this.sendUsername;
	}

	/**
	 * 设置接收人id
	 * @param receiveUserid 接收人id
	 */
	public void setReceiveUserid(java.lang.Integer receiveUserid) {
		this.receiveUserid = receiveUserid;
	}

	/**
	 * 获取接收人id
	 * @return 接收人id
	 */
	public java.lang.Integer getReceiveUserid() {
		return this.receiveUserid;
	}

	/**
	 * 设置接收人姓名
	 * @param receiveUsername 接收人姓名
	 */
	public void setReceiveUsername(java.lang.String receiveUsername) {
		this.receiveUsername = receiveUsername;
	}

	/**
	 * 获取接收人姓名
	 * @return 接收人姓名
	 */
	public java.lang.String getReceiveUsername() {
		return this.receiveUsername;
	}

	/**
	 * 设置发送时间
	 * @param sendTime 发送时间
	 */
	public void setSendTime(java.util.Date sendTime) {
		this.sendTime = sendTime;
	}

	/**
	 * 设置发送时间字符串格式
	 * @param sendTime 发送时间
	 */
	public void setSendTimeStr(String sendTime) {
		if (!org.apache.commons.lang.StringUtils.isBlank(sendTime)) {
			try {
				this.sendTime = java.text.DateFormat.getDateTimeInstance().parse(sendTime);
			} catch (java.text.ParseException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 获取发送时间
	 * @return 发送时间
	 */
	public java.util.Date getSendTime() {
		return this.sendTime;
	}

	/**
	 * 设置0未读1已读
	 * @param readed 0未读1已读
	 */
	public void setReaded(java.lang.Integer readed) {
		this.readed = readed;
	}

	/**
	 * 获取0未读1已读
	 * @return 0未读1已读
	 */
	public java.lang.Integer getReaded() {
		return this.readed;
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
			.append("Title",getTitle())
			.append("Content",getContent())
			.append("SendUserid",getSendUserid())
			.append("SendUsername",getSendUsername())
			.append("ReceiveUserid",getReceiveUserid())
			.append("ReceiveUsername",getReceiveUsername())
			.append("SendTime",getSendTime())
			.append("Readed",getReaded())
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
		if(obj instanceof DrmLetter == false) return false;
		if(this == obj) return true;
//		DrmLetterEntity other = (DrmLetterEntity)obj;
		DrmLetter other = (DrmLetter)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

