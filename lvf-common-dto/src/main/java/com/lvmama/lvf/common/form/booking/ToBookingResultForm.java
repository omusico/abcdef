package com.lvmama.lvf.common.form.booking;

import java.util.List;

import com.lvmama.lvf.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;
import com.lvmama.lvf.common.dto.order.FlightOrderExpressDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;
import com.lvmama.lvf.common.form.Form;

/**
 * @author lutianyu
 * @date   2015-2-10
 */
public class ToBookingResultForm implements Form{
	private List<FlightOrderPassengerDto> passengers;
	private List<FlightOrderContacterDto> contacters;
	private List<FlightOrderExpressDto> addresses;
	private List<InsuranceInfoDto> insurances;
	public List<FlightOrderPassengerDto> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<FlightOrderPassengerDto> passengers) {
		this.passengers = passengers;
	}

	public List<FlightOrderContacterDto> getContacters() {
		return contacters;
	}

	public void setContacters(List<FlightOrderContacterDto> contacters) {
		this.contacters = contacters;
	}

	public List<FlightOrderExpressDto> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<FlightOrderExpressDto> addresses) {
		this.addresses = addresses;
	}

	public List<InsuranceInfoDto> getInsurances() {
		return insurances;
	}

	public void setInsurances(List<InsuranceInfoDto> insurances) {
		this.insurances = insurances;
	}
}
