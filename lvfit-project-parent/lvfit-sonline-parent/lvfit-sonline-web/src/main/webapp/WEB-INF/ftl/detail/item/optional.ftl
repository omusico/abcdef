<div class="adjust-item clearfix adjust-item-optional"> 
	<#assign notsetkexuan=0 />
	<#if roomDiff?? && roomDiff.roomDiffPrice gt 0> 
    <div class="title">
        <span>可选<br>服务</span>
    </div>  
	<#assign notsetkexuan=1 />
	</#if>
	
	<#if notsetkexuan==0> 
		<#if otherTicketMap?size gt 0>
		<div class="title">
			<span>可选<br>服务</span>
		</div>  
		<#assign notsetkexuan=1 />
		</#if>
	</#if>
	
	<#if notsetkexuan==0> 
		<#if insProducts?size gt 0>
			<div class="title">
				<span>可选<br>服务</span>
			</div>  
			<#assign notsetkexuan=1 />
		</#if>
	</#if>
	
    <#if roomDiff?? && roomDiff.roomDiffPrice gt 0> 
    <div id="adjust-optional-addition">
        <div class="right-container clearfix">
            <div class="type gray">
                <p class="shadow">附加</p>
            </div>
            <div class="detail detail-item">
                <div id="fangchaDiv">
                    <div class="other optional-addition-other fangchaDivContent">
                        <div data-type="optionalAddition" class="optional-insurance-item adjust-product-item">
                            <div class="optional-addition-item-name">
                                房差
                                <span><i class="group_icon icon_wenhao_blue"></i><em class="fc-tip" tip-content="因旅游过程中的住宿安排是两个床位的标准间，团费中是根据1名成人占1张床计算的。如出游人数（成人）为单数时，需要补足另外一个人床位的费用。如在实际旅游过程中能够安排3人间或同性拼房，所付房差费用回团后将根据实际发生情况减免退回。">说明</em></span>
                            </div>
                            <div class="optional-insurance-single-price">
                                <span class="singlePrice-fangcha price">￥<span>${roomDiff.roomDiffPrice}</span></span>
                            </div>
                            <div class="optional-addition-quantity">
                                <select id="rommDiffSelect" class="addtion-change-quantity" data-type="ROOM_DIFF">
                                <#if adultQuantity % 2 == 0>
                                    <#list 0..adultQuantity as num>
                                    <#if num_index % 2 == 0>
                                    <option value="${num}">${num}</option>
                                    </#if>
                                    </#list>
                                <#else>
                                    <#list 1..adultQuantity as num>
                                    <#if num_index % 2 == 0>
                                    <option value="${num}">${num}</option>
                                    </#if>
                                    </#list>
                                </#if>
                                </select> 份
                            </div>
                            <div class="optional-insurance-total-price">
                                <span class="total-price price"><#if adultQuantity % 2 == 0>--<#else>￥${roomDiff.roomDiffPrice}</#if></span>
                            </div>
                            <div data-multiple-select="true" class="optional-item-status status product-upgrade-operator">
                                <i <#if adultQuantity % 2 != 0>class="product-item-checked-icon"</#if> ></i>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </#if>

    <!-- 可选服务附加选项模板开始 -->
    <#if otherTicketMap?size gt 0>
    <div class="right-container clearfix">
        <div class="type gray">
            <p class="shadow">
                其它票
            </p>
        </div>
        <div class="detail detail-item">
            <#list otherTicketMap?keys as key>
            <div class="insurance-detail-item insurance-detail-item_insurance">
                <div class="detail-top clearfix">
                    <div class="spot">
                        <p class="name gray">
                            <a rel="nofollow" target="_blank" href="http://ticket.lvmama.com/p-${key}">${otherTicketMap[key][0].productName}</a>
                        </p>
                    </div>
                </div>
                <#list otherTicketMap[key] as item>
                <div <#if item_index != 0>class="other" <#else> class="default" </#if>>
                    <div class="optional-insurance-item adjust-product-item" data-suppgoodsid="${item.suppGoodsId}">
                        <div class="optional-insurance-item-name item-name">
                            ${item.goodsName}
                        </div>
                        <div class="optional-insurance-single-price">
                            <div class="price_day">
                                <select class="optional-ticket-select-date">
                                    <#list item.priceMap?keys as date>
                                    <option value="${date}" data-price="${item.priceMap[date]?string}">${date}</option>
                                    </#list>
                                </select>
                            </div>
                            <span class="price">￥<span>${item.defaultSelectPrice}</span></span>
                        </div>
                        <div class="optional-insurance-quantity">
                            <select class="addtion-change-quantity" data-type="OTHER_TICKET">
                                <#list 0..totalQuantity as quantity>
                                <option value="${quantity}">${quantity}</option>
                                </#list>
                            </select> 份
                        </div>
                        <div class="optional-insurance-total-price">
                            <span class="total-price price">--</span>
                        </div>
                        <div class="optional-item-status status product-upgrade-operator">
                            <i></i>
                        </div>

                        <div class="clearfix"></div>
                    </div>
                </div>
                </#list>
                <#if otherTicketMap[key]?size gt 1>
                <div>
                    <p data-toggle-text="insurance" class="toggle-others">
                            <span>展开其它</span>其它票
                        <i class="arrow arrow-blue-down"></i>
                    </p>
                </div>
                </#if>
            </div>
            </#list>
        </div>
    </div>
    </#if>
    <!-- 可选服务附加选项模板开始 -->
    <#if insProducts?size gt 0>
    <div class="right-container clearfix">
        <div class="type gray">
            <p class="shadow">保险</p>
        </div>
        <div class="detail detail-item">
            <#list insProducts as insProduct>
            <div class="insurance-detail-item insurance-detail-item_insurance">
                <div class="detail-top clearfix">
                    <div class="spot">
                        <p class="name gray">
                            ${insProduct.productName}
                        </p>
                    </div>
                </div>
                <#list insProduct.insBranches as item>
                <div <#if item_index != 0>class="other" <#else> class="default" </#if> >
                    <div class="optional-insurance-item adjust-product-item" data-suppgoodsid="${item.suppGoodsId}">
                        <div class="optional-insurance-item-name item-name">
                            <span class="toggle-detail">
                                ${item.branchName} ${item.goodsName}
                                <i class="arrow"></i>
                            </span>
                        </div>
                        <div class="optional-insurance-single-price">
                            <span class="price">￥<span>${item.price}</span></span>
                        </div>
                        <div></div>
                        <div class="optional-insurance-quantity">
                            <select class="addtion-change-quantity insCountSelect" data-type="INSURANCE">
                                <option value="0">0</option>
                                <option value="${totalQuantity}" <#if insProduct_index == 0 && item_index==0 >selected="selected"</#if> >${totalQuantity}</option>
                            </select> 份
                        </div>
                        <div class="optional-insurance-total-price">
                            <span class="total-price price">
                            <#if insProduct_index == 0 && item_index==0 >
                            ￥${item.price * totalQuantity}
                            <#else>
                            --
                            </#if>
                            </span>
                        </div>
                        <div class="optional-item-status status product-upgrade-operator">
                            <i <#if insProduct_index == 0 && item_index==0 >class="product-item-checked-icon"</#if> ></i>
                        </div>

                        <div class="clearfix"></div>
                        <div class="adjust-product-item-detail">
                            <ul>
                                <li class="clearfix">${item.branchDesc}</li>
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
                </div>
                </#list>
                <#if insProduct.insBranches?size gt 1>
                <p data-toggle-text="insurance" class="toggle-others">
                    <span>展开</span>其它保险
                    <i class="arrow arrow-blue-down"></i>
                </p>
                </#if>
            </div>
            </#list>
        </div>
    </div>
    </#if>
</div>