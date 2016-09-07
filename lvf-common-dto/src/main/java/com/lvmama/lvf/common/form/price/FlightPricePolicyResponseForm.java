package com.lvmama.lvf.common.form.price;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.calculator.FlightTicketPriceDto;
import com.lvmama.lvf.common.dto.flight.price.FlightPriceBase;
import com.lvmama.lvf.common.dto.flight.price.FlightPricePolicyDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;
/**
 * 运价政策 ResponseForm
 * @author zhangzongshuang
 * @date 2015年8月4日
 */
public class FlightPricePolicyResponseForm implements Serializable, Form {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7838624703975182794L;
    
	private FlightPricePolicyDto flightPricePolicy=new FlightPricePolicyDto();

	public FlightPricePolicyResponseForm(FlightPricePolicyDto flightPricePolicy) {
		super();
		this.flightPricePolicy = flightPricePolicy;
	}

	public FlightPricePolicyDto getFlightPricePolicy() {
		return flightPricePolicy;
	}

	public void setFlightPricePolicy(FlightPricePolicyDto flightPricePolicy) {
		this.flightPricePolicy = flightPricePolicy;
	}

	public Long getId() {
		return flightPricePolicy.getId();
	}

	public void setId(Long id) {
		flightPricePolicy.setId(id);
	}

	public String getUuid() {
		return flightPricePolicy.getUuid();
	}

	public FlightPriceBase getFlightPriceBase() {
		return flightPricePolicy.getFlightPriceBase();
	}

	public void setUuid(String uuid) {
		flightPricePolicy.setUuid(uuid);
	}

	public void setFlightPriceBase(FlightPriceBase flightPriceBase) {
		flightPricePolicy.setFlightPriceBase(flightPriceBase);
	}

	public Date getCreateTime() {
		return flightPricePolicy.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		flightPricePolicy.setCreateTime(createTime);
	}

	public String getFlightNo() {
		return flightPricePolicy.getFlightNo();
	}

	public Date getUpdateTime() {
		return flightPricePolicy.getUpdateTime();
	}

	public void setFlightNo(String flightNo) {
		flightPricePolicy.setFlightNo(flightNo);
	}

	public void setUpdateTime(Date updateTime) {
		flightPricePolicy.setUpdateTime(updateTime);
	}

	public String getSeatClassCode() {
		return flightPricePolicy.getSeatClassCode();
	}

	public void setSeatClassCode(String seatClassCode) {
		flightPricePolicy.setSeatClassCode(seatClassCode);
	}

	public String getDepartureAirportCode() {
		return flightPricePolicy.getDepartureAirportCode();
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		flightPricePolicy.setDepartureAirportCode(departureAirportCode);
	}

	public String getArrivalAirportCode() {
		return flightPricePolicy.getArrivalAirportCode();
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
		flightPricePolicy.setArrivalAirportCode(arrivalAirportCode);
	}

	public String getDepartureCityCode() {
		return flightPricePolicy.getDepartureCityCode();
	}

	public void setDepartureCityCode(String departureCityCode) {
		flightPricePolicy.setDepartureCityCode(departureCityCode);
	}

	public String getArrivalCityCode() {
		return flightPricePolicy.getArrivalCityCode();
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		flightPricePolicy.setArrivalCityCode(arrivalCityCode);
	}

	public String getDepartureDate() {
		return  DateUtils.parseDate(flightPricePolicy.getDepartureDate(),"yyyy-MM-dd");
	}

	public void setDepartureDate(Long departureDate) {
		flightPricePolicy.setDepartureDate(departureDate);
	}

	public String getLvSeatClassCode() {
		return flightPricePolicy.getLvSeatClassCode();
	}

	public void setLvSeatClassCode(String lvSeatClassCode) {
		flightPricePolicy.setLvSeatClassCode(lvSeatClassCode);
	}

	public Long getVersionNo() {
		return flightPricePolicy.getVersionNo();
	}

	public void setVersionNo(Long versionNo) {
		flightPricePolicy.setVersionNo(versionNo);
	}

	public String getMd5Sign() {
		return flightPricePolicy.getMd5Sign();
	}

	public void setMd5Sign(String md5Sign) {
		flightPricePolicy.setMd5Sign(md5Sign);
	}

	public String getSuppCode() {
		return flightPricePolicy.getSuppCode();
	}

	public void setSuppCode(String suppCode) {
		flightPricePolicy.setSuppCode(suppCode);
	}

	public String getSuppPolicyNo() {
		return flightPricePolicy.getSuppPolicyNo();
	}

	public void setSuppPolicyNo(String suppPolicyNo) {
		flightPricePolicy.setSuppPolicyNo(suppPolicyNo);
	}

	public FlightTicketPriceDto getFlightTicketPriceDto() {
		return flightPricePolicy.getFlightTicketPriceDto();
	}

	public void setFlightTicketPriceDto(FlightTicketPriceDto flightTicketPriceDto) {
		flightPricePolicy.setFlightTicketPriceDto(flightTicketPriceDto);
	}

	public String getSaleType() {
		return flightPricePolicy.getSaleType();
	}

	public void setSaleType(String saleType) {
		flightPricePolicy.setSaleType(saleType);
	}

	public BigDecimal getSettlePrice() {
		if(flightPricePolicy.getFlightTicketPriceDto()!=null){
			return flightPricePolicy.getFlightTicketPriceDto().getSettlePrice();
		}
		return null;
	}

}
