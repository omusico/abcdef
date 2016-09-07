package com.lvmama.lvf.common.form.policy;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.md.Carrier;
import com.lvmama.lvf.common.dto.md.DateRange;
import com.lvmama.lvf.common.dto.policy.FlightPolicyListDto;
import com.lvmama.lvf.common.dto.supp.Supp;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

public class FlightPolicyListResultForm implements Serializable, Form{

	private static final long serialVersionUID = 4414477913414657452L;
	
	private FlightPolicyListDto flightPolicyListDto;
	
	private String policyEffectDateRange;
	
	private String lastUpdateDate;

	public FlightPolicyListDto getFlightPolicyListDto() {
		return flightPolicyListDto;
	}

	public void setFlightPolicyListDto(FlightPolicyListDto flightPolicyListDto) {
		this.flightPolicyListDto = flightPolicyListDto;
	}

	public PersistenceType getPtype() {
		return flightPolicyListDto.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		flightPolicyListDto.setPtype(ptype);
	}

	public String getSequence() {
		return flightPolicyListDto.getSequence();
	}

	public Long getId() {
		return flightPolicyListDto.getId();
	}

	public void setId(Long id) {
		flightPolicyListDto.setId(id);
	}

	public String getUuid() {
		return flightPolicyListDto.getUuid();
	}

	public void setUuid(String uuid) {
		flightPolicyListDto.setUuid(uuid);
	}

	public Date getCreateTime() {
		return flightPolicyListDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		flightPolicyListDto.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return flightPolicyListDto.getUpdateTime();
	}

	public Carrier getCarrier() {
		return flightPolicyListDto.getCarrier();
	}

	public void setUpdateTime(Date updateTime) {
		flightPolicyListDto.setUpdateTime(updateTime);
	}

	public void setCarrier(Carrier carrier) {
		flightPolicyListDto.setCarrier(carrier);
	}

	public String getIncludeDepartureAirports() {
		return flightPolicyListDto.getIncludeDepartureAirports();
	}

	public void setIncludeDepartureAirports(String includeDepartureAirports) {
		flightPolicyListDto
				.setIncludeDepartureAirports(includeDepartureAirports);
	}

	public String getIncludeArrivalAirports() {
		return flightPolicyListDto.getIncludeArrivalAirports();
	}

	public void setIncludeArrivalAirports(String includeArrivalAirports) {
		flightPolicyListDto.setIncludeArrivalAirports(includeArrivalAirports);
	}

	public Supp getSupp() {
		return flightPolicyListDto.getSupp();
	}

	public void setSupp(Supp supp) {
		flightPolicyListDto.setSupp(supp);
	}

	public String getRouteType() {
		return flightPolicyListDto.getRouteType();
	}

	public void setRouteType(String routeType) {
		flightPolicyListDto.setRouteType(routeType);
	}

	public String getDepartureSeats() {
		return flightPolicyListDto.getDepartureSeats();
	}

	public void setDepartureSeats(String departureSeats) {
		flightPolicyListDto.setDepartureSeats(departureSeats);
	}

	public String getArrivalSeats() {
		return flightPolicyListDto.getArrivalSeats();
	}

	public void setArrivalSeats(String arrivalSeats) {
		flightPolicyListDto.setArrivalSeats(arrivalSeats);
	}

	public DateRange getDepartureDateRange() {
		return flightPolicyListDto.getDepartureDateRange();
	}

	public void setDepartureDateRange(DateRange departureDateRange) {
		flightPolicyListDto.setDepartureDateRange(departureDateRange);
	}

	public String getPolicyEffectDateRange() {
		if (null != flightPolicyListDto && null != flightPolicyListDto.getDepartureDateRange() &&
				null != flightPolicyListDto.getDepartureDateRange().getStartDate() && 
				null != flightPolicyListDto.getDepartureDateRange().getEndDate()) {
			this.policyEffectDateRange =  DateUtils.formatDate(flightPolicyListDto.getDepartureDateRange().getStartDate())+"至"
				+DateUtils.formatDate(flightPolicyListDto.getDepartureDateRange().getStartDate());
		}
		return policyEffectDateRange;
	}

	public void setPolicyEffectDateRange(String policyEffectDateRange) {
		this.policyEffectDateRange = policyEffectDateRange;
	}

	public String getLastUpdateDate() {
		if (null != flightPolicyListDto) {
			this.lastUpdateDate = DateUtils.formatCnHmDate(flightPolicyListDto.getUpdateTime());
		}
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}


}
