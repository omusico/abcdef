package com.lvmama.lvf.common.form.policy;

import java.util.Date;

import com.lvmama.lvf.common.dto.policy.FlightPolicyExcludeDto;
import com.lvmama.lvf.common.form.Form;

public class FlightPolicyExcludeResultForm implements Form{
	
	private Date depDate;

	private FlightPolicyExcludeDto flightPolicyExcludeDto;

	public FlightPolicyExcludeDto getFlightPolicyExcludeDto() {
		return flightPolicyExcludeDto;
	}

	public void setFlightPolicyExcludeDto(
			FlightPolicyExcludeDto flightPolicyExcludeDto) {
		this.flightPolicyExcludeDto = flightPolicyExcludeDto;
	}

	public Long getPolicyId() {
		return flightPolicyExcludeDto.getPolicyId();
	}

	public void setPolicyId(Long policyId) {
		flightPolicyExcludeDto.setPolicyId(policyId);
	}

	public String getFlightNo() {
		return flightPolicyExcludeDto.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		flightPolicyExcludeDto.setFlightNo(flightNo);
	}

	public Long getId() {
		return flightPolicyExcludeDto.getId();
	}

	public Long getDepartureDate() {
		return flightPolicyExcludeDto.getDepartureDate();
	}

	public void setId(Long id) {
		flightPolicyExcludeDto.setId(id);
	}

	public void setDepartureDate(Long departureDate) {
		flightPolicyExcludeDto.setDepartureDate(departureDate);
	}

	public String getUuid() {
		return flightPolicyExcludeDto.getUuid();
	}

	public void setUuid(String uuid) {
		flightPolicyExcludeDto.setUuid(uuid);
	}
	
	public Date getDepDate() {
		return depDate;
	}

	public void setDepDate(Date depDate) {
		this.depDate = depDate;
	}

	
}
