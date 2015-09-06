<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>用户列表</title>
</head>
<body>
	<!-- 流式布局，页面上部空出50px-->
	<div class="row${fluid} envbasePage">
		<!-- 页面内容置中，左右各留span1 -->
		<div class="span10 offset1">
			<div id="message"></div>
			<!-- 页头  begin -->
			<div class="row${fluid}">
				<div class="envbaseTitle span12">
					<div class="span3">
						<h1 class="pageTitle">USER LIST</h1>
					</div>
					<div class="span5"></div>
					<div class="span4" align="right">
						<span> 
							<shiro:hasPermission name="USER_ADD">
								<a href="${ctx}/userSample/toAdd" class="pull-right icon-plus icon-2x pointer i" style="margin-right: 10px;" title="新增用户"></a>
							</shiro:hasPermission>
						
						</span>
					</div>
				</div>
			</div>
			<!-- 页头  end -->
			<!-- 面包屑 begin -->
			<div class="row${fluid}">
				<div class="span12">
					<ul class="breadcrumb">
						<li><a href="${ctx}/">首页</a> <span class="divider">/</span></li>
						<li class="active">用户列表</li>
					</ul>
				</div>
			</div>
			<!-- 面包屑 end -->

			<!-- 水平表单 begin -->
			<form id="filterForm" class="form-horizontal" action="${ctx}/userSample/list" method="get">

				<div class="envbaseFilterForm">
					<div class="row${fluid}">
						<div class="span12">
							<div class="span11 filterCondition">
								<span> 
									<input type="text" class="span2" name="search_LIKE_username" value="${param['search_LIKE_username']}" placeholder="姓名">
									<select class="span2" name="search_EQ_sex" data-placeholder="性别">
										<option <c:if test="${empty param['search_EQ_age'] }">selected="selected"</c:if> ></option>
										<option value="0" <c:if test="${param['search_EQ_sex'] eq 0 }">selected="selected"</c:if> >男士</option>
										<option value="1" <c:if test="${param['search_EQ_sex'] eq 1 }">selected="selected"</c:if> >女士</option>
									</select>
								</span>
							</div>
							<div class="span1 filterAction">
								<span> <i class="pull-right icon-search icon-2x pointer"
									style="margin-right: 15px;"
									onclick="$('#filterForm').submit();"></i>
								</span>
							</div>

						</div>
					</div>
				</div>
			</form>

			<!-- 水平表单 end -->
			<div class="envbaseList">
				<c:forEach items="${userList}" var="user">
					<div class="row${fluid}">
						<div class="span12">
							<!-- 最左列，通常放入可唯一识别当前记录的字段，比如客户名，如没有，可放入ID -->
							<div class="number span2">
								<span> 
									<a href="${ctx}/userSample/detail/${user.id}" title="姓名">${user.username}</a>
								</span>
							</div>
							<!-- 记录要展示的数据，此处按列排，不是按行排 -->
							<div class="content span9">
								<div class="row${fluid}">
									<!-- 第一 列 -->
									<div class="span4">
										<dl class="dl-horizontal">
											<dt>年龄：</dt>
											<dd>&nbsp;</dd>
											<dt>生日：</dt>
											<dd>&nbsp;</dd>
											<dt>性别：</dt>
											<dd>&nbsp;</dd>
											<dt>薪水：</dt>
											<dd>&nbsp;</dd>
										</dl>
									</div>
									<!-- 第二 列 -->
									<div class="span4">
										<dl class="dl-horizontal">
											<dt>职业：</dt>
											<dd>软件工程师</dd>
											<dt>&nbsp;</dt>
											<dd>&nbsp;</dd>
											<dt>&nbsp;</dt>
											<dd>&nbsp;</dd>
											<dt>&nbsp;</dt>
											<dd>&nbsp;</dd>
										</dl>
									</div>
									<!-- 第三 列 -->
									<div class="span4">
										<dl class="dl-horizontal">
											<dt>&nbsp;</dt>
											<dd>&nbsp;</dd>
											<dt>&nbsp;</dt>
											<dd>&nbsp;</dd>
											<dt>创建人：</dt>
											<dd>&nbsp;</dd>
											<dt>创建时间：</dt>
											<dd>&nbsp;</dd>
										</dl>
									</div>
								</div>
							</div>
							<!-- 操作按钮 
							说明：
							   按钮每行至多放三个，超过三个，请用<br>换行
							-->
							<div class="action span1">
								<span> 
								    <i title="编辑" class="icon-edit pointer pull-left" style="margin-left:15px;" onclick="window.location='${ctx}/userSample/toEdit/${user.id}'"></i>
									<i title="删除" class="icon-minus pointer pull-left" style="margin-left:15px;" onclick="deleteById('${user.id}')"> </i>
								</span>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<!-- 分页 -->
			<div class="row${fluid}">
				<envbase:pagination page="${page}"  />
				<%-- 
				<input type="hidden" name="pageSize" value="${page.pageSize}"/>
				<div style="float:right; height:24px; line-height:20px; margin-top:-4px;">
			    	本页显示
			    	<select id="pageSize" style="width:50px; height:24px;line-height:24px;">
			    		<option value="10" >10</option>
			    		<option value="20" >20</option>
			    		<option value="50" >50</option>
			    	</select>页
			    </div>
				 --%>	
			</div>
		</div>
	</div>
	
	
	<!-- SCRIPT -->
	<script type="text/javascript">
		/* 
		$.initover(function() {
			app.initWithContext("handleAccordion", "#accordion2");
		});
		
		$("#menu_jobS").addClass("active");
		
		var pageSize = '${page.pageSize}';
		$("#pageSize").val(pageSize);
		$("#pageSize").trigger("liszt:updated");
		
		$("#pageSize").change(function(){
			alert(this.value);
			$("input[name='pageSize']").val(this.value);
			EnvbaseUtil.turn2Page(1);
		});
		 */
	</script>
	<script type="text/javascript">
		var deleteById = function(id) {
			EnvbaseUtil.createModal('删除用户', '确定要删除该用户？', function() {
				$.ajax({
					url : ctx + '/userSample/deleteById/'+ id,
					type : "DELETE",
					success : function(data) {
						window.location.reload();
						EnvbaseUtil.showAlertMessage(
									$("#message"),
									"用户删除失败！",
									"error"); 
					}
				});
			});
		};
	</script>
</body>
</html>

