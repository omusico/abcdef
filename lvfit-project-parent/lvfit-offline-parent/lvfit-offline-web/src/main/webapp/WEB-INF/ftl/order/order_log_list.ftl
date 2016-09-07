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
		<script src="${request.contextPath}/js/common/common.js"></script>
		<script type="text/javascript" src="${request.contextPath}/js/My97DatePicker/WdatePicker.js"></script> 
		
		<script type="text/javascript">
			$(function (){
				initGrid();
			}); 

         	//spinach 
			function query() {
				$("#flightOrderList").jqGrid('setGridParam', 
				{
		 			url:"${request.contextPath}/order/orderLog",
		 			datatype : "json",
		 			mtype : "POST",
			 		postData : getQueryParams()
				}).trigger("reloadGrid");
				
			}
	
			function getQueryParams() {
	    		
    			// 订单来源
	    		var operType =$("select[tempName='operType']").val();
        		
				return {
                    'fitOrderQueryDto.orderMainId' : "${mainOrderId}",
                    'fitOrderQueryDto.operType' : operType.toString(),
					'search':false
				}
			}
			
			function initGrid() 
			{
			
				var colNames = ['操作时间','描述', '操作类型','操作人','操作详情', '结果','操作ID客人ID', 'traceNo'];
		
				var cols = [ 
					{
						name : 'fitOrderOpLogDto.createTime',
						index : 'fitOrderOpLogDto.createTime',
						formatter:formatDate,
						align : 'center',
						sortable:false
					},
					{
						name : 'fitOrderOpLogDto.desc',
						index : 'fitOrderOpLogDto.desc',
						align : 'center',
						sortable:false
					},
					{
						name : 'operType',
						index : 'operType',
						align : 'center',
						sortable:false
					},
					{
						name : 'fitOrderOpLogDto.oper',
						index : 'fitOrderOpLogDto.oper',
						align : 'center',
						sortable:false
					},
					{
						name : 'fitOrderOpLogDto.remark',
						index : 'fitOrderOpLogDto.remark',
						align : 'center',
						sortable:false
					},
					{
						name : 'fitOrderOpLogDto.result', 
						index : 'fitOrderOpLogDto.result',
						align : 'center',
						sortable:false
					},
					{
						name : 'fitOrderOpLogDto.operId',
						index : 'fitOrderOpLogDto.operId',
						align : 'center',
						sortable:false
					},
					{
						name : 'fitOrderOpLogDto.traceNo',
						index : 'fitOrderOpLogDto.traceNo',
						align : 'center',
						sortable:false
					}
					];
					
				$("#flightOrderList").jqGrid({
					url : '${request.contextPath}/order/orderLog',
					datatype : "json",
					mtype : "POST",
					height:'auto',//高度，表格高度。可为数值、百分比或'auto'
					postData : getQueryParams(),
			        //width:1000,//这个宽度不能为百分比
			        autowidth:true,//自动宽
					colNames:colNames,
					colModel :cols,
					gridview:true,        //加速显示 
		            autowidth : true,
					rowNum : 10,
					pager : '#pager',
					viewrecords : true,
					rowList:[10,20,50],   //分页选项，可以下拉选择每页显示记录数
					//multiselect : true,   //是否设置全选按钮
					caption : "订单查询列表",
					jsonReader : {
						id: "orderId",
						root : "results",
						page : "pagination.page", //当前页
						records : "pagination.records", //总记录数
						total:'pagination.total',
						repeatitems : false
					},
					onPaging : function(pgButton) {
						$("#flightOrderList").jqGrid('setGridParam', {
							postData : getQueryParams()
						});
					}
				});
			} 
			

    		function formatDate(cellvalue, options, rowObject){
    			if(cellvalue){
    				return new Date(cellvalue).format("yyyy-MM-dd hh:mm:ss");
    			}else{
    				return "";
    			}
    		}
    		
  		//清空表单y
  		function clearForm()
  		{
  			$('input[type=text]').val('');
  			$('select').val('');
  			$('input[tempName="operType"]').attr('checked', false);
  		}
    		
    		
	
		</script>
	</head>
	<body>
	<div class="content content1">
	    <input type="hidden" name="search" value="false">
		<div class="breadnav">首页 > 订单日志</div>
		<div class="infor1" id="conditionDiv">
			<div class="order message">
				<div class="main">
					<div class="part">
						<span>操作人类型：</span>
						<select tempName="operType" onchange="query()">
						<option value="">全部</option>
						<#list operTypeEnum as val> 
						<option value="${val}">${val.cnName}</option>
						</#list>
						</select>
					</div>
					
				</div> <!-- END class="main" -->
			</div> 
		</div>
	</div>
	 <div class="content content1" style="margin-top:50px;">
      <table id="flightOrderList"></table>
      <div id="pager"></div>
    </div>
    <div class="content content1">
	<div class="click">
		<a href="javascript:void(0);" onclick="javascript:window.history.back();"><div class="button">返回</div></a>
		<a href="javascript:void(0);" onclick="javascript:window.close();"><div class="button">关闭</div></a>
	</div>
	</div>
	<div id="jsContainer" class="jsContainer" style="height: 0">
		<div id="tuna_alert"
			style="display: none; position: absolute; z-index: 999; overflow: hidden;"></div>
		<div id="tuna_jmpinfo"
			style="visibility: hidden; position: absolute; z-index: 120;"></div>
	</div>                  
	<script type="text/javascript" src="${request.contextPath}/js/fixdiv.js"></script>
	<script type="text/javascript" src="${request.contextPath}/js/address.js"></script>
</body>
</html>