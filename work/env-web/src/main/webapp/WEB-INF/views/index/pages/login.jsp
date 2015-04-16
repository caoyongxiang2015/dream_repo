<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>login</title>


<script type="text/javascript">
	function verify() {
		$.ajax({
			url : '${ctx}/verify',
			data : 'username=' + $('#username').val() + '&password=' +   $('#password').val()  + '&n=' + new Date(),
			dataType : 'json',
			method : 'post',
			success : function(data) {
				var json = eval(data); 
				$('#msg').text(json.msg);

				if(json.redirectUrl!=null){
					//跳转视图
					window.location.href='${ctx}'+json.redirectUrl;
				   }
			},
			error : function() {
				alert("登录异常");
			}
		});

	}
</script>

</head>
<body>
	login...

	<div id="msg" style="color: red"></div>
	<form>
		username:<input type="text" placeholder="请输入用户名" name="username"
			id="username" class="required checkuname" /> password:<input
			type="password" placeholder="请输入密码" class="required checkpwd"
			id="password" /> <input type="button" value="login"
			onclick="verify();">
	</form>

</body>