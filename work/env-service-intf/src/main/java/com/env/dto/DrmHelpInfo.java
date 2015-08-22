/**
 * Description: TA们都在这里得到了帮助，模拟数据数据库实体/领域对象
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
 * TA们都在这里得到了帮助，模拟数据数据库实体/领域对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class DrmHelpInfo extends DomainObject{
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
	 * 目标公司
	 */
	//@Length(max=200)
	private java.lang.String companyName;
	
	/**
	 * 昵称
	 */
	//@Length(max=100)
	private java.lang.String nickname;
	
	/**
	 * 联系方式
	 */
	//@Length(max=100)
	private java.lang.String contactType;
	
	/**
	 * opeTime
	 */
	//
	private java.util.Date opeTime;
	
	/**
	 * 评价内容
	 */
	//@Length(max=4000)
	private java.lang.String evalContent;
	
	//columns END
	/*
	public DrmHelpInfo(){
	}

	public DrmHelpInfo(
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
	 * 设置目标公司
	 * @param companyName 目标公司
	 */
	public void setCompanyName(java.lang.String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 获取目标公司
	 * @return 目标公司
	 */
	public java.lang.String getCompanyName() {
		return this.companyName;
	}

	/**
	 * 设置昵称
	 * @param nickname 昵称
	 */
	public void setNickname(java.lang.String nickname) {
		this.nickname = nickname;
	}

	/**
	 * 获取昵称
	 * @return 昵称
	 */
	public java.lang.String getNickname() {
		return this.nickname;
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
	 * 设置opeTime
	 * @param opeTime opeTime
	 */
	public void setOpeTime(java.util.Date opeTime) {
		this.opeTime = opeTime;
	}

	/**
	 * 设置opeTime字符串格式
	 * @param opeTime opeTime
	 */
	public void setOpeTimeStr(String opeTime) {
		if (!org.apache.commons.lang.StringUtils.isBlank(opeTime)) {
			try {
				this.opeTime = java.text.DateFormat.getDateTimeInstance().parse(opeTime);
			} catch (java.text.ParseException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 获取opeTime
	 * @return opeTime
	 */
	public java.util.Date getOpeTime() {
		return this.opeTime;
	}

	/**
	 * 设置评价内容
	 * @param evalContent 评价内容
	 */
	public void setEvalContent(java.lang.String evalContent) {
		this.evalContent = evalContent;
	}

	/**
	 * 获取评价内容
	 * @return 评价内容
	 */
	public java.lang.String getEvalContent() {
		return this.evalContent;
	}

    /**
     * 实体的toString方法
     * @return 实体字符串
     */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("CompanyName",getCompanyName())
			.append("Nickname",getNickname())
			.append("ContactType",getContactType())
			.append("OpeTime",getOpeTime())
			.append("EvalContent",getEvalContent())
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
		if(obj instanceof DrmHelpInfo == false) return false;
		if(this == obj) return true;
//		DrmHelpInfoEntity other = (DrmHelpInfoEntity)obj;
		DrmHelpInfo other = (DrmHelpInfo)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

