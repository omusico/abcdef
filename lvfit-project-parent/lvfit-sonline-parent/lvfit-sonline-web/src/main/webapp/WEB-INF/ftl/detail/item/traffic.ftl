<!--自主打包交通-->
<div id="adjust-traffic" class="adjust-item clearfix">
<!-- 交通模板开始 -->
<input type="hidden" id="selectDepFlightNo" name="selectDepFlightNo" value="${sumDepFlightInfos[0].flightNo}"/>
<input type="hidden" id="selectArvFlightNo" name="selectArvFlightNo" value="${sumArvFlightInfos[0].flightNo}"/>
<input type="hidden" id="last_selectDepFlightNo" name="last_selectDepFlightNo" value=""/>
<input type="hidden" id="last_selectArvFlightNo" name="last_selectArvFlightNo" value=""/>
<input type="hidden" id="last_selectSaleType" name="last_selectSaleType" value=""/>
<input type="hidden" id="selectSaleType" name="selectSaleType" value="${sumDepFlightInfos[0].saleType}"/>
<input type="hidden" id="toSortRuleType" name="toSortRuleType" value="${toSortRule.sortRuleType?string}"/>
<input type="hidden" id="backSortRuleType" name="backSortRuleType" value="${backSortRule.sortRuleType?string}"/>

    <!-- 对接往返程的已选择航班 -->
    <#include "detail/item/traffic_free_selected.ftl"> 
 
</div>
<!-- 交通模板结束 -->

<!-- 更换交通版块  开始 -->
<div class="traffic_change" id="traffic_change">
    <span class="traffic_tab_tips"><i class="tip-icon tip-icon-warning"></i>所有航班起抵时间均为当地时间（24小时制）</span>
    <!-- 自由组合   开始 -->
	<#if queryCharsetFlightFlag=='true'>
		<#if charterSize==0 >
		    <ul class="traffic_tab"> 
			  <li class="active">自由组合</li> 
			</ul>	 
			<div class="traffic_type" style="display:block;">
			   <#include "detail/item/traffic_free_pop.ftl">
			</div>  
		<#else>
			<ul class="traffic_tab">
				<li class="active">往返推荐</li>
				<li>自由组合</li>
			</ul>	
			<div class="traffic_type" style="display:block;">
			   <#include "detail/item/traffic_recommend_pop.ftl">
			</div> 	
			<div class="traffic_type">
			   <#include "detail/item/traffic_free_pop.ftl">
			</div>	
		</#if> 
	<#else>
	   <ul class="traffic_tab"> 
		  <li>自由组合</li> 
		</ul>	 
		<div class="traffic_type" style="display:block;">
		   <#include "detail/item/traffic_free_pop.ftl">
		</div>  
	</#if> 
    <!-- 自由组合结束 -->
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
 