<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="mobile-agent" content="format=html5; url=http://m.lvmama.com/">
    <link rel="dns-prefetch" href="//s1.lvjs.com.cn">
    <link rel="dns-prefetch" href="//s2.lvjs.com.cn">
    <link rel="dns-prefetch" href="//s3.lvjs.com.cn">
    <title>驴妈妈旅游网</title>
    <link rel="shortcut icon" href="http://www.lvmama.com/favicon.ico" type="image/x-icon">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" href="http://pic.lvmama.com/min/index.php?f=/styles/v6/header_new.css,/styles/v6/public/base.css,/styles/v5/modules/paging.css,/styles/v5/modules/tip.css,/styles/v5/modules/calendar.css">
    <link rel="stylesheet" href="http://pic.lvmama.com/styles/v6/flighthotel/fh-result-loading.css">
    <link rel="stylesheet" href="http://pic.lvmama.com/styles/v6/flighthotel/fh-select-flight.css">
</head>

<body class="fh-select-flight">
    <!-- 流量埋点 -->
    <script src="http://pic.lvmama.com/min/index.php?f=/js/v5/ibm/eluminate.js"></script>
    <script src="http://pic.lvmama.com/min/index.php?f=/js/v5/ibm/coremetrics-initalize.js"></script>
    <script>_LVMAMA_COREMETRICS.init(document.domain);</script>
    <script>
        cmCreatePageviewTag("机酒频道首页_<fh-select-flight>", "FlightHotel", null, null,"-_--_--_--_--_-路径页面");
    </script>
     <script type="text/javascript" src="http://s2.lvjs.com.cn/js/common/losc.js"></script>
    <!-- banWrap -->
     <#if isBackBooking=='true'>
          <h3 style="font-weight: normal;">&nbsp;&nbsp;&nbsp;&nbsp;<a href="${request.contextPath}/back_index" style="color:#21a8dc">首页</a> >
               产品选择页
           </h3>
     </#if>
    
    <div class="banWrap">
        <!-- filter 筛选开始-->
        <div class="filter bd_ddd">
            
            <!-- filter-head 去程头部 添加hide类可以隐藏-->
            <div class="filter-head yh f18 c9">
                <a href="" class="btn backbtn cbtn-pink fr"><span class="btn-text">返回上一页</span></a><i class="fh-icon-depa"></i>更换去程航班：<span class="c3 pl10">${fcfi.departureCityName}<i class="fh-icon-from-to"></i><i class="pr15">${fcfi.arrivalCityName}</i><dfn class="arial f16">${fcfi.departureDate}</dfn></span>
            </div><!-- //filter-head-->
            
            <!-- filter-head 返程头部 已添加hide类隐藏-->
            <div class="filter-head yh f18 c9 hide">
                <a href="" class="btn backbtn cbtn-pink fr"><span class="btn-text">返回上一页</span></a><i class="fh-icon-dest"></i>更换返程航班：<span class="c3 pl10">${fcfi.departureCityName}<i class="fh-icon-from-to"></i><i class="pr15">${fcfi.arrivalCityName}</i><dfn class="arial f16">${fcfi.departureDate}</dfn></span>
            </div><!-- //filter-head-->

            <div class="search_kind">
                <dl class="clearfix js_fuxuan">
                    <dt>起飞时间</dt>
                    <dd class="kind_buxian"><a class="search_arrow_1" href="javascript:;">全部</a></dd>
                    <dd class="active"><a href="javascript:;"><i class="ph_icon hotel_ck"></i>凌晨（0-6点）</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>上午（6-12点）</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>下午（12-18点）</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>晚上（18-24点）</a></dd>
                </dl>
            </div><!-- //search_kind -->
            <div class="search_kind">
                <dl class="clearfix js_fuxuan">
                    <dt>到达时间</dt>
                    <dd class="kind_buxian"><a class="search_arrow_1" href="javascript:;">全部</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>凌晨（0-6点）</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>上午（6-12点）</a></dd>
                    <dd class="active"><a href="javascript:;"><i class="ph_icon hotel_ck"></i>下午（12-18点）</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>晚上（18-24点）</a></dd>
                </dl>
            </div><!-- //search_kind -->
            <div class="search_kind nobd">
                <dl class="clearfix js_fuxuan">
                    <dt>航空公司</dt>
                    <dd class="kind_buxian"><a class="search_arrow_1" href="javascript:;">全部</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>东方航空</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>南方航空</a></dd>
                    <dd class="active"><a href="javascript:;"><i class="ph_icon hotel_ck"></i>中国航空</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>中国航空</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>中国航空</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>中国航空</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>中国航空</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>中国航空</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>中国航空</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>中国航空</a></dd>
                    <dd class="active"><a href="javascript:;"><i class="ph_icon hotel_ck"></i>中国航空</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>中国航空</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>中国航空</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>中国航空</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>中国航空</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>中国航空</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>中国航空</a></dd>
                    <dd><a href="javascript:;"><i class="ph_icon hotel_ck"></i>中国航空</a></dd>
                </dl>
                <a class="search_gd js_moreSearch">更多<i class="arrow"></i></a>
            </div><!-- //search_kind -->

            <div class="request clearfix">
                <p class="result c9"><dfn class="f16 cf60 bold pr5">834</dfn>条航班</p>
                <dl class="request_list">
                    <dt>您已选择：</dt>
                    <dd>
                        <span>锦江之星<a class="request_close" href="javascript:;" title="删除">×</a></span>
                    </dd>
                    <dd>
                        <span>健身房<a class="request_close" href="javascript:;" title="删除">×</a></span>
                    </dd>
                    <dd>
                        <a class="close_all" href="javascript:;">清除所有条件</a>
                    </dd>
                </dl>
            </div><!-- //request -->
        </div><!-- //filter 筛选结束-->
            
        <!-- 排序开始 -->
        <div class="result_sort clearfix mt20">
            <ul class="rank_box">
                <li class="active"><a href="javascript:;">驴妈妈推荐 </a> </li>
                <li title="按价格由低到高排序"> <a href="javascript:;">价格 </a><i class="sort_up"></i></li>
                <li title="按好评率由高到低排序"><a href="javascript:;">好评率 </a><i class="sort_down"></i></li>
            </ul>
        </div><!-- 排序结束 -->

        <!-- 产品部分 -->
        <#if results?? >
        	<div class="fh-product clearfix">
            <!-- 搜索无结果 -->
            <div class="fh-no-result clearfix">
                <i></i>
                <div class="fh-nr-text">
                    <p class="sorry">非常抱歉，没有找到符合您条件的航班</p>
                    <p class="suggestion">建议您适当减少已选择的条件或 <a href="">取消条件重新搜索</a></p>
                </div>
            </div>
        	<#else>
        	
            <!-- 机票列表 -->
            <#list results as flo>
            <div class="flight-list">
                <div class="flight-detail clearfix">
                    <div class="flight-col flight-info">
                        <div class="flight-top">${flo.carrierName}</div>
                        <!-- TODO 机型信息填在对应的data属性中 -->
                        <div class="flight-bottom"><span class="flight-number">${flo.carrierCode}</span><span class="plane-type" data-plan="${flo.airplane.code}" data-name="${flo.airplane.name}" data-type="${flo.airplane.airplaneType}" data-min="${flo.airplane.minSeats123}" data-max="${flo.airplane.maxSeats}">${flo.airplane.code}</span></div>
                    </div>
                    <div class="flight-col flight-time">
                        <div class="flight-top">17:15</div>
                        <div class="flight-bottom"><a class="airport-name" href="javascript:;" title="${flo.departureAirportName}">${flo.departureAirportName}</a><span>${flo.departureAirportCode}</span></div>
                    </div>
                    
                    <div class="flight-col flight-stop">
                    
                    <#if flo.stopCount==0>
                    	<p class="flight-stop-text"></p>
                    	<#else>
                    	  <!-- TODO 没有经停时，删除“经停”两字，切勿删除P标签 -->
                        <p class="flight-stop-text">经停</p>
                    </#if>
                      
                        <div class="fh-icon-stop"></div>
                    </div>
                    
                    <div class="flight-col flight-time flight-arrival-time">
                        <div class="flight-top"><span class="time">${flo.arrivalTime}</span><span class="flight-add-one-day" tip-content="航班到达日期为起飞日期<span class='tip-add-one'>+1天</span>。">+1</span></div>
                        <div class="flight-bottom"><a class="airport-name" href="javascript:;" title="${flo.arrivalAirportName}">${flo.arrivalAirportName}</a><span>${flo.arrivalAirportCode}</span></div>
                    </div>
                    <div class="flight-col flight-duration">
                        <div class="flight-center">${flo.flyTime}</div>
                    </div>
                    <div class="flight-col flight-type">
                        <div class="flight-center">
                            <div class="select-class">
                                <span>经济舱</span>
                                <i></i>
                            </div>
                            <span class="flight-ticket-amount">剩余9</span>
                            <ol class="select-class-list">
                                <li class="active">
                                    <span class="scl-diff">+<i class="price-rmb">¥</i>0</span>
                                    <span class="scl-class">经济舱</span>
                                    <span class="scl-remain">剩余9</span>
                                </li>
                                <li>
                                    <span class="scl-diff">+<i class="price-rmb">¥</i>800</span>
                                    <span class="scl-class">公务舱</span>
                                    <span class="scl-remain">剩余2</span>
                                </li>
                                <li>
                                    <span class="scl-diff">+<i class="price-rmb">¥</i>840</span>
                                    <span class="scl-class">头等舱</span>
                                    <span class="scl-remain">剩余1</span>
                                </li>
                            </ol>
                        </div>
                    </div>
                    <div class="flight-col flight-diff">
                        <div class="flight-center">+<i class="price-rmb">¥</i>0</div>
                    </div>
                    <span class="fh-selected">已选<i class="icon icon-selected"></i></span>
                </div>
                
            </#list>
        </#if>
        
            
            <!-- 分页 -->
            <div class="paging orangestyle">
                <span class="gopage">到第 <input type="text" class="input-text"> 页 <button type="button" class="btn">确定</button></span>
                <div class="pagebox">
                    <a class="prevpage" href="#">上一页</a><a href="#">1</a><span class="pagemore">...</span><a href="#">16</a><a href="#">17</a><span class="pagesel">18</span><a href="#">19</a><a href="#">20</a><span class="pagemore">...</span><a href="#">50</a><a class="nextpage" href="#">下一页</a>
                </div>
            </div><!-- //paging -->
        </div>
    </div><!-- //banWrap结束 -->

    <!-- 查看机型 -->
    <div class="plane-info">
        <div class="plane-info-title">
            <span class="pi-plan">计划机型</span>
            <span class="pi-name">机型名称</span>
            <span class="pi-type">类型</span>
            <span class="pi-min">最少座位数</span>
            <span class="pi-max">最多座位数</span>
        </div>
        <div class="plane-info-detail">
            <span class="pi-plan"></span>
            <span class="pi-name"></span>
            <span class="pi-type"></span>
            <span class="pi-min"></span>
            <span class="pi-max"></span>
        </div>
    </div><!-- //plane-info结束 -->

    <!-- 正在加载弹层 START-->
    <div class="fh-overlay"></div>
    <div class="fh-dialog-loading">
        <div class="fh-dialog-inner clearfix">
            <div class="fh-dialog-body">
                <p>驴妈妈拼命加载中，请稍后...</p>
            </div>
        </div>
    </div>
    <!-- 正在加载弹层 END-->

    <script src="http://pic.lvmama.com/min/index.php?f=/js/new_v/jquery-1.7.2.min.js,/js/v6/header_new.js,/js/ui/lvmamaUI/lvmamaUI.js,/js/v5/modules/pandora-poptip.js,/js/v6/modules/pandora-calendar.js"></script>
    <script src="http://pic.lvmama.com/min/index.php?f=/js/v6/flighthotel/fh-select-flight.js,/js/v6/flighthotel/fh-flight-tip.js"></script>

    <script>
    $(function() {

        // 更换舱位
        $(".select-class-list li").on("click", function(e) {
            var event = e || window.event;
            event.stopPropagation ? event.stopPropagation() : (event.cancelBubble = true);

            // TODO 更换舱位后的操作
            var $this = $(this);
            var $parent = $(this).parent();
            $parent.siblings(".select-class").find("span").html($this.find(".scl-class").html());
            $parent.siblings(".flight-ticket-amount").html($this.find(".scl-remain").html());
            $this.parents(".flight-detail").find(".flight-diff .flight-center").html($this.find(".scl-diff").html());
            $parent.hide();
        });

        // 显示正在加载dialog
        $(".fh-overlay, .fh-dialog-loading").show();
        
        setTimeout(function(){
            // 隐藏正在加载dialog
            $(".fh-overlay, .fh-dialog-loading").hide();
        },2000);

    });
    </script>
</body>

</html>
