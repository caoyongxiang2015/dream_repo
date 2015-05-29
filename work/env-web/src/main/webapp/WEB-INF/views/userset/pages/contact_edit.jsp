<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>envbase form sample</title>
</head>
<body>
	<!-- 流式布局，页面上部空出50px-->
	<div class="row-fluid envbasePage">
		<!-- 水平表单 begin -->
		<form class="form-horizontal" action="${ctx}/ptuserset/contactsave" method="post">
		
			
			
			<!-- 页面内容置中，左右各留span1 -->
			<div class="span8 offset2">
				<!-- 页头  begin -->
				<div class="row-fluid">
					<div class="span12 envbaseTitle">
						<div class="span6">
							<h1 class="pageTitle">设置</h1>
						</div>
						<div class="span6" align="right">
						</div>
					</div>
				</div>
				<!-- 页头  end -->
				
				
				
				<!-- 面包屑 begin -->
				<div class="row-fluid">
				
					<div class="span12">
						<ul class="breadcrumb">
						<!-- 
						button-highlight  黄色
						button-royal 蓝色
						button-rounded 圆角方形
						button-large 大小
						 -->
					<li><a href="#" class="button button-royal 	button-rounded button-large">个人资料</a></li>
					<li><a href="javascript:window.location.href='${ctx}/ptuserset/service'" class="button button-royal button-rounded button-large">服务设置</a></li>
					<li><a href="javascript:window.location.href='${ctx}/ptuserset/contact'" class="button button-highlight 		button-rounded button-large">联系方式</a></li>
					<li><a href="javascript:window.location.href='${ctx}/ptuserset/pwd_edit'" class="button button-royal 		button-rounded button-large">修改密码</a></li>
						</ul>
					</div> 
				</div>
				<!-- 面包屑 end -->
				
				
				<div class="envbaseBorder">
				
				
				<input type="hidden" name="entity.id" value="${entity.id }">
				
				
					<!-- 片段头 begin -->
					<div class="sectionTitle">
						<h5>联系方式</h5>
					</div>
					
					<!-- 片段头 end -->
					<div class="row-fluid">
						<div class="span6 control-group">
							<label class="control-label" for="input1">手机号</label>
							<div class="controls">
								<input type="text" class="span10" id="input1" name="entity.phone" value="${entity.phone }">
							</div>
						</div>
						<div class="span6 control-group">
							<label class="control-label" for="input2">QQ号码<span
								style="color: red;">*</span></label>
							<div class="controls">
								<input type="text" class="span10" id="input2" name="entity.qq" value="${entity.qq }">
							</div>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6 control-group">
							<label class="control-label" for="input3">微信号</label>
							<div class="controls">
								<div class="span10 input-append">
									<input type="text" class="span10" id="input3" name="entity.weixin" value="${entity.weixin }">
								</div>
							</div>
						</div>
						<div class="span6 control-group">
							<label class="control-label" for="input4">邮箱</label>
							<div class="controls">
								<div class="span10 input-append">
									<input type="text" class="span10" id="input4" name="entity.email" value="${entity.email }">
								</div>
							</div>
						</div>
					</div>
					
					
					<div class="row-fluid">
						<div class="span12 control-group" style="text-align: center;">
							<a href="javascript:window.location.href='${ctx }/ptuserset/contact'">取消</a>&nbsp;&nbsp;
							<input type="submit" class="span3 button button-glow button-border button-rounded button-primary" value="保存">
						</div>
					</div>
					
					
					
				</div><!-- <div class="envbaseBorder"> -->
			</div>
		</form>
		<!-- 水平表单 end -->
	</div>

</body>
</html>