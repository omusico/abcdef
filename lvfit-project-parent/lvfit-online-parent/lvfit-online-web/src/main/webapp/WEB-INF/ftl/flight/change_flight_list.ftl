<#if flightInfos?? && flightInfos?size gt 0 >
<div class="flight-list">
    <!-- 机票列表头部 -->
    <div class="flight-title clearfix">
        <div class="flight-col flight-info">航班信息</div>
        <div class="flight-col flight-time">
            <a onclick="sortFunction(this)" title="按起飞时间 从早到晚排序"  href="javascript:;">起飞时间
                <em class="sort_up"></em>
            </a>
        </div>
        <div class="flight-col flight-stop"></div>
        <div class="flight-col flight-time flight-arrival-time">到达时间</div>
        <div class="flight-col flight-duration">飞行时长</div>
        <div class="flight-col flight-type">舱位</div>
        <div class="flight-col flight-diff">
            <a class="active" onclick="sortFunction(this)" title="按差价由低到高排序" href="javascript:;">差价
                <em class="sort_up"></em>
            </a>
        </div>
    </div><!-- //flight-title -->
    <#list flightInfos as flo>
        <!-- 机票列表 --><!-- 没有 更多舱位时 加 flight-detail-all -->
    <div class="flight-detail <#if flo.seats?size lte 1>flight-detail-all</#if> clearfix" data-filterkey="${flo.filterKey}">
        <div class="flight-col flight-info">
            <div class="flight-top">
                <i class="fh-icon-ac fh-icon-ac-${flo.carrierCode}"></i>
            ${flo.carrierName}
            </div>
            <!-- TODO 机型信息填在对应的data属性中 -->
            <div class="flight-bottom"><span class="flight-number">${flo.flightNo}</span><span
                    class="plane-type" data-plan="${flo.airplane.code}"
                    data-name="${flo.airplane.name}" data-type="${flo.airplane.airplaneType}"
                    data-min="${flo.airplane.minSeats}"
                    data-max="${flo.airplane.maxSeats}">${flo.airplane.code}</span></div>
        </div>
        <div class="flight-col flight-time">
            <div class="flight-top">${flo.departureTime?substring(10, 16)}</div>
            <div class="flight-bottom">
                <a class="airport-name" href="javascript:;" title="${flo.departureAirportName}">${flo.departureAirportName}</a><span>${flo.departureTermainalBuilding}</span>
            </div>
        </div>
        <div class="flight-col flight-stop">
            <#if flo.stopCount==0>
                <p class="flight-stop-text"></p>
            <#else>
                <!-- TODO 没有经停时，删除“经停”两字，切勿删除P标签 -->
                <p class="flight-stop-text">经停</p>
            </#if>
            <div class="fh-icon-stop"></div>
        </div>
        <div class="flight-col flight-time flight-arrival-time">

            <div class="flight-top"><span class="time">${flo.arrivalTime?substring(10, 16)}</span>

                <#if flo.highLightFlag>
                    <span class="flight-add-one-day"
                          tip-content="航班到达日期为起飞日期<span class='tip-add-one'>+1天</span>。">+1</span>
                <#else>
                    <span class="flight-add-one-day"
                          tip-content="航班到达日期为起飞日期<span class='tip-add-one'>+1天</span>。"></span>
                </#if>
            </div>

            <div class="flight-bottom"><a class="airport-name" href="javascript:;"
                                          title="${flo.arrivalAirportName}">${flo.arrivalAirportName}</a><span>${flo.arrivalTerminalBuilding}</span>
            </div>
        </div>
        <div class="flight-col flight-duration">
            <div class="flight-center">${flo.flyTime?replace("小时", "h")?replace("分钟", "m")}</div>
        </div>

        <!--新版舱位展示----开始-->
        <div class="flight-type-list">
            <ul>
                <#list flo.seats as seatInfo>
                    <li class="clearfix seat-info" data-flightno="${flo.flightNo}" data-code="${seatInfo.seatClassCode}"
                        style="display:${(seatInfo_index == 0)?string("block;","none;")}">
                        <div class="flight-col flight-type">
                            <div class="flight-center">
                                <em code=${seatInfo.seatClassCode}pricepolicyid="${seatInfo.pricePolicyId}"><span
                                        class="flight-class">${seatInfo.seatClassTypeName}</span></em>
                                <#if seatInfo.inventoryCount lte 9>
                                    <span class="flight-ticket-amount">剩余${seatInfo.inventoryCount}</span>
                                <#else>
                                    <span class="flight-ticket-amount" style="display:none;"></span>
                                </#if>
                            </div>
                        </div>

                        <#if seatInfo.differentPrice lt 0>
                            <div class="flight-col flight-diff flight-diff-minus" id="flight-price">
                                <div class="flight-center"><em>-</em><i
                                        class="price-rmb">¥</i>${seatInfo.differentPrice*(-1)}</div>
                            </div>
                        <#else>
                            <div class="flight-col flight-diff" id="flight-price">
                                <div class="flight-center"><em>+</em><i
                                        class="price-rmb">¥</i>${seatInfo.differentPrice}</div>
                            </div>
                        </#if>

                        <#if seatInfo_index == 0 && flo_index == 0>
                            <a href="javascript:void(0);" class="fh-selected">已选<i
                                    class="icon icon-selected"></i></a>
                        <#else>
                            <a href="javascript:void(0);"
                               class="btn btn-sm btn-orange fh-select-btn">选择</a>
                        </#if>
                    </li>
                </#list>
            </ul>
            <a class="more-type-btn" href="javascript:;">更多舱位<i class="arrow"></i></a>
        </div>
        <!--新版舱位展示----结束-->
    </div>
    </#list>
</div><!-- //flight-list -->
<#else><!--搜索有结果的if想对应-->
<!-- 搜索无结果 -->
<div class="fh-no-result clearfix">
    <i></i>
    <div class="fh-nr-text">
        <p class="sorry">非常抱歉，没有找到符合您条件的航班</p>
        <p class="suggestion">建议您适当减少已选择的条件或 <a href="javascript:;" onclick="closeAll();">取消条件重新搜索</a></p>
    </div>
</div>
</#if>


</div>
