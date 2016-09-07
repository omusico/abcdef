package com.lvmama.lvf.common.dto.supp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.enums.RouteType;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightCombinationDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderFlightInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPNRInfoDto;

/**
 * 
 * @author xumeng
 * 供应商订单详情DTO
 */
public class FlightSupOrderDetailViewDto implements Serializable{
	
	private FlightSupOrderDto flightSupOrderDto = new FlightSupOrderDto();
	/** 线路信息 */
	private RouteType routeType;
	/** 订单航班信息 */
	private List<FlightOrderFlightInfoDto> flightOrderFlightInfos;
	/**供应商订单客规明细相关*/
	List<FlightOrderFlightCombinationDetailDto> orderFlightCombinationDetails = new ArrayList<FlightOrderFlightCombinationDetailDto>();
	/**供应商订单票号相应信息*/
	List<FlightOrderSuppOrderTicketInfoDto> flightOrderSuppOrderTicketInfoDtos = new ArrayList<FlightOrderSuppOrderTicketInfoDto>();
	List<FlightOrderSuppOrderDetailDto> flightOrderSuppOrderDetailDtos = new ArrayList<FlightOrderSuppOrderDetailDto>();
	public Long getOrderId() {
		return flightSupOrderDto.getOrderId();
	}
	
	public void setOrderId(Long orderId) {
		flightSupOrderDto.setOrderId(orderId);
	}

	/**支付方式*/
	public List<PaymentType> getPaymentTypes() {
		return flightSupOrderDto.getPaymentTypes();
	}

	public void setCreateTime(Date createTime) {
		flightSupOrderDto.setCreateTime(createTime);
	}

	public void setSuppOrderLvNo(String suppOrderLvNo) {
		flightSupOrderDto.setSuppOrderLvNo(suppOrderLvNo);
	}

	public void setSuppOfficeNo(String suppOfficeNo) {
		flightSupOrderDto.setSuppOfficeNo(suppOfficeNo);
	}

	public void setFlightOrderSuppOrderPassengers(
			List<FlightOrderSuppOrderPassengerDto> flightOrderSuppOrderPassengers) {
		flightSupOrderDto
				.setFlightOrderSuppOrderPassengers(flightOrderSuppOrderPassengers);
	}

	public void setPaymentTypes(List<PaymentType> paymentTypes) {
		flightSupOrderDto.setPaymentTypes(paymentTypes);
	}

	public Date getCreateTime() {
		return flightSupOrderDto.getCreateTime();
	}

	public String getSuppOrderLvNo() {
		return flightSupOrderDto.getSuppOrderLvNo();
	}

	public String getSuppOfficeNo() {
		return flightSupOrderDto.getSuppOfficeNo();
	}

	public List<FlightOrderSuppOrderPassengerDto> getFlightOrderSuppOrderPassengers() {
		return flightSupOrderDto.getFlightOrderSuppOrderPassengers();
	}
 
	public void setSupp(Supp supp) {
		flightSupOrderDto.setSupp(supp);
	}

	public void setSuppOrderNo(String suppOrderNo) {
		flightSupOrderDto.setSuppOrderNo(suppOrderNo);
	}

	public void setFlightOrderPNRInfo(FlightOrderPNRInfoDto flightOrderPNRInfo) {
		flightSupOrderDto.setFlightOrderPNRInfo(flightOrderPNRInfo);
	}

	public void setFlightOrderSuppOrderAmount(
			FlightOrderSuppOrderAmountDto flightOrderSuppOrderAmount) {
		flightSupOrderDto
				.setFlightOrderSuppOrderAmount(flightOrderSuppOrderAmount);
	}

	public FlightOrderSuppOrderAmountDto getFlightOrderSuppOrderAmount() {
		return flightSupOrderDto.getFlightOrderSuppOrderAmount();
	}

	public Supp getSupp() {
		return flightSupOrderDto.getSupp();
	}

	public String getSuppOrderNo() {
		return flightSupOrderDto.getSuppOrderNo();
	}

	public FlightOrderPNRInfoDto getFlightOrderPNRInfo() {
		return flightSupOrderDto.getFlightOrderPNRInfo();
	}

	public FlightOrderSuppOrderStatusDto getFlightOrderSuppOrderStatus() {
		return flightSupOrderDto.getFlightOrderSuppOrderStatus();
	}

	public void setFlightOrderSuppOrderStatus(
			FlightOrderSuppOrderStatusDto flightOrderSuppOrderStatus) {
		flightSupOrderDto
				.setFlightOrderSuppOrderStatus(flightOrderSuppOrderStatus);
	}

	public List<FlightOrderFlightCombinationDetailDto> getOrderFlightCombinationDetails() {
		return orderFlightCombinationDetails;
	}

	public void setOrderFlightCombinationDetails(
			List<FlightOrderFlightCombinationDetailDto> orderFlightCombinationDetails) {
		this.orderFlightCombinationDetails = orderFlightCombinationDetails;
	}

	public List<FlightOrderSuppOrderTicketInfoDto> getFlightOrderSuppOrderTicketInfoDtos() {
		return flightOrderSuppOrderTicketInfoDtos;
	}

	public void setFlightOrderSuppOrderTicketInfoDtos(
			List<FlightOrderSuppOrderTicketInfoDto> flightOrderSuppOrderTicketInfoDtos) {
		this.flightOrderSuppOrderTicketInfoDtos = flightOrderSuppOrderTicketInfoDtos;
	}

	public List<FlightOrderSuppOrderDetailDto> getFlightOrderSuppOrderDetailDtos() {
		return flightOrderSuppOrderDetailDtos;
	}

	public void setFlightOrderSuppOrderDetailDtos(
			List<FlightOrderSuppOrderDetailDto> flightOrderSuppOrderDetailDtos) {
		this.flightOrderSuppOrderDetailDtos = flightOrderSuppOrderDetailDtos;
	}

	public List<FlightOrderFlightInfoDto> getFlightOrderFlightInfos() {
		return flightOrderFlightInfos;
	}

	public void setFlightOrderFlightInfos(
			List<FlightOrderFlightInfoDto> flightOrderFlightInfos) {
		this.flightOrderFlightInfos = flightOrderFlightInfos;
	}

	public RouteType getRouteType() {
		return routeType;
	}

	public void setRouteType(RouteType routeType) {
		this.routeType = routeType;
	}
}
