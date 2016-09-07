package com.lvmama.lvf.common.form.order;

import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;
import com.lvmama.lvf.common.form.Form;

public class FlightOrderInputForm implements Form {

	private Long orderId;
	
	private String orderNo;
	
	private FlightOrderRemarkDto flightOrderRemarkDto;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public FlightOrderRemarkDto getFlightOrderRemarkDto() {
		return flightOrderRemarkDto;
	}

	public void setFlightOrderRemarkDto(FlightOrderRemarkDto flightOrderRemarkDto) {
		this.flightOrderRemarkDto = flightOrderRemarkDto;
	}
	
}
