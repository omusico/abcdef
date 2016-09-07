package com.lvmama.lvf.common.dto.status.order;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.status.Op;
import com.lvmama.lvf.common.dto.status.OpCommandBack;
import com.lvmama.lvf.common.dto.status.engine.GeneratorOp;
import com.lvmama.lvf.common.dto.status.engine.OpContext;
import com.lvmama.lvf.common.dto.status.engine.ProcessOp;
import com.lvmama.lvf.common.dto.status.engine.StatusContext;

/**
 * 订单后台状态
 * @author majun
 * @date   2015-3-12
 */
public enum OrderBackStatus implements GeneratorOp,ProcessOp {

	NULL("",""),
	BOOKING_FAIL("订位失败","FAIL"){
		@Override
		public boolean vaild(StatusContext statusContext) {
			return OpCommandBack.OP_REJECT_BOOKING.equals(statusContext.getOp());
		}
	},NORMAL("正常","NORMAL"){
		public boolean vaild(StatusContext statusContext){
			
			if(OpCommandBack.ROLLBACK_CANCEL.equals(statusContext.getOp())){
				return true;
			}
			
			if(OrderBackStatus.CANCEL.equals(statusContext.getOrder().getFlightOrderStatus().getOrderBackStatus())){
				return false;
			}
			
			return !(OpCommandBack.OP_PASS_CANCEL.equals(statusContext.getOp())
					||OpCommandBack.OP_PASS_ONBROAD.equals(statusContext.getOp()));
		}		
	},
	CANCEL("取消","CANCEL"){
		public boolean vaild(StatusContext statusContext){		
			return OpCommandBack.OP_PASS_CANCEL.equals(statusContext.getOp());
		}		
	},
	DONE("完成","FINISHED"){
		public boolean vaild(StatusContext statusContext){		
			return OpCommandBack.OP_PASS_ONBROAD.equals(statusContext.getOp());
		}		
	};
	
	private String cnName;
	private String ailas;
	
	
	public String getAilas() {
		return ailas;
	}

	public void setAilas(String ailas) {
		this.ailas = ailas;
	}

	private OrderBackStatus(String cnName, String ailas) {
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
		if(statusContext.getOrder().getFlightOrderStatus() == null)
			return;
		
		if(vaild(statusContext)){
			statusContext.getOrder().getFlightOrderStatus().setOrderBackStatus(this);
		}
	};
}
