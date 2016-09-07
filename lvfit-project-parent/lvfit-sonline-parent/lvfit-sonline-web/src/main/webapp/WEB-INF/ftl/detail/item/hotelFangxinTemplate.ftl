<#macro fangXinTemplate fangxing isSelected showType>
	<div  data-type="hotel" class="hotel-item adjust-product-item" data-roomid="${fangxing.roomId}" 
		data-hotelid="${fangxing.hotelId}"  data-groupId="${fangxing.groupId}" data-diffPrice="${fangxing.diffPrice}"
		data-goodsId="${fangxing.goodsId}">

			<div class="hotel-item-name">
				<span class="toggle-detail">
					${fangxing.roomName}
					<i class="arrow"></i>
				</span>
			</div>
			<div class="hotel-item-capacity">
				<span>
					 ${fangxing.maxVisitor}人
				</span>
			</div>
			<div class="hotel-item-number-of-beds">
				<span>${fangxing.bedType}</span>
			</div>
			<div class="hotel-item-internet">
				<span>${fangxing.internet}</span>
			</div>
			<div class="hotel-item-price">
				<span class="price">
					<#if fangxing.diffPrice gt 0 > 
					<span a>+</span>￥<span d>${fangxing.diffPrice}</span>
					<#else>
						<#if fangxing.diffPrice == 0 > 
						<span a></span>--<span d></span>
						<#else>
						<span a>-</span>￥<span d>${-fangxing.diffPrice}</span>
						</#if>
					</#if>
				</span>
			</div>
			<div class="hotel-item-quantity">
				<#assign min=fangxing.minCount max=fangxing.maxCount> 
				<select data-price-1="${fangxing.price}" roomquantity ispop='0'  data-detailid-suppgoodsid="${fangxing.detailId}-${fangxing.goodsId}" data-type="hotel" 
				data-roomcount="${fangxing.roomCount}" class="lvmama-price-flag">  
				<#list min..max as x> 
					<#if  fangxing.roomCount==x  >
					<option value="${x}" selected>${x}</option>
					<#else>
					<option value="${x}">${x}</option>
					</#if>
				</#list>
				</select>
				间
			</div>
			<div class="adjust-product-item-status status">
				<#if fangxing.isBeSelected=='Y'> 
				<i class="product-item-checked-icon"></i>
				<#else>
				 <button data-changetype="hotel" data-hotelid="${fangxing.hotelId}"   data-groupid="${fangxing.groupId}"  data-roomid="${fangxing.roomId}" 
				 data-suppgoodsid="${fangxing.goodsId}" class="btn btn-mini do-select-action">
				选择
				</button>
				</#if>	 
			</div>
			<div class="clearfix"></div>
			<div class="adjust-product-item-detail" >
				<ul>
					<li class="clearfix">
						<span class="detail-title gray">床型</span>
						<span class="content">${fangxing.bedType}</span>
					</li>
					<li class="clearfix">
						<span class="detail-title gray">宽带</span>
						<span class="content">${fangxing.internet}</span>
					</li>
					<li class="clearfix">
						<span class="detail-title gray">描述</span>
						<span class="content">${fangxing.description}</span>
					</li>
				</ul>
				<p class="collapse-detail clearfix">
					<span>
						收起
						<i class="arrow arrow-blue-up"></i>
					</span>
				</p>
				<div class="info_arrow"><span>◆</span><i>◆</i></div>
			</div>
		</div> 
</#macro>