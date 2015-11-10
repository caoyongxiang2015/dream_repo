<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title><spring:message code="index.title" /></title>
</head>
<body>

	<div class="container" style="width: 500px; margin-top: 15px;">

		<div class="setting-profile panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">net friend comment</h3>
			</div>
			<div class="panel-body">
				<h3 class="panel-title"></h3>
				<div class="help-block">
				<c:forEach items="${libs}" var="lib">
				${lib.title }
					<br>
				${lib.advantage }
					<br>
				${lib.weakness }
					<br>
				${lib.suggestion }
					<br>
					<hr>
				</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>