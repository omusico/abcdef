<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>驴妈妈（机+X）后台管理系统</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="${request.contextPath}/css/ui-common.css">
<link rel="stylesheet" href="${request.contextPath}/css/ui-components.css">
<link rel="stylesheet" href="${request.contextPath}/css/ui-panel.css">
<link rel="stylesheet" href="${request.contextPath}/css/dialog.css" type="text/css"/>
<script type="text/javascript" src="${request.contextPath}/js/resources/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${request.contextPath}/js/jquery-ui.js"></script>
</head>

<script type="text/javascript">


document.domain = 'fit.lvmama.com';

//重新登录系统
function registerLogin(){
 top.location = "${request.contextPath}/userLogin";
}
//重新登录系统
function exitLogin(){
if(confirm('确定要退出系统？')){
window.close();
window.parent.close();
top.location = "${request.contextPath}/userLogin";
  }
}

</script>
<body>
<!-- 顶部导航\\ -->
<div class="topbar">
	<a class="logo" href="/panel/"><h1>驴妈妈机酒业务管理系统<small></small></h1></a>
	<p>操作员：<span>${(users.userName)!""} </span> [<a id="reLogin" class="B" href="javascript:void();" onclick="registerLogin()";>重新登陆</a>]　[
	<a href="#" class="B" target="_self" onclick="exitLogin()">退出系统</a>]</p>
</div>
<!-- //顶部导航 -->

<!-- 边栏\\ -->
<div id="panel_aside" class="panel_aside">
	<span id="oper_aside" class="icon-arrow-left"></span>
    <span id="oper_set" class="icon-set"></span>
	<div class="aside_box">
		<#if menuList??>
			<ul id="aside_list" class="aside_list ul_oper_list">
			<#list menuList as obj>
				<li class="oper_item"><a target="iframeMain" ><span class="icon-tag"></span>${obj.name}</a>
            	<ul class="ul_oper_list"> 
				<#list obj.subList as subObj>
					<li class="oper_item"><a target="iframeMain" href="${subObj.url?if_exists}"><span class="icon-tag"></span>${subObj.name}</a></li>
				</#list>
				</ul>
				</li>
			</#list>
			</ul>
		<#else>
		<ul id="aside_list" class="aside_list ul_oper_list">
		    <li class="oper_item"><a target="iframeMain" ><span class="icon-tag_2"></span>购物车管理</a>
            <ul class="ul_oper_list">
               <li class="oper_item"><a target="iframeMain" href="${request.contextPath}/shopping/toShoppingList"><span class="icon-tag_1"></span>购物车列表</a></li>           	        
	        </ul>
			</li>
			<li class="oper_item"><a target="iframeMain" ><span class="icon-tag_2"></span>订单管理</a>
            <ul class="ul_oper_list">
                <li class="oper_item"><a target="iframeMain" href="${request.contextPath}/back_index"><span class="icon-tag_1"></span>后台下单</a></li>
	            <li class="oper_item"><a target="iframeMain" href="${request.contextPath}/order/toOrderQuery"><span class="icon-tag_1"></span>订单列表查询</a></li>
	            <li class="oper_item"><a target="iframeMain" href="${request.contextPath}/sdpProduct/suppCallBack"><span class="icon-tag_1"></span>机票回调</a></li>
	             </ul>
			</li>
			<li class="oper_item"><a target="iframeMain" ><span class="icon-tag_2"></span>报表管理</a>
            <ul class="ul_oper_list">
               <li class="oper_item"><a target="iframeMain" href="${request.contextPath}/report/toRevenueReport"><span class="icon-tag_1"></span>机酒营收报表</a></li>           	        
	        </ul>
			</li>
			<li class="oper_item"><a target="iframeMain" ><span class="icon-tag_2"></span>配置管理</a>
            <ul class="ul_oper_list">
               <li class="oper_item"><a target="iframeMain" href="${request.contextPath}/hotel/toRecomHotelList"><span class="icon-tag_1"></span>推荐酒店配置</a></li>           	        
	        </ul>
			</li>
			<li class="oper_item"><a target="iframeMain" ><span class="icon-tag_2"></span>日志管理</a>
            <ul class="ul_oper_list">
               <li class="oper_item"><a target="iframeMain" href="${request.contextPath}/fitOpLog/index"><span class="icon-tag_1"></span>查询操作日志</a></li>   
               <li class="oper_item"><a target="iframeMain" href="${request.contextPath}/fitSearchRecord/index"><span class="icon-tag_1"></span>搜索记录</a></li>        	        
	        </ul>
			</li>
			<li class="oper_item"><a target="iframeMain" ><span class="icon-tag_2"></span>产品管理</a>
            <ul class="ul_oper_list">
               <li class="oper_item"><a target="iframeMain" href="${request.contextPath}/sdpProduct/query"><span class="icon-tag_1"></span>产品列表</a></li>
               <li class="oper_item"><a target="iframeMain" href="${request.contextPath}/sdpProduct/syncQuery"><span class="icon-tag_1"></span>产品同步管理</a></li>
               <li class="oper_item"><a target="iframeMain" href="${request.contextPath}/sdpProduct/searchSynInfo"><span class="icon-tag_1"></span>查询同步记录</a></li>      
	        </ul>
			</li>
		</ul>
		
		
		</#if>
		<!-- //ul aside_list -->
	</div>
</div>
<!-- //边栏 -->
<div id="panel_control" class="panel_control"></div>
<!-- 工作区\\ -->
<div id="panel_main" class="panel_main">
	<iframe id="iframeMain" name="iframeMain" src="" frameborder="0" style=" height:100%; background:#fff"></iframe>
	<div class="scoll-mask"></div>
</div>
<!-- //工作区 -->


<!-- 底部\\ -->
<div class="footer"></div><!-- //底部 -->
<script src="${request.contextPath}/js/resources/jqGrid/js/jquery-1.7.2.min.js"> </script>
<script src="${request.contextPath}/js/panel-custom.js"></script>
<script>
</script>

</body>
</html>
