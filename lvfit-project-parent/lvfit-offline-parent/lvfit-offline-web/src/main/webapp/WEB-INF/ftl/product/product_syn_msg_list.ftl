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
				var colNames = ['产品ID', '同步产品基本信息消耗时间','同步产品索引消耗时间','同步产品索引状态','同步产品基本信息状态','创建时间'];

				var cols = [ 
					{
						name : 'productId',
						index : 'productId',
						align : 'center',
						sortable:false
					},
					{
						name : 'productSyncTime',
						index : 'productSyncTime',
						align : 'center',
						sortable:false
					},
					{
						name : 'indexSyncTime', 
						index : 'indexSyncTime',
						align : 'center',
						sortable:false
					},//--------------
					{
						name : 'productSyncStatus', 
						index : 'productSyncStatus',
						align : 'center',
						sortable:false
					},
					{
						name : 'indexSyncStatus',  
						index : 'indexSyncStatus',
						align : 'center',
						sortable:false
					},
					{
						name : 'createTime',   
						index : 'createTime',
						align : 'center',
						formatter : dateFormatter,
						sortable:false
					}];
					
				$("#sdpProductList").jqGrid({
					url : '${request.contextPath}/sdpProduct/queryAllSynInfo',
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
					'productId':$("#productIdInput").val(),
					'indexSyncStatus':$("#productIndexInput").val(),
					'productSyncStatus':$("#productBasicInfoInput").val()
				};
				return queryData;
			}
			
			function dateFormatter (cellvalue, options, rowObject)  
			{  
				   return new Date(cellvalue).format("yyyy-MM-dd hh:mm:ss");
			}
			
			function query(){
				$("#sdpProductList").jqGrid('setGridParam', 
				{
		 			url:"${request.contextPath}/sdpProduct/queryAllSynInfo",
		 			datatype : "json",
		 			mtype : "POST",
			 		postData : getQueryParams()
				}).trigger("reloadGrid");
			}
		</script>
	</head>
	<body>
	<div class="content content1">
		 <input type="hidden" id="basePath" value="${request.contextPath}">
		 <input type="hidden" id="productId" value="${productId}">
	     <input type="hidden" name="search" value="false">
		 <div class="breadnav">首页->交通+X->产品同步管理->产品同步信息列表</div>
		 <div class="infor1" id="conditionDiv">
				<!-- 产品信息 start  -->
				<div class="visitor message">
					<div class="main">
						<div class="part">
							<span>产品ID：</span><input type="text" id="productIdInput" name="productIdInput"/>
							 同步产品索引状态：<select type="text" id="productIndexInput" name="productIndexInput"/>
												<option value="">全部</option>
												<option value="SUCCESS">成功</option>
												<option value="APPLY">发起</option>
												<option value="INVALID">无效</option>
												<option value="FAIL">失败</option>
												<option value="TIMEOUT">超时</option>
							 			</select>
							 同步产品基本信息状态：<select type="text" id="productBasicInfoInput" name="productBasicInfoInput"/>
							 					<option value="">全部</option>
							 					<option value="SUCCESS">成功</option>
												<option value="APPLY">发起</option>
												<option value="INVALID">无效</option>
												<option value="FAIL">失败</option>
												<option value="TIMEOUT">超时</option>
							 			   </select>
						</div>
					</div>
				</div>
				<!-- 产品信息 end  -->
			</div>
			<div class="click">
				<a href="javascript:void(0);" onclick="query();"><div class="button">查询</div></a>
				<!--<a href="javascript:void(0);" onclick="clearForm();"><div class="button">清空</div></a>-->
			</div>
		</div>
		<div class="content content1" style="margin-top:50px;">
	      <table id="sdpProductList"></table>
	      <div id="pager"></div>
	    </div>
    </div>
</body>
</html>