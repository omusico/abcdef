var allCities = ['北京|beijing|bj|PEK', '上海|shanghai|sh|SHA', '重庆|chongqing|cq|CKG', '深圳|shenzhen|sz|SZX', '广州|guangzhou|gz|CAN', '杭州|hangzhou|hz|HGH',
    '南京|nanjing|nj|NKG',  '天津|tianjin|tj|TSN', '成都|chengdu|cd|CTU', '南昌|nanchang|nc|KHN', '三亚|sanya|sy|SYX', '青岛|qingdao|qd|TAO','武汉|wuhan|wh|WUH',
    '厦门|xiamen|xm|XMN', '西安|xian|xa|XIY', '长沙|changsha|cs|CSX', '合肥|hefei|hf|HFE', '安庆|anqing|aq|AQG', '安顺|anshun|as|AVA','阿勒泰|aletai|alt|AAT', '鞍山|anshan|as|AOG','阿里|ali|al|NGQ','阿尔山|aershan|aes|YIE',
    '阿克苏|akesu|aks|AKU', '包头|baotou|bt|BAV', '北海|beihai|bh|BHY', '百色|baise|bs|AEB','巴彦淖尔|bayannaoer|byne|RLK', '保山|baoshan|bs|BSD', '毕节|bijie|bj|BFJ','博乐|bole|bl|BPL','长治|changzhi|cz|CIH', '长春|changchun|cc|CGQ', '常州|changzhou|cz|CZX', '昌都|changdu|cd|BPX',
    '朝阳|chaoyang|cy|CHG', '常德|changde|cd|CGD', '长白山|changbaishan|cbs|NBS', '赤峰|chifeng|cf|CIF', '池州|chizhou|cz|JUH','大同|datong|dt|DAT', '大连|dalian|dl|DLC', '东营|dongying|dy|DOY', '迪庆|diqing|dq|DIG', '丹东|dandong|dd|DDG','达州|dazhou|dz|DAX','稻城|daocheng|dc|DCY',
    '大理|dali|dl|DLU', '敦煌|dunhuang|dh|DNH', '鄂尔多斯|eerduosi|eeds|DSN', '恩施|enshi|es|ENH', '二连浩特|erlianhaote|elht|ERL','福州|fuzhou|fz|FOC', '阜阳|fuyang|fy|FUG', '佛山|foshan|fs|FUO','贵阳|guiyang|gy|KWE','赣州|ganzhou|gz|KOW',
    '桂林|guilin|gl|KWL', '广元|guangyuan|gy|GYS', '格尔木|geermu|gem|GOQ','固原|guyuan|gy|GYU', '呼和浩特|huhehaote|hhht|HET', '哈密|hami|hm|HMI',
    '黑河|heihe|hh|HEK', '海拉尔|hailaer|hle|HLD', '哈尔滨|haerbin|heb|HRB', '海口|haikou|hk|HAK', '黄山|huangshan|hs|TXN', '邯郸|handan|hd|HDG',
    '汉中|hanzhong|hz|HZG', '和田|hetian|ht|HTN', '淮安|huaian|ha|HIA','怀化|huaihua|hh|HJJ','惠州|huizhou|hz|HUZ', '锦州|jinzhou|jz|JNZ', '景德镇|jingdezhen|jdz|JDZ',
    '嘉峪关|jiayuguan|jyg|JGN', '鸡西|jixi|jx|JXA','加格达奇|jiaerdaqi|jedq|JGD','井冈山|jinggangshan|jgs|JGS','金昌|jinchang|jc|JIC', '济宁|jining|jn|JNG', '九江|jiujiang|jj|JIU','九寨沟|jiuzhaigou|jzg|JZH', '佳木斯|jiamusi|jms|JMU', '济南|jinan|jn|TNA','揭阳|jieyang|jy|SWA',
    '喀什|kashi|ks|KHG', '昆明|kunming|km|KMG', '康定|kangding|kd|KGT', '凯里|kaili|kl|KJH','喀纳斯|kanasi|kns|KJI','克拉玛依|kelamayi|klmy|KRY', '库尔勒|kuerle|kel|KRL', '库车|kuche|kc|KCA', '兰州|lanzhou|lz|LHW',
    '洛阳|luoyang|ly|LYA', '丽江|lijiang|lj|LJG', '荔波|libo|lb|LLB','吕梁|lvliang|ll|LLV','六盘水|liupanshui|lps|LPF','林芝|linzhi|lz|LZY', '柳州|liuzhou|lz|LZH', '泸州|luzhou|lz|LZO', '连云港|lianyungang|lyg|LYG', '黎平|liping|lp|HZH','龙岩|longyan|ly|LCX',
    '拉萨|lasa|ls|LXA', '临沧|lincang|lc|LNJ', '临沂|linyi|ly|LYI', '芒市|mangshi|ms|LUM', '牡丹江|mudanjiang|mdj|MDG', '满洲里|manzhouli|mzl|NZH', '绵阳|mianyang|my|MIG',
    '漠河|mohe|mh|OHE', '南充|nanchong|nc|NAO', '南宁|nanning|nn|NNG', '南阳|nanyang|ny|NNY', '南通|nantong|nt|NTG', '那拉提|nalati|nlt|NLT',
    '宁波|ningbo|nb|NGB', '攀枝花|panzhihua|pzh|PZI','普洱|puer|pe|SYM', '衢州|quzhou|qz|JUZ','泉州|quanzhou|qz|JJN', '秦皇岛|qinhuangdao|qhd|SHP','日喀则|rikaze|rkz|RKZ','日照|rizhao|rz|RIZ', '庆阳|qingyang|qy|IQN', '齐齐哈尔|qiqihaer|qqhe|NDG',
    '石家庄|shijiazhuang|sjz|SJW', '沈阳|shenyang|sy|SHE', '铜仁|tongren|tr|TEN', '塔城|tacheng|tc|TCG','唐山|tangshan|ts|TVS', '腾冲|tengchong|tc|TCZ', '台州|taizhou|tz|HYN',
    '通辽|tongliao|tl|TGO','天水|tianshui|ts|THQ', '太原|taiyuan|ty|TYN', '威海|weihai|wh|WEH', '梧州|wuzhou|wz|WUZ', '文山|wenshan|ws|WNH', '无锡|wuxi|wx|WUX', '潍坊|weifang|wf|WEF', '武夷山|wuyishan|wys|WUS', '武陵山|wulinshan|wls|JIQ','乌兰浩特|wulanhaote|wlht|HLH',
    '温州|wenzhou|wz|WNZ', '乌鲁木齐|wulumuqi|wlmq|URC', '万州|wanzhou|wz|WXN', '乌海|wuhai|wh|WUA', '兴义|xingyi|xy|ACX', '西昌|xichang|xc|XIC', '襄樊|xiangfan|xf|XFN',
    '西宁|xining|xn|XNN', '锡林浩特|xilinhaote|xlht|XIL', '西双版纳|xishuangbanna|xsbn|JHG', '徐州|xuzhou|xz|XUZ', '义乌|yiwu|yw|YIW', '永州|yongzhou|yz|LLF', '榆林|yulin|yl|UYN', '延安|yanan|ya|ENY', '运城|yuncheng|yc|YCU',
    '烟台|yantai|yt|YNT', '银川|yinchuan|yc|INC', '宜昌|yichang|yc|YIH', '宜春|yichun|yc|YIC','宜宾|yibin|yb|YBP', '盐城|yancheng|yc|YNZ','扬州|yangzhou|yz|YTY', '延吉|yanji|yj|YNJ', '玉树|yushu|ys|YUS', '伊宁|yining|yn|YIN', '珠海|zhuhai|zh|ZUH', '昭通|zhaotong|zt|ZAT',
    '张家界|zhangjiajie|zjj|DYG','张家口|zhangjiakou|zjk|ZQZ','张掖|zhangye|zy|YZY', '舟山|zhoushan|zs|HSN', '郑州|zhengzhou|zz|CGO', '中卫|zhongwei|zw|ZHY','中山|zhongshan|zs|ZGN', '湛江|zhanjiang|zj|ZHA','遵义|zhunyi|zy|ZYI',
    '阿拉善右旗|alashanyouqi|alsyq|RHT','阿拉善左旗|alashanzuoqi|alszq|AFX','安康|ankang|ak|AKA','长海|changhai|ch|CNI','德令哈|delingha|dlh|HXD','额济纳旗|ejinaqi|ejnq|EJN','抚远|fuyuan|fy|FYJ','富蕴|fuyun|fy|FYN','河池|hechi|hc|HCJ','衡阳|hengyang|hy|HNY','红原|hongyuan|hy|AHJ',
    '花土沟|huatugou|htg|HTT','宁蒗|ninglang|nl|NLH','且末|qiemo|qm|IQM','三明|sanming|sm|SQJ','神农架|shennongjia|snj|HPG','通化|tonghua|th|TNH','吐鲁番|tulufan|tlf|TLQ','夏河|xiahe|xh|GXH','忻州|xinzhou|xz|WUT'
];

var _shoppingUUID = $("#shoppingUUID").val();

$(function() {
    if ($("#departureCityName").val() == "" || $("#departureCityName").val() == "请输入出发地") {
        var cityName = $("#currentCity").text();
        $("#departureCityName").val(cityName);
    }

    var errorMsgOutTime = $("#errorMsgOutTime").val();
    if(errorMsgOutTime=='') {
        initTicket();
        initInsurance();
        // 如果为单程，返程日期disable
        var tripType = $("#tripType").val();
        if (tripType == "DC") {
            $(".fh-return-day-group").addClass("fh-input-group-disable");
        }
        initAjax();
        // 初始化购物车中的产品信息，产品选择模块的默认值
        initProduct();
    }
});

function writeSearchRecord() {
    var searchCondition = $("#tripType").val()+"|"+$("#departureCityCode").val()+"|"+$("#arrivalCityCode").val()+"|"+$("#cityCode").val()+"|"+$("#flightStartDate").val()+"|"+$("#flightEndDate").val()+"|"+$("#hotelStartDate").val()+"|"+$("#hotelEndDate").val()+"|"+$("#adultsCount").val()+"|"+$("#childCount").val();
    if(window.localStorage) {
        window.localStorage.setItem('searchCondition', searchCondition);
    }
}


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


$(".select-class").live("click", function(e) {
    var event = e || window.event;
    event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);

    var left = $(this).offset().left;
    var top = $(this).offset().top + $(this).offsetHeight;
    $(this).siblings(".select-class-list").css("left", left).css("top", top).show();
});

//更换舱位
$(".select-class-list li").live("click", function(e) {
    var event = e || window.event;
    event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);

    var shoppingUUID = $("#shoppingUUID").val();
    var flightNo = $(this).data("flightno");
    var seatCode = $(this).data("code");
    var flightType = $(this).data("type");
    $.ajax({
        type: "post",
        url: baseUrl + "/shopping/changeSeat",
        data: {
            shoppingUUID : shoppingUUID,
            flightNo: flightNo,
            seatCode: seatCode,
            flightType: flightType
        },
        success: function(data) {
            if (flightType === "DEPARTURE") {
                $("#to_flightInfo").html(data);
            }
            if (flightType === "RETURN") {
                $("#back_flightInfo").html(data);
            }
            initAjax();
        }
    });
});

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
                if (obj.result.comboPromotionAmount > 0) {
                    $("#promotion").html(obj.result.comboPromotionAmount);
                    $(".price-discount").show();
                }
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

$(".xuanze").die().live("click",function() {
    var $dd = $(this).parents("dd");
    var productId = $dd.data('productid');
    var branchId  = $dd.data('branchid');
    var suppGoodsId = $dd.data('goodsid');
    var roomCount = $dd.siblings(".roomTable-td4").find(".select-div span").text();

    $.ajax({
        type: "post",
        url: baseUrl + "/shopping/changePlan",
        data: {
            shoppingUUID: _shoppingUUID,
            hotelId: productId,
            roomId: branchId,
            planId: suppGoodsId,
            roomCount: Number(roomCount)
        },
        success: function(data) {
            $("#hotelInfo").html(data);
            $(".JS_showAllRoom").bind("click", showAllRoom);
            initAjax();
        },
        error:function(obj) {
            $(".returnAlert").show();
            $('.resortOverlay').stop(true,true).show();
            $("#errorMsg").html(eval('(' + obj.responseText + ')').message);
        }
    });
});

$('.fh-return-btn').click(function() {
    $('.returnAlert').stop(true,true).fadeOut();
    $('.resortOverlay').stop(true,true).fadeOut();
    $('body').removeAttr('style');

    $("#myForm").submit();
});

$('.ph_icon_closeAlert').click(function() {
    $('.returnAlert').stop(true,true).fadeOut();
    $('.resortOverlay').stop(true,true).fadeOut();
    $('body').removeAttr('style');

    $("#myForm").submit();
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
    if (!_shoppingUUID) {
        return;
    }
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
        }
    });
};
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
        error:function(data) {
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

$(".fh-change-btn").live("click", function() {
    var shoppingUuid = $("#shoppingUUID").val();
    
    var flightTripType = $(this).data("type");
    var url = baseUrl + "/search/flightList?shoppingUUID=" + shoppingUuid + "&flightType=" + flightTripType;
    window.location.href = url;
});

$("#changeHotelBtn").live("click", function() {
    var shoppingUuid = $("#shoppingUUID").val();
    var url = baseUrl+"/search/hotelList/"+ shoppingUuid;
    window.location.href = url;
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

$(".JS_select_city").click(function() {
    $(this).select();
    $(".complete-wrap,.des_error_tips").hide();
});
$(document).bind("click", function($element) {
    $(".complete-wrap,.roundTrip ,.liveDepart").hide();
    $(".backTracking,.checkOut").removeClass("fh-city-error");
});
$("input").bind("click", function($element) {
    $(".roundTrip ,.liveDepart").hide();
    $(".backTracking,.checkOut").removeClass("fh-city-error");
});
// 搜索
$(".fh-search-btn").live("click", function(e) {
    var event = e || window.event;
    //IE用cancelBubble=true来阻止而FF下需要用stopPropagation方法
    event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
    $('.city_mdd_depa,.city_mdd_dest,.city_mdd_hotel').hide();
    if (validateFhInput()) {
        var selectDepa=$(".select_depa").val().replace(/ /g, "");
        var selectDest=$(".select_dest").val().replace(/ /g, "");
        var selectHotel=$(".select-hotel").val().replace(/ /g, "");
        for(var i=0;i<allCities.length;i++){
            if(allCities[i].indexOf(selectDepa)!=-1){
                selectDepa=allCities[i].split("|")[3];
                $(".h_select_depa").val(selectDepa);
            }
            if(allCities[i].indexOf(selectDest)!=-1){
                selectDest=allCities[i].split("|")[3];
                $(".h_select_dest").val(selectDest)
            }
            if(allCities[i].indexOf(selectHotel)!=-1){
                selectHotel=allCities[i].split("|")[3];
                $(".h_select_hotel").val(selectHotel)
            }
        }
        $("#myForm").submit();
    }else{
        return false;
    }
    writeSearchRecord();
});


function validateFhInput() {
    // 判断输入是否为空
    if (!validateRequire()) {
        return false
    }

    var allCitie=[];
    var allCitieStr = "";
    for(var i=0;i<allCities.length;i++){
        allCitie.push(allCities[i].split("|")[0]);
        allCitieStr = allCitieStr + ","+allCities[i].split("|")[0];
    }
    // 判断出发城市是否存在
    if (allCitieStr.indexOf($("#departureCityName").val().replace(/ /g, ""))==-1) {
        if($(".selectPage").length!=0){
            showInvalidCityError($(".JS_select_depa"),{
                "top":87,
                "left":67
            });
        }else{
            showInvalidCityError($(".JS_select_depa"),{
                "top":139,
                "left":60
            });
        }
        return false;
    }
    // 判断目的地城市是否存在
    if (allCitieStr.indexOf($("#arrivalCityName").val().replace(/ /g, ""))==-1) {
        if($(".selectPage").length!=0){
            showInvalidCityError($(".JS_select_dest"),{
                "top":132,
                "left":67
            });
        }else{
            showInvalidCityError($(".JS_select_dest"),{
                "top":185,
                "left":60
            });
        }

        return false;
    }
    // 判断入住城市是否存在
    if (allCitieStr.indexOf($("#hotelCityName").val().replace(/ /g, ""))==-1) {
        if($(".selectPage").length!=0){
            showInvalidCityError($(".select-hotel"),{
                "top":87,
                "left":560
            });
        }else{
            showInvalidCityError($(".select-hotel"),{
                "top":230,
                "left":60
            });
        }

        return false;
    }
    // 判断出发地城市和目的地城市是否相同
    if ($("#departureCityName").val().replace(/ /g, "") === $("#arrivalCityName").val().replace(/ /g, "")) {
        if($(".selectPage").length!=0){
            showSameCityError($(".JS_select_dest"),{
                "top":132,
                "left":67
            });
        }else{
            showSameCityError($(".JS_select_dest"),{
                "top":185,
                "left":60
            });
        }
        return false;
    }
    return true;
}

function validateRequire() {
    var $cityInput = $(".input-city");
    var $cityMdd = $(".city_mdd");
    $cityMdd.hide();
    $cityInput.removeClass("fh-city-error");
    for (var i = 0; i < $cityInput.length; i++) {
        var $thisCityInput = $cityInput.eq(i);
        if ($thisCityInput.val() === "" || $thisCityInput.val()=== $thisCityInput.attr("placeholder")) {
            $thisCityInput.addClass("fh-city-error");
            if (!$cityMdd.is(":visible")) {
                $thisCityInput.click();
            }
            return false;
        }
    }
    return true;
}

function showAllRoom () {
    var $this = $(this);
    var text = $this.html();
    var $thisList = $this.parents(".listMain");
    var $openRoom = $thisList.find('.room-content .open');
    var $diff = $thisList.find(".roomHead .roomTable-td5");
    if ($openRoom.length) {
        $openRoom.find('.roomName').click();
    }
    if ($this.children('.arrow').length) {
        $diff.show();
        $thisList.find(".room-content").show();
        $thisList.find(".romLi-more dl").show();
        $this.html(text.replace('展开', '收起').replace('arrow', 'arrow_up'));
    } else {
        $diff.hide();
        $thisList.find(".room-content:gt(0)").hide();
        var $rooms = $thisList.find(".romLi-more");
        $rooms.each(function(index, ele) {
            $(ele).find('dl:gt(0)').hide();
        });
        $this.html(text.replace('收起', '展开').replace('arrow_up', 'arrow'));
    }
}

$(".select-div-list li").live("click", function () {
    var $selectSpan = $(this).parents(".select-div-list").siblings(".select-div").find("span");
    var num = $(this).data("num");
    var curNum = Number( $selectSpan.text() );

    if (num !== curNum) {
        $selectSpan.text(num);
        $(this).parents(".roomTable-td4").siblings(".roomTable-td6").html("<a href=\"javascript:void(0);\" class=\"btn btn-small btn-orange xuanze\">选择</a>");
    }
});
