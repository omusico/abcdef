package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderPaymentDto;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderRefundDto;

/**
 * 主订单信息
 * @author majun
 * @date   2015-3-9
 */
public class OrderMainDto extends Entity implements Serializable , Dto
{
	private static final long serialVersionUID = -9032877247896121732L;

	/** 订单号信息(主单) */
	private FlightOrderNoDto flightOrderNo;
	
	/** 订单客户信息 */
	private FlightOrderCustomerDto flightOrderCustomer;
	
	/** 订单联系人信息 */
	private FlightOrderContacterDto flightOrderContacter;
	
	/** 订单预订来源 */
	private BookingSource bookingSource; 
	
	/** 订单合同信息 */
	private FlightOrderAgreementDto flightOrderAgreement;
	
	/** 订单快递信息 */
	private FlightOrderExpressDto flightOrderExpress;
	
	/** 订单乘机人信息 */
	private List<FlightOrderPassengerDto> flightOrderPassengers = new ArrayList<FlightOrderPassengerDto>();
	
	 /** 订单航线组合信息 */
    private FlightOrderFlightCombinationDto flightOrderFlightCombination;
    
    /** 订单PNR信息 */
    private List<FlightOrderPNRInfoDto> flightOrderPNRInfos = new ArrayList<FlightOrderPNRInfoDto>();
    
	/** 订单支付信息 */
	private List<FlightOrderPaymentDto> flightOrderPayment = new ArrayList<FlightOrderPaymentDto>();
	
	/** 订单退款信息 */
	private List<FlightOrderRefundDto> flightOrderRefund = new ArrayList<FlightOrderRefundDto>();
	
	/** 订单操作日志信息 */
	private List<OrderOpLogDto> ordeOpLogs = new ArrayList<OrderOpLogDto>();
	
	/** 订单信息 */
	private List<FlightOrderDto> flightOrders = new ArrayList<FlightOrderDto>();
	
	/** 订单备注信息(只用于级联加载，不用于级联保存) */
	private List<FlightOrderRemarkDto> flightOrderRemarks = new ArrayList<FlightOrderRemarkDto>();
	
	 /** VST订单信息 */
    private FlightOrderSalesOrderRelationDto flightOrderSalesOrderRelationDto;
    
    /** 变价后的订单总销售价 */
    private BigDecimal totalSalesPrice;
    
    /**订单记录推广losc**/
	private FlightOrderLoscInfoDto flightOrderLoscInfoDto;
	
	/**大交通&CPS对接项目记录*/
	private FlightOrderCPSInfoDto flightOrderCPSInfoDto;
	
	private String equipmentNo;
	
	//优惠券号
	private String couponCode;    
	//优惠券金额
	private BigDecimal couponPrice;
	
	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public BigDecimal getCouponPrice() {
		return couponPrice;
	}

	public void setCouponPrice(BigDecimal couponPrice) {
		this.couponPrice = couponPrice;
	}

	public FlightOrderNoDto getFlightOrderNo() {
		return flightOrderNo;
	}

	public void setFlightOrderNo(FlightOrderNoDto flightOrderNo) {
		this.flightOrderNo = flightOrderNo;
	}

	public FlightOrderCustomerDto getFlightOrderCustomer() {
		return flightOrderCustomer;
	}

	public void setFlightOrderCustomer(FlightOrderCustomerDto flightOrderCustomer) {
		this.flightOrderCustomer = flightOrderCustomer;
	}

	public FlightOrderContacterDto getFlightOrderContacter() {
		return flightOrderContacter;
	}

	public void setFlightOrderContacter(FlightOrderContacterDto flightOrderContacter) {
		this.flightOrderContacter = flightOrderContacter;
	}

	public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}

	public FlightOrderAgreementDto getFlightOrderAgreement() {
		return flightOrderAgreement;
	}

	public void setFlightOrderAgreement(FlightOrderAgreementDto flightOrderAgreement) {
		this.flightOrderAgreement = flightOrderAgreement;
	}

	public FlightOrderExpressDto getFlightOrderExpress() {
		return flightOrderExpress;
	}

	public void setFlightOrderExpress(FlightOrderExpressDto flightOrderExpress) {
		this.flightOrderExpress = flightOrderExpress;
	}

	public List<FlightOrderPassengerDto> getFlightOrderPassengers() {
		return flightOrderPassengers;
	}

	public void setFlightOrderPassengers(
			List<FlightOrderPassengerDto> flightOrderPassengers) {
		this.flightOrderPassengers = flightOrderPassengers;
	}

	public FlightOrderFlightCombinationDto getFlightOrderFlightCombination() {
		return flightOrderFlightCombination;
	}

	public void setFlightOrderFlightCombination(
			FlightOrderFlightCombinationDto flightOrderFlightCombination) {
		this.flightOrderFlightCombination = flightOrderFlightCombination;
	}

	public List<FlightOrderPNRInfoDto> getFlightOrderPNRInfos() {
		return flightOrderPNRInfos;
	}

	public void setFlightOrderPNRInfos(
			List<FlightOrderPNRInfoDto> flightOrderPNRInfos) {
		this.flightOrderPNRInfos = flightOrderPNRInfos;
	}

	public List<OrderOpLogDto> getOrdeOpLogs() {
		return ordeOpLogs;
	}

	public void setOrdeOpLogs(List<OrderOpLogDto> ordeOpLogs) {
		this.ordeOpLogs = ordeOpLogs;
	}

	public List<FlightOrderDto> getFlightOrders() {
		return flightOrders;
	}

	public void setFlightOrders(List<FlightOrderDto> flightOrders) {
		this.flightOrders = flightOrders;
	}

	public List<FlightOrderRemarkDto> getFlightOrderRemarks() {
		return flightOrderRemarks;
	}

	public void setFlightOrderRemarks(List<FlightOrderRemarkDto> flightOrderRemarks) {
		this.flightOrderRemarks = flightOrderRemarks;
	}

	public List<FlightOrderPaymentDto> getFlightOrderPayment() {
		return flightOrderPayment;
	}

	public void setFlightOrderPayment(List<FlightOrderPaymentDto> flightOrderPayment) {
		this.flightOrderPayment = flightOrderPayment;
	}

	public List<FlightOrderRefundDto> getFlightOrderRefund() {
		return flightOrderRefund;
	}

	public void setFlightOrderRefund(List<FlightOrderRefundDto> flightOrderRefund) {
		this.flightOrderRefund = flightOrderRefund;
	}

	public FlightOrderSalesOrderRelationDto getFlightOrderSalesOrderRelationDto() {
		return flightOrderSalesOrderRelationDto;
	}

	public void setFlightOrderSalesOrderRelationDto(
			FlightOrderSalesOrderRelationDto flightOrderSalesOrderRelationDto) {
		this.flightOrderSalesOrderRelationDto = flightOrderSalesOrderRelationDto;
	}

	public BigDecimal getTotalSalesPrice() {
		return totalSalesPrice;
	}

	public void setTotalSalesPrice(BigDecimal totalSalesPrice) {
		this.totalSalesPrice = totalSalesPrice;
	}

	public FlightOrderLoscInfoDto getFlightOrderLoscInfoDto() {
		return flightOrderLoscInfoDto;
	}

	public void setFlightOrderLoscInfoDto(
			FlightOrderLoscInfoDto flightOrderLoscInfoDto) {
		this.flightOrderLoscInfoDto = flightOrderLoscInfoDto;
	}

	public String getEquipmentNo() {
		return equipmentNo;
	}

	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}

	public FlightOrderCPSInfoDto getFlightOrderCPSInfoDto() {
		return flightOrderCPSInfoDto;
	}

	public void setFlightOrderCPSInfoDto(FlightOrderCPSInfoDto flightOrderCPSInfoDto) {
		this.flightOrderCPSInfoDto = flightOrderCPSInfoDto;
	}

}
