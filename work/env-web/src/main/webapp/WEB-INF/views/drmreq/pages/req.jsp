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
    		
    		
    		<!-- 我收到的需求 -->
                <div role="tabpanel" class="tab-pane active" id="sended">
	                            <!-- 
									接收到的需求步骤：
									1. 根据实际步骤步数，添加多少个li
									2. 已经完成的步骤 添加class="message-step-pass"
									3. 当前步骤 添加class="message-step-current"
									4. 未开始的步骤 没有class
									5. 最后一步如果是放弃，则添加class="messaga-step-fail"
	                            -->
	                            
	                            <br/>
                <c:choose>
		<c:when test="${accept_success == 1 }">
			<div class="alert alert-success" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				恭喜您，应答成功！请等待对方将诚意金托管至本平台。
			</div>
		</c:when>
		<c:when test="${accept_success == 0 }">
			<div class="alert alert-tip" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				抱歉，已经被别人抢先应答了，下次动作快点哦！
			</div>
		</c:when>
		<c:when test="${accept_success == 2 }">
			<div class="alert alert-tip" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				您已经接受了应答，请不要重复接受应答。
			</div>
		</c:when>
		<c:when test="${accept_success == -1 }">
			<div class="alert alert-failure" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				非常抱歉，未应答成功，请刷新页面重试！
			</div>
		</c:when>
		</c:choose>
		
                <!-- 应答状态:  0未应答1已应答2赏金已托管3服务已完成4申请退款5放弃需求 -->
                <c:if test="${notices.size()==0 }">
                	<div class="panel panel-default">
	                	<div class="panel-heading">
	                            <h3 class="panel-title"><span>没有记录</span></h3>
	                    </div>
                    </div>
                </c:if>
                
                
                <c:forEach items="${notices }" var="nt">
                <!-- 未被应答，或者该需求是当前登录用户应答的-->
                <%-- <c:if test="${nt.req.acceptState == 0 || nt.req.acceptUserId == cur_userid }"> --%>
                           	
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">我接受到的需求 <f:formatDate value="${nt.req.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/><!-- <span>请求者给应答者发送的</span> --></h3>
                        </div>
                        <div class="panel-body">
                            <div class="demand-progress">
	                            <ol class="message-step clearfix">
	                            	<li class="message-step-pass">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">需求已发布</p>
	                            	</li>
	                            	<li class='<c:if test="${nt.req.acceptState==0}">message-step-current</c:if><c:if test="${nt.req.acceptState>0}">message-step-pass</c:if>'>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text"><c:if test="${nt.req.acceptState==0}">等待应答</c:if><c:if test="${nt.req.acceptState>0}">已应答</c:if></p>
	                            	</li>
	                            	<c:if test="${nt.req.acceptState!=5 && nt.req.acceptState!=7}">
	                            	<li class='<c:if test="${nt.req.acceptState==1}">message-step-current</c:if><c:if test="${nt.req.acceptState>1}">message-step-pass</c:if>'>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text"><c:if test="${nt.req.acceptState<=1}">赏金待托管</c:if><c:if test="${nt.req.acceptState>1}">赏金已托管</c:if></p>
	                            	</li>
	                            	</c:if>
	                            	<c:if test="${nt.req.acceptState!=5 && nt.req.acceptState!=7}">
	                            	<li class='<c:if test="${nt.req.acceptState==2}">message-step-current</c:if><c:if test="${nt.req.acceptState>2}">message-step-pass</c:if>'>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">服务进行中</p>
	                            	</li>
	                            	</c:if>
	                            	<c:if test="${nt.req.acceptState!=4 && nt.req.acceptState!=5 && nt.req.acceptState!=7}">
	                            	<li class='<c:if test="${nt.req.acceptState==3 || nt.req.acceptState==6}">message-step-current</c:if>'>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">评价并结束</p>
	                            	</li>
	                            	</c:if>
	                            	<c:if test="${nt.req.acceptState==4}">
	                            	<li class="message-step-fail">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">申请退款</p>
	                            	</li>
									</c:if>
	                            	<c:if test="${nt.req.acceptState==5 || nt.req.acceptState==7}">
	                            	<li class="message-step-fail">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">放弃需求</p>
	                            	</li>
									</c:if>
	                        	</ol>
                            </div>
                            
                <!-- 0未应答，等待应答 -->
                    <c:if test="${nt.req.acceptState==0}">
                            
                            <form name="ddyd" action="${ctx}/drmreq/receive" method="post">
                            <input type="hidden" name="entity.id" value="${nt.req.id }"> 
                            <input type="hidden" name="entity.acceptState" value="1"> <!-- 1:已应答，赏金待托管 -->
                            
                            <div class="send-message"><f:formatDate value="${nt.req.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>  用户${nt.req.sendUserNickname } 向您发送请求帮助信息，TA想简单了解下${nt.req.companyShotname }公司的信息，诚意金${nt.req.price }元</div>
                            <div class="accept-message">接受请求后，对方将诚意金托管到本平台后，开放联系方式给TA
	                            <div class="select-time">
	                                <div class="form-inline">
							            <label class="checkbox inline">
							            	<input type="checkbox" value="手机号" checked="checked" name="entity.openContact">
							              	手机号
							            </label>
							            <label class="checkbox inline">
							            	<input type="checkbox" value="QQ号码" checked="checked" name="entity.openContact">
							            	QQ
							            </label>
							            <label class="checkbox inline">
							            	<input type="checkbox" value="电子邮箱" checked="checked" name="entity.openContact">
							            	Email
							            </label>
							        </div>
	                            </div>
                            </div>
                            <div class="contact-message">请选择一个您方便的时间，求职者与您联系
								<div class="select-time">
	                                <div class="form-inline">
							            <label class="checkbox inline">
							            	<input type="checkbox" value="工作日" checked="checked" name="entity.acceptDuration">
							              	工作日
							            </label>
							            <label class="checkbox inline">
							            	<input type="checkbox" value="周末及节假日" checked="checked" name="entity.acceptDuration">
							            	周末及节假日
							            </label>
							            <input type="text" class="form-control" name="entity.acceptDuration" placeholder="您可以指定具体哪天或者时间段（默认全天）">
							        </div>
	                            </div>
                            </div>
                            <div class="button-bar">
                                <button class="btn btn-lg btn-primary" type="submit">接受请求</button>
                                <button class="btn btn-lg btn-default" data-toggle="modal" onclick="showletterdialog('${nt.req.sendUserId}');">给TA发私信</button>
                            </div>
                        	</form>
                        	
                        	</c:if>
                        	
	                <!-- 1已应答,赏金待托管 -->
	                    <c:if test="${nt.req.acceptState==1}">
	                  			<div class="send-message"><f:formatDate value="${nt.req.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>  用户${nt.req.sendUserNickname } 向您发送请求帮助信息，TA想简单了解下${nt.req.companyShotname }公司的信息，诚意金${nt.req.price }元</div>
	                          <div class="accept-message">您已经接受请求，请等待对方将赏金托管到本平台</div>
	                          <div class="button-bar">
	                              <button class="btn btn-lg btn-default" data-toggle="modal" onclick="showletterdialog('${nt.req.sendUserId}');">给TA发私信</button>
	                          </div>
	                    </c:if>
	                        	
	                <!-- 2赏金已托管，服务进行中-->
	                    <c:if test="${nt.req.acceptState==2}">
	                   		<div class="send-message">您好，用户${nt.req.sendUserNickname } 已经将诚意金${nt.req.price }元托管到本平台，待您双方沟通完毕后，本平台将诚意金转入您的账户。</div>
	                        <div class="contact-message">您选择与求职者沟通的时间是：${nt.req.acceptDuration } ；TA的联系电话是：${nt.req.sendUserPhone }</div>
	                        <div class="button-bar">
	                              <button class="btn btn-lg btn-default" data-toggle="modal" onclick="showletterdialog('${nt.req.sendUserId}');">给TA发私信</button>
	                          </div>
	                    </c:if>
	                    
	                <!-- 3服务已完成，评价并结束 -->
	                    <c:if test="${nt.req.acceptState==3}">
	                    	<div class="send-message">您好，用户${nt.req.sendUserNickname } 已经将诚意金${nt.req.price }元托管到本平台，待您双方沟通完毕后，本平台将诚意金转入您的账户。</div>
	                        <div class="contact-message">双方咨询已经完成！祝您好运！</div>
	                    </c:if>
	                    <c:if test="${nt.req.acceptState==4}">
	                        <div class="contact-message">您已申请退款。祝您工作顺利！</div>
	                    </c:if>
	                    <c:if test="${nt.req.acceptState==5}">
	                        <div class="contact-message">好职客感谢您的支持，很遗憾对方已主动放弃该帮助。</div>
	                    </c:if>
	                    <c:if test="${nt.req.acceptState==6}">
	                        <div class="contact-message">双方咨询已经完成！您已确认将诚意金转给对方。祝您工作顺利！</div>
	                    </c:if>
	                    <c:if test="${nt.req.acceptState==7}">
	                        <div class="contact-message">好职客感谢您的支持，遗憾对方已主动放弃该帮助。</div>
	                    </c:if>
	                    
                        </div>
                        
                        
                        
                    </div>
                    
               <%--  </c:if>     --%>            
                </c:forEach>
                
                </div>
                
                
                
                
                <!-- 我发出的需求 -->
                
                <div role="tabpanel" class="tab-pane" id="received">
                    
                <c:if test="${reqs.size()==0 }">
                	<div class="panel panel-default">
	                	<div class="panel-heading">
	                            <h3 class="panel-title"><span>没有记录</span></h3>
	                    </div>
                    </div>
                </c:if>
                
                <c:forEach items="${reqs }" var="req">
                
<%--                 >>>>reqid:${req.id } >>acceptState:${req.acceptState }>>>acceptUserId:${req.acceptUserId }   ### --%>
                
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">我发出的需求<!-- <span>应答者接受后，自动给请求者发送的</span> --></h3>
                        </div>
                        <div class="panel-body">
                            <div class="demand-progress">
	                            <ol class="message-step clearfix">
	                            	<li class="message-step-pass">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">需求已发布</p>
	                            	</li>
	                            	
	                            	<li class='<c:if test="${req.acceptState==0}">message-step-current</c:if><c:if test="${req.acceptState>0}">message-step-pass</c:if>'>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text"><c:if test="${req.acceptState==0}">等待应答</c:if><c:if test="${req.acceptState>0}">已应答</c:if></p>
	                            	</li>
	                            	
	                            	<c:if test="${req.acceptState!=5 && req.acceptState!=7}">
	                            	<li class='<c:if test="${req.acceptState==1}">message-step-current</c:if><c:if test="${req.acceptState>1}">message-step-pass</c:if>'>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text"><c:if test="${req.acceptState<=1}">赏金待托管</c:if><c:if test="${req.acceptState>1}">赏金已托管</c:if></p>
	                            	</li>
	                            	</c:if>
	                            	<c:if test="${req.acceptState!=5 && req.acceptState!=7}">
	                            	<li class='<c:if test="${req.acceptState==2}">message-step-current</c:if><c:if test="${req.acceptState>2}">message-step-pass</c:if>'>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">服务进行中</p>
	                            	</li>
	                            	</c:if>
	                            	<c:if test="${req.acceptState!=4 && req.acceptState!=5 && req.acceptState!=7}">
	                            	<li class='<c:if test="${req.acceptState==3 || req.acceptState==6}">message-step-current</c:if>'>
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">评价并结束</p>
	                            	</li>
	                            	</c:if>
	                            	<c:if test="${req.acceptState==4}">
	                            	<li class="message-step-fail">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">申请退款</p>
	                            	</li>
									</c:if>
	                            	<c:if test="${req.acceptState==5 || req.acceptState==7}">
	                            	<li class="message-step-fail">
	                            		<div class="step-icon"></div>
	                            		<p class="step-text">放弃需求</p>
	                            	</li>
									</c:if>
	                        	</ol>
                            </div>
                            
                            
	                <!-- 0 等待应答 -->
	                    <c:if test="${req.acceptState==0}">
	                    	<div class="send-message"><f:formatDate value="${req.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/> 您向${req.companyShotname }公司内部员工  发送的请求帮助信息，已经成功发出，请耐心等待，谢谢！</div>
	                    </c:if>
	                    
	                <!-- 1已应答,赏金待托管 -->
	                    <c:if test="${req.acceptState==1}">
                            <div class="send-message"><f:formatDate value="${req.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/> 您向${req.companyShotname }公司内部员工  发送的请求帮助信息，TA已接受应答，愿意帮助您</div>
                            <div class="accept-message">您是否愿意接受帮助？
                                <button class="btn btn-lg btn-warning J-accept-help">接受帮助</button>
                                <a class="J-giveup-help" onclick="giveup('${req.id}');">放弃帮助</a>
                            </div>
                            <div class="accept-message" style="display: none;">TA已经开放了联系方式${req.openContact }，待您赏金托管后可见。</div>
                            <div class="accept-message" style="display: none;">我们的支付宝账号是:xxxxx
								<%-- <button class="btn btn-lg btn-primary" data-toggle="modal" onclick="nn.returnStatus('付款完成信息已经通知客服，平台客服24小时内会审核您的付款情况；会尽快使您与${req.companyShotname }公司员工取得联系！好职客感谢您的支持！')">赏金托管完成，通知客服审核</button> --%>
								<button class="btn btn-lg btn-primary" data-toggle="modal" onclick="depositMoney('${req.id}')">赏金托管完成，通知客服审核</button>
                            </div>
	                    </c:if>
	                <!-- 2赏金已托管，服务进行中-->
	                    <c:if test="${req.acceptState==2}">
	                    	<div class="send-message"><f:formatDate value="${req.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/> 您与${req.companyShotname }公司内部员工发送的请求已经达成一致，请您积极主动的联系TA吧；${req.acceptDuration }，${req.openContact }
                                <button class="btn btn-lg btn-primary" onclick="serviceComplete('${req.id}');">服务完成</button><a onclick="backMoney('${req.id}');">申请退款</a>
                            </div>
	                    </c:if>
                        
	                <!-- 3服务已完成，评价并结束 -->
	                    <c:if test="${req.acceptState==3}">
	                    	<div class="send-message">您好，双方咨询已经完成！通知客服将诚意金转给对方，祝您好运！<!-- pay_notice -->
	                    		<%-- <button class="btn btn-lg btn-primary" data-toggle="modal" onclick="nn.returnStatus('转账信息已经通知客服，客服两个工作日内转账给对方！<br/>好职客感谢您的支持！')">请将诚意金转给对方</button> --%>
	                    		<button class="btn btn-lg btn-primary" data-toggle="modal" onclick="payMoney('${req.id}');">请将诚意金转给对方</button>
	                    	</div>
	                    </c:if>  
	                    <c:if test="${req.acceptState==6}">
	                    	<div class="send-message">您好，双方咨询已完成，祝您工作顺利！
	                    	</div>
	                    </c:if>    
	                <!-- 4申请退款 -->
	                    <c:if test="${req.acceptState==4}">
	                    	<div class="send-message">您已申请退款！</div>
	                    </c:if>    
	                <!-- 5放弃帮助 -->
                        <c:if test="${req.acceptState==5 || req.acceptState==7}">
                        	<div class="send-message">有应答者响应，但您已经放弃了该需求。<button class="btn btn-lg btn-primary" onclick="javascript:window.location.href='${ctx}/drmreq/againRelease?reqid=${req.id}'">重新发起请求</button></div>
                        </c:if>
                            
                        </div>
                    </div>
                    
                    
               	</c:forEach>
                    
                    
                
                </div>           
            </div>
    	</section>
    </div>
    
    
    
<input type="hidden" name="reqid" >
    
	<!-- 发送私信 [[ -->
	<div class="modal fade" id="sendPriviteMessage" tabindex="-1" role="dialog" aria-labelledby="sendPriviteMessage">
		<input type="text" name="youruserid" >
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
			    <div class="modal-body">
				    <div class="container-fluid">
					    <!-- <div class="row message-object">
					    	<div class="col-xs-3">对方ID：</div>
					    	<div class="col-xs-3">xxxxx</div>
					    	<div class="col-xs-3">对方昵称：</div>
					    	<div class="col-xs-3">XXXXX</div>
					    </div> -->
				    	<!-- <div class="row">
					    	<label for="messageTitle" class="label-control col-xs-2">标题：</label>
							<div class="form-group col-xs-10">
								<input type="text" class="form-control" id="messageTitle" name="messageTitle" placeholder="私信标题">
					        </div>
					    </div> -->
					    <div class="row">
					    	<label for="messageText" class="abel-control col-xs-2">内容：</label>
					    	<div class="form-group col-xs-10">
						    	<textarea class="form-control" id="messageText" name="messageText" placeholder="发送私信" rows="8" cols="30"></textarea>
					    	</div>
					    </div>
				    </div>
		        </div>
		        <div class="modal-footer text-center">
			        <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal" onclick="sendletter();">发送</button>
			        <button type="button" class="btn btn-link" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
		</div>
	<!-- 发送私信 ]] -->

	<!-- 发送完成返回弹窗状态 -->
	<div class="modal fade" id="returnStatus" tabindex="-1" role="dialog" aria-labelledby="returnStatus">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<div class="modal-body">
				</div>
				<div class="modal-footer text-center">
					<button type="button" class="btn btn-primary btn-block btn-lg" data-dismiss="modal">确定</button>
				</div>
			</div>
		</div>
	</div>
	
	
	<!-- 放弃帮助 -->
	<div class="modal fade" id="giveupHelp" tabindex="-1" role="dialog" aria-labelledby="giveupHelp">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<div class="modal-body">
					您确定要放弃帮助吗？
				</div>
				<div class="modal-footer text-center">
			        <button type="button" class="btn btn-primary btn-lg J-giveup-help-confirm" data-dismiss="modal">确定</button>
			        <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 服务完成 -->
	<div class="modal fade" id="serviceComplete" tabindex="-1" role="dialog" aria-labelledby="serviceComplete">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<div class="modal-body">
					您确定咨询完成了吗?
				</div>
				<div class="modal-footer text-center">
			        <button type="button" class="btn btn-primary btn-lg J-service-complete-confirm" data-dismiss="modal">确定</button>
			        <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 将诚意金转给对方-->
	<div class="modal fade" id="payMoney" tabindex="-1" role="dialog" aria-labelledby="payMoney">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<div class="modal-body">
					转账信息已经通知客服，客服两个工作日内转账给对方！<br/>好职客感谢您的支持！
				</div>
				<div class="modal-footer text-center">
			        <button type="button" class="btn btn-primary btn-lg J-payMoney-confirm" data-dismiss="modal">确定</button>
			        <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 资金托管完成-->
	<div class="modal fade" id="depositMoney" tabindex="-1" role="dialog" aria-labelledby="depositMoney">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<div class="modal-body">
					付款完成信息已经通知客服，平台客服24小时内会审核您的付款情况；会尽快使您与公司员工取得联系！好职客感谢您的支持！
				</div>
				<div class="modal-footer text-center">
			        <button type="button" class="btn btn-primary btn-lg J-depositMoney-confirm" data-dismiss="modal">确定</button>
			        <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	
	
	<!-- 申请退款 -->
	<div class="modal fade" id="backMoney" tabindex="-1" role="dialog" aria-labelledby="backMoney">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<div class="modal-body">
					您确定退款吗?
					 <div class="row">
					    	<div class="form-group col-xs-10">
						    	<textarea class="form-control" id="reasonText" placeholder="请说明退款原因" rows="3" cols="30"></textarea>
					    	</div>
					    </div>
				</div>
				<div class="modal-footer text-center">
			        <button type="button" class="btn btn-primary btn-lg J-back-money-confirm" data-dismiss="modal">确定</button>
			        <button type="button" class="btn btn-primary btn-lg" data-dismiss="modal">取消</button>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	
		function showletterdialog(youruserid){
			$("input[name='youruserid']").val(youruserid);
			$('#sendPriviteMessage').modal('show');
		}
		function sendletter(){
			var messageText = $("#messageText").val();
			if(''==messageText){
				alert("请填写内容！");
				return ;
			}
			var sendurl = '${ctx}/drmletter/sendletter?receiveUserid='+$("input[name='youruserid']").val() +'&sendMessage'+$("input[name='youruserid']").val()+ '='+messageText;
			$.ajax({
				url: sendurl ,
				type:'get',
				success:function(data){
					$("#returnStatus .modal-body").html("发送成功");
					$("#returnStatus").modal("show");
				},
				fail:function(data){
					$("#returnStatus .modal-body").html("发送失败");
					$("#returnStatus").modal("show");
				},
				error:function(data){
					$("#returnStatus .modal-body").html("发送失败，请刷新重试！");
					$("#returnStatus").modal("show");
				}
			});
		}
		
	   /* $(function () { $('#sendPriviteMessage').on('show.bs.modal', function () {
	      alert('嘿，我听说您喜欢模态框...');})
	   }); */
	</script>

	<script type="text/javascript">
		$(".J-accept-help").on("click",function(){
			$(this).parent().nextAll(".accept-message").show();
			$(".J-accept-help").hide();
			$(".J-giveup-help").hide();
		})
		
		function giveup(reqid){
			$("input[name='reqid']").val(reqid);
			$("#giveupHelp").modal("show");
		}

		function serviceComplete(reqid){
			$("input[name='reqid']").val(reqid);
			$("#serviceComplete").modal("show");
		}
		function backMoney(reqid){
			$("input[name='reqid']").val(reqid);
			$("#backMoney").modal("show");
		}
		function payMoney(reqid){
			$("input[name='reqid']").val(reqid);
			$("#payMoney").modal("show");
		}
		function depositMoney(reqid){
			$("input[name='reqid']").val(reqid);
			$("#depositMoney").modal("show");
		}
		// 放弃帮助
		$(".J-giveup-help-confirm").on("click",function(){
			$.ajax({
				url:'${ctx}/drmreq/giveupHelp?acceptstate=5&reqid='+$("input[name='reqid']").val(),
				type:'get',
				success : function(data) {
					window.location.reload();
				}
			});
		})
		// 服务完成
		$(".J-service-complete-confirm").on("click",function(){
			$.ajax({
				url:'${ctx}/drmreq/serviceComplete?acceptstate=3&reqid='+$("input[name='reqid']").val(),
				type:'get',
				success : function(data) {
					window.location.reload();
				}
			});
		})
		// 申请退款
		$(".J-back-money-confirm").on("click",function(){
			$.ajax({
				url:'${ctx}/drmreq/backMoney?acceptstate=4&reqid='+$("input[name='reqid']").val()+'&reason='+$("input[name='reasonText']").val(),
				type:'get',
				success : function(data) {
					window.location.reload();
				}
			});
		})
		
		// 将资金转给对方
		$(".J-payMoney-confirm").on("click",function(){
			$.ajax({
				url:'${ctx}/drmreq/payComplete?acceptstate=6&reqid='+$("input[name='reqid']").val(),
				type:'get',
				success : function(data) {
					// 不用刷页面
				}
			});
		})
		
		// 资金托管完成
		$(".J-depositMoney-confirm").on("click",function(){
			$.ajax({
				url:'${ctx}/drmreq/depositMoney?acceptstate=2&reqid='+$("input[name='reqid']").val(),
				type:'get',
				success : function(data) {
					// 不用刷页面
				}
			});
		})
		
	</script>
	
	
</body>
</html>