/**
 * Description: 用户注册的公司信息数据库实体/领域对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:46
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-21   caoyx   1.0         Initial
 */
package com.env.dto;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.env.core.domain.DomainObject;

/**
 * 能提供的公司信息标签/领域对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class DrmCompanyContent extends DomainObject{
	private static final long serialVersionUID = 1L;
	private java.lang.String companyLibId;
	private java.lang.String cotent;
	private java.lang.Integer disabled;

	
	@Override
	public String toString() {
		return "DrmCompanyContent [companyLibId=" + companyLibId + ", cotent="
				+ cotent + ", disabled=" + disabled + "]";
	}

	public java.lang.String getCompanyLibId() {
		return companyLibId;
	}

	public void setCompanyLibId(java.lang.String companyLibId) {
		this.companyLibId = companyLibId;
	}

	public java.lang.String getCotent() {
		return cotent;
	}

	public void setCotent(java.lang.String cotent) {
		this.cotent = cotent;
	}

	public java.lang.Integer getDisabled() {
		return disabled;
	}

	public void setDisabled(java.lang.Integer disabled) {
		this.disabled = disabled;
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
		if(obj instanceof DrmCompanyContent == false) return false;
		if(this == obj) return true;
		DrmCompanyContent other = (DrmCompanyContent)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

