<%@include file="/WEB-INF/common/layouts/common.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>我的主页</title>
<!-- 
<script>
$(document).ready(function(){
  $('input').iCheck({
    checkboxClass: 'icheckbox_square-blue',
    radioClass: 'iradio_square-blue',
    increaseArea: '20%' // optional
  });
});
</script>
 -->
</head>
<body>
	<!-- 流式布局，页面上部空出50px-->
	<div class="row-fluid envbasePage">
	
		
		
			<!-- 页面内容置中，左右各留span1 -->
			<div class="span8 offset2">
				<!-- 页头  begin -->
				<div class="row-fluid">
					<div class="span12 envbaseTitle">
						<div class="span6">
							<h1 class="pageTitle">我的主页</h1>
						</div>
						<div class="span6" align="right">
						</div>
					</div>
				</div>
				<!-- 页头  end -->
				<!-- 面包屑 begin -->
				<!-- 
				<div class="row-fluid">
					<div class="span12">
						<ul class="breadcrumb">
							<li><span class="active">资料完整度</span></li>
						</ul>
					</div>
				</div>
				 -->
				
				
				
				
				
				
				
				<!-- 面包屑 end -->
				<div class="envbaseBorder">
				
				
				
				
				
				
				
					<!-- 片段头 begin -->
					<div class="sectionTitle">
						<h5>一句话介绍</h5>
					</div>
					<!-- 片段头 end -->
					<div class="row-fluid">
						<div class="span12 control-group">
							<!-- <label class="control-label" for="testarea3">文本域</label> -->
							<div class="controls">
								<textarea class="span12" id="testarea3" rows="2"
									placeholder="一句话可以做个简单的说明"></textarea>
							</div>
						</div>
					</div>
					
					
					
					
					
					
		<!-- 水平表单 begin -->
		<form class="form-horizontal" action="${ctx }/drmcompany/save" method="post">
					
					<!-- 片段头 begin -->
					<div class="sectionTitle">
						<h5>可以提供的信息</h5>
					</div>
					<!-- 片段头 end -->
					<div class="row-fluid">
						<div class="span12 control-group">
							<label class="control-label" for="inputEmail">公司名称</label>
							<div class="controls">
								<input class="span11" type="text" name="entity.companyName" required >&nbsp;
								<span style="color: red;">*</span>
							</div>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6 control-group">
							<label class="control-label" for="">部门名称</label>
							<div class="controls">
								<input class="span12" type="text" name="entity.deptName">
							</div>
						</div>
						<div class="span6 control-group">
							<label class="control-label" for="">职位</label>
							<div class="controls">
								<input class="span12" type="text" name="entity.postname" >
							</div>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6 control-group">
							<label class="control-label" for="">入职日期</label>
							<div class="controls">
								<div class="span6 input-append date datetime-picker" data-date-minView="month">
									<input class="span*" type="text" id="inputDate" name="entity.indate" required
										readonly><span class="add-on"><i
										class="icon-remove"></i></span><span class="add-on"><i
										class="icon-calendar"></i></span>
								</div>
							</div>
						</div>
						<div class="span6 control-group">
							<label class="control-label" for="">离职日期</label>
							<div class="controls">
								<div class="span6 input-append date datetime-picker" data-date-minView="month">
									<input class="span*" type="text" id="inputDate2" name="entity.outdate"
										readonly placeholder="离职日期"><span class="add-on"><i
										class="icon-remove"></i></span> <span class="add-on"><i
										class="icon-calendar"></i></span>
								</div>
							</div>
						</div>
						
					</div>
					
					<div class="row-fluid">
						<div class="span12 control-group">
							<label class="control-label" for="inputEmail">提供信息服务的方式</label>
							<div class="controls">
								<input type="checkbox" name="entity.qq" value="1">QQ
								<input type="checkbox" name="entity.weixin" value="1">微信
								<input type="checkbox" name="entity.phone" value="1">电话
								<input type="checkbox" name="entity.email" value="1">邮件
								<input type="checkbox" name="entity.ptshow" value="1">平台直接推送
								<input type="checkbox" name="entity.zhanneixin" value="1">站内信
							</div>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span12 control-group">
							<label class="control-label" for="">标价</label>
							<div class="controls">
								<input type="radio" name="entity.price" value="0">免费
								<input type="radio" name="entity.price" value="5">5元
								<input type="radio" name="entity.price" value="10">10元
							</div>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span12 control-group" style="text-align: center;">
							<input type="submit" class="span3 button button-glow button-border button-rounded button-primary" value="新增公司信息">
						</div>
					</div>
					
					<div id="message"></div>
					<!-- 公司列表 -->
					<c:forEach items="${companys }" var="company">
						<div class="row-fluid" style="text-align: left;margin-left: 20px;">
							<div class="span4 control-group"><input type="radio" class="company_select" name="company_select" onclick="selectCompany('${company.id}','${company.companyName }')" >${company.companyName }&nbsp;</div>
							<div class="span3 control-group"><fmt:formatDate value='${company.indate}' pattern='yyyy-MM' /> ~<c:if test="${company.outdate==null}">至今</c:if><fmt:formatDate value='${company.outdate}' pattern='yyyy-MM' />&nbsp;</div>
							<div class="span1 control-group">
								<c:choose>
								<c:when test="${null == company.price || company.price==0}">免费</c:when>
								<c:otherwise><fmt:formatNumber value="${company.price}" type="currency" pattern="￥#"/>元</c:otherwise>
								</c:choose>
							</div>
							<div class="span2 control-group">
							<c:if test="${company.qq ==1 }">QQ</c:if>&nbsp;<c:if test="${company.weixin ==1 }">微信</c:if>&nbsp;<c:if test="${company.email ==1 }">Email</c:if>
							<c:if test="${company.phone ==1 }">电话</c:if>&nbsp;<c:if test="${company.zhanneixin ==1 }">站内信</c:if>&nbsp;<c:if test="${company.ptshow ==1 }">平台直接展示</c:if>
							</div>
							<div class="span1 control-group">
								<a href="javascript:void(0)" onclick="deleteById('${company.id}')">删除</a>
							</div>
						</div>
					</c:forEach>
					
					
		</form>
		
		
		
					<!-- 片段头 begin -->
					<div class="sectionTitle">
						<input type="hidden" class="current_company_id" value="">
						<h5 class="company_h">公司名称：(请从上面选择一个公司)</h5>
					</div>
					<!-- 片段头 end -->
					<div class="row-fluid">
						<input type="hidden" class="i_gsxx" name="i_gsxx" value="">
						<input type="hidden" class="i_bmxx" name="i_gsxx" value="">
						<input type="hidden" class="i_xmxx" name="i_gsxx" value="">
						<input type="hidden" class="i_zdxx" name="i_gsxx" value="">
						<input type="hidden" class="i_zpxx" name="i_gsxx" value="">
						<input type="hidden" class="i_fldyxx" name="i_gsxx" value="">
						<input type="hidden" class="i_qtxx" name="i_gsxx" value="">
						<!-- <div class="span12 control-group" style="text-align: center;"> -->
						<div class="span12 btn-group" data-toggle="buttons-radio">
						  <button style="height:100px;width:100px;margin:5px;" class="b_gsxx button button-glow button-circle button-raised button-primary" onclick="selectOnetag($('input.i_gsxx').val())">公司信息</button>
						  <button style="height:100px;width:100px;margin:5px;" class="b_bmxx button button-glow button-circle button-border button-primary" onclick="selectOnetag($('input.i_bmxx').val())">部门信息</button>
						  <button style="height:100px;width:100px;margin:5px;" class="b_xmxx button button-glow button-circle button-border button-primary" onclick="selectOnetag($('input.i_xmxx').val())">项目信息</button>
						  <button style="height:100px;width:100px;margin:5px;" class="b_zdxx button button-glow button-circle button-border button-primary" onclick="selectOnetag($('input.i_zdxx').val())">制度信息</button>
						  <button style="height:100px;width:100px;margin:5px;" class="b_zpxx button button-glow button-circle button-border button-primary" onclick="selectOnetag($('input.i_zpxx').val())">招聘信息</button>
						  <button style="height:100px;width:100px;margin:5px;" class="b_fldyxx button button-glow button-circle button-border button-primary" onclick="selectOnetag($('input.i_fldyxx').val())">福利待遇信息</button>
						  <button style="height:100px;width:100px;margin:5px;" class="b_qtxx button button-glow button-circle button-border button-primary" onclick="selectOnetag($('input.i_qtxx').val())">其他信息</button>
						</div>
					</div>
					
					
					<div class="row-fluid">
						<div class="span12 control-group" style="text-align: center;">
						</div>
					</div>	
					<div class="twotagSection"></div>
				</div>
				
				
				
				
				
				
				
			</div>
		<!-- 水平表单 end -->
	</div>


<script type="text/javascript">

var selectOnetag = function(onetagid){
	
	// alert(onetagid);
	// alert($("input.current_company_id").val()) ;
	if($("input.current_company_id").val() == ''){
		//alert("请选择一家公司");
		EnvbaseUtil.createModal('提示信息', '请选择一家公司', function() {},"OK");
	}else{
		$("div.twotagSection").load("${ctx}/drmtwotag/twotagSection/"+onetagid+"/"+$("input.current_company_id").val());
	}
}

	
function selectCompany(id,name){
	$("input.current_company_id").val(id);
	$("h5.company_h").text("公司名称："+name);
	
	$.ajax({
		type:'post',
		url:'${ctx}/drmonetag/getonetagid/'+id,
		data:'text',
		success:function(data){
			//alert(data);
			var ds = data.split(",");
			
			$('input.i_gsxx').val(ds[0]);
			$('input.i_bmxx').val(ds[1]);
			$('input.i_xmxx').val(ds[2]);
			$('input.i_zdxx').val(ds[3]);
			$('input.i_zpxx').val(ds[4]);
			$('input.i_fldyxx').val(ds[5]);
			$('input.i_qtxx').val(ds[6]);
		},
		error:function(){
			alert("请刷新页面后再次选择公司！");
		}
		
	});
}

var deleteById = function(id) {
	EnvbaseUtil.createModal('删除公司', '确定要删除该公司？', function() {
		$.ajax({
			url:'${ctx}/drmcompany/delete/'+id,
			type : "DELETE",
			success : function(data) {
				if(data == "1"){
					window.location.href="${ctx}/myhome";
				}else if(data == "0"){
				}else if(data == "-1"){
				}
			},
			error : function(data) {
			}
		});
	},"确定");
};

</script>


</body>
</html>