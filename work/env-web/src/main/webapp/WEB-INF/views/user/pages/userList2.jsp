<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>USER LIST</title>
</head>
<body>
	<div class="row${fluid}">
		<div class="span6">
			<h2 class="page-title">USER LIST</h2>
		</div>
		<div class="span6 header_buttons">
			<a href="${ctx}/testuser?action=create" class="btn blue pull-right"><i
				class="icon-plus"></i></a>
		</div>
	</div>

	<div class="page-container">
		<div class="row${fluid}">
			<div class="span12">
				<form id="filterForm" class="form-inline filterForm"
					action="${ctx}/testuser" method="get">
					<input type="text" name="search_LIKE_id"
						value="${searchParams.LIKE_id}" class="m-wrap small"
						placeholder="ID"> <input type="text"
						name="search_LIKE_name" value="${searchParams.LIKE_name}"
						class="m-wrap small" placeholder="姓名"> <input type="text"
						name="search_LIKE_sex" value="${searchParams.LIKE_sex}"
						class="m-wrap small" placeholder="性别"> <input type="text"
						name="search_LIKE_birthDay"
						value="${searchParams.LIKE_birthDay}" class="m-wrap small"
						placeholder="生日">
					<div class="buttons pull-right">
						<i class="icon-search icon-2x pointer"
							onclick="$('#filterForm').submit();"></i>
					</div>
				</form>
			</div>
		</div>
		<table class="table table-striped table-advance table-hover">
			<thead>
				<tr>
					<th width="100">ID</th>
					<th width="100">姓名</th>
					<th width="100">性别</th>
					<th width="100">生日</th>
					<th width="100">城市</th>
					<th width="100">身高</th>
					<th width="150">操作</th>
				</tr>
			</thead>
			<c:forEach items="${userList}" var="testUser">
				<tr>
					<td nowrap="nowrap"><a href="#">test</a></td>
					<td nowrap="nowrap"><c:if
							test="${null ne testUser.username && '' ne testUser.username}">
							<c:out value="${testUser.username}" />
						</c:if> <c:if test="${null eq testUser.username || '' eq testUser.username}">
							&nbsp;
						</c:if></td>
					<td nowrap="nowrap"></td>
					<td nowrap="nowrap"></td>
					<td nowrap="nowrap"></td>
					<td nowrap="nowrap"></td>
					<td nowrap="nowrap"><i class="icon-edit pointer icon-large"
						onclick="window.location='${ctx}/sample/${testUser.id}?action=edit'"></i>
						&nbsp;&nbsp; <i title="删除" class="icon-minus pointer icon-large"
						onclick="deleteById('${testUser.id}')"> </i></td>
				</tr>
			</c:forEach>
		</table>
		<div class="row${fluid}">
			<envbase:pagination page="${page}" />
		</div>
	</div>
	
	<script type="text/javascript">
		var deleteById = function(testuserId) {
			createModal("删除用户", "确定要删除该用户？", function() {
				$.ajax({
					url : '${ctx}/sample/' + testuserId,
					type : "DELETE",
					dataType : "json",
					success : function() {
						window.location.reload();
					}
				});
			});
		};
	</script>
</body>
</html>
