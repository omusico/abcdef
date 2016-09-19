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
    <link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v6/header_new.css,/styles/v6/public/base.css,/styles/v5/modules/tip.css,/styles/v5/modules/paging.css,/styles/v5/modules/dialog.css,/styles/common/poplogin.css,/styles/lv/calendar.css,/styles/lv/buttons.css">
    <link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v6/flighthotel/fh-result-loading.css,/styles/fit/v3/select.css">
    <link rel="stylesheet" href="${request.contextPath}/css/fh-select.css">


    <script>
        var baseUrl = '${request.contextPath}';
    </script>

    <style>

    .Mybtn {
        border-right: #7b9ebd 1px solid;
        padding-right: 2px;
        border-top: #7b9ebd 1px solid;
        padding-left: 2px;
        font-size: 12px;
        FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0,  StartColorStr=#ffffff,  EndColorStr=#cecfde);
        border-left: #7b9ebd 1px solid;
        cursor: hand;
        color: black;
        padding-top: 2px;
        border-bottom: #7b9ebd 1px solid;
    }

    </style>

    <script>
        var baseUrl = '${request.contextPath}';
    </script>

</head>
<body class="fh-select flight_fit" >
<input type="hidden" id ="basePath" value="${request.contextPath}">
<!-- 流量埋点 -->
    <script src="http://pic.lvmama.com/min/index.php?f=/js/v5/ibm/eluminate.js"></script>
    <script src="http://pic.lvmama.com/min/index.php?f=/js/v5/ibm/coremetrics-initalize.js"></script>
    <script>_LVMAMA_COREMETRICS.init(document.domain);</script>
    <script>
        cmCreatePageviewTag("机酒频道首页_<fh-select>", "FlightHotel", null, null,"-_--_--_--_--_-路径页面");
    </script>
     <script type="text/javascript" src="http://s2.lvjs.com.cn/js/common/losc.js"></script>
    <#if getSuperCommonHeader ??>
    	<!--去掉搜索框-->
 		${getSuperCommonHeader()}
	</#if>
    <!-- banWrap -->

        <#if isBackBooking=='true'>
        <br>
        <h3 style="font-weight: normal;">&nbsp;&nbsp;&nbsp;&nbsp;<a href="${request.contextPath}/back_index" style="color:#21a8dc">首页</a> >
               产品选择页
           </h3>
       </#if>

    <div class="banWrap mt40 <#if searchform.tripType == "DC">fh-single-flight</#if>">
        <!-- 搜索部分 -->
        <form id="myForm" action="${request.contextPath}/search" method="get">
            <input type="hidden" name="shoppingUUID" id ="shoppingUUID" value="${shoppingUUID}">
            <input class="selectPage" type="hidden">
        <div class="fhMain">
            <!-- 搜索部分 -->
            <#if toFlight==null>
            <div class="fh-search clearfix" style="display:block">
            <#else>
            <div class="fh-search clearfix" style="display:none">
            </#if>
                <div class="fh-search-part-group clearfix">
                    <div class="fh-type clearfix" id="flightTypeDiv">
                        <input class="input-flight-type" type="hidden" id="tripType" name="tripType" value="${searchform.tripType}">
                        <a id="wfButton" <#if searchform.tripType == "WF">class="active"</#if> href="javascript:;" data-type="WF"><i></i>往返</a>
                        <a id="dcButton" <#if searchform.tripType == "DC">class="active"</#if> href="javascript:;" data-type="DC"><i></i>单程</a>
                    </div>
                    <div class="fh-search-part fh-search-part-flight clearfix">
                        <i class="icon icon-flight"></i>
                        <div class="fh-input-cities">
                            <div class="fh-input-group">
                            <!--TODO value中填写当前城市 -->
                            <input type="text" id="departureCityName" autocomplete="off" class="input-city input-city JS_select_depa select_depa"  value="${searchform.departureCityName}" placeholder="请输入出发地">
                            <em class="input-info">出发地：</em>
                            <input class="h_select_depa" id="departureCityCode" type="hidden"  name='departureCityCode' value="${searchform.departureCityCode}"/><!-- 隐藏域 存储出发地 -->
                        </div>
                        <div class="fh-input-group">
                            <div class="errTips">与出发地不能为同一城市</div>
                                <input type="text" autocomplete="off" id="arrivalCityName" class="input-city js_destination JS_dest_input JS_select_city JS_select_dest select_dest" value="${searchform.arrivalCityName}" placeholder="请输入目的地">
                                <em class="input-info">目的地：</em>
                                <!--<span class="hotCity">热门：<i class="searchHot">三亚</i><i class="searchHot" >厦门</i><i class="searchHot">成都</i><i class="searchHot">广州</i></span>-->
                            <input class="h_select_dest" id="arrivalCityCode" type="hidden" name="arrivalCityCode" value="${searchform.arrivalCityCode}"/><!-- 隐藏域 存储目的地 -->
                        </div>
                        <a class="change-city" href="javascript:;"></a>
                </div>
                <div class="fh-input-days">
                    <div class="fh-input-group">
                        <!--TODO value中填写当天+2 日期 -->
                        <input type="text" class="input-calendar JS_flight_calendar" id="flightStartDate" name="departureTime" id="departureTime"  readonly="readonly" value="${searchform.departureTime}">
                        <div class="fh-calendar-info">
                            <i class="dayAfterTom" id="flightStartDayOfWeek"></i>
                            <span class="icon icon-calendar"></span>
                        </div>
                        <em class="input-info">去程：</em>
                    </div>
                    <div class="fh-input-group fh-return-day-group">
                    	<div class="roundTrip">往返时间不能超过20天</div>
                        <!--TODO value中填写当天+5 日期 -->
                        <input type="text" class="input-calendar JS_flight_calendar backTracking" id="flightEndDate" name="returnTime" id="returnTime" readonly="readonly" value="${searchform.returnTime}">
                        <div class="fh-calendar-info">
                            <i class="dayAfter5" id="flightEndDayOfWeek"></i>
                            <span class="icon icon-calendar"></span>
                        </div>
                        <em class="input-info">返程：</em>
                    </div>
                </div>
            </div>
            <div class="fh-search-part clearfix">
                <i class="icon icon-hotel"></i>
                <div class="fh-input-group-list">
                    <div class="fh-input-group">
                        <input type="text" autocomplete="off" id="hotelCityName" class="input-city JS_select_city select-hotel" value="${searchform.cityName}" placeholder="请输入您的入住城市">
                        <em class="input-info">入住城市：</em>

                        <input class="h_select_hotel" type="hidden" id="cityCode" name="cityCode" value="${searchform.cityCode}"/><!-- 隐藏域 存储入住城市 -->
                    </div>
                    <div class="fh-input-group mr10">
                        <!--TODO value中填写当天+2 日期 -->
                        <input  id ="hotelStartDate" type="text" class="input-calendar JS_hotel_calendar" name="checkInTime" readonly="readonly" value="${searchform.checkInTime}">
                        <div class="fh-calendar-info">
                            <i class="dayAfterTom" id="hotelStartDayOfWeek"></i>
                            <span class="icon icon-calendar"></span>
                        </div>
                        <em class="input-info">入住：</em>
                    </div>
                    <div class="fh-input-group">
                    	<div class="liveDepart">入住时间不能超过20天</div>
                        <!--TODO value中填写当天+5 日期 -->
                        <input id="hotelEndDate"  type="text" class="input-calendar JS_hotel_calendar checkOut" name="checkOutTime" readonly="readonly" value="${searchform.checkOutTime}">
                        <div class="fh-calendar-info pa">
                            <i class="dayAfter5" id="hotelEndDayOfWeek"></i>
                            <span class="icon icon-calendar"></span>
                        </div>
                        <em class="input-info">离店：</em>
                    </div>
                </div>
            </div>
            <div class="fh-search-part fh-search-part-people clearfix">
                <i class="icon icon-people"></i>
                <div class="fh-input-group-list">
                    <div class="fh-input-group fh-input-group-adult">
                        <input type="hidden" class="JS_people_num" name="adultsCount" id="adultsCount" value="${searchform.adultsCount}"><!-- 隐藏域 存储成人人数 -->
                            <div class="select-div select-people">
                                <span id = "adultCountSpan">${searchform.adultsCount}</span>
                                <em>成人</em>
                                <i></i>
                            </div>
                            <ol id="adaultOl" class="select-people-list JS_adult_list" data-other-list=".JS_child_list">
                                <li data-num="1">1</li>
                                <li data-num="2">2</li>
                                <li data-num="3">3</li>
                                <li data-num="4">4</li>
                                <li data-num="5">5</li>
                                <li data-num="6">6</li>
                                <li data-num="7">7</li>
                                <li data-num="8">8</li>
                                <li data-num="9">9</li>
                            </ol>
                        </div>
                        <div class="fh-input-group fh-input-group-child">
                            <input type="hidden" class="JS_people_num JS_child_num" name="childCount" id="childCount" value="${searchform.childCount}"><!-- 隐藏域 存储儿童人数 -->
                            <div class="select-div select-people">
                                <span id="childCountSpan">${searchform.childCount}</span>
                                <em>儿童（2-12岁）</em>
                                <i></i>
                            </div>
                            <ol id="child" class="select-people-list JS_child_list" data-other-list=".JS_adult_list">
                                <li data-num="0">0</li>
                                <li data-num="1">1</li>
                                <li data-num="2">2</li>
                                <li data-num="3">3</li>
                                <li data-num="4">4</li>
                            </ol>
                        </div>
                    </div>
                </div>
                <!-- 报错信息 -->
                <div class="invalid-city-error"><i class="warning"></i>没有找到该城市<p><span>◆</span><i>◆</i></p></div>
                <div class="same-city-error"><i class="warning"></i>出发城市和到达城市不能相同<p><span>◆</span><i>◆</i></p></div>
            </div>
            <div class="fh-search-btn-group clearfix">
                <a href="javascript:;" class="btn btn-pink fh-search-btn">确认</a>
                <a href="javascript:;" class="btn fh-cancel-btn">取消</a>
            </div>
        </div><!-- //fh-search -->

        <!-- 条件部分 -->
        <#if toFlight==null>
        <div class="fh-condition clearfix" style="display:none">
        <#else>
        <div class="fh-condition clearfix" style="display:block">
        </#if>
            <div class="fh-condition-part fh-condition-part-flight clearfix">
                <i class="icon icon-flight"></i>
                <!-- 出发地 TODO 填写时间，地点-->
                <div class="fh-condition-detail">
                    <div class="fh-top">${searchform.departureCityName}</div>
                    <div class="fh-bottom">${searchform.departureTime}</div>
                </div><!-- //fh-condition-detail -->

                <i class="icon icon-from-to"></i>
                <!-- 目的地 TODO 填写时间，地点-->
                <div class="fh-condition-detail">
                    <div class="fh-top">${searchform.arrivalCityName}</div>
                    <#if backFlight!=null || backFlight!=''>
                    <div class="fh-bottom">${searchform.returnTime}</div>
                    </#if>
                </div><!-- //fh-condition-detail -->
            </div>
            <div class="fh-condition-part fh-condition-part-hotel clearfix">
                <i class="icon icon-hotel"></i>
                <!-- 入住酒店城市 TODO 填写时间，地点-->
                <div class="fh-condition-detail">
                    <div class="fh-top">${searchform.cityName}</div>
                    <div class="fh-bottom">${searchform.checkInTime}<span> 至 </span>${searchform.checkOutTime}<span id="countDay">(${stayDays}晚)</span></div>
                </div><!-- //fh-condition-detail -->
            </div>
            <div class="fh-condition-part fh-condition-part-people clearfix">
                <i class="icon icon-people"></i>
                <div class="fh-center">
                    <span><strong>${searchform.adultsCount}</strong>&nbsp;成人</span>
                    <span><strong>${searchform.childCount}</strong>&nbsp;儿童</span>
                </div>
                 <#if isBackBooking=='true'>
                    <div class="fh-center">
                       <div class="btn btn-pink fh-edit-btn" style="cursor:pointer;">修改</div>
                    </div>
                 </#if>
            </div>

              <#if isBackBooking=='true'>

              <#else>
                 <div class="btn btn-pink fh-edit-btn" style="cursor:pointer;">修改</div>
              </#if>




        </div><!-- //fh-condition -->
    </div><!-- //fhMain -->
    </form>

    <div class="complete-wrap"  id="ctShow"><!--style="width:138px;"-->
    </div>
        <!-- 产品部分 -->
        <div class="fh-product clearfix">
            <!-- 搜索无结果 -->
            <#if toFlight==null>
                <div class="fh-no-result clearfix">
                    <i></i>
                    <p class="suggestion" ></p>
                    <div class="fh-nr-text" >
                        <p class="sorry" style="padding-top:5px;">${errorMsg}</p>
                        <p class="suggestion">请尝试修改上述搜索条件</p>
                    </div>
                </div>
            </#if>

            <#if toFlight!=null>
                <!-- 产品主体 -->
                <div class="fh-product-main">
                    <!-- 机票 -->
                    <#include "flight/flightInfo.ftl">
                    <!--新版酒店开始-->
                    <#if hotel != null>
                    <div class="listMain mt10 bd_ddd">
                        <div class="fh-title fh-flight-title">酒店
                            <span class="pl10 f14 c9">
                                <dfn>${searchform.checkInTime}</dfn> 至 <dfn>${searchform.checkOutTime}</dfn>
                                <span id="countDay">（${stayDays}晚）</span>
                            </span>
                        </div>
                        <div id="hotelInfo">
                        <#include "hotel/hotelInfo.ftl">
                        </div>
                    </div>
                    </#if>
                    <!--新版酒店结束-->

                    <#if toFlight!=null>
                        <div class="fh-pm-xpro">
                            <h3 class="fh-title">可选产品</h3>
                            <ul class="xpro-head clearfix">
                                <li class="xh-type">类型</li>
                                <li class="xh-name">产品名称</li>
                                <li class="xh-price">单价</li>
                                <li class="xh-date">使用日期</li>
                                <li class="xh-count">份数</li>
                            </ul>
                            <div class="xpro-main">
                                <!-- 门票 -->
                                <#if spots?size gt 0 >
                                    <div class="xm-product-box clearfix" id="spotsInfoDiv">
                                        <div class="xh-type">
                                            门票
                                        </div>
                                        <div class="xpb-content">
                                            <#list spots as spot>
                                                <div class="xpb-list" <#if spot_index != 0>style="display:none;"</#if>>
                                                    <div class="xpbl-title"><em <#if spot.spotTickets?size = 1>class="no_gaoguang"</#if> data-productId="${spot.productId}">${spot.productName}<#if spot.spotTickets?size gt 1><i class="arrow"></i></#if></em></div>
                                                    <!-- 默认显示一条 -->
                                                    <#list spot.spotTickets as ticket>
                                                        <div class="xpbl-item clearfix" <#if ticket_index != 0>style="display:none;"</#if> data-id="T${ticket.suppGoodsId}">
                                                            <div class="xh-name"><em title="${ticket.goodsName}">${ticket.goodsName}</em></div>
                                                            <div class="xh-price"><dfn>￥</dfn><span>${ticket.dayTimePriceDtos[0].price}</span></div>
                                                            <div class="xh-date">
                                                                <div class="select-day">
                                                                    <span>请选择游玩日期</span>
                                                                    <i class="arrow"></i>
                                                                </div>
                                                                <ol class="select-day-list">
                                                                    <#list ticket.dayTimePriceDtos as dayPrice>
                                                                        <li data-day="${dayPrice.specDate?string('yyyy-MM-dd')}" data-price="${dayPrice.price}">${dayPrice.specDate?string('yyyy-MM-dd')}</li>
                                                                    </#list>
                                                                </ol>
                                                            </div>
                                                            <div class="xh-count">
                                                                <div class="select-count">
                                                                    <span>0</span>
                                                                    <i class="arrow"></i>
                                                                </div>
                                                                <span class="xh-unit">份</span>
                                                                <ol class="select-count-list ticket-count">
                                                                    <#if ticket.minQuantity gt 0>
                                                                        <li data-count="0">0</li>
                                                                    </#if>
                                                                    <#list ticket.minQuantity..ticket.maxQuantity as num>
                                                                        <li data-count="${num}">${num}</li>
                                                                    </#list>
                                                                </ol>
                                                            </div>
                                                            <i class="xh-check-icon"></i>
                                                        </div>

                                                        <div class="fh-ticket-detail" id="TDTL${ticket.suppGoodsId}">
                                                            <dl class="clearfix">
                                                                <dt>费用说明</dt>
                                                                <dd>
                                                                ${ticket.ticketGoodsDetailDto.priceIncludes}
                                                                </dd>
                                                            </dl>
                                                            <dl class="clearfix">
                                                                <dt>预定时间</dt>
                                                                <dd>
                                                                    游玩当天${ticket.ticketGoodsDetailDto.aheadBookTime}前可下单，请尽早预订，以免耽误您的行程。
                                                                </dd>
                                                            </dl>
                                                            <dl class="clearfix">
                                                                <dt>入园须知</dt>
                                                                <dd>
                                                                    取票时间：${ticket.ticketGoodsDetailDto.changeTime}<br>
                                                                    取票地点：${ticket.ticketGoodsDetailDto.changeAddress}<br>
                                                                    入园方式：${ticket.ticketGoodsDetailDto.enterStyle}<br>
                                                                    <#if ticket.ticketGoodsDetailDto.limitFlag?exists && ticket.ticketGoodsDetailDto.limitFlag == "0">
                                                                        入园限制：请在入园当天的<#if ticket.ticketGoodsDetailDto.limitTime?exists>${ticket.ticketGoodsDetailDto.limitTime?split(":")[0]}</#if>点<#if ticket.ticketGoodsDetailDto.limitTime?exists>${ticket.ticketGoodsDetailDto.limitTime?split(":")[1]}</#if>分以前入园<br>
                                                                    <#else>
                                                                        入园限制：无限制<br>
                                                                    </#if>

                                                                    <#if ticket.ticketGoodsDetailDto.aperiodicFlag?exists && ticket.ticketGoodsDetailDto.aperiodicFlag == "Y">
                                                                        有效期限：（有效期内，仅限入园1次）有效期从${ticket.ticketGoodsDetailDto.startTimeStr?if_exists}到${ticket.ticketGoodsDetailDto.endTimeStr?if_exists}有效。
                                                                    <#else>
                                                                        <#if ticket.ticketGoodsDetailDto.days?exists && ticket.ticketGoodsDetailDto.days == 1>
                                                                            有效期限：（有效期内，仅限入园1次）指定游玩日当天内有效。
                                                                        <#else>
                                                                            有效期限：（有效期内，仅限入园1次）指定游玩日${ticket.ticketGoodsDetailDto.days?if_exists}天内有效。
                                                                        </#if>
                                                                    </#if>
                                                                    <br>
                                                                    详情信息请见：<a href="" target="_blank"></a>
                                                                </dd>
                                                            </dl>
                                                            <dl class="clearfix">
                                                                <dt>重要提示</dt>
                                                                <dd>
                                                                    <#if ticket.ticketGoodsDetailDto.height?exists && ticket.ticketGoodsDetailDto.height ? length gt 0>
                                                                        身高：${ticket.ticketGoodsDetailDto.height}<br>
                                                                    </#if>
                                                                    <#if ticket.ticketGoodsDetailDto.age?exists && ticket.ticketGoodsDetailDto.age ? length gt 0>
                                                                        年龄：${ticket.ticketGoodsDetailDto.age}<br>
                                                                    </#if>
                                                                    <#if ticket.ticketGoodsDetailDto.region?exists && ticket.ticketGoodsDetailDto.region ? length gt 0>
                                                                        地域：${ticket.ticketGoodsDetailDto.region}<br>
                                                                    </#if>
                                                                    <#if ticket.ticketGoodsDetailDto.maxQuantity?exists && ticket.ticketGoodsDetailDto.maxQuantity ? length gt 0>
                                                                        最大限购：${ticket.ticketGoodsDetailDto.maxQuantity}<br>
                                                                    </#if>
                                                                    <#if ticket.ticketGoodsDetailDto.express?exists && ticket.ticketGoodsDetailDto.express ? length gt 0>
                                                                        快递：${ticket.ticketGoodsDetailDto.express}<br>
                                                                    </#if>
                                                                    <#if ticket.ticketGoodsDetailDto.entityTicket?exists && ticket.ticketGoodsDetailDto.entityTicket ? length gt 0>
                                                                        实体票：${ticket.ticketGoodsDetailDto.entityTicket}<br>
                                                                    </#if>
                                                                    <#if ticket.ticketGoodsDetailDto.others?exists && ticket.ticketGoodsDetailDto.others ? length gt 0>
                                                                        其他：${ticket.ticketGoodsDetailDto.others?if_exists}
                                                                    </#if>
                                                                </dd>
                                                            </dl>
                                                            <span class="shouqi">收起<i class="arrow"></i></span>
                                                            <div class="ftd-arrow"><span>◆</span><i>◆</i></div>
                                                        </div>
                                                    </#list>
                                                </div>
                                            </#list>
                                            <#if spots?size gt 1>
                                                <p class="xh-more"><em>更多门票<i class="arrow"></i></em></p>
                                            </#if>
                                        </div>
                                    </div><!-- 门票结束 -->
                                </#if>


                                <!-- 保险 xpb-insurance -->
                                <div class="xm-product-box xpb-insurance clearfix">
                                    <div class="xh-type">
                                        保险
                                    </div>
                                    <div class="xpb-content">
                                        <div class="xpb-list">
                                            <div class="xpbl-title"><em <#if flightInsuranceInfos?size = 1>class="no_gaoguang"</#if>>${flightInsuranceInfos[0].insuranceClass.name}<#if flightInsuranceInfos?size gt 1><i class="arrow"></i></#if></em></div>
                                            <#list flightInsuranceInfos as fInsurance>
                                                <div class="xpbl-item clearfix" data-id="F${fInsurance.id}" data-suppname="${fInsurance.supp.name}" <#if fInsurance_index gt 0>style="display:none;"</#if> >
                                                    <div class="xh-name"><em title="${fInsurance.insuranceRemark}">${fInsurance.insuranceRemark}</em></div>
                                                    <div class="xh-price"><dfn>￥</dfn><span>${fInsurance.insurancePrice}</span></div>
                                                    <div class="xh-time" >--</div>
                                                    <div class="xh-count">
                                                        <div class="select-count">
                                                            <span>0</span>
                                                            <i class="arrow"></i>
                                                        </div>
                                                        <span class="xh-unit">份</span>
                                                        <ol class="select-count-list select-flightInsurance-count-list">
                                                            <li data-count="0">0</li>
                                                        </ol>
                                                        <i class="fh-icon-ques" tip-content="每程每人各一份"></i>
                                                    </div>
                                                    <i class="xh-check-icon"></i>
                                                </div>

                                                <div class="fh-ticket-detail" id="TDTL${fInsurance.id}">
                                                    <dl class="clearfix">
                                                        <dt>描述</dt>
                                                        <dd>
                                                        ${fInsurance.insuranceDesc}
                                                        </dd>
                                                    </dl>
                                                    <span class="shouqi">收起<i class="arrow"></i></span>
                                                    <div class="ftd-arrow"><span>◆</span><i>◆</i></div>
                                                </div>
                                            </#list>
                                        </div>

                                        <#if insuranceMap??>
                                        <#list insuranceMap?keys as key>
                                            <div class="xpb-list" id="insuranceList">
                                                <div class="xpbl-title"><em <#if insuranceMap[key]?size == 1>class="no_gaoguang"</#if>>${insuranceMap[key][0].productName}<#if insuranceMap[key]?size gt 1><i class="arrow"></i></#if></em></div>
                                                <#list insuranceMap[key] as suppGood >
                                                <div class="xpbl-item clearfix" data-id="I${suppGood.suppGoodsId }" <#if suppGood_index gt 0>style="display:none;"</#if> >
                                                    <div class="xh-name"><em title="${suppGood.goodsName } -- ${branch.branchName }">${suppGood.goodsName } -- ${branch.branchName} </em></div>
                                                    <div class="xh-price"><dfn>￥</dfn><span>${suppGood.price}</span></div>
                                                    <div class="xh-time" >--</div>
                                                    <div class="xh-count">
                                                        <div class="select-count">
                                                            <span>0</span>
                                                            <i class="arrow"></i>
                                                        </div>
                                                        <span class="xh-unit">份</span>
                                                        <ol class="select-count-list select-insurance-list"></ol>
                                                    </div>
                                                    <i class="xh-check-icon "></i>
                                                </div>

                                                <div class="fh-ticket-detail" id="TDTL${suppGood.suppGoodsId}">
                                                    <dl class="clearfix">
                                                        <dt>描述</dt>
                                                        <dd>
                                                        ${suppGood.branchDesc}
                                                        </dd>
                                                    </dl>
                                                    <span class="shouqi">收起<i class="arrow"></i></span>
                                                    <div class="ftd-arrow"><span>◆</span><i>◆</i></div>
                                                </div>
                                                </#list>
                                            </div>
                                        </#list>
                                        <p class="insurance-warning"><i class="fh-icon fh-icon-warning"></i>为了您再出游过程中获得更为全面的保障，强烈建议旅游者出游时间根据个人意愿和需要，自行投保人参意外伤害保险等个人险种。</p>
                                        </#if>
                                    </div>
                                </div><!-- 保险 xpb-insurance end -->
                            </div>
                        </div> <!-- 可选产品结束 fh-pm-xpro-->
                    </#if>
                </div>
            </#if>
            <!-- 列表结束 -->

                <#if toFlight!=null>
		            <div class="fh-product-side"
		             <#if isBackBooking=='true'>
		              style=" left: 56%;
             margin-left: 250px;
             position: fixed;
             z-index: 9;"
                   </#if>
		            >
		                <h3 class="fh-title">费用明细</h3>
                    <div class="fh-price-box">
    		                <div class="market-price">
    		                    <span class="price"><i class="price-rmb">¥</i><em id="totalPrice"></em></span>
    		                    <span class="name">
                                    <#if hotel != null>套餐价：<#else>机票价格：</#if>
                                </span>
    		                </div>
                        <p class="price-des">以上费用均已含机建费、燃油费</p>
                        <dl class="price-list" id="price-list">
		                        <dt class="clearfix">
		                            <span class="price"><i class="price-rmb">¥</i><em id="productPrice">0</em></span>
		                            <span class="name">可选产品</span>
		                        </dt>
                            <div id="ticket_price_list"></div>
                            <div id="fli_ins_price_list"></div>
                            <div id="insurance_price_list"></div>
                        </dl>
                    </div>
                    <div class="price-discount">
                        <span class="price">-<i class="price-rmb">¥</i><em id="promotion"></em></span>
                        <span class="name">
                            <#if hotel != null>套餐优惠：<#else>优惠：</#if>
                        </span>
                    </div>
                    <div class="lvmama-price">
                        <span class="price"><i class="price-rmb">¥</i><em id="salesPrice"></em></span>
                        <span class="name">应付总价：</span>
                    </div>
		                <a href="javascript:;" class="btn btn-orange btn-block fh-order-btn">下一步，订单填写</a>
		            </div><!-- //fh-product-side -->
                </#if>
		        </div>
                <!-- 费用明细 -->
		</div><!-- //酒店结果结束 listMain -->
    <!-- 门票保险规则 -->


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
    <!-- 城市列表 -->
    <div class="city_mdd">
    </div>
    <!-- //city_mdd结束 -->

    <!-- 出发城市列表 -->
    <div class="city_mdd_depa">
        <!-- <p>支持中文/拼音/简拼输入</p> -->
        <#include "city.ftl">
    </div>
    <!-- 到达城市列表 -->
    <div class="city_mdd_dest">
        <#include "city.ftl">
    </div>
 	<!-- 酒店城市列表 -->
    <div class="city_mdd_hotel">
        <#include "city.ftl">
    </div>

    <!--请求计算价格失败弹框 start  -->
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
            <p>您选择的航班已售完，请更换条件重新查询</p>
        </div>
        <div class="sorryBtn">
            <input id="reloadUrl" type="hidden" value=""/>
            <a href="javascript:;" class="fh-return-btn">重新查询</a>
        </div>
    </div>

    <div id="coustomerDialog" style="display:none;">

       <ul>
        	<input id="searchName" name="searchName" type="text" placeholder="(模糊查询)会员名称/收集/邮箱/会员卡号"  style="width: 300px;height:30px;border:1px solid #e4e4e4;}" />
        	    <br>
                 <input type="button" onclick="checkAccount();" value="核对账号" class="Mybtn"/></span>&nbsp;&nbsp;&nbsp;&nbsp;
                 <input type="button" onclick="showRegUserAccount();" value="注册新用户" class="Mybtn"/></span>
                 <br>
               (<span style="color:red;">注：输入信息识别用户帐号，无账号则输入手机号注册新用户</span>)
            <table width="100%" border="1" id="table01" style="display:none;" class="table">
            </table>

			<div id="regist_userMobile" style="display:none">
				<input class="inputtxt per28" id="userPhone" name="userPhone" type="text" placeholder="请输入11位的手机号码" />
				<span class="bluebut"><a href="javascript:regUserAccount()">确定</a></span>
			</div>
            <div id="search_user_list" ></div>
        </ul>

    </div>
    <!-- 大图模板 -->
    <div class="img-dialog">
        <img src="" alt="" width="300" height="200">
    </div>

    <input id="_requestPath" type="hidden" value="${request.contextPath}">
    <input id="isBackBooking" type="hidden" value="${isBackBooking}">
    <input id="errorMsgOutTime" type="hidden" value="${errorMsg}">

    <#include "hotel/hotel_detail.ftl"/>
    <!-- 正在加载弹层 END-->
    <!-- 地图js -->
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=1.4"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/DistanceTool/1.2/src/DistanceTool_min.js"></script>

	<script src="http://pic.lvmama.com/min/index.php?f=/js/new_v/jquery-1.7.2.min.js,/js/v6/header_new.js,/js/ui/lvmamaUI/lvmamaUI.js,/js/v5/modules/pandora-poptip.js,/js/v5/modules/pandora-dialog.js,/js/common/poplogin.js,/js/lv/calendar.js,/js/common/losc.js"></script>
    <script src="http://pic.lvmama.com/min/index.php?f=/js/v6/flighthotel/fh-flight-tip.js,/js/v6/flighthotel/fh-select-alert.js,/js/fit/v3/select.js,/js/fit/v3/search.js"></script>

	  <#if isBackBooking=='true'>
       <#else>
	       <#include "online_foot.ftl">
       </#if>

	<script src="${request.contextPath}/js/common/login.js"></script>
    <!-- hotelAlert 酒店弹窗 start 包括：详情、点评、地图 -->
    <script src="${request.contextPath}/js/common/common.js"></script>
    <script src="${request.contextPath}/js/moment.js"></script>

    <link type="text/css" rel="stylesheet" href="${request.contextPath}/js/jquery-dialog/jquery-ui-1.8.9.custom.css" />
    <script language="javascript" src="${request.contextPath}/js/jquery-dialog/jquery-ui-1.8.9.custom.min.js"></script>
	<!-- hotelAlert 酒店弹窗结束 -->
    <script src="${request.contextPath}/js/fh-select.js"></script>
    <script src="${request.contextPath}/js/fh-hotel-detail.js"></script>
</body>
</html>
