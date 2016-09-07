package com.lvmama.lvfit.common.dto.status.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lvmama.lvfit.common.dto.status.order.OrderAuditStatus;
import com.lvmama.lvfit.common.dto.status.order.OrderBackStatus;
import com.lvmama.lvfit.common.dto.status.order.OrderBookingStatus;
import com.lvmama.lvfit.common.dto.status.order.OrderCancelStatus;
import com.lvmama.lvfit.common.dto.status.order.OrderFrontStatus;
import com.lvmama.lvfit.common.dto.status.order.OrderPayStatus;
import com.lvmama.lvfit.common.dto.status.order.OrderSettlementStatus;
import com.lvmama.lvfit.common.dto.status.order.OrderTicketStatus;
import com.lvmama.lvfit.common.dto.status.order.SuppOrderAuditStatus;

public class OrderStatusProcess {
	
	public static void processOp(StatusContext context){
		
		processOp4Order(context);
		processOp4PnrInfo(context);
		
	}
	
	private static void processOp4PnrInfo(StatusContext context) {
		
		List<FitProcessOp> opStatus = new ArrayList<FitProcessOp>();
		
		opStatus.addAll(Arrays.asList(OrderBookingStatus.values()));
		
		for(FitProcessOp opstatus:opStatus){
			if(null==opstatus){
				continue;
			}
			opstatus.processOp(context);
		}
	}

	private static void processOp4Order(StatusContext context) {
		
		if(null==context.getOrder()){
			return;
		}

		List<FitProcessOp> opStatus = new ArrayList<FitProcessOp>();
		
		opStatus.addAll(Arrays.asList(OrderAuditStatus.values()));
		opStatus.addAll(Arrays.asList(SuppOrderAuditStatus.values()));
		opStatus.addAll(Arrays.asList(OrderBackStatus.values()));
		opStatus.addAll(Arrays.asList(OrderBookingStatus.values()));
		opStatus.addAll(Arrays.asList(OrderCancelStatus.values()));
		opStatus.addAll(Arrays.asList(OrderFrontStatus.values()));
		opStatus.addAll(Arrays.asList(OrderPayStatus.values()));
		opStatus.addAll(Arrays.asList(OrderTicketStatus.values()));
		opStatus.addAll(Arrays.asList(OrderSettlementStatus.values()));
		
		for(FitProcessOp opstatus:opStatus){
			if(null==opstatus){
				continue;
			}
			opstatus.processOp(context);
		}
	}
	
}
