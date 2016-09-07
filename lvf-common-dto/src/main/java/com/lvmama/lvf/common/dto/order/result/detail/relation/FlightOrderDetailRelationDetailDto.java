package com.lvmama.lvf.common.dto.order.result.detail.relation;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.flight.FlightAirportLineDto;
import com.lvmama.lvf.common.dto.md.TimeSegmentRange;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;

/**
 * 订单详情关联详细信息
 * @author majun
 * @date   2015-3-17
 */
public class FlightOrderDetailRelationDetailDto implements Serializable
{
	private static final long serialVersionUID = 8038448210463351235L;

	/**航程类型*/
	private FlightTripType flightType;
	
	/** 航段时间范围信息 */
	private TimeSegmentRange timeSegmentRange;
	
	/** 机场线路信息*/
	private FlightAirportLineDto flightAirportLine;
	
	/** 乘客类型*/
	private List<PassengerType> passengerTypes;
	
	/** 乘客数量 */
	private List<Integer> passengerCounts;
	
	/** 乘客列表 */
	private List<FlightOrderPassengerDto> passengerDtos;

	public FlightTripType getFlightType() {
		return flightType;
	}

	public void setFlightType(FlightTripType flightType) {
		this.flightType = flightType;
	}

	public TimeSegmentRange getTimeSegmentRange() {
		return timeSegmentRange;
	}

	public void setTimeSegmentRange(TimeSegmentRange timeSegmentRange) {
		this.timeSegmentRange = timeSegmentRange;
	}

	public FlightAirportLineDto getFlightAirportLine() {
		return flightAirportLine;
	}

	public void setFlightAirportLine(FlightAirportLineDto flightAirportLine) {
		this.flightAirportLine = flightAirportLine;
	}

	public List<PassengerType> getPassengerTypes() {
		return passengerTypes;
	}

	public void setPassengerTypes(List<PassengerType> passengerTypes) {
		this.passengerTypes = passengerTypes;
	}

	public List<Integer> getPassengerCounts() {
		return passengerCounts;
	}

	public void setPassengerCounts(List<Integer> passengerCounts) {
		this.passengerCounts = passengerCounts;
	}

	public List<FlightOrderPassengerDto> getPassengerDtos() {
		return passengerDtos;
	}

	public void setPassengerDtos(List<FlightOrderPassengerDto> passengerDtos) {
		this.passengerDtos = passengerDtos;
	}
}
