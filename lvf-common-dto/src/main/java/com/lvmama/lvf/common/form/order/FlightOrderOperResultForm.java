package com.lvmama.lvf.common.form.order;

import java.util.Date;

import com.lvmama.lvf.common.dto.order.FlightOrderDto;
import com.lvmama.lvf.common.dto.order.FlightOrderOperDto;
import com.lvmama.lvf.common.form.Form;

public class FlightOrderOperResultForm implements Form {
	
	private FlightOrderOperDto flightOrderOperDto;
	
	public FlightOrderOperResultForm(){
		super();
	}
	
	public FlightOrderOperResultForm(FlightOrderOperDto flightOrderOperDto){
		super();
		this.flightOrderOperDto = flightOrderOperDto;
	}

	public FlightOrderOperDto getFlightOrderOperDto() {
		return flightOrderOperDto;
	}

	public void setFlightOrderOperDto(FlightOrderOperDto flightOrderOperDto) {
		this.flightOrderOperDto = flightOrderOperDto;
	}

	public String getSequence() {
		return flightOrderOperDto.getSequence();
	}

	public Long getId() {
		return flightOrderOperDto.getId();
	}

	public void setId(Long id) {
		flightOrderOperDto.setId(id);
	}

	public String getUuid() {
		return flightOrderOperDto.getUuid();
	}

	public void setUuid(String uuid) {
		flightOrderOperDto.setUuid(uuid);
	}

	public Date getCreateTime() {
		return flightOrderOperDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		flightOrderOperDto.setCreateTime(createTime);
	}

	public String getOper() {
		return flightOrderOperDto.getOper();
	}

	public Date getUpdateTime() {
		return flightOrderOperDto.getUpdateTime();
	}

	public void setOper(String oper) {
		flightOrderOperDto.setOper(oper);
	}

	public void setUpdateTime(Date updateTime) {
		flightOrderOperDto.setUpdateTime(updateTime);
	}

	public String getRemark() {
		return flightOrderOperDto.getRemark();
	}

	public void setRemark(String remark) {
		flightOrderOperDto.setRemark(remark);
	}
	
	

}
