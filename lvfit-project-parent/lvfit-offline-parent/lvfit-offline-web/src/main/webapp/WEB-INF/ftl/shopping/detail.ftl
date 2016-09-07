<div class="module2">
	<div style="font-size:14px">
		<label><b>购物车编号:</b></label>
		${shoppingUuid}
	</div>
	<!-- 关联订单 -->
	<h2>机票信息</h2>
	<table class="table1" id="flightTable">
		<tr>
			<th>航班号</th>
			<th>出发城市</th>
			<th>到达城市</th>
			<th>出发时间</th>
			<th>到达时间</th>			
			<th>飞行时长</th>
			<th>舱位名称</th>
			<th>子舱位名称</th>
		</tr>
		<#if flights??>
		<#list flights as flight>
		<tr>
			<td>
			    ${flight.flightNo}
			</td>
			<td>
				${flight.departureCityName}
			</td>
			<td>
				${flight.arrivalCityName}
			</td>	
			<td>
				${flight.departureTime}
			</td>
			<td>
				${flight.arrivalTime}
			</td>
			<td>
				${flight.flyTimeMins}
			</td>
			<td>
				${flight.seatClassName}
			</td>
			<td>
				${flight.seatClassCode}舱
			</td>
		</tr>		
		</#list>
		</#if>
	</table>
	<!-- 同主单订单 -->
	<h2>酒店信息</h2>
	<table class="table1" id="hotelTable">
		<tr>
			<th>酒店Id</th>
			<th>酒店名称</th>
			<th>规格Id</th>
			<th>房间名称</th>
			<th>商品Id</th>
			<th>商品名称</th>
			<th>预定房间数量</th>
			<th>入住日期</th>
			<th>离店日期</th>
		</tr>
		<#if hotels??>
		<#list hotels as hotel>
		<tr>
			<td>
			   ${hotel.hotelId}
			</td>
			<td>
			   ${hotel.hotelName}
			</td>
			<td>
				 ${hotel.roomId}
			</td>
			<td>
				 ${hotel.roomName}
			</td>
			<td>
				 ${hotel.planId}
			</td>
			<td>
				 ${hotel.planName}
			</td>
			<td>
				 ${hotel.roomCount}
			</td>
			<td>
				 ${hotel.checkinTime}
			</td>
			<td>
				 ${hotel.checkoutTime}
			</td>
		</tr>		
		</#list>
		</#if>
	</table>
	
	<h2>景点门票信息</h2>
	<table class="table1" id="spotTable">
		<tr>
			<th>景点Id</th>
			<th>景点名称</th>
			<th>门票Id</th>
			<th>门票名称</th>
			<th>门票种类</th>
			<th>购买门票数量</th>
			<th>游玩日期</th>
			<th>版本号</th>
			<th>门票价格</th>
		</tr>
		<#if spots??>
		<#list spots as spot>
		<tr>
			<td>
			   ${spot.spotId}
			</td>
			<td>
			   ${spot.spotName}
			</td>
			<td>
				 ${spot.ticketId}
			</td>
			<td>
				 ${spot.ticketName}
			</td>
			<td>
				 ${spot.ticketSpec}
			</td>
			<td>
				 ${spot.ticketCount}
			</td>
			<td>
				 ${spot.visitTime}
			</td>
			<td>
				 ${spot.versionNo}
			</td>
			<td>
				 ${spot.ticketPrice}
			</td>
		</tr>		
		</#list>
		</#if>
	</table>
	
	<h2>保险信息</h2>
	<table class="table1" id="insuranceTable">
		<tr>
			<th>保险Id</th>
			<th>保险名称</th>
			<th>保险类型</th>
			<th>保险规格Id</th>
			<th>规格名称</th>
			<th>保险商品Id</th>
			<th>保险商品名称</th>
			<th>购买保险数量</th>
			<th>保险价格</th>
		</tr>
		<#if insurances??>
		<#list insurances as insurance>
		<tr>
			<td>
			   ${insurance.insuranceId}
			</td>
			<td>
			   ${insurance.insuranceName}
			</td>
			<td>
				 ${insurance.insuranceType}
			</td>
			<td>
				 ${insurance.insuranceBranchId}
			</td>
			<td>
				 ${insurance.insuranceBranchName}
			</td>
			<td>
				 ${insurance.insuranceSuppGoodsId}
			</td>
			<td>
				 ${insurance.insuranceSuppGoodsName}
			</td>
			<td>
				 ${insurance.insuranceCount}
			</td>
			<td>
				 ${insurance.insurancePrice}
			</td>
		</tr>		
		</#list>
		</#if>
	</table>
	
	<h2>航空意外险信息</h2>
	<table class="table1" id="insuranceTable">
		<tr>
			<th>保险Id</th>
			<th>产品编码</th>
			<th>保险名称</th>
			<th>供应商名称</th>
			<th>购买保险数量</th>
			<th>保险价格</th>
		</tr>
		<#if flightInsurances??>
		<#list flightInsurances as flightInsurance>
		<tr>
			<td>
			   ${flightInsurance.insuranceId}
			</td>
			<td>
			   ${flightInsurance.insuranceClassCode}
			</td>
			<td>
			   ${flightInsurance.insuranceName}
			</td>
			<td>
				 ${flightInsurance.suppName}
			</td>
			<td>
				 ${flightInsurance.insuranceCount}
			</td>
			<td>
				 ${flightInsurance.insurancePrice}
			</td>
		</tr>		
		</#list>
		</#if>
	</table>
	
	<!-- 同主单订单 -->
	<h2>乘客信息</h2>
	<table class="table1" id="passengerTable">
		<tr>
			<th>乘客名称</th>
			<th>乘客类型</th>
			<th>证件类型</th>
			<th>证件号码</th>
			<th>手机号</th>
			<th>出生日期</th>
		</tr>
		<#if passengers??>
		<#list passengers as passenger>
		<tr>
			<td >
				${passenger.passengerName}
			</td>
			<td>
			  <#if passenger.passengerType == 'ADULT'> 成人<#else> 儿童 </#if>
			</td>
			<td>
			   <#if passenger.idCardType == 'ID'> 身份证<#else> 护照 </#if>
			</td>
			<td>
				 ${passenger.idCardNo}
			</td>
			<td>
				 ${passenger.telephone}
			</td>
			<td>
				<#if passenger.passengerBirthday ?? >${passenger.passengerBirthday}</#if>
			</td>
		</tr>		
		</#list>
		</#if>
	</table>
	
	<h2>用户信息</h2>
	<table class="table1">
		<tr>
			<th>用户ID</th>
			<th>用户名称</th>
		</tr>
		<#if detail ??>
		<#list detail as dl>
		<tr>
			<td>${dl.customerId}</td>
			<td>${dl.customerName}</td>
		</tr>
		</#list>
		</#if>
	</table>
	
	<h2>购买人信息</h2>
	<table class="table1">
		<tr>
			<th>姓名</th>
			<th>手机号</th>
			<th>邮箱</th>
		</tr>
		<#if detail ??>
		<#list detail as dl>
		<tr>
			<td>${dl.contacterName}</td>
			<td>${dl.contacterMobile}</td>
			<td>${dl.contacterEmail}</td>
		</tr>
		</#list>
		</#if>
	</table>
</div>
