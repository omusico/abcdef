package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.FlightTripType;

/**
 * 预订请求明细对象
 * @author majun
 * @date   2015-1-21
 */
public class FlightOrderBookingDetailRequest implements Serializable
{
	private static final long serialVersionUID = 7560022393800989506L;
	
	/** 往返类型 */
	private FlightTripType flightTripType;
	
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
	
	private BookingSource bookingSource;
	
	/** 运价政策主键 */
	private Long pricePolicyId;

	/**隔夜航班高亮显示*/
	private boolean highLightFlag = false;
	
	private String suppCode;
	
	private String saleType; //政策类型，用于标识该条报价是来自普通政策还是包机政策
	
	public FlightTripType getFlightTripType() {
		return flightTripType;
	}

	public void setFlightTripType(FlightTripType flightTripType) {
		this.flightTripType = flightTripType;
	}

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

	public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}

	public Long getPricePolicyId() {
		return pricePolicyId;
	}

	public void setPricePolicyId(Long pricePolicyId) {
		this.pricePolicyId = pricePolicyId;
	}

	public boolean getHighLightFlag() {
		return highLightFlag;
	}

	public void setHighLightFlag(boolean highLightFlag) {
		this.highLightFlag = highLightFlag;
	}

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
	
	
	
}
