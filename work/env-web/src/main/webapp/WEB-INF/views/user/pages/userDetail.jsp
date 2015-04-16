<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>用户详情</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#editButton").click(function() {
			$('#input_form').submit();
		});
	});
</script>
</head>
<body>
	<!-- 流式布局，页面上部空出50px-->
	<div class="row${fluid} envbasePage">
		<!-- 水平表单 begin -->
		<form id="input_form" class="form-horizontal valid"
			action="${ctx}/userSample/toEdit/${user.id}" method="get">
			<!-- 页面内容置中，左右各留span1 -->
			<div class="span10 offset1">
				<div id="message"></div>
				<envbase:flushMessage />
				<!-- 页头  begin -->
				<div class="row${fluid}">
					<div class="span12 envbaseTitle">
						<div class="span6">
							<h1 class="pageTitle">用户详情</h1>
						</div>
						<div class="span6" align="right">
							<a href="${ctx}/userSample/toEdit/${user.id}" class="pull-right icon-plus icon-2x pointer i" style="margin-right: 10px;" title="编辑用户"></a>
						</div>
					</div>
				</div>
				<!-- 页头  end -->
				<!-- 面包屑 begin -->
				<div class="row${fluid}">
					<div class="span12">
						<ul class="breadcrumb">
							<li><a href="${ctx}/">首页</a> <span class="divider">/</span></li>
							<li><a href="${ctx}/userSample/list">用户列表</a> <span class="divider">/</span></li>
							<li class="active">用户详情</li>
						</ul>
					</div>
				</div>
				<!-- 面包屑 end -->
				<div class="envbaseBorder">
					<!-- 片段头 begin -->
					<div class="sectionTitle">
						<h5>基本信息</h5>
					</div>
					<!-- 片段头 end -->
					<div class="row${fluid}">
						<div class="span6 control-group">
							<label class="control-label">姓名：
							</label>
							<div class="controls">
								${user.username }
							</div>
						</div>
						<div class="span6 control-group">
							<label class="control-label">年龄：</label>
							<div class="controls">
								&nbsp;
							</div>
						</div>
					</div>

					<div class="row${fluid}">
						<div class="span6 control-group">
							<label class="control-label">性别：</label>
							<div class="controls">
								&nbsp;
							</div>
						</div>
						<div class="span6 control-group">
							<label class="control-label">生日：
							</label>
							<div class="controls">
							&nbsp;
							</div>
						</div>
					</div>
					<!-- 片段头 begin -->
					<div class="sectionTitle">
						<h5>职业信息</h5>
					</div>
					<!-- 片段头 end -->
					<div class="row${fluid}">
						<div class="span6 control-group">
							<label class="control-label">职业：
							</label>
							<div class="controls">
								&nbsp;
							</div>
						</div>
						<div class="span6 control-group">
							<label class="control-label">薪水：</label>
							<div class="controls">
								<fmt:formatNumber value="3500" pattern="#,##0.00"/>
							</div>
						</div>
					<div class="row${fluid}">
						<div class="span12 control-group">
							<label class="control-label" >简介：</label>
							<div class="controls" style="word-break:break-all;">
								&nbsp;
							</div>
						</div>
					</div>
				</div>
				
				<!-- 片段头 begin -->
					<div class="sectionTitle">
						<h5>系统信息</h5>
					</div>
					<!-- 片段头 end -->
					<div class="row${fluid}">
						<div class="span6 control-group">
							<label class="control-label">创建人：
							</label>
							<div class="controls">
								&nbsp;
							</div>
						</div>
						<div class="span6 control-group">
							<label class="control-label">创建时间：</label>
							<div class="controls">
								&nbsp;
							</div>
						</div>
					</div>
					<div class="row${fluid}">
						<div class="span6 control-group">
							<label class="control-label">更新人：
							</label>
							<div class="controls">
								&nbsp;
							</div>
						</div>
						<div class="span6 control-group">
							<label class="control-label">更新时间：</label>
							<div class="controls">
								&nbsp;
							</div>
						</div>
					
				</div>
				</div>
			</div>
		</form>
		<!-- 水平表单 end -->
	</div>
</body>
</html>