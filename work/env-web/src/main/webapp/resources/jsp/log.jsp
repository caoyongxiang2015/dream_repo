<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="head.jsp"%>
<div class="index-nav-container">
            <ul class="index-nav">
                <li><a href="index.jsp">首页</a></li>
                <li><a href="Loading.jsp">组件</a></li>
                <li class="active"><a href="log.jsp">升级日志</a></li>
                <li><a href="download.jsp">JavaScript插件</a></li>
            </ul>
</div>
<div class="log-banner">
</div>
<div class="component-content clearfix status">
    <!--右边具体插件-->
    <h1><img src="../customize/images/logo_small.png"/></h1>
    <p>当前版本：<font class="green">1.0-SNAPSHOT</font></p>
    <p><span><i class="orange"></i>change</span><span><i class="blue"></i>BugFix</span><span><i class="bice"></i>Teature</span><span><i class="yellow"></i>warning</span></p>
    <div class="log">
        <h2>Sunivo Web 1.0  2014-04-08</h2>
        <div class="log-small dotted" style="border-bottom:none;">
            <p>接口： <a href="Validation.jsp">formValidation()</a>　类型：<i class="orange"></i>　开发者：杨成　</p>
            <dl class="x-dl-log clearfix">
                <dt>说明：</dt>
                <dd>1.支持ajax提交form表单时的验证。</dd>
                <dt>  &nbsp;</dt>
                <dd>2.插件内集成md5加密。</dd>
                <dt>  &nbsp;</dt>
                <dd>3.修改formValidation方法的部分bug。</dd>
            </dl>
        </div>
        <%--<div class="log-small">
            <p>接口：baidu().css　类型：change()　开发者：石怡　<i class="blue"></i></p>
            <small>说明：1.记支出、收入账目时，可以直接晒帐到微博。 2.在记账页面增加了发微博功能。 3.客户端注册问题、精品推荐统计流量跳转的问题。 </small>
        </div>--%>
        <div class="log-border"></div>
        <h2>Sunivo Web 1.0  2014-04-21</h2>
        <div class="log-small dotted" style="border-bottom:none;">
            <p>接口： <a href="Cookie.jsp">$.cookie()</a>　类型：<i class="orange"></i>　开发者：杨成　</p>
            <dl class="x-dl-log clearfix">
                <dt>说明：</dt>
                <dd>1.可以使用本地存储，添加，删除自定义cookie。 </dd>
            </dl>
        </div>
        <div class="log-border"></div>
        <h2>Sunivo Web 1.0  2014-05-14</h2>
        <div class="log-small dotted" style="border-bottom:none;">
            <p>接口： <a href="checkbox-relevance.jsp">checkboxPlug</a>　类型：<i class="orange"></i>　开发者：杨成　</p>
            <dl class="x-dl-log clearfix">
                <dt>说明：</dt>
                <dd>1.修改之前的关联方式，支持配置，完成关联。</dd>
            </dl>
        </div>
        <div class="log-border"></div>
        <h2>Sunivo Web 1.0  2014-05-14</h2>
        <div class="log-small dotted" style="border-bottom:none;">
            <p>接口： <a href="Validation.jsp">formValidation()</a>　类型：<i class="orange"></i>　开发者：杨成　</p>
            <dl class="x-dl-log clearfix">
                <dt>说明：</dt>
                <dd>1.新增了对validate插件用法的描述。</dd>
            </dl>
        </div>
        <div class="log-border"></div>
        <h2>Sunivo Web 1.0  2014-05-15</h2>
        <div class="log-small dotted" style="border-bottom:none;">
            <p>接口： <a href="checkAll.jsp">$.fn.doCheckAll()</a>　类型：<i class="orange"></i>　开发者：杨成　</p>
            <dl class="x-dl-log clearfix">
                <dt>说明：</dt>
                <dd>1.提供全选功能，支持动态添加。</dd>
            </dl>
        </div>
        <div class="log-border"></div>
        <%--<h2>Sunivo Web 1.0  2014-04-08</h2>
        <div class="log-small dotted">
            <p>接口：baidu().css　类型：change()　开发者：石怡　<i class="blue"></i></p>
            <small>说明：1.记支出、收入账目时，可以直接晒帐到微博。 2.在记账页面增加了发微博功能。 3.客户端注册问题、精品推荐统计流量跳转的问题。 </small>
        </div>
        <div class="log-small">
            <p>接口：baidu().css　类型：change()　开发者：石怡　<i class="bice"></i></p>
            <small>说明：1.记支出、收入账目时，可以直接晒帐到微博。 2.在记账页面增加了发微博功能。 3.客户端注册问题、精品推荐统计流量跳转的问题。 </small>
        </div>
        <div class="log-border"></div>
        <h2>Sunivo Web 1.0  2014-04-08</h2>
        <div class="log-small dotted">
            <p>接口：baidu().css　类型：change()　开发者：石怡　<i class="yellow"></i></p>
            <small>说明：1.记支出、收入账目时，可以直接晒帐到微博。 2.在记账页面增加了发微博功能。 3.客户端注册问题、精品推荐统计流量跳转的问题。 </small>
        </div>
        <div class="log-small">
            <p>接口：baidu().css　类型：change()　开发者：石怡　<i class="bice"></i></p>
            <small>说明：1.记支出、收入账目时，可以直接晒帐到微博。 2.在记账页面增加了发微博功能。 3.客户端注册问题、精品推荐统计流量跳转的问题。 </small>
        </div>
        <div class="log-border"></div>
        <h2>Sunivo Web 1.0  2014-04-08</h2>
        <div class="log-small dotted">
            <p>接口：baidu().css　类型：change()　开发者：石怡　<i class="yellow"></i></p>
            <small>说明：1.记支出、收入账目时，可以直接晒帐到微博。 2.在记账页面增加了发微博功能。 3.客户端注册问题、精品推荐统计流量跳转的问题。 </small>
        </div>
        <div class="log-small">
            <p>接口：baidu().css　类型：change()　开发者：石怡　<i class="yellow"></i></p>
            <small>说明：1.记支出、收入账目时，可以直接晒帐到微博。 2.在记账页面增加了发微博功能。 3.客户端注册问题、精品推荐统计流量跳转的问题。 </small>
        </div>
        <div class="log-border"></div>
        <h2>Sunivo Web 1.0  2014-04-08</h2>
        <div class="log-small dotted">
            <p>接口：baidu().css　类型：change()　开发者：石怡　<i class="bice"></i></p>
            <small>说明：1.记支出、收入账目时，可以直接晒帐到微博。 2.在记账页面增加了发微博功能。 3.客户端注册问题、精品推荐统计流量跳转的问题。 </small>
        </div>
        <div class="log-small">
            <p>接口：baidu().css　类型：change()　开发者：石怡　<i class="yellow"></i></p>
            <small>说明：1.记支出、收入账目时，可以直接晒帐到微博。 2.在记账页面增加了发微博功能。 3.客户端注册问题、精品推荐统计流量跳转的问题。 </small>
        </div>--%>
    </div>


</div>
<%@include file="foot.jsp"%>
<script type="text/javascript">
    sw_define(function(){
        document.body.style.background = "#f0f0f0";
        var a = new sw();
        a.init();
    });
</script>