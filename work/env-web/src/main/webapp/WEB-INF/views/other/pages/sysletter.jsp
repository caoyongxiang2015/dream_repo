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

<div class="container" style="width:500px;margin-top: 15px;">

<div class="setting-profile panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">尊敬的好职客用户${curUser.getLoginId()}，您好：</h2><br>
				(针对您可能关心的问题作一些说明，也恳请您提出宝贵的意见或建议，好职客团队渴望听到多方声音)
			</div>
			<div class="panel-body">
				<br>
				<h3 class="panel-title">用户故意填写的公司名称并非自己所在的公司？</h3>
				<div class="help-block">
				1、我们鼓励用户本着诚信的态度，有偿或无偿共享自己的信息，如果用户随意填写公司名称，将毫无意义。好职客团队会查询填写的公司是否存在。如果有人投诉该用户，本平台将研判处理或禁止该用户使用。<br>
				2、如果用户为他人多次共享信息，平台会以资鼓励。<br>
				3、如果用户填写的虚假公司名称，其他用户将搜索不到该用户；或者无法提供全面的企业信息而遭投诉。
				</div>
			
				<br>
				<br>
				<h3 class="panel-title">用户为他人提供虚假信息</h3>
				<div class="help-block">
				1、任何事务都有两面性，任何一家企业既有优点也有缺点，我们鼓励用户客观的提供企业信息，客观的分析企业的优点缺点，一味的表达优点或一味的表达缺点，这类信息我们认为是不全面的。<br>
				2、发布需求的用户一般会向一位以上内部员工咨询信息，可以从多为内部员工处获取共同点。<br>
				3、如果用户需要，好职客团队会在互联网上搜索分析用户目标公司，以及结合广大网友的观点，协助用户分析目标公司，以供参考。
				</div>
				
				
				<br>
				<br>
				<h3 class="panel-title">不同的公司，部门/岗位/职务不同，为他人提供的信息可能会以偏概全</h3>
				<div class="help-block">
				1、用户提供信息时，需要表达自己所处的位置，当然个人的敏感信息需要注意；建议用户提供自己所掌握的信息供需要的人自己参考。<br>
				2、有需求的用户，可以通过咨询多人，以及结合面试时掌握的信息，更全面的把握公司信息。咨询公司内部员工的信息可以有效的验证面试官或企业HR提供信息的客观性<br>
				</div>
				
				
				<br>
				<br>
				<h3 class="panel-title">如果您有其他疑问/意见/建议，非常欢迎您通过下方的'意见反馈'，把情况反馈给我们，不胜感激！</h3>
				<div class="help-block">
				好职客作为白领共享信息的平台，我们努力维护其向好的方向发展，帮助他人，也帮助我们自己，让我们大家共同贡献自己的力量吧！！！
				</div>
				
				
				
			</div>	
		</div>
</div>


	
	<script type="text/javascript">
		// 记录日志
		$.ajax({
			url:'${ctx}/sysletter/read',
			type:'post',
			success:function(data){
				
			}
		});
	</script>
	
	
</body>
</html>