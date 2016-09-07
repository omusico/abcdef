package com.lvmama.lvf.common.dto.status.order;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.status.Op;
import com.lvmama.lvf.common.dto.status.OpAction;
import com.lvmama.lvf.common.dto.status.OpCommandBack;
import com.lvmama.lvf.common.dto.status.OpList;
import com.lvmama.lvf.common.dto.status.engine.GeneratorOp;
import com.lvmama.lvf.common.dto.status.engine.OpContext;
import com.lvmama.lvf.common.dto.status.engine.ProcessOp;
import com.lvmama.lvf.common.dto.status.engine.StatusContext;

/**
 * 订单供应商审核状态
 * @author majun
 * @date   2015-4-29
 */
public enum SuppOrderAuditStatus implements GeneratorOp,ProcessOp
{
	NULL(""){
		public boolean vaild(StatusContext statusContext){
			return OpCommandBack.APPLY_RTVT.equals(statusContext.getOp());
		}
	},
	APPLY_SUPP_OP("供应商处理申请"){
		public boolean vaild(StatusContext statusContext){
			return OpAction.APPLY_SUPP_OP.equals(statusContext.getOp().getOpAction());
		}
		
		public List<Op> generatorBackOp(OpContext opContext){
            OpList opList = new OpList(opContext);
            switch (opContext.getOpType()) {
                case ISSUE:
                    opList.add(OpCommandBack.SUPP_OP_PASS_ISSUE);
                    opList.add(OpCommandBack.SUPP_OP_REJECT_ISSUE);
                    break;
                case RTVT:
                    opList.add(OpCommandBack.SUPP_OP_PASS_RTVT);
                    opList.add(OpCommandBack.SUPP_OP_REJECT_RTVT);
                    break;
                default:
                    break;
            }
            return opList.list();
        }
		
	},
	SUPP_OP_PASS("供应商处理通过"){
		public boolean vaild(StatusContext statusContext){
			return OpAction.SUPP_OP_PASS.equals(statusContext.getOp().getOpAction());
		}
	},
	SUPP_OP_REJECT("供应商处理驳回"){
		public boolean vaild(StatusContext statusContext){
			return OpAction.SUPP_OP_REJECT.equals(statusContext.getOp().getOpAction());
		}
	};
	
	private String cnName;

	private SuppOrderAuditStatus(String cnName) {
		this.cnName = cnName;
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
			statusContext.getOrder().getFlightOrderStatus().setSuppOrderAuditStatus(this);
		}
	};
}
