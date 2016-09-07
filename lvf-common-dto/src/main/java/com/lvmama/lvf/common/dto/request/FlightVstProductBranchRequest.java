package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.BaseVSTRequest;
import com.lvmama.lvf.common.dto.status.BatchFlag;
import com.lvmama.lvf.common.dto.vst.FlightVstProductBranchDto;

public class FlightVstProductBranchRequest extends BaseVSTRequest implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5739766514844829779L;
	
	private FlightVstProductBranchDto flightVstProductBranchDto = new FlightVstProductBranchDto();

	public BatchFlag getBatchFlag() {
		return flightVstProductBranchDto.getBatchFlag();
	}

	public void setBatchFlag(BatchFlag batchFlag) {
		flightVstProductBranchDto.setBatchFlag(batchFlag);
	}

	public Long getVstProductId() {
		return flightVstProductBranchDto.getVstProductId();
	}

	public void setVstProductId(Long vstProductId) {
		flightVstProductBranchDto.setVstProductId(vstProductId);
	}

	public FlightVstProductBranchDto getFlightVstProductBranchDto() {
		return flightVstProductBranchDto;
	}

	public void setFlightVstProductBranchDto(
			FlightVstProductBranchDto flightVstProductBranchDto) {
		this.flightVstProductBranchDto = flightVstProductBranchDto;
	}

}
