package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.flight.FlightAirLineDto;
import com.lvmama.lvf.common.dto.order.status.FlightOrderStatusDto;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderDto;

/**
 * 订单查询列表DTO
 * 
 */
public class FlightOrderQueryDto extends Entity implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 订单主键 */
	private Long orderId;

	/** 订单号信息 */
	private FlightOrderNoDto flightOrderNo;
	
	/** 订单对应客户信息 */
	private FlightOrderCustomerDto flightOrderCustomer;

	/** 订单联系人信息 */
	private FlightOrderContacterDto flightOrderContacter;
	
	/** 乘客信息 */
	private FlightOrderPassengerDto flightOrderPassenger;

	/** PNR信息 */
	private FlightOrderPNRInfoDto flightOrderPNRInfo;
	
	/** 订单对应票价、乘机人相关信息 */
	private FlightOrderTicketInfoDto flightOrderTicketInfoDto;
	
	/** 订单航班信息 */
	private FlightOrderFlightInfoDto flightOrderFlightInfo;

	/** 订单状态 */
	private FlightOrderStatusDto flightOrderStatus;
	
	/**子订单信息*/
	private FlightOrderLinkInfoDto flightOrderLinkInfoDto;
	
	/**供应商订单信息*/
	private FlightOrderSuppOrderDto flightOrderSuppOrderDto;
	
	/** 航线信息 */
	private FlightAirLineDto flightAirLine; 
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public FlightOrderNoDto getFlightOrderNo() {
		return flightOrderNo;
	}

	public void setFlightOrderNo(FlightOrderNoDto flightOrderNo) {
		this.flightOrderNo = flightOrderNo;
	}

	public FlightOrderContacterDto getFlightOrderContacter() {
		return flightOrderContacter;
	}

	public void setFlightOrderContacter(FlightOrderContacterDto flightOrderContacter) {
		this.flightOrderContacter = flightOrderContacter;
	}

	public FlightOrderPNRInfoDto getFlightOrderPNRInfo() {
		return flightOrderPNRInfo;
	}

	public void setFlightOrderPNRInfo(FlightOrderPNRInfoDto flightOrderPNRInfo) {
		this.flightOrderPNRInfo = flightOrderPNRInfo;
	}

	public FlightOrderPassengerDto getFlightOrderPassenger() {
		return flightOrderPassenger;
	}

	public void setFlightOrderPassenger(FlightOrderPassengerDto flightOrderPassenger) {
		this.flightOrderPassenger = flightOrderPassenger;
	}

	public FlightOrderStatusDto getFlightOrderStatus() {
		return flightOrderStatus;
	}

	public void setFlightOrderStatus(FlightOrderStatusDto flightOrderStatus) {
		this.flightOrderStatus = flightOrderStatus;
	}

	public FlightOrderFlightInfoDto getFlightOrderFlightInfo() {
		return flightOrderFlightInfo;
	}

	public void setFlightOrderFlightInfo(
			FlightOrderFlightInfoDto flightOrderFlightInfo) {
		this.flightOrderFlightInfo = flightOrderFlightInfo;
	}

	public FlightOrderTicketInfoDto getFlightOrderTicketInfoDto() {
		return flightOrderTicketInfoDto;
	}

	public void setFlightOrderTicketInfoDto(
			FlightOrderTicketInfoDto flightOrderTicketInfoDto) {
		this.flightOrderTicketInfoDto = flightOrderTicketInfoDto;
	}

	public FlightOrderCustomerDto getFlightOrderCustomer() {
		return flightOrderCustomer;
	}

	public void setFlightOrderCustomer(FlightOrderCustomerDto flightOrderCustomer) {
		this.flightOrderCustomer = flightOrderCustomer;
	}

	public FlightOrderLinkInfoDto getFlightOrderLinkInfoDto() {
		return flightOrderLinkInfoDto;
	}

	public void setFlightOrderLinkInfoDto(
			FlightOrderLinkInfoDto flightOrderLinkInfoDto) {
		this.flightOrderLinkInfoDto = flightOrderLinkInfoDto;
	}

	public FlightOrderSuppOrderDto getFlightOrderSuppOrderDto() {
		return flightOrderSuppOrderDto;
	}

	public void setFlightOrderSuppOrderDto(
			FlightOrderSuppOrderDto flightOrderSuppOrderDto) {
		this.flightOrderSuppOrderDto = flightOrderSuppOrderDto;
	}

	public FlightAirLineDto getFlightAirLine() {
		return flightAirLine;
	}

	public void setFlightAirLine(FlightAirLineDto flightAirLine) {
		this.flightAirLine = flightAirLine;
	}
	
    
}
