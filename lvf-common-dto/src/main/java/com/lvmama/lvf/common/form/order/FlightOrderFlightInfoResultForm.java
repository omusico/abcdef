package com.lvmama.lvf.common.form.order;

import java.math.BigDecimal;
import java.util.Date;

import com.lvmama.lvf.common.dto.enums.FlightSegmentType;
import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.enums.MealType;
import com.lvmama.lvf.common.dto.flight.FlightAirportLineDto;
import com.lvmama.lvf.common.dto.flight.FlightInfoDto;
import com.lvmama.lvf.common.dto.flight.FlightSeatDto;
import com.lvmama.lvf.common.dto.flight.FlightStopInfoDto;
import com.lvmama.lvf.common.dto.md.Airplane;
import com.lvmama.lvf.common.dto.md.Carrier;
import com.lvmama.lvf.common.dto.md.TimeSegmentRange;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightCombinationDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightInfoDto;
import com.lvmama.lvf.common.form.Form;

public class FlightOrderFlightInfoResultForm implements Form {

	private FlightOrderFlightInfoDto flightOrderFlightInfoDto;

	public FlightOrderFlightInfoDto getFlightOrderFlightInfoDto() {
		return flightOrderFlightInfoDto;
	}

	public void setFlightOrderFlightInfoDto(
			FlightOrderFlightInfoDto flightOrderFlightInfoDto) {
		this.flightOrderFlightInfoDto = flightOrderFlightInfoDto;
	}

	public String getSequence() {
		return flightOrderFlightInfoDto.getSequence();
	}

	public Long getId() {
		return flightOrderFlightInfoDto.getId();
	}

	public void setId(Long id) {
		flightOrderFlightInfoDto.setId(id);
	}

	public String getUuid() {
		return flightOrderFlightInfoDto.getUuid();
	}

	public void setUuid(String uuid) {
		flightOrderFlightInfoDto.setUuid(uuid);
	}

	public Date getCreateTime() {
		return flightOrderFlightInfoDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		flightOrderFlightInfoDto.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return flightOrderFlightInfoDto.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		flightOrderFlightInfoDto.setUpdateTime(updateTime);
	}

	public Long getCombinationDetailId() {
		return flightOrderFlightInfoDto.getCombinationDetailId();
	}

	public void setCombinationDetailId(Long combinationDetailId) {
		flightOrderFlightInfoDto.setCombinationDetailId(combinationDetailId);
	}

	public FlightInfoDto getFlightInfo() {
		return flightOrderFlightInfoDto.getFlightInfo();
	}

	public void setFlightInfo(FlightInfoDto flightInfo) {
		flightOrderFlightInfoDto.setFlightInfo(flightInfo);
	}

	public FlightTripType getFlightTripType() {
		return flightOrderFlightInfoDto.getFlightTripType();
	}

	public void setFlightTripType(FlightTripType flightTripType) {
		flightOrderFlightInfoDto.setFlightTripType(flightTripType);
	}

	public Carrier getCarrier() {
		return flightOrderFlightInfoDto.getCarrier();
	}

	public void setCarrier(Carrier carrier) {
		flightOrderFlightInfoDto.setCarrier(carrier);
	}

	public Airplane getAirplane() {
		return flightOrderFlightInfoDto.getAirplane();
	}

	public void setAirplane(Airplane airplane) {
		flightOrderFlightInfoDto.setAirplane(airplane);
	}

	public String getFlightNo() {
		return flightOrderFlightInfoDto.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		flightOrderFlightInfoDto.setFlightNo(flightNo);
	}

	public Integer getMileages() {
		return flightOrderFlightInfoDto.getMileages();
	}

	public void setMileages(Integer mileages) {
		flightOrderFlightInfoDto.setMileages(mileages);
	}

	public FlightAirportLineDto getFlightAirportLine() {
		return flightOrderFlightInfoDto.getFlightAirportLine();
	}

	public void setFlightAirportLine(FlightAirportLineDto flightAirportLine) {
		flightOrderFlightInfoDto.setFlightAirportLine(flightAirportLine);
	}

	public FlightSegmentType getFlightSegmentType() {
		return flightOrderFlightInfoDto.getFlightSegmentType();
	}

	public void setFlightSegmentType(FlightSegmentType flightSegmentType) {
		flightOrderFlightInfoDto.setFlightSegmentType(flightSegmentType);
	}

	public FlightStopInfoDto getFlightStopInfo() {
		return flightOrderFlightInfoDto.getFlightStopInfo();
	}

	public void setFlightStopInfo(FlightStopInfoDto flightStopInfo) {
		flightOrderFlightInfoDto.setFlightStopInfo(flightStopInfo);
	}

	public BigDecimal getyParPrice() {
		return flightOrderFlightInfoDto.getyParPrice();
	}

	public void setyParPrice(BigDecimal yParPrice) {
		flightOrderFlightInfoDto.setyParPrice(yParPrice);
	}

	public MealType getMealType() {
		return flightOrderFlightInfoDto.getMealType();
	}

	public void setMealType(MealType mealType) {
		flightOrderFlightInfoDto.setMealType(mealType);
	}

	public TimeSegmentRange getTimeSegmentRange() {
		return flightOrderFlightInfoDto.getTimeSegmentRange();
	}

	public void setTimeSegmentRange(TimeSegmentRange timeSegmentRange) {
		flightOrderFlightInfoDto.setTimeSegmentRange(timeSegmentRange);
	}

	public Boolean getIsShare() {
		return flightOrderFlightInfoDto.getIsShare();
	}

	public void setIsShare(Boolean isShare) {
		flightOrderFlightInfoDto.setIsShare(isShare);
	}

	public Carrier getShareCarrier() {
		return flightOrderFlightInfoDto.getShareCarrier();
	}

	public void setShareCarrier(Carrier shareCarrier) {
		flightOrderFlightInfoDto.setShareCarrier(shareCarrier);
	}

	public String getShareFlightNo() {
		return flightOrderFlightInfoDto.getShareFlightNo();
	}

	public void setShareFlightNo(String shareFlightNo) {
		flightOrderFlightInfoDto.setShareFlightNo(shareFlightNo);
	}

	public FlightSeatDto getFlightSeat() {
		return flightOrderFlightInfoDto.getFlightSeat();
	}

	public void setFlightSeat(FlightSeatDto flightSeat) {
		flightOrderFlightInfoDto.setFlightSeat(flightSeat);
	}

	
}
