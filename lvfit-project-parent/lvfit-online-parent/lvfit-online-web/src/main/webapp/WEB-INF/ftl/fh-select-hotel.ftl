<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" >
<meta name="mobile-agent" content="format=html5; url=http://m.lvmama.com/">
<link rel="dns-prefetch" href="//s1.lvjs.com.cn">
<link rel="dns-prefetch" href="//s2.lvjs.com.cn">
<link rel="dns-prefetch" href="//s3.lvjs.com.cn">
<link rel="shortcut icon" href="http://www.lvmama.com/favicon.ico" type="image/x-icon"> 
<title id="TITLE"></title>
<meta name="description" id="DESC" content="">
<meta name="keywords" id="KEYWORDS" content="">
<link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v6/header_new.css,/styles/v6/public/base.css,/styles/v5/modules/paging.css,/styles/lv/buttons.css">
<link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v6/flighthotel/fh-result-loading.css,/styles/fit/v3/select-hotel.css">
<link rel="stylesheet" href="${request.contextPath}/css/fh-select.css">
<style type="text/css">
.bigImg,.smallImg{
	height:303px;
	width:auto;
	margin-left:-20%;
	*margin-left:-33%;
}
.smallImg{
	height:66px;
}
.hotelInfo-pic{
	overflow:hidden;
}
</style>
</head>
<body class="fh-select-hotel flight_fit">
	<!-- 流量埋点 -->
    <script src="http://pic.lvmama.com/min/index.php?f=/js/v5/ibm/eluminate.js"></script>
    <script src="http://pic.lvmama.com/min/index.php?f=/js/v5/ibm/coremetrics-initalize.js"></script>
    <script>_LVMAMA_COREMETRICS.init(document.domain);</script>
    <script>
        cmCreatePageviewTag("机酒频道首页_<fh-select-hotel>", "FlightHotel", null, null,"-_--_--_--_--_-路径页面");
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
    
	<div class="body_bg">
		<div class="wrap pt60">
			<!-- filter 筛选开始-->
			<div class="filter bd_ddd">
				
				<div class="filter-head yh f18 c9">                  
					<a href="javascript:;" onclick="goBack()" class="btn btn-pink btn-lg fr"><span class="btn-text">返回上一页</span></a>更换酒店：<span class="c3 pl10">${rzcs}<i class="plr15"><dfn class="arial f16">${rzrq}</dfn>&nbsp;至&nbsp;<dfn class="arial f16">${fcrq}</dfn></i></span><dfn class="arial f16">${rzfw}</dfn>晚
				</div>
				<#if landmarkMap?exists>
				<div class="search_kind search_kind_hotel"><!--酒店商圈开始-->
	            	<dl class="clearfix js_fuxuan">
	                	<dt id="jdsq">酒店位置</dt>
	                    <dd id="jdsqall" class="kind_buxian"><a code='ALL' codetype="L" class="search_arrow_1" href="javascript:;">不限</a></dd>
	                    <#if landmark?? && landmark?size gt 0>
	                    	<dd class="kind_hotel_location"><span>地标<b class="searchArrow"></b></span></dd>
	                    </#if>
	                    <#if trainStation?? && trainStation?size gt 0>
	                    	<dd class="kind_hotel_location"><span>火车站<b class="searchArrow"></b></span></dd>
	                    </#if>
	                    <#if metroStation?? && metroStation?size gt 0>
	                    	<dd class="kind_hotel_location kind_hl_metro"><span>地铁站<b class="searchArrow"></b></span></dd>
	                    </#if>
	                    <#if longBusStation?? && longBusStation?size gt 0>
	                    	<dd class="kind_hotel_location"><span>长途汽车站<b class="searchArrow"></b></span></dd>
	                    </#if>
	                    <#if spots?? && spots?size gt 0>
	                    	<dd class="kind_hotel_location"><span>景点/景区<b class="searchArrow"></b></span></dd>
	                    </#if>
	                    <#if airPorts?? && airPorts?size gt 0>
	                    	<dd class="kind_hotel_location"><span>飞机场<b class="searchArrow"></b></span></dd>
	                    </#if>
	                    <#if businesses?? && businesses?size gt 0>
	                    	<dd class="kind_hotel_location"><span>商圈<b class="searchArrow"></b></span></dd>
	                    </#if>
	                </dl>
		                <div class="search_subCon">
		                	<!-- 地铁选项卡 -->
		                	<#if metroStation?exists>
	                    	<div class="metro">
		                    	<ul class="clearfix">
		                    		<#assign metrototal=0>
		                    		<#list metroStation?keys as metro>
		                    		<#if metrototal==0>
		                    		<li class="active">
		                    		<#else>
		                    		<li>
		                    		</#if>
		                				<a href="javascript:;">${metro}</a>
		                				<span class="metroTabArrow"><b></b></span>
		                			</li>
		                			<#assign metrototal=metrototal+1>
		                			</#list>
		                		</ul>
		                		<#assign metroCount = 0 />
		                		<#list metroStation?keys as metros>
		                		<#list metroStation[metros] as metro>
		                    	<div class="search_subCon_list search_more" style="display:${(metroCount == 0)?string("block;","none;")}">
		                    		<dd id="${metro.id}"><a code='${metro.id}' codetype="L" href="javascript:;">
		                    		${metro.value}</a></dd>
		                    	</div>
		                    	<#assign metroCount = metroCount + 1 />
		                    	</#list>
		                    	</#list>
	                    </div>
	                    </#if>
	                    <!--地铁选项卡结束-->
	                    <!-- 普通选项卡 -->
	                    <#if landmarkMap?exists>
                    	<div class="subCon_list">
                    		<#if landmark?? && landmark?size gt 0>
                    		<div class="search_subCon_list">
                    		<#list landmark as landmark>
	                			<dd id="${landmark.id}"><a code='${landmark.id}' codetype="L" href="javascript:;">
	                    		${landmark.value}</a></dd>
	                    	</#list>
	                    	</div>
	                    	</#if>
	                    	
	                    	<#if trainStation?? && trainStation?size gt 0>
	                    	<div class="search_subCon_list">
	                    	<#list trainStation as train>
                    		<dd id="${train.id}"><a code='${train.id}' codetype="L" href="javascript:;">
	                    		${train.value}</a></dd>
	                    	</#list>
	                    	</div>
	                    	</#if>
	                    	
	                    	<#if metroStation?? && metroStation?size gt 0>
	                    	<div class="search_subCon_list">
	                    		<!-- 地铁站占用 -->
	                    	</div>
	                    	</#if>
	                    	
	                    	<#if longBusStation?? && longBusStation?size gt 0>
	                    	<div class="search_subCon_list">
	                    	<#list longBusStation as bus>
                			<dd id="${bus.id}"><a code='${bus.id}' codetype="L" href="javascript:;">
                    		${bus.value}</a></dd>
	                    	</#list>
	                    	</div>
	                    	</#if>
	                    	
	                    	<#if spots?? && spots?size gt 0>
	                    	<div class="search_subCon_list">
	                    	<#list spots as spot>
                			<dd id="${spot.id}"><a code='${spot.id}' codetype="L" href="javascript:;">
                    		${spot.value}</a></dd>
	                    	</#list>
	                    	</div>
	                    	</#if>
	                    	
	                    	<#if airPorts?? && airPorts?size gt 0>
	                    	<div class="search_subCon_list">
	                    	<#list airPorts as airPort>
                		    <dd id="${airPort.id}"><a code='${airPort.id}' codetype="L" href="javascript:;">
                    		${airPort.value}</a></dd>
	                    	</#list>
	                    	</div>
	                    	</#if>
	                    	
	                    	<#if businesses?? && businesses?size gt 0>
	                    	<div class="search_subCon_list">
	                    	<#list businesses as business>
                		    <dd id="${business.id}"><a code='${business.id}' codetype="L" href="javascript:;">
                    		${business.value}</a></dd>
	                    	</#list>
	                    	</div>
	                    	</#if>
                    	</div>
                    	</#if>
                    	<!--普通选项卡结束-->
	                </div>
	            </div><!-- //search_kind --><!--酒店商圈结束-->
	            </#if>
				<div class="search_kind"><!--酒店星级开始-->
	            	<dl class="clearfix js_fuxuan">
	                	<dt id="jdxj">酒店星级</dt>
	                	<dd id="jdxjall" class="kind_buxian"><a code='ALL' codetype="R" class="search_arrow_1" href="javascript:;">不限</a></dd>
	                    <#if hotelStar?? && hotelStar?size gt 0>
	                    	<!-- 后台再次筛选时，直接在前面加个R -->
	                    	<#list hotelStar as stars>
	                    		<#if (stars.id==100 || stars.id==101)><dd id="100"><a code='100,101' codetype="R" href="javascript:;"><i class="ph_icon hotel_ck"></i>五星/豪华型</a></dd></#if>
	                    		<#if (stars.id==102 || stars.id==103)><dd id="102"><a code='102,103' codetype="R" href="javascript:;"><i class="ph_icon hotel_ck"></i>四星/高档型</a></dd></#if>
	                    		<#if (stars.id==104 || stars.id==105)><dd id="104"><a code='104,105' codetype="R" href="javascript:;"><i class="ph_icon hotel_ck"></i>三星/舒适型</a></dd></#if>
	                    		<#if (stars.id==106 || stars.id==107)><dd id="106"><a code='106,107' codetype="R" href="javascript:;"><i class="ph_icon hotel_ck"></i>二星/经济型</a></dd></#if>
	                    	</#list>
	                    </#if>
	                </dl>
	            </div><!-- //search_kind --><!--酒店星级结束-->
	            <#if hotelBrand?? && hotelBrand?size gt 0>
	            <div class="search_kind"><!--酒店品牌开始-->
	            	<dl class="clearfix js_fuxuan">
	                	<dt id="jdpp">酒店品牌</dt>
	                    <dd id="jdppall" class="kind_buxian"><a code='ALL' codetype="B" class="search_arrow_1" href="javascript:;">不限</a></dd>
	                    <!--<#if hotelBrand?? && hotelBrand?size gt 0>-->
	                    	<#list hotelBrand as defaultHotel>
	                    		<dd id="${defaultHotel.id}" name="brand"><a code='${defaultHotel.id}' codetype="B" href="javascript:;"><i class="ph_icon hotel_ck"></i>${defaultHotel.value}</a></dd>
	                    	</#list>
	                    <!--</#if>-->
	                    <div id="filterStr" value="C20151215O20151218" show="false">
	                    <!--此处添加更多酒店的按钮-->
	                </dl>
	                <#if moreHotelBrand?? && moreHotelBrand?size gt 0 && moreHotelBrand?size gt 8>
	                <a href="javascript:;" class="search_gd js_more_hotel_brand">更多</a>
	                </#if>
	            </div><!-- //search_kind --><!--酒店品牌结束-->
	            </#if>
	            <div class="search_kind nobd"><!--酒店设施开始-->
	            	<dl class="clearfix js_fuxuan">
	                	<dt id="jdss">酒店设施</dt>
	                    <dd id="jdssall" class="kind_buxian"><a code='ALL' codetype="F" class="search_arrow_1" href="javascript:;">不限</a></dd>
	                    <#if hotelFacilities?? && hotelFacilities?size gt 0 >
	                    	<#list hotelFacilities as hotelFacility>
	                    		<dd id="${hotelFacility.id}"><a code='${hotelFacility.id}' codetype="F" href="javascript:;"><i class="ph_icon hotel_ck"></i>${hotelFacility.value}</a></dd>
	                    	</#list>
	                    </#if>
	                </dl>
	                 <#if hotelFacilities?? && hotelFacilities?size gt 0 && hotelFacilities?size gt 8>
	                 <a class="search_gd js_moreSearch">更多<i class="arrow"></i></a>
	                </#if>
				</div><!-- //search_kind --><!--酒店设施结束-->

	            <div class="request clearfix plr20"><!--已选条件开始-->
	            		<#if hotelLists?size lte 0>
	            		<p class="result c9"><dfn class="f16 cf60 bold pr5">0</dfn>家酒店</p>
	            		<#else>
	            		<p class="result c9"><dfn class="f16 cf60 bold pr5">${pagination.records}</dfn>家酒店</p>
	            		</#if>
	                 <dl class="request_list">
	                    <!--<dt>您已选择：</dt>-->
	                    <!--<dd>
	                        <span>锦江之星<a class="request_close" href="javascript:;" title="删除">×</a></span>
	                    </dd>
	                    <dd>
	                        <span>健身房<a class="request_close" href="javascript:;" title="删除">×</a></span>
	                    </dd>
	                    -->
	                    <!--${yixuan}-->
	                    <!--<dd>
	                        <a class="close_all" href="javascript:;" onclick="qingchuAll()">清除所有条件</a>
	                    </dd>-->
	                </dl>
				</div><!-- //request --><!--已选条件结束-->
			</div><!-- //filter 筛选结束-->
			
			<!-- 排序开始 -->
			<div class="result_sort clearfix mt20"><!-- 排序开始 -->
				<!-- 酒店搜索 -->
				<form class="hotel-search" action="">
					<#if keywords>
					<input id="searchHotel" class="hotel-search-input" type="text" value="${keywords}">
					<#else>
					<input id="searchHotel" class="hotel-search-input input-tip" type="text" value="请输入酒店名称/地标/商圈">
					</#if>
					<a class="hotel-search-btn" href="javascript:;">搜索</a>
				</form>
				<ul class="rank_box">
					<li id="defaultSort"><a href="javascript:;">驴妈妈推荐 </a> </li>
					<#if S=="3"||S=="27">
						<li id="priceSort" title="按价格由低到高排序"> <a href="javascript:;">价格 </a><i class="sort_up"></i></li>
					<#else>
						<li id="priceSort_down" title="按价格由高到低排序"> <a href="javascript:;">价格 </a><i class="sort_down"></i></li>
					</#if>
					<li id="goodCommentSort" class="active" title="按好评率由高到低排序"><a href="javascript:;">好评率 </a><i class="sort_down"></i></li>
				</ul>
			</div><!-- 排序结束 -->

			<!-- 搜索无结果 -->
            <!--无结果模块--开始-->
				 <#if !(hotelLists?? && hotelLists?size gt 0)>
			     	<div class="fh-no-result clearfix">
                		<i></i>
                		<div class="fh-nr-text">
                   		 	<p class="sorry">非常抱歉，没有找到符合您条件的酒店</p>
                   			<p class="suggestion">建议您适当减少已选择的条件或 或<a href="${request.contextPath}/search/hotels/${uuid}/ALL/ALL/ALL/ALL/ALL/1">取消条件重新搜索</a></p>
               			</div>
            		</div>
		         </#if>
         	<!--无结果模块--结束-->	
			
			<!-- 搜索结果开始 listMain-->
			<#if hotelLists?? && hotelLists?size gt 0>
				<#list hotelLists as hotel>
			<div class="listMain mt10 bd_ddd">
				
					<!-- 列表开始 -->
					<div class="list-box"><!--酒店列表开始-->
						<div class="list-t pr"><!--酒店基本信息开始-->
							<a name="${hotel.productId }" href="javascript:;" class="list-t-img pa"><img src="http://pic.lvmama.com${hotel.photoUrl}" width="180" height="120" alt=""></a>
							<h4 class="list-t-tit">
								<a name="${hotel.productId }" href="javascript:" class="yh f20 c3">${hotel.productName}</a>
								<span class="c9 f12">
									<#if hotel.starDesc??>
    									<span class="hotel_type">
    									<#if hotel.starDesc ? ends_with("酒店")>
        								<#assign sublength = hotel.starDesc?index_of("酒店")/>
        									[${hotel.starDesc ? substring(0,sublength)}]
        								<#else>
        									[${hotel.starDesc}]	
    									</#if>
    					   				</span>
    								</#if>
								</span>
							</h4>
						<!--设施-->
						<#if hotel.facilities??><!--酒店设施开始-->	
							<p class="list-icon">
								<#list hotel.facilities?split(',') as facility> 
	        	    			<#if facility=="472">
	        	    			<span class="ph_icon_hotel ph_icon_mr" title="会议室"></span>
	        	    			</#if>
	        	    			<#if facility=="470">
	        	    			<span class="ph_icon_hotel ph_icon_gym" title="健身房"></span>
	        	    			</#if> 
	        	    			<#if facility=="464">
	        	    			<span class="ph_icon_hotel ph_icon_park_f" title="免费停车场"></span>
	        	    			</#if>
	        	    			<#if facility=="460">
	        	    			<span class="ph_icon_hotel ph_icon_wifi_f" title="免费Wifi"></span>
	        	    			</#if>
	        	    			<#if facility=="462">
	        	    			<span class="ph_icon_hotel ph_icon_internet_f" title="免费宽带"></span>
	        	    			</#if>
	        	    			<#if facility=="471">
	        	    			<span class="ph_icon_hotel ph_icon_bc" title="商务中心"></span>
	        	    			</#if>
	        	    			<#if facility=="468">
	        	    			<span class="ph_icon_hotel ph_icon_swim-in" title="室内游泳池"></span>
	        	    			</#if>
	        	    			<#if facility=="461">
	        	    			<span class="ph_icon_hotel ph_icon_wifi_c" title="收费Wifi"></span>
	        	    			</#if>
	        	    			<#if facility=="465">
	        	    			<span class="ph_icon_hotel ph_icon_park_c" title="收费停车场"></span>
	        	    			</#if>
	        	    			<#if facility=="473">
	        	    			<span class="ph_icon_hotel ph_icon_restaurant" title="酒店餐厅"></span>
	        	    			</#if>
	        	    			<#if facility=="463">
	        	    			<span class="ph_icon_hotel ph_icon_internet_c" title="收费宽带"></span>
	        	    			</#if>
	        	    			<#if facility=="466">
	        	    			<span class="ph_icon_hotel ph_icon_pick_f" title="免费接机"></span>
	        	    			</#if>
	        	    			<#if facility=="467">
	        	    			<span class="ph_icon_hotel ph_icon_pick_c" title="收费接机"></span>
	        	    			</#if>
	        	    			<#if facility=="469">
	        	    			<span class="ph_icon_hotel ph_icon_swim-out" title="室外游泳池"></span>
	        	    			</#if>
	        					</#list>
							</p>
						</#if><!--酒店设施结束-->
							<p class="list-info mt10 c9">
								<#if hotel.commentGood?? && hotel.commentGood gt 0>
								<dfn class="cf60 f14 pr5">${hotel.commentGood}%</dfn>好评率来自
								</#if>
								<#if hotel.commentNum?? && hotel.commentNum gt 0>
								<a name="${hotel.productId }" href="javascript:;" class="JS_alertBox c09c">${hotel.commentNum}</a>条点评
								</#if>
							</p>
							<p class="list-address c9 mt10">
								<#if hotel.address??>
									地址：<span class="pl5 c6">${hotel.address}
									</span>
								<a name="${hotel.productId}" class="list-maplink pl5 c09c JS_maplink" href="javascript:;"><span class="ph_icon ph_icon_map"></span>地图</a>
								</#if>
							</p>
						</div><!-- //list-t --><!--酒店基本信息结束-->
	
						<ul class="roomHead roomTable clearfix f12 mt20">
							<li class="roomTable-td roomTable-td1">房型</li>
							<li class="roomTable-td roomTable-td2">床型</li>
							<li class="roomTable-td roomTable-td3">早餐</li>
							<li class="roomTable-td roomTable-td-kd">宽带</li>
							<li class="roomTable-td roomTable-td4">间数</li>
							<li class="roomTable-td roomTable-td5">差价</li>
						</ul>
						
						<#if hotel.rooms?? && hotel.rooms?size gt 0><!--房型开始-->
						<#assign showGoodCount = 0 /><#--默认房型,为了只展示两个-->
						<#list hotel.rooms as room><!--房型列表开始-->
						<#assign showGoodCount = showGoodCount +1 /><#--默认房型-->
						<#if room.plans?? && room.plans?size gt 0>
						<#assign goodDefault = room.plans[0] /><#--默认房型-->
						<div class="room-content" style="display:${(showGoodCount lt 3)?string("block;","none;")}">
						<div class="roomLi clearfix" name="roomDiv">
						<div class="roomTable-td roomTable-td1"><em class="roomName pr"><span class="ht-icon"></span>${room.branchName}<i class="arrow"></i></em></div>
						<!--房型设施 info_box-->
						<div class="info_box">
							<img src="http://pic.lvmama.com${room.photoUrl}" data-src="http://pic.lvmama.com${room.photoUrl}" width="90" height="60">
						    <div class="room-meta">
						    	<#if room.bedType>
						    	<p>床型：${room.bedType}</p>
						    	</#if>
						    	<#if room.extraBed>
					            <p class="room-addBed">加床：${room.extraBed}</p>
					            </#if>
					            <#if room.area>
					            <p class="room-area">面积：${room.area}平方米</p>
					            </#if>
					            <#if room.floor>
					            <p>楼层：${room.floor}</p>
					            </#if>
					            <#if room.broadband>
					            <p>宽带：${room.broadband}</p>
					            </#if>
						    </div>
						    <#if room.branchDesc>
						    <p class="room-other">其他：${room.branchDesc}</p>
						    <#else>
						    <p class="room-other"></p>
						    </#if>
							<a class="room-up" href="javascript:;">收起</a>
                        </div><!-- //info_box -->
						</div>
						<!-- 隐藏 -->
						<!--<div class="romLi-more bd_ddd clearfix" name="roomDiv">-->
						<div class="romLi-more clearfix">
						<#assign roomXiaoJi = 0 /><#--默认房型-->
						<#list room.plans as plan>
						<dl style="display:${(roomXiaoJi == 0)?string("block;","none;")}">
						<#assign roomXiaoJi = roomXiaoJi + 1 />
							<dt class="roomTable-td roomTable-td1">${plan.goodsName}</dt>
							<#if room.bedType??><!--床型开始-->
							<dd class="roomTable-td roomTable-td2">${room.bedType}</dd>
							<#else>
							<dd class="roomTable-td roomTable-td2">暂无介绍</dd>
							</#if><!--床型结束-->
							<!--早餐介绍-->
						   <#assign hasBreakfast = false/> <!--早餐开始-->
				           <#if plan.dayPrice?? && plan.dayPrice?size gt 0>
				               <#list plan.dayPrice as goodsTimePrice>
				               			<#if goodsTimePrice.breakfast gt 0>
				               				<#assign hasBreakfast = true/>
				               				<#break>
				               			</#if>
				                </#list>
				           </#if>
				           <#if hasBreakfast>
				          	    <#assign hasBreakfast = false/>
				          	    <dd class="roomTable-td roomTable-td3">有早餐</dd>
				           <#else>
				         	     <dd class="roomTable-td roomTable-td3">无早餐</dd>
				           </#if>
						   <!--早餐结束-->
							<#if room.broadband??><!--宽带开始-->
							<dd class="roomTable-td roomTable-td-kd">${room.broadband}</dd>
							<#else>
							<dd class="roomTable-td roomTable-td-kd">暂无介绍</dd>
							</#if><!--宽带结束-->
							<dd class="roomTable-td roomTable-td4">
								<div class="select-div">
	                                <span id="${hotel.productId}${room.branchId}${plan.suppGoodsId}">
	                                <#if roomCounts gt plan.maxQuantity>
	                                	${plan.minRoomCounts}
	                                <#else>
	                                	${roomCounts}
	                                </#if>
	                                </span>
	                                <i class="arrow"></i>
	                            </div>
	                            <ol class="select-div-list">
	                                <#if plan.dayPrice?? && plan.dayPrice?size gt 0 && plan.maxRoomCounts gte plan.minRoomCounts>
	                            		<#list plan.minRoomCounts..plan.maxRoomCounts as roomNum>
	                            			<li data-num="${roomNum}">${roomNum}</li>
	                            	 	</#list>
	                            	</#if>
	                            </ol>
							</dd>
                            <!-- 差价"-"加room-diff-minus -->
							<#if plan.suppGoodsId == selectedPlanId><!--选中的商品变为已选-->
							<!--<dd class="roomTable-td roomTable-td5 cf60 yh f12"><span>+</span>&yen;<dfn class="f14 pl2 bold"></dfn></dd>-->
							<#if plan.priceDifferences lt 0> 
							<dd class="roomTable-td roomTable-td5 room-diff-minus" name="priceDiff${hotel.productId}${room.branchId}${plan.suppGoodsId}">
							<#else> 
							<dd class="roomTable-td roomTable-td5" name="priceDiff${hotel.productId}${room.branchId}${plan.suppGoodsId}">
							</#if>
							
                                <span id="${settlementPrice}">
                                	 <#if plan.priceDifferences != '' && plan.priceDifferences lt 0>
                                		-
                                		</span>&yen;<dfn id="${plan.priceDifferencesSingle}" class="f14 pl2 bold">${plan.priceDifferences*-1}</dfn>
                                	<#else>
                                		+
                                		</span>&yen;<dfn id="${plan.priceDifferencesSingle}" class="f14 pl2 bold">${plan.priceDifferences}</dfn>
                                	</#if>
                                
                            </dd>
							<dd class="roomTable-td roomTable-td6"><a href="javascript:changeRooms('${hotel.productId}','${room.branchId}','${plan.suppGoodsId}');" settlementPrice ="${plan.price}" class="selectedBtn">已选 <span class="ph_icon ph_icon_selected"></span></a></dd>
							<#else>
							<!--<dd class="roomTable-td roomTable-td5 cf60 yh f12" name="priceDiff${hotel.productId}${room.branchId}${plan.suppGoodsId}">-->
							<dd <#if goodDefault.priceDifferences lt 0> class="roomTable-td roomTable-td5 room-diff-minus" <#else> class="roomTable-td roomTable-td5"</#if> name="priceDiff${hotel.productId}${room.branchId}${goodDefault.suppGoodsId}">
								<span>
                            	<#if plan.priceDifferences lt 0>
                            		-
                            		</span>&yen;<dfn class="f14 pl2 bold">${plan.priceDifferences?default(0)*(-1)}</dfn>
                            	<#else>
                            		+
                            		</span>&yen;<dfn class="f14 pl2 bold">${plan.priceDifferences}</dfn>
                            	</#if>
							</dd>
							<dd class="roomTable-td roomTable-td6"><a href="javascript:changeRooms('${hotel.productId}','${room.branchId}','${plan.suppGoodsId}');" class="btn btn-small btn-orange" settlementPrice ="${plan.price}">选择 </a></dd>
							</#if>
						</dl>
						</#list>
						</div><!-- //romLi-more -->
						</div>
						</#if>
						</#list><!--房型列表结束-->
						</#if><!--房型结束-->
						
				</div><!--酒店列表结束-->
				<!-- 列表结束 -->
				<#if hotel.rooms?size gt 2>
					<p class="mt10 tr">
					<a href="javascript:;" class="c09c arrowMain pr showAllRoom JS_showAllRoom">展开全部房型<dfn>（${hotel.rooms?size}）</dfn><i class="arrow"></i></a>
				</p>
				</#if>
				<!-- 列表结束 -->
			</div><!-- //搜索结果结束 listMain -->
				</#list>
			</#if>
			<!--分页开始-->
			<!--${fenYe}-->
			<div class="paging orangestyle">
				<#assign endPage2 =0>
				<span class="gopage">到第 <input id="pageNoInput" type="text" class="js_goPage input-text" onkeypress="BindEnter();"> 页 <button class="btn btn-gray btn-small" onclick="goPage()" type="button">确定</button></span>
				<div class="pagebox">
				<#if pagination.page - 1 gt 0>
				   <a style="cursor: pointer;" href="${request.contextPath}${url}/${pagination.page-1}/${queryId}" class="prevpage"><i class="larr"></i>上一页</a>
				</#if>
				<#if pagination.page !=1> 
				   <a style="cursor: pointer;" href="${request.contextPath}${url}/1/${queryId}">1</a>
				</#if>
				<#if pagination.page gt 4>
				  <span class="pagemore">...</span>
				</#if>
				 
				<#if pagination.total gt pagination.page+5 >		
					<#assign endPage2 =pagination.page+5 >
				<#else>
					<#assign endPage2 =pagination.page +1>
				</#if>		
				  
				<#assign i =pagination.page-5 >
				<#list i..endPage2 as index>  
				    <#assign i =i+1 >  
				    <#if i gt 0>
					  	<#if i == pagination.page >		
							<span class="pagesel">${i}</span>
						<#else>
							<#if i!=1 && i lt pagination.total>		
								<a style="cursor: pointer;" href="${request.contextPath}${url}/${i}/${queryId}">${i}</a>
							</#if>					
						</#if>		
					</#if>
				</#list>  
				
				<#if pagination.page + 3 lt pagination.total >	
					<span class="pagemore">...</span>
				</#if>	
				
				<#if pagination.page != pagination.total >	
					<a style="cursor: pointer;" href="${request.contextPath}${url}/${pagination.total}/${queryId}">${pagination.total}</a>
				</#if>		
				<#if pagination.page lt pagination.total >	
					<a style="cursor: pointer;" class="nextpage" href="${request.contextPath}${url}/${pagination.page+1}/${queryId}"><i class="rarr"></i>下一页</a>
				</#if>	
				</div>
				</div>
				<script type="text/javascript">
					function goPage(){
		    			var numInputObj = document.getElementById("pageNoInput");
		    			//验证：必须是数字
		    			if(!/^[1-9][0-9]*$/.test(numInputObj.value)){
		    				alert("请输入正确的页码");
		    				return;
		    			}
		    			//是否超出范围
		    			if(numInputObj.value>${pagination.total}){
		    				alert("页码超出范围");
		    				return;
		    			}
		    			window.location.href="${request.contextPath}${url}/"+numInputObj.value+"/${queryId}";
		    		}
		    		function BindEnter() {
					 if (event.keyCode == 13) {
					     event.cancelBubble = true;
					     event.returnValue = false;
					     goPage();
					   }
					}
				</script>
			<!-- 分页结束-->

		</div><!-- //wrap -->
	</div><!-- //body_bg -->
	<div class="resortOverlay"></div>
    <!-- 正在加载弹层 START-->
    <div class="fh-overlay"></div>
    <div class="fh-dialog-loading">
        <div class="fh-dialog-inner clearfix">
            <div class="fh-dialog-body">
                <p>驴妈妈拼命加载中，请稍后...</p>
            </div>
        </div>
    </div>
    <!-- 正在加载弹层 END-->
    <!-- moreHotel更多酒店品牌弹层 -->
    <#if moreHotelBrand?? && moreHotelBrand?size gt 0 && moreHotelBrand?size gt 8>
   	<div class="moreHotel">
    	<p class="title">更多酒店品牌</p>
    	<ul>
    	<#list moreHotelBrand as moreHotel>
    		<li>
    			<label code="${moreHotel.id}" codetype="B" name="morehotel"><input type="checkbox" brandId="${moreHotel.id}">${moreHotel.value}</label>
    		</li>
    	</#list>
    	</ul>
    	<p class="btnWrap">
    		<a href="javascript:;" class="btnOK">确 定</a>
    	</p>
    	<i class="moreHotel_close" title="关闭"></i>
    </div><!-- //moreHotel更多酒店品牌弹层 -->
    </#if>
    <div class="returnAlert">
        <a href="javascript:;" class="ph_icon_closeAlert"></a>
        <div class="prompt">提示</div>
        <div class="sorryWarp">
            <div class="sorryImg"></div>
            <p id ='errorMsgOutTime'>该酒店在您所选的日期已内售完，请返回重新查询</p>
        </div>
        <div class="sorryBtn">
        	<input id="reloadUrl" type="hidden" value="111111"/>
            <a href="javascript:;" class="fh-return-btn">重新查询</a>
        </div>
    </div>
    <!-- 大图模板 -->
	<div class="img-dialog">
	    <img src="" alt="" width="300" height="200">
	</div>
<!-- 地图js -->
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.4"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/DistanceTool/1.2/src/DistanceTool_min.js"></script>
<!--<script src="http://pic.lvmama.com/min/index.php?f=/js/new_v/jquery-1.7.2.min.js,/js/v6/header_new.js,/js/ui/lvmamaUI/lvmamaUI.js,/js/v6/public/searchComplete.js"></script>--> 

<script src="http://pic.lvmama.com/min/index.php?f=/js/new_v/jquery-1.7.2.min.js,/js/v6/header_new.js,/js/v6/flighthotel/fh-select-alert.js,/js/fit/v3/select-hotel.js,/js/common/losc.js"></script>




<!--<script src="${request.contextPath}/js/fh-select-hotel.js"></script>
<script src="${request.contextPath}/js/fh-select-alert.js"></script>-->
<script src="${request.contextPath}/js/common/common.js"></script>
<script src="${request.contextPath}/js/fh-room.js"></script>

<!-- hotelAlert 酒店弹窗 start 包括：详情、点评、地图 -->
<#include "hotel/hotel_detail.ftl"/>
<!-- hotelAlert 酒店弹窗结束 -->
 
<script>
$(function(){
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
var query = {};
	query.uuid = "${uuid}";
	query.L = "${L}";
	query.R = "${R}";
	query.F = "${F}";
	query.B = "${B}";
	H = "${B}";
	query.S = "${S}";
	query.P = "${P}";
	query.QUERYID = "${queryId}";
	
	function search(){
		var url = "${request.contextPath}/search/hotels";
		for(var key in query){
			url+="/"+query[key];		
		}
		var searchKeyWord = $('#searchHotel').val();
		if("请输入酒店名称/地标/商圈"!=searchKeyWord){
			url = url + "?keywords="+searchKeyWord;
		}
	    $(".fh-overlay, .fh-dialog-loading").show();
		window.location.href=url;
	}
	
	$(function(){
	
		listShow();
  		bindClick();
	});

	function listShow(){
	    	var listShow="";
	    	var moreHotel="";
	    	var last = "<dd><a class='close_all' href='javascript:;'>清除所有条件</a></dd>";
	    	if(query.L!="ALL"
	    		||query.R!="ALL"
	    		||query.F!="ALL"
	    		||query.B!="ALL"){
	    		listShow = "<dt>您已选择：</dt>";
	    	}
    		
    		var lcount =1;
			$('.search_kind').find("dd").each(function(){
				var t = $(this);
				var code = t.find("a").attr("code");
				var codetype = t.find("a").attr("codetype");
				if(!code || !codetype || !query[codetype]){
					return;
				}
				
				if(indexOf(code,codetype)){
					if(code!='ALL'){
						t.attr("class","active");
						if(codetype=='L'&&lcount==1){
							listShow+="<dd><span>"+t.find("a").text()+"<a code='"+code+"'  codetype ='"+codetype+"'  class = 'request_close' href='javascript:;' title='删除' >×</a></span></dd>";		
							lcount=2;
						}else if(codetype!='L'){
							listShow+="<dd><span>"+t.find("a").text()+"<a code='"+code+"'  codetype ='"+codetype+"'  class = 'request_close' href='javascript:;' title='删除' >×</a></span></dd>";
						}
					}
				}
			});
			//选中更多酒店中的数据时，进行展示
			$('.moreHotel').find("li").each(function(){
				var t = $(this);
				var code = t.find("label").attr("code");
				var codetype = t.find("label").attr("codetype");
				if(!code || !codetype || !query[codetype]){
					return;
				}
				if(codetype=='L'&&code.indexOf('-')>0&&codetype!='ALL'){
					code = code.substring(0,code.indexOf('-'));
				}
				if(indexOf(code,codetype)&&codetype!='L'){
					if(code!='ALL'){
						t.find("input").attr("checked","checked");
						if(codetype=='L'&&lcount==1){
							moreHotel+="<dd><span>"+t.find("label").text()+"<a code='"+code+"'  codetype ='"+codetype+"'  class = 'request_close' href='javascript:;' title='删除' >×</a></span></dd>";
							lcount=2;
						}else if(codetype!='L'){
							moreHotel+="<dd><span>"+t.find("label").text()+"<a code='"+code+"'  codetype ='"+codetype+"'  class = 'request_close' href='javascript:;' title='删除' >×</a></span></dd>";
						}
					}
				}
			});
			
			
	    	if(listShow != null && listShow != ""){
	    		if(moreHotel != null && moreHotel != ""){
	    			$(".request_list").html(listShow+moreHotel+last);
	    		}else{
	    			$(".request_list").html(listShow+last);  
	    		}
	    	}
    }

	function indexOf(code,codetype){
		var queryStr = query[codetype].split('-');
		for(var i=0;i<queryStr.length;i++){
			if(queryStr[i]==code){
				return true;
			}
		}
		return false;
	}
	


	function bindClick(){
	
		//已选择条件上的取消所有条件
	    $(".close_all").click(function(){

	    	$(".request_list").html("");

			var f = $(".active");
			for(var i=0; i<f.length;i++){
				f.eq(i).attr("class","");
			}
         	query.L = "ALL";
         	query.R="ALL";
    		query.F="ALL";
    		query.B="ALL";
    		query.S="ALL";
    		query.P="1";
         	listShow();
         	search();
	    });			
	
		$('.request_close').click(function(e){
		
			var code = $(e.target).attr("code");
			var codetype = $(e.target).attr("codetype");
			
         	if(!code || !codetype){
         		return;
         	}
         	var queryStr = "";
         	$('.search_kind').find("dd").each(function(){
				var t = $(this);
				var ddcode = t.find("a").attr("code");
				var ddcodetype = t.find("a").attr("codetype");
				if(ddcodetype == codetype){
					if(ddcode == code){
						t.attr("class","");
					}
					if(t.attr("class")=="active"){
						queryStr+=((queryStr=="")?"":"-")+ddcode;
					}
				}
         	});
         	
         	$('.moreHotel').find("li").each(function(){
				var t = $(this);
				var ddcode = t.find("label").attr("code");
				var ddcodetype = t.find("label").attr("codetype");
				if(ddcodetype == codetype){
					if(ddcode == code){
						//t.attr("class","");
						t.find("input").attr("checked",false)
					}
					//if(t.attr("class")=="active"){
					if(t.find("input").attr("checked")=="checked"){
						queryStr+=((queryStr=="")?"":"-")+ddcode;
					}
				}
         	});
         	
     		query[codetype]=((queryStr=="")?"ALL":queryStr);
    		query.P="1";
         	listShow();
         	search();
		});
		
	
		$('.search_kind').click(function(e){
			
			var codetype = $(e.target).attr("codetype")?$(e.target).attr("codetype"):$(e.target).parent("a").attr("codetype");
			if(!codetype){
         		return;
         	}
         	
         	var code = $(e.target).attr("code")?$(e.target).attr("code"):$(e.target).parent("a").attr("code");
			if(!code){
         		return;
         	}
         	
         	if(query[codetype] == code
         		&&code=='ALL'){
         		return;
         	}
			
			var queryStr = "";
			
         	$('.search_kind').find("dd").each(function(){
				
				var t = $(this);
				var ddcodetype = $(this).find("a").attr("codetype");
				var ddcode = $(this).find("a").attr("code");
					         		
				if(ddcodetype == codetype){
					if(ddcode == code){
						if(ddcode == "ALL"){
							query[codetype]="ALL";
						}else{
							t.attr("class","active");
						}
					}else{
						if(ddcode == "ALL"){
							t.attr("class","kind_buxian");
						}else{
							if(!indexOf(ddcode,codetype)){
								t.attr("class","");
							}
						}
					}
					
					if(indexOf(code,codetype) && ddcode == code){
						if(t.attr("code") == "ALL"){
							t.attr("class","kind_buxian");
						}else{
							t.attr("class","");
						}
					}
					
					if(t.attr("class")=="active"){
						queryStr+=((queryStr=="")?"":"-")+ddcode;				
					}
				}
         	});
			if(codetype=="B"){
						var bandIds=[];
						 $('.moreHotel input:checked, .brand_wrap input:checked').each(function() {
	       					 bandIds.push($(this).attr("brandId"));
	   					 });
	   					 queryStr=queryStr+"-"+bandIds.join("-");		
					}
         	if(query[codetype] == code){
         		query[codetype] = 'ALL';
         	}else{
				query[codetype] = queryStr;
			}
			if(codetype=='L'){
				query.L=code;
				$(".search_subCon").hide();
			}
    		query.P="1";
    		if(query.B == "-"){
    			query.B = "ALL"; 
    		}
    		if(query.B.lastIndexOf("-")==query.B.length-1){
    			query.B = query.B.substring(0,query.B.length-1);
    		}
			listShow();
    		search();
    		
		});
	}
	function changeRooms(productId,branchId,suppGoodsId){
		var shoppingUUID = "${uuid}";
  		var hotelUUID =shoppingUUID+"_hotel";
  		var productId =productId;
  		var branchId = branchId;
  		var suppGoodsId =suppGoodsId;
  		var roomCount = $("#"+productId+branchId+suppGoodsId+"").text();
  		 $.ajax({
             type: "post",
             async: false,
             dataType: "json",
             url: "${request.contextPath}/shopping/changehotel",
             data: 
             {
             	shoppingUUID:shoppingUUID,
             	hotelId:productId,
             	roomId:branchId,
             	planId:suppGoodsId,
             	hotelUUID:hotelUUID,
             	roomCount:roomCount
             },
             success: function(obj) {
             	if(obj.isSuccess){
             		location.href="${request.contextPath}/search/backToShopping?shoppingUUID="+shoppingUUID;
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
		    	var reloadUrl = "${request.contextPath}/search/"+shoppingUUID+"?tripType="+tripType+"&departureCityCode="+departureCityCode+"&arrivalCityCode="+arrivalCityCode+"&departureTime="+flightStartDate+"&returnTime="+flightEndDate+"&cityCode="+cityCode+"&checkInTime="+hotelStartDate+"&checkOutTime="+hotelEndDate+"&adultsCount="+adultsCount+"&childCount="+childCount;
		    	$('#reloadUrl').val(reloadUrl);
			  }
         });

	}
	//房间选择按钮
	function roomSelected(productId,branchId,suppGoodsId){
  		
    };


	//返回上一页
	function goBack(){
		var baseurl='${request.contextPath}';
		var contextpath='/search/backToShopping?shoppingUUID=${uuid}';
		window.location.href=baseurl+contextpath;
  		//window.history.back()
  	}
	//点击按价格从低到高 排序
	
	var curSortValue = '${S}';
	
	$("#priceSort").click(function(){
		  if(curSortValue=="27"){
		  	query.S="2";
		  }
		  if(curSortValue=="ALL"){
		  	query.S="2";
		  }
		  if(curSortValue=="3"){
		     query.S="2";
		  }
		  listShow();
     	  search();
	});
	
	//点击按价格从高到低 排序
	$("#priceSort_down").click(function(){
		  if(curSortValue=="27"){
		  	query.S="3";
		  }
		  if(curSortValue=="ALL"){
		  	query.S="3";
		  }
		  if(curSortValue=="2"){
		  	query.S="3";
		  }
		  listShow();
     	  search();
	});
	//点击按好评率从高到低排序
	$("#goodCommentSort").click(function(){
		  //$(this).find("i").toggleClass("asc").toggleClass("desc");
		  query.S="27";
		  listShow();
     	  search();
	});
	//点击按驴妈妈推荐排序
	$("#defaultSort").click(function(){
		  //$(this).find("i").toggleClass("asc").toggleClass("desc");
		  //如果已经是驴妈妈推荐排序了，再点击则没有反应
		  if($("#defaultSort").hasClass("active")){
		  	return;
		  }
		  query.S="ALL";
		  listShow();
     	  search();
	});
  
 	
    $('.JS_showAllRoom').on("click", function(e) {
    if($('.big')[0].style.display =='none'){
    	$('.big').css('display','block');
    	}else{
    	$('.big').css('display','none');
    	};
    });
   
//更换房间数  (改为不联动)
function changeRoomNum(){
	// 更换房间数
    $(".select-div-list li").on("click", function(e) {
        var event = e || window.event;
        event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);

        var roomNum = $(this).data("num");//房间数
        var $selectList = $(this).parent();
		var baseAmount="${baseAmount}";//酒店基准价
		var goodsId = $(this).parent().parent().find("span").attr("id");
		
		//console.info("roomNum="+roomNum+";baseAmount="+baseAmount);
		// 所有的房间数都变
        //$(".select-div span").html(roomNum);
        
        $("span[id="+goodsId+"]").html(roomNum);
        $selectList.hide();
       
       //var priceDiffDiv = $("div[name='priceDiff"+goodsId+"']");
      	var selectButton = $(this).parent().parent().parent().find(".roomTable-td6");
		var settlementPrice = $(selectButton).find("a").attr("settlementPrice");
		var priceDiff = (settlementPrice*roomNum)-baseAmount;
		//console.info("settlementPrice="+settlementPrice+";priceDiff="+priceDiff);
		//改价格            	
		var priceDiffHtml = "";
		if(priceDiff >= 0){
			priceDiffHtml += "+&yen;<dfn class='f14 pl2 bold'>"+priceDiff+"</dfn>";
		}else{
			priceDiffHtml += "-&yen;<dfn class='f14 pl2 bold'>"+Math.abs(priceDiff)+"</dfn>";
		}
		$("div[name='priceDiff"+goodsId+"']").html(priceDiffHtml);
		$("dd[name='priceDiff"+goodsId+"']").html(priceDiffHtml);
		
		//把已选按钮改成选择
		if($(".roomTable-td6").find("a").hasClass("selectedBtn")){
			$(".roomTable-td6").find("a").removeClass("selectedBtn").addClass("btn btn-small btn-orange xuanze");
			$(".roomTable-td6").find("a").html("选择");
		}
        
    });
}

$(function(){
	if(query.S=="27"){
		  $("#priceSort").attr("class","")
  		  $("#goodCommentSort").attr("class","active")
  		  $("#defaultSort").attr("class","")
	}else if(query.S=="3"){
		  $("#priceSort").attr("class","active")
  		  $("#goodCommentSort").attr("class","")
  		  $("#defaultSort").attr("class","")
	}else if(query.S=="ALL"){
		 $("#priceSort").attr("class","")
  		 $("#goodCommentSort").attr("class","")
  		 $("#defaultSort").attr("class","active")
	}else if(query.S=="2"){
		$("#priceSort_down").attr("class","active")
  		$("#goodCommentSort").attr("class","")
  		$("#defaultSort").attr("class","")
	}
	query.L = "${L}";
	query.R = "${R}";
	query.F = "${F}";
	query.B = "${B}";
	if(query.L=="ALL"){
		$("#jdsqall").attr("class","kind_buxian active");
	}
	if(query.R=="ALL"){
		$("#jdxjall").attr("class","kind_buxian active");
	}
	if(query.F=="ALL"){
		$("#jdssall").attr("class","kind_buxian active");
	}
	if(query.B=="ALL"){
		$("#jdppall").attr("class","kind_buxian active");
	}
}); 
    
$(function(){
     //var adultCount = '${adultCount}';
     //var childCount = '${childCount}';
     //fit.room.loadChangedHotelRoomCount(adultCount,childCount);
     changeRoomNum();
});
//选择更多酒店品牌
$(".btnOK").click(function(){
	var bandIds = [];
	var qq = [];
    $('.moreHotel input:checked, .brand_wrap input:checked').each(function() {
        bandIds.push($(this).attr("brandId"));
    });
     $('.moreHotel input').each(function() {
        qq.push($(this).attr("brandId"));
    });
    	for(var i=0;i<bandIds.length;i++){
			for(var j=0;j<qq.length;j++){
			if(query.B.indexOf(bandIds[i])==-1 && query.B.indexOf(qq[j])>=0){
				query.B=query.B.replace(qq[j]+"-",""); 
				query.B=query.B.replace("-"+qq[j],""); 
			}else if(query.B.indexOf(bandIds[i])>=0){
				query.B=query.B.replace(bandIds[i]+"-",""); 
				query.B=query.B.replace("-"+bandIds[i],""); 
			}
			}
			}
    if(bandIds.length == 0) {
		listShow();
     	search();
    }else{
    	if(query.B=="ALL"){
    		query.B=bandIds.join("-");
    	}else{
    		query.B=query.B+"-"+bandIds.join("-");
		}
	}
			
	
    	listShow();
     	search();
}); 
$(function(){
	var from ='${departureCityName}';
	var dest ='${arrivalCityName}';
	var hotel ='${hotelName}';
    seoJustice(from,dest,hotel,'seotdk_fit_freetour','${request.contextPath}');
  
});
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
$('.hotel-search-btn').click(function(){
	var searchKeyWord = $('#searchHotel').val();
	var url = "${request.contextPath}/search/hotels/${uuid}/ALL/ALL/ALL/ALL/ALL/1";
	if("请输入酒店名称/地标/商圈"!=searchKeyWord){
		url = url + "?keywords="+searchKeyWord;
	}
	window.location.href=url;
});
</script>
        <#if isBackBooking=='true'>
       <#else>
	       <#include "online_foot.ftl">
       </#if> 
</body>
</html>