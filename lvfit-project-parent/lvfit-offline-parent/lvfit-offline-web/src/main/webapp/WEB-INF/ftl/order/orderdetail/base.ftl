<div class="module1">
	<div class="main">
		<div class="area remark">
			<span>VST主单号：</span><p>
	    	<#if  base.fitSuppMainOrderDto.vstMainOrderNo??>
	    		<a href="http://super.lvmama.com/vst_order/order/orderManage/showOrderStatusManage.do?orderType=parent&orderId=${base.fitSuppMainOrderDto.vstMainOrderNo ? trim }" style="color:blue;" target='_blank' title='查看详情'>${base.fitSuppMainOrderDto.vstMainOrderNo } </a>
	    	</#if>
			&nbsp;&nbsp;</p>
			<span>机酒主单号：</span><p>${base.fitOrderNo.orderNo !"&nbsp;" } &nbsp;&nbsp;</p>
			<span>订单来源：</span>
			<p><#list bookingSourceEnum as val>  
							   <#if val !="NULL" && val == base.bookingSource>
							       ${val.cnName !"&nbsp;"}
							   </#if>
							</#list>
			&nbsp;</p>
			 <span>支付方式：</span><p>预付(驴妈妈)</p>
			 <span>登陆用户：</span><p>${base.fitOrderCustomer.customerName !"&nbsp;" }</p>
			 <span>&nbsp;</span>
			 <p><a href="${request.contextPath}/order/toOrderLog/${base.id }" >操作日志</a></p>
		</div>
		<div class="area remark">
			<p><span>订单状态：</span>${base.fitSuppMainOrderDto.fitSuppMainOrderStatus.orderStatus.cnName }</p>
			<p><span>审核状态：</span>${base.fitSuppMainOrderDto.fitSuppMainOrderStatus.auditStatus.cnName }</p>
			<p><span>支付状态：</span>${base.fitSuppMainOrderDto.fitSuppMainOrderStatus.paymentStatus.cnName }</p>
			<p><span>支付金额：</span>${base.orderAmount.totalSalesAmount !"&nbsp;" } (加价:¥${ base.fitOrderPassengers?size*base.flightFeeAmount !"&nbsp;"})</p>
			<p><span>下单时间：</span>${(base.createTime)?string("yyyy-MM-dd HH:mm:ss")}</p>
			<p><span>支付等待时间：</span>${base.fitSuppMainOrderDto.fitSuppMainOrderStatus.waitPayTime}分钟</p>
		</div>
		
	</div>
</div>
<!-- <div>
	<table class="p_table table_center">
		    <thead>
		        <tr>
		              <tr>
						<th nowrap="nowrap">交易流水号</th>
						<th nowrap="nowrap">网关交易号</th>
						<th nowrap="nowrap">支付网关</th>
						<th nowrap="nowrap">交易金额</th>
						<th nowrap="nowrap">支付状态</th>
						<th nowrap="nowrap">支付信息</th>
						<th nowrap="nowrap">交易时间</th>
						<th nowrap="nowrap">创建时间</th>
						<th nowrap="nowrap">对账流水号</th>
						<th nowrap="nowrap">原订单号</th>
						<th nowrap="nowrap">预授权状态</th>
					</tr>
		        </tr>
		    </thead>
		    <tbody>
		    	<#list payAndPreVOList as result>
				    <tr>
					    <td>${result.serial!''}</td>
						<td>${result.gatewayTradeNo!''}</td>
						<td>${result.payWayZh!''}</td>
						<td>${result.amountYuan!''}</td>
						<td>${result.statusZh!''}</td>
						<td>${result.callbackInfo!''}</td>
						<td><#if result.callbackTime??>${result.callbackTime?string('yyyy-MM-dd HH:mm') !''}</#if></td>
						<td>${result.createTime?string('yyyy-MM-dd HH:mm') !''}</td>
						<td>${result.paymentTradeNo!''}</td>
						<td>${result.oriObjectId!''}</td>
						<td>${result.payPreStatusZh!''}</td>
					</tr>
			   </#list>
			</tbody>
		</table>
</div> -->