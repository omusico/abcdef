<!DOCTYPE html>
<html>
<head>
	<title>订单详情页</title>
	<link rel="stylesheet" type="text/css" href="${request.contextPath}/css/area_tankuang.css">
	<link rel="stylesheet" href="${request.contextPath}/css/order-details.css" type="text/css"/>
    <script type="text/javascript" src="${request.contextPath}/js/resources/jquery-1.7.1.min.js"></script>
    <script src="${request.contextPath}/js/order/orderDetailMain.js"> </script>
    <script src="${request.contextPath}/js/order/orderOpCommandBack.js"> </script>
    <script type="text/javascript" src="${request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>

</head>
<body>
	<div class="content content2">
		<div class="breadnav"><a href="javascript:;" target='_blank'>首页</a>： <span>订单管理</span> >订单详情页
		<#include "order/orderdetail/base.ftl">
		<#include "order/orderdetail/info.ftl">
		<#include "order/orderdetail/users.ftl">
		<div class="content content1" style="padding: 20px 500px 50px;">
		<div style="text-align:center">
			<a href="javascript:void(0);" onclick="javascript:window.close();"><div class="button">关闭</div></a>
		</div>
		</div>
	</div>
	</div>
</body>
</html>