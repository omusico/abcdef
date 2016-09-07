/*!
 * File:         fh-search.js
 * Created:      2015-11-23
 * Last Updated: 2015-11-26
 * Author:       印韩春
 * Description:  机+酒频道页（搜索）
 */
$(function() {
	
	$.ajax({
		   type: "GET",
		   //url: "http://localhost:9091/indhttex/ip",
		   url: location.href.substring(0,location.href.indexOf("/index")+1)+"index/ip",
		   success: function(data){
		     alert( "add: " + data.add );
			 $("#departureCityName").val(data.add);
			 for(var i=0;i<allCities.length;i++){
		        if(data.add==allCities[i].split("|")[0]){
		            $(".select_depa").val(data.add);
		        }else{$(".select_depa").val("上海")}
			 } 
		   }
		});
	
	
	
    $(document).bind("click", function() {
        $(".select-people-list,.city_mdd,.des_error_tips").hide();
    });
$(document).ready(function(){
    var doc=document,inputs=doc.getElementsByTagName('input'),supportPlaceholder='placeholder'in doc.createElement('input'),placeholder=function(input){var text=input.getAttribute('placeholder'),defaultValue=input.defaultValue;
    if(defaultValue==''){
        input.value=text}
        input.onfocus=function(){
            if(input.value===text){this.value=''}};
            input.onblur=function(){if(input.value===''){this.value=text}}};
            if(!supportPlaceholder){
                for(var i=0,len=inputs.length;i<len;i++){var input=inputs[i],text=input.getAttribute('placeholder');
                if(input.type==='text'&&text){placeholder(input)}}}});
    //获取默认日期的星期值
    var $dayAfterTom = $('.dayAfterTom');
    var $dayAfter5 = $('.dayAfter5');
    var myDay = new Date();
    var dayAfterTom = myDay.getDay() + 2;
    var dayAfter5 = dayAfterTom + 3;
    //默认时间获取
    var newDate=new Date();
    newDate.setDate(newDate.getDate()+2);
    var goYear = newDate.getFullYear();
    var goMonth = newDate.getMonth() + 1;
    var goDay = newDate.getDate();
    if (goMonth <= 9) {
        goMonth = "0" + goMonth;
    }
    if (goDay <= 9) {
        goDay = "0" + goDay;
    }
    $('#flightStartDate').val(goYear+"-"+goMonth+"-"+goDay);
    $('#hotelStartDate').val(goYear+"-"+goMonth+"-"+goDay);

    newDate.setDate(newDate.getDate()+3);
    var backYear = newDate.getFullYear();
    var backMonth = newDate.getMonth() + 1;
    var backDay = newDate.getDate();
    if (backMonth <= 9) {
        backMonth = "0" + backMonth;
    }
    if (backDay <= 9) {
        backDay = "0" + backDay;
    }
    $('#flightEndDate').val(backYear+"-"+backMonth+"-"+backDay);
    $('#hotelEndDate').val(backYear+"-"+backMonth+"-"+backDay);


	    //地点获取
	    var allCities = ['北京|beijing|bj|PEK', '上海|shanghai|sh|SHA', '重庆|chongqing|cq|CKG', '深圳|shenzhen|sz|SZX', '广州|guangzhou|gz|CAN', '杭州|hangzhou|hz|HGH',
	        '南京|nanjing|nj|NKG', '天津|tianjin|tj|TSN', '成都|chengdu|cd|CTU', '南昌|nanchang|nc|KHN', '三亚|sanya|sy|SYX', '青岛|qingdao|qd|TAO','武汉|wuhan|wh|WUH',
	        '厦门|xiamen|xm|XMN', '西安|xian|xa|XIY', '长沙|changsha|cs|CSX', '合肥|hefei|hf|HFE', '安庆|anqing|aq|AQG', '安顺|anshun|as|AVA','阿泰勒|ataile|atl|AAT', '鞍山|anshan|as|AOG','阿里|ali|al|NGQ','阿尔山|aershan|aes|YIE',
	        '阿克苏|akesu|aks|AKU', '包头|baotou|bt|BAV', '北海|beihai|bh|BHY', '百色|baise|bs|AEB','巴彦淖尔|bayannaoer|byne|RLK', '保山|baoshan|bs|BSD', '毕节|bijie|bj|BFJ','博乐|bole|bl|BPL','长治|changzhi|cz|CIH', '长春|changchun|cc|CGQ', '常州|changzhou|cz|CZX', '昌都|changdu|cd|BPX',
	        '朝阳|chaoyang|cy|CHG', '常德|changde|cd|CGD', '长白山|changbaishan|cbs|NBS', '赤峰|chifeng|cf|CIF', '池州|chizhou|cz|JUH','大同|datong|dt|DAT', '大连|dalian|dl|DLC', '东营|dongying|dy|DOY', '迪庆|diqing|dq|DIG', '丹东|dandong|dd|DDG','达州|dazhou|dz|DAX','稻城|daocheng|dc|DCY',
	        '大理|dali|dl|DLU', '敦煌|dunhuang|dh|DNH', '鄂尔多斯|eerduosi|eeds|DSN', '恩施|enshi|es|ENH', '二连浩特|erlianhaote|elht|ERL','福州|fuzhou|fz|FOC', '阜阳|fuyang|fy|FUG', '佛山|foshan|fs|FUO','贵阳|guiyang|gy|KWE','赣州|ganzhou|gz|KOW',
	        '桂林|guilin|gl|KWL', '广元|guangyuan|gy|GYS', '格尔木|geermu|gem|GOQ','固原|guyuan|gy|GYU', '呼和浩特|huhehaote|hhht|HET', '哈密|hami|hm|HMI',
	        '黑河|heihe|hh|HEK', '海拉尔|hailaer|hle|HLD', '哈尔滨|haerbin|heb|HRB', '海口|haikou|hk|HAK', '黄山|huangshan|hs|TXN', '邯郸|handan|hd|HDG',
	        '汉中|hanzhong|hz|HZG', '和田|hetian|ht|HTN', '淮安|huaian|ha|HIA','怀化|huaihua|hh|HJJ','惠州|huizhou|hz|HUZ', '锦州|jinzhou|jz|JNZ', '景德镇|jingdezhen|jdz|JDZ',
	        '嘉峪关|jiayuguan|jyg|JGN', '鸡西|jixi|jx|JXA','加尔达奇|jiaerdaqi|jedq|JGD','井冈山|jinggangshan|jgs|JGS','金昌|jinchang|jc|JIC', '济宁|jining|jn|JNG', '九江|jiujiang|jj|JIU','九寨沟|jiuzhaigou|jzg|JZH', '佳木斯|jiamusi|jms|JMU', '济南|jinan|jn|TNA','揭阳|jieyang|jy|SWA',
	        '喀什|kashi|ks|KHG', '昆明|kunming|km|KMG', '康定|kangding|kd|KGT', '凯里|kaili|kl|KJH','喀纳斯|kanasi|kns|KJI','克拉玛依|kelamayi|klmy|KRY', '库尔勒|kuerle|kel|KRL', '库车|kuche|kc|KCA', '兰州|lanzhou|lz|LHW',
	        '洛阳|luoyang|ly|LYA', '丽江|lijiang|lj|LJG', '荔波|libo|lb|LLB','吕梁|lvliang|ll|LLV','六盘水|liupanshui|lps|LPF','林芝|linzhi|lz|LZY', '柳州|liuzhou|lz|LZH', '泸州|luzhou|lz|LZO', '连云港|lianyungang|lyg|LYG', '黎平|liping|lp|HZH','龙岩|longyan|ly|LCX',
	         '拉萨|lasa|ls|LXA', '临沧|lincang|lc|LNJ', '临沂|linyi|ly|LYI', '芒市|mangshi|ms|LUM', '牡丹江|mudanjiang|mdj|MDG', '满洲里|manzhouli|mzl|NZH', '绵阳|mianyang|my|MIG',
	        '漠河|mohe|mh|OHE', '南充|nanchong|nc|NAO', '南宁|nanning|nn|NNG', '南阳|nanyang|ny|NNY', '南通|nantong|nt|NTG', '那拉提|nalati|nlt|NLT',
	        '宁波|ningbo|nb|NGB', '攀枝花|panzhihua|pzh|PZI','普洱|puer|pe|SYM', '衢州|quzhou|qz|JUZ','泉州|quanzhou|qz|JJN', '秦皇岛|qinhuangdao|qhd|SHP','日喀则|rikaze|rkz|RKZ', '庆阳|qingyang|qy|IQN', '齐齐哈尔|qiqihaer|qqhe|NDG',
	        '石家庄|shijiazhuang|sjz|SJW', '沈阳|shenyang|sy|SHE', '思茅|simao|sm|SYM', '铜仁|tongren|tr|TEN', '塔城|tacheng|tc|TCG','唐山|tangshan|ts|TVS', '腾冲|tengchong|tc|TCZ', '台州|taizhou|tz|HYN',
	        '通辽|tongliao|tl|TGO','天水|tianshui|ts|THQ', '太原|taiyuan|ty|TYN', '威海|weihai|wh|WEH', '梧州|wuzhou|wz|WUZ', '文山|wenshan|ws|WNH', '无锡|wuxi|wx|WUX', '潍坊|weifang|wf|WEF', '武夷山|wuyishan|wys|WUS', '武陵山|wulinshan|wls|JIQ','乌兰浩特|wulanhaote|wlht|HLH',
	        '温州|wenzhou|wz|WNZ', '乌鲁木齐|wulumuqi|wlmq|URC', '万州|wanzhou|wz|WXN', '乌海|wuhai|wh|WUA', '兴义|xingyi|xy|ACX', '西昌|xichang|xc|XIC', '襄樊|xiangfan|xf|XFN',
	        '西宁|xining|xn|XNN', '锡林浩特|xilinhaote|xlht|XIL', '西双版纳|xishuangbanna|xsbn|JHG', '徐州|xuzhou|xz|XUZ', '义乌|yiwu|yw|YIW', '永州|yongzhou|yz|LLF', '榆林|yulin|yl|UYN', '延安|yanan|ya|ENY', '运城|yuncheng|yc|YCU',
	        '烟台|yantai|yt|YNT', '银川|yinchuan|yc|INC', '宜昌|yichang|yc|YIH', '宜春|yichun|yc|YIC','宜宾|yibin|yb|YBP', '盐城|yancheng|yc|YNZ','扬州|yangzhou|yz|YTY', '延吉|yanji|yj|YNJ', '玉树|yushu|ys|YUS', '伊宁|yining|yn|YIN', '珠海|zhuhai|zh|ZUH', '昭通|zhaotong|zt|ZAT',
	        '张家界|zhangjiajie|zjj|DYG','张家口|zhangjiakou|zjk|ZQZ','张掖|zhangye|zy|YZY', '舟山|zhoushan|zs|HSN', '郑州|zhengzhou|zz|CGO', '中卫|zhongwei|zw|ZHY','中山|zhongshan|zs|ZGN', '湛江|zhanjiang|zj|ZHA','遵义|zhunyi|zy|ZYI'
	    ];
	    $(".JS_select_depa").click(function() { 
	        $(this).select();
	    });
	    $(".JS_select_dest").click(function() { 
	        $(this).select();
	    });
	    $(".select-hotel").click(function() { 
	        $(this).select();
	    });

	    $(window).keyup(function(event){
	        var code=event.keyCode;
	        if(code==9){
	            $(".city_mdd").hide();
	            $(".city_mdd1").hide();
	           
	        }
	    })
	     $(".JS_select_depa").keyup(function(e) {
	 //$(".JS_select_depa").bind('change', function(e) {
	       var goCityV=$(".JS_select_depa").val().replace(/(^\s*)|(\s*$)/g, "");
	       goCityV=goCityV.toLocaleLowerCase();
	       var cityShow="";
	       if(goCityV=="" || goCityV == null){
	        $("#ctShow").hide();
	        $(".city_mdd").show();
	        return;
	       }
	       for(var i=0;i<allCities.length;i++){
	        if(allCities[i].split("|")[0].indexOf(goCityV)==0){
	            cityShow+="<p>"+allCities[i].split("|")[0]+"</p>";
	        }else if(allCities[i].split("|")[2].indexOf(goCityV)==0 || allCities[i].split("|")[1].indexOf(goCityV)==0){
	                cityShow+="<p>"+allCities[i].split("|")[0]+"</p>";
	        }else{
	             if(allCities[i].split("|")[2].indexOf(goCityV)==0){
	                cityShow+="<p>"+allCities[i].split("|")[0]+"</p>";
	            }
	        }
	       
	       }
	            if(cityShow=="" || cityShow==null){
	                //cityShow+="您输入的城市没有机场"
	                cityShow='<input type="text" style="background:#fff" disabled="disabled" value="您输入的城市没有机场"/>';
	            }
	            $("#ctShow").html(cityShow);
	            $(".city_mdd,.select-people-list").hide();
	            $("#ctShow").show();
	            $(".city_mdd1").bind('click', function(e) {
	                var event = e || window.event;
	                $(".JS_select_depa").val(event.target.innerHTML);
	                $("#ctShow").hide();
	                $(".city_mdd1").unbind();
	            });
	            
	    });
	$(".JS_select_dest").keyup(function(e) {

	       var goCityV=$(".JS_select_dest").val().replace(/(^\s*)|(\s*$)/g, "");
	       goCityV=goCityV.toLocaleLowerCase();
	       $("#ctShow").hide();
	       var cityShow="";
	       if(goCityV=="" || goCityV == null){
	        $("#ctShow").hide();
	        $(".city_mdd").show();
	        return;
	       }
	       for(var i=0;i<allCities.length;i++){
	        if(allCities[i].split("|")[0].indexOf(goCityV)==0){
	            cityShow+="<p>"+allCities[i].split("|")[0]+"</p>";
	        }else if(allCities[i].split("|")[2].indexOf(goCityV)==0 || allCities[i].split("|")[1].indexOf(goCityV)==0){
	                cityShow+="<p>"+allCities[i].split("|")[0]+"</p>";
	        }else{
	             if(allCities[i].split("|")[2].indexOf(goCityV)==0){
	                cityShow+="<p>"+allCities[i].split("|")[0]+"</p>";
	            }
	        }
	       }
	            if(cityShow=="" || cityShow==null){
	                //cityShow+="您输入的城市没有机场";
	                cityShow='<input type="text" style="background:#fff" disabled="disabled" value="您输入的城市没有机场"/>';
	            }
	            $("#ctShow").html(cityShow);
	            $(".city_mdd,.select-people-list").hide();
	            $("#ctShow").show();
	            $(".city_mdd1").bind('click', function(e) {
	                var event = e || window.event;
	                $(".JS_select_dest").val(event.target.innerHTML);
	                $("#ctShow").hide();
	                $(".city_mdd1").unbind();
	                setCity($(".select-hotel"), event.target.innerHTML);
	            });
	            
	    });
	$(".select-hotel").keyup(function(e) {

	       var goCityV=$(".select-hotel").val().replace(/(^\s*)|(\s*$)/g, "");
	       goCityV=goCityV.toLocaleLowerCase();
	       $("#ctShow").hide();
	       var cityShow="";
	       if(goCityV=="" || goCityV == null){
	        $("#ctShow").hide();
	        $(".city_mdd").show();
	        return;
	       }
	       for(var i=0;i<allCities.length;i++){
	        if(allCities[i].split("|")[0].indexOf(goCityV)==0){
	            cityShow+="<p>"+allCities[i].split("|")[0]+"</p>";
	        }else if(allCities[i].split("|")[2].indexOf(goCityV)==0 || allCities[i].split("|")[1].indexOf(goCityV)==0){
	                cityShow+="<p>"+allCities[i].split("|")[0]+"</p>";
	        }else{
	             if(allCities[i].split("|")[2].indexOf(goCityV)==0){
	                cityShow+="<p>"+allCities[i].split("|")[0]+"</p>";
	            }
	        }
	       }
	            if(cityShow=="" || cityShow==null){
	                //cityShow+="您输入的城市没有机场"
	                cityShow='<input type="text" style="background:#fff" disabled="disabled" value="您输入的城市没有机场"/>';
	            }
	            $("#ctShow").html(cityShow);
	            $(".city_mdd,.select-people-list").hide();
	            $("#ctShow").show();
	            $(".city_mdd1").bind('click', function(e) {
	                var event = e || window.event;
	                $(".select-hotel").val(event.target.innerHTML);
	                $("#ctShow").hide();
	                $(".city_mdd1").unbind();
	                setCity($(".select-hotel"), event.target.innerHTML);
	            });
	            
	    });
	// 搜索
	        $(".fh-search-btn").on("click", function(e) {
	            var event = e || window.event;
	            //IE用cancelBubble=true来阻止而FF下需要用stopPropagation方法
	            event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
	            $('.city_mdd').hide();
	            if (validateFhInput()) {               // TODO
	                
	                var selectDepa=$(".select_depa").val();
	                var selectDest=$(".select_dest").val();
	                var selectHotel=$(".select-hotel").val();
	                 for(var i=0;i<allCities.length;i++){
	                    if(allCities[i].indexOf(selectDepa)!=-1){
	                        selectDepa=allCities[i].split("|")[3];
	                        $(".h_select_depa").val(selectDepa)
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
	                 
	            }else{
	                return false;
	            }
	        });

	        function validateFhInput() {
	            var $destInput = $(".JS_dest_input");        
	            var isOk = true;
	            if($(".select_depa").val() === ""||$(".select_depa").val() === "请输入出发地"){
	                isOk = false;
	                // var $thisCitySelect = $destInput.siblings(".JS_select_city");
	                $(".select_depa").addClass("fh-city-error");
	                $(".select_depa").click();
	            }else if ($destInput.val() === ""||$destInput.val() === "请输入目的地") {
	                isOk = false;
	                // var $thisCitySelect = $destInput.siblings(".JS_select_city");
	                $destInput.addClass("fh-city-error");
	                $destInput.click();
	            }else if($(".select-hotel").val() === ""||$(".select-hotel").val() === "请输入您的入住城市"){
	                 isOk = false;
	                // var $thisCitySelect = $destInput.siblings(".JS_select_city");
	                $(".select-hotel").addClass("fh-city-error");
	                $(".select-hotel").click();
	            }
	            return isOk;
	        }
	    function dayOfWeek(day) {
	        var d;
	        switch (day) {
	            case 0 || 7:
	                d = "天";
	                break;
	            case 1:
	                d = "一";
	                break;
	            case 2:
	                d = "二";
	                break;
	            case 3:
	                d = "三";
	                break;
	            case 4:
	                d = "四";
	                break;
	            case 5:
	                d = "五";
	                break;
	            case 6:
	                d = "六";
	                break;
	            default:
	                d = "一"
	        }
	        return d;
	    }

	    $dayAfterTom.html("星期" + dayOfWeek(dayAfterTom));
	    $dayAfter5.html("星期" + dayOfWeek(dayAfter5));

	    // 日历功能
	    $(".fh-calendar-info").click(function(e) {
	        var event = e || window.event;
	        event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);

	        var $input = $(this).siblings("input.input-calendar");
	        $input.focus();
	        $input.click();
	    });

	    $(".input-calendar").click(function() {
	        // 清除其他弹框
	        removeCalendar();
	        $(".city_mdd,.select-people-list").hide();
	    });

	    pandora.calendar({
	        trigger: ".JS_flight_calendar",
	        isRange: true,
	        cascade: {
	            days: 0,
	            trigger: ".JS_flight_calendar"
	        },
	        isTodayClick: false,
	        template: "small",
	        selectDateCallback: selectDateCallback
	    });

	    pandora.calendar({
	        trigger: ".JS_hotel_calendar",
	        isRange: true,
	        cascade: {
	            days: 0,
	            trigger: ".JS_hotel_calendar"
	        },
	        isTodayClick: false,
	        template: "small",
	        selectDateCallback: selectDateCallback
	    });

	    function selectDateCallback(cal) {          
	        $(cal.warp).bind("click", function(e) {
	            e = e || window.event;
	            if (e.stopPropagation) {
	                e.stopPropagation();
	            } else
	                e.cancelBubble = true;
	        });

	        var d1 = $(cal.options.trigger).eq(0).val().split('-'),
	            d2 = $(cal.options.trigger).eq(1).val().split('-'),
	            day = 0,
	            nd = null,
	            offset = null,

	            d1 = new Date(parseInt(d1[0], 10), parseInt(d1[1], 10) - 1, parseInt(d1[2], 10));
	        d2 = new Date(parseInt(d2[0], 10), parseInt(d2[1], 10) - 1, parseInt(d2[2], 10));
	        day = (d2.getTime() - d1.getTime()) / (1000 * 3600 * 24);


	        if (day <= 0) {
	            nd = cal.addDays(d1, 1);
	            week = cal.setToday({
	                year: parseInt(nd.getFullYear(), 10),
	                month: parseInt(nd.getMonth() + 1, 10),
	                day: parseInt(nd.getDate(), 10)
	            });
	            // 填充文案
	            if (typeof week === "string") {
	                $(cal.options.trigger).eq(1).siblings(".fh-calendar-info").find("i").html(week);
	            } else {
	                $(cal.options.trigger).eq(1).siblings(".fh-calendar-info").find("i").html(cal.options.weeks[cal._weekIndex + 1 === 7 ? 0 : cal._weekIndex + 1]);
	            }
	            $(cal.options.trigger).eq(1).val(nd.getFullYear() + "-" + cal.mend(nd.getMonth() + 1) + "-" + cal.mend(nd.getDate()));
	        }

	        var selectedDateArray = cal.selectedDate.split('-');
	        d = {
	            year: parseInt(selectedDateArray[0], 10),
	            month: parseInt(selectedDateArray[1], 10),
	            day: parseInt(selectedDateArray[2], 10)
	        };
	        week = cal.setToday(d);
	        // 填充文案
	        function setDayOfWeek($element, week) {
	            if (typeof week === "string") {
	                $element.siblings(".fh-calendar-info").find("i").html(week);
	            } else {
	                $element.siblings(".fh-calendar-info").find("i").html(cal.options.weeks[cal._weekIndex]);
	            }
	        }

	        setDayOfWeek(cal.$trigger, week);

	        // 酒店日历联动
	        if (cal.options.trigger === ".JS_flight_calendar") {
	            if (cal.$trigger[0] === $(cal.options.trigger).eq(0)[0]) {
	                // 更新入住日期
	                $('#hotelStartDate').val($(cal.options.trigger).eq(0).val());
	                setDayOfWeek($('#hotelStartDate'), week);

	            } else {
	                // 更新离店日期
	                $('#hotelEndDate').val($(cal.options.trigger).eq(1).val());
	                setDayOfWeek($('#hotelEndDate'), week);

	                var dHotelStart = $('#hotelStartDate').val().split('-');
	                dHotelStart = new Date(parseInt(dHotelStart[0], 10), parseInt(dHotelStart[1], 10) - 1, parseInt(dHotelStart[2], 10));
	                var dDiff = (d2.getTime() - dHotelStart.getTime()) / (1000 * 3600 * 24);

	                // 返程小于入住时，同时更新入住日期
	                if (dDiff <= 0) {
	                    $('#hotelStartDate').val($(cal.options.trigger).eq(0).val());
	                    setDayOfWeek($('#hotelStartDate'), $(cal.options.trigger).eq(0).siblings(".fh-calendar-info").find("i").html());
	                }
	            }
	            if (day <= 0) {
	                $('#hotelEndDate').val($(cal.options.trigger).eq(1).val());
	            }
	        }

	        if (cal.$trigger[0] === $(cal.options.trigger).eq(0)[0]) {
	            $(cal.options.trigger).eq(1).click();
	        }
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

	    $(".JS_select_city").on("click", function(e) {
	        var event = e || window.event;
	        event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
	        // 清除其他弹框
	        $(".select-people-list").hide();
	        removeCalendar();

	        var $this = $(this);
	        $(".JS_select_city").removeClass("JS_city_active");
	        $(this).addClass("JS_city_active");
	        var thisL = $this.offset().left,
	            thisT = $this.offset().top,
	            thisH = $this.outerHeight(true);
	        // 切换回热门
	        $(".JS_mt_hot").click();
	        $('.city_mdd').show().css({
	            'left': thisL,
	            'top': thisT + thisH
	        });
	         $('.city_mdd1').css({
	            'left': thisL,
	            'top': thisT + thisH
	        });
	    });

	    function removeCalendar() {
	        $(".ui-calendar").remove();
	    }

	    // 选择人数
	    $(".select-people").on("click", function(e) {
	        var event = e || window.event;
	        //IE用cancelBubble=true来阻止而FF下需要用stopPropagation方法
	        event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);
	        // 清除其他弹框
	        $(".select-people-list, .city_mdd").hide();
	        removeCalendar();

	        $(this).siblings(".select-people-list").show();
	    });

	    $(".select-people-list li").on("click", function(e) {
	        var event = e || window.event;
	        event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);

	        var value = $(this).data("num");
	        var $parent = $(this).parent();
	        $parent.siblings(".select-people").find("span").html(value);
	        $parent.siblings(".JS_people_num").val(value);
	        $parent.hide();
	        // reset
	        resetPeopleList($($parent.data("other-list")), value);
	    });

	    // child+adult<9
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
	        // 成人1 => 儿童0-2 限制
	        if ($element.selector == ".JS_child_list") {
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
	        // 同理：儿童3-4 => 成人>2
	        // if ($element.selector == ".JS_adult_list") {
	        //     if (parseInt(num) >= 3) {
	        //         $list.eq(0).hide();
	        //     }
	        // }

	    }

});
