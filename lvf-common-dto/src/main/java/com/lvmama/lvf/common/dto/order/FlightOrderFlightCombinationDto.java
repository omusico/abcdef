package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.CombinationType;
import com.lvmama.lvf.common.dto.enums.RouteType;
import com.lvmama.lvf.common.dto.flight.FlightAirLineDto;

/**
 * 订单航班组合主信息
 * @author majun
 * @date   2015-1-19
 */
@XmlRootElement
public class FlightOrderFlightCombinationDto extends Entity implements Serializable 
{
	private static final long serialVersionUID = -1660933870016528462L;
	
	/** 主订单主键 */
	private Long orderMainId;
	
	/** 航线信息 */
	private FlightAirLineDto flightAirLine; 
	
	/** 组合类型 */
	private CombinationType combinationType = CombinationType.AUTO;
	
	/** 航线类型 */
	private RouteType routeType;

	/** 订单航班组合明细信息 */
	private List<FlightOrderFlightCombinationDetailDto> details = new ArrayList<FlightOrderFlightCombinationDetailDto>();
	
	private String isSupp;
	
	public Long getOrderMainId() {
		return orderMainId;
	}

	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}

	public FlightAirLineDto getFlightAirLine() {
		return flightAirLine;
	}

	public void setFlightAirLine(FlightAirLineDto flightAirLine) {
		this.flightAirLine = flightAirLine;
	}

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

	public List<FlightOrderFlightCombinationDetailDto> getDetails() {
		return details;
	}

	public void setDetails(List<FlightOrderFlightCombinationDetailDto> details) {
		this.details = details;
	}
	
	@Override
	@JsonIgnore
	public String getSequence() {
		return "S_FORD_FLIGHT_COMBI";
	}

	public String getIsSupp() {
		return isSupp;
	}

	public void setIsSupp(String isSupp) {
		this.isSupp = isSupp;
	}
}
