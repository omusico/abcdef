package com.lvmama.lvfit.common.dto.adapter.request;

import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.FitFlightBookingType;
import com.lvmama.lvfit.common.dto.enums.RouteType;
import com.lvmama.lvfit.common.dto.order.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

/**
 * 请求机票单品预订Request
 */
public class FlightBookingRequest implements Serializable {

	private static final long serialVersionUID = -2052602152896571667L;

	/** 交通+X 默认机票往返 */
	private RouteType routeType = RouteType.RT;

	/** 航班信息 */
	private List<FitOrderFlightDto> fitOrderFlightDtoList = new ArrayList<FitOrderFlightDto>();

	/** 客户信息 */
	private FitOrderCustomerDto fitOrderCustomerDto;

	/** 联系人 */
	private FitOrderContacterDto fitOrderContacterDto;

	/** 乘客 */
	private List<FitOrderPassengerDto> fitOrderPassengerDtoList = new ArrayList<FitOrderPassengerDto>();

	/** 订单备注 */
	private List<FitOrderRemarkDto> fitOrderRemarkDtoList = new ArrayList<FitOrderRemarkDto>();

	private BigDecimal orderTotalSalesAmount;

	private FitSuppMainOrderDto fitSuppMainOrderDto;

	/** 订单预订来源 */
	private BookingSource bookingSource;
	
	/** 机+X机票预订方式  */
	private FitFlightBookingType fitFlightBookingType; 

	public RouteType getRouteType() {
		return routeType;
	}

	public void setRouteType(RouteType routeType) {
		this.routeType = routeType;
	}

	public List<FitOrderFlightDto> getFitOrderFlightDtoList() {
		return fitOrderFlightDtoList;
	}

	public void setFitOrderFlightDtoList(List<FitOrderFlightDto> fitOrderFlightDtoList) {
		this.fitOrderFlightDtoList = fitOrderFlightDtoList;
	}

	public FitOrderCustomerDto getFitOrderCustomerDto() {
		return fitOrderCustomerDto;
	}

	public void setFitOrderCustomerDto(FitOrderCustomerDto fitOrderCustomerDto) {
		this.fitOrderCustomerDto = fitOrderCustomerDto;
	}

	public FitOrderContacterDto getFitOrderContacterDto() {
		return fitOrderContacterDto;
	}

	public void setFitOrderContacterDto(FitOrderContacterDto fitOrderContacterDto) {
		this.fitOrderContacterDto = fitOrderContacterDto;
	}

	public List<FitOrderPassengerDto> getFitOrderPassengerDtoList() {
		return fitOrderPassengerDtoList;
	}

	public void setFitOrderPassengerDtoList(List<FitOrderPassengerDto> fitOrderPassengerDtoList) {
		this.fitOrderPassengerDtoList = fitOrderPassengerDtoList;
	}

	public List<FitOrderRemarkDto> getFitOrderRemarkDtoList() {
		return fitOrderRemarkDtoList;
	}

	public void setFitOrderRemarkDtoList(List<FitOrderRemarkDto> fitOrderRemarkDtoList) {
		this.fitOrderRemarkDtoList = fitOrderRemarkDtoList;
	}

	public BigDecimal getOrderTotalSalesAmount() {
		return orderTotalSalesAmount;
	}

	public void setOrderTotalSalesAmount(BigDecimal orderTotalSalesAmount) {
		this.orderTotalSalesAmount = orderTotalSalesAmount;
	}

	public FitSuppMainOrderDto getFitSuppMainOrderDto() {
		return fitSuppMainOrderDto;
	}

	public void setFitSuppMainOrderDto(FitSuppMainOrderDto fitSuppMainOrderDto) {
		this.fitSuppMainOrderDto = fitSuppMainOrderDto;
	}

	public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}

	public FitFlightBookingType getFitFlightBookingType() {
		return fitFlightBookingType;
	}

	public void setFitFlightBookingType(FitFlightBookingType fitFlightBookingType) {
		this.fitFlightBookingType = fitFlightBookingType;
	}
	
}
