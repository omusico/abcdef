package com.lvmama.lvf.common.form.price;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.flight.price.FlightPriceInfoDto;
import com.lvmama.lvf.common.dto.md.TimeSegmentRange;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

/**
 * 运价基本信息管理ResponseForm
 * @author yangyongni
 * @date 2015年8月10日
 */
public class FlightPriceInfoResponseForm implements Serializable, Form {

	private static final long serialVersionUID = 1L;
	
	private FlightPriceInfoDto flightPriceInfo = new FlightPriceInfoDto();

	public FlightPriceInfoResponseForm(FlightPriceInfoDto flightPriceInfo) {
		super();
		this.flightPriceInfo = flightPriceInfo;
	}

	public FlightPriceInfoDto getFlightPriceInfo() {
		return flightPriceInfo;
	}

	public void setFlightPriceInfo(FlightPriceInfoDto flightPriceInfo) {
		this.flightPriceInfo = flightPriceInfo;
	}
	
	public String getSequence() {
		return flightPriceInfo.getSequence();
	}

	public Long getId() {
		return flightPriceInfo.getId();
	}

	public void setId(Long id) {
		flightPriceInfo.setId(id);
	}

	public String getUuid() {
		return flightPriceInfo.getUuid();
	}

	public void setUuid(String uuid) {
		flightPriceInfo.setUuid(uuid);
	}

	public String getFlightNo() {
		return flightPriceInfo.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		flightPriceInfo.setFlightNo(flightNo);
	}

	public String getSeatClassCode() {
		return flightPriceInfo.getSeatClassCode();
	}

	public void setSeatClassCode(String seatClassCode) {
		flightPriceInfo.setSeatClassCode(seatClassCode);
	}

	public String getDepartureAirportCode() {
		return flightPriceInfo.getDepartureAirportCode();
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		flightPriceInfo.setDepartureAirportCode(departureAirportCode);
	}

	public String getArrivalAirportCode() {
		return flightPriceInfo.getArrivalAirportCode();
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
		flightPriceInfo.setArrivalAirportCode(arrivalAirportCode);
	}

	public String getDepartureDate() {
		return  DateUtils.parseDate(flightPriceInfo.getDepartureDate(),"yyyy-MM-dd");
	}

	public void setDepartureDate(Long departureDate) {
		flightPriceInfo.setDepartureDate(departureDate);
	}

	public String getLvSeatClassCode() {
		return flightPriceInfo.getLvSeatClassCode();
	}

	public void setLvSeatClassCode(String lvSeatClassCode) {
		flightPriceInfo.setLvSeatClassCode(lvSeatClassCode);
	}

	public TimeSegmentRange getTimeSegmentRange() {
		return flightPriceInfo.getTimeSegmentRange();
	}

	public void setTimeSegmentRange(TimeSegmentRange timeSegmentRange) {
		flightPriceInfo.setTimeSegmentRange(timeSegmentRange);
	}

	public BigDecimal getParPrice() {
		return flightPriceInfo.getParPrice();
	}

	public void setParPrice(BigDecimal parPrice) {
		flightPriceInfo.setParPrice(parPrice); 
	}	
	
	public BigDecimal getYParPrice() {
		return flightPriceInfo.getyParPrice();
	}

	public void setYParPrice(BigDecimal yParPrice) {
		flightPriceInfo.setyParPrice(yParPrice);
	}

	public BigDecimal getDiscount() {
		return flightPriceInfo.getDiscount();
	}

	public void setDiscount(BigDecimal discount) {
		flightPriceInfo.setDiscount(discount);
	}
	
	public Integer getInventoryCount() {
		return flightPriceInfo.getInventoryCount();
	}

	public void setInventoryCount(Integer inventoryCount) {
		flightPriceInfo.setInventoryCount(inventoryCount);
	}

	public String getDepartureTime() {
		if(flightPriceInfo.getTimeSegmentRange()!=null){
			return DateUtils.formatTime(flightPriceInfo.getTimeSegmentRange().getDepartureTime());
		}
		return "";
	}
	
	public String getArrivalTime() {
		if(flightPriceInfo.getTimeSegmentRange()!=null){
			return DateUtils.formatTime(flightPriceInfo.getTimeSegmentRange().getArrivalTime());
		}
		return "";
	}
	
	public String getDepartureCityCode() {
		return flightPriceInfo.getDepartureCityCode();
	}

	public void setDepartureCityCode(String departureCityCode) {
		flightPriceInfo.setDepartureCityCode(departureCityCode);
	}

	public String getArrivalCityCode() {
		return flightPriceInfo.getArrivalCityCode();
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		flightPriceInfo.setArrivalCityCode(arrivalCityCode);
	}
	
	public Date getUpdateTime() {
		return flightPriceInfo.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		flightPriceInfo.setUpdateTime(updateTime);
	}
}
