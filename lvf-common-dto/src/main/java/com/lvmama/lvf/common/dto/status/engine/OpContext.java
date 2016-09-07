package com.lvmama.lvf.common.dto.status.engine;

import com.lvmama.lvf.common.dto.order.FlightOrderDto;
import com.lvmama.lvf.common.dto.status.OpSource;
import com.lvmama.lvf.common.dto.status.OpType;

public class OpContext {

	private OpSource opSource;
	private OpType opType = OpType.NULL;
	private FlightOrderDto order;
	
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
	public FlightOrderDto getOrder() {
		return order;
	}
	public void setOrder(FlightOrderDto order) {
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
	public OpContext put(FlightOrderDto order) {
		this.order = order;
		return this;
	}
}
