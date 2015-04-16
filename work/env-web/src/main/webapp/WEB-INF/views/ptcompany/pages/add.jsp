<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增PtCompany</title>
</head>
<body>
    <a href="/">首页</a>
	<form action="${ctx }/ptcompany/save" method="POST">
		<table>
			<tr>
				<td>单位名称:</td>
				<td>
				<input type="text" id="entity.companyName"
					name="entity.companyName"
					value="${entity.companyName}" />
				<font color="red"><form:errors path="entity.companyName" />
				</font>
				</td>
			</tr>
			<tr>
				<td>记录版本号，每次修改递增1:</td>
				<td>
				<input type="text" id="entity.version"
					name="entity.version"
					value="${entity.version}" />
				<font color="red"><form:errors path="entity.version" />
				</font>
				</td>
			</tr>
			<tr>
				<td>逻辑删除标志，1删除0可用:</td>
				<td>
				<input type="text" id="entity.disabled"
					name="entity.disabled"
					value="${entity.disabled}" />
				<font color="red"><form:errors path="entity.disabled" />
				</font>
				</td>
			</tr>
			<tr>
				<td>创建者ID:</td>
				<td>
				<input type="text" id="entity.createUserid"
					name="entity.createUserid"
					value="${entity.createUserid}" />
				<font color="red"><form:errors path="entity.createUserid" />
				</font>
				</td>
			</tr>
			<tr>
				<td>创建时间:</td>
				<td>
				<input type="text" id="entity.createTimeStr"
					name="entity.createTimeStr"
					value="<fmt:formatDate value='${entity.createTime}' pattern='yyyy-MM-dd HH:mm:ss' />" />
				<font color="red"><form:errors path="entity.createTime" />
				</font>
				</td>
			</tr>
			<tr>
				<td>修改者ID:</td>
				<td>
				<input type="text" id="entity.updateUserid"
					name="entity.updateUserid"
					value="${entity.updateUserid}" />
				<font color="red"><form:errors path="entity.updateUserid" />
				</font>
				</td>
			</tr>
			<tr>
				<td>修改时间:</td>
				<td>
				<input type="text" id="entity.updateTimeStr"
					name="entity.updateTimeStr"
					value="<fmt:formatDate value='${entity.updateTime}' pattern='yyyy-MM-dd HH:mm:ss' />" />
				<font color="red"><form:errors path="entity.updateTime" />
				</font>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="reset" value="重置" />&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="submit" value="增加" />&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="button" value="返回" onclick="window.location.href='/ptcompany/toSelect'"/></td>
			</tr>
		</table>
	</form>
</body>
</html>