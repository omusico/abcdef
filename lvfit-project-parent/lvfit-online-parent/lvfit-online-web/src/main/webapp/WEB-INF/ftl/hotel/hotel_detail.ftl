<!-- hotelAlert 酒店弹窗 -->
<div class="resortOverlay"></div>
<div class="hotelAlert">
	<a href="javascript:;" class="ph_icon ph_icon_closehotel pa JS_hotelAlertClose"></a>
	<div class="hotelAlert-tit">
		<em id="hotel_detail_name" class="yh f20 c3"></em>
		<span id="hotel_detail_star" class="c9 pl10"></span>
	</div>
	
	<ul class="hotelAlertTab mt15 f14">
		<li class="active" >酒店简介</li>
		<li class="comment_hidden">点评<dfn class="cf60" id="hotel_comment_count2"></dfn></li>
		<li class="last">地图</li>
	</ul>
	<div class="hotelAlertCon">
		<!-- 酒店信息 -->
		<div class="hotelAlertInfo clearfix hotelAlertCon-li mt15" style="display:block">
			<!-- hotelInfo 酒店图示 -->
	        <div class="hotelInfo-Img fl pr">
	           <div id="hotel_detail_pic_big" class="hotelInfo-pic pr"></div>
	            <div class="hotelInfo-spic pr ml20 mt5">
	                <ul id="hotel_detail_pic_small" class="pa"></ul>
	            </div><!-- //hotelInfo-spic -->
	            <a href="javascript:;" class="l hotelImg-btn"><span class="ph_icon ph_icon_alertl"></span></a>
	            <a href="javascript:;" class="r hotelImg-btn"><span class="ph_icon ph_icon_alertr"></span></a>
	        </div><!-- //hotelInfo-Img -->
	
	        <!-- hotelInfo酒店信息 -->
	        <div class="hotelInfoBox fr pr20">
	            <ul class="hotelInfo">
	            	<li><em>酒店地址：</em><span id="hotel_detail_address"></span></li>
	            	<li>
	            		<em>设施服务：</em>
						<div class="list-icon" id="hotel_detail_fac"></div>
	            	</li>
	            	<li><em>酒店电话：</em><dfn id="hotel_detail_phone" class="cf60 f16"></dfn></li>
	            	<li><em>酒店政策：</em><span id="hotel_detail_policy"></span></li>
	            	<li><em>酒店简介：</em><span id="hotel_detail_desc"></span></li>
	            </ul>
				
				<!-- 地理位置 -->
				<div class="c9 mt15">地理位置：</div>
	            <div id="hotel_detail_traffic" class="hotelInfo-address mt10"></div><!-- //hotelInfo-address -->
	        </div><!-- //hotelInfo -->
		</div><!-- //hotelAlertInfo -->
		
		<!-- 点评 -->
		<div class="hotelAlertCom hotelAlertCon-li comment_hidden">
			<div class="alertComCount c9">
				<dfn class="f18 cf60" id="hotel_comment_per"></dfn>
				好评率&emsp;来自<dfn class="c6 f14" id="hotel_comment_count"></dfn>条点评</div>
			<div class="hotelAleCom mt5" id="hotel_comment_page">
			</div><!-- //alertCom -->
			<!-- 分页 -->
	        <div class="paging orangestyle">
				<div class="pagebox" id="pageComment">
		    	</div>
	        </div><!-- //paging -->
		</div><!-- //hotelAlertCom -->
		
		<!-- 地图 -->
		<div class="hotelAlertMap hotelAlertCon-li">
			<div class="traffic-map" id="traffic-map"></div>
		</div><!-- //hotelAlertMap -->
		
   </div><!-- //hotelAlertCon -->
  </div> <!-- //hotelAlert -->
  <!-- hotelAlert 酒店弹窗结束 -->
