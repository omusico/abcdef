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
				var colNames = ['ID','产品ID', '出发城市区域Id','出发城市区短拼音','出发城市code','出发城市名称','到达城市区域Id','到达城市区短拼音','到达城市code','到达城市名称','是否为选中出发地','操作'];

				var cols = [
					{
						name : 'id',
						index : 'id',
						align : 'center',
						sortable:false
					},
					{
						name : 'productId',
						index : 'productId',
						align : 'center',
						sortable:false
					},
					{
						name : 'departureCityDistrictId',
						index : 'departureCityDistrictId',
						align : 'center',
						sortable:false
					},
					{
						name : 'departureCityShortPinYin', 
						index : 'departureCityShortPinYin',
						align : 'center',
						sortable:false
					},//--------------
					{
						name : 'departureCityCode', 
						index : 'departureCityCode',
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
						name : 'arrivalCityDistrictId',   
						index : 'arrivalCityDistrictId',
						align : 'center',
						sortable:false
					},
					//----------------
					{
						name : 'arrivalCityShortPinYin',  
						index : 'arrivalCityShortPinYin',
						align : 'center',
						sortable:false
					},
					{
						name : 'arrivalCityCode',  
						index : 'arrivalCityCode',
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
						name : 'isSelectedDeparture',  
						index : 'isSelectedDeparture',
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
					url : '${request.contextPath}/sdpProduct/queryDepartureCityList',
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
					'productId':$("#productId").val(),
					'departureCityDistrictId':$("#departureCityDistrictId").val(),
					'departureCityName':$("#departureCityName").val()
				};
				return queryData;
			}
			
			//编辑
			function openEditDialog(obj){
				$('#EditDialog').dialog({
				    title:'打包产品城市组编辑',
				    width:350,
					height:350,
					modal:'true'
				});
				$.ajax({	
					url: "${request.contextPath}/sdpProduct/queryOneCity",
					type: "post",
					data: {
						'id':obj
					},
					dataType: 'json',
					success: function (data) {
						if(data!=null){
							$("#idInput").val(data.id);
							$("#productIdInput").val(data.productId);
							$("#depId").val(data.departureCityDistrictId);
							$("#depPingYin").val(data.departureCityShortPinYin);
							$("#depCode").val(data.departureCityCode);
							<#--
								$("#depCity").val(data.departureCityDistrictId);
								-->
							$("#arrId").val(data.arrivalCityDistrictId);
							$("#arrPingYin").val(data.arrivalCityShortPinYin);
							$("#arrCode").val(data.arrivalCityCode);
							<#--
								$("#arrCity").val(data.arrivalCityDistrictId);
								-->
							$("#isSelected").val(data.isSelectedDeparture);
						}
					}
				});
				
			}
			
			function dateFormatter (cellvalue, options, rowObject)  
			{  
				   return new Date(cellvalue).format("yyyy-MM-dd hh:mm:ss");
			}
			function operationsLink(cellvalue, options, rowObject) 
			{
	    		return  "<a href='javascript:void(0);' onclick='openEditDialog("+rowObject.id+");' style='color:blue;'>编辑"+ "</a>";
	    		<#-- "<a href='javascript:void(0);' onclick='deleteProduct("+rowObject.id+");' style='color:blue;'>删除"+ "</a>"-->
	    		
    		}
    		
    		//编辑
			function saveEdit() {
				var id = $("#idInput").val();
				var isSelected = $("#isSelected").val();
				if(id==''||isSelected==''){
					alert("数据不能为空!");
					return;
				}
				var params = {
					    id:id,
						departureCityDistrictId:$("#depId").val(),
						departureCityCode:$("#depCode").val(),
						departureCityShortPinYin:$("#depPingYin").val(),
						arrivalCityDistrictId:$("#arrId").val(),
						arrivalCityCode:$("#arrCode").val(),
						arrivalCityShortPinYin:$("#arrPingYin").val(),
						isSelectedDeparture:$("#isSelected").val()
				};
				console.info(params);
				$.ajax({
					url : "${request.contextPath}/sdpProduct/updateCityGroup",
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
			  
			//查询 
			function query() {
				$("#sdpDataList").jqGrid('setGridParam', 
				{
		 			url:"${request.contextPath}/sdpProduct/queryDepartureCityList",
		 			datatype : "json",
		 			mtype : "POST",
			 		postData : getQueryParams()
				}).trigger("reloadGrid");
			}
			
			function deleteProduct(obj){
			 var r=confirm("确定要删除吗？")
			  if (r==false){
			  	return;
			  }
				
			  
			}
		</script>
	</head>
	<body>
	<div class="content content1">
		 <input type="hidden" id="basePath" value="${request.contextPath}">
		 <input type="hidden" id="productId" value="${productId}">
	     <input type="hidden" name="search" value="false">
		 <div class="breadnav">首页->交通+X->产品同步管理->产品城市组管理</div>
		 <div class="infor1" id="conditionDiv">
				<!-- 产品信息 start  -->
				<div class="visitor message">
					<div class="main">
						<div class="part">
							<span>出发城市ID：</span><input type="text" id="departureCityDistrictId" name="fitSdpCityGroupDto.departureCityDistrictId"/>
							<span>出发城市名称：</span><input type="text" id="departureCityName" name="fitSdpCityGroupDto.departureCityName"/>							
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
						<td align="right">出发城市区域ID：</td>
						<td>
							<input id="depId" name="depId">
									
						</td>
				</tr>
				
				<tr height="25">	
						<td align="right">出发城市短拼音：</td>
						<td>
							<input id="depPingYin" name="depPingYin">
						</td>
				</tr>
				<tr height="25">	
						<td align="right">出发城市CODE：</td>
						<td>
							<input id="depCode" name="depCode">
						</td>
				</tr>
				<#--
				<tr height="25">	
						<td align="right">出发城市：</td>
						<td>
							<select id="depCity" name="depCity" onchange="">
									<option value="">-请选择城市-</option>
									<#list cityGroup as city>  
									  <#if val !="NULL">
									   <option value="${city.districtId}">${city.cnName}</option>
									  </#if> 
									</#list>
							</select>
						</td>
				</tr>
				-->
				<tr height="25">	
						<td align="right">到达城市Id：</td>
						<td>
							<input id="arrId" name="arrId">
						</td>
				</tr>
				<tr height="25">	
						<td align="right">到达城市拼音：</td>
						<td>
							<input id="arrPingYin" name="arrPingYin">
						</td>
				</tr>
				<tr height="25">	
						<td align="right">到达城市Code：</td>
						<td>
							<input id="arrCode" name="arrCode">
						</td>
				</tr>
				<#--
				<tr height="25">
					<td align="right">目的城市：</td>
					<td>
							<select id="arrCity" name="arrCity">
									<option value="">-请选择城市-</option>
									<#list cityGroup as city>  
									  <#if val !="NULL">
									   <option value="${city.districtId}">${city.cnName}</option>
									  </#if> 
									</#list>
							</select>
					</td>
				</tr>
				-->
				<tr height="25">
					<td align="right">是选中出发地：</td>
					<td>
						<select type="text" id="isSelected">
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