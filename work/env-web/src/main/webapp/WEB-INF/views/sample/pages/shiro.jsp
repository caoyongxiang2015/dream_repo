<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>ENVBASE SHIRO SAMPLE</title>
<script type="text/javascript">
</script>
</head>
<body>

	<envbase:flushMessage/>
	
	<!-- 流式布局，页面上部空出50px-->
	<div class="container-fluid" style="margin-top: 50px;">
		<div class="row-fluid">
			<!-- 水平表单 begin -->
			<form class="form-horizontal">
				<!-- 页面内容置中，左右各留span1 -->
				<div class="span10 offset1">
					<!-- 页头  begin -->
					<div class="row-fluid">
						<div class="span12">
							<div class="span6">
								<h3 style="color: #3CA2E3;">警告弹窗样例</h3>
							</div>
							<div class="span6" align="right"></div>
						</div>
					</div>
					<!-- 页头  end -->
					<!-- 面包屑 begin -->
					<div class="row-fluid">
						<div class="span12">
							<ul class="breadcrumb">
								<li><a href="${ctx}/">首页</a> <span class="divider">/</span></li>
								<li><a href="${ctx}/sample/listSample2">样例</a> <span
									class="divider">/</span></li>
								<li class="active">shiro</li>
							</ul>
						</div>
					</div>
					<!-- 面包屑 end -->
					<div
						style="border-style: none solid solid; border-width: 0 1px 1px; border-color: #E2E2E2;">
						
						<div class="sectionTitle">
							<h5>Shiro-先登录</h5>
						</div>
						<div class="row-fluid">
							<div class="span12 control-group">
								<shiro:hasRole name="admin">
									shiro-hasRole: admin
								</shiro:hasRole>
								<br/>
								<shiro:hasPermission name="USER_MENU">
									shiro-hasPermission:USER_MENU
								</shiro:hasPermission>
								<br/>
								<shiro:hasPermission name="USER_ADD">
									shiro-hasPermission:admin-add
								</shiro:hasPermission>
							</div>
						</div>
					</div>
				</div>
			</form>
			<!-- 水平表单 end -->
		</div>
	</div>
</body>
</html>