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
		<c:choose>
		<c:when test="${save_profile_success == 1 }">
			<div class="alert alert-success" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				个人资料信息保存成功！
			</div>
		</c:when>
		<c:when test="${save_profile_success == 0 }">
			<div class="alert alert-failure" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				抱歉，个人资料信息保存失败，请刷新页面重试！
			</div>
		</c:when>
		<c:when test="${save_profile_success == -1 }">
			<div class="alert alert-tip" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				请完善个人资料信息，方便您与别人的沟通！
			</div>
		</c:when>
		</c:choose>
		<!-- alert end -->
		<!-- 设置个人信息 start -->
		<div class="setting-profile panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">个人信息<span>本平台承诺严格保密您的个人信息</span></h3>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" id="personalProfile" action="${ctx }/profile/save" method="post">
				<input type="hidden" name="userid" value="curuser.id">
				    <fieldset>
					    <div class="row">
					    	<label class="col-xs-2 col-md-3 control-label" for="nickname">昵称</label>
					    	<div class="col-xs-5">
						    	<div class="form-group form-group-lg">
						            <input type="text" placeholder="昵称" id="nickname" name="nickname" value="${curuser.nickname }" class="form-control">
						        </div>
					    	</div>
					    </div>
					    <div class="row">
					    	<label class="col-xs-2 col-md-3 control-label" for="lastname">姓</label>
					    	<div class="col-xs-3 col-md-3">
						    	<div class="form-group form-group-lg">
						            <input id="lastname" name="lastname" value="${curuser.lastname }" type="text" placeholder="姓" class="form-control">
						        </div>
					    	</div>
					    	<div class="col-xs-2 col-md-2">
						    	<div class="form-inline">
						            <label class="radio inline">
						            	<input type="radio" value="1" checked="checked" name="sex">
						              	男
						            </label>
						            <label class="radio inline">
						            	<input type="radio" value="2" name="sex">
						            	女
						            </label>
						            <label class="radio inline">
						            	<input type="radio" value="3" name="sex">
						            	保密
						            </label>
						        </div>
					    	</div>
					    	<div class="col-xs-4 col-md-3">
					    		<p class="help-block">必填</p>
					    	</div>
					    </div>
					    <div class="row">
					    	<label class="col-xs-2 col-md-3 control-label" for="realname">名</label>
					    	<div class="col-xs-5">
						    	<div class="form-group form-group-lg">
						            <input id="realname" name="realname" value="${curuser.realname }" type="text" placeholder="名" class="form-control">
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
								
								
								
								
								
								
								
								
								
								
									<!-- 当前公司 -->
									<div role="tabpanel" class="tab-pane active" id="persent">
									<%-- <input type="hidden" name="curcompanyid" value="${curcompany.id }"> --%>
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg"><input type="text" placeholder="公司名称（当前在职的 或 最近工作的一家公司）" id="companyShotname" name="companyShotname" value="${curcompany.companyShotname }" class="form-control"></div>
											</div>
											<div class="col-xs-5"><p class="help-block">必填</p></div>
										</div>
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg"><input type="text" placeholder="部门名称（当前在职的 或 最近工作的一家公司）" id="deptName" name="deptName"  value="${curcompany.deptName }"class="form-control"></div>
											</div>
											<div class="col-xs-5"></div>
										</div>
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg">
													<select id="jobDuration" name="jobDuration" class="form-control">
														<option value="请选择在该公司工作时长" <c:if test="${curcompany.jobDuration eq null || curcompany.jobDuration eq '' }">selected="selected"</c:if>>请选择在该公司工作时长</option>
														<option value="1年以内" <c:if test="${curcompany.jobDuration eq '1年以内'}">selected="selected"</c:if>>1年以内</option>
														<option value="1-3年" <c:if test="${curcompany.jobDuration eq '1-3年'}">selected="selected"</c:if>>1-3年</option>
														<option value="3-5年" <c:if test="${curcompany.jobDuration eq '3-5年'}">selected="selected"</c:if>>3-5年</option>
														<option value="5年以上" <c:if test="${curcompany.jobDuration eq '5年以上'}">selected="selected"</c:if>>5年以上</option>
													</select>
												</div>
											</div>
											<div class="col-xs-5"></div>
										</div>
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg"><input type="text" id="price" name="price" value="${curcompany.price }" placeholder="需要对方支付的金额" class="form-control"></div>
											</div>
											<div class="col-xs-1">
												<p class="help-block"></p>
											</div>
											<div class="col-xs-4">
												<p class="help-block">他人咨询我公司信息时，期望支付给我的诚意金的金额</p>
											</div>
										</div>
										<div class="sperate-line"></div>
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg"><input type="text" id="companyCatagory01" name="provideContent"  value="${curcompany.provideContent }" placeholder="我可提供的信息" class="form-control"></div>
											</div>
											<div class="col-xs-5">
												<p class="help-block">可以根据下面的建议选择，也可以手动输入</p>
											</div>
										</div>
										<p class="suggestion">建议：</p>
										<div class="label-collected" id="labelCollect01">
											<button type="button" class="btn btn-default btn-sm">公司规模</button>
											<button type="button" class="btn btn-default btn-sm">公司文化</button>
											<button type="button" class="btn btn-default btn-sm">福利待遇</button>
											<button type="button" class="btn btn-default btn-sm">业务方向</button>
											<button type="button" class="btn btn-default btn-sm">部门信息</button>
											<button type="button" class="btn btn-default btn-sm">出差/加班情况</button>
											<button type="button" class="btn btn-default btn-sm">领导怎么样</button>
											<button type="button" class="btn btn-default btn-sm">加薪频率幅度</button>
											<button type="button" class="btn btn-default btn-sm">使用到的技术</button>
											<button type="button" class="btn btn-default btn-sm">男女员工大概比例</button>
										</div>
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg">
													<input type="text" id="remark" name="remark" value="${curcompany.remark }" placeholder="备注" class="form-control">
												</div>
											</div>
											<div class="col-xs-5">
												<p class="help-block">可以说明具体情况！</p>
											</div>
										</div>
									</div>
									
									
									
									
									
									
									
									
									
									
									
									
									
									<!-- 上一家公司 -->
									<div role="tabpanel" class="tab-pane" id="previous">
									<input type="hidden" name="entity2.id" value="${precompany.id }">
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg"><input type="text" placeholder="公司名称（上一家公司）" id="entity2.companyShotname" name="entity2.companyShotname" value="${precompany.companyShotname }" class="form-control"></div>
											</div>
											<div class="col-xs-5"><p class="help-block">必填</p></div>
										</div>
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg"><input type="text" placeholder="部门名称（上一家公司）" id="entity2.deptName" name="entity2.deptName" value="${precompany.deptName }" class="form-control"></div>
											</div>
											<div class="col-xs-5"></div>
										</div>
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg">
													<select id="entity2.jobDuration" name="entity2.jobDuration" class="form-control">
														<option value="请选择在该公司工作时长" <c:if test="${precompany.jobDuration eq null || precompany.jobDuration eq '' }">selected="selected"</c:if>>请选择在该公司工作时长</option>
														<option value="1年以内" <c:if test="${precompany.jobDuration eq '1年以内'}">selected="selected"</c:if>>1年以内</option>
														<option value="1-3年" <c:if test="${precompany.jobDuration eq '1-3年'}">selected="selected"</c:if>>1-3年</option>
														<option value="3-5年" <c:if test="${precompany.jobDuration eq '3-5年'}">selected="selected"</c:if>>3-5年</option>
														<option value="5年以上" <c:if test="${precompany.jobDuration eq '5年以上'}">selected="selected"</c:if>>5年以上</option>
													</select>
												</div>
											</div>
											<div class="col-xs-5"></div>
										</div>
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg"><input type="text" id="entity2.price" name="entity2.price" value="${precompany.price }" placeholder="需要对方支付的金额" class="form-control"></div>
											</div>
											<div class="col-xs-1">
												<p class="help-block"></p>
											</div>
											<div class="col-xs-4">
												<p class="help-block">他人咨询我公司信息时，期望支付给我的诚意金的金额</p>
											</div>
										</div>
										<div class="sperate-line"></div>
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg"><input type="text" id="companyCatagory02" name="entity2.provideContent" value="${precompany.provideContent }" placeholder="我能提供该公司的信息" class="form-control"></div>
											</div>
											<div class="col-xs-5">
												<p class="help-block">可以根据下面的建议选择，也可以手动输入</p>
											</div>
										</div>
										<p class="suggestion">建议：</p>
										<div class="label-collected" id="labelCollect02">
											<button type="button" class="btn btn-default btn-sm">公司规模</button>
											<button type="button" class="btn btn-default btn-sm">公司文化</button>
											<button type="button" class="btn btn-default btn-sm">福利待遇</button>
											<button type="button" class="btn btn-default btn-sm">业务方向</button>
											<button type="button" class="btn btn-default btn-sm">部门信息</button>
											<button type="button" class="btn btn-default btn-sm">出差/加班情况</button>
											<button type="button" class="btn btn-default btn-sm">领导怎么样</button>
											<button type="button" class="btn btn-default btn-sm">加薪频率幅度</button>
											<button type="button" class="btn btn-default btn-sm">使用到的技术</button>
											<button type="button" class="btn btn-default btn-sm">男女员工大概比例</button>
										</div>
										<div class="row">
											<div class="col-xs-6">
												<div class="form-group form-group-lg">
													<input type="text" id="entity2.remark" name="entity2.remark" value="${precompany.remark }" placeholder="备注" class="form-control">
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
							<label class="col-xs-2 col-md-3 control-label" for="qq">QQ</label>
							<div class="col-xs-5 col-md-5">
								<div class="form-group form-group-lg">
									<input type="text" placeholder="QQ" class="form-control" id="qq" name="qq"value="${curuser.qq }" />
								</div>
							</div>
							<div class="col-xs-5 col-md-4">
								<p class="help-block">除了电话外，还可以提供QQ联系方式，方便求职者联系您</p>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-2 col-md-3 control-label" for="u_email">邮箱</label>
							<div class="col-xs-5 col-md-5">
								<div class="form-group form-group-lg"><input type="text" placeholder="邮箱" class="form-control" id="u_email" name="u_email"value="${curuser.email }" ></div>
							</div>
							<div class="col-xs-5 col-md-4">
								<p class="help-block"></p>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-2 col-md-3 control-label" for="moneyCount">收款账号</label>
							<div class="col-xs-5 col-md-5">
								<div class="form-group form-group-lg"><input type="text" placeholder="收款账号" class="form-control" id="moneyCount" name="moneyCount" value="${curuser.moneyCount }" ></div>
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


<script type="text/javascript">
		$("#personalProfile").validate({
			rules : {
				// name: { required: true }
				// 表单的name值
				// required: 必填项
				//moneyCount: {required: true,range:['10','20']},
				// range 数值之间
				u_email: {email: true},
				// email 邮件
				//qq: {required: true, digits: true},
				// digits: 数字
				lastname: {required: true},
				companyShotname: {required: true,minlength: '2',maxlength: '50'}
				// minlength: 最小位数
				// maxlength: 最大位数
			},
			tooltip_options: {
				//moneyCount: {placement:'right'},
				u_email: {placement:'right'},
				//qq: {placement:'right'},
				lastname: {placement:'right'},
				//companyShotname: {placement: 'top'}
				companyShotname: {placement: 'right'}
			},
		})
	</script>

</body>
</html>