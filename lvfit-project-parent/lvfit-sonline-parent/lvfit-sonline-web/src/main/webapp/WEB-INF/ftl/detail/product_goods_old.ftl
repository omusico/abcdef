
    <!-- 交通 -->
    <div class="adjust-traffic preorder-adjust-first" id="adjust-traffic">
        <#include "/detail/item/traffic.ftl"/>
    </div>
   
    <div id="adjust-hotel-outer">
        <#include "/detail/item/hotelinfo.ftl"/>
    </div>   
    <!-- 酒店套餐 -->
    <div id="adjust-hotel-package">
        <#include "/detail/item/hotel_combo.ftl"/>
    </div>
        
    <!-- 当地游 -->
    <div id="adjust-local">
        <#include "/detail/item/local_trip.ftl"/>
    </div>
    <!-- 附加 -->
    <div id="adjust-optional">
        <#include "/detail/item/optional.ftl"/>
    </div>
