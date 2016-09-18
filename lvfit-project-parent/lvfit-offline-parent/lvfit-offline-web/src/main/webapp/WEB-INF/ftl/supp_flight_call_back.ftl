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
				var colNames = ['ID','UUID', '回调订单ID','VST订单主编号','VST订单编号','CALL请求STR','往返类型','回调结果','回调时间','创建时间','更新时间','CALL请求STR2','操作'];

				var cols = [
					{
						name : 'id',
						index : 'id',
						align : 'center',
						sortable:false
					},
					{
						name : 'uuid',
						index : 'uuid',
						align : 'center',
						sortable:false
					},
					{
						name : 'suppOrderId',
						index : 'suppOrderId',
						align : 'center',
						sortable:false
					},
					{
						name : 'vstOrderMainNo', 
						index : 'vstOrderMainNo',
						align : 'center',
						sortable:false
					},//--------------
					{
						name : 'vstOrderNo', 
						index : 'vstOrderNo',
						align : 'center',
						sortable:false
					},
					{
						name : 'callRequestStr',  
						index : 'callRequestStr',
						align : 'center',
						sortable:false
					},
					{
						name : 'tripType',   
						index : 'tripType',
						align : 'center',
						sortable:false
					},
					//----------------
					{
						name : 'callbackType',  
						index : 'callbackType',
						align : 'center',
						sortable:false
					},
					{
						name : 'callbackTime',  
						index : 'callbackTime',
						align : 'center',
						formatter : dateFormatter,
						sortable:false
					},
					{
						name : 'createTime',  
						index : 'createTime',
						align : 'center',
						formatter : dateFormatter,
						sortable:false
					},
					{
						name : 'updateTime',  
						index : 'updateTime',
						align : 'center',
						formatter : dateFormatter,
						sortable:false
					},
					{
						name : 'callRequestStr2', 
						index : 'callRequestStr2',
						align : 'center',
						sortable:false
					},
					{
						name : 'allOperation', //操作
						index : 'allOperation',
						formatter:operationsLink,
						align : 'center',
						sortable:false
					}];
					
				$("#sdpDataList").jqGrid({
					url : '${request.contextPath}/sdpProduct/suppCallBackQuery',
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
						$("#sdpDataList").jqGrid('setGridParam', {
							postData : getQueryParams()
						});
					}
				});
			}
			
			function getQueryParams(){
				var queryData = {
					'suppOrderId':$("#suppOrderId").val(),
					'vstOrderMainNo':$("#vstOrderMainNo").val(),
					'vstOrderNo':$("#vstOrderNo").val()
				};
				return queryData;
			}
			
			function dateFormatter (cellvalue, options, rowObject)  
			{  
				   return new Date(cellvalue).format("yyyy-MM-dd hh:mm:ss");
			}
			
			function operationsLink(cellvalue, options, rowObject) 
			{
				if(rowObject.callbackType=='SUCCESS'){
					return '';
				}else{
	    			return  "<a href='javascript:void(0);' onclick='handleFlightBack("+rowObject.vstOrderMainNo+")' style='color:blue;'>手动回调(按主订单)"+ "</a>"+
	    			" <br><a href='javascript:void(0);' onclick='handleFlightBackDetail("+rowObject.vstOrderMainNo+","+rowObject.vstOrderNo+")' style='color:blue;'>手动回调(按订单)"+ "</a>";
    			}
    		}
    		
    		function handleFlightBack(vstOrderMainNo){
    			$.ajax({	
					url: "${request.contextPath}/sdpProduct/handleSuppFlightCallBack",
					type: "post",
					data: {
						'vstOrderMainNo':vstOrderMainNo
					},
					dataType: 'json',
					success: function (data) {
						if(data.status=='SUCCESS'){
							alert("回调成功,由于异步回调，稍等片刻后刷新可见回调结果!");
						}else{
							alert("回调失败!");
						}
					}
				});
    		}
    		
    		function handleFlightBackDetail(vstOrderMainNo,vstOrderNo){
    			$.ajax({	
					url: "${request.contextPath}/sdpProduct/handleSuppFlightCallBack",
					type: "post",
					data: {
						'vstOrderMainNo':vstOrderMainNo,
						'vstOrderNo':vstOrderNo
					},
					dataType: 'json',
					success: function (data) {
						if(data.status=='SUCCESS'){
							alert("回调成功,由于异步回调，稍等片刻后刷新可见回调结果!");
						}else{
							alert("回调失败!");
						}
					}
				});
    		}
    		
			//查询 
			function query() {
				$("#sdpDataList").jqGrid('setGridParam', 
				{
		 			url:"${request.contextPath}/sdpProduct/suppCallBackQuery",
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
		 <div class="breadnav">首页->交通+X->订单管理->机票回调管理</div>
		 <div class="infor1" id="conditionDiv">
				<!-- 产品信息 start  -->
				<div class="visitor message">
					<div class="main">
						<div class="part">
							<span>回调订单ID：</span><input type="text" id="suppOrderId" name="fitSuppOrderForFlightCallBackDto.suppOrderId"/>
							<span>VST订单主编号：</span><input type="text" id="vstOrderMainNo" name="fitSuppOrderForFlightCallBackDto.vstOrderMainNo"/>
							<span>VST订单编号：</span><input type="text" id="vstOrderNo" name="fitSuppOrderForFlightCallBackDto.vstOrderNo"/>							
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
	      <table id="sdpDataList"></table>
	      <div id="pager"></div>
	     </div>
    </div>
    	
</body>
</html>