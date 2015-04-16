<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示PtCompany</title>
<script type="text/javascript">
    function goToPage(toPage){
        if( toPage != undefined ){
	        with(document.getElementById("currentPage")){
	            value = toPage;
	        }
        }
        else{
	        with(document.getElementById("currentPage")){
	            if(1 > value || value > ${page.pages}){
	                value = ${page.currentPage};
		            return;
		        }
	        }
        }
        document.getElementById("selectForm").submit();
    }
</script>
</head>
<body>
    <a href="/">首页</a>
	<form id="selectForm" name="selectForm" action="${ctx }/ptcompany/list" method="POST">
		<table border="1" id="dataTable">
			<thead>
				<tr>
					<th width="100">id</th>
					<th width="100">单位名称</th>
					<th width="100">记录版本号，每次修改递增1</th>
					<th width="100">逻辑删除标志，1删除0可用</th>
					<th width="100">创建者ID</th>
					<th width="100">创建时间</th>
					<th width="100">修改者ID</th>
					<th width="100">修改时间</th>
					<th width="150">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ptCompanyList}" var="entity">
				<tr>
					<td nowrap="nowrap">
						<c:if test="${null ne entity.id && '' ne entity.id}">
							<c:out value="${entity.id}" />
						</c:if>
						<c:if test="${null eq entity.id || '' eq entity.id}">
							&nbsp;
						</c:if>
					</td>
					<td nowrap="nowrap">
						<c:if test="${null ne entity.companyName && '' ne entity.companyName}">
							<c:out value="${entity.companyName}" />
						</c:if>
						<c:if test="${null eq entity.companyName || '' eq entity.companyName}">
							&nbsp;
						</c:if>
					</td>
					<td nowrap="nowrap">
						<c:if test="${null ne entity.version && '' ne entity.version}">
							<c:out value="${entity.version}" />
						</c:if>
						<c:if test="${null eq entity.version || '' eq entity.version}">
							&nbsp;
						</c:if>
					</td>
					<td nowrap="nowrap">
						<c:if test="${null ne entity.disabled && '' ne entity.disabled}">
							<c:out value="${entity.disabled}" />
						</c:if>
						<c:if test="${null eq entity.disabled || '' eq entity.disabled}">
							&nbsp;
						</c:if>
					</td>
					<td nowrap="nowrap">
						<c:if test="${null ne entity.createUserid && '' ne entity.createUserid}">
							<c:out value="${entity.createUserid}" />
						</c:if>
						<c:if test="${null eq entity.createUserid || '' eq entity.createUserid}">
							&nbsp;
						</c:if>
					</td>
					<td nowrap="nowrap">
						<c:if test="${null ne entity.createTime && '' ne entity.createTime}">
							<f:formatDate value='${entity.createTime}' pattern='yyyy-MM-dd HH:mm:ss' />
						</c:if>
						<c:if test="${null eq entity.createTime || '' eq entity.createTime}">
							&nbsp;
						</c:if>
					</td>
					<td nowrap="nowrap">
						<c:if test="${null ne entity.updateUserid && '' ne entity.updateUserid}">
							<c:out value="${entity.updateUserid}" />
						</c:if>
						<c:if test="${null eq entity.updateUserid || '' eq entity.updateUserid}">
							&nbsp;
						</c:if>
					</td>
					<td nowrap="nowrap">
						<c:if test="${null ne entity.updateTime && '' ne entity.updateTime}">
							<f:formatDate value='${entity.updateTime}' pattern='yyyy-MM-dd HH:mm:ss' />
						</c:if>
						<c:if test="${null eq entity.updateTime || '' eq entity.updateTime}">
							&nbsp;
						</c:if>
					</td>
					<td nowrap="nowrap"><a
						href="${ctx }/ptcompany/delete/${entity.id}">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
						href="${ctx }/ptcompany/toedit/${entity.id}">修改</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>
