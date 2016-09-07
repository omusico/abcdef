package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.booking.FlightOrderRequestRecordDto;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.OrderFlag;
import com.lvmama.lvf.common.dto.status.order.OrderStatus;

public class FlightOrderRequestRecordRequest implements Serializable, Dto {

	private FlightOrderRequestRecordDto flightOrderRequestRecordDto = new FlightOrderRequestRecordDto();
	/**乘机开始日期*/
	private String depTimeBeginTime;
	/**乘机结束日期*/
	private String depTimeEndTime;
	/**下单请求开始时间*/
	private String orderReqBeginTime;
	/**下单请求结束时间*/
	private String orderReqEndTime;
	/**预定来源集合*/
	private List<BookingSource> bookingSources;
	/**账号类型*/
	private OrderFlag orderFlag;
	@Override
	public Long getId() {
		return flightOrderRequestRecordDto.getId();
	}

	public FlightOrderRequestRecordDto getFlightOrderRequestRecordDto() {
		return flightOrderRequestRecordDto;
	}

	public void setFlightOrderRequestRecordDto(
			FlightOrderRequestRecordDto flightOrderRequestRecordDto) {
		this.flightOrderRequestRecordDto = flightOrderRequestRecordDto;
	}
	/**traceNo*/
	public String getTraceNo() {
		return flightOrderRequestRecordDto.getTraceNo();
	}

	public void setTraceNo(String traceNo) {
		flightOrderRequestRecordDto.setTraceNo(traceNo);
	}
	/**航空公司*/
	public String getAirplaneCompanyCode() {
		return flightOrderRequestRecordDto.getAirplaneCompanyCode();
	}

	public void setAirplaneCompanyCode(String airplaneCompanyCode) {
		flightOrderRequestRecordDto.setAirplaneCompanyCode(airplaneCompanyCode);
	}
	/**航班号*/
	public String getFlightNo() {
		return flightOrderRequestRecordDto.getFlightNo();
	}

	public void setFlightNo(String flightNo) {
		flightOrderRequestRecordDto.setFlightNo(flightNo);
	}
	/**预定结果*/
	public OrderStatus getOrderStatus() {
		return flightOrderRequestRecordDto.getOrderStatus();
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		flightOrderRequestRecordDto.setOrderStatus(orderStatus);
	}
	/**出发城市*/
	public String getDepAirportCityCode() {
		return flightOrderRequestRecordDto.getDepAirportCityCode();
	}

	public void setDepAirportCityCode(String depAirportCityCode) {
		flightOrderRequestRecordDto.setDepAirportCityCode(depAirportCityCode);
	}
	/** 到达城市*/
	public String getArrAirportCityCode() {
		return flightOrderRequestRecordDto.getArrAirportCityCode();
	}

	public void setArrAirportCityCode(String arrAirportCityCode) {
		flightOrderRequestRecordDto.setArrAirportCityCode(arrAirportCityCode);
	}
	/**乘机开始日期*/
	public String getDepTimeBeginTime() {
		return depTimeBeginTime;
	}

	public void setDepTimeBeginTime(String depTimeBeginTime) {
		this.depTimeBeginTime = depTimeBeginTime;
	}
	/**乘机结束日期*/
	public String getDepTimeEndTime() {
		return depTimeEndTime;
	}

	public void setDepTimeEndTime(String depTimeEndTime) {
		this.depTimeEndTime = depTimeEndTime;
	}
	/**下单请求开始时间*/
	public String getOrderReqBeginTime() {
		return orderReqBeginTime;
	}

	public void setOrderReqBeginTime(String orderReqBeginTime) {
		this.orderReqBeginTime = orderReqBeginTime;
	}
	/**下单请求结束时间*/
	public String getOrderReqEndTime() {
		return orderReqEndTime;
	}

	public void setOrderReqEndTime(String orderReqEndTime) {
		this.orderReqEndTime = orderReqEndTime;
	}
	/**预定来源集合*/
	public List<BookingSource> getBookingSources() {
		return bookingSources;
	}

	public void setBookingSources(List<BookingSource> bookingSources) {
		this.bookingSources = bookingSources;
	}
	/**订单号*/
	public String getOrderNo() {
		return flightOrderRequestRecordDto.getOrderNo();
	}

	public void setOrderNo(String orderNo) {
		flightOrderRequestRecordDto.setOrderNo(orderNo);
	}
	/**账号类型*/
	public OrderFlag getOrderFlag() {
		return orderFlag;
	}

	public void setOrderFlag(OrderFlag orderFlag) {
		this.orderFlag = orderFlag;
	}
}
