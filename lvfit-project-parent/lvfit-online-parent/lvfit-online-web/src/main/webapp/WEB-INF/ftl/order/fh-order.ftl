<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>机+酒订单填写页面</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="shortcut icon" href="http://www.lvmama.com/favicon.ico" type="image/x-icon"> 
<link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/new_v/header-air.css,/styles/v3/core.css,/styles/v4/modules/step.css,/styles/v5/modules/tip.css,/styles/v5/modules/tags.css,/styles/v4/modules/calendar.css,/styles/v4/modules/dialog.css,/styles/v6/flighthotel/fh-result-loading.css,/styles/v6/flighthotel/fh-icon-ac.css,/styles/v5/modules/dialog.css,/styles/common/poplogin.css">
<link rel="stylesheet" href="http://pic.lvmama.com/styles/v6/order.css"> 
<link rel="stylesheet" href="${request.contextPath}/css/fh-order.css">
<script type="text/javascript">
var _data = {};
_data._shopingUUID = '${shopingUUID}';
_data._contextPath = "${request.contextPath}";
_data._visitTime = "${flightInfos?first.departureDate }";
</script>
</head>
<body class="order fh-order">
    <!-- 流量埋点 -->
    <script src="http://pic.lvmama.com/min/index.php?f=/js/v5/ibm/eluminate.js"></script>
    <script src="http://pic.lvmama.com/min/index.php?f=/js/v5/ibm/coremetrics-initalize.js"></script>
    <script>_LVMAMA_COREMETRICS.init(document.domain);</script>
    <script>
        cmCreatePageviewTag("机酒频道首页_<订单填写页>", "FlightHotel", null, null,"-_--_--_--_--_-路径页面");
        
        
    </script>
    <script type="text/javascript" src="http://s2.lvjs.com.cn/js/common/losc.js"></script>

     <#if isBackBooking=='true'>
        <br>
         <h3 style="font-weight: normal;">&nbsp;&nbsp;&nbsp;&nbsp;<a href="${request.contextPath}/back_index" style="color:21a8dc">首页</a> >
                <a href="${request.contextPath}/search/backToShopping?shoppingUUID=${shopingUUID}" style="color:#21a8dc">产品选择页</a> > 订单填写页
           </h3>
        
     </#if>

<div class="order-header wrap">
    <div class="header-inner">
      <#if isBackBooking?? >
          <p class="welcome">
             当前会员:<strong>（${user.userName}）</strong>
           </p> 
       <#else>
         <a class="logo" href="http://www.lvmama.com/">自在游天下 就找驴妈妈</a>
         <p class="welcome">
            您好，
          <#if user?? >
            ${user.userName}
         <#else>
                 您还未登录！   
          </#if>
        </p>
        <p class="info">24小时服务热线：<strong>1010-6060</strong></p>
       </#if>
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
            <h1 class="order_name" id="fit_productName">
            <span>
                ${productName}
            </span>
            </h1>
            <dl class="order_dl">
                <dt>机票</dt>
                <dd>
                    <div class="table_list table_tit">
                        <ul class="table_list_t flight-detail">
                            <li class="flight-name"><#if tripType == "WF">往返</#if><#if tripType == "DC">单程</#if></li>
                            <li class="flight-info">航班信息</li>
                            <li class="flight-depa-stop">起飞信息</li>
                            <li class="flight-arrival-time">到达信息</li>
                            <li class="flight-duration">飞行时长</li>
                            <li class="flight-type">舱位</li>
                        </ul>
                    </div>
                    <#if flightInfos?? && flightInfos?size gt 0>
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
                        <#if flightInfo.highLightFlag ?? && flightInfo.highLightFlag == true>
                        <p class="flight-warning">
                            <i class="fh-icon fh-icon-warning"></i>该航班为隔夜航班，请留意您的酒店入住日期
                        </p>
                        </#if>
                    </div>
                    </#list>
                    </div>                    
                </dd>
            </dl>
            </#if>
            <#if hotel != null>
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
                        <!-- 酒店信息 -->
                        <div class="hotel-item">
                            <div class="hotel-detail clearfix">
                                <div class="hotel-name">
                                    <div class="hotel-center">${hotel.productName}<!-- 三亚湾红树林度假酒店 --></div>
                                </div>
                                <div class="hotel-room-type">
                                    <div class="hotel-top">${hotel.rooms[0].branchName} - ${hotel.rooms[0].plans[0].goodsName}<!-- 豪华海景房 - 商品名称 --></div>
                                    <div class="hotel-bottom">${hotel.rooms[0].branchDesc}<!-- 床型：大床  早餐：双早  宽带：免费 --></div>
                                </div>
                                <div class="hotel-time">
                                    <div class="hotel-time-day">
                                        <div class="hotel-top">${checkInDate} <!-- 入住 --></div>
                                        <div class="hotel-bottom">${checkOutDate} <!-- 离店 --></div>
                                    </div>
                                    <div class="hotel-center"><#if (roomDate)??>(${roomDate }晚)<#else></#if> </div>
                                </div>
                                <div class="hotel-amount">
                                    <div class="hotel-center">${hotel.rooms[0].plans[0].roomCounts}<!-- 预定房间数 --></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </dd>
            </dl>
            </#if>
            <#if selTickets?size gt 0 || selInsurances ?size gt 0 || insuranceInfos?size gt 0>
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
                        <!-- 可选产品门票 -->
                        <#if selTickets?size gt 0>
                        <div class="xpro-item xpro-item-ticket clearfix">
                            <div class="xpro-type">门票</div>
                            <div class="xit-list">
                                <#list selTickets as ticket>
                                <div class="xpro-detail clearfix" data-id="T${ticket.suppGoodsId}">
                                    <div class="xpro-name"><em>${ticket.spotName}-${ticket.ticketName}</em></div>
                                    <div class="xpro-time">${ticket.ticketDate?string('yyyy-MM-dd')}</div>
                                    <div class="xpro-amount">${ticket.ticketCount}</div>
                                    <div class="xpro-price"><i>￥</i>${ticket.ticketPrice}</div>
                                </div>
                                </#list>
                            </div>
                        </div>
                        </#if>
                        <!-- 可选产品保险 -->
                        <#if selInsurances?size gt 0 || insuranceInfos?size gt 0>
                        
                        <div class="xpro-item xpro-item-insurance clearfix">
                        	<div class="xpro-type">保险</div>
                            <div class="xit-list">
                                <#list insuranceInfos as fliIns>
                                <div class="xpro-detail clearfix" data-id="I${fliIns.insuranceId}">
                                    <div class="xpro-name"><em>${fliIns.insuranceName}</em></div>
                                    <div class="xpro-time" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--</div>
                                    <div class="xpro-amount">${fliIns.insuranceCount}</div>
                                    <div class="xpro-price"><i>￥</i>${fliIns.insurancePrice}</div>
                                </div>
                                <div class="fh-ticket-detail" id="TDTL${fliIns.insuranceId}">
                                    <dl class="clearfix">
                                        <dt>描述</dt>
                                        <dd>${fliIns.insuranceDesc}</dd>
                                    </dl>
                                    <span class="shouqi">收起<i class="arrow"></i></span>
                                    <div class="ftd-arrow"><span>◆</span><i>◆</i></div>
                                </div>
                                </#list>
                                <#list selInsurances as insuranceInfo>
                                <div class="xpro-detail clearfix" data-id="I${insuranceInfo.suppGoodsId}">
                                    <div class="xpro-name"><em>${insuranceInfo.productName}-${insuranceInfo.suppGoodsName }-${insuranceInfo.branchName }</em></div>
                                    <div class="xpro-time" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--</div>
                                    <div class="xpro-amount">${insuranceInfo.insuranceCount}</div>
                                    <div class="xpro-price"><i>￥</i>${insuranceInfo.insurancePrice}</div>
                                </div>
                                </#list>
                            </div>
                        </div>
                        </#if>
                    </div>
                </dd>
            </dl>
            </#if>
        </div>
        
        <!-- 登录提示 开始-->
        <div id="toLogin" class="fit-order-log-tip" style="display: none">
            <i class="tip-icon tip-icon-info"></i><a href="javascript:void(0)" onclick="toLogin();" class="fit-log-btn">登录</a>后获得常用联系人信息，极速填写订单
        </div>
        <!-- 登录提示 结束-->
        
        <!--联系人信息填写--开始-->
        <div id="contractDiv" class="order_box">
          <h3 class="order_tit">联系人信息</h3>
	      <!--此处改成异步-->
	      <div class="name_list js_checkName" style="display:none">
	      </div>
          <!--购买人--开始-->
            <div class="user_info no_bd js_copy_info"> <!--js_copy_info是购买人专用的，下面得复制购买人信息按钮点击,需要读取这个名字下面输入得内容-->
                <h5 class="youwan_tit">购买人</h5>
                <div class="Preser_box Preser_box_long">
                    <label class="check"><input class="checkbox" checked type="checkbox">保存所有人信息</label>
                </div>
                <dl class="user_dl">
                    <dt><span class="red">*</span> 中文姓名：</dt>
                    <dd>
                        <input class="input js_yz js_goumai_name" onblur="checkContactName(this);" type_name="text" type="text" placeholder="姓名" value="${contacter.name}">
                        <input type="hidden" name="receiverId" >
                        <input  type="hidden" name="certType">
	                	<input  type="hidden" name="certNo">
	                	<input  type="hidden" name="peopleType" >
	                	<input  type="hidden" name="birthday">
                        <span class="error_text"><i class="tip-icon tip-icon-error"></i>请输入姓名</span>
                    </dd>
                </dl>
                <dl class="user_dl">
                    <dt><span class="red">*</span>手机号码：</dt>
                    <dd>
                        <input class="input js_yz js_textBig" type_name="mobile" maxlength="11" type="text" value="${contacter.mobile}" placeholder="手机号码"  onblur="initContractData(this)">
                        <span class="ts_text">此手机号为接收短信所用，作为订购与取票凭证，请准确填写。</span>
                        <span class="error_text"><i class="tip-icon tip-icon-error"></i>请输入手机号码</span>
                    </dd>
                </dl>
                <dl class="user_dl">
                    <dt><span class="red">*</span>邮箱地址：</dt>
                    <dd>
                        <input class="input js_yz js_email" type_name="email" value="${contacter.email}" type="text" placeholder="邮箱">
                        <span class="ts_text">此邮箱地址为接收邮件所用，作为订购与取票凭证，请准确填写。</span>
                        <span class="error_text"><i class="tip-icon tip-icon-error"></i>请输入邮箱地址</span>
                    </dd>
                </dl>
            </div><!--购买人--结束-->  
          
          <!--游玩人--开始-->
          	<!--游玩人外层div结束-->
            <div class="fit-users">
            <span class="ts_text"><i class="tip-icon tip-icon-info"></i>为了您能顺利出游，请务必确认所填姓名、证件类型和证件号码与所持证件保持一致；</span>
			<#list 1..(adultCount+childCount) as i>
            <div <#if i == 1>class="user_info fit-user-first border_t1_dotted"<#else>class="user_info border_t1_dotted"</#if>>
                <dl class="user_dl">
                    <dt><span class="red">*</span>姓名：</dt>
                    <dd>
                        <input class="input js_yz" type_name="text"  type="text" <#if passengers[i-1]??>  value =${passengers[i-1].passengerName} </#if> placeholder="姓名" onblur="checkUserName(this);">
                        <div class="fillInBtn" id="${i}">填写说明
                            <div class="fillingExplanation" id="fillingExplanation_${i}">
                            </div>
                        </div>
                        
                        <input type="hidden" name="receiverId" <#if passengers[i-1]??>  value =${passengers[i-1].passengerId} </#if>  >
                        <#if i == 1><span class="btn cbtn-default js_btn_copy">复制购买人信息</span></#if>
                        <span class="error_text"><i class="tip-icon tip-icon-error"></i>请输入姓名</span>
                    </dd>
                </dl>
                <input type="hidden" name="email" value="">
                <dl class="user_dl">
                    <dt><span class="red">*</span>人群：</dt>
                    <dd>
                        <select class="select peopleType" name="peopleType" onchange="changePeopleTypeCheck(this)">
                           <option value="ADULT"  > 成人</option>
                           <option value="CHILDREN" <#if i gt adultCount> selected="selected" </#if> > 儿童</option>
                           <!-- <option value="ALL">所有</option> -->
                        </select>
                        <span class="error_text"><i class="tip-icon tip-icon-error"></i>据航空公司标准（2-12周岁为儿童），您所填游玩人年龄与人群类型不符</span>
                    </dd>
                </dl>
                <dl class="user_dl" style="display:none">
                    <dt><span class="red">*</span>手机号码：</dt>
                    <dd>
                        <input class="input js_yz js_textBig" type_name="mobile" maxlength="11" type="text"  placeholder="手机号码" <#if passengers[i-1]??>  value =${passengers[i-1].mobile} </#if> >
                        <span class="error_text"><i class="tip-icon tip-icon-error"></i>请输入手机号码</span>
                    </dd>
                </dl>
                <dl class="user_dl">
                    <dt><span class="red">*</span>证件类型：</dt>
                    <dd>
                        <select class="select js_zhengjian" name="cardType">
                            <option value="ID" <#if passengers[i-1]?? && passengers[i-1].passengerIDCardType == 'ID'> selected="selected"  </#if> >身份证</option>
                            <option value="PASSPORT" <#if passengers[i-1]?? && passengers[i-1].passengerIDCardType == 'PASSPORT'> selected="selected"  </#if> >护照</option>
                            <!-- <option value="OFFICER">军官证</option>
                            <option value="SOLDIER">士兵证</option>
                            <option value="TAIBAO">台胞证</option>
                            <option value="OTHER">其他</option> -->
                        </select>
                        <input class="input js_yz" type_name="shenfenzheng" type="text"  <#if passengers[i-1]??>  value =${passengers[i-1].passengerIDCardNo} </#if> placeholder="证件号码"  onblur="blurIdAndBirthday(this,'ID')">
                        <span class="error_text"><i class="tip-icon tip-icon-error"></i>证件信息错误或重复，请进行修改</span>
                    </dd>
                </dl>
                <dl class="user_dl js_zhengjian_hide" style="display:none;">
                    <dt><span class="red">*</span>出生日期：</dt>
                    <dd>
                        <input class="input js_birthday js_yz" type_name="birthday" type="text" readonly="readonly" <#if passengers[i-1]??>  value =${passengers[i-1].passengerBirthday} </#if> placeholder="yyyy-mm-dd"  onblur="blurIdAndBirthday(this,'birthday')">
                        <span class="error_text"><i class="tip-icon tip-icon-error"></i>请输入出生日期</span>
                    </dd>
                </dl>
                <h5 class="youwan_tit">游玩人${i}</h5>
            </div><!--游玩人1--结束-->
            </#list>
            
            </div><!--游玩人外层div结束-->
        </div><!--联系人信息填写--结束-->
        
        <!--付款按钮-->
        <div class="fk_box_fixed mt_20">
            <div class="fk_box">
            
               <#if isBackBooking?? >
                   <a class="btn_fk" href="javascript:infoSubmitBack('${shopingUUID }',${adultCount},${childCount });">同意以下协议，去付款</a>
                <#else>
                   <a class="btn_fk" href="javascript:infoSubmit('${shopingUUID }',${adultCount},${childCount });">同意以下协议，去付款</a>
                  </#if>
                <div class="fk_l">
                    <a href="javascript:{window.history.back();}"><i class="order_icon icon_jtl"></i>返回上一步</a>
                    <div class="fk_jg">
                        <p class="fk_p1">应付总价<span><small>¥</small><em id="salesPrice"></em></span></p>
                        <p class="fk_p2">（机酒含税价<span>¥<em id="totalPrice"></em>
                        </span> - 组合套餐优惠<span>¥<em id="promotion"></em></span>）</p>
                    </div>
                </div>
            </div>
        </div>
        
        <p class="xieyi_ok"><label class="check"><input class="checkbox" type="checkbox" checked>我已同意以下条款</label></p>
        
        <!--协议书-->
        <div class="order_box">
            <div class="lv-agree">
                <h4>预订须知</h4>
                一、机酒套餐产品均为即时计价，请以我方最终确认价格为准。<br>
                二、不可抗力是指不能预见、不能避免并不能克服的客观情况。不可抗力、意外事件等不可归责于旅行社的客观原因包括但不限于，恶劣天气、自然灾害、战争、罢工、骚乱、飞机故障、航班保护、恐怖事件、政府行为、公共卫生事件等客观原因，造成旅游行程安排的交通服务延误、景区临时关闭、宾馆饭店临时被征用、出境管制、边境关闭、目的地入境政策临时变更、我国政府机构发布橙色及以上旅游预警信息等，均会导致旅游目的无法实现，旅行社不承担违约责任。<br>
                三、为了获得更为全面的保障，乙方强烈建议旅游者出游时根据个人意愿和需要自行投保人身意外伤害保险等个人险种。<br>
                四、为不耽误您的行程，请您至少在航班起飞前90分钟到达机场办理相关手续。<br>
                五、酒店价格为团队优惠房价，一经成交无法退订。若因游客方原因无法出行，需游客自行承担相应损失。<br>
                六、按照国际惯例，酒店须在14：00后方能办理入住，在12：00之前办理退房手续。<br>
                七、外籍人士预订提示<br>
                　　本产品网上报价适用持有大陆居民身份证的游客。如您持有其他国家或地区的护照，请在预订过程中注明。<br>
                八、未成年旅游者预订提示<br>
                　　1、未满18周岁的旅游者请由家属（因服务能力所限无法接待及限制接待的人除外）陪同参团。<br>
                　　2、因服务能力所限，无法接待18周岁以下旅游者单独报名出游，敬请谅解。<br>
                　　3、为不耽误您的行程，请您至少在航班起飞前90分钟到达机场办理相关手续。<br>
                　　4、酒店价格为团队优惠房价，一经成交无法退订。若因游客方原因无法出行，需游客自行承担相应损失。<br>
                　　5、按照国际惯例，酒店须在14：00后方能办理入住，在12：00之前办理退房手续。<br>
                九、退改说明<br>
                　　1.游客如不能出行，应至少提前7天通知取消，并承担实际损失费。<br>
                　　2.如需退改，请联系客服，客服电话10106060转1或4。<br>          
             </div>
             <span class="xieyi_gd" style="margin-top:-70px">查看更多<i class="icon_arrow"></i></span>
        </div>
        <div class="order_box" style="height:40px">
            <div class="lv-agree">
                <h4>委托服务协议书</h4>
             </div>
             <span class="xieyi_qw" style="margin-top:-70px">查看全文</span>
        </div>
    </div>
</div>


<!--合同查看全文，弹窗内容-->
<div class="ht_box" style="height:400px;overflow-y:auto;"><!-- <iframe src="团队境内旅游合同.html" height="400" width="720"> -->
<h2 style="align-content: center">《委托服务协议书使用说明》</h2>
1、本协议所涉及的相关产品订单，均由"驴妈妈旅游网"合作的供应商提供，"驴妈妈旅游网"仅作为网站服务运营商。<br>
2、驴妈妈旅游网"页面所显示的"费用说明"、"重要提示"作为本协议的有效法律条款，具有同等法律效力。<br>
3、委托方在"驴妈妈旅游网"在线订购产品或委托其客服工作人员电话订购的，就本协议所需填写部分可以通过在线填写 电子订单或口头委托填写等方式确认协议条款并依"驴妈妈旅游网"的预订流程体现至在线本协议文本中，对双方均有法律 上的强制约束力。 <br>
<h2 style="align-content: center">委托服务协议书 </h2>
编号: <br>
委托方（以下简称甲方）：<span class="buyer_name"></span>				 联系电话：<span class="buyer_phone"></span><br>
受托方（以下简称乙方）： 上海驴妈妈兴旅国际旅行社有限公司				 		 联系电话： 1010-6060 <br>

本协议系乙方代为甲方办理门票、往返机票、签证及酒店预订、机场接送等各类委托预订服务，且为了明确双方的权利义 务，本着平等协商的原则，就有关事项达成的如下协议：<br> 

第一条 承诺与保证 <br>
（一）乙方保证是具有国家旅游局认可的具有旅游资质的组团社。<br>
（二）乙方仅为甲方提供本协议约定的服务事项，其他甲方在境内或境外期间自行安排的内容（包括但不限于参加旅游项 目、购物、出行等）或尚未安排的内容全部由甲方自行承担费用、责任及风险，与乙方无关。 <br>
（三）甲方在"驴妈妈旅游网"订购完成后，因自身原因而未能实际实现所委托事项部分或全部时，将自行承担责任。<br>
（四）乙方明确告知甲方，无论在境内或境外的自行安排活动期间，请甲方在自己能够控制风险的范围内活动， 所产生的责任自负；甲方已明知并愿意自觉遵守。<br>
（五）甲方就本协议的委托事项已作详尽了解，并自愿接受本协议内容。 <br>
第二条 申请与交易 <br>
（一）甲方以书面方式（包括但不限于通过"驴妈妈旅游网"在线或电话预订等方式）向乙方表明委托事项(以"驴妈妈旅游 网"预订流程中的订单信息为准）；甲方提交的其它书面委托事项有同等法律效力。甲方在实际实现了乙方委托事项后 （完成订购），乙方按照本协议的受托及服务义务即刻履行完毕。 <br>
（二）乙方在签订本协议时，对甲方委托事项中涉及的目的地、日期、标准、项目、安全须知等已作如实详细说明和报价。<br>
（三）甲、乙双方对本协议委托事项及服务费用已达成共识。 <br>
（四）甲方自愿按委托事项交齐费用后，由乙方出具发票等文件。 <br>
第三条 双方权利和义务 <br>
（一）甲方在线或电话委托提交订单后，支付全款或预付款时签订本服务协议。甲方对要求乙方办理各类委托预订服务中 提供资料及填写的信息等真实性负责。 <br>
（二）本协议的委托事项以甲方以"驴妈妈旅游网"预订流程中的订单信息为准；双方确认：乙方不安排领队、导游服务 （甲方需要陪同服务人员除外）。 <br>
（三）甲方抵达目的地后将自行保管所有旅行证件；如甲方发生证件遗失，乙方将给予配合；但由此产生本协议以外的 费用（包括但不限于补办证件费、交通、延住、机票、陪同或其他服务费等）全部由甲方承担。 <br>
（四）乙方所代办的服务事项均为甲方直接指定，其代办行为即为甲方的真实意愿表示；甲方如对已代办服务项目有任何 其他书面要求，乙方协助甲方联系相关部门。甲方在第三方服务期间遭受人身、财产损失的，乙方可予以协助处理。<br>
（五）鉴于乙方仅向甲方提供委托服务，甲、乙双方本协议时，除约定由乙方提供的服务内容外，其余部分由甲方自行负 责。甲方在签订本协议时或后向乙方索取的其它信息介绍或资料仅作为甲方参考，乙方对参考信息及资料不提供服务，也 不承担责任。 <br>
（六）甲方已知晓：如遇航空公司机票税费、邮轮港务费、签证费等费用调整时，同意乙方按调整后的价格结算。 <br>
（七）乙方特别告知甲方： <br>
　　1、如甲方为老人、未成年人、孕妇或有心脏病、高血压、呼吸系统等疾病病史，建议征得医生意见，或经家属同意， 或由家属陪伴为妥。甲方在本协议委托事项以外所产生的费用，由甲方自行承担。 <br>　　
    2、甲方作为成年人，已明确知晓户外部分活动（包括但不限于潜水、游泳、高速摩托艇、攀岩、蹦极、滑雪、高原 旅行等）为高危娱乐，在充分考虑到自身条件后才自愿参加；并自愿承担因参加上述活动而发生任何事故可能造成的任何后果。 <br>　　
    3、凡持非中国大陆护照的游客或自备签证的旅游者，应自行办理本次旅行签证和再次回中国大陆的签证。如因签证 等问题造成出入境受阻，由甲方自行负责。 <br>　　
    4、甲方应遵守社会公共秩序和社会公德，尊重目的地国家（地区）的法律法规、风俗习惯、文化传统和宗教信仰， 爱护旅游资源，保护生态环境，遵守文明行为规范，不参与色情、赌博和涉毒等活动。若违反，后果自负。<br> 　　
    5、乙方提示甲方购买个人旅游意外保险，甲方已明确知晓。 <br>
（八）甲方同意，在乙方完成本协议的委托事项义务后，因不可抗力或天气、罢工、飞机、火车及轮船等一切非乙方原因 造成甲方行程时间变更的，乙方不承担违约或侵权责任。 <br>
（九）甲方知晓：签证服务是否给予签证或签注，是否准予出入境，是外国政府、使领馆及有关部门的权力，如因甲方的 自身原因或因提供材料存在问题及其他不可归责于乙方的原因而不能及时办理签证或签注而影响行程的，以及被有关部门 拒发签证或签注或不准出入境的，相关责任和乙方实际已发生的费用（机票、酒店定金等）由甲方承担；乙方不退还相应 服务费。 <br>
（十）乙方将根据甲方的本协议委托事项，对甲方递交的资料进行初步审核；甲方同意并配合乙方增补所需材料和提供必 要的保证金。 <br>
（十一）甲方与乙方办理本协议委托事项后，若因自身原因被拒签或拒绝出入境，或在乙方完成本协议委托服务示前甲方 自行取消旅游等导致本协议提前事项后甲方取消委托服务项目，或国家旅游局未发出建议中国公民暂缓前往该目的地的旅 游警解除时，由甲方支付乙方实际已发生费用（机票、酒店定金、签证费等），以及乙方服务费。<br>
（十二）甲方有义务按使领馆要求在规定时间、地点前往使领馆进行签证面试，并在回国后必须按使领馆要求履行销签义 务，在规定时间内去使领馆面试销签。因此发生的路费和误工费由甲方自理。 <br>
（十三）甲方同意：若因非乙方的原因，造成委托事项变更的，以乙方最终确认信息和实际收的所有票据、凭证为准。 <br>
（十四）委托过程中，第三方所提供的赠送活动及相关赠品，甲方若不接受，则视为自愿放弃，费用不予另退或抵扣。 <br>
（十五）如甲方选择了自由组合航班或单订船票，因网上数据更新有一定的延时，甲方所选定的航班、舱位和价格以乙 方操作人员回复为准。乙方将根据民航或邮轮公司订座系统实时信息与甲方确认。 <br>
（十六）甲方已知晓乙方提供的机票必须按顺序使用,否则航空公司有权取消后续行程的机位。 <br>
（十七）甲方已知晓乙方提供的特价机票或优惠价机票属于不可签转、更改、退票，不可累计里程的，甲方应当对此完 全了解，并愿意按照航空公司规定使用。 <br>
（十八）甲方确认，本人是在签订本协议前已仔细阅读并详细了解了全部条款内容，乙方人员亦向甲方对本协议内容进 行了详细说明后，本人才自愿签订本委托协议。签署本服务协议的甲方代表人，对自身的代理权真实性和合法性承担相 应法律责任，并承担负责将本协议内容转告未签名同行者的责任。 <br>
（十九）本合同一式两份，双方各持一份，《委托服务协议书使用说明》均有正文条款法律效力，此协议自双方签章且 乙方资源审核完毕同时甲方付清全部应付费用后生效。 <br><br><br>


　　甲方：<span class="buyer_name"></span>　　乙方：上海驴妈妈兴旅国际旅行社有限公司　<br>
　　日期：${flightInfos?first.departureDate }　日期：${flightInfos?first.departureDate } 


<!-- </iframe> --></div>


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
<!-- 正在加载弹层 START-->
<div class="fh-overlay"></div>
<div class="fh-dialog-loading">
    <div class="fh-dialog-inner clearfix">
        <div class="fh-dialog-body">
            <p>驴妈妈正在提交中..</p>
        </div>
    </div>
</div>
<!-- 正在加载弹层 END-->
<!--请求计算价格失败弹框 start  -->
<div class="returnAlert">
    <a href="javascript:;" class="ph_icon_closeAlert"></a>
    <div class="prompt">提示</div>
    <div class="sorryWarp">
        <div class="sorryImg"></div>
        <p id ='errorMsg'></p>
    </div>
    <div class="sorryBtn">
    	<input id="reloadUrl" type="hidden">
        <a href="javascript:;" class="fh-return-btn">重新查询</a>
    </div>
</div>
<div class="resortOver" style="display: none;"></div>

<#list selTickets as ticket>
<div class="fh-ticket-detail" id="TDTL${ticket.suppGoodsId}">
    <dl class="clearfix">
        <dt>费用说明</dt>
        <dd>
            ${ticket.ticketDtl.priceIncludes}
        </dd>
    </dl>
    <dl class="clearfix">
        <dt>预定时间</dt>
        <dd>
            游玩当天${ticket.ticketDtl.aheadBookTime}前可下单，请尽早预订，以免耽误您的行程。
        </dd>
    </dl>
    <dl class="clearfix">
        <dt>入园须知</dt>
        <dd>
            取票时间：${ticket.ticketDtl.changeTime}<br>
            取票地点：${ticket.ticketDtl.changeAddress}<br>
            入园方式：${ticket.ticketDtl.enterStyle}<br>
            <#if ticket.ticketDtl.limitFlag?exists && ticket.ticketDtl.limitFlag == "0">
                入园限制：请在入园当天的<#if ticket.ticketDtl.limitTime?exists>${ticket.ticketDtl.limitTime?split(":")[0]}</#if>点<#if ticket.ticketDtl.limitTime?exists>${ticket.ticketDtl.limitTime?split(":")[1]}</#if>分以前入园<br>
            <#else>
                入园限制：无限制<br>
            </#if>
            
            <#if ticket.ticketDtl.aperiodicFlag?exists && ticket.ticketDtl.aperiodicFlag == "Y">
            有效期限：（有效期内，仅限入园1次）有效期从${ticket.ticketDtl.startTimeStr?if_exists}到${ticket.ticketDtl.endTimeStr?if_exists}有效。
            <#else>
                <#if ticket.ticketDtl.days?exists && ticket.ticketDtl.days == 1>
                有效期限：（有效期内，仅限入园1次）指定游玩日当天内有效。
                <#else>
                有效期限：（有效期内，仅限入园1次）指定游玩日${ticket.ticketDtl.days?if_exists}天内有效。
                </#if>
            </#if>
            <br>
            详情信息请见：<a href="" target="_blank"></a>
        </dd>
    </dl>
    <dl class="clearfix">
        <dt>重要提示</dt>
        <dd>
        <#if ticket.ticketDtl.height?exists && ticket.ticketDtl.height ? length gt 0>
        身高：${ticket.ticketDtl.height}<br>
        </#if>
        <#if ticket.ticketDtl.age?exists && ticket.ticketDtl.age ? length gt 0>
        年龄：${ticket.ticketDtl.age}<br>
        </#if>
        <#if ticket.ticketDtl.region?exists && ticket.ticketDtl.region ? length gt 0>
        地域：${ticket.ticketDtl.region}<br>
        </#if>
        <#if ticket.ticketDtl.maxQuantity?exists && ticket.ticketDtl.maxQuantity ? length gt 0>
        最大限购：${ticket.ticketDtl.maxQuantity}<br>
        </#if>
        <#if ticket.ticketDtl.express?exists && ticket.ticketDtl.express ? length gt 0>
        快递：${ticket.ticketDtl.express}<br>
        </#if>
        <#if ticket.ticketDtl.entityTicket?exists && ticket.ticketDtl.entityTicket ? length gt 0>
        实体票：${ticket.ticketDtl.entityTicket}<br>
        </#if>
        <#if ticket.ticketDtl.others?exists && ticket.ticketDtl.others ? length gt 0>
        其他：${ticket.ticketDtl.others?if_exists}
        </#if>
        </dd>
    </dl>
    <span class="shouqi">收起<i class="arrow"></i></span>
    <div class="ftd-arrow"><span>◆</span><i>◆</i></div>
</div>
</#list>

<#list selInsurances as insuranceInfo>
<!-- 门票保险规则 -->
   <div class="fh-ticket-detail" id="TDTL${insuranceInfo.suppGoodsId}">
       <dl class="clearfix">
           <dt>描述</dt>
           <dd>
              ${insuranceInfo.insuranceDetail}
           </dd>
       </dl>
       <span class="shouqi">收起<i class="arrow"></i></span>
       <div class="ftd-arrow"><span>◆</span><i>◆</i></div>
   </div>
</#list>

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
    
<!--请求计算价格失败弹框 end  -->
<#if isBackBooking=='true'>
       <#else>
	       <#include "online_foot.ftl">
     </#if>
<script src="http://s3.lvjs.com.cn/min/index.php?f=js/new_v/jquery-1.7.2.min.js,/js/ui/lvmamaUI/lvmamaUI.js,/js/new_v/top/header-air_new.js,/js/v5/modules/pandora-poptip.js,/js/v4/modules/pandora-calendar.js,/js/v4/modules/pandora-dialog.js,/js/common/poplogin.js"></script>
<!--<script src="http://pic.lvmama.com/js/v6/order.js"></script>-->
<script src="${request.contextPath}/js/common/common.js"></script>
<script src="${request.contextPath}/js/common/login.js"></script>
<script src="${request.contextPath}/js/order/fh-order.js"></script>
<script src="${request.contextPath}/js/order/new-order.js"></script>
<script type="text/javascript">
//$(".fh-overlay, .fh-dialog-loading").show();
var basePath = "${request.contextPath}";
var shopingUUID = "${shopingUUID}";
var returnAlertFunction = function(){
	var uuid = "${shopingUUID}";
    var errorMsgOutTime = "${errorMsgOutTime}";
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
  	var reloadUrl = "/search?shoppingUUID="+uuid+"&tripType="+tripType+"&departureCityCode="+departureCityCode+"&arrivalCityCode="+arrivalCityCode+"&departureTime="+flightStartDate+"&returnTime="+flightEndDate+"&cityCode="+cityCode+"&checkInTime="+hotelStartDate+"&checkOutTime="+hotelEndDate+"&adultsCount="+adultsCount+"&childCount="+childCount;
  	$('#reloadUrl').val(reloadUrl);
    if(errorMsgOutTime!=''){
    	$(".returnAlert").show();
		$('.resortOverlay').stop(true,true).show();
		$("#errorMsg").html(errorMsgOutTime);
    }
}
$(function(){
	cleanBrowserData();
	//缓存超时弹框
	returnAlertFunction();
    //价格实例化
    initPrice("${request.contextPath}",'${shopingUUID}');
    // 订单信息恢复
    //recoveryInfoRecord();
    //初始化登录
    initUserName();
    //获取常用联系人
    initPassengers();
    //证件控件初始化
    initId_Card();
    initPassport();
    
});

$('.ph_icon_closeAlert').click(function(){
	$('.returnAlert').stop(true,true).fadeOut();
    $('.resortOver').stop(true,true).fadeOut();
    $('body').removeAttr('style');
    var url ="";
	if('${errorMsgOutTime}'){
		url = $('#reloadUrl').val();
	}else{
		url="${request.contextPath}/search/backToShopping?shoppingUUID="+shopingUUID+"&type=orderfilled";
	}
	window.location.href=url;
})

//登录
function toLogin(){
	//登录之后只做查当前用户、常用联系人操作
    showLogin(loginCallback);
}

//登录后回调
function loginCallback(){
		initUserName();
		initPassengers();
		$("#toLogin").remove();
		$("#picCodeContainer").remove(); 
		$("#login_user").attr("status","1");
		$('.dialog-close').click(); //如果没有关闭登陆弹窗，就写这个click
		$("[zType='ifUnLogin']").remove();
}

function initGoumai(obj){
     $('.js_goumai_name').val($(obj).val());
}


$(document).bind("click", function($element) {
         
        if($element.target.className=='fillInBtn'){
            $("#fillingExplanation_"+$element.target.id).html($("#fillingExplanationHtml").html());
            $("#fillingExplanation_"+$element.target.id).toggle();
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
                	nameList = '<a href="javascript:;" class="fit-more-contact">更多<i class="icon_arrow"></i></a><b>常用联系人：</b>'
            }
            for(var i=0; i<data.length; i++) {
            	var checkFlag ;
            	if(lastReceiverIds!=""&&lastReceiverIds.indexOf(data[i].receiverId)>-1){
            		checkFlag ='<label class="check"><input class="checkbox" type="checkbox" value="'+data[i].receiverId+'" id="passenger_' + data[i].certNo + '" onclick="checkUser(this)" checked="checked">' + data[i].receiverName
            	}else{
            		checkFlag ='<label class="check"><input class="checkbox" type="checkbox" value="'+data[i].receiverId+'" id="passenger_' + data[i].certNo + '" onclick="checkUser(this)">' + data[i].receiverName
            	}
                nameList = nameList + checkFlag
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
            $(".js_checkName").show();            
        }
    });
    
}

//清除浏览器回退数据
function cleanBrowserData(){
	var $yanzheng = $('.js_yz');
	for(var i=0;i<$yanzheng.length;i++){
		var This = $yanzheng.eq(i);
		This.val("");
	}
}

</script>



</body>
</html>
