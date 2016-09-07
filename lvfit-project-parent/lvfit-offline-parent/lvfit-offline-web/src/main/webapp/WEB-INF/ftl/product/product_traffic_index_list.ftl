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
		
		Date.prototype.format = function (format) {
			    var o = {
			        "M+": this.getMonth() + 1,
			        "d+": this.getDate(),
			        "h+": this.getHours(),
			        "m+": this.getMinutes(),
			        "s+": this.getSeconds(),
			        "q+": Math.floor((this.getMonth() + 3) / 3),
			        "S": this.getMilliseconds()
			    }
			    if (/(y+)/.test(format)) {
			        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
			    }
			    for (var k in o) {
			        if (new RegExp("(" + k + ")").test(format)) {
			            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
			        }
			    }
			    return format;
			}
			
			$(function (){
				initGrid();
			});

			function initGrid() 
			{
				var colNames = ['产品ID', '出发地ID','出发地名称','最低市场价','最低销售价','APP最低市场价','APP最低销售价','WAP最低市场价','WAP最低销售价','更新时间'];

				var cols = [ 
					{
						name : 'productId',  //产品ID
						index : 'productId',
						align : 'center',
						sortable:false
					},
					{
						name : 'startDistrictId',   //出发地ID
						index : 'startDistrictId',
						align : 'center',
						sortable:false
					},
					{
						name : 'startDistrict',   //出发地名称
						index : 'startDistrict',
						align : 'center',
						sortable:false
					},
					{
						name : 'lowestMarketPrice',   //最低市场价
						index : 'lowestMarketPrice',
						align : 'center',
						sortable:false
					},//--------------
					{
						name : 'lowestSaledPrice',   //市场最低销售价
						index : 'lowestSaledPrice',
						align : 'center',
						sortable:false
					},
					{
						name : 'appLowestMarketPrice',   //app最低市场价
						index : 'appLowestMarketPrice',
						align : 'center',
						sortable:false
					},
					{
						name : 'appLowestSaledPrice',   //app最低销售价
						index : 'appLowestSaledPrice',
						align : 'center',
						sortable:false
					},
					//----------------
					{
						name : 'wapLowestMarketPrice',  //wap最低市场价
						index : 'wapLowestMarketPrice',
						align : 'center',
						sortable:false
					},
					{
						name : 'wapLowestSaledPrice',//wap最低销售价
						index : 'wapLowestSaledPrice',
						align : 'center',
						sortable:false
					},
					{
						name : 'updateTime', //更新时间
						index : 'updateTime',
						formatter : dateFormatter,
						align : 'center',
						sortable:false
					}];
					
				$("#sdpProductList").jqGrid({
					url : '${request.contextPath}/sdpProduct/querySearchIndexList',
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
					rowList:[10,20,50,200],   //分页选项，可以下拉选择每页显示记录数
					caption : "打包产品查询列表",
					jsonReader : {
						id: "productId",
						root : "results",
						page : "pagination.page", //当前页
						records : "pagination.records", //总记录数
						total:'pagination.total',
						repeatitems : false
					},
					onPaging : function(pgButton) {
						$("#sdpProductList").jqGrid('setGridParam', {
							postData : getQueryParams()
						});
					}
				});
			}
			
			function getQueryParams(){
				var queryData = {
					'productId':$("#productId").val(),
				};
				console.info(queryData);
				return queryData;
			}
			
			function dateFormatter (cellvalue, options, rowObject)  
			{  
				   return new Date(cellvalue).format("yyyy-MM-dd hh:mm:ss");
			}
		</script>
	</head>
	<body>
	<div class="content content1">
		 <input type="hidden" id="basePath" value="${request.contextPath}">
		 <input type="hidden" id="productId" value="${productId}">
	     <input type="hidden" name="search" value="false">
		 <div class="breadnav">首页->交通+X->产品管理->产品索引列表</div>
		 <div class="content content1" style="margin-top:50px;">
	      <table id="sdpProductList"></table>
	      <div id="pager"></div>
	     </div>
    </div>
</body>
</html>