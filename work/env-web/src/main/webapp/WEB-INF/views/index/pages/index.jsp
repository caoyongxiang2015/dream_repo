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
					<p style="font-size: 28px;">已收录500+公司信息</p>
					<p><a class="btn btn-purple btn-lg seek-advice" href="javascript:window.location.href='${ctx}/release/first'" role="button">找人咨询</a></p>

		      </div>
		    </div>
		    <div class="item">
			    <div class="container">
		        <h2>只为让您掌握的信息产生价值</h2>
				<p style="font-size: 28px;">只为让您帮助更多的人</p>
				<!-- <p><a class="btn btn-purple btn-lg seek-advice" style="color: orange;" href="#" role="button">收到一条请求信息</a></p> -->
		      </div>
		    </div>
		    <div class="item">
			    <div class="container">
		        <h2>面试是一个不对等的双向选择</h2>
				<p style="font-size: 28px;">解决您与企业之间的信息不对等</p>
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
						<c:if test="${  notices==null || notices.size()<1  }">
						<c:if test="${ tuoguanNotices==null || tuoguanNotices.size()<1  }">
						<c:if test="${ serviceCompleteNotices==null || serviceCompleteNotices.size()<1  }">
							您暂无新消息
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
								<!-- <input id="getCodeSMS" type="button" class="btn btn-success " style="color: #000;background-color: green" value="免费获取验证码" onclick="sendMessage()" /> -->
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
							<button class="btn btn-form btn-block btn-login" type="button">登录</button>
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
	    		<div class="panel-body">您可以发布需求，寻找该公司的内部员工；只要输入公司名称的简称即可，平台系统会通过后台大数据分析匹配相应的内部员工</div>
	    	</div>
	    	<div class="col-5 panel panel-primary">
	    		<div class="panel-heading">
	    			<h3 class="panel-title">2 等待应答</h3>
	    		</div>
	    		<div class="panel-body">需求发布之后，会将您的需求通知公司的内部员工，等待TA的回应</div>
	    	</div>
	    	<div class="col-5 panel panel-primary">
	    		<div class="panel-heading">
	    			<h3 class="panel-title">3 诚意金托管</h3>
	    		</div>
	    		<div class="panel-body">公司内部员工接受您的请求后，需要支付给对方的诚意金先托管在本平台，服务结束满意后，平台再将资金转给对方，服务过程中本平台不收取任何费用</div>
	    	</div>
	    	<div class="col-5 panel panel-primary">
	    		<div class="panel-heading">
	    			<h3 class="panel-title">4 服务</h3>
	    		</div>
	    		<div class="panel-body">对方会开放联系方式给您，您可以通过手机号、邮箱、站内信或者QQ号向TA咨询公司的信息</div>
	    	</div>
	    	<div class="col-5 panel panel-primary">
	    		<div class="panel-heading">
	    			<h3 class="panel-title">5 评价并结束</h3>
	    		</div>
	    		<div class="panel-body">咨询完成后，您可以对TA或者对提供的信息作出评价，并结束流程</div>
	    	</div>
	    </div>
	    <div class="section-title">
	    	<h2>常见问题</h2>
	    </div>
	    <div class="row">
	    	<div class="col-sm-12 col-md-6 col-lg-6">
	    		<div class="qa-text">
	    			<h4 class="question">好职客是个什么样的网站？</h4>
	    			<p class="answer">白领在换工作时，往往对公司信息把握不够，导致工作不满意。好职客旨在帮助白领在换工作之前能够准确的把握目标公司的信息，不打无准备的仗，提高白领与企业之间的信息对等性</p>
	    		</div>
	    	</div>
	    	<div class="col-sm-12 col-md-6 col-lg-6">
	    		<div class="qa-text">
	    			<h4 class="question">我在好职客能得到什么？</h4>
	    			<p class="answer">可以直接在好职客找到企业的内部员工，通过他们了解最真实最新的公司信息；可以为他人提供自己所在公司的信息，帮助他人同时赚取一定费用，也可以为别人推荐工作，还可以认识到同行业的朋友</p>
	    		</div>
	    	</div>
	    	<div class="col-sm-12 col-md-6 col-lg-6">
	    		<div class="qa-text">
	    			<h4 class="question">我想了解的公司没有搜索到怎么办？</h4>
	    			<p class="answer">好职客平台首先会收集搜索频率较高的公司信息，然后也尽可能多的收集搜索频率不高的公司信息，但难免会有很多公司信息当前没有收集到，如果您没有搜索到，可以通知我们，我们在第一时间搜集该公司信息</p>
	    		</div>
	    	</div>
	    	<div class="col-sm-12 col-md-6 col-lg-6">
	    		<div class="qa-text">
	    			<h4 class="question">我想了解的公司没有找到内部员工怎么办？</h4>
	    			<p class="answer">好职客平台会定期收集公司内部员工，也会根据会员需要寻找内部员工，但无法保证每个公司都能收集到内部员工；如果当前没有在本平台找到内部员工，可以通过网站底部反馈</p>
	    		</div>
	    	</div>
	    </div>
	    
	    
	    
	    
	    
	    
	    
	    <div class="section-title examples-title">
	    	<h2>TA们都在这里得到了帮助</h2>
	    </div>
	    <div class="examples">
		    <div class="example-item">
		    	<div class="row">
		    		<div class="col-xs-4">咨询的公司：南京擎天科技</div>
		    		<div class="col-xs-2">昵称：天使的城</div>
		    		<div class="col-xs-3">联系方式：186****5268</div>
		    		<div class="col-xs-3">2015-11-07 20:37:11</div>
		    	</div>
		    	<div class="judgement">收到擎天的面试通知，由于不知道擎天怎么样，就在网上查找这个公司的信息，有说好的，也有说不好的，各种说法都有，也不知道真假，
		    	偶然看到好职客网，就试了下，果然找到了一位已经在擎天工作四年的朋友，感觉对方很友善，优缺点都帮我分析了下，出差的情况啊，加班啊，福利待遇啊，里面员工的情况领导的情况啊，
		    	做的项目情况啊等等，交流的信息也比较全面，比较客观，挺感谢他的，感觉不错。
		    	</div>
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

var InterValObj; //timer变量，控制时间
var count = 10; //间隔函数，1秒执行
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
			url:'${ctx}/auth/register/getCode?type=1&pwd=1&phone='+$("#phone").val(),
			type:'post',
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
				url:'${ctx}/auth/ajaxlogin?username='+une+'&password='+pwd,
				type:'post',
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
