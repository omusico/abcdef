package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.Entity;

/**
 * 订单退票票号信息
 * @author majun
 * @date   2015-2-4
 */
public class FlightOrderTicketRefundDto extends Entity implements Serializable 
{
	private static final long serialVersionUID = 8670956326963153182L;
	
	/** 订单PNR退票信息 */
	@FkId
	private FlightOrderPNRRefundDto flightOrderPNRRefund;
	
	/** 订单票号信息 */
	@FkId
	private FlightOrderTicketInfoDto flightOrderTicketInfo;
	
	/** 所退航段 */
	private String flightSegments;

	public FlightOrderPNRRefundDto getFlightOrderPNRRefund() {
		return flightOrderPNRRefund;
	}

	public void setFlightOrderPNRRefund(FlightOrderPNRRefundDto flightOrderPNRRefund) {
		this.flightOrderPNRRefund = flightOrderPNRRefund;
	}

	public FlightOrderTicketInfoDto getFlightOrderTicketInfo() {
		return flightOrderTicketInfo;
	}

	public void setFlightOrderTicketInfo(
			FlightOrderTicketInfoDto flightOrderTicketInfo) {
		this.flightOrderTicketInfo = flightOrderTicketInfo;
	}

	public String getFlightSegments() {
		return flightSegments;
	}

	public void setFlightSegments(String flightSegments) {
		this.flightSegments = flightSegments;
	}
	
	@Override
	@JsonIgnore
	public String getSequence() {
		return "S_FORD_TICKET_REFUND";
	}
	
}
