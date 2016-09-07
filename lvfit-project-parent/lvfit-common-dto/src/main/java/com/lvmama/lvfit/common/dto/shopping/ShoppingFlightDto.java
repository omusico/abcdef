package com.lvmama.lvfit.common.dto.shopping;

import com.lvmama.lvf.common.dto.Entity;

public class ShoppingFlightDto  extends Entity{
	 
    
    private String shoppingUuid;

  
    private String flightNo;

    
    private String departureDate;

    
    private String departureTime;

    
    private String arrivalTime;

    
    private String departureAirportCode;

   
    private String arrivalCityName;

   
    private String arrivalAirportCode;

   
    private String flyTimeMins;

   
    private String seatClassCode;

   
    private String seatClassName;

    private String backOrto;
    
    //版本号
    private Long versionNo;
	

    private String DepartureCityName;
	public String getShoppingUuid() {
		return shoppingUuid;
	}


	public void setShoppingUuid(String shoppingUuid) {
		this.shoppingUuid = shoppingUuid;
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


	public String getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}


	public String getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public String getDepartureAirportCode() {
		return departureAirportCode;
	}


	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}


	public String getArrivalCityName() {
		return arrivalCityName;
	}


	public void setArrivalCityName(String arrivalCityName) {
		this.arrivalCityName = arrivalCityName;
	}


	public String getArrivalAirportCode() {
		return arrivalAirportCode;
	}


	public void setArrivalAirportCode(String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
	}


	public String getFlyTimeMins() {
		return flyTimeMins;
	}


	public void setFlyTimeMins(String flyTimeMins) {
		this.flyTimeMins = flyTimeMins;
	}


	public String getSeatClassCode() {
		return seatClassCode;
	}


	public void setSeatClassCode(String seatClassCode) {
		this.seatClassCode = seatClassCode;
	}

	public String getSeatClassName() {
		return seatClassName;
	}


	public void setSeatClassName(String seatClassName) {
		this.seatClassName = seatClassName;
	}

	public String getBackOrto() {
		return backOrto;
	}

	public void setBackOrto(String backOrto) {
		this.backOrto = backOrto;
	}


	public String getDepartureCityName() {
		return DepartureCityName;
	}


	public void setDepartureCityName(String departureCityName) {
		DepartureCityName = departureCityName;
	}


	public Long getVersionNo() {
		return versionNo;
	}


	public void setVersionNo(Long versionNo) {
		this.versionNo = versionNo;
	}

	
	
	
	

	
	

}
