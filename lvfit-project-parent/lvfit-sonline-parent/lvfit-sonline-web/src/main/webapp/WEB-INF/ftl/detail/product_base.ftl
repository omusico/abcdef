
        <!-- 顶部产品概览开始 -->
        <div class="product-overview clearfix">
            <input type="hidden" id="productId" name="productId" value="${basicInfo.productId}">
            <input type="hidden" id="bizCategoryId" name="bizCategoryId" value="${basicInfo.bizCategoryId}">
            <input type="hidden" id="isMuiltDeparture" name="isMuiltDeparture" value="${basicInfo.muiltDpartureFlag?string}">
            <input type="hidden" id="startDistrictId" name="startDistrictId" value="${basicInfo.defDeparture.departureCityDistrictId}">
            <input type="hidden" id="shoppingUuid" name="shoppingUuid" value="${basicInfo.shoppingUuid}">
            <input type="hidden" id="depCityCode" name="depCityCode" value="${basicInfo.defDeparture.departureCityCode}">
            <input type="hidden" id="arvCityCode" name="arvCityCode" value="${basicInfo.defDeparture.arrivalCityCode}">
            <input type="hidden" id="routeNum" name="routeNum" value="${basicInfo.routeNum}">
            <input type="hidden" id="noGoodsFlag" name="noGoodsFlag">
            <div class="product-type">
                <div class="free-tour-icon" id="tour-type"></div>
            </div>
            <div class="clear"></div>

            <div class="product-Img fl pr">
                <div class="product-pic pr">
                    <div class="pika-imgnav"><a class="previous js_btnL"></a><a class="next js_btnR"></a></div>
                    <ul>
                        <#list photoUrls as photoUrl>
                        <li><img src="http://pic.lvmama.com${photoUrl}" width="455" height="303"></li>
                        </#list>
                    </ul>
                </div>

                <div class="product-spic pr ml20 mt5">
                    <ul class="pa" style="left: 0px; position: absolute; top: 0px; width: 210px;">
                        <#list photoUrls as photoUrl>
                        <li <#if photoUrl_index==0>class="active"</#if> ><img src="http://pic.lvmama.com${photoUrl}" width="100" height="67"><span class="zhezhao"></span></li>
                        </#list>
                    </ul>
                </div><!-- //product-spic -->

                <a href="javascript:;" class="l productImg-btn js_btnL"><span class="group_icon ph_icon_alertl"></span></a>
                <a href="javascript:;" class="r productImg-btn js_btnR"><span class="group_icon ph_icon_alertr"></span></a>
            </div>


            <!--首屏右侧开始-->
            <div class="product_top_r">
                <div class="product_top_tit">
                    <div class="product_top_cfd">
                        <span class="product_top_cfd_title">
                            <span id="depCityNameSpan">${basicInfo.defDeparture.departureCityName}</span>出发
                            <#if depCities?size gt 1>
                            <span class="product_top_cfd_title_triangle"></span>
                            </#if>
                        </span>
                        <#if depCities?size gt 1>
                        <div class="product_top_cfd_content">
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

                    <h1>${basicInfo.productName}</h1>
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
                                起/份（${basicInfo.adultQuantity}成人${basicInfo.childQuantity}儿童）
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
               <#--  <#if additional.promotionInfo != null>
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

                <!-- 套餐包含 -->
                <dl class="product_info2">
                    <dt>套餐包含：</dt>
                    <dd>
                        ${additional.containItems}
                    </dd>
                </dl>

                <#if additional.pmRecommendInfo>
                <div class="product_tj">
                    <div class="product_tj_l">
                        <img src="${additional.pmUrl!'http://s2.lvjs.com.cn/img/v6/line/icon_lv.jpg'}" width="70" height="70">
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
                $(".product_top_cfd_content dd").live("click", function(e) {
                    var event = e || window.event;
                    event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);

                    var districtId = $(this).data("districtid");
                    var productId = $("#productId").val();

                    var path = window.location.pathname;
                    if (path.indexOf("preview") == -1) {
                         window.location.href="${request.contextPath}/freetour-"+productId+"-D"+districtId;
                     } else {
                         window.location.href="${request.contextPath}/freetour-"+productId+"-D"+districtId + "-preview";
                     }
                });

                <!--分期付款样式-->
                $("#product-price-explain,.tagsbackRMB").poptip();

                //焦点图
                $('.product-Img').imgScroll1({
                      migBox: '.product-pic', //运动列表ul的父级；
                      tabBox: '.product-spic',     //切换列表ul的父级
                      btnL : '.js_btnL',    //左按钮
                      btnR : '.js_btnR',    //右按钮
                      tab_name : 'active',  //切换高亮状态的class
                      runStyle : 2          //大图切换方式，1是左右滚动，2是渐变切换
                });

                var level = $(".percentum").data("level");
                if (level === "" || isNaN(level)) {
                    $("#feedBackRateSpan").text("100%");
                } else {
                    $("#feedBackRateSpan").text(level + "%");
                }
            });
        </script>
