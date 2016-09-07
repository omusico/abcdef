/**
 * 
 */
package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.BaseVSTRequest;
import com.lvmama.lvf.common.dto.status.BatchFlag;
import com.lvmama.lvf.common.dto.vst.FlightVstGoodsTimePriceDto;

/**
 * @author lven
 *
 */
public class FlightVstGoodsTimePriceRequest extends BaseVSTRequest implements Serializable{
	private static final long serialVersionUID = -782760597235535125L;

	private FlightVstGoodsTimePriceDto flightVstGoodsTimePriceDto = new FlightVstGoodsTimePriceDto();

	public BatchFlag getBatchFlag() {
		return flightVstGoodsTimePriceDto.getBatchFlag();
	}

	public Long getVstGoodsId() {
		return flightVstGoodsTimePriceDto.getVstGoodsId();
	}

	public void setVstGoodsId(Long vstGoodsId) {
		flightVstGoodsTimePriceDto.setVstGoodsId(vstGoodsId);
	}

	public void setBatchFlag(BatchFlag batchFlag) {
		flightVstGoodsTimePriceDto.setBatchFlag(batchFlag);
	}

	public FlightVstGoodsTimePriceDto getFlightVstGoodsTimePriceDto() {
		return flightVstGoodsTimePriceDto;
	}

	public void setFlightVstGoodsTimePriceDto(
			FlightVstGoodsTimePriceDto flightVstGoodsTimePriceDto) {
		this.flightVstGoodsTimePriceDto = flightVstGoodsTimePriceDto;
	}
	
}
