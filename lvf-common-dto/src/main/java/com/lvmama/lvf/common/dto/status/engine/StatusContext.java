package com.lvmama.lvf.common.dto.status.engine;

import java.util.List;

import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPNRInfoDto;
import com.lvmama.lvf.common.dto.status.Op;

public class StatusContext {

	private Op op;
	private FlightOrderDto order;
	private List<FlightOrderDetailDto> orderDetails;
	private FlightOrderPNRInfoDto pnrInfo;
	
	public FlightOrderPNRInfoDto getPnrInfo() {
		return pnrInfo;
	}
	public void setPnrInfo(FlightOrderPNRInfoDto pnrInfo) {
		this.pnrInfo = pnrInfo;
	}
	public Op getOp() {
		return op;
	}
	public void setOp(Op op) {
		this.op = op;
	}
	public FlightOrderDto getOrder() {
		return order;
	}
	public void setOrder(FlightOrderDto order) {
		this.order = order;
	}
	public List<FlightOrderDetailDto> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<FlightOrderDetailDto> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public StatusContext put(Op op) {
		this.op = op;
		return this;
	}
	public StatusContext put(FlightOrderDto order) {
		this.order = order;
		return this;
	}
	public StatusContext put(FlightOrderPNRInfoDto pnrInfo){
		this.pnrInfo = pnrInfo;
		return this;
	}
	public StatusContext put(List<FlightOrderDetailDto> orderDetails) {
		this.orderDetails = orderDetails;
		return this;
	}
}
