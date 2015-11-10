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

		<c:if test="${libs!=null && libs.size()>0 }">
		<div class="setting-profile panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">网络搜索网友对该公司的评价（主要搜集IT技术岗类评价）</h3>
			</div>
			<div class="panel-body">
				<h3 class="panel-title"></h3>
				<div class="help-block">
					<c:forEach items="${libs}" var="lib">
						<span style="font-weight: bold;">${lib.userPost } --</span>  ${lib.title }
						<br>
					<c:if test="${lib.advantage!=null && ''!=lib.advantage }">
						<span style="font-weight: bold;">公司优点：</span>${lib.advantage}<br>
					</c:if>
					<c:if test="${lib.weakness!=null && ''!=lib.weakness }">
						<span style="font-weight: bold;">公司缺点：</span>${lib.weakness}<br>
					</c:if>
					<c:if test="${lib.suggestion!=null && ''!=lib.suggestion }">
						<span style="font-weight: bold;">意见建议：</span>${lib.suggestion}<br>
					</c:if>
					<c:if test="${lib.remark!=null && ''!=lib.remark }">
						${lib.remark}<br>
					</c:if>
						
						<hr>
					</c:forEach>
				</div>
			</div>
		</div>
		</c:if>
</body>
</html>