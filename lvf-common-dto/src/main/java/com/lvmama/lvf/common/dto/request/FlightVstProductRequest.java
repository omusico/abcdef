package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.BaseVSTRequest;
import com.lvmama.lvf.common.dto.status.ActiveStatus;
import com.lvmama.lvf.common.dto.status.BatchFlag;
import com.lvmama.lvf.common.dto.vst.FlightVstProductDto;

/**
 * @author lutianyu
 * @date   2015年4月18日
 */
public class FlightVstProductRequest extends BaseVSTRequest implements Serializable{
	private static final long serialVersionUID = -320530731590478819L;
	
	private FlightVstProductDto flightVstProductDto = new FlightVstProductDto();

	public Long getVstProductId() {
		return flightVstProductDto.getVstProductId();
	}

	public void setVstProductId(Long vstProductId) {
		flightVstProductDto.setVstProductId(vstProductId);
	}

	public ActiveStatus getActiveStatus() {
		return flightVstProductDto.getActiveStatus();
	}

	public void setActiveStatus(ActiveStatus activeStatus) {
		flightVstProductDto.setActiveStatus(activeStatus);
	}

	public BatchFlag getBatchFlag() {
		return flightVstProductDto.getBatchFlag();
	}

	public void setBatchFlag(BatchFlag batchFlag) {
		flightVstProductDto.setBatchFlag(batchFlag);
	}

	public FlightVstProductDto getFlightVstProductDto() {
		return flightVstProductDto;
	}

	public void setFlightVstProductDto(FlightVstProductDto flightVstProductDto) {
		this.flightVstProductDto = flightVstProductDto;
	}
}
