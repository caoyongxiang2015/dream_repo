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

    <div class="container" style="margin-top: 15px;">
	    <div class="demand-progress">
	    	<ol class="step-progress clearfix">
		    	<!--
					此处进度条
					当前在哪一步，就给哪一步添加class="current-step"
					其他步骤都删除class="current-step"
		    	-->
	    		<li>1. 需求发布</li>
	    		<li>2. 等待应答</li>
	    		<li>3. 诚意金托管</li>
	    		<li class="current-step">4. 服务</li>
	    		<li>5. 评价并结束</li>
	    	</ol>
	    </div>
    	<section class="release-demand">
    		<div class="row">
    			<div class="col-xs-8 col-xs-offset-2">
	    			<div class="send-respond">
	    				<p class="text-success">服务进行中...</p>
	    				<div class="help-block">请带着诚意向TA请教问题，待服务完成后，对TA的服务做出评价。默认7天后赏金自动转入对方账户</div>
	    				<div class="help-block">
		    				(${req.acceptUser.lastname}  先生/女士)TA已给您留了联系方式  ${req.openContact} ：
	    					<br>方便的时间段:${req.acceptDuration}
							<c:if test="${fn:contains(req.openContact, '手机号')}">
		    					<br>手机号${req.acceptUser.phone}
		    				</c:if>
							<c:if test="${fn:contains(req.openContact, 'QQ号码')}">
		    					<br>QQ号码${req.acceptUser.qq}
		    				</c:if>
							<c:if test="${fn:contains(req.openContact, '电子邮箱')}">
		    					<br>电子邮箱${req.acceptUser.email}
		    				</c:if>
	    				</div>
	    				
	    				<div class="next-btn">
	    					<button onclick="serviceComplete('${req.id}');" class="btn btn-primary btn-lg btn-block">服务完成</button>
							<button class="btn btn-link" data-toggle="modal" onclick="showletterdialog('${req.sendUserId}');">给TA发私信</button>

	    					<%-- <button onclick="javascript:window.location.href='${ctx}/release/fifth'" class="btn btn-primary btn-lg btn-block">服务完成</button> --%>
	    					<%-- <a onclick="backMoney('${req.id}');">申请退款</a> --%>
							<!-- <button class="btn btn-link" data-toggle="modal" data-target="#sendPriviteMessage">给TA发私信</button> -->
	    				</div>
	    				<p class="help-me text-danger">亲，给本平台提提意见或建议吧，有机会赢取大奖哦！</p>
	    			</div>
    			</div>
    		</div>
    	</section>
    </div>
    
    
    <!-- 发送私信 [[ -->
    <!-- 
	<div class="modal fade" id="sendPriviteMessage1" tabindex="-1" role="dialog" aria-labelledby="sendPriviteMessage1">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
			    <div class="modal-body">
				    <div class="container-fluid">
					    <div class="row message-object">
					    	<div class="col-xs-3">对方ID：</div>
					    	<div class="col-xs-3">xxxxx</div>
					    	<div class="col-xs-3">对方昵称：</div>
					    	<div class="col-xs-3">XXXXX</div>
					    </div>
				    	<div class="row">
					    	<label for="messageTitle" class="label-control col-xs-2">标题：</label>
							<div class="form-group col-xs-10">
								<input type="text" class="form-control" id="messageTitle" placeholder="私信标题">
					        </div>
					    </div>
					    <div class="row">
					    	<label for="messageText" class="abel-control col-xs-2">内容：</label>
					    	<div class="form-group col-xs-10">
						    	<textarea class="form-control" id="messageText" placeholder="发送私信" rows="8" cols="30"></textarea>
					    	</div>
					    </div>
				    </div>
		        </div>
		        <div class="modal-footer text-center">
			        <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal" onclick="nn.returnStatus('<div class=\'text-center\'>发送完成！</div>');">发送</button>
			        <button type="button" class="btn btn-link" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	 -->
	<!-- 发送私信 ]] -->
	
	<!-- 发送完成返回弹窗状态 -->
	<div class="modal fade" id="returnStatus" tabindex="-1" role="dialog" aria-labelledby="returnStatus">
		<div class="modal-dialog modal-m">
			<div class="modal-content">
				<div class="modal-body">
				</div>
				<div class="modal-footer text-center">
					<button type="button" class="btn btn-primary btn-block btn-lg" data-dismiss="modal">确定</button>
				</div>
			</div>
		</div>
	</div>
	
	
 
	<!-- 服务完成 -->
	<div class="modal fade" id="serviceComplete" tabindex="-1" role="dialog" aria-labelledby="serviceComplete">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<div class="modal-body">
					您确定咨询完成了吗?
				</div>
				<div class="modal-footer text-center">
			        <button type="button" class="btn btn-primary btn-lg J-service-complete-confirm" data-dismiss="modal">确定</button>
			        <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	   
	   
	   
	   
	<!-- 发送私信 [[ -->
	<div class="modal fade" id="sendPriviteMessage" tabindex="-1" role="dialog" aria-labelledby="sendPriviteMessage">
		<input type="hidden" name="youruserid" >
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
			    <div class="modal-body">
				    <div class="container-fluid">
					    <div class="row">
					    	<label for="messageText" class="abel-control col-xs-2">内容：</label>
					    	<div class="form-group col-xs-10">
						    	<textarea class="form-control" id="messageText" name="messageText" placeholder="发送私信" rows="8" cols="30"></textarea>
					    	</div>
					    </div>
				    </div>
		        </div>
		        <div class="modal-footer text-center">
			        <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal" onclick="sendletter();">发送</button>
			        <button type="button" class="btn btn-link" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
		</div>
	<!-- 发送私信 ]] -->
	   
	   
	   
	   
    <input type="hidden" name="reqid" >
    
<script src="${static_common}/hzk/js/jquery.min.js"></script>

<script type="text/javascript" src="${static_common}/hzk/js/jquery.validate.js"></script>
<script type="text/javascript" src="${static_common}/hzk/js/jquery-validate.bootstrap-tooltip.js"></script>
    
<script type="text/javascript">

function serviceComplete(reqid){
	$("input[name='reqid']").val(reqid);
	$("#serviceComplete").modal("show");
}


// 服务完成
$(".J-service-complete-confirm").on("click",function(){
	$.ajax({
		url:'${ctx}/drmreq/serviceComplete?acceptstate=3&reqid='+$("input[name='reqid']").val(),
		type:'get',
		success : function(data) {
			window.location.location="${ctx}/release/fifth";
		}
	});
})





		function showletterdialog(youruserid){
			$("input[name='youruserid']").val(youruserid);
			$('#sendPriviteMessage').modal('show');
		}
		
		
// 发私信
function sendletter(){
	var messageText = $("#messageText").val();
	if(''==messageText){
		alert("请填写内容！");
		return ;
	}
	var sendurl = '${ctx}/drmletter/sendletter?receiveUserid='+$("input[name='youruserid']").val() +'&sendMessage'+$("input[name='youruserid']").val()+ '='+messageText;
	$.ajax({
		url: sendurl ,
		type:'get',
		success:function(data){
			$("#returnStatus .modal-body").html("发送成功");
			$("#returnStatus").modal("show");
		},
		fail:function(data){
			$("#returnStatus .modal-body").html("发送失败");
			$("#returnStatus").modal("show");
		},
		error:function(data){
			$("#returnStatus .modal-body").html("发送失败，请刷新重试！");
			$("#returnStatus").modal("show");
		}
	});
}



</script>
</body>
</html>