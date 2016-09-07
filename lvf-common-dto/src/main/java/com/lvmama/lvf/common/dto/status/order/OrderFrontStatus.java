package com.lvmama.lvf.common.dto.status.order;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.status.Op;
import com.lvmama.lvf.common.dto.status.OpAction;
import com.lvmama.lvf.common.dto.status.OpCommandBack;
import com.lvmama.lvf.common.dto.status.OpCommandFront;
import com.lvmama.lvf.common.dto.status.OpList;
import com.lvmama.lvf.common.dto.status.OpType;
import com.lvmama.lvf.common.dto.status.engine.GeneratorOp;
import com.lvmama.lvf.common.dto.status.engine.OpContext;
import com.lvmama.lvf.common.dto.status.engine.ProcessOp;
import com.lvmama.lvf.common.dto.status.engine.StatusContext;

/**
 * 前端订单状态(客户订单状态)
 * @author majun
 * @date   2015-3-12
 */
public enum OrderFrontStatus implements GeneratorOp,ProcessOp {
	
	NULL("",false),
	BOOKING_FAIL("订位失败",false){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_REJECT_BOOKING.equals(statusContext.getOp());
		}
	},
	NOT_CONFIRM("已提交"){
		public boolean vaild(StatusContext statusContext){		
			return OpCommandFront.APPLY_CONFIRM.equals(statusContext.getOp())
					||OpCommandBack.APPLY_CONFIRM.equals(statusContext.getOp());
		}		
	},
	CONFIRM_SUCC("已核对"){
		public boolean vaild(StatusContext statusContext){		
			return OpCommandBack.OP_PASS_CONFIRM.equals(statusContext.getOp());
		}		
	},	
	NOT_PAY("待支付"){
		public boolean vaild(StatusContext statusContext){		
			return OpCommandBack.OP_PASS_BOOKING.equals(statusContext.getOp());
		}		
	},
	PAY_SUCC("已支付"){
		public boolean vaild(StatusContext statusContext){		
			return OpCommandBack.OP_PASS_PAY.equals(statusContext.getOp())
					||OpCommandBack.ROLLBACK_CANCEL.equals(statusContext.getOp());
		}		
	},
	ISSUE_SUCC("已出票"){
		public boolean vaild(StatusContext statusContext){		
			return OpCommandBack.OP_PASS_ISSUE.equals(statusContext.getOp());
		}		
	},
	CTMT_SUCC("已变更"){
		public boolean vaild(StatusContext statusContext){		
			return OpCommandBack.OP_PASS_CTMT.equals(statusContext.getOp());
		}		
	},
	RTVT_SUCC("已退票"){
		public boolean vaild(StatusContext statusContext){		
			return OpCommandBack.OP_PASS_RTVT.equals(statusContext.getOp());
		}		
	},
	REFUND_SUCC("已退款"){
		public boolean vaild(StatusContext statusContext){		
			return OpCommandBack.OP_PASS_REFUND.equals(statusContext.getOp());
		}
	},
	CANCEL_SUCC("已取消"){
		public boolean vaild(StatusContext statusContext){		
			return OpCommandBack.OP_PASS_CANCEL.equals(statusContext.getOp());
		}
	},
	DONE("完成"){
		public List<Op> generatorFrontOp(OpContext opContext){
			OpList opList = new OpList(opContext);
			opList.add(OpCommandFront.APPLY_HIDDEN);
			return opList.list();
		}
		public boolean vaild(StatusContext statusContext){		
			return OpCommandBack.OP_PASS_ONBROAD.equals(statusContext.getOp());
		}		
	},
	NOT_AUDIT("未审核"){
		public boolean vaild(StatusContext statusContext){
			return OpAction.APPLY.equals(statusContext.getOp().getOpAction()) 
				&& (statusContext.getOp().getOpType() == OpType.ISSUE || statusContext.getOp().getOpType() == OpType.CTMT
				|| statusContext.getOp().getOpType() == OpType.RTVT);
		}
	},
	AUDIT_PASS("审核通过"){
		public boolean vaild(StatusContext statusContext){
			return OpAction.AUDIT_PASS.equals(statusContext.getOp().getOpAction())
				&& (statusContext.getOp().getOpType() == OpType.ISSUE || statusContext.getOp().getOpType() == OpType.CTMT
				|| statusContext.getOp().getOpType() == OpType.RTVT);
		}
	},
	AUDIT_REJECT("审核驳回"){
		public boolean vaild(StatusContext statusContext){
			return OpAction.AUDIT_REJECT.equals(statusContext.getOp().getOpAction())
				&& (statusContext.getOp().getOpType() == OpType.ISSUE || statusContext.getOp().getOpType() == OpType.CTMT
				|| statusContext.getOp().getOpType() == OpType.RTVT);
		}		
	},
	/*OP_PASS("处理通过"){
		public boolean vaild(StatusContext statusContext){
			return OpAction.OP_PASS.equals(statusContext.getOp().getOpAction())
				&& (statusContext.getOp().getOpType() == OpType.ISSUE || statusContext.getOp().getOpType() == OpType.CTMT
				|| statusContext.getOp().getOpType() == OpType.RTVT);
		}
	},*/ 
	OP_REJECT("处理驳回"){
		public boolean vaild(StatusContext statusContext){
			return OpAction.OP_REJECT.equals(statusContext.getOp().getOpAction())
				&& (statusContext.getOp().getOpType() == OpType.ISSUE || statusContext.getOp().getOpType() == OpType.CTMT
				|| statusContext.getOp().getOpType() == OpType.RTVT);
		}
	};
	private String cnName;
	private Boolean vaild;

	public String getCnName() {
		return cnName;
	}

	private OrderFrontStatus(String cnName,Boolean vaild) {
		this.cnName = cnName;
		this.vaild = vaild;
	}

	private OrderFrontStatus(String cnName) {
		this.cnName = cnName;
		this.vaild = true;
	}
	
	public Boolean getVaild() {
		return vaild;
	}

	public List<Op> generatorFrontOp(OpContext opContext){
		return new ArrayList<Op>();
	}

	public List<Op> generatorBackOp(OpContext opContext){
		return new ArrayList<Op>();
	}

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
			statusContext.getOrder().getFlightOrderStatus().setOrderFrontStatus(this);
		}
	}
}
