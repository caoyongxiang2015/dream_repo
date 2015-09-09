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
		
		<c:forEach items="${ls }" var="lte">
		
			
			<div class="panel panel-default">
				<div class="panel-heading no-bottom-border" onclick="opendetail('${lte.receiveUserid}');">
					<h3 class="panel-title">
						我与用户 ${lte.receiveUsername }的私信<i class="right glyphicon glyphicon-resize-full"></i>
					</h3>
				</div>
				<div class="panel-body lettersection" hidden>
					
				</div>
			</div>
			
			
		</c:forEach>
		
		
		====================================
		
			<div class="panel panel-default">
				<div class="panel-heading no-bottom-border">
					<h3 class="panel-title">
						我与用户XXX的私信<i class="right glyphicon glyphicon-resize-full"></i>
					</h3>
				</div>
				<div class="panel-body" hidden>
					<div class="media">
						<!--                                <div class="media-left"><a href="#"><img src="" alt="">头像</a></div>-->
						<div class="media-right text-success">
							<h5 class="meida-heading">TA：2015.02.02 12:12:12</h5>
							<div class="media-content">用户XXXXX
								向您发送请求帮助信息，TA想简单了解下XXX公司的信息，诚意金50元</div>
						</div>
					</div>
					<div class="media">
						<!--                                <div class="media-left"><a href="#"><img src="" alt="">头像</a></div>-->
						<div class="media-right text-primary">
							<h5 class="meida-heading">我：2015.02.02 12:12:12</h5>
							<div class="media-content">
								信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息信息
							</div>
						</div>
					</div>
					<div class="media">
						<!--                                <div class="media-left"><a href="#"><img src="" alt="">头像</a></div>-->
						<div class="media-right text-success">
							<h5 class="meida-heading">TA：2015.02.02 12:12:12</h5>
							<div class="media-content">
								请求帮助信息请求帮助信息请求帮助信息请求帮助信息请求帮助信息请求帮助信息请求帮助信息请求帮助信息请求</div>
						</div>
					</div>
					<div class="form-group mt15">
						<form action="" id="messageForm">
							<textarea id="sendMessage" name="sendMessage" cols="30" rows="3"
								class="form-control"></textarea>
							<div class="text-center">
								<button type="submit" class="btn btn-lg btn-primary mt15">发送私信</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			
			
			
			<div class="panel panel-default">
				<div class="panel-heading no-bottom-border">
					<h3 class="panel-title">
						我与用户XXX的私信<i class="right glyphicon glyphicon-resize-full"></i>
					</h3>
				</div>
				<div class="panel-body" hidden>
					<div class="media">
						<!--                                <div class="media-left"><a href="#"><img src="" alt="">头像</a></div>-->
						<div class="media-right text-success">
							<h5 class="meida-heading">2015.02.02 12:12:12</h5>
							<div class="media-content">用户XXXXX
								向您发送请求帮助信息，TA想简单了解下XXX公司的信息，诚意金50元</div>
						</div>
					</div>
				</div>
			</div>
			
			
			
			</section>
	</div>

<div class="xxx"></div>
	<script src="${static_common}/hzk/js/jquery.min.js"></script>

	<script type="text/javascript"
		src="${static_common}/hzk/js/jquery.validate.js"></script>
	<script type="text/javascript"
		src="${static_common}/hzk/js/jquery-validate.bootstrap-tooltip.js"></script>
		
		
	<script type="text/javascript">
	
		function opendetail(uid){
			var url = '${ctx}/drmletter/letterSection/'+uid;
			
			$(this).next().load(url);
			//$('.lettersection').load(url);
		}
	
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
		})
	</script>
</body>
</html>