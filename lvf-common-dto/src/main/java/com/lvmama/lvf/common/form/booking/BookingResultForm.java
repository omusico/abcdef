package com.lvmama.lvf.common.form.booking;

import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.PersistenceType;
import com.lvmama.lvf.common.dto.enums.RouteType;
import com.lvmama.lvf.common.dto.order.FlightOrderAgreementDto;
import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;
import com.lvmama.lvf.common.dto.order.FlightOrderCustomerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderDto;
import com.lvmama.lvf.common.dto.order.FlightOrderExpressDto;
import com.lvmama.lvf.common.dto.order.FlightOrderNoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;
import com.lvmama.lvf.common.dto.order.OrderMainDto;
import com.lvmama.lvf.common.dto.order.OrderOpLogDto;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderPaymentDto;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderRefundDto;
import com.lvmama.lvf.common.form.Form;

/**
 * @author lutianyu
 * @date   2015-2-11
 */
public class BookingResultForm implements Form {
	
	private OrderMainDto orderMainDto;
	
	private RouteType routeType;
	
	/** 出发城市名 */
	private String deptCityName;
	
	/** 到达城市名 */
	private String arrvCityName;
	
	private List<ToBookingSegmentForm> flights;

	public BookingResultForm(OrderMainDto orderMainDto) {
		super();
		this.orderMainDto = orderMainDto;
	}

	public OrderMainDto getOrderMainDto() {
		return orderMainDto;
	}

	public void setOrderMainDto(OrderMainDto orderMainDto) {
		this.orderMainDto = orderMainDto;
	}

	public RouteType getRouteType() {
		return routeType;
	}

	public void setRouteType(RouteType routeType) {
		this.routeType = routeType;
	}

	public String getDeptCityName() {
		return deptCityName;
	}

	public void setDeptCityName(String deptCityName) {
		this.deptCityName = deptCityName;
	}

	public String getArrvCityName() {
		return arrvCityName;
	}

	public void setArrvCityName(String arrvCityName) {
		this.arrvCityName = arrvCityName;
	}

	public List<ToBookingSegmentForm> getFlights() {
		return flights;
	}

	public void setFlights(List<ToBookingSegmentForm> flights) {
		this.flights = flights;
	}

	public PersistenceType getPtype() {
		return orderMainDto.getPtype();
	}

	public void setPtype(PersistenceType ptype) {
		orderMainDto.setPtype(ptype);
	}

	public String getSequence() {
		return orderMainDto.getSequence();
	}

	public Long getId() {
		return orderMainDto.getId();
	}

	public void setId(Long id) {
		orderMainDto.setId(id);
	}

	public String getUuid() {
		return orderMainDto.getUuid();
	}

	public void setUuid(String uuid) {
		orderMainDto.setUuid(uuid);
	}

	public Date getCreateTime() {
		return orderMainDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		orderMainDto.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return orderMainDto.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		orderMainDto.setUpdateTime(updateTime);
	}

	public FlightOrderNoDto getFlightOrderNo() {
		return orderMainDto.getFlightOrderNo();
	}

	public void setFlightOrderNo(FlightOrderNoDto flightOrderNo) {
		orderMainDto.setFlightOrderNo(flightOrderNo);
	}

	public FlightOrderCustomerDto getFlightOrderCustomer() {
		return orderMainDto.getFlightOrderCustomer();
	}

	public void setFlightOrderCustomer(
			FlightOrderCustomerDto flightOrderCustomer) {
		orderMainDto.setFlightOrderCustomer(flightOrderCustomer);
	}

	public FlightOrderContacterDto getFlightOrderContacter() {
		return orderMainDto.getFlightOrderContacter();
	}

	public void setFlightOrderContacter(
			FlightOrderContacterDto flightOrderContacter) {
		orderMainDto.setFlightOrderContacter(flightOrderContacter);
	}

	public FlightOrderAgreementDto getFlightOrderAgreement() {
		return orderMainDto.getFlightOrderAgreement();
	}

	public void setFlightOrderAgreement(
			FlightOrderAgreementDto flightOrderAgreement) {
		orderMainDto.setFlightOrderAgreement(flightOrderAgreement);
	}

	public List<FlightOrderPassengerDto> getFlightOrderPassengers() {
		return orderMainDto.getFlightOrderPassengers();
	}

	public void setFlightOrderPassengers(
			List<FlightOrderPassengerDto> flightOrderPassengers) {
		orderMainDto.setFlightOrderPassengers(flightOrderPassengers);
	}

	public FlightOrderExpressDto getFlightOrderExpress() {
		return orderMainDto.getFlightOrderExpress();
	}

	public void setFlightOrderExpress(FlightOrderExpressDto flightOrderExpress) {
		orderMainDto.setFlightOrderExpress(flightOrderExpress);
	}

	public List<OrderOpLogDto> getOrdeOpLogs() {
		return orderMainDto.getOrdeOpLogs();
	}

	public void setOrdeOpLogs(List<OrderOpLogDto> ordeOpLogs) {
		orderMainDto.setOrdeOpLogs(ordeOpLogs);
	}

	public List<FlightOrderDto> getFlightOrders() {
		return orderMainDto.getFlightOrders();
	}

	public void setFlightOrders(List<FlightOrderDto> flightOrders) {
		orderMainDto.setFlightOrders(flightOrders);
	}

	public List<FlightOrderPaymentDto> getFlightOrderPayment() {
		return orderMainDto.getFlightOrderPayment();
	}

	public void setFlightOrderPayment(List<FlightOrderPaymentDto> flightOrderPayment) {
		orderMainDto.setFlightOrderPayment(flightOrderPayment);
	}

	public List<FlightOrderRefundDto> getFlightOrderRefund() {
		return orderMainDto.getFlightOrderRefund();
	}

	public void setFlightOrderRefund(List<FlightOrderRefundDto> flightOrderRefund) {
		orderMainDto.setFlightOrderRefund(flightOrderRefund);
	}
	
	
}