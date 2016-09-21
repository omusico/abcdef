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
    <link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v6/header_new.css,/styles/v6/public/base.css,/styles/v5/modules/tip.css,/styles/v5/modules/calendar.css,/styles/fit/flighthotel.css">

   

 	<style type="text/css">
        .complete-wrap {
            background: #fff;
            width: 158px;
            border: #ddd solid 1px;
            overflow: hidden;
            box-shadow: 0px 2px 4px #ccc;
            z-index: 99;
            position: absolute;
            display: none;
            max-height:300px;
            margin-top:-1px;
        }
        .complete-wrap a:hover, .complete-wrap li.active a {color: #FF6600;cursor:pointer;background-color:#F5F5F5;}
        .fh-input-group{position:relative;}
        .fh-input-group .hotCity{
            position:absolute;
            right:-9px;
            top:-20px;
            width: 165px;
        }
        .fh-input-group .hotCity i {
            padding: 9px 12px 9px 0;
            margin-right: -5px;
            color: #dd3377;
            font-size: 12px;
        }
        .fh-input-group .hotCity i:hover{
            cursor:pointer;
        }
        .errTips {
		    display: none;
		    position: absolute;
		    top: 34px;
		    left: 0px;
		    width: 158px;
		    height: 27px;
		    z-index: 10;
		    color: #E38;
		    font-size: 10px;
		    line-height: 27px;
		    text-align: center;
		    font-family: 微软雅黑;
        }
    </style>


<body class="fh-index flight_fit">
<script src="http://pic.lvmama.com/min/index.php?f=/js/v5/ibm/eluminate.js"></script>
<script src="http://pic.lvmama.com/min/index.php?f=/js/v5/ibm/coremetrics-initalize.js"></script>
	
<script>_LVMAMA_COREMETRICS.init(document.domain);</script>
<script>
    cmCreatePageviewTag("机酒频道首页_<fh-search>", "FlightHotel", null, null,"-_--_--_--_--_-路径页面");
</script>
 <script type="text/javascript" src="http://s2.lvjs.com.cn/js/common/losc.js"></script>

<#if getSuperCommonHeader ??>
	<!--去掉搜索框-->
	${getSuperCommonHeader()}
</#if>

<#if isBackBooking=='true'>
<br>
<h3 style="font-weight: normal;">&nbsp;&nbsp;&nbsp;&nbsp;首页</h3>
</#if>

<input type="hidden" id="base_path" value="${request.contextPath}">
    <!-- banWrap -->
<form id="myForm" action="${request.contextPath}/search" method="get">
    <input type= "hidden" name="shoppingUUID" value="${uuid}"/>
    <div class="banWrap mt40">
        <!-- 搜索 -->
        <div class="fhMain">
            <div class="fh-search">
                <div class="fh-search-part clearfix">
                    <i class="icon icon-flight"></i>
                    <div class="fh-sp-item clearfix">
                        <!-- 隐藏域 存储机票类型 往返:WF, 单程:DC 可在下面data-type进行配置-->
                        <input id="tripType" name="tripType" class="input-flight-type" type="hidden" value="WF">
                        <a id="wfButton" class="active" href="javascript:;" data-type="WF"><i></i>往返</a>
                        <a id="dcButton" href="javascript:;" data-type="DC"><i></i>单程</a>
                    </div>
                    <div class="fh-sp-item clearfix">
	                    <div class="fh-input-group mr10">
	                        <!--TODO value中填写当前城市 -->
	                        <input type="text" autocomplete="off"  id="departureCityName" class="input-city js_destination JS_select_city JS_select_depa select_depa" value="" placeholder="请输入出发地">
	                        <input class="h_select_depa" type="hidden" id="departureCityCode" name="departureCityCode" value=""/><!-- 隐藏域 存储出发地 -->
	                        <em class="input-info">出发地：</em>
	                    </div>
	                    <div class="fh-input-group mr20">
	                        <div class="errTips">与出发地不能为同一城市</div>
	                        <input type="text" autocomplete="off" id="arrivalCityName"  class="input-city js_destination JS_dest_input JS_select_city JS_select_dest select_dest" placeholder="请输入目的地">
	                        <input class="h_select_dest" type="hidden" id="arrivalCityCode" name="arrivalCityCode" value=""/><!-- 隐藏域 存储目的地 -->
	                        <em class="input-info">目的地：</em>
                            <span class="hotCity">热门：<i class="searchHot">三亚</i><i class="searchHot">厦门</i><i class="searchHot">成都</i><i class="searchHot">广州</i></span>
	                    </div>
	                    <div class="fh-input-group mr10 pr">
	                        <!--TODO value中填写当天+2 日期 -->
	                        <input type="text" name="departureTime" id="flightStartDate" class="input-calendar JS_flight_calendar" readonly="readonly" value="">
	                        <div class="fh-calendar-info pa">
	                            <i class="dayAfterTom" id="flightStartDayOfWeek"></i>
	                            <span class="icon icon-calendar"></span>
	                        </div>
	                        <em class="input-info">去程：</em>
	                    </div>
	                    <div class="fh-input-group fh-return-day-group pr">
	                        <!--TODO value中填写当天+5 日期 -->
	                        <input type="text" id="flightEndDate" name="returnTime" class="input-calendar JS_flight_calendar" readonly="readonly" value="">
	                        <div class="fh-calendar-info pa">
	                            <i class="dayAfter5" id="flightEndDayOfWeek"></i>
	                            <span class="icon icon-calendar"></span>
	                        </div>
	                        <em class="input-info">返程：</em>
	                    </div>
	                </div>
	            </div>
                <div class="fh-search-part clearfix">
                    <i class="icon icon-hotel"></i>
                    <div class="fh-input-group mr20 pr">
                        <input type="text" autocomplete="off" id="hotelCityName"  class="input-city js_destination JS_select_city select-hotel" placeholder="请输入您的入住城市">
                        <input class="h_select_hotel" type="hidden" id="cityCode" name="cityCode" value=""/><!-- 隐藏域 存储入住城市 -->
                        <em class="input-info">入住城市：</em>
                    </div>
                    <div class="fh-input-group mr10 pr">
                        <!--TODO value中填写当天+2 日期 -->
                        <input id="hotelStartDate" type="text" name="checkInTime" class="input-calendar JS_hotel_calendar" readonly="readonly" value="2015-11-28">
                        <div class="fh-calendar-info pa">
                            <i class="dayAfterTom" id="hotelStartDayOfWeek"></i>
                            <span class="icon icon-calendar"></span>
                        </div>
                        <em class="input-info">入住：</em>
                    </div>
                    <div class="fh-input-group pr">
                        <!--TODO value中填写当天+5 日期 -->
                        <input id="hotelEndDate" type="text" name="checkOutTime" class="input-calendar JS_hotel_calendar" readonly="readonly" value="2015-12-01">
                        <div class="fh-calendar-info pa">
                            <i class="dayAfter5" id="hotelEndDayOfWeek"></i>
                            <span class="icon icon-calendar"></span>
                        </div>
                        <em class="input-info">离店：</em>
                    </div>
                </div>
                <div class="fh-search-part clearfix">
                    <i class="icon icon-people"></i>
                    <div class="fh-input-group pr mr10">
                        <input type="hidden" name="adultsCount" id="adultsCount" class="JS_people_num " value="2"><!-- 隐藏域 存储成人人数 -->
                        <div class="select-div select-people">
                            <span id="adultCountSpan">2</span>
                            <em>成人</em>
                            <i></i>
                        </div>
                        <ol class="select-people-list JS_adult_list" data-other-list=".JS_child_list">
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
                    <div class="fh-input-group pr mr10">
                        <input type="hidden" name="childCount" id="childCount" class="JS_people_num JS_child_num" value="0"><!-- 隐藏域 存储儿童人数 -->
                        <div class="select-div select-people">
                            <span id="childCountSpan">0</span>
                            <em>儿童（2-12岁）</em>
                            <i></i>
                        </div>
                        <ol class="select-people-list JS_child_list" data-other-list=".JS_adult_list">
                            <li data-num="0">0</li>
                            <li data-num="1">1</li>
                            <li data-num="2">2</li>
                            <li data-num="3">3</li>
                            <li data-num="4">4</li>
                        </ol>
                    </div>
                    <input type="button" class="fh-search-btn" value="搜索机+酒套餐">
                </div>
            </div>
            <div class="fh-logo"></div>
        </div>
        <!-- //fhMain -->
    </div>
    <!-- //banWrap结束 -->
    <div class="complete-wrap"  id="ctShow"><!--style="width:138px;"-->
        
    </div>
    <!-- 城市列表 -->
    <div class="city_mdd">
    </div>
    <!-- //city_mdd结束 -->

    <!-- 出发城市列表 -->
    <div class="city_mdd_depa">
        <!-- <p>支持中文/拼音/简拼输入</p> -->
        <ul class="mdd_tab">
            <li class="active JS_mt_hot">热门<i class="ico city_icon"></i></li>
            <li>ABCD<i class="ico city_icon"></i></li>
            <li>EFGH<i class="ico city_icon"></i></li>
            <li>JKLM<i class="ico city_icon"></i></li>
            <li>NOPQRS<i class="ico city_icon"></i></li>
            <li>TUVWX<i class="ico city_icon"></i></li>
            <li>YZ<i class="ico city_icon"></i></li>
        </ul>
        <ul class="mdd_list">
            <li style="display:block;">
                <!--热门-->
                <a href="javascript:;">北京</a>
                <a href="javascript:;">上海</a>
                <a href="javascript:;">三亚</a>
                <a href="javascript:;">厦门</a>
                <a href="javascript:;">天津</a>
                <a href="javascript:;">西安</a>
                <a href="javascript:;">大连</a>
                <a href="javascript:;">昆明</a>
                <a href="javascript:;">深圳</a>
                <a href="javascript:;">成都</a>
                <a href="javascript:;">重庆</a>
                <a href="javascript:;">南京</a>
                <a href="javascript:;">杭州</a>
				<a href="javascript:;">宁波</a>
				<a href="javascript:;">广州</a>
				<a href="javascript:;">桂林</a>
                <a href="javascript:;">青岛</a>
                <a href="javascript:;">哈尔滨</a>
                <a href="javascript:;">武汉</a>
                <a href="javascript:;">无锡</a>
                <a href="javascript:;">济南</a>
                <a href="javascript:;">沈阳</a>
                <a href="javascript:;">长沙</a>
                <a href="javascript:;">福州</a>
                <a href="javascript:;">温州</a>  
            </li>
            <li>
                <!--ABCD-->
                <a href="javascript:;">阿勒泰</a>
                <a href="javascript:;">阿克苏</a>
                <a href="javascript:;">鞍山</a>
                <a href="javascript:;">安庆</a>
                <a href="javascript:;">安顺</a>
                <a href="javascript:;">阿里</a>
                <a href="javascript:;">阿尔山</a>
                <a href="javascript:;">百色</a>
                <a href="javascript:;">包头</a>
                <a href="javascript:;">毕节</a>
                <a href="javascript:;">北海</a>
                <a href="javascript:;">博乐</a>
                <a href="javascript:;">保山</a>
                <a href="javascript:;">北京</a>
                <a href="javascript:;">巴彦淖尔</a>
                <a href="javascript:;">昌都</a>
                <a href="javascript:;">常德</a>
                <a href="javascript:;">长春</a>
                <a href="javascript:;">朝阳</a>
                <a href="javascript:;">赤峰</a>
                <a href="javascript:;">长治</a>
                <a href="javascript:;">重庆</a>
                <a href="javascript:;">长沙</a>
                <a href="javascript:;">成都</a>
                <a href="javascript:;">常州</a>
                <a href="javascript:;">池州</a>
                <a href="javascript:;">长白山</a>
                <a href="javascript:;">大同</a>
                <a href="javascript:;">达州</a>
                <a href="javascript:;">稻城</a>
                <a href="javascript:;">丹东</a>
                <a href="javascript:;">迪庆</a>
                <a href="javascript:;">大连</a>
                <a href="javascript:;">大理</a>
                <a href="javascript:;">敦煌</a>
                <a href="javascript:;">东营</a>
            </li>
            <li>
                <!--EFGH-->
                <a href="javascript:;">鄂尔多斯</a>
                <a href="javascript:;">恩施</a>
                <a href="javascript:;">二连浩特</a>
                <a href="javascript:;">福州</a>
                <a href="javascript:;">阜阳</a>
                <a href="javascript:;">佛山</a>
                <a href="javascript:;">广州</a>
                <a href="javascript:;">赣州</a>
                <a href="javascript:;">格尔木</a>
                <a href="javascript:;">广元</a>
                <a href="javascript:;">固原</a>
                <a href="javascript:;">贵阳</a>
                <a href="javascript:;">桂林</a>
                <a href="javascript:;">海口</a>
                <a href="javascript:;">邯郸</a>
                <a href="javascript:;">黑河</a>
                <a href="javascript:;">呼和浩特</a>
                <a href="javascript:;">合肥</a>
                <a href="javascript:;">杭州</a>
                <a href="javascript:;">淮安</a>
                <a href="javascript:;">怀化</a>
                <a href="javascript:;">海拉尔</a>
                <a href="javascript:;">哈密</a>
                <a href="javascript:;">哈尔滨</a>
                <a href="javascript:;">和田</a>
                <a href="javascript:;">惠州</a>
                <a href="javascript:;">汉中</a>
                <a href="javascript:;">黄山</a>
            </li>
            <li>
                <!--JKLM-->
                <a href="javascript:;">景德镇</a>
                <a href="javascript:;">加格达奇</a>
                <a href="javascript:;">嘉峪关</a>
                <a href="javascript:;">井冈山</a>
                <a href="javascript:;">金昌</a>
                <a href="javascript:;">九江</a>
                <a href="javascript:;">佳木斯</a>
                <a href="javascript:;">济宁</a>
                <a href="javascript:;">锦州</a>
                <a href="javascript:;">鸡西</a>
                <a href="javascript:;">九寨沟</a>
                <a href="javascript:;">揭阳</a>
                <a href="javascript:;">济南</a>
                <a href="javascript:;">库车</a>
                <a href="javascript:;">康定</a>
                <a href="javascript:;">喀什</a>
                <a href="javascript:;">凯里</a>
                <a href="javascript:;">喀纳斯</a>
                <a href="javascript:;">昆明</a>
                <a href="javascript:;">库尔勒</a>
                <a href="javascript:;">克拉玛依</a>
                <a href="javascript:;">黎平</a>
                <a href="javascript:;">龙岩</a>
                <a href="javascript:;">兰州</a>
                <a href="javascript:;">丽江</a>
                <a href="javascript:;">荔波</a>
                <a href="javascript:;">吕梁</a>
                <a href="javascript:;">临沧</a>
                <a href="javascript:;">六盘水</a>
                <a href="javascript:;">拉萨</a>
                <a href="javascript:;">洛阳</a>
                <a href="javascript:;">连云港</a>
                <a href="javascript:;">临沂</a>
                <a href="javascript:;">柳州</a>
                <a href="javascript:;">泸州</a>
                <a href="javascript:;">林芝</a>
                <a href="javascript:;">芒市</a>
                <a href="javascript:;">牡丹江</a>
                <a href="javascript:;">绵阳</a>
                <a href="javascript:;">满洲里</a>
                <a href="javascript:;">漠河</a>
            </li>
            <li>
                <!--NOPQRS-->
                <a href="javascript:;">南昌</a>
                <a href="javascript:;">南充</a>
                <a href="javascript:;">宁波</a>
                <a href="javascript:;">南京</a>
                <a href="javascript:;">那拉提</a>
                <a href="javascript:;">南宁</a>
                <a href="javascript:;">南阳</a>
                <a href="javascript:;">南通</a>
                <a href="javascript:;">攀枝花</a>
                <a href="javascript:;">普洱</a>
                <a href="javascript:;">庆阳</a>
                <a href="javascript:;">泉州</a>
                <a href="javascript:;">衢州</a>
                <a href="javascript:;">齐齐哈尔</a>
                <a href="javascript:;">秦皇岛</a>
                <a href="javascript:;">青岛</a>
                <a href="javascript:;">日喀则</a>
                <a href="javascript:;">日照</a>
                <a href="javascript:;">上海</a>
                <a href="javascript:;">沈阳</a>
                <a href="javascript:;">石家庄</a>
                <a href="javascript:;">思茅</a>
                <a href="javascript:;">三亚</a>
                <a href="javascript:;">深圳</a>
            </li>
            <li>
                <!--TUVWX-->
                <a href="javascript:;">台州</a>
                <a href="javascript:;">塔城</a>
                <a href="javascript:;">腾冲</a>
                <a href="javascript:;">铜仁</a>
                <a href="javascript:;">通辽</a>
                <a href="javascript:;">天水</a>
                <a href="javascript:;">天津</a>
                <a href="javascript:;">唐山</a>
                <a href="javascript:;">太原</a>
                <a href="javascript:;">乌兰浩特</a>
                <a href="javascript:;">武陵山</a>
                <a href="javascript:;">乌鲁木齐</a>
                <a href="javascript:;">潍坊</a>
                <a href="javascript:;">威海</a>
                <a href="javascript:;">文山</a>
                <a href="javascript:;">温州</a>
                <a href="javascript:;">乌海</a>
                <a href="javascript:;">武汉</a>
                <a href="javascript:;">武夷山</a>
                <a href="javascript:;">无锡</a>
                <a href="javascript:;">梧州</a>
                <a href="javascript:;">万州</a>
                <a href="javascript:;">兴义</a>
                <a href="javascript:;">西双版纳</a>
                <a href="javascript:;">襄樊</a>
                <a href="javascript:;">西昌</a>
                <a href="javascript:;">锡林浩特</a>
                <a href="javascript:;">西安</a>
                <a href="javascript:;">厦门</a>
                <a href="javascript:;">西宁</a>
                <a href="javascript:;">徐州</a>
            </li>
            <li>
                <!--YZ-->
                <a href="javascript:;">延安</a>
                <a href="javascript:;">银川</a>
                <a href="javascript:;">伊春</a>
                <a href="javascript:;">永州</a>
                <a href="javascript:;">榆林</a>
                <a href="javascript:;">宜宾</a>
                <a href="javascript:;">运城</a>
                <a href="javascript:;">宜春</a>
                <a href="javascript:;">宜昌</a>
                <a href="javascript:;">伊宁</a>
                <a href="javascript:;">义乌</a>
                <a href="javascript:;">延吉</a>
                <a href="javascript:;">烟台</a>
                <a href="javascript:;">盐城</a>
                <a href="javascript:;">扬州</a>
                <a href="javascript:;">玉树</a>
                <a href="javascript:;">郑州</a>
                <a href="javascript:;">张家界</a>
                <a href="javascript:;">舟山</a>
                <a href="javascript:;">张掖</a>
                <a href="javascript:;">昭通</a>
                <a href="javascript:;">中山</a>
                <a href="javascript:;">湛江</a>
                <a href="javascript:;">中卫</a>
                <a href="javascript:;">张家口</a>
                <a href="javascript:;">珠海</a>
                <a href="javascript:;">遵义</a>
            </li>
        </ul>
    </div>
    <!-- 到达城市列表 -->
    <div class="city_mdd_dest">
        <ul class="mdd_list">
            <li style="display:block;">
                <!--热门-->
                <a href="javascript:;">三亚</a>
				<a href="javascript:;">广州</a>
				<a href="javascript:;">成都</a>
				<a href="javascript:;">深圳</a>
				<a href="javascript:;">厦门</a>
				<a href="javascript:;">桂林</a>
				<a href="javascript:;">长沙</a>
				<a href="javascript:;">海口</a>
				<a href="javascript:;">上海</a>
				<a href="javascript:;">北京</a>
				<a href="javascript:;">昆明</a>
				<a href="javascript:;">丽江</a>
				<a href="javascript:;">西双版纳</a>
				<a href="javascript:;">九寨沟</a>
				<a href="javascript:;">张家界</a>
				<a href="javascript:;">黄山</a>
				<a href="javascript:;">宁波</a>
				<a href="javascript:;">杭州</a>
				<a href="javascript:;">南京</a>
				<a href="javascript:;">西安</a>
				<a href="javascript:;">长白山</a>
				<a href="javascript:;">无锡</a>
				<a href="javascript:;">重庆</a>
				<a href="javascript:;">北海</a>
				<a href="javascript:;">青岛</a>
  
            </li>
        </ul>
    </div>
 	<!-- 酒店城市列表 -->
    <div class="city_mdd_hotel">
        <ul class="mdd_list">
            <li style="display:block;">
                <!--热门-->
                <a href="javascript:;">三亚</a>
				<a href="javascript:;">广州</a>
				<a href="javascript:;">成都</a>
				<a href="javascript:;">深圳</a>
				<a href="javascript:;">厦门</a>
				<a href="javascript:;">桂林</a>
				<a href="javascript:;">长沙</a>
				<a href="javascript:;">海口</a>
				<a href="javascript:;">上海</a>
				<a href="javascript:;">北京</a>
				<a href="javascript:;">昆明</a>
				<a href="javascript:;">丽江</a>
				<a href="javascript:;">西双版纳</a>
				<a href="javascript:;">九寨沟</a>
				<a href="javascript:;">张家界</a>
				<a href="javascript:;">黄山</a>
				<a href="javascript:;">宁波</a>
				<a href="javascript:;">杭州</a>
				<a href="javascript:;">南京</a>
				<a href="javascript:;">西安</a>
				<a href="javascript:;">长白山</a>
				<a href="javascript:;">无锡</a>
				<a href="javascript:;">重庆</a>
				<a href="javascript:;">北海</a>
				<a href="javascript:;">青岛</a>
            </li>
        </ul>
    </div>
     </form>
    
    
    <!-- //city_mdd结束 -->
	
    <script src="http://pic.lvmama.com/min/index.php?f=/js/new_v/jquery-1.7.2.min.js,/js/v6/header_new.js,/js/ui/lvmamaUI/lvmamaUI.js,/js/v5/modules/pandora-poptip.js,/js/v6/modules/pandora-calendar.js,/js/fit/fh-search.js"></script>
	<script src="http://pic.lvmama.com/js/v6/public/searchComplete.js"></script>
	
	   <#if isBackBooking=='true'>
       <#else>
	       <#include "online_foot.ftl">
        </#if>
	  
	<script src="${request.contextPath}/js/fh-index.js"></script>
	<script src="${request.contextPath}/js/common/common.js"></script>
    <script src="${request.contextPath}/js/moment.js"></script>
	<script>
		$(function(){
            // $("#tripType").val("WF"); // 选择单程后，hidden值变为DC, 在选择页面回退，因为缓存，hidden值为DC，但页面显示为WF
			$.ajax({
				   type: "GET",
				   url: location.href.substring(0,location.href.indexOf("/index")+1)+"index/ip",
				   success: function(data){
					   var departureCityName = $("#currentCity").text();
					   if(null != departureCityName && '' != departureCityName){//取到了头中的数据
						   var flag = false;
						   for(var i=0;i<allCities.length;i++){
						        if(departureCityName==allCities[i].split("|")[0]){
						            $(".select_depa").val(departureCityName);
						            flag = true;
						        }
							 } 
						   if (flag == false){
							   $(".select_depa").val("上海");
						   }
					   } else {   //没取到
						   var flag = false;
						   for(var i=0;i<allCities.length;i++){
						        if(data.add==allCities[i].split("|")[0]){
						            $(".select_depa").val(data.add);
						            flag = true;
						        }
							 }
						   if(flag == false){
							   $(".select_depa").val("上海");
						   }
						   writeSearchRecord();
					   } 
				   }
				});
				//页面加载的时候 人数保持联动
			var count = $(".select-div").find("span");
			
			count.eq(0).html($("#adultsCount").attr("value"));
			count.eq(1).html($("#childCount").attr("value"));
			
			//默认时间获取
		    var newDate=new Date();
		    newDate.setDate(newDate.getDate()+2);
		    var goYear = newDate.getFullYear();
		    var goMonth = newDate.getMonth() + 1;
		    var goDay = newDate.getDate();
		    if (goMonth <= 9) {
		        goMonth = "0" + goMonth;
		    }
		    if (goDay <= 9) {
		        goDay = "0" + goDay;
		    }
		    $('#flightStartDate').val(goYear+"-"+goMonth+"-"+goDay);
		    $('#hotelStartDate').val(goYear+"-"+goMonth+"-"+goDay);
		
		    newDate.setDate(newDate.getDate()+3);
		    var backYear = newDate.getFullYear();
		    var backMonth = newDate.getMonth() + 1;
		    var backDay = newDate.getDate();
		    if (backMonth <= 9) {
		        backMonth = "0" + backMonth;
		    }
		    if (backDay <= 9) {
		        backDay = "0" + backDay;
		    }
		    $('#flightEndDate').val(backYear+"-"+backMonth+"-"+backDay);
		    $('#hotelEndDate').val(backYear+"-"+backMonth+"-"+backDay);
		    seoJustice('','','','seotdk_fit_index','${request.contextPath}');

            $('.searchHot').click(function() { 
                $('.JS_select_dest').val($(this).html());
                $('.select-hotel').val($(this).html());
            })

            //填充默认搜索条件
            fillSearchCondition();

		});
	
    //首页默认打开时，把搜索条件填充到页面
    function fillSearchCondition(){
    	//1、根据用户搜索历史记录，且Cookie没有清理掉，显示上次搜索过的航程类型，出发、到达城市及出发、往返时间
    	if(window.localStorage){
    		var searchCondition = window.localStorage.getItem('searchCondition'); 
    		if(searchCondition != null && searchCondition != ''){
    			//RT|XMN|NGB|2016-02-24|2016-02-27
	    		console.info("获取上一次的搜索条件="+searchCondition);
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
	    		
	    		$("#tripType").val(tripType);
	    		if(tripType == 'DC'){
	    			$("#dcButton").trigger("click");
	    		}else if(tripType == 'WF'){
	    			$("#wfButton").trigger("click");
	    		}
	    		
	    		$("#departureCityCode").val(departureCityCode);
	    		for(var i=0;i<allCities.length;i++){
                    if(allCities[i].indexOf(departureCityCode)!=-1){
                        var deptCity=allCities[i].split("|")[0];
                        $("#departureCityName").val(deptCity);
                        break;
                    }
                }
	    		
                $("#arrivalCityCode").val(arrivalCityCode);
	    		for(var i=0;i<allCities.length;i++){
                    if(allCities[i].indexOf(arrivalCityCode)!=-1){
                        var arrvCity=allCities[i].split("|")[0];
                        $("#arrivalCityName").val(arrvCity);
                        break;
                    }
                }
                
                $("#cityCode").val(cityCode);
	    		for(var i=0;i<allCities.length;i++){
                    if(allCities[i].indexOf(cityCode)!=-1){
                        var hotelCity=allCities[i].split("|")[0];
                        $("#hotelCityName").val(hotelCity);
                        break;
                    }
                }
                
                var startDate = new Date(flightStartDate);
                var startDay = moment(startDate);
                var nowDay = moment();
                if (startDay.diff(nowDay, 'days') >= 0) {
    	    		$("#flightStartDate").val(flightStartDate);
    	    		var flightGoDayWeek = getDayOfWeek(flightStartDate);
    	    		$("#flightStartDayOfWeek").text(flightGoDayWeek);
    	    		
    	    		$("#flightEndDate").val(flightEndDate);
    	    		var flightBackDayWeek = getDayOfWeek(flightEndDate);
    	    		$("#flightEndDayOfWeek").text(flightBackDayWeek);
    	    		
    	    		$("#hotelStartDate").val(hotelStartDate);
    	    		var hotelGoDayWeek = getDayOfWeek(hotelStartDate);
    	    		$("#hotelStartDayOfWeek").text(hotelGoDayWeek);
    	    		
    	    		$("#hotelEndDate").val(hotelEndDate);
    	    		var hotelBackDayWeek = getDayOfWeek(hotelEndDate);
    	    		$("#hotelEndDayOfWeek").text(hotelBackDayWeek);
                }
	    		
	    		$("#adultsCount").val(adultsCount);
	    		$("#adultCountSpan").text(adultsCount);
	    		
	    		$("#childCount").val(childCount);
	    		$("#childCountSpan").text(childCount);
	    		
	    		return;
    		}
    	}
    	
    	//2、读取用户IP地址
    	var flag = false;
		$.ajax({
		   type: "GET",
		   async: false,
		   url: location.href.substring(0,location.href.indexOf("/index")+1)+"/search/index/ip",
		   timeout:5000,
		   success: function(data){
			   for(var i=0;i<allCities.length;i++){
			        if(data.city==allCities[i].split("|")[0]){
			            $("#departureCityName").val(data.add);
			            $("#departureCityCode").val(allCities[i].split("|")[3]);
			            flag = true;
			            break;
			        }
				 }
		   }
		});
		
    }
    /**
	 * getDayOfWeek 返回星期
	 * @param {string} date 格式:"YYYY-MM-DD"
	 */
	function getDayOfWeek(date){
	    var nowDay;
	    if (date) {
	        var dayArray = date.split("-");
	        nowDay = new Date(parseInt(dayArray[0], 10), parseInt(dayArray[1], 10) - 1, parseInt(dayArray[2], 10));
	    } else {
	        nowDay = new Date();
	    }
	    
	    var day = nowDay.getDay();
	    var dayArray = ["星期天","星期一","星期二","星期三","星期四","星期五","星期六"];
	    return dayArray[day];
	}
	</script>
</body>

</html>
