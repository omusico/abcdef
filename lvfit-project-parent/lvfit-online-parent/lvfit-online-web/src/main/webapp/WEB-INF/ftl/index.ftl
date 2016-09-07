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
    <link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v6/header_new.css,/styles/v6/public/base.css,/styles/v5/modules/tip.css,/styles/lv/calendar.css,/styles/fit/v3/index.css">
    <link rel="stylesheet" href="${request.contextPath}/css/fh-select.css">
</head>

<body class="fh-index flight_fit">
<script src="http://pic.lvmama.com/min/index.php?f=/js/v5/ibm/eluminate.js"></script>
<script src="http://pic.lvmama.com/min/index.php?f=/js/v5/ibm/coremetrics-initalize.js"></script>

<script>_LVMAMA_COREMETRICS.init(document.domain);</script>
<script>
    cmCreatePageviewTag("机酒频道首页_<fh-search>", "FlightHotel", null, null,"-_--_--_--_--_-路径页面");
</script>
<script type="text/javascript" src="http://s2.lvjs.com.cn/js/common/losc.js"></script>

<!-- 公共头部开始    -->
<div id="headerInfo" style="visibility:hidden">
<#if getSuperCommonHeader ??>
    <#if isNew>
        ${getSuperCommonHeader('company',true,'${provinceId}','${cityId}','${stationName}','index')}
    <#else>
        ${getSuperCommonHeader()}
    </#if>
</#if>
</div>

<input type="hidden" id="base_path" value="${request.contextPath}">
    <!-- banWrap -->
    <form id="myForm" action="${request.contextPath}/search/${uuid}" method="get">
    <!--  <input type= "hidden",name="shoppingUUID" value="${ShoppingUUID}}"/> -->
    <div class="banWrap mt40">
        <!-- 搜索 -->
        <div class="fhMain">
            <div class="fh-search">
                <div class="fh-title">
                    <h3>机票+酒店套餐</h3>
                    自由搭配随心旅行!
                </div>
                <div class="fh-flight-part clearfix">
                    <i class="icon-flight"></i>
                    <div class="fh-type clearfix">
                        <!-- 隐藏域 存储机票类型 往返:WF, 单程:DC 可在下面data-type进行配置-->
                        <input id="tripType" name="tripType" class="input-flight-type" type="hidden" value="WF">
                        <a id="wfButton" class="active" href="javascript:;" data-type="WF"><i></i>往返</a>
                        <a id="dcButton" href="javascript:;" data-type="DC"><i></i>单程</a>
                    </div>
                    <div class="fh-input-cities">
                        <div class="fh-input-group">
                            <!--TODO value中填写当前城市 -->
                            <input type="text" autocomplete="off"  id="departureCityName" class="input-city js_destination JS_select_city JS_select_depa select_depa" value="" placeholder="请输入出发地">
                            <input class="h_select_depa" type="hidden" id="departureCityCode" name="departureCityCode" value=""/><!-- 隐藏域 存储出发地 -->
                            <em class="input-info">出发地：</em>
                        </div>
                        <div class="fh-input-group">
                            <input type="text" autocomplete="off" id="arrivalCityName"  class="input-city js_destination JS_dest_input JS_select_city JS_select_dest select_dest" placeholder="请输入目的地">
                            <input class="h_select_dest" type="hidden" id="arrivalCityCode" name="arrivalCityCode" value=""/><!-- 隐藏域 存储目的地 -->
                            <em class="input-info">目的地：</em>
                        </div>
                        <a class="change-city" href="javascript:;"></a>
                    </div>
                    <div class="fh-input-days">
                        <div class="fh-input-group">
                            <!--TODO value中填写当天+2 日期 -->
                            <input type="text" name="departureTime" id="flightStartDate" class="input-calendar JS_flight_calendar" readonly="readonly" value="">
                            <div class="fh-calendar-info">
                                <i class="dayAfterTom" id="flightStartDayOfWeek"></i>
                                <span class="icon icon-calendar"></span>
                            </div>
                            <em class="input-info">去程：</em>
                        </div>
                        <div class="fh-input-group fh-return-day-group">
                            <!--TODO value中填写当天+5 日期 -->
                            <input type="text" id="flightEndDate" name="returnTime" class="input-calendar JS_flight_calendar backTracking" readonly="readonly" value="">
                            <div class="fh-calendar-info">
                                <i class="dayAfter5" id="flightEndDayOfWeek"></i>
                                <span class="icon icon-calendar"></span>
                            </div>
                            <em class="input-info">返程：</em>
                        </div>
                    </div>
                </div>
                <div class="fh-hotel-part clearfix">
                    <i class="icon-hotel"></i>
                    <div class="fh-input-group fh-hotel-city">
                        <input type="text" autocomplete="off" id="hotelCityName"  class="input-city js_destination JS_select_city select-hotel" placeholder="请输入您的入住城市">
                        <input class="h_select_hotel" type="hidden" id="cityCode" name="cityCode" value=""/><!-- 隐藏域 存储入住城市 -->
                        <em class="input-info">入住城市：</em>
                    </div>
                    <div class="fh-input-group fh-hotel-start">
                        <!--TODO value中填写当天+2 日期 -->
                        <input id="hotelStartDate" type="text" name="checkInTime" class="input-calendar JS_hotel_calendar" readonly="readonly">
                        <div class="fh-calendar-info">
                            <i class="dayAfterTom" id="hotelStartDayOfWeek"></i>
                            <span class="icon icon-calendar"></span>
                        </div>
                        <em class="input-info">入住：</em>
                    </div>
                    <div class="fh-input-group fh-hotel-end">
                        <!--TODO value中填写当天+5 日期 -->
                        <input id="hotelEndDate" type="text" name="checkOutTime" class="input-calendar JS_hotel_calendar checkOut" readonly="readonly">
                        <div class="fh-calendar-info">
                            <i class="dayAfter5" id="hotelEndDayOfWeek"></i>
                            <span class="icon icon-calendar"></span>
                        </div>
                        <em class="input-info">离店：</em>
                    </div>
                </div>
                <div class="fh-people-part clearfix">
                    <i class="icon-people"></i>
                    <div class="fh-input-group fh-people-adult">
                        <input type="hidden" name="adultsCount" id="adultsCount" class="JS_people_num " value="2"><!-- 隐藏域 存储成人人数 -->
                        <div class="select-div select-people">
                            <span id="adultCountSpan">2</span>
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
                    <div class="fh-input-group fh-people-child">
                        <input type="hidden" name="childCount" id="childCount" class="JS_people_num JS_child_num" value="0"><!-- 隐藏域 存储儿童人数 -->
                        <div class="select-div select-people">
                            <span id="childCountSpan">0</span>
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
                    <a href="javascript:;" class="fh-search-btn">搜索机+酒套餐</a>
                </div>
                <!-- 报错信息 -->
                <div class="invalid-city-error"><i class="warning"></i>没有找到该城市<p><span>◆</span><i>◆</i></p></div>
                <div class="same-city-error"><i class="warning"></i>出发城市和到达城市不能相同<p><span>◆</span><i>◆</i></p></div>
            </div>
            <div class="fh-slider">
                <a class="slider-btn slider-btn-left" href="javascript:;"><i class="left"></i></a>
                <a class="slider-btn slider-btn-right" href="javascript:;"><i class="right"></i></a>
                <ul class="slider-pic-box">
                   <li>
                        <a id="sanyaLink" href="" target="_blank">
                            <img width="581" height="355" src="${request.contextPath}/img/sanya.jpg">
                        </a>
                    </li>
                    <li>
                        <a id="xiamenLink" href="" target="_blank">
                            <img width="581" height="355" src="${request.contextPath}/img/xiamen.jpg">
                        </a>
                    </li>
                    <li>
                        <a id="guilinLink" href="" target="_blank">
                            <img width="581" height="355" src="${request.contextPath}/img/guilin.jpg">
                        </a>
                    </li>
                    <li>
                        <a id="qindaoLink" href="" target="_blank">
                            <img width="581" height="355" src="${request.contextPath}/img/qindao.jpg">
                        </a>
                    </li>
                    <li>
                        <a id="yunnanLink" href="" target="_blank">
                            <img width="581" height="355" src="${request.contextPath}/img/yunnan.jpg">
                        </a>
                    </li>
                </ul>
                <ul class="slider-tab-box"></ul>
            </div>
        </div>
        <!-- //fhMain -->
    </div>
    </form>
    <!-- //banWrap结束 -->
    <div class="main-wrap">
        <#include "recommendInfo.ftl">
    </div>

    <div class="complete-wrap"  id="ctShow"><!--style="width:138px;"-->

    </div>
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


    <!-- //city_mdd结束 -->
    <div class="hh_cooperate">
    <#if friendList?? && friendList?size gt 0>
        <p><b>友情链接：</b><span>
            <#list friendList as seoFriendLink>
                <#assign linkUrl = seoFriendLink.friendLinkUrl/>
                <#if linkUrl?if_exists>
                    <#if linkUrl?contains("http://")>
                        <a href="${linkUrl}" target="_blank" hidefocus="false">${seoFriendLink.friendLinkName?if_exists}</a>
                    <#else>
                        <a href="http://${linkUrl}" target="_blank" hidefocus="false">${seoFriendLink.friendLinkName?if_exists}</a>
                    </#if>
                <#else>
                    <a href="#" target="_blank" hidefocus="false">${seoFriendLink.friendLinkName?if_exists}</a>
                </#if>
            </#list>
        </span></p>
    </#if>
    <#if innerList?? && innerList?size gt 0>
    <p><b>热门精选：</b><span>
        <#list innerList as innerLink>
            <#assign linkUrl = innerLink.linkUrl/>
            <#if linkUrl?if_exists>
                <#if linkUrl?contains("http://")>
                    <a href="${linkUrl}" target="_blank" hidefocus="false">${innerLink.linkName?if_exists}</a>
                <#else>
                    <a href="http://${linkUrl}" target="_blank" hidefocus="false">${innerLink.linkName?if_exists}</a>
                </#if>
            <#else>
                <a href="#" target="_blank" hidefocus="false">${innerLink.linkName?if_exists}</a>
            </#if>
        </#list>
    </span></p>
</#if>
</div>
    <div class="footer_links"></div>
    <script src="http://pic.lvmama.com/min/index.php?f=/js/new_v/jquery-1.7.2.min.js,/js/v6/header_new.js,/js/ui/lvmamaUI/lvmamaUI.js,/js/v5/modules/pandora-poptip.js,/js/lv/calendar.js,/js/common/losc.js"></script>
    <script src="http://pic.lvmama.com/min/index.php?f=/js/fit/v3/search.js,/js/fit/v3/index.js"></script>
    <script src="${request.contextPath}/js/common/common.js"></script>
    <script src="${request.contextPath}/js/moment.js"></script>
    <script src="${request.contextPath}/js/fh-index.js"></script>
</body>

</html>
