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
		
		<script type="text/javascript">
			$(function (){
				initGrid();
				//初始化交通模态框
				inItConsoleDlg();
				/*初始化加价模态框*/
				inItFeeConsoleDlg();
				$("#assistDom").html($("#consoleDlg").html());
				$("#feeAssistDom").html($("#feeRuleDlg").html());
				

			});

			function initGrid() 
			{
			
				var colNames = ['品类','产品ID', '产品名称','产品经理','产品是否有效','是否可售','审核状态',/*'当前同步状态',*/'是否为多出发地','被打包产品Id', '行程天数','操作1','操作2'];

				var cols = [ 
					{
						name : 'bizCategoryId',  //品类
						index : 'bizCategoryId',
						align : 'center',
						width:70,
						sortable:false
					},
					{
						name : 'productId',  //产品ID
						index : 'productId',
						//formatter:formatLinkVst,
						align : 'center',
						width:70,
						sortable:false
					},
					{
						name : 'productName',   //名称
						index : 'productName',
						align : 'center',
						sortable:false
					},
					{
						name : 'managerName',   //产品经理
						index : 'managerName',
						align : 'center',
						sortable:false
					},//--------------
					{
						name : 'cancelFlag',   //产品状态（是否有效）
						index : 'cancelFlag',
						align : 'center',
						width:70,
						sortable:false
					},
					{
						name : 'saleFlag',   //是否可售
						index : 'saleFlag',
						align : 'center',
						width:70,
						sortable:false
					},
					{
						name : 'auditType',   //审核状态
						index : 'auditType',
						align : 'center',
						width:70,
						sortable:false
					},
					/*{
						name : 'curSyncFlag',   //当前同步状态
						index : 'curSyncFlag',
						align : 'center',
						width:70,
						sortable:false
					},*/
					//----------------
					{
						name : 'muiltDpartureFlag',  //是否为多出发地
						index : 'muiltDpartureFlag',
						align : 'center',
						width:70,
						sortable:false
					},
					{
						name : 'packagedProductId',//被打包产品Id
						index : 'packagedProductId',
						align : 'center',
						sortable:false
					},
					{
						name : 'routeStayNum', //行程天数
						index : 'routeStayNum',
						align : 'center',
						sortable:false
					},
					{
						name : 'allOperation', //操作
						index : 'allOperation',
						formatter:operationsLink,
						width:150,
						align : 'center',
						sortable:false
					},
					{
						name : 'ballOperation', //操作
						index : 'ballOperation',
						formatter:oppLink,
						width:150,
						align : 'center',
						sortable:false
					}
					];
					
				$("#sdpProductList").jqGrid({
					url : '${request.contextPath}/sdpProduct/productQuery',
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
					//multiselect : true,   //是否设置全选按钮
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
			//查询 
			function query() {
				if($('#productId').val() != '' && isNaN($('#productId').val())){
					alert("产品ID格式错误。");
					$("#productId").val("").focus();return;
				}
				if($('#packagedProductId').val() != '' && isNaN($('#packagedProductId').val())){
					alert("打包产品ID格式错误。");
					$("#packagedProductId").val("").focus();return;
				}
				$("#sdpProductList").jqGrid('setGridParam', 
				{
		 			url:"${request.contextPath}/sdpProduct/productQuery",
		 			datatype : "json",
		 			mtype : "POST",
			 		postData : getQueryParams()
				}).trigger("reloadGrid");
			}

			function getQueryParams() {
				var queryData = {
					'productId':$("#productId").val(),
					'productName':$("#productName").val(),
					'bizCategoryId':$("#bizCategoryId").val(),
					'packagedProductId':$("#packagedProductId").val(),
					'managerName':$("#managerName").val(),
					'muiltDpartureFlag':$("#muiltDpartureFlag").val()	
				};
				return queryData;
			}
			function operationsLink(cellvalue, options, rowObject) 
			{
	    		return  "<a href='javascript:void(0);' onclick='syncSearchIndex("+rowObject.productId+");' style='color:blue;'>同步索引标签"+ "</a>"+
	    		" | <a href='javascript:void(0);' onclick='deleteProduct("+rowObject.productId+");' style='color:blue;'>删除产品"+ "</a>"+
				" <br/><a href='${request.contextPath}/sdpProduct/searchTrafficIndex?productId="+rowObject.productId+"' target='_blank'' style='color:blue;'>查询索引交通表"+ "</a>"+
	    		" | <a href='${request.contextPath}/sdpProduct/departureCity?productId="+rowObject.productId+"' target='_blank'' style='color:blue;'>出发城市管理"+ "</a>";
	    		
    		}
    		function oppLink(cellvalue, options, rowObject) 
			{
	    		return "<a href='${request.contextPath}/sdpProduct/searchIndex?productId="+rowObject.productId+"' target='_blank'' style='color:blue;'>查询索引"+ "</a>"+
	    		" <br/><a href='${request.contextPath}/sdpProduct/searchPushInfo?productId="+rowObject.productId+"' target='_blank'' style='color:blue;'>查询推送信息列表"+ "</a>";
    		}
			/*设置交通规则*/
			function setTrafficRules(productId,routeNum){
				var consoleDlg = $("#consoleDlg");
				consoleDlg.html($("#assistDom").html());
				$("#productId_1").val(productId);
				$.ajax({	
					url: "${request.contextPath}/sdpProduct/trafficRulesQuery",
					type: "post",
					data: {
						'productId':productId
					},
					dataType: 'json',
					success: function (data) {
						//渲染行程天数下拉框
						var $formTableGoway = $("table.formTableGoway");
						var options = "";
						for(var j=1;j<=routeNum;j++){
							if(j===1){options += "<option value='"+j+"' selected=''>"+j+"</option>";
							}else{options += "<option value='"+j+"'>"+j+"</option>";}
						}
						$formTableGoway.find(".routeDayNum").html(options);
						var $formTableBackWay = $("table.formTableBackWay");
						options = "";
						for(var j=1;j<=routeNum;j++){
							if(j===routeNum){options += "<option value='"+j+"'  selected=''>"+j+"</option>";
							}else{options += "<option value='"+j+"'>"+j+"</option>";}
						}
						$formTableBackWay.find(".routeDayNum").html(options);
						
						if(data!=null){
							for(var i in data){
								if(data[i].trafficTripeType !==undefined){
									if(data[i].trafficTripeType==="GO_WAY"){//去程规则获取值
										
										$formTableGoway.find(".routeDayNum").val(data[i].routeDayNum);
										$formTableGoway.find(".sortRuleType").val(data[i].sortRuleType);
										if(data[i].depBegTime!==null && data[i].depBegTime!=="" && data[i].depEndTime!==null && data[i].depEndTime!==""){
											$formTableGoway.find(".launchTime").attr("checked","checked");
											$formTableGoway.find(".depBegTime").val(data[i].depBegTime);$formTableGoway.find(".depEndTime").val(data[i].depEndTime);
										}else{
											$formTableGoway.find(".landTime").attr("checked","checked");
											$formTableGoway.find(".arrBegTime").val(data[i].arrBegTime);$formTableGoway.find(".arrEndTime").val(data[i].arrEndTime);
										}
									}else if(data[i].trafficTripeType==="BACK_WAY"){//反程规则获取值
										$formTableBackWay.find(".routeDayNum").val(data[i].routeDayNum);
										$formTableBackWay.find(".sortRuleType").val(data[i].sortRuleType);
										if(data[i].depBegTime!==null && data[i].depBegTime!=="" && data[i].depEndTime!==null && data[i].depEndTime!==""){
											$formTableBackWay.find(".launchTime").attr("checked","checked");
											$formTableBackWay.find(".depBegTime").val(data[i].depBegTime);$formTableBackWay.find(".depEndTime").val(data[i].depEndTime);
										}else{
											$formTableBackWay.find(".landTime").attr("checked","checked");
											$formTableBackWay.find(".arrBegTime").val(data[i].arrBegTime);$formTableBackWay.find(".arrEndTime").val(data[i].arrEndTime);
										}
									}
								}
							}
						}
						consoleDlg.dialog( "option" , "title" , "航班筛选规则设置" ).dialog( "open" );	
					},
					error:function(e){
						consoleDlg.dialog( "option" , "title" , "航班筛选规则设置" ).dialog( "open" ); 
					}
				});		
	
			}
			/*设置加价规则*/
			function setFeeRules(productId){	
				var feeRuleDlg = $("#feeRuleDlg");
				feeRuleDlg.html($("#feeAssistDom").html());
				$("#productId_2").val(productId);
				$.ajax({	
					url: "${request.contextPath}/sdpProduct/feeRulesQuery",
					type: "post",
					data: {
						'productId':productId
					},
					dataType: 'json',
					success: function (data) {
						//渲染行程天数下拉框
						var $formTableFeeRule = $("table.formTableFeeRule");
						if(data!=null){
							for(var i in data){
								$formTableFeeRule.find(".constantRaise").attr("checked","checked");
								$formTableFeeRule.find("#oprationValue").val(data[i].oprationValue);
							}
						}
						feeRuleDlg.dialog( "option" , "title" , "价格规则设置" ).dialog( "open" ); 

					}
				});		
			}
			/*同步索引标签*/
			function syncSearchIndex(productId){
				$.ajax({	
					url: "${request.contextPath}/sdpProduct/syncSearchIndex",
					type: "post",
					data: {
						'productId':productId
					},
					dataType: 'json',
					success: function (data) {
						
						if(data!=null){
							if(data.returnStr=="SUCCESS"){
								alert("同步索引标签信息成功！");
							}else{
								alert("同步索引标签信息失败！！");
							}

						}
					},
					error:function(data){
						alert("同步索引标签信息失败！");
					}
				});		
			}
			/*初始化交通模态框*/
			function inItConsoleDlg(){
				$("#consoleDlg").dialog({
				autoOpen: false,
				modal: true, // 设置对话框为模态（modal）对话框
				resizable: true,
				width: 650,
				height : 400,
				position : "center", // 窗口显示的位置 
				buttons: {  // 为对话框添加按钮
					"保存": updateorSaveTrafficRules,
					"取消": function() {$("#consoleDlg").dialog("close")}
					} 
				});  
			}
			/*初始化加价模态框*/
			function inItFeeConsoleDlg(){
			    var feeRuleDlg = $("#feeRuleDlg");
				feeRuleDlg.dialog({
				autoOpen: false,
				modal: true, // 设置对话框为模态（modal）对话框
				resizable: true,
				width: 600,
				height : 400,
				position : "center", // 窗口显示的位置 
				buttons: {  // 为对话框添加按钮
					"保存": updateorSaveFeeRules,
					"取消": function() {$("#feeRuleDlg").dialog("close")}
					} 
				});  
			}
			/*保存交通规则*/
			function updateorSaveTrafficRules(){
				var productId = $("#productId_1").val();
				var $formTableGoway = $("#consoleDlg").find("table.formTableGoway");
				var $formTableBackWay = $("#consoleDlg").find("table.formTableBackWay");
				var paramData = [];
				var goData = {
					productId:productId,
					routeDayNum:$formTableGoway.find(".routeDayNum").val(),
					sortRuleType:$formTableGoway.find(".sortRuleType").val(),
					trafficTripeType:'GO_WAY'	};					
				if($formTableGoway.find("input[name='depRadio']:checked").val()=="launchTime"){
					goData.depBegTime = $formTableGoway.find(".depBegTime").val();
					goData.depEndTime = $formTableGoway.find(".depEndTime").val();
				}else{
					goData.arrBegTime = $formTableGoway.find(".arrBegTime").val();
					goData.arrEndTime = $formTableGoway.find(".arrEndTime").val();
				}
				var BegTime="",EndTime="";
				if(goData.depBegTime!==undefined && goData.depEndTime!==undefined){
					if(!(verifyBeginEndTime(goData.depBegTime,goData.depEndTime))){
						return;
					}
					
				}else if(goData.arrBegTime!==undefined && goData.arrEndTime!==undefined){
					if(!(verifyBeginEndTime(goData.arrBegTime,goData.arrEndTime))){
						return;
					}
				}
				var backData = {
					productId:productId,
					routeDayNum:$formTableBackWay.find(".routeDayNum").val(),
					sortRuleType:$formTableBackWay.find(".sortRuleType").val(),
					trafficTripeType:'BACK_WAY'};					
				if($formTableBackWay.find("input[name='arrRadio']:checked").val()=="launchTime"){
					backData.depBegTime = $formTableBackWay.find(".depBegTime").val();
					backData.depEndTime = $formTableBackWay.find(".depEndTime").val();
				}else{
					backData.arrBegTime = $formTableBackWay.find(".arrBegTime").val();
					backData.arrEndTime = $formTableBackWay.find(".arrEndTime").val();
				}
				if(goData.routeDayNum>backData.routeDayNum){
					alert("返程日期不能在去程日期之前!");return;
				}
				if(backData.depBegTime!==undefined && backData.depEndTime!==undefined){
					if(!(verifyBeginEndTime(backData.depBegTime,backData.depEndTime))){
						return;
					}
					
				}else if(backData.arrBegTime!==undefined && backData.arrEndTime!==undefined){
					if(!(verifyBeginEndTime(backData.arrBegTime, backData.arrEndTime))){
						return;
					}
				}
				paramData.push(goData);
				paramData.push(backData);

				$.ajax({	
					url: "${request.contextPath}/sdpProduct/trafficRulesSave",
					type: "post",
					data: 
					{
					  productTrafficRulesDtosStr:JSON.stringify(paramData)
					},
					dataType: 'json',
					success:function (data) {
						if(data.returnStr=="Success"){
							$( "#consoleDlg").dialog("close");      
						}
					},
					error:function(data){
						alert(data.responseText);
					}
					});
			}
			
			function verifyBeginEndTime(BeginTime,EndingTime){
				var BegTime = BeginTime.split(":");
				var EndTime = EndingTime.split(":");
				var saveFlag = true;
				if(parseInt(BegTime[0])>parseInt(EndTime [0])){
						saveFlag = false;
				}
				if((parseInt(BegTime[0])==parseInt(EndTime [0])) && (parseInt(BegTime[1])>parseInt(EndTime[1]))){
					saveFlag = false;
				}
				if(!saveFlag){
						alert("开始时间必须 <= 结束时间."); return false;
				}
				return true;
			}
			
			/*保存加价规则*/
			function updateorSaveFeeRules(){
				var productId = $("#productId_2").val();
				var $formTableFeeRule = $("#feeRuleDlg").find("table.formTableFeeRule");
				var paramData = {};
				paramData.productId = productId;
				if($formTableFeeRule.find("input[name='feeRadio']:checked").val()=="ADD_CONSTANT_BY_SALES_PRICE"){
					paramData.feeRuleType = "ADD_CONSTANT_BY_SALES_PRICE";
					paramData.oprationValue = $formTableFeeRule.find("#oprationValue").val();
					// 正整数校验^[0-9]*$
					if(paramData.oprationValue=="" || (!/^\d+$/.test(paramData.oprationValue))){
						alert("请输入正整数！");
						$formTableFeeRule.find("#oprationValue").focus();return;
					}
					
				}else{ alert("请选择加价规则！");return;}
				$.ajax({	
					url: "${request.contextPath}/sdpProduct/feeRulesSave",
					type: "post",
					data: paramData,
					dataType: 'json',
					success:function (data) {
						if(data.returnStr!==null && data.returnStr=="Success"){
							$( "#feeRuleDlg").dialog("close");      
						}
					},
					error:function(data){
						alert(data.responseText);
					}
					});
				
			}
			/*删除当前产品信息*/
			function deleteProduct(productId){
				var deleteFlag = confirm("确定要删除产品ID为:"+productId+" 的产品吗？");
				
				if(deleteFlag){
					$.ajax({
						url: "${request.contextPath}/sdpProduct/deleteProductInfo",
						type: "post",
						data: {
							'productId':productId
						},
						dataType: 'json',
						success: function (data) {
							if(data.returnStr=="SUCCESS"){
								alert("删除产品信息成功！");
								query();
							}else{
								alert("删除产品信息失败！！");
							}
						},
						error:function(e){
							alert("删除产品信息失败！！");
						}
					});	
				}
			}
		</script>
	</head>
	<body>
	<div class="content content1">
		<input type="hidden" id="basePath" value="${request.contextPath}">
	    <input type="hidden" name="search" value="false">
		<div class="breadnav">首页->交通+X->产品同步管理->产品索引列表</div>
		<div class="infor1" id="conditionDiv">
			<!-- 产品信息 start  -->
			<div class="visitor message">
				<div class="main">
					<div class="part">
						<span>产品ID：</span><input type="text" id="productId" name="fitSdpProductBasicInfoDto.productId"/>
						<span>产品名称：</span><input type="text" id="productName" name="fitSdpProductBasicInfoDto.productName"/>							
					</div>
					<div class="part">
						<span>产品品类：</span><select id="bizCategoryId">
							<option value="">全部</option>
							<#list BIZ_CATEGORY_TYPE as val>
							<#if val !="NULL">
							<option value="${val.categoryId}">${val.cnName}</option>
							</#if>
							</#list>
						</select>
						<span>是否为多出发地：</span><select id="muiltDpartureFlag">
						<option value="">全部</option>
						<#list JudgeType as val>  
						  <#if val !="NULL">
						   <option value="${val}">${val.cnName}</option>
						  </#if> 
						</#list>
						</select>
					</div>
					<div class="part">
						<span>被打包产品Id：</span><input type="text" id="packagedProductId"  name="fitSdpProductBasicInfoDto.packagedProductId"/>
						<span>产品经理：</span><input type="text" id="managerName"  name="fitSdpProductBasicInfoDto.managerName"/>
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
	
	<!-- 设置交通规则弹出框-->
	<div id="consoleDlg">
		<div id="formContainer">
			<form id="consoleForm">
				<input type="hidden" id="productId_1" />
				<table class="formTableGoway">
				<!--<div id="goWay">-->
					<tr style="height: 30px;">
						<th><span style="font-weight:bold">去程</span></th>
						<th>行程第</th>
						<td>
							<select id="routeDayNum" class="routeDayNum">
								<option value="1" selected="">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
							<span>天</span>
						</td>
						<th><span style="color:red;">*</span>排序规则：</th>
						<td>
							<select id="sortRuleType" class="sortRuleType">
								<option value="SORT_BY_PRICE_ASC" selected="">价格由低到高</option>
								<option value="SORT_BY_DEPTIME_ASC">起飞时间由早到晚</option>
							</select>
						</td>
					</tr>
					<tr style="height: 30px;">
						<th></th>
						<th>
						<input name="depRadio" id="launchTime" class="launchTime" type="radio" value="launchTime"/>
						起飞时间：</th>
						<td>
							<select id="depBegTime" class="depBegTime">
								<option value="00:00" selected="">00:00</option>
								<option value="01:00">01:00</option>
								<option value="02:00">02:00</option>
								<option value="03:00">03:00</option>
								<option value="04:00">04:00</option>
								<option value="05:00">05:00</option>
								<option value="06:00">06:00</option>
								<option value="07:00">07:00</option>
								<option value="08:00">08:00</option>
								<option value="09:00">09:00</option>
								<option value="10:00">10:00</option>
								<option value="11:00">11:00</option>
								<option value="12:00">12:00</option>
								<option value="13:00">13:00</option>
								<option value="14:00">14:00</option>
								<option value="15:00">15:00</option>
								<option value="16:00">16:00</option>
								<option value="17:00">17:00</option>
								<option value="18:00">18:00</option>
								<option value="19:00">19:00</option>
								<option value="20:00">20:00</option>
								<option value="21:00">21:00</option>
								<option value="22:00">22:00</option>
								<option value="23:00">23:00</option>
								<option value="23:59">23:59</option>
							 </select>
							 <span>----</span>
							 <select id="depEndTime" class="depEndTime">
								<option value="00:00">00:00</option>
								<option value="01:00">01:00</option>
								<option value="02:00">02:00</option>
								<option value="03:00">03:00</option>
								<option value="04:00">04:00</option>
								<option value="05:00">05:00</option>
								<option value="06:00">06:00</option>
								<option value="07:00">07:00</option>
								<option value="08:00">08:00</option>
								<option value="09:00">09:00</option>
								<option value="10:00">10:00</option>
								<option value="11:00">11:00</option>
								<option value="12:00">12:00</option>
								<option value="13:00">13:00</option>
								<option value="14:00">14:00</option>
								<option value="15:00">15:00</option>
								<option value="16:00">16:00</option>
								<option value="17:00">17:00</option>
								<option value="18:00">18:00</option>
								<option value="19:00">19:00</option>
								<option value="20:00">20:00</option>
								<option value="21:00">21:00</option>
								<option value="22:00">22:00</option>
								<option value="23:00">23:00</option>
								<option value="23:59" selected="">23:59</option>
							</select>
						</td>
					</tr>
					<tr style="height: 30px;">
						<th></th>
						<th>
						<input name="depRadio" id="landTime" class="landTime" type="radio" value="landTime" checked="checked"/>
						降落时间：</th>
						<td>
							<select id="arrBegTime" class="arrBegTime">
								<option value="00:00" selected="">00:00</option>
								<option value="01:00">01:00</option>
								<option value="02:00">02:00</option>
								<option value="03:00">03:00</option>
								<option value="04:00">04:00</option>
								<option value="05:00">05:00</option>
								<option value="06:00">06:00</option>
								<option value="07:00">07:00</option>
								<option value="08:00">08:00</option>
								<option value="09:00">09:00</option>
								<option value="10:00">10:00</option>
								<option value="11:00">11:00</option>
								<option value="12:00">12:00</option>
								<option value="13:00">13:00</option>
								<option value="14:00">14:00</option>
								<option value="15:00">15:00</option>
								<option value="16:00">16:00</option>
								<option value="17:00">17:00</option>
								<option value="18:00">18:00</option>
								<option value="19:00">19:00</option>
								<option value="20:00">20:00</option>
								<option value="21:00">21:00</option>
								<option value="22:00">22:00</option>
								<option value="23:00">23:00</option>
								<option value="23:59">23:59</option>
							 </select>
							 <span>----</span>
							 <select id="arrEndTime" class="arrEndTime">
								<option value="00:00">00:00</option>
								<option value="01:00">01:00</option>
								<option value="02:00">02:00</option>
								<option value="03:00">03:00</option>
								<option value="04:00">04:00</option>
								<option value="05:00">05:00</option>
								<option value="06:00">06:00</option>
								<option value="07:00">07:00</option>
								<option value="08:00">08:00</option>
								<option value="09:00">09:00</option>
								<option value="10:00">10:00</option>
								<option value="11:00">11:00</option>
								<option value="12:00">12:00</option>
								<option value="13:00">13:00</option>
								<option value="14:00">14:00</option>
								<option value="15:00">15:00</option>
								<option value="16:00">16:00</option>
								<option value="17:00">17:00</option>
								<option value="18:00">18:00</option>
								<option value="19:00">19:00</option>
								<option value="20:00">20:00</option>
								<option value="21:00">21:00</option>
								<option value="22:00">22:00</option>
								<option value="23:00">23:00</option>
								<option value="23:59" selected="">23:59</option>
							</select>
						</td>
					</tr>
				<!--</div>-->
				</table>
					
				<table class="formTableBackWay">
					<!--返程-->
					<tr style="height: 30px;">
						<th><span style="font-weight:bold">返程</span></th>
						<th>行程第</th>
						<td>
							<select id="routeDayNum" class="routeDayNum">
								<option value="1" selected="">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
							<span>天</span>
						</td>
						<th><span style="color:red;">*</span>排序规则：</th>
						<td>
							<select id="sortRuleType" class="sortRuleType">
								<option value="SORT_BY_PRICE_ASC" selected="">价格由低到高</option>
								<option value="SORT_BY_DEPTIME_ASC">起飞时间由早到晚</option>
							</select>
						</td>
					</tr>
					<tr style="height: 30px;">
						<th></th>
						<th>
						<input name="arrRadio" id="launchTime" class="launchTime" type="radio" value="launchTime" checked="checked"/>
						起飞时间：</th>
						<td>
							<select id="depBegTime" class="depBegTime">
								<option value="00:00" selected="">00:00</option>
								<option value="01:00">01:00</option>
								<option value="02:00">02:00</option>
								<option value="03:00">03:00</option>
								<option value="04:00">04:00</option>
								<option value="05:00">05:00</option>
								<option value="06:00">06:00</option>
								<option value="07:00">07:00</option>
								<option value="08:00">08:00</option>
								<option value="09:00">09:00</option>
								<option value="10:00">10:00</option>
								<option value="11:00">11:00</option>
								<option value="12:00">12:00</option>
								<option value="13:00">13:00</option>
								<option value="14:00">14:00</option>
								<option value="15:00">15:00</option>
								<option value="16:00">16:00</option>
								<option value="17:00">17:00</option>
								<option value="18:00">18:00</option>
								<option value="19:00">19:00</option>
								<option value="20:00">20:00</option>
								<option value="21:00">21:00</option>
								<option value="22:00">22:00</option>
								<option value="23:00">23:00</option>
								<option value="23:59">23:59</option>
							 </select>
							 <span>----</span>
							 <select id="depEndTime" class="depEndTime">
								<option value="00:00">00:00</option>
								<option value="01:00">01:00</option>
								<option value="02:00">02:00</option>
								<option value="03:00">03:00</option>
								<option value="04:00">04:00</option>
								<option value="05:00">05:00</option>
								<option value="06:00">06:00</option>
								<option value="07:00">07:00</option>
								<option value="08:00">08:00</option>
								<option value="09:00">09:00</option>
								<option value="10:00">10:00</option>
								<option value="11:00">11:00</option>
								<option value="12:00">12:00</option>
								<option value="13:00">13:00</option>
								<option value="14:00">14:00</option>
								<option value="15:00">15:00</option>
								<option value="16:00">16:00</option>
								<option value="17:00">17:00</option>
								<option value="18:00">18:00</option>
								<option value="19:00">19:00</option>
								<option value="20:00">20:00</option>
								<option value="21:00">21:00</option>
								<option value="22:00">22:00</option>
								<option value="23:00">23:00</option>
								<option value="23:59" selected="">23:59</option>
							</select>
						</td>
					</tr>
					<tr style="height: 30px;">
						<th></th>
						<th>
						<input name="arrRadio" id="landTime" class="landTime" type="radio" value="landTime"/>
						降落时间：</th>
						<td>
							<select id="arrBegTime"  class="arrBegTime">
								<option value="00:00" selected="">00:00</option>
								<option value="01:00">01:00</option>
								<option value="02:00">02:00</option>
								<option value="03:00">03:00</option>
								<option value="04:00">04:00</option>
								<option value="05:00">05:00</option>
								<option value="06:00">06:00</option>
								<option value="07:00">07:00</option>
								<option value="08:00">08:00</option>
								<option value="09:00">09:00</option>
								<option value="10:00">10:00</option>
								<option value="11:00">11:00</option>
								<option value="12:00">12:00</option>
								<option value="13:00">13:00</option>
								<option value="14:00">14:00</option>
								<option value="15:00">15:00</option>
								<option value="16:00">16:00</option>
								<option value="17:00">17:00</option>
								<option value="18:00">18:00</option>
								<option value="19:00">19:00</option>
								<option value="20:00">20:00</option>
								<option value="21:00">21:00</option>
								<option value="22:00">22:00</option>
								<option value="23:00">23:00</option>
								<option value="23:59">23:59</option>
							 </select>
							 <span>----</span>
							 <select id="arrEndTime" class="arrEndTime">
								<option value="00:00">00:00</option>
								<option value="01:00">01:00</option>
								<option value="02:00">02:00</option>
								<option value="03:00">03:00</option>
								<option value="04:00">04:00</option>
								<option value="05:00">05:00</option>
								<option value="06:00">06:00</option>
								<option value="07:00">07:00</option>
								<option value="08:00">08:00</option>
								<option value="09:00">09:00</option>
								<option value="10:00">10:00</option>
								<option value="11:00">11:00</option>
								<option value="12:00">12:00</option>
								<option value="13:00">13:00</option>
								<option value="14:00">14:00</option>
								<option value="15:00">15:00</option>
								<option value="16:00">16:00</option>
								<option value="17:00">17:00</option>
								<option value="18:00">18:00</option>
								<option value="19:00">19:00</option>
								<option value="20:00">20:00</option>
								<option value="21:00">21:00</option>
								<option value="22:00">22:00</option>
								<option value="23:00">23:00</option>
								<option value="23:59" selected="">23:59</option>
							</select>
						</td>
					</tr>
				</table>
			</form>
		</div>	
	</div>
	<div id="assistDom" style="display:none;"></div>
	
	<!-- 加价规则弹出框-->
	<div id="feeRuleDlg" style="padding-top:30px;">
		<div id="formContainer">
		<input type="hidden" id="productId_2" />
		<table class="formTableFeeRule">
			<tr style="height: 30px;">
				<th>加价规则：</th>
				<th>
				<input name="feeRadio" id="constantRaise " class="constantRaise" type="radio" value="ADD_CONSTANT_BY_SALES_PRICE"/>
				基于销售价恒定，加价</th>
				<td>
					<input type="text" id="oprationValue" />元
				</td>
			</tr>
		</table>
		</div>
	</div>
	<div id="feeAssistDom" style="display:none;"></div>
	<form id="exportCsvForm" action="" method="post" target="_blank">
		<div id="exportCsvDiv" style="display:none;">
		</div>
	</form>
	
	<div id="jsContainer" class="jsContainer" style="height: 0">
		<div id="tuna_alert"
			style="display: none; position: absolute; z-index: 999; overflow: hidden;"></div>
		<div id="tuna_jmpinfo"
			style="visibility: hidden; position: absolute; z-index: 120;"></div>
	</div>                  
<style type="text/css">
.formTableBackWay{
	width: 100%;
    margin: 25px auto;
}
.formTableGoway{
	width: 100%;
    margin: 25px auto;
}
.content1 .infor1 .message .main .part select{
    color: #333;
    width: 216px;
}
</style>
</body>
</html>