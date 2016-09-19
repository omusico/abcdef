package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.enums.BindingStatus;
import com.lvmama.lvf.common.dto.order.FlightOrderVstDto;

/**
 * @author lutianyu
 * @date   2015年3月25日
 */
public class VSTOrderRequest implements Serializable{
	private static final long serialVersionUID = 1423213230488786465L;
	
	private FlightOrderVstDto flightOrderVstDto = new FlightOrderVstDto();

	public Long getVstFlightOrderId() {
		return flightOrderVstDto.getVstFlightOrderId();
	}

	public void setVstFlightOrderId(Long vstFlightOrderId) {
		flightOrderVstDto.setVstFlightOrderId(vstFlightOrderId);
	}

	public Long getId() {
		return flightOrderVstDto.getId();
	}

	public void setId(Long id) {
		flightOrderVstDto.setId(id);
	}

	public Long getVstMainOrderId() {
		return flightOrderVstDto.getVstMainOrderId();
	}

	public void setVstMainOrderId(Long vstMainOrderId) {
		flightOrderVstDto.setVstMainOrderId(vstMainOrderId);
	}

	public Long getLvfMainOrderId() {
		return flightOrderVstDto.getLvfMainOrderId();
	}

	public void setLvfMainOrderId(Long lvfMainOrderId) {
		flightOrderVstDto.setLvfMainOrderId(lvfMainOrderId);
	}

	public String getLvfMainOrderNo() {
		return flightOrderVstDto.getLvfMainOrderNo();
	}

	public void setLvfMainOrderNo(String lvfMainOrderNo) {
		flightOrderVstDto.setLvfMainOrderNo(lvfMainOrderNo);
	}

	public FlightOrderVstDto getFlightOrderVstDto() {
		return flightOrderVstDto;
	}

	public void setFlightOrderVstDto(FlightOrderVstDto flightOrderVstDto) {
		this.flightOrderVstDto = flightOrderVstDto;
	}

	public void setBindingStatus(BindingStatus bindingStatus) {
		flightOrderVstDto.setBindingStatus(bindingStatus);
	}
	
	public BindingStatus getBindingStatus() {
		return flightOrderVstDto.getBindingStatus();
	}

	public String getLockSeatOrderId() {
		return flightOrderVstDto.getLockSeatOrderId();
	}
	
	public void setLockSeatOrderId(String lockSeatOrderId) {
		flightOrderVstDto.setLockSeatOrderId(lockSeatOrderId);
	}
	
}
