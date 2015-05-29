<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>个人设置</title>
</head>
<body>
	
	<br/>
			<envbase:flushMessage />
	
	
	<!-- 个人资料 begin -->

	<!-- 流式布局，页面上部空出50px-->
	<div class="row${fluid} envbasePage">
		<!-- 页面内容置中，左右各留span1 -->
		<div class="span8 offset1">
			个人资料

			<!--个人资料 水平表单 begin -->
			<form id="filterForm1" class="form-horizontal" action="${ctx }/ptuserset/selfsave" method="post">
				<input type="submit" value="保存个人资料">
				<input type="hidden" name="entity.id" value="${entity.id }">
				<div class="envbaseFilterForm">
					<div class="row${fluid}">
						<div class="span12">
							<div class="span12 filterCondition">
									昵称<input type="text" class="span6" name="entity.nickname" value="${entity.nickname }" >
							</div>
							<div class="span12 filterCondition">
									姓名<input type="text" class="span6" name="entity.realname" value="${entity.realname }" >									
							</div>
							<div class="span12 filterCondition">
									性别
									<input type="radio" class="span3" name="entity.sex" value="1" <c:if test="${entity.sex eq 1 }">checked="checked"</c:if> >男
									<input type="radio" class="span3" name="entity.sex" value="2" <c:if test="${entity.sex eq 2 }">checked="checked"</c:if> >女
							</div>
							<div class="span12 filterCondition">
									工作年限<select class="span6" name="entity.workyears">
										<option value="0" <c:if test="${entity.workyears eq 0 }">selected="selected"</c:if> >应届毕业生</option>
										<option value="1" <c:if test="${entity.workyears eq 1 }">selected="selected"</c:if> >一年以下</option>
									</select>
							</div>
							<!-- 
							<div class="span1 filterAction">
								<span> <i class="pull-right icon-search icon-2x pointer"
									style="margin-right: 15px;"
									onclick="$('#filterForm').submit();"></i>
								</span>
							</div>
 							-->
						</div>
					</div>
				</div>
			</form>

			<!--个人资料 水平表单 end -->
		</div>
		
	
		<!-- 个人资料 end -->	
		
		
		
		
		
	<!-- 服务设置 begin -->

	<!-- 流式布局，页面上部空出50px-->
	<div class="row${fluid} envbasePage">
		<!-- 页面内容置中，左右各留span1 -->
		<div class="span8 offset1">
			服务设置
			
			<!--服务设置 水平表单 begin -->
			<form id="filterForm2" class="form-horizontal" action="${ctx }/ptuserset/servicesave" method="post">
				<input type="submit" value="保存">
				<input type="hidden" name="entity.id" value="${entity.id }">
				<div class="envbaseFilterForm">
					<div class="row${fluid}">
						<div class="span12">
							<div class="span12 filterCondition">
								是否提供线下
								面对面咨询服务
								<input type="radio" class="span3" name="entity.isoffline" value="1" <c:if test="${entity.isoffline eq 1 }">checked="checked"</c:if> >是
								<input type="radio" class="span3" name="entity.isoffline" value="0" <c:if test="${entity.isoffline eq 0 }">checked="checked"</c:if> >否
							</div>
							<div class="span12 filterCondition">线下咨询费用（元/次）
								<input type="text" class="span6" name="entity.offlineprice" value="${entity.offlineprice }" >
							</div>
						</div>
					</div>
				</div>
			</form>

			<!--服务设置 水平表单 end -->
		</div>
		
	
		<!-- 服务设置 end -->	
		
		
		
		
		
	<!-- 联系方式 begin -->

	<!-- 流式布局，页面上部空出50px-->
	<div class="row${fluid} envbasePage">
		<!-- 页面内容置中，左右各留span1 -->
		<div class="span8 offset1">
			联系方式

			<!--联系方式 水平表单 begin -->
			<form id="filterForm3" class="form-horizontal" action="${ctx }/ptuserset/contactsave" method="post">
				<input type="submit" value="保存联系方式">
				<input type="hidden" name="entity.id" value="${entity.id }">
				<div class="envbaseFilterForm">
					<div class="row${fluid}">
						<div class="span12">
							<div class="span12 filterCondition">
								手机号<input type="text" class="span6" name="entity.phone" value="${entity.phone }" >
							</div>
							<div class="span12 filterCondition">
									QQ号码<input type="text" class="span6" name="entity.qq" value="${entity.qq }" >									
							</div>
							<div class="span12 filterCondition">
									邮箱<input type="text" class="span6" name="entity.email" value="${entity.email }" >									
							</div>
							<div class="span12 filterCondition">
									微信号<input type="text" class="span6" name="entity.weixin" value="${entity.weixin }" >									
							</div>
						</div>
					</div>
				</div>
			</form>

			<!-- 联系方式 水平表单 end -->
		</div>
		<!-- 联系方式 end -->	
		
		
		
		
	<!-- 修改密码 begin -->

	<!-- 流式布局，页面上部空出50px-->
	<div class="row${fluid} envbasePage">
		<!-- 页面内容置中，左右各留span1 -->
		<div class="span8 offset1">
			修改密码

			<!--修改密码 水平表单 begin -->
			<form id="filterForm4" class="form-horizontal" action="${ctx }/ptuserset/pwdmodify" method="post">
				<input type="submit" value="保存密码">
				<input type="hidden" name="id" value="${entity.id }">
				<div class="envbaseFilterForm">
					<div class="row${fluid}">
						<div class="span12">
							<div class="span12 filterCondition">
								原始密码<input type="password" class="span6" name="oldpwd" value="" >
							</div>
							<div class="span12 filterCondition">
								新的密码<input type="password" class="span6" name="newpwd" value="" >									
							</div>
							<div class="span12 filterCondition">
								确认密码<input type="password" class="span6" name="newpwdconfirm" value="" >									
							</div>
						</div>
					</div>
				</div>
			</form>

			<!-- 修改密码 水平表单 end -->
		</div>
		<!-- 修改密码 end -->	
		
		
		
	</div>
	
	
</body>
</html>

