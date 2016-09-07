package com.lvmama.lvf.common.dto.status.engine;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.order.status.FlightOrderStatusDto;
import com.lvmama.lvf.common.dto.status.Op;
import com.lvmama.lvf.common.dto.status.OpCommandBack;
import com.lvmama.lvf.common.dto.status.OpSource;
import com.lvmama.lvf.common.dto.status.order.OrderLockStatus;
import com.lvmama.lvf.common.dto.status.order.OrderTicketStatus;

public class OrderOpGenerator {
	
	public static List<Op> generatorOp(OpContext context){
		FlightOrderStatusDto status = context.getOrder().getFlightOrderStatus(); 
		OpSource opSource = context.getOpSource();
		
		List<Op> ops = new ArrayList<Op>();	
		if(OpSource.FRONT.equals(opSource)
				&&OrderLockStatus.FRONT_LOCK.equals(status.getOrderLockStatus())){
			return ops;
		}
		if(OpSource.BACK.equals(opSource)){
			ops.add(OpCommandBack.OP_LOG);
			ops.add(OpCommandBack.OP_REMARK);
			ops.add(OpCommandBack.BOOKING_AGAIN);
		}
		//后台锁定即禁止前后台任何OP处理
		if(OrderLockStatus.BACK_LOCK.equals(status.getOrderLockStatus())){
			return ops;
		}
		
		List<GeneratorOp> opStatus = new ArrayList<GeneratorOp>();
		opStatus.add(status.getOrderAuditStatus());
        opStatus.add(status.getSuppOrderAuditStatus());
		opStatus.add(status.getOrderBackStatus());
		opStatus.add(status.getOrderBookingStatus());
		opStatus.add(status.getOrderCancelStatus());
		opStatus.add(status.getOrderFrontStatus());
		opStatus.add(status.getOrderPayStatus());
		opStatus.add(status.getOrderTicketStatus());
		opStatus.add(status.getOrderSettlementStatus());
		
		for(GeneratorOp opstatus:opStatus){
			if(null==opstatus){
				continue;
			}
			ops.addAll(opstatus.generatorOp(context));
		}
		return ops;
	}
	
}
