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
	    		<li>3. 赏金托管</li>
	    		<li class="current-step">4. 服务</li>
	    		<li>5. 评价并结束</li>
	    	</ol>
	    </div>
    	<section class="release-demand">
    		<div class="row">
    			<div class="col-xs-8 col-xs-offset-2">
	    			<div class="send-respond">
	    				<p class="text-success">服务进行中...</p>
	    				<div class="help-block">请您带着诚意向TA请教问题，待服务完成后，对TA的服务做出评价。默认7天后赏金自动转入对方账户</div>
	    				<div class="help-block">可用【私信/电话1332232244/QQ/邮箱】与TA联系</div>
	    				<div class="next-btn"><button onclick="javascript:window.location.href='${ctx}/release/fifth'" class="btn btn-primary btn-lg btn-block">服务完成</button>
							<button class="btn btn-link" data-toggle="modal" data-target="#sendPriviteMessage">给TA发私信</button>
	    				</div>
	    				<p class="help-me text-danger">亲，给本平台提提意见或建议吧，有机会赢取大奖哦！</p>
	    			</div>
    			</div>
    		</div>
    	</section>
    </div>
    
    
    <!-- 发送私信 [[ -->
	<div class="modal fade" id="sendPriviteMessage" tabindex="-1" role="dialog" aria-labelledby="sendPriviteMessage">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<!--<div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">发送私信</h4>
			    </div>-->
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
	
	
    
    
<script src="${static_common}/hzk/js/jquery.min.js"></script>

<script type="text/javascript" src="${static_common}/hzk/js/jquery.validate.js"></script>
<script type="text/javascript" src="${static_common}/hzk/js/jquery-validate.bootstrap-tooltip.js"></script>
    
	
</body>
</html>