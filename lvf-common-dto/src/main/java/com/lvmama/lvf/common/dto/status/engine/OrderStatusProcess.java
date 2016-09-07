package com.lvmama.lvf.common.dto.status.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.lvmama.lvf.common.dto.status.detail.DetailAuditStatus;
import com.lvmama.lvf.common.dto.status.detail.DetailBookingStatus;
import com.lvmama.lvf.common.dto.status.detail.DetailSuppAuditStatus;
import com.lvmama.lvf.common.dto.status.detail.DetailTicketStatus;
import com.lvmama.lvf.common.dto.status.order.OrderAuditStatus;
import com.lvmama.lvf.common.dto.status.order.OrderBackStatus;
import com.lvmama.lvf.common.dto.status.order.OrderBookingStatus;
import com.lvmama.lvf.common.dto.status.order.OrderCancelStatus;
import com.lvmama.lvf.common.dto.status.order.OrderFrontStatus;
import com.lvmama.lvf.common.dto.status.order.OrderPayStatus;
import com.lvmama.lvf.common.dto.status.order.OrderSettlementStatus;
import com.lvmama.lvf.common.dto.status.order.OrderTicketStatus;
import com.lvmama.lvf.common.dto.status.order.SuppOrderAuditStatus;

public class OrderStatusProcess {
	
	public static void processOp(StatusContext context){
		
		processOp4Order(context);
		processOp4OrderDetails(context);
		processOp4PnrInfo(context);
		
	}
	
	private static void processOp4PnrInfo(StatusContext context) {
		
		if(null==context.getPnrInfo()){
			return;
		}

		List<ProcessOp> opStatus = new ArrayList<ProcessOp>();
		
		opStatus.addAll(Arrays.asList(OrderBookingStatus.values()));
		
		for(ProcessOp opstatus:opStatus){
			if(null==opstatus){
				continue;
			}
			opstatus.processOp(context);
		}
	}
	
	private static void processOp4OrderDetails(StatusContext context) 
	{
		if(CollectionUtils.isEmpty(context.getOrderDetails()))
			return;

		List<ProcessOp> opStatus = new ArrayList<ProcessOp>();
		
		opStatus = new ArrayList<ProcessOp>();
		opStatus.addAll(Arrays.asList(DetailAuditStatus.values()));
		opStatus.addAll(Arrays.asList(DetailSuppAuditStatus.values()));
		opStatus.addAll(Arrays.asList(DetailTicketStatus.values()));
		opStatus.addAll(Arrays.asList(DetailBookingStatus.values()));

		for(ProcessOp opstatus:opStatus){
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

		List<ProcessOp> opStatus = new ArrayList<ProcessOp>();
		
		opStatus.addAll(Arrays.asList(OrderAuditStatus.values()));
		opStatus.addAll(Arrays.asList(SuppOrderAuditStatus.values()));
		opStatus.addAll(Arrays.asList(OrderBackStatus.values()));
		opStatus.addAll(Arrays.asList(OrderBookingStatus.values()));
		opStatus.addAll(Arrays.asList(OrderCancelStatus.values()));
		opStatus.addAll(Arrays.asList(OrderFrontStatus.values()));
		opStatus.addAll(Arrays.asList(OrderPayStatus.values()));
		opStatus.addAll(Arrays.asList(OrderTicketStatus.values()));
		opStatus.addAll(Arrays.asList(OrderSettlementStatus.values()));
		
		
		for(ProcessOp opstatus:opStatus){
			if(null==opstatus){
				continue;
			}
			opstatus.processOp(context);
		}
	}
	
}
