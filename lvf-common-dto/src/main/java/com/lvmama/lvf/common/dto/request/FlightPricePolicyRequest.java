package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.StringUtil;
/**
 * 运价政策管理 request
 * @author zhangzongshuang
 * @date 2015年8月3日
 */
public class FlightPricePolicyRequest implements Serializable,Dto{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -4226810312847362900L;
	/** 航班号*/
	 private String flightNo;
	 /** 舱位代码*/
	 private String seatClassCode;
	 /** LV舱位代码(舱位代码+票面价) */
	 private String lvSeatClassCode;
	 /** 供应商编码*/
	 private String suppCode;   
	 /** 出发机场代码 */
	 private String departureAirportCode;
	 /** 到达机场代码 */
	 private String arrivalAirportCode;
	 /** 出发城市*/
	 private String departureCityCode; 
	 /** 到达城市*/
	 private String arrivalCityCode ;
	 /** 供应商政策编号*/
	 private String suppPolicyNo ;
	 /** 航班日期/毫秒数*/
	 private Long departureDate;
	 /** md5sign*/
	 private String md5Sign ;
	 /** 航班日期*/
	 private String departureTime;
	 /** 运价政策list*/
	 private List<Long> flightPricePolicyList;
	 /** 运价库存list*/
	 private List<Long> flightPriceInventoryList;
	
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

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
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

	public String getSuppPolicyNo() {
		return suppPolicyNo;
	}

	public void setSuppPolicyNo(String suppPolicyNo) {
		this.suppPolicyNo = suppPolicyNo;
	}

	public String getMd5Sign() {
		return md5Sign;
	}

	public void setMd5Sign(String md5Sign) {
		this.md5Sign = md5Sign;
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
	public void setDepartureDate(Long departureDate) {
		this.departureDate = departureDate;
	}

	public Long getDepartureDate() {
		return departureDate;
	}
	
	public List<Long> getFlightPricePolicyList() {
		return flightPricePolicyList;
	}

	public void setFlightPricePolicyList(List<Long> flightPricePolicyList) {
		this.flightPricePolicyList = flightPricePolicyList;
	}

	public List<Long> getFlightPriceInventoryList() {
		return flightPriceInventoryList;
	}

	public void setFlightPriceInventoryList(List<Long> flightPriceInventoryList) {
		this.flightPriceInventoryList = flightPriceInventoryList;
	}

	@Override
	public Long getId() {
		return null;
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

	public String getLvSeatClassCode() {
		return lvSeatClassCode;
	}

	public void setLvSeatClassCode(String lvSeatClassCode) {
		this.lvSeatClassCode = lvSeatClassCode;
	}
}
