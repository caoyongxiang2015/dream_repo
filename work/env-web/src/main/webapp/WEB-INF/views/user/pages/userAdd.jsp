<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>用户新增</title>
</head>
<body>
	<h3>用户新增</h3>
	<form id="input_form" class="form-horizontal valid"
		action="${ctx}/userSample/add" method="post">
		<envbase:token/>
		<input type="text" name="username" class="required"> <input type="submit"
			id="saveButton" value="save">

	</form>


	<script type="text/javascript">
	/*
		$(document).ready(function() {
			$("#saveButton").click(function() {
				alert(1);
				$('#input_form').submit();
			});
		});
		*/
	</script>
</body>
</html>