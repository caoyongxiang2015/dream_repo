/**
 * Description: 记录用户对公司的搜索次数数据库实体/领域对象
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
 * 记录用户对公司的搜索次数数据库实体/领域对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class DrmSearchRecord extends DomainObject{
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
	 * companyId
	 */
	//
	private java.lang.Integer companyId;
	
	/**
	 * companyName
	 */
	//@Length(max=200)
	private java.lang.String companyName;
	
	/**
	 * 被搜索的次数
	 */
	//
	private java.lang.Integer searchCount;
	
	//columns END
	/*
	public DrmSearchRecord(){
	}

	public DrmSearchRecord(
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
	 * 设置被搜索的次数
	 * @param searchCount 被搜索的次数
	 */
	public void setSearchCount(java.lang.Integer searchCount) {
		this.searchCount = searchCount;
	}

	/**
	 * 获取被搜索的次数
	 * @return 被搜索的次数
	 */
	public java.lang.Integer getSearchCount() {
		return this.searchCount;
	}

    /**
     * 实体的toString方法
     * @return 实体字符串
     */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("CompanyId",getCompanyId())
			.append("CompanyName",getCompanyName())
			.append("SearchCount",getSearchCount())
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
		if(obj instanceof DrmSearchRecord == false) return false;
		if(this == obj) return true;
//		DrmSearchRecordEntity other = (DrmSearchRecordEntity)obj;
		DrmSearchRecord other = (DrmSearchRecord)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

