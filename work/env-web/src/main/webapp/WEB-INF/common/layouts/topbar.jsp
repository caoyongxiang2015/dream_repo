<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="com.env.constant.Constants"%>
<%@page import="com.env.dto.PtUser"%>
<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<!-- HEADER START -->
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container${fluid}">
			<div class="row${fluid}">
				<div class="span10 offset1">
					<a href="${ctx}/" class="brand"> <i class="icon-flag"
						style="vertical-align: middle;"></i> Sample
					</a>
					<div class="nav-collapse collapse">
						<ul class="nav" role="menu" aria-labelledby="dLabel">

							<li><a href="${ctx}/">Home</a></li>
							<li><a href="${ctx}/sample/index">Sample</a></li>
							<li><a href="${ctx}/userSample/list">单表样例</a></li>
							<li><a href="${ctx}/userDetailSample/userDetailList">多表样例</a></li>
							<li><a href="${ctx}/uploadSample/uploadPage">附件样例</a></li>
							<li><a href="${ctx}/userSample/userListALL">文档下载样例</a></li>
							<shiro:hasPermission name="USER_ADD">
								<li><a href="#">权限加载成功</a></li>
							</shiro:hasPermission>
						</ul>
						<ul class="nav pull-right">
							<li class="dropdown pull-right">
								<a href="#" data-toggle="dropdown" style="padding: 8px 15px;"> 
									<%
									PtUser user = (PtUser)request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
									%>
									<c:choose> 
										<c:when test="<%=(null!=user)%>">   
											<span class="message" title="<%=user.getNickname() %>"><%=user.getNickname() %></span>
										</c:when> 
										<c:otherwise>
											<span class="message" title="">未登录</span>
										</c:otherwise> 
									</c:choose>
									<i class="icon-angle-down"></i>
								</a>
								<ul class="dropdown-menu">
									<li><a href="#" id="userProfile"><i class="icon-cog"></i>&nbsp;个人中心</a></li>
									<li><a href="${ctx}/auth/logout"><i class="icon-off"></i>&nbsp;退出</a></li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$("#userProfile").click(function() {
			EnvbaseUtil.createRemoteModal("个人中心", "${ctx}/commons/userProfileSection", {}, function() {
				var validateValue = $("#changePasswordForm").valid();
				if (validateValue) {
					var oldPassword = $("#oldPassword").val();
					var password = $("#password").val();
					var confirmPassword = $("#confirmPassword").val();
					$.ajax({
						url : "${ctx}/commons/changePassword",
						data : {
							"oldPassword" : oldPassword,
							"password" : password,
							"confirmPassword" : confirmPassword
						},
						dataType : "json",
						type : "GET",
						contentType : "text/html; charset=UTF-8",
						error : function() {
							console.log("error");
						},
						success : function(data) {
							var status = data.status;
							var message = data.message;
							// 修改成功，关闭对话框
							if (0 == status) {

								$("#modal_dialog").modal("hide");
							} else {
								// 弹出消息
								EnvbaseUtil.showAlertMessage($("#userProfileMessage"), message, "error");
							}
						},
					});
					return false;
				} else {
					return false;
				}
			}, "修改密码");
		});
	});
</script>
<!-- HEADER END -->