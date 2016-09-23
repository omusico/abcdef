<div class="crumbs clearfix">
</div>
<div id="dev"></div>
<div class="product_top clearfix">
    <input type="hidden" id="productId" name="productId" value="${basicInfo.productId}">
    <input type="hidden" id="bizCategoryId" name="bizCategoryId" value="${basicInfo.bizCategoryId}">
    <input type="hidden" id="isMuiltDeparture" name="isMuiltDeparture" value="${basicInfo.muiltDpartureFlag?string}">
    <input type="hidden" id="startDistrictId" name="startDistrictId" value="${basicInfo.defDeparture.departureCityDistrictId}">
    <input type="hidden" id="shoppingUuid" name="shoppingUuid" value="${shoppingUuid}">
    <input type="hidden" id="depCityCode" name="depCityCode" value="${basicInfo.defDeparture.departureCityCode}">
    <input type="hidden" id="arvCityCode" name="arvCityCode" value="${basicInfo.defDeparture.arrivalCityCode}">
    <input type="hidden" id="routeNum" name="routeNum" value="${basicInfo.routeNum}">
    <input type="hidden" id="noGoodsFlag" name="noGoodsFlag">
    <input type="hidden" id="showStartMonth" name="showStartMonth" value="${showStartMonth}">
    <input type="hidden" name="packCharterFlightFlag" id="packCharterFlightFlag" value="${basicInfo.packCharterFlightFlag}">
    <div class="group_icon product_gty"></div>
    <!-- 首屏左侧开始 -->
    <div class="product_top_l image_zone clearfix">
    <!--图片切换模块 开始-->
        <div class="product_top_img">
            <div class="focusImg">
                <#if photoUrls[0]?length gt 4>
                <#assign photoLen = photoUrls[0]?length - 4/>
                <#assign photoType = photoUrls[0]?substring(photoLen,photoLen+4)/>
                <img src="http://pic.lvmama.com${photoUrls[0]?substring(0,photoLen)}_480_320${photoType}" width="460px" height="308px"/>
                </#if>
                <span class="group_icon btn_l"></span>
                <span class="group_icon btn_r"></span>
            </div>
            <div class="scrollImg">
                <div class="scrollImg_wrap">
                    <ul>
                        <#list photoUrls as photoUrl>
                            <#if photoUrls[0]?length gt 4>
                            <#assign photoLen = photoUrl?length - 4/>
                            <#assign photoType = photoUrl?substring(photoLen,photoLen+4)/>
                            <li <#if photoUrl_index==0>class='active'</#if> data-src="http://pic.lvmama.com${photoUrl?substring(0,photoLen)}_480_320${photoType}">
                                <a href="javascript:;">
                                    <img src="http://pic.lvmama.com${photoUrl?substring(0,photoLen)}_180_120${photoType}" width="95px" height="64px"/>
                                </a>
                            </li>
                            </#if>
                        </#list>
                    </ul>
                </div>
                <div class="scrollBtn">
                    <a href="javascript:;" class="group_icon prev disable"></a>
                    <a href="javascript:;" class="group_icon next"></a>
                </div>
            </div>
        </div><!--图片切换模块 结束-->

        <!--日历表开始-->
        <#include "detail/group_calendar.ftl">
        <!--日历表结束-->
    </div><!-- //product_top_l 首屏左侧结束-->

    <!--首屏右侧开始-->
    <div class="product_top_r">
        <div class="product_top_tit">
            <div class="product_top_cfd">
                <span class="product_top_cfd_title">
                    <span id="depCityNameSpan">${basicInfo.defDeparture.departureCityName}</span>出发
                    <#if basicInfo.muiltDpartureFlag == "Y">
                    <span class="product_top_cfd_title_triangle"></span>
                    </#if>
                </span>
                <#if basicInfo.muiltDpartureFlag == "Y">
                <div class="product_top_cfd_content" id="depCitiesDiv">
                    <#list depCities?keys as key>
                    <dl>
                        <dt>${key}</dt>
                        <#list depCities[key] as depCity>
                        <dd data-districtid="${depCity.departureCityDistrictId}" data-citycode="${depCity.departureCityCode}">${depCity.departureCityName}</dd>
                        </#list>
                    </dl>
                    </#list>
                </div>
                </#if>
            </div><!-- //product_top_cfd -->
            <i class="product_top_cfd_blank"></i>

            <h1>
                <#if basicInfo.productShowName??>
                   <b>${mainTitle}</b>&nbsp;&nbsp;${subTitle}
                <#else>
                  ${basicInfo.productName}
                </#if>
            </h1>
            <#list additional.titleTags as titleTag>
            <span class="tagsback tagsback-orange" tip-content='${titleTag.tagContent}'><i>${titleTag.tagName}</i></span>
            </#list>
        </div>

        <div class="product_info1">
            <p>
                <i class="group_icon icon_dmz1"></i>
                <span id="feedBackRateSpan" class="c_f60">
                </span>好评
            </p>
            产品编号：${basicInfo.productId}
        </div>

        <div class="pr">
            <dl class="product_info2 product_info2_1">
                <dt>驴妈妈价：</dt>
                <dd class="clearfix">
                    <p class="product_price_box">
                        <span class="product_price" id="product_price"><dfn>¥</dfn>${basicInfo.productPrice}</span>
                        起/人(最少成团人数:1人)
                    </p>
                    <span class="pro_price_tips">
                        <i class="group_icon icon_wenhao"></i>
                        <samp class="js_tips" tip-content="本起价是指未包含附加服务（如单人房差、保险费等）的基本价格。您最终确认的价格将会随所选出行日期、人数及服务项目而相应变化">起价说明</samp>
                    </span>
                </dd>
            </dl>

            <!-- 分期价 -->
            <div class="product_info2 product_info_bg" id="instalmentDiv" style="display: none">
                <dt>分&ensp;期&ensp;价：</dt>
                <div class="product-price-content">
                <dd>
                    <span id="instalmentSpan" class="product-price-rmb product-price-rmb-small tags tagsbackRMB" tip-content="">
                        <span class="rmb-symbol">&yen;</span>
                        <span class="product-price-value">${lowestRateMoney!}</span>
                    </span>
                    <span class="fs-12 color-style1">
                        起/期&ensp;<span class="product-price-span">(0首付，0利息，0手续费)</span>
                        <i class="product-price-explain-icon"></i>
                        <span id="product-price-explain" tip-content="分期支付请生成订单后，选择小驴分期，填写个人申请资料，等待银行审批。审批结果将以短信形式通知。">分期说明</span>
                    </span>
                </dd>
                </div>
            </div>

            <!-- 开心驴行图标 -->
            <#list additional.titleTags as titleTag>
                <#if titleTag.tagName=="开心驴行">
                <span class="group_icon icon_kxlv pa"></span>
                </#if>
            </#list>
        </div>

        <!-- 促销信息 -->
        <#-- <#if additional.promotionInfo != null>
        <div class="product_infoLine">
            <span class="tagscx">促销</span>
            <a href="javascript:;" class="product_cx">
                ${additional.promotionInfo}
                <i class="icon_arrow"></i>
            </a>
        </div>
        </#if> -->

        <!-- 优惠信息 -->
        <#if additional.discountActivityTags?size gt 0>
        <dl class="product_info2 mt5">
            <dt>优&emsp;&emsp;惠：</dt>
            <dd>
                <#list additional.discountActivityTags as activityTag>
                <#if activityTag.tagName == '游记返现'>
                <span class="tags101" tip-content="${activityTag.tagContent}">${activityTag.tagName}</span>
                <#else>
                <span class="tagsback tagsback-app2" tip-content="${activityTag.tagContent}">${activityTag.tagName}</span>
                </#if>
                </#list>
            </dd>
        </dl>
        </#if>

        <#if basicInfo.routeList?size == 0>
        <dl class="product_info2 zIndex5">
            <dt>目 的 地：</dt>
            <dd class="product_mdd_down clearfix">
                <div class="product_mdd">
                    <#list additional.destination as dest>
                    <p>
                        <span>${dest.districtName}</span>
                    </p>
                    </#list>
                    <i class="icon_arrow"></i>
                </div>
                <!--JS会自动检测是否超过一行，是否显示按钮-->
            </dd>
        </dl>
        </#if>

        <#if basicInfo.routeList?size gt 0>
        <div class="instance_list2_box">
            <div>
                <dl class="product_info2">
                    <dt>线路概况：</dt>
                    <dd class="product_xlgk c6">
                        <#list basicInfo.routeList as routeL>
                            <#if routeL_index lt 5>
                            <i>
                                <dfn>D${routeL_index+1}</dfn>
                                <#list routeL as route>
                                ${route}<#if routeL_has_next><span>&gt;</span></#if>
                                </#list>
                            </i>
                            </#if>
                            <#if routeL_index == 5>
                                <i><dfn>D6</dfn><span>&gt;</span><b class="cc">...</b></i>
                            </#if>
                        </#list>
                        <#if basicInfo.routeList?size gt 5>
                            <a href="javascript:;" class="product_xlgk_btn c9 pa JS_view_more_product_travel">查看更多</a>
                        </#if>
                    </dd>
                </dl>
            </div>
        </div>
        </#if>

        <#if additional.pmRecommendInfo>
        <div class="product_tj">
            <div class="product_tj_l">
                <img src="${additional.pmUrl!'http://s2.lvjs.com.cn/img/v6/line/icon_lv.jpg'}" width="90" height="90">
            </div>
            <div class="product_tj_r">
                <h4>产品经理推荐</h4>
                <div class="product_tj_info">
                    <#list additional.pmRecommendInfo?split("\r\n") as info>
                    <p><i class="group_icon icon_xing2"></i>${info}<br></p>
                    </#list>
                </div>
            </div>
            <i class="group_icon icon_douhao1"></i>
            <i class="group_icon icon_douhao2"></i>
        </div>
        </#if>

        <#if basicInfo.prodTags && basicInfo.prodTags?size gt 0>
        <#list basicInfo.prodTags as prodTag>
            <#if prodTag.tagName=="开心驴行">
            <!-- 开心驴行信用保障 -->
            <div class="product_xybz c6 mt20">
               <div class="product_xybzTit c9">开心驴行信用保障：<a href="javascript:;" class="c09c fr">了解更多</a></div>
               <p><span class="group_icon icon_lvxin"></span>1人报名即成行</p>
               <p><span class="group_icon icon_lvxin"></span>若不满意就重玩</p>
               <p><span class="group_icon icon_lvxin"></span>突发情况随时退</p>
               <p><span class="group_icon icon_lvxin"></span>航班延误可理赔</p>
               <p class="last"><span class="group_icon icon_lvxin"></span>管家服务全程陪</p>
            </div><!-- //product_xybz -->
            </#if>
        </#list>
        </#if>
    </div><!--首屏右侧 结束-->
</div>

<script>
    $(function(){
        $(".product_top_cfd_content dd").click(function(e) {
             var event = e || window.event;
             event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
             var districtId = $(this).data("districtid");
             var productId = $("#productId").val();

             var path = window.location.pathname;
             if (path.indexOf("preview") == -1) {
                 window.location.href="${request.contextPath}/group-"+productId+"-D"+districtId;
             } else {
                 window.location.href="${request.contextPath}/group-"+productId+"-D"+districtId + "-preview";
             }

        });

        <!--分期付款样式-->
        $("#product-price-explain,.tagsbackRMB").poptip();

        var level = $(".percentum").data("level");
        if (level === "" || isNaN(level)) {
            $("#feedBackRateSpan").text("100%");
        } else {
            $("#feedBackRateSpan").text(level + "%");
        }
    });
</script>
