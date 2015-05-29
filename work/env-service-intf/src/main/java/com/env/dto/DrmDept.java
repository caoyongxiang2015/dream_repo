/**
 * Description: DrmDept数据库实体/领域对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-05-05 下午 21:27:01
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
 * DrmDept数据库实体/领域对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
public class DrmDept extends DomainObject{
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
	 * 公司原始库id
	 */
	//
	private java.lang.Integer companyLibId;

	private java.lang.Integer userId;
	/**
	 * 我的公司ID
	 */
	//
	private java.lang.Integer companyId;
	
	/**
	 * 我的部门ID
	 */
	//
	private java.lang.Integer deptId;
	
	/**
	 * 公司名称
	 */
	//@Length(max=200)
	private java.lang.String companyName;
	
	/**
	 * 部门名称
	 */
	//@Length(max=200)
	private java.lang.String deptName;
	
	/**
	 * 部门规模
	 */
	//@Length(max=100)
	private java.lang.String deptSize;
	
	/**
	 * 男女员工比例
	 */
	//@Length(max=50)
	private java.lang.String sexratio;
	
	/**
	 * 部门优点
	 */
	//@Length(max=1000)
	private java.lang.String advantage;
	
	/**
	 * 部门缺点
	 */
	//@Length(max=1000)
	private java.lang.String weakness;
	
	/**
	 * 部门氛围
	 */
	//@Length(max=1000)
	private java.lang.String atmosphere;
	
	/**
	 * 部门老大怎么样
	 */
	//@Length(max=1000)
	private java.lang.String boss;
	
	/**
	 * 部门加班情况
	 */
	//@Length(max=100)
	private java.lang.String overtime;
	
	/**
	 * 业务方向
	 */
	//@Length(max=1000)
	private java.lang.String business;
	
	/**
	 * 公司信息字数统计
	 */
	//
	private java.lang.Integer wordCount;
	
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
	public DrmDept(){
	}

	public DrmDept(
		java.lang.Integer id
	){
		this.id = id;
	}

    */

	/**
	 * 设置公司原始库id
	 * @param companyLibId 公司原始库id
	 */
	public void setCompanyLibId(java.lang.Integer companyLibId) {
		this.companyLibId = companyLibId;
	}

	/**
	 * 获取公司原始库id
	 * @return 公司原始库id
	 */
	public java.lang.Integer getCompanyLibId() {
		return this.companyLibId;
	}

	/**
	 * 设置我的公司ID
	 * @param companyId 我的公司ID
	 */
	public void setCompanyId(java.lang.Integer companyId) {
		this.companyId = companyId;
	}

	/**
	 * 获取我的公司ID
	 * @return 我的公司ID
	 */
	public java.lang.Integer getCompanyId() {
		return this.companyId;
	}

	/**
	 * 设置我的部门ID
	 * @param deptId 我的部门ID
	 */
	public void setDeptId(java.lang.Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * 获取我的部门ID
	 * @return 我的部门ID
	 */
	public java.lang.Integer getDeptId() {
		return this.deptId;
	}

	/**
	 * 设置公司名称
	 * @param companyName 公司名称
	 */
	public void setCompanyName(java.lang.String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 获取公司名称
	 * @return 公司名称
	 */
	public java.lang.String getCompanyName() {
		return this.companyName;
	}

	/**
	 * 设置部门名称
	 * @param deptName 部门名称
	 */
	public void setDeptName(java.lang.String deptName) {
		this.deptName = deptName;
	}

	/**
	 * 获取部门名称
	 * @return 部门名称
	 */
	public java.lang.String getDeptName() {
		return this.deptName;
	}

	/**
	 * 设置部门规模
	 * @param deptSize 部门规模
	 */
	public void setDeptSize(java.lang.String deptSize) {
		this.deptSize = deptSize;
	}

	/**
	 * 获取部门规模
	 * @return 部门规模
	 */
	public java.lang.String getDeptSize() {
		return this.deptSize;
	}

	/**
	 * 设置男女员工比例
	 * @param sexratio 男女员工比例
	 */
	public void setSexratio(java.lang.String sexratio) {
		this.sexratio = sexratio;
	}

	/**
	 * 获取男女员工比例
	 * @return 男女员工比例
	 */
	public java.lang.String getSexratio() {
		return this.sexratio;
	}

	/**
	 * 设置部门优点
	 * @param advantage 部门优点
	 */
	public void setAdvantage(java.lang.String advantage) {
		this.advantage = advantage;
	}

	/**
	 * 获取部门优点
	 * @return 部门优点
	 */
	public java.lang.String getAdvantage() {
		return this.advantage;
	}

	/**
	 * 设置部门缺点
	 * @param weakness 部门缺点
	 */
	public void setWeakness(java.lang.String weakness) {
		this.weakness = weakness;
	}

	/**
	 * 获取部门缺点
	 * @return 部门缺点
	 */
	public java.lang.String getWeakness() {
		return this.weakness;
	}

	/**
	 * 设置部门氛围
	 * @param atmosphere 部门氛围
	 */
	public void setAtmosphere(java.lang.String atmosphere) {
		this.atmosphere = atmosphere;
	}

	/**
	 * 获取部门氛围
	 * @return 部门氛围
	 */
	public java.lang.String getAtmosphere() {
		return this.atmosphere;
	}

	/**
	 * 设置部门老大怎么样
	 * @param boss 部门老大怎么样
	 */
	public void setBoss(java.lang.String boss) {
		this.boss = boss;
	}

	/**
	 * 获取部门老大怎么样
	 * @return 部门老大怎么样
	 */
	public java.lang.String getBoss() {
		return this.boss;
	}

	/**
	 * 设置部门加班情况
	 * @param overtime 部门加班情况
	 */
	public void setOvertime(java.lang.String overtime) {
		this.overtime = overtime;
	}

	/**
	 * 获取部门加班情况
	 * @return 部门加班情况
	 */
	public java.lang.String getOvertime() {
		return this.overtime;
	}

	/**
	 * 设置业务方向
	 * @param business 业务方向
	 */
	public void setBusiness(java.lang.String business) {
		this.business = business;
	}

	/**
	 * 获取业务方向
	 * @return 业务方向
	 */
	public java.lang.String getBusiness() {
		return this.business;
	}

	/**
	 * 设置公司信息字数统计
	 * @param wordCount 公司信息字数统计
	 */
	public void setWordCount(java.lang.Integer wordCount) {
		this.wordCount = wordCount;
	}

	/**
	 * 获取公司信息字数统计
	 * @return 公司信息字数统计
	 */
	public java.lang.Integer getWordCount() {
		return this.wordCount;
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
	
	

    public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	/**
     * 实体的toString方法
     * @return 实体字符串
     */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("CompanyLibId",getCompanyLibId())
			.append("CompanyId",getCompanyId())
			.append("DeptId",getDeptId())
			.append("CompanyName",getCompanyName())
			.append("DeptName",getDeptName())
			.append("DeptSize",getDeptSize())
			.append("Sexratio",getSexratio())
			.append("Advantage",getAdvantage())
			.append("Weakness",getWeakness())
			.append("Atmosphere",getAtmosphere())
			.append("Boss",getBoss())
			.append("Overtime",getOvertime())
			.append("Business",getBusiness())
			.append("WordCount",getWordCount())
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
		if(obj instanceof DrmDept == false) return false;
		if(this == obj) return true;
//		DrmDeptEntity other = (DrmDeptEntity)obj;
		DrmDept other = (DrmDept)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

