/**
 * Description: DrmTwotag数据库实体/领域对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-05-05 下午 21:27:02
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-05-05   caoyx   1.0         Initial
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
 * DrmTwotag数据库实体/领域对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
public class DrmTwotag extends DomainObject{
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
//	private java.lang.Integer id;
	
	/**
	 * 人员id
	 */
	//
	private java.lang.Integer userid;
	
	/**
	 * 一级标签id
	 */
	//
	private java.lang.Integer onetagid;
	
	/**
	 * 一级标签名称
	 */
	//@Length(max=100)
	private java.lang.String onetagname;
	
	/**
	 * 标签名称
	 */
	//@Length(max=100)
	private java.lang.String tagname;
	
	/**
	 * 能否提供该标签信息
	 */
	//
	private java.lang.Integer canprovide;
	
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
	public DrmTwotag(){
	}

	public DrmTwotag(
	){
	}

    */

	/**
	 * 设置人员id
	 * @param userid 人员id
	 */
	public void setUserid(java.lang.Integer userid) {
		this.userid = userid;
	}

	/**
	 * 获取人员id
	 * @return 人员id
	 */
	public java.lang.Integer getUserid() {
		return this.userid;
	}

	/**
	 * 设置一级标签id
	 * @param onetagid 一级标签id
	 */
	public void setOnetagid(java.lang.Integer onetagid) {
		this.onetagid = onetagid;
	}

	/**
	 * 获取一级标签id
	 * @return 一级标签id
	 */
	public java.lang.Integer getOnetagid() {
		return this.onetagid;
	}

	/**
	 * 设置一级标签名称
	 * @param onetagname 一级标签名称
	 */
	public void setOnetagname(java.lang.String onetagname) {
		this.onetagname = onetagname;
	}

	/**
	 * 获取一级标签名称
	 * @return 一级标签名称
	 */
	public java.lang.String getOnetagname() {
		return this.onetagname;
	}

	/**
	 * 设置标签名称
	 * @param tagname 标签名称
	 */
	public void setTagname(java.lang.String tagname) {
		this.tagname = tagname;
	}

	/**
	 * 获取标签名称
	 * @return 标签名称
	 */
	public java.lang.String getTagname() {
		return this.tagname;
	}

	/**
	 * 设置能否提供该标签信息
	 * @param canprovide 能否提供该标签信息
	 */
	public void setCanprovide(java.lang.Integer canprovide) {
		this.canprovide = canprovide;
	}

	/**
	 * 获取能否提供该标签信息
	 * @return 能否提供该标签信息
	 */
	public java.lang.Integer getCanprovide() {
		return this.canprovide;
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
			.append("Userid",getUserid())
			.append("Onetagid",getOnetagid())
			.append("Onetagname",getOnetagname())
			.append("Tagname",getTagname())
			.append("Canprovide",getCanprovide())
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
			.toHashCode();
	}

	/**
	 * 对象比较
	 * @param obj 待比较对象
	 * @return 是否相同<li>true--相同<li>false--不相同
	 */
	public boolean equals(Object obj) {
		if(obj instanceof DrmTwotag == false) return false;
		if(this == obj) return true;
//		DrmTwotagEntity other = (DrmTwotagEntity)obj;
		DrmTwotag other = (DrmTwotag)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

