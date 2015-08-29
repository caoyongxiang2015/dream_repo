<%@page import="com.env.constant.Constants"%>
<%@page import="com.env.dto.PtUser"%>
<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title><spring:message code="index.title"/></title>
<style type="text/css">

.jumbotron {
    background: linear-gradient(45deg, #020031 0px, #6D3353 100%) repeat scroll 0% 0% transparent;
    color: #FFF;
	text-align: center;
	text-shadow: 0px 1px 3px rgba(0, 0, 0, 0.4), 0px 0px 30px rgba(0, 0, 0, 0.075);
}
.masthead {
    color: #FFF;
	text-align:center; 
	background:linear-gradient(45deg,#020031 0,#6d3353 100%);
}
.container-fluid {
  padding-right: 0px;
  padding-left: 0px;
}
</style>

<script type="text/javascript">

	function login() {
		window.location.href='${ctx}/login';
	}
	
	function logout() {
		$.ajax({
			url : '${ctx}/logout',
			dataType : 'json',
			method : 'post',
			success : function(data) {
				var json = eval(data); 

				if(json.redirectUrl!=null){
					window.location.href='${ctx}'+json.redirectUrl;
				}
			},
			error : function() {
				alert("退出异常");
			}
		});

	}
</script>

</head>
<body>
	<%
	PtUser user = (PtUser)request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
	%>
	
 
	<%-- <a href="javascript:window.location.href='${ctx}/auth/logout'">logout</a> --%>
	
	<div class="jumbotron masthead">
		<div class="container">
		    <h1>工作台</h1>
		    <c:choose> 
				<c:when test="<%=(null!=user)%>">   
					<h2><%=user.getNickname() %>欢迎回来...</h2>
				</c:when> 
				<c:otherwise>   
					<p class="masthead-button-links"><a href="javascript:window.location.href='${ctx}/auth/toLogin'">please login</a></p>
				</c:otherwise> 
			</c:choose>
		    
		    <ul class="masthead-links"></ul>
	
		</div>
	</div>
	
</body>
</html>
