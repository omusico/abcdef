<#macro hotelGroupShow groups>  
<div class="yin-hotel-dialog-template" data-groupid="${groups.groupId}"  id="hotelGroupContentDiv${groups.groupId}" >
<#list groups.hotels as hotel> 
		<!-- 更换酒店弹窗 --> 
		<!-- yin-hotel-item 酒店开始 -->
		<div <#if !hotel_has_next> class="yin-hotel-item yin-hotel-item-last"  <#else>class="yin-hotel-item"</#if>  >
			<div class="yhi-basic clearfix">
				<div class="yhib-thumbnail">
					<#if hotel.hotelPhoto && hotel.hotelPhoto != ''>
			            <img src="http://pic.lvmama.com/${hotel.hotelPhoto}" alt="" width="90" height="60"/>
                    <#else>
                        <img src="http://pic.lvmama.com/img/cmt/img_120_60.jpg" alt="" width="90" height="60"/>
                    </#if>
				</div>
				<div class="yhib-info">
					<p class="yhib-hotel-name"><a target="_blank" href="http://hotels.lvmama.com/hotel/${hotel.hotelId}">${hotel.hotelName}</a><span>${hotel.startRate}</span></p>
					<p class="yhib-hotel-location">地址：${hotel.address}</p>
				</div>
			</div>
			<div class="yhi-room-list"> 
				<#list hotel.fangXinList as fangxing> 
					<#if fangxing_index lt 4> 
						 <div class="yhir-room clearfix">
							<div class="yhir-room-item yhir-room-name">
								<a>${fangxing.roomName}</a><i class="arrow"></i>
							</div>
							<div class="yhir-room-item yhir-room-capacity">${fangxing.maxVisitor}人</div>
							<div class="yhir-room-item yhir-room-beds">${(fangxing.bedType)!'&nbsp;'}</div>
							<div class="yhir-room-item yhir-room-wifi">${(fangxing.internet)!'&nbsp;'}</div>
							<div class="yhir-room-item yhir-room-diff" data-diffprice='${fangxing.diffPrice}'><#if fangxing.diffPrice gt 0 > 
					<span a>+</span>￥<span d>${fangxing.diffPrice}</span>
					<#else>
						<#if fangxing.diffPrice == 0 > 
						<span a></span>--<span d></span>
						<#else>
						<span a>-</span>￥<span d>${-fangxing.diffPrice}</span>
						</#if>
					</#if></div>
							<div class="yhir-room-item yhir-room-quantity">
								<#assign min=fangxing.minCount max=fangxing.maxCount> 
								<select data-price-1="${fangxing.price}" roomquantity ispop='1' data-roomCount="${fangxing.roomCount}" data-detailid-suppgoodsid="${fangxing.detailId}-${fangxing.goodsId}" data-type="hotel" class="lvmama-price-flag">
									<#list min..max as x> 
										<#if  fangxing.roomCount==x  >
										<option value="${x}" selected>${x}</option>
										<#else>
										<option value="${x}">${x}</option>
										</#if> 
									</#list>
								</select>
								<span>间</span>
							</div>
							<div class="yhir-room-item yhir-room-opertion" data-hotelid="${fangxing.hotelId}"   data-groupid="${fangxing.groupId}"  data-roomid="${fangxing.roomId}" 
				 data-goodsId="${fangxing.goodsId}">
								<#if fangxing.isBeSelected=='Y'> 
								<i class="product-item-checked-icon"></i>
								<#else>
								 <a hidefocus="false" href="javascript:;" data-hotelid="${fangxing.hotelId}"   data-groupid="${fangxing.groupId}"  data-roomid="${fangxing.roomId}" 
				 data-goodsId="${fangxing.goodsId}"  class="btn btn-mini js_yhir_room_select_btn">选择</a>
								</#if>	
							</div>
							<div class="yhir-room-detail">
								<ul>
									<li class="clearfix">
										<span class="yhir-rd-title">床型</span>
										<span class="yhir-rd-content">${fangxing.bedType}</span>
									</li>
									<li class="clearfix">
										<span class="yhir-rd-title">宽带</span>
										<span class="yhir-rd-content">${fangxing.internet}</span>
									</li>
									<li class="clearfix">
										<span class="yhir-rd-title">描述</span>
										<span class="yhir-rd-content">${fangxing.description}、${fangxing.floor}、${fangxing.area}平米</span>
									</li>
								</ul>
								<p class="yhir-collapse clearfix">
									<span>收起<i class="arrow arrow-blue-up"></i></span>
								</p>
								<div class="yhir-arrow"><span>◆</span><i>◆</i></div>
							</div>
						</div>
						<!--default结束-->
					<#else>
						 <div class="yhir-room clearfix" style="display:none;">
							<div class="yhir-room-item yhir-room-name">
								<a>${fangxing.roomName}</a><i class="arrow"></i>
							</div>
							<div class="yhir-room-item yhir-room-capacity">${fangxing.maxVisitor}人</div>
							<div class="yhir-room-item yhir-room-beds">${fangxing.bedType}</div>
							<div class="yhir-room-item yhir-room-wifi">${fangxing.internet}</div>
							<div class="yhir-room-item yhir-room-diff" data-diffprice='${fangxing.diffPrice}'><span a>+</span><dfn>￥</dfn><span d>${fangxing.diffPrice}</span></div>
							<div class="yhir-room-item yhir-room-quantity">
								<#assign min=fangxing.minCount max=fangxing.maxCount> 
								<select data-price-1="${fangxing.price}" roomquantity ispop='1' data-roomCount="${fangxing.roomCount}" data-detailid-suppgoodsid="${fangxing.detailId}-${fangxing.goodsId}" data-type="hotel" class="lvmama-price-flag">
									<#list min..max as x> 
										<#if  fangxing.roomCount==x  >
										<option value="${x}" selected>${x}</option>
										<#else>
										<option value="${x}">${x}</option>
										</#if> 
									</#list>
								</select>
								<span>间</span>
							</div>
							<div class="yhir-room-item yhir-room-opertion" data-hotelid="${fangxing.hotelId}"   data-groupid="${fangxing.groupId}"  data-roomid="${fangxing.roomId}" 
				 data-goodsId="${fangxing.goodsId}">
								<#if fangxing.isBeSelected=='Y'> 
								<i class="product-item-checked-icon"></i>
								<#else>
								 <a hidefocus="false" href="javascript:;" data-hotelid="${fangxing.hotelId}"   data-groupid="${fangxing.groupId}"  data-roomid="${fangxing.roomId}" 
				 data-goodsId="${fangxing.goodsId}" class="btn btn-mini js_yhir_room_select_btn">选择</a>
								</#if>								
							</div>
							<div class="yhir-room-detail">
								<ul>
									<li class="clearfix">
										<span class="yhir-rd-title">床型</span>
										<span class="yhir-rd-content">${fangxing.bedType}</span>
									</li>
									<li class="clearfix">
										<span class="yhir-rd-title">宽带</span>
										<span class="yhir-rd-content">${fangxing.internet}</span>
									</li>
									<li class="clearfix">
										<span class="yhir-rd-title">描述</span>
										<span class="yhir-rd-content">${(fangxing.description)!'-'}、${(fangxing.floor)!'-'}、${fangxing.area!'-'}平米</span>
									</li>
								</ul>
								<p class="yhir-collapse clearfix">
									<span>收起<i class="arrow arrow-blue-up"></i></span>
								</p>
								<div class="yhir-arrow"><span>◆</span><i>◆</i></div>
							</div>
						</div>
					</#if>
				</#list> 
				<#if  hotel.fangXinList?size  gt 4> 
					<p class="yhir-open-room-list"><span>展开其他房型<i class="arrow"></i></span></p>
				</#if>
			</div>
		</div><!-- //yin-hotel-item 酒店结束 -->

		<!-- yin-hotel-item 酒店开始 最后一个酒店加 yin-hotel-item-last 类--> 
		
		<!-- 加载弹层 START-->
		<div class="ft-overlay"></div>
		<div class="ft-dialog-loading">
			<div class="ft-dialog-inner clearfix">
				<div class="ft-dialog-body">
					<p>驴妈妈拼命加载中，请稍候...</p>
				</div>
			</div>
		</div> 
</#list> 
</div> 
</#macro>