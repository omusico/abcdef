package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.BaseVSTRequest;
import com.lvmama.lvf.common.dto.status.BatchFlag;
import com.lvmama.lvf.common.dto.vst.FlightVstTrafficFlightDto;

public class TrafficFlightRequest extends BaseVSTRequest implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5739766514844829779L;
	
	private FlightVstTrafficFlightDto flightVstTrafficFlightDto = new FlightVstTrafficFlightDto();

	public BatchFlag getBatchFlag() {
		return flightVstTrafficFlightDto.getBatchFlag();
	}

	public void setBatchFlag(BatchFlag batchFlag) {
		flightVstTrafficFlightDto.setBatchFlag(batchFlag);
	}

	public Long getVstProductId() {
		return flightVstTrafficFlightDto.getVstProductId();
	}

	public void setVstProductId(Long vstProductId) {
		flightVstTrafficFlightDto.setVstProductId(vstProductId);
	}

	public Long getVstGroupId() {
		return flightVstTrafficFlightDto.getVstGroupId();
	}

	public void setVstGroupId(Long vstGroupId) {
		flightVstTrafficFlightDto.setVstGroupId(vstGroupId);
	}
}
