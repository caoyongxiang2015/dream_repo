<%@page import="com.env.constant.Constants"%>
<%@page import="com.env.dto.PtUser"%>
<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<script type="text/javascript" src="http://qzonestyle.gtimg.cn/qzone/openapi/qc_loader.js" data-appid="101044974" charset="utf-8"></script>
<meta charset="UTF-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title><spring:message code="index.title"/></title>



<body>

	<!-- [[ 主体部分 -->
	<div class="jumbotron">
		<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
		  <!-- Indicators -->
		  <ol class="carousel-indicators" style="width: 50%">
		    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
		  </ol>
		  <!-- Wrapper for slides -->
		  <div class="carousel-inner" role="listbox">
		    <div class="item active">
			    <div class="container">
			        <h2>只为帮您选择一个理想职业  <font style="font-size: 26px;color: orange;">--- IT/互联网/通信 </font> </h2>
					<p style="font-size: 28px;">已收录(<font style="font-size: 36px;color: #FECB48;">南京</font>)<font style="font-size: 36px;color: orange;">1,5</font><font style="font-size: 24px;color: orange;">00+</font>公司的员工  </p>
					<p><a class="btn btn-purple btn-lg seek-advice" href="javascript:window.location.href='${ctx}/release/first'" role="button">找人咨询</a></p>

		      </div>
		    </div>
		    <div class="item">
			    <div class="container">
		        <h2>只为让您掌握的信息产生价值</h2>
				<p style="font-size: 28px;">其实您可以帮助更多的人，还能赚取<font style="font-size: 36px;color: orange;"><i>收益</i></font></p>
		      </div>
		    </div>
		    <div class="item">
			    <div class="container">
		        <h2>面试是一个不对等的双向选择</h2>
				<p style="font-size: 28px;">邀请内部员工为您提供<font style="font-size: 36px;color: orange;"><i>多对一</i></font>的咨询服务</p>
		      </div>
		    </div>
		    <div class="item">
			    <div class="container">
		        <h2>为您架起沟通桥梁</h2>
				<p style="font-size: 28px;">您可以认识更多更优秀的同行<font style="font-size: 36px;color: orange;"><i>朋友</i></font></p>
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
					<!-- 系统消息 -->
					<c:if test="${ sysletters!=null && sysletters.size()>0 }">
						<c:forEach items="sysletters" var="letr">
							<a href="${ctx}/sysletter">您收到一条系统消息，请查看</a><br/>
						</c:forEach>
					</c:if>
					
					<!-- 收到的请求消息 -->
					
						<c:if test="${ sysletters==null || sysletters.size()<1 }">
						<c:if test="${  notices==null || notices.size()<1  }">
							<c:if test="${ tuoguanNotices==null || tuoguanNotices.size()<1  }">
								<c:if test="${ serviceCompleteNotices==null || serviceCompleteNotices.size()<1  }">
									您暂无新消息
								</c:if>
							</c:if>
						</c:if>
						</c:if>
						<c:if test="${notices!=null && notices.size()>0 }">
							<a href="${ctx}/drmreq">您收到新的需求帮助信息，请查看</a>
						</c:if>
						<c:if test="${tuoguanNotices!=null && tuoguanNotices.size()>0 }">
							您发布的需求有人已应答，请托管赏金<br>
							<c:forEach items="${tuoguanNotices}" var="tn">
								<a href="${ctx}/release/third/${tn.reqId}">需求编号${tn.reqId}，<f:formatDate value="${tn.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></a><br>
							</c:forEach>
						</c:if>
						<c:if test="${serviceCompleteNotices!=null && serviceCompleteNotices.size()>0 }">
							已在进行中的咨询服务<br>
							<c:forEach items="${serviceCompleteNotices}" var="sn">
								<a href="${ctx}/release/forth/${sn.reqId}">需求编号${sn.reqId}，<f:formatDate value="${sn.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></a><br>
							</c:forEach>
						</c:if>
					</div> 
				</div>
			</div>
  			<%
	  		}else{
  			%>
		  	<div class="user-form posa">
				<div class="regidit-form panel panel-default" hidden>
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
								<!-- <input id="getCodeSMS" type="button" class="btn btn-success " style="color: #000;background-color: green" value="免费获取验证码" onclick="sendMessage()" /> -->
							</div>
							<a href="${ctx }/terms" target="_blank" style="padding-left:30px;"><span style="color: gray;">我已阅读并接受好职客服务条款</span></a>
							<button style="margin-top:5px;" class="btn btn-form mt15 btn-block btn-lg registerUser" type="button">注册</button>
						</form>
					</div> 
				</div>
				
				<div class="login-form panel panel-default" >
					<div class="panel-heading posr">
						<h3 class="panel-title" style="color: #563D7C;text-align: center;">欢迎来到白领社区</h3>
						<!-- <a href="javascript:;" class="posa J-gotoregidit">注册<i class="glyphicon glyphicon-share-alt"></i></a> -->
					</div>
					<div class="panel-body">
						<form id="loginForm" class="form" method="post">
							<div class="alert loginmsg" style="padding: 1px;margin-bottom: 5px; background-color:#FF0000; color:#FFFFFF" hidden></div>
							<div class="form-group form-group-lg mt15">
								<label for="username" hidden>手机号：</label>
							    <input type="text" class="form-control" id="username" name="username" placeholder="手机号登录">
							</div>
							<div class="form-group form-group-lg mt15">
							    <label for="password" hidden>密码：</label>
							    <input type="password" class="form-control" id="password" name="password" placeholder="登录密码">
							</div>
							<div>还没有账号？
								<a href="javascript:;" class="posa J-gotoregidit">快速注册</a>
								<button class="btn btn-form btn-block btn-login" style="margin-top: 10px;" type="button">登录</button>
							</div>
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
	    		<div class="panel-body">您可以发布需求，寻找该公司的内部员工；只要输入公司名称即可，好职客通过后台大数据分析匹配相应的内部员工</div>
	    	</div>
	    	<div class="col-5 panel panel-primary">
	    		<div class="panel-heading">
	    			<h3 class="panel-title">2 等待应答</h3>
	    		</div>
	    		<div class="panel-body">需求发布之后，会将您的需求通知公司的内部员工，等待他们回应</div>
	    	</div>
	    	<div class="col-5 panel panel-primary">
	    		<div class="panel-heading">
	    			<h3 class="panel-title">3 诚意金托管</h3>
	    		</div>
	    		<div class="panel-body">当公司内部员工接受您的请求后，需要您将诚意金先托管在好职客，服务结束满意后，好职客再将资金转给对方，服务过程中好职客不收取任何费用</div>
	    	</div>
	    	<div class="col-5 panel panel-primary">
	    		<div class="panel-heading">
	    			<h3 class="panel-title">4 服务</h3>
	    		</div>
	    		<div class="panel-body">对方会开放联系方式(QQ号/邮箱/手机号/站内信)给您，您可以通过对方提供的联系方式向TA咨询目标公司的信息</div>
	    	</div>
	    	<div class="col-5 panel panel-primary">
	    		<div class="panel-heading">
	    			<h3 class="panel-title">5 评价并结束</h3>
	    		</div>
	    		<div class="panel-body">咨询完成后，您可以对TA或对好职客作出评价，并结束流程</div>
	    	</div>
	    </div>
	    <div class="section-title">
	    	<h2>常见问题</h2>
	    </div>
	    <div class="row">
	    	<div class="col-sm-12 col-md-6 col-lg-6">
	    		<div class="qa-text">
	    			<h4 class="question">好职客是个什么样的网站？</h4>
	    			<p class="answer">白领在换工作时，往往对公司信息把握不够，导致工作不满意。好职客旨在帮助白领在换工作之前能够准确的把握目标公司的信息，降低换工作付出的代价，提高白领与企业之间的信息对等性。好职客是白领职场经验知识交流平台。</p>
	    		</div>
	    	</div>
	    	<div class="col-sm-12 col-md-6 col-lg-6">
	    		<div class="qa-text">
	    			<h4 class="question">我在好职客能得到什么？</h4>
	    			<p class="answer">1、可以直接在好职客找到企业的内部员工，通过他们了解最真实最新的公司内部信息；2、可以为他人提供自己所在公司的信息，帮助他人同时赚取一定费用；3、可以找同行为自己推荐工作，也可为别人推荐工作，同时认识到同行的朋友</p>
	    		</div>
	    	</div>
	    	<div class="col-sm-12 col-md-6 col-lg-6">
	    		<div class="qa-text">
	    			<h4 class="question">我想了解的公司没有搜索到怎么办？</h4>
	    			<p class="answer">好职客平台首先会收集搜索频率较高或发布需求较多的公司信息，也尽可能多的收集搜索频率不高的公司信息，但难免会有很多公司信息当前没有收集到，如果您没有搜索到，可以通知我们，我们在第一时间搜集该公司信息。</p>
	    		</div>
	    	</div>
	    	<div class="col-sm-12 col-md-6 col-lg-6">
	    		<div class="qa-text">
	    			<h4 class="question">我想了解的公司没有找到内部员工怎么办？</h4>
	    			<p class="answer">好职客平台会定期收集公司内部员工，也会根据会员需要寻找内部员工，但无法保证每个公司都能及时收集到内部员工；如果当前没有在本平台找到内部员工，可以通过网站底部反馈，我们会尽快与您联系。</p>
	    		</div>
	    	</div>
	    	<div class="col-sm-12 col-md-6 col-lg-6">
	    		<div class="qa-text">
	    			<h4 class="question">我在好职客注册的信息会不会被其他人看到？</h4>
	    			<p class="answer">1、好职客承诺严格保密注册会员的信息，任何人都不会看到您的信息；2、当有会员向您发出请求咨询信息时并附上诚意金，在您同意之后方可见到您开放给他的联系方式。</p>
	    		</div>
	    	</div>
	    	<div class="col-sm-12 col-md-6 col-lg-6">
	    		<div class="qa-text">
	    			<h4 class="question">为什么个人资料中仅允许填写两家公司信息？</h4>
	    			<p class="answer">为了保证会员在一定程度上掌握公司信息的时效性，因此仅允许会员填写自己工作过的最近的两家公司；如果您有疑问或者想填写更多公司，可通过网站底部意见反馈，把情况反馈给好职客，我们会尽快与您联系。</p>
	    		</div>
	    	</div>
	    </div>
	    
	    
	    
	    
	    
	    
	    
	    <div class="section-title examples-title">
	    	<h2>TA们都在这里获得了帮助</h2>
	    </div>
	    <div class="examples">
		    <div class="example-item">
		    	<div class="row">
		    		<div class="col-xs-4">咨询的公司：南京擎天科技</div>
		    		<div class="col-xs-2">昵称：天使的城</div>
		    		<div class="col-xs-3">联系方式：186****5268</div>
		    		<div class="col-xs-3">2015-11-01 09:02:11</div>
		    	</div>
		    	<div class="judgement">收到擎天的面试通知，由于不知道擎天怎么样，就在网上查找这个公司的信息，有说好的，也有说不好的，各种说法都有，也不知道真假，
		    	偶然看到好职客网，就试了下，果然找到了一位已经在擎天工作四年的朋友，感觉对方很友善，优缺点都帮我分析了下，出差的情况啊，加班啊，福利待遇啊，里面员工的情况领导的情况啊，
		    	做的项目情况啊等等，交流的信息也比较全面，比较客观，挺感谢他的，感觉不错。
		    	</div>
		    </div>
		    <div class="example-item">
		    	<div class="row">
		    		<div class="col-xs-4">咨询的公司：南京维数软件技术有限公司</div>
		    		<div class="col-xs-2">昵称：高女士</div>
		    		<div class="col-xs-3">联系方式：133********</div>
		    		<div class="col-xs-3">2015-10-31 20:00:00</div>
		    	</div>
		    	<div class="judgement">我在维数软件工作很久了，怎么说呢，既有优点也有缺点吧，如果想了解维数软件的情况，可以来好职客找到我，我会客观的把她好的一面，不好的一面分析给您。我也看了网上的评价，很多也有失客观。</div>
	    	</div>
		    <div class="example-item">
		    	<div class="row">
		    		<div class="col-xs-4">咨询的公司：苏宁易购</div>
		    		<div class="col-xs-2">用户：孟女士</div>
		    		<div class="col-xs-3">联系方式：150****6293</div>
		    		<div class="col-xs-3">2015-10-31 12:55:09</div>
		    	</div>
		    	<div class="judgement">之前听说苏宁的加班文化，不知道是真是假，就在好职客上找到一位苏宁易购的朋友，咨询了一下，基本了解了里面的情况，总比道听途说的好，咨询费也没白花</div>
		    </div>
		    <div class="example-item">
		    	<div class="row">
		    		<div class="col-xs-4">咨询的公司：南京唐尧网络科技有限公司</div>
		    		<div class="col-xs-2">昵称：jackchen</div>
		    		<div class="col-xs-3">联系方式：133********</div>
		    		<div class="col-xs-3">2015-10-31 10:50:27</div>
		    	</div>
		    	<div class="judgement">在百度贴吧里看到了好职客网站，就注册了一下试试，没想到这么快就有人咨询我们公司的信息，收了五十块钱，虽然不多，能帮人就帮下吧，大家找好工作也都不容易，想了解唐尧的信息可以找我哈</div>
		    </div>
		    <div class="example-item">
		    	<div class="row">
		    		<div class="col-xs-4">咨询的公司：南京睿翊腾信息技术有限公司</div>
		    		<div class="col-xs-2">昵称：遥远的尽头</div>
		    		<div class="col-xs-3">联系方式：138********</div>
		    		<div class="col-xs-3">2015-10-29 19:20:03</div>
		    	</div>
		    	<div class="judgement">我在这工作了一两年了，还算比较熟悉睿翊腾的情况，如果来我们公司面试或者想了解的情况的亲们可以问我哈，可以先通过站内信，QQ或者打电话也行哈</div>
		    </div>
	    	<%-- <a href="${ctx }/drmeval">查看更多&gt;&gt;</a> --%>
    	</div>
    </div>
    
    
    
    
	<!-- 登录窗口 [[ -->
	<div class="modal fade" id="xuanchuanModel" role="dialog" aria-labelledby="xuanchuanModel" style="text-align: center;margin-top:15px;">
							<span class="daojishi_xc" style="font-size: 14px;color: #fff">14秒后自动关闭</span>
							<div>
								<img alt="" src="${static_common }/hzk/images/xuanchuanye.png" style="width:70%">
							<span>
							<a href="javascript:;" class="posa xuanchuanye_close" style="font-size: 24px;color: #ff7f27">关闭</a> 
							</span>
							</div>
	</div>
	<!-- 登录窗口 ]]-->
	
    
    
    
    
    
    
    
<script src="${static_common}/hzk/js/jquery.min.js"></script>

<script type="text/javascript" src="${static_common}/hzk/js/jquery.validate.js"></script>
<script type="text/javascript" src="${static_common}/hzk/js/jquery-validate.bootstrap-tooltip.js"></script>

<%
if(null == curUser){
	%>
	
<script type="text/javascript">

var InterValObj_xc; //timer变量，控制时间
var curCount_xc=14;// 当前剩余秒数


$(document).ready(function(){
	$("#xuanchuanModel").modal("show");
	
	InterValObj_xc = window.setInterval(SetRemainTime_xc, 1000); //启动计时器，1秒执行一次
	
	$(".xuanchuanye_close").on('click',function(){
		$("#xuanchuanModel").modal("hide");
	});
	
	
});


//timer处理函数
function SetRemainTime_xc() {
     if (curCount_xc == 0) {                
		window.clearInterval(InterValObj_xc);//停止计时器
		$("#xuanchuanModel").modal("hide");
     }
     else {
         curCount_xc--;
		$(".daojishi_xc").text(curCount_xc + "秒后自动关闭");
     }
}

</script>

	<%
}
%>

	<script type="text/javascript">

var InterValObj; //timer变量，控制时间
var count = 120; //间隔函数，1秒执行
var curCount;//当前剩余秒数

     
	//获取手机验证码
	$("#getCodeSMS").on('click',function(){
		$("div.alert-failure").hide();
		if(''==$("#phone").val()){
			$("div.alert-failure").text("请填写手机号");
			$("div.alert-failure").show();
			return ;
		}
		if(''==$("#pwd").val()){
			$("div.alert-failure").text("请填写密码");
			$("div.alert-failure").show();
			return ;
		}
		
					//向后台发送处理数据
		$.ajax({
			//url:'${ctx}/auth/register/getCode?type=1&pwd=1&phone='+$("#phone").val(),
			url:'${ctx}/auth/register/getCode',
			type:'post',
			data: {type:1, phone:$("#phone").val(), pwd:$("#pwd").val()} ,
			success : function(data) {
				//alert(data.message);
				if(data.result==false){
					$("div.alert-failure").text(data.message);
					$("div.alert-failure").show();
				}else{
					curCount = count;
					//设置button效果，开始计时
				     $("#getCodeSMS").attr("disabled", "true");
				     $("#getCodeSMS").text("请" + curCount + "秒内输入验证码");
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
                $("#getCodeSMS").removeAttr("disabled");//启用按钮
                $("#getCodeSMS").text("重新发送验证码");
            }
            else {
                curCount--;
                $("#getCodeSMS").text("请" + curCount + "秒内输入验证码");

            }
}
</script>

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
		
		$(".btn-login").on('click',function(){
			
			$("div.loginmsg").hide();
   			var une=$('#username').val();
   			var pwd=$('#password').val();
			if(''==une){
				$("div.loginmsg").text("请填写用户名");
				$("div.loginmsg").show();
				return ;
			}
			if(''==pwd){
				$("div.loginmsg").text("请填写密码");
				$("div.loginmsg").show();
				return ;
			}

			// 登录
			$.ajax({
				//url:'${ctx}/auth/ajaxlogin?username='+une+'&password='+pwd,
				url:'${ctx}/auth/ajaxlogin',
				type:'post',
				data: {username:une, password:pwd} ,
				success : function(data) {
					if(data.loginSuccess == '0'){
						$("div.loginmsg").text(data.loginMsg);
						$("div.loginmsg").show();
					}
					if(data.loginSuccess == '1'){
						alert('登录成功，请您简单的填写基本资料，点击确定跳转到个人资料页面，谢谢！');
						window.location.href="${ctx}/profile";						
					}
				},
				error:function(){
					alert("登录失败");
				}  
			});
		});
		
		
		
		// 注册
		$(".registerUser").on('click',function(){
			
   			//var pwd=$.md5($('#pwd').val());
   			var phone=$('#phone').val();
   			var pwd=$('#pwd').val();
   			var authCode=$('#verfityCodeSMS').val();

  			$("div.alert-failure").hide();
			if(''==phone){
				$("div.alert-failure").text("请填写手机号");
				$("div.alert-failure").show();
				return ;
			}
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
				//url:'${ctx}/auth/register/userRegister'+'?phone='+phone+'&pwd='+pwd+'&authCode='+authCode+'&n='+new Date(),
				url:'${ctx}/auth/register/userRegister',
				type:'post',
				data: {phone:phone, pwd:pwd,authCode:authCode,n:new Date()} ,
				success : function(data) {
					if(data.result==false){
						//alert(data.message);
						$("div.alert-failure").text(data.message);
						$("div.alert-failure").show();
					}
					if(data.result==true){
						alert("注册成功，将跳转到个人资料页面，请完善您的基本资料，谢谢！");
						window.location.href="${ctx}/profile";
						
						// 发一条系统消息
						$.ajax({
							url:'${ctx}/sysletter/send',
							type:'post',
							success : function(data) {
								}
							});
					}
				},
				error:function(){
					alert("注册异常");
				} 
			});
		})
	</script>
	
	
	<script type="text/javascript">
		// 记录日志
		$.ajax({
			url:'${ctx}/ptvisitlog/save?access_url=/',
			type:'post',
			success:function(data){
				
			}
		});
	</script>
	
	
</body>
</html>
