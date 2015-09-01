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
	    		<li class="current-step">3. 赏金托管</li>
	    		<li>4. 服务</li>
	    		<li>5. 评价并结束</li>
	    	</ol>
	    </div>
    	<section class="release-demand">
    		<div class="row">
    			<div class="col-xs-8 col-xs-offset-2">
	    			<div class="send-respond">
	    				<p class="text-success"><i class="glyphicon glyphicon-ok"></i>恭喜您，提示信息提示信息提示！</p>
	    				<div class="help-block">XXXXXXXX有限公司提示提身体身体提示信息信息信息信息信息金到本平台，待服务结束后，再将赏金转入信息提供者的账户，谢谢</div>
	    				<div class="help-block text-center J-account-info" style="display: none;">支付宝帐号是：xxxxxx，汇款请注明您的ID号</div>
	    				<div class="next-btn">
		    				<button class="btn btn-primary btn-lg btn-block J-sendMoney">托管赏金</button>
	    					<button class="btn btn-primary btn-lg btn-block" data-toggle="modal" style="display: none;" onclick="nn.returnStatus('付款完成信息已经通知客服，平台客服24小时内会审核您的付款情况；会尽快让您与XXX公司员工取得联系！白领去哪网感谢您的支持！谢谢！')">付款完成并通知客服审核</button>
    					</div>
	    				<p class="help-me text-danger">亲，给本平台提提意见或建议吧，有机会赢取大奖哦！</p>
	    			</div>
    			</div>
    		</div>
    	</section>
    </div>
    
	<!-- 发送完成返回弹窗状态 -->
	<div class="modal fade" id="returnStatus" tabindex="-1" role="dialog" aria-labelledby="returnStatus">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<div class="modal-body">
				</div>
				<div class="modal-footer text-center">
					<button type="button" class="btn btn-primary btn-block btn-lg" data-dismiss="modal">确定</button>
				</div>
			</div>
		</div>
	</div>
    
	<script type="text/javascript">
		$(".J-sendMoney").on("click",function(){
			$(this).hide();
			$(this).next().show();
			$(".J-account-info").show();
		})
	</script>
	
</body>
</html>