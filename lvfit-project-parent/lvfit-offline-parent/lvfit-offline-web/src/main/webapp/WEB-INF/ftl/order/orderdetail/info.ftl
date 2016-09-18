<div class="module3">
	<div class="hbinfor">
		<h3 class="order_name">
		${base.productName }
		</h3>	
		<!-- <div class="title">航班信息</div> --> 
		<b>航班信息</b>
		<table id="flightInfoTable">
			<tr class="title">
				<th>去/返程</th>
				<th>乘客类型</th>
				<th>VST子单号</th>
				<th>机票子单号</th>
				<th>航班日期</th>
				<th>航班号</th>
				<th style="width: 140px;">航段</th>
				<th>起飞/到达时间 </th>
				<th>飞行时长</th>
				<th>舱位</th>
				<th>支付金额</th>
				<td>预定状态</td>
				<td>审核状态</td>
			</tr>
			
			<!-- 去程信息 -->
			<#if isCharter=='false'><!-- 如果是普通航班. -->
			<#list base.fitSuppMainOrderDto.fitSuppOrderDtos  as suppOrder>
			<#if suppOrder.categoryId == 21>
			<#list suppOrder.suppFlightOrderDtos as flightOrder>
			<tr>	
				<td><#if flightOrder.tripType == "DEPARTURE">去程<#else>返程</#if></td>
				<td><#if flightOrder.passengerType == "ADULT">成人<#else>儿童</#if></td>
				<td>
					<a target='_blank' href="http://super.lvmama.com/vst_order/order/orderManage/showChildOrderStatusManage.do?orderItemId=${suppOrder.vstOrderNo }">${suppOrder.vstOrderNo }</a>
					&nbsp;
				</td>
				<td>
					<!-- <a target='_blank' href="http://super.lvmama.com/offline-web/order/queryOrderDetailByVstOrderId/${suppOrder.vstOrderNo ? trim}/${flightOrder.flightOrderNo ? trim}">${flightOrder.flightOrderNo ? trim}</a> -->
					<a target='_blank' href="http://super.lvmama.com/vst_order/order/orderManage/showChildOrderStatusManage.do?orderItemId=${suppOrder.vstOrderNo }">${flightOrder.flightOrderNo ? trim }</a>
					&nbsp;
				</td>
				
				<#if flightOrder.tripType != "NULL" && flightOrder.tripType != '' && flightOrder.tripType == "DEPARTURE">
				<td>${flight0.departureDate }</td>
				<td>${flight0.carrierName } <br/>${flight0.flightNo } ${flight0.airplane.code }</td>
				<td>${flight0.departureCityName }${flight0.departureAirportName }${flight0.departureTermainalBuilding } ---
						${flight0.arrivalCityName }${flight0.arrivalAirportName }${flight0.arrivalTerminalBuilding }
				</td><!-- 上海虹桥机场T2—三亚凤凰国际机场T1 -->
				<td >
					${flight0.departureTime }<br/>${flight0.arrivalTime }&nbsp;
				</td>
				<td >
					${flight0.flyTimeMins }&nbsp;
				</td>
				<td>
				&nbsp;${flight0.seatClassTypeName }
				<#if flightOrder.passengerType == "ADULT">${flight0.seatClassCode }<#else>${flight0.seatClassType }</#if>
				</td>
				<#else>
				<td>${flight1.departureDate }</td>
				<td>${flight1.carrierName } <br/>${flight1.flightNo } ${flight1.airplane.code }</td>
				<td>${flight1.departureCityName }${flight1.departureAirportName }${flight1.departureTermainalBuilding } ---
						${flight1.arrivalCityName }${flight1.arrivalAirportName }${flight1.arrivalTerminalBuilding }
				</td><!-- 上海虹桥机场T2—三亚凤凰国际机场T1 -->
				<td >
					${flight1.departureTime }<br/>${flight1.arrivalTime }&nbsp;
				</td>
				<td >
					${flight1.flyTimeMins }&nbsp;
				</td>
				<td>&nbsp;${flight1.seatClassTypeName }
				<#if flightOrder.passengerType == "ADULT">${flight1.seatClassCode }<#else>${flight1.seatClassType }</#if>
				</td>
				</#if>
				
				<td>
				<#if flightOrder.orderAmount?? && flightOrder.orderAmount.totalSalesAmount ??>
					${flightOrder.orderAmount.totalSalesAmount ? trim}
					&nbsp;
				</#if>
				</td>
				<td>
					<#if flightOrder.bookingStatus ??>
						${ flightOrder.bookingStatus.cnName  }
					<#else>
						预订失败
					</#if>
					&nbsp;
				</td>
				<td>
				     ${suppOrder.fitSuppOrderStatusDto.orderItemStatus.cnName }
                         <br>
                                  资源审核 （${suppOrder.fitSuppOrderStatusDto.resAuditStatus.cnName }）
                         <br>
                                 信息审核（${suppOrder.fitSuppOrderStatusDto.infoAuditStatus.cnName }）
				</td>
				
				
			</tr>
			</#list>
			</#if>
			</#list>
			</#else><!-- 如果是包机. -->
					<#list base.fitSuppMainOrderDto.suppFlightOrderDtos  as suppOrder>
						<#if suppOrder.categoryId == 21>
							<#list suppOrder.suppFlightOrderDtos as flightOrder>
								<tr>	
									<td><#if flightOrder.tripType == "DEPARTURE">去程<#else>返程</#if></td>
									<td><#if flightOrder.passengerType == "ADULT">成人<#else>儿童</#if></td>
									<td>
										<a target='_blank' href="http://super.lvmama.com/vst_order/order/orderManage/showChildOrderStatusManage.do?orderItemId=${suppOrder.vstOrderNo }">${suppOrder.vstOrderNo }</a>
										&nbsp;
									</td>
									<td>
										<!-- <a target='_blank' href="http://super.lvmama.com/offline-web/order/queryOrderDetailByVstOrderId/${suppOrder.vstOrderNo ? trim}/${flightOrder.flightOrderNo ? trim}">${flightOrder.flightOrderNo ? trim}</a> -->
										<a target='_blank' href="http://super.lvmama.com/vst_order/order/orderManage/showChildOrderStatusManage.do?orderItemId=${suppOrder.vstOrderNo }">${flightOrder.flightOrderNo ? trim }</a>
										&nbsp;
									</td>
									
									<#if flightOrder.tripType != "NULL" && flightOrder.tripType != '' && flightOrder.tripType == "DEPARTURE">
									<td>${flight0.departureDate }</td>
									<td>${flight0.carrierName } <br/>${flight0.flightNo } ${flight0.airplane.code }</td>
									<td>${flight0.departureCityName }${flight0.departureAirportName }${flight0.departureTermainalBuilding } ---
											${flight0.arrivalCityName }${flight0.arrivalAirportName }${flight0.arrivalTerminalBuilding }
									</td><!-- 上海虹桥机场T2—三亚凤凰国际机场T1 -->
									<td >
										${flight0.departureTime }<br/>${flight0.arrivalTime }&nbsp;
									</td>
									<td >
										${flight0.flyTimeMins }&nbsp;
									</td>
									<td>
									&nbsp;${flight0.seatClassTypeName }
									<#if flightOrder.passengerType == "ADULT">${flight0.seatClassCode }<#else>${flight0.seatClassType }</#if>
									</td>
									<#else>
									<td>${flight1.departureDate }</td>
									<td>${flight1.carrierName } <br/>${flight1.flightNo } ${flight1.airplane.code }</td>
									<td>${flight1.departureCityName }${flight1.departureAirportName }${flight1.departureTermainalBuilding } ---
											${flight1.arrivalCityName }${flight1.arrivalAirportName }${flight1.arrivalTerminalBuilding }
									</td><!-- 上海虹桥机场T2—三亚凤凰国际机场T1 -->
									<td >
										${flight1.departureTime }<br/>${flight1.arrivalTime }&nbsp;
									</td>
									<td >
										${flight1.flyTimeMins }&nbsp;
									</td>
									<td>&nbsp;${flight1.seatClassTypeName }
									<#if flightOrder.passengerType == "ADULT">${flight1.seatClassCode }<#else>${flight1.seatClassType }</#if>
									</td>
									</#if>
									
									<td>
									<#if flightOrder.orderAmount?? && flightOrder.orderAmount.totalSalesAmount ??>
										${flightOrder.orderAmount.totalSalesAmount ? trim}
										&nbsp;
									</#if>
									</td>
									<td>
										<#if flightOrder.bookingStatus ??>
											${ flightOrder.bookingStatus.cnName  }
										<#else>
											预订失败
										</#if>
										&nbsp;
									</td>
									<td>
									     ${suppOrder.fitSuppOrderStatusDto.orderItemStatus.cnName }
					                         <br>
					                                  资源审核 （${suppOrder.fitSuppOrderStatusDto.resAuditStatus.cnName }）
					                         <br>
					                                 信息审核（${suppOrder.fitSuppOrderStatusDto.infoAuditStatus.cnName }）
									</td>
									
									
								</tr>
							</#list>
						</#if>
					</#list>
			</#if>
		</table>
		
		<br/>
		<b>客票信息</b>
		<table>
			<tr class="title">
				<th>去/返程</th>
				<th>乘客类型</th>
				<th>姓名</th>
				<th style="width:400px;">航段</th>
				<th>票号</th>
			</tr>
			<#list base.fitSuppMainOrderDto.fitSuppOrderDtos  as suppOrder>
			<#if suppOrder.categoryId == 21>
			<#list suppOrder.suppFlightOrderDtos as flightOrder>
			<#list flightOrder.suppFlightOrderDetailDtos as flightDetatail >
			<tr>
				<td><#if flightOrder.tripType == "DEPARTURE">去程<#else>返程</#if></td>
				<td><#if flightOrder.passengerType == "ADULT">成人<#else>儿童</#if></td>
				<td>${flightDetatail.fitOrderPassenger.passengerName} &nbsp;</td>
				<td>
				<#if flightOrder.tripType == "DEPARTURE">
					${flight0.departureCityName }${flight0.departureAirportName }${flight0.departureTermainalBuilding } ---
					${flight0.arrivalCityName }${flight0.arrivalAirportName }${flight0.arrivalTerminalBuilding }&nbsp;
				<#else>
					${flight1.departureCityName }${flight1.departureAirportName }${flight1.departureTermainalBuilding } ---
					${flight1.arrivalCityName }${flight1.arrivalAirportName }${flight1.arrivalTerminalBuilding }&nbsp;
				</#if>
				</td>
				<td>${flightDetatail.fitSuppOrderTicketInfoDto.ticketNo}</td>
			</tr>
			</#list>
			</#list>
			</#if>
			</#list>
			
		</table>
		
		<!-- 酒店信息 -->
			<#if hotel != null></#if>
		<#if base.fitOrderHotelDtos  ? exists && base.fitOrderHotelDtos?size gt 0>
		<br/>
		<b>酒店信息</b>
		<table id="hotelInfoTable">
			<tr class="title">
				<td>VST子单号</td>
				<td >酒店名称</td>
				<td>房型</td>
				<td>入住时间/离店时间 </td>
				<td>间数</td>
				<td>支付金额</td>
				<td>订单状态</td>
				<td>审核状态</td>
				<td>支付状态</td>
			</tr>
			<#list base.fitOrderHotelDtos as hotel>			
				<#list base.fitOrders as order>
				<#if hotel.id == order.orderProductId >				
				<#list base.fitSuppMainOrderDto.fitSuppOrderDtos  as suppOrder>
					
					<#if suppOrder.categoryId == 1  && order.id  == suppOrder.fitOrderId>
						<tr><td>
						<a target='_blank' href="http://super.lvmama.com/vst_order/order/orderManage/showChildOrderStatusManage.do?orderItemId=${suppOrder.vstOrderNo ? trim}&orderType=child">${suppOrder.vstOrderNo  }</a>
						</td>
						<td > ${hotel.hotelName !''} </td>
						<td>${branchDesc ! ''}</td>
						<td> ${hotel.checkin?string("yyyy-MM-dd") }至${hotel.checkout?string("yyyy-MM-dd") } </td>
						<td>${hotel.roomCount }</td>
						<td>
							${suppOrder.orderAmount.totalAmount }
						</td>
						<td> ${suppOrder.fitSuppOrderStatusDto.orderStatus.cnName }</td>
						<td>
							 ${suppOrder.fitSuppOrderStatusDto.orderItemStatus.cnName }
							 <br>
									  资源审核 （${suppOrder.fitSuppOrderStatusDto.resAuditStatus.cnName }）
							 <br>
									 信息审核（${suppOrder.fitSuppOrderStatusDto.infoAuditStatus.cnName }）
						 </td>
						<td> ${suppOrder.fitSuppOrderStatusDto.paymentStatus.cnName }</td></tr>
						

					</#if>
					
				</#list>

				</#if>
			</#list>
			
			</#list>
		</table> 
		</#if>
		
		<!-- 当地游信息 -->
		<#if base.fitOrderLocalTripProductDto  ? exists>
		<br/>
		<b>当地游信息</b>
		<table id="hotelInfoTable">
		<tr class="title">
			<td>VST子单号</td>
			<td >商品名称</td>
			<td>预订份数</td>
			<td>出游日期</td>
			<td>订单状态</td>
			<td>审核状态</td>
			<td>支付金额</td>
		</tr>
		<tr>
			<td>
			<#list base.fitSuppMainOrderDto.fitSuppOrderDtos  as suppOrder>
			<#if suppOrder.categoryId == 16>
			<a target='_blank' href="http://super.lvmama.com/vst_order/order/orderManage/showChildOrderStatusManage.do?orderItemId=${suppOrder.vstOrderNo ? trim}&orderType=child">${suppOrder.vstOrderNo  }</a>
			<#break>
			</#if>
			</#list>
			</td>
			<td>${base.fitOrderLocalTripProductDto.productName}</td>			
			<td>
				成人${base.fitOrderBasicInfoDto.adultQuantity !"&nbsp;" }份
				<br>
				儿童${base.fitOrderBasicInfoDto.childQuantity !"&nbsp;" }份
				<#if base.fitOrderRoomDiffDto ??>
				<br>
				房差${base.fitOrderRoomDiffDto.selectCount !"0" }份
				<#else>
				<br>房差0份
				</#if>
			</td>
			<td>${base.fitOrderLocalTripProductDto.visitDate?string("yyyy-MM-dd")}</td>
			
			<#list base.fitSuppMainOrderDto.fitSuppOrderDtos  as suppOrder>
				<#if suppOrder.categoryId == 16>
					<td> ${suppOrder.fitSuppOrderStatusDto.orderStatus.cnName }</td>
					<td>
				     ${suppOrder.fitSuppOrderStatusDto.orderItemStatus.cnName }
		            <br>
		                     资源审核 （${suppOrder.fitSuppOrderStatusDto.resAuditStatus.cnName }）
		            <br>
		                    信息审核（${suppOrder.fitSuppOrderStatusDto.infoAuditStatus.cnName }）
		            </td>
		            <td>
						${suppOrder.orderAmount.totalAmount }
						<#if base.fitOrderRoomDiffDto ??>
						<br>
						( 房差:${base.fitOrderRoomDiffDto.selectPrice !"0" } )
						</#if>
					</td>        
				</#if>
			</#list>
		</tr>
		</table>
		</#if>
		
		<!-- 酒店套餐信息 -->
		<#if base.fitOrderHotelComboDto  ? exists>
		<br/>
		<b>酒店套餐信息</b>
		<table id="hotelInfoTable">
		<tr class="title">
			<td>VST子单号</td>
			<td >商品名称</td>
			<td>预订份数</td>
			<td>入住/离店时间</td>
			<td>订单状态</td>
			<td>审核状态</td>
			<td>支付金额</td>
		</tr>
		<tr>
			<td>
			<#list base.fitSuppMainOrderDto.fitSuppOrderDtos  as suppOrder>
			<#if suppOrder.categoryId == 17>
			<a target='_blank' href="http://super.lvmama.com/vst_order/order/orderManage/showChildOrderStatusManage.do?orderItemId=${suppOrder.vstOrderNo ? trim}&orderType=child">${suppOrder.vstOrderNo  }</a>
			<#break>
			</#if>
			</#list>
			</td>
			<td>${base.fitOrderHotelComboDto.branchName!''}</td>
			<td>${base.fitOrderHotelComboDto.quantity!''}</td>
			<td>${base.fitOrderHotelComboDto.checkIn?string("yyyy-MM-dd")} 至 ${base.fitOrderHotelComboDto.checkOut?string("yyyy-MM-dd")}</td>
			<#list base.fitSuppMainOrderDto.fitSuppOrderDtos  as suppOrder>
				<#if suppOrder.categoryId == 17>
					<td> ${suppOrder.fitSuppOrderStatusDto.orderStatus.cnName }</td>
					<td>
				     ${suppOrder.fitSuppOrderStatusDto.orderItemStatus.cnName }
		            <br>
		                     资源审核 （${suppOrder.fitSuppOrderStatusDto.resAuditStatus.cnName }）
		            <br>
		                    信息审核（${suppOrder.fitSuppOrderStatusDto.infoAuditStatus.cnName }）
		            </td>
		            <td>
						${suppOrder.orderAmount.totalAmount!''}
					</td>        
				</#if>
			</#list>
			</tr>
		</table>
		</#if>
		
		<!-- 其他票信息 -->
		<#if base.fitOrderOtherTicketDtos  ? exists && base.fitOrderOtherTicketDtos?size gt 0>
		<br/>
		<b>其他票信息</b>
		<table id="hotelInfoTable">
		<tr class="title">
			<td>VST子单号</td>
			<td >商品名称</td>
			<td>预订份数</td>
			<td>出游日期</td>
			<td>订单状态</td>
			<td>审核状态</td>
			<td>支付金额</td>
		</tr>
		<#list base.fitOrderOtherTicketDtos as otherTickets>
		<tr>
		<#list base.fitOrders as order>
			<#if otherTickets.id == order.orderProductId >
				<#list base.fitSuppMainOrderDto.fitSuppOrderDtos  as suppOrder>
					<#if suppOrder.categoryId == 12 && order.id  == suppOrder.fitOrderId>
						<td>
						<a target='_blank' href="http://super.lvmama.com/vst_order/order/orderManage/showChildOrderStatusManage.do?orderItemId=${suppOrder.vstOrderNo ? trim}&orderType=child">${suppOrder.vstOrderNo  }</a>
						</td>
						<td>${otherTickets.goodsName !''}</td>
						<td>${otherTickets.selectCount !''}</td>
						<td>${otherTickets.selectDate?string("yyyy-MM-dd")}</td>
		
						<td> ${suppOrder.fitSuppOrderStatusDto.orderStatus.cnName }</td>
						<td>
						     ${suppOrder.fitSuppOrderStatusDto.orderItemStatus.cnName }
				            <br>
				                     资源审核 （${suppOrder.fitSuppOrderStatusDto.resAuditStatus.cnName }）
				            <br>
				                    信息审核（${suppOrder.fitSuppOrderStatusDto.infoAuditStatus.cnName }）
			            </td>
			            <td>
							${suppOrder.orderAmount.totalAmount !''}
						</td>
					</#if>
				</#list>
			</#if>
		</#list>
		</tr>
		</#list>
		</table>
		</#if>
		
		
		
		
		
		<!-- 门票和景点信息 -->
		<#if base.fitOrderSpotTicketDtos ? exists && base.fitOrderSpotTicketDtos?size gt 0 >
		<br/>
		<b>门票信息</b>
		<table id="hotelInfoTable">
			<tr class="title">
				<td>VST子单号</td>
				<td >景点名称</td>
				<td>商品名称</td>
				<td>类型</td>
				<td>游玩日期</td>
				<td>支付金额</td>
				<td>份数</td>
				<td>订单状态</td>
				<td>审核状态</td>
				<td>支付状态</td>
			</tr>
			<#list base.fitOrderSpotTicketDtos as tickets>
		   <#list base.fitSuppMainOrderDto.fitSuppOrderDtos  as suppOrder>
		   <#if suppOrder_index gt ticket_i && ( suppOrder.categoryId == 5 || suppOrder.categoryId == 11 || suppOrder.categoryId == 12 || suppOrder.categoryId == 13) >
			<tr >
				<td>
					<a target='_blank' href="http://super.lvmama.com/vst_order/order/orderManage/showChildOrderStatusManage.do?orderItemId=${suppOrder.vstOrderNo ? trim}&orderType=child">${suppOrder.vstOrderNo  }</a>
				</td>
				<td > ${tickets.spotName } </td>
				<td>${tickets.ticketName }</td>
				<td>门票</td>
				<td> ${tickets.visitDate?string("yyyy-MM-dd") }</td>
				<td>
					${tickets.ticketPrice * tickets.ticketCount }
				</td>
				<td>${tickets.ticketCount }</td>
				
				<#list base.fitOrders as order>
					<#if tickets.id == order.orderProductId >
						<#list base.fitSuppMainOrderDto.fitSuppOrderDtos  as suppOrder>
						<#if order.id  == suppOrder.fitOrderId >
						<td> ${suppOrder.fitSuppOrderStatusDto.orderStatus.cnName }&nbsp;</td>
						<td>
						 ${suppOrder.fitSuppOrderStatusDto.orderItemStatus.cnName }
                         <br>
                                  资源审核 （${suppOrder.fitSuppOrderStatusDto.resAuditStatus.cnName }）
                         <br>
                                 信息审核（${suppOrder.fitSuppOrderStatusDto.infoAuditStatus.cnName }）
						</td>
						<td> ${suppOrder.fitSuppOrderStatusDto.paymentStatus.cnName }&nbsp;</td>
						<#assign ticket_flag = tickets_index>
						<#break>
						</#if>
						</#list>
					</#if>
				</#list>
		          </tr>
		              <#assign ticket_i= suppOrder_index>
					<#break>
					</#if>
				</#list>
			</#list>
		</table> 
		</#if>
		
			<!-- 保险信息 -->
		<#if base.fitOrderInsuranceDtos ? exists && base.fitOrderInsuranceDtos?size gt 0 >
		<br/>
		<b>保险信息</b>
		<table id="hotelInfoTable">
			<tr class="title">
				<td>VST子单号</td>
				<td >保险名称</td>
				<td>商品名称</td>
				<!--<td>类型</td>-->
				<td>支付金额</td>
				<td>份数</td>
				<td>订单状态</td>
				<td>审核状态</td>
				<td>支付状态</td>
			</tr>
			<#list base.fitOrderInsuranceDtos as insurance>
		   <#list base.fitSuppMainOrderDto.fitSuppOrderDtos  as suppOrder>
		   <#if suppOrder_index gt ticket_i && ( suppOrder.categoryId == 3) >
			<tr >
				<td>
					<a target='_blank' href="http://super.lvmama.com/vst_order/order/orderManage/showChildOrderStatusManage.do?orderItemId=${suppOrder.vstOrderNo ? trim}&orderType=child">${suppOrder.vstOrderNo  }</a>
				</td>
				<td >${insurance.insuranceName}</td>
				<td> ${insurance.insuranceSuppGoodsName}</td>
				<!--<td>
					<#list insuranceTypeEnum as val>  
					   <#if val !="NULL" && val.longValue == insurance.insuranceType >
					       ${val.cnName}
					   </#if>
					</#list>
				</td>-->
				<td>
					${insurance.insurancePrice * insurance.insuranceCount }
				</td>
				<td>${insurance.insuranceCount }</td>
				
				<#list base.fitOrders as order>
					<#if insurance.id == order.orderProductId >
						<#list base.fitSuppMainOrderDto.fitSuppOrderDtos  as suppOrder>
						<#if order.id  == suppOrder.fitOrderId >
						<td> ${suppOrder.fitSuppOrderStatusDto.orderStatus.cnName }&nbsp;</td>
						<td> 
						 ${suppOrder.fitSuppOrderStatusDto.orderItemStatus.cnName }
                         <br>
                                  资源审核 （${suppOrder.fitSuppOrderStatusDto.resAuditStatus.cnName }）
                         <br>
                                 信息审核（${suppOrder.fitSuppOrderStatusDto.infoAuditStatus.cnName }）
						</td>
						<td> ${suppOrder.fitSuppOrderStatusDto.paymentStatus.cnName }&nbsp;</td>
						<#assign ticket_flag = tickets_index>
						<#break>
						</#if>
						</#list>
					</#if>
				</#list>
		          </tr>
		              <#assign ticket_i= suppOrder_index>
					<#break>
					</#if>
				</#list>
			</#list>
		</table> 
		</#if>
		
		
		<!-- 航空意外险信息 -->
		<#if base.flightInsuranceDtos ? exists && base.flightInsuranceDtos?size gt 0 >
		<br/>
		<b>保险信息</b>
		<table id="hotelInfoTable">
			<tr class="title">
				<td >保险单号</td>
				<td >保险名称</td>
				<td>供应商类型</td>
				<td>支付金额</td>
				<td>份数</td>
			</tr>
			<#list base.flightInsuranceDtos as flightInsurance>
			<tr >
				<td >${flightInsurance.insuranceOrderNo}</td>
				<td >${flightInsurance.insuranceName}</td>
				<td >${flightInsurance.insuranceSuppName}</td>
				<td>
					${flightInsurance.insurancePrice * flightInsurance.insuranceCount }
				</td>
				<td>${flightInsurance.insuranceCount }</td>
				
		    </tr>
			</#list>
		</table> 
		</#if>
		
		
	</div>
</div>