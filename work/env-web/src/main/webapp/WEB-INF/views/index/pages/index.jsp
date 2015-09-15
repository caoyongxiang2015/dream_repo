<%@page import="com.env.constant.Constants"%>
<%@page import="com.env.dto.PtUser"%>
<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title><spring:message code="index.title"/></title>


<body>

	<!-- [[ 主体部分 -->
	<div class="jumbotron">
		<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
		  <!-- Indicators -->
		  <ol class="carousel-indicators">
		    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
		  </ol>
		  <!-- Wrapper for slides -->
		  <div class="carousel-inner" role="listbox">
		    <div class="item active">
			    <div class="container">
			        <h2>只为帮您选择一个理想职业</h2>
					<p>已收录2000+公司的内部员工</p>
					<p><a class="btn btn-purple btn-lg seek-advice" href="#" role="button">找人咨询</a></p>

		      </div>
		    </div>
		    <div class="item">
			    <div class="container">
		        <h2>只为让您掌握的信息产生价值</h2>
				<p>只为让您帮助更多的人</p>
				<!-- <p><a class="btn btn-purple btn-lg seek-advice" style="color: orange;" href="#" role="button">收到一条请求信息</a></p> -->
		      </div>
		    </div>
		    <div class="item">
			    <div class="container">
		        <h2>面试是一个不对等的双向选择</h2>
				<p>求职路也是一个不断重新认识自己的过程</p>
				<p></p>
		      </div>
		    </div>
		  </div>
		  <!-- Controls -->
		  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
		  <!-- Forms -->
		  <div class="container form-container posr">
		  	
	  		<%
	  		PtUser curUser = (PtUser) request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
	  		if(null!=curUser){
  			%>
	  		<div class="user-form posa" style="top: 50px;">
	  			<div class="regidit-form panel panel-default">
					<div class="panel-heading posr">
						<h3 class="panel-title"><%=curUser.getLoginId() %>，欢迎回来</h3>
					</div>
					<div class="panel-body">
					<!-- 收到的请求消息 -->
						<c:if test="${notices==null || notices.size()<1 }">
							您暂无新消息
						</c:if>
						<c:if test="${notices!=null && notices.size()>0 }">
						<a href="${ctx}/drmreq">您收到新的需求帮助信息，请查看</a>
						</c:if>
					</div> 
				</div>
			</div>
  			<%
	  		}else{
  			%>
		  	<div class="user-form posa">
				<div class="regidit-form panel panel-default">
					<div class="panel-heading posr">
						<h3 class="panel-title">注册</h3>
						<a href="javascript:;" class="posa J-gotologin">登录<i class="glyphicon glyphicon-share-alt"></i></a>
					</div>
					<div class="panel-body">
						<form class="form" id="regiditForm">
							<div class="alert alert-failure" style="padding: 1px;margin-bottom: 5px; background-color:#FF0000; color:#FFFFFF" hidden></div>
							
							<div class="form-group form-group-lg">
								<label for="phone" hidden>手机号：</label>
							    <input type="tel" class="form-control" id="phone" name="phone" placeholder="手机号">
							</div>
							<div class="form-group form-group-lg">
							    <label for="pwd" hidden>密码：</label>
							    <input type="password" class="form-control" id="pwd" name="pwd" placeholder="密码">
							</div>
							<div class="form-inline form-group-lg">
							    <label for="verfityCodeSMS" hidden>短信验证码：</label>
							    <input type="text" class="form-control" id="verfityCodeSMS" name="verfityCodeSMS" placeholder="手机验证码">
								<button type="button" id="getCodeSMS" class="btn btn-success btn-lg">免费获取验证码</button>
							</div>
							<button class="btn btn-form mt15 btn-block btn-lg registerUser" type="button">注册</button>
						</form>
					</div> 
				</div>
				
				<div class="login-form panel panel-default" hidden>
					<div class="panel-heading posr">
						<h3 class="panel-title">登录</h3>
						<a href="javascript:;" class="posa J-gotoregidit">注册<i class="glyphicon glyphicon-share-alt"></i></a>
					</div>
					<div class="panel-body">
						<form id="loginForm" class="form" action="${ctx}/auth/login" method="post">
							<div class="form-group form-group-lg mt15">
								<label for="username" hidden>手机号：</label>
							    <input type="text" class="form-control" id="username" name="username" placeholder="手机号/邮箱/QQ">
							</div>
							<div class="form-group form-group-lg mt15">
							    <label for="password" hidden>密码：</label>
							    <input type="password" class="form-control" id="password" name="password" placeholder="登录密码">
							</div>
							<button class="btn btn-form btn-block btn-login" type="submit">登录</button>
						</form>
					</div>
				</div>
			</div>
	  			<%
		  		}
		  		%>
			</div>
		</div>
	</div>	
	
	
	
	
	<!-- 流程说明 -->
    <div class="container">
	    <div class="section-title">
		    <h2>流程说明</h2>
	    </div>
	    <div class="row flow-detail">
	    	<div class="col-5 panel panel-primary">
	    		<div class="panel-heading">
	    			<h3 class="panel-title">1 需求发布</h3>
	    		</div>
	    		<div class="panel-body">什么什么什么什么什么什么什么什么什么什么什么什么什么什么什么什么什么什么什么什么什么什么什么什么什么什么什么什么什么什么</div>
	    	</div>
	    	<div class="col-5 panel panel-primary">
	    		<div class="panel-heading">
	    			<h3 class="panel-title">2 需求发布</h3>
	    		</div>
	    		<div class="panel-body">什么什么什么什么什么什么什么事没什么说明书</div>
	    	</div>
	    	<div class="col-5 panel panel-primary">
	    		<div class="panel-heading">
	    			<h3 class="panel-title">3 需求发布</h3>
	    		</div>
	    		<div class="panel-body">什么什么什么什么什么什么什么事没什么说明书</div>
	    	</div>
	    	<div class="col-5 panel panel-primary">
	    		<div class="panel-heading">
	    			<h3 class="panel-title">4 需求发布</h3>
	    		</div>
	    		<div class="panel-body">什么什么什么什么什么什么什么事没什么说明书</div>
	    	</div>
	    	<div class="col-5 panel panel-primary">
	    		<div class="panel-heading">
	    			<h3 class="panel-title">5 需求发布</h3>
	    		</div>
	    		<div class="panel-body">什么什么什么什么什么什么什么事没什么说明书</div>
	    	</div>
	    </div>
	    <div class="section-title">
	    	<h2>常见问题</h2>
	    </div>
	    <div class="row">
	    	<div class="col-sm-12 col-md-6 col-lg-6">
	    		<div class="qa-text">
	    			<h4 class="question">好职客是个什么样的网站？</h4>
	    			<p class="answer">答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案</p>
	    		</div>
	    	</div>
	    	<div class="col-sm-12 col-md-6 col-lg-6">
	    		<div class="qa-text">
	    			<h4 class="question">我在好职客能得到什么？</h4>
	    			<p class="answer">答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案</p>
	    		</div>
	    	</div>
	    	<div class="col-sm-12 col-md-6 col-lg-6">
	    		<div class="qa-text">
	    			<h4 class="question">我想了解的公司没有搜索到怎么办？</h4>
	    			<p class="answer">答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案</p>
	    		</div>
	    	</div>
	    	<div class="col-sm-12 col-md-6 col-lg-6">
	    		<div class="qa-text">
	    			<h4 class="question">我想了解的公司没有收录内部员工怎么办？</h4>
	    			<p class="answer">答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案答案</p>
	    		</div>
	    	</div>
	    </div>
	    <div class="section-title examples-title">
	    	<h2>TA们都在这里得到了帮助</h2>
	    </div>
	    <div class="examples">
		    <div class="example-item">
		    	<div class="row">
		    		<div class="col-xs-4">咨询的公司：XXXX有限公司</div>
		    		<div class="col-xs-2">昵称：XXXXX</div>
		    		<div class="col-xs-3">联系方式：188********</div>
		    		<div class="col-xs-3">2015-08-31 20:00:00</div>
		    	</div>
		    	<div class="judgement">评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容</div>
		    </div>
		    <div class="example-item">
		    	<div class="row">
		    		<div class="col-xs-4">咨询的公司：XXXX有限公司</div>
		    		<div class="col-xs-2">昵称：XXXXX</div>
		    		<div class="col-xs-3">联系方式：188********</div>
		    		<div class="col-xs-3">2015-08-31 20:00:00</div>
		    	</div>
		    	<div class="judgement">评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容</div>
		    </div>
		    <div class="example-item">
		    	<div class="row">
		    		<div class="col-xs-4">咨询的公司：XXXX有限公司</div>
		    		<div class="col-xs-2">昵称：XXXXX</div>
		    		<div class="col-xs-3">联系方式：188********</div>
		    		<div class="col-xs-3">2015-08-31 20:00:00</div>
		    	</div>
		    	<div class="judgement">评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容</div>
		    </div>
		    <div class="example-item">
		    	<div class="row">
		    		<div class="col-xs-4">咨询的公司：XXXX有限公司</div>
		    		<div class="col-xs-2">昵称：XXXXX</div>
		    		<div class="col-xs-3">联系方式：188********</div>
		    		<div class="col-xs-3">2015-08-31 20:00:00</div>
		    	</div>
		    	<div class="judgement">评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容</div>
		    </div>
		    <div class="example-item">
		    	<div class="row">
		    		<div class="col-xs-4">咨询的公司：XXXX有限公司</div>
		    		<div class="col-xs-2">昵称：XXXXX</div>
		    		<div class="col-xs-3">联系方式：188********</div>
		    		<div class="col-xs-3">2015-08-31 20:00:00</div>
		    	</div>
		    	<div class="judgement">评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容</div>
	    	</div>
	    	<a href="${ctx }/drmeval">查看更多&gt;&gt;</a>
    	</div>
    </div>
    
<script src="${static_common}/hzk/js/jquery.min.js"></script>

<script type="text/javascript" src="${static_common}/hzk/js/jquery.validate.js"></script>
<script type="text/javascript" src="${static_common}/hzk/js/jquery-validate.bootstrap-tooltip.js"></script>

    	<script type="text/javascript">
		$("#regiditForm").validate({
			rules: {     
				verfityCodeSMS: {required: true},
				pwd: {required: true},
				phone: {required: true}
			},
			tooltip_options: {
				'_all_': {placement:'right'}
			},
		});
		$("#loginForm").validate({
			rules: {     
				password: {required: true},
				username: {required: true}
			},
			tooltip_options: {
				'_all_': {placement:'right'}
			}
		})
		
		//获取手机验证码
		$("#getCodeSMS").on('click',function(){
			$("div.alert-failure").hide();
			if(''==$("#phone").val()){
				$("div.alert-failure").text("请填写手机号");
				$("div.alert-failure").show();
				return ;
			}
			
			$.ajax({
				url:'${ctx}/auth/register/getCode?type=1&phone='+$("#phone").val(),
				type:'post',
				success : function(data) {
					alert(data.message);
				},
				error:function(){
					alert("手机验证码获取失败");
				}  
			});
		})
		
		// 注册
		$(".registerUser").on('click',function(){
			
   			//var pwd=$.md5($('#pwd').val());
   			var phone=$('#phone').val();
   			var pwd=$('#pwd').val();
   			var authCode=$('#verfityCodeSMS').val();
			
   			$("div.alert-failure").hide();
				$("div.alert-failure").text("请填写手机号");
				$("div.alert-failure").show();
				return ;
			if(''==pwd){
				$("div.alert-failure").text("请填写密码");
				$("div.alert-failure").show();
				return ;
			}
			if(''==authCode){
				$("div.alert-failure").text("请填写手机号验证码");
				$("div.alert-failure").show();
				return ;
			}
			
			
			$.ajax({
				url:'${ctx}/auth/register/userRegister'+'?phone='+phone+'&pwd='+pwd+'&authCode='+authCode+'&n='+new Date(),
				type:'post',
				success : function(data) {
					if(data.result==false){
						//alert(data.message);
						$("div.alert-failure").text(data.message);
						$("div.alert-failure").show();
					}
					if(data.result==true){
						alert("注册成功，将跳转到个人资料页面，请完善您的基本资料，谢谢！");
						window.location.href="${ctx}/profile";
					}
				},
				error:function(){
					alert("注册异常");
				} 
			});
		})
		
	</script>
	
</body>
</html>
