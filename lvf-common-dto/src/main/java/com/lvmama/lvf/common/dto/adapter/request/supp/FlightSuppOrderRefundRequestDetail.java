package com.lvmama.lvf.common.dto.adapter.request.supp;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.adapter.request.supp.base.SuppRequest;
import com.lvmama.lvf.common.dto.enums.IDCardType;
import com.lvmama.lvf.common.dto.order.FlightOrderDetailRTVTAmountDto;

/**
 * 
 * @author mashengwen
 * RC1
 */
@XmlRootElement
public class FlightSuppOrderRefundRequestDetail extends SuppRequest implements
		Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8976248215980555437L;
	private String passengerName;
	private String flightTicketNo;
	private String[] flightSegments;
	private BigDecimal refundFee;
	private BigDecimal refundRate;
	/**517na加的 --start*/
	//证件类型 
	private IDCardType passengerIDCardType;
	//证件号码
	private String passengerIDCardNo;
	//退票相关费用
	private FlightOrderDetailRTVTAmountDto flightOrderDetailRTVTAmountDto;
	
	/**517na加的 --end*/
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getFlightTicketNo() {
		return flightTicketNo;
	}
	public void setFlightTicketNo(String flightTicketNo) {
		this.flightTicketNo = flightTicketNo;
	}
	public String[] getFlightSegments() {
		return flightSegments;
	}
	public void setFlightSegments(String[] flightSegments) {
		this.flightSegments = flightSegments;
	}
	public BigDecimal getRefundFee() {
		return refundFee;
	}
	public void setRefundFee(BigDecimal refundFee) {
		this.refundFee = refundFee;
	}
	public BigDecimal getRefundRate() {
		return refundRate;
	}
	public void setRefundRate(BigDecimal refundRate) {
		this.refundRate = refundRate;
	}
	public IDCardType getPassengerIDCardType() {
		return passengerIDCardType;
	}
	public void setPassengerIDCardType(IDCardType passengerIDCardType) {
		this.passengerIDCardType = passengerIDCardType;
	}
	public String getPassengerIDCardNo() {
		return passengerIDCardNo;
	}
	public void setPassengerIDCardNo(String passengerIDCardNo) {
		this.passengerIDCardNo = passengerIDCardNo;
	}
	public FlightOrderDetailRTVTAmountDto getFlightOrderDetailRTVTAmountDto() {
		return flightOrderDetailRTVTAmountDto;
	}
	public void setFlightOrderDetailRTVTAmountDto(
			FlightOrderDetailRTVTAmountDto flightOrderDetailRTVTAmountDto) {
		this.flightOrderDetailRTVTAmountDto = flightOrderDetailRTVTAmountDto;
	}
}
