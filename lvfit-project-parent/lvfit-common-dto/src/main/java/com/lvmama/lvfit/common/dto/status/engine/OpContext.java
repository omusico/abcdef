package com.lvmama.lvfit.common.dto.status.engine;

import com.lvmama.lvfit.common.dto.order.FitOrderDto;
import com.lvmama.lvfit.common.dto.status.OpSource;
import com.lvmama.lvfit.common.dto.status.OpType;

public class OpContext {

	private OpSource opSource;
	private OpType opType = OpType.NULL;
	private FitOrderDto order;
	
	public OpType getOpType() {
		return opType;
	}
	public void setOpType(OpType opType) {
		this.opType = opType;
	}
	public OpSource getOpSource() {
		return opSource;
	}
	public void setOpSource(OpSource opSource) {
		this.opSource = opSource;
	}
	public FitOrderDto getOrder() {
		return order;
	}
	public void setOrder(FitOrderDto order) {
		this.order = order;
	}
	public OpContext put(OpSource opSource) {
		this.opSource = opSource;
		return this;
	}
	public OpContext put(OpType opType) {
		this.opType = opType;
		return this;
	}
	public OpContext put(FitOrderDto order) {
		this.order = order;
		return this;
	}
}
