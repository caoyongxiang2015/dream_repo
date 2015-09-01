/**
 * Description: 用户发布需求；搜索公司 都把公司记录下来数据库实体/领域对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-09-01 下午 21:01:45
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-09-01   caoyx   1.0         Initial
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
 * 用户发布需求；搜索公司 都把公司记录下来数据库实体/领域对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-09-01
 * @see
 * @since 1.0
 */
public class DrmSearchCompany extends DomainObject{
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
	 * companyName
	 */
	//@Length(max=200)
	private java.lang.String companyName;
	
	/**
	 * companyShotname
	 */
	//@Length(max=100)
	private java.lang.String companyShotname;
	
	/**
	 * 标志该公司当前是否被搜索到
	 */
	//
	private java.lang.Integer searched;
	
	/**
	 * sendUserId
	 */
	//
	private java.lang.Integer sendUserId;
	
	/**
	 * sendUserPhone
	 */
	//@Length(max=20)
	private java.lang.String sendUserPhone;
	
	/**
	 * 标志是发布需求还是搜索公司;1发布需求，2搜索
	 */
	//
	private java.lang.Integer flag;
	
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
	public DrmSearchCompany(){
	}

	public DrmSearchCompany(
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
	 * 设置companyName
	 * @param companyName companyName
	 */
	public void setCompanyName(java.lang.String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 获取companyName
	 * @return companyName
	 */
	public java.lang.String getCompanyName() {
		return this.companyName;
	}

	/**
	 * 设置companyShotname
	 * @param companyShotname companyShotname
	 */
	public void setCompanyShotname(java.lang.String companyShotname) {
		this.companyShotname = companyShotname;
	}

	/**
	 * 获取companyShotname
	 * @return companyShotname
	 */
	public java.lang.String getCompanyShotname() {
		return this.companyShotname;
	}

	/**
	 * 设置标志该公司当前是否被搜索到
	 * @param searched 标志该公司当前是否被搜索到
	 */
	public void setSearched(java.lang.Integer searched) {
		this.searched = searched;
	}

	/**
	 * 获取标志该公司当前是否被搜索到
	 * @return 标志该公司当前是否被搜索到
	 */
	public java.lang.Integer getSearched() {
		return this.searched;
	}

	/**
	 * 设置sendUserId
	 * @param sendUserId sendUserId
	 */
	public void setSendUserId(java.lang.Integer sendUserId) {
		this.sendUserId = sendUserId;
	}

	/**
	 * 获取sendUserId
	 * @return sendUserId
	 */
	public java.lang.Integer getSendUserId() {
		return this.sendUserId;
	}

	/**
	 * 设置sendUserPhone
	 * @param sendUserPhone sendUserPhone
	 */
	public void setSendUserPhone(java.lang.String sendUserPhone) {
		this.sendUserPhone = sendUserPhone;
	}

	/**
	 * 获取sendUserPhone
	 * @return sendUserPhone
	 */
	public java.lang.String getSendUserPhone() {
		return this.sendUserPhone;
	}

	/**
	 * 设置标志是发布需求还是搜索公司;1发布需求，2搜索
	 * @param flag 标志是发布需求还是搜索公司;1发布需求，2搜索
	 */
	public void setFlag(java.lang.Integer flag) {
		this.flag = flag;
	}

	/**
	 * 获取标志是发布需求还是搜索公司;1发布需求，2搜索
	 * @return 标志是发布需求还是搜索公司;1发布需求，2搜索
	 */
	public java.lang.Integer getFlag() {
		return this.flag;
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
			.append("CompanyName",getCompanyName())
			.append("CompanyShotname",getCompanyShotname())
			.append("Searched",getSearched())
			.append("SendUserId",getSendUserId())
			.append("SendUserPhone",getSendUserPhone())
			.append("Flag",getFlag())
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
		if(obj instanceof DrmSearchCompany == false) return false;
		if(this == obj) return true;
//		DrmSearchCompanyEntity other = (DrmSearchCompanyEntity)obj;
		DrmSearchCompany other = (DrmSearchCompany)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

