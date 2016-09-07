<!--自主打包交通-->
<div id="adjust-traffic" class="adjust-item clearfix">
<!-- 交通模板开始 -->
<input type="hidden" id="selectDepFlightNo" name="selectDepFlightNo" value="${sumDepFlightInfos[0].flightNo}"/>
<input type="hidden" id="selectArvFlightNo" name="selectArvFlightNo" value="${sumArvFlightInfos[0].flightNo}"/>
<input type="hidden" id="toSortRuleType" name="toSortRuleType" value="${toSortRule.sortRuleType?string}"/>
<input type="hidden" id="backSortRuleType" name="backSortRuleType" value="${backSortRule.sortRuleType?string}"/>

<div class="adjust-item clearfix" id="139178_1723273">
    <div class="need-submit-data" data-group="traffic" data-goodsid="2963379" data-goodtype="traffic" data-mainitem="MAIN" data-routerelation="PACK" data-detailid="524827" data-quantity="1" data-todate="2016-05-04" data-visittime="2016-05-04" data-backdate="2016-05-08">
    </div>
    <div class="title">
        <span>交通</span>
    </div>
    <div class="right-container clearfix">
        <div class="type gray">
                    <div class="clearfix">
                            <p id="toback" class="shadow">往返</p>
                    </div> 
                    <dl class="ldt_tcil_content clearfix">
                        <dt>
                            <em>出发：</em>
                        </dt>
                        <dd>
                            <p>
                                ${sumDepFlightInfos[0].departureCityName}
                            </p>

                            <p>
                                ${sumDepFlightInfos[0].departureDate}
                            </p>
                        </dd>
                    </dl>
                    <dl class="ldt_tcil_content clearfix">
                        <dt><em>返回：</em></dt>
                        <dd>
                            <p>
                                ${sumArvFlightInfos[0].departureCityName}
                            </p>

                            <p>
                                ${sumArvFlightInfos[0].departureDate}
                            </p>
                        </dd>
                    </dl>
                    <!-- TODO add end -->
                </div>
        <div class="detail">
                 <ul class="ldt_tci_center">
                            <!--不含中转 开始--> 
								<li class="ldt_tcic_info ldt_tcic_info_first clearfix">

                                <div class="ldt_tcici_icon">
                                    <span class="ldt_tcici_icon_go">去</span>
                                </div>
                                <div class="ldt_tcici_clock">
                                    <b>${sumDepFlightInfos[0].departureTime?substring(11, 16)}</b>
                                    <b>${sumDepFlightInfos[0].arrivalTime?substring(11, 16)}</b>
                                </div>
                                <div class="ldt_tcici_fromto">
                                    <p>${sumDepFlightInfos[0].departureAirportName}
                                    </p>
                                    <p></p>
                                </div>
                                <div class="ldt_tcici_time">
                                        ${sumDepFlightInfos[0].flyTime}
                                </div>
                                <div class="ldt_tcici_company">
                                    ${sumDepFlightInfos[0].carrierName}<br>
                                    ${sumDepFlightInfos[0].flightNo}
                                </div>
                                <div class="ldt_tcici_type">
                                        ${sumDepFlightInfos[0].seats[0].seatClassTypeName}  
                                </div>
                                     </li></ul>
                       <ul class="ldt_tci_center">
								<li class="ldt_tcic_info ldt_tcic_info_first clearfix">
								<div class="ldt_tcici_icon">
								<span class="ldt_tcici_icon_go">返</span>
								</div>
								<div class="ldt_tcici_clock">
                                    <b>${sumArvFlightInfos[0].departureTime?substring(11, 16)}</b>
                                    <b>${sumArvFlightInfos[0].arrivalTime?substring(11, 16)}</b>
                                </div>
                                <div class="ldt_tcici_fromto">
                                    <p>${sumArvFlightInfos[0].departureAirportName}
                                    </p>
                                    <p></p>
                                </div>
                                <div class="ldt_tcici_time">
                                        ${sumArvFlightInfos[0].flyTime}
                                </div>
                                <div class="ldt_tcici_company">
                                    ${sumArvFlightInfos[0].carrierName}<br>
                                    ${sumArvFlightInfos[0].flightNo}
                                </div>
                                <div class="ldt_tcici_type">
                                        ${sumArvFlightInfos[0].seats[0].seatClassTypeName}  
                                </div>
							</li>
					  </ul>
                          
                        <!-- TODO add end -->
                        <div class="default">
                            <div class="adjust-traffic-item adjust-product-item" data-price="58" data-item-id="1">
                                <div class="adjust-traffic-item-type">
                                    <span></span>
                                </div>
                                <div class="adjust-traffic-item-price">
                        <span class="price">

                        </span>
                                </div>
                                <div class="adjust-traffic-item-price">
                        <span class="price">
                            <select class="lvmama-price-flag" data-price-1="105000" hidden="hidden">
                                <option value="1">1</option>
                            </select>
                        </span>
                                </div> 
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
					<div class="replace">
						<button class="replace-button flight-replace-button">更换其他交通</button>
					</div> 
    </div>
</div>
 
</div>
<!-- 交通模板结束 -->

<!-- 更换交通版块  开始 -->
<div class="traffic_change" id="traffic_change">
    <span class="traffic_tab_tips"><i class="tip-icon tip-icon-warning"></i>所有航班起抵时间均为当地时间（24小时制）</span>
    <!-- 自由组合   开始 -->
    <ul class="traffic_tab">
        <li class="active">自由组合</li>
    </ul>
    <div>
        <!-- 已选去程   开始-->
        <div class="fh_qu_box" id="fh_qu_box" style="display:none">
            <div class="fh_qu_l">
                <i class="line_icon_qu">去</i>
                已选去程<br>
                ${sumDepFlightInfos[0].departureDate?substring(5, 10)}<small>（${sumDepFlightInfos[0].weekOfDate}）</small>
            </div>
            <ul class="info_ul">
                <li class="info_li2"></li>
                <li class="info_li3"></li>
                <li class="info_li4"></li>
                <li class="info_li5"></li>
                <li class="info_li6"></li>
                <li class="info_li7"></li>
                <li class="info_li8"><span id="toFliBtn" class="btn btn-small btn-pink">重选去程</span></li>
            </ul>
        </div><!-- 已选去程   结束-->

        <!-- 去程 开始-->
        <div id="dep_fli_box">
            <div class="fh_filter_box">
                <div class="fh_filter_t">
                    <span id="backFliBtn" class="btn btn-small btn-pink">只更换返程</span>
                    选择去程：${sumDepFlightInfos[0].departureCityName}<i></i>${sumArvFlightInfos[0].departureCityName}　${sumDepFlightInfos[0].departureDate}
                    <small>（${sumDepFlightInfos[0].weekOfDate}）</small>
                </div>
                <div class="tt-filter">
                    <div class="search_sort clearfix">
                        <div class="search_list clearfix">
                            <div class="search_theme">航空公司</div>
                            <dl class="search_theme_list clearfix carrierCodeDl">
                                <dt><a class="selected no_limit" href="javascript:;">不限</a></dt>
                                <dd>
                                    <#list toCarrierCode.fields as val>
                                    <span class="navListSpan">
                                        <a href="javascript:;"><i data-code="${val.fieldValue}"></i>${val.fieldDesc}</a>
                                    </span>
                                    </#list>
                                </dd>
                            </dl>
                        </div>
                        <div class="search_list clearfix">
                            <div class="search_theme">起飞时段</div>
                            <dl class="search_theme_list clearfix depSegmentDl">
                                <dt><a href="javascript:;" class="selected no_limit">不限</a></dt>
                                <dd>
                                    <#list toDepTime.fields as val>
                                    <span class="navListSpan">
                                        <a href="javascript:;"><i data-code="${val.fieldValue}"></i>${val.fieldDesc?replace(",", " ")}</a>
                                    </span>
                                    </#list>
                                </dd>
                            </dl>
                        </div>
                        <div class="search_list clearfix">
                            <div class="search_theme">舱位等级</div>
                            <dl class="search_theme_list clearfix seatClassTypeDl">
                                <dt><a class="selected no_limit" href="javascript:;">不限</a></dt>
                                <dd>
                                    <#list toSeatClassType.fields as val>
                                    <span class="navListSpan">
                                        <a href="javascript:;"><i data-code="${val.fieldValue}"></i>${val.fieldDesc}</a>
                                    </span>
                                    </#list>
                                </dd>
                            </dl>
                        </div>
                    </div>
                </div>
            </div>

            <p class="fh_all_tips">共<span>${sumDepFlightInfos?size}</span>条航班信息</p>

            <div class="zuhe_traffic_list">
                <div class="traffic_list_t">
                    <ul class="traffic_info_list">
                        <li class="info_li1"></li>
                        <li class="info_li2">航班信息</li>
                        <li class="info_li3 sort_btn <#if toSortRule.sortRuleType?string == 'SORT_BY_DEPTIME_ASC'>sort_active</#if>">当地起飞时间<i></i></li>
                        <li class="info_li4"></li>
                        <li class="info_li5">当地降落时间</li>
                        <li class="info_li6">飞行时长</li>
                        <li class="info_li7">舱位</li>
                        <li class="info_li8 sort_btn <#if toSortRule.sortRuleType?string == 'SORT_BY_PRICE_ASC'>sort_active</#if>"">差价<i></i></li>
                        <li class="info_li9"></li>
                    </ul>
                </div>
                <!-- 航班列表  开始 -->
                <div class="traffic_list_b" id="dep_traffic_list">
                <#include "detail/item/flight_list/to_flight_list.ftl">
                </div>
                <!-- 航班列表  结束 -->
            </div>
        </div>
        <!-- 去程 结束-->

        <!-- 返程开始 -->
        <div id="arv_fli_box" style="display:none">
            <div class="fh_filter_box">
                <div class="fh_filter_t">
                    选择返程：${sumArvFlightInfos[0].departureCityName}<i></i>${sumDepFlightInfos[0].departureCityName}　${sumArvFlightInfos[0].departureDate}
                    <small>（${sumArvFlightInfos[0].weekOfDate}）</small>
                </div>
                <div class="tt-filter">
                    <div class="search_sort clearfix">
                        <div class="search_list clearfix">
                            <div class="search_theme">航空公司</div>
                            <dl class="search_theme_list clearfix carrierCodeDl">
                                <dt><a class="selected no_limit" href="javascript:;">不限</a></dt>
                                <dd>
                                    <#list backCarrierCode.fields as val>
                                    <span class="navListSpan">
                                        <a href="javascript:;"><i data-code="${val.fieldValue}"></i>${val.fieldDesc}</a>
                                    </span>
                                    </#list>
                                </dd>
                            </dl>
                        </div>
                        <div class="search_list clearfix">
                            <div class="search_theme">起飞时段</div>
                            <dl class="search_theme_list clearfix depSegmentDl">
                                <dt><a href="javascript:;" class="selected no_limit">不限</a></dt>
                                <dd>
                                    <#list backDepTime.fields as val>
                                    <span class="navListSpan">
                                        <a href="javascript:;"><i data-code="${val.fieldValue}"></i>${val.fieldDesc?replace(",", " ")}</a>
                                    </span>
                                    </#list>
                                </dd>
                            </dl>
                        </div>
                        <div class="search_list clearfix">
                            <div class="search_theme">舱位等级</div>
                            <dl class="search_theme_list clearfix seatClassTypeDl">
                                <dt><a class="selected no_limit" href="javascript:;">不限</a></dt>
                                <dd>
                                    <#list backSeatClassType.fields as val>
                                    <span class="navListSpan">
                                        <a href="javascript:;"><i data-code="${val.fieldValue}"></i>${val.fieldDesc}</a>
                                    </span>
                                    </#list>
                                </dd>
                            </dl>
                        </div>
                    </div>
                </div>
            </div><!-- 筛选条件 结束-->

            <p class="fh_all_tips">共<span>${sumArvFlightInfos?size}</span>条航班信息</p>

            <div class="zuhe_traffic_list">
                <div class="traffic_list_t">
                    <ul class="traffic_info_list">
                        <li class="info_li1"></li>
                        <li class="info_li2">航班信息</li>
                        <li class="info_li3 sort_btn <#if backSortRule.sortRuleType?string == 'SORT_BY_DEPTIME_ASC'>sort_active</#if>"">当地起飞时间<i></i></li>
                        <li class="info_li4"></li>
                        <li class="info_li5">当地降落时间</li>
                        <li class="info_li6">飞行时长</li>
                        <li class="info_li7">舱位</li>
                        <li class="info_li8 sort_btn <#if backSortRule.sortRuleType?string == 'SORT_BY_PRICE_ASC'>sort_active</#if>">差价<i></i></li>
                        <li class="info_li9"></li>
                    </ul>
                </div>
                <!-- 航班列表  开始 -->
                <div class="traffic_list_b" id="arv_traffic_list">
                <#include "detail/item/flight_list/back_flight_list.ftl">
                </div>
                <!-- 航班列表  结束 -->
            </div>
        </div>
        <!-- 返程结束-->
    </div>
    <!-- 自由组合   结束 -->
</div>

<!-- 更换交通版块  结束 -->
<!--弹出航班信息-->
<table class="fh_type_box">
    <tr>
        <th>计划机型</th>
        <th>机型名称</th>
        <th>类型</th>
        <th>最少座位数</th>
        <th>最多座位数</th>
    </tr>
    <tr id="airlineTr">
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
</table>
