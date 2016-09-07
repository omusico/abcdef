package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.md.Carrier;
import com.lvmama.lvf.common.dto.supp.Supp;

public class FlightPolicyListRequest implements Serializable,Dto{

	private static final long serialVersionUID = 5075231203241983935L;

	private Supp supp;
	
	private Carrier carrier;
	
	private String departureAirport;
	
	private String arrivalAirport;
	
	private String startUpdateTime;
	
	private String endUpdateTime;
	
	public Supp getSupp() {
		return supp;
	}

	public void setSupp(Supp supp) {
		this.supp = supp;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public String getStartUpdateTime() {
		return startUpdateTime;
	}

	public void setStartUpdateTime(String startUpdateTime) {
		this.startUpdateTime = startUpdateTime;
	}

	public String getEndUpdateTime() {
		return endUpdateTime;
	}

	public void setEndUpdateTime(String endUpdateTime) {
		this.endUpdateTime = endUpdateTime;
	}

	@JsonIgnore
	@Override
	public Long getId() {
		return null;
	}


}
