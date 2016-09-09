
		  <div class="canderBox">
			     <p class="canderBox-load"><span class="canderBox-loadpic"></span><br>请稍后，日历正在加载中...</p>
		  </div>
      <input type="hidden" name="selectDate" id="selectDate">

<script>
var weekDay  = new Array("周日","周一","周二","周三","周四","周五","周六");

//日历框js开始
$(function() {
    $("#selectDate").val("");
    var params = {
        productId: $("#productId").val(),
        departureCityCode:$("#depCityCode").val(),
        arrivalCityCode:$("#arvCityCode").val(),
		categoryId:$("#bizCategoryId").val()
    };
    $.getJSON('${request.contextPath}/getCaclendarData', params, function(data) {
        initCalendar(data);
    });
});

function initCalendar(cdata){
	var calendarData = cdata;

	var starDateStr = "";
	if(typeof cdata == "object" && cdata.results!= null && cdata.results.length>0){
		starDateStr = cdata.results[0].departureDate;
	}
    var yyyyS = starDateStr.substr(0,4);
    var mmS = (starDateStr.substr(5,2))-1;
    var ddS = starDateStr.substr(8,2);
    var startDate = null;
	if(starDateStr == ""){
        startDate = new Date();
    }else{
        startDate = new Date(yyyyS,mmS,ddS,0,0,0);//页面默认显示日期
    }
    pandora.calendar({
		date: startDate, //默认月份
	    target: ".canderBox",//渲染容器
		trigger: ".canderBox-load",
		frequent: false, // 单月显示
		isTodayClick: true,
		titleTip: "{{year}}年{{month}}月", // 日历标题格式
		offsetAmount: { left: -821, top: -2 },
		template: "big", //小日历  small
		mostwo:true,
		mos: 24, //往后翻多少月
		selectDateCallback:function(that){//点击选择日期后的回调函数
			var $el = $(".ui-calendar td[date-map='" + that.selectedDate + "']");
			var priceTxt = $(".selectModel_freetour #"+that.selectedDate).html();
			var showPrice= that.selectedDate+"("+weekDay[$el.attr("week")]+")" + priceTxt;

			$(".cxrq").html( showPrice );
			$("#selectDate").val(that.selectedDate);

			loadsGoods(that.selectedDate);
		},
		completeCallback: function (obj) {//数据加载完成并显示出日历后的回调函数,点击上下月回调函数。
			$('.canderBox-load').hide();//隐藏日历loading
			var dayPrices = null;
			// 边框样式调整
			var $calbox = $('.canderBox .ui-calendar .calbox');
			$calbox.eq(0).css("border-left","1px solid #dcdcdc");
			$calbox.eq(1).css("border-right","1px solid #dcdcdc");
			$calbox.find("tbody tr:last td").css("border-bottom-width","0");
			
			if(calendarData.results!=null &&　calendarData.results.length>0){
			var dateArr = new Array(); // 记录时间价格的日期
			var datePos = 0; // 时间价格日期的数组坐标位
			//填充起价
			$("#product_price").html(calendarData.startPrice);
			// 分期价
			genInstalment(calendarData.instalments);

            calendarData.results.forEach(function(data){
				var el = $(".ui-calendar td[date-map='" + data.departureDate + "']");
				if(el.length > 0 && data.lowestSaledPrice >=0) {
					if (data.stock == 0) {
						el.find(".calinfo").html("售罄");
					} else {
						if(data.stock==-1){
							el.find(".calinfo").html("");
						}
						el.find(".calprice").html("&yen;" + data.lowestSaledPrice + "起");
						dateArr[datePos] = data.departureDate;
						datePos++;
					}
					//设置隐藏域的值
					if(data.lowestSaledChildPrice!=null){
						$(".selectModel_freetour").append("<option id='"+data.departureDate+"' value='"+data.departureDate+"'>"+data.lowestSaledPrice+"元/份");
					}
				}
			});
			// 处理没有时间价格的日期
			var tdElement=$(".ui-calendar").find("td");
			$(tdElement).each(function(t,v){
				var date=$(v).attr("date-map");
				var isNodate = true;
				for(var i=0;i<datePos;i++){
					if(dateArr[i]==date){
						isNodate = false;
						break;
					}
				}
                if (isNodate) {
                    $(v).find("div:eq(0)").removeClass().addClass("nodate");
                }
			});

            //下一页按钮是否出来
            var calendarEndDate = $('.calmonth').eq(1).find('.caltitle').attr('thistime');//当前日历上最后一个月
            if (calendarEndDate.length == 6) {
                calendarEndDate = calendarEndDate.replace("-", "0");
            } else {
                calendarEndDate = calendarEndDate.replace("-", "");
            }
            var calEndMonth = calendarEndDate.substr(4, 2);
            var calEndYear = calendarEndDate.substr(0, 4);
            var showEndDate = calendarData.results[calendarData.results.length - 1].departureDate;
            var showEndMonth = showEndDate.substr(5, 2);
            var showEndYear = showEndDate.substr(0, 4);

            if (((parseInt(calEndMonth) + 1) <= showEndMonth && showEndMonth < (parseInt(calEndMonth) + 2)) ||
                    ((parseInt(calEndMonth) + 1) < showEndMonth && showEndMonth <= (parseInt(calEndMonth) + 2)) ||
                    (showEndMonth > parseInt(calEndMonth) || showEndYear > parseInt(calEndYear))) {
            } else {
                $(".canderBox .ui-calendar .month-next").attr("style", "display:none");
            }
		}

		},
		// 节假日
		festival: {
			'2016-01-01': '元旦',
			'2016-02-07': '除夕',
			'2016-02-08': '春节',
			'2016-02-22': '元宵',
			'2016-04-04': '清明',
			'2016-05-01': '五一',
			'2016-06-09': '端午',
			'2016-09-15': '中秋',
			'2016-10-01': '国庆'
		}
	});
}

function genInstalment(data) {
	if (!data || data.length == 0) {
        $("#instalmentDiv").hide();
        $("#product-fenqi .detail-instance-body").hide();
        return;
    }
	var str = "支持以下分期方式："
			+ "<div class='pay_dotline'></div>"
			+ "<div class='payFQ_whole'>"
			+ "<div class='payFQ_bankname'>" + data[0].bankName + "</div>"
			+ "<table class='payFQ_table'>";
	var lowestPrice = 0;
	for (var i = 0; i< data.length; i++) {
		var itemStr = "<tr><td class='pay_first'></td><td width='90' class='pay_two'>￥<em>"
			+ data[i].price + "</em></td><td class='pay_three'><em>X</em>"
			+ data[i].term + "期</td></tr>";
		str += itemStr;
		if (lowestPrice ==0 || data[i].price < lowestPrice) {
			lowestPrice = data[i].price;
		}
	}
	str += "</table></div>";
	$(".product-price-value").html(lowestPrice);
	$("#instalmentSpan").attr("tip-content", str);
    $("#instalmentDiv").css("display", "block");
}

//日历框js结束 <!-- 日历模块模板结束 -->
</script>
