package com.lvmama.lvf.common.form.vst;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.status.BatchFlag;
import com.lvmama.lvf.common.dto.vst.FlightVstBasicFlightDto;
import com.lvmama.lvf.common.dto.vst.FlightVstTrafficFlightDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

public class VSTTrafficFlightResponseForm implements Form, Serializable {

	private static final long serialVersionUID = -6290246199854638801L;
	
	private FlightVstTrafficFlightDto vstTrafficFlight = new FlightVstTrafficFlightDto();
	
	public FlightVstTrafficFlightDto getVstTrafficFlight() {
		return vstTrafficFlight;
	}

	public void setVstTrafficFlight(FlightVstTrafficFlightDto vstTrafficFlight) {
		this.vstTrafficFlight = vstTrafficFlight;
	}
	
	public Long getVstProductId() {
		return vstTrafficFlight.getVstProductId();
	}

	public void setVstProductId(Long vstProductId) {
		vstTrafficFlight.setVstProductId(vstProductId);
	}


	public Long getVstGroupId() {
		return vstTrafficFlight.getVstGroupId();
	}

	public void setVstGroupId(Long vstGroupId) {
		vstTrafficFlight.setVstGroupId(vstGroupId);
	}

	public String getTripType() {
		return vstTrafficFlight.getTripType();
	}

	public void setTripType(String tripType) {
		vstTrafficFlight.setTripType(tripType);
	}

	public Long getVstTrafficFlightId() {
		return vstTrafficFlight.getVstTrafficFlightId();
	}

	public void setVstTrafficFlightId(Long vstTrafficFlightId) {
		vstTrafficFlight.setVstTrafficFlightId(vstTrafficFlightId);
	}

	public Long getVstFlightId() {
		return vstTrafficFlight.getVstFlightId();
	}

	public void setVstFlightId(Long vstFlightId) {
		vstTrafficFlight.setVstFlightId(vstFlightId);
	}
	
	public FlightVstBasicFlightDto getVstBasicFlightDto() {
		return vstTrafficFlight.getVstBasicFlightDto();
	}

	public void setVstBasicFlightDto(FlightVstBasicFlightDto vstBasicFlightDto) {
		vstTrafficFlight.setVstBasicFlightDto(vstBasicFlightDto);
	}
	
	public Date getUpdateTime(){
		return vstTrafficFlight.getUpdateTime();
	}
	
	public void setUpdateTime(Date updateTime){
		vstTrafficFlight.setUpdateTime(updateTime);
	}
	
	public Date getCreateTime(){
		return vstTrafficFlight.getCreateTime();
	}
	
	public void setCreateTime(Date createTime){
		vstTrafficFlight.setCreateTime(createTime);
	}
	
	public BatchFlag getBatchFlag() {
		return vstTrafficFlight.getBatchFlag();
	}

	public void setBatchFlag(BatchFlag batchFlag) {
		vstTrafficFlight.setBatchFlag(batchFlag);
	}

	public String getUpdateTimeStr() {
		if(this.getUpdateTime()!=null){
			return DateUtils.formatCnHmDate(this.getUpdateTime());
		}
		return null;
	}

	public String getCreateTimeStr() {
		if(this.getCreateTime()!=null){
			return DateUtils.formatCnHmDate(this.getCreateTime());
		}
		return null;
	}
	
	

}
