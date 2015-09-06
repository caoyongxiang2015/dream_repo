/**
 * Description: url访问日志数据库实体/领域对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:53
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
 * url访问日志数据库实体/领域对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class PtVisitLog extends DomainObject{
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
	 * 访问IP
	 */
	//@Length(max=30)
	private java.lang.String visitIp;
	
	/**
	 * 访问时间
	 */
	//
	private java.util.Date visitTime;
	
	/**
	 * 访问的地址
	 */
	//@Length(max=1000)
	private java.lang.String visitUrl;
	
	/**
	 * 访问者id
	 */
	//
	private java.lang.Integer visitUserid;
	
	/**
	 * 访问者用户名
	 */
	//@Length(max=100)
	private java.lang.String visitUsername;
	
	/**
	 * 备注
	 */
	//@Length(max=500)
	private java.lang.String remark;
	
	//columns END
	/*
	public PtVisitLog(){
	}

	public PtVisitLog(
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
	 * 设置访问IP
	 * @param visitIp 访问IP
	 */
	public void setVisitIp(java.lang.String visitIp) {
		this.visitIp = visitIp;
	}

	/**
	 * 获取访问IP
	 * @return 访问IP
	 */
	public java.lang.String getVisitIp() {
		return this.visitIp;
	}

	/**
	 * 设置访问时间
	 * @param visitTime 访问时间
	 */
	public void setVisitTime(java.util.Date visitTime) {
		this.visitTime = visitTime;
	}

	/**
	 * 设置访问时间字符串格式
	 * @param visitTime 访问时间
	 */
	public void setVisitTimeStr(String visitTime) {
		if (!org.apache.commons.lang.StringUtils.isBlank(visitTime)) {
			try {
				this.visitTime = java.text.DateFormat.getDateTimeInstance().parse(visitTime);
			} catch (java.text.ParseException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 获取访问时间
	 * @return 访问时间
	 */
	public java.util.Date getVisitTime() {
		return this.visitTime;
	}

	/**
	 * 设置访问的地址
	 * @param visitUrl 访问的地址
	 */
	public void setVisitUrl(java.lang.String visitUrl) {
		this.visitUrl = visitUrl;
	}

	/**
	 * 获取访问的地址
	 * @return 访问的地址
	 */
	public java.lang.String getVisitUrl() {
		return this.visitUrl;
	}

	/**
	 * 设置访问者id
	 * @param visitUserid 访问者id
	 */
	public void setVisitUserid(java.lang.Integer visitUserid) {
		this.visitUserid = visitUserid;
	}

	/**
	 * 获取访问者id
	 * @return 访问者id
	 */
	public java.lang.Integer getVisitUserid() {
		return this.visitUserid;
	}

	/**
	 * 设置访问者用户名
	 * @param visitUsername 访问者用户名
	 */
	public void setVisitUsername(java.lang.String visitUsername) {
		this.visitUsername = visitUsername;
	}

	/**
	 * 获取访问者用户名
	 * @return 访问者用户名
	 */
	public java.lang.String getVisitUsername() {
		return this.visitUsername;
	}

	/**
	 * 设置备注
	 * @param remark 备注
	 */
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	/**
	 * 获取备注
	 * @return 备注
	 */
	public java.lang.String getRemark() {
		return this.remark;
	}

    /**
     * 实体的toString方法
     * @return 实体字符串
     */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("VisitIp",getVisitIp())
			.append("VisitTime",getVisitTime())
			.append("VisitUrl",getVisitUrl())
			.append("VisitUserid",getVisitUserid())
			.append("VisitUsername",getVisitUsername())
			.append("Remark",getRemark())
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
		if(obj instanceof PtVisitLog == false) return false;
		if(this == obj) return true;
//		PtVisitLogEntity other = (PtVisitLogEntity)obj;
		PtVisitLog other = (PtVisitLog)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

