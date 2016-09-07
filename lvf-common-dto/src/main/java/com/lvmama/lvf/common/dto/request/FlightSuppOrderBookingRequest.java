package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.flight.FlightAirLineDto;
import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderPassengerDto;


/**
 * 供应商订单请求对象
 * @author leizhengwei
 * 2015年12月17日
 */
public class FlightSuppOrderBookingRequest implements Serializable 
{
	
	private static final long serialVersionUID = -6264309781036547799L;
	
	/** 航线信息 */
	private FlightAirLineDto flightAirLine;

	/** 供应商订单乘机人信息 */
	private List<FlightOrderSuppOrderPassengerDto> flightOrderSuppOrderPassengers = new ArrayList<FlightOrderSuppOrderPassengerDto>();
	
	/** 供应商订单乘机人信息 */
    private  FlightOrderContacterDto flightOrderContacterDto = new FlightOrderContacterDto(); 	
    
    /** 供应商订单预订详情信息 */
    private FlightOrderBookingDetailRequest flightOrderBookingDetailRequest = new FlightOrderBookingDetailRequest();
    

	public FlightAirLineDto getFlightAirLine() {
		return flightAirLine;
	}

	public void setFlightAirLine(FlightAirLineDto flightAirLine) {
		this.flightAirLine = flightAirLine;
	}

	public List<FlightOrderSuppOrderPassengerDto> getFlightOrderSuppOrderPassengers() {
		return flightOrderSuppOrderPassengers;
	}

	public void setFlightOrderSuppOrderPassengers(
			List<FlightOrderSuppOrderPassengerDto> flightOrderSuppOrderPassengers) {
		this.flightOrderSuppOrderPassengers = flightOrderSuppOrderPassengers;
	}

	public FlightOrderContacterDto getFlightOrderContacterDto() {
		return flightOrderContacterDto;
	}

	public void setFlightOrderContacterDto(
			FlightOrderContacterDto flightOrderContacterDto) {
		this.flightOrderContacterDto = flightOrderContacterDto;
	}

	public FlightOrderBookingDetailRequest getFlightOrderBookingDetailRequest() {
		return flightOrderBookingDetailRequest;
	}

	public void setFlightOrderBookingDetailRequest(
			FlightOrderBookingDetailRequest flightOrderBookingDetailRequest) {
		this.flightOrderBookingDetailRequest = flightOrderBookingDetailRequest;
	}
    
    
	
	
}
