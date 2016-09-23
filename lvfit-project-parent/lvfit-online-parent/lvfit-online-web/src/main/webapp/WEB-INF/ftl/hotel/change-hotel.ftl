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
    .subCon_list {
        position: relative;
        padding: 0 45px 0 9px;
        overflow: hidden;
		height: auto;
    }
</style>
<script>
	var baseUrl = '${request.contextPath}';
</script>
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
                <a href="${request.contextPath}/search/backToShopping?shoppingUUID=${req.shoppingUUID}" style="color:#21a8dc">产品选择页</a>
           </h3>
     </#if>

    <input type="hidden" name="shoppingUUID" id="shoppingUUID" value="${req.shoppingUUID}" />
    <input type="hidden" name="keywords" id="keywords" />
    <input type="hidden" name="cityCode" id="cityCode" value="${req.cityCode}"/>
	<input type="hidden" name="checkInTime" id="checkInTime" value="${req.checkInTime}"/>
	<input type="hidden" name="checkOutTime" id="checkOutTime" value="${req.checkOutTime}"/>
	<input type="hidden" name="adultsCount" id="adultsCount" value="${req.adultsCount}"/>
	<input type="hidden" name="childCount" id="childCount" value="${req.childCount}"/>
    <input type="hidden" name="hotelBasePrice" id="hotelBasePrice" value="${hotelBasePrice}" />
    <input type="hidden" name="selHotelId" id="selHotelId" value="${selHotelId}" />
    <input type="hidden" name="selHotelRoomId" id="selHotelRoomId" value="${selHotelRoomId}" />
    <input type="hidden" name="selHotelPlanId" id="selHotelPlanId" value="${selHotelPlanId}" />
	<div class="body_bg">
		<div class="wrap pt60">
			<!-- filter 筛选开始-->
			<div class="filter bd_ddd">
				<div class="filter-head yh f18 c9">                  
					<a href="javascript:;" onclick="goBack()" class="btn btn-pink btn-lg fr"><span class="btn-text">返回上一页</span></a>更换酒店：<span class="c3 pl10">${cityName}<i class="plr15"><dfn class="arial f16">${checkInDate}</dfn>&nbsp;至&nbsp;<dfn class="arial f16">${checkOutDate}</dfn></i></span><dfn class="arial f16">${dayDiff}</dfn>晚
				</div>
				<#if landmarkMap?exists>
				<div class="search_kind search_kind_hotel"><!--酒店商圈开始-->
					<dl class="clearfix js_fuxuan" id="hotelLocationCondition">
	                	<dt>酒店位置</dt>
	                    <dd class="kind_buxian active"><a code='ALL' codetype="L" class="search_arrow_1" href="javascript:;">不限</a></dd>
	                    <#if landmark??>
	                    	<dd class="kind_hotel_location"><span>地标<b class="searchArrow"></b></span></dd>
	                    </#if>
	                    <#if trainStation??>
	                    	<dd class="kind_hotel_location"><span>火车站<b class="searchArrow"></b></span></dd>
	                    </#if>
	                    <#if metroStation??>
	                    	<dd class="kind_hotel_location kind_hl_metro"><span>地铁站<b class="searchArrow"></b></span></dd>
	                    </#if>
	                    <#if longBusStation??>
	                    	<dd class="kind_hotel_location"><span>长途汽车站<b class="searchArrow"></b></span></dd>
	                    </#if>
	                    <#if spots??>
	                    	<dd class="kind_hotel_location"><span>景点/景区<b class="searchArrow"></b></span></dd>
	                    </#if>
	                    <#if airPorts??>
	                    	<dd class="kind_hotel_location"><span>飞机场<b class="searchArrow"></b></span></dd>
	                    </#if>
	                    <#if businesses??>
	                    	<dd class="kind_hotel_location"><span>商圈<b class="searchArrow"></b></span></dd>
	                    </#if>
	                </dl>
		            <div class="search_subCon">
						<!-- 地铁选项卡 -->
						<#if metroStation?exists>
						<div class="metro">
							<ul class="clearfix">
								<#list metroStation?keys as key>
								<li <#if key_index == 0 >class="active"</#if> >
									<a href="javascript:;">${key}</a>
									<span class="metroTabArrow"><b></b></span>
								</li>
								</#list>
							</ul>
							<#list metroStation?keys as key>
								<div class="search_subCon_list search_more" <#if key_index==0>style="display:block;"</#if> >
								<#list metroStation[key] as val>
                                    <dd data-code='${val.id}' data-type="L"><a href="javascript:;">
									${val.value}</a></dd>
								</#list>
								</div>
							</#list>
						</div>
						</#if>
						<!--地铁选项卡结束-->
						<!-- 普通选项卡 -->
						<#if landmarkMap?exists>
						<div class="subCon_list">
							<#if landmark??>
								<div class="search_subCon_list">
								<#list landmark as land>
									<dd data-code='${land.id}' data-type="L"><a href="javascript:;">${land.value}</a></dd>
								</#list>
								</div>
							</#if>

							<#if trainStation??>
								<div class="search_subCon_list">
								<#list trainStation as train>
								<dd data-code='${train.id}' data-type="L"><a href="javascript:;">
									${train.value}</a></dd>
								</#list>
								</div>
							</#if>

							<#if metroStation??>
							<div class="search_subCon_list">
								<!-- 地铁站占用 -->
							</div>
							</#if>

							<#if longBusStation??>
								<div class="search_subCon_list">
								<#list longBusStation as bus>
									<dd data-code='${bus.id}' data-type="L"><a href="javascript:;">${bus.value}</a></dd>
								</#list>
								</div>
							</#if>

							<#if spots??>
							<div class="search_subCon_list">
								<#list spots as spot>
									<dd data-code='${spot.id}' codetype="L"><a href="javascript:;">${spot.value}</a></dd>
								</#list>
							</div>
							</#if>

							<#if airPorts??>
							<div class="search_subCon_list">
								<#list airPorts as airPort>
									<dd data-code='${airPort.id}' data-type="L"><a href="javascript:;">${airPort.value}</a></dd>
								</#list>
							</div>
							</#if>

							<#if businesses??>
							<div class="search_subCon_list">
								<#list businesses as business>
									<dd data-code='${business.id}' data-type="L"><a href="javascript:;">${business.value}</a></dd>
								</#list>
							</div>
							</#if>

						</div>
						</#if>
						<!--普通选项卡结束-->
					</div>
				</div><!-- //search_kind --><!--酒店商圈结束-->
	            </#if>
				<div class="search_kind js_search_kind"><!--酒店星级开始-->
	            	<dl class="clearfix js_fuxuan" id="hotelStarCondition">
	                	<dt>酒店星级</dt>
	                	<dd class="kind_buxian active"><a class="search_arrow_1" href="javascript:;">不限</a></dd>
	                    <#if hotelStar??>
	                    	<!-- 后台再次筛选时，直接在前面加个R -->
	                    	<#list hotelStar?sort_by("id") as stars>
	                    		<#if stars.id==100 || stars.id==101><dd data-code='100,101' data-type="R"><a href="javascript:;"><i class="ph_icon hotel_ck"></i>五星级/豪华型</a></dd></#if>
	                    		<#if stars.id==102 || stars.id==103><dd data-code='102,103' data-type="R"><a href="javascript:;"><i class="ph_icon hotel_ck"></i>四星级/品质型</a></dd></#if>
	                    		<#if stars.id==104 || stars.id==105><dd data-code='104,105' data-type="R"><a href="javascript:;"><i class="ph_icon hotel_ck"></i>三星级/舒适型</a></dd></#if>
	                    		<#if stars.id==106 || stars.id==107><dd data-code='106,107' data-type="R"><a href="javascript:;"><i class="ph_icon hotel_ck"></i>二星级/简约型</a></dd></#if>
	                    		<#if stars.id==109><dd data-code='109,109' data-type="R"><a href="javascript:;"><i class="ph_icon hotel_ck"></i>其他/其他</a></dd></#if>
	                    	</#list>
	                    </#if>
	                </dl>
	            </div><!-- //search_kind --><!--酒店星级结束-->
	            <#if hotelBrand?? && hotelBrand?size gt 0>
	            <div class="search_kind js_search_kind"><!--酒店品牌开始-->
	            	<dl class="clearfix js_fuxuan" id="hotelBrandCondition">
	                	<dt id="jdpp">酒店品牌</dt>
	                    <dd id="jdppall" class="kind_buxian active"><a class="search_arrow_1" href="javascript:;">不限</a></dd>
	                    <#if hotelBrand??>
	                    	<#list hotelBrand as defaultHotel>
	                    		<dd data-code='${defaultHotel.id}' data-type="B"><a href="javascript:;"><i class="ph_icon hotel_ck"></i>${defaultHotel.value}</a></dd>
	                    	</#list>
	                    </#if>
	                    <!--此处添加更多酒店的按钮-->
	                </dl>
	                <#if moreHotelBrand?? && moreHotelBrand?size gt 0 && moreHotelBrand?size gt 8>
	                <a href="javascript:;" class="search_gd js_more_hotel_brand">更多</a>
	                </#if>
	            </div><!-- //search_kind --><!--酒店品牌结束-->
	            </#if>
	            <div class="search_kind js_search_kind" id="hotelFacilitiesCondition"><!--酒店设施开始-->
	            	<dl class="clearfix js_fuxuan">
	                	<dt>酒店设施</dt>
	                    <dd class="kind_buxian active"><a class="search_arrow_1" href="javascript:;">不限</a></dd>
	                    <#if hotelFacilities?? && hotelFacilities?size gt 0 >
	                    	<#list hotelFacilities as hotelFacility>
	                    		<dd data-code='${hotelFacility.id}' data-type="F"><a href="javascript:;"><i class="ph_icon hotel_ck"></i>${hotelFacility.value}</a></dd>
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
	            		<p class="result c9"><dfn class="f16 cf60 bold pr5">${hotelLists?size}</dfn>家酒店</p>
	            		</#if>
	                 <dl class="request_list" style="display:none;">
                         <dt>您已选择：</dt>
                         <dd id="localConditions"></dd>
						 <dd id="starConditions"></dd>
						 <dd id="brandConditions"></dd>
						 <dd id="moreBrandConditions"></dd>
						 <dd id="faciliConditions"></dd>
                         <dd><a class="close_all" href="javascript:closeAll();">清除所有条件</a></dd>
	                </dl>
				</div><!-- //request --><!--已选条件结束-->
			</div><!-- //filter 筛选结束-->
			
			<!-- 排序开始 -->
			<div class="result_sort clearfix mt20"><!-- 排序开始 -->
				<!-- 酒店搜索 -->
                <form class="hotel-search" >
					<input id="hotelSearchInput" class="hotel-search-input input-tip" type="text" placeholder="请输入酒店名称/地标/商圈">
					<a class="hotel-search-btn" href="javascript:;">搜索</a>
                </form>

				<ul class="rank_box">
					<li class="active" data-sortval=""><a href="javascript:;">驴妈妈推荐 </a> </li>
					<li title="按价格由低到高排序" data-sortval="3"> <a href="javascript:;">价格 </a><i class="sort_down"></i></li>
					<li title="按好评率由高到低排序" data-sortval="27"><a href="javascript:;">好评率 </a><i class="sort_down"></i></li>
				</ul>
			</div><!-- 排序结束 -->

			<div id="hotel_list">
			<#include "hotel/hotel_list.ftl">
            </div>

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
    			<label><input type="checkbox" name="brand" data-type="B" data-code="${moreHotel.id}">${moreHotel.value}</label>
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
        	<input id="reloadUrl" type="hidden" value=""/>
            <a href="javascript:;" class="fh-return-btn">重新查询</a>
        </div>
    </div>
    <!-- 大图模板 -->
	<div class="img-dialog">
	    <img src="" alt="" width="300" height="200">
	</div>

    <!-- hotelAlert 酒店弹窗 start 包括：详情、点评、地图 -->
	<#include "hotel/hotel_detail.ftl"/>
    <!-- hotelAlert 酒店弹窗结束 -->

	<#if isBackBooking=='true'>
	<#else>
		<#include "online_foot.ftl">
	</#if>
    <!-- 地图js -->
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.4"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/library/DistanceTool/1.2/src/DistanceTool_min.js"></script>

	<script src="http://pic.lvmama.com/min/index.php?f=/js/new_v/jquery-1.7.2.min.js,/js/v6/header_new.js,/js/v6/flighthotel/fh-select-alert.js,/js/fit/v3/select-hotel.js,/js/common/losc.js"></script>
	<script src="${request.contextPath}/js/common/common.js"></script>
    <script src="${request.contextPath}/js/fh-hotel-detail.js"></script>
    <script>
        var path="${request.contextPath}/search/backToShopping?shoppingUUID=" + $("#shoppingUUID").val();

        $(function() {
            var uuid = $("#shoppingUUID").val();
            var searchCondition = window.localStorage.getItem('searchCondition');
            if(searchCondition != null && searchCondition != '') {
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

                var reloadUrl = "${request.contextPath}/search?shoppingUUID=" + uuid + "&tripType=" + tripType + "&departureCityCode=" + departureCityCode + "&arrivalCityCode=" + arrivalCityCode + "&departureTime=" + flightStartDate + "&returnTime=" + flightEndDate + "&cityCode=" + cityCode + "&checkInTime=" + hotelStartDate + "&checkOutTime=" + hotelEndDate + "&adultsCount=" + adultsCount + "&childCount=" + childCount;
                $('#reloadUrl').val(reloadUrl);
            }
        });

		$(".search_subCon_list dd").click(function (e) {
            var event = e || window.event;
            event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);

			$(".search_subCon_list").find("dd").removeClass("active");
            $(this).addClass("active");
            addConditions();
        });

        // 筛选条件点击
        $(".js_search_kind dd:not(:first)").live("click", function(e){
            var event = e || window.event;
            event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);

            var $list = $(this).parents(".search_kind");
            var $noLimit = $list.find("dd:first"); // 不限选项
            var $thisItem = $(this); // 其他选项

            // 判断该元素是否被选中，如果被选中，去掉选中状态，如果所有
            // 其他条件清空，则“不限”选项被选中
            if ($thisItem.hasClass("active")) {
                $thisItem.removeClass("active");
                var hasConditionFlag = false;
                $list.find("dd:not(:first)").each(function(){
                    if ($(this).hasClass("active")) {
                        hasConditionFlag = true;
                    }
                });
                if (!hasConditionFlag) {
                    $noLimit.addClass("active");
                }

            } else {
                $thisItem.addClass("active");
                if ($noLimit.hasClass("active")) {
                    $noLimit.removeClass("active");
                }
            }
            // 构造选中的条件
            addConditions();
        });

        // 点击[不限]按钮
        $(".kind_buxian:not(:first)").live("click", function(e){
            var event = e || window.event;
            event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);

            if (!$(this).hasClass("active")) {
                $(this).addClass("active");
            }
            var $list = $(this).siblings("dd");
            $list.each(function() {
                if ($(this).hasClass("active")) {
                    $(this).removeClass("active");
                }
            });
            // 构造选中的条件
            addConditions();
        });

		// 点击酒店位置[不限]按钮
		$(".kind_buxian:first").live("click", function () {
            $(".search_subCon_list dd").removeClass("active");
            addConditions();
        });

        $("#jdppall").click(function () {
            // 清除更多酒店中选中的checkbox
            $("input[name='brand']").attr("checked", false);
            $("#moreBrandConditions").html("");
        });

        function addConditions() {
            var localCondition = addCondition( $(".search_subCon_list").find("dd") );
            var starCondition = addCondition( $("#hotelStarCondition").find("dd:not(:first)") );
            var brandCondition = addCondition( $("#hotelBrandCondition").find("dd:not(:first)") );
            var faciliCondition = addCondition( $("#hotelFacilitiesCondition").find("dd:not(:first)") );

            $("#localConditions").html(localCondition);
            $("#starConditions").html(starCondition);
            $("#brandConditions").html(brandCondition);
            $("#faciliConditions").html(faciliCondition);

            if ($(".request_list dd span").length) {
                $(".request_list").show();
            } else {
                $(".request_list").hide();
            }
			searchHotels();
        }

        function addCondition($list) {
            var ddStr = "";
            $list.each(function () {
                if ($(this).hasClass("active")) {
                    ddStr += "<span>" + $(this).find("a").text()
                            + "<a class=\"request_close\" href=\"javascript:void(0);\" data-type=\"" + $(this).data("type")
                            + "\" data-code=\"" + $(this).data("code") + "\" onclick=\"requestClose( $(this) )\" title=\"删除\">×</a></span>";
                }
            });
            return ddStr;
        }

        function addMoreBrandCondition($check) {
            var ddStr = "";
            $check.each(function () {
                if ($(this).is(":checked")) {
                    ddStr += "<span>" + $(this).parents("label").text()
                            + "<a class=\"request_close\" href=\"javascript:void(0);\" data-type=\"" + $(this).data("type")
                            + "\" data-code=\"" + $(this).data("code") + "\" onclick=\"requestClose( $(this) )\" title=\"删除\">×</a></span>";
                }
            });
            return ddStr;
        }

        // 删除单个筛选条件
        function requestClose($span){
            var type = $span.data("type");
            var code = $span.data("code");
			if (type != "L") {
                $(".search_kind dd:not(:first)").each(function () {
                    var itemType = $(this).data("type");
                    var itemCode = $(this).data("code");
                    if (itemType === type && itemCode === code) {
                        $(this).trigger("click");
                    }
                });
            } else {
                $(".kind_buxian:first").trigger("click");
			}
        }
        // 删除所有筛选条件
        function closeAll() {
            $(".request_list dd span").remove();
			$(".request_list").hide();


            $(".search_kind:not(:first)").find("dd").removeClass("active");
			$(".search_subCon_list dd").removeClass("active");
			$(".search_subCon").hide();
			$(".kind_hotel_location").removeClass("active");

            $(".kind_buxian").addClass("active");
			searchHotels();
        }

		$(".btnOK").click(function () {
            var str = addMoreBrandCondition( $("input[name='brand']") );

			$("#moreBrandConditions").html(str);

			$(".moreHotel").hide();
			if ($(".request_list dd span").length) {
                $(".request_list").show();
			} else {
                $(".request_list").hide();
			}
        });

		function searchHotels() {
            //$(".fh-overlay, .fh-dialog-loading").show();
            $.ajax({
                type: "post",
                url: baseUrl + "/search/searchHotels",
                data: {
                    keywords : $("#keywords").val(),
            		cityCode : $("#cityCode").val(),
                    departureDate : $("#checkInTime").val(),
                    returnDate : $("#checkOutTime").val(),
                    params : genParamStr(),
                    adultCount : $("#adultsCount").val(),
                    childCount : $("#childCount").val(),
                    hotelBasePrice : $("#hotelBasePrice").val(),
                    selHotelId : $("#selHotelId").val(),
                    selHotelRoomId : $("#selHotelRoomId").val(),
                    selHotelPlanId : $("#selHotelPlanId").val()
                },
                success: function(data) {
                    //$(".fh-overlay, .fh-dialog-loading").hide();
                    $("#hotel_list").html(data);
                    $(".result dfn").text($("#hotelCounts").val());
                    $(".JS_showAllRoom").die().bind("click", showAllRoom);
                    $(".roomName").die().bind("click", showRoomDetail);
                }
            });
        }
		
		function genParamStr() {
			var str = "";
			// 构建过滤规则
            var localKey = genParamStrKey($("#localConditions span a"));
			var starKey = genParamStrKey($("#starConditions span a"));
            var brandKey = genParamStrKey($("#brandConditions span a"));
            var moreBrandKey = genParamStrKey($("#moreBrandConditions span a"));
            var faciliKey = genParamStrKey($("#faciliConditions span a"));
			if (localKey !== "") {
                str += "L" + localKey;
			}
			if (starKey !== "") {
				str += "R" + starKey;
			}
			if (brandKey !== "") {
				if (moreBrandKey !== "") {
                    str += "B" + brandKey + "," + moreBrandKey;
                } else {
					str += "B" + brandKey;
				}
			} else {
                if (moreBrandKey !== "") {
                    str += "B" + moreBrandKey;
                }
			}
			if (faciliKey !== "") {
                str += "F" + faciliKey;
			}
			// 构建排序规则
			$(".rank_box li").each(function () {
				if ($(this).hasClass("active")) {
					var sortValue = $(this).attr("data-sortval");
					if (sortValue !== "") {
                        str += "S" + sortValue;
					}
				}
            });
			// 构建排序信息
			var pageNum = $("#page").val();
			if (!isNaN(pageNum)) {
				str += "P" + pageNum;
			} else {
				str += "P1";
			}

			return str;
        }

		function genParamStrKey($obj) {
            var str = "";
            $obj.each(function () {
                str += $(this).data("code") + ",";
            });
			return str.substring(0, str.length - 1);
        }

		$(".rank_box li:not(:eq(1))").click(function () {
            $(this).addClass("active");
            $(this).siblings("li").removeClass("active");

            searchHotels();
        });
		$(".rank_box li:eq(1)").click(function () {
            $(this).addClass("active");
            $(this).siblings("li").removeClass("active");

            var $i = $(this).find("i")
			if ($i.hasClass("sort_down")) {
                $i.removeClass("sort_down");
				$i.addClass("sort_up");
				$(this).attr("data-sortval", 3);
			} else {
                $i.removeClass("sort_up");
                $i.addClass("sort_down");
                $(this).attr("data-sortval", 2);
			}
            searchHotels();
        });

        function goPage() {
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
            $("#page").val(numInputObj);
            searchHotels();
        }

		function BindEnter() {
            if (event.keyCode == 13) {
                event.cancelBubble = true;
                event.returnValue = false;
                goPage();
            }
        }

		$(".pagebox a").live("click", function () {
			$("#page").val($(this).text());
            searchHotels();
        });

        function showAllRoom () {
            var $this = $(this);
            var text = $this.html();
            var $thisList = $this.parents(".listMain");
            var $openRoom = $thisList.find('.room-content .open');
            var $diff = $thisList.find(".roomHead .roomTable-td5");
            if ($openRoom.length) {
                $openRoom.find('.roomName').click();
            }
            if ($this.children('.arrow').length) {
                $diff.show();
                $thisList.find(".room-content").show();
                $thisList.find(".romLi-more dl").show();
                $this.html(text.replace('展开', '收起').replace('arrow', 'arrow_up'));
            } else {
                $diff.hide();
                $thisList.find(".room-content:gt(0)").hide();
                var $rooms = $thisList.find(".romLi-more");
                $rooms.each(function(index, ele) {
                    $(ele).find('dl:gt(0)').hide();
                });
                $this.html(text.replace('收起', '展开').replace('arrow_up', 'arrow'));
            }
        }

        function showRoomDetail() {
            var $this = $(this);
            var $roomLi = $this.parents('.roomLi');
            $roomLi.toggleClass('open');
            var $thisI = $roomLi.find('.roomName i');
            if ($roomLi.hasClass('open')) {
                $thisI.removeClass('arrow').addClass('arrow_up');
            } else {
                $thisI.removeClass('arrow_up').addClass('arrow');
            }
        }

		$(".hotel-search-btn").click(function () {
			var key = $("#hotelSearchInput").val();
			if ("请输入酒店名称/地标/商圈" == key) {
                $("#keywords").val("");
			} else {
                $("#keywords").val(key);
			}
			searchHotels();
        });
		
		function goBack() {
			history.go(-1);
        }

        $(".xuanze").live("click", function() {
            var $dd = $(this).parents("dd");
            var productId = $dd.data('productid');
            var branchId  = $dd.data('branchid');
            var suppGoodsId = $dd.data('goodsid');
            var roomCount = $dd.siblings(".roomTable-td4").find(".select-div span").text();

            $.ajax({
                type: "post",
                url: baseUrl + "/shopping/changeHotel",
                data: {
                    shoppingUUID: $("#shoppingUUID").val(),
                    hotelId: productId,
                    roomId: branchId,
                    planId: suppGoodsId,
                    roomCount: Number(roomCount)
                },
                success: function() {
                    window.location.href = path;
                },
                error:function() {
                    handelError();
                }
            });
        });

        function handelError() {
            $(".returnAlert").show();
            $('.resortOverlay').stop(true,true).show();
            $("#errorMsgOutTime").html("系统繁忙，请重新查询！");
        }

        $(".fh-return-btn").live("click", function () {
            window.location.href = $('#reloadUrl').val();
        });
	</script>
</body>
</html>
