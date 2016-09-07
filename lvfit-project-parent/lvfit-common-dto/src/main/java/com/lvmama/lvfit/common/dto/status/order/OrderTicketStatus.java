
package com.lvmama.lvfit.common.dto.status.order;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvfit.common.dto.order.FitOrderDto;
import com.lvmama.lvfit.common.dto.status.Op;
import com.lvmama.lvfit.common.dto.status.OpCommandBack;
import com.lvmama.lvfit.common.dto.status.OpCommandFront;
import com.lvmama.lvfit.common.dto.status.OpList;
import com.lvmama.lvfit.common.dto.status.TicketStatusType;
import com.lvmama.lvfit.common.dto.status.engine.FitGeneratorOp;
import com.lvmama.lvfit.common.dto.status.engine.OpContext;
import com.lvmama.lvfit.common.dto.status.engine.FitProcessOp;
import com.lvmama.lvfit.common.dto.status.engine.StatusContext;

/**
 * 订单出退改状态枚举
 * 
 * @author majun
 * @date 2015-3-12
 */
public enum OrderTicketStatus implements FitGeneratorOp,FitProcessOp {
	
	NULL("未出票",TicketStatusType.NULL),
	NOT_ISSUE("未出票", TicketStatusType.ISSUE){
		
		public List<Op> generatorBackOp(OpContext opContext){
			OpList opList = new OpList(opContext);
			opList.add(OpCommandBack.APPLY_ISSUE);
			return opList.list();
		}
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_PASS_PAY.equals(statusContext.getOp())
				|| OpCommandBack.APPLY_CTMT.equals(statusContext.getOp());
		}
	},
	APPLY_ISSUE("待出票",TicketStatusType.ISSUE){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.APPLY_ISSUE.equals(statusContext.getOp());
		}
        public List<Op> generatorBackOp(OpContext opContext){
            OpList opList = new OpList(opContext);
            opList.add(OpCommandBack.SYNC_SUPP_ISSUE);
            return opList.list();
        }
	},
	ISSUE_SUCC("出票成功",TicketStatusType.ISSUE) {
		
		public List<Op> generatorFrontOp(OpContext opContext) {
			OpList opList = new OpList(opContext);
			opList.add(OpCommandFront.APPLY_CTMT);
			opList.add(OpCommandFront.APPLY_RTVT);
			return opList.list();
		}

		public List<Op> generatorBackOp(OpContext opContext) {
			OpList opList = new OpList(opContext);
			opList.add(OpCommandBack.APPLY_CTMT);
			opList.add(OpCommandBack.APPLY_RTVT);
			return opList.list();
		}

		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_PASS_ISSUE.equals(statusContext.getOp());
		}
	},
	ISSUE_FAIL("出票失败", TicketStatusType.ISSUE) {
		
		public boolean vaild(StatusContext statusContext){
			return  //OpCommandBack.AUDIT_REJECT_ISSUE.equals(statusContext.getOp())
					//||
					OpCommandBack.OP_REJECT_ISSUE.equals(statusContext.getOp());
		}

	},
	APPLY_CTMT("未变更",TicketStatusType.CTMT){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.APPLY_CTMT.equals(statusContext.getOp())
					||OpCommandFront.APPLY_CTMT.equals(statusContext.getOp());
		}
	},
	CTMT_SUCC("变更成功", TicketStatusType.CTMT) {
		
		public List<Op> generatorFrontOp(OpContext opContext) {
			OpList opList = new OpList(opContext);
			opList.add(OpCommandFront.APPLY_RTVT);
			opList.add(OpCommandBack.APPLY_CTMT);
			return opList.list();
		}
		public List<Op> generatorBackOp(OpContext opContext) {
			OpList opList = new OpList(opContext);
			opList.add(OpCommandBack.APPLY_RTVT);
			opList.add(OpCommandBack.APPLY_CTMT);
			return opList.list();
		}
		
		public boolean vaild(StatusContext statusContext){
			return OpCommandBack.OP_PASS_CTMT.equals(statusContext.getOp());
		}
		
	},
	CTMT_FAIL("变更失败", TicketStatusType.CTMT){
		
		public boolean vaild(StatusContext statusContext){
			return  //OpCommandBack.AUDIT_REJECT_CTMT.equals(statusContext.getOp())
					//||
					OpCommandBack.OP_REJECT_CTMT.equals(statusContext.getOp());
		}		
		
	},
	APPLY_RTVT("未退票",TicketStatusType.RTVT){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.APPLY_RTVT.equals(statusContext.getOp())
					||OpCommandFront.APPLY_RTVT.equals(statusContext.getOp());
		}
	},
	RTVT_DONE("已退票",TicketStatusType.RTVT){
		@Override
		public boolean vaild(StatusContext statusContext) {
			FitOrderDto order = statusContext.getOrder();
			return false;
		}
	},
	RTVT_SUCC("退票成功",TicketStatusType.RTVT){
		
//		public List<Op> generatorBackOp(OpContext opContext) {
//			OpList opList = new OpList(opContext);
//			opList.add(OpCommandBack.APPLY_REFUND);
//			return opList.list();
//		}
		
		public boolean vaild(StatusContext statusContext){
			return OpCommandBack.OP_PASS_RTVT.equals(statusContext.getOp());
		}	
	},
	RTVT_FAIL("退票失败",TicketStatusType.RTVT){
		
		public boolean vaild(StatusContext statusContext){
			return //OpCommandBack.AUDIT_REJECT_RTVT.equals(statusContext.getOp())
					//||
					OpCommandBack.OP_REJECT_RTVT.equals(statusContext.getOp());
		}
		
	},
	ALL_CHANGE("全部退改",TicketStatusType.NULL);
	

	private String cnName;
	private TicketStatusType type;
	
	public static OrderTicketStatus[] getStatus(TicketStatusType type){
		
		List<OrderTicketStatus> types  = new ArrayList<OrderTicketStatus>();
		
		for(OrderTicketStatus status:OrderTicketStatus.values()){
			if(status.getType().equals(type)){
				types.add(status);
			}
		}
		return types.toArray(new OrderTicketStatus[types.size()]);
	}

	public TicketStatusType getType() {
		return type;
	}

	public void setType(TicketStatusType type) {
		this.type = type;
	}

	private OrderTicketStatus(String cnName, TicketStatusType type) {
		this.cnName = cnName;
		this.type = type;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public List<Op> generatorFrontOp(OpContext opContext) {
		return new ArrayList<Op>();
	};

	public List<Op> generatorBackOp(OpContext opContext) {
		return new ArrayList<Op>();
	};

	public List<Op> generatorOp(OpContext opContext) {

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
		if(statusContext.getOrder().getOrderStatus() == null)
			return;
		
		if(vaild(statusContext)){
//			statusContext.getOrder().getOrderStatus().setOrderTicketStatus(this);
		}
	}

	
}
