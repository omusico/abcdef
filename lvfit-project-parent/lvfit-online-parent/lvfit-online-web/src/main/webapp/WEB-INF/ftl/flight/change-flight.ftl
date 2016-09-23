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
            <input type="hidden" name="shoppingUUID" id="shoppingUUID" value="${req.shoppingUUID}">
            <input type="hidden" name="flightTripType" id="flightTripType" value="${req.flightType}">
            <input type="hidden" name="sortField" id="sortField" value="DIFF_PRICE">
            <input type="hidden" name="sortType" id="sortType" value="ASC">
            <input type="hidden" name="flightNo" id="flightNo" value="${flightInfos[0].flightNo}">
			<#if req.flightType == "DEPARTURE">
            	<!-- filter-head 去程头部 添加hide类可以隐藏-->
	            <div class="filter-head yh f18 c9 ">
	                <a href="javascript:;" class="btn btn-pink btn-lg pr">
                        <span class="btn-text">返回上一页</span>
                    </a><i class="fh-icon-depa"></i>更换去程航班：
                    <span class="c3 pl10">${flightInfos[0].departureCityName}<i class="fh-icon-from-to"></i><i class="pr15">${flightInfos[0].arrivalCityName}</i><dfn class="arial f16">${flightInfos[0].departureDate}</dfn></span>
	            </div><!-- //filter-head-->
			</#if>
			<#if req.flightType == "RETURN">
                <!-- filter-head 返程头部 已添加hide类隐藏-->
	            <div class="filter-head yh f18 c9 ">
	                <a href="javascript:;" class="btn btn-pink btn-lg pr">
                        <span class="btn-text">返回上一页</span>
                    </a><i class="fh-icon-dest"></i>更换返程航班：
                    <span class="c3 pl10">${flightInfos[0].departureCityName}<i class="fh-icon-from-to"></i><i class="pr15">${flightInfos[0].arrivalCityName}</i><dfn class="arial f16">${flightInfos[0].departureDate}</dfn></span>
	            </div><!-- //filter-head-->
            </#if>
           
            <div class="search_kind">
                <dl class="clearfix js_fuxuan f_start" id="depTimeSegmentCondition">
                    <dt>起飞时间</dt>
                    <dd class="kind_buxian active"><a class="search_arrow_1" href="javascript:;" data-code="">不限</a></dd>
                    <#list departureTimeSegment as departureTime>
                    	<dd data-type="depTimeSegment" data-code="${departureTime.fieldValue}">
                    		<a href="javascript:;" class="screen_condition"><i class="ph_icon hotel_ck"></i>${departureTime.fieldDesc?replace(",", "(") + ")"}</a>
                    	</dd>
					</#list>
                </dl>
            </div><!-- //search_kind -->
            
            <div class="search_kind">
                <dl class="clearfix js_fuxuan f_reach" id="arrivalTimeSegmentCondition">
                    <dt>到达时间</dt>
                    <dd class="kind_buxian active"><a class="search_arrow_1" href="javascript:;" data-code="">不限</a></dd>
                    <#list arrivalTimeSegment as arrivalTime>
                    	<dd data-type="arrivalTimeSegment" data-code="${arrivalTime.fieldValue}">
							<a href="javascript:;" class="screen_condition"><i class="ph_icon hotel_ck"></i>${arrivalTime.fieldDesc?replace(",", "(") + ")"}</a>
						</dd>
                   </#list>
                </dl>
            </div> <!-- //search_kind -->

            <div class="search_kind f_airport_company">
                <dl class="clearfix js_fuxuan" id="carrierNameCodeCondition">
                    <dt>航空公司</dt>
                    <dd class="kind_buxian active"><a class="search_arrow_1" href="javascript:;" data-code="">不限</a></dd>
                     <#list carrierNameCode as carrierName>
                    	<dd data-type="carrierNameCode" data-code="${carrierName.fieldValue}">
						 	<a href="javascript:;" class="screen_condition"><i class="ph_icon hotel_ck"></i>${carrierName.fieldDesc}</a>
						</dd>
                    </#list>
                </dl>
                <#if carrierNameCode?size gt 8>
                	 <a class="search_gd js_moreSearch">更多<i class="arrow"></i></a>
                </#if>
            </div><!-- //search_kind -->
            
            <#if departureAirportNameCode ?? && departureAirportNameCode?size gt 1>
            <div class="search_kind f_dept_airport">
                <dl class="clearfix js_fuxuan" id="depAirportNameCodeCondition">
                    <dt>起飞机场</dt>
                    <dd class="kind_buxian active"><a class="search_arrow_1" href="javascript:;" data-code="">不限</a></dd>
                    <#list departureAirportNameCode as item>
                    	<dd data-type="depAirportNameCode" data-code="${item.fieldValue}">
                    	<a href="javascript:;" class="screen_condition"><i class="ph_icon hotel_ck"></i>${item.fieldDesc}</a>
                    	</dd>
					</#list>
                </dl>
            </div>
            </#if>
            <#if arrivalAirportNameCode ?? && arrivalAirportNameCode?size gt 1>
            <div class="search_kind f_arri_airport">
                <dl class="clearfix js_fuxuan" id="arvAirportNameCodeCondition">
                    <dt>降落机场</dt>
                    <dd class="kind_buxian active"><a class="search_arrow_1" href="javascript:;" data-code="">不限</a></dd>
                    <#list arrivalAirportNameCode as item>
                    	<dd data-type="arvAirportNameCode" data-code="${item.fieldValue}">
                    	<a href="javascript:;" class="screen_condition"><i class="ph_icon hotel_ck"></i>${item.fieldDesc}</a>
                    	</dd>
					</#list>
                </dl>
            </div>
            </#if>
			
            <div class="request clearfix">
                <p class="result c9"><dfn class="f16 cf60 bold pr5" id="flight_num">${flightCount}</dfn>条航班</p>
                <dl class="request_list" style="display: none;">
                    <dt>您已选择：</dt>
					<dd id="conditions"></dd>
					<dd><a class="close_all" href="javascript:closeAll();">清除所有条件</a></dd>
                </dl>
            </div><!-- //request -->
        </div><!-- //filter 筛选结束-->
          
        <!-- 产品部分 -->
        <div class="fh-product clearfix" id="div-fh-product">
        <#include "flight/change_flight_list.ftl">
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
        	<input id="reloadUrl" name="reloadUrl" type="hidden" />
            <a href="javascript:;" class="fh-return-btn">重新查询</a>
        </div>
    </div>
	<#if isBackBooking=='true'>
	<#else>
		<#include "online_foot.ftl">
	</#if>
    <script src="http://pic.lvmama.com/min/index.php?f=/js/new_v/jquery-1.7.2.min.js,/js/v6/header_new.js,/js/v5/modules/pandora-poptip.js,/js/common/losc.js"></script>
    <script src="http://pic.lvmama.com/min/index.php?f=/js/fit/v3/select-flight.js,/js/v6/flighthotel/fh-flight-tip.js"></script>
	<script src="${request.contextPath}/js/common/common.js"></script>
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
            initChooseBtn();
        });

        //点击返回上一页
        $(".btn-text").click(function(){
            goBack();
        });

        function goBack() {
            history.go(-1);
        }

		$(".fh-select-btn").live("click", function (e) {
            var event = e || window.event;
            event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);

            var shoppingUUID = $("#shoppingUUID").val();
            var flightNo = $(this).parents(".seat-info").data("flightno");
            var seatCode = $(this).parents(".seat-info").data("code");
            var flightType = $("#flightTripType").val();
            $.ajax({
                type: "post",
                url: "${request.contextPath}/shopping/changeFlight",
                data: {
                    shoppingUUID : shoppingUUID,
                    flightNo: flightNo,
                    seatCode: seatCode,
                    flightType: flightType
                },
                success: function() {
                    window.location.href = path;
                },
                error : function () {
                    handelError();
                }
            });
        });
        // 筛选条件点击
        $(".search_kind dd:not(:first)").live("click", function(e){
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
            // 筛选航班
            filterFlight();
        });

        // 点击[不限]按钮
        $(".kind_buxian").live("click", function(e){
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
            // 筛选航班
            filterFlight();
        });

		function addConditions() {
            $("#conditions").html("");
			var str = "";
            str += addCondition( $("#depTimeSegmentCondition") );
            str += addCondition( $("#arrivalTimeSegmentCondition") );
            str += addCondition( $("#carrierNameCodeCondition") );
            str += addCondition( $("#depAirportNameCodeCondition") );
            str += addCondition( $("#arvAirportNameCodeCondition") );

			if (str === "") {
                $(".request_list").hide();
			} else {
                $("#conditions").append(str);
                $(".request_list").show();
            }
        }

		function addCondition($dl) {
			var $list = $dl.find("dd:not(:first)");
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
		// 删除单个筛选条件
        function requestClose($span){
            var type = $span.data("type");
            var code = $span.data("code");
            var queryStr = "";
            $(".search_kind dd:not(:first)").each(function() {
                var itemType = $(this).data("type");
                var itemCode = $(this).data("code");
                if( itemType === type && itemCode === code){
                    $(this).trigger("click");
                }
            });
        }
        // 删除所有筛选条件
		function closeAll() {
            $(".kind_buxian").trigger("click");
		}

        function filterFlight() {
            var shoppingUuid = $("#shoppingUUID").val();
            var flightTripType = $("#flightTripType").val();
            var depTimeSegmentKey = getRequestKey( $("#depTimeSegmentCondition") );
            var arvTimeSegmentKey = getRequestKey( $("#arrivalTimeSegmentCondition") );
            var carrierNameCodeKey = getRequestKey( $("#carrierNameCodeCondition") );
            var depAirportNameCodeKey = getRequestKey( $("#depAirportNameCodeCondition") );
            var arvAirportNameCodeKey = getRequestKey( $("#arvAirportNameCodeCondition") );
            $.ajax({
                type: "post",
                url: "${request.contextPath}/shopping/filterFlight",
                data: {
                    shoppingUuid : shoppingUuid,
                    flightTripType : flightTripType,
                    depTimeSegmentKey : depTimeSegmentKey,
                    arvTimeSegmentKey : arvTimeSegmentKey,
                    carrierNameCodeKey : carrierNameCodeKey,
                    depAirportNameCodeKey : depAirportNameCodeKey,
                    arvAirportNameCodeKey : arvAirportNameCodeKey,
                    sortField : $("#sortField").val(),
                    sortType : $("#sortType").val()
                },
                success: function(data) {
                    $("#div-fh-product").html(data);
                    $(".plane-type").live("mouseenter", showPlanInfo);
                    $(".plane-type").live("mouseout", hidePlanInfo);
                    initFlightTab();
                    countFlight();
                    initChooseBtn();
                },
                error : function () {
                    handelError();
                }
            });
        }

        /**
         * 得到每个筛选添加请求key
         */
        function getRequestKey($dl) {
            var $list = $dl.find("dd:not(:first)");
            var key = "";
            $list.each(function () {
                if ($(this).hasClass("active")) {
                    key += $(this).data("code") + ",";
                }
            });
            if (key !== "") {
                key = key.substring(0, key.length-1);
            }
            return key;
        }

        function countFlight() {
            $("#flight_num").text( $(".flight-detail").size() );
        }

        function sortFunction (obj){
            var $em = $(obj).find("em");
            var $col = $(obj).parents(".flight-col");
            if($col.hasClass("flight-time")) {
                $("#sortField").val("DEPARTURE_TIME");
            } else if($col.hasClass("flight-diff")){
                $("#sortField").val("DIFF_PRICE");
            }

            if ($em.hasClass("sort_up")) {
                $("#sortType").val("DESC");
            } else {
                $("#sortType").val("ASC");
            }
            filterFlight();
        }

        function initFlightTab() {
            var sortField = $("#sortField").val();
            var sortType = $("#sortType").val();

            $(".flight-col").find("a").removeClass("active");
            if (sortField == "DEPARTURE_TIME") {
                $(".flight-time").find("a").addClass("active");
                if (sortType == "ASC") {
                    $(".flight-time").find("a").find("em").addClass("sort_up");
                    $(".flight-time").find("a").find("em").removeClass("sort_down");
                } else {
                    $(".flight-time").find("a").find("em").addClass("sort_down");
                    $(".flight-time").find("a").find("em").removeClass("sort_up");
                }
            } else {
                $(".flight-diff").find("a").addClass("active");
                if (sortType == "ASC") {
                    $(".flight-diff").find("a").find("em").addClass("sort_up");
                    $(".flight-diff").find("a").find("em").removeClass("sort_down");
                } else {
                    $(".flight-diff").find("a").find("em").addClass("sort_down");
                    $(".flight-diff").find("a").find("em").removeClass("sort_up");
                }
            }
        }

        function handelError() {
            $(".returnAlert").show();
            $('.resortOverlay').stop(true,true).show();
            $("#errorMsgOutTime").html("系统繁忙，请重新查询！");
        }

        function showPlanInfo() {
            var $this = $(this);
            var $planeInfoDetail = $(".plane-info-detail");
            var thisL = $this.offset().left,
                    thisT = $this.offset().top,
                    thisH = $this.outerHeight(true);
            $planeInfoDetail.find(".pi-plan").text($this.data("plan"));
            $planeInfoDetail.find(".pi-name").text($this.data("name"));
            $planeInfoDetail.find(".pi-type").text($this.data("type"));
            $planeInfoDetail.find(".pi-min").text($this.data("min"));
            $planeInfoDetail.find(".pi-max").text($this.data("max"));
            $('.plane-info').show().css({
                'left': thisL,
                'top': thisT + thisH + 4
            });
        }

        function hidePlanInfo() {
            var timeId = setTimeout(function() {
                        $('.plane-info').hide();
                    },
                    300);
            $('.plane-info').mouseenter(function() {
                clearTimeout(timeId);
            }).mouseleave(function() {
                $(this).hide();
            });
        }

        $(".fh-return-btn").live("click", function () {
            window.location.href = $('#reloadUrl').val();
        });

        function initChooseBtn() {
            var flightNo = $("#flightNo").val();
            $(".flight-detail").find(".seat-info:eq(0)").each(function () {
                if ($(this).data("flightno") == flightNo) {
                    $(this).find(".chooseBtnDiv").html("<a href=\"javascript:void(0);\" class=\"fh-selected\">已选<i class=\"icon icon-selected\"></i></a>");
                } else {
                    $(this).find(".chooseBtnDiv").html("<a href=\"javascript:void(0);\" class=\"btn btn-sm btn-orange fh-select-btn\">选择</a>");
                }
            });
        }
    </script>
</body>

</html>
