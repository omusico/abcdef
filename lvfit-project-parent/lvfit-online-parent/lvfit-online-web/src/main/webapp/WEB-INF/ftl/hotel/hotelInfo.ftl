    <div class="list-box">
        <div class="list-t">
            <a id="changeHotelBtn" href="javascript:;" class="btn btn-sm btn-pink fh-change-hotel-btn">更换酒店</a>
            <a name="${hotel.productId }" href="javascript:;" class="list-t-img pa">
                <img src="http://pic.lvmama.com${hotel.photoUrl}" width="180" height="120" />
            </a>
            <h4 class="list-t-tit">
                <a name="${hotel.productId }" href="javascript:;" class="yh f20 c3">${hotel.productName}</a>
                <span class="c9 f12">
                    <#if hotel.starDesc ? ends_with("酒店")>
                        <#assign sublength = hotel.starDesc?index_of("酒店")/>
                        [${hotel.starDesc ? substring(0,sublength)}]
                    <#else>
                        [${hotel.starDesc}]
                    </#if>
                </span>
            </h4>

            <p class="list-icon">
                <#if hotel.facilities??>
                    <#list hotel.facilities?split(',') as facility>
                        <!-- 460,461,462,463,464 -->
                        <#if facility="472">
                            <span class="ph_icon_hotel ph_icon_mr" title="会议室"></span>
                        </#if>
                        <#if facility="470">
                            <span class="ph_icon_hotel ph_icon_gym" title="健身房"></span>
                        </#if>
                        <#if facility="464">
                            <span class="ph_icon_hotel ph_icon_park_f" title="免费停车场"></span>
                        </#if>
                        <#if facility="460">
                            <span class="ph_icon_hotel ph_icon_wifi_f" title="免费Wifi"></span>
                        </#if>
                        <#if facility="462">
                            <span class="ph_icon_hotel ph_icon_internet_f" title="免费宽带"></span>
                        </#if>
                        <#if facility="471">
                            <span class="ph_icon_hotel ph_icon_bc" title="商务中心"></span>
                        </#if>
                        <#if facility="468">
                            <span class="ph_icon_hotel ph_icon_swim-in" title="室内游泳池"></span>
                        </#if>
                        <#if facility="461">
                            <span class="ph_icon_hotel ph_icon_wifi_c" title="收费Wifi"></span>
                        </#if>
                        <#if facility="465">
                            <span class="ph_icon_hotel ph_icon_park_c" title="收费停车场"></span>
                        </#if>
                        <#if facility="473">
                            <span class="ph_icon_hotel ph_icon_restaurant" title="酒店餐厅"></span>
                        </#if>
                        <#if facility="463">
                            <span class="ph_icon_hotel ph_icon_internet_c" title="收费宽带"></span>
                        </#if>
                        <#if facility="466">
                            <span class="ph_icon_hotel ph_icon_pick_f" title="免费接机"></span>
                        </#if>
                        <#if facility="467">
                            <span class="ph_icon_hotel ph_icon_pick_c" title="收费接机"></span>
                        </#if>
                        <#if facility="469">
                            <span class="ph_icon_hotel ph_icon_swim-out" title="室外游泳池"></span>
                        </#if>
                    </#list>
                </#if>
            </p>
            <p class="list-info mt10 c9">
                <#if hotel.commentGood?? && hotel.commentGood gt 0>
                    <dfn class="cf60 f14 pr5">${hotel.commentGood}%</dfn>好评率来自
                </#if>
                <#if hotel.commentNum?? && hotel.commentNum gt 0>
                    <a name="${hotel.productId }" href="javascript:;"
                       class="JS_alertBox c09c">${hotel.commentNum}</a>条点评
                </#if>
            </p>
            <p class="list-address c9 mt10">
                地址：<span class="pl5 c6">${hotel.address}</span>
                <a name="${hotel.productId }" class="list-maplink pl5 c09c JS_maplink"
                   href="javascript:;"><span class="ph_icon ph_icon_map"></span>地图</a>
            </p>
        </div><!-- //list-t -->
        <ul class="roomHead roomTable clearfix">
            <li class="roomTable-td roomTable-td1">房型</li>
            <li class="roomTable-td roomTable-td2">床型</li>
            <li class="roomTable-td roomTable-td3">早餐</li>
            <li class="roomTable-td roomTable-td-kd">宽带</li>
            <li class="roomTable-td roomTable-td4">间数</li>
            <li class="roomTable-td roomTable-td5">差价</li>
        </ul>

        <#list hotel.rooms as room>
        <#assign showFlag = false>
        <div class="room-content" <#if room_index lt 1>style="display: block;"</#if>>
            <!-- 展开加open -->
            <div class="roomLi clearfix">
                <div class="roomTable-td roomTable-td1">
                    <em class="roomName pr">
                        <span class="ht-icon"></span>${room.branchName}<i class="arrow"></i>
                    </em>
                </div>
                <!--房型设施 info_box-->
                <div class="info_box">
                    <img src="http://pic.lvmama.com${room.photoUrl}" data-src="http://pic.lvmama.com${room.photoUrl}" width="90" height="60">
                    <div class="room-meta">
                        <#if room.bedType>
                            <p>床型：${room.bedType}</p>
                        </#if>
                        <#if room.extraBed>
                            <p class="room-addBed">加床：${room.extraBed}</p>
                        </#if>
                        <#if room.area>
                            <p class="room-area">面积：${room.area}平方米</p>
                        </#if>
                        <#if room.floor>
                            <p>楼层：${room.floor}</p>
                        </#if>
                        <#if room.broadband>
                            <p>宽带：${room.broadband}</p>
                        </#if>
                    </div>
                    <#if room.branchDesc>
                    <p class="room-other">其他：${room.branchDesc}</p>
                    <#else>
                    <p class="room-other"></p>
                    </#if>
                    <a class="room-up" href="javascript:;">收起</a>
                </div><!-- //info_box -->
            </div>

            <div class="romLi-more clearfix">
            <#if room.plans?size gt 1>
                <#assign showFlag = true>
            </#if>
            <#list room.plans as plan>
                <dl <#if plan_index lt 1>style="display:block"</#if> >
                    <dt class="roomTable-td roomTable-td1">${plan.goodsName}</dt>
                    <!--床型开始-->
                    <dd class="roomTable-td roomTable-td2">${room.bedType!"暂无介绍"}</dd>
                    <!--床型结束-->
                    <!--早餐介绍-->
                    <#assign hasBreakfast = false/>
                    <#if plan.dayPrice?? && plan.dayPrice?size gt 0>
                        <#list plan.dayPrice as goodsTimePrice>
                            <#if goodsTimePrice.breakfast gt 0>
                                <#assign hasBreakfast = true/>
                                <#break>
                            </#if>
                        </#list>
                    </#if>
                    <dd class="roomTable-td roomTable-td3"><#if hasBreakfast>有早餐<#else>无早餐</#if></dd>
                    <!--早餐结束-->
                    <dd class="roomTable-td roomTable-td-kd">${room.broadband!"暂无介绍"}</dd>
                    <!--宽带结束-->
                    <!--房间数开始-->
                    <dd class="roomTable-td roomTable-td4">
                        <div class="select-div">
                            <span>
                            ${plan.planCounts}
                            </span>
                            <i class="arrow"></i>
                        </div>
                        <ol class="select-div-list">
                            <#list plan.minPlanCounts..plan.maxPlanCounts as roomNum>
                                <li data-num="${roomNum}">${roomNum}</li>
                            </#list>
                        </ol>
                    </dd>
                    <!--房间数结束-->
                    <!--差价开始-->
                    <!-- 差价"-"加room-diff-minus -->
                    <dd class="roomTable-td roomTable-td5 <#if plan.priceDifferences lt 0>room-diff-minus </#if>">
                        <#if plan.priceDifferences != "" && plan.priceDifferences lt 0>
                            <span>-</span>&yen;<dfn
                                class="f14 pl2 bold">${plan.priceDifferences*-1}</dfn>
                        <#else>
                            <span>+</span>&yen;<dfn
                                class="f14 pl2 bold">${plan.priceDifferences}</dfn>
                        </#if>
                    </dd>
                    <dd class="roomTable-td roomTable-td6" data-productid="${hotel.productId}" data-branchid="${room.branchId}" data-goodsid="${plan.suppGoodsId}">
                        <#if room_index == 0 && plan_index == 0>
                            <a href="javascript:void(0);" class="selectedBtn">已选<span class="ph_icon ph_icon_selected"></span></a>
                        <#else>
                            <a href="javascript:void(0);" class="btn btn-small btn-orange xuanze">选择</a>
                        </#if>
                    </dd>
                </dl>
            </#list>
            </div><!-- //romLi-more -->
        </div>
        </#list>
    </div>
    <#if hotel.rooms?size gte 2 || showFlag>
        <p class="mt10 tr">
            <a href="javascript:;" class="c09c arrowMain pr showAllRoom JS_showAllRoom">展开全部房型<dfn>（${hotel.rooms?size}）</dfn>
                <i class="arrow"></i>
            </a>
        </p>
    </#if>

