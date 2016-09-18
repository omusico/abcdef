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
				var colNames = ['ID','产品ID', '去程','返程','游玩时间','销量','是否多出发地','更新时间','操作'];

				var cols = [
					{
						name : 'id',  //产品ID
						index : 'id',
						align : 'center',
						sortable:false
					},
					{
						name : 'productId',  //产品ID
						index : 'productId',
						align : 'center',
						sortable:false
					},
					{
						name : 'toTraffic',
						index : 'toTraffic',
						align : 'center',
						sortable:false
					},
					{
						name : 'backTraffic',
						index : 'backTraffic',
						align : 'center',
						sortable:false
					},
					{
						name : 'depatureTime',
						index : 'depatureTime',
						align : 'center',
						sortable:false
					},//--------------
					{
						name : 'salesVolume',
						index : 'salesVolume',
						align : 'center',
						sortable:false
					},
					{
						name : 'isMultiDepature',   
						index : 'isMultiDepature',
						align : 'center',
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
						name : 'allOperation', //操作
						index : 'allOperation',
						formatter:operationsLink,
						align : 'center',
						sortable:false
					}];
					
				$("#sdpProductList").jqGrid({
					url : '${request.contextPath}/sdpProduct/queryTrafficIndexList',
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
				return queryData;
			}
			
			function operationsLink(cellvalue, options, rowObject) 
			{
	    		return  "<a href='javascript:void(0);' onclick='toEdit("+rowObject.id+");' style='color:blue;'>编辑"+ "</a>";
	    		
    		}
			
			function dateFormatter (cellvalue, options, rowObject)  
			{  
				   return new Date(cellvalue).format("yyyy-MM-dd hh:mm:ss");
			}
			
			function toEdit(obj){
				$('#EditDialog').dialog({
				    title:'打包产品城市组编辑',
				    width:350,
					height:400,
					modal:'true'
				});
				$.ajax({	
					url: "${request.contextPath}/sdpProduct/queryOneTrafficIndex",
					type: "post",
					data: {
						'id':obj
					},
					dataType: 'json',
					success: function (data) {
						if(data!=null){
						console.info(data);
							$("#idInput").val(data.id);
							$("#productIdInput").val(data.productId);
							$("#toTraffic").val(data.toTraffic);
							$("#backTraffic").val(data.backTraffic);
							$("#playTime").val(data.depatureTime);
							$("#volume").val(data.salesVolume);
							$("#isMulti").val(data.isMultiDepature);
						}
					}
				});
			}
			
			function saveEdit(){
				var id = $("#idInput").val();
				var toTraffic = $("#toTraffic").val();
				var backTraffic = $("#backTraffic").val();
				if(id==''||toTraffic==''||backTraffic==''){
					alert("数据不能为空!");
					return;
				}
				var params = {
					    id:id,
						toTraffic:toTraffic,
						backTraffic:backTraffic,
						depatureTime:$("#playTime").val(),
						salesVolume:$("#volume").val(),
						isMultiDepature:$("#isMulti").val()
				};
				$.ajax({
					url : "${request.contextPath}/sdpProduct/updateTrafficIndex",
					type : "post",
					data: params,
					dataType: 'json',
					success : function(data) {
						if (data.returnStr == 'SUCCESS') {
							alert("成功！");
							$('#EditDialog').dialog('close');
							window.location.reload();
						} else {
							alert("修改失败！");
						}
					}
				}); // ajax-end
			}
		</script>
	</head>
	<body>
	<div class="content content1">
		 <input type="hidden" id="basePath" value="${request.contextPath}">
		 <input type="hidden" id="productId" value="${productId}">
	     <input type="hidden" name="search" value="false">
		 <div class="breadnav">首页->交通+X->产品管理->产品索引交通列表</div>
		 <div class="content content1" style="margin-top:50px;">
	      <table id="sdpProductList"></table>
	      <div id="pager"></div>
	     </div>
    </div>
    
    <div id="EditDialog" style="display:none;">
			<table>
				<tr height="25">	
					<td align="right">ID：</td>
					<td>
						<input type="text" id="idInput" readonly="readonly" />
					</td>
				</tr>
				<tr height="25">	
					<td align="right">产品ID：</td>
					<td>
						<input type="text" id="productIdInput" readonly="readonly" />
					</td>
				</tr>
				<tr height="25">	
						<td align="right">去程：</td>
						<td>
							<textarea type="text" id="toTraffic" style="height:50px" name="toTraffic"></textarea>
						</td>
				</tr>
				<tr height="25">	
						<td align="right">返程：</td>
						<td>
							<textarea type="text" id="backTraffic" style="height:50px" name="backTraffic"></textarea>
						</td>
				</tr>
				<tr height="25">	
						<td align="right">游玩时间：</td>
						<td>
							<textarea style="height:50px" id="playTime" name="playTime"></textarea>
						</td>
				</tr>
				<tr height="25">	
						<td align="right">销量：</td>
						<td>
							<input id="volume" name="volume">
						</td>
				</tr>
				<tr height="25">	
						<td align="right">是否多出发地：</td>
						<td>
							<select id="isMulti" name="isMulti">
								<option value="Y">是</option>
								<option value="N">否</option>
							</select>
						</td>
				</tr>
				<tr height="45">
					<td align="right">
						<button class="button" onclick="saveEdit()">保存</button>
					</td>
					<td align="center">
						<button class="button" onclick="javaScript:$('#EditDialog').dialog('close')">取消</button>
					</td>
				</tr>
			</table>
		</div>
</body>
</html>