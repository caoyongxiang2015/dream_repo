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


	<!-- [[ 主体部分 -->
	<div class="container" style="margin-top: 15px;">
		<!-- alert start -->
		<div class="alert alert-success" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			个人资料信息保存成功！
		</div>
		<!-- alert end -->
		<!-- 设置个人信息 start -->
		<div class="setting-profile panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">个人信息<span>本平台承诺严格保密您的个人信息</span></h3>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" id="personalProfile">
				    <fieldset>
					    <div class="row">
					    	<label class="col-xs-2 col-md-3 control-label" for="input01">昵称</label>
					    	<div class="col-xs-5">
						    	<div class="form-group form-group-lg">
						            <input type="text" placeholder="昵称" id="input01" name="input01" class="form-control">
						        </div>
					    	</div>
					    </div>
					    <div class="row">
					    	<label class="col-xs-2 col-md-3 control-label" for="input02">姓</label>
					    	<div class="col-xs-3 col-md-3">
						    	<div class="form-group form-group-lg">
						            <input id="input02" name="input02" type="text" placeholder="姓" class="form-control">
						        </div>
					    	</div>
					    	<div class="col-xs-2 col-md-2">
						    	<div class="form-inline">
						            <label class="radio inline">
						            	<input type="radio" value="1" checked="checked" name="group">
						              	男
						            </label>
						            <label class="radio inline">
						            	<input type="radio" value="2" name="group">
						            	女
						            </label>
						            <label class="radio inline">
						            	<input type="radio" value="3" name="group">
						            	保密
						            </label>
						        </div>
					    	</div>
					    	<div class="col-xs-4 col-md-3">
					    		<p class="help-block">必填</p>
					    	</div>
					    </div>
					    <div class="row">
					    	<label class="col-xs-2 col-md-3 control-label" for="input03">名</label>
					    	<div class="col-xs-5">
						    	<div class="form-group form-group-lg">
						            <input id="input03" type="text" placeholder="名" class="form-control">
						        </div>
					    	</div>
					    	<div class="col-xs-5 col-md-4">
						    	<!--<p class="help-block">本平台承诺严格保密您的姓名</p>-->
					    	</div>
					    </div>
					    <div class="worked-experience row">
							<label class="col-xs-2 col-md-3 control-label">公司</label>
							<div class="col-xs-10 col-md-9">
							    <!-- Nav tabs -->
								<ul class="nav nav-tabs" role="tablist">
									<li role="presentation" class="active"><a href="#persent" aria-controls="persent" role="tab" data-toggle="tab">当前在职公司</a></li>
									<li role="presentation"><a href="#previous" aria-controls="previous" role="tab" data-toggle="tab">上一家公司</a></li>
								</ul>
								<!-- Tab panes -->
								<div class="tab-content">
									<div role="tabpanel" class="tab-pane active" id="persent">
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg"><input type="text" placeholder="公司名称（当前在职的）" id="companyInput01" name="companyInput01" class="form-control"></div>
											</div>
											<div class="col-xs-5"><p class="help-block">必填</p></div>
										</div>
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg"><input type="text" placeholder="部门名称（当前在职的）" id="companyInput02" class="form-control"></div>
											</div>
											<div class="col-xs-5"></div>
										</div>
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg">
													<select id="companyInput03" class="form-control">
														<option value="val0" selected="selected">请选择</option>
														<option value="val1">1年</option>
														<option value="val2">2年</option>
														<option value="val3">3年</option>
													</select>
												</div>
											</div>
											<div class="col-xs-5"></div>
										</div>
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg"><input type="text" id="moneyInput01" name="moneyInput01" placeholder="需要支付的金额" class="form-control"></div>
											</div>
											<div class="col-xs-1">
												<p class="help-block">必填</p>
											</div>
											<div class="col-xs-4">
												<p class="help-block">说明什么说明什么说明什么说明书</p>
											</div>
										</div>
										<div class="sperate-line"></div>
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg"><input type="text" id="companyCatagory01" name="companyCatagory01" placeholder="公司所在领域" class="form-control"></div>
											</div>
											<div class="col-xs-5">
												<p class="help-block">使用中文逗号进行分割</p>
											</div>
										</div>
										<p class="suggestion">建议：</p>
										<div class="label-collected" id="labelCollect01">
											<button type="button" class="btn btn-default btn-sm">设计网络</button>
											<button type="button" class="btn btn-default btn-sm">移动支付</button>
											<button type="button" class="btn btn-default btn-sm">互联网</button>
											<button type="button" class="btn btn-default btn-sm">O2O</button>
											<button type="button" class="btn btn-default btn-sm">互联网</button>
											<button type="button" class="btn btn-default btn-sm">O2O</button>
											<button type="button" class="btn btn-default btn-sm">金融</button>
											<button type="button" class="btn btn-default btn-sm">操作系统</button>
											<button type="button" class="btn btn-default btn-sm">政务服务</button>
											<button type="button" class="btn btn-default btn-sm">云计算</button>
											<button type="button" class="btn btn-default btn-sm">移动支付</button>
											<button type="button" class="btn btn-default btn-sm">互联网</button>
											<button type="button" class="btn btn-default btn-sm">设计网络</button>
											<button type="button" class="btn btn-default btn-sm">移动支付</button>
											<button type="button" class="btn btn-default btn-sm">互联网</button>
											<button type="button" class="btn btn-default btn-sm">O2O</button>
											<button type="button" class="btn btn-default btn-sm">金融</button>
											<button type="button" class="btn btn-default btn-sm">操作系统</button>
											<button type="button" class="btn btn-default btn-sm">移动支付</button>
											<button type="button" class="btn btn-default btn-sm">互联网</button>
											<button type="button" class="btn btn-default btn-sm">O2O</button>
											<button type="button" class="btn btn-default btn-sm">金融</button>
											<button type="button" class="btn btn-default btn-sm">操作系统</button>
											<button type="button" class="btn btn-default btn-sm">政务服务</button>
											<button type="button" class="btn btn-default btn-sm">云计算</button>
										</div>
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg">
													<input type="text" id="companyAddon" placeholder="备注" class="form-control">
												</div>
											</div>
											<div class="col-xs-5">
												<p class="help-block">可以说明具体情况！</p>
											</div>
										</div>
									</div>
									<div role="tabpanel" class="tab-pane" id="previous">
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg"><input type="text" placeholder="公司名称（上一家公司）" id="previousCompanyInput01" name="previousCompanyInput01" class="form-control"></div>
											</div>
											<div class="col-xs-5"><p class="help-block">必填</p></div>
										</div>
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg"><input type="text" placeholder="部门名称（上一家公司）" id="previousCompanyInput02" class="form-control"></div>
											</div>
											<div class="col-xs-5"></div>
										</div>
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg">
													<select id="previousCompanyInput03" class="form-control">
														<option value="val0" selected="selected">请选择</option>
														<option value="val1">1年</option>
														<option value="val2">2年</option>
														<option value="val3">3年</option>
													</select>
												</div>
											</div>
											<div class="col-xs-5"></div>
										</div>
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg"><input type="text" id="moneyInput" placeholder="需要支付的金额" class="form-control"></div>
											</div>
											<div class="col-xs-1">
												<p class="help-block">必填</p>
											</div>
											<div class="col-xs-4">
												<p class="help-block">说明什么说明什么说明什么说明书</p>
											</div>
										</div>
										<div class="sperate-line"></div>
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg"><input type="text" id="companyCatagory02" placeholder="公司所在领域" class="form-control"></div>
											</div>
											<div class="col-xs-5">
												<p class="help-block">使用中文逗号进行分割</p>
											</div>
										</div>
										<p class="suggestion">建议：</p>
										<div class="label-collected" id="labelCollect02">
											<button type="button" class="btn btn-default btn-sm">设计网络</button>
											<button type="button" class="btn btn-default btn-sm">移动支付</button>
											<button type="button" class="btn btn-default btn-sm">互联网</button>
											<button type="button" class="btn btn-default btn-sm">O2O</button>
											<button type="button" class="btn btn-default btn-sm">互联网</button>
											<button type="button" class="btn btn-default btn-sm">O2O</button>
											<button type="button" class="btn btn-default btn-sm">金融</button>
											<button type="button" class="btn btn-default btn-sm">操作系统</button>
											<button type="button" class="btn btn-default btn-sm">政务服务</button>
											<button type="button" class="btn btn-default btn-sm">云计算</button>
											<button type="button" class="btn btn-default btn-sm">移动支付</button>
											<button type="button" class="btn btn-default btn-sm">互联网</button>
											<button type="button" class="btn btn-default btn-sm">设计网络</button>
											<button type="button" class="btn btn-default btn-sm">移动支付</button>
											<button type="button" class="btn btn-default btn-sm">互联网</button>
											<button type="button" class="btn btn-default btn-sm">O2O</button>
											<button type="button" class="btn btn-default btn-sm">金融</button>
											<button type="button" class="btn btn-default btn-sm">操作系统</button>
											<button type="button" class="btn btn-default btn-sm">移动支付</button>
											<button type="button" class="btn btn-default btn-sm">互联网</button>
											<button type="button" class="btn btn-default btn-sm">O2O</button>
											<button type="button" class="btn btn-default btn-sm">金融</button>
											<button type="button" class="btn btn-default btn-sm">操作系统</button>
											<button type="button" class="btn btn-default btn-sm">政务服务</button>
											<button type="button" class="btn btn-default btn-sm">云计算</button>
										</div>
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg">
													<input type="text" id="companyAddon" name="companyAddon" required placeholder="备注" class="form-control">
												</div>
											</div>
											<div class="col-xs-5">
												<p class="help-block">可以说明具体情况！</p>
											</div>
										</div>
									</div>
								</div>
							</div>
					    </div>
						<div class="row">
							<label class="col-xs-2 col-md-3 control-label" for="qqInput">QQ</label>
							<div class="col-xs-5 col-md-5">
								<div class="form-group form-group-lg">
									<input type="text" placeholder="QQ" class="form-control" id="qqInput" name="qqInput"/>
								</div>
							</div>
							<div class="col-xs-5 col-md-4">
								<p class="help-block">除了电话外，还可以提供QQ联系方式，方便求职者联系您</p>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-2 col-md-3 control-label" for="mailInput">邮箱</label>
							<div class="col-xs-5 col-md-5">
								<div class="form-group form-group-lg"><input type="text" placeholder="邮箱" class="form-control" id="mailInput" name="mailInput"></div>
							</div>
							<div class="col-xs-5 col-md-4">
								<p class="help-block"></p>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-2 col-md-3 control-label" for="accountInput">收款账号</label>
							<div class="col-xs-5 col-md-5">
								<div class="form-group form-group-lg"><input type="text" placeholder="收款账号" class="form-control" id="accountInput" name="accountInput"></div>
							</div>
							<div class="col-xs-5 col-md-4">
								<p class="help-block">请预留您的银行卡号或支付宝账号，用于收款使用。推荐您使用支付宝账号</p>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-2 col-md-3"></div>
							<div class="col-xs-5 col-md-5">
								<div class="form-group form-group-lg"><button type="submit" class="btn btn-primary btn-block btn-lg">保存</button></div>
							</div>
						</div>
				    </fieldset>
				</form>
			</div>	
		</div>
	</div>

<script src="${static_common}/hzk/js/jquery.min.js"></script>

<script type="text/javascript" src="${static_common}/hzk/js/jquery.validate.js"></script>
<script type="text/javascript" src="${static_common}/hzk/js/jquery-validate.bootstrap-tooltip.js"></script>

<script type="text/javascript">
		$("#personalProfile").validate({
			rules : {
				// name: { required: true }
				// 表单的name值
				// required: 必填项
				accountInput: {required: true,range:['10','20']},
				// range 数值之间
				mailInput: {required: true,email: true},
				// email 邮件
				qqInput: {required: true, digits: true},
				// digits: 数字
				companyInput01: {required: true,minlength: '8',maxlength: '12'}
				// minlength: 最小位数
				// maxlength: 最大位数
			},
			tooltip_options: {
				accountInput: {placement:'right'},
				mailInput: {placement:'right'},
				qqInput: {placement:'right'},
				companyInput01: {placement: 'top'}
			},
		})
	</script>

</body>
</html>