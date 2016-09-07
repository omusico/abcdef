package com.lvmama.lvf.common.dto.flight;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.CombinationType;
import com.lvmama.lvf.common.dto.enums.RouteType;

@XmlRootElement
public class FlightCombinationDto extends AEEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1961388203799876875L;
	private CombinationType combinationType;
	private RouteType routeType;
	private List<FlightCombinationDetailDto> details = new ArrayList<FlightCombinationDetailDto>();
	
	public CombinationType getCombinationType() {
		return combinationType;
	}
	public void setCombinationType(CombinationType combinationType) {
		this.combinationType = combinationType;
	}
	public RouteType getRouteType() {
		return routeType;
	}
	public void setRouteType(RouteType routeType) {
		this.routeType = routeType;
	}
	public List<FlightCombinationDetailDto> getDetails() {
		return details;
	}
	public void setDetails(List<FlightCombinationDetailDto> details) {
		this.details = details;
	}

}
