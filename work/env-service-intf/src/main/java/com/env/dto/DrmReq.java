/**
 * Description: 需求数据库实体/领域对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:50
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
 * 需求数据库实体/领域对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class DrmReq extends DomainObject{
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
	 * 需求订单编号(根据规则生成）
	 */
	//@Length(max=100)
	private java.lang.String reqNum;
	
	/**
	 * 公司名称
	 */
	//@Length(max=200)
	private java.lang.String companyName;
	
	/**
	 * 公司简称
	 */
	//@Length(max=100)
	private java.lang.String companyShotname;
	
	/**
	 * 赏金
	 */
	//
	private Long price;
	
	/**
	 * 线下服务赏金
	 */
	//
	private Long faceprice;
	
	/**
	 * 发布需求的用户id
	 */
	//
	private java.lang.Integer sendUserId;
	
	/**
	 * 发布需求的用户手机号
	 */
	//@Length(max=20)
	private java.lang.String sendUserPhone;
	
	/**
	 * 发布需求的用户昵称
	 */
	//@Length(max=100)
	private java.lang.String sendUserNickname;
	
	/**
	 * 应答状态0未应答1已应答2赏金已托管3服务已完成4申请退款5放弃需求
	 */
	//
	private java.lang.Integer acceptState;
	
	/**
	 * 应答的用户id
	 */
	//
	private java.lang.Integer acceptUserId;
	
	/**
	 * 方便的时间段，例如工作日，节假日，均可。直接是存储汉字
	 */
	//@Length(max=2000)
	private java.lang.String acceptDuration;
	
	/**
	 * 开放给对方的联系方式，例如电话qq邮箱
	 */
	//@Length(max=2000)
	private java.lang.String openContact;
	
	/**
	 * 应答时间
	 */
	//
	private java.util.Date acceptTime;
	
	/**
	 * 赏金托管时间
	 */
	//
	private java.util.Date depositTime;
	
	/**
	 * 服务完成时间
	 */
	//
	private java.util.Date completeTime;
	
	/**
	 * 评价结束时间
	 */
	//
	private java.util.Date endTime;
	
	/**
	 * 废弃终止时间
	 */
	//
	private java.util.Date stopTime;
	
	/**
	 * 标题
	 */
	//@Length(max=200)
	private java.lang.String title;
	
	/**
	 * 详细需求(捎上一句话）
	 */
	//@Length(max=4000)
	private java.lang.String content;
	
	/**
	 * 过期时间（默认一个月）
	 */
	//
	private java.util.Date overtime;
	
	/**
	 * 评价分数
	 */
	//
	private java.lang.Integer evalScore;
	
	/**
	 * 评价内容
	 */
	//@Length(max=4000)
	private java.lang.String evalContent;
	
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
	public DrmReq(){
	}

	public DrmReq(
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
	 * 设置需求订单编号(根据规则生成）
	 * @param reqNum 需求订单编号(根据规则生成）
	 */
	public void setReqNum(java.lang.String reqNum) {
		this.reqNum = reqNum;
	}

	/**
	 * 获取需求订单编号(根据规则生成）
	 * @return 需求订单编号(根据规则生成）
	 */
	public java.lang.String getReqNum() {
		return this.reqNum;
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
	 * 设置公司简称
	 * @param companyShotname 公司简称
	 */
	public void setCompanyShotname(java.lang.String companyShotname) {
		this.companyShotname = companyShotname;
	}

	/**
	 * 获取公司简称
	 * @return 公司简称
	 */
	public java.lang.String getCompanyShotname() {
		return this.companyShotname;
	}

	/**
	 * 设置赏金
	 * @param price 赏金
	 */
	public void setPrice(Long price) {
		this.price = price;
	}

	/**
	 * 获取赏金
	 * @return 赏金
	 */
	public Long getPrice() {
		return this.price;
	}

	/**
	 * 设置线下服务赏金
	 * @param faceprice 线下服务赏金
	 */
	public void setFaceprice(Long faceprice) {
		this.faceprice = faceprice;
	}

	/**
	 * 获取线下服务赏金
	 * @return 线下服务赏金
	 */
	public Long getFaceprice() {
		return this.faceprice;
	}

	/**
	 * 设置发布需求的用户id
	 * @param sendUserId 发布需求的用户id
	 */
	public void setSendUserId(java.lang.Integer sendUserId) {
		this.sendUserId = sendUserId;
	}

	/**
	 * 获取发布需求的用户id
	 * @return 发布需求的用户id
	 */
	public java.lang.Integer getSendUserId() {
		return this.sendUserId;
	}

	/**
	 * 设置发布需求的用户手机号
	 * @param sendUserPhone 发布需求的用户手机号
	 */
	public void setSendUserPhone(java.lang.String sendUserPhone) {
		this.sendUserPhone = sendUserPhone;
	}

	/**
	 * 获取发布需求的用户手机号
	 * @return 发布需求的用户手机号
	 */
	public java.lang.String getSendUserPhone() {
		return this.sendUserPhone;
	}

	/**
	 * 设置发布需求的用户昵称
	 * @param sendUserNickname 发布需求的用户昵称
	 */
	public void setSendUserNickname(java.lang.String sendUserNickname) {
		this.sendUserNickname = sendUserNickname;
	}

	/**
	 * 获取发布需求的用户昵称
	 * @return 发布需求的用户昵称
	 */
	public java.lang.String getSendUserNickname() {
		return this.sendUserNickname;
	}

	/**
	 * 设置应答状态0未应答1已应答2赏金已托管3服务已完成4申请退款5放弃需求
	 * @param acceptState 应答状态0未应答1已应答2赏金已托管3服务已完成4申请退款5放弃需求
	 */
	public void setAcceptState(java.lang.Integer acceptState) {
		this.acceptState = acceptState;
	}

	/**
	 * 获取应答状态0未应答1已应答2赏金已托管3服务已完成4申请退款5放弃需求
	 * @return 应答状态0未应答1已应答2赏金已托管3服务已完成4申请退款5放弃需求
	 */
	public java.lang.Integer getAcceptState() {
		return this.acceptState;
	}

	/**
	 * 设置应答的用户id
	 * @param acceptUserId 应答的用户id
	 */
	public void setAcceptUserId(java.lang.Integer acceptUserId) {
		this.acceptUserId = acceptUserId;
	}

	/**
	 * 获取应答的用户id
	 * @return 应答的用户id
	 */
	public java.lang.Integer getAcceptUserId() {
		return this.acceptUserId;
	}

	/**
	 * 设置方便的时间段，例如工作日，节假日，均可。直接是存储汉字
	 * @param acceptDuration 方便的时间段，例如工作日，节假日，均可。直接是存储汉字
	 */
	public void setAcceptDuration(java.lang.String acceptDuration) {
		this.acceptDuration = acceptDuration;
	}

	/**
	 * 获取方便的时间段，例如工作日，节假日，均可。直接是存储汉字
	 * @return 方便的时间段，例如工作日，节假日，均可。直接是存储汉字
	 */
	public java.lang.String getAcceptDuration() {
		return this.acceptDuration;
	}

	/**
	 * 设置开放给对方的联系方式，例如电话qq邮箱
	 * @param openContact 开放给对方的联系方式，例如电话qq邮箱
	 */
	public void setOpenContact(java.lang.String openContact) {
		this.openContact = openContact;
	}

	/**
	 * 获取开放给对方的联系方式，例如电话qq邮箱
	 * @return 开放给对方的联系方式，例如电话qq邮箱
	 */
	public java.lang.String getOpenContact() {
		return this.openContact;
	}

	/**
	 * 设置应答时间
	 * @param acceptTime 应答时间
	 */
	public void setAcceptTime(java.util.Date acceptTime) {
		this.acceptTime = acceptTime;
	}

	/**
	 * 设置应答时间字符串格式
	 * @param acceptTime 应答时间
	 */
	public void setAcceptTimeStr(String acceptTime) {
		if (!org.apache.commons.lang.StringUtils.isBlank(acceptTime)) {
			try {
				this.acceptTime = java.text.DateFormat.getDateTimeInstance().parse(acceptTime);
			} catch (java.text.ParseException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 获取应答时间
	 * @return 应答时间
	 */
	public java.util.Date getAcceptTime() {
		return this.acceptTime;
	}

	/**
	 * 设置赏金托管时间
	 * @param depositTime 赏金托管时间
	 */
	public void setDepositTime(java.util.Date depositTime) {
		this.depositTime = depositTime;
	}

	/**
	 * 设置赏金托管时间字符串格式
	 * @param depositTime 赏金托管时间
	 */
	public void setDepositTimeStr(String depositTime) {
		if (!org.apache.commons.lang.StringUtils.isBlank(depositTime)) {
			try {
				this.depositTime = java.text.DateFormat.getDateTimeInstance().parse(depositTime);
			} catch (java.text.ParseException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 获取赏金托管时间
	 * @return 赏金托管时间
	 */
	public java.util.Date getDepositTime() {
		return this.depositTime;
	}

	/**
	 * 设置服务完成时间
	 * @param completeTime 服务完成时间
	 */
	public void setCompleteTime(java.util.Date completeTime) {
		this.completeTime = completeTime;
	}

	/**
	 * 设置服务完成时间字符串格式
	 * @param completeTime 服务完成时间
	 */
	public void setCompleteTimeStr(String completeTime) {
		if (!org.apache.commons.lang.StringUtils.isBlank(completeTime)) {
			try {
				this.completeTime = java.text.DateFormat.getDateTimeInstance().parse(completeTime);
			} catch (java.text.ParseException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 获取服务完成时间
	 * @return 服务完成时间
	 */
	public java.util.Date getCompleteTime() {
		return this.completeTime;
	}

	/**
	 * 设置评价结束时间
	 * @param endTime 评价结束时间
	 */
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * 设置评价结束时间字符串格式
	 * @param endTime 评价结束时间
	 */
	public void setEndTimeStr(String endTime) {
		if (!org.apache.commons.lang.StringUtils.isBlank(endTime)) {
			try {
				this.endTime = java.text.DateFormat.getDateTimeInstance().parse(endTime);
			} catch (java.text.ParseException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 获取评价结束时间
	 * @return 评价结束时间
	 */
	public java.util.Date getEndTime() {
		return this.endTime;
	}

	/**
	 * 设置废弃终止时间
	 * @param stopTime 废弃终止时间
	 */
	public void setStopTime(java.util.Date stopTime) {
		this.stopTime = stopTime;
	}

	/**
	 * 设置废弃终止时间字符串格式
	 * @param stopTime 废弃终止时间
	 */
	public void setStopTimeStr(String stopTime) {
		if (!org.apache.commons.lang.StringUtils.isBlank(stopTime)) {
			try {
				this.stopTime = java.text.DateFormat.getDateTimeInstance().parse(stopTime);
			} catch (java.text.ParseException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 获取废弃终止时间
	 * @return 废弃终止时间
	 */
	public java.util.Date getStopTime() {
		return this.stopTime;
	}

	/**
	 * 设置标题
	 * @param title 标题
	 */
	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	/**
	 * 获取标题
	 * @return 标题
	 */
	public java.lang.String getTitle() {
		return this.title;
	}

	/**
	 * 设置详细需求(捎上一句话）
	 * @param content 详细需求(捎上一句话）
	 */
	public void setContent(java.lang.String content) {
		this.content = content;
	}

	/**
	 * 获取详细需求(捎上一句话）
	 * @return 详细需求(捎上一句话）
	 */
	public java.lang.String getContent() {
		return this.content;
	}

	/**
	 * 设置过期时间（默认一个月）
	 * @param overtime 过期时间（默认一个月）
	 */
	public void setOvertime(java.util.Date overtime) {
		this.overtime = overtime;
	}

	/**
	 * 设置过期时间（默认一个月）字符串格式
	 * @param overtime 过期时间（默认一个月）
	 */
	public void setOvertimeStr(String overtime) {
		if (!org.apache.commons.lang.StringUtils.isBlank(overtime)) {
			try {
				this.overtime = java.text.DateFormat.getDateTimeInstance().parse(overtime);
			} catch (java.text.ParseException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 获取过期时间（默认一个月）
	 * @return 过期时间（默认一个月）
	 */
	public java.util.Date getOvertime() {
		return this.overtime;
	}

	/**
	 * 设置评价分数
	 * @param evalScore 评价分数
	 */
	public void setEvalScore(java.lang.Integer evalScore) {
		this.evalScore = evalScore;
	}

	/**
	 * 获取评价分数
	 * @return 评价分数
	 */
	public java.lang.Integer getEvalScore() {
		return this.evalScore;
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
			.append("ReqNum",getReqNum())
			.append("CompanyName",getCompanyName())
			.append("CompanyShotname",getCompanyShotname())
			.append("Price",getPrice())
			.append("Faceprice",getFaceprice())
			.append("SendUserId",getSendUserId())
			.append("SendUserPhone",getSendUserPhone())
			.append("SendUserNickname",getSendUserNickname())
			.append("AcceptState",getAcceptState())
			.append("AcceptUserId",getAcceptUserId())
			.append("AcceptDuration",getAcceptDuration())
			.append("OpenContact",getOpenContact())
			.append("AcceptTime",getAcceptTime())
			.append("DepositTime",getDepositTime())
			.append("CompleteTime",getCompleteTime())
			.append("EndTime",getEndTime())
			.append("StopTime",getStopTime())
			.append("Title",getTitle())
			.append("Content",getContent())
			.append("Overtime",getOvertime())
			.append("EvalScore",getEvalScore())
			.append("EvalContent",getEvalContent())
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
		if(obj instanceof DrmReq == false) return false;
		if(this == obj) return true;
//		DrmReqEntity other = (DrmReqEntity)obj;
		DrmReq other = (DrmReq)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

