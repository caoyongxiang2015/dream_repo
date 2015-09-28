<%@page import="com.env.constant.Constants"%>
<%@page import="com.env.dto.PtUser"%>
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
	    <div class="demand-progress">
	    	<ol class="step-progress clearfix">
		    	<!--
					此处进度条
					当前在哪一步，就给哪一步添加class="current-step"
					其他步骤都删除class="current-step"
		    	-->
	    		<li class="current-step">1. 需求发布</li>
	    		<li>2. 等待应答</li>
	    		<li>3. 诚意金托管</li>
	    		<li>4. 服务</li>
	    		<li>5. 评价并结束</li>
	    	</ol>
	    </div>
    	<section class="release-demand">
    		<div class="panel">
    		
    		<c:if test="${req_release_month_company_count==1}">
    		当月超限
    		</c:if>
    		<c:if test="${req_release_day_company_count==1 }">
    		当天超限
    		</c:if>
    		
    			<!-- <div class="panel-heading">
    				<h3 class="panel-title">发布需求</h3>
				</div> -->
				
    		<c:if test="${req_release_month_company_count==0 && req_release_day_company_count==0}">
    	
				
				<div class="panel-body row">
					<div class="col-xs-9">
    				<form class="form-horizontal" id="releaseDemand" action="${ctx }/release/release1_save" method="post" onSubmit="return check();">
						<div class="row">
							<label class="col-xs-3 control-label" for="companyShotname">公司名称</label>
							<div class="col-xs-7">
    							<div class="form-group form-group-lg">
		    						<input type="text" id="companyShotname" name="companyShotname" placeholder="公司名称" value="${req_companyname }" class="form-control required">
		    					</div>
							</div>
							<div class="col-xs-2">
								<p class="help-block">必填</p>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 control-label" for="price">金额</label>
							<div class="col-xs-7">
    							<div class="form-group form-group-lg">
		    						<input type="text" id="price" name="price" placeholder="金额" class="form-control">
		    					</div>
							</div>
							<div class="col-xs-2">
								<p class="help-block">必填</p>
							</div>
						</div>
						
						<%
						PtUser user = (PtUser)request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
						if(null==user){// 未登录%>
							
						<div class="row alert-msg" hidden>
							<label class="col-xs-3 control-label" for="phonecode">&nbsp;</label>
							<div class="col-xs-6">
								<div class="alert alert-failure" style="width:200px;height:30px;padding: 5px;margin-bottom: 5px; background-color:#FF0000; color:#FFFFFF">手机号号码阿布正去</div>
							</div>
						</div>


						<div class="row">
							<label class="col-xs-3 control-label" for="telephone">手机号码</label>
							<div class="col-xs-4">
    							<div class="form-group form-group-lg">
		    						<input type="text" id="telephone" name="telephone" placeholder="手机号码" class="form-control">
								</div>
							</div>
							<div class="col-xs-3">
								<button type="button"  class="btn btn-lg btn-primary btn-block getCodeSMS">获取手机验证码</button>
							</div>
							<div class="col-xs-2">
								<p class="help-block">必填</p>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 control-label" for="phonecode">验证码</label>
							<div class="col-xs-4">
    							<div class="form-group form-group-lg">
		    						<input type="text" id="phonecode" name="phonecode" placeholder="验证码" class="form-control">		 
		    					</div>
							</div>
							<div class="col-xs-2">
								<p class="help-block">必填</p>
							</div>
						</div>
						
						<%}%>
						
						<div class="row">
							<label class="col-xs-3 control-label" for="content">备注</label>
							<div class="col-xs-7">
    							<div class="form-group form-group-lg">
		    						<textarea id="content" name="content" class="form-control" rows="3" placeholder="捎上一句话，比如您想咨询的问题；您的期望；您的诚意等等"></textarea>		    					
		    					</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-7 col-xs-offset-3">
								<div class="form-group">
    								<button type="submit" class="btn btn-lg btn-primary btn-block deploy">查找内部员工</button>
								</div>
							</div>
						</div>
    					</form>
					</div>
					<div class="col-xs-3">
						<div class="col-explain fn-left">
    						<p class="help-block">1、请附上您的诚意金，金额范围一般是您期望薪资的5‰-15‰，单位人民币</p>
    						<p class="help-block">2、您不需要立即托管诚意金，当有人接受了您的请求信息之后，需要您将诚意金托管到本平台，待服务结束后，再将金额转入对方账户</p>
    						<p class="help-block">3、金额多少不代表信息的价值</p>
    					</div>
    				</div>
    			</div>
    		
    		
    		
    		</c:if>
    		
    		</div>
    	</section>
    </div>
    
    
    <script type="text/javascript">
	    $("#releaseDemand").validate({
			rules: {
				companyShotname: {required: true},
				price: {required: true, digits:true},
				telephone: {required: true, digits:true},
				phonecode: {required: true}
			},
			tooltip_options: {
				'_all_': {placement:'right'},
				telephone: {html:true}
			},
		})
	</script>
	
	
	<script type="text/javascript">

var InterValObj; //timer变量，控制时间
var count = 120; //间隔函数，1秒执行
var curCount;//当前剩余秒数

     
	//获取手机验证码
	$(".getCodeSMS").on('click',function(){
		$("div.alert-msg").hide();
		if(''==$("#telephone").val()){
			$("div.alert-failure").text("请填写手机号");
			$("div.alert-msg").show();
			return ;
		}
					//向后台发送处理数据
		$.ajax({
			url:'${ctx}/auth/register/getCode?type=1&pwd=1&phone='+$("#telephone").val(),
			type:'post',
			success : function(data) {
				//alert(data.message);
				if(data.result==false){
					$("div.alert-failure").text(data.message);
					$("div.alert-msg").show();
				}else{
					curCount = count;
					//设置button效果，开始计时
				     $(".getCodeSMS").attr("disabled", "true");
				     $(".getCodeSMS").text("请" + curCount + "秒内输入验证码");
				     InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次
				}
			},
			error:function(){
				alert("手机验证码获取失败");
			}  
		});
	})	

//timer处理函数
function SetRemainTime() {
            if (curCount == 0) {                
                window.clearInterval(InterValObj);//停止计时器
                $(".getCodeSMS").removeAttr("disabled");//启用按钮
                $(".getCodeSMS").text("重新发送验证码");
            }
            else {
                curCount--;
                $(".getCodeSMS").text("请" + curCount + "秒内输入验证码");

            }
}


	
	function check(){
		var flag = false;
		if(undefined != $("#telephone").val() && null!=$("#telephone").val()){ // 判断有没有登录过
			$.ajax({
				url:'${ctx}/release/checkcode?authCode='+$("#phonecode").val(),
				type:'post',
				async:false,
				success:function(data){
					if(data.result==false){
						flag = false;
						$("div.alert-failure").text(data.message);
						$("div.alert-msg").show();
					}else {
						flag = true;
					}
				},
				error:function(data){
					alert("校验验证码失败")
				}
			})
		}else{
			flag = true;
		}
		return flag;
	}
	
$(".deploy").on("click",function(){
})

</script>

</body>
</html>
