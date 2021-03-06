  <%@ page language="java" pageEncoding="UTF-8"%>
 <link rel="stylesheet" href="../customize/css/case.css">
  <%@include file="head.jsp"%>
  <%@include file="top.jsp"%>
  <div class="component-content clearfix"> 
  <%@include file="left.jsp"%>
  

  <!--右边具体插件-->
<div class="component-substance">
      <h1>标签页tab.js </h1>
  <!--插件编译人、编译时间-->
      <label>开发者：瞿亚鹏　发布日期：2014-03-27　版本号：1.0　评价：<span><i></i><i></i><i></i></span></label>
      <div class="component-block">
        <h2>★ 案例</h2>
        通过添加标签页功能，可以让多个内容区域快速、动态切换。下拉菜单也可以使用。 
      </div>
      <h3>静态案例</h3> 
      <div class="bs-docs-example"> 
    <!--添加插件案例-->
        <ul id="myTab" class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#home">供应链金融</a></li>
            <li><a data-toggle="tab" href="#profile">国际物流</a ></li>
            <li class="dropdown">
            <a id="myTabDrop1" class="dropdown-toggle" data-toggle="dropdown" href="#">贸易代理<b class="caret"></b></a>
            <ul class="dropdown-menu" aria-labelledby="myTabDrop1" role="menu">
                <li><a data-toggle="tab" tabindex="-1" href="#dropdown1">进口贸易代理</a></li>
                <li><a data-toggle="tab" tabindex="-1" href="#dropdown2">出口贸易代理</a></li>
            </ul>
            </li>
        </ul>
        <div id="myTabContent" class="tab-content">
            <div  id="home"class="tab-pane fade in active">
                <p>上海春宇供应链管理有限公司是中国最大的，基于电子商务平台的化工供应链服务提供商。为全球化工领域建立一个跨企业的业务支持平台，通过供应链的集成，达到一站式服务的目标。</p>
            </div>
            <div  id="profile" class="tab-pane fade">
                <p>春宇会员培训”内容涉及进出口物流、报关、报检、金融等方面知识，并安排专家为各中小企业讲解进出口贸易各个环节的要点并解答企业遇到的困难，使他们对外贸实务有更清晰的认识，提高了企业的进出口效率。</p>
            </div>
            <div  id="dropdown1" class="tab-pane fade">
                <p>公司专注于化工进出口领域，为国际及国内中下游化工企业和化工产品应用企业提供采购外包、物流规划与实施、供应链金融结算、代理进口、全球分销等供应链服务，与客户共享资源，为客户创造价值。应用信息技术使所有参与者在信息、工作流、计划上实现高效率协同作业。</p>
            </div>
            <div  id="dropdown2" class="tab-pane fade">
                <p>由上海春宇供应链管理有限公司主办的“春宇‘快贸通’•中小企业综合金融服务方案合作备忘录签署暨启动仪式”，将于2013年9月26日上午在上海国际会议中心5楼长江厅隆重举办。</p>
            </div>
        </div>
        
   </div>
      <!--添加插件代码-->
  	<h2>★ 用法</h2>
    <p>通过JavaScript启动可切换标签页（每个标签页单独被激活）：</p>
  	<pre class="prettyprint  linenums"><ol class="linenums"><!-- <li>&lt;ul class=&quot;nav&nbsp;nav-tabs&quot; id=&quot;myTab&quot; &gt;&lt;ul/&gt;</li>--><li>$(<span class="text-warning">'#myTab a'</span>).click(function (e) {</li><li>e.preventDefault()</li><li>$(this).tab(<span class="text-warning">'show'</span>)</li><li>})</li></ol></pre>
    <p>可以有以下几种方式单独激活标签页：</p>
    <pre class="prettyprint  linenums"><ol class="linenums"><li>$(<span class="text-warning">'#myTab a[href="#profile"]'</span>).tab(<span class="text-warning">'show'</span>)</li><li>$(<span class="text-warning">'#myTab a:first'</span>).tab(<span class="text-warning">'show'</span>)</li><li>$(<span class="text-warning">'#myTab a:last'</span>).tab(<span class="text-warning">'show'</span>)</li><li>$(<span class="text-warning">'#myTab li:eq(<span class="text-success">2</span>) a'</span>).tab(<span class="text-warning">'show'</span>)</li></ol></pre>
    <h2>★ 调用方式</h2>
    <p>只需为页面元素简单的添加 <code>data-toggle="tab"</code> 或 <code>data-toggle="pill"</code> 就可以无需写任何JavaScript代码也能激活标签页。</p>
    <p>需为ul添加 <code>.nav</code> 和 <code>.nav-tabs</code> 的class即可为其赋予标签页样式</p>
    <pre class="prettyprint  linenums"><ol class="linenums"><li>&lt;ul <span class="text-success">class=</span><span class="text-warning">&quot;nav&nbsp;nav-tabs&quot;</span> <span class="text-success">id=</span><span class="text-warning">&quot;myTab&quot;</span> &gt;</li><li>    &lt;li&gt;&lt;a <span class="text-success">href=</span><span class="text-warning">"#home"</span> <span class="text-success">data-toggle=</span><span class="text-warning">"tab"</span>&gt;供应链金融&lt;/a&gt;&lt;/li&gt;</li><li>    &lt;li&gt;&lt;a <span class="text-success">href=</span><span class="text-warning">"#profile"</span> <span class="text-success">data-toggle=</span><span class="text-warning">"tab"</span>&gt;国际物流&lt;/a&gt;&lt;/li&gt;</li><li>    &lt;li&gt;&lt;a <span class="text-success">href=</span><span class="text-warning">"#messages"</span> <span class="text-success">data-toggle=</span><span class="text-warning">"tab"</span>&gt;贸易代理&lt;/a&gt;&lt;/li&gt;</li><li>&lt;/ul&gt;</li></ol></pre>
     <h2>★ 方法</h2>
     <p>激活标签页和内容区。每个标签页都应该通过data-target 或 href以指定目标内容容器。</p>
     <pre class="prettyprint  linenums"><ol class="linenums"><li>&lt;ul <span class="text-success">class=</span><span class="text-warning">&quot;nav&nbsp;nav-tabs&quot;</span> <span class="text-success">id=</span><span class="text-warning">&quot;myTab&quot;</span> &gt;</li><li>    &lt;li&gt;&lt;a <span class="text-success">href=</span><span class="text-warning">"#home"</span> <span class="text-success">data-toggle=</span><span class="text-warning">"tab"</span>&gt;供应链金融&lt;/a&gt;&lt;/li&gt;</li><li>    &lt;li&gt;&lt;a <span class="text-success">href=</span><span class="text-warning">"#profile"</span> <span class="text-success">data-toggle=</span><span class="text-warning">"tab"</span>&gt;国际物流&lt;/a&gt;&lt;/li&gt;</li><li>    &lt;li&gt;&lt;a <span class="text-success">href=</span><span class="text-warning">"#messages"</span> <span class="text-success">data-toggle=</span><span class="text-warning">"tab"</span>&gt;贸易代理&lt;/a&gt;&lt;/li&gt;</li><li>&lt;/ul&gt;</li><li></li><li>&lt;div <span class="text-success">class=</span><span class="text-warning">"tab-content"</span>&gt;</li><li>    &lt;div <span class="text-success">class=</span><span class="text-warning">"tab-pane active"</span> <span class="text-success">id=</span><span class="text-warning">"home"</span>&gt;...&lt;/div&gt;</li><li>    &lt;div <span class="text-success">class=</span><span class="text-warning">"tab-pane"</span> <span class="text-success">id=</span><span class="text-warning">"profile"</span>&gt;...&lt;/div&gt;</li><li>    &lt;div <span class="text-success">class=</span><span class="text-warning">"tab-pane"</span> <span class="text-success">id=</span><span class="text-warning">"messages"</span>&gt;...&lt;/div&gt;</li><li>&lt;/div&gt;</li><li></li><li>&lt;script&gt;</li><li>    $(function () {</li><li>      $(<span class="text-warning">'#myTab a:last'</span>).tab(<span class="text-warning">'show'</span>);</li><li>    })</li><li>&lt;/scritp&gt;</li></ol></pre>
      <h2>★ 事件</h2>
      <div class="table-responsive">
      <table class="table table-bordered table-striped">
        <thead>
         <tr>
           <th style="width: 150px;">事件类型</th>
           <th>描述</th>
         </tr>
        </thead>
        <tbody>
         <tr>
           <td>show.bs.tab</td>
           <td>This event fires on tab show, but before the new tab has been shown. Use <code>event.target</code> and <code>event.relatedTarget</code> to target the active tab and the previous active tab (if available) respectively.</td>
        </tr>
        <tr>
           <td>shown.bs.tab</td>
           <td>This event fires on tab show after a tab has been shown. Use <code>event.target</code> and <code>event.relatedTarget</code> to target the active tab and the previous active tab (if available) respectively.</td>
         </tr>
        </tbody>
      </table>
    </div><!-- /.table-responsive -->
      <div class="highlight">
     <pre class="prettyprint  linenums"><ol><code><li>    $(<span class="text-warning">'a[data-toggle="tab"]'</span>).on(<span class="text-warning">'shown.bs.tab'</span>, <span><span>function</span> <span>(e)</span> {</span></li><li>    e.target <span>// activated tab</span></li><li>    e.relatedTarget <span>// previous tab</span></li><li>    })</li></code></ol></pre>
    </div>
      </div> 
</div>

 <%@include file="foot.jsp"%>