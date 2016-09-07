package com.lvmama.lvfit.common.dto.status.order;

import com.lvmama.lvfit.common.dto.status.OpCommandFront;
import com.lvmama.lvfit.common.dto.status.engine.FitProcessOp;
import com.lvmama.lvfit.common.dto.status.engine.StatusContext;

/**
 * 订单显示状态
 * 
 * @date   2015-1-30
 */
public enum OrderVisibleStatus implements FitProcessOp {
	
	NOT_VISIBLE("不显示"){
		public boolean vaild(StatusContext statusContext){
			return OpCommandFront.APPLY_HIDDEN.equals(statusContext.getOp());
		}
	},
	VISIBLE("显示");
	
	private String cnName;

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	private OrderVisibleStatus (String cnName) {
		this.cnName = cnName;
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
			statusContext.getOrder().getOrderStatus().setVisible(this);
		}
	}

	
}
