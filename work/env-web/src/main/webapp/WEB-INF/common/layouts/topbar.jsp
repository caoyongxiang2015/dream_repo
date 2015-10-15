<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="com.env.constant.Constants"%>
<%@page import="com.env.dto.PtUser"%>
<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<!-- [[ 公共头部 -->
    <header class="navbar-fixed-top">
    	<div class="container clearfix">
    		<div class="logo left">
	    		<a href="${ctx}" class="logo-link">
	    			<h1>好知客</h1>
	    			<img src="${static_common}/hzk/images/haozhike2.png" alt="好知客">
	    		</a>
    		</div>
    		<ul class="nav navbar-nav left" role="navigator">
    			<li class="active"><a href="${ctx }">首页</a></li>
    			<%
				PtUser user = (PtUser)request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
				if(null!=user){// 已经登录%>
    			<li><a href="${ctx }/drmletter">私信</a></li>
    			<li><a href="${ctx }/drmreq">需求</a></li>
    			<li><a href="${ctx }/profile">我的资料</a></li>
    			<%} %>
    		</ul>
    		
    		<% if(null!=user){// 已经登录%>
    		<div class="dropdown right">
	    		<a href="#" class="dropdown-toggle">
		    		<img src="${static_common}/hzk/images/pic.png" alt=""/>
    			</a>
	    		<ul class="dropdown-menu dropup">
	    			<li>
	    				<a href="javascript:;" class="modifypwd_a">修改密码</a>
	    				<a href="javascript:window.location.href='${ctx }/auth/logout'">退出</a>
	    			</li>
		    		<span class="caret posa"></span>
	    		</ul>
    		</div>
   			<%} %>
    		
    		<button class="btn btn-large btn-primary right btn-release" onclick="javascript:window.location.href='${ctx}/release/first'" type="button">发布需求</button>
    		<form id="mysearch" action="${ctx }/drmsearch" class="form-inline search-form right" method="post">
    			<div class="input-group posr">
	    			<input type="text" class="form-control" placeholder="请输入公司简称" id="searchCompany" name="searchCompany">
		    		<i class="glyphicon glyphicon-search posa"></i>
	    			<span class="input-group-btn">
		    			<%-- <button type="button" onclick="javascript:window.location.href='${ctx}/drmsearch'" class="btn btn-success btn-large">搜索</button> --%>
		    			<button type="submit" class="btn btn-success btn-large">搜索</button>
	    			</span>
		    	</div>
    		</form>
    	</div>
	
	
	
	<!-- 登录窗口 [[ -->
	<div class="modal fade" id="modifyPwdFormModel" role="dialog" aria-labelledby="modifyPwdFormModel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="user-form">
					<div class="regidit-form panel panel-default">
						<div class="panel-heading posr">
							<h3 class="panel-title">修改密码</h3>
							<a href="javascript:;" class="posa modifypwd_close">关闭</a>
						</div>
						<div class="panel-body">
							<form id="modifypwdForm" class="form">
								<div id="modifypwdmsg" class="alert alert-failure" role="alert" hidden="hidden"></div>
								<div class="form-group form-group-lg">
								    <label for="oldpwd" hidden>原始密码：</label>
								    <input type="password" class="form-control" id="oldpwd" name="oldpwd" placeholder="原始密码">
								</div>
								<div class="form-group form-group-lg">
								    <label for="newpwd" hidden>新密码：</label>
								    <input type="password" class="form-control" id="newpwd" name="newpwd" placeholder="新密码">
								</div>
								<div class="form-group form-group-lg">
								    <label for="confirmpwd" hidden>确认密码：</label>
								    <input type="password" class="form-control" id="confirmpwd" name="confirmpwd" placeholder="确认密码">
								</div>
								<button class="btn btn-form mt15 btn-block btn-lg modifypwd" type="button">确定修改密码</button>
							</form>
						</div> 
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 登录窗口 ]]-->
	
	
	
<script src="${static_common}/hzk/js/jquery.min.js"></script>

<script type="text/javascript" src="${static_common}/hzk/js/jquery.validate.js"></script>
<script type="text/javascript" src="${static_common}/hzk/js/jquery-validate.bootstrap-tooltip.js"></script>
	
<script type="text/javascript">
		$("#mysearch").validate({
			rules : {
				// 表单的name值
				searchCompany: {required: true}
			},
			tooltip_options: {
				searchCompany: {placement: 'left'}
			}
		})
		
		
		
		$("a.modifypwd_a").on("click",function(){
			$("#modifyPwdFormModel").modal({backdrop:false});
			$("#modifyPwdFormModel").modal("show");
		});
		$(".modifypwd").on("click",function(){
			$("#modifypwdmsg").hide();
			var oldp = $("#oldpwd").val();
			var newp = $("#newpwd").val();
			var conp = $("#confirmpwd").val();
			if(''==oldp){
				$("#modifypwdmsg").text("请填写原始密码！");
				$("#modifypwdmsg").show();
				return;
			}
			if(''==newp){
				$("#modifypwdmsg").text("请填写新密码！");
				$("#modifypwdmsg").show();
				return;
			}
			if(''==conp){
				$("#modifypwdmsg").text("请填写确认密码！");
				$("#modifypwdmsg").show();
				return;
			}
			if(newp !=conp){
				$("#modifypwdmsg").text("新密码与确认密码不一致！");
				$("#modifypwdmsg").show();
				return;
			}
			//修改
			$.ajax({
				url:'${ctx}/ptuser/modifypwd?oldpwd='+oldp+'&newpwd='+newp+'&confirmpwd='+conp,
				type:'post',
				success:function(data){
					if(data.success==false){
						$("#modifypwdmsg").text(data.msg);
						$("#modifypwdmsg").show();
					}
					if(data.success==true){
						alert(data.msg);
						$("#modifyPwdFormModel").modal("hide");
					}
				}
			});
		})
		
		$("a.modifypwd_close").on("click",function(){
			$("#modifyPwdFormModel").modal("hide");
		})
	</script>
	

    </header>
	<!-- 公共头部 ]] -->