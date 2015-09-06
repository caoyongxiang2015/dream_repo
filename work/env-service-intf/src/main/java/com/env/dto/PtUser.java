/**
 * Description: PtUser数据库实体/领域对象
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
 * PtUser数据库实体/领域对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class PtUser extends DomainObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	/**
	 * 登录名（手机号）
	 */
	//@Length(max=50)
	private java.lang.String loginId;
	
	/**
	 * 登录密码
	 */
	//@Length(max=50)
	private java.lang.String pwd;
	
	/**
	 * 昵称
	 */
	//@Length(max=100)
	private java.lang.String nickname;
	
	/**
	 * 姓
	 */
	//@Length(max=10)
	private java.lang.String lastname;
	
	/**
	 * 真实姓名
	 */
	//@Length(max=100)
	private java.lang.String realname;
	
	/**
	 * 性别1男2女
	 */
	//
	private java.lang.Integer sex;
	
	/**
	 * 省
	 */
	//@Length(max=10)
	private java.lang.String province;
	
	/**
	 * 市
	 */
	//@Length(max=20)
	private java.lang.String city;
	
	/**
	 * 县区
	 */
	//@Length(max=30)
	private java.lang.String county;
	
	/**
	 * 个性签名
	 */
	//@Length(max=500)
	private java.lang.String signature;
	
	/**
	 * 身份证号
	 */
	//@Length(max=20)
	private java.lang.String idcard;
	
	/**
	 * 身份证正面
	 */
	//@Length(max=500)
	private java.lang.String idcardfront;
	
	/**
	 * 身份证反面
	 */
	//@Length(max=500)
	private java.lang.String idcardback;
	
	/**
	 * 资料完整度百分比
	 */
	//
	private java.lang.Integer percent;
	
	/**
	 * 工作年限0应届毕业生，1一年以下，2：1-3年，3:3-5年，4:5-7年，5:7-10年，6:10年以上
	 */
	//
	private java.lang.Integer workyears;
	
	/**
	 * 是否提供线下服务0不提供，1提供
	 */
	//
	private java.lang.Integer isoffline;
	
	/**
	 * 线下服务价格每次
	 */
	//
	private Long offlineprice;
	
	/**
	 * QQ号码
	 */
	//@Length(max=20)
	private java.lang.String qq;
	
	/**
	 * EMAIL
	 */
	//@Email @Length(max=100)
	private java.lang.String email;
	
	/**
	 * 微信
	 */
	//@Length(max=100)
	private java.lang.String weixin;
	
	/**
	 * 手机号
	 */
	//@Length(max=20)
	private java.lang.String phone;
	
	/**
	 * 当前公司ID
	 */
	//
	private java.lang.Integer curCompanyId;
	private java.lang.Integer companyIndex;
	
	/**
	 * 当前公司名称
	 */
	//@Length(max=200)
	private java.lang.String curCompanyName;
	
	/**
	 * 当前部门名称
	 */
	//@Length(max=200)
	private java.lang.String curDeptName;
	
	/**
	 * 收款账号
	 */
	//@Length(max=500)
	private java.lang.String moneyCount;
	
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
	public PtUser(){
	}

	public PtUser(
		java.lang.Integer id
	){
		this.id = id;
	}

    */


	/**
	 * 设置登录名（手机号）
	 * @param loginId 登录名（手机号）
	 */
	public void setLoginId(java.lang.String loginId) {
		this.loginId = loginId;
	}

	/**
	 * 获取登录名（手机号）
	 * @return 登录名（手机号）
	 */
	public java.lang.String getLoginId() {
		return this.loginId;
	}

	/**
	 * 设置登录密码
	 * @param pwd 登录密码
	 */
	public void setPwd(java.lang.String pwd) {
		this.pwd = pwd;
	}

	/**
	 * 获取登录密码
	 * @return 登录密码
	 */
	public java.lang.String getPwd() {
		return this.pwd;
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
	 * 设置姓
	 * @param lastname 姓
	 */
	public void setLastname(java.lang.String lastname) {
		this.lastname = lastname;
	}

	/**
	 * 获取姓
	 * @return 姓
	 */
	public java.lang.String getLastname() {
		return this.lastname;
	}

	/**
	 * 设置真实姓名
	 * @param realname 真实姓名
	 */
	public void setRealname(java.lang.String realname) {
		this.realname = realname;
	}

	/**
	 * 获取真实姓名
	 * @return 真实姓名
	 */
	public java.lang.String getRealname() {
		return this.realname;
	}

	/**
	 * 设置性别1男2女
	 * @param sex 性别1男2女
	 */
	public void setSex(java.lang.Integer sex) {
		this.sex = sex;
	}

	/**
	 * 获取性别1男2女
	 * @return 性别1男2女
	 */
	public java.lang.Integer getSex() {
		return this.sex;
	}

	/**
	 * 设置省
	 * @param province 省
	 */
	public void setProvince(java.lang.String province) {
		this.province = province;
	}

	/**
	 * 获取省
	 * @return 省
	 */
	public java.lang.String getProvince() {
		return this.province;
	}

	/**
	 * 设置市
	 * @param city 市
	 */
	public void setCity(java.lang.String city) {
		this.city = city;
	}

	/**
	 * 获取市
	 * @return 市
	 */
	public java.lang.String getCity() {
		return this.city;
	}

	/**
	 * 设置县区
	 * @param county 县区
	 */
	public void setCounty(java.lang.String county) {
		this.county = county;
	}

	/**
	 * 获取县区
	 * @return 县区
	 */
	public java.lang.String getCounty() {
		return this.county;
	}

	/**
	 * 设置个性签名
	 * @param signature 个性签名
	 */
	public void setSignature(java.lang.String signature) {
		this.signature = signature;
	}

	/**
	 * 获取个性签名
	 * @return 个性签名
	 */
	public java.lang.String getSignature() {
		return this.signature;
	}

	/**
	 * 设置身份证号
	 * @param idcard 身份证号
	 */
	public void setIdcard(java.lang.String idcard) {
		this.idcard = idcard;
	}

	/**
	 * 获取身份证号
	 * @return 身份证号
	 */
	public java.lang.String getIdcard() {
		return this.idcard;
	}

	/**
	 * 设置身份证正面
	 * @param idcardfront 身份证正面
	 */
	public void setIdcardfront(java.lang.String idcardfront) {
		this.idcardfront = idcardfront;
	}

	/**
	 * 获取身份证正面
	 * @return 身份证正面
	 */
	public java.lang.String getIdcardfront() {
		return this.idcardfront;
	}

	/**
	 * 设置身份证反面
	 * @param idcardback 身份证反面
	 */
	public void setIdcardback(java.lang.String idcardback) {
		this.idcardback = idcardback;
	}

	/**
	 * 获取身份证反面
	 * @return 身份证反面
	 */
	public java.lang.String getIdcardback() {
		return this.idcardback;
	}

	/**
	 * 设置资料完整度百分比
	 * @param percent 资料完整度百分比
	 */
	public void setPercent(java.lang.Integer percent) {
		this.percent = percent;
	}

	/**
	 * 获取资料完整度百分比
	 * @return 资料完整度百分比
	 */
	public java.lang.Integer getPercent() {
		return this.percent;
	}

	/**
	 * 设置工作年限0应届毕业生，1一年以下，2：1-3年，3:3-5年，4:5-7年，5:7-10年，6:10年以上
	 * @param workyears 工作年限0应届毕业生，1一年以下，2：1-3年，3:3-5年，4:5-7年，5:7-10年，6:10年以上
	 */
	public void setWorkyears(java.lang.Integer workyears) {
		this.workyears = workyears;
	}

	/**
	 * 获取工作年限0应届毕业生，1一年以下，2：1-3年，3:3-5年，4:5-7年，5:7-10年，6:10年以上
	 * @return 工作年限0应届毕业生，1一年以下，2：1-3年，3:3-5年，4:5-7年，5:7-10年，6:10年以上
	 */
	public java.lang.Integer getWorkyears() {
		return this.workyears;
	}

	/**
	 * 设置是否提供线下服务0不提供，1提供
	 * @param isoffline 是否提供线下服务0不提供，1提供
	 */
	public void setIsoffline(java.lang.Integer isoffline) {
		this.isoffline = isoffline;
	}

	/**
	 * 获取是否提供线下服务0不提供，1提供
	 * @return 是否提供线下服务0不提供，1提供
	 */
	public java.lang.Integer getIsoffline() {
		return this.isoffline;
	}

	/**
	 * 设置线下服务价格每次
	 * @param offlineprice 线下服务价格每次
	 */
	public void setOfflineprice(Long offlineprice) {
		this.offlineprice = offlineprice;
	}

	/**
	 * 获取线下服务价格每次
	 * @return 线下服务价格每次
	 */
	public Long getOfflineprice() {
		return this.offlineprice;
	}

	/**
	 * 设置QQ号码
	 * @param qq QQ号码
	 */
	public void setQq(java.lang.String qq) {
		this.qq = qq;
	}

	/**
	 * 获取QQ号码
	 * @return QQ号码
	 */
	public java.lang.String getQq() {
		return this.qq;
	}

	/**
	 * 设置EMAIL
	 * @param email EMAIL
	 */
	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	/**
	 * 获取EMAIL
	 * @return EMAIL
	 */
	public java.lang.String getEmail() {
		return this.email;
	}

	/**
	 * 设置微信
	 * @param weixin 微信
	 */
	public void setWeixin(java.lang.String weixin) {
		this.weixin = weixin;
	}

	/**
	 * 获取微信
	 * @return 微信
	 */
	public java.lang.String getWeixin() {
		return this.weixin;
	}

	/**
	 * 设置手机号
	 * @param phone 手机号
	 */
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	/**
	 * 获取手机号
	 * @return 手机号
	 */
	public java.lang.String getPhone() {
		return this.phone;
	}

	/**
	 * 设置当前公司ID
	 * @param curCompanyId 当前公司ID
	 */
	public void setCurCompanyId(java.lang.Integer curCompanyId) {
		this.curCompanyId = curCompanyId;
	}

	/**
	 * 获取当前公司ID
	 * @return 当前公司ID
	 */
	public java.lang.Integer getCurCompanyId() {
		return this.curCompanyId;
	}

	/**
	 * 设置当前公司名称
	 * @param curCompanyName 当前公司名称
	 */
	public void setCurCompanyName(java.lang.String curCompanyName) {
		this.curCompanyName = curCompanyName;
	}

	/**
	 * 获取当前公司名称
	 * @return 当前公司名称
	 */
	public java.lang.String getCurCompanyName() {
		return this.curCompanyName;
	}

	/**
	 * 设置当前部门名称
	 * @param curDeptName 当前部门名称
	 */
	public void setCurDeptName(java.lang.String curDeptName) {
		this.curDeptName = curDeptName;
	}

	/**
	 * 获取当前部门名称
	 * @return 当前部门名称
	 */
	public java.lang.String getCurDeptName() {
		return this.curDeptName;
	}

	/**
	 * 设置收款账号
	 * @param moneyCount 收款账号
	 */
	public void setMoneyCount(java.lang.String moneyCount) {
		this.moneyCount = moneyCount;
	}

	/**
	 * 获取收款账号
	 * @return 收款账号
	 */
	public java.lang.String getMoneyCount() {
		return this.moneyCount;
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

    public java.lang.Integer getCompanyIndex() {
		return companyIndex;
	}

	public void setCompanyIndex(java.lang.Integer companyIndex) {
		this.companyIndex = companyIndex;
	}

	/**
     * 实体的toString方法
     * @return 实体字符串
     */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("LoginId",getLoginId())
			.append("Pwd",getPwd())
			.append("Nickname",getNickname())
			.append("Lastname",getLastname())
			.append("Realname",getRealname())
			.append("Sex",getSex())
			.append("Province",getProvince())
			.append("City",getCity())
			.append("County",getCounty())
			.append("Signature",getSignature())
			.append("Idcard",getIdcard())
			.append("Idcardfront",getIdcardfront())
			.append("Idcardback",getIdcardback())
			.append("Percent",getPercent())
			.append("Workyears",getWorkyears())
			.append("Isoffline",getIsoffline())
			.append("Offlineprice",getOfflineprice())
			.append("Qq",getQq())
			.append("Email",getEmail())
			.append("Weixin",getWeixin())
			.append("Phone",getPhone())
			.append("CurCompanyId",getCurCompanyId())
			.append("CurCompanyName",getCurCompanyName())
			.append("CurDeptName",getCurDeptName())
			.append("MoneyCount",getMoneyCount())
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
		if(obj instanceof PtUser == false) return false;
		if(this == obj) return true;
//		PtUserEntity other = (PtUserEntity)obj;
		PtUser other = (PtUser)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

