package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.FlightOrderFlightCombinationDetailType;
import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.enums.PassengerType;

/**
 * 订单航班组合明细信息
 * @author majun
 * @date   2015-1-13
 */
public class FlightOrderFlightCombinationDetailDto extends Entity implements Serializable 
{
	private static final long serialVersionUID = 184882718366213287L;
	
	/** 订单航班组合主表主键 */
	private Long combinationId;

	/** 航程类型 */
	private FlightTripType flightTripType;
	
	/** 订单航班组合明细类型 */
	private FlightOrderFlightCombinationDetailType combinationDetailType = FlightOrderFlightCombinationDetailType.NORMAL;
	
	/** 乘客类型 */
	private PassengerType passengerType;
	
	/** 订单航班信息*/
	private FlightOrderFlightInfoDto flightOrderFlightInfo;
	
	/** 订单航班政策信息 */
	private FlightOrderFlightPolicyDto flightOrderFlightPolicy;
	
	/** 订单客规 */
	private FlightOrderTicketRuleDto flightOrderTicketRule;
	
	public Long getCombinationId() {
		return combinationId;
	}

	public void setCombinationId(Long combinationId) {
		this.combinationId = combinationId;
	}

	public FlightTripType getFlightTripType() {
		return flightTripType;
	}

	public void setFlightTripType(FlightTripType flightTripType) {
		this.flightTripType = flightTripType;
	}

	public FlightOrderFlightCombinationDetailType getCombinationDetailType() {
		return combinationDetailType;
	}

	public void setCombinationDetailType(
			FlightOrderFlightCombinationDetailType combinationDetailType) {
		this.combinationDetailType = combinationDetailType;
	}
	
	public PassengerType getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}

	public FlightOrderFlightInfoDto getFlightOrderFlightInfo() {
		return flightOrderFlightInfo;
	}

	public void setFlightOrderFlightInfo(
			FlightOrderFlightInfoDto flightOrderFlightInfo) {
		this.flightOrderFlightInfo = flightOrderFlightInfo;
	}

	public FlightOrderFlightPolicyDto getFlightOrderFlightPolicy() {
		return flightOrderFlightPolicy;
	}

	public void setFlightOrderFlightPolicy(
			FlightOrderFlightPolicyDto flightOrderFlightPolicy) {
		this.flightOrderFlightPolicy = flightOrderFlightPolicy;
	}
	
	public FlightOrderTicketRuleDto getFlightOrderTicketRule() {
		return flightOrderTicketRule;
	}

	public void setFlightOrderTicketRule(
			FlightOrderTicketRuleDto flightOrderTicketRule) {
		this.flightOrderTicketRule = flightOrderTicketRule;
	}
	
	@Override
	@JsonIgnore
	public String getSequence() {
		return "S_FORD_FLIGHT_COMBI_DETAIL";
	}

}
