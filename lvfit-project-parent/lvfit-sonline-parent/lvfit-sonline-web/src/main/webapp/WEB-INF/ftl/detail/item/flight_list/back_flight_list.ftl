
    <div class="fh_no_result" style="display:none">
        <i></i>
        <p class="info">很抱歉，没有找到符合筛选条件的航班</p>
        <p class="suggestion">您可以：<a class="nr-close-all" href="javascript:;">清空筛选条件</a></p>
    </div>
    <#list arvFlightInfos as arvFlightInfo>
    <div class="traffic_list <#if saleType!='DomesticProduct'><#if arvFlightInfo_index==0>active</#if></#if>" data-filterkey="${arvFlightInfo.filterKey}" data-flightno="${arvFlightInfo.flightNo}">
        <!-- 去程航班 -->
        <ul class="info_ul">
            <li class="info_li1"></li>
            <li class="info_li2">
                <i class="fh-icon-ac fh-icon-ac-${arvFlightInfo.carrierCode}"></i>
                ${arvFlightInfo.carrierName}
                <p class="fh_info_p">
                    ${arvFlightInfo.flightNo}
                    <span class="fh_type" data-code="${arvFlightInfo.airplane.code}" data-name="${arvFlightInfo.airplane.name}"
                        data-type="${arvFlightInfo.airplane.airplaneType}" data-min="${arvFlightInfo.airplane.minSeats}"
                        data-max="${arvFlightInfo.airplane.maxSeats}">${arvFlightInfo.airplane.code}
                    </span>
                </p>
            </li>
            <li class="info_li3">
                <p class="fh_time">${arvFlightInfo.departureTime?substring(11, 16)}</p>
                <p class="fh_ap_name"><em>${arvFlightInfo.departureAirportName}</em><span>${arvFlightInfo.departureTermainalBuilding}</span></p>
            </li>
            <li class="info_li4">
                <p class="jingting">
                <#if arvFlightInfo.stopCount gt 0>
                经停
                </#if>
                <i></i><i class="fr"></i>
                </p>
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
            <li class="info_li7">
                <div class="fh_cangwei_box fh_cx_box">
                    <p class="fh_cangwei" data-seatclasscode="${arvFlightInfo.seats[0].seatClassCode}">${arvFlightInfo.seats[0].seatClassTypeName}
                    <#if arvFlightInfo.seats[0].inventoryCount lte 9>
                    <small>剩余${arvFlightInfo.seats[0].inventoryCount}</small></p>
                    </#if>
                </div>
                <!--<a class="btn_cx">更多舱型<i class="icon_arrow"></i></a>-->
            </li>
            <li class="info_li8 fh_chajia">
                <div class="fh_chajia_box fh_cx_box">
                    <p class="fh_chajia_list">
                        <#if arvFlightInfo.seats[0].differentPrice gte 0>
                            <span class="fh_price">${"+ <dfn>¥</dfn>" + arvFlightInfo.seats[0].differentPrice}</span>
                        <#else>
                            <span class="fh_price">${"- <dfn>¥</dfn>" + -arvFlightInfo.seats[0].differentPrice}</span>
                        </#if>
                    </p>
                </div>
            </li>
            <li class="info_li9 fh_btn">
                <div class="fh_xuan_box fh_cx_box">
                    <p class="fh_xuan_list">
                        <span class="btn btn-small btn-orange arv_fh_select" <#if arvFlightInfo_index==0>style="display:none"</#if> data-flightno="${arvFlightInfo.flightNo}" >选择</span>
                        <span class="btn btn-small btn-dis arv_fh_select" <#if arvFlightInfo_index==0>style="display:inline-block"</#if> data-flightno="${arvFlightInfo.flightNo}" >已选</span>
                    </p>
                </div>
            </li>
        </ul>

        <div class=""></div>
        <!-- 已选打钩icon -->
        <span class="fh_btn_gou"></span>
    </div>
    </#list>
