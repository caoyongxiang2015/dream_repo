<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>二级标签</title>
</head>
<body>
<!-- <button class="button button-raised button-primary button-pill">公司名称</button> -->

<div class="row-fluid">
	<div class="span12 control-group" style="text-align: center;">
		<c:forEach items="${twotags}" var="twotag">
			<c:if test="${twotag.rownum==1}">
				<%-- <button class="button button-border button-primary button-pill">${twotag.tagname }</button> --%>
				<input type="checkbox" name="${twotag.tagname }" <c:if test="${twotag.canprovide==1}">checked</c:if> onchange="twotagchange('${twotag.id}')" >${twotag.tagname }
			</c:if>
		</c:forEach>
	</div>
	<div class="span12 control-group" style="text-align: center;">
		<c:forEach items="${twotags}" var="twotag">
			<c:if test="${twotag.rownum==2}">
				<input type="checkbox" name="${twotag.tagname }" <c:if test="${twotag.canprovide==1}">checked</c:if> onchange="twotagchange('${twotag.id}')" >${twotag.tagname}
			</c:if>
		</c:forEach>
	</div>
</div>

<script type="text/javascript">
function twotagchange(pk){
	var canprovide = 1;
	$.ajax({
		url:'${ctx}/drmtwotag/toggletwotag/'+pk+'/'+canprovide,
		type:'get',
		success:function(data){
			
		},
		error:function(data){
			alert('选择信息失败');
		}
		
	});
}
</script>


</body>
</html>