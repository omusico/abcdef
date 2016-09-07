package com.lvmama.lvf.common.form.vst;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.flight.FlightSeatDto;
import com.lvmama.lvf.common.dto.status.BatchFlag;
import com.lvmama.lvf.common.dto.vst.FlightVstBasicFlightDto;
import com.lvmama.lvf.common.dto.vst.FlightVstGoodsDto;
import com.lvmama.lvf.common.form.Form;

public class VSTGoodsRequestForm implements Form, Serializable {

	private static final long serialVersionUID = 3535469184847532231L;
	
	private FlightVstGoodsDto goodsDto = new FlightVstGoodsDto();
	
	private Pagination pagination = new Pagination();
	
	private String updateBeginTime;
	
	private String updateEndTime;
	
	public BatchFlag getBatchFlag() {
		return goodsDto.getBatchFlag();
	}

	public void setBatchFlag(BatchFlag batchFlag) {
		goodsDto.setBatchFlag(batchFlag);
	}
	
	public FlightVstGoodsDto getGoodsDto() {
		return goodsDto;
	}

	public void setGoodsDto(FlightVstGoodsDto goodsDto) {
		this.goodsDto = goodsDto;
	}

	public Long getVstGoodsId() {
		return goodsDto.getVstGoodsId();
	}

	public void setVstGoodsId(Long vstGoodsId) {
		goodsDto.setVstGoodsId(vstGoodsId);
	}

	public Long getVstProductId() {
		return goodsDto.getVstProductId();
	}

	public void setVstProductId(Long vstProductId) {
		goodsDto.setVstProductId(vstProductId);
	}

	public Long getVstBasicFlightId() {
		return goodsDto.getVstBasicFlightId();
	}

	public void setVstBasicFlightId(Long vstBasicFlightId) {
		goodsDto.setVstBasicFlightId(vstBasicFlightId);
	}

	public String getSeatClassCode() {
		return goodsDto.getSeatClassCode();
	}

	public void setSeatClassCode(String seatClassCode) {
		goodsDto.setSeatClassCode(seatClassCode);
	}

	public Long getVstProductBranchId() {
		return goodsDto.getVstProductBranchId();
	}

	public void setVstProductBranchId(Long vstProductBranchId) {
		goodsDto.setVstProductBranchId(vstProductBranchId);
	}

	public FlightVstBasicFlightDto getVstBasicFlightDto() {
		return goodsDto.getVstBasicFlightDto();
	}

	public void setVstBasicFlightDto(FlightVstBasicFlightDto vstBasicFlightDto) {
		goodsDto.setVstBasicFlightDto(vstBasicFlightDto);
	}
	
	public Long getFliSeatId() {
		return goodsDto.getFliSeatId();
	}

	public void setFliSeatId(Long fliSeatId) {
		goodsDto.setFliSeatId(fliSeatId);
	}

	public FlightSeatDto getFliSeatDto() {
		return goodsDto.getFliSeatDto();
	}

	public void setFliSeatDto(FlightSeatDto fliSeatDto) {
		goodsDto.setFliSeatDto(fliSeatDto);
	}

	public Date getUpdateStartTime() {
		return goodsDto.getUpdateStartTime();
	}

	public void setUpdateStartTime(Date updateStartTime) {
		goodsDto.setUpdateStartTime(updateStartTime);
	}
	
	public Date getUpdateTime(){
		return goodsDto.getUpdateTime();
	}
	
	public void setUpdateTime(Date updateTime){
		goodsDto.setUpdateTime(updateTime);
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
}
