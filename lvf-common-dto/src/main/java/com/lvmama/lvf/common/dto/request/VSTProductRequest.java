package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.vst.FlightVstProductDto;

public class VSTProductRequest implements Serializable {

	private static final long serialVersionUID = 4078765488328781753L;
	
	private FlightVstProductDto vstProductDto ;

	public FlightVstProductDto getVstProductDto() {
		return vstProductDto;
	}

	public void setVstProductDto(FlightVstProductDto vstProductDto) {
		this.vstProductDto = vstProductDto;
	}

}
