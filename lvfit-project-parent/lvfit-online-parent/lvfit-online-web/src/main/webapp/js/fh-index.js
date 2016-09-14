/* 
* @Author: shengyaqing
* @Date:   2015-12-23 13:51:13
* @Last Modified by:   shengyaqing
* @Last Modified time: 2016-03-11 14:03:55
*/
//地点获取
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

'use strict';
$(document).ready(function(){
    var doc = document, inputs = doc.getElementsByTagName('input'), supportPlaceholder = 'placeholder' in doc.createElement('input'), placeholder = function (input) {
        var text = input.getAttribute('placeholder'), defaultValue = input.defaultValue;
        if (defaultValue == '') {
            input.value = text
        }
        input.onfocus = function () {
            if (input.value === text) {
                this.value = ''
            }
        };
        input.onblur = function () {
            if (input.value === '') {
                this.value = text
            }
        }
    };
    if (!supportPlaceholder) {
        for (var i = 0, len = inputs.length; i < len; i++) {
            var input = inputs[i], text = input.getAttribute('placeholder');
            if (input.type === 'text' && text) {
                placeholder(input)
            }
        }
    }

    $(".lv_search_box").hide();
    $("#headerInfo").css("visibility", "visible");

    // 根据站点设置出发地
    var cityName = $("#currentCity").text();
    $("#departureCityName").val(cityName);

    var startDate = moment().add(2, 'days').format('YYYY-MM-DD');
    var endDate = moment().add(5, 'days').format('YYYY-MM-DD');
    var startDayWeek = getDayOfWeek(startDate);
    var endDayWeek = getDayOfWeek(endDate);

    $("#flightStartDate").val(startDate);
    $("#flightStartDayOfWeek").text(startDayWeek);

    $("#flightEndDate").val(endDate);
    $("#flightEndDayOfWeek").text(endDayWeek);

    $("#hotelStartDate").val(startDate);
    $("#hotelStartDayOfWeek").text(startDayWeek);

    $("#hotelEndDate").val(endDate);
    $("#hotelEndDayOfWeek").text(endDayWeek);

    // 填充上一次cookie中保存的搜索条件
    fillSearchCondition();

    seoJustice('','','','seotdk_fit_index', $("#base_path").val());

    //设置成人儿童数
    resetChildList();
    resetAdultList();
    //获取推荐信息
    getRecommendInfo();
});

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
    $(".fh-search-btn").on("click", function(e) {
        var event = e || window.event;
        //IE用cancelBubble=true来阻止而FF下需要用stopPropagation方法
        event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
        $('.city_mdd_depa,.city_mdd_dest,.city_mdd_hotel').hide();
        if (validateFhInput()) {               // TODO
            
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
         // 城市选择
    $(".city_mdd").bind({
        "click": function(e) {
            e = e || window.event;
            if (e.stopPropagation)
                e.stopPropagation();
            else
                e.cancelBubble = true;
            var target = e.target || e.srcElement;
             $("#ctShow").hide();
             $(".errTips").hide();
            switch (target.tagName.toLowerCase()) {
                case "a":
                    var city = $(target).text();
                    var $thisCity = $(".JS_city_active");
                    setCity($thisCity, city);
                    $(this).hide();
                    // 目的地带入入住城市
                    if ($thisCity.hasClass("JS_select_dest")) {
                        setCity($(".select-hotel"), city);
                    }
                    // 出发地填充后，若目的地无值点开目的地选择框
                    if ($thisCity.hasClass("JS_select_depa") && $(".JS_select_dest").find("span").hasClass("tip")) {
                        $(".JS_select_dest").click();
                    }
                    break;
                case "li":
                    var $this = $(target);
                    $this.addClass('active').siblings().removeClass('active');
                    $this.parent().siblings('.mdd_list').find("li:eq(" + $this.index() + ")").show().siblings().hide();
                    break;
                case "span":
                    $(this).hide();
                    break;
            }
        },
        "mousedown": function(e) {
            e = e || window.event;
            if (e.stopPropagation)
                e.stopPropagation();
            else
                e.cancelBubble = true;
        }
    });
    
    function setCity($element, city) {
        $element.removeClass("fh-city-error");
        $element.val(city).removeClass("tip");
        $element.siblings(".js_destination").val(city);
    }
    function removeCalendar() {
        $(".ui-calendar").remove();
    }

(function ($) {
    var keys = { ESC: 27, TAB: 9, RETURN: 13, LEFT: 37, UP: 38, RIGHT: 39, DOWN: 40 };
    /*
      $searchData: 搜索结果(目的地全称+逗号+目的地所属行政区)
      $searchName: 目的地全称
      $parentName: 目的地所属行政区
      $searchCount: 酒店数量
      $searchType: 目的地类型
    */
    var destinationModel = "<li><a href='javascript:;' data-place=\"$searchData\" data-id=\"$searchID\"><span class=\"place-name\">$searchName</span></a></li>";
    var $elements,$activedElement,timeoutId;
    var querySelecter = { completeBox: ".complete-wrap", destinationBox: ".destinationBox", errorTipsBox: ".des_error_tips", destInput: ".js_destination"};


    function Factory() {
        $elements = this;
        return new searchComplete();
    }

    //多次请求流规避
    function timeoutFn() {
        var fn = new searchComplete("none");
        fn.requestData();
    }

    function searchComplete(option) {
        if (option)
            return;
        this.initialize();
        return $elements;
    }

    searchComplete.prototype = {
        initialize: function () {
            var that = this;
            that.createContainer();
            that.bindEvent();
        },
        createContainer: function () {
            var html = [];
            //html.push("<div class=\"complete-wrap destinationBox\" style=\"display:none\"></div>");
            //html.push("<div class=\"des_error_tips\" style=\"display:none;\"><span>没有找到含“</span><span style=\"color:#333333;font-weight:bold\" class=\"word\"></span><span>”的城市</span><i>×</i></div>");
            if ($(querySelecter.destinationBox).size() <= 0)
                $("body").append(html.join(''));
        },
        bindEvent: function () {
            var that = this;
            that.bindKeyupEvent();
            that.bindFoucsEvent();
            that.bindBlurEvent();
            that.bindMouseEvent();
        },
        bindKeyupEvent: function () {
            var that = this;
            //$elements.unbind("keydown");
            $elements.bind("keydown", function (e) {//取消form的自动submit事件
                switch (e.which) {
                    case keys.RETURN:
                        e = e || window.event;
                        if (!e.preventDefault())
                            e.returnValue = false;
                        break;
                }

                $(".errTips").hide();
                $(".JS_select_city ").removeClass('fh-city-error');
            });
            //$elements.unbind("keyup");
            $elements.bind("keyup", function (e) {
                switch (e.which) {
                    case keys.UP:
                        that.moveUp();
                        break;
                    case keys.DOWN:
                        that.moveDown();
                        break;
                    case keys.ESC:
                        $(querySelecter.completeBox).hide();
                        break;
                    case keys.RETURN:
                        if ($(querySelecter.completeBox).is(":visible")) {
                            that.select(e);
                        }
                        if($(this).attr("class").indexOf("JS_select_dest")!=-1){
                            $(".select-hotel").val($(this).val());
                        }
                        break;
                    default:
                        clearTimeout(timeoutId);
                        timeoutId = setTimeout(timeoutFn, 300);
                        break;
                }
            });

        },
        bindFoucsEvent: function () {
            var that = this;
            $elements.bind("focus", function (e) {
                var target = e.target || window.event.srcElement;
                $activedElement = $(target);

                //设置自动完成列表层定位
                var UlPosition = { left: $activedElement.offset().left, top: $activedElement.offset().top + $activedElement.outerHeight() };
                var UlWidth = $activedElement.outerWidth();
                var $targetBox = that.getActivedBox();
                $targetBox.css({
                    left: UlPosition.left,
                    top: UlPosition.top
                });
                if(target.value!=""){
                    return;
                }
                if ($activedElement.val() !== "")
                    that.requestData();
                $("input:text[active]").removeAttr("active");
                $(target).attr("active", "actived");
            });
            
            //$elements.unbind("click");
            $elements.bind("click", function (e) {
                that.cancelBubble(e);
            });
        },
        bindBlurEvent: function () {
        },
        bindMouseEvent: function () {
            var that = this;
            $(querySelecter.completeBox).bind("mouseup", function (e) {
                e = e || window.event;
                var target = e.target || e.srcElement; 
                var $keyword = $(".js_keyword:visible");
                switch (target.tagName.toLowerCase()) {
                    case "a":
                        $activedElement.val($(target).attr("data-place"));
                        $keyword.attr("data-id", $(target).attr("data-id"));
                        break;
                    case "b":
                        $activedElement.val($(target).parent().parent().attr("data-place"));
                        $keyword.attr("data-id", $(target).parent().parent().attr("data-id"));
                        break;
                    case "span":
                    
                    	if($(this).width() != 388 ){
                    		$activedElement.val($(target).parent().attr("data-place"));
                        }
                        $keyword.attr("data-id", $(target).parent().attr("data-id"));
                        if($activedElement.attr("class").indexOf("JS_select_dest")!=-1){
                            $(".select-hotel").val($(target).parent().attr("data-place"));
                        }
                        break;
                    case "li":
                        $activedElement.val($(target).find("a").attr("data-place"));
                        $keyword.attr("data-id", $(target).find("a").attr("data-id"));

                        break;
                }
                that.getActivedBox().hide();

            });
            $(querySelecter.errorTipsBox).find("i").bind("mousedown", function () {
                $(this).parent().hide();
            });
        },
        moveDown: function() {
            var that = this;
            if (!that.hasValue()) {
                return;
            }
            var $libox = that.getActivedBox();
            var $activeLi = $libox.find("li.active");
            if($activeLi.size() > 0) {
                if($activeLi.next().size() > 0) {
                    $activeLi.removeClass("active").next().addClass("active");
                } else if ($activeLi.prev().size() > 0){
                    $activeLi.removeClass("active").siblings(":first").addClass("active")
                }
            }else {
                $libox.find("li:first").addClass("active")
            }
            var $actived = $libox.find("li.active");
            $activedElement.val($actived.find("a").attr("data-place"));
        },
        moveUp: function() {
            var that = this;
            if (!that.hasValue()) {
                return;
            }
            var $libox = that.getActivedBox();
            var $activeLi = $libox.find("li.active");
            if($activeLi.size() > 0) {
                if($activeLi.prev().size() > 0) {
                    $activeLi.removeClass("active").prev().addClass("active");
                } else if ($activeLi.next().size() > 0){
                    $activeLi.removeClass("active").siblings(":last").addClass("active")
                }
            }else {
                $libox.find("li:last").addClass("active")
            }

            var $actived = $libox.find("li.active");
            $activedElement.val($actived.find("a").attr("data-place"));

        },
        select: function (e) {
            var $activedLink = this.getActivedBox().find("li.active>a");
            if ($activedLink.size() > 0) {
                $activedElement.val($activedLink.attr("data-place"));
                $(".js_keyword:visible").attr("data-id", $activedLink.attr("data-id"));
            }
            $(querySelecter.completeBox).hide();
        },
        hasValue: function () {
            if ($.trim($activedElement.val()) === "")
                return false;
            else
                return true;
        },
        getActivedBox: function () {
            return $(querySelecter.destinationBox);
        },
        cancelBubble: function (e) {
            e = e || window.event;
            if (!e.stopPropagation())
                e.cancelBubble = true;
        },
        requestData: function () {//开始请求数据
            var that = this;
            if (!that.hasValue()) {
                that.getActivedBox().hide();
                return;
            }
            if ($activedElement.hasClass("js_destination")) {
                $(querySelecter.errorTipsBox).hide();
            }
            var keyword = $activedElement.val();
            var dataStr = ("type=DEST&keyword=" + keyword.split(",")[0]) ;
            var ajaxurl = "http://s.lvmama.com/autocomplete/autoCompleteHotel.do";
            var qq=[];
            $.each(allCities, function (index, items) {
                var finalModel = destinationModel.replace("$searchData", items.split("|")[0]);
                finalModel = finalModel.replace("$searchID", items.split("|")[3]);
                finalModel = finalModel.replace("$searchName", items.split("|")[0]);
                //var goCityV=$activedElement.val();
                var goCityV=$activedElement.val().replace(/ /g, "");
                goCityV=goCityV.toLocaleLowerCase();
                
                if(items.split("|")[0].indexOf(goCityV)==0){
                    qq.push(items);
                }else if(items.split("|")[2].indexOf(goCityV)==0 || items.split("|")[1].indexOf(goCityV)==0){
                     qq.push(items);
                }else{
                    if(items.split("|")[2].indexOf(goCityV)==0){
                        qq.push(items);
                    }
                 }
            });
            that.dataBind(qq);
        },
        dataBind: function (data) {//数据可视化
            var that = this;
            if (!(typeof data === "object"))
                return;
            var html = "";
            //拼接补全位
            if (data) {
                if (that.getActivedBox().hasClass("destinationBox")) {//目的地补全
                    var canton = [];
                    $.each(data, function (index, items) {
                        var finalModel = destinationModel.replace("$searchData", items.split("|")[0]);
                        finalModel = finalModel.replace("$searchID", items.split("|")[3]);
                        finalModel = finalModel.replace("$searchName", items.split("|")[0]);
                        if(canton.length>=10){

                        }else{
                            canton.push(finalModel);
                        }
                    });
                    if (canton.length == 0)
                        html = "";
                    else
                        html = "<ul>" + canton.join('') + "</ul>";
                }
            }
            if (html === "") {
                that.getActivedBox().hide();
                if ($activedElement.hasClass("js_destination")) {
                    var thisL = $activedElement.offset().left,
                        thisT = $activedElement.offset().top,
                        thisH = $activedElement.outerHeight(true);
                    $(querySelecter.errorTipsBox).show().css({ 'left': thisL, 'top': thisT + thisH }).find(".word").text($activedElement.val());
                }
                return;
            }
            that.getActivedBox().show().html(html);

            if ($activedElement.hasClass("js_destination")) {
                var $a = that.getActivedBox().find("li:first").addClass("active").find("a");
                $(".js_keyword:visible").attr("data-id", $a.attr("data-id"));
            }
        }
    };
    $.fn.cityComplete = $.cityComplete = Factory;
}(jQuery));

 (function searchInputInit() {
        /*目的地输入框*/
        $(".js_destination").bind({
            "focus": function () {
                $('.city_mdd_depa,.city_mdd_dest,.city_mdd_hotel,.destinationBox').hide();
                var $this = $(this);
                $('.tiptextcity').hide();
                $this.removeClass("des_error");
                $(".js_destination").removeClass("JS_city_active");
                $this.addClass("JS_city_active");
                if ($this.val() == "") {
                    $this.val("").removeClass("des_tip");
                }
                if ($(this).hasClass("JS_select_depa")) {
                        $('.mdd_list').css("border-top", "#E5E5E5 solid 1px");
                   } else {
                        $('.mdd_list').css("border-top", "none");}
                // if ($.trim($this.val()) == '') {
                //     var thisL = $this.offset().left,
                //         thisT = $this.offset().top,
                //         thisH = $this.outerHeight(true);
                //     if ($(this).hasClass("JS_select_depa")) {
                //         $('.mdd_tab').show();
                //         $('.mdd_list').css("border-top", "#E5E5E5 solid 1px");
                //     } else {
                //         $('.mdd_tab').hide();
                //         $('.mdd_list').css("border-top", "none");
                //     }
                //     $('.city_mdd').show().css({ 'left': thisL, 'top': thisT + thisH });
                // };
                    if($(this).width() == 93 || $(this).width() == 123 ){
                        $('.complete-wrap').css({
                        'width': $(this).width()+65
                        });
                    }else{
                        $('.complete-wrap').css({
                        'width': $(this).width()+80
                        });
                    }
                    if($(this).width() == 248 || $(this).width() == 308 ){
                        $('.des_error_tips').css({
                            'width': $(this).width()+70
                        });
                    }else{
                        $('.des_error_tips').css({
                            'width': 210
                        });
                    }
                    
            },
            "blur": function () {
                var $this = $(this);
                if ($this.val() == "") {
                    $this.val("").addClass("des_tip");
                }
                if ($this.val() != "" && !$(".js_keyword").attr("data-id")) {
                    $this.addClass("des_error");
                }
            },
            "keyup": function () {
                var $this = $(this);
                if ($.trim($this.val()) == '') {
                    var thisL = $this.offset().left,
                        thisT = $this.offset().top,
                        thisH = $this.outerHeight(true);
                    // if ($(this).hasClass("JS_select_depa")) {
                    //     $('.mdd_tab').show();
                    //     $('.mdd_list').css("border-top", "#E5E5E5 solid 1px");
                    // } else {
                    //     $('.mdd_tab').hide();
                    //     $('.mdd_list').css("border-top", "none");
                    // }
                    if ($(this).hasClass("JS_select_depa")) {
                        $('.mdd_list').css("border-top", "#E5E5E5 solid 1px");
                   } else {
                        $('.mdd_list').css("border-top", "none");
                    }
                    $('.city_mdd').show().css({ 'left': thisL, 'top': thisT + thisH });
                    $('.des_error_tips').hide();
                } else {
                    $('.city_mdd').hide();
                }
            },
            "mousedown": function(ev){
                ev.stopPropagation();
                $('.ui-calendar').remove();
            }
        });
    }());

    $(".js_destination").cityComplete();
    $(".JS_select_dest").blur(function(){ 
        $(".select-hotel").val($(this).val());
    });
    
  //记录搜索历史
    function writeSearchRecord(){
        var searchCondition = $("#tripType").val()+"|"+$("#departureCityCode").val()+"|"+$("#arrivalCityCode").val()+"|"+$("#cityCode").val()+"|"+$("#flightStartDate").val()+"|"+$("#flightEndDate").val()+"|"+$("#hotelStartDate").val()+"|"+$("#hotelEndDate").val()+"|"+$("#adultsCount").val()+"|"+$("#childCount").val();
        if(window.localStorage){
        	window.localStorage.setItem('searchCondition', searchCondition);
        }
    }

//1、儿童数+成人数<=9；2、儿童数 <= 2倍成人数
function resetChildList() {
    var $list = $("#child").find("li");
    var adultCount = Number( $("#adultsCount").val() );
    var maxNum1 = 9 - adultCount;
    var maxNum2 = 2 * adultCount;
    var maxNum = maxNum1 < maxNum2 ? maxNum1 : maxNum2;
    for (var i = 0; i < $list.length; i++) {
        var $thisItem = $list.eq(i);
        if (parseInt($thisItem.data("num")) > maxNum) {
            $thisItem.hide();
        } else {
            $thisItem.show();
        }
    }
}
function resetAdultList() {
    var $list = $("#adaultOl").find("li");
    var childCount = Number( $("#childCount").val() );
    var maxNum = 9 - childCount;
    for (var i = 0; i < $list.length; i++) {
        var $thisItem = $list.eq(i);
        if (parseInt($thisItem.data("num")) > maxNum) {
            $thisItem.hide();
        } else {
            $thisItem.show();
        }
    }
}

//首页默认打开时，把搜索条件填充到页面
function fillSearchCondition() {
    //1、根据用户搜索历史记录，且Cookie没有清理掉，显示上次搜索过的航程类型，出发、到达城市及出发、往返时间
    if(window.localStorage){
        var searchCondition = window.localStorage.getItem('searchCondition');
        if(searchCondition != null && searchCondition != ''){
            //RT|XMN|NGB|2016-02-24|2016-02-27
            console.info("获取上一次的搜索条件="+searchCondition);
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

            if (arrivalCityCode !== "") {
                $("#arrivalCityCode").val(arrivalCityCode);
                for(var i=0; i < allCities.length; i++){
                    if(allCities[i].indexOf(arrivalCityCode) !== -1){
                        var arrvCity=allCities[i].split("|")[0];
                        $("#arrivalCityName").val(arrvCity);
                        break;
                    }
                }
            }

            if (cityCode !== "") {
                $("#cityCode").val(cityCode);
                for(var i=0; i < allCities.length; i++) {
                    if(allCities[i].indexOf(cityCode) !== -1){
                        var hotelCity=allCities[i].split("|")[0];
                        $("#hotelCityName").val(hotelCity);
                        break;
                    }
                }
            }

            var startDate = new Date(flightStartDate);
            var startDay = moment(startDate);
            var nowDay = moment();
            if (startDay.diff(nowDay, 'days') >= 0) {
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
            }

            $("#adultsCount").val(adultsCount);
            $("#adultCountSpan").text(adultsCount);

            $("#childCount").val(childCount);
            $("#childCountSpan").text(childCount);
        }
    }
}

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

function getRecommendInfo() {
    var cityName = $(".lv_city").text();
    $.ajax({
        type: "GET",
        url: $("#base_path").val() + "/recommendInfo/" + cityName,
        success: function(data) {
            $(".main-wrap").html(data);
            var siteId = $("#belongSiteId").val();
            if (siteId == "1") {
                $("#sanyaLink").attr("href", "http://s.lvmama.com/freetour/H13K110000?keyword=%E4%B8%89%E4%BA%9A&k=0#list");
                $("#xiamenLink").attr("href", "http://s.lvmama.com/freetour/H13K110000?keyword=%E5%8E%A6%E9%97%A8&k=0#list");
                $("#guilinLink").attr("href", "http://s.lvmama.com/freetour/H13K110000?keyword=%E6%A1%82%E6%9E%97&k=0#list");
                $("#qindaoLink").attr("href", "http://s.lvmama.com/freetour/H13K110000?keyword=%E9%9D%92%E5%B2%9B&k=0#list");
                $("#yunnanLink").attr("href", "http://s.lvmama.com/freetour/H13K110000?keyword=%E4%B8%BD%E6%B1%9F&k=0#list");
            } else if (siteId == "2") {
                $("#sanyaLink").attr("href", "http://s.lvmama.com/freetour/H13K110000?keyword=%E4%B8%89%E4%BA%9A&k=0#list");
                $("#xiamenLink").attr("href", "http://s.lvmama.com/freetour/H14K120000?keyword=%E5%8E%A6%E9%97%A8&k=0#list");
                $("#guilinLink").attr("href", "http://s.lvmama.com/freetour/H14K120000?keyword=%E6%A1%82%E6%9E%97&k=0#list");
                $("#qindaoLink").attr("href", "http://s.lvmama.com/freetour/H14K120000?keyword=%E9%9D%92%E5%B2%9B&k=0#list");
                $("#yunnanLink").attr("href", "http://s.lvmama.com/freetour/H14K120000?keyword=%E4%B8%BD%E6%B1%9F&k=0#list");
            } else if (siteId == "229") {
                $("#sanyaLink").attr("href", "http://s.lvmama.com/freetour/H322K440400?keyword=%E4%B8%89%E4%BA%9A&k=1#list");
                $("#xiamenLink").attr("href", "http://s.lvmama.com/freetour/H322K440400?keyword=%E5%8E%A6%E9%97%A8&k=0#list");
                $("#guilinLink").attr("href", "http://s.lvmama.com/freetour/H322K440400?keyword=%E6%A1%82%E6%9E%97&k=0#list");
                $("#qindaoLink").attr("href", "http://s.lvmama.com/freetour/H322K440400?keyword=%E9%9D%92%E5%B2%9B&k=0#list");
                $("#yunnanLink").attr("href", "http://s.lvmama.com/freetour/H322K440400?keyword=%E4%B8%BD%E6%B1%9F&k=0#list");
            } else if (siteId == "231") {
                $("#sanyaLink").attr("href", "http://s.lvmama.com/freetour/H324K440400?keyword=%E4%B8%89%E4%BA%9A&k=0#list");
                $("#xiamenLink").attr("href", "http://s.lvmama.com/freetour/H324K440400?keyword=%E5%8E%A6%E9%97%A8&k=0#list");
                $("#guilinLink").attr("href", "http://s.lvmama.com/freetour/H324K440400?keyword=%E6%A1%82%E6%9E%97&k=0#list");
                $("#qindaoLink").attr("href", "http://s.lvmama.com/freetour/H324K440400?keyword=%E9%9D%92%E5%B2%9B&k=0#list");
                $("#yunnanLink").attr("href", "http://s.lvmama.com/freetour/H324K440400?keyword=%E4%B8%BD%E6%B1%9F&k=0#list");
            } else if (siteId == "100") {
                $("#sanyaLink").attr("href", "http://s.lvmama.com/freetour/H69K440400?keyword=%E4%B8%89%E4%BA%9A&k=0#list");
                $("#xiamenLink").attr("href", "http://s.lvmama.com/freetour/H69K440400?keyword=%E5%8E%A6%E9%97%A8&k=0#list");
                $("#guilinLink").attr("href", "http://s.lvmama.com/freetour/H69K440400?keyword=%E6%A1%82%E6%9E%97&k=0#list");
                $("#qindaoLink").attr("href", "http://s.lvmama.com/freetour/H69K440400?keyword=%E9%9D%92%E5%B2%9B&k=0#list");
                $("#yunnanLink").attr("href", "http://s.lvmama.com/freetour/H69K440400?keyword=%E4%B8%BD%E6%B1%9F&k=0#list");
            } else if (siteId == "82") {
                $("#sanyaLink").attr("href", "http://s.lvmama.com/freetour/H56K320100?keyword=%E4%B8%89%E4%BA%9A&k=0#list");
                $("#xiamenLink").attr("href", "http://s.lvmama.com/freetour/H56K320100?keyword=%E5%8E%A6%E9%97%A8&k=0#list");
                $("#guilinLink").attr("href", "http://s.lvmama.com/freetour/H56K320100?keyword=%E6%A1%82%E6%9E%97&k=0#list");
                $("#qindaoLink").attr("href", "http://s.lvmama.com/freetour/H56K310000?keyword=%E9%9D%92%E5%B2%9B&k=1#list");
                $("#yunnanLink").attr("href", "http://s.lvmama.com/freetour/H56K310000?keyword=%E4%BA%91%E5%8D%97&k=0#list");
            } else if (siteId == "279") {
                $("#sanyaLink").attr("href", "http://s.lvmama.com/freetour/H258K510100?keyword=%E4%B8%89%E4%BA%9A&k=1#list");
                $("#xiamenLink").attr("href", "http://s.lvmama.com/freetour/H258K510100?keyword=%E5%8E%A6%E9%97%A8&k=0#list");
                $("#guilinLink").attr("href", "http://s.lvmama.com/freetour/H258K510100?keyword=%E6%A1%82%E6%9E%97&k=0#list");
                $("#qindaoLink").attr("href", "http://s.lvmama.com/freetour/H258K510100?keyword=%E9%9D%92%E5%B2%9B&k=0#list");
                $("#yunnanLink").attr("href", "http://s.lvmama.com/freetour/H258K510100?keyword=%E4%B8%BD%E6%B1%9F&k=0#list");
            } else {
                $("#sanyaLink").attr("href", "http://s.lvmama.com/freetour/H9K310000?keyword=%E4%B8%89%E4%BA%9A&k=0#list");
                $("#yunnanLink").attr("href", "http://s.lvmama.com/freetour/H9K310000?keyword=%E4%B8%BD%E6%B1%9F&k=1#list");
                $("#xiamenLink").attr("href", "http://s.lvmama.com/freetour/H9K310000?keyword=%E5%8E%A6%E9%97%A8&k=0#list");
                $("#guilinLink").attr("href", "http://s.lvmama.com/freetour/H9K310000?keyword=%E6%A1%82%E6%9E%97&k=0#list");
                $("#qindaoLink").attr("href", "http://s.lvmama.com/freetour/H9K310000?keyword=%E9%9D%92%E5%B2%9B&k=0#list");
            }
        }
    });
}

$(".hot-tab li").live("hover", function(e) {
    var event = e || window.event;
    event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);

    var $hot = $(".hot");
    var $moreBtns = $(".more-btns a");
    var $hotProduct = $(".hot-product");

    var $me = $(this);
    var index = $me.index();
    var $thisMore = $moreBtns.eq(index);
    var $thisHot = $hotProduct.eq(index);
    $me.addClass('active').siblings().removeClass('active');
    $hotProduct.hide();
    $thisHot.show();
    $moreBtns.hide();
    if ($thisMore.attr("href") != "") {
        $thisMore.show();
    }
    showUnloadedImg($thisHot);
});

// 加载图片
function showUnloadedImg($showBox) {
    $showBox.find('img[to]').each(function() {
        var $me = $(this);
        $me.attr('src', $me.attr('to')).removeAttr('to');
    });
}
