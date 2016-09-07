package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.flight.FlightAirLineDto;
import com.lvmama.lvf.common.dto.order.FlightOrderOperDto;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderPassengerDto;

/**
 * 供应商预订请求对象
 * @author hedandan
 * @date   2016-1-22
 */
public class SuppBookingRequest implements Serializable 
{
	private static final long serialVersionUID = -6264309781036547799L;
	
	/** 航线信息 */
	private FlightAirLineDto flightAirLine;
	
	/** 乘客信息列表 */
	private List<FlightOrderSuppOrderPassengerDto> suppOrderPassengers = new ArrayList<FlightOrderSuppOrderPassengerDto>();
	
	/** 订单操作者信息 */
	private FlightOrderOperDto flightOrderOper;
	
	/** 总销售价*/
	private BigDecimal suppOrderTotalSalesAmount;
	
	/** 预订请求明细对象列表 */
	private SuppBookingDetailRequest suppBookingDetailRequest = new SuppBookingDetailRequest();
	
//	private FlightOrderSalesOrderRelationRequest relationRequest;

	public FlightAirLineDto getFlightAirLine() {
		return flightAirLine;
	}

	public void setFlightAirLine(FlightAirLineDto flightAirLine) {
		this.flightAirLine = flightAirLine;
	}

	public List<FlightOrderSuppOrderPassengerDto> getSuppOrderPassengers() {
		return suppOrderPassengers;
	}

	public void setSuppOrderPassengers(
			List<FlightOrderSuppOrderPassengerDto> suppOrderPassengers) {
		this.suppOrderPassengers = suppOrderPassengers;
	}

	public FlightOrderOperDto getFlightOrderOper() {
		return flightOrderOper;
	}

	public void setFlightOrderOper(FlightOrderOperDto flightOrderOper) {
		this.flightOrderOper = flightOrderOper;
	}

	public BigDecimal getSuppOrderTotalSalesAmount() {
		return suppOrderTotalSalesAmount;
	}

	public void setSuppOrderTotalSalesAmount(BigDecimal suppOrderTotalSalesAmount) {
		this.suppOrderTotalSalesAmount = suppOrderTotalSalesAmount;
	}

	public SuppBookingDetailRequest getSuppBookingDetailRequest() {
		return suppBookingDetailRequest;
	}

	public void setSuppBookingDetailRequest(
			SuppBookingDetailRequest suppBookingDetailRequest) {
		this.suppBookingDetailRequest = suppBookingDetailRequest;
	}

}
