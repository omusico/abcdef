package com.lvmama.lvfit.common.dto.status.engine;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvfit.common.dto.order.FitOrderStatusDto;
import com.lvmama.lvfit.common.dto.status.Op;
import com.lvmama.lvfit.common.dto.status.OpCommandBack;
import com.lvmama.lvfit.common.dto.status.OpSource;
import com.lvmama.lvfit.common.dto.status.order.OrderLockStatus;

public class FitOrderOpGenerator {
	
	public static List<Op> generatorOp(OpContext context){
		FitOrderStatusDto status = context.getOrder().getOrderStatus();
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
		
		List<FitGeneratorOp> opStatus = new ArrayList<FitGeneratorOp>();
		opStatus.add(status.getOrderAuditStatus());
//        opStatus.add(status.getSuppOrderAuditStatus());
		opStatus.add(status.getOrderBackStatus());
		opStatus.add(status.getOrderBookingStatus());
		opStatus.add(status.getOrderCancelStatus());
		opStatus.add(status.getOrderFrontStatus());
		opStatus.add(status.getOrderPayStatus());
//		opStatus.add(status.getOrderTicketStatus());
		opStatus.add(status.getOrderSettlementStatus());
		
		for(FitGeneratorOp opstatus:opStatus){
			if(null==opstatus){
				continue;
			}
			ops.addAll(opstatus.generatorOp(context));
		}
		return ops;
	}
	
}
