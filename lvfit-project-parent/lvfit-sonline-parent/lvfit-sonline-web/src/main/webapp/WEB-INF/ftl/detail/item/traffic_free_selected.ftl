<#assign baoji=sumDepFlightInfos[0].saleType />
<div class="adjust-item" >
    <div class="clearfix">
        <div class="title">
            <span>交通</span>
        </div>
	        <#list charterFlightInfos as arvFlightInfo>  
			    <div class="right-container clearfix spp" go-flightno="${arvFlightInfo.flightNo}" back-flightno="${arvFlightInfo.returnFlightInfoDto[0].flightNo}"
			        <#if baoji!='DomesticProduct'> style="display:none" <#else> <#if arvFlightInfo_index != 0> style="display:none"</#if></#if>    tag='charsetflight'>
			        <div class="type gray">
								 <div class="clearfix">
										<p id="toback" class="shadow">往返</p>
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
			                    <dl class="ldt_tcil_content clearfix">
			                        <dt><em>返回：</em></dt>
			                        <dd>
			                            <p>
			                                ${arvFlightInfo.returnFlightInfoDto[0].departureCityName}
			                            </p>
			
			                            <p>
			                                ${arvFlightInfo.returnFlightInfoDto[0].departureDate}
			                            </p>
			                        </dd>
			                    </dl>
			                    <!-- TODO add end -->
			                </div>
			        <div class="detail">
			                 <ul class="ldt_tci_center">
			                            <!--不含中转 开始--> 
			                                <li class="ldt_tcic_info ldt_tcic_info_first clearfix">
			
			                                <div class="ldt_tcici_icon">
			                                    <span class="ldt_tcici_icon_go">去</span>
			                                </div>
			                                <div class="ldt_tcici_clock">
			                                    <b>${arvFlightInfo.departureTime?substring(11, 16)}</b>
			                                    <b>${arvFlightInfo.arrivalTime?substring(11, 16)}</b>
			                                </div>
			                                <div class="ldt_tcici_fromto">
			                                    <p>${arvFlightInfo.departureAirportName}
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
			                                <div class="ldt_tcici_type"> 
			                                      ${arvFlightInfo.seats[0].seatClassTypeName}  
			                                </div>
			                                     </li></ul>
			                       <ul class="ldt_tci_center">
			                                <li class="ldt_tcic_info ldt_tcic_info_first clearfix">
			                                <div class="ldt_tcici_icon">
			                                <span class="ldt_tcici_icon_go">返</span>
			                                </div>
			                                <div class="ldt_tcici_clock">
			                                    <b>${arvFlightInfo.returnFlightInfoDto[0].departureTime?substring(11, 16)}</b>
			                                    <b>${arvFlightInfo.returnFlightInfoDto[0].arrivalTime?substring(11, 16)}</b>
			                                </div>
			                                <div class="ldt_tcici_fromto">
			                                    <p>${arvFlightInfo.returnFlightInfoDto[0].departureAirportName}
			                                    </p>
			                                    <p>${arvFlightInfo.returnFlightInfoDto[0].arrivalAirportName}</p>
			                                </div>
			                                <div class="ldt_tcici_time">
			                                        ${arvFlightInfo.returnFlightInfoDto[0].flyTime}
			                                </div>
			                                <div class="ldt_tcici_company">
			                                    ${arvFlightInfo.returnFlightInfoDto[0].carrierName}<br>
			                                    ${arvFlightInfo.returnFlightInfoDto[0].flightNo}
			                                </div>
			                                <div class="ldt_tcici_type">   
			                                        ${arvFlightInfo.returnFlightInfoDto[0].seats[0].seatClassTypeName}  
			                                </div>
			                            </li>
			                      </ul>
			                          
			                        <!-- TODO add end -->
			                        <div class="default">
			                            <div class="adjust-traffic-item adjust-product-item" data-price="58" data-item-id="1">
			                                <div class="adjust-traffic-item-type">
			                                    <span></span>
			                                </div>
			                                <div class="adjust-traffic-item-price">
			                        <span class="price">
			                        </span>
			                         </div>
			                                <div class="adjust-traffic-item-price">
			                        <span class="price">
			                            <select class="lvmama-price-flag" data-price-1="105000" hidden="hidden">
			                                <option value="1">1</option>
			                            </select>
			                        </span>
			                                </div> 
			                                <div class="clearfix"></div>
			                            </div>
			                        </div>
			                    </div>
			                    <div class="replace">
			                        <button class="replace-button flight-replace-button">更换其他交通</button>
			                    </div> 
			    </div>
	    	</#list>
		
        <#list depFlightInfos as depFlightInfo>
        <div data-flightno="${depFlightInfo.flightNo}" class="right-container clearfix depFlightBox"  <#if baoji=='DomesticProduct'> style="display:none" <#else> <#if depFlightInfo_index != 0> style="display:none"</#if> </#if> >
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
    <div data-flightno="${arvFlightInfo.flightNo}" class="clearfix arvFlightBox"  <#if baoji=='DomesticProduct'> style="display:none" <#else> <#if arvFlightInfo_index != 0> style="display:none" </#if>  </#if>      >
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