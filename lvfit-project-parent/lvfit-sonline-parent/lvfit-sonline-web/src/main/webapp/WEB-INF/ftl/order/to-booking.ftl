<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>填写订单-驴妈妈旅游网</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="shortcut icon" href="http://www.lvmama.com/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/new_v/header-air.css,/styles/v3/core.css,/styles/v4/modules/step.css,/styles/v5/modules/tip.css,/styles/v5/modules/tags.css,/styles/v4/modules/calendar.css,/styles/v4/modules/dialog.css,/styles/v6/flighthotel/fh-result-loading.css,/styles/v6/flighthotel/fh-icon-ac.css,/styles/v5/modules/dialog.css,/styles/common/poplogin.css">
<link rel="stylesheet" href="http://pic.lvmama.com/styles/v6/order.css">
<link rel="stylesheet" href="${request.contextPath}/css/order/fh-order.css">

<style>

.fillInBtn{
    display: inline-block;
    font-size: 12px;
    font-family: &quot;SimSun&quot;,sans-serif;
    color: #666;
    border-bottom: #999 dashed 1px;
    padding-bottom: 2px;
    cursor: pointer;
    margin-right: 10px;
    margin-left: 10px;
    line-height: 12px;
}
.fillingExplanation{
    display:none;
    position: absolute;
    left: 385px;
    top: 34px;
    background: #FFF;
    width: 430px;
    padding: 0px 16px 20px;
    border: #CCC solid 1px;
    z-index: 1000;
}
.fillingExplanation ol{
    list-style-type: decimal;
    list-style-position: inside;
    margin-top: 15px;
    color: #666;
    line-height: 20px;
}

.fillingExplanation ol>li{
    display: list-item;
    padding-left: 0;
}
.fillingExplanation ul{
    list-style-type: disc;
}
.fillingExplanation ul>li{
    display: list-item;
    padding-left: 20px;
}
.fillingExplanation .info_arrow {
    height: 14px;
    width: 14px;
    overflow: hidden;
    left: 17px;
    top: -7px;
}
.fillingExplanation .info_arrow span {
    color: #CCC;
}
.fillingExplanation .info_arrow i {
    color: #FFF;
    top: 1px;
}
<!--.dialog-inner{
    overflow-y: auto;
    overflow-x: hidden;
}-->

</style>

</head>

<body class="order fh-order">
<!-- 流量埋点 -->
<script src="http://pic.lvmama.com/min/index.php?f=/js/v5/ibm/eluminate.js"></script>
<script src="http://pic.lvmama.com/min/index.php?f=/js/v5/ibm/coremetrics-initalize.js"></script>
<script>_LVMAMA_COREMETRICS.init(document.domain);</script>
<script>
        cmCreatePageviewTag("", "", null, null,"-_--_--_--_--_-路径页面");
</script>
<div class="order-header wrap">
    <div class="header-inner">
        <a class="logo" href="http://www.lvmama.com/">自在游天下 就找驴妈妈</a>
        <p class="welcome"></p>
        <p class="header-info">24小时服务热线：<strong>1010-6060</strong></p>
    </div>
</div>

<div class="main_box">
    <div class="wrap">
        <ol class="ui-step ui-step-3">
            <li class="ui-step1 ui-step-start ui-step-active">
                <div class="ui-step-arrow">
                    <i class="arrow_r1"></i>
                    <i class="arrow_r2"></i>
                </div>
                <span class="ui-step-text">1.填写订单</span>
            </li>
                <li class="ui-step2 ">
                    <div class="ui-step-arrow">
                        <i class="arrow_r1"></i>
                        <i class="arrow_r2"></i>
                    </div>
                    <span class="ui-step-text">2.选择支付方式支付</span>
                </li>
            <li class="ui-step3 ui-step-end ">
                <div class="ui-step-arrow">
                    <i class="arrow_r1"></i>
                    <i class="arrow_r2"></i>
                </div>
                <span class="ui-step-text">3.完成</span>
            </li>
        </ol>


        <div class="order_box border_3">
            <h1 class="order_name" id="fit_productName"><span>${productName}</span></h1>
            <!--机票开始-->
            <#if flightInfos?? && flightInfos?size gt 0>
            <dl class="order_dl">
                <dt>机票</dt>
                <dd>
                    <div class="table_list table_tit">
                        <ul class="table_list_t flight-detail">
                            <li class="flight-name">往返</li>
                            <li class="flight-info">航班信息</li>
                            <li class="flight-depa-stop">起飞信息</li>
                            <li class="flight-arrival-time">到达信息</li>
                            <li class="flight-duration">飞行时长</li>
                            <li class="flight-type">舱位</li>
                        </ul>
                    </div>
                    <div class="table_list table_t flight-list">
                    <#list flightInfos as flightInfo>
                    <#if flightInfo_index ==0>
                    <!--去程航班-->
                    <div class="flight-item flight-item-depa">
                    <#else>
                    <!--返程航班-->
                    <div class="flight-item">
                    </#if>
                        <div class="flight-detail clearfix">
                            <div class="flight-name">
                                <#if flightInfo_index ==0>
                                <i class="fh-icon fh-icon-depa"></i>
                                <#else>
                                <i class="fh-icon fh-icon-dest"></i>
                                </#if>
                                <div class="flight-name-info">
                                    <#if flightInfo_index ==0>
                                    <div id="departureTime" class="flight-top">${flightInfo.departureDate }</div>
                                    <#else>
                                    <div class="flight-top">${flightInfo.departureDate }</div>
                                    </#if>
                                    <div class="flight-bottom">${flightInfo.departureCityName }<!-- 上海上海上 -->
                                    <span class="fh-icon fh-icon-to"></span>${flightInfo.arrivalCityName }<!-- 三亚三亚三 --></div>
                                </div>
                            </div>
                            <div class="flight-info">
                                <div class="flight-top">
                                    <i class="fh-icon-ac fh-icon-ac-${flightInfo.carrierCode}"></i>
                                    ${flightInfo.carrierName }<!-- 南方航空 -->
                                </div>
                                <!-- TODO 机型信息填在对应的data属性中 -->
                                <div class="flight-bottom"><span class="flight-number">${flightInfo.flightNo }<!-- CZ3836 --></span>
                                <span class="plane-type" data-plan="${flightInfo.airplane.code }" data-name="${flightInfo.airplane.name }"
                                    data-type="${flightInfo.airplane.airplaneType }" data-min="${flightInfo.airplane.minSeats }"
                                    data-max="${flightInfo.airplane.maxSeats }">${flightInfo.airplane.code }<!-- 320 --></span></div>
                            </div>
                            <div class="flight-depa-time flight-time">
                                <div class="flight-top">${flightInfo.departureTime?string?substring(11,16) }<!-- 17:15 --></div>
                                <div class="flight-bottom">
                                    <a class="airport-name" href="javascript:;" title="${flightInfo.departureAirportName }">${flightInfo.departureAirportName }<!-- 浦东国际机场够了 --></a>
                                    <span>${flightInfo.departureTermainalBuilding }<!-- T2 --></span>
                                </div>
                            </div>
                            <div class="flight-stop">
                                <!-- TODO 没有经停时，删除“经停”两字，切勿删除P标签 -->
                                <p class="flight-stop-text"><#if flightInfo.stopCount gt 0>经停</#if></p>
                                <div class="fh-icon fh-icon-stop">${flightInfo.stopCity }</div>
                            </div>
                            <div class="flight-arrival-time flight-time">
                                <div class="flight-top">${flightInfo.arrivalTime ?string?substring(11,16) }
                                <#if flightInfo.highLightFlag ?? && flightInfo.highLightFlag == true>
                                <span class="flight-add-one-day" tip-content="航班到达日期为起飞日期
                                <span class='tip-add-one'>+1天</span>。">+1</span>
                                </#if>
                                </div>
                                <div class="flight-bottom">
                                <a class="airport-name" href="javascript:;" title="${flightInfo.arrivalAirportName }">${flightInfo.arrivalAirportName }<!-- 浦东国际机场够了 --></a>
                                <span>${flightInfo.arrivalTerminalBuilding }<!-- T2 --></span></div>
                            </div>
                            <div class="flight-duration">
                                <div class="flight-center">${flightInfo.flyTime }<!-- 4h --></div>
                            </div>
                            <div class="flight-type">
                                <div class="flight-center">
                                    ${flightInfo.seats[0].seatClassTypeName }
                                    <#if flightInfo.seats[0]..inventoryCount?? && flightInfo.seats[0]..inventoryCount  lte 9>
                                        <span class="flight-ticket-amount">剩余${flightInfo.seats[0].inventoryCount}</span>
                                    </#if>
                                </div>
                            </div>
                        </div>
                        <!--<#if flightInfo.highLightFlag ?? && flightInfo.highLightFlag == true>
                        <p class="flight-warning">
                            <i class="fh-icon fh-icon-warning"></i>该航班为隔夜航班，请留意您的酒店入住日期
                        </p>
                        </#if>-->
                    </div>
                    </#list>
                    </div>
                </dd>
            </dl>
            </#if>
            <!--机票结束-->

            <!--酒店开始-->  
            <#if hotels?? && hotels?size gt 0 > 
			<dl class="order_dl">
                <dt>酒店</dt>
                <dd>
                    <div class="table_list table_tit">
                        <ul class="table_list_t hotel-detail">
                            <li class="hotel-name">酒店名称</li>
                            <li class="hotel-room-type">房型</li>
                            <li class="hotel-time">入住/离店时间</li>
                            <li class="hotel-amount">间数</li>
                        </ul>
                    </div>
                    <div class="table_list table_t hotel-list">
						<#list hotels as hotel>   
                        <!-- 酒店信息 -->
                        <div class="hotel-item">
                            <div class="hotel-detail clearfix">
                                <div class="hotel-name">
                                    <div class="hotel-center">${hotel.hotelName}<!-- 三亚湾红树林度假酒店 --></div>
                                </div>
                                <div class="hotel-room-type">
                                    <div class="hotel-top">${hotel.roomName} - ${hotel.goodsName}<!-- 豪华海景房 - 商品名称 --></div>
                                    <div class="hotel-bottom"><#if hotel.bedType??> 床型：${hotel.bedType}</#if>  <#if hotel.breakfast??>早餐：${hotel.breakfast}</#if>  <#if hotel.internet??>宽带：${hotel.internet}</#if> <!-- 床型：大床  早餐：双早  宽带：免费 --></div>
                                </div>
                                <div class="hotel-time">
                                    <div class="hotel-time-day">
                                        <div class="hotel-top">${hotel.checkIn} <!-- 入住 --></div>
                                        <div class="hotel-bottom">${hotel.checkOut} <!-- 离店 --></div>
                                    </div>
                                    <div class="hotel-center">(${hotel.stayDays}晚)</div>
                                </div>
                                <div class="hotel-amount">
                                    <div class="hotel-center">${hotel.roomCount}</div>
                                </div>
                            </div>
                        </div>
						</#list> 
                    </div>
                </dd>
            </dl>
			 
            </#if> 
			
            <!--酒店套餐开始-->
            <#if (hotelInfo !="" || hotelInfo != null) && hotelInfo.productId !="" >
            <dl class="order_dl">
                <dt>酒店套餐</dt>
                <dd>
                    <div class="table_list table_tit">
                        <ul class="table_list_t">
                            <li class="jd_table1">产品信息</li>
                            <li class="jd_table2">游玩时间</li>
                            <li class="jd_table3">份数</li>
                        </ul>
                    </div>
                    <div class="table_list table_t jd_table_t">
                        <ul class="table_list_t">
                            <li class="jd_table1">
                                <h4>${hotelInfo.productName}</h4>
                                <a class="pro_name" href="javascript:;" hidefocus="false">${hotelInfo.branchName}<i class="icon_arrow"></i></a>
                            </li>
                            <li class="jd_table2">
                            <#if hotelInfo.startDayStr!=null || hotelInfo.startDayStr!=''>
                                ${hotelInfo.startDayStr}
                            <#else>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                            </#if>
                            </li>
                            <li class="jd_table3">${hotelInfo.quantity}</li>
                        </ul>
                        <div class="pro_info clearfix">
                            <p>
                                <b>描述</b>
                                ${hotelInfo.branchDesc}
                            </p>
                            <a class="pro_info_sq" href="javascript:;" hidefocus="false">收起</a>
                            <div class="info_arrow"><span>◆</span><i>◆</i></div>
                        </div>
                    </div>
                </dd>
            </dl>
            </#if>
            <!--酒店套餐结束-->
            
            
            <!--酒店结束-->

            <!--当地游开始-->
            <#if (localTripInfo !="" || localTripInfo != null)&&localTripInfo.productId != null>
            <!--&&localTripInfo.productName-->
            <dl class="order_dl">
                    <dt>当地游</dt>
                    <dd>
                        <div class="table_list table_tit">
                            <ul class="table_list_t">
                                <li class="jd_table1">产品信息</li>
                                <li class="jd_table2">游玩时间</li>
                                <li class="jd_table3">人数</li>
                            </ul>
                        </div>
                        <div class="table_list table_t jd_table_t">
                            <ul class="table_list_t">
                                <li class="jd_table1">
                                    <h4>${localTripInfo.productName}</h4>
                                    <a class="pro_name" href="javascript:;" hidefocus="false">成人/儿童/房差<i class="icon_arrow"></i></a>
                                </li>
                                <li class="jd_table2">
                                    <#if localTripInfo.visitDateStr!=null || localTripInfo.visitDateStr!=''>
                                        ${localTripInfo.visitDateStr}
                                    <#else>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                    </#if>
                                </li>
                                <li class="jd_table3">
                                    成人：${passengers.adultCount}
                                    <#if passengers.childCount gt 0>
                                         儿童：${passengers.childCount}
                                    </#if>      
                                          
                                </li>
                            </ul>
                            <div class="pro_info clearfix">
                                <p>
                                    <b>描述</b>
                                </p>
                                <p>
                                    1.旅游者在行程开始前7日以内提出解除合同或者按照本合同第十二条第2款约定由旅行社在行程开始前解除合同的，按下列标准扣除必要的费用：
                                </p>
                                <p>
                                    2.行程开始前6日至4日，按旅游费用总额的20%；
                                </p>
                                <p>
                                    3.行程开始前3日至1日，按旅游费用总额的40%；
                                </p>
                                <p>
                                    4.行程开始当日，按旅游费用总额的60%；
                                </p>
                                <p>
                                    5.如按上述比例支付的业务损失费不足以赔偿组团社的实际损失，旅游者应当按实际损失对组团社予以赔偿，但最高额不应当超过旅游费用总额。
                                </p>
                                <p>
                                    6.游客转让：出行前，在符合办理团队签证或签注期限或其他条件许可情况下，旅游者可以向组团社书面提出将其自身在本合同中的权利和义务转让给符合出游条件的第三人；并且由第三人与组团社重新签订合同；因此增加的费用由旅游者或第三人承担，减少的费用由组团社退还旅游者。
                                </p>
                                <strong></strong><br>
                                                <p></p>
                                <a class="pro_info_sq" href="javascript:;" hidefocus="false">收起</a>
                                <div class="info_arrow"><span>◆</span><i>◆</i></div>
                            </div>
                        </div>
                    </dd>
            </dl>
            </#if>
            <!--当地游结束-->

            <!-- 可选产品开始 -->
            <#if (otherTickets?? && otherTickets?size gt 0)||(insuranceInfos?? && insuranceInfos?size gt 0)>
            <dl class="order_dl">
                <dt>可选产品</dt>
                <dd>
                    <div class="table_list table_tit">
                        <ul class="table_list_t xpro-detail">
                            <li class="xpro-type">类型</li>
                            <li class="xpro-name">产品名称</li>
                            <li class="xpro-time">使用日期</li>
                            <li class="xpro-amount">份数</li>
                            <li class="xpro-price">单价</li>
                        </ul>
                    </div>
                    <div class="table_list table_t xpro-list">
                    <!-- 其他票信息 -->
                    <#if otherTickets?? && otherTickets?size gt 0>
                       <div class="xpro-item xpro-item-ticket clearfix">
                            <div class="xpro-type">其它票</div>
                            <div class="xit-list">
                                <#list otherTickets as ticket>
                                <div class="xpro-detail clearfix" style="margin-bottom:20px;" data-id="T${ticket.suppGoodsId}">
                                    <div class="xpro-name" style="text-decoration:none;"><em>${ticket.productName}-${ticket.goodsName}</em></div>
                                    <div class="xpro-time">${ticket.selectDate}</div>
                                    <div class="xpro-amount">${ticket.selectCount}</div>
                                    <div class="xpro-price"><i>￥</i>${ticket.selectPrice}</div>
                                </div>
                                </#list>
                            </div>
                        </div>
                    </#if>

                    <!--保险信息-->
                    <#if insuranceInfos?? && insuranceInfos?size gt 0>
                        <div class="xpro-item xpro-item-insurance clearfix">
                            <div class="xpro-type">保险</div>
                            <div class="xit-list">
                                <#list insuranceInfos as insuranceInfo>
                                <div class="xpro-detail clearfix" style="margin-bottom:20px;" data-id="I${insuranceInfo.suppGoodsId}">
                                    <div class="xpro-name"><em>${insuranceInfo.productName}-${insuranceInfo.branchName }-${insuranceInfo.goodsName }</em></div>
                                    <div class="xpro-time" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--</div>
                                    <div class="xpro-amount">${insuranceInfo.selectCount}</div>
                                    <div class="xpro-price"><i>￥</i>${insuranceInfo.price}</div>
                                    <div class="fh-ticket-detail" id="TDTL${insuranceInfo.suppGoodsId}">
                                       <dl class="clearfix">
                                           <dt>描述</dt>
                                           <dd>
                                              ${insuranceInfo.branchDesc}
                                           </dd>
                                       </dl>
                                       <span class="shouqi">收起<i class="arrow"></i></span>
                                       <div class="ftd-arrow"><span>◆</span><i>◆</i></div>
                                   </div>
                                </div>
                                </#list>
                            </div>
                        </div>
                    </#if>
                    </div>
                </dd>
            </dl>
            </#if>
            <!--可选产品结束-->
        </div>

        <!--联系人信息填写--开始-->
        <div id="contractDiv" class="order_box">
            <h3 class="order_tit" style="display: none">联系人信息</h3>
            <!--此处改成异步-->
            <div class="name_list js_checkName" style="display:none">
            <!--<b class="lixirenClass" style="display: none">常用联系人：</b>-->
            </div>
            <span id="toLogin" class="ts_text" style="display: none"><i class="tip-icon tip-icon-info"></i>  <a href="javascript:void(0)" onclick="toLogin();">登录</a> 后获得常用联系人信息，极速填写订单</span>
            <!--游玩人--开始-->

            <#assign peopleCount = (passengers.adultCount + passengers.childCount)*quantity>
            <#list 1..peopleCount as i>
            <div class="user_info border_t1_dotted">
                <dl class="user_dl">
                    <dt><span class="red">*</span>姓名：</dt>
                    <dd>
                        <input class="input js_yz" type_name="text"  type="text" placeholder="姓名" onblur="checkUserName(this);"
                         <#if i == 1>onchange="initGoumai(this);"</#if>
                        >

                        <div class="fillInBtn" id="${i}">填写说明
                            <div class="fillingExplanation" id="fillingExplanation_${i}">
                            </div>
                        </div>

                        <input type="hidden" name="receiverId" value=""  >
                        <!--<#if i == 1><span class="btn cbtn-default js_btn_copy">复制购买人信息</span></#if>-->
                        <span class="error_text"><i class="tip-icon tip-icon-error"></i>请输入正确的姓名</span>
                    </dd>
                </dl>
                <dl class="user_dl">
                    <dt><span class="red">*</span>人群：</dt>
                    <dd>
                        <select class="select peopleType" name="peopleType" onchange="changePeopleTypeCheck(this)">
                           <option value="ADULT"  > 成人</option>
                           <option value="CHILDREN" <#if i gt passengers.adultCount*quantity> selected="selected" </#if> > 儿童</option>
                        </select>
                        <span class="error_text"><i class="tip-icon tip-icon-error"></i>据航空公司标准（2-12周岁为儿童），您所填游玩人年龄与人群类型不符</span>
                    </dd>
                </dl>
                <dl class="user_dl" style="display:none">
                    <dt><span class="red">*</span>手机号码：</dt>
                    <dd>
                        <input class="input js_yz js_textBig" type_name="mobile" maxlength="11" type="text"  placeholder="手机号码" value="">
                        <span class="error_text"><i class="tip-icon tip-icon-error"></i>请输入正确的手机号码</span>
                    </dd>
                </dl>
                <dl class="user_dl">
                    <dt><span class="red">*</span>证件类型：</dt>
                    <dd>
                        <select class="select js_zhengjian" name="cardType">
                            <option value="ID_CARD"  selected="selected" >身份证</option>
                            <option value="PASSPORT" >护照</option>
                        </select>
                        <input class="input js_yz" type_name="shenfenzheng" type="text"  value="" placeholder="证件号码"  onblur="blurIdAndBirthday(this,'ID')">
                        <span class="ts_text"><i class="tip-icon tip-icon-info"></i>为了您能顺利出游，请务必确认所填姓名、证件类型和证件号码与所持证件保持一致；</span>
                        <span class="error_text"><i class="tip-icon tip-icon-error"></i>证件信息错误或重复，请进行修改</span>
                    </dd>
                </dl>
                <dl class="user_dl js_zhengjian_hide" style="display:none;">
                    <dt><span class="red">*</span>出生日期：</dt>
                    <dd>
                        <input class="input js_birthday js_yz" type_name="birthday" type="text" readonly="readonly" value="" placeholder="yyyy-mm-dd"  onblur="blurIdAndBirthday(this,'birthday')">
                        <span class="error_text"><i class="tip-icon tip-icon-error"></i>请选择出生日期</span>
                    </dd>
                </dl>
                <h5 class="youwan_tit">游玩人${i}</h5>
            </div><!--游玩人1--结束-->
            </#list>


            <!--购买人--开始-->
            <div class="user_info js_copy_info"> <!--js_copy_info是购买人专用的，下面得复制购买人信息按钮点击,需要读取这个名字下面输入得内容-->
                <h5 class="youwan_tit">购买人</h5>
                <div class="Preser_box Preser_box_long">
                    <label class="check"><input class="checkbox" checked type="checkbox">保存所有人信息</label>
                </div>
                <dl class="user_dl">
                    <dt><span class="red">*</span> 中文姓名：</dt>
                    <dd>
                        <input class="input js_yz js_goumai_name" onblur="checkUserName(this);" type_name="text" type="text" placeholder="姓名" value="">
                        <input type="hidden" name="receiverId" >
                        <input  type="hidden" name="certType">
                        <input  type="hidden" name="certNo">
                        <input  type="hidden" name="peopleType" >
                        <input  type="hidden" name="birthday">
                        <span class="error_text"><i class="tip-icon tip-icon-error"></i>请输入正确的姓名</span>
                    </dd>
                </dl>
                <dl class="user_dl">
                    <dt><span class="red">*</span>手机号码：</dt>
                    <dd>
                        <input class="input js_yz js_textBig" type_name="mobile" maxlength="11" type="text" value="" placeholder="手机号码"  onblur="initContractData(this)">
                        <span class="ts_text">此手机号为接收短信所用，作为订购与取票凭证，请准确填写。</span>
                        <span class="error_text"><i class="tip-icon tip-icon-error"></i>请输入正确的手机号码</span>
                    </dd>
                </dl>
                <dl class="user_dl">
                    <dt><span class="red">*</span>邮箱地址：</dt>
                    <dd>
                        <input class="input js_yz js_email" type_name="email" value="" type="text" placeholder="邮箱">
                        <span class="ts_text">此邮箱地址为接收邮件所用，作为订购与取票凭证，请准确填写。</span>
                        <span class="error_text"><i class="tip-icon tip-icon-error"></i>请输入正确的邮箱地址</span>
                    </dd>
                </dl>
            </div><!--购买人--结束-->


        </div><!--联系人信息填写--结束-->


        <!--付款按钮-->
        <div class="fk_box_fixed mt_20">
            <div class="fk_box">
                <a class="btn_fk" href="javascript:infoSubmit('${shoppingUUID}',${adultCount},${childCount});">同意以下协议，去付款</a>
                <div class="fk_l">
                    <a href="javascript:{window.history.back();}"><i class="order_icon icon_jtl"></i>返回上一步</a>
                    <div class="fk_jg">
                        <p class="fk_p1">应付总价<span><small>¥</small><em id="salesPrice"></em></span></p>
                    </div>
                </div>
            </div>
        </div>

        <p class="xieyi_ok"><label class="check"><input class="checkbox" type="checkbox" checked>我已同意以下条款</label></p>

        <div class="order_box">
            <div class="lv-agree">
                <h4>预订须知</h4>
                <div id="bookingNotice"></div>
             </div>
             <span class="xieyi_gd" style="margin-top:-70px">查看更多<i class="icon_arrow"></i></span>
        </div>
        <div class="order_box" style="height:40px">
            <div class="lv-agree">
                <#if bizCategoryId == 18>
                    <h4>委托服务协议书</h4>
                <#else>
                    <h4>团队境内旅游合同</h4>
                </#if>
             </div>
             <span class="xieyi_qw" style="margin-top:-70px">查看全文</span>
        </div>
    </div>
</div>


<!--合同查看全文，弹窗内容-->
<div class="ht_box" style="height:400px;overflow-y:auto;"><!-- <iframe src="团队境内旅游合同.html" height="400" width="720"> -->
<div id="hetong" style="margin:0px auto;"></div>
</div>
<!--请求计算价格失败弹框 start  -->
<div class="returnAlert">
    <a href="javascript:;" class="ph_icon_closeAlert"></a>
    <div class="prompt">提示</div>
    <div class="sorryWarp">
        <div class="sorryImg"></div>
        <p id ='errorMsg'></p>
    </div>
    <div class="sorryBtn">
        <a href="javascript:;" class="fh-return-btn">重新查询</a>
    </div>
</div>

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
</div>

<!--<div class="resortOver" style="display: none;"></div>-->

 <div id="fillingExplanationHtml" style="display:none;">
   <ol>
    <li>乘客姓名需与登机所持证件上的名字一致。</li>
    <li>中文姓名：
    <ul>
    <li>若持护照登机，必须确认护照上有中文姓名。</li>
    <li>生僻字可用拼音代替，例如：“王鬳”可输入为“王yan”。</li>
    <li>姓名中含特殊符号“··”“_”等，可不用输入，例如：<br>
    　“汉祖然·买买提”可输入为汉祖然买买提。</li>
    <li>香港、台湾、澳门的护照不支持国内航班，请改用其他证件。</li>
    </ul>
    </li>
    <li>英文姓名:
    <ul>
    <li>若持护照登机，必须按照护照顺序区分姓与名。例如： "Smith/Black"，不区分大小写。</li>
    <li>名字长度≤26个字符，若过长请使用缩写。</li>
    </ul>
    </li>
 </ol>
<div class="info_arrow"><span>◆</span><i>◆</i></div>

 </div>
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
<script src="http://s3.lvjs.com.cn/min/index.php?f=js/new_v/jquery-1.7.2.min.js,/js/ui/lvmamaUI/lvmamaUI.js,/js/new_v/top/header-air_new.js,/js/v5/modules/pandora-poptip.js,/js/v4/modules/pandora-calendar.js,/js/v4/modules/pandora-dialog.js,/js/common/poplogin.js"></script>
<script src="${request.contextPath}/js/order/order.js"></script>
<script src="${request.contextPath}/js/comm/common.js"></script>
<script src="${request.contextPath}/js/comm/login.js"></script>
<script src="${request.contextPath}/js/order/sdp-order.js"></script>
<script type="text/javascript" src="http://pic.lvmama.com/js/common/losc.js"></script>

<script>
var basePath = "${request.contextPath}";
var shopingUUID = "${shoppingUUID}";

$(function(){
    //获取价格
    initPrice(shopingUUID);
    //初始化登录
    initUserName();
    //获取常用联系人
    initPassengers();
    //证件控件初始化
    initId_Card();
    initPassport();
    //获取合同
    getContracts(shopingUUID)
    //获取预订须知
    getBookingNotice();
});

//登录
function toLogin(){
    //登录之后只做查当前用户、常用联系人操作
    showLogin(function (){
            initUserName();
            initPassengers();
                $("#toLogin").remove();
                $("#picCodeContainer").remove(); 
                $("#picCodeContainer").remove(); 
                $("#login_user").attr("status","1");
                $('.dialog-close').click(); //如果没有关闭登陆弹窗，就写这个click
                $("[zType='ifUnLogin']").remove();
    });
    
    
    
}

function initGoumai(obj){
     $('.js_goumai_name').val($(obj).val());
}


$(document).bind("click", function($element) {

        if($element.target.className=='fillInBtn'){
            $("#fillingExplanation_"+$element.target.id).html($("#fillingExplanationHtml").html());
            $("#fillingExplanation_"+$element.target.id).toggle(function(){
                $(".fillingExplanation").show();
            },function(){
                $(".fillingExplanation").hide();
            });
        }else{
            $(".fillingExplanation").hide();
        }
});

//获取会员
function initUserName() {
    $.ajax({
        url : "${request.contextPath}/getUserByLvSessionId",
        async : true,
        type : "POST",
        success : function(data) {
            var userName = '';
            if(data.userName==undefined) {
                userName = "请登录";
                //没有获取到会员时，显示登录按钮
                $("#toLogin").show();
                $("#contractDiv").addClass("fit-order-to-log");
            }else{
                userName = "<b>"+data.userName+"</b>";
                $("#contractDiv").addClass("fit-order-logged");
            }
            $(".welcome").html("您好，" + userName);
        }
    });
}

//获取常用联系人
function initPassengers(){
	var lastReceiverIds = "${receiveIds}";
	var isSuccess = window.localStorage.getItem('isSuccess');
	if(isSuccess=='true'){
		lastReceiverIds = "";
	}
    $.ajax({
        url : "${request.contextPath}/getVstPassengers",
        async : true,
        type : "POST",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success : function(data) {
            if(data.length == 0){
                return;
            }
            var nameList = '';
            if(data.length>8){
            	nameList = '<a href="javascript:;" class="fit-order-logged fit-more-contact">更多<i class="icon_arrow"></i></a><b>常用联系人：</b>';
           }
            for(var i=0; i<data.length; i++) {
            	var checkFlag ;
            	if(lastReceiverIds!=""&&lastReceiverIds.indexOf(data[i].receiverId)>-1){
            		checkFlag ='<label class="check"><input class="checkbox" type="checkbox" value="'+data[i].receiverId+'" id="passenger_' + data[i].certNo + '" onclick="checkUser(this)" checked="checked">' + data[i].receiverName
            	}else{
            		checkFlag ='<label class="check"><input class="checkbox" type="checkbox" value="'+data[i].receiverId+'" id="passenger_' + data[i].certNo + '" onclick="checkUser(this)">' + data[i].receiverName
            	}
                nameList = nameList + checkFlag
                					//+ '<label class="check"><input class="checkbox" type="checkbox" value="'+data[i].receiverId+'" id="passenger_' + data[i].certNo + '" onclick="checkUser(this)">' + data[i].receiverName
                                    + '<input type="hidden" name="receiverId" value="' + data[i].receiverId + '">'
                                    + '<input type="hidden" name="receiverName" value="' + data[i].receiverName + '">'
                                    + '<input type="hidden" name="mobileNumber" value="' + data[i].mobileNumber + '">'
                                    + '<input type="hidden" name="certType" value="' + data[i].certType + '">'
                                    + '<input type="hidden" name="certNo" value="' + data[i].certNo + '">'
                                    + '<input type="hidden" name="email" value="' + data[i].email + '">'
                                    + '<input type="hidden" name="birthday" value="' + data[i].birthdayStr + '">'
                                    + '<input type="hidden" name="peopleType" value="' + data[i].peopleType + '">'
                                    + '</label>';
            }

            $(".js_checkName").append(nameList);
            $(".js_checkName").css("display","block");
            //$(".lixirenClass").css("display","block");
            $(".order_tit").show();
        }
    });
}
</script>
</body>
</html>
