package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.BaseVSTRequest;
import com.lvmama.lvf.common.dto.status.ActiveStatus;
import com.lvmama.lvf.common.dto.status.BatchFlag;
import com.lvmama.lvf.common.dto.vst.FlightVstGoodsDto;

/**
 * @author lutianyu
 * @date   2015年4月16日
 */
public class FlightVstGoodsRequest extends BaseVSTRequest implements Serializable{
	private static final long serialVersionUID = -4895148146587024667L;

	private FlightVstGoodsDto flightVstGoodsDto = new FlightVstGoodsDto();
	
	public Long getVstGoodsId() {
		return flightVstGoodsDto.getVstGoodsId();
	}

	public void setVstGoodsId(Long vstGoodsId) {
		flightVstGoodsDto.setVstGoodsId(vstGoodsId);
	}

	public Long getVstProductId() {
		return flightVstGoodsDto.getVstProductId();
	}

	public void setVstProductId(Long vstProductId) {
		flightVstGoodsDto.setVstProductId(vstProductId);
	}

	public ActiveStatus getActiveStatus() {
		return flightVstGoodsDto.getActiveStatus();
	}

	public void setActiveStatus(ActiveStatus activeStatus) {
		flightVstGoodsDto.setActiveStatus(activeStatus);
	}

	public BatchFlag getBatchFlag() {
		return flightVstGoodsDto.getBatchFlag();
	}

	public void setBatchFlag(BatchFlag batchFlag) {
		flightVstGoodsDto.setBatchFlag(batchFlag);
	}

	public FlightVstGoodsDto getFlightVstGoodsDto() {
		return flightVstGoodsDto;
	}

	public void setFlightVstGoodsDto(FlightVstGoodsDto flightVstGoodsDto) {
		this.flightVstGoodsDto = flightVstGoodsDto;
	}
	
}
