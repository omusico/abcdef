package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.BaseVSTRequest;
import com.lvmama.lvf.common.dto.status.BatchFlag;
import com.lvmama.lvf.common.dto.vst.FlightVstBasicFlightDto;

/**
 * @author lutianyu
 * @date   2015年4月20日
 */
public class FlightVstBizFlightRequest extends BaseVSTRequest implements Serializable {
	private static final long serialVersionUID = 2434259284371731855L;
	
	private FlightVstBasicFlightDto flightVstBizFlightDto = new FlightVstBasicFlightDto();

	public Long getVstBasicFlightId() {
		return flightVstBizFlightDto.getVstBasicFlightId();
	}

	public void setVstBasicFlightId(Long vstBasicFlightId) {
		flightVstBizFlightDto.setVstBasicFlightId(vstBasicFlightId);
	}

	public BatchFlag getBatchFlag() {
		return flightVstBizFlightDto.getBatchFlag();
	}

	public void setBatchFlag(BatchFlag batchFlag) {
		flightVstBizFlightDto.setBatchFlag(batchFlag);
	}

	public FlightVstBasicFlightDto getFlightVstBizFlightDto() {
		return flightVstBizFlightDto;
	}

	public void setFlightVstBizFlightDto(
			FlightVstBasicFlightDto flightVstBizFlightDto) {
		this.flightVstBizFlightDto = flightVstBizFlightDto;
	}
}
