<#if hotelCombos??>
<div class="adjust-item clearfix">
    <div class="title">
        <span>酒店<br>套餐</span>
    </div>
    <div class="right-container clearfix">
        <div class="type gray">
            <p>${hotelCombos[0].travelDays}天${hotelCombos[0].stayDays}晚</p>
            <p>第${hotelCombos[0].dayOfDuration}天</p>
            <p>${hotelCombos[0].startDay?string('yyyy-MM-dd')}</p>
        </div>
        <div class="detail">
            <div class="item-name">
                <a target="_Blank" href="http://dujia.lvmama.com/package/${hotelCombos[0].productId}">${hotelCombos[0].productName}</a>
            </div>
            <#list hotelCombos as branch>
            <div id="hotelCombo-${branch.suppGoodsId}" <#if branch.isBeSelected == "Y">class="default"<#else>class="other"</#if> >
                <div class="hotel-package-item adjust-product-item">
                    <div class="optional-addition-item-name item-name">
                        <span class="toggle-detail">
                            ${branch.branchName}
                            <i class="arrow"></i>
                        </span>
                    </div>
                    <div class="package-item-quantity">
                        <select class="lvmama-price-flag">
                            <option value="${branch.quantity}">${branch.quantity}</option>
                        </select> 份
                    </div>
                    <div class="optional-addition-single-price">
                        <span class="price">￥${branch.price}</span>
                    </div>
                    <div class="hotel-package-item-status status">
                        <i class="product-item-checked-icon"></i>
                    </div>

                    <div class="clearfix"></div>
                    <div class="adjust-product-item-detail">
                        <ul>
                            <li class="clearfix">${branch.branchDesc}</li>
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

            <#if hotelCombos?size gt 1>
            <p class="toggle-others toggle-hotelCombo">
                <span>其他套餐</span>
                <i class="arrow arrow-blue-down"></i>
            </p>
            </#if>
        </div>

        <#if hotelCombos?size gt 1>
        <div class="replace">
            <button class="replace-button replace-hotelCombo-btn">更换其他套餐</button>
        </div>
        </#if>
    </div>
</div>

<div class="dialog-content clearfix" data-content="content" id="hotelComboContentDiv" style="display:none">
    <div class="detail">
        <#list hotelCombos as branch>
        <div <#if branch.isBeSelected == "Y">class="default"</#if> >
            ${branch.productName}
            <div class="dialog-item adjust-product-item" data-suppGoodsId="${branch.suppGoodsId}">
                <div class="hotel-package-item-name item-name">
                    <span class="toggle-detail">
                        ${branch.branchName} <i class="arrow"></i>
                    </span>
                </div>
                <div class="package-item-quantity">
                    <select class="lvmama-price-flag">
                        <option value="${branch.quantity}">${branch.quantity}</option>
                    </select> 份
                </div>
                <div class="hotel-package-item-price">
                    <#if branch.isBeSelected != "Y">
                        <#if branch.diffPrice gt 0>
                            <span class="price">${"+ ￥" + branch.diffPrice}</span>
                        <#else>
                            <span class="price">${"- ￥" + -branch.diffPrice}</span>
                        </#if>
                    </#if>
                </div>
                <div class="hotel-package-item-status status">
                    <#if branch.isBeSelected == "Y">
                    <i class="product-item-checked-icon"></i>
                    <#else>
                    <button class="btn btn-mini do-select-action">选择</button>
                    </#if>
                </div>
                <div class="clearfix"></div>
                <div class="adjust-product-item-detail">
                    <ul>
                        <li class="clearfix">
                            <span class="detail-title gray">描述</span>
                            <span class="content">${branch.branchDesc}</span>
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
        </div>
        </#list>
    </div>
</div>
</#if>
<!--酒店套餐-->