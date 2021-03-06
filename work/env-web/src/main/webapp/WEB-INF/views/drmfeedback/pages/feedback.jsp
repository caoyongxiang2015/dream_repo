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
				<form class="form-horizontal" id="feedback1"  method="post">
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
					    	<label class="col-xs-2 col-md-3 control-label" for="lastname">联系方式</label>
					    	<div class="col-xs-5">
						    	<div class="form-group form-group-lg">
						            <input id="contactType" name="entity.contactType"  type="text" placeholder="邮箱/电话/QQ/微信" class="form-control">
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
    								用户交流QQ群：338471845
								</div>
							</div>
							<div class="col-xs-2">
						    	<div class="form-group form-group-lg">
    								<button type="button" class="btn btn-lg btn-primary btn-block" onclick="fd();">提交</button>
								</div>
							</div>
						</div>
				    </fieldset>
				</form>
			</div>	
		</div>
</div>

<script type="text/javascript">
function fd(){
	
	if(''==$('#content').val()){
		alert("请填写反馈内容，谢谢！");
		return ;
	}
	
	if(''==$('#contactType').val()){
		alert("请填写联系方式，谢谢！");
		return ;
	}
	
	$.ajax({
		url:'${ctx}/ptfeedback/save',
		type:'POST', 
		//dataType:'html',
		data:$('#feedback1').serialize(),
		success:function(data){
			if('1'==data){
				alert("\n\n我们已经收到您的反馈信息，非常感谢您的反馈，我们会及时与您联系！\n\n跳转到首页");
				window.location.href="${ctx}/";
			}else{
				alert("抱歉，提交失败，请刷新重试！");
			}
		}
	});
}
</script>

</body>
</html>