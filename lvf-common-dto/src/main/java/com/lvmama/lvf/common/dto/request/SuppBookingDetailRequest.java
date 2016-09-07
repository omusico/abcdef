package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 预订请求明细对象
 * @author majun
 * @date   2015-1-21
 */
public class SuppBookingDetailRequest implements Serializable
{
	private static final long serialVersionUID = 7560022393800989506L;
	
	/** 航班号 */
	private String flightNo;
	
	/** 出发日期 */
	private String departureDate;
	
	/** 出发机场三字代码 */
	private String departureAirportCode;
	
	/** 到达机场三字代码 */
	private String arrivalAirportCode;
	
	/** 舱位编码 */
	private String seatClassCode;
	
	/** 票面价 */
	private BigDecimal parPrice;
	
	/** 政策主键 */
	private Long policyId;
	
	private String carrierCode;
	
	/** 运价政策主键 */
	private Long pricePolicyId;

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureAirportCode() {
		return departureAirportCode;
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}

	public String getArrivalAirportCode() {
		return arrivalAirportCode;
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
	}

	public String getSeatClassCode() {
		return seatClassCode;
	}

	public void setSeatClassCode(String seatClassCode) {
		this.seatClassCode = seatClassCode;
	}

	public BigDecimal getParPrice() {
		return parPrice;
	}

	public void setParPrice(BigDecimal parPrice) {
		this.parPrice = parPrice;
	}

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	public Long getPricePolicyId() {
		return pricePolicyId;
	}

	public void setPricePolicyId(Long pricePolicyId) {
		this.pricePolicyId = pricePolicyId;
	}
	
	
	
}
