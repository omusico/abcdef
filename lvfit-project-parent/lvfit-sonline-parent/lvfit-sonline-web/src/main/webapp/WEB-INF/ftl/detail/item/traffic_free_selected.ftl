<div class="adjust-item">
    <div class="clearfix">
        <div class="title">
            <span>交通</span>
        </div>

        <#list depFlightInfos as depFlightInfo>
        <div data-flightno="${depFlightInfo.flightNo}" class="right-container clearfix depFlightBox" <#if depFlightInfo_index != 0> style="display:none"</#if> >
            <!--新增线路默认机票---开始-->
            <div class="type gray">
                <div class="clearfix">
                    <p class="shadow">单程</p>
                </div>

                <dl class="ldt_tcil_content clearfix">
                    <dt>
                        <em>出发：</em>
                    </dt>
                    <dd>
                        <p>
                            ${depFlightInfo.departureCityName}
                        </p>
                        <p>
                            ${depFlightInfo.departureDate}
                        </p>
                    </dd>
                </dl>
            </div>

            <div class="detail">
                <ul class="ldt_tci_center">
                    <!--不含中转 开始-->
                    <li class="ldt_tcic_info ldt_tcic_info_first clearfix">

                        <div class="ldt_tcici_icon">
                            <i>去</i>
                        </div>

                        <div class="ldt_tcici_clock">
                            <b>
                                ${depFlightInfo.departureTime?substring(11, 16)}
                            </b>
                            <b>
                                ${depFlightInfo.arrivalTime?substring(11, 16)}
                                <#if depFlightInfo.highLightFlag?string == "true">
                                <small style="color:red" class="js_tips" tip-content='航班到达日期为起飞日期<span class="c_f00">+1天</span>。'>+1</small>
                                </#if>
                            </b>
                        </div>
                        <div class="ldt_tcici_fromto">
                            <p>${depFlightInfo.departureAirportName}
                                <span class="qidi_zhuan"></span>
                            </p>
                            <p>
                                ${depFlightInfo.arrivalAirportName}
                            </p>
                        </div>
                        <div class="ldt_tcici_time">
                            ${depFlightInfo.flyTime}
                        </div>
                        <div class="ldt_tcici_company">
                            ${depFlightInfo.carrierName}<br>
                            ${depFlightInfo.flightNo}
                        </div>
                        <div class="ldt_tcici_type" data-seatclasscode="${depFlightInfo.seats[0].seatClassCode}">
                            ${depFlightInfo.seats[0].seatClassTypeName}
                        </div>

                    </li>
                </ul>

                <!--航班表格---结束-->
                <!--新增线路默认机票---结束-->
            </div>
            <!--对接更换交通开始-->
            <div class="replace">
                <button class="replace-button flight-replace-button">更换其他交通</button>
            </div>
            <!--对接更换交通结束-->
        </div>
        </#list>
    </div>

    <#list arvFlightInfos as arvFlightInfo>
    <div data-flightno="${arvFlightInfo.flightNo}" class="clearfix arvFlightBox" <#if arvFlightInfo_index != 0> style="display:none"</#if>>
        <div class="right-container clearfix">
            <!--新增线路默认机票---开始-->
            <div class="type gray">
                <div class="clearfix">
                    <p class="shadow">单程</p>
                </div>

                <dl class="ldt_tcil_content clearfix">
                    <dt>
                        <em>出发：</em>
                    </dt>
                    <dd>
                        <p>
                            ${arvFlightInfo.departureCityName}
                        </p>
                        <p>
                            ${arvFlightInfo.departureDate}
                        </p>
                    </dd>
                </dl>
            </div>

            <div class="detail">
                <ul class="ldt_tci_center">
                    <!--不含中转 开始-->
                    <li class="ldt_tcic_info ldt_tcic_info_first clearfix">

                        <div class="ldt_tcici_icon">
                            <b>返</b>
                        </div>

                        <div class="ldt_tcici_clock">
                            <b>
                                ${arvFlightInfo.departureTime?substring(11, 16)}
                            </b>
                            <b>
                                ${arvFlightInfo.arrivalTime?substring(11, 16)}
                                <#if arvFlightInfo.highLightFlag?string == "true">
                                <small style="color:red" class="js_tips" tip-content='航班到达日期为起飞日期<span class="c_f00">+1天</span>。'>+1</small>
                                </#if>
                            </b>
                        </div>
                        <div class="ldt_tcici_fromto">
                            <p>${arvFlightInfo.departureAirportName}
                                <span class="qidi_zhuan"></span>
                            </p>
                            <p>
                                ${arvFlightInfo.arrivalAirportName}
                            </p>
                        </div>
                        <div class="ldt_tcici_time">
                            ${arvFlightInfo.flyTime}
                        </div>
                        <div class="ldt_tcici_company">
                            ${arvFlightInfo.carrierName}<br>
                            ${arvFlightInfo.flightNo}
                        </div>
                        <div class="ldt_tcici_type" data-seatclasscode="${arvFlightInfo.seats[0].seatClassCode}">
                            ${arvFlightInfo.seats[0].seatClassTypeName}
                        </div>

                    </li>
                </ul>

                <!--航班表格---结束-->
                <!--新增线路默认机票---结束-->
            </div>
            <!--对接更换交通开始-->
        </div>
    </div>
    </#list>
</div>