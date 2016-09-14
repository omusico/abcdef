<div class="flight-item">
    <div class="flight-detail clearfix">
        <div class="flight-col flight-name">
            <i class="fh-icon fh-icon-depa"></i>
            <div class="flight-center">${toFlight.departureDate}</div>
        </div>
        <div class="flight-col flight-info">
            <div class="flight-top"><i class="fh-icon-ac fh-icon-ac-${toFlight.carrierCode}"></i>${toFlight.carrierName}</div>
            <!-- TODO 机型信息填在对应的data属性中 -->
            <div class="flight-bottom"><span class="flight-number">${toFlight.flightNo}</span><span class="plane-type" data-plan=${toFlight.airplane.code} data-name=${toFlight.airplane.name} data-type="${toFlight.airplane.airplaneType}" data-min=${toFlight.airplane.minSeats} data-max=${toFlight.airplane.maxSeats}>${toFlight.airplane.code}</span></div>
        </div>
        <div class="flight-col flight-time flight-depa-time">
            <div class="flight-top">${toFlight.departureTime?substring(10, 16)}</div>
            <div class="flight-bottom"><a class="airport-name" href="javascript:;" title="${toFlight.departureAirportName}">${toFlight.departureAirportName}</a><span>${toFlight.departureTermainalBuilding}</span></div>
        </div>
        <div class="flight-col flight-stop">
            <!-- TODO 没有经停时，删除“经停”两字，切勿删除P标签 -->
            <p class="flight-stop-text">
            <#if toFlight.stopCount gt 0>
                经停
            </#if>
            </p>
            <div class="fh-icon-stop"></div>
        </div>
        <div class="flight-col flight-time flight-arrival-time">
            <div class="flight-top">
                <span class="time">${toFlight.arrivalTime?substring(10, 16)}</span>

            <#if toFlight.highLightFlag == true>
                <span class="flight-add-one-day" tip-content="航班到达日期为起飞日期<span class='tip-add-one'>+1天</span>。">+1</span>
            </#if>
            </div>
            <div class="flight-bottom">
                <a class="airport-name" href="javascript:;" title="${toFlight.arrivalAirportName}">${toFlight.arrivalAirportName}</a><span>${toFlight.arrivalTerminalBuilding}</span>
            </div>
        </div>
        <div class="flight-col flight-duration">
            <div class="flight-center">${toFlight.flyTime?replace("小时", "h")?replace("分钟","m")}</div>
        </div>
        <div class="flight-col flight-type">
            <div class="flight-center">
            <#list toFlight.seats as seats>
                <#if seats_index == 0>
                    <div class="select-class">
                        <em flightno="${toFlight.flightNo}" code="${seats.seatClassCode}" policyid="${seats.pricePolicyId}"><span>${seats.seatClassTypeName}</span></em>
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
                <#list toFlight.seats as seats>
                    <li <#if seats_index == 0>class="active"</#if> data-flightno="${toFlight.flightNo}" data-code="${seats.seatClassCode}" data-type="DEPARTURE" childPrice="${seats.childrenPrice}" adaultPrice="${seats.flightTicketPriceDto.salesPrice}">
                        <#if seats.differentPrice lt 0>
                            <span class="scl-diff-minus">-<i class="price-rmb">¥</i>${seats.differentPrice * (-1)}</span>
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
        <a href="javascript:;" data-type="DEPARTURE" class="btn btn-sm btn-pink fh-change-btn">更换航班</a>
    </div>
<#if toFlight.highLightFlag == true>
    <p class="flight-warning">
        <i class="fh-icon fh-icon-warning"></i>该航班为隔夜航班，请留意您的酒店入住日期
    </p>
</#if>
</div>
