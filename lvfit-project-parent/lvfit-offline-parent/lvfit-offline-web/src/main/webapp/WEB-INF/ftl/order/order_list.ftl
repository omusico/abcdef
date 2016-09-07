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
				$("#btnExport").click(function(){
					exportCsv();
				});
				$("#btnExport_f").click(function(){
					exportCsv_f();
				});
				$("#btnExport_h").click(function(){
					exportCsv_h();
				});
			}); 

         	//spinach 
			function query() {
				if($('#orderMainNo').val() != '' && isNaN($('#orderMainNo').val()))
    			{
    				alert("订单号格式错误!");
    				$("#orderMainNo").val("").focus();
    				return;
    			}
    			/* if($('#orderNo').val() != '' && isNaN($('#orderNo').val()))
    			{
    				alert("订单号格式错误!");
    				$("#orderNo").val("").focus();
    				return;
    			} */
    			if($('#contactCellphone').val() != '' && !/^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17\d{1})|(18([0-4]|[5-9])))\d{8}$/.test($("#contactCellphone").val())){
        			alert("手机号不合法！")
    				$("#contactCellphone").val("").focus();
    				return;
        		};
        		
				$("#flightOrderList").jqGrid('setGridParam', 
				{
		 			url:"${request.contextPath}/order/OrderQuery",
		 			datatype : "json",
		 			mtype : "POST",
			 		postData : getQueryParams()
				}).trigger("reloadGrid");
				//conditionForExportCsvForm();
			}
	
			function getQueryParams() {
    			// 订单来源
	    		var bookingSource = getBookingSource();
				var mm = {
					// 'fitOrderQueryDto.orderNo' : $("#orderNo").val(), //子订单号
                    'fitOrderQueryDto.orderMainNo' : $("#orderMainNo").val(),
                    'fitOrderQueryDto.VSTMainNo' : $("#VSTMainNo").val(),
                    'fitOrderQueryDto.customerName' : $("#customerName").val(), //下单人姓名 即驴妈妈帐号
                    'fitOrderQueryDto.mainStartTime' : $("#mainStartTime").val(),
                    'fitOrderQueryDto.mainEndTime' : $("#mainEndTime").val(),
                    'fitOrderQueryDto.bookingSources' : bookingSource.toString(),
                    
                    'suppMainStatus.orderStatus' : $("#orderStatus").val(),
                    'suppMainStatus.auditStatus' : $("#orderAuditStatus").val(),
                    'suppMainStatus.paymentStatus' : $("#orderPayStatus").val(),
                    //购买人信息
                    'fitOrderQueryPeopleDto.contactName' : $("#contactName").val(),
                    'fitOrderQueryPeopleDto.contactCellphone' : $("#contactCellphone").val(),
                    'fitOrderQueryPeopleDto.contactEmail' : $("#contactEmail").val(),
                    'fitOrderQueryPeopleDto.contactTelphone' : $("#contactTelphone").val(),  //购买人固话
                    //城市
                    'fitOrderQueryPeopleDto.departCity' : $("#departCity").val(),  //出发地
                    'fitOrderQueryPeopleDto.arriveCity' : $("#arriveCity").val(),  //目的地
                    'fitOrderQueryPeopleDto.checkInCity' : $("#checkInCity").val(),  //入住城市
                    'fitOrderQueryPeopleDto.playerFStartTime' : $("#playerFStartTime").val(),  //去程时间
                    'fitOrderQueryPeopleDto.playerFEndTime' : $("#playerFEndTime").val(),  //返程时间
                    
                    'fitOrderQueryPeopleDto.playerName' : $("#playerName").val(),
                    'fitOrderQueryPeopleDto.playerIDNumber' : $("#playerIDNumber").val(),
                    'fitOrderQueryPeopleDto.playerLiveStartTime' : $("#playerLiveStartTime").val(),
                    'fitOrderQueryPeopleDto.playerLiveEndTime' : $("#playerLiveEndTime").val(),
                    'fitOrderQueryPeopleDto.playerLiveEndTime' : $("#playerLiveEndTime").val(),
					'search':false,
					'fitOrderQueryPeopleDto.productId':$("#productId").val(),
					'fitOrderQueryPeopleDto.productName':$("#productName").val(),
					'fitOrderQueryPeopleDto.categoryId':$("#categoryId").val()
				};
				return mm;
			}
			
			function getBookingSource(){
				var bookingSource = "";
				$("input[tempName='bookingSource']:checkbox").each(function(){

					//渠道兼容
            		if($(this).prop("checked") ){
						if($(this).val()=='FIT_FRONT'){
                            bookingSource += ",'FIT_FRONT','FIT_SDP_FRONT'";
						}
                        if($(this).val()=='FIT_BACK'){
                            bookingSource += ",'FIT_BACK','FIT_SDP_BACK'";
                        }
                        if($(this).val()=='FIT_IOS'){
                            bookingSource += ",'FIT_IOS','FIT_SDP_IOS'";
                        }
                        if($(this).val()=='FIT_ANDROID'){
                            bookingSource += ",'FIT_ANDROID','FIT_SDP_ANDROID'";
                        }
                        if($(this).val()=='FIT_WAP'){
                            bookingSource += ",'FIT_WAP','FIT_SDP_WAP'";
                        }
                        if($(this).val()=='FIT_DISTRIBUTION'){
                            bookingSource += ",'FIT_DISTRIBUTION','FIT_SDP_DISTRIBUTION'";
                        }
            		}
        		});
        		if(bookingSource){
        			bookingSource = bookingSource.substr(1);
        		};
        		return bookingSource;
			}
			
			function initGrid() 
			{
			
				var colNames = ['主订单号','VST主单号', '产品名称','产品品类','预订人数','支付方式','下单时间', '金额','购买人','订单来源', '订单状态'];
		
				var cols = [ 
					{
						name : 'mainOrderNo',  //mainOrderNo
						index : 'mainOrderNo',
						formatter:formatLink,
						align : 'center',
						sortable:false
					},
					{
						name : 'vstMainOrderNo',  //mainOrderNo
						index : 'vstMainOrderNo',
						formatter:formatLinkVst,
						align : 'center',
						sortable:false
					},
					{
						name : 'productName',   //名称
						index : 'productName',
						align : 'center',
						sortable:false
					},
					{
						name : 'categoryId',   //产品品类
						index : 'categoryId',
						align : 'center',
						sortable:false
					},
					{
						name : 'detailCount',   //预订人数
						index : 'detailCount',
						align : 'center',
						sortable:false
					},
					{
						name : 'payType',  //支付方式
						index : 'payType',
						align : 'center',
						sortable:false
					},
					{
						name : 'createDate',
						index : 'createDate',
						align : 'center',
						sortable:false
					},
					{
						name : 'orderTotalAmount', //金额
						index : 'orderTotalAmount',
						align : 'center',
						sortable:false
					},
					/* {
						name : 'departureDate',// 游玩日期
						index : 'departureDate',
						align : 'center',
						sortable:false
					}, */
					{
						name : 'contactName',
						index : 'contactName',
						align : 'center',
						sortable:false
					},
					{
						name : 'bookingSource',
						index : 'bookingSource',
						align : 'center',
						sortable:false
					},
					{
						name : 'allStatus', //订单状态|审核状态|支付状态
						index : 'allStatus',
						align : 'center',
						sortable:false
					}
					];
					
				$("#flightOrderList").jqGrid({
					url : '${request.contextPath}/order/OrderQuery',
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
			
			function conditionForExportCsvForm()
			{
				$('#exportCsvDiv').html($('#conditionDiv').clone());
				$.each($('#conditionDiv').find('select'), function(index, obj)
				{
					var objName = $(obj).attr('name');
					$('#exportCsvDiv').find('select[name="'+objName+'"]').attr('value', $(obj).val());
				});
			}

    		function formatLink(cellvalue, options, rowObject) 
			{
	    		var url = "${request.contextPath}/order/queryOrderDetail/"+rowObject.vstMainOrderNo+"/"+rowObject.mainId;
	    		return  "<a href='"+url+"' style='color:blue;' target='_blank' title='查看详情'>" + cellvalue + "</a>";
    		}
    		
    		function formatLinkVst(cellvalue, options, rowObject) 
			{
	    		var url = "http://super.lvmama.com/vst_order/order/orderManage/showOrderStatusManage.do?orderType=parent&orderId="+cellvalue;
	    		return  "<a href='"+url+"' style='color:blue;' target='_blank' title='查看详情'>" + cellvalue + "</a>";
    		}
    		
  		//清空表单
  		function clearForm()
  		{
  			$('input[type=text]').val('');
  			$('select').val('');
  			$('input[tempName="bookingSource"]').attr('checked', false);
  		}
    		
  		/**
  		 * 导出Csv
  		 */
  		function exportCsv(){
  			 setBookSource();
  			 var basePath = $("#basePath").val();
  			 var url = basePath+"/order/orderAllExportCsv";
  			 url = completeUrl(url);
  			 $("#exportCsvForm").attr("action",url);
  			 $('#exportCsvForm').submit();
  		}
  		
  		function exportCsv_f(){
  			 setBookSource();
  			 var basePath = $("#basePath").val();
  			 var url = basePath+"/order/orderFlightExportCsv";
  			 url = completeUrl(url);
  			 $("#exportCsvForm").attr("action",url);
  			 $('#exportCsvForm').submit();
  		}
  		function exportCsv_h(){
  			 setBookSource();
	  		 var basePath = $("#basePath").val();
  			 var url = basePath+"/order/orderHotelExportCsv";
  			 url = completeUrl(url);
  			 $("#exportCsvForm").attr("action",url);
  			 $('#exportCsvForm').submit();
  		}
  		
  		function completeUrl(url){
  			 var bookingSource = getBookingSource();
  			 url +="?suppMainStatus.orderStatus="+$("#orderStatus").val();
  			 url +="&fitOrderQueryDto.orderMainNo="+$("#orderMainNo").val();
  			 url +="&fitOrderQueryDto.VSTMainNo="+$("#VSTMainNo").val();
  			 url +="&fitOrderQueryDto.orderNo="+$("#orderNo").val();
  			 url +="&fitOrderQueryDto.mainStartTime="+$("#mainStartTime").val();
  			 url +="&fitOrderQueryDto.mainEndTime="+$("#mainEndTime").val();
  			 url +="&suppMainStatus.auditStatus="+$("#orderAuditStatus").val();
  			 url +="&suppMainStatus.paymentStatus="+$("#orderPayStatus").val();
  			 url +="&fitOrderQueryDto.bookingSources="+bookingSource.toString();
  			 url +="&fitOrderQueryDto.customerName="+$("#customerName").val();
  			 url +="&fitOrderQueryPeopleDto.productId="+$("#productId").val();
  			 url +="&fitOrderQueryPeopleDto.productName="+$("#productName").val();
  			 url +="&fitOrderQueryPeopleDto.categoryId="+$("#categoryId").val();
  			 url +="&fitOrderQueryPeopleDto.departCity="+$("#departCity").val();
  			 url +="&fitOrderQueryPeopleDto.arriveCity="+$("#arriveCity").val();
  			 url +="&fitOrderQueryPeopleDto.playerFStartTime="+$("#playerFStartTime").val();
  			 url +="&fitOrderQueryPeopleDto.playerFEndTime="+$("#playerFEndTime").val();
  			 url +="&fitOrderQueryPeopleDto.playerName="+$("#playerName").val();
  			 url +="&fitOrderQueryPeopleDto.playerIDNumber="+$("#playerIDNumber").val();
  			 url +="&fitOrderQueryPeopleDto.contactCellphone="+$("#contactCellphone").val();
  			 url +="&fitOrderQueryPeopleDto.contactName="+$("#contactName").val();
  			 return url;
  		}
  		 function setBookSource(){
   			// 订单来源
     		var bookingSource = getBookingSource();
            $("bookingSources").val(bookingSource.toString());
   		}
		</script>
	</head>
	<body>
	<div class="content content1">
		<input type="hidden" id="basePath" value="${request.contextPath}">
	    <input type="hidden" name="search" value="false">
		<div class="breadnav">首页 > 订单查询</div>
		<div class="infor1" id="conditionDiv">
			<div class="visitor message">
				<div class="title" style="height:120px;">订单信息</div>
				<div class="main">
					<div class="part">
						<span>主订单号：</span><input type="text" id="orderMainNo" name="fitOrderQueryDto.orderMainNo"/>
						<span>VST主单号：</span><input type="text" id="VSTMainNo" name="fitOrderQueryDto.VSTMainNo"/>
						<!-- <span>子订单号：</span><input type="text" id="orderNo" name="fitOrderQueryDto.orderNo"/> -->
						<!-- <span>采购订单：</span><input type="text" id="purOrderNo" name="purOrderNo"/> -->
					</div>
					<div class="part">
						<span>下单时间：</span><input type="text" id="mainStartTime" name="fitOrderQueryDto.mainStartTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',startDate: '%y-%M-%d 00:00:00'})" style="width:140px;" 
							class="Wdate" readonly="readonly"/>
						 - 
						<input type="text" id="mainEndTime" name="fitOrderQueryDto.mainEndTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',startDate: '%y-%M-%d 23:59:59'})" style="width:140px;" 
						 	class="Wdate" readonly="readonly"/>
						 	
						 <!-- <span>支付时间：</span><input type="text" id="payQueryBegTime" name="fitOrderQueryDto.payQueryBegTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" style="width:140px;" 
							class="Wdate" readonly="readonly"/>
						 - 
						<input type="text" id="payQueryEndTime" name="fitOrderQueryDto.payQueryEndTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" style="width:140px;" 
							class="Wdate" readonly="readonly"/>	--!>
					</div>
					<div class="part">						
						<span>订单状态：</span><select id="orderStatus">
							<option value="">全部</option>
							<#list orderBookingStatus as val>  
							   <#if val !="NULL">
							       <option value="${val}">${val.cnName}</option>
							   </#if>
							</#list>
						</select>
						<span>资源审核：</span><select id="orderAuditStatus">
							<option value="">全部</option>
							<#list orderAuditStatusEnum as val>  
							  <#if val !="NULL">
							   <option value="${val}">${val.cnName}</option>
							  </#if> 
							</#list>
						</select>
						<span>支付状态：</span><select id="orderPayStatus">
							<option value="">全部</option>
							<#list orderPayStatusEnum as val>  
							  <#if val !="NULL">
							   <option value="${val}">${val.cnName}</option>
							  </#if> 
							</#list>
						</select>		
					</div> 
					<div class="part">
						<span>订单来源：</span>
						<input type="hidden" id="bookingSources" name="fitOrderQueryDto.bookingSources"/>
						<#list bookingSourceEnum as val>
						<input type="checkbox" class="choose" tempName="bookingSource" value="${val }"/>${val.cnName}
						</#list>
					</div>
					
				</div> <!-- END class="main" -->
			</div> 
			
			<!-- 产品信息 start  -->
			<div class="visitor message">
				<div class="title" style="height:60px;">产品信息</div>
				<div class="main">
					<div class="part">
						<span>产品Id：</span><input type="text" id="productId"/>
						<span>产品名称：</span><input type="text" id="productName"/>
						<span>产品品类：</span><select id="categoryId">
							<option value="">全部</option>
							<#list bizCategoryType as val>  
							  <#if val !="NULL">
							   <option value="${val.categoryId}">${val.cnName}</option>
							  </#if> 
							</#list>
						</select>	 
					</div>
					<div class="part">
						<span>出发地：</span><input type="text" id="departCity" name="fitOrderQueryPeopleDto.departCity"/>
						<span>目的地：</span><input type="text" id="arriveCity" name="fitOrderQueryPeopleDto.arriveCity"/>
						<span>去程时间：</span><input type="text" id="playerFStartTime" name="fitOrderQueryPeopleDto.playerFStartTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" style="width:140px;" 
							class="Wdate" readonly="readonly"/>
						 <span style="width:80px;">返程时间：</span> <input type="text" id="playerFEndTime" name="fitOrderQueryPeopleDto.playerFEndTime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" style="width:140px;" 
							class="Wdate" readonly="readonly"/>
					</div>
				</div>
			</div>
			<!-- 产品信息 end  -->
			
			<!-- 游客信息 start  -->
			<div class="visitor message">
				<div class="title" style="height:60px;">游客信息</div>
				<div class="main">
					<div class="part">
						<span>驴妈妈账号：</span><input type="text" id="customerName" name="fitOrderQueryDto.customerName"/>
						<span>游玩人姓名：</span><input type="text" id="playerName" />
						<span>游玩人证件号：</span><input type="text" id="playerIDNumber" />
					</div>
					<div class="part">
						<span>购买人手机号：</span><input type="text" id="contactCellphone" name="fitOrderQueryPeopleDto.contactCellphone"/>
						<span>购买人姓名：</span><input type="text" id="contactName" name="fitOrderQueryPeopleDto.contactName"/>
						<!-- <span>购买人邮箱：</span><input type="text" id="contactEmail" name="fitOrderQueryPeopleDto.contactEmail"/> -->
					</div>
				</div>
			</div>
			<!-- 游客信息 end  -->
		</div>
		<div class="click">
			<a href="javascript:void(0);" onclick="query();"><div class="button">查询</div></a>
			<a href="javascript:void(0);" onclick="clearForm();"><div class="button">清空</div></a>
			
			<a href="javascript:;"><div id="btnExport" class="button" >交通+X订单报表</div></a>
			<a href="javascript:;"><div id="btnExport_f" class="button" >机票订单报表</div></a>
			<a href="javascript:;"><div id="btnExport_h" class="button" >酒店订单报表</div></a>
		</div>
	</div>
	 <div class="content content1" style="margin-top:50px;">
      <table id="flightOrderList"></table>
      <div id="pager"></div>
    </div>
	
	<form id="exportCsvForm" action="" method="post" target="_blank">
		<input type="hidden" id="data" name="data">
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
</body>
</html>