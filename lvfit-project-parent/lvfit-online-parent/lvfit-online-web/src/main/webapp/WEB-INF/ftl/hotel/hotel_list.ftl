<!-- 搜索无结果 -->
<!--无结果模块--开始-->
<#if !(hotelLists?? && hotelLists?size gt 0)>
<div class="fh-no-result clearfix">
    <i></i>
    <div class="fh-nr-text">
        <p class="sorry">非常抱歉，没有找到符合您条件的酒店</p>
        <p class="suggestion">建议您适当减少已选择的条件 或
            <a href="${request.contextPath}/search/hotels/${uuid}/ALL/ALL/ALL/ALL/ALL/1">取消条件重新搜索</a>
        </p>
    </div>
</div>
</#if>
<!--无结果模块--结束-->

<!-- 搜索结果开始 listMain-->
<#if hotelLists?? && hotelLists?size gt 0>
    <#list hotelLists as hotel>
        <#assign showFlag = false>
    <div class="listMain mt10 bd_ddd">
        <!-- 列表开始 -->
        <div class="list-box"><!--酒店列表开始-->
            <div class="list-t pr"><!--酒店基本信息开始-->
                <a name="${hotel.productId }" href="javascript:;" class="list-t-img pa">
                    <img src="http://pic.lvmama.com${hotel.photoUrl}" width="180" height="120" alt="">
                </a>
                <h4 class="list-t-tit">
                    <a name="${hotel.productId }" href="javascript:" class="yh f20 c3">${hotel.productName}</a>
                    <span class="c9 f12">
                        <#if hotel.starDesc??>
                            <span class="hotel_type">
                                <#if hotel.starDesc ? ends_with("酒店")>
                                    <#assign sublength = hotel.starDesc?index_of("酒店")/>
                                    [${hotel.starDesc ? substring(0,sublength)}]
                                <#else>
                                    [${hotel.starDesc}]
                                </#if>
                            </span>
                        </#if>
                    </span>
                </h4>
                <!--设施-->
                <#if hotel.facilities??><!--酒店设施开始-->
                <p class="list-icon">
                    <#list hotel.facilities?split(',') as facility>
                        <#if facility=="472">
                            <span class="ph_icon_hotel ph_icon_mr" title="会议室"></span>
                        </#if>
                        <#if facility=="470">
                            <span class="ph_icon_hotel ph_icon_gym" title="健身房"></span>
                        </#if>
                        <#if facility=="464">
                            <span class="ph_icon_hotel ph_icon_park_f" title="免费停车场"></span>
                        </#if>
                        <#if facility=="460">
                            <span class="ph_icon_hotel ph_icon_wifi_f" title="免费Wifi"></span>
                        </#if>
                        <#if facility=="462">
                            <span class="ph_icon_hotel ph_icon_internet_f" title="免费宽带"></span>
                        </#if>
                        <#if facility=="471">
                            <span class="ph_icon_hotel ph_icon_bc" title="商务中心"></span>
                        </#if>
                        <#if facility=="468">
                            <span class="ph_icon_hotel ph_icon_swim-in" title="室内游泳池"></span>
                        </#if>
                        <#if facility=="461">
                            <span class="ph_icon_hotel ph_icon_wifi_c" title="收费Wifi"></span>
                        </#if>
                        <#if facility=="465">
                            <span class="ph_icon_hotel ph_icon_park_c" title="收费停车场"></span>
                        </#if>
                        <#if facility=="473">
                            <span class="ph_icon_hotel ph_icon_restaurant" title="酒店餐厅"></span>
                        </#if>
                        <#if facility=="463">
                            <span class="ph_icon_hotel ph_icon_internet_c" title="收费宽带"></span>
                        </#if>
                        <#if facility=="466">
                            <span class="ph_icon_hotel ph_icon_pick_f" title="免费接机"></span>
                        </#if>
                        <#if facility=="467">
                            <span class="ph_icon_hotel ph_icon_pick_c" title="收费接机"></span>
                        </#if>
                        <#if facility=="469">
                            <span class="ph_icon_hotel ph_icon_swim-out" title="室外游泳池"></span>
                        </#if>
                    </#list>
                </p>
                </#if><!--酒店设施结束-->
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
                    <#if hotel.address??>
                        地址：<span class="pl5 c6">${hotel.address}
									</span>
                        <a name="${hotel.productId}" class="list-maplink pl5 c09c JS_maplink"
                           href="javascript:;"><span class="ph_icon ph_icon_map"></span>地图</a>
                    </#if>
                </p>
            </div><!-- //list-t --><!--酒店基本信息结束-->

            <ul class="roomHead roomTable clearfix f12 mt20">
                <li class="roomTable-td roomTable-td1">房型</li>
                <li class="roomTable-td roomTable-td2">床型</li>
                <li class="roomTable-td roomTable-td3">早餐</li>
                <li class="roomTable-td roomTable-td-kd">宽带</li>
                <li class="roomTable-td roomTable-td4">间数</li>
                <li class="roomTable-td roomTable-td5">差价</li>
            </ul>

            <#if hotel.rooms??><!--房型开始-->
                <#list hotel.rooms as room><!--房型列表开始-->
                <div class="room-content" <#if room_index lt 2>style="display:block;"</#if>>
                    <div class="roomLi clearfix" name="roomDiv">
                        <div class="roomTable-td roomTable-td1"><em class="roomName pr"><span
                                class="ht-icon"></span>${room.branchName}<i
                                class="arrow"></i></em></div>
                        <!--房型设施 info_box-->
                        <div class="info_box">
                            <img src="http://pic.lvmama.com${room.photoUrl}"
                                 data-src="http://pic.lvmama.com${room.photoUrl}" width="90"
                                 height="60">
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
                            <p class="room-other"><#if room.branchDesc>
                                其他：${room.branchDesc}</#if></p>
                            <a class="room-up" href="javascript:;">收起</a>
                        </div><!-- //info_box -->
                    </div>

                    <div class="romLi-more clearfix">
                        <#if room.plans?size gt 1>
                            <#assign showFlag = true>
                        </#if>
                        <#list room.plans as plan>
                            <dl <#if plan_index lt 1>style="display: block" </#if>>
                                <dt class="roomTable-td roomTable-td1">${plan.goodsName}</dt>
                                <dd class="roomTable-td roomTable-td2">${room.bedType!'暂无介绍'}</dd>
                                <!--早餐介绍-->
                                <#assign hasBreakfast = false/> <!--早餐开始-->
                                <#if plan.dayPrice?? && plan.dayPrice?size gt 0>
                                    <#list plan.dayPrice as goodsTimePrice>
                                        <#if goodsTimePrice.breakfast gt 0>
                                            <#assign hasBreakfast = true/>
                                            <#break>
                                        </#if>
                                    </#list>
                                </#if>
                                <dd class="roomTable-td roomTable-td3"><#if hasBreakfast>
                                    有早餐<#else>无早餐</#if></dd>
                                <!--早餐结束-->
                                <dd class="roomTable-td roomTable-td-kd">${room.broadband!"暂无介绍"}</dd>
                                <dd class="roomTable-td roomTable-td4">
                                    <div class="select-div">
                                    <span>
                                    ${room.roomCounts}
                                    </span>
                                        <i class="arrow"></i>
                                    </div>
                                    <ol class="select-div-list">
                                        <#list plan.minQuantity..plan.maxQuantity as roomNum>
                                            <li data-num="${roomNum}">${roomNum}</li>
                                        </#list>
                                    </ol>
                                </dd>
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
                                <#if selHotelId == hotel.productId && selHotelRoomId== room.branchId && selHotelPlanId == plan.suppGoodsId>
                                    <a href="javascript:void(0);" class="selectedBtn">已选
                                        <span class="ph_icon ph_icon_selected"></span>
                                    </a>
                                <#else>
                                    <a href="javascript:void(0);" class="btn btn-small btn-orange xuanze">选择</a>
                                </#if>
                                </dd>
                            </dl>
                        </#list>
                    </div><!-- //romLi-more -->
                </div>
                </#list><!--房型列表结束-->
            </#if><!--房型结束-->
        </div><!--酒店列表结束-->
        <!-- 列表结束 -->

        <#if hotel.rooms?size gt 2 || showFlag>
            <p class="mt10 tr">
                <a href="javascript:;"
                   class="c09c arrowMain pr showAllRoom JS_showAllRoom">展开全部房型<dfn>（${hotel.rooms?size}）</dfn><i
                        class="arrow"></i></a>
            </p>
        </#if>
        <!-- 列表结束 -->
    </div><!-- //搜索结果结束 listMain -->
    </#list>

    <!--分页开始-->
    <input type="hidden" name="page" id="page" value="${pagination.page}">
    <div class="paging orangestyle">
        <#assign endPage2 =0>
        <span class="gopage">到第 <input id="pageNoInput" type="text" class="js_goPage input-text" onkeypress="BindEnter();"> 页 <button class="btn btn-gray btn-small" onclick="goPage()" type="button">确定</button></span>
        <div class="pagebox">
            <#if pagination.page - 1 gt 0>
                <a style="cursor: pointer;" class="prevpage"><i class="larr"></i>上一页</a>
            </#if>
            <#if pagination.page !=1>
                <a style="cursor: pointer;">1</a>
            </#if>
            <#if pagination.page gt 4>
                <span class="pagemore">...</span>
            </#if>

            <#if pagination.total gt pagination.page + 5>
                <#assign endPage2 = pagination.page + 5>
            <#else>
                <#assign endPage2 = pagination.page + 1>
            </#if>

            <#assign i = pagination.page - 5 >
            <#list i..endPage2 as index>
                <#assign i =i+1 >
                <#if i gt 0>
                    <#if i == pagination.page >
                        <span class="pagesel">${i}</span>
                    <#else>
                        <#if i!=1 && i lt pagination.total>
                            <a style="cursor: pointer;" >${i}</a>
                        </#if>
                    </#if>
                </#if>
            </#list>

            <#if pagination.page + 3 lt pagination.total >
                <span class="pagemore">...</span>
            </#if>

            <#if pagination.page != pagination.total >
                <a style="cursor: pointer;" >${pagination.total}</a>
            </#if>
            <#if pagination.page lt pagination.total >
                <a style="cursor: pointer;" class="nextpage"><i class="rarr"></i>下一页</a>
            </#if>
        </div>
    </div>
    <!-- 分页结束-->
</#if>
