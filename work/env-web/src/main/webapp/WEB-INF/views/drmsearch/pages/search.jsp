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
            <div class="col-xs-9 col-sm-8 panel">
                <div class="search-result-info panel-body">
                    <div class="row">
                        <div class="col-xs-2">
                            <a href="#"><img src="" alt=""></a>
                        </div>
                        <div class="col-xs-10">
                            <h4>${company.companyShotname }<span class="company-fullname">${company.companyName }</span></h4>
                            <div class="row">
                                <div class="col-xs-4"><i class="glyphicon glyphicon-user"></i>${company.employeeSum }</div>
                                <div class="col-xs-3"><i class="glyphicon glyphicon-map-marker"></i>${company.city }</div>
                                <div class="col-xs-5"><i class="glyphicon glyphicon-time"></i><f:formatDate value="${company.establishDate }" pattern="yyyy-MM-dd"/></div>
                            </div>
                            <div class="company-website"><i class="glyphicon glyphicon-globe"></i><a href="#">${company.website }</a></div>
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
                </div>
            </div>
            <div class="col-xs-3 col-sm-4 search-result-reference">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="glyphicon glyphicon-new-window"></i>已收录该公司3名员工</h3>
                    </div>
                    <div class="panel-body"><button class="btn btn-lg btn-success btn-block">向他们了解公司内部信息</button></div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="glyphicon glyphicon-new-window"></i>尚未收录该公司员工</h3>
                    </div>
                    <div class="panel-body"><button class="btn btn-lg btn-success btn-block" data-toggle="modal" data-target="#loginFormModel">免费委托本平台联系内部员工</button></div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="glyphicon glyphicon-new-window"></i>有15位小伙伴通过该平台找到该公司内部员工</h3>
                    </div>
                    <div class="panel-body"><button class="btn btn-lg btn-success btn-block">查看</button></div>
                </div>
            </div>
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
								<button type="submit" class="btn btn-form mt15 btn-block btn-lg">注册</button>
							</form>
						</div> 
					</div>
					<div class="login-form panel panel-default">
						<div class="panel-heading posr">
							<h3 class="panel-title">登录</h3>
							<a href="javascript:;" class="posa J-gotoregidit">注册<i class="glyphicon glyphicon-share-alt"></i></a>
						</div>
						<div class="panel-body">
							<form id="loginForm" class="form">
								<div class="form-group form-group-lg mt15">
									<label for="loginName" hidden>手机号：</label>
								    <input type="text" class="form-control" id="loginName" name="loginName" placeholder="手机号/邮箱/QQ">
								</div>
								<div class="form-group form-group-lg mt15">
								    <label for="loginPassword" hidden>密码：</label>
								    <input type="password" class="form-control" id="loginPassword" name="loginPassword" placeholder="登录密码">
								</div>
								<button class="btn btn-form btn-block btn-login" type="submit">登录</button>
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
				loginPassword: {required: true},
				loginName: {required: true}
			},
			tooltip_options: {
				'_all_': {placement:'right'}
			}
		})
	</script>

</body>
</html>