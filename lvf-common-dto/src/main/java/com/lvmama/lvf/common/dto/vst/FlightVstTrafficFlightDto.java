/**
 * 
 */
package com.lvmama.lvf.common.dto.vst;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.VSTEntity;

/**
 * 产品航班信息
 * @author lven
 *
 */
public class FlightVstTrafficFlightDto extends VSTEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** VST产品航班信息ID*/
	private Long vstTrafficFlightId;
	
	/** VST产品ID*/
	private Long vstProductId;
	
	/** 航班*/
	private Long vstFlightId;
	
	/** VST产品组ID*/
	private Long vstGroupId;
	
	/** 默认单程 */
	private String tripType;
	
	/** 基础航班信息*/
	private FlightVstBasicFlightDto vstBasicFlightDto;

	public Long getVstProductId() {
		return vstProductId;
	}

	public void setVstProductId(Long vstProductId) {
		this.vstProductId = vstProductId;
	}


	public Long getVstGroupId() {
		return vstGroupId;
	}

	public void setVstGroupId(Long vstGroupId) {
		this.vstGroupId = vstGroupId;
	}

	public String getTripType() {
		return tripType;
	}

	public void setTripType(String tripType) {
		this.tripType = tripType;
	}

	public Long getVstTrafficFlightId() {
		return vstTrafficFlightId;
	}

	public void setVstTrafficFlightId(Long vstTrafficFlightId) {
		this.vstTrafficFlightId = vstTrafficFlightId;
	}

	public Long getVstFlightId() {
		return vstFlightId;
	}

	public void setVstFlightId(Long vstFlightId) {
		this.vstFlightId = vstFlightId;
	}
	
	public FlightVstBasicFlightDto getVstBasicFlightDto() {
		return vstBasicFlightDto;
	}

	public void setVstBasicFlightDto(FlightVstBasicFlightDto vstBasicFlightDto) {
		this.vstBasicFlightDto = vstBasicFlightDto;
	}

	@Override
	public String toString() {
		return "FlightVstTrafficFlightDto [vstTrafficFlightId="
				+ vstTrafficFlightId + ", vstProductId=" + vstProductId
				+ ", vstFlightId=" + vstFlightId + ", vstGroupId=" + vstGroupId
				+ ", tripType=" + tripType + ", vstBasicFlightDto="
				+ vstBasicFlightDto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((tripType == null) ? 0 : tripType.hashCode());
		result = prime * result
				+ ((vstFlightId == null) ? 0 : vstFlightId.hashCode());
		result = prime * result
				+ ((vstProductId == null) ? 0 : vstProductId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightVstTrafficFlightDto other = (FlightVstTrafficFlightDto) obj;
		if (tripType == null) {
			if (other.tripType != null)
				return false;
		} else if (!tripType.equals(other.tripType))
			return false;
		if (vstFlightId == null) {
			if (other.vstFlightId != null)
				return false;
		} else if (!vstFlightId.equals(other.vstFlightId))
			return false;
		if (vstProductId == null) {
			if (other.vstProductId != null)
				return false;
		} else if (!vstProductId.equals(other.vstProductId))
			return false;
		if (getActiveStatus().getActiveStatus() == null) {
			if (other.getActiveStatus().getActiveStatus() != null)
				return false;
		} else if (!getActiveStatus().getActiveStatus().equals(other.getActiveStatus().getActiveStatus()))
			return false;
		return true;
	} 
	
}
