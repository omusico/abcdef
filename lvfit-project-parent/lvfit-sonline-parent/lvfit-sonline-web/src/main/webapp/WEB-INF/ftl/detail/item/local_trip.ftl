<!--当地游-->
<#if localTrip??>
<div class="adjust-item clearfix">
    <div class="need-submit-data params-local-163597-2420816"></div>
    <div class="lvmama-fangcha-price fangcha-local-163597-2420816"></div>
    <div class="title">
        <span>当地游</span>
    </div>
    <div class="right-container clearfix">
        <div class="type gray">
            <p>${localTrip.travelDays}天${localTrip.stayDays}晚</p>
            <p>可选时间</p>
            <p>第${localTrip.dayOfDuration}天</p>
        </div>
        <div class="detail">
            <div class="default">
                <div data-type="local" class="local-item adjust-product-item clearfix">
                    <div class="local-item-name">
                        <p>${localTrip.productName}</p>
                    </div>
                    <div class="local-item-day">
                        <select class="lvmama-price-flag">
                            <option value="${localTrip.visitDate?string('yyyy-MM-dd')}">${localTrip.visitDate?string('yyyy-MM-dd')}</option>
                        </select>
                    </div>
                    <div class="local-item-quantity">

                    </div>
                    <div class="local-item-price">
                    </div>
                    <div class="local-item-status status">
                        <i class="product-item-checked-icon"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</#if>
<!--当地游-->