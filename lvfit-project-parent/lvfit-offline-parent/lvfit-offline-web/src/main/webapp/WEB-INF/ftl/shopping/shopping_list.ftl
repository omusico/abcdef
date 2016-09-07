<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<link rel="stylesheet" href="${request.contextPath}/css/order-details.css" type="text/css"/>
		<link rel="stylesheet" href="${request.contextPath}/css/trip-list.css">
		<link type="text/css" rel="stylesheet" href="${request.contextPath}/js/resources/jquery-ui-1.8.11/css/redmond/jquery-ui-1.8.11.css"/>
		<link type="text/css" rel="stylesheet" href="${request.contextPath}/js/resources/jqGrid/css/ui.jqgrid.css"/>
		<link rel="stylesheet" type="text/css" href="${request.contextPath}/css/area_tankuang.css">
		<script src="${request.contextPath}/js/resources/jqGrid/js/jquery-1.7.2.min.js"> </script>
		<script src="${request.contextPath}/js/resources/jquery-ui-1.8.10.custom.min.js"></script>
		<script src="${request.contextPath}/js/resources/jqGrid/src/i18n/grid.locale-cn.js"></script>
		<script src="${request.contextPath}/js/resources/jqGrid/js/jquery.jqGrid.src.js"></script>
		<script type="text/javascript" src="${request.contextPath}/js/My97DatePicker/WdatePicker.js"></script> 
		
		<script type="text/javascript">
			$(function (){
				initGrid();								
			}); 
			   
         function formatLink(cellvalue, options, rowObject) 
			{
	    		var url = "${request.contextPath}/shopping/queryShoppingDetail/"+rowObject.shoppingUuid;
	    		return  "<a href='"+url+"' style='color:blue;' target='_blank'>" + cellvalue + "</a>";
    		}
    		
			function query() 
			{
				$("#shoppingList").jqGrid('setGridParam', 
				{
		 			url:"${request.contextPath}/shopping/queryShoppingList",
		 			datatype : "json",
		 			mtype : "POST",
			 		postData : getQueryParams()
				}).trigger("reloadGrid");
			  conditionHtmlToExportCsvForm();	
				
			}
	
			function getQueryParams() 
			{	    		
	    			
				return {
					'shoppingUUId':$('#shoppingUUId').val(),
					'queryBegTime':$("#queryBegTime").val(),
					'queryEndTime':$("#queryEndTime").val(),
					'contacterName':$("#contacterName").val(),
					'contacterMobile':$("#contacterMobile").val(),
					'search':false
				}
			}
	
			function initGrid() 
			{
			
				var colNames = ['购物车编号', '用户Id','用户名称','购买人名称','购买人手机号','出发城市','到达城市','入住城市','乘客类型','创建时间','VST订单状态','VST订单信息','机票去程订单状态','机票去程订单信息','机票返程订单状态','机票返程订单信息'];
		
				var cols = [ 
					{
						name : 'shoppingUuid',
						index : 'shoppingUuid',
						formatter:formatLink,
						align : 'center',
						sortable:false
					},
					{
						name : 'customerId',
						index : 'customerId',
						align : 'center',
						sortable:false
					},
					{
						name : 'customerName',
						index : 'customerName',
						align : 'center',
						sortable:false
					},
					{
						name : 'contacterName',
						index : 'contacterName',
						sortable:false
					},
					{
						name : 'contacterMobile',
						index : 'contacterMobile',
						align : 'center',
						sortable:false
					},
					{
						name : 'departureCityName',
						index : 'departureCityName',
						align : 'center',
						sortable:false
					},
					{
						name : 'arrivalCityName',
						index : 'arrivalCityName',
						align : 'center',
						sortable:false
					},
					{
						name : 'hotelCityName',
						index : 'hotelCityName',
						align : 'center',
						sortable:false
					},
					{
						name : 'passengerType',
						index : 'passengerType',
						align : 'center',
						sortable:false
					},
					{
						name : 'createTimeStr',
						index : 'createTimeStr',
						align : 'center',
						sortable:false
					},
					{
						name : 'vstOrderStatus',
						index : 'vstOrderStatus',
						align : 'center',
						sortable:false
					},
					{
						name : 'vstOrderMsg',
						index : 'vstOrderMsg',
						align : 'center',
						sortable:false
					},
					{
						name : 'depFliOrderStatus',
						index : 'depFliOrderStatus',
						align : 'center',
						sortable:false
					},
					{
						name : 'depFliOrderMsg',
						index : 'depFliOrderMsg',
						align : 'center',
						sortable:false
					},
					{
						name : 'arvFliOrderStatus',
						index : 'arvFliOrderStatus',
						align : 'center',
						sortable:false
					},
					{
						name : 'arvFliOrderMsg',
						index : 'arvFliOrderMsg',
						align : 'center',
						sortable:false
					}];
					
							
				$("#shoppingList").jqGrid({
					url : '${request.contextPath}/shopping/queryShoppingList',
					datatype : "json",
					mtype : "POST",
					height:'auto',//高度，表格高度。可为数值、百分比或'auto'
			        //width:1000,//这个宽度不能为百分比
			        autowidth:true,//自动宽
					colNames:colNames,
					colModel :cols,
					gridview:true,        //加速显示 
		            autowidth : true,
					rowNum : 10,
					pager : '#pager',
					viewrecords : true,
					rowList:[10,20,50,200],   //分页选项，可以下拉选择每页显示记录数
					//multiselect : false,   //是否设置全选按钮
					caption : "购物车查询列表",
					jsonReader : {
						root : "results",
						page : "pagination.page", //当前页
						records : "pagination.records", //总记录数
						total:'pagination.total',
						repeatitems : false
					},
					onPaging : function(pgButton) {
						$("#shoppingList").jqGrid('setGridParam', {
							postData : getQueryParams()
						});
					}
				});
			} 
			
    		//清空表单
    		function clearForm()
    		{
    			$('input[type=text]').val('');
    			$('select').val('');
    			$('input[tempName="bookingSource"]').attr('checked', false);
    		} 
    		
    		
    		//将条件插入到导出exportCsvForm
    		function conditionHtmlToExportCsvForm()
    		{
				$('#exportCsvDiv').html($('#condition').html());				
				//元素赋值
				$.each($('#condition').find('input[type="text"]'), function(index, obj)
				{
						$('#exportCsvDiv').find('input[name="'+objName+'"]').attr('value', $(obj).val());
				});				
    		}
    		//导出Csv
    		function exportCsv()
    		{
    			$('#exportCsvForm').submit();
    		}  
					
		</script>
	</head>
	<body>
	<div class="content content1">
	    <input type="hidden" name="search" value="false">
		<div class="breadnav">首页 > 购物车查询</div>
		<div class="infor1" id ="condition">
			<!--<div class="order message" id="conditionDiv">-->
				<div class="title">购物查询</div>
				<div class="main">
					<div class="part">
						<span>订购物车编号：</span><input type="text" id="shoppingUUId" name="shoppingUUId">						
					</div>
					<div class="part">
						<span>购买人姓名：</span><input type="text" id="contacterName" name="contacterName">
						<span>购买人手机号：</span><input type="text" id="contacterMobile" name="contacterMobile">						
					</div>	
 					<div class="part">
						<span>下单时间：</span><input type="text" id="queryBegTime" name="queryBegTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" style="width:100px;" 
							class="Wdate" readonly="readonly"/>
						 - 
						<input type="text" id="queryEndTime" name="queryEndTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" style="width:100px;" 
						 	class="Wdate" readonly="readonly"/>
					</div>
									
				<!--</div>-->
			</div> 						
		</div>
		<div class="click">
			<a href="javascript:void(0);" onclick="query();"><div class="button">查询</div></a>
			<a href="javascript:void(0);" onclick="clearForm();"><div class="button">清空</div></a>	
			<a href="javascript:void(0);" onclick="exportCsv();"><div class="button">导出Csv</div></a>		 
		</div>
	</div>
	 <div class="content content1" style="margin-top:50px;">
      <table id="shoppingList"></table>
      <div id="pager"></div>
    </div>
    <br>
    <br>
   
   
	<form id="exportCsvForm" action="${request.contextPath}/shopping/exportCsv" method="post" target="_blank">
		<div id="exportCsvDiv" style="display:none;">
		</div>
	</form>
	
	<div id="jsContainer" class="jsContainer" style="height: 0">
		<div id="tuna_alert"
			style="display: none; position: absolute; z-index: 999; overflow: hidden;"></div>
		<div id="tuna_jmpinfo"
			style="visibility: hidden; position: absolute; z-index: 120;"></div>
	</div>                  
	<script type="text/javascript" src="${request.contextPath}/js/fixdiv.js"></script>
	<script type="text/javascript" src="${request.contextPath}/js/address.js"></script>
		<!--隐藏控件-->		
		<input type="hidden" name="paymentNoOperate" id="paymentNoOperate" />
		<input type="hidden" name="orderId" id="orderId" />
		<input type="hidden" name="orderMainId" id="orderMainId" />
</body>
</html>