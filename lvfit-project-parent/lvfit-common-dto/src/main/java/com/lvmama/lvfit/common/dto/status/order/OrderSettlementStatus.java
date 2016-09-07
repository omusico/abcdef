package com.lvmama.lvfit.common.dto.status.order;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvfit.common.dto.status.Op;
import com.lvmama.lvfit.common.dto.status.OpCommandBack;
import com.lvmama.lvfit.common.dto.status.OpList;
import com.lvmama.lvfit.common.dto.status.engine.FitGeneratorOp;
import com.lvmama.lvfit.common.dto.status.engine.OpContext;
import com.lvmama.lvfit.common.dto.status.engine.FitProcessOp;
import com.lvmama.lvfit.common.dto.status.engine.StatusContext;

public enum OrderSettlementStatus implements FitGeneratorOp,FitProcessOp {

	NULL("",""),
	NOT_SETTLEMENT("未结算","UNSETTLEMENTED"){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_PASS_RTVT.equals(statusContext.getOp())
					|| OpCommandBack.OP_PASS_ISSUE.equals(statusContext.getOp())
					|| OpCommandBack.OP_PASS_CTMT.equals(statusContext.getOp());
		}
		
		public List<Op> generatorBackOp(OpContext opContext) {
			OpList opList = new OpList(opContext);
			opList.add(OpCommandBack.APPLY_SUPP_SETTLMENT);
			return opList.list();
		}
		
	},
	APPLY_SETTLEMENT("申请结算","SETTLEMENTING"){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.APPLY_SUPP_SETTLMENT.equals(statusContext.getOp());
		}
	},
	APPLY_SETTLEMENT_FAIL("申请结算失败",""){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_REJECT_SUPP_SETTLMENT.equals(statusContext.getOp());
		}
	},
	APPLY_SETTLEMENT_SUCC("申请结算成功","SETTLEMENTED"){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_PASS_SUPP_SETTLMENT.equals(statusContext.getOp());
		}
	},
	SETTLEMENT_NOTNEED("无需申请结算","NOSETTLEMENT");
	
	private String cnName;
	private String ailas;
	
	public String getAilas() {
		return ailas;
	}

	public void setAilas(String ailas) {
		this.ailas = ailas;
	}

	private OrderSettlementStatus(String cnName, String ailas) {
		this.cnName = cnName;
		this.ailas = ailas;
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
		if(statusContext.getOrder().getOrderStatus() == null){
			return;
		}
		if(vaild(statusContext)){
			statusContext.getOrder().getOrderStatus().setOrderSettlementStatus(this);;
		}
	};
}
