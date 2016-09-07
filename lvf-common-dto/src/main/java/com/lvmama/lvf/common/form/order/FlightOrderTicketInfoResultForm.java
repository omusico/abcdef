package com.lvmama.lvf.common.form.order;

import java.util.Date;

import com.lvmama.lvf.common.dto.enums.LinkStatus;
import com.lvmama.lvf.common.dto.enums.OrderLinkType;
import com.lvmama.lvf.common.dto.order.FlightOrderDto;
import com.lvmama.lvf.common.dto.order.FlightOrderLinkInfoDto;
import com.lvmama.lvf.common.form.Form;

public class FlightOrderTicketInfoResultForm implements Form {

	private FlightOrderLinkInfoDto flightOrderLinkInfoDto;

	public FlightOrderLinkInfoDto getFlightOrderLinkInfoDto() {
		return flightOrderLinkInfoDto;
	}

	public void setFlightOrderLinkInfoDto(
			FlightOrderLinkInfoDto flightOrderLinkInfoDto) {
		this.flightOrderLinkInfoDto = flightOrderLinkInfoDto;
	}

	public String getSequence() {
		return flightOrderLinkInfoDto.getSequence();
	}

	public Long getId() {
		return flightOrderLinkInfoDto.getId();
	}

	public void setId(Long id) {
		flightOrderLinkInfoDto.setId(id);
	}

	public String getUuid() {
		return flightOrderLinkInfoDto.getUuid();
	}

	public void setUuid(String uuid) {
		flightOrderLinkInfoDto.setUuid(uuid);
	}

	public Date getCreateTime() {
		return flightOrderLinkInfoDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		flightOrderLinkInfoDto.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return flightOrderLinkInfoDto.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		flightOrderLinkInfoDto.setUpdateTime(updateTime);
	}

	public String getLinkOrderNo() {
		return flightOrderLinkInfoDto.getLinkOrderNo();
	}

	public void setLinkOrderNo(String linkOrderNo) {
		flightOrderLinkInfoDto.setLinkOrderNo(linkOrderNo);
	}

	public OrderLinkType getOrderLinkType() {
		return flightOrderLinkInfoDto.getOrderLinkType();
	}

	public void setOrderLinkType(OrderLinkType orderLinkType) {
		flightOrderLinkInfoDto.setOrderLinkType(orderLinkType);
	}

	public LinkStatus getLinkStatus() {
		return flightOrderLinkInfoDto.getLinkStatus();
	}

	public void setLinkStatus(LinkStatus linkStatus) {
		flightOrderLinkInfoDto.setLinkStatus(linkStatus);
	}

	public String getLinkUrl() {
		return flightOrderLinkInfoDto.getLinkUrl();
	}

	public void setLinkUrl(String linkUrl) {
		flightOrderLinkInfoDto.setLinkUrl(linkUrl);
	}

	public String getLinkDesc() {
		return flightOrderLinkInfoDto.getLinkDesc();
	}

	public void setLinkDesc(String linkDesc) {
		flightOrderLinkInfoDto.setLinkDesc(linkDesc);
	}
	
	
}
