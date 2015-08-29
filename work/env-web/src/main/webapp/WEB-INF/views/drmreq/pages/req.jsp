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
    	<section class="demand-message">
			<ul class="nav nav-tabs" role="tablist">
				<li class="active" role="presentation"><a href="#sended" aria-controls="#" role="tab" data-toggle="tab">我接收到的需求</a></li>
				<li role="presentation"><a href="#received" aria-controls="#" role="tab" data-toggle="tab">我发出的需求</a></li>
			</ul>
    		<div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="sended">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">我接受到的需求<span>请求者给应答者发送的</span></h3>
                        </div>
                        <div class="panel-body">
                            <div class="demand-progress">
	                            <!-- 
									接收到的需求步骤：
									1. 根据实际步骤步数，添加多少个li
									2. 已经完成的步骤 添加class="message-step-pass"
									3. 当前步骤 添加class="message-step-current"
									4. 未开始的步骤 没有class
									5. 最后一步如果是放弃，则添加class="messaga-step-fail"
	                            -->
	                            <ol class="message-step clearfix">
	                            	<li class="message-step-pass">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">已完成步骤</p>
	                            	</li>
	                            	<li class="message-step-current">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">当前步骤</p>
	                            	</li>
	                            	<li>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">未开始步骤</p>
	                            	</li>
	                            	<li>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">未开始步骤</p>
	                            	</li>
	                            	<li>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">未开始步骤</p>
	                            	</li>
	                            	<li class="message-step-fail">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">失败结束步骤</p>
	                            	</li>
	                            </ol>
                            </div>
                            <div class="send-message">2015.5.28 10:51:00  用户XXXXX 向您发送请求帮助信息，TA想简单了解下XXX公司的信息，诚意金50元</div>
                            <div class="accept-message">
	                            接受请求后，待对方将诚意金托管到本平台后，开放联系方式给TA
	                            <div class="select-time">
	                                <div class="form-inline">
							            <label class="radio inline">
							            	<input type="radio" value="1" checked="checked" name="contactMethod">
							              	手机号
							            </label>
							            <label class="radio inline">
							            	<input type="radio" value="2" name="contactMethod">
							            	QQ
							            </label>
							            <label class="radio inline">
							            	<input type="radio" value="3" name="contactMethod">
							            	Email
							            </label>
							        </div>
	                            </div>
                            </div>
                            <div class="contact-message">
	                            请选择一个您方便的时间，求职者与您联系
								<div class="select-time">
	                                <div class="form-inline">
							            <label class="radio inline">
							            	<input type="radio" value="1" checked="checked" name="group">
							              	工作日
							            </label>
							            <label class="radio inline">
							            	<input type="radio" value="2" name="group">
							            	节假日
							            </label>
							            <label class="radio inline">
							            	<input type="radio" value="3" name="group">
							            	以上均可
							            </label>
							            <input type="text" class="form-control" placeholder="您可以指定具体哪天或者时间段（默认全天）">
							        </div>
	                            </div>
                            </div>
                            <div class="button-bar">
                                <button class="btn btn-lg btn-primary">接受请求</button>
                                <button class="btn btn-lg btn-default" data-toggle="modal" data-target="#sendPriviteMessage">给TA发私信</button>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">我接受到的需求<span>请求者给应答者发送的</span></h3>
                        </div>
                        <div class="panel-body">
                                                        <div class="demand-progress">
	                            <!-- 
									接收到的需求步骤：
									1. 根据实际步骤步数，添加多少个li
									2. 已经完成的步骤 添加class="message-step-pass"
									3. 当前步骤 添加class="message-step-current"
									4. 未开始的步骤 没有class
									5. 最后一步如果是放弃，则添加class="messaga-step-fail"
	                            -->
	                            <ol class="message-step clearfix">
	                            	<li class="message-step-pass">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">已完成步骤</p>
	                            	</li>
	                            	<li class="message-step-current">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">当前步骤</p>
	                            	</li>
	                            	<li>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">未开始步骤</p>
	                            	</li>
	                            	<li>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">未开始步骤</p>
	                            	</li>
	                            	<li>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">未开始步骤</p>
	                            	</li>
	                            	<li class="message-step-fail">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">失败结束步骤</p>
	                            	</li>
	                            </ol>
                            </div>
                            <div class="send-message">2015.5.28 10:51:00  用户XXXXX 向您发送请求帮助信息，TA想简单了解下XXX公司的信息，诚意金50元</div>
                            <div class="accept-message">您已经接受请求，请等待对方将赏金托管到本平台</div>
<!--                        <div class="contact-message">请选择一个您方便的时间，求职者与您联系</div>-->
                            <div class="button-bar">
<!--                        	<button class="btn btn-lg btn-lg btn-primary">接受请求</button>-->
                                <button class="btn btn-lg btn-default" data-toggle="modal" data-target="#sendPriviteMessage">给TA发私信</button>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">我接受到的需求<span>请求者给应答者发送的</span></h3>
                        </div>
                        <div class="panel-body">
                            <div class="demand-progress">
	                            <!-- 
									接收到的需求步骤：
									1. 根据实际步骤步数，添加多少个li
									2. 已经完成的步骤 添加class="message-step-pass"
									3. 当前步骤 添加class="message-step-current"
									4. 未开始的步骤 没有class
									5. 最后一步如果是放弃，则添加class="messaga-step-fail"
	                            -->
	                            <ol class="message-step clearfix">
	                            	<li class="message-step-pass">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">已完成步骤</p>
	                            	</li>
	                            	<li class="message-step-current">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">当前步骤</p>
	                            	</li>
	                            	<li>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">未开始步骤</p>
	                            	</li>
	                            	<li>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">未开始步骤</p>
	                            	</li>
	                            	<li>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">未开始步骤</p>
	                            	</li>
	                            	<li class="message-step-fail">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">失败结束步骤</p>
	                            	</li>
	                            </ol>
                            </div>
                            <div class="send-message">您好，求职者用户XXXXX 已经将诚意金50元托管到本平台，待您双方沟通完毕后，由求职者确认服务完成或默认7个工作日内，本平台将诚意金转入您的账户。</div>
<!--                        <div class="accept-message">接受请求后，待对方将诚意金托管到本平台后，开放联系方式给TA</div>-->
                            <div class="contact-message">您选择与求职者沟通的时间是：节假日 18点-21点</div>
                        </div>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane" id="received">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">我发出的需求<span>应答者接受后，自动给请求者发送的</span></h3>
                        </div>
                        <div class="panel-body">
                            <div class="demand-progress">
	                            <!-- 
									接收到的需求步骤：
									1. 根据实际步骤步数，添加多少个li
									2. 已经完成的步骤 添加class="message-step-pass"
									3. 当前步骤 添加class="message-step-current"
									4. 未开始的步骤 没有class
									5. 最后一步如果是放弃，则添加class="messaga-step-fail"
	                            -->
	                            <ol class="message-step clearfix">
	                            	<li class="message-step-pass">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">已完成步骤</p>
	                            	</li>
	                            	<li class="message-step-current">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">当前步骤</p>
	                            	</li>
	                            	<li>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">未开始步骤</p>
	                            	</li>
	                            	<li>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">未开始步骤</p>
	                            	</li>
	                            	<li>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">未开始步骤</p>
	                            	</li>
	                            	<li class="message-step-fail">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">失败结束步骤</p>
	                            	</li>
	                            </ol>
                            </div>
                            <div class="send-message"><a href="#">2015.5.28 10:51:00  您向用户XXXXX 发送的请求帮助信息，TA已接受应答，愿意帮助您</a></div>
                            <div class="accept-message">您是否愿意接受帮助？
                                <button class="btn btn-lg btn-warning J-accept-help">接受帮助</button>
                                <a href="#">放弃帮助</a>
                            </div>
                            <div class="accept-message" style="display: none;">TA已经开放了这几种来纳西方式给你，带您赏金托管后可见。</div>
                            <div class="accept-message" style="display: none;">我们的支付宝账号是:xxxxx，转账是请备注您的ID。
								<button class="btn btn-lg btn-primary" data-toggle="modal" onclick="nn.returnStatus('付款完成信息已经通知客服，平台客服24小时内会审核您的付款情况；会尽快让您与XXX公司员工取得联系！白领去哪网感谢您的支持！谢谢！')">赏金托管完成，通知客服审核</button>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">我发出的需求<span>应答者接受后，自动给请求者发送的</span></h3>
                        </div>
                        <div class="panel-body">
                            <div class="demand-progress">
	                            <!-- 
									接收到的需求步骤：
									1. 根据实际步骤步数，添加多少个li
									2. 已经完成的步骤 添加class="message-step-pass"
									3. 当前步骤 添加class="message-step-current"
									4. 未开始的步骤 没有class
									5. 最后一步如果是放弃，则添加class="messaga-step-fail"
	                            -->
	                            <ol class="message-step clearfix">
	                            	<li class="message-step-pass">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">已完成步骤</p>
	                            	</li>
	                            	<li class="message-step-current">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">当前步骤</p>
	                            	</li>
	                            	<li>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">未开始步骤</p>
	                            	</li>
	                            	<li>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">未开始步骤</p>
	                            	</li>
	                            	<li>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">未开始步骤</p>
	                            	</li>
	                            	<li class="message-step-fail">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">失败结束步骤</p>
	                            	</li>
	                            </ol>
                            </div>
                            <div class="send-message">
                                <a href="#">2015.5.28 10:51:00  您与用户XXX已经达成一致，请您积极主动的联系TA吧</a>
                                <button class="btn btn-lg btn-primary">服务完成</button>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">我发出的需求<span>应答者接受后，自动给请求者发送的</span></h3>
                        </div>
                        <div class="panel-body">
                            <div class="demand-progress">
	                            <!-- 
									接收到的需求步骤：
									1. 根据实际步骤步数，添加多少个li
									2. 已经完成的步骤 添加class="message-step-pass"
									3. 当前步骤 添加class="message-step-current"
									4. 未开始的步骤 没有class
									5. 最后一步如果是放弃，则添加class="messaga-step-fail"
	                            -->
	                            <ol class="message-step clearfix">
	                            	<li class="message-step-pass">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">已完成步骤</p>
	                            	</li>
	                            	<li class="message-step-current">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">当前步骤</p>
	                            	</li>
	                            	<li>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">未开始步骤</p>
	                            	</li>
	                            	<li>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">未开始步骤</p>
	                            	</li>
	                            	<li>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">未开始步骤</p>
	                            	</li>
	                            	<li class="message-step-fail">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">失败结束步骤</p>
	                            	</li>
	                            </ol>
                            </div>
                            <div class="send-message">
                                <a href="#">有应答者响应，但您已经放弃了该需求。</a>
                                <button class="btn btn-lg btn-primary">重新发起请求</button>
                            </div>
                        </div>
                    </div>
                </div>           
            </div>
    	</section>
    </div>
    
<script src="${static_common}/hzk/js/jquery.min.js"></script>

<script type="text/javascript" src="${static_common}/hzk/js/jquery.validate.js"></script>
<script type="text/javascript" src="${static_common}/hzk/js/jquery-validate.bootstrap-tooltip.js"></script>
    
	<script type="text/javascript">
		$(".J-accept-help").on("click",function(){
			$(this).parent().nextAll(".accept-message").show();
		})
	</script>
</body>
</html>