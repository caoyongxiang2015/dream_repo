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

<div class="setting-profile panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">意见反馈</h3>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" id="feedback1" action="${ctx }/ptfeedback/save" method="post">
				<input type="hidden" name="userid" value="curuser.id">
				    <fieldset>
					    <div class="row">
					    	<label class="col-xs-2 col-md-3 control-label" for="callerName">称呼</label>
					    	<div class="col-xs-5">
						    	<div class="form-group form-group-lg">
						            <input type="text" placeholder="称呼" id="callerName" name="entity.callerName" class="form-control">
						        </div>
					    	</div>
					    </div>
					    <div class="row">
					    	<label class="col-xs-2 col-md-3 control-label" for="lastname">联系发送</label>
					    	<div class="col-xs-5">
						    	<div class="form-group form-group-lg">
						            <input id="lastname" name="entity.contactType"  type="text" placeholder="邮箱/电话/QQ/微信" class="form-control">
						        </div>
					    	</div>
					    </div>
					    <div class="row">
					    	<label class="col-xs-2 col-md-3 control-label" for="content">反馈内容</label>
					    	<div class="col-xs-5">
						    	<div class="form-group form-group-lg">
		    						<textarea id="content" name="entity.content" class="form-control" rows="3" placeholder="感谢您填写反馈内容，对我们是极大的鼓舞"></textarea>		    					
		    					</div>
					    	</div>
					    </div>
						<div class="row">
					    	<label class="col-xs-2 col-md-3 control-label" for=""></label>
							<div class="col-xs-3">
						    	<div class="form-group form-group-lg">
    								用户交流群：52638921
								</div>
							</div>
							<div class="col-xs-2">
						    	<div class="form-group form-group-lg">
    								<button type="submit" class="btn btn-lg btn-primary btn-block">提交</button>
								</div>
							</div>
						</div>
				    </fieldset>
				</form>
			</div>	
		</div>
		
		
</div>
</body>
</html>