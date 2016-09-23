<div id="recommend_fli_box">
<div class="traffic_list_t">
	<ul class="traffic_info_list">
		<li class="info_li1"></li>
		<li class="info_li2">航班信息</li>
		<li class="info_li3 sort_btn ">当地起飞时间<i></i></li>
		<li class="info_li4"></li>
		<li class="info_li5">当地降落时间</li>
		<li class="info_li6">飞行时长</li>
		<li class="info_li7">舱位</li>
		<li class="info_li8 sort_btn sort_active">差价<i></i></li>
		<li class="info_li9"></li>
	</ul>
</div>
<!-- 航班列表  开始 -->
<div class="traffic_list_b" id='charset_flight_list'>
	<div class="fh_no_result">
		<i></i>
		<p class="info">很抱歉，没有找到符合筛选条件的航班</p>
		<p class="suggestion">您可以：<a class="nr-close-all" href="javascript:;">清空筛选条件</a></p>
	</div>
	<#list charterFlightInfos as arvFlightInfo> 
		<div class="traffic_list" data-flightno="${arvFlightInfo.flightNo}"  data-backflightno="${arvFlightInfo.returnFlightInfoDto[0].flightNo}">
			<!-- 去程航班 -->
			<ul class="info_ul">
				<li class="info_li1"><i class="line_icon_qu">去</i></li>
				<li class="info_li2">
					<i class="fh-icon-ac fh-icon-ac-${arvFlightInfo.carrierCode}"></i>
					 ${arvFlightInfo.carrierName}
					<p class="fh_info_p"> ${arvFlightInfo.flightNo}<span class="fh_type" data-code="${arvFlightInfo.airplane.code}" data-name="${arvFlightInfo.airplane.name}"
                        data-type="${arvFlightInfo.airplane.airplaneType}" data-min="${arvFlightInfo.airplane.minSeats}"
                        data-max="${arvFlightInfo.airplane.maxSeats}">${arvFlightInfo.airplane.code}</span></p>
				</li>
				<li class="info_li3">
					<p class="fh_time">${arvFlightInfo.departureTime?substring(11, 16)}</p>
					<p class="fh_ap_name"><em>${arvFlightInfo.departureAirportName}</em><span>${arvFlightInfo.departureTerminalBuilding}</span></p>
				</li>
				<li class="info_li4">
					<p class="jingting">经停<i></i><i class="fr"></i></p>
				</li>
				<li class="info_li5">
					<p class="fh_time">${arvFlightInfo.arrivalTime?substring(11, 16)}
					 <#if arvFlightInfo.highLightFlag?string == "true">
					 <small class="js_tips" tip-content='航班到达日期为起飞日期<span class="c_f00">+1天</span>。'>+1</small>
					  </#if>
					 </p>
					<p class="fh_ap_name"><em>${arvFlightInfo.arrivalAirportName}</em><span>${arvFlightInfo.arrivalTerminalBuilding}</span></p>
				</li>
				<li class="info_li6"><p class="fh_time_l">${arvFlightInfo.flyTime}</p></li>   
				<li class="info_li7"><p class="fh_cangwei">${arvFlightInfo.seats[0].seatClassTypeName}
				<#if arvFlightInfo.seats[0].inventoryCount lte 9>
                    <small>剩余${arvFlightInfo.seats[0].inventoryCount}</small></p>
                    </#if>
                </p></li>
			</ul>
			<!--  返程航班 -->
			<ul class="info_ul">
				<li class="info_li1"><i class="line_icon_fan">返</i></li>
				<li class="info_li2">
					<i class="fh-icon-ac fh-icon-ac- ${arvFlightInfo.returnFlightInfoDto[0].carrierCode}"></i>
					 ${arvFlightInfo.returnFlightInfoDto[0].carrierName}
					<p class="fh_info_p"> ${arvFlightInfo.returnFlightInfoDto[0].flightNo}<span class="fh_type" data-code="${arvFlightInfo.returnFlightInfoDto[0].airplane.code}" data-name="${arvFlightInfo.returnFlightInfoDto[0].airplane.name}"
                        data-type="${arvFlightInfo.returnFlightInfoDto[0].airplane.airplaneType}" data-min="${arvFlightInfo.returnFlightInfoDto[0].airplane.minSeats}"
                        data-max="${arvFlightInfo.returnFlightInfoDto[0].airplane.maxSeats}">${arvFlightInfo.returnFlightInfoDto[0].airplane.code}</span></p>
				</li>
				<li class="info_li3">
					<p class="fh_time">${arvFlightInfo.returnFlightInfoDto[0].departureTime?substring(11, 16)}</p>
					<p class="fh_ap_name"><em>${arvFlightInfo.returnFlightInfoDto[0].departureAirportName}</em><span>${arvFlightInfo.returnFlightInfoDto[0].departureTerminalBuilding}</span></p> 
				</li>
				<li class="info_li4">
					<p class="jingting">经停<i></i><i class="fr"></i></p>
				</li>
				<li class="info_li5">
					<p class="fh_time">${arvFlightInfo.returnFlightInfoDto[0].arrivalTime?substring(11, 16)}
					 <#if arvFlightInfo.returnFlightInfoDto[0].highLightFlag?string == "true">
					 <small class="js_tips" tip-content='航班到达日期为起飞日期<span class="c_f00">+1天</span>。'>+1</small>
					  </#if>
					 </p>
					<p class="fh_ap_name"><em>${arvFlightInfo.returnFlightInfoDto[0].arrivalAirportName}</em><span>${arvFlightInfo.returnFlightInfoDto[0].arrivalTerminalBuilding}</span></p>
				</li>
				<li class="info_li6"><p class="fh_time_l">${arvFlightInfo.returnFlightInfoDto[0].flyTime}</p></li>
				<li class="info_li7"><p class="fh_cangwei">${arvFlightInfo.returnFlightInfoDto[0].seats[0].seatClassTypeName}
				<#if arvFlightInfo.returnFlightInfoDto[0].seats[0].inventoryCount lte 9>
                    <small>剩余${arvFlightInfo.returnFlightInfoDto[0].seats[0].inventoryCount}</small></p>
                    </#if>
                </p></li>
			</ul>
			<!-- 差价 -->
			<div class="info_li8 fh_chajia">+<span class="fh_price"><dfn>¥</dfn>${arvFlightInfo.seats[0].differentPrice}</span></div>
			<!-- 选择按钮 -->
			<div class="info_li9 fh_btn">
				<span class="btn btn-small btn-orange js_fh_select" go-flightno="${arvFlightInfo.flightNo}" back-flightno="${arvFlightInfo.returnFlightInfoDto[0].flightNo}">选择</span>
				<span class="btn btn-small btn-dis">已选</span>
			</div>
			<!-- 已选打钩icon -->
			<span class="fh_btn_gou"></span>
		</div>  
	</#list> 
</div><!-- 航班列表  结束 -->
</div>