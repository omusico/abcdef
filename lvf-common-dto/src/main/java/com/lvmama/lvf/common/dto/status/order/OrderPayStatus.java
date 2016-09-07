
package com.lvmama.lvf.common.dto.status.order;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.status.Op;
import com.lvmama.lvf.common.dto.status.OpList;
import com.lvmama.lvf.common.dto.status.OpCommandBack;
import com.lvmama.lvf.common.dto.status.OpCommandFront;
import com.lvmama.lvf.common.dto.status.PayStatusType;
import com.lvmama.lvf.common.dto.status.engine.GeneratorOp;
import com.lvmama.lvf.common.dto.status.engine.OpContext;
import com.lvmama.lvf.common.dto.status.engine.ProcessOp;
import com.lvmama.lvf.common.dto.status.engine.StatusContext;

/**
 * 订单支付/退款状态
 * @author majun
 * @date   2015-1-30
 */
public enum OrderPayStatus implements GeneratorOp,ProcessOp {
	
	NULL("",PayStatusType.NULL),
	NOT_PAY("待支付",PayStatusType.PAY){
		
		public List<Op> generatorFrontOp(OpContext opContext){
		    OpList opList = new OpList(opContext);
		    opList.add(OpCommandFront.APPLY_CANCEL);
			opList.add(OpCommandFront.APPLY_PAY);
			return opList.list();
		}
		
		public List<Op> generatorBackOp(OpContext opContext){
			OpList opList = new OpList(opContext);
			opList.add(OpCommandBack.APPLY_CANCEL);
			opList.add(OpCommandBack.WAIT_CANCEL);
			switch (opContext.getOpType()) {
			case PAY:
				opList.add(OpCommandBack.APPLY_PAY);
				opList.add(OpCommandBack.DIRECT_REDUCTION_PAY);
				break;
			default:
				break;
			}
			return opList.list();
		}
		
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_PASS_BOOKING.equals(statusContext.getOp()) ||
				OpCommandBack.APPLY_CTMT.equals(statusContext.getOp());
		}
	},
	PAY_TIMEOUT("超时未支付",PayStatusType.PAY){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_OUTTIME_PAY.equals(statusContext.getOp());
		}
		
		public List<Op> generatorBackOp(OpContext opContext){
			OpList opList = new OpList(opContext);
			opList.add(OpCommandBack.APPLY_CANCEL);
			return opList.list();
		}
	},
	PAY_SUCC("支付成功",PayStatusType.PAY){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_PASS_PAY.equals(statusContext.getOp());
		}
		
		public List<Op> generatorBackOp(OpContext opContext){
			OpList opList = new OpList(opContext);
			opList.add(OpCommandBack.APPLY_ISSUE);
            opList.add(OpCommandBack.APPLY_SUPP_ISSUE);
            
//            switch (opContext.getOpType()) {
//            
//			case RTVT:
//	            opList.add(OpCommandBack.APPLY_REFUND);
//				break;
//			default:
//				break;
//            }
            
			return opList.list();
		}
		
	},
	PAY_FAIL("支付失败",PayStatusType.PAY){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_REJECT_PAY.equals(statusContext.getOp());
		}
	},
	NOT_REFUND("未退款", PayStatusType.REFUND){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.APPLY_RTVT.equals(statusContext.getOp());
		}
	},
	APPLY_REFUND("申请退款",PayStatusType.REFUND){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.APPLY_REFUND.equals(statusContext.getOp());
		}
	},
	REFUND_REJECT("退款驳回",PayStatusType.REFUND){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_REJECT_REFUND.equals(statusContext.getOp());
		}		
	},
	REFUND_SUCC("退款成功",PayStatusType.REFUND){
		public List<Op> generatorFrontOp(OpContext opContext){
			OpList opList = new OpList(opContext);
			opList.add(OpCommandFront.APPLY_HIDDEN);
			return opList.list();
		}
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_PASS_REFUND.equals(statusContext.getOp());
		}
	},
	REFUND_FAIL("退款失败",PayStatusType.REFUND){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_REJECT_REFUND.equals(statusContext.getOp());
		}
	};
	
	private String cnName;
	private PayStatusType orderPayStatusType;
	
    public static OrderPayStatus[] getStatus(PayStatusType payStatusType){
		
		List<OrderPayStatus> orderPayStatuss  = new ArrayList<OrderPayStatus>();
		
		for(OrderPayStatus orderPayStatus : OrderPayStatus.values())
		{
			if(orderPayStatus.getOrderPayStatusType() == payStatusType)
			{
				orderPayStatuss.add(orderPayStatus );
			}
		}
		return orderPayStatuss.toArray(new OrderPayStatus[orderPayStatuss.size()]);
	}
    
	public PayStatusType getOrderPayStatusType() {
		return orderPayStatusType;
	}

	public void setOrderPayStatusType(PayStatusType orderPayStatusType) {
		this.orderPayStatusType = orderPayStatusType;
	}
	
	private OrderPayStatus(String cnName, PayStatusType orderPayStatusType) {
		this.cnName = cnName;
		this.orderPayStatusType = orderPayStatusType;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
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
		
	}

	@Override
	public boolean vaild(StatusContext statusContext) {
		return false;
	}

	@Override
	public void processOp(StatusContext statusContext) {
		if(statusContext.getOrder().getFlightOrderStatus() == null)
			return;
		
		if(vaild(statusContext)){
			statusContext.getOrder().getFlightOrderStatus().setOrderPayStatus(this);
		}
	};
}
