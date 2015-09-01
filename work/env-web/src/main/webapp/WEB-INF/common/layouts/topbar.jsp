<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="com.env.constant.Constants"%>
<%@page import="com.env.dto.PtUser"%>
<%@include file="/WEB-INF/common/layouts/common.jsp"%>

<!-- [[ 公共头部 -->
    <header class="navbar-fixed-top">
    	<div class="container clearfix">
    		<div class="logo left">
	    		<a href="#" class="logo-link">
	    			<h1>好职客</h1>
	    			<img src="${static_common}/hzk/images/logo.png" alt="好职客">
	    		</a>
    		</div>
    		<ul class="nav navbar-nav left" role="navigator">
    			<li class="active"><a href="${ctx }">首页</a></li>
    			<li><a href="${ctx }/drmletter">私信</a></li>
    			<li><a href="${ctx }/drmreq">需求</a></li>
    			<li><a href="${ctx }/profile">我的资料</a></li>
    		</ul>
    		<div class="dropdown right">
	    		<a href="#" class="dropdown-toggle">
		    		<img src="${static_common}/hzk/images/pic.png" alt=""/>
    			</a>
	    		<ul class="dropdown-menu dropup">
	    			<li>
	    				<a href="javascript:;">修改密码</a>
	    				<a href="javascript:window.location.href='${ctx }/auth/logout'">退出</a>
	    			</li>
		    		<span class="caret posa"></span>
	    		</ul>
    		</div>
    		<button class="btn btn-large btn-primary right btn-release" onclick="javascript:window.location.href='${ctx}/release/first'" type="button">发布需求</button>
    		<form id="mysearch" action="${ctx }/drmsearch" class="form-inline search-form right" method="post">
    			<div class="input-group posr">
	    			<input type="text" class="form-control" placeholder="搜索公司" id="searchCompany" name="searchCompany">
		    		<i class="glyphicon glyphicon-search posa"></i>
	    			<span class="input-group-btn">
		    			<%-- <button type="button" onclick="javascript:window.location.href='${ctx}/drmsearch'" class="btn btn-success btn-large">搜索</button> --%>
		    			<button type="submit" class="btn btn-success btn-large">搜索</button>
	    			</span>
		    	</div>
    		</form>
    	</div>
	
	
<script src="${static_common}/hzk/js/jquery.min.js"></script>

<script type="text/javascript" src="${static_common}/hzk/js/jquery.validate.js"></script>
<script type="text/javascript" src="${static_common}/hzk/js/jquery-validate.bootstrap-tooltip.js"></script>
	
<script type="text/javascript">
		$("#mysearch").validate({
			rules : {
				// 表单的name值
				searchCompany: {required: true}
			},
			tooltip_options: {
				searchCompany: {placement: 'left'}
			}
		})
	</script>
	

    </header>
	<!-- 公共头部 ]] -->