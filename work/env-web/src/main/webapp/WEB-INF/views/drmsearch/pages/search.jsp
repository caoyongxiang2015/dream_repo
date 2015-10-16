<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title><spring:message code="index.title" /></title>
</head>
<body>



    <div class="container" style="margin-top: 15px;">
    	<section class="search-result row">
    	
    	<c:if test="${null==company}">
    	
    	
            <div class="col-xs-9 col-sm-8 panel">
                <div class="search-result-info panel-body">
                    <div class="row">
                        <div class="col-xs-2">
                            <!-- <a href="#"><img src="" alt=""></a> -->
                           	基本信息
                        </div>
                        <div class="col-xs-10">
                            <h4>${companyname}</h4>
                            <div class="row">
                            </div>
                            <div class="company-website"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">专长领域</div>
                        <div class="col-xs-10 great-area">尚未收录
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">公司介绍</div>
                        <div class="col-xs-10 company-introduce">
                        		尚未收录
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2"></div>
                        <div class="col-xs-10 company-introduce" style="color: green">
                        		非常抱歉，我们目前还没有收录 [${companyname}] 信息，如果您想了解该公司信息，请点击右侧按钮，我们会尽快为您服务，谢谢！
                        </div>
                    </div>
                </div>
            </div>
            
            
            <div class="col-xs-3 col-sm-4 search-result-reference">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="glyphicon glyphicon-new-window"></i>提醒好知客团队收录该公司</h3>
                    </div>
                    <div class="panel-body"><button class="btn btn-lg btn-success btn-block tellMe" >通知收录该公司及内部员工</button></div>
                </div>
            </div>
            
            </c:if>
            
            
    	<c:if test="${null!=company}">
            <div class="col-xs-9 col-sm-8 panel">
                <div class="search-result-info panel-body">
                    <div class="row">
                        <div class="col-xs-2">
                            <!-- <a href="#"><img src="" alt=""></a> -->
                           	基本信息
                        </div>
                        <div class="col-xs-10">
                            <h4>${company.companyShotname }<span class="company-fullname">${company.companyName }</span></h4>
                            <div class="row">
                                <div class="col-xs-4"><c:if test="${null != company.employeeSum}"><i class="glyphicon glyphicon-user"></i>${company.employeeSum }</c:if></div>
                                <div class="col-xs-3"><c:if test="${null != company.city}"><i class="glyphicon glyphicon-map-marker"></i>${company.city }</c:if></div>
                                <div class="col-xs-5"><c:if test="${null != company.establishDate}"><i class="glyphicon glyphicon-time"></i><f:formatDate value="${company.establishDate }" pattern="yyyy-MM-dd"/></c:if></div>
                            </div>
                            <div class="company-website"><c:if test="${null != company.website}"><i class="glyphicon glyphicon-globe"></i><a href="${company.website }" target="_blank">${company.website }</a></c:if></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">专长领域</div>
                        <div class="col-xs-10 great-area">
                        	<span class="label label-info">${company.fields }</span>
                            <!-- <span class="label label-default">互联网集散中心</span>
                            <span class="label label-primary">New</span>
                            <span class="label label-success">New</span>
                            <span class="label label-warning">New</span>
                            <span class="label label-info">New</span>
                            <span class="label label-danger">New</span> -->
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">公司介绍</div>
                        <div class="col-xs-10 company-introduce">
                        ${company.introduction }
                        </div>
                    </div>
                    
                    
            		
            		<c:if test="${hascurcompany==1 && usercount<1}">
                    <div class="row">
                        <div class="col-xs-2"></div>
                        <div class="col-xs-10 company-introduce" style="color: green">
                        		非常抱歉，我们目前还没有收录 [${companyname}] 内部员工信息，如果您想找到${companyname}内部员工，请点击右侧按钮，我们会尽快为您服务，谢谢！
                        </div>
                    </div>
                    </c:if>
                </div>
            </div>
            
            <div class="col-xs-3 col-sm-4 search-result-reference">
            	<c:if test="${hascurcompany==1 && usercount>0}">
	            	<div class="panel panel-default">
	                    <div class="panel-heading">
	                        <h3 class="panel-title"><i class="glyphicon glyphicon-new-window"></i>已收录该公司${usercount}位员工</h3>
	                    </div>
	                    <div class="panel-body"><button class="btn btn-lg btn-success btn-block" onclick="javascript:window.location.href='${ctx}/release/first?name=${companyname}'">向他们了解公司内部信息</button></div>
	                </div>
	                
	                <div class="panel panel-default">
	                    <div class="panel-heading">
	                        <h3 class="panel-title"><!-- <i class="glyphicon glyphicon-new-window"></i> -->已有<c:if test="${company.remark==null || company.remark==''}">1</c:if><c:if test="${company.remark!=null && company.remark!=''}">${company.remark }</c:if>位小伙伴成功通过他们了解该公司</h3>
	                    </div>
	                    <!-- <div class="panel-body"><button class="btn btn-lg btn-success btn-block">查看</button></div> -->
	                </div>
            	</c:if>
            	
            	
                    
           		<c:if test="${logined==0 || hascurcompany==0}">
           			<div class="panel panel-default">
	                    <div class="panel-heading">
	                        <h3 class="panel-title"><i class="glyphicon glyphicon-new-window"></i>已收录该公司</h3>
	                    </div>
	                    <div class="panel-body">
           		<c:if test="${logined==0}">
	                    	登录并填写您所在公司名称后，可联系该公司内部员工
	                    <button class="btn btn-lg btn-success btn-block cal_login" >登录 / 注册</button>
           		</c:if>
           		<c:if test="${hascurcompany==0}">
	                    	您尚未填写您最近在职的公司名称，填写所在公司名称后，可联系该公司内部员工
	                    <a href="${ctx }/profile">
	                    <button class="btn btn-lg btn-success btn-block" >去完善个人信息</button>
	                    </a>
           		</c:if>
	                    </div>
	                </div>
           		</c:if>
            	
            	<c:if test="${hascurcompany==1 && usercount<1}">
	                <div class="panel panel-default">
	                    <div class="panel-heading">
	                        <h3 class="panel-title"><i class="glyphicon glyphicon-new-window"></i>已收录该公司，尚未找到该公司员工</h3>
	                    </div>
	                    <div class="panel-body"><button class="btn btn-lg btn-success btn-block contactEmployer" >免费委托本平台收录内部员工</button></div>
	                </div>
            	</c:if>
                
            </div>
            
            </c:if>
            
            
    	</section>
    </div>
    
    
    
    
    
    
	<!-- 登录窗口 [[ -->
	<div class="modal fade" id="loginFormModel" role="dialog" aria-labelledby="loginFormModel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="user-form">
					<div class="regidit-form panel panel-default" hidden>
						<div class="panel-heading posr">
							<h3 class="panel-title">注册</h3>
							<a href="javascript:;" class="posa J-gotologin">登录<i class="glyphicon glyphicon-share-alt"></i></a>
						</div>
						<div class="panel-body">
							<form id="regiditForm" class="form">
								<div id="regiditmsg" class="alert alert-failure" role="alert" hidden="hidden"></div>
								<div class="form-group form-group-lg">
									<label for="inputPhone" hidden>手机号：</label>
								    <input type="tel" class="form-control" id="inputPhone" name="inputPhone" placeholder="手机号">
								</div>
								<div class="form-group form-group-lg">
								    <label for="setPassword" hidden>密码：</label>
								    <input type="password" class="form-control" id="setPassword" name="setPassword" placeholder="密码">
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
					<div class="login-form panel panel-default">
						<div class="panel-heading posr">
							<h3 class="panel-title">登录</h3>
							<a href="javascript:;" class="posa J-gotoregidit">注册<i class="glyphicon glyphicon-share-alt"></i></a>
						</div>
						<div class="panel-body">
							<form id="loginForm" class="form"  method="post">
								<div id="loginmsg" class="alert alert-failure" role="alert" hidden="hidden"></div>
								<div class="form-group form-group-lg mt15">
									<label for="username" hidden>手机号：</label>
							    	<input type="text" class="form-control" id="username" name="username" placeholder="手机号">
								</div>
								<div class="form-group form-group-lg mt15">
								    <label for="password" hidden>密码：</label>
							    	<input type="password" class="form-control" id="password" name="password" placeholder="登录密码">
								</div>
								<button class="btn btn-form btn-block btn-login" type="button" onclick="login();">登录</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 登录窗口 ]]-->
	
	
	
	
	<script type="text/javascript">
		$("#regiditForm").validate({
			rules: {     
				verfityCodeSMS: {required: true},
				setPassword: {required: true},
				inputPhone: {required: true}
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
	</script>

	<script type="text/javascript">
	$(".tellMe").on("click",function(){
		if(0=='${logined}'){// 未登录
			$("#loginFormModel").modal("show");
			return;
		}

		// todo 通知收录公司
		$.ajax({
			url:'${ctx}/collnotice/save?colltype=收录公司&companyname=${companyname}',
			type:'post',
			success:function(data){
				alert("您的信息我们已经收到，好知客团队会尽快为您服务，感谢您使用好知客!")
			},
			error:function(data){
				alert("-1");
			}
		});
	});
	$(".contactEmployer").on("click",function(){
		if(0=='${logined}'){// 未登录
			$("#loginFormModel").modal("show");
			return;
		}

		// todo 通知 收录员工
		$.ajax({
			url:'${ctx}/collnotice/save?colltype=收录员工&companyname=${companyname}',
			type:'post',
			success:function(data){
				alert("您的信息我们已经收到，好知客团队会尽快为您服务，感谢您使用好知客!")
			},
			error:function(data){
				alert("-1");
			}
		});
	});
	
	function login(){
		$("#loginmsg").hide();
		if(''==$("#username").val()){
			$("#loginmsg").text("请输入登录名");
			$("#loginmsg").show();
			return ;
		}
		if(''==$("#password").val()){
			$("#loginmsg").text("请输入登录密码");
			$("#loginmsg").show();
			return ;
		}
		
		$.ajax({
			url:'${ctx}/auth/ajaxlogin',
			type:'post',
			data:$('#loginForm').serialize(),
			success:function(data){
				if("1"==data.loginSuccess) {
					alert("登录成功!")
					window.location.reload();
				}else{
					$("#loginmsg").text(data.loginMsg);
					$("#loginmsg").show();
				}
			},
			error:function(data){
				alert("-1");
			}
		});
	}
	
	$(".cal_login").on("click",function(){
		if(0=='${logined}'){// 未登录
			$("#loginFormModel").modal("show");
			return;
		}
	})
	</script>
	
	
	
    	<script type="text/javascript">
		//获取手机验证码
		$("#getCodeSMS").on('click',function(){
			$("#regiditmsg").hide();
			
			if(''==$("#inputPhone").val()){
				$("#regiditmsg").text("请填写手机号");
				$("#regiditmsg").show();
				return ;
			}
			
			$.ajax({
				url:'${ctx}/auth/register/getCode?type=1&pwd=1&phone='+$("#inputPhone").val(),
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
   			var phone=$('#inputPhone').val();
   			var pwd=$('#setPassword').val();
   			var authCode=$('#verfityCodeSMS').val();
			
   			$("#regiditmsg").hide();
   			
			if(''==phone){
				$("#regiditmsg").text("请填写手机号");
				$("#regiditmsg").show();
				return ;
			}
			if(''==pwd){
				$("#regiditmsg").text("请填写密码");
				$("#regiditmsg").show();
				return ;
			}
			if(''==authCode){
				$("#regiditmsg").text("请填写手机号验证码");
				$("#regiditmsg").show();
				return ;
			}
			
			
			$.ajax({
				url:'${ctx}/auth/register/userRegister'+'?phone='+phone+'&pwd='+pwd+'&authCode='+authCode+'&n='+new Date(),
				type:'post',
				success : function(data) {
					if(data.result==false){
						//alert(data.message);
						$("#regiditmsg").text(data.message);
						$("#regiditmsg").show();
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