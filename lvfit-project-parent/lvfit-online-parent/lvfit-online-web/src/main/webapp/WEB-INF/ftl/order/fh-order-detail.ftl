<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>我的订单-驴妈妈旅游网</title>
    <link rel="icon" href="http://www.lvmama.com/favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="http://www.lvmama.com/favicon.ico" type="image/x-icon" />
    <link href="http://pic.lvmama.com/styles/new_v/header-air.css" rel="stylesheet" />
    <link href="http://pic.lvmama.com/styles/mylvmama/ui-lvmama.css" rel="stylesheet" />
    <link href="http://pic.lvmama.com/styles/mylvmama/ui-components.css" rel="stylesheet" />
    <link href="http://pic.lvmama.com/styles/mylvmama/lv-bought.css" rel="stylesheet" />
    <link rel="stylesheet" href="http://pic.lvmama.com/styles/global_pop.css">
    <link href="http://pic.lvmama.com/styles/new_v/ob_common/ui-components.css" rel="stylesheet" />
    <link rel="stylesheet" href="http://pic.lvmama.com/styles/v6/header_new.css">
    <link rel="stylesheet" href="http://pic.lvmama.com/styles/v6/index_new.css">
    <link rel="stylesheet" href="http://pic.lvmama.com/styles/v5/modules/tip.css">
    <link rel="stylesheet" href="http://pic.lvmama.com/styles/v6/flighthotel/fh-order-detail.css">
    <style type="text/css">
	.xit-list .xpro-detail {
	    margin: -20px 0 15px 80px;
	    display: inline-block;
	}
	.fh-ticket-detail dl {
        margin-bottom: 30px;
    }
    .shouqi{
        float:left;
        color:#0099cc;
        position: absolute;
        bottom: 10px;
        right: 36px;
        cursor: pointer;
    }
	.shouqi:hover{
	    text-decoration: underline;
	}
	.shouqi .shouqi_arrow {
	    border-color: transparent transparent #09c transparent;
	    top: 2px;
	    right: -10px;
	}
	.shouqi_arrow {
	    display: inline-block;
	    margin-left: 4px;
	    border-width: 4px;
	    border-style: solid;
	    width: 0;
	    height: 0;
	    overflow: hidden;
	    font-size: 0;
	    position: absolute;
	}
    .timeCenter{
        width: 46px;
        display: inline-block;
        text-align: center;
    }
    
    
  .button {
    background-color: #009dda;
    color: #fff;
    float: left;
    height: 30px;
    line-height: 30px;
    margin-left: 300px;
     margin-top: 10px;
    text-align: center;
    width: 100px;
    cursor:pointer;
}
    </style>
    <script src="http://pic.lvmama.com/js/new_v/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="http://s2.lvjs.com.cn/js/common/losc.js"></script>
    <script type="text/javascript">
    $(function() {
        $("span.selfPack").hover(function() {
                $("#relat_product_list").show();
            },
            function() {
                $("#relat_product_list").hide();
            }
        );
    });
    
    function toVstOrderDetail(){
        var url =  "http://super.lvmama.com/vst_order/order/orderManage/showOrderStatusManage.do?orderType=parent&orderId="+'${result.vstOrderMainNo}';
        window.open(url);
    }
    
    </script>
</head>

<body id="page-order" class="fh-order-detail w_1000" >
<#if getSuperCommonHeader ??>
    <#if isNew>
        ${getSuperCommonHeader('company',true,'${provinceId}','${cityId}','${stationName}','index')}
    <#else>
        ${getSuperCommonHeader()}
    </#if>
</#if>

    <#if isBackBooking=='true'>
    
        <br>
          <h3 style="font-weight: normal;">&nbsp;&nbsp;&nbsp;&nbsp;<a href="${request.contextPath}/back_index" style="color:#21a8dc">首页</a> >
                <a href="${request.contextPath}/search/backToShopping?shoppingUUID=${uuid}" style="color:#21a8dc">产品选择页</a></a> > 订单详情页
           </h3>
     </#if>

    <div id="wrap" class="ui-container lvmama-bg">
    
        <#if isBackBooking=='true'>
           <div class="lv-nav wrap">
            <p>
              </p>
            </div>
        <#else>
           <div class="lv-nav wrap">
            <p>
                <a href="http://www.lvmama.com/myspace/index.do">我的驴妈妈</a> &gt;
                <a href="http://www.lvmama.com/myspace/order.do">我的订单</a> &gt;
                <a class="current">订单详情</a>
            </p>
            </div>
          </#if>
        
        <div class="wrap ui-content lv-bd">
            <!-- 订单详情>> -->
            <div class="ui-box mod-edit order_detail-edit pd10">
                <div class="ui-box-title">
                    <h3>订单详情</h3></div>
                <!-- 订单信息>> -->
                <div class="clearfix">
                    <h4>游客信息</h4>
                    <p class="p-info first">联系人姓名
                        <strong>
                            ${result.fitOrderContacterDto.name}
                        </strong>　　　联系人手机：
                        <strong>
                            ${result.fitOrderContacterDto.mobile}
                        </strong>
                    </p>
                    <table class="lv-table order_detail-table">
                        <tbody>
                            <tr>
                                <th>姓名</th>
                                <!--<th>手机</th>-->
                                <th>证件类型</th>
                                <th>证件号码</th>
                                <th>出生年月</th>
                                <th>乘客类型</th>
                            </tr>
                            <#if result.fitOrderPassengers?? && result.fitOrderPassengers?size gt 0>
                            <#list result.fitOrderPassengers as passenger>
                            <tr>
                                <td>${passenger.passengerName}</td>
                                <!--<td>
                                    ${passenger.mobile}
                                </td>-->
                                <td>
                                    ${passenger.passengerIDCardType.cnName}
                                </td>
                                <td>
                                    ${passenger.passengerIDCardNo}
                                </td>
                                <td>
                                    ${passenger.passengerBirthday}
                                </td>
                                <td>
                                    ${passenger.passengerType.cnName}
                                </td>
                            </tr>
                            </#list>
                            </#if>
                        </tbody>
                    </table>

                    <h4>订单信息</h4>
                    <ul class="order-info clearfix">
                        <li>订单号：${result.vstOrderMainNo}</li>
                        <li>订单状态：${result.orderViewStatus}</li>
                        <li>应付总价：<dfn>&yen;<i class="f18">${result.totalAmount}</i></dfn></li>
                        <li>下单时间：${result.createTime}</li>
                        <li>支付方式：${result.paytarget}</li>
                    </ul>
                    <!-- 订单列表>> -->
                    <div class="order_list-box">
                        <table class="lv-table order_list-table">
                            <colgroup>
                                <col class="lvcol-1">
                                    <col class="lvcol-2">
                            </colgroup>
                            <thead>
                                <tr class="thead">
                                    <th class="product-name">产品名称</th>
                                    <th class="play-date">游玩日期</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <div id="relat_product_list" style="display:none;position:absolute;background-color:#fff;border:1px solid #ccc;width:359px;padding:10px;text-align:left">
                                        <td class="product-name-content">${result.productName}</td>
                                    </div>
                                    <td class="play-date-content">${result.visitTime}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <!-- <<订单列表 -->

                    <h4>航班信息</h4>
                    <table class="table_list table_t flight-list clearfix">
                        <tbody>
                            <!-- 机票列表循环-->
                            <#if flights?? && flights?size gt 0>
                            <#list flights as flight>
                            	<#if flight.tripType=='DEPARTURE'>
                            		<tr class="flight-detail flight-detail-depa">
                            	<#else>
                            		<tr class="flight-detail">
                            	</#if>
                            	<td class="flight-name">${flight.departureCityName}<span class="fh-icon fh-icon-to"></span>${flight.arrivalCityName}</td>
                                <#assign toDepartureTime=flight.departureTime?datetime("yyyy-MM-dd HH:mm:ss")>
                                <#assign toArrivalTime=flight.arrivalTime?datetime("yyyy-MM-dd HH:mm:ss")>
                                <td class="flight-info"><span class="day">${flight.departureDate}</span><span class="time">${toDepartureTime?string("HH:mm")}</span><span class="airport">${flight.departureAirportName} ${flight.departureTermainalBuilding}</span></br><span class="day">${toArrivalTime?string("yyyy-MM-dd")}</span><span class="time">${toArrivalTime?string("HH:mm")}</span><span class="airport">${flight.arrivalAirportName} ${flight.arrivalTerminalBuilding}</span></td>
                                <td class="flight-stop">
                                <#if flight.stopCount?? && flight.stopCount gt 0>
                                    经停
                                </#if>                                                                
                                </td>
                                <td class="flight-company"><span class="name">${flight.carrierName}</span><span class="number">${flight.flightNo}</span>
                                <span class="plane-type" data-plan="${flight.airplane.code}" data-name="${flight.airplane.name}" data-type="${flight.airplane.airplaneType}" data-min="${flight.airplane.minSeats}" data-max="${flight.airplane.maxSeats}">${flight.airplane.code}</span>
                                </td>
                                <td class="flight-type">${flight.seatClassTypeName}</td>
                                
                                <td class="flight-ticket-number">
                                    <div class="title">票号：</div>
                                    <#list ticketNos?keys as key>
                                    <#assign tripeType = flight.tripType>
                                    <#if key == tripeType>
                                    <div>
                                        <#assign item = ticketNos[key]>
                                        <#list item as itemValue>
                                            <#if itemValue.ticketNo != null && itemValue.ticketNo != ''>
                                                ${itemValue.name} ${itemValue.ticketNo}
                                                </br>
                                            </#if>
                                        </#list>
                                    </div>
                                    </#if>
                                    </#list>
                                </td>
   
                                </tr>
                            </#list>
                            </#if>
                        </tbody>
                    </table>
                    
                    <#if hotelInfo ?? && hotelInfo?size gt 0>
                    <h4>酒店信息</h4>
                    <table class="table_list table_t hotel-list">
                        <tbody>
                        <#list hotelInfo as hotel>
                            <tr class="hotel-detail">
                                <td class="hotel-name">${hotel.hotelName}</td>
                                <td class="hotel-room-type">
                                    <span>${hotel.roomName} - ${hotel.planName}</span></br>
                                    <span>${hotel.branchDesc}</span>
                                </td>
                                <td class="hotel-time"><span class="hotel-top">${hotel.checkin?string("yyyy-MM-dd")} 入住</span></br><span>${hotel.checkout?string("yyyy-MM-dd")} 离店</span></td>
                                <td class="hotel-amount">${hotel.roomCount}间</td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    </#if>
                    
                    <#if spotTickets?size gt 0 ||  insurances?size gt 0 || flightInsurances?size gt 0>
                    <h4 class="xpro-title">可选产品信息</h4>
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
                        <!-- 可选产品门票 -->
                        <#if spotTickets?size gt 0>
                        <div class="xpro-item xpro-item-ticket clearfix">
                            <div class="xpro-type">门票</div>
                            <div class="xit-list">
                                <#list spotTickets as ticket>
                                <div class="xpro-detail clearfix" data-id="T${ticket.ticketGoodsDetailDto.suppGoodsId}">
                                    <div class="xpro-name"><em>${ticket.spotName}-${ticket.ticketName}</em></div>
                                    <div class="xpro-time">${ticket.visitDate?string('yyyy-MM-dd')}</div>
                                    <div class="xpro-amount">${ticket.ticketCount}</div>
                                    <div class="xpro-price"><i>￥</i>${ticket.ticketPrice}</div>
                                </div>
						        <div class="fh-ticket-detail" id="TDTL${ticket.ticketGoodsDetailDto.suppGoodsId}">
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
						            <span class="shouqi">收起<i class="shouqi_arrow"></i></span>
						            <div class="ftd-arrow"><span>◆</span><i>◆</i></div>
						        </div>
                                </#list>
                            </div>
                        </div>
                        </#if>
                        
                        <#if insurances?size gt 0 || flightInsurances?size gt 0>
                        <div class="xpro-item xpro-item-insurance clearfix">
                            <div class="xpro-type">保险</div>
                            <div class="xit-list">
                            <#list flightInsurances as insuranceInfo>
                                <div class="xpro-detail clearfix" data-id="T${insuranceInfo.id}">
                                    <div class="xpro-name"><em>${insuranceInfo.insuranceName}</em></div>
                                    <div class="xpro-time"><span class="timeCenter">--</span></div>
                                    <div class="xpro-amount">${insuranceInfo.insuranceCount}</div>
                                    <div class="xpro-price"><i>￥</i>${insuranceInfo.insurancePrice}</div>
                                </div>
                                <!-- 门票保险规则 -->
                                <div class="fh-ticket-detail" id="TDTL${insuranceInfo.id}">
                                    <dl class="clearfix">
                                        <dt>描述</dt>
                                            <dd>
                                                ${insuranceInfo.insuranceDesc}
                                            </dd>
                                        </dl>
                                        <span class="shouqi">收起<i class="shouqi_arrow"></i></span>
                                        <div class="ftd-arrow"><span>◆</span><i>◆</i></div>
                                </div><!-- 门票保险规则结束 -->
                            </#list>
	                        <#list insurances as insuranceInfo>
                                <div class="xpro-detail clearfix" data-id="T${insuranceInfo.insuranceSuppGoodsId}">
                                    <div class="xpro-name"><em>${insuranceInfo.insuranceName}-${insuranceInfo.insuranceSuppGoodsName }-${insuranceInfo.insuranceBranchName }</em></div>
                                    <div class="xpro-time"><span class="timeCenter">--</span></div>
                                    <div class="xpro-amount">${insuranceInfo.insuranceCount}</div>
                                    <div class="xpro-price"><i>￥</i>${insuranceInfo.insurancePrice}</div>
                                </div>
                                <!-- 门票保险规则 -->
						        <div class="fh-ticket-detail" id="TDTL${insuranceInfo.insuranceSuppGoodsId}">
						            <dl class="clearfix">
						                <dt>描述</dt>
							                <dd>
							                    ${insuranceInfo.insuranceDetail}
							                </dd>
							            </dl>
							            <span class="shouqi">收起<i class="shouqi_arrow"></i></span>
							            <div class="ftd-arrow"><span>◆</span><i>◆</i></div>
								</div><!-- 门票保险规则结束 -->
                            </#list>
                            </div>
                        </div>
                        </#if>
                        
                    </div>
                    </#if>
                </div>
            </div>
        </div>
        <div class="hr_b"></div>
        
        <#if isBackBooking=='true'>
        <div class="wrap ui-content lv-bd">
        <div class="view-box clearfix">
           <div class="order_list-box">
         <h4>退改规则：<span style="color:blue;">人工退改</span></h4>
        <h3>您的订单已提交成功！我们正在审核您的订单，审核通过后，会电话联系您付款！</h3>
             <div class="button" ><span onclick="javascript:toVstOrderDetail();">查看订单</span></div><br>
        </div>
        </div>
        </div>
        <#else>
         <div class="buttom clearfix">
            <div class="buttom_list">
                <b class="buttom_list_tit1">订购指南</b>
                <a rel="nofollow" href="http://www.lvmama.com/public/help_center_2" target="_blank">门票订购流程是怎样的？</a>
                <a rel="nofollow" href="http://www.lvmama.com/public/help_center_4" target="_blank">二维码使用时有什么注意事项？</a>
                <a rel="nofollow" href="http://www.lvmama.com/public/help_center_5" target="_blank">可以预定多长时间的门票？</a>
                <a rel="nofollow" href="http://www.lvmama.com/public/help_center_10" target="_blank">想要修改订单，怎么操作？</a>
            </div>
            <div class="buttom_list">
                <b class="buttom_list_tit2">注册与登录</b>
                <a rel="nofollow" href="http://www.lvmama.com/public/help_center_132" target="_blank">手机没有收到激活/验证短信怎么办？</a>
                <a rel="nofollow" href="http://login.lvmama.com/nsso/register/registering.do" target="_blank">怎样才能成为驴妈妈会员？</a>
                <a rel="nofollow" href="http://login.lvmama.com/nsso/login" target="_blank">在哪登录会员帐号？</a>
                <a rel="nofollow" href="http://www.lvmama.com/public/help_center_149" target="_blank">如何修改我的帐号密码？</a>
            </div>
            <div class="buttom_list">
                <b class="buttom_list_tit3">支付与取票</b>
                <a rel="nofollow" href="http://www.lvmama.com/public/buy_guide#m_2" target="_blank">付款方式有哪些？</a>
                <a rel="nofollow" href="http://www.lvmama.com/public/buy_guide#m_2" target="_blank">在线支付安全吗？</a>
                <a rel="nofollow" href="http://www.lvmama.com/public/buy_guide#m_2" target="_blank">为什么支付不成功？</a>
                <a rel="nofollow" href="http://www.lvmama.com/public/buy_guide#m_2" target="_blank">想要退款，应该怎么做？</a>
            </div>
            <div class="buttom_list" style="border: medium none;">
                <b class="buttom_list_tit4">沟通与订阅</b>
                <a rel="nofollow" href="http://www.lvmama.com/userCenter/user/transItfeedBack.do" target="_blank">我想咨询门票，应该怎么办？</a>
                <a rel="nofollow" href="http://www.lvmama.com/userCenter/user/transItfeedBack.do" target="_blank">我有意见，在哪可以提？</a>
                <a rel="nofollow" href="http://www.lvmama.com/userCenter/user/transItfeedBack.do" target="_blank">我想投诉，应该怎么反映？</a>
                <a rel="nofollow" href="http://www.lvmama.com/public/about_lvmama#m_1" target="_blank">我是景区负责人，怎么联系驴妈妈？</a>
            </div>
        </div>
       </#if>

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
        <#if isBackBooking=='true'>
       <#else>
	       <#include "online_foot.ftl">
       </#if>
    </div>
    <!--
<div id="xh_floatR">
    <div class="bm-box ie6png">
        <i class="close" title="今天不再提醒"></i>
        <a class="bm-link" target="_blank" title="" href="#"></a>
    </div>
</div>
-->
    <!--[if lte IE 6]>
<script src="http://pic.lvmama.com/js/zt/DD_belatedPNG.js" ></script>
<script type="text/javascript">
   DD_belatedPNG.fix('.ie6png');
</script>
<![endif]-->
    <script src="http://pic.lvmama.com/min/index.php?f=/js/new_v/jquery-1.7.2.min.js,/js/ui/lvmamaUI/lvmamaUI.js,/js/new_v/top/header-air_new.js,/js/v6/public/searchComplete.js,/js/v6/header_new.js"></script>
    <!--
<script src="http://pic.lvmama.com/js/new_v/jquery_cookie.js"></script>
<script src="http://pic.lvmama.com/js/new_v/util/jurlp.min.js"></script>
<script src="http://pic.lvmama.com/js/new_v/top/header-air.js"></script>
-->
    <script src="http://pic.lvmama.com/js/mylvmama/jquery-ui-1.8.21.custom.min.js"></script>
    <script src="http://pic.lvmama.com/js/mylvmama/jquery.tools.min.js"></script>
    <script src="http://pic.lvmama.com/js/mylvmama/lvmama-custom.js"></script>
    <script src="http://pic.lvmama.com/js/common/losc.js"></script>

    <script src="http://pic.lvmama.com/js/v5/modules/pandora-poptip.js"></script>
    <script src="http://pic.lvmama.com/js/v6/flighthotel/fh-flight-tip.js"></script>
    <script src="http://pic.lvmama.com/js/v6/flighthotel/fh-order-detail.js"></script>


    <script type="text/javascript">
    $(function() {
        $(document.body).ready(function() {
            $.ajax({
                url: "http://www.lvmama.com/myspace/message/unReadCount.do",
                type: "post",
                dataType: "json",
                success: function(json) {
                    //$("#myspace_message_count,#myspace_message_count_id").text(json.count);
                    var num = json.waittingCommentNumber;


                    if (num === "0") {
                        $("#lvnav-comment >a").eq(1).hide();
                    } else {
                        $("#lvnav-comment >a").eq(1).show();
                    }

                    $("#waittingCommentNumber").text(num);

                },
                error: function() {
                    $("#lvnav-comment >a").eq(1).hide();
                }
            });

            var url = "http://www.lvmama.com/message/index.php?r=PrivatePm/GetUnreadCount&callback=?";
            $.getJSON(url, function(json) {
                if (json.code == 200) {
                    var num = json.data.unreadCount;
                    if (num == 0) {
                        $("#myspace_message_count_a").removeClass("msg-num");
                        $("#myspace_message_count_id").text(num);
                    } else {
                        $("#myspace_message_count,#myspace_message_count_id").text(num);
                    }
                } else {
                    $("#myspace_message_count_span").hide();
                    $("#myspace_message_count_a").removeClass("msg-num");
                }
            });

        });
    });

    // 门票规则
    $(".xpro-item .xpro-name em").click(function() {
        $('.fh-ticket-detail').css({
            'position': 'relative',
            'z-index':'1',
            'margin': '-10px 80px 30px',
            'float': 'left'
        });
        var $this = $(this);
        var $detail = $this.parents(".xpro-detail");
        var id = $detail.data("id");
        var $dialog = $("#TDTL" + id.substring(1));
        $dialog.toggle();
    });

    $(".shouqi").click(function() {
        var $ticket_detail = $(this).parents(".fh-ticket-detail");
        $ticket_detail.hide();
    })
    </script>
</body>