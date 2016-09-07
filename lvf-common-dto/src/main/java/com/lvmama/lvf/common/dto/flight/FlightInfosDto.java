package com.lvmama.lvf.common.dto.flight;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.AEEntity;

@XmlRootElement
public class FlightInfosDto extends AEEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4950738348772921747L;

	
	private List<FlightInfoDto> flightInfos = new ArrayList<FlightInfoDto>();


	public List<FlightInfoDto> getFlightInfos() {
		return flightInfos;
	}


	public void setFlightInfos(List<FlightInfoDto> flightInfos) {
		this.flightInfos = flightInfos;
	}
	
	
}
