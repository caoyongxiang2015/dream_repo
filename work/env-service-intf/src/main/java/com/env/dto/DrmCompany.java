/**
 * Description: DrmCompany数据库实体/领域对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-05-28 下午 22:52:56
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-05-28   caoyx   1.0         Initial
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
 * DrmCompany数据库实体/领域对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-28
 * @see
 * @since 1.0
 */
public class DrmCompany extends DomainObject{
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
	private java.lang.Integer id;
	
	/**
	 * 用户ID
	 */
	//
	private java.lang.Integer userId;
	
	/**
	 * 公司原始库id
	 */
	//
	private java.lang.Integer companyLibId;
	
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
	 * 公司规模
	 */
	//@Length(max=100)
	private java.lang.String companySize;
	
	/**
	 * 公司地址
	 */
	//@Length(max=500)
	private java.lang.String address;
	
	/**
	 * 男女员工比例
	 */
	//@Length(max=50)
	private java.lang.String sexratio;
	
	/**
	 * 公司文化
	 */
	//@Length(max=1000)
	private java.lang.String culture;
	
	/**
	 * 公司优点
	 */
	//@Length(max=1000)
	private java.lang.String advantage;
	
	/**
	 * 公司缺点
	 */
	//@Length(max=1000)
	private java.lang.String weakness;
	
	/**
	 * 交通情况
	 */
	//@Length(max=1000)
	private java.lang.String traffic;
	
	/**
	 * 我的岗位名称
	 */
	//@Length(max=100)
	private java.lang.String postname;
	
	/**
	 * 工作内容简介
	 */
	//@Length(max=1000)
	private java.lang.String workcontent;
	
	/**
	 * 公司氛围
	 */
	//@Length(max=1000)
	private java.lang.String atmosphere;
	
	/**
	 * 老板怎么样
	 */
	//@Length(max=1000)
	private java.lang.String boss;
	
	/**
	 * 入职日期
	 */
	//
	private java.util.Date indate;
	
	/**
	 * 离职日期
	 */
	//
	private java.util.Date outdate;
	
	/**
	 * 在职时长
	 */
	//@Length(max=100)
	private java.lang.String jobDuration;
	
	/**
	 * 公司加班情况
	 */
	//@Length(max=100)
	private java.lang.String overtime;
	
	/**
	 * 是否有班车
	 */
	//
	private java.lang.Integer hasbus;
	
	/**
	 * 提供的信息
	 */
	//@Length(max=4000)
	private java.lang.String provideContent;
	
	/**
	 * 公司信息字数统计
	 */
	//
	private java.lang.Integer wordCount;
	
	/**
	 * 提供信息服务的方式（qq/微信/电话/平台展示/站内信/邮件）
	 */
	//
	private java.lang.Integer provideType;
	
	/**
	 * 是否提供QQ方式
	 */
	//
	private java.lang.Integer qq;
	
	/**
	 * 是否提供weixin方式
	 */
	//
	private java.lang.Integer weixin;
	
	/**
	 * 是否提供电话方式
	 */
	//
	private java.lang.Integer phone;
	
	/**
	 * 是否提供email方式
	 */
	//@Email
	private java.lang.Integer email;
	
	/**
	 * 是否提供站内信方式
	 */
	//
	private java.lang.Integer zhanneixin;
	
	/**
	 * 直接在平台展示
	 */
	//
	private java.lang.Integer ptshow;
	
	/**
	 * 标价
	 */
	//
	private Long price;
	
	/**
	 * 线下服务价格
	 */
	//
	private Long faceprice;
	
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
	public DrmCompany(){
	}

	public DrmCompany(
		java.lang.Integer id
	){
		this.id = id;
	}

    */

	/**
	 * 设置主键
	 * @param id 主键
	 */
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	/**
	 * 获取主键
	 * @return 主键
	 */
	public java.lang.Integer getId() {
		return this.id;
	}

	/**
	 * 设置用户ID
	 * @param userId 用户ID
	 */
	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	/**
	 * 获取用户ID
	 * @return 用户ID
	 */
	public java.lang.Integer getUserId() {
		return this.userId;
	}

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
	 * 设置公司规模
	 * @param companySize 公司规模
	 */
	public void setCompanySize(java.lang.String companySize) {
		this.companySize = companySize;
	}

	/**
	 * 获取公司规模
	 * @return 公司规模
	 */
	public java.lang.String getCompanySize() {
		return this.companySize;
	}

	/**
	 * 设置公司地址
	 * @param address 公司地址
	 */
	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	/**
	 * 获取公司地址
	 * @return 公司地址
	 */
	public java.lang.String getAddress() {
		return this.address;
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
	 * 设置公司文化
	 * @param culture 公司文化
	 */
	public void setCulture(java.lang.String culture) {
		this.culture = culture;
	}

	/**
	 * 获取公司文化
	 * @return 公司文化
	 */
	public java.lang.String getCulture() {
		return this.culture;
	}

	/**
	 * 设置公司优点
	 * @param advantage 公司优点
	 */
	public void setAdvantage(java.lang.String advantage) {
		this.advantage = advantage;
	}

	/**
	 * 获取公司优点
	 * @return 公司优点
	 */
	public java.lang.String getAdvantage() {
		return this.advantage;
	}

	/**
	 * 设置公司缺点
	 * @param weakness 公司缺点
	 */
	public void setWeakness(java.lang.String weakness) {
		this.weakness = weakness;
	}

	/**
	 * 获取公司缺点
	 * @return 公司缺点
	 */
	public java.lang.String getWeakness() {
		return this.weakness;
	}

	/**
	 * 设置交通情况
	 * @param traffic 交通情况
	 */
	public void setTraffic(java.lang.String traffic) {
		this.traffic = traffic;
	}

	/**
	 * 获取交通情况
	 * @return 交通情况
	 */
	public java.lang.String getTraffic() {
		return this.traffic;
	}

	/**
	 * 设置我的岗位名称
	 * @param postname 我的岗位名称
	 */
	public void setPostname(java.lang.String postname) {
		this.postname = postname;
	}

	/**
	 * 获取我的岗位名称
	 * @return 我的岗位名称
	 */
	public java.lang.String getPostname() {
		return this.postname;
	}

	/**
	 * 设置工作内容简介
	 * @param workcontent 工作内容简介
	 */
	public void setWorkcontent(java.lang.String workcontent) {
		this.workcontent = workcontent;
	}

	/**
	 * 获取工作内容简介
	 * @return 工作内容简介
	 */
	public java.lang.String getWorkcontent() {
		return this.workcontent;
	}

	/**
	 * 设置公司氛围
	 * @param atmosphere 公司氛围
	 */
	public void setAtmosphere(java.lang.String atmosphere) {
		this.atmosphere = atmosphere;
	}

	/**
	 * 获取公司氛围
	 * @return 公司氛围
	 */
	public java.lang.String getAtmosphere() {
		return this.atmosphere;
	}

	/**
	 * 设置老板怎么样
	 * @param boss 老板怎么样
	 */
	public void setBoss(java.lang.String boss) {
		this.boss = boss;
	}

	/**
	 * 获取老板怎么样
	 * @return 老板怎么样
	 */
	public java.lang.String getBoss() {
		return this.boss;
	}

	/**
	 * 设置入职日期
	 * @param indate 入职日期
	 */
	public void setIndate(java.util.Date indate) {
		this.indate = indate;
	}

	/**
	 * 设置入职日期字符串格式
	 * @param indate 入职日期
	 */
	public void setIndateStr(String indate) {
		if (!org.apache.commons.lang.StringUtils.isBlank(indate)) {
			try {
				this.indate = java.text.DateFormat.getDateTimeInstance().parse(indate);
			} catch (java.text.ParseException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 获取入职日期
	 * @return 入职日期
	 */
	public java.util.Date getIndate() {
		return this.indate;
	}

	/**
	 * 设置离职日期
	 * @param outdate 离职日期
	 */
	public void setOutdate(java.util.Date outdate) {
		this.outdate = outdate;
	}

	/**
	 * 设置离职日期字符串格式
	 * @param outdate 离职日期
	 */
	public void setOutdateStr(String outdate) {
		if (!org.apache.commons.lang.StringUtils.isBlank(outdate)) {
			try {
				this.outdate = java.text.DateFormat.getDateTimeInstance().parse(outdate);
			} catch (java.text.ParseException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 获取离职日期
	 * @return 离职日期
	 */
	public java.util.Date getOutdate() {
		return this.outdate;
	}

	/**
	 * 设置在职时长
	 * @param jobDuration 在职时长
	 */
	public void setJobDuration(java.lang.String jobDuration) {
		this.jobDuration = jobDuration;
	}

	/**
	 * 获取在职时长
	 * @return 在职时长
	 */
	public java.lang.String getJobDuration() {
		return this.jobDuration;
	}

	/**
	 * 设置公司加班情况
	 * @param overtime 公司加班情况
	 */
	public void setOvertime(java.lang.String overtime) {
		this.overtime = overtime;
	}

	/**
	 * 获取公司加班情况
	 * @return 公司加班情况
	 */
	public java.lang.String getOvertime() {
		return this.overtime;
	}

	/**
	 * 设置是否有班车
	 * @param hasbus 是否有班车
	 */
	public void setHasbus(java.lang.Integer hasbus) {
		this.hasbus = hasbus;
	}

	/**
	 * 获取是否有班车
	 * @return 是否有班车
	 */
	public java.lang.Integer getHasbus() {
		return this.hasbus;
	}

	/**
	 * 设置提供的信息
	 * @param provideContent 提供的信息
	 */
	public void setProvideContent(java.lang.String provideContent) {
		this.provideContent = provideContent;
	}

	/**
	 * 获取提供的信息
	 * @return 提供的信息
	 */
	public java.lang.String getProvideContent() {
		return this.provideContent;
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
	 * 设置提供信息服务的方式（qq/微信/电话/平台展示/站内信/邮件）
	 * @param provideType 提供信息服务的方式（qq/微信/电话/平台展示/站内信/邮件）
	 */
	public void setProvideType(java.lang.Integer provideType) {
		this.provideType = provideType;
	}

	/**
	 * 获取提供信息服务的方式（qq/微信/电话/平台展示/站内信/邮件）
	 * @return 提供信息服务的方式（qq/微信/电话/平台展示/站内信/邮件）
	 */
	public java.lang.Integer getProvideType() {
		return this.provideType;
	}

	/**
	 * 设置是否提供QQ方式
	 * @param qq 是否提供QQ方式
	 */
	public void setQq(java.lang.Integer qq) {
		this.qq = qq;
	}

	/**
	 * 获取是否提供QQ方式
	 * @return 是否提供QQ方式
	 */
	public java.lang.Integer getQq() {
		return this.qq;
	}

	/**
	 * 设置是否提供weixin方式
	 * @param weixin 是否提供weixin方式
	 */
	public void setWeixin(java.lang.Integer weixin) {
		this.weixin = weixin;
	}

	/**
	 * 获取是否提供weixin方式
	 * @return 是否提供weixin方式
	 */
	public java.lang.Integer getWeixin() {
		return this.weixin;
	}

	/**
	 * 设置是否提供电话方式
	 * @param phone 是否提供电话方式
	 */
	public void setPhone(java.lang.Integer phone) {
		this.phone = phone;
	}

	/**
	 * 获取是否提供电话方式
	 * @return 是否提供电话方式
	 */
	public java.lang.Integer getPhone() {
		return this.phone;
	}

	/**
	 * 设置是否提供email方式
	 * @param email 是否提供email方式
	 */
	public void setEmail(java.lang.Integer email) {
		this.email = email;
	}

	/**
	 * 获取是否提供email方式
	 * @return 是否提供email方式
	 */
	public java.lang.Integer getEmail() {
		return this.email;
	}

	/**
	 * 设置是否提供站内信方式
	 * @param zhanneixin 是否提供站内信方式
	 */
	public void setZhanneixin(java.lang.Integer zhanneixin) {
		this.zhanneixin = zhanneixin;
	}

	/**
	 * 获取是否提供站内信方式
	 * @return 是否提供站内信方式
	 */
	public java.lang.Integer getZhanneixin() {
		return this.zhanneixin;
	}

	/**
	 * 设置直接在平台展示
	 * @param ptshow 直接在平台展示
	 */
	public void setPtshow(java.lang.Integer ptshow) {
		this.ptshow = ptshow;
	}

	/**
	 * 获取直接在平台展示
	 * @return 直接在平台展示
	 */
	public java.lang.Integer getPtshow() {
		return this.ptshow;
	}

	/**
	 * 设置标价
	 * @param price 标价
	 */
	public void setPrice(Long price) {
		this.price = price;
	}

	/**
	 * 获取标价
	 * @return 标价
	 */
	public Long getPrice() {
		return this.price;
	}

	/**
	 * 设置线下服务价格
	 * @param faceprice 线下服务价格
	 */
	public void setFaceprice(Long faceprice) {
		this.faceprice = faceprice;
	}

	/**
	 * 获取线下服务价格
	 * @return 线下服务价格
	 */
	public Long getFaceprice() {
		return this.faceprice;
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
			.append("UserId",getUserId())
			.append("CompanyLibId",getCompanyLibId())
			.append("CompanyName",getCompanyName())
			.append("DeptName",getDeptName())
			.append("CompanySize",getCompanySize())
			.append("Address",getAddress())
			.append("Sexratio",getSexratio())
			.append("Culture",getCulture())
			.append("Advantage",getAdvantage())
			.append("Weakness",getWeakness())
			.append("Traffic",getTraffic())
			.append("Postname",getPostname())
			.append("Workcontent",getWorkcontent())
			.append("Atmosphere",getAtmosphere())
			.append("Boss",getBoss())
			.append("Indate",getIndate())
			.append("Outdate",getOutdate())
			.append("JobDuration",getJobDuration())
			.append("Overtime",getOvertime())
			.append("Hasbus",getHasbus())
			.append("ProvideContent",getProvideContent())
			.append("WordCount",getWordCount())
			.append("ProvideType",getProvideType())
			.append("Qq",getQq())
			.append("Weixin",getWeixin())
			.append("Phone",getPhone())
			.append("Email",getEmail())
			.append("Zhanneixin",getZhanneixin())
			.append("Ptshow",getPtshow())
			.append("Price",getPrice())
			.append("Faceprice",getFaceprice())
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
		if(obj instanceof DrmCompany == false) return false;
		if(this == obj) return true;
//		DrmCompanyEntity other = (DrmCompanyEntity)obj;
		DrmCompany other = (DrmCompany)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

