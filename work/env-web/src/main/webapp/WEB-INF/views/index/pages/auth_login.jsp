<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<title><spring:message code="auth_login.title" /></title>


<script type="text/javascript">
	
</script>

</head>
<body>
	auth_login

	<div id="msg" style="color: red"></div>

	<form class="form-horizontal" action="${ctx}/auth/login" method="post">
		<div class="control-group">
			<label class="control-label" for="username"><spring:message code="login.username" /></label>
			<div class="controls">
				<input type="text" id="username" name="username"placeholder="username">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="password"><spring:message code="login.password" /></label>
			<div class="controls">
				<input type="password" id="password" name="password" placeholder="password">
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<label class="checkbox"> <input type="checkbox" id="rememberMe" name="rememberMe"> 记住我 </label>
				<button type="submit" class="btn" class="btn btn-success">SUBMIT</button>
			</div>
		</div>
	</form>

</body>