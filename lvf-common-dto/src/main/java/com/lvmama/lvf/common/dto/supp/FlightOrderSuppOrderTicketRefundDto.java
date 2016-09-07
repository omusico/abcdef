package com.lvmama.lvf.common.dto.supp;

import java.io.Serializable;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.Entity;

/**
 * 供应商订单退票票号信息
 * @author majun
 * @date   2015-2-4
 */
public class FlightOrderSuppOrderTicketRefundDto extends Entity implements Serializable 
{
	private static final long serialVersionUID = 8670956326963153182L;
	
	/** 供应商订单主键 */
	private Long suppOrderId;
	
	/** 供应商订单PNR退票主键 */
	private Long suppPnrRefundId; 
	
	/** 供应商订单票号信息 */
	@FkId
	private FlightOrderSuppOrderTicketInfoDto flightOrderSuppOrderTicketInfo;
	
	/** 所退航段 */
	private String flightSegments;

	public Long getSuppOrderId() {
		return suppOrderId;
	}

	public void setSuppOrderId(Long suppOrderId) {
		this.suppOrderId = suppOrderId;
	}

	public Long getSuppPnrRefundId() {
		return suppPnrRefundId;
	}

	public void setSuppPnrRefundId(Long suppPnrRefundId) {
		this.suppPnrRefundId = suppPnrRefundId;
	}

	public FlightOrderSuppOrderTicketInfoDto getFlightOrderSuppOrderTicketInfo() {
		return flightOrderSuppOrderTicketInfo;
	}

	public void setFlightOrderSuppOrderTicketInfo(
			FlightOrderSuppOrderTicketInfoDto flightOrderSuppOrderTicketInfo) {
		this.flightOrderSuppOrderTicketInfo = flightOrderSuppOrderTicketInfo;
	}

	public String getFlightSegments() {
		return flightSegments;
	}

	public void setFlightSegments(String flightSegments) {
		this.flightSegments = flightSegments;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
