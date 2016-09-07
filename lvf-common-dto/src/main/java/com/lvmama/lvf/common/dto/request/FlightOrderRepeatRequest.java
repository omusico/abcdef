package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Dto;

public class FlightOrderRepeatRequest implements Serializable, Dto {
	
	private static final long serialVersionUID = 1L;
	/** 乘客名称 */
	private String passengerName;
	/** 乘客证件号 */
	private String passengerIDCardNo;
	/** 始发地 */
	private String departureAirportCode;
	/** 目的地 */
	private String arrivalAirportCode;
	/** 起飞时间 */
	private String departureDate;
	/** 航班号 */
	private String flightNo;
	
	@JsonIgnore
	@Override
	public Long getId() {
		return null;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerIDCardNo() {
		return passengerIDCardNo;
	}

	public void setPassengerIDCardNo(String passengerIDCardNo) {
		this.passengerIDCardNo = passengerIDCardNo;
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

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	
}
