package com.lvmama.lvfit.common.dto.status.engine;

import com.lvmama.lvfit.common.dto.order.FitOrderDto;
import com.lvmama.lvfit.common.dto.status.Op;

public class StatusContext {

	private Op op;
	private FitOrderDto order;
	
	public Op getOp() {
		return op;
	}

	public void setOp(Op op) {
		this.op = op;
	}

	public FitOrderDto getOrder() {
		return order;
	}

	public void setOrder(FitOrderDto order) {
		this.order = order;
	}


	public StatusContext put(Op op) {
		this.op = op;
		return this;
	}
	
	public StatusContext put(FitOrderDto order) {
		this.order = order;
		return this;
	}
	
}
