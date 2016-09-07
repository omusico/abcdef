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