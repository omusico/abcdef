<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="mobile-agent" content="format=html5; url=http://m.lvmama.com/">
    <link rel="dns-prefetch" href="//s1.lvjs.com.cn">
    <link rel="dns-prefetch" href="//s2.lvjs.com.cn">
    <link rel="dns-prefetch" href="//s3.lvjs.com.cn">
    <link rel="shortcut icon" href="http://www.lvmama.com/favicon.ico" type="image/x-icon">
    <title id="TITLE"></title>
	<meta name="description" id="DESC" content="">
	<meta name="keywords" id="KEYWORDS" content="">
	<link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v6/header_new.css,/styles/v6/public/base.css,/styles/v5/modules/paging.css,/styles/v5/modules/tip.css,/styles/v5/modules/calendar.css,/styles/lv/buttons.css">
	<link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v6/flighthotel/fh-result-loading.css,/styles/v6/flighthotel/fh-icon-ac.css,/styles/fit/v3/select-flight.css">
	<link rel="stylesheet" href="${request.contextPath}/css/fh-select.css">
   
    <style type="text/css">
		.screen_condition .fh-icon-ac{
			margin-top: 2px;
		}
		.flight-title .active {color:#f60;} 
		.flight-title a {color:#999;} 
		.flight-title .active .sort_up{background-position: -17px -44px;	} 
		.flight-title .active .sort_down{background-position: -1px -44px;	} 
		.resortOverlay {
		position: fixed;
		top: 0px;
		left: 0px;
		width: 100%;
		height: 100%;
		z-index: 1000;
		background-color: #000;
		opacity: 0.4;
		filter: alpha(opacity=40);
		display: none
	}
	</style>
</head>

<body class="fh-select-flight flight_fit">
<!-- 流量埋点 -->
    <script src="http://pic.lvmama.com/min/index.php?f=/js/v5/ibm/eluminate.js"></script>
    <script src="http://pic.lvmama.com/min/index.php?f=/js/v5/ibm/coremetrics-initalize.js"></script>
    <script>_LVMAMA_COREMETRICS.init(document.domain);</script>
    <script>
        cmCreatePageviewTag("机酒频道首页_<fh-select-flight>", "FlightHotel", null, null,"-_--_--_--_--_-路径页面");
    </script>
     <script type="text/javascript" src="http://s2.lvjs.com.cn/js/common/losc.js"></script>
    <#if getSuperCommonHeader ??>
    	<!--去掉搜索框-->
 		${getSuperCommonHeader()}
	</#if>
	
	 <#if isBackBooking=='true'>
	     <br>
         <h3 style="font-weight: normal;">&nbsp;&nbsp;&nbsp;&nbsp;<a href="${request.contextPath}/back_index" style="color:#21a8dc">首页</a> >
                <a href="${request.contextPath}/search/backToShopping?shoppingUUID=${uuid}" style="color:#21a8dc">产品选择页</a>
           </h3>
     </#if>
	
    <!-- banWrap -->
    <div class="banWrap">
        <!-- filter 筛选开始-->
        <div class="filter bd_ddd">
      		
			<#if fdf.backOrTo == "to">
            	<!-- filter-head 去程头部 添加hide类可以隐藏-->
	            <div id="flightmethod" value=${fdf.backOrTo} class="filter-head yh f18 c9 ">
	                <a href="javascript:;" class="btn btn-pink btn-lg pr"><span class="btn-text">返回上一页</span></a><i class="fh-icon-depa"></i>更换去程航班：<span class="c3 pl10">${fdf.departureCityName}<i class="fh-icon-from-to"></i><i class="pr15">${fdf.arrivalCityName}</i><dfn class="arial f16">${fdf.departureDate}</dfn></span>
	            </div><!-- //filter-head-->
	           
	            <#elseif fdf.backOrTo == "back">
	             <!-- filter-head 返程头部 已添加hide类隐藏-->
	            <div id="flightmethod" value=${fdf.backOrTo} class="filter-head yh f18 c9 ">
	                <a href="javascript:;" class="btn btn-pink btn-lg pr"><span class="btn-text">返回上一页</span></a><i class="fh-icon-dest"></i>更换返程航班：<span class="c3 pl10">${fdf.departureCityName}<i class="fh-icon-from-to"></i><i class="pr15">${fdf.arrivalCityName}</i><dfn class="arial f16">${fdf.departureDate}</dfn></span>
	            </div><!-- //filter-head-->
	            
            </#if>
           
            <div class="search_kind">
                <dl class="clearfix js_fuxuan f_start">
                    <dt>起飞时间</dt>
                    <dd class="kind_buxian" code="ALL" codetype="departureTimeSegments"><a class="search_arrow_1" href="javascript:;" code="ALL" codetype="departureTimeSegments">不限</a></dd>
                    <#list dtsf as departureTime>
                    	<dd id="startTime" codetype="departureTimeSegments" code="${departureTime.fieldValue}">
                    	<a href="javascript:;" codetype="departureTimeSegments" code="${departureTime.fieldValue}"  class="screen_condition"><i class="ph_icon hotel_ck"  codetype="departureTimeSegments" code="${departureTime.fieldValue}"></i>${departureTime.fieldDesc}</a>
                    	</dd>
					</#list>
                    
                  
                </dl>
            </div><!-- //search_kind -->
            
            <div class="search_kind">
                <dl class="clearfix js_fuxuan f_reach">
                    <dt>到达时间</dt>
                    <dd class="kind_buxian" code="ALL" codetype="arrivalTimeSegments"><a class="search_arrow_1" href="javascript:;" code="ALL" codetype="arrivalTimeSegments">不限</a></dd>
                    
                    <#list atsf as arrivalTime>
                    	<dd id="arrivalTime"  codetype="arrivalTimeSegments" code="${arrivalTime.fieldValue}"><a href="javascript:;" codetype="arrivalTimeSegments" code="${arrivalTime.fieldValue}" class="screen_condition"><i class="ph_icon hotel_ck" codetype="arrivalTimeSegments" code="${arrivalTime.fieldValue}"></i>${arrivalTime.fieldDesc}</a></dd>
                   </#list>
                </dl>
            </div> <!-- //search_kind -->
           
           
            <div class="search_kind f_airport_company">
                <dl class="clearfix js_fuxuan">
                    <dt>航空公司</dt>
                    <dd class="kind_buxian" codetype="carriers" code="ALL"><a class="search_arrow_1" href="javascript:;" codetype="carriers" code="ALL">不限</a></dd>
                     <#list cnf as carrierName>
                     
                    	<dd id="carrierName" codetype="carriers" code="${carrierName.fieldValue}"><a href="javascript:;" codetype="carriers" code="${carrierName.fieldValue}" class="screen_condition"><i class="ph_icon hotel_ck" codetype="carriers" code="${carrierName.fieldValue}"></i>${carrierName.fieldDesc}</a>
                    </#list>
                </dl>
                <#if namesize gt 8>
                	 <a class="search_gd js_moreSearch">更多<i class="arrow"></i></a>
                </#if>
            </div><!-- //search_kind -->
            
            <#if deptAirports ?? && deptAirports?size gt 1>
            <div class="search_kind f_dept_airport">
                <dl class="clearfix js_fuxuan">
                    <dt>起飞机场</dt>
                    <dd class="kind_buxian" codetype="departAirports" code="ALL"><a class="search_arrow_1" href="javascript:;" codetype="departAirports" code="ALL">不限</a></dd>
                    <#list deptAirports as item>
                    	<dd id="departAirport" codetype="departAirports" code="${item.fieldValue}">
                    	<a href="javascript:;" codetype="departAirports" code="${item.fieldValue}"  class="screen_condition"><i class="ph_icon hotel_ck"  codetype="departAirports" code="${item.fieldValue}"></i>${item.fieldDesc}</a>
                    	</dd>
					</#list>
                </dl>
            </div>
            </#if>
            <#if arriAirports ?? && arriAirports?size gt 1>
            <div class="search_kind f_arri_airport">
                <dl class="clearfix js_fuxuan">
                    <dt>降落机场</dt>
                    <dd class="kind_buxian" codetype="arriveAirports" code="ALL"><a class="search_arrow_1" href="javascript:;" codetype="arriveAirports" code="ALL">不限</a></dd>
                    <#list arriAirports as item>
                    	<dd id="arriveAirport" codetype="arriveAirports" code="${item.fieldValue}">
                    	<a href="javascript:;" codetype="arriveAirports" code="${item.fieldValue}"  class="screen_condition"><i class="ph_icon hotel_ck"  codetype="arriveAirports" code="${item.fieldValue}"></i>${item.fieldDesc}</a>
                    	</dd>
					</#list>
                </dl>
            </div>
            </#if>
			
            <div class="request clearfix">
                <p class="result c9"><dfn class="f16 cf60 bold pr5" id="search_flight_size_show">${size}</dfn>条航班</p>
                <dl class="request_list">
                    <dt>您已选择：</dt>
                </dl>
            </div><!-- //request -->
        </div><!-- //filter 筛选结束-->
          
        <!-- 产品部分 -->
        <div class="fh-product clearfix" id="div-fh-product">
         	
             <#if results?? && results?size gt 0 >
                <div class="flight-list">
			            <!-- 机票列表头部 -->
	                <div class="flight-title clearfix">
	                    <div class="flight-col flight-info">航班信息</div>
                		<div class="flight-col flight-time"><a id="sort_departuretime" title="按起飞时间 从早到晚排序" onclick="sortFunction(this)"  href="javascript:;">起飞时间<em id="sorttimeId" class="sort_up"></em></a></div>
	                    <div class="flight-col flight-stop"></div>
	                    <div class="flight-col flight-time flight-arrival-time">到达时间</div>
	                    <div class="flight-col flight-duration">飞行时长</div>
	                    <div class="flight-col flight-type">舱位</div>
	                    <div class="flight-col flight-diff"><a class="active" id="sort_price" onclick="sortFunction(this)" title="按差价由低到高排序" href="javascript:;">差价<em id="sortpriceId" class="sort_up"></em></a></div>
	                </div><!-- //flight-title -->
	             <#list results as flo>
	              	<!-- 机票列表 -->
			              	<#if flo.seats??&&flo.seats?size gt 1>
			                <div class="flight-detail clearfix">
			                <#else>
			                <!-- 没有 更多舱位时 加 flight-detail-all -->
			                <div class="flight-detail flight-detail-all clearfix">
			                </#if>
			                    <div class="flight-col flight-info">
			                    	
			                        <div class="flight-top">
			                        	<i class="fh-icon-ac fh-icon-ac-${flo.carrierCode}"></i>
			                       			 ${flo.carrierName}
			                        </div>
			                        <!-- TODO 机型信息填在对应的data属性中 -->
			                        <div class="flight-bottom"><span class="flight-number">${flo.flightNo}</span><span class="plane-type" data-plan="${flo.airplane.code}" data-name="${flo.airplane.name}" data-type="${flo.airplane.airplaneType}" data-min="${flo.airplane.minSeats}" data-max="${flo.airplane.maxSeats}">${flo.airplane.code}</span></div>
			                    </div>
			                    <div class="flight-col flight-time">
			                        <div class="flight-top">${flo.departureTime}</div>
			                        <div class="flight-bottom"><a class="airport-name" href="javascript:;" title="${flo.departureAirportName}">${flo.departureAirportName}</a><span>${flo.departureTermainalBuilding}</span></div>
			                    </div>
			                    <div class="flight-col flight-stop">
				                     <#if flo.stopCount==0>
				                    	<p class="flight-stop-text"></p>
				                    	<#else>
				                    	  <!-- TODO 没有经停时，删除“经停”两字，切勿删除P标签 -->
				                        <p class="flight-stop-text">经停</p>
				                    </#if>
			                        <div class="fh-icon-stop"></div>
			                    </div>
			                    <div class="flight-col flight-time flight-arrival-time">
			                    
			                        <div class="flight-top"><span class="time">${flo.arrivalTime}</span>
			                     
                        			<#if flo.highLightFlag>
                        				<span class="flight-add-one-day" tip-content="航班到达日期为起飞日期<span class='tip-add-one'>+1天</span>。">+1</span>
                        			<#else>
			                        	<span class="flight-add-one-day" tip-content="航班到达日期为起飞日期<span class='tip-add-one'>+1天</span>。"></span>
			                         </#if>
			                        </div>
			                        
			                        <div class="flight-bottom"><a class="airport-name" href="javascript:;" title="${flo.arrivalAirportName}">${flo.arrivalAirportName}</a><span>${flo.arrivalTerminalBuilding}</span></div>
			                    </div>
			                    <div class="flight-col flight-duration">
			                        <div class="flight-center">${flo.flyTime}</div>
			                    </div>
			                   
			                    <!--新版舱位展示----开始-->
			                    <div class="flight-type-list">
			                        <ul>
			                        <#list flo.seats as seatInfo>
			                        	<li class="clearfix" style="display:${(seatInfo_index == 0)?string("block;","none;")}" <#if seatInfo.selectFlag==true>id="selectSeat"</#if>>
			                                <div class="flight-col flight-type">
			                                    <div class="flight-center">
			                                    	<em code=${seatInfo.seatClassCode} pricepolicyid="${seatInfo.pricePolicyId}"><span class="flight-class">${seatInfo.seatClassTypeName}</span></em>
			                                        <#if seatInfo.inventoryCount lte 9>
				                                	  <span class="flight-ticket-amount">剩余${seatInfo.inventoryCount}</span>
				                                	<#else>
				                                		<span class="flight-ticket-amount" style="display:none;"></span>
				                                	</#if>
			                                    </div>
			                                </div>
			                                
			                                <#if seatInfo.differentPrice lt 0>
			                                	<div class="flight-col flight-diff flight-diff-minus" id="flight-price">
		                        	 				<!--<span class="scl-diff">-<i class="price-rmb">¥</i>${seatInfo.differentPrice*-1}</span>-->
		                        	 				<div class="flight-center"><em>-</em><i class="price-rmb">¥</i>${seatInfo.differentPrice*-1}</div>
		                        	 			</div>
		            						<#else>
			            						<div class="flight-col flight-diff" id="flight-price">
			            							<div class="flight-center"><em>+</em><i class="price-rmb">¥</i>${seatInfo.differentPrice}</div>
			            							<!--<span class="scl-diff">+<i class="price-rmb">¥</i>${seatInfo.differentPrice}</span>-->
			            						</div>
		        							</#if>
			                                
			                                <#if seatInfo.selectFlag==true>
			                                <a href="javascript:void(0);" class="fh-selected">已选<i class="icon icon-selected"></i></a>
			                                <#else>
			                                <a href="javascript:void(0);" class="btn btn-sm btn-orange fh-select-btn">选择</a>
			                                </#if>
			                                <input type="hidden" id="flightNo"  value="${flo.flightNo}" >
			                            </li>
			                        </#list>
			                        </ul>
			                        <a class="more-type-btn" href="javascript:;">更多舱位<i class="arrow"></i></a>
			                    </div>
			                    <!--新版舱位展示----结束-->
			           </div>
	              </#list>
	              </div><!-- //flight-list -->
           		<#else><!--搜索有结果的if想对应-->
        		
             	<!-- 搜索无结果 -->
		            <div class="fh-no-result clearfix">
		                <i></i>
		                <div class="fh-nr-text">
		                    <p class="sorry">非常抱歉，没有找到符合您条件的航班</p>
		                    <p class="suggestion">建议您适当减少已选择的条件或 <a href="javascript:;" id="reload">取消条件重新搜索</a></p>
		                </div>
		            </div>
               </#if>
               
               
            </div>     
    </div><!-- //banWrap结束 -->

    <!-- 查看机型 -->
    <div class="plane-info">
        <div class="plane-info-title">
            <span class="pi-plan">计划机型</span>
            <span class="pi-name">机型名称</span>
            <span class="pi-type">类型</span>
            <span class="pi-min">最少座位数</span>
            <span class="pi-max">最多座位数</span>
        </div>
        <div class="plane-info-detail">
            <span class="pi-plan"></span>
            <span class="pi-name"></span>
            <span class="pi-type"></span>
            <span class="pi-min"></span>
            <span class="pi-max"></span>
        </div>
    </div><!-- //plane-info结束 -->

    <!-- 正在加载弹层 START-->
    <div class="fh-overlay"></div>
    <div class="fh-dialog-loading">
        <div class="fh-dialog-inner clearfix">
            <div class="fh-dialog-body">
                <p>驴妈妈拼命加载中，请稍后...</p>
            </div>
        </div>
    </div>
    <div class="resortOverlay"></div>
    <!-- 正在加载弹层 END-->
	<div class="returnAlert">
        <a href="javascript:;" class="ph_icon_closeAlert"></a>
        <div class="prompt">提示</div>
        <div class="sorryWarp">
            <div class="sorryImg"></div>
            <p id ='errorMsgOutTime'>该机票在您所选的日期已内售完，请返回重新查询</p>
        </div>
        <div class="sorryBtn">
        	<input id="reloadUrl" type="hidden" value="111111"/>
            <a href="javascript:;" class="fh-return-btn">重新查询</a>
        </div>
    </div>
    <script src="http://pic.lvmama.com/min/index.php?f=/js/new_v/jquery-1.7.2.min.js,/js/v6/header_new.js,/js/v5/modules/pandora-poptip.js,/js/common/losc.js"></script>
    <script src="http://pic.lvmama.com/min/index.php?f=/js/fit/v3/select-flight.js,/js/v6/flighthotel/fh-flight-tip.js"></script>
	<script src="${request.contextPath}/js/common/common.js"></script>
    <script>
    $(function(){
     initSeat();
	var uuid = "${shoppingUuid}";
    var errorMsgOutTime = "${errorMsgOutTime}";
    if(errorMsgOutTime!=''){
    	var searchCondition = window.localStorage.getItem('searchCondition');
	  	if(searchCondition != null && searchCondition != ''){
    		var tripType = searchCondition.split('|')[0];
    		var departureCityCode = searchCondition.split('|')[1];
    		var arrivalCityCode = searchCondition.split('|')[2];
    		var cityCode = searchCondition.split('|')[3];
    		var flightStartDate = searchCondition.split('|')[4];
    		var flightEndDate = searchCondition.split('|')[5];
    		var hotelStartDate = searchCondition.split('|')[6];
    		var hotelEndDate = searchCondition.split('|')[7];
    		var adultsCount = searchCondition.split('|')[8];
    		var childCount = searchCondition.split('|')[9];
    	}
    	$(".returnAlert").show();
		$('.resortOverlay').stop(true,true).show();
		$("#errorMsgOutTime").html(errorMsgOutTime);
    	var reloadUrl = "${request.contextPath}/search/"+uuid+"?tripType="+tripType+"&departureCityCode="+departureCityCode+"&arrivalCityCode="+arrivalCityCode+"&departureTime="+flightStartDate+"&returnTime="+flightEndDate+"&cityCode="+cityCode+"&checkInTime="+hotelStartDate+"&checkOutTime="+hotelEndDate+"&adultsCount="+adultsCount+"&childCount="+childCount;
    	$('#reloadUrl').val(reloadUrl);
    }
	});
    
    //
    var query = {}
    query.uuid = "${uuid}";
    query.method = "${method}";
    query.init="false";
    query.carriers="${carriers}";
    query.departureTimeSegments="${departureTimeSegments}";
    query.arrivalTimeSegments="${arrivalTimeSegments}";
    query.departAirports="ALL";
    query.arriveAirports="ALL";
    query.sortByDepartureTimeDate="${sortByDepartureTimeDate}";
    query.sortByDiffPrice="${sortByDiffPrice}";
    query.asc="${asc}";
    
    function search(){
    		var url="${request.contextPath}/search/flight";
    		for(var key in query){
				url+="/"+query[key];
    		}
    		$(".fh-overlay, .fh-dialog-loading").show();
    		$.ajax({
    			url : url,
    			cache : false,
    			async : true,
    			type : "POST",
    			datatype : "json",
    			success: function(result){
    				$(".fh-overlay, .fh-dialog-loading").hide();
    				if('${errorMsgOutTime}'!=''){
	    				var searchCondition = window.localStorage.getItem('searchCondition');
					  	if(searchCondition != null && searchCondition != ''){
				    		var tripType = searchCondition.split('|')[0];
				    		var departureCityCode = searchCondition.split('|')[1];
				    		var arrivalCityCode = searchCondition.split('|')[2];
				    		var cityCode = searchCondition.split('|')[3];
				    		var flightStartDate = searchCondition.split('|')[4];
				    		var flightEndDate = searchCondition.split('|')[5];
				    		var hotelStartDate = searchCondition.split('|')[6];
				    		var hotelEndDate = searchCondition.split('|')[7];
				    		var adultsCount = searchCondition.split('|')[8];
				    		var childCount = searchCondition.split('|')[9];
				    	}
				    	$(".returnAlert").show();
		    			$('.resortOverlay').stop(true,true).show();
		    			$("#errorMsgOutTime").html(${errorMsgOutTime});
				    	var reloadUrl = "${request.contextPath}/search/"+query.uuid+"?tripType="+tripType+"&departureCityCode="+departureCityCode+"&arrivalCityCode="+arrivalCityCode+"&departureTime="+flightStartDate+"&returnTime="+flightEndDate+"&cityCode="+cityCode+"&checkInTime="+hotelStartDate+"&checkOutTime="+hotelEndDate+"&adultsCount="+adultsCount+"&childCount="+childCount;
				    	$('#reloadUrl').val(reloadUrl);
    				}else{
	    				$("#div-fh-product").html(result);
	    				var length = $("#search_flight_size").val();
	    				$("#search_flight_size_show").html(length);
    				}
       			}
    	    });
    }
    
    function listShow(){
	    	var listShow=""
	    	var last = "<dd><a class='close_all' href='javascript:closeAll();'>清除所有条件</a></dd>";
	    	if(query.departureTimeSegments!="ALL"
	    		||query.arrivalTimeSegments!="ALL"
	    		||query.departAirports!="ALL"
	    		||query.arriveAirports!="ALL"
	    		||query.carriers!="ALL"){
	    		listShow = "<dt>您已选择：</dt>";
	    	}
    		
	    	var $html_f_start = $('.f_start').find("dd");
			for(var i=0;i<$html_f_start.length;i++){
				var $f_start_eq = $html_f_start.eq(i);
				var code = $.trim($f_start_eq.attr("code"));
				if(query.departureTimeSegments.indexOf(code)!=-1){
					if(query.departureTimeSegments!="ALL"){
			    		listShow+="<dd><span>"+$f_start_eq.find("a").text()+"起飞<a  code=\""+code+"\" codetype='departureTimeSegments' class='request_close' href='javascript:;' onclick='requestClose(this)' title='删除'>×</a></span></dd>";
			    		$f_start_eq.addClass("active");
					}else{
						$f_start_eq.addClass("active");
					}
				}
				if(i==0){
		    		$html_f_start.eq(0).addClass("kind_buxian");
				}
			}
			
			var $html_f_reach = $('.f_reach').find("dd");
			for(var i=0;i<$html_f_reach.length;i++){
				var $f_reach_eq = $html_f_reach.eq(i);
				var code = $.trim($f_reach_eq.attr("code"));
				if(query.arrivalTimeSegments.indexOf(code)!=-1){
		    		if(query.arrivalTimeSegments!="ALL"){
			    		listShow+="<dd><span>"+$f_reach_eq.find("a").text()+"到达<a code='"+code+"' codetype='arrivalTimeSegments'  class='request_close' href='javascript:;' onclick=\"requestClose(this)\" title='删除'>×</a></span></dd>";
			    		$f_reach_eq.addClass("active");
		    		}else{
		    			$f_reach_eq.addClass("active")
					}
				}
				$html_f_reach.eq(0).addClass("kind_buxian");
			}
			
			var $html_airport_company = $('.f_airport_company').find("dd");
			for(var i=0;i<$html_airport_company.length;i++){
				var $airport_company_eq = $html_airport_company.eq(i);
				var code = $.trim($airport_company_eq.attr("code"));
				if(query.carriers.indexOf(code)!=-1){
		    		if(query.carriers!="ALL"){
			    		listShow+="<dd><span>"+$airport_company_eq.find("a").text()+"<a code='"+code+"' codetype='carriers'  class='request_close' href='javascript:' onclick=\"requestClose(this)\" title='删除'>×</a></span></dd>";
			    		$airport_company_eq.addClass("active");
		    		}else{
		    			$airport_company_eq.addClass("active");
					}
				}
			}
			
			var $html_dept_airport = $('.f_dept_airport').find("dd");
			$html_dept_airport.each(function(i){
				var code = $(this).attr("code");
				if(query.departAirports.indexOf(code)!=-1){
		    		if(query.departAirports!="ALL"){
			    		listShow+="<dd><span>"+$(this).find("a").text()+"<a code='"+code+"' codetype='departAirports'  class='request_close' href='javascript:' onclick=\"requestClose(this)\" title='删除'>×</a></span></dd>";
			    		$(this).addClass("active");
		    		}else{
		    			$(this).addClass("active");
					}
				}
			});
			var $html_arri_airport = $('.f_arri_airport').find("dd");
			$html_arri_airport.each(function(i){
				var code = $(this).attr("code");
				if(query.arriveAirports.indexOf(code)!=-1){
		    		if(query.arriveAirports!="ALL"){
			    		listShow+="<dd><span>"+$(this).find("a").text()+"<a code='"+code+"' codetype='arriveAirports'  class='request_close' href='javascript:' onclick=\"requestClose(this)\" title='删除'>×</a></span></dd>";
			    		$(this).addClass("active");
		    		}else{
		    			$(this).addClass("active");
					}
				}
			});
			
			$(".filter .search_kind").each(function(){
				$(this).find("dd").eq(0).addClass("kind_buxian");
			});
			
	    	if(listShow == null || listShow == ""){
	    		$(".request_list").html(listShow);  
	    	}else{
	    		$(".request_list").html(listShow+last);      
	    	}
			
    }
    
    
    $(function() {
    	
		listShow();
    	
    	//排序
    	var tpclass = query.asc;
   
    	if(tpclass!=null && tpclass!=""){
    		$("#priceId").attr("class",tpclass);
    		$("#timeId").attr("class",tpclass);
    		
    	}
    	if(tpclass=="desc"){
    		if(query.sortByDiffPrice == "true"){
    			$("#sortpriceId").attr("class","sort_down");
    			$("#sort_price").attr("title","按差价由高到低排序");
    		}
    		if(query.sortByDepartureTimeDate == "true"){
    			$("#sorttimeId").attr("class","sort_down");
    			$("#sort_departuretime").attr("title","按起飞时间 从晚到早排序");
    		}
			
    	}
		//去除加title后最后一行显示有线的问题
		$(".flight-detail").last().addClass("flight-detail-last")
		
		//过滤条件去掉最后一行显示有线的问题
		$(".filter .search_kind").last().addClass("nobd");
		
        // 更换舱位
        $("#div-fh-product").on("click",".select-class-list li", function(e) {
        	var event = e || window.event;
            event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);

            // TODO 更换舱位后的操作
            var $this = $(this);
            var $parent = $(this).parent();
            if($this.children('a').eq(0).html()==$parent.siblings(".select-class").find('em').html()){}else{
                $(this).parents(".flight-type").siblings('a').html("选择").attr("class","fh-select-btn");
            }
            $this.addClass('active').siblings().removeClass('active');
            $parent.siblings(".select-class").find("em").html($this.find(".scl-class").html());
            if($this.find(".scl-remain").html()==null){
            	$parent.siblings(".flight-ticket-amount").attr("style","display: none;");
            }else{
            	$parent.siblings(".flight-ticket-amount").attr("style","");
            }
            $parent.siblings(".flight-ticket-amount").html($this.find(".scl-remain").html());
            
           	$parent.siblings(".select-class").find("em").attr("code",$this.find(".scl-class").attr("code"));
           	$parent.siblings(".select-class").find("em").attr("pricepolicyid",$this.find(".scl-class").attr("pricepolicyid"));
           	$parent.siblings(".select-class").find("em").val($this.find(".scl-class").val());
           	
            $this.parents(".flight-detail").find(".flight-diff .flight-center").html($this.find(".scl-diff").html());
            $parent.hide();
        });

         //点不限取消条件，重新查询
         $('.search_kind').click(function(e){
         	if(!$(e.target).attr("codetype")){
         		return;
         	}
         	
         	if(query[$(e.target).attr("codetype")] == $(e.target).attr("code")
         		&&$(e.target).attr("code")=='ALL'){
         		return;
         	}
			
			var queryStr = "";
			
         	$('.search_kind').find("dd").each(function(){
         	
				if($(this).attr("codetype") == $(e.target).attr("codetype")){
					
					if($(this).attr("code") == $(e.target).attr("code")){
						if($(this).attr("code") == "ALL"){
							query[$(e.target).attr("codetype")]="ALL";
							$(this).attr("class","active");
						}else{
							$(this).attr("class","active");
						}
					}else{
						if($(this).attr("code") == "ALL"){
							$(this).attr("class","kind_buxian");
						}else{
							if(query[$(e.target).attr("codetype")].indexOf($(this).attr("code"))==-1){
								$(this).attr("class","");
							}
						}
					}
					
					if(query[$(e.target).attr("codetype")].indexOf($(e.target).attr("code"))>-1){
				
						if($(this).attr("code") == $(e.target).attr("code")){
							$(this).attr("class","");
						}
						if(query[$(e.target).attr("codetype")] == $(e.target).attr("code")){
							if($(this).attr("code") == "ALL"){
								$(this).attr("class","active");
							}
						}
					}
					
					if($(this).attr("class")=="active"){
						queryStr+=((queryStr=="")?"":",")+$(this).attr("code");				
					}
				}
				
         	});
			
         	if(query[$(e.target).attr("codetype")] == $(e.target).attr("code")){
         		query[$(e.target).attr("codetype")] = 'ALL';
         	}else{
				query[$(e.target).attr("codetype")] = queryStr;
			}
			
			listShow();
    		search();
		  });
    
        //点选择之后
        $(".fh-select-btn").die().live("click",function(e){
	     	var code =$(this).parent().find('em').attr('code');
	     	 var policyid = $(this).parent().find('em').attr('pricepolicyid');
	     	 var flightNo = $(this).parent().find("input").attr("value");
	     	 var flightuuid = query.uuid+"_flight";
	     	 var fid = $(this).parent().find("input").attr("fid");
	     	 var flightType = "${method}";
	     	 $.ajax({
	                type: "post",
	                async: false,
	                dataType: "json",
	                url: "${request.contextPath}/shopping/changeflight",
	                data: {
	                	seatCode:code,
	                	policyId:policyid,
	                	flightNo:flightNo,
	                	flightUUID:flightuuid,
	                	shoppingUUID:query.uuid,
        	  			flightType:flightType
	                },
	                success: function(obj) {
	                	if(obj.isSuccess){
	            	     	window.location.href="${request.contextPath}/search/backToShopping?shoppingUUID="+query.uuid;
	                	}
	                },
	                error:function(obj)
				  {
				  	var searchCondition = window.localStorage.getItem('searchCondition');
				  	if(searchCondition != null && searchCondition != ''){
			    		var tripType = searchCondition.split('|')[0];
			    		var departureCityCode = searchCondition.split('|')[1];
			    		var arrivalCityCode = searchCondition.split('|')[2];
			    		var cityCode = searchCondition.split('|')[3];
			    		var flightStartDate = searchCondition.split('|')[4];
			    		var flightEndDate = searchCondition.split('|')[5];
			    		var hotelStartDate = searchCondition.split('|')[6];
			    		var hotelEndDate = searchCondition.split('|')[7];
			    		var adultsCount = searchCondition.split('|')[8];
			    		var childCount = searchCondition.split('|')[9];
			    	}
			    	$(".returnAlert").show();
	    			$('.resortOverlay').stop(true,true).show();
	    			$("#errorMsgOutTime").html(eval('(' + obj.responseText + ')').message);
			    	var reloadUrl = "${request.contextPath}/search/"+query.uuid+"?tripType="+tripType+"&departureCityCode="+departureCityCode+"&arrivalCityCode="+arrivalCityCode+"&departureTime="+flightStartDate+"&returnTime="+flightEndDate+"&cityCode="+cityCode+"&checkInTime="+hotelStartDate+"&checkOutTime="+hotelEndDate+"&adultsCount="+adultsCount+"&childCount="+childCount;
			    	$('#reloadUrl').val(reloadUrl);
				  }
	            });
	   	});

	   	//点已选之后
	   	$(".fh-selected").die().live("click",function(e){
			var path="${request.contextPath}/search/backToShopping?shoppingUUID="+query.uuid;
			window.location.href = path;
  	
	   	});
		
    	//点击返回上一页
    	$(".btn-text").die().live("click",function(e){
			var path="${request.contextPath}/search/backToShopping?shoppingUUID="+query.uuid;
			window.location.href = path;
    	});
    	
    	//取消条件重新搜索
    	$("#reload").click(function(){
    		
    		$(".request_list").html("");
			var c = $(".active");
			for(var i=0; i<c.length;i++){
				c.eq(i).attr("class","");
			}
         	var d = $(".kind_buxian");
         	for(var j=0;j<d.length;j++){
         		d.eq(j).attr("class","active");
         	}
         	
         	query.carriers = "ALL";
         	query.departureTimeSegments="ALL";
    		query.arrivalTimeSegments="ALL";
         	listShow();
         	search();
	    		
	    });
	    
    });
    $(function(){
    	var from = '${fdf.departureCityName}';
    	var dest = '${fdf.arrivalCityName}';
    	var hotel = '${hotelName}';
    	  seoJustice(from,dest,hotel,'seotdk_fit_freetour','${request.contextPath}');
    	});
	    //已选择条件上的取消所有条件
	    function closeAll(){
	    	$(".request_list").html("");
			var f = $(".active");
			for(var i=0; i<f.length;i++){
				f.eq(i).attr("class","");
			}
         	var g = $(".kind_buxian");
         	for(var j=0;j<g.length;j++){
         		g.eq(j).attr("class","active");
         	}
         	
         	query.carriers = "ALL";
         	query.departureTimeSegments="ALL";
    		query.arrivalTimeSegments="ALL";
    		query.departAirports="ALL";
    		query.arriveAirports="ALL";
    		$(".filter .search_kind").each(function(){
				$(this).find("dd").eq(0).addClass("active kind_buxian");
			});
         	search();
	    }
	    
	    //条件筛选 request_close
	    function requestClose(that){
	    	var codetype = $(that).attr("codetype");
	    	var code = $(that).attr("code");
	    	var queryStr = "";
         	$('.search_kind').find("dd").each(function(){
         		var codeTypeClear = $(this).attr("codetype");
         		var codeClear = $(this).attr("code");
				if( codeTypeClear == codetype){
					if(codeClear == code){
						$(this).attr("class","");
					}else{
						if($(this).attr("class")=="active"){
							queryStr+=((queryStr=="")?"":",")+$(this).attr("code");				
						}
					}
				}
         	});
	    	if("" == $.trim(queryStr)){
	    		queryStr = "ALL";
	    	}
	    	switch (codetype) {
			case "departureTimeSegments":
				query.departureTimeSegments = queryStr;
				break;
			case "arrivalTimeSegments":
				query.arrivalTimeSegments = queryStr;
				break;
			case "carriers":
				query.carriers = queryStr;
				break;
			case "departAirports":
				query.departAirports = queryStr;
				break;
			case "arriveAirports":
				query.arriveAirports = queryStr;
				break;
			default:
				break;
			}
	    	
	    	var $dd = $(that).parents("dd");
	    	var length = $dd.parent().find("dd").length;
	    	if(length === 2){
	    		$dd.parent().empty();
	    	}else{
	    		$dd.remove();
	    	}
	    	listShow();
         	search();
	    }
	    
	  	//点击起飞时间和差价 排序 
    	function sortFunction (that){
			var sort = $(that).find("em").attr("class");
			var id = $(that).attr("id");
			if("sort_departuretime" == id){
				query.sortByDepartureTimeDate="true";
				query.sortByDiffPrice="false";
			}else if("sort_price" == id){
				query.sortByDepartureTimeDate="false";
				query.sortByDiffPrice="true";
			}
			 query.asc= "sort_up"==sort?"desc":"asc";
         	 search();
         	 //排序
    	var tpclass = query.asc;
   
    	if(tpclass!=null && tpclass!=""){
    		$("#priceId").attr("class",tpclass);
    		$("#timeId").attr("class",tpclass);
    		
    	}
    	if(tpclass=="desc"){
    		if(query.sortByDiffPrice == "true"){
    			$("#sortpriceId").attr("class","sort_down");
    			$("#sort_price").attr("title","按差价由高到低排序");
    		}
    		if(query.sortByDepartureTimeDate == "true"){
    			$("#sorttimeId").attr("class","sort_down");
    			$("#sort_departuretime").attr("title","按起飞时间 从晚到早排序");
    		}
    	}
	
    	};
    	
    	$('.fh-return-btn').click(function(){
		    $('.returnAlert').stop(true,true).fadeOut();
		    $('.resortOverlay').stop(true,true).fadeOut();
		    $('body').removeAttr('style');
		    var url = $('#reloadUrl').val();
		    window.location.href=url;
		});
		
		$('.ph_icon_closeAlert').click(function(){
			$('.returnAlert').stop(true,true).fadeOut();
		    $('.resortOverlay').stop(true,true).fadeOut();
		    $('body').removeAttr('style');
		    var url = $('#reloadUrl').val();
		    window.location.href=url;
		})
		//排序之后不能更换仓位的临时处理方法---开始
    	$(".select-class").on("click", function(e) {
		var event = e || window.event;
		event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
		$(".select-class-list").hide();
		var $this = $(this);
		var thisL = $this.offset().left,
			thisT = $this.offset().top,
			thisH = $this.outerHeight(true);
		$this.siblings(".select-class-list").show().css({
			'left': thisL,
			'top': thisT + thisH + 2
		});
		});
		//排序之后不能更换仓位的临时处理方法---结束
		
		function initSeat(){
	     var firstLi = $("#selectSeat").parent().children().eq(0);
	     var firstLi_code=firstLi.find('em').attr('code');
	     var firstLi_pricepolicyid=firstLi.find('em').attr('pricepolicyid');
	     var selectLi_code =$("#selectSeat").find('em').attr('code');
	     var selectLi_pricepolicyid=$("#selectSeat").find('em').attr('pricepolicyid');
	     if(firstLi_code==selectLi_code&&firstLi_pricepolicyid==selectLi_pricepolicyid){
	     	return;
	     }
	   	 $("#selectSeat").insertBefore(firstLi);
	   	 $("#selectSeat").show();
	   	 firstLi.hide();
	    }
    </script>
    <#if isBackBooking=='true'>
       <#else>
	       <#include "online_foot.ftl">
     </#if>
</body>

</html>
