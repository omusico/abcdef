<!DOCTYPE html>
<html>
<head>
	<title>购物车详情</title>
	<link rel="stylesheet" href="${request.contextPath}/css/order-details.css" type="text/css"/>
</head>
<body>
	<div class="content content2">		
		<div class="breadnav"><a href="javascript:;" target='_blank'>首页</a>： <span>购物车管理</span> > 购物车详情${gmail}		
		<#include "shopping/detail.ftl">
	</div>
</body>
</html>