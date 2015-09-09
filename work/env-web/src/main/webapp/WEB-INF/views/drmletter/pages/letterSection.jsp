<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<body>

	<div class="media">
		<div class="media-right text-success">
		
		
		<c:forEach items="${ds }" var="d">
		${d.sendTime }~${d.title }~${d.content }~${d.sendUserid }~${d.receiveUserid }
		<br/>
		</c:forEach>
		</div>
	</div>

</body>