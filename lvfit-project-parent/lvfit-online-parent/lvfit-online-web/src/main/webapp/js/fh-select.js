var _shoppingUUID = $("#shoppingUUID").val();

$(function(){
    var uuid = _shoppingUUID;
    var errorMsgOutTime = $("#errorMsgOutTime").val();
    if(errorMsgOutTime!=''){
        var searchCondition = window.localStorage.getItem('searchCondition');
        if(searchCondition != null && searchCondition != ''){
            var tripType = searchCondition.split('|')[0];
            var departureCityCode = searchCondition.split('|')[1];
            var arrivalCityCode = searchCondition.split('|')[2];
            var cityCode = searchCondition.split('|')[3];
            var flightStartDate = searchCondition.split('|')[4];
            var flightEndDate = searchCondition.split('|')[5];
            var hotelStartDate = searchCondition.split('|')[6];
            var hotelEndDate = searchCondition.split('|')[7];
            var adultsCount = searchCondition.split('|')[8];
            var childCount = searchCondition.split('|')[9];
            $("#tripType").val(tripType);
            if(tripType == 'DC'){
                $("#dcButton").trigger("click");
            }else if(tripType == 'WF'){
                $("#wfButton").trigger("click");
            }

            $("#departureCityCode").val(departureCityCode);
            for(var i=0;i<allCities.length;i++){
                if(allCities[i].indexOf(departureCityCode)!=-1){
                    var deptCity=allCities[i].split("|")[0];
                    $("#departureCityName").val(deptCity);
                    break;
                }
            }

            $("#arrivalCityCode").val(arrivalCityCode);
            for(var i=0;i<allCities.length;i++){
                if(allCities[i].indexOf(arrivalCityCode)!=-1){
                    var arrvCity=allCities[i].split("|")[0];
                    $("#arrivalCityName").val(arrvCity);
                    break;
                }
            }

            $("#cityCode").val(cityCode);
            for(var i=0;i<allCities.length;i++){
                if(allCities[i].indexOf(cityCode)!=-1){
                    var hotelCity=allCities[i].split("|")[0];
                    $("#hotelCityName").val(hotelCity);
                    break;
                }
            }
            $("#flightStartDate").val(flightStartDate);
            var flightGoDayWeek = getDayOfWeek(flightStartDate);
            $("#flightStartDayOfWeek").text(flightGoDayWeek);

            $("#flightEndDate").val(flightEndDate);
            var flightBackDayWeek = getDayOfWeek(flightEndDate);
            $("#flightEndDayOfWeek").text(flightBackDayWeek);

            $("#hotelStartDate").val(hotelStartDate);
            var hotelGoDayWeek = getDayOfWeek(hotelStartDate);
            $("#hotelStartDayOfWeek").text(hotelGoDayWeek);

            $("#hotelEndDate").val(hotelEndDate);
            var hotelBackDayWeek = getDayOfWeek(hotelEndDate);
            $("#hotelEndDayOfWeek").text(hotelBackDayWeek);
            $("#adultsCount").val(adultsCount);
            $("#adultCountSpan").text(adultsCount);

            $("#childCount").val(childCount);
            $("#childCountSpan").text(childCount);
        }
        $(".returnAlert").show();
        $('.resortOverlay').stop(true,true).show();
        $("#errorMsg").html(errorMsgOutTime);
        var reloadUrl = baseUrl+"/search/"+uuid+"?tripType="+tripType+"&departureCityCode="+departureCityCode+"&arrivalCityCode="+arrivalCityCode+"&departureTime="+flightStartDate+"&returnTime="+flightEndDate+"&cityCode="+cityCode+"&checkInTime="+hotelStartDate+"&checkOutTime="+hotelEndDate+"&adultsCount="+adultsCount+"&childCount="+childCount;
        $('#reloadUrl').val(reloadUrl);
    }

});




$(function(){
    if($(".fh-product-side").length>0){
        var fhProductTop=$(".fh-product-side").offset().top;
        $(window).scroll(function(event){
            var scrollTop=$(window).scrollTop()
            if(scrollTop < fhProductTop) {
                $(".fh-product-side").attr("style","top: 0px");
            }
        });
    }
    $('.searchHot').click(function() {
        $('.JS_select_dest').val($(this).html());
        $('.select-hotel').val($(this).html());
    })
    //设置成人儿童数 start
    var adultNum = $("#adault").text()
    var child =$("#child");
    var adult = $("#adaultOl");
    var childNum = $("#childNum").text()
    resetPeopleList(child, adultNum);
    resetAdultList(adult, childNum)
    //设置成人儿童数 end
    function resetPeopleList($element, num) {
        var $list = $element.find("li");
        var maxNum = 9 - num;
        for (var i = 0; i < $list.length; i++) {
            var $thisItem = $list.eq(i);
            if (parseInt($thisItem.data("num")) > maxNum) {
                $thisItem.hide();
            } else {
                $thisItem.show();
            }
        }
        var departureCity =  $("#departureCityName").val();
        if(departureCity == '' || null == departureCity){//出发城市等于空
            $.ajax({
                type: "GET",
                url: baseUrl+"/index/ip",
                success: function(data){
                    $("#departureCityName").val(data.add);
                    for(var i=0;i<allCities.length;i++){
                        if(data.add==allCities[i].split("|")[0]){
                            $(".select_depa").val(data.add);
                        }else{$(".select_depa").val("上海")}
                    }
                }
            });
        }
        // 成人1 => 儿童0-2 限制
        if (parseInt(num) == 1) {
            for (var i = 3; i < $list.length; i++) {
                $list.eq(i).hide();
            }
            // 如果儿童>=3, 修改为0
            var $childInput = $(".JS_child_num");
            if(parseInt($childInput.val())>=3){
                $childInput.val(0);
                $childInput.siblings(".select-people").find("span").html(0);
            }
        }
    }
    function resetAdultList($element, num) {
        var $list = $element.find("li");
        var maxNum = 9 - num;
        for (var i = 0; i < $list.length; i++) {
            var $thisItem = $list.eq(i);
            if (parseInt($thisItem.data("num")) > maxNum) {
                $thisItem.hide();
            } else {
                $thisItem.show();
            }
        }
    }

    $(".fh-order-btn").click(function(e){
        if(isStopSubmit()) {
            return;
        }
        var isBackBooking = $("#isBackBooking").val();
        if(isBackBooking=='true'){
            openCoustomerDialog();
            return;
        }
        $.ajax({
            type: "post",
            async: true,
            dataType: "json",
            url: baseUrl+"/order/recordBookingLogNoLogin?shopingUUID="+_shoppingUUID,
            success: function(data){
                if(data.isSuccess=='SUCCESS'){
                    var url = baseUrl+"/order/toBooking?shopingUUID="+_shoppingUUID;
                    window.location.href=url;
                }else{
                    $(".returnAlert").show();
                    $('.resortOverlay').stop(true,true).show();
                    $("#errorMsg").html(data.errMessage);
                }
            }
        });
    });
});

//搜索
$(".fh-search-btn").on("click", function(e) {
    var event = e || window.event;
    //IE用cancelBubble=true来阻止而FF下需要用stopPropagation方法
    event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
    if (validateFhInput()) {
        // TODO
        var form = $('#search_form');
        form.submit();
    }
});

//更换舱位
$(".select-class-list li").on("click", function(e) {
    var event = e || window.event;
    event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
    // TODO 更换舱位后的操作
    var $this = $(this);
    var $parent = $(this).parent();
    $this.addClass('active').siblings().removeClass('active');
    $parent.siblings(".select-class").find("em").html($this.find(".scl-class").html());

    if($this.find(".scl-remain").html()==null){

        $parent.siblings(".flight-ticket-amount").attr("style","display: none;");

    }else{

        $parent.siblings(".flight-ticket-amount").attr("style","");

    }
    $parent.siblings(".flight-ticket-amount").html($this.find(".scl-remain").html());

    $parent.siblings(".select-class").find("em").attr("code",$this.find(".scl-class").attr("code"));
    $parent.siblings(".select-class").find("em").val($this.find(".scl-class").val());
    $parent.hide();

    var adaultPrice=$(this).attr("adaultPrice");//当前的成人价格
    var childPrice=$(this).attr("childPrice");//当前的小孩价格
    var adaultCount=$("#adultsCount").val();//成人数
    var childCount =$("#childCount").val(); //儿童数
    var price=parseFloat(adaultPrice)*adaultCount+parseFloat(childPrice)*childCount;
    for(var i=0;i<$(this).parent().find("li").length;i++){
        var adaultPriceI=$(this).parent().find("li").eq(i).attr("adaultPrice");
        var childPriceI=$(this).parent().find("li").eq(i).attr("childPrice");
        var baseAmount = $(this).parent().find("li").eq(i).attr("baseAmount");
        var priceI=parseFloat(adaultPriceI)*adaultCount+parseFloat(childPriceI)*childCount;//当前选中地价格
        var qq=priceI-baseAmount;
        if(qq<0){
            qq=qq*-1;
            $(this).parent().find("li").eq(i).find(".scl-diff").html("-<i class='price-rmb'>&yen</i>"+qq);
        }else{
            $(this).parent().find("li").eq(i).find(".scl-diff").html("+<i class='price-rmb'>&yen</i>"+qq);
        }
    }
    var code = $(this).parents(".flight-detail").find("em").attr("code");
    var policyid = $(this).children().eq(1).attr("policyid");
    var flightNo = $(this).parents(".flight-detail").find("em").attr("flightNo");
    var shoppingUUID = _shoppingUUID;
    var flightType = $(this).parents(".flight-detail").find("em").attr("flightType");;
    $.ajax({
        type: "post",
        async: true,
        dataType: "json",
        url:baseUrl+"/shopping/changeflight",
        data: {
            shoppingUUID:shoppingUUID,
            flightNo:flightNo,
            seatCode:code,
            policyId:policyid,
            flightType:flightType
        },
        success: function(obj) {
            var url = baseUrl+"/search/backToShopping?shoppingUUID="+shoppingUUID;
            window.location.href=url;
        },
        error:function(obj)
        {
            $(".returnAlert").show();
            $('.resortOverlay').stop(true,true).show();
            $("#errorMsg").html(eval('(' + obj.responseText + ')').message);
        }
    });
});

function roomSelected(productId,branchId,suppGoodsId){
    var roomCount = $("#"+productId+branchId+suppGoodsId+"").text();
    var shoppingUUID = _shoppingUUID;
    $.ajax({
        type: "post",
        async: false,
        dataType: "json",
        url: baseUrl+"/shopping/changehotel",
        data:
        {
            shoppingUUID:shoppingUUID,
            hotelId:productId,
            roomId:branchId,
            planId:suppGoodsId,
            roomCount:roomCount
        },
        success: function(obj) {
            if(obj.isSuccess){
                var url = baseUrl+"/search/backToShopping?shoppingUUID="+shoppingUUID;
                window.location.href=url;
                //initAjax();
            }
        },
        error:function(obj)
        {
            $(".returnAlert").show();
            $('.resortOverlay').stop(true,true).show();
            $("#errorMsg").html(eval('(' + obj.responseText + ')').message);
        }
    });
};

function initAjax(){
    if(!$(".fh-no-result").length){
        $(".fh-overlay, .fh-dialog-loading").show();
        $.ajax({
            type: "post",
            async: true,
            dataType: "json",
            url: baseUrl+"/shopping/calucateAmount",
            data: {
                shoppingUUID:_shoppingUUID
            },
            success: function(obj) {
                var product_price = calProductPrice(); // 选择页面产品价格统一由前台计算
                $("#productPrice").html(product_price);
                $("#totalPrice").html(obj.result.comboTotalAmount);
                $("#promotion").html(obj.result.comboPromotionAmount);
                $("#salesPrice").html(obj.result.comboSalesAmount + product_price);
                $(".fh-overlay, .fh-dialog-loading").hide();
            },
            error:function(obj) {
                $(".fh-overlay, .fh-dialog-loading").hide();
                $(".returnAlert").show();
                $('.resortOverlay').stop(true,true).show();
                $("#errorMsg").html(eval('(' + obj.responseText + ')').message);
            }
        });
    }
};

$(".xuanze").die().live("click",function(e){
    $(".selectedBtn").html("选择");
    $(".selectedBtn").attr("class","btn btn-small btn-orange xuanze");
    var productId = $(this).attr('productId');
    var branchId  = $(this).attr('branchId');
    var suppGoodsId=$(this).attr('suppGoodsId');

    e.target.className="selectedBtn";
    e.target.innerHTML="已选"+"<span class='ph_icon ph_icon_selected'></span>";
    //差价计算
    roomSelected(productId,branchId,suppGoodsId);
});

//更换房间数  (改为不联动)
function changeRoomNum(){
    // 更换房间数
    $(".select-div-list li").on("click", function(e) {
        var event = e || window.event;
        event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
        var roomNum = $(this).data("num");//房间数
        var $selectList = $(this).parent();
        var baseAmount=$("#baseAmount").val();//酒店基准价
        var goodsId = $(this).parent().parent().find("span").attr("id");

        //console.info("roomNum="+roomNum+";baseAmount="+baseAmount);
        //只变相同商品的房间数
        $("span[id="+goodsId+"]").html(roomNum);
        $selectList.hide();

        var priceDiffDiv = $("dd[name='priceDiff"+goodsId+"']");
        var selectButton = priceDiffDiv.parent().find(".roomTable-td6");
        var settlementPrice = $(selectButton).find("a").attr("settlementPrice");
        var priceDiff = (settlementPrice*roomNum)-baseAmount;
        //console.info("settlementPrice="+settlementPrice+";priceDiff="+priceDiff);
        //改价格
        var priceDiffHtml = "";
        if(priceDiff >= 0){
            priceDiffHtml += "+&yen;<dfn class='f14 pl2 bold'>"+priceDiff+"</dfn>";
        }else{
            priceDiffHtml += "-&yen;<dfn class='f14 pl2 bold'>"+Math.abs(priceDiff)+"</dfn>";
        }
        $(priceDiffDiv).html(priceDiffHtml);

        //把已选按钮改成选择
        if($(".roomTable-td6").find("a").hasClass("selectedBtn")){
            $(".roomTable-td6").find("a").removeClass("selectedBtn").addClass("btn btn-small btn-orange xuanze");
            $(".roomTable-td6").find("a").html("选择");
        }

    });
}

$('.fh-return-btn').click(function(){
    var shoppingUUID = _shoppingUUID;
    $('.returnAlert').stop(true,true).fadeOut();
    $('.resortOverlay').stop(true,true).fadeOut();
    $('body').removeAttr('style');
    var form = $('#search_form');
    form.submit();

});

$('.ph_icon_closeAlert').click(function(){
    $('.returnAlert').stop(true,true).fadeOut();
    $('.resortOverlay').stop(true,true).fadeOut();
    $('body').removeAttr('style');
    var form = $('#search_form');
    form.submit();
})

//加载可选择房间数
$(function(){
    // 更换房间数
    changeRoomNum();
    initTicket();
    initInsurance();
    // 如果为单程，返程日期disable
    var tripType = $("#tripType").val();
    if (tripType == "DC") {
        $(".fh-return-day-group").addClass("fh-input-group-disable");
    }
    // 初始化购物车中的产品信息，产品选择模块的默认值
    initProduct();
    initAjax();
});

// 门票详情展示
$(".xh-name em").click(function() {
    $('.fh-ticket-detail').css({
        'position': 'relative',
        'z-index':'1'
    });
    var $item = $(this).parents('.xpbl-item');
    var id = $item.data("id");
    var $dialog = $("#TDTL" + id.substring(1));

    $dialog.toggle();
});

$(".shouqi").click(function() {
    var $ticket_detail = $(this).parents(".fh-ticket-detail");
    $ticket_detail.hide();
})


$(function(){
    var from = $("#departureCityName").val();
    var dest = $("#arrivalCityName").val();
    var hotel = $("#productName").val();
    var _requestPath = $("#_requestPath").val();
    seoJustice(from,dest,hotel,'seotdk_fit_freetour',_requestPath);
})

$("#flightTypeDiv a").click(function() {
    var flight_type = $(this).data("type");
    $("#tripType").val(flight_type);
});
// 构造保险份数
var genInsuranceCount = function(num) {
    var arr = new Array();
    var str0 = "<li data-count=" + 0 + ">" + 0 + "</li>";
    var str1 = "<li data-count=" + num + ">" + num + "</li>";
    arr.push(str0);
    arr.push(str1);
    return arr.join("");
}
// 构造机票航意险份数
var genFlightInsuranceCount = function(num) {
    var tripType = $("#tripType").val();
    var str = "";
    if (tripType === "DC") {
        str = "<li data-count=" + num + ">" + num + "</li>";
    }
    if (tripType === "WF") {
        str = "<li data-count=" + (num * 2) + ">" + (num * 2) + "</li>";
    }
    return str;
};

// 初始化门票下拉菜单
var initTicket = function() {
    // 初始化门票日期
    $(".select-day-list li").click(selectDayListClick);
    $(".ticket-count li").click(selectCount);
}
// 初始化保险
var initInsurance = function() {
    var adultsCount = Number( $("#adultsCount").val() );
    var childCount = Number( $("#childCount").val() );
    var count = adultsCount + childCount;

    $(".select-insurance-list").append(genInsuranceCount(count));
    $(".select-insurance-list li").click(selectCount);

    $(".select-flightInsurance-count-list").append(genFlightInsuranceCount(count));
    $(".select-flightInsurance-count-list li").click(selectCount);
}

// 选择日期
var selectDayListClick = function(e) {
    var event = e || window.event;
    event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);

    var $this = $(this);
    var dayVal = $this.data("day");
    var priceVal = $this.data("price");
    var $parent = $this.parent();
    var $thisItem = $this.parents(".xpbl-item");
    var $thisChecked = $thisItem.find(".xh-check-icon");

    $parent.siblings(".select-day").removeClass("sd-not-selected").addClass("sd-selected").find("span").html(dayVal);
    $parent.hide();
    // 将价格更改成门票当日价格
    $thisItem.find(".xh-price span").text(priceVal);

    if($thisItem.find(".select-count span").html() !="0") {
        // 已选
        $thisChecked.addClass("xh-checked");
        updCart($this, "TICKET");
    } else {
        $thisChecked.removeClass("xh-checked");
    }
    saveToCache($this);
}

// 选择份数
var selectCount = function(e) {
    var event = e || window.event;
    event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);

    var $this = $(this);
    var value = $this.data("count");
    var $parent = $this.parent();
    var $thisItem = $this.parents(".xpbl-item");
    var $thisDay = $thisItem.find(".select-day");
    var $thisChecked = $thisItem.find(".xh-check-icon");

    $parent.siblings(".select-count").find("span").html(value);
    $parent.hide();

    if(value !="0") {
        $parent.siblings(".select-count").removeClass("sd-not-selected");
        if($thisDay.length > 0) {
            if($thisDay.hasClass("sd-selected")) {
                // 已选
                $thisChecked.addClass("xh-checked");
                updCart($this, "TICKET");
            } else {
                $thisDay.addClass("sd-not-selected");
            }
        } else {
            // 已选
            $thisChecked.addClass("xh-checked");
            updCart($this, "INSURANCE");
        }
    } else {
        if($thisDay.length > 0) {
            $thisDay.removeClass("sd-not-selected");
        }
        $thisChecked.removeClass("xh-checked");
        removeProduct($this);
    }
    saveToCache($this);
}
// 根据选择的商品，更新购物车价格
var updCart = function(obj, type) {
    var $this = obj;
    var $root = $this.parents(".xpbl-item");

    var productName = $root.siblings(".xpbl-title").find("em").text();
    var id = $root.attr("data-id");
    var goodsName = $root.find(".xh-name").text();
    var price = 0;
    if ($this.parents(".xh-date").length > 0) { // 判断触发事件是否为选择日期
        price = $this.data("price");
    } else {
        price = Number( $root.find(".xh-price span").text() );
    }
    var count = Number( $root.find(".select-count span").text() ); // 数目

    $dd = $("#price-list").find("#" + id);
    if ($dd.length > 0) {
        var pre_count = $dd.data("count");
        var pre_price = $dd.data("price");

        if (pre_count === count && pre_price === price) {
            return;
        }
        $dd.remove();
    }

    if (count > 0) {
        var str = "<dd id=\"" + id + "\" data-count=\"" + count + "\" data-price=\"" + price + "\" class=\"clearfix\">" + "<span class=\"price\">"
            + "<i class=\"price-rmb\">¥</i>" + price + " X "
            + count + "</span><span class=\"name\" title=\"" + productName + goodsName + "\">" + productName + goodsName
            + "</span>";
        if (type === "TICKET") {
            $("#ticket_price_list").append(str);
        }
        if (type === "INSURANCE") {
            $("#insurance_price_list").append(str);
        }
    }

    var product_price = calProductPrice();
    var sale_price = calSalesPrice(product_price); // 应付总价
    // 更新可选产品价格和总价格
    $("#productPrice").html(product_price);
    $("#salesPrice").html(sale_price);

    hideProductPriceListIfNotExist();
}
// 删除商品
var removeProduct = function(obj) {
    var $this = obj;
    var $root = $this.parents(".xpbl-item");

    var id = $root.attr("data-id");
    var $dd = $("#price-list").find("#" + id);

    if ($dd.length == 0) {
        return;
    }
    $dd.remove();

    var product_price = calProductPrice();
    var sale_price = calSalesPrice(product_price);

    // 更新可选产品价格和总价格
    $("#price-list .price em").html(product_price);
    $("#salesPrice").html(sale_price);

    hideProductPriceListIfNotExist();
}
// 将更新的购物车信息保存到缓存中
var saveToCache = function(obj) {
    var $this = obj;
    var $root = $this.parents(".xpbl-item");
    // 为避免产品ID重复，门票id:"T" + suppGoodsId，保险id: "I" + suppGoodsId, 航意险: "F" + id;
    var type = $root.attr("data-id").substring(0,1);
    if("T" == type) {
        saveSpotTicketToCache(obj);
    } else if ("I" == type) {
        saveInsuranceToCache(obj);
    } else if ("F" == type) {
        saveFliInsToCache(obj);
    }
}
var saveSpotTicketToCache = function(obj) {
    var $this = obj;
    var $root = $this.parents(".xpbl-item");

    var id = $root.attr("data-id"); // 为避免产品ID重复，门票id:"T" + suppGoodsId，保险id: "I" + suppGoodsId;
    var suppGoodsId = id.substring(1);
    var date = $root.find(".select-day span").text();
    var count = Number( $root.find(".select-count span").text() );
    var price = 0;
    if ($this.parents(".xh-date").length > 0) { // 判断触发事件是否为选择日期
        price = $this.data("price");
    } else {
        price = Number( $root.find(".xh-price span").text() );
    }
    var spotName = $root.siblings(".xpbl-title").find("em").text();
    var ticketName = $root.find(".xh-name").text();
    var productId = $root.siblings(".xpbl-title").find("em").attr("data-productId");

    var DATE_FORMAT = /^[0-9]{4}-[0-1]?[0-9]{1}-[0-3]?[0-9]{1}$/;
    var COUNT_FORMAT = /^\d*$/;
    if (!DATE_FORMAT.test(date)) {
        date = "";
    }
    if (!COUNT_FORMAT.test(count)) {
        count = "";
    }

    $.ajax({
        type: "post",
        async: true,
        dataType: "json",
        url: baseUrl+"/shopping/updSelectedTicket",
        data: {
            shoppingUuid: _shoppingUUID,
            suppGoodsId: suppGoodsId,
            ticketDate: date,
            ticketCount: count,
            ticketPrice: price,
            spotName: spotName,
            ticketName: ticketName,
            productId: productId
        },
        error: function(obj) {
            $(".fh-overlay, .fh-dialog-loading").hide();
            $(".returnAlert").show();
            $('.resortOverlay').stop(true,true).show();
            $("#errorMsg").html(eval('(' + obj.responseText + ')').message);
        }
    });
}

var saveInsuranceToCache = function(obj) {
    var array = new Array();
    $("#insuranceList").find(".xpbl-item").each(function(i){
        var count = $(this).find(".select-count span").html();
        if(count > 0){
            var insurance = {};
            var count = $(this).find(".xh-count span").html();
            insurance.productId = $(this).find("input[name='productId']").val();
            insurance.productType = $(this).find("input[name='productType']").val();
            insurance.productName = $(this).find("input[name='productName']").val();
            insurance.branchId = $(this).find("input[name='branchId']").val();
            insurance.branchName = $(this).find("input[name='branchName']").val();
            insurance.suppGoodsId = $(this).find("input[name='suppGoodsId']").val();
            insurance.suppGoodsName = $(this).find("input[name='suppGoodsName']").val();
            insurance.insuranceCount = count;
            insurance.insurancePrice = $(this).find(".xh-price span").html();
            insurance.insuranceDetail = $(this).find("input[name='insuranceDetail']").val();
            insurance.visitDate = $("#flightStartDate").val();
            array.push(insurance);
        }
    });

    var data = {};
    var url =  baseUrl+"/shopping/updSelectedInsurance";
    data.shoppingUuid = _shoppingUUID;
    data.insuranceList = JSON.stringify(array);
    $.ajax({
        type: "post",
        async: true,
        dataType: "json",
        url: url,
        data: data,
        error: function(obj) {
            $(".fh-overlay, .fh-dialog-loading").hide();
            $(".returnAlert").show();
            $('.resortOverlay').stop(true,true).show();
            $("#errorMsg").html(eval('(' + obj.responseText + ')').message);
        }
    });
}

var saveFliInsToCache = function(obj) {
    var $this = obj;
    var $root = $this.parents(".xpbl-item");

    var id = $root.attr("data-id"); // 为避免产品ID重复，门票id:"T" + suppGoodsId，保险id: "I" + suppGoodsId;
    var insuranceId = id.substring(1);
    var count = Number( $root.find(".select-count span").text() );
    var price = Number( $root.find(".xh-price span").text() );

    var insuranceName = $root.siblings(".xpbl-title").find("em").text();
    var coverage = $root.find(".xh-name").text();
    var suppName = $root.data("suppname");
    $.ajax({
        type: "post",
        async: true,
        dataType: "json",
        url: baseUrl+"/shopping/updSelectedFliIns",
        data: {
            shoppingUuid: _shoppingUUID,
            insuranceId: insuranceId,
            insuranceName: insuranceName + coverage,
            suppName: suppName,
            insurancePrice: price,
            insuranceCount: count
        },
        error: function(obj) {
            $(".fh-overlay, .fh-dialog-loading").hide();
            $(".returnAlert").show();
            $('.resortOverlay').stop(true,true).show();
            $("#errorMsg").html(eval('(' + obj.responseText + ')').message);
        }
    })
}

// 初始化时如果缓存中存在产品信息，展示相应信息
var initProduct = function() {
    $.ajax({
        type: "post",
        async: false,
        dataType: "json",
        url: baseUrl+"/shopping/getShoppingInfo",
        data: {
            shoppingUuid: _shoppingUUID
        },
        success: function(data) {
            handleSpotTicketResult(data);
            handleInsuranceResult(data);
            handleFlightInsuranceResult(data);
            hideProductPriceListIfNotExist();
        },
        error:function(data)
        {
            $(".returnAlert").show();
            $('.resortOverlay').stop(true,true).show();
            $("#errorMsg").html(eval('(' + data.responseText + ')').message);
        }
    });
}
var handleSpotTicketResult = function(data) {
    var selTickets = data.selectTicketInfo;
    for (var i = 0; i < selTickets.length; i++) {
        // 初始化购物车产品信息
        var suppGoodsId = selTickets[i].suppGoodsId;
        var date = selTickets[i].ticketDate;
        var dateD = new Date(date);
        var dateS = moment(dateD).format("YYYY-MM-DD");
        var count = selTickets[i].ticketCount;
        var spotName = selTickets[i].spotName;
        var ticketName = selTickets[i].ticketName;
        var price = selTickets[i].ticketPrice;

        var str = "<dd id=\"T" + suppGoodsId + "\" data-count=\"" + count + "\" data-price=\"" + price + "\" class=\"clearfix\">" + "<span class=\"price\">"
            + "<i class=\"price-rmb\">¥</i>" + price + " X "
            + count + "</span><span class=\"name\" title=\"" + spotName + ticketName + "\">" + spotName + ticketName
            + "</span>";

        $("#ticket_price_list").append(str);

        // 根据缓存中的购物车信息初始化门票默认值
        $(".xpbl-item").each(function() {
            var cur_id = $(this).attr("data-id");
            var cur_suppGoodsId = cur_id.substring(1);
            if (cur_suppGoodsId === suppGoodsId) {
                $(this).find(".select-day").addClass("sd-selected");
                $(this).find(".select-day span").text(dateS);
                $(this).find(".xh-price span").text(price);
                $(this).find(".select-count span").text(count);
                $(this).find(".xh-check-icon").addClass("xh-checked");
            }
        });
    }
}

var handleInsuranceResult = function(data) {
    var selInsurances = data.selectInsuranceInfo;
    for (var i = 0; i < selInsurances.length; i++) {
        // 初始化购物车产品信息
        var suppGoodsId = selInsurances[i].suppGoodsId;
        var count = selInsurances[i].insuranceCount;
        var productName = selInsurances[i].productName;
        var suppGoodsName = selInsurances[i].suppGoodsName;
        var branchName = selInsurances[i].branchName;
        var price = selInsurances[i].insurancePrice;

        var name = productName + suppGoodsName + " -- " + branchName;

        var str = "<dd id=\"I" + suppGoodsId + "\" data-count=\"" + count + "\" data-price=\"" + price + "\" class=\"clearfix\">" + "<span class=\"price\">"
            + "<i class=\"price-rmb\">¥</i>" + price + " X "
            + count + "</span><span class=\"name\" title=\"" + name + "\">" + name + "</span>";

        $("#insurance_price_list").append(str);

        // 根据缓存中的购物车信息初始化门票默认值
        $(".xpb-insurance .xpbl-item").each(function() {
            var cur_id = $(this).attr("data-id");
            var cur_suppGoodsId = cur_id.substring(1);
            if (cur_suppGoodsId === suppGoodsId) {
                $(this).show();
                $(this).find(".select-count span").text(count);
                $(this).find(".xh-check-icon").addClass("xh-checked");
            }
        });
    }
}
// 处理航空意外险数据
var handleFlightInsuranceResult = function(data) {
    var flightInsurance = data.selectFlightInsInfo;
    for (var i = 0; i < flightInsurance.length; i++) {
        var id = flightInsurance[i].insuranceId;
        var price = flightInsurance[i].insurancePrice;
        var suppName = flightInsurance[i].suppName;
        var name = flightInsurance[i].insuranceName;
        var count = flightInsurance[i].insuranceCount;

        var str = "<dd id=\"F" + id + "\" data-count=\"" + count + "\" data-price=\"" + price + "\" class=\"clearfix\">" + "<span class=\"price\">"
            + "<i class=\"price-rmb\">¥</i>" + price + " X "
            + count + "</span><span class=\"name\" title=\"" + name + "\">" + name + "</span>";

        $("#fli_ins_price_list").append(str);

        $(".xpb-insurance .xpbl-item").each(function() {
            var cur_id = $(this).attr("data-id");
            var cur_suppGoodsId = cur_id.substring(1);
            if (cur_suppGoodsId == id) {
                $(this).find(".select-count span").text(count);
                $(this).find(".xh-check-icon").addClass("xh-checked");
            }
        });
    }
}

// 计算产品价格
var calProductPrice = function() {
    var productPrice = 0;
    var arr = new Array();
    $("#price-list dd").each(function() {
        var o = new Object();
        o.count = $(this).data("count");
        o.price = $(this).data("price");
        arr.push(o);
    });
    $.ajax({
        type: "post",
        async: false,
        dataType: "json",
        contentType:"application/json;",
        url: baseUrl+"/shopping/calulateProductPrice",
        data : JSON.stringify({
            products:arr,
        }),
        success: function(data) {
            productPrice = data;
        },
        error:function(data)
        {
            $(".returnAlert").show();
            $('.resortOverlay').stop(true,true).show();
            $("#errorMsg").html(eval('(' + data.responseText + ')').message);
        }
    });
    return productPrice;
}
// 计算总价格
var calSalesPrice = function(product_price) {
    var salesPrice = 0;
    var totalPrice = $("#totalPrice").text();
    var promotion = $("#promotion").text();
    var productPrice = product_price;

    var data = {};
    data.comboPrice = totalPrice;
    data.productPrice = productPrice;
    data.discountPrice = promotion;
    $.ajax({
        type: "post",
        async: false,
        dataType: "json",
        url: baseUrl+"/shopping/calulateSalesPrice",
        data : data,
        success: function(data) {
            salesPrice = data;
        }
    });
    return salesPrice;
}
// 判断购物车中是否有可选产品，如果没有在费用明细中隐藏可选产品DIV，否则显示.
var hideProductPriceListIfNotExist = function() {
    if($("#price-list dd").length > 0) {
        $("#price-list").show();
    } else {
        $("#price-list").hide();
    }
}
// 当门票选择日期和份数只选择其中一个时，阻止订单提交。
var isStopSubmit = function() {
    var $item = $("#spotsInfoDiv").find(".xpbl-item");
    var flag = false;
    $item.each(function() {
        var $day = $(this).find(".select-day");
        var $count = $(this).find(".select-count");
        if (!$day.hasClass("sd-selected") && Number( $count.text() ) > 0) {
            $day.addClass("sd-not-selected");
            flag = true;
        }
    });
    return flag;
}

//核对用户输入的账号
function checkAccount(){
    $("#regist_userMobile").hide();
    var searchName= $("#searchName").val();
    if($.trim(searchName)==''){
        alert("请输入信息识别用户帐号");
        return;
    }
    $.ajax({
        url : baseUrl+"/loginUser/queryUserMember",
        cache : false,
        async : false,
        data : {
            "paramValue":searchName
        },
        type : "POST",
        datatype : "json",
        success: function(data){
            $("#search_user_list").show();
            $("#search_user_list").html(data)
        }
    });
}

//点击注册用户，显示注册文本
function showRegUserAccount(){
    $("#regist_userMobile").show();
    $("#search_user_list").hide();
    $("#searchName").val("");
    $("#search_user_list").html("")
    $("#userPhone").val("")
}

//注册用户
function regUserAccount(){
    var userPhone = $.trim($("#userPhone").val());
    var isMobile=/^(?:13\d|15\d|18\d)\d{5}(\d{3}|\*{3})$/;
    if($.trim(userPhone)=='' || userPhone.length!=11 || !isMobile.test(userPhone)){
        alert("请输入11位有效的电话号码!");
        return;
    }

    $.ajax({
        url : baseUrl+"/loginUser/registUserMember",
        cache : false,
        async : false,
        data : {
            "mobileNumber":userPhone
        },
        type : "POST",
        datatype : "json",
        success: function(data){
            if (data != "" && data.status == "SUCCESS") {
                alert(data.message);
                $("#regist_userMobile").hide();
                $("#searchName").val("");
                $("#search_user_list").html("")
                $("#searchName").val(userPhone);
                checkAccount();
                $("#search_user_list").show();
            } else {
                alert(data.message);
            }
        }
    });
}

//选取会员信息
function chooseUserInfo(obj){

    var userGrade = $("#userGrade_"+obj).val();
    var userName = $("#userName_"+obj).val();
    var userNo = $("#userNo_"+obj).val();
    var mobileNumber = $("#mobileNumber_"+obj).val();
    $.ajax({
        url : baseUrl+"/loginUser/chooseUserMember",
        cache : false,
        async : false,
        data : {
            "userName":userName,
            "userGrade":userGrade,
            "userNo":userNo,
            "userId":obj,
            "mobileNumber":mobileNumber
        },
        type : "POST",
        datatype : "json",
        success: function(data){
            if (data != "" && data.status == "SUCCESS") {
                var url = baseUrl+"/order/toBooking?shopingUUID="+_shoppingUUID;
                window.location.href=url;
            }
        }
    });
}

//打开修改联系人信息Dialog
function openCoustomerDialog()
{
    $("#searchName").val("");
    $("#search_user_list").html("");
    $('#coustomerDialog').dialog({
        title:'选择用户账号',
        width:600,
        height:400,
        modal:'true'
    });
}

$("#toChangeFlightBtn").click(function() {
    $.ajax({
        type: "post",
        async: true,
        dataType: "json",
        url: baseUrl+"/search/flight/check/recordBookingLogNoLogin?shopingUUID="+_shoppingUUID,
        success: function(data){
            if(data.isSuccess=='SUCCESS'){
                var url = baseUrl+"/search/flight/"+_shoppingUUID+"/to/true/ALL/ALL/ALL/ALL/ALL/false/true/asc?pageType=select";
                window.location.href=url;
            }else{
                $(".returnAlert").show();
                $('.resortOverlay').stop(true,true).show();
                $("#errorMsg").html(data.errMessage);
            }
        }
    });
});
$("#backChangeFlightBtn").click(function() {
    $.ajax({
        type: "post",
        async: true,
        dataType: "json",
        url: baseUrl+"/search/flight/check/recordBookingLogNoLogin?shopingUUID="+_shoppingUUID,
        success: function(data){
            if(data.isSuccess=='SUCCESS'){
                var url = baseUrl+"/search/flight/"+_shoppingUUID+"/back/true/ALL/ALL/ALL/ALL/ALL/false/true/asc?pageType=select";
                window.location.href=url;
            }else{
                $(".returnAlert").show();
                $('.resortOverlay').stop(true,true).show();
                $("#errorMsg").html(data.errMessage);
            }
        }
    });
});
$("#changeHotelBtn").click(function() {
    $.ajax({
        type: "post",
        async: true,
        dataType: "json",
        url: baseUrl+"/search/hotel/check/recordBookingLogNoLogin?shopingUUID="+_shoppingUUID,
        success: function(data){
            if(data.isSuccess=='SUCCESS'){
                var url = baseUrl+"/search/hotels/"+_shoppingUUID+"/ALL/ALL/ALL/ALL/ALL/1?pageType=select";
                window.location.href=url;
            }else{
                $(".returnAlert").show();
                $('.resortOverlay').stop(true,true).show();
                $("#errorMsg").html(data.errMessage);
            }
        }
    });
});

/**
 * getDayOfWeek 返回星期
 * @param {string} date 格式:"YYYY-MM-DD"
 */
function getDayOfWeek(date){
    var nowDay;
    if (date) {
        var dayArray = date.split("-");
        nowDay = new Date(parseInt(dayArray[0], 10), parseInt(dayArray[1], 10) - 1, parseInt(dayArray[2], 10));
    } else {
        nowDay = new Date();
    }

    var day = nowDay.getDay();
    var dayArray = ["星期天","星期一","星期二","星期三","星期四","星期五","星期六"];
    return dayArray[day];
}
