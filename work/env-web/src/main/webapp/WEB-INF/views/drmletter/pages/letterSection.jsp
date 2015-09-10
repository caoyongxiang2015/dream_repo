<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<body>
<c:forEach items="${ds }" var="d">


	<div class="media">
		<div class="media-right <c:if test='${d.sendUserid==myUserid }'>text-success</c:if><c:if test='${d.sendUserid==yourUserid }'>text-primary</c:if>">
			<h5 class="meida-heading">
				<c:if test="${d.sendUserid==myUserid }">我：</c:if><c:if test="${d.sendUserid==yourUserid }">TA：</c:if><f:formatDate value="${d.sendTime }" pattern="yyyy-MM-dd HH:mm:ss"/>   
					  ${d.title }
			</h5>
			<div class="media-content">
				${d.content}
			</div>
		</div>
	</div>	
					
</c:forEach>

	<div class="form-group mt15">
		<form action="${ctx}/drmletter/sendletter" id="messageForm${yourUserid}">
			<textarea name="sendMessage${yourUserid}" cols="30" rows="3" class="form-control sendMessage${yourUserid}"></textarea>
			<div class="text-center">
				<button type="button" class="btn btn-lg btn-primary mt15" onclick="sendmsg('${yourUserid}');">发送私信</button>
			</div>
		</form>
	</div>
	
	<script type="text/javascript">
	function sendmsg(yourUserid){
		//alert('##'+$(".sendMessage"+yourUserid).val()+'##');
		if(''==$(".sendMessage"+yourUserid).val()){
			alert("发送内容不能为空，谢谢！");
			return false;
		}
		$("#messageForm"+yourUserid).submit();
	}
	 	
	</script>
	
</body>