package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.StringUtil;

/**
 * 运价基本信息管理request
 * @author yangyongni
 */
public class FlightPriceInfoRequest implements Serializable,Dto{

	private static final long serialVersionUID = 1L;
	/** 航班号*/
	private String flightNo;
	/** 舱位代码*/
	private String seatClassCode; 
	/** 航班日期/毫秒数*/
	private Long departureDate;
	/** 航班日期/毫秒数*/
	private String departureDateTime;
	/** 出发机场*/
    private String departureAirportCode;
    /** 到达机场*/
    private String arrivalAirportCode;
    /** 出发城市*/
	 private String departureCityCode; 
	 /** 到达城市*/
	 private String arrivalCityCode ;
	 /** 供应商编码 */
	 private String suppCode;
	/** 运价基本信息list*/
    private List<Long> flightPriceInfoList;
    /** 出发日期*/
	 private String departureTime; 
    
	 private String lvSeatClassCode;
	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getSeatClassCode() {
		return seatClassCode;
	}

	public void setSeatClassCode(String seatClassCode) {
		this.seatClassCode = seatClassCode;
	}

	public Long getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Long departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(String departureDateTime) {
		this.departureDateTime = departureDateTime;
		if(StringUtil.isNotEmptyString(departureDateTime)){
			Long departureTimeLong = DateUtils.parseCnHmDate(departureDateTime+ " 00:00:00").getTime();
			this.setDepartureDate(departureTimeLong);
		}
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

	public List<Long> getFlightPriceInfoList() {
		return flightPriceInfoList;
	}

	public void setFlightPriceInfoList(List<Long> flightPriceInfoList) {
		this.flightPriceInfoList = flightPriceInfoList;
	}

	@Override
	public Long getId() {
		return null;
	}

	public String getDepartureCityCode() {
		return departureCityCode;
	}

	public void setDepartureCityCode(String departureCityCode) {
		this.departureCityCode = departureCityCode;
	}

	public String getArrivalCityCode() {
		return arrivalCityCode;
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		this.arrivalCityCode = arrivalCityCode;
	}
	
	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}
	
	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
		if(StringUtil.isNotEmptyString(departureTime)){
			Long departureTimeLong = DateUtils.parseCnHmDate(departureTime+ " 00:00:00").getTime();
			this.setDepartureDate(departureTimeLong);
		}
	}

	public String getLvSeatClassCode() {
		return lvSeatClassCode;
	}

	public void setLvSeatClassCode(String lvSeatClassCode) {
		this.lvSeatClassCode = lvSeatClassCode;
	}
	
	
	

}
