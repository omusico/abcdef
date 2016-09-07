package com.lvmama.lvf.common.form.vst;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.status.BatchFlag;
import com.lvmama.lvf.common.dto.vst.FlightVstBasicFlightDto;
import com.lvmama.lvf.common.dto.vst.FlightVstTrafficFlightDto;
import com.lvmama.lvf.common.form.Form;

public class VSTTrafficFlightRequestForm implements Form, Serializable {

	private static final long serialVersionUID = -6290246199854638801L;
	
	private FlightVstTrafficFlightDto vstTrafficFlight = new FlightVstTrafficFlightDto();
	
	private String updateBeginTime;
	
	private String updateEndTime;
	
	private Date updateStartTime;
	
	private Pagination pagination = new Pagination();
	
	private Long vstBasicFlightId;

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

	public Long getVstBasicFlightId() {
		return vstBasicFlightId;
	}

	public void setVstBasicFlightId(Long vstBasicFlightId) {
		this.vstBasicFlightId = vstBasicFlightId;
	}

	public String getUpdateBeginTime() {
		return updateBeginTime;
	}

	public void setUpdateBeginTime(String updateBeginTime) {
		this.updateBeginTime = updateBeginTime;
	}

	public String getUpdateEndTime() {
		return updateEndTime;
	}

	public void setUpdateEndTime(String updateEndTime) {
		this.updateEndTime = updateEndTime;
	}

	public Date getUpdateStartTime() {
		return updateStartTime;
	}

	public void setUpdateStartTime(Date updateStartTime) {
		this.updateStartTime = updateStartTime;
	}
	
	public BatchFlag getBatchFlag() {
		return vstTrafficFlight.getBatchFlag();
	}

	public void setBatchFlag(BatchFlag batchFlag) {
		vstTrafficFlight.setBatchFlag(batchFlag);
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


}
