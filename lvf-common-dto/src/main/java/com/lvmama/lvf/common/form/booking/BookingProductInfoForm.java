package com.lvmama.lvf.common.form.booking;

import java.util.List;

import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.form.Form;

public class BookingProductInfoForm implements Form{
	private FlightTripType flightTripType;

	private List<ToBookingProductPriceForm> productPrices;

	public FlightTripType getFlightTripType() {
		return flightTripType;
	}

	public void setFlightTripType(FlightTripType flightTripType) {
		this.flightTripType = flightTripType;
	}

	public List<ToBookingProductPriceForm> getProductPrices() {
		return productPrices;
	}

	public void setProductPrices(List<ToBookingProductPriceForm> productPrices) {
		this.productPrices = productPrices;
	}
	
	
}
