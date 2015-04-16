<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>用户编辑</title>
</head>
<body>
	<h3>用户编辑</h3>
	<form id="input_form" class="form-horizontal valid"
		action="${ctx}/userSample/edit" method="POST">
		<input type="hidden" name="id" value="${user.id }" >
		<input type="text" name="username" value="${user.username }" ><input type="submit" value="modify">
	</form>
</body>
</html>