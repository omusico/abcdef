package com.lvmama.lvf.common.dto.vst;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.VSTEntity;
import com.lvmama.lvf.common.dto.flight.FlightInfoDto;

/**
 * VST基础航班
 */
public class FlightVstBasicFlightDto extends VSTEntity implements Serializable {

	private static final long serialVersionUID = -358226151898575358L;
	
	/** vst返回的基础航班id */
	private Long vstBasicFlightId;
	
	/** 航班号 */
	private String flightNo;
	
	/** vst航空公司id */
	private Long vstCarrierId;
	
	/** vst出发城市id */
	private Long vstDeptCityId;
	
	/** vst到达城市id */
	private Long vstArrvCityId;
	
	/** 出发城市三字码 */
	@JsonIgnore
	private String deptCityCode;
	
	/** 到达城市三字码 */
	@JsonIgnore
	private String arrvCityCode;
	
	/** 出发机场三字码 */
	private String deptAirportCode;
	
	/** 到达机场三字码 */
	private String arrvAirportCode;
	
	/** 对应FlightInfo表的ID */
	private Long flightInfoId;
	
	/** VST机型字典ID */
	private Long vstAirplaneId;

	/** 外键flightInfoId对应flightInfoDto */
	private FlightInfoDto flightInfoDto;
	
	public Long getVstBasicFlightId() {
		return vstBasicFlightId;
	}

	public void setVstBasicFlightId(Long vstBasicFlightId) {
		this.vstBasicFlightId = vstBasicFlightId;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public Long getVstCarrierId() {
		return vstCarrierId;
	}

	public void setVstCarrierId(Long vstCarrierId) {
		this.vstCarrierId = vstCarrierId;
	}

	public Long getVstDeptCityId() {
		return vstDeptCityId;
	}

	public void setVstDeptCityId(Long vstDeptCityId) {
		this.vstDeptCityId = vstDeptCityId;
	}

	public Long getVstArrvCityId() {
		return vstArrvCityId;
	}

	public void setVstArrvCityId(Long vstArrvCityId) {
		this.vstArrvCityId = vstArrvCityId;
	}

	public String getDeptAirportCode() {
		return deptAirportCode;
	}

	public void setDeptAirportCode(String deptAirportCode) {
		this.deptAirportCode = deptAirportCode;
	}

	public String getArrvAirportCode() {
		return arrvAirportCode;
	}

	public void setArrvAirportCode(String arrvAirportCode) {
		this.arrvAirportCode = arrvAirportCode;
	}

	public Long getFlightInfoId() {
		return flightInfoId;
	}

	public void setFlightInfoId(Long flightInfoId) {
		this.flightInfoId = flightInfoId;
	}

	public String getDeptCityCode() {
		return deptCityCode;
	}

	public void setDeptCityCode(String deptCityCode) {
		this.deptCityCode = deptCityCode;
	}

	public String getArrvCityCode() {
		return arrvCityCode;
	}

	public void setArrvCityCode(String arrvCityCode) {
		this.arrvCityCode = arrvCityCode;
	}

	public Long getVstAirplaneId() {
		return vstAirplaneId;
	}

	public void setVstAirplaneId(Long vstAirplaneId) {
		this.vstAirplaneId = vstAirplaneId;
	}

	public FlightInfoDto getFlightInfoDto() {
		return flightInfoDto;
	}

	public void setFlightInfoDto(FlightInfoDto flightInfoDto) {
		this.flightInfoDto = flightInfoDto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((arrvAirportCode == null) ? 0 : arrvAirportCode.hashCode());
		result = prime * result
				+ ((deptAirportCode == null) ? 0 : deptAirportCode.hashCode());
		result = prime * result
				+ ((flightInfoId == null) ? 0 : flightInfoId.hashCode());
		result = prime * result
				+ ((flightNo == null) ? 0 : flightNo.hashCode());
		result = prime * result
				+ ((vstArrvCityId == null) ? 0 : vstArrvCityId.hashCode());
		result = prime * result
				+ ((vstCarrierId == null) ? 0 : vstCarrierId.hashCode());
		result = prime * result
				+ ((vstDeptCityId == null) ? 0 : vstDeptCityId.hashCode());
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
		FlightVstBasicFlightDto other = (FlightVstBasicFlightDto) obj;
		if (arrvAirportCode == null) {
			if (other.arrvAirportCode != null)
				return false;
		} else if (!arrvAirportCode.equals(other.arrvAirportCode))
			return false;
		if (deptAirportCode == null) {
			if (other.deptAirportCode != null)
				return false;
		} else if (!deptAirportCode.equals(other.deptAirportCode))
			return false;
		if (flightInfoId == null) {
			if (other.flightInfoId != null)
				return false;
		} else if (!flightInfoId.equals(other.flightInfoId))
			return false;
		if (flightNo == null) {
			if (other.flightNo != null)
				return false;
		} else if (!flightNo.equals(other.flightNo))
			return false;
		if (vstArrvCityId == null) {
			if (other.vstArrvCityId != null)
				return false;
		} else if (!vstArrvCityId.equals(other.vstArrvCityId))
			return false;
		if (vstCarrierId == null) {
			if (other.vstCarrierId != null)
				return false;
		} else if (!vstCarrierId.equals(other.vstCarrierId))
			return false;
		if (vstAirplaneId == null) {
			if (other.vstAirplaneId != null)
				return false;
		} else if (!vstAirplaneId.equals(other.vstAirplaneId))
			return false;
		if (vstDeptCityId == null) {
			if (other.vstDeptCityId != null)
				return false;
		} else if (!vstDeptCityId.equals(other.vstDeptCityId))
			return false;
		if (getActiveStatus().getActiveStatus() == null) {
			if (other.getActiveStatus().getActiveStatus() != null)
				return false;
		} else if (!getActiveStatus().getActiveStatus().equals(other.getActiveStatus().getActiveStatus()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FlightVstBasicFlightDto [vstBasicFlightId=" + vstBasicFlightId
				+ ", flightNo=" + flightNo + ", vstCarrierId=" + vstCarrierId
				+ ", vstDeptCityId=" + vstDeptCityId + ", vstArrvCityId="
				+ vstArrvCityId + ", deptCityCode=" + deptCityCode
				+ ", arrvCityCode=" + arrvCityCode + ", deptAirportCode="
				+ deptAirportCode + ", arrvAirportCode=" + arrvAirportCode
				+ ", flightInfoId=" + flightInfoId + ", vstAirplaneId="
				+ vstAirplaneId + ", flightInfoDto=" + flightInfoDto + "]";
	}

}
