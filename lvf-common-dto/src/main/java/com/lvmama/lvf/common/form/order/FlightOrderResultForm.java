package com.lvmama.lvf.common.form.order;

import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.order.FlightOrderAmountDto;
import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderDto;
import com.lvmama.lvf.common.dto.order.FlightOrderLinkInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderNoDto;
import com.lvmama.lvf.common.dto.order.status.FlightOrderStatusDto;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderDto;
import com.lvmama.lvf.common.form.Form;

public class FlightOrderResultForm implements Form {

	private FlightOrderDto flightOrderDto;

	public FlightOrderDto getFlightOrderDto() {
		return flightOrderDto;
	}

	public void setFlightOrderDto(FlightOrderDto flightOrderDto) {
		this.flightOrderDto = flightOrderDto;
	}

	public String getSequence() {
		return flightOrderDto.getSequence();
	}

	public Long getId() {
		return flightOrderDto.getId();
	}

	public void setId(Long id) {
		flightOrderDto.setId(id);
	}

	public String getUuid() {
		return flightOrderDto.getUuid();
	}

	public void setUuid(String uuid) {
		flightOrderDto.setUuid(uuid);
	}

	public void setCreateTime(Date createTime) {
		flightOrderDto.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return flightOrderDto.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		flightOrderDto.setUpdateTime(updateTime);
	}

	public FlightOrderNoDto getFlightOrderNo() {
		return flightOrderDto.getFlightOrderNo();
	}

	public void setFlightOrderNo(FlightOrderNoDto flightOrderNo) {
		flightOrderDto.setFlightOrderNo(flightOrderNo);
	}

	public List<FlightOrderLinkInfoDto> getFlightOrderLinkInfos() {
		return flightOrderDto.getFlightOrderLinkInfos();
	}

	public List<FlightOrderSuppOrderDto> getFlightOrderSuppOrders() {
		return flightOrderDto.getFlightOrderSuppOrders();
	}

	public void setFlightOrderSuppOrders(
			List<FlightOrderSuppOrderDto> flightOrderSuppOrders) {
		flightOrderDto.setFlightOrderSuppOrders(flightOrderSuppOrders);
	}

	public void setFlightOrderLinkInfos(
			List<FlightOrderLinkInfoDto> flightOrderLinkInfos) {
		flightOrderDto.setFlightOrderLinkInfos(flightOrderLinkInfos);
	}

	public FlightOrderAmountDto getFlightOrderAmount() {
		return flightOrderDto.getFlightOrderAmount();
	}

	public void setFlightOrderAmount(FlightOrderAmountDto flightOrderAmount) {
		flightOrderDto.setFlightOrderAmount(flightOrderAmount);
	}


//	public FlightOrderOpStatusDto getFlightOrderOpStatus() {
//		return flightOrderDto.getFlightOrderOpStatus();
//	}
//
//	public void setFlightOrderOpStatus(
//			FlightOrderOpStatusDto flightOrderOpStatus) {
//		flightOrderDto.setFlightOrderOpStatus(flightOrderOpStatus);
//	}

	public FlightOrderStatusDto getFlightOrderStatus() {
		return flightOrderDto.getFlightOrderStatus();
	}

	public void setFlightOrderStatus(FlightOrderStatusDto flightOrderStatus) {
		flightOrderDto.setFlightOrderStatus(flightOrderStatus);
	}

	public List<FlightOrderDetailDto> getFlightOrderDetails() {
		return flightOrderDto.getFlightOrderDetails();
	}

	public void setFlightOrderDetails(
			List<FlightOrderDetailDto> flightOrderDetails) {
		flightOrderDto.setFlightOrderDetails(flightOrderDetails);
	}
	
}
