<style>
    .btn-stop {
        height: 40px;
        padding: 0 26px;
        background: #f80;
        border-color: #f80;
        color: #fff;
        font: normal 18px/40px "Microsoft Yahei";
    }
    .btn-stop:hover {
        background: #f80;
        color: #fff;
        cursor: default;
    }
</style>

    <!-- 顶部产品概览结束 -->
    <div id="preorder-height-holder" class="preorder-height-holder">
        <!-- 订单基本配置开始 -->
        <div class="product-preorder clearfix color-style1" id="product-preorder">
            <div class="clearfix">
                <div class="preorder-config">
                    <div class="preorder-input-group chrome-hack-1">
                        <input class="preorder-start-time" id="preorder-start-time" type="hidden" placeholder="请选择出行日期" autocomplete="off">
                        <span class="chrome-hack-2">出行日期：</span>

                        <#if basicInfo.bizCategoryId == 18>
                        <div class="cxrq">请选择出行日期</div>
                        <input class="preorder-start-time" id="preorder-start-time" type="hidden" placeholder="请选择出行日期" autocomplete="off">
                        <input id="selected-saled-price" type="hidden" >
                        <input id="selected-saled-child-price" type="hidden" >

                        <select class="selectModel_freetour" style="display:none"></select >
                        </#if>

                        <#if basicInfo.bizCategoryId == 15>
                        <select id="playtime" class="selectModel" name="playtimeQuantity">
                            <option>请选择出行时间</option>
                        </select>
                        </#if>
                    </div>
                    <div class="preorder-input-group">
                        <span>成人：</span>
                        <#if basicInfo.bizCategoryId == 15 || (basicInfo.bizCategoryId == 18 && packagedProdCatId!=17)>
                            <select id="adult-count" class="adult-count selectModel" data-class="selectbox-mini"  name="adultQuantity">
                                <#list adultMinQuantity..adultMaxQuantity as num>
                                	<#if num=='2'>
                                		<option value="${num}" selected="selected">${num}</option>
                                	<#else>
                                		<option value="${num}">${num}</option>
                                	</#if>
                                </#list>
                            </select>
                            <input type="hidden" id="adultQuantity" name="adultQuantity" value="2">
                        </#if>
                        <#if basicInfo.bizCategoryId == 18 && packagedProdCatId==17>  
							<span id="adult-count-span">${basicInfo.adultQuantity}</span>
							<input type="hidden" id="adultQuantity" name="adultQuantity" value="${basicInfo.adultQuantity}"> 
                        </#if>
						<input type="hidden" id="packagedProdCatId" name="packagedProdCatId" value="${packagedProdCatId}"> 
                    </div>
                    <div class="preorder-input-group">
                        <span>儿童：</span>
                        <#if basicInfo.bizCategoryId == 15 || (basicInfo.bizCategoryId == 18 && packagedProdCatId!=17)>
                        <select id="children-count" class="children-count" data-class="selectbox-mini" name="childQuantity">
                            <#list childMinQuantity..childMaxQuantity as num>
                            <option value="${num}">${num}</option>
                            </#list>
                        </select>
						 <input type="hidden" id="childMaxQuantity" name="childMaxQuantity" value="${childMaxQuantity}">
						  <input type="hidden" id="childMinQuantity" name="childMinQuantity" value="${childMinQuantity}">
						 <input type="hidden" id="childQuantity" name="childQuantity" value="${childMinQuantity}">
                        </#if>
                       <#if basicInfo.bizCategoryId == 18 && packagedProdCatId==17>   
							<span id="child-count-span">${basicInfo.childQuantity}</span>
							 <input type="hidden" id="childQuantity" name="childQuantity" value="${basicInfo.childQuantity}">
						</#if>  
                    </div>
                    <#if basicInfo.bizCategoryId == 18 && packagedProdCatId==17> 
						<div class="preorder-input-group">
							<span>份数：</span>
							<select id="preorder-quantity" data-hidden="Y" data-class="selectbox-mini" name="quantity" onchange="changeQuantity(this.value);">
								<#list 1..maxQuantityLimit as num>
								<option value="${num}">${num}</option>
								</#list>
							</select>
						</div> 
                    </#if>

                    <#if basicInfo.childPriceDesc??>
                    <div class="preorder-smap fl">
                        <span class="pro_price_tips"><samp class="js_tips" tip-content="${basicInfo.childPriceDesc}">儿童价标准</samp></span>
                    </div>
                    </#if>

                </div>
                <div class="preorder-confirm">
                    <a id="preorder-booking-button" class="btn cbtn-orange1 fr ml20">开始预订</a>
                    <div class="preorder-total-price">
                        <span class="tip-icon tip-icon-help js_tips" style="display:none" id="DuiJie_TraffocTip" tip-content="机票价格更新频繁，以实际支付为准，为避免价格波动，请您尽快预订；"></span>
                        <span class="total-price-value" id="total-price-value">--</span>
                        <span class="total-price-symbol rmb-symbol">&yen;</span>
                        <span class="total-price-title">总价：</span>
                        <span class="fangcha" style="display:none;"></span>
                        <div class="fr mr20"><span class="pro_price_tips booking_tips"><i class="group_icon icon_wenhao_blue"></i><samp class="js_tips">如何预订</samp></span></div>

                    </div>
                </div><!-- //preorder-confirm -->
            </div>
        </div>

        <!-- 预订详细配置开始 -->
        <div id="preorder-adjust" class="preorder-adjust">
            <div id="loading-data-status"></div>
        </div>
        <!-- 预订详细配置结束 -->
    </div>

<script> 
  //点击开始预订 弹出日历框
 $("#preorder-booking-button").bind("click", function(event){
     event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);

     if ($("#preorder-booking-button").hasClass("btn-stop")) {
         return;
     }
     if ('${isNotPreview}' == 'true' && '${isCanBooking}' == 'true') {
         if ($("#selectDate").val() == "" || $("#noGoodsFlag").val() == "true" || $("#noGoodsFlag").val() == "") {
             $("#playtimeUl").parents(".selectbox-drop").show();
             $("#playtimeUl").parents(".selectbox").addClass("selectbox-active").addClass("active");
             $(".canderBox").addClass("redBorder");
             $(".canderBox").append("<span class=\"selectTimeTip\"><i class=\"group_icon icon_selectTimeTip\"></i>请选择日期</span>");
             return;
         } else {
             var _path = _data._contextPath + "/order/toBooking?shoppingUuid=" + $("#shoppingUuid").val()
                     + "&productId=" + $("#productId").val() + "&bizCategoryId=" + $("#bizCategoryId").val();
             window.location.href = _path;
         }
     } else {
         return;
     }
 });


// 获得价格
function initPriceInBaseInfo(){ 
	  $.ajax({
          type: "post",
          dataType: "json",
          url: _data._contextPath+"/calucateAmount",
          data: {
        	  shoppingUUID: $("#shoppingUuid").val()
          },
          success: function(obj) {
              $("#preorder-booking-button").removeClass("btn-stop");
              $("#preorder-booking-button").addClass("cbtn-orange1");
        	  $("#total-price-value").html(obj.result.totalAmount);
              var $facha = $("#total-price-value").siblings(".fangcha");
              $facha.html("(含房差<dfn>￥</dfn>" + obj.result.roomDiffAmount +")");
              if (obj.result.roomDiffAmount > 0) {
                  $facha.show();
              } else {
                  $facha.hide();
              }
          },
          error: function () {
              $("#preorder-booking-button").addClass("btn-stop");
              $("#preorder-booking-button").removeClass("cbtn-orange1");
          }
      });
};

// 保存到购物车
function saveToCache(obj, type) { 
    var reqData = {};
    reqData.shoppingUuid = $("#shoppingUuid").val();

    var suppGoodsId = obj.parents(".adjust-product-item").attr("data-suppgoodsid");
    if (suppGoodsId) {
        reqData.suppGoodsId = suppGoodsId;
    }
    reqData.selectCount = obj.val();
    reqData.productType = type;

    var $item = obj.parents(".optional-insurance-item");
    var $priceSpan = $item.find(".optional-insurance-single-price .price");
    var price = $priceSpan.find("span").text();

    reqData.selectPrice = price;
    if (type == "I_OTHER_TICKET") {
        var date = obj.parents(".optional-insurance-quantity").siblings(".optional-insurance-single-price").find(".optional-ticket-select-date").val();
        reqData.selectDate = date;
    }

    $.ajax({
        type: "post",
        dataType: "json",
        url:  _data._contextPath+"/saveToCache",
        data: reqData,
        success: function(data) {
            if (data) {
                initPriceInBaseInfo();
            }
        }
    });
}
</script>
