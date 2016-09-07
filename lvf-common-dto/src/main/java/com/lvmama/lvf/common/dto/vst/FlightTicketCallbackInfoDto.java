package com.lvmama.lvf.common.dto.vst;

import java.io.Serializable;
import java.util.List;

public class FlightTicketCallbackInfoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2235009061796362533L;
	
	/**
	 * 主订单ID
	 */
	private Long orderId;
	
	/**
	 * 子订单ID
	 */
	private Long orderItemId;
	
	/**
	 * 机票详细信息
	 */
	private List<FlightTicketDetailInfoDto> flightTicketDetailInfos;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public List<FlightTicketDetailInfoDto> getFlightTicketDetailInfos() {
		return flightTicketDetailInfos;
	}

	public void setFlightTicketDetailInfos(
			List<FlightTicketDetailInfoDto> flightTicketDetailInfos) {
		this.flightTicketDetailInfos = flightTicketDetailInfos;
	}

}
