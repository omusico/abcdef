package com.lvmama.lvf.common.form.booking;

import java.math.BigDecimal;
import java.util.List;

import com.lvmama.lvf.common.dto.flight.FlightAirLineDto;
import com.lvmama.lvf.common.dto.order.FlightOrderOperDto;
import com.lvmama.lvf.common.dto.request.SuppBookingDetailRequest;
import com.lvmama.lvf.common.dto.request.SuppBookingRequest;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderPassengerDto;
import com.lvmama.lvf.common.form.Form;


/**
 * 供应商下单预定填写页请求FORM
 * 
 */
public class SuppBookingInputForm implements Form {
    SuppBookingRequest request = new SuppBookingRequest();

	public SuppBookingRequest getRequest() {
		return request;
	}

	public void setRequest(SuppBookingRequest request) {
		this.request = request;
	}

	public FlightAirLineDto getFlightAirLine() {
		return request.getFlightAirLine();
	}

	public void setFlightAirLine(FlightAirLineDto flightAirLine) {
		request.setFlightAirLine(flightAirLine);
	}

	public FlightOrderOperDto getFlightOrderOper() {
		return request.getFlightOrderOper();
	}

	public void setFlightOrderOper(FlightOrderOperDto flightOrderOper) {
		request.setFlightOrderOper(flightOrderOper);
	}

	public BigDecimal getSuppOrderTotalSalesAmount() {
		return request.getSuppOrderTotalSalesAmount();
	}

	public void setSuppOrderTotalSalesAmount(
			BigDecimal suppOrderTotalSalesAmount) {
		request.setSuppOrderTotalSalesAmount(suppOrderTotalSalesAmount);
	}

	public List<FlightOrderSuppOrderPassengerDto> getSuppOrderPassengers() {
		return request.getSuppOrderPassengers();
	}

	public void setSuppOrderPassengers(
			List<FlightOrderSuppOrderPassengerDto> suppOrderPassengers) {
		request.setSuppOrderPassengers(suppOrderPassengers);
	}

	public SuppBookingDetailRequest getSuppBookingDetailRequest() {
		return request.getSuppBookingDetailRequest();
	}

	public void setSuppBookingDetailRequest(
			SuppBookingDetailRequest suppBookingDetailRequest) {
		request.setSuppBookingDetailRequest(suppBookingDetailRequest);
	}


}