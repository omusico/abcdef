package com.lvmama.lvf.common.form.order;

import com.lvmama.lvf.common.dto.order.FlightOrderImportDto;
import com.lvmama.lvf.common.dto.order.FlightOrderImportRecordDto;
import com.lvmama.lvf.common.dto.order.status.GenerateStatus;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FlightOrderImportRecordResultForm implements Serializable,Form {

	private static final long serialVersionUID = 6486824736600168873L;

	private FlightOrderImportRecordDto flightOrderImportRecordDto;

	private String statusCnName;

	private String createTimeString;

	public FlightOrderImportRecordResultForm(FlightOrderImportRecordDto dto) {
		super();
		this.flightOrderImportRecordDto = dto;
		this.setStatusCnName(dto.getStatus().getCnName());
		this.setCreateTimeString(DateUtils.formatDate(dto.getCreateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS));
	}

	public FlightOrderImportRecordDto getFlightOrderImportRecordDto() {
		return flightOrderImportRecordDto;
	}

	public void setFlightOrderImportRecordDto(FlightOrderImportRecordDto flightOrderImportRecordDto) {
		this.flightOrderImportRecordDto = flightOrderImportRecordDto;
	}

	public String getStatusCnName() {
		return statusCnName;
	}

	public void setStatusCnName(String statusCnName) {
		this.statusCnName = statusCnName;
	}

	public String getCreateTimeString() {
		return createTimeString;
	}

	public void setCreateTimeString(String createTimeString) {
		this.createTimeString = createTimeString;
	}

	public void setImportDtos(List<FlightOrderImportDto> importDtos) {
		flightOrderImportRecordDto.setImportDtos(importDtos);
	}

	public String getFileName() {
		return flightOrderImportRecordDto.getFileName();
	}

	public void setFileName(String fileName) {
		flightOrderImportRecordDto.setFileName(fileName);
	}

	public String getAccountName() {
		return flightOrderImportRecordDto.getAccountName();
	}

	public void setAccountName(String accountName) {
		flightOrderImportRecordDto.setAccountName(accountName);
	}

	public String getCompanyName() {
		return flightOrderImportRecordDto.getCompanyName();
	}

	public void setCompanyName(String companyName) {
		flightOrderImportRecordDto.setCompanyName(companyName);
	}

	public GenerateStatus getStatus() {
		return flightOrderImportRecordDto.getStatus();
	}

	public void setStatus(GenerateStatus status) {
		flightOrderImportRecordDto.setStatus(status);
	}

	public String getRecordDesc() {
		return flightOrderImportRecordDto.getRecordDesc();
	}

	public void setRecordDesc(String recordDesc) {
		flightOrderImportRecordDto.setRecordDesc(recordDesc);
	}

	public List<FlightOrderImportDto> getImportDtos() {
		return flightOrderImportRecordDto.getImportDtos();
	}

	public Long getId() {
		return flightOrderImportRecordDto.getId();
	}

	public void setId(Long id) {
		flightOrderImportRecordDto.setId(id);
	}

	public Date getCreateTime() {
		return flightOrderImportRecordDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		flightOrderImportRecordDto.setCreateTime(createTime);
	}
}
