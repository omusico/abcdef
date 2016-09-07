package com.lvmama.lvf.common.dto.status.order;

import com.lvmama.lvf.common.dto.status.OpCommandBack;
import com.lvmama.lvf.common.dto.status.OpCommandFront;
import com.lvmama.lvf.common.dto.status.engine.ProcessOp;
import com.lvmama.lvf.common.dto.status.engine.StatusContext;

/**
 * 订单机票出票状态
 * 
 * @author majun
 * @date 2015-3-12
 */
public enum OrderLockStatus implements ProcessOp{
	
	UN_LOCK("未锁定"){
		public boolean vaild(StatusContext statusContext){
			return OpCommandBack.OP_PASS_CANCEL.equals(statusContext.getOp())
					||OpCommandBack.OP_PASS_CTMT.equals(statusContext.getOp())
					||OpCommandBack.OP_PASS_RTVT.equals(statusContext.getOp())
					||OpCommandBack.OP_REJECT_CANCEL.equals(statusContext.getOp())
					||OpCommandBack.OP_REJECT_CTMT.equals(statusContext.getOp())
					||OpCommandBack.OP_REJECT_RTVT.equals(statusContext.getOp());
		}
	},
	BACK_LOCK("后台锁定"){
		public boolean vaild(StatusContext statusContext){
			return false;
		}
	},
	FRONT_LOCK("前台锁定"){
		public boolean vaild(StatusContext statusContext){
			return OpCommandFront.APPLY_CANCEL.equals(statusContext.getOp())
					||OpCommandFront.APPLY_CTMT.equals(statusContext.getOp())
					||OpCommandFront.APPLY_RTVT.equals(statusContext.getOp());
		}
	};

	private String cnName;
	
	private OrderLockStatus(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
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
			statusContext.getOrder().getFlightOrderStatus().setOrderLockStatus(this);
		}
	}


}
