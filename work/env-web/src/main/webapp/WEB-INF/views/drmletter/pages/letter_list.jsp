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

<%-- <button onclick="javascript:window.location.href='${ctx}/drmletter/send'">发送测试短信</button> --%>


	
	<div class="container" style="margin-top: 15px;">
		<section class="privite-message">
			<c:if test="${send_success == 1}">
				<div class="alert alert-success" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						发送成功
				</div>
			</c:if>
			<c:if test="${send_success == -1}">
				<div class="alert alert-success" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						发送失败
				</div>
			</c:if>
		
		<c:if test="${ls.size()<1}">
			<div class="panel panel-default">
	     		<div class="panel-heading">
	                 <h3 class="panel-title"><span>没有记录</span></h3>
	        	</div>
	        </div>
		</c:if>
		
		<c:forEach items="${ls }" var="lte">
			
			<div class="panel panel-default">
				<div class="panel-heading no-bottom-border" onclick="opendetail('${lte.receiveUserid}');">
					<h3 class="panel-title">
						我与用户 ${lte.receiveUsername }的私信<i class="right glyphicon glyphicon-resize-full"></i>
					</h3>
				</div>
				<div class="panel-body lettersection${lte.receiveUserid}" hidden>
					
				</div>
			</div>
			
			
		</c:forEach>
		
			
			</section>
	</div>

	<script src="${static_common}/hzk/js/jquery.min.js"></script>

	<script type="text/javascript"
		src="${static_common}/hzk/js/jquery.validate.js"></script>
	<script type="text/javascript"
		src="${static_common}/hzk/js/jquery-validate.bootstrap-tooltip.js"></script>
		
		
	<script type="text/javascript">
	
		function opendetail(uid){
			var url = '${ctx}/drmletter/letterSection/'+uid;
			$('.lettersection'+uid).load(url);
		}
		
		
	/* 
		$("#messageForm").validate({
			rules : {
				sendMessage : {
					required : true
				}
			},
			tooltip_options : {
				sendMessage : {
					placement : 'top'
				}
			},
		}) */
	</script>
</body>
</html>