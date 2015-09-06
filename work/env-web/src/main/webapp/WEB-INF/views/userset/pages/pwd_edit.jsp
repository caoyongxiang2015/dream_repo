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

		<form class="form-horizontal" action="${ctx}/ptuserset/pwdsave" method="post">
		
			
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
					<li><a href="javascript:window.location.href='${ctx}/ptuserset/self'" class="button button-royal 	button-rounded button-large">个人资料</a></li>
					<li><a href="javascript:window.location.href='${ctx}/ptuserset/service'" class="button button-royal button-rounded button-large">服务设置</a></li>
					<li><a href="javascript:window.location.href='${ctx}/ptuserset/contact'" class="button button-royal 		button-rounded button-large">联系方式</a></li>
					<li><a href="#" class="button button-highlight 		button-rounded button-large">修改密码</a></li>
						</ul>
					</div> 
				</div>
				<!-- 面包屑 end -->
				
				
				<envbase:flushMessage/>
				
				<div class="envbaseBorder">
				
				
					<input type="hidden" name="entity.id" value="${entity.id }">
				
					<!-- 片段头 begin -->
					<div class="sectionTitle">
						<h5>修改密码</h5>
					</div>
					
					<!-- 片段头 end -->
					<div class="row-fluid">
						<div class="span2 control-group">
						</div>
						<div class="span6 control-group">
							<label class="control-label" for="input1">新密码</label>
							<div class="controls">
								<input type="password" class="span12" id="input1" name="entity.pwd">
							</div>
						</div>
					</div>
					
					<div class="row-fluid">
						<div class="span2 control-group">
						</div>
						<div class="span6 control-group">
							<label class="control-label" for="input2">确认密码</label>
							<div class="controls">
								<input type="password" class="span12" id="input2" name="pwdconfirm">
							</div>
						</div>
					</div>
					
					
					
					<div class="row-fluid">
						<div class="span12 control-group" style="text-align: center;">
							<input type="submit" class="span3 button button-glow button-border button-rounded button-primary" value="保存">
						</div>
					</div>
					
				</div><!-- <div class="envbaseBorder"> -->
			</div>
		</form>
	</div>

</body>
</html>