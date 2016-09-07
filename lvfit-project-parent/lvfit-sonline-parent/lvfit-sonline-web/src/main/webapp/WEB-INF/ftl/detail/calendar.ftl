<!--<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="http://s3.lvjs.com.cn/min/index.php?f=js/new_v/jquery-1.7.2.min.js"></script>
<script src="http://s1.lvjs.com.cn/min/index.php?f=/js/bower_components/jquery/jquery.min.js,/js/bower_components/jquery.actual/jquery.actual.min.js,/js/bower_components/underscore/underscore.js,/js/bower_components/backbone/backbone.js,/js/bower_components/marionette/lib/backbone.marionette.min.js,/js/bower_components/moment/min/moment.min.js,/js/bower_components/PikaChoose/lib/jquery.jcarousel.min.js,/js/bower_components/PikaChoose/lib/jquery.pikachoose.js,/js/bower_components/PikaChoose/lib/jquery.touchwipe.min.js&version=122906"></script>

<script src="http://s2.lvjs.com.cn/min/index.php?f=/js/ui/lvmamaUI/lvmamaUI.js,/js/v6/public/searchComplete.js,/js/v6/header_new.js,/js/v5/modules/pandora-poptip.js,/js/v6/modules/imgScroll1.js,/js/v5/modules/pandora-select.js,/js/v5/modules/pandora-dialog.js,/js/common/losc.js,/js/v6/comment/new_comment.js,/js/v6/public/common_box.js&version=122906"></script>

<script src="http://s3.lvjs.com.cn/min/index.php?f=/js/line/config.js,/js/line/util.js,/js/line/calendar.js,/js/line/product-detail-freetour.js"></script>
<script src="http://www.lvmama.com/vst_front/js/comm/comment.js?verson=201508111234"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.4"></script>
<script src="http://s1.lvjs.com.cn/min/index.php?f=/js/v5/ibm/eluminate.js,/js/v5/ibm/coremetrics-initalize.js&version=122906"></script>

<script src="http://s2.lvjs.com.cn/min/index.php?f=/js/v6/modules/calendar-detail.js"></script>
<script src="/vst_front/js/localAndOutBU/linedetail.js?verson=201601281640"></script>
<script type="text/javascript" src="http://s3.lvjs.com.cn/js/v6/public/promotion-module.js"></script>
</head>
<body>-->
<div class="canderBox">
     <p class="canderBox-load"><span class="canderBox-loadpic"></span><br>请稍后，日历正在加载中...</p>
</div>
<!--</body>
</html>-->
<!-- 日历模块模板开始 -->
<script>
var weekDay  = new Array("周日","周一","周二","周三","周四","周五","周六");  

//日历框js开始
$(function(){
    pandora.calendar({
        target: ".canderBox",//渲染容器
        trigger: ".canderBox-load",
        frequent: false, // 单月显示
        isTodayClick: true,
        titleTip: "{{year}}年{{month}}月", // 日历标题格式
        offsetAmount: { left: -821, top: -2 },
        mostwo:true,
        //mos: 24, //往后翻多少月
        selectDateCallback:function(that){//点击选择日期后的回调函数
			//点击选择日期之后的事件
        },
        completeCallback: function (obj) {//数据加载完成并显示出日历后的回调函数,点击上下月回调函数。
            $('.canderBox-load').hide();//隐藏日历loading
            var dayPrices = null;
            // 边框样式调整
            var $calbox = $('.canderBox .ui-calendar .calbox');
            $calbox.eq(0).css("border-left","1px solid #dcdcdc");
            $calbox.eq(1).css("border-right","1px solid #dcdcdc");
            $calbox.find("tbody tr:last td").css("border-bottom-width","0");
            $(".ui-calendar").append("<div class='ftc-tip'><i></i>因票价变动频繁，请以实时查询报价为准</div>");
            
            var params = {
                  productId: 578809,
                  startDate:2016-05-17,
                  endDate:2016-06-30
            };
            
            $.getJSON('${request.contextPath}/getCaclendarData', params, function(response) {
                    var dateArr = new Array(); // 记录时间价格的日期
        	        var datePos = 0; // 时间价格日期的数组坐标位
                    response.forEach(function(data){
                        var el = $(".ui-calendar td[date-map='" + data.departureDate + "']");
                        if(el.length > 0 && data.lowestSaledPrice >=0) {
                           if(data.stock == 0) {
                             el.find(".calinfo").html("售罄");
                           }else{
                           
                              if(data.stock==-1){
                                 el.find(".calinfo").html("");
                              }else if(data.stock >= 10){
                                  el.find(".calinfo").html("充足");
                              }else if(data.stock<10){
                                  el.find(".calinfo").html("余"+data.stock);
                              }
                    	      el.find(".calprice").html("&yen;" + data.lowestSaledPrice + "起");
                    	      if(data.displayType) {
	                             el.find(".caltips").html("促");
	                          }
	                          //if(data.lineRouteName) {
	                          //   el.find(".caltips").attr("routeId", data.lineRouteId).html(data.lineRouteName);
	                          //   el.find(".caltips").attr("class","caltips stroke")
	                          //}
	                    
	                           dateArr[datePos] = data.departureDate;
						       datePos++;
                           }  
                           //设置隐藏域的值
                          if(data.lowestSaledChildPrice!=0&&data.lowestSaledChildPrice!=null){
                             $(".selectModel_freetour").append("<option id='"+data.departureDate+"' value='"+data.departureDate+"'>成人"+data.lowestSaledPrice+"元/人  儿童"+data.lowestSaledChildPrice+"元/人</option>");
                          }else{
                              $(".selectModel_freetour").append("<option id='"+data.departureDate+"'  value='"+data.departureDate+"'>成人"+data.lowestSaledPrice+"元/人</option>");
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
				       if(isNodate){
					       $(v).find("div:eq(0)").removeClass().addClass("nodate"); 
				       }
			       });
                
             });
              
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

    
    //焦点图
    $('.product-Img').imgScroll1({  
          migBox: '.product-pic', //运动列表ul的父级；
          tabBox: '.product-spic',     //切换列表ul的父级
          btnL : '.js_btnL',    //左按钮
          btnR : '.js_btnR',    //右按钮
          tab_name : 'active',  //切换高亮状态的class
          runStyle : 2          //大图切换方式，1是左右滚动，2是渐变切换
    });



    /**
     * showYinDialog 显示酒店/门票弹窗
     * @param {boolean} isTicketDialog 是否为门票弹窗
     * @param {boolean} isCommented 是否有评论
     * @param {boolean} isMultipleImages 是否为多张图片
     */
    $(".JS_yin_hotel_dialog").on("click", function(){
        showYinDialog(false, false, false);
    });

    $(".yin-dialog-change-hotel").on("click", function(){
        pandora.dialog({
            title: "更换其他酒店&emsp;<small>入住3晚&emsp;入住：2014-07-29&emsp;离店：2014-08-01</small>",
            content: $(".yin-hotel-dialog-template").html(),
            width: "900px",
            height: "550px"
        });
    });

    var $document = $(document);
    $document.on("click",".js_yhir_room_select_btn",function(){
        console.log("选择");
    });


});
//日历框js结束 <!-- 日历模块模板结束 -->
</script>