package com.lvmama.lvf.common.dto.status.order;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.status.Op;
import com.lvmama.lvf.common.dto.status.OpCommandBack;
import com.lvmama.lvf.common.dto.status.OpCommandFront;
import com.lvmama.lvf.common.dto.status.OpList;
import com.lvmama.lvf.common.dto.status.engine.GeneratorOp;
import com.lvmama.lvf.common.dto.status.engine.OpContext;
import com.lvmama.lvf.common.dto.status.engine.ProcessOp;
import com.lvmama.lvf.common.dto.status.engine.StatusContext;

/**
 * 订单订位状态
 * @author majun
 * @date   2015-1-30
 */
public enum OrderBookingStatus  implements GeneratorOp,ProcessOp{
	
	NULL(""),
	NOT_BOOKING("未订位"){
		public List<Op> generatorFrontOp(OpContext opContext){
			OpList opList = new OpList(opContext);
			opList.add(OpCommandFront.APPLY_CANCEL);
			return opList.list();
		}
		public List<Op> generatorBackOp(OpContext opContext){
			OpList opList = new OpList(opContext);
			opList.add(OpCommandFront.APPLY_CANCEL);
			opList.add(OpCommandBack.WAIT_CANCEL);
			return opList.list();
		}
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_PASS_CONFIRM.equals(statusContext.getOp()) ||
				OpCommandBack.APPLY_CTMT.equals(statusContext.getOp());
		}
	},
	BOOKING_SUCC("订位成功"){
		
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_PASS_BOOKING.equals(statusContext.getOp())
					||OpCommandBack.OP_PASS_ISSUE.equals(statusContext.getOp())
					||OpCommandBack.AUDIT_PASS_CTMT.equals(statusContext.getOp());
		}
	},
	BOOKING_FAIL("订位失败"){
		public List<Op> generatorFrontOp(OpContext opContext){
			OpList opList = new OpList(opContext);
			opList.add(OpCommandFront.APPLY_CANCEL);
			return opList.list();
		}
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_REJECT_BOOKING.equals(statusContext.getOp());
		}
	};
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	private OrderBookingStatus(String cnName) {
		this.cnName = cnName;
	}
	
	public List<Op> generatorFrontOp(OpContext opContext){
		return new ArrayList<Op>();
	};
	
	public List<Op> generatorBackOp(OpContext opContext){
		return new ArrayList<Op>();
	};
	
	public List<Op> generatorOp(OpContext opContext){

		switch (opContext.getOpSource()) {
		case FRONT:
			return generatorFrontOp(opContext);
		case BACK:
			return generatorBackOp(opContext);
		default:
			return new ArrayList<Op>();
		}
	};

	@Override
	public boolean vaild(StatusContext statusContext) {
		return false;
	}

	@Override
	public void processOp(StatusContext statusContext) {
		if(statusContext.getOrder().getFlightOrderStatus() == null)
			return;
		
		if(vaild(statusContext))
		{
			statusContext.getOrder().getFlightOrderStatus().setOrderBookingStatus(this);
			if(statusContext.getPnrInfo() == null)
				return;
			else
				statusContext.getPnrInfo().setOrderBookingStatus(this);
		}
	};
	
}
