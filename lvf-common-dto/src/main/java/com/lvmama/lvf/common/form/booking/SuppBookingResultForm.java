package com.lvmama.lvf.common.form.booking;

import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.enums.RouteType;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderDto;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderMainDto;
import com.lvmama.lvf.common.form.Form;

/**
 * 供应商预订返回结果Form
 * @author leizhengwei
 * 2015年12月17日
 */
public class SuppBookingResultForm implements Form {
	
	private FlightOrderSuppOrderMainDto suppOrderMainDto;
	
	private RouteType routeType;
	
	public FlightOrderSuppOrderMainDto getSuppOrderMainDto() {
		return suppOrderMainDto;
	}

	public void setSuppOrderMainDto(FlightOrderSuppOrderMainDto suppOrderMainDto) {
		this.suppOrderMainDto = suppOrderMainDto;
	}

	public String getSuppOrderMainNo() {
		return suppOrderMainDto.getSuppOrderMainNo();
	}

	public void setSuppOrderMainNo(String suppOrderMainNo) {
		suppOrderMainDto.setSuppOrderMainNo(suppOrderMainNo);
	}

	public Long getId() {
		return suppOrderMainDto.getId();
	}

	public void setId(Long id) {
		suppOrderMainDto.setId(id);
	}

	public String getExternalNo() {
		return suppOrderMainDto.getExternalNo();
	}

	public void setExternalNo(String externalNo) {
		suppOrderMainDto.setExternalNo(externalNo);
	}

	public Date getCreateTime() {
		return suppOrderMainDto.getCreateTime();
	}

	public List<FlightOrderSuppOrderDto> getFlightOrderSuppOrderDtos() {
		return suppOrderMainDto.getFlightOrderSuppOrderDtos();
	}

	public void setCreateTime(Date createTime) {
		suppOrderMainDto.setCreateTime(createTime);
	}

	public void setFlightOrderSuppOrderDtos(
			List<FlightOrderSuppOrderDto> flightOrderSuppOrderDtos) {
		suppOrderMainDto.setFlightOrderSuppOrderDtos(flightOrderSuppOrderDtos);
	}

	public Date getUpdateTime() {
		return suppOrderMainDto.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		suppOrderMainDto.setUpdateTime(updateTime);
	}

	public String getSuppCode() {
		return suppOrderMainDto.getSuppCode();
	}

	public void setSuppCode(String suppCode) {
		suppOrderMainDto.setSuppCode(suppCode);
	}

	public String getLvOrderMainNo() {
		return suppOrderMainDto.getLvOrderMainNo();
	}

	public void setLvOrderMainNo(String lvOrderMainNo) {
		suppOrderMainDto.setLvOrderMainNo(lvOrderMainNo);
	}

	public RouteType getRouteType() {
		return routeType;
	}

	public void setRouteType(RouteType routeType) {
		this.routeType = routeType;
	}
	
	
}