<%@page import="com.env.constant.Constants"%>
<%@page import="com.env.dto.PtUser"%>
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
	    		<li class="current-step">1. 需求发布</li>
	    		<li>2. 等待应答</li>
	    		<li>3. 赏金托管</li>
	    		<li>4. 服务</li>
	    		<li>5. 评价并结束</li>
	    	</ol>
	    </div>
    	<section class="release-demand">
    		<div class="panel">
    			<div class="panel-heading">
    				<h3 class="panel-title">发布需求</h3>
				</div>
				<div class="panel-body row">
					<div class="col-xs-9">
    				<form class="form-horizontal" id="releaseDemand" action="${ctx }/release/release1_save" method="post">
						<div class="row">
							<label class="col-xs-3 control-label" for="companyShotname">公司名称</label>
							<div class="col-xs-7">
    							<div class="form-group form-group-lg">
		    						<input type="text" id="companyShotname" name="companyShotname" placeholder="公司名称" class="form-control">
		    					</div>
							</div>
							<div class="col-xs-2">
								<p class="help-block">必填</p>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 control-label" for="price">金额</label>
							<div class="col-xs-7">
    							<div class="form-group form-group-lg">
		    						<input type="text" id="price" name="price" placeholder="金额" class="form-control">
		    					</div>
							</div>
							<div class="col-xs-2">
								<p class="help-block">必填</p>
							</div>
						</div>
						
						<%
						PtUser user = (PtUser)request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
						if(null==user){// 未登录%>
						
						<div class="row">
							<label class="col-xs-3 control-label" for="telephone">手机号码</label>
							<div class="col-xs-4">
    							<div class="form-group form-group-lg">
		    						<input type="text" id="telephone" name="telephone" placeholder="手机号码" class="form-control">
								</div>
							</div>
							<div class="col-xs-3">
								<button type="button" class="btn btn-lg btn-primary btn-block">获取手机验证码</button>
							</div>
							<div class="col-xs-2">
								<p class="help-block">必填</p>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 control-label" for="phonecode">验证码</label>
							<div class="col-xs-4">
    							<div class="form-group form-group-lg">
		    						<input type="text" id="phonecode" name="phonecode" placeholder="验证码" class="form-control">		 
		    					</div>
							</div>
							<div class="col-xs-2">
								<p class="help-block">必填</p>
							</div>
						</div>
						
						<%}%>
						
						<div class="row">
							<label class="col-xs-3 control-label" for="content">备注</label>
							<div class="col-xs-7">
    							<div class="form-group form-group-lg">
		    						<textarea id="content" name="content" class="form-control" rows="3" placeholder="捎上一句话"></textarea>		    					
		    					</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-7 col-xs-offset-3">
								<div class="form-group">
    								<button type="submit" class="btn btn-lg btn-primary btn-block">发布</button>
								</div>
							</div>
						</div>
    					</form>
					</div>
					<div class="col-xs-3">
						<div class="col-explain fn-left">
    						<p class="help-block">1、请附上您的诚意金，金额范围一般是您期望薪资的5‰-15‰，单位人民币</p>
    						<p class="help-block">2、当您的需求有人应答之后，需要您将诚意金托管到本平台，待服务结束后，再将金额转入对方账户</p>
    						<p class="help-block">3、金额多少不代表信息的价值</p>
    					</div>
    				</div>
    			</div>
    		</div>
    	</section>
    </div>
    
    
    <script type="text/javascript">
		$("#releaseDemand").validate({
			rules: {
				companyShotname: {required: true},
				price: {required: true},
				telephone: {required: true, digits:true},
				phonecode: {required: true}
			},
			tooltip_options: {
				'_all_': {placement:'right'},
				telephone: {html:true}
			},
		})
	</script>
	
</body>
</html>