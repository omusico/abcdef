package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;



public class FlightTicketRefundRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//关于票的信息
	private Long ticketId;
	
	private BigDecimal refundAmount;
	
	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}
}

