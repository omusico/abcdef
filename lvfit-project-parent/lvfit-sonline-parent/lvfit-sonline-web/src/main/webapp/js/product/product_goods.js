$(function() {
    $("#adult-count").live("change", changeChildSelect);
    $("#children-count").live("change", changeAdultSelect);
    setTimeout(initChildSelect,500);
});
 
function initChildSelect(){
    //只在有下拉菜单的时候进行处理.
    if ($("#adult-count").length > 0) {
        var adultCount = Number( $("#adult-count").siblings("div").find(".select-value").text() );
        var maxNum1 = 9 - adultCount;
        var maxNum2 = 2 * adultCount;
        var maxNum = maxNum1 < maxNum2 ? maxNum1 : maxNum2;
        var $list = $("#children-count").siblings("div").find(".select-results").find("li");

        for (var i = 0; i < $list.length; i++) {
            var $thisItem = $list.eq(i);
            if (parseInt($thisItem.attr("rel")) > maxNum) {
                $thisItem.hide();
            } else {
                $thisItem.show();
            }
        }

        $("#children-count").trigger("change");

    }
}

function changeQuantity(quantity){
	 var adultQuantity = $("#adultQuantity").val();
	 var childQuantity = $("#childQuantity").val();
	 $("#adult-count-span").html(parseInt(adultQuantity)*parseInt(quantity));
	 $("#child-count-span").html(parseInt(childQuantity)*parseInt(quantity));
	 loadsGoods();
}

// 1. 成人数 + 儿童数 < 9
// 2. 1个成人最多带2个儿童
function changeChildSelect() {
    var adultCount = $("#adult-count").siblings("div").find(".select-value").text();
    var childCount = $("#children-count").siblings("div").find(".select-value").text();
    $("#adultQuantity").val(adultCount);
    var maxNum1 = 9 - Number( adultCount );
    var maxNum2 = 2 * Number( adultCount );
    var maxNum = maxNum1 < maxNum2 ? maxNum1 : maxNum2;
    var $list = $("#children-count").siblings("div").find(".select-results").find("li");
    for (var i = 0; i < $list.length; i++) {
        var $thisItem = $list.eq(i);
        if (parseInt($thisItem.attr("rel")) > maxNum) {
            $thisItem.hide();
        } else {
            $thisItem.show();
        }
    }
    if(parseInt(childCount) > maxNum) {
        $("#children-count").siblings("div").find(".select-results").find("li:first-child").trigger("click");
    }
    loadsGoods();
}
function changeAdultSelect() {
    var childCount = $("#children-count").siblings("div").find(".select-value").text();
    $("#childQuantity").val(childCount);
    var maxNum = 9 - Number( childCount );
    var $list = $("#adult-count").siblings("div").find(".select-results").find("li");
    for (var i = 0; i < $list.length; i++) {
        var $thisItem = $list.eq(i);
        if (parseInt($thisItem.attr("rel")) > maxNum) {
            $thisItem.hide();
        } else {
            $thisItem.show();
        }
    }
    loadsGoods();
}

function loadsGoods() {
     // 显示loading界面
    if ($("#selectDate").val() == "") return;
    $("#preorder-adjust").html('<div class="loading-data-status"><img src="http://pic.lvmama.com/img/new_v/ui_scrollLoading/loadingGIF46px.gif" alt="loading" /></div>');
    var obj = genRequestParam();
    $.ajax({
        url: _data._contextPath + "/loadsGoods",
        type:"post",
        data: obj,
        success: function (data) {
            // 按钮恢复正常
            $("#preorder-adjust").html(data);
            $("#noGoodsFlag").val(false);
            if($("<div>"+data+"</div>").find(".do-not-modify-me").size() == 0){
                $("#feeInclude").show();
            }else {
                $("#feeInclude").hide();
            }
            initPriceInBaseInfo();
        },
        error: function(data) {
           
    	    var adultQuantity = parseInt(obj.adultQuantity);
    	    var childQuantity = parseInt(obj.childQuantity);
    	    var quantity = parseInt(obj.quantity);
    	    var departDate = $("#selectDate").val();
            var str = "<div class=\"fit_no_detail\">"
                + "<i></i>"
                + "<p style='position:relative; left:-50px;'>出行日期："+departDate+" 成人数："+adultQuantity*quantity+" 儿童数："+childQuantity*quantity+"</p>"
                + "<h5>暂时没有找到满足您的商品!</h5>"
                + "<p style='color:#09C'>请选择其他出行日期</p>"
                + "</div>";
            $("#preorder-adjust").html(str);
            $("#noGoodsFlag").val(true);
            $("#total-price-value").html("--");

            $("#preorder-booking-button").addClass("btn-stop");
            $("#preorder-booking-button").removeClass("cbtn-orange1");
        }
    });
}

function genRequestParam() {
    var obj = new Object();
    obj.shoppingUuid = $("#shoppingUuid").val();
    obj.productId = $("#productId").val();
    obj.isMuiltDeparture = $("#isMuiltDeparture").val();
    obj.packagedProdCatId = $("#packagedProdCatId").val();
    obj.startDistrictId = $("#startDistrictId").val();
    obj.adultQuantity = $("#adultQuantity").val();
    obj.childQuantity = $("#childQuantity").val();
    obj.departDate = $("#selectDate").val();
    if($("#packCharterFlightFlag").val()=='Y')
        $("#packCharterFlightFlag").val('TRUE');
    obj.isCharterFlightFirst = $("#packCharterFlightFlag").val();
    obj.depCityCode = $("#depCityCode").val(); 
    obj.arvCityCode = $("#arvCityCode").val();
    if ($("#preorder-quantity").val() === undefined) {
        obj.quantity = 1;
    } else {
        obj.quantity = $("#preorder-quantity").val();
    }
    
    obj.bizCategoryId = $("#bizCategoryId").val();
    return obj;
}

$(function(){
    // 选择附加服务时保存商品到购物车
    $(".addtion-change-quantity").live("change", function() {
        calculateItemPrice( $(this) );

        var type = $(this).data("type");
        if (type == "ROOM_DIFF") {
            saveToCache( $(this), null ) ;
        }
        if (type == "OTHER_TICKET") {
            saveToCache( $(this), "I_OTHER_TICKET" );
        }
        if (type == "INSURANCE") {
            saveToCache( $(this), "INSURANCE" );
        }
    });

    $('.fc-tip').poptip({
        offsetX: -24
    });  

    function toggleDiv(obj,isHidden){ 
        if(isHidden>0){
            $(obj).parents('.hotel-item').find('.adjust-product-item-detail').show();
        }else{
            $(obj).parents('.hotel-item').find('.adjust-product-item-detail').hide();
        }
    }

    // 商品详情页面展示
    $(".toggle-detail").live("click", function(e) {
    	var event = e || window.event;
        event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true); 
        var parent_div = $(this).parents('.hotel-item');
        var item_detail_hidden = parent_div.find('.adjust-product-item-detail:hidden').size();
        if(item_detail_hidden>0){
            var jj = this;
            setTimeout(function(){toggleDiv(jj,item_detail_hidden);},100);    
        }else{
            var jj = this;
            setTimeout(function(){toggleDiv(jj,item_detail_hidden);},100);   
        }
        $(this).find("i").toggleClass("arrow-up");
    });
    // 收起详情
    $(".collapse-detail").live("click",function(e) {
    	var event = e || window.event;
        event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
        $(this).parents(".adjust-product-item-detail").toggle();
        $(this).parents(".adjust-product-item-detail").siblings(".optional-insurance-item-name").find("i").toggleClass("arrow-up");
    });
    // 展开收起其他商品
    $("#adjust-optional .toggle-others").live("click", function(e) {
    	var event = e || window.event;
        event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
        $(this).parents(".insurance-detail-item").find(".other").toggle();
        var $i = $(this).find("i");
        if ($i.hasClass("arrow-blue-up")) {
            $i.removeClass("arrow-blue-up");
            $i.addClass("arrow-blue-down");
            $(this).find("span").text("展开");
        } else {
            $i.addClass("arrow-blue-up");
            $i.removeClass("arrow-blue-down");
            $(this).find("span").text("收起");
        }
    });
});

// 构造房差份数
//1、如果成人数为奇数：
//     房差默认选中1份，房差份数可选范围为所选成人数的所有奇数
//     如：成人数为5，则可选房差份数为1，3，5，默认选中1份
//2、如果成人数为偶数：
//     房差默认选中0份，房差份数可选范围为所选成人数的所有偶数份
//     如：成人数为4，则可选房差份数为0，2，4，默认选中0份
function genRoomDiffOptions() {
    var adultQuantity = $("#adultQuantity").val();
    var iniNum = 0;
    if (adultQuantity % 2 == 0) {
        iniNum = 0;
    } else {
        iniNum = 1;
    }
    var arr = new Array();
    for (var i = iniNum; i <= adultQuantity; i=i+2) {
        var str = "<option value=" + i + ">" + i + "</option>";
        arr.push(str);
    }
    $("#rommDiffSelect").html(arr.join(""));
}

// 构造保险份数
function genInsuranceCount(num) {
    var arr = new Array();
    var str0 = "<option value=" + 0 + ">" + 0 + "</option>";
    var str1 = "<option value=" + num + ">" + num + "</option>";
    arr.push(str0);
    arr.push(str1);
    return arr.join("");
}

// 选择份数时计算单个商品总价
function calculateItemPrice(obj) {
    var $this = obj;
    var count = Number( $this.val() );

    var $item = $this.parents(".optional-insurance-item");
    var $priceSpan = $item.find(".optional-insurance-single-price .price");
    var price = $priceSpan.find("span").text();

    $totalPriceSpan = $item.find(".optional-insurance-total-price").find(".total-price");
    $icon = $item.find(".optional-item-status i");
    var totalPrice = price * count;
    if (totalPrice != 0) {
        $totalPriceSpan.html( "￥" + totalPrice );
        $icon.addClass("product-item-checked-icon");
    } else {
        $totalPriceSpan.html( "--" );
        $icon.removeClass("product-item-checked-icon");
    }
}

//更换交通
$(function(){
    //更换其他交通按钮
    $('.flight-replace-button').live("click", function(e) { 
        initSortType(); //初始化更换交通排序规则
        iniChangeFlightDialog();
        var $content = $("#traffic_change");

        pandora.dialog({
            title: "更换其他机票",
            content: $content,
            width:1120,
            height: 660 
        });
    });

    //切换交通推荐和自由组合
    $('.traffic_tab li').live('click',function(){
        var num = $(this).index();
        $(this).addClass('active').siblings().removeClass('active');
        $('.traffic_change .traffic_type').eq(num).show().siblings('.traffic_type').hide();
    });

    function iniChangeFlightDialog() {
        $(".search_theme_list").find("dt").find("a").addClass("selected no_limit");
        $(".navListSpan").find("a").removeClass("selected");
        $(".traffic_list ").show();
        $(".fh_no_result").hide();
        
        $("#fh_qu_box").hide();
        $("#dep_fli_box").show();
        $("#arv_fli_box").hide();
        
        var depFlightCount = $("#dep_fli_box").find(".traffic_list").size();
        $("#dep_fli_box").find(".fh_all_tips").find("span").text( depFlightCount );
        
        var arvFlightCount = $("#arv_fli_box").find(".traffic_list").size();
        $("#arv_fli_box").find(".fh_all_tips").find("span").text( arvFlightCount );
    }

    /*机型参数*/
    $('.fh_type').live("hover" ,function(event){
        if(event.type=='mouseenter') { 
            var code = $(this).data("code");
            var name = $(this).data("name");
            var type = $(this).data("type");
            var minSeats = $(this).data("min");
            var maxSeats = $(this).data("max");
            var str = "<td>" + code + "</td>"
                + "<td>" + name + "</td>"
                + "<td>" + type + "</td>"
                + "<td>" + minSeats + "</td>"
                + "<td>" + maxSeats + "</td>";
            $("#airlineTr").html(str);

            var thisL = $(this).offset().left-20,
                thisT = $(this).offset().top+20,
                tanBox = $('.fh_type_box');
            tanBox.show().css({'left':thisL,'top':thisT});
        }else{ 
            $('.fh_type_box').hide();
        }
    });

     //包机里面的：选择按钮
    $('.js_fh_select').live('click',function(){
        $(this).hide().siblings('.btn').css('display','inline-block');
        $(this).parents('.traffic_list').addClass('active').siblings().removeClass('active').find('.btn-orange').show().siblings('.btn-dis').hide();

        //自由组合多仓位选择按钮
        var $xuanlist = $(this).parent('.fh_xuan_list'),
            cxbox = $(this).parents('.info_ul').find('.fh_cx_box');
        $xuanlist.siblings().find('.btn-orange').show().siblings('.btn-dis').hide();
        //选中置顶
        for (var i = 0; i < cxbox.length; i++) {
            cxbox.eq(i).prepend(cxbox.eq(i).find('p').eq($xuanlist.index()));
        };

        // 如果选择为去程航班
        chgFlightAjaxSubmit($(this).attr("go-flightno"), "CHARTER",$(this).attr("back-flightno")); 
        $(".dialog-close").trigger("click");
    });

    //去程选择按钮
    $('.dep_fh_select').live('click',function(e){
        var event = e || window.event;
        event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);

        // 如果选择为去程航班
        chgFlightAjaxSubmit($(this).data("flightno"), "DEPARTURE");

        $("#fh_qu_box").find(".info_li2").html( $(this).parents(".info_ul").find(".info_li2").clone() );
        $("#fh_qu_box").find(".info_li3").html( $(this).parents(".info_ul").find(".info_li3").clone() );
        $("#fh_qu_box").find(".info_li4").html( $(this).parents(".info_ul").find(".info_li4").clone() );
        $("#fh_qu_box").find(".info_li5").html( $(this).parents(".info_ul").find(".info_li5").clone() );
        $("#fh_qu_box").find(".info_li6").html( $(this).parents(".info_ul").find(".info_li6").clone() );
        $("#fh_qu_box").find(".info_li7").html( $(this).parents(".info_ul").find(".info_li7").clone() );
        $("#fh_qu_box").show();

        $("#dep_fli_box").hide();
        $("#arv_fli_box").show();
    });

    // 返程选择按钮
    $('.arv_fh_select').live('click',function(e) {
        var event = e || window.event;
        event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
        chgFlightAjaxSubmit($(this).data("flightno"), "RETURN");
         
        $(".dialog-close").off('click').bind('click',function(e){
                        $('.overlay').hide();
                        $('.hotel-dialog').hide();
        });

        $(".dialog-close").trigger("click");
    });

    // 筛选条件点击
    $(".navListSpan").live("click", function(e){
        var event = e || window.event;
        event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);

        var $list = $(this).parents(".search_theme_list");
        var $noLimit = $list.find("dt a"); // 不限选项
        var $thisItem = $(this).find("a"); // 其他选项

        if ($thisItem.hasClass("selected")) {
            $thisItem.removeClass("selected");
            var hasConditionFlag = false;
            $list.find(".navListSpan a").each(function(){
                if ($(this).hasClass("selected")) {
                    hasConditionFlag = true;
                }
            });
            if (!hasConditionFlag) {
                $noLimit.addClass("selected");
            }
        } else {
            $thisItem.addClass("selected");
            if ($noLimit.hasClass("selected")) {
                $noLimit.removeClass("selected");
            }
        }
        // 根据筛选条件过滤航班
        filterFlight( $(this) );
    });

    // 点击[不限]按钮
    $(".no_limit").live("click", function(e){
        var event = e || window.event;
        event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);

        if (!$(this).hasClass("selected")) {
            $(this).addClass("selected");
        }
        var $list = $(this).parents(".search_theme_list");
        var $item = $list.find(".navListSpan a");
        $item.each(function() {
            if ($(this).hasClass("selected")) {
                $(this).removeClass("selected");
            }
        });
        filterFlight( $(this) );
    });

    //清空筛选条件
    $(".nr-close-all").live("click", function(e) {
        var event = e || window.event;
        event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);

        $itemList = $(this).parents(".traffic_list_b");
        $itemList.find(".traffic_list").show();
        $itemList.find(".fh_no_result").hide();
        $(".no_limit").addClass("selected");
        $(".navListSpan a").removeClass("selected");

        countFlightRecord( $itemList );
    });
});//end____更换交通

function filterFlight(obj) {
    var $parents = obj.parents(".search_sort");
    var $carrierCodeDl = $parents.find(".carrierCodeDl");
    var $depSegmentDl =  $parents.find(".depSegmentDl");
    var $seatClassTypeDl = $parents.find(".seatClassTypeDl");
    var $traffic_list = $parents.parents(".fh_filter_box").siblings(".zuhe_traffic_list").find(".traffic_list_b");

    var carrier_key = getkeyStr( $carrierCodeDl.find(".navListSpan a") );
    var dep_key = getkeyStr( $depSegmentDl.find(".navListSpan a") );
    var seat_key = getkeyStr( $seatClassTypeDl.find(".navListSpan a") );

    if (carrier_key === "" && dep_key ==="" && seat_key ==="") {
        $traffic_list.find(".traffic_list").show();
        $traffic_list.find(".fh_no_result").hide();
        countFlightRecord( $traffic_list );
        return;
    }

    if (carrier_key !== "") {
        var arr1 = carrier_key.split(",");
    }
    if (dep_key !== "") {
        var arr2 = dep_key.split(",");
    }
    if (seat_key !== "") {
        var arr3 = seat_key.split(",");
    }

    var noResultflag = false;
    $traffic_list.find(".traffic_list").each(function() {
        var filterKey = $(this).data("filterkey");
        var filterArr = filterKey.split("|");
        var flag1 = false;
        var flag2 = false;
        var flag3 = false;

        if (arr1) {
            for (var i=0; i<arr1.length; i++) {
                if (arr1[i] === filterArr[0]) {
                    flag1 = true;
                }
            }
        }

        if (arr2) {
            for (var i=0; i<arr2.length; i++) {
                if (arr2[i] === filterArr[1]) {
                    flag2 = true;
                }
            }
        }

        if (arr3) {
            for (var i=0; i<arr3.length; i++) {
                if (arr3[i] === filterArr[2]) {
                    flag3 = true;
                }
            }
        }

        if ( $carrierCodeDl.find(".no_limit").hasClass("selected") ) {
            flag1 = true;
        }

        if ( $depSegmentDl.find(".no_limit").hasClass("selected") ) {
            flag2 = true;
        }

        if ( $seatClassTypeDl.find(".no_limit").hasClass("selected") ) {
            flag3 = true;
        }

        if (flag1 && flag2 && flag3) {
            $(this).show();
            noResultflag = true;
        } else {
            $(this).hide();
        }
    });
    if (!noResultflag) {
        $traffic_list.find(".fh_no_result").show();
    } else {
        $traffic_list.find(".fh_no_result").hide();
    }
    countFlightRecord( $traffic_list );
}

//计算航班列表的航班数
function countFlightRecord( $traffic_list_b ) {
    var totalFliCount = $traffic_list_b.find(".traffic_list").length;
    var hiddenFliCount = $traffic_list_b.find(".traffic_list:hidden").length;
    $traffic_list_b.parents(".zuhe_traffic_list").siblings(".fh_all_tips").find("span").text(totalFliCount - hiddenFliCount);
}

function getkeyStr(data) {
    var key = "";
    data.each(function() {
        if ($(this).hasClass("selected")) {
            key += $(this).find("i").data("code");
            key += ",";
        }
    });
    if (key.length >= 1) {
        key = key.substring(0, key.length-1);
    }
    return key;
}
// 提交更换航班ajax请求
function chgFlightAjaxSubmit(flightNo, tripType,backFlightNo) {
    //包机
    if (tripType === "CHARTER") { 
        $(".arvFlightBox").hide();
        $(".depFlightBox").hide();
        $("[tag=charsetflight]").each(function() {
            var no1 = $(this).attr("go-flightno");
            var no2 = $(this).attr("back-flightno");  
            if (no1 === flightNo && no2 === backFlightNo) {
                $(this).show();
                $(this).siblings("[tag=charsetflight]").hide();
                return;
            }
        }); 
        $("#selectDepFlightNo").val(flightNo);
        $("#selectArvFlightNo").val(backFlightNo);  
        $("#selectSaleType").val('DomesticProduct');
    }
    if (tripType === "DEPARTURE") { 
        $("[tag=charsetflight]").hide();
        $(".depFlightBox").each(function() {
            var no = $(this).data("flightno");
            if (no === flightNo) {
                $(this).show();
                $(this).siblings(".depFlightBox").hide();
                return;
            }
        });
        $("#selectDepFlightNo").val(flightNo);  
        if($("#selectSaleType").val()=='DomesticProduct'){
            $("#selectArvFlightNo").val('');  
            $("#selectSaleType").val('common'); 
        }
        $("#selectSaleType").val('common');
    }
    if (tripType === "RETURN") {
        $("[tag=charsetflight]").hide();
        $(".arvFlightBox").each(function() {
            var no = $(this).data("flightno");
            if (no === flightNo) {
                $(this).show();
                $(this).siblings(".arvFlightBox").hide();
                return;
            }
        });
        $("#selectArvFlightNo").val(flightNo); 
        if($("#selectSaleType").val()=='DomesticProduct'){
            $("#selectDepFlightNo").val('');  
            $("#selectSaleType").val('common'); 
        }
        $("#selectSaleType").val('common');
    }
    
    $.ajax({
        url: _data._contextPath + "/changeFlight",
        type:"post",
        data: {
            shoppingUuid : $("#shoppingUuid").val(),
            flightNo : flightNo,
            charsetBackflightNo : backFlightNo,
            flightTripType : tripType
        },
        success: function(data) {  
            var selectSaleType_v = $('#selectSaleType').val();
            if (tripType === "DEPARTURE") {
                $("#dep_traffic_list").html(data);
                var $dd = $("#dep_traffic_list .traffic_list");
                if(selectSaleType_v!='DomesticProduct'){ 
                    $("#dep_traffic_list .traffic_list").each(function(){
                        if ($(this).data("flightno") === flightNo) {
                            $(this).find(".btn-dis").css('display','inline-block').siblings('.btn-orange').hide();
                            $(this).addClass('active').siblings().removeClass('active').find('.btn-orange').show().siblings('.btn-dis').hide();
                            $("#dep_traffic_list").prepend( $(this) );
                        }
                    });
                }
            }
            if (tripType === "RETURN") {
                $("#arv_traffic_list").html(data);
                 if(selectSaleType_v!='DomesticProduct'){ 
                    $("#arv_traffic_list .traffic_list").each(function(){
                        if ($(this).data("flightno") === flightNo) {
                            $(this).find(".btn-dis").css('display','inline-block').siblings('.btn-orange').hide();
                            $(this).addClass('active').siblings().removeClass('active').find('.btn-orange').show().siblings('.btn-dis').hide();
                            $("#arv_traffic_list").prepend( $(this) );
                        }
                    });
                }
            }
            if (tripType === "CHARTER") {
                $("#charset_flight_list").html(data);
                if(selectSaleType_v =='DomesticProduct'){ 
                    $("#charset_flight_list .traffic_list").each(function(){
                        if ($(this).data("flightno") === flightNo) {
                            $(this).find(".btn-dis").css('display','inline-block').siblings('.btn-orange').hide();
                            $(this).addClass('active').siblings().removeClass('active').find('.btn-orange').show().siblings('.btn-dis').hide();
                            $("#charset_flight_list").prepend( $(this) );
                        }
                    });
                }
            }
            initPriceInBaseInfo();
        }
    });
}
 

$(function() {
    $(".replace-hotelCombo-btn").live("click", showHotelComboDialog );
  	$(".toggle-hotelCombo").live("click", showHotelComboDialog );
   	$(".do-select-action").live("click", selectBtnClick);
});

function showHotelComboDialog(e) {
    var event = e || window.event;
    event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
    $('.overlay').show(); 
    var $content = $('#adjust-hotel-package').find("#hotelComboContentDiv"); 
    pandora.dialog({
        title: "更换其他酒店套餐",
        skin: "hotelcombo-dialog",
        content: $content,
        width: "900px",
        height: "550px",
        initialize: function() { 
            $(".dialog-close").bind('click',function(e){
                $('.overlay').hide();
                $('.hotelcombo-dialog').hide(); 
            });
        }
    });
}

function selectBtnClick(e) {
    var event = e || window.event;
    event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);

    var shoppingUuid = $("#shoppingUuid").val();
    $item = $(this).parents(".dialog-item");
    var goodsId = $item.attr("data-suppGoodsId");

    $("#hotelComboContentDiv").find(".dialog-item").each(function(e) {
        var curGoodsId = $(this).attr("data-suppGoodsId");
        if (goodsId === curGoodsId) {
            var $status = $(this).find(".status");
            $status.html("<i class=\"product-item-checked-icon\"></i>");
        } else {
            var $status = $(this).find(".status");
            $status.html("<button class=\"btn btn-mini do-select-action\">选择</button>");
        }
    });

    $.ajax({
        url: _data._contextPath + "/changeHotelCombo",
        type:"post",
        data: {
            shoppingUuid : shoppingUuid,
            suppGoodsId : goodsId
        },
        success: function(data) {
           	 $("#adjust-hotel-package").html(data);  
            //这里关闭弹出框
            $(".dialog-close").trigger("click");  
            //下面刷新价格 
            initPriceInBaseInfo();
        }
    });
}
$("#toFliBtn").live("click", function(e) {
    var event = e || window.event;
    event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
    $("#fh_qu_box").hide();
    $("#dep_fli_box").show();
    $("#arv_fli_box").hide();
});
$("#backFliBtn").live("click", function(e) {
    var event = e || window.event;
    event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
    
    $activeItem = $("#dep_traffic_list").find(".active .info_ul");
    $("#fh_qu_box").find(".info_li2").html( $activeItem.find(".info_li2").clone() );
    $("#fh_qu_box").find(".info_li3").html( $activeItem.find(".info_li3").clone() );
    $("#fh_qu_box").find(".info_li4").html( $activeItem.find(".info_li4").clone() );
    $("#fh_qu_box").find(".info_li5").html( $activeItem.find(".info_li5").clone() );
    $("#fh_qu_box").find(".info_li6").html( $activeItem.find(".info_li6").clone() );
    $("#fh_qu_box").find(".info_li7").html( $activeItem.find(".info_li7").clone() );
    $("#fh_qu_box").show();
    
    $("#arv_fli_box").show();
    $("#dep_fli_box").hide();
});

function initSortType() {
    window.sortFlight={};
    var toSortRuleType = $("#toSortRuleType").val();
    var backSortRuleType = $("#backSortRuleType").val(); 
    if (toSortRuleType === "SORT_BY_DEPTIME_ASC") {
        sortFlight.depTimeSortType = "ASC";
        sortFlight.depPriceSortType= "ASC";
        sequenceFlight("departureTime", "DEPARTURE", "ASC");
        sequenceFlight("departureTime", "CHARTER", "ASC");
        $("#dep_fli_box").find(".traffic_info_list").find(".info_li3").addClass("sort_active").siblings().removeClass("sort_active"); 
        $("#charset_flight_list").find(".traffic_info_list").find(".info_li3").addClass("sort_active").siblings().removeClass("sort_active");
    }
    if (toSortRuleType === "SORT_BY_PRICE_ASC") {
        sortFlight.depTimeSortType = "ASC";
        sortFlight.depPriceSortType= "ASC";
        sequenceFlight("differentPrice", "DEPARTURE", "ASC");
        sequenceFlight("differentPrice", "CHARTER", "ASC");
        $("#dep_fli_box").find(".traffic_info_list").find(".info_li8").addClass("sort_active").siblings().removeClass("sort_active"); 
        $("#charset_flight_list").find(".traffic_info_list").find(".info_li8").addClass("sort_active").siblings().removeClass("sort_active");
    }
    if (backSortRuleType === "SORT_BY_DEPTIME_ASC") {
        sortFlight.arrTimesortType = "ASC";
        sortFlight.arrPricesortType= "ASC";
        sequenceFlight("departureTime", "RETURN", "ASC"); 
        $("#arv_fli_box").find(".traffic_info_list").find(".info_li3").addClass("sort_active").siblings().removeClass("sort_active");  
    }
    if (backSortRuleType === "SORT_BY_PRICE_ASC") {
        sortFlight.arrTimesortType = "ASC";
        sortFlight.arrPricesortType= "ASC";
        sequenceFlight("differentPrice", "RETURN", "ASC");
        $("#arv_fli_box").find(".traffic_info_list").find(".info_li8").addClass("sort_active").siblings().removeClass("sort_active"); 
    }
    $(".traffic_info_list li").removeClass("sort_down");
}

$('.sort_btn').live('click',function(e) {
    var event = e || window.event;
    event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true); 
    $(this).addClass("sort_active");
    $(this).siblings(".sort_btn").removeClass("sort_active");
    $(this).toggleClass("sort_down");
   	var $dep_fli_box = $(this).parents("#dep_fli_box");
   	var $arv_fli_box = $(this).parents("#arv_fli_box");
   	var $rec_fli_box = $(this).parents("#recommend_fli_box");
    if($dep_fli_box.length>0){
   		if($(this).hasClass("info_li3")){//去程起飞时间字段
       		if(sortFlight.depTimeSortType === "ASC"){
                sortFlight.depTimeSortType = "DESC";
            }else{
                sortFlight.depTimeSortType = "ASC";
            }
            sequenceFlight("departureTime","DEPARTURE",sortFlight.depTimeSortType);
   		}else if($(this).hasClass("info_li8")){//去程差价字段
   		    if(sortFlight.depPriceSortType === "ASC"){
   		        sortFlight.depPriceSortType = "DESC";
   		    }else{
   		        sortFlight.depPriceSortType = "ASC";
   		    }
   			sequenceFlight("differentPrice","DEPARTURE",sortFlight.depPriceSortType);
   		}
   	}else if($arv_fli_box.length>0){
   		if($(this).hasClass("info_li3")){//返程起飞时间字段
			if(sortFlight.arrTimesortType === "ASC"){
				sortFlight.arrTimesortType = "DESC";
			}else{
				sortFlight.arrTimesortType = "ASC";
			}
			sequenceFlight("departureTime","RETURN",sortFlight.arrTimesortType);
   		}else if($(this).hasClass("info_li8")){//返程差价字段
   			if(sortFlight.arrPricesortType === "ASC"){
   				sortFlight.arrPricesortType = "DESC";
   			}else{
   				sortFlight.arrPricesortType = "ASC";
   			}
   			sequenceFlight("differentPrice","RETURN",sortFlight.arrPricesortType);
   		}
   	}
    //推荐包机航班的排序
    else if($rec_fli_box.length>0){
        if($(this).hasClass("info_li3")){//返程起飞时间字段
            if(sortFlight.arrTimesortType === "ASC"){
                sortFlight.arrTimesortType = "DESC";
            }else{
                sortFlight.arrTimesortType = "ASC";
            }
            sequenceFlight("departureTime","CHARTER",sortFlight.arrTimesortType);
        }else if($(this).hasClass("info_li8")){//返程差价字段
            if(sortFlight.arrPricesortType === "ASC"){
                sortFlight.arrPricesortType = "DESC";
            }else{
                sortFlight.arrPricesortType = "ASC";
            }
            sequenceFlight("differentPrice","CHARTER",sortFlight.arrPricesortType);
        }
    }


});

function sequenceFlight(sortStr,flightTripType,sortType){
	var flightNo = "";
     $.ajax({
        url: _data._contextPath + "/sequenceFlight",
        type:"post",
        data: {
            shoppingUuid : $("#shoppingUuid").val(),
            sortStr : sortStr,
            flightTripType : flightTripType,
            sortType : sortType
        },
        success: function(data) {
            console.log("sequenceFlight---"+flightTripType+"---$('#selectSaleType').val()==="+$('#selectSaleType').val());
            if (flightTripType === "DEPARTURE") {
                $("#dep_traffic_list").html(data);
                flightNo = $("#selectDepFlightNo").val();
                var selectSaleType_v = $('#selectSaleType').val();
                if(selectSaleType_v!='DomesticProduct'){
                    $("#dep_traffic_list .traffic_list").each(function(){
    	                if ($(this).data("flightno") === flightNo) {
    	                    $(this).find(".btn-dis").css('display','inline-block').siblings('.btn-orange').hide();
    	                    $(this).addClass('active').siblings().removeClass('active').find('.btn-orange').show().siblings('.btn-dis').hide();
    	                    $("#dep_traffic_list").prepend($(this));
    	                }
                    });
                    $("#dep_fli_box").find(".navListSpan").each(function(){
                        if ($(this).find("a").hasClass("selected")) {
                            filterFlight( $(this) );
                        }
                    });
                }else{
                     $("#dep_traffic_list .traffic_list").each(function(){ 
                             $(this).siblings().removeClass('active').find('.btn-orange').show().siblings('.btn-dis').hide();
                    });
                }
            }

            if (flightTripType === "RETURN") {
                $("#arv_traffic_list").html(data);
                var selectSaleType_v = $('#selectSaleType').val();
                if(selectSaleType_v!='DomesticProduct'){
                    flightNo = $("#selectArvFlightNo").val();
                    $("#arv_traffic_list .traffic_list").each(function(){
                        if ($(this).data("flightno") === flightNo) {
                            $(this).find(".btn-dis").css('display','inline-block').siblings('.btn-orange').hide();
                            $(this).addClass('active').siblings().removeClass('active').find('.btn-orange').show().siblings('.btn-dis').hide();
                            $("#arv_traffic_list").prepend($(this));
                        }
                    });
                    $("#arv_fli_box").find(".navListSpan").each(function(){
                        if ($(this).find("a").hasClass("selected")) {
                            filterFlight( $(this) );
                        }
                    });
                }else{
                     $("#arv_traffic_list .traffic_list").each(function(){ 
                           $(this).siblings().removeClass('active').find('.btn-orange').show().siblings('.btn-dis').hide();
                    });
                }
            }

            if (flightTripType === "CHARTER") {   
                $("#charset_flight_list").html(data);
                var selectSaleType_v = $('#selectSaleType').val();
                var flightNo_to = $("#selectDepFlightNo").val();
                var flightNo_back = $("#selectArvFlightNo").val();
                if(selectSaleType_v=='DomesticProduct'){
                    //迁移到最上面，当前选择的航班.
                    $("#charset_flight_list .traffic_list").each(function(){ 
                        if ($(this).data("flightno") === flightNo_to && $(this).data("backflightno") === flightNo_back) { 
                            $(this).find(".btn-dis").css('display','inline-block').siblings('.btn-orange').hide();
                            $(this).addClass('active').siblings().removeClass('active').find('.btn-orange').show().siblings('.btn-dis').hide();
                            $("#charset_flight_list").prepend($(this));
                        }
                    }); 
                }else{
                     $("#charset_flight_list .traffic_list").each(function(){ 
                            $(this).siblings().removeClass('active').find('.btn-orange').show().siblings('.btn-dis').hide();
                    });
                }
            }
        }
    });
}
$(".js_tips").hover(function(){
    $(this).css('cursor','pointer');
});
$(".js_tips").poptip();

//弹出酒店
    $(function () {
        /**
         * showYinDialog 显示酒店/门票弹窗
         * @param {boolean} isTicketDialog 是否为门票弹窗
         * @param {boolean} isCommented 是否有评论
         * @param {boolean} isMultipleImages 是否为多张图片
         */
        $(".JS_yin_hotel_dialog").live("click", function(){
            showYinDialog(false, true, false);
            setTimeout(removeYinDialogLoading,2000);
        });

        $(".yin-dialog-change-hotel").live("click", function(){
            var groupid = $(this).attr('group_id');
            var group = $('div[data-groupId='+groupid+'][data-type=hotel]').eq(0);
            if($('#adjust-hotel-outer').find("#hotelGroupContentDiv"+groupid).size()==0){
                return;
            }
            $('.overlay').show();
            $('div.hotel-dialog').remove();
            pandora.dialog({
                title: "更换其他酒店&emsp;<small>入住"+group.attr('data-dayOfDuration')+"晚&emsp;入住："+group.attr('data-checkin')+"&emsp;离店："+group.attr('data-checkout')+"</small>",
                content: $('#adjust-hotel-outer').find("#hotelGroupContentDiv"+groupid),
                width: "900px",
                height: "550px",
                skin: "dialog-default hotel-dialog", //模板名称
                initialize: function() {
                    var $dialog = this.wrap;
                    var $body = $dialog.find(".dialog-body");
                    var $foot = $dialog.find(".dialog-footer");
                    $foot.hide();
                    $body.css({
                        "height": $body.height()+20
                    });
                    hideLoading();
                    $(".dialog-close").bind('click',function(e){
                        $('.overlay').hide();
                        $('.hotel-dialog').hide();
                    });
                }
            });
        });


        //房型的下拉菜单的选择事件也出发更新缓存.
        $(".lvmama-price-flag[roomquantity][ispop=0]").live("change",function(e){
            var event = e || window.event;
            event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
            //var _v = $('option:selected',this).val();
            //var _t = $(this).attr('data-detailid-suppgoodsid');
            //设置全部的下拉菜单同步变化为一样的val.
            //$('.lvmama-price-flag[roomquantity][ispop=1][data-detailid-suppgoodsid='+_t+']').removeAttr('ispop').val(_v).attr('ispop',"1");

            //基本页面的下拉菜单的情况
            var hasChoosed = $(this).parent().parent().find('.product-item-checked-icon').size(); 
            //如果当前选中了就进行价格的查询
            if(hasChoosed>0){
                changeHotelSelect(this);
            }
        }) ;

        //弹出详情页面里面的下拉菜单的情况
         $(".lvmama-price-flag[roomquantity][ispop=1]").live("change",function(e){
            var event = e || window.event;
            event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
            //var _v = $('option:selected',this).val();
            //var _t = $(this).attr('data-detailid-suppgoodsid');
            //设置全部的下拉菜单同步变化为一样的val.
            //$('.lvmama-price-flag[roomquantity][ispop=0][data-detailid-suppgoodsid='+_t+']').removeAttr('ispop').val(_v).attr('ispop',"0");

            //弹出详情页面里面的下拉菜单的情况
            var hasChoosed2 = $(this).parent().parent().find('.product-item-checked-icon').size();
            //如果当前选中了就进行价格的查询
            if(hasChoosed2>0){
                changeHotelSelect2(this);
            }

        }) ;

        //设置弹出框里面的选择按钮的事件，以及默认基本信息里面的选择按钮事件
        $(".js_yhir_room_select_btn").live("click", changeHotelButton);

    });

    function changeHotelSelect(obj,e) { 
        var er = e || window.event; 
        if(er){
            er.stopPropagation ? er.stopPropagation() : (er.cancelBubble = true);
        }
        var shoppingUuid = $("#shoppingUuid").val();
        var $item = $(obj);
        var $hotel = $item.parent().parent();
        var roomCount = $item.find('option:selected').val();
        var goodsId = $hotel.attr("data-goodsid");
        var groupId = $hotel.attr("data-groupid");
        var hotelId = $hotel.attr("data-hotelid");
        var roomId = $hotel.attr("data-roomid");

        changeHotelPost(shoppingUuid,groupId,hotelId,roomId,roomCount,goodsId); 

        return false;
    }

    function changeHotelSelect2(obj,e) {
        var er = e || window.event;
        if(er){
           er.stopPropagation ? er.stopPropagation() : (er.cancelBubble = true);
        }
        var shoppingUuid = $("#shoppingUuid").val();
        var $item = $(obj);
        var $hotel = $item.parent().next('.yhir-room-opertion');
        var roomCount = $item.find('option:selected').val();
        var goodsId = $hotel.attr("data-goodsid");
        var groupId = $hotel.attr("data-groupid");
        var hotelId = $hotel.attr("data-hotelid");
        var roomId = $hotel.attr("data-roomid");

        changeHotelPost(shoppingUuid,groupId,hotelId,roomId,roomCount,goodsId);
        return false;
    }

    //点击弹出的div里面的选择按钮.
    function changeHotelButton(e) {
        var er = e || window.event;
        if(er){
           er.stopPropagation ? er.stopPropagation() : (er.cancelBubble = true);
        }
        var $item = $(e.currentTarget)
        var shoppingUuid = $("#shoppingUuid").val();
        var roomCount = $item.parent().parent().find('select option:selected').val();
        var goodsId = $item.attr("data-goodsid");
        var groupId = $item.attr("data-groupid");
        var hotelId = $item.attr("data-hotelid");
        var roomId = $item.attr("data-roomid");

        changeHotelPost(shoppingUuid,groupId,hotelId,roomId,roomCount,goodsId);
        return false;
    }

    /**
     * 修改选择的房型.
     */
    function changeHotelPost(a,b,c,d,ee,f) {
        $.ajax({
            url: _data._contextPath + "/changeHotel",
            type:"post",
            data: {
                shoppingUuid : a,
                groupId : b,
                hotelId : c,
                roomId : d,
                roomCount : ee,
                suppGoodsId : f
            },
            success: function(data) {
                //这里关闭弹出框
                $("#adjust-hotel-outer").html(data);
                $(".dialog-close").off('click').bind('click',function(e){
                        $('.overlay').hide();
                        $('.hotel-dialog').hide();
                 });
                 $(".dialog-close").trigger("click");

                //下面刷新价格
                initPriceInBaseInfo();

            }
        });
    }

    $(function() {
        // 酒店的详情展示
        $(".toggle-detail").live("click", function(e) {
            var event = e || window.event;
            event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
            $(this).parents(".hotel-item-name").siblings(".adjust-product-item-detail").toggle();
        });
        // 收起酒店的详情
        $(".collapse-detail span").live("click",function(e) {
            var event = e || window.event;
            event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
            $(this).parents(".adjust-product-item-detail").toggle();
            $(this).parents(".adjust-product-item-detail").siblings(".hotel-item-name").find("i").toggleClass("arrow-up");
        });

        $(".lvmama-price-flag").live("change",function(e){
            var nocalFlag = $(this).data("nocalflag");
            if(nocalFlag != 'Y'){

            }
        })
        priceFresh();
    });
    cmCreateElementTag('001_${category_name}_${productType_name}_${packageType_name}_加载商品信息','产品详情页');

    function otherFangxing(me){
        var $temp = $(me).siblings('.otherFangxing');
        $temp.toggle();
        if($temp.is(':hidden')==true){
            $(me).find('span').text('展开其它房型').siblings('i').addClass('arrow-blue-down').removeClass('arrow-blue-up');
        }else{
            $(me).find('span').text('收起其它房型').siblings('i').removeClass('arrow-blue-down').addClass('arrow-blue-up');
        }
    }

    /**
     *展开房型的选择
     */
    function fangXinChange(me){
        var otherFangxingDIV = $(me).closest('.otherFangxing');
        var defaultFangxingDIV = $(me).closest('.otherFangxing').siblings('.defaultFangxing');
        $(defaultFangxingDIV).find('.hotel-item').find('.hotel-item-quantity').find('.lvmama-price-flag').removeClass().addClass('lvmama-price-flagMore');
        $(otherFangxingDIV).find('.hotel-item').find('.hotel-item-quantity').find('.lvmama-price-flagMore').removeClass().addClass('lvmama-price-flag');

        var oldSuppGoodsId = $(defaultFangxingDIV).find("input[name=setSuppGoodsId]").val();
        var oldDetailId = $(defaultFangxingDIV).find("input[name=setDetailId]").val();
        var oldGroupId = $(defaultFangxingDIV).find("input[name=setGroupId]").val();
        var oldProductbranchid = $(defaultFangxingDIV).find("input[name=setCurrentProductBranchId]").val();

        var newSuppGoodsId = $(otherFangxingDIV).find("input[name=setSuppGoodsId]").val();
        var newDetailId = $(otherFangxingDIV).find("input[name=setDetailId]").val();
        var newGroupId = $(otherFangxingDIV).find("input[name=setGroupId]").val();
        var newDefaultQuantity = $(otherFangxingDIV).find("input[name=setDefaultQuantity]").val();
        var newProductbranchid = $(otherFangxingDIV).find("input[name=setCurrentProductBranchId]").val();

        var newSelected = otherFangxingDIV.html();
        var oldSelected = defaultFangxingDIV.html();

        otherFangxingDIV.html(oldSelected);
        otherFangxingDIV.find('.option').html('<a href="javascript:;" onclick="fangXinChange(this)"> 选择</a>');

        defaultFangxingDIV.html(newSelected);
        defaultFangxingDIV.find('.option').html('<i class="product-item-checked-icon"></i>');


        var hotelTopDiv = $(defaultFangxingDIV).closest('.right-container').siblings('.hotelTopDiv');
        var replaceButton = $(defaultFangxingDIV).closest('.detail').siblings('.replace').find('.replace-button');

        $(hotelTopDiv).removeClass();
        $(hotelTopDiv).addClass('hotelTopDiv need-submit-data' + ' params-hotel-'+newDetailId + '-' + newSuppGoodsId);
        $(hotelTopDiv).attr('data-goodsId',newSuppGoodsId);
        $(hotelTopDiv).attr('data-quantity',newDefaultQuantity);
        $(hotelTopDiv).attr('data-detailid',newDetailId);
        $(replaceButton).attr('data-currentproductbranchid',newProductbranchid);
        $(replaceButton).attr("data-defaultsuppgoodsid",newSuppGoodsId);

        $("#"+oldGroupId+"_"+oldProductbranchid).attr("id",newGroupId + "_" + newProductbranchid);


        priceFresh();
    }

    function priceFresh(){
        $(".hotel-item-price").parents(".defaultFangxing").each(function(e){
            $(this).find('.hotel-item .hotel-item-price .price').text("--");

            var selectedPrice = $(this).find('.hotel-item .hotel-item-price .price').attr('data-price');

            $(this).siblings('.otherFangxing').each(function(){
                var otherPrice = $(this).find('.hotel-item .hotel-item-price .price').attr('data-price');
                var diffrentPrice = otherPrice-selectedPrice;
                if(diffrentPrice == 0){
                    $(this).find('.hotel-item .hotel-item-price .price').text("--");
                }else if(diffrentPrice > 0){
                    $(this).find('.hotel-item .hotel-item-price .price').text("￥ +" + diffrentPrice/100);
                }else if(diffrentPrice < 0){
                    $(this).find('.hotel-item .hotel-item-price .price').text("￥ -" + diffrentPrice/100);
                }
            });
        });
    }