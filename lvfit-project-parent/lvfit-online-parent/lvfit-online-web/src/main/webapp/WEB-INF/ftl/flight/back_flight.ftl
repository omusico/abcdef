<#if backFlight !=null || backFlight !=''>
<div class="flight-item flight-item-back">
    <div class="flight-detail clearfix">
        <div class="flight-col flight-name">
            <i class="fh-icon fh-icon-dest"></i>
            <div class="flight-center">${backFlight.departureDate}</div>
        </div>
        <div class="flight-col flight-info">
            <div class="flight-top"><i class="fh-icon-ac fh-icon-ac-${backFlight.carrierCode}"></i>${backFlight.carrierName}</div>
            <!-- TODO 机型信息填在对应的data属性中 -->
            <div class="flight-bottom"><span class="flight-number">${backFlight.flightNo}</span><span class="plane-type" data-plan=${backFlight.airplane.code} data-name=${backFlight.airplane.name} data-type="${backFlight.airplane.airplaneType}" data-min=${backFlight.airplane.minSeats} data-max=${backFlight.airplane.maxSeats}>${backFlight.airplane.code}</span></div>
        </div>
        <div class="flight-col flight-time flight-depa-time">
            <div class="flight-top">${backFlight.departureTime?substring(10, 16)}</div>
            <div class="flight-bottom"><a class="airport-name" href="javascript:;" title="${backFlight.departureAirportName}">${backFlight.departureAirportName}</a><span>${backFlight.departureTermainalBuilding}</span></div>
        </div>
        <div class="flight-col flight-stop">
            <!-- TODO 没有经停时，删除“经停”两字，切勿删除P标签 -->
            <p class="flight-stop-text"></p>
            <div class="fh-icon-stop"></div>
        </div>
        <div class="flight-col flight-time flight-arrival-time">
            <div class="flight-top"><span class="time">${backFlight.arrivalTime?substring(10, 16)}</span>
            <#if backFlight.highLightFlag == true>
                <span class="flight-add-one-day" tip-content="航班到达日期为起飞日期<span class='tip-add-one'>+1天</span>。">+1</span>
            </#if>
            </div>
            <div class="flight-bottom"><a class="airport-name" href="javascript:;" title="${backFlight.arrivalAirportName}">${backFlight.arrivalAirportName}</a>${backFlight.arrivalTerminalBuilding}</div>
        </div>
        <div class="flight-col flight-duration">
            <div class="flight-center">${backFlight.flyTime?replace("小时", "h")?replace("分钟","m")}</div>
        </div>
        <div class="flight-col flight-type">
            <div class="flight-center">
            <#list backFlight.seats as seats>
                <#if seats_index == 0>
                    <div class="select-class">
                        <!--<span flightNo="${backFlight.flightNo}"code="${seats.seatClassCode}" policyid="${seats.pricePolicyId}">${seats.seatClassTypeName}</span>-->
                        <em flightNo="${backFlight.flightNo}"code="${seats.seatClassCode}" policyid="${seats.pricePolicyId}" flightType="back"><span>${seats.seatClassTypeName}</span></em>
                        <!--<span>${seats.seatClassTypeName}</span>-->
                        <i></i>
                    </div>
                    <#if seats.inventoryCount lte 9>
                        <span class="flight-ticket-amount">剩余${seats.inventoryCount}</span>
                    <#else>
                        <span class="flight-ticket-amount" style="display:none;"></span>
                    </#if>
                </#if>
            </#list>
                <ol class="select-class-list">
                <#list backFlight.seats as seats>
                    <li <#if seats_index == 0>class="active"</#if> data-flightno="${backFlight.flightNo}" data-code="${seats.seatClassCode}" data-type="RETURN" childPrice="${seats.childrenPrice}" adaultPrice="${seats.flightTicketPriceDto.salesPrice}">
                        <#if seats.differentPrice lt 0>
                            <span class="scl-diff-minus">-<i class="price-rmb">¥</i>${seats.differentPrice*(-1)}</span>
                        <#else>
                            <span class="scl-diff">+<i class="price-rmb">¥</i>${seats.differentPrice}</span>
                        </#if>

                        <span class="scl-class" code="${seats.seatClassCode}" policyid="${seats.pricePolicyId}">${seats.seatClassTypeName}</span>
                        <#if seats.inventoryCount lte 9>
                            <span class="flight-ticket-amount">剩余${seats.inventoryCount}</span>
                        </#if>
                    </li>
                </#list>
                </ol>
            </div>
        </div>
        <a href="javascript:;" data-type="RETURN" class="btn btn-sm btn-pink fh-change-btn">更换航班</a>
    </div>
<#if backFlight.highLightFlag == true>
    <p class="flight-warning">
        <i class="fh-icon fh-icon-warning"></i>该航班为隔夜航班，请留意您的酒店入住日期
    </p>
</#if>
</div>
</#if>
