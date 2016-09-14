<div class="fh-pm-flight">
    <h3 class="fh-title fh-flight-title">
        机票
        <span class="from">${searchform.departureCityName}</span>
        <i class="icon icon-from-to-sm"></i>
        <span>${searchform.arrivalCityName}</span>
    </h3>
    <!-- 机票列表 -->
    <div class="flight-list">
        <!-- 去程航班 -->
        <div id="to_flightInfo">
        <#include "flight/to_flight.ftl">
        </div>

        <div id="back_flightInfo">
        <!-- 返程航班 -->
        <#include "flight/back_flight.ftl">
        </div>

    </div><!-- //flight-list -->
</div>



