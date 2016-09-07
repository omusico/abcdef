package com.lvmama.lvf.common.form.vst;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.flight.FlightInfoDto;
import com.lvmama.lvf.common.dto.status.BatchFlag;
import com.lvmama.lvf.common.dto.vst.FlightVstBasicFlightDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

public class VSTBasicFlightResponseForm implements Form, Serializable {

	private static final long serialVersionUID = 7231307056514501012L;
	
	private FlightVstBasicFlightDto vstBasicFlight = new FlightVstBasicFlightDto();

	public FlightVstBasicFlightDto getVstBasicFlight() {
		return vstBasicFlight;
	}

	public void setVstBasicFlight(FlightVstBasicFlightDto vstBasicFlight) {
		this.vstBasicFlight = vstBasicFlight;
	}
	
	public BatchFlag getBatchFlag(){
		return vstBasicFlight.getBatchFlag();
	}
	
	public void setBatchFlag(BatchFlag batchFlag){
		vstBasicFlight.setBatchFlag(batchFlag);
	}
	
	public Long getVstBasicFlightId() {
		return vstBasicFlight.getVstBasicFlightId();
	}

	public void setVstBasicFlightId(Long vstBasicFlightId) {
		vstBasicFlight.setVstBasicFlightId(vstBasicFlightId);
	}

	public String getFlightNo() {
		return vstBasicFlight.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		vstBasicFlight.setFlightNo(flightNo);
	}

	public Long getVstCarrierId() {
		return vstBasicFlight.getVstCarrierId();
	}

	public void setVstCarrierId(Long vstCarrierId) {
		vstBasicFlight.setVstCarrierId(vstCarrierId);
	}

	public Long getVstDeptCityId() {
		return vstBasicFlight.getVstDeptCityId();
	}

	public void setVstDeptCityId(Long vstDeptCityId) {
		vstBasicFlight.setVstDeptCityId(vstDeptCityId);
	}

	public Long getVstArrvCityId() {
		return vstBasicFlight.getVstArrvCityId();
	}

	public void setVstArrvCityId(Long vstArrvCityId) {
		vstBasicFlight.setVstArrvCityId(vstArrvCityId);
	}

	public String getDeptAirportCode() {
		return vstBasicFlight.getDeptAirportCode();
	}

	public void setDeptAirportCode(String deptAirportCode) {
		vstBasicFlight.setDeptAirportCode(deptAirportCode);
	}

	public String getArrvAirportCode() {
		return vstBasicFlight.getArrvAirportCode();
	}

	public void setArrvAirportCode(String arrvAirportCode) {
		vstBasicFlight.setArrvAirportCode(arrvAirportCode);
	}

	public Long getFlightInfoId() {
		return vstBasicFlight.getFlightInfoId();
	}

	public void setFlightInfoId(Long flightInfoId) {
		vstBasicFlight.setFlightInfoId(flightInfoId);
	}

	public String getDeptCityCode() {
		return vstBasicFlight.getDeptCityCode();
	}

	public void setDeptCityCode(String deptCityCode) {
		vstBasicFlight.setDeptCityCode(deptCityCode);
	}

	public String getArrvCityCode() {
		return vstBasicFlight.getArrvCityCode();
	}

	public void setArrvCityCode(String arrvCityCode) {
		vstBasicFlight.setArrvCityCode(arrvCityCode);
	}

	public Long getVstAirplaneId() {
		return vstBasicFlight.getVstAirplaneId();
	}

	public void setVstAirplaneId(Long vstAirplaneId) {
		vstBasicFlight.setVstAirplaneId(vstAirplaneId);
	}

	public FlightInfoDto getFlightInfoDto() {
		return vstBasicFlight.getFlightInfoDto();
	}

	public void setFlightInfoDto(FlightInfoDto flightInfoDto) {
		vstBasicFlight.setFlightInfoDto(flightInfoDto);
	}

	public Date getUpdateTime() {
		return vstBasicFlight.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		vstBasicFlight.setUpdateTime(updateTime);
	}

	public Date getCreateTime() {
		return vstBasicFlight.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		vstBasicFlight.setCreateTime(createTime);
	}
	
	public String getUpdateTimeStr(){
		if(this.getUpdateTime()!=null){
			return DateUtils.formatCnHmDate(this.getUpdateTime());
		}
		return null;
	}
	
	public String getCreateTimeStr(){
		if(this.getCreateTime()!=null){
			return DateUtils.formatCnHmDate(this.getCreateTime());
		}
		return null;
	}

}
