package com.lvmama.lvf.common.dto.flight;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.policy.FlightPolicyDto;

@XmlRootElement
public class FlightCombinationDetailDto extends AEEntity implements Serializable {
	
	private static final long serialVersionUID = -8680100295144035858L;
	
	@FkId
	@XmlTransient
	private FlightCombinationDto flightCombination;
	
	private FlightTripType flightTripType;
	
	private List<FlightInfoDto> flightInfos = new ArrayList<FlightInfoDto>();
	
	private List<FlightPolicyDto> flightPolicys = new ArrayList<FlightPolicyDto>();

	public FlightCombinationDto getFlightCombination() {
		return flightCombination;
	}

	public void setFlightCombination(FlightCombinationDto flightCombination) {
		this.flightCombination = flightCombination;
	}

	public FlightTripType getFlightTripType() {
		return flightTripType;
	}

	public void setFlightTripType(FlightTripType flightTripType) {
		this.flightTripType = flightTripType;
	}

	public List<FlightInfoDto> getFlightInfos() {
		return flightInfos;
	}

	public void setFlightInfos(List<FlightInfoDto> flightInfos) {
		this.flightInfos = flightInfos;
	}

	public List<FlightPolicyDto> getFlightPolicys() {
		return flightPolicys;
	}

	public void setFlightPolicys(List<FlightPolicyDto> flightPolicys) {
		this.flightPolicys = flightPolicys;
	}

	
	
}
