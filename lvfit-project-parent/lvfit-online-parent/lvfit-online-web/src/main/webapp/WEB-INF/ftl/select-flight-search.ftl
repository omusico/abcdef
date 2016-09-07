<!-- 产品部分 -->
<input type="hidden" id="search_flight_size" value="${results?size }" />
<#if results?? && results?size gt 0 >
    <div class="flight-list">
    <!-- 机票列表头部 -->
    <div class="flight-title clearfix">
        <div class="flight-col flight-info">航班信息</div>
	    <div class="flight-col flight-time"><a <#if sortByDepartureTimeDate == "true"> class="active" </#if> id="sort_departuretime" <#if sortByDepartureTimeDate == "true" && asc == "desc">title="按起飞时间 从晚到早排序"<#else>title="按起飞时间 从早到晚排序"</#if>  onclick="sortFunction(this)"  href="javascript:;">起飞时间 <em <#if sortByDepartureTimeDate == "true" && asc == "desc">class="sort_down"<#else>class="sort_up"</#if> ></em></a></div>
        <div class="flight-col flight-stop"></div>
        <div class="flight-col flight-time flight-arrival-time">到达时间</div>
        <div class="flight-col flight-duration">飞行时长</div>
        <div class="flight-col flight-type">舱位</div>
        <div class="flight-col flight-diff"><a <#if sortByDiffPrice == "true">class="active" </#if> id="sort_price" onclick="sortFunction(this)" <#if sortByDiffPrice == "true" && asc == "desc">title="按差价由高到低排序"<#else>title="按差价由低到高排序"</#if> href="javascript:;">差价<em <#if sortByDiffPrice == "true" && asc == "desc">class="sort_down"<#else>class="sort_up"</#if> ></em></a></div>
    </div><!-- //flight-title -->
 <#list results as flo>
  	<!-- 机票列表 -->
    
      <div class="flight-detail clearfix">
          <div class="flight-col flight-info">
          	
              <div class="flight-top">
              	<i class="fh-icon-ac fh-icon-ac-${flo.carrierCode}"></i>
             			 ${flo.carrierName}
              </div>
              <!-- TODO 机型信息填在对应的data属性中 -->
              <div class="flight-bottom"><span class="flight-number">${flo.flightNo}</span><span class="plane-type" data-plan="${flo.airplane.code}" data-name="${flo.airplane.name}" data-type="${flo.airplane.airplaneType}" data-min="${flo.airplane.minSeats}" data-max="${flo.airplane.maxSeats}">${flo.airplane.code}</span></div>
          </div>
          <div class="flight-col flight-time">
              <div class="flight-top">${flo.departureTime}</div>
              <div class="flight-bottom"><a class="airport-name" href="javascript:;" title="${flo.departureAirportName}">${flo.departureAirportName}</a><span>${flo.departureTermainalBuilding}</span></div>
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
          
              <div class="flight-top"><span class="time">${flo.arrivalTime}</span>
           
           			<#if flo.highLightFlag>
           				<span class="flight-add-one-day" tip-content="航班到达日期为起飞日期<span class='tip-add-one'>+1天</span>。">+1</span>
           			<#else>
              	<span class="flight-add-one-day" tip-content="航班到达日期为起飞日期<span class='tip-add-one'>+1天</span>。"></span>
               </#if>
              </div>
              
              <div class="flight-bottom"><a class="airport-name" href="javascript:;" title="${flo.arrivalAirportName}">${flo.arrivalAirportName}</a><span>${flo.arrivalTerminalBuilding}</span></div>
          </div>
          <div class="flight-col flight-duration">
              <div class="flight-center">${flo.flyTime}</div>
          </div>
         
           
          <!--新版舱位展示----开始-->
        <div class="flight-type-list">
            <ul>
            <#list flo.seats as seatInfo>
                <li class="clearfix" style="display:${(seatInfo_index == 0)?string("block;","none;")}" <#if seatInfo.selectFlag==true>id="selectSeat"</#if>>
                    <div class="flight-col flight-type">
                        <div class="flight-center">
                        	<em code=${seatInfo.seatClassCode} pricepolicyid="${seatInfo.pricePolicyId}"><span class="flight-class">${seatInfo.seatClassTypeName}</span></em>
                            <#if seatInfo.inventoryCount lte 9>
                        	  <span class="flight-ticket-amount">剩余${seatInfo.inventoryCount}</span>
                        	<#else>
                        		<span class="flight-ticket-amount" style="display:none;"></span>
                        	</#if>
                        </div>
                    </div>
                    
                    <#if seatInfo.differentPrice lt 0>
                    	<div class="flight-col flight-diff flight-diff-minus" id="flight-price">
        	 				<!--<span class="scl-diff">-<i class="price-rmb">¥</i>${seatInfo.differentPrice*-1}</span>-->
        	 				<div class="flight-center"><em>-</em><i class="price-rmb">¥</i>${seatInfo.differentPrice*-1}</div>
        	 			</div>
					<#else>
						<div class="flight-col flight-diff" id="flight-price">
							<div class="flight-center"><em>+</em><i class="price-rmb">¥</i>${seatInfo.differentPrice}</div>
							<!--<span class="scl-diff">+<i class="price-rmb">¥</i>${seatInfo.differentPrice}</span>-->
						</div>
					</#if>
                    
                    <#if seatInfo.selectFlag==true>
                    <a href="javascript:void(0);" class="fh-selected">已选<i class="icon icon-selected"></i></a>
                    <#else>
                    <a href="javascript:void(0);" class="btn btn-sm btn-orange fh-select-btn">选择</a>
                    </#if>
                    <input type="hidden" id="flightNo"  value="${flo.flightNo}" >
                </li>
            </#list>
            </ul>
            <a class="more-type-btn" href="javascript:void(0);">更多舱位<i class="arrow"></i></a>
        </div>
        <!--新版舱位展示----结束-->
 </div>
  </#list>
  </div><!-- //flight-list -->
<#else>
<!-- 搜索无结果 -->
  <div class="fh-no-result clearfix">
    <i></i>
    <div class="fh-nr-text">
        <p class="sorry">非常抱歉，没有找到符合您条件的航班</p>
        <p class="suggestion">建议您适当减少已选择的条件或 <a href="javascript:;" id="reload">取消条件重新搜索</a></p>
    </div>
  </div>
</#if>
<script>
$(function(){
	initSeat();
	var uuid = "${shoppingUuid}";
    var errorMsgOutTime = "${errorMsgOutTime}";
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
    	}
    	$(".returnAlert").show();
		$('.resortOverlay').stop(true,true).show();
		$("#errorMsgOutTime").html(errorMsgOutTime);
    	var reloadUrl = "${request.contextPath}/search/"+uuid+"?tripType="+tripType+"&departureCityCode="+departureCityCode+"&arrivalCityCode="+arrivalCityCode+"&departureTime="+flightStartDate+"&returnTime="+flightEndDate+"&cityCode="+cityCode+"&checkInTime="+hotelStartDate+"&checkOutTime="+hotelEndDate+"&adultsCount="+adultsCount+"&childCount="+childCount;
    	$('#reloadUrl').val(reloadUrl);
    }
	});
	
	//取消条件重新搜索
    	$("#reload").click(function(){
    		
    		$(".request_list").html("");
			var c = $(".active");
			for(var i=0; i<c.length;i++){
				c.eq(i).attr("class","");
			}
         	var d = $(".kind_buxian");
         	for(var j=0;j<d.length;j++){
         		d.eq(j).attr("class","active");
         	}
         	
    		query.carriers = "ALL";
         	query.departureTimeSegments="ALL";
    		query.arrivalTimeSegments="ALL";
    		query.departAirports="ALL";
    		query.arriveAirports="ALL";
    		
         	listShow();
         	search();
	    		
	    });
</script>