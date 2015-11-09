/**
 * Description: DrmNetfriendComment数据库实体/领域对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-11-09 下午 22:58:36
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-11-09   caoyx   1.0         Initial
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
 * DrmNetfriendComment数据库实体/领域对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-11-09
 * @see
 * @since 1.0
 */
public class DrmNetfriendComment extends DomainObject{
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
	 * companyLibId
	 */
	//
	private java.lang.Integer companyLibId;
	
	/**
	 * companyName
	 */
	//@Length(max=500)
	private java.lang.String companyName;
	
	/**
	 * advantage
	 */
	//@Length(max=1000)
	private java.lang.String advantage;
	
	/**
	 * weakness
	 */
	//@Length(max=1000)
	private java.lang.String weakness;
	
	/**
	 * suggestion
	 */
	//@Length(max=1000)
	private java.lang.String suggestion;
	
	/**
	 * title
	 */
	//@Length(max=1000)
	private java.lang.String title;
	
	/**
	 * disabled
	 */
	//
	private java.lang.Integer disabled;
	
	/**
	 * 内部员工/离职员工....
	 */
	//@Length(max=100)
	private java.lang.String friendType;
	
	/**
	 * 评分
	 */
	//
	private java.lang.Integer score;
	
	//columns END
	/*
	public DrmNetfriendComment(){
	}

	public DrmNetfriendComment(
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
	 * 设置companyLibId
	 * @param companyLibId companyLibId
	 */
	public void setCompanyLibId(java.lang.Integer companyLibId) {
		this.companyLibId = companyLibId;
	}

	/**
	 * 获取companyLibId
	 * @return companyLibId
	 */
	public java.lang.Integer getCompanyLibId() {
		return this.companyLibId;
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
	 * 设置advantage
	 * @param advantage advantage
	 */
	public void setAdvantage(java.lang.String advantage) {
		this.advantage = advantage;
	}

	/**
	 * 获取advantage
	 * @return advantage
	 */
	public java.lang.String getAdvantage() {
		return this.advantage;
	}

	/**
	 * 设置weakness
	 * @param weakness weakness
	 */
	public void setWeakness(java.lang.String weakness) {
		this.weakness = weakness;
	}

	/**
	 * 获取weakness
	 * @return weakness
	 */
	public java.lang.String getWeakness() {
		return this.weakness;
	}

	/**
	 * 设置suggestion
	 * @param suggestion suggestion
	 */
	public void setSuggestion(java.lang.String suggestion) {
		this.suggestion = suggestion;
	}

	/**
	 * 获取suggestion
	 * @return suggestion
	 */
	public java.lang.String getSuggestion() {
		return this.suggestion;
	}

	/**
	 * 设置title
	 * @param title title
	 */
	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	/**
	 * 获取title
	 * @return title
	 */
	public java.lang.String getTitle() {
		return this.title;
	}

	/**
	 * 设置disabled
	 * @param disabled disabled
	 */
	public void setDisabled(java.lang.Integer disabled) {
		this.disabled = disabled;
	}

	/**
	 * 获取disabled
	 * @return disabled
	 */
	public java.lang.Integer getDisabled() {
		return this.disabled;
	}

	/**
	 * 设置内部员工/离职员工....
	 * @param friendType 内部员工/离职员工....
	 */
	public void setFriendType(java.lang.String friendType) {
		this.friendType = friendType;
	}

	/**
	 * 获取内部员工/离职员工....
	 * @return 内部员工/离职员工....
	 */
	public java.lang.String getFriendType() {
		return this.friendType;
	}

	/**
	 * 设置评分
	 * @param score 评分
	 */
	public void setScore(java.lang.Integer score) {
		this.score = score;
	}

	/**
	 * 获取评分
	 * @return 评分
	 */
	public java.lang.Integer getScore() {
		return this.score;
	}

    /**
     * 实体的toString方法
     * @return 实体字符串
     */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("CompanyLibId",getCompanyLibId())
			.append("CompanyName",getCompanyName())
			.append("Advantage",getAdvantage())
			.append("Weakness",getWeakness())
			.append("Suggestion",getSuggestion())
			.append("Title",getTitle())
			.append("Disabled",getDisabled())
			.append("FriendType",getFriendType())
			.append("Score",getScore())
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
		if(obj instanceof DrmNetfriendComment == false) return false;
		if(this == obj) return true;
//		DrmNetfriendCommentEntity other = (DrmNetfriendCommentEntity)obj;
		DrmNetfriendComment other = (DrmNetfriendComment)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

