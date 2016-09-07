package com.lvmama.lvfit.adapter.flight.adapter;

import com.lvmama.lvfit.common.dto.adapter.request.FlightBookingRequest;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;

/**
 * 新预订Service
 */
public interface FlightBookingAdapter
{

	/**
	 * 预订
	 * @param 	flightBookingRequest		预订请求对象
	 */
	FitSuppMainOrderDto booking(FlightBookingRequest flightBookingRequest);
	

}
