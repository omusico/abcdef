package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.booking.FlightOrderIntentionRecordDto;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.SeatClassType;

public class FlightOrderIntentionRecordRequest  implements Serializable, Dto{
	
	private FlightOrderIntentionRecordDto flightOrderIntentionRecordDto = new FlightOrderIntentionRecordDto();
	/**起飞开始日期*/
	private String depTimeBeginTime;
	/**起飞结束日期*/
	private String depTimeEndTime;
	/**预定开始时间*/
	private String orderBeginTime;
	/**预定结束时间*/
	private String orderEndTime;
	/**预定来源集合*/
	private List<BookingSource> bookingSources;
	@Override
	public Long getId() {
		return flightOrderIntentionRecordDto.getId();
	}
	/**起飞开始日期*/
	public String getDepTimeBeginTime() {
		return depTimeBeginTime;
	}
	public void setDepTimeBeginTime(String depTimeBeginTime) {
		this.depTimeBeginTime = depTimeBeginTime;
	}
	/**起飞结束日期*/
	public String getDepTimeEndTime() {
		return depTimeEndTime;
	}
	public void setDepTimeEndTime(String depTimeEndTime) {
		this.depTimeEndTime = depTimeEndTime;
	}
	/**预定开始时间*/
	public String getOrderBeginTime() {
		return orderBeginTime;
	}
	public void setOrderBeginTime(String orderBeginTime) {
		this.orderBeginTime = orderBeginTime;
	}
	/**预定结束时间*/
	public String getOrderEndTime() {
		return orderEndTime;
	}
	public void setOrderEndTime(String orderEndTime) {
		this.orderEndTime = orderEndTime;
	}
	/**预定来源集合*/
	public List<BookingSource> getBookingSources() {
		return bookingSources;
	}
	public void setBookingSources(List<BookingSource> bookingSources) {
		this.bookingSources = bookingSources;
	}
	/**出发城市*/
	public String getDepAirportCityCode() {
		return flightOrderIntentionRecordDto.getDepAirportCityCode();
	}
	public void setDepAirportCityCode(String depAirportCityCode) {
		flightOrderIntentionRecordDto.setDepAirportCityCode(depAirportCityCode);
	}
	/**到达城市*/
	public String getArrAirportCityCode() {
		return flightOrderIntentionRecordDto.getArrAirportCityCode();
	}
	public void setArrAirportCityCode(String arrAirportCityCode) {
		flightOrderIntentionRecordDto.setArrAirportCityCode(arrAirportCityCode);
	}
	/**承运人*/
	public String getCarrierCode() {
		return flightOrderIntentionRecordDto.getCarrierCode();
	}
	public void setCarrierCode(String carrierCode) {
		flightOrderIntentionRecordDto.setCarrierCode(carrierCode);
	}
	/**客户帐号*/
	public String getLvmamaAccount() {
		return flightOrderIntentionRecordDto.getLvmamaAccount();
	}
	public void setLvmamaAccount(String lvmamaAccount) {
		flightOrderIntentionRecordDto.setLvmamaAccount(lvmamaAccount);
	}
	/**舱位类型*/
	public SeatClassType getSeatClassType() {
		return flightOrderIntentionRecordDto.getSeatClassType();
	}
	public void setSeatClassType(SeatClassType seatClassType) {
		flightOrderIntentionRecordDto.setSeatClassType(seatClassType);
	}
	
}
