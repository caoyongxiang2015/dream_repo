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


<SCRIPT>
setTimeout("wait_hide()",4000);
function wait_hide() {
	$(".waiting").hide();
	$(".result").show();
}
</Script>

    <div class="container" style="margin-top: 15px;">
	    <div class="demand-progress">
	    	<ol class="step-progress clearfix">
		    	<!--
					此处进度条
					当前在哪一步，就给哪一步添加class="current-step"
					其他步骤都删除class="current-step"
		    	-->
	    		<li>1. 需求发布</li>
	    		<li class="current-step">2. 等待应答</li>
	    		<li>3. 诚意金托管</li>
	    		<li>4. 服务</li>
	    		<li>5. 评价并结束</li>
	    	</ol>
	    </div>
    	<section class="release-demand">
    	

			<div id="waiting" class="row waiting" style="text-align: center;background-color: #DBDBDB;">
				<img style="margin-top:150px; " src="${static_common }/hzk/images/wait.gif">
				<br>
				<br>
				<p style="font-size: 20px;color: green;">好职客正在通过大数据分析  为您搜索${req_company_shotname}内部员工...请稍后...</p>
				<br><br><br><br>&nbsp;
				<br><br><br><br>&nbsp;
			</div>


    		<div class="row result" hidden>
    			<div class="col-xs-8 col-xs-offset-2">
	    			<div class="send-respond">
	    				<p class="text-success"><i class="glyphicon glyphicon-ok"></i>恭喜您，需求发布成功!</p>
	    				<div class="help-block text-center">
	    				<c:if test="${match_success==0 }">
	    					 但非常抱歉，当前未匹配到[${req_company_shotname}]内部的员工！<br>
	    					 您可以尝试搜索该公司信息，您也可以给我们留言！
	    				</c:if>
	    				<c:if test="${match_success==1 }">您的需求已经发送给[${req_company_shotname}]的[${match_user_count }]位内部员工，请耐心等待！感谢您的支持，谢谢！</c:if></div>
	    				<div class="next-btn">
							&nbsp;
	    				</div>
	    				<p class="help-me text-danger">亲，给本平台提提意见或建议吧，有机会赢取大奖哦！</p>
	    			</div>
    			</div>
    		</div>
    	</section>
    </div>
    
	
</body>
</html>