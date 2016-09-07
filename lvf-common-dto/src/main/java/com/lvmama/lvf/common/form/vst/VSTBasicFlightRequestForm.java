package com.lvmama.lvf.common.form.vst;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.flight.FlightInfoDto;
import com.lvmama.lvf.common.dto.status.BatchFlag;
import com.lvmama.lvf.common.dto.vst.FlightVstBasicFlightDto;
import com.lvmama.lvf.common.form.Form;

public class VSTBasicFlightRequestForm implements Form, Serializable {

	private static final long serialVersionUID = 7231307056514501012L;
	
	private FlightVstBasicFlightDto vstBasicFlight = new FlightVstBasicFlightDto();
	
	private Date updateStartTime;
	
	private String updateBeginTime;
	
	private String updateEndTime;
	
	private Pagination pagination = new Pagination();

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

	public Date getUpdateStartTime() {
		return updateStartTime;
	}

	public void setUpdateStartTime(Date updateStartTime) {
		this.updateStartTime = updateStartTime;
	}

	public String getUpdateBeginTime() {
		return updateBeginTime;
	}

	public void setUpdateBeginTime(String updateBeginTime) {
		this.updateBeginTime = updateBeginTime;
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

	public String getUpdateEndTime() {
		return updateEndTime;
	}

	public void setUpdateEndTime(String updateEndTime) {
		this.updateEndTime = updateEndTime;
	}
	
	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public int getPage() {
		return pagination.getPage();
	}

	public void setPage(int page) {
		pagination.setPage(page);
	}

	public int getRows() {
		return pagination.getRows();
	}

	public void setRows(int rows) {
		pagination.setRows(rows);
	}

	public int getRecords() {
		return pagination.getRecords();
	}

	public void setRecords(int records) {
		pagination.setRecords(records);
	}

	public void countRecords(int records) {
		pagination.countRecords(records);
	}

	public int getTotal() {
		return pagination.getTotal();
	}

	public void setTotal(int total) {
		pagination.setTotal(total);
	}

	public String getSidx() {
		return pagination.getSidx();
	}

	public void setSidx(String sidx) {
		pagination.setSidx(sidx);
	}

	public String getSord() {
		return pagination.getSord();
	}

	public void setSord(String sord) {
		pagination.setSord(sord);
	}

	public int getStartRow() {
		return pagination.getStartRow();
	}

	public int getEndRow() {
		return pagination.getEndRow();
	}

	public boolean isSearch() {
		return pagination.isSearch();
	}

	public void setSearch(boolean search) {
		pagination.setSearch(search);
	}

}
