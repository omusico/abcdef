package com.lvmama.lvfit.common.dto.status.order;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvfit.common.dto.status.Op;
import com.lvmama.lvfit.common.dto.status.OpAction;
import com.lvmama.lvfit.common.dto.status.OpCommandBack;
import com.lvmama.lvfit.common.dto.status.OpList;
import com.lvmama.lvfit.common.dto.status.OpType;
import com.lvmama.lvfit.common.dto.status.OrderAuditType;
import com.lvmama.lvfit.common.dto.status.engine.FitGeneratorOp;
import com.lvmama.lvfit.common.dto.status.engine.OpContext;
import com.lvmama.lvfit.common.dto.status.engine.FitProcessOp;
import com.lvmama.lvfit.common.dto.status.engine.StatusContext;

/**
 * 订单审核状态
 * 
 * @author leizhengwei
 * @date 2015-3-9
 */
public enum OrderAuditStatus implements FitGeneratorOp,FitProcessOp {
	
	NULL("未审核", OrderAuditType.NULL),
	NOT_AUDIT("未审核", OrderAuditType.AUDIT){
		public boolean vaild(StatusContext statusContext){
			return OpAction.APPLY.equals(statusContext.getOp().getOpAction()) 
				&& (statusContext.getOp().getOpType() == OpType.ISSUE || statusContext.getOp().getOpType() == OpType.CTMT
				|| statusContext.getOp().getOpType() == OpType.RTVT);
		}
		public List<Op> generatorBackOp(OpContext opContext){
			OpList opList = new OpList(opContext);
			switch (opContext.getOpType()) {
				case ISSUE:
					opList.add(OpCommandBack.AUDIT_PASS_ISSUE);
					opList.add(OpCommandBack.AUDIT_REJECT_ISSUE);
					break;
				case CTMT:
					opList.add(OpCommandBack.AUDIT_PASS_CTMT);
					opList.add(OpCommandBack.AUDIT_REJECT_CTMT);
					break;
				case RTVT:
					opList.add(OpCommandBack.AUDIT_PASS_RTVT);
					opList.add(OpCommandBack.AUDIT_REJECT_RTVT);
					opList.add(OpCommandBack.SYNC_SUPP_RTVT);
					break;
				default:
					break;
			}
			return opList.list();
		}
	}, 
	AUDIT_PASS("审核通过", OrderAuditType.AUDIT){
		public boolean vaild(StatusContext statusContext){
			return OpAction.AUDIT_PASS.equals(statusContext.getOp().getOpAction())
				&& (statusContext.getOp().getOpType() == OpType.ISSUE || statusContext.getOp().getOpType() == OpType.CTMT
				|| statusContext.getOp().getOpType() == OpType.RTVT);
		}
		public List<Op> generatorBackOp(OpContext opContext){
			OpList opList = new OpList(opContext);
			switch (opContext.getOpType()) {
				case ISSUE:
					opList.add(OpCommandBack.OP_PASS_ISSUE);
					opList.add(OpCommandBack.OP_REJECT_ISSUE);
					break;
				case CTMT:
					opList.add(OpCommandBack.OP_PASS_CTMT);
					opList.add(OpCommandBack.OP_REJECT_CTMT);
					break;
				case RTVT:
					opList.add(OpCommandBack.OP_PASS_RTVT);
					opList.add(OpCommandBack.OP_REJECT_RTVT);
					opList.add(OpCommandBack.SYNC_SUPP_RTVT); 
					opList.add(OpCommandBack.APPLY_REFUND);//审核通过,在RTVT界面才能退款
					break;
				default:
					break;
			}
			return opList.list();
		}
	}, 
	AUDIT_REJECT("审核驳回", OrderAuditType.AUDIT){
		public boolean vaild(StatusContext statusContext){
			return OpAction.AUDIT_REJECT.equals(statusContext.getOp().getOpAction())
				&& (statusContext.getOp().getOpType() == OpType.ISSUE || statusContext.getOp().getOpType() == OpType.CTMT
				|| statusContext.getOp().getOpType() == OpType.RTVT);
		}		
	},
	OP_PASS("处理通过", OrderAuditType.OP){
		public boolean vaild(StatusContext statusContext){
			return OpAction.OP_PASS.equals(statusContext.getOp().getOpAction())
				&& (statusContext.getOp().getOpType() == OpType.ISSUE || statusContext.getOp().getOpType() == OpType.CTMT
				|| statusContext.getOp().getOpType() == OpType.RTVT);
		}
	}, 
	OP_REJECT("处理驳回", OrderAuditType.OP){
		public boolean vaild(StatusContext statusContext){
			return OpAction.OP_REJECT.equals(statusContext.getOp().getOpAction())
				&& (statusContext.getOp().getOpType() == OpType.ISSUE || statusContext.getOp().getOpType() == OpType.CTMT
				|| statusContext.getOp().getOpType() == OpType.RTVT);
		}		
	};

	private String cnName;
	
	private OrderAuditType orderAuditType;

	private OrderAuditStatus(String cnName, OrderAuditType orderAuditType) {
		this.cnName = cnName;
		this.orderAuditType = orderAuditType;
	}
	
	public String getCnName() {
		return cnName;
	}
	
	public OrderAuditType getOrderAuditType() {
		return orderAuditType;
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
		if(statusContext.getOrder().getOrderStatus() == null){
			return;
		}
		if(vaild(statusContext)){
			statusContext.getOrder().getOrderStatus().setOrderAuditStatus(this);
		}
	};
}
