<#import "/detail/item/hotelFangxinTemplate.ftl" as hotelFangxinTemplate>
<#import "/detail/item/hotelPopHotels.ftl" as hotelPop>
<#if hotelGroups?exists && hotelGroups?size gt 0>
<#list hotelGroups as groups>
		<input name="groupId" type="hidden" value="${groups.groupId}" data-leastPrice="${groups.leastPrice}" >
		<#list groups.hotels as hotel>
		<#if hotel.isBeSelected=='Y'>
		<!--酒店 START-->
		<div id="adjust-hotel" class="adjust-hotel">
			<div id="${hotel.groupId}_${hotel.hotelId}" class="adjust-item clearfix">
				<div data-quantity="1"   data-travelDays="${hotel.travelDays}" data-checkin="${hotel.checkIn}"  data-dayOfDuration="${hotel.dayOfDuration}"
				data-checkOut="${hotel.checkOut}"  data-groupId="${hotel.groupId}"
				data-routerelation="HOTEL" data-mainitem="MAIN" data-goodtype="hotel"
				data-type="hotel"
				class="need-submit-data params-hotel-${hotel.groupId}-${hotel.hotelId}"></div>
				<div class="title">
					<span>酒店</span>
				</div>
				<div class="right-container right-container-first clearfix">
					<div class="type gray">
						<p>入住${hotel.startDays}晚</p>
						<p><span class="hotel-margin">入住</span>${hotel.checkIn}</p>
						<p><span class="hotel-margin">离店</span>${hotel.checkOut}</p>
					</div>
					<div class="detail">
						<div class="detail-top clearfix">
							<div class="thumbnail">
								<#if hotel.hotelPhoto && hotel.hotelPhoto != ''>
			                        <img src="http://pic.lvmama.com/${hotel.hotelPhoto}" />
			                    <#else>
			                        <img src="http://pic.lvmama.com/img/cmt/img_120_60.jpg" />
			                    </#if>
							</div>
							<div class="spot">
								<p class="name">
									<a target="_blank" href="http://hotels.lvmama.com/hotel/${hotel.hotelId}">${hotel.hotelName}</a>
								</p>
								<p class="address gray">地址：${hotel.address}</p>
							</div>
						</div>
						<div class="default">
							<#list hotel.fangXinList as fangXin>
								<#if fangXin.isBeSelected=='Y'>
									<div class="default defaultFangxing">
										<input name="setGroupId" type="hidden" value="${hotel['groupId']}">
										<input name="setSuppGoodsId" type="hidden" value="${fangXin.goodsId}">
										<input name="setDefaultQuantity" type="hidden" value="${fangXin.maxVisitor}">
										<input name="setDetailId" type="hidden" value="${fangXin.detailId}">
										<@hotelFangxinTemplate.fangXinTemplate  fangXin 'true' 'default'/>
									</div>
									<!--default结束-->
								<#else>
									<div class="otherFangxing" style="display:none">
										<input name="setGroupId" type="hidden" value="${hotel['groupId']}">
										<input name="setSuppGoodsId" type="hidden" value="${fangXin.goodsId}">
										<input name="setDefaultQuantity" type="hidden" value="${fangXin.maxVisitor}">
										<input name="setDetailId" type="hidden" value="${fangXin.detailId}">
										<@hotelFangxinTemplate.fangXinTemplate  fangXin 'true' 'default'/>
									</div>
								</#if>
							</#list>

							<#if hotel.fangXinList?? && hotel.fangXinList?size gt 1>
								<p style=" cursor: pointer; color: #09C;padding-top: 10px;" onclick="otherFangxing(this)">
									<span>展开其他房型</span>
									<i class="arrow arrow-blue-down">
									</i>
								</p>
						   </#if>
						</div>


					</div>
					<#if groups.hotels?size gt 1>
					<div class="replace">
						<button class="replace-button yin-dialog-change-hotel" group_id="${hotel.groupId}">更换其他酒店</button>
					</div>
					</#if>
				</div>
			</div>
		</div>
		</#if>
		<!--酒店 END-->
 </#list>
</#list>
</#if>

<#list hotelGroups as groups>
	 <@hotelPop.hotelGroupShow  groups  />
</#list>

<!--
<link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/line/detail/product-detail-group.css,/styles/public/detail_sale.css">
   -->

<script>

	
</script>