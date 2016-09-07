
		<div id="myBigCalendar">
			<p class="canderBox-load">请稍后，日历正在加载中...</p>
		</div>
        <input type="hidden" name="selectDate" id="selectDate">
<script>

//日历框js开始
$(function(){
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

function initCalendar(data) {
    var calendarData = data;
    $("#selectDate").val("");
    var showStartMonth;
    var showStartMonthD ="";
    if(typeof data == "object" && data.results!= null && data.results.length>0){
    	showStartMonthD = calendarData.results[0].departureDate;
    }
    var yyyyS = showStartMonthD.substr(0, 4);
    var mmS = (showStartMonthD.substr(5, 2)) - 1;
    var ddS = showStartMonthD.substr(8, 2);
    if (showStartMonthD == "") {
        showStartMonth = new Date();
    } else {
        showStartMonth = new Date(yyyyS, mmS, ddS, 0, 0, 0);//页面默认显示日期
    }
    showStartMonth = lv.calendar.dateFormat(showStartMonth, "yyyy-MM-dd");
	var myBigCalendar = lv.calendar({
		date:showStartMonth, //默认月份
        autoRender: true,  //自动渲染日历
        trigger: "#myBigCalendar",  //触发的位置
        triggerEvent: "click",  //响应的触发事件 自动渲染时此参数无效
        isTodayClick: true,
        sourceFn: fillData,  //填充时间价格表
        //completeCallback: completeCallback,  //日历加载完成后执行的回掉函数
		selectDateCallback:function() {//点击选择日期后的回调函数
            var selectedDate = myBigCalendar.getSelect();
            $("#selectDate").val(selectedDate);
            $("#playtime").val(selectedDate);
            var text = $("#playtime").find("option:selected").text();

            $("#playtime").siblings(".selectbox").find(".select-value").html(text);

            loadsGoods(selectedDate);
        },
        monthPrev: 0  //日历可以往后翻页2页
    });

    function fillData() {
        var self = this;
        var url = "${request.contextPath}/getCaclendarData?productId="+$("#productId").val()+"&departureCityCode="+$("#depCityCode").val()+"&arrivalCityCode="+$("#arvCityCode").val() + "&categoryId=" + $("#bizCategoryId").val();

        /**
         * 获取剩余HTML
         * @param inventory 剩余数量
         * @returns {string} 生成的HTML
         */
        function getStoreHTML(inventory) {
            var html = "";
            if (inventory <= 0) {
                html = "售罄";
            } else if (inventory < 10) {
                html = "余" + inventory
            }
            return html;
        }

        /**
         * 创建浮动框
         * @returns {*|jQuery|HTMLElement}  被创建的浮动框jQuery对象
         */
        function createHover() {
            var $hover = $(".calhover");
            if ($hover.length <= 0) {
                $hover = $('<div class="calhover"><div class="triangle"></div></div>');
            } else {
                $hover.html('<div class="triangle"></div>');
            }
            $("body").append($hover);
            $hover.removeClass("calhover-right");
            return $hover;
        }

        /**
         * 设置显示
         * @param data Ajax返回值
         * @returns {boolean}
         */
        function setDate(data) {

            /**
             * 退化的情况，无任何返回值
             */
            if (!data) {
                return false;
            }

            var $allTd = self.wrap.find('td[data-date-map]');  //所有的日历单元格
            $allTd.children().addClass("caldisabled");  //先禁用所有的日历日期

            //对json对象进行迭代处理
            data.results.forEach(function (row) {
                //row 每个json对象中的元素单元，格式如下所示
                // {
                //     "child": 3688,         lowestSaledChildPrice : 0
                //     "date": "2016-06-11",  departureDate : "2016-05-24"
                //     "detail": "",
                //     "endDate": "201612",
                //     "lineRouteId": 0,      lineRouteId : 13120
                //     "lineRouteName": "A",
                //     "next": true,
                //     "prev": false,
                //     "price": 3988,         lowestSaledPrice : 300
                //     "surplus": 4,
                //     "type": 1,
                //     "inventory": -1,       stock : 199
                							  groupName : "LOWEST_SALED_PRICE"
                //     "oversold": false,
                //     "sale": "下单满3000减200元，成人儿童可享受，不与其他优惠同享；\n下单满2000减150元，成人儿童可享受，不与其他优惠同享；\n下单满1000减100元，成人儿童可享受，不与其他优惠同享；"
                // }

                var jsonDateStr = row.departureDate;  //json单元-日期

                //将json单元日期字符串转化为JS日历对象(new Date())
                var date = lv.calendar.getDateFromFormattedString(jsonDateStr, self.options.dateFormat);

                //将日历对象转换为字符串(只保留参数dateFormat设定的数据，默认值为年月日)
                var dateStr = lv.calendar.dateFormat(date, self.options.dateFormat);

                //json单元-价格
                var price = row.lowestSaledPrice;

                //价格-浮点数
                var inventory = parseFloat(row.stock);

                //json单月-是否促销
                //var sale = row.sale;

                //json单元-日期对应文档中的td单元格
                var $td = self.wrap.find('td[data-date-map=' + dateStr + ']');

                //如果json中的数据有td单元格相对应，则显示数据信息
                if ($td) {

                    //促销等元素的显示位置
                    var $calActive = $td.find(".calactive");

                    //显示价格
                    $td.find(".calprice").html('<i>¥</i><em>' + price + '</em>起');

                    //显示库存
                    //$td.find(".calinfo").html(getStoreHTML(inventory));

                    //是否售罄
                    //if (inventory <= 0) {
                    //    $td.find(".calinfo").addClass("sellout");
                    //} else {
                       $td.children().removeClass("caldisabled")
                    //}

                    //是否促销  ---暂不展示
                    //if (sale) {
                    //    var $sale = $('<div class="calsale">促</div>');
                    //    $calActive.append($sale);
                    //}

                }
            });


            //显示促销/线路/休假浮动框
            (function () {

                var festival;  //节日
                var route;  //线路
                var sale;  //促销

                //鼠标移开，隐藏浮动框
                self.wrap.on("mouseleave", "[data-date-map]", function () {
                    var $hover = $(".calhover");
                    $hover.hide();
                    $hover.css({
                        left: 0,
                        top: 0
                    });
                });

                //鼠标移入，显示浮动框
                self.wrap.on("mouseenter", "[data-date-map]", function () {
                    var hasOnce = false;

                    //td单元格
                    var $this = $(this);

                    //sting 当前单元格日期字符串
                    var date = $this.attr("data-date-map");

                    //创建浮动框jQuery DOM对象
                    var $hover = createHover();

                    //休假
                    var $calfestival = $('<p class="calfestival"><i>休</i><span></span></p>');
                    var $calfestivalContent = $calfestival.find("span");

                    //线路
                    var $calroute = $('<p class="calroute"><i> </i><span></span></p>');
                    var $calrouteTitle = $calroute.find("i");
                    var $calrouteContent = $calroute.find("span");

                    //促销
                    var $calsale = $('<p class="calsale"><i>促</i><span></span></p>');
                    var $calsaleContent = $calsale.find("span");

                    //显示坐标
                    var left = $this.offset().left;
                    var top = $this.offset().top + $this.outerHeight();

                    //节日
                    var thatFestival = self.options.festival[date];
                    festival = thatFestival;
                    if (thatFestival) {
                        hasOnce = true;
                        $calfestivalContent.html(thatFestival.vacationName);
                        $hover.append($calfestival);
                    }

                    //页面右侧处理，如果屏幕过小，则显示在左侧
                    var width = $hover.outerWidth();

                    var $table = $this.parents(".caltable");
                    var tableLeft = $table.offset().left;
                    var tableWidth = $table.outerWidth();
                    if (width + left - tableLeft > tableWidth) {
                        left = tableLeft + (tableWidth - width);
                        $hover.addClass("calhover-right");
                    }

                    //显示
                    if (hasOnce) {
                        $hover.show();
                        $hover.css({
                            left: left,
                            top: top
                        });
                    }

                });

            })();
        }
        if(data && data.results!=null && calendarData.results.length>0){
	        setDate(calendarData);
	        //填充起价等
	        fitOther(calendarData);
	        pageNext(data.results[0].departureDate, data.results[data.results.length-1].departureDate);
        }
        $(".canderBox-load").html("<br>");
    }
    //上一页下一页展示
    //pageNext(data.results[0].departureDate, data.results[data.results.length-1].departureDate);
}

//上一页、下一页按钮是否显示
function pageNext(startDate, endDate) {
    var calendarEndDate = $(".mtitle").text();

    var calMonth = calendarEndDate.substring(5, calendarEndDate.length-1);
    var calYear = calendarEndDate.substr(0,4);

	var showEndDate = endDate;
    var showEndMonth = showEndDate.substr(5,2);
    var showEndYear =  showEndDate.substr(0,4);
    //下一页
    if(parseInt(calMonth) >= showEndMonth && parseInt(calYear) >= parseInt(showEndYear)) {
       $(".month-next").attr("style","display:none");
    }
    //上一页
    var showStartDate = startDate;
    var showStartMonth = showStartDate.substr(5,2);
    var showStartYear = showStartDate.substr(0,4);
    if(parseInt(showStartMonth) >= parseInt(calMonth) && parseInt(showStartYear) >= parseInt(calYear)) {
    	$(".month-prev").attr("style","display:none");
    }
}

//填充起价定
function fitOther(data){
	// 填充起价
	$("#product_price").html(data.startPrice);
	// 分期价
	genInstalment(data.instalments);
	// 构造出行日期下拉列表
	genPlayDateTimeSelect(data.results);
}

function genInstalment(data) {
    if (!data || data.length == 0) {
        $("#instalmentDiv").hide();
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

function genPlayDateTimeSelect(data) {
    var arr1 = new Array();
    var arr2 = new Array();
    arr1.push("<option>请选择出行时间</option>");
    arr2.push("<li>请选择出行时间</li>");
    for (var i=0; i<data.length; i++) {
        var value = data[i].monthAndDay + " " + data[i].dayOfWeek + " " + "成人" + data[i].lowestSaledPrice + "元/人";
        var optionStr1 = "<option value=\"" + data[i].departureDate + "\">" + value + "</option>";
        var optionStr2 = "<li rel=\"" + data[i].departureDate + "\">" + value + "</li>";

        arr1.push(optionStr1);
        arr2.push(optionStr2);
    }
    $("#playtime").html( arr1.join("") );
    $("#playtime").siblings(".selectbox").find(".select-results").attr("id", "playtimeUl").html( arr2.join("") );
}

$("#playtimeUl li").live("click", function() {
    $(this).parents(".selectbox-drop").siblings(".select-info").find(".select-value").text($(this).text());
    $("#playtime").val( $(this).attr("rel") );
    $("#selectDate").val( $(this).attr("rel") );
    loadsGoods( $(this).attr("rel") );
    $(".caltable").find("td").removeClass("td-selected");
});



//日历框js结束 <!-- 日历模块模板结束 -->
</script>
