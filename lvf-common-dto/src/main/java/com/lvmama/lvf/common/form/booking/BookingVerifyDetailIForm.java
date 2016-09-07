package com.lvmama.lvf.common.form.booking;

import com.lvmama.lvf.common.dto.enums.PassengerType;

public class BookingVerifyDetailIForm {
	
	/** 乘客类型 */
	private PassengerType passengerType;
	
	/** 乘客数量 */
	private Integer passengerCount;

	/** 航班号 */
	private String flightNo;
	
	/** 出发机场三字代码 */
	private String departureAirportCode;
	
	/** 到达机场三字代码 */
	private String arrivalAirportCode;
	
	/** 出发日期 */
	private String departureDate;
	
	/** 舱位编码 */
	private String seatClassCode;
	
	/** 政策主键 */
	private Long policyId;

	public PassengerType getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}

	public Integer getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(Integer passengerCount) {
		this.passengerCount = passengerCount;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
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

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getSeatClassCode() {
		return seatClassCode;
	}

	public void setSeatClassCode(String seatClassCode) {
		this.seatClassCode = seatClassCode;
	}

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	
	
}
