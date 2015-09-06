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
	    		<li>4. 服务</li>
	    		<li class="current-step">5. 评价并结束</li>
	    	</ol>
	    </div>
    	<section class="release-demand">
    		<div class="row">
    			<div class="col-xs-8 col-xs-offset-2">
	    			<div class="send-respond">
	    				<p class="text-success"><i class="glyphicon glyphicon-ok"></i>服务完成，请评价热心的小伙伴吧，鼓励鼓励TA！</p>
	    				<div class="help-block text-center">评价完成后，赏金将转入对方的账户</div>
	    				<div class="give-mark row">
		    				<div class="col-xs-2 text-right">请评分：</div>
		    				<div class="col-xs-8">
			    				<div class="mark-stars">
				    				<i class="glyphicon glyphicon-star"></i>
			    					<i class="glyphicon glyphicon-star"></i>
			    					<i class="glyphicon glyphicon-star"></i>
			    					<i class="glyphicon glyphicon-star"></i>
			    					<i class="glyphicon glyphicon-star"></i>
			    					<span class="J-score" hidden></span>
			    					<span hidden>分</span>
			    				</div>
			    				<div class="form-group">
		    						<textarea class="form-control" name="judgment" rows="5" cols="10"></textarea>
			    				</div>
		    				</div>
	    				</div>
	    				<div class="next-btn"><button class="btn btn-primary btn-lg btn-block">完成评价并结束</button>
							<button class="btn btn-link" data-toggle="modal" data-target="#complainHim">投诉TA</button>
	    				</div>
	    				<p class="help-me text-danger">亲，给本平台提提意见或建议吧，有机会赢取大奖哦！</p>
	    			</div>
    			</div>
    		</div>
    	</section>
    </div>
    
    
    <!-- 投诉框 [[ -->
	<div class="modal fade" id="complainHim" tabindex="-1" role="dialog">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="exampleModalLabel">我要投诉</h4>
	      </div>
	      <div class="modal-body">
	        <form>
	          <div class="form-group">
	            <label for="recipient-name" class="control-label">投诉原因:</label>
	            <select name="recipient-name" id="recipient-name" class="form-control">
		            <option value="0" selected>投诉云因11111</option>
		            <option value="">投诉原因1</option>
		            <option value="">投诉原因2</option>
		            <option value="">投诉原因3</option>
	            </select>
	          </div>
	          <div class="form-group">
	            <label for="message-text" class="control-label">补充说明:</label>
	            <textarea class="form-control" id="message-text" placeholder="补充说明"></textarea>
	          </div>
	        </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-link" data-dismiss="modal">取消</button>
	        <button type="button" class="btn btn-primary btn-lg J-submit-complain" data-dismiss="modal" onclick="nn.returnStatus('提交成功！')">提交</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- 投诉框 ]] -->

	<!-- 返回结果两种表现方式 -->
	<!-- 投诉结果 1 [[ -->
		<!-- 
			此处为在投诉弹出框中点击确定投诉之后，弹出的投诉成功提示框
		 -->
	<!--<div class="complain-result" hidden><div class="alert alert-success" role="alert">投诉提交成功</div></div>-->
	<!-- 投诉结果 1 ]] -->
	<!-- 发送完成返回弹窗状态 2 -->
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