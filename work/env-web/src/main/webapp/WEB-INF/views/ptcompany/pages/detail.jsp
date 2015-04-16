<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示PtCompany</title>
</head>
<body>
    <a href="/">首页</a>
		<table>
			<tr>
				<td>id:</td>
				<td>
				<input type="text" id="entity.id"
					name="entity.id" 
					value="${entity.id}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>单位名称:</td>
				<td>
				<input type="text" id="entity.companyName"
					name="entity.companyName" 
					value="${entity.companyName}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>记录版本号，每次修改递增1:</td>
				<td>
				<input type="text" id="entity.version"
					name="entity.version" 
					value="${entity.version}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>逻辑删除标志，1删除0可用:</td>
				<td>
				<input type="text" id="entity.disabled"
					name="entity.disabled" 
					value="${entity.disabled}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>创建者ID:</td>
				<td>
				<input type="text" id="entity.createUserid"
					name="entity.createUserid" 
					value="${entity.createUserid}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>创建时间:</td>
				<td>
				<input type="text" id="entity.createTimeStr"
					name="entity.createTimeStr"
					value="<f:formatDate value='${entity.createTime}' pattern='yyyy-MM-dd HH:mm:ss' />" readonly="readonly"/>
			</tr>
			<tr>
				<td>修改者ID:</td>
				<td>
				<input type="text" id="entity.updateUserid"
					name="entity.updateUserid" 
					value="${entity.updateUserid}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>修改时间:</td>
				<td>
				<input type="text" id="entity.updateTimeStr"
					name="entity.updateTimeStr"
					value="<f:formatDate value='${entity.updateTime}' pattern='yyyy-MM-dd HH:mm:ss' />" readonly="readonly"/>
			</tr>
		</table>
</body>
</html>
