
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet"
	href="${request.contextPath}/css/order-details.css" type="text/css" />
<link type="text/css" rel="stylesheet"
	href="${request.contextPath}/js/resources/jquery-ui-1.8.11/css/redmond/jquery-ui-1.8.11.css" />
<link type="text/css" rel="stylesheet"
	href="${request.contextPath}/js/resources/jqGrid/css/ui.jqgrid.css" />
<script
	src="${request.contextPath}/js/resources/jqGrid/js/jquery-1.7.2.min.js">
	
</script>
<script
	src="${request.contextPath}/js/resources/jquery-ui-1.8.10.custom.min.js"></script>
<script
	src="${request.contextPath}/js/resources/jqGrid/src/i18n/grid.locale-cn.js"></script>
<script
	src="${request.contextPath}/js/resources/jqGrid/js/jquery.jqGrid.src.js"></script>
<script src="${request.contextPath}/js/Calendar.js"></script>



<script type="text/javascript">
	$(function() {
		var importFlag = '${importFlag}';
		if(importFlag=='true'){
			alert("导入成功！");
		}
		initGrid();
	});
	
	
	
	
	//查询列表信息   
	function query() {
		var productId = $("#productId").val();
		var districtCityId = $("#districtCityId").val();

		if (productId == '' || districtCityId == '') {
			//alert("城市不能为空!");
			//return;
		}

		$("#list").jqGrid('setGridParam', {
			url : "${request.contextPath}/taskConfig/queryTaskConfigList",
			datatype : "json",
			mtype : "POST",
			postData : getParams()
		}).trigger("reloadGrid");
	}

	
	function importFile() {
		var path = $("#selectFileBtn").val();
		if(path!=""){
			if(confirm("请在导入文件前确定格式完全正确且数据是完整的，否则将不能导入成功！")){
				$("#file").submit();
			}
		}else{
			alert("请选择文件！");
			return;
		}
	}
	
	//清空查询信息   
	function reset() {
		document.getElementById("myForm").reset()
	}

	function getParams() {
		return {
			'productId' : $("#productId").val(),
			'districtCityId' : $("#districtCityId").val(),
			'search' : false
		}
	}

	function initGrid() {
		$("#list")
				.jqGrid(
						{
							url : "${request.contextPath}/taskConfig/queryTaskConfigList",
							datatype : "json",
							mtype : "POST",
							colNames : [ '产品ID', '城市行政ID', '城市名称',
									'酒店名称', '创建日期', '更改日期',
									 '操作' ],
							colModel : [ {
								name : 'productId',
								index : 'productId',
								align : 'center',
								sortable : false
							}, {
								name : 'districtCityId',
								index : 'districtCityId',
								align : 'center',
								sortable : false
							}, {
								name : 'cityName',
								index : 'cityName',
								align : 'center',
								sortable : false
							}, {
								name : 'hotelName',
								index : 'hotelName',
								align : 'center',
								sortable : false
							}, {
								name : 'createTime',
								index : 'createTime',
								align : 'center',
								sortable : false
							}, {
								name : 'updateTime',
								index : 'updateTime',
								align : 'center',
								sortable : false
							},
								{
								name : 'operate',
								index : 'operate',
								align : 'center',
								sortable : false
							} ],
							rowNum : 10, //每页显示记录数
							autowidth : true, //自动匹配宽度
							pager : '#pager', //表格数据关联的分页条，html元素
							rowList : [ 10, 20, 50, 500 ], //分页选项，可以下拉选择每页显示记录数
							viewrecords : true, //显示总记录数
							height : 'auto',//高度，表格高度。可为数值、百分比或'auto'
							//autoheight: true,     //设置高度
							gridview : true, //加速显示
							viewrecords : true, //显示总记录数
							multiselect : false,
							sortable : true, //可以排序
							sortname : 'searchTime', //排序字段名
							sortorder : "desc", //排序方式：倒序
							caption : "酒店列表",
							jsonReader : {
								root : "results", // json中代表实际模型数据的入口  
								page : "pagination.page", // json中代表当前页码的数据   
								records : "pagination.records", // json中代表数据行总数的数据   
								total : 'pagination.total', // json中代表页码总数的数据 
								repeatitems : false
							// 如果设为false，则jqGrid在解析json时，会根据name来搜索对应的数据元素（即可以json中元素可以不按顺序）；而所使用的name是来自于colModel中的name设定。   
							},
							onPaging : function(pgButton) {
								$("#list").jqGrid('setGridParam', {
									postData : getParams()
								});
							},
							gridComplete : function() { //在此事件中循环为每一行添加日志、废保和查看链接
								var ids = jQuery("#list").jqGrid('getDataIDs');
								for ( var i = 0; i < ids.length; i++) {
									var id = ids[i];

									var rowData = $('#list').jqGrid('getRowData', id);
									//alert(rowData.districtCityId);

									operateClick = '<a href="#" style="color:blue" onclick="openEditDialog('+ id + ')" >编辑</a> <a href="#" style="color:blue" onclick="deleteConfig('+ id + ')" >删除</a>';
									jQuery("#list").jqGrid('setRowData', id, {
										operate : operateClick
									});
								}
							}
						});
	}

	//添加
	function add() {
		var productId = $("#productId").val();
		var districtCityId = $("#districtCityId").val();
		var cityName = $("#cityName").val();
		var hotelName = $("#hotelName").val();
		
		if(productId==''||districtCityId==''||cityName==''||hotelName==''){
			alert("数据不能为空!");
			return;
		}
		
	
		$.ajax({
			url : "save",
			dataType : "json",
			contentType : "application/json;",
			type : "POST",
			data : JSON.stringify({
				request : setRequest()
			}),
			success : function(data) {
				// alert(data.flag);
				if (data.flag == 'true') {
					alert("成功！");
					initGrid();
				} else {
					alert("失败！");

				}
			}
		}); // ajax-end
	}
	
	function setRequest(){
		var productId = $("#productId").val();
		var districtCityId = $("#districtCityId").val();
		var cityName = $("#cityName").val();
		var hotelName = $("#hotelName").val();
		
		if(productId==''){
			alert("产品ID不能为空!");
			return;
		}
		
		var request = new Object;
		request.productId = productId;
		request.districtCityId = districtCityId;
		request.cityName = cityName;
		request.hotelName = hotelName;
		return request;
	}
	
	
	function deleteConfig(id){
		
		  var r=confirm("确定要删除吗？")
		  if (r==false){
		  	return;
		  }
		
		
		$.ajax({
			url : "delete",
			dataType : "json",
			contentType : "application/json;",
			type : "POST",
			data : JSON.stringify({
				request : setDeleteRequest(id)
			}),
			success : function(data) {
				// alert(data.flag);
				if (data.flag == 'true') {
					alert("成功！");
					window.location.reload();
				} else {
					alert("失败！");

				}
			}
		}); // ajax-end
	}
	function setDeleteRequest(id){
		var request = new Object;
		request.id = id;
		return request;
	}
	
	//编辑
	function openEditDialog(id){
		$('#EditDialog').dialog({
		    title:'任务配置编辑',
		    width:350,
			height:320,
			modal:'true'
		});
		
		 $("#hotelDataId").val(id);
	
		$.ajax({
			url : "get",
			dataType : "json",
			contentType : "application/json;",
			type : "POST",
			data : JSON.stringify({
				request : setDeleteRequest(id)
			}),
			success : function(data) {
				
				 $("#productIdSpan").html(data.productId);
				 $("#districtCityIdSpan").html(data.districtCityId);
				 
				 mytest(data.productId,data.districtCityId);
				 $("#cityNameInput").val(data.cityName);
				 $("#hotelNameInput").val(data.hotelName);
				 $("#createTimeInput").val(data.createTime);
				 $("#updateTimeInput").val(data.updateTime);
			
			}
		}); // ajax-end
	}
	
	request.productId = productId;
		request.districtCityId = districtCityId;
		request.cityName = cityName;
		request.hotelName = hotelName;
	
	//编辑
	function edit() {
				var productId = $("#productIdInput").val();
		var districtCityId = $("#districtCityIdInput").val();
		var cityName = $("#cityNameInput").val();
		var hotelName = $("#hotelNameInput").val();
		var createTime = $("#createTimeInput").val();
		var updateTime = $("#updateTimeInput").val();
		if(productId==''||districtCityId==''||cityName==''||hotelName==''||createTime==''||updateTime==''){
			alert("数据不能为空!");
			return;
		}
	
		$.ajax({
			url : "save",
			dataType : "json",
			contentType : "application/json;",
			type : "POST",
			data : JSON.stringify({
				request : setEditRequest()
			}),
			success : function(data) {
				// alert(data.flag);
				if (data.flag == 'true') {
					alert("成功！");
					window.location.reload();
				} else {
					alert("失败！");

				}
			}
		}); // ajax-end
	}
	
	function setEditRequest(){
		var hotelDataId = $("#hotelDataId").val();
		var productId = $("#productIdInput").val();
		var districtCityId = $("#districtCityIdInput").val();
		var cityName = $("#cityNameInput").val();
		var hotelName = $("#hotelNameInput").val();
		var createTime = $("#createTimeInput").val();
		var updateTime = $("#updateTimeInput").val();
		var request = new Object;
		request.id = hotelDataId;
		request.productId = productId;
		request.districtCityId = districtCityId;
		request.cityName = cityName;
		request.hotelName = hotelName;
		request.createTime = createTime;
		request.updateTime = updateTime;
		return request;
	}
	
	
	function mytest(productId,districtCityId){
			$.ajax({
			url : "getCityList",
			dataType : "json",
			contentType : "application/json;",
			type : "POST",
			data :"",
			success : function(data) {
			
			var jsontext = JSON.stringify(data);
			var citys=JSON.parse(jsontext);
				   for(var o in citys){  
			        //alert("text:"+data[o].name);  
			      } 
				  
				  	  
				   var htmldep="";
				   var htmlarr="";
				   var selectdep="";
				   var selectarr="";
					$.each(citys,function(i,n){
						if(data[i]['code']==depCityCode){
							selectdep='selected="selected"';
							htmldep+="<option  "+selectdep+" value="+data[i]['code']+">"+data[i]['name']+"("+data[i]['code']+")</option>";
						}else{
							htmldep+="<option   value="+data[i]['code']+">"+data[i]['name']+"("+data[i]['code']+")</option>";
						}
						})
						//arr
					$.each(citys,function(i,n){
						if(data[i]['code']==districtCityId){
							selectarr='selected="selected"';
							htmlarr+="<option  "+selectarr+" value="+data[i]['code']+">"+data[i]['name']+"("+data[i]['code']+")</option>";
						}else{
							htmlarr+="<option   value="+data[i]['code']+">"+data[i]['name']+"("+data[i]['code']+")</option>";
						}
						})
		             $("#productIdInput").empty().append(htmldep);
					 $("#districtCityIdInput").empty().append(htmlarr);
		             
			}
		}); // ajax-end
	
	}
	
	
	
</script>
</head>
<body>
	<div class="content content1">
		<div class="breadnav">
			<span>首页</span> >默认酒店数据
		</div>
		<form id="myForm">
			<div class="infor1">

				<div class="visitor message">

					<div class="main">
						<div class="part">


							产品ID： <input type="text" value="" id="productId" length="10px">
							城市行政ID：<input type="text" value="" id="districtCityId" length="200px"></br>
								城市名称：	<select  id="cityName" length="300px" >
							<option value=""></option>
							<#list citys as city> 
							<option value="${city.code}">${city.name}(${city.code})</option>
								</#list>
							</select>
							
							酒店名称：
									<select id="hotelName" length="300px" >
							<option value=""></option>
							<#list citys as city> 
							<option value="${city.code}">${city.name}(${city.code})</option>
								</#list>
							</select>
							
						</div>
					</div>
				</div>

			</div>
			
			<div class="click">
				
				<a href="javascript:;"><div class="button"
						onclick="add()">添加</div></a> 
						<a href="javascript:;"><div class="button" onclick="query()">查询</div></a>
				<!-- <a href="javascript:;"><div class="button" onclick="reset()">清空</div></a>-->
			</div>
		</form>
		
		<form id="file" action="${request.contextPath}/hotel/batch" method="POST" enctype="multipart/form-data">
	     <input type="file" name="uploadFile" id="selectFileBtn"/>
		<input type="button" value="批量导入" onclick="importFile();"/>
   </form>
		
		<div class="content1" style="margin-top: 50px;">
			<table id="list"></table>
			<div id="pager"></div>
		</div>
		<br> <br>
	</div>
	
	
	
	<div id="EditDialog" style="display:none;">
	
			<input type="hidden" id="hotelDataId" />
			<table>
				<tr height="35">	
					<td align="right">产品ID<span  style="color: red;" id="productIdSpan"></span>：</td>
					
					<td>
						<select id="productIdInput" length="300px" >
							<option value=""></option>
							<#list citys as city> 
							<option value="${city.code}">${city.name}(${city.code})</option>
								</#list>
							</select>
					</td>
				</tr>
				<tr height="35">	
					<td align="right">城市行政id<span style="color: red;"  id="districtCityIdSpan"></span>：</td>
					<td>
						<select id="districtCityIdInput" length="300px" >
							<option value=""></option>
							<#list citys as city> 
							<option value="${city.code}">${city.name}(${city.code})</option>
								</#list>
							</select>
					</td>
				</tr>
				<tr height="35">	
					<td align="right">城市名称：</td>
					<td>
						<input type="text" id="cityNameInput" />
					</td>
				</tr>
				<tr height="35">	
					<td align="right">酒店名称：</td>
					<td>
						<input type="text" id="hotelNameInput" />
					</td>
				</tr>
				<tr height="35">	
					<td align="right">创建日期：</td>
					<td>
						<input type="text" id="createTimeInput" />
					</td>
				</tr>
				<tr height="35">	
					<td align="right">更改日期：</td>
					<td>
						<input type="text" id="updateTimeInput" />
					</td>
				</tr>
				
				<tr height="35">
					<td colspan="2" align="center">
						<button class="button" onclick="edit()">保存</button>
					</td>
				</tr>
			</table>
		</div>
	
	
	
	
	

</body>
</html>