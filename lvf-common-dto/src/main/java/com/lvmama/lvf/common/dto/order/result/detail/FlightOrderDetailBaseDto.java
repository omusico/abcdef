package com.lvmama.lvf.common.dto.order.result.detail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.enums.PayType;
import com.lvmama.lvf.common.dto.enums.Product;
import com.lvmama.lvf.common.dto.order.FlightOrderAmountDto;
import com.lvmama.lvf.common.dto.order.FlightOrderCPSInfoDto;
import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;
import com.lvmama.lvf.common.dto.order.FlightOrderCustomerDto;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderPaymentDto;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderRefundDto;
import com.lvmama.lvf.common.dto.order.status.FlightOrderStatusDto;
import com.lvmama.lvf.common.dto.status.Op;
import com.lvmama.lvf.common.dto.status.ResultStatus;

/**
 * 订单详情基本信息
 * @author majun
 * @date   2015-3-17
 */
public class FlightOrderDetailBaseDto implements Serializable
{
	private static final long serialVersionUID = 5444497034255466070L;

	/** 主订单主键 */
	private Long orderMainId;
	
	/** 订单主键 */
	private Long orderId;
	
	/** 审核操作主键 */
	private Long auditOpId;
	
	/** 订单号 */
	private String orderNo;
	
	/** 主订单号 */
	private String orderMainNo;
	
	/** 外部机票子订单Id (VST)*/
	private Long salesOrderId;
	
	/** 外部机票子订单Id (VST)*/
	private Long salesMainOrderId;
	
	/** 供应商 */
	private List<String> suppCodes;
	
	/** 供应商订单号 */
	private List<String> suppOrderNos;
	
	/** 供应商退票单号 */
	private List<String> suppRefundNos;
	
	/** 预订来源(订单来源) */
	private BookingSource bookingSource;
	
	/** 付款方式 */
	private PayType payType;
	
	/** 订单类型 */
	private OrderType orderType;
	
	/** 产品类型 */
	private Product product;
	
	/** 订单创建时间 */
	private Date createTime;
	
	/** 订单状态信息 */
	private FlightOrderStatusDto flightOrderStatus;
	
	/** 操作列表 */
	private List<Op> ops;
	
	/** 联系人信息 */
	private FlightOrderContacterDto flightOrderContacter;
	
	/** 用户备注 */
	private String customerRemark;
	
	/** 订单金额信息 */
	private FlightOrderAmountDto flightOrderAmountDto;
	
	/** 订单客户信息 */
	private FlightOrderCustomerDto flightOrderCustomer;
	
	/** 订单支付信息 */
    private List<FlightOrderPaymentDto> flightOrderPayments = new ArrayList<FlightOrderPaymentDto>();
    
    /** 订单退款信息 */
    private List<FlightOrderRefundDto> flightOrderRefunds = new ArrayList<FlightOrderRefundDto>();
	
	/**预定完成时间*/
	private Date finishBookingTime;
	
	/**支付等待时间*/
	private Date limitTime;
	
	/**cps分销信息DTO*/
	private FlightOrderCPSInfoDto flightOrderCPSInfoDto;

	public Date getFinishBookingTime() {
		return finishBookingTime;
	}

	public void setFinishBookingTime(Date finishBookingTime) {
		this.finishBookingTime = finishBookingTime;
	}

	public Date getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(Date limitTime) {
		this.limitTime = limitTime;
	}

	public Long getOrderMainId() {
		return orderMainId;
	}

	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getAuditOpId() {
		return auditOpId;
	}

	public void setAuditOpId(Long auditOpId) {
		this.auditOpId = auditOpId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderMainNo() {
		return orderMainNo;
	}

	public void setOrderMainNo(String orderMainNo) {
		this.orderMainNo = orderMainNo;
	}

	public List<String> getSuppOrderNos() {
		return suppOrderNos;
	}

	public void setSuppOrderNos(List<String> suppOrderNos) {
		this.suppOrderNos = suppOrderNos;
	}

	public List<String> getSuppRefundNos() {
		return suppRefundNos;
	}

	public void setSuppRefundNos(List<String> suppRefundNos) {
		this.suppRefundNos = suppRefundNos;
	}

	public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}

	public PayType getPayType() {
		return payType;
	}

	public void setPayType(PayType payType) {
		this.payType = payType;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public FlightOrderStatusDto getFlightOrderStatus() {
		return flightOrderStatus;
	}

	public void setFlightOrderStatus(FlightOrderStatusDto flightOrderStatus) {
		this.flightOrderStatus = flightOrderStatus;
	}

	public List<Op> getOps() {
		return ops;
	}

	public void setOps(List<Op> ops) {
		this.ops = ops;
	}

	public FlightOrderContacterDto getFlightOrderContacter() {
		return flightOrderContacter;
	}

	public void setFlightOrderContacter(FlightOrderContacterDto flightOrderContacter) {
		this.flightOrderContacter = flightOrderContacter;
	}

	public String getCustomerRemark() {
		return customerRemark;
	}

	public void setCustomerRemark(String customerRemark) {
		this.customerRemark = customerRemark;
	}

	public FlightOrderAmountDto getFlightOrderAmountDto() {
		return flightOrderAmountDto;
	}

	public void setFlightOrderAmountDto(FlightOrderAmountDto flightOrderAmountDto) {
		this.flightOrderAmountDto = flightOrderAmountDto;
	}

	public FlightOrderCustomerDto getFlightOrderCustomer() {
		return flightOrderCustomer;
	}

	public void setFlightOrderCustomer(FlightOrderCustomerDto flightOrderCustomer) {
		this.flightOrderCustomer = flightOrderCustomer;
	}

	public List<FlightOrderPaymentDto> getFlightOrderPayments() {
		return flightOrderPayments;
	}

	public void setFlightOrderPayments(List<FlightOrderPaymentDto> flightOrderPayments) 
	{
		//只获取支付成功的订单信息
		List<FlightOrderPaymentDto> newFlightOrderPaymentDtos = new ArrayList<FlightOrderPaymentDto>();
		if(CollectionUtils.isNotEmpty(flightOrderPayments))
		{
			for(FlightOrderPaymentDto flightOrderPaymentDto : flightOrderPayments)
			{
				ResultStatus resultStatus = flightOrderPaymentDto.getPaymentStatus();
				if(resultStatus != null && resultStatus == ResultStatus.SUCCESS)
				{
					newFlightOrderPaymentDtos.add(flightOrderPaymentDto);
				}
			}
		}	
		this.flightOrderPayments = newFlightOrderPaymentDtos;
	}

	public List<FlightOrderRefundDto> getFlightOrderRefunds() {
		return flightOrderRefunds;
	}

	public void setFlightOrderRefunds(List<FlightOrderRefundDto> flightOrderRefunds) 
	{
		//只获取支付成功的订单信息
		List<FlightOrderRefundDto> newFlightOrderRefundDtos = new ArrayList<FlightOrderRefundDto>();
		if(CollectionUtils.isNotEmpty(flightOrderRefunds))
		{
			for(FlightOrderRefundDto flightOrderRefundDto : flightOrderRefunds)
			{
				ResultStatus resultStatus = flightOrderRefundDto.getRefundStatus();
				if(resultStatus != null && resultStatus == ResultStatus.SUCCESS)
				{
					newFlightOrderRefundDtos.add(flightOrderRefundDto);
				}
			}
		}	
		this.flightOrderRefunds = newFlightOrderRefundDtos;
	}

	public Long getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(Long salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public Long getSalesMainOrderId() {
		return salesMainOrderId;
	}

	public void setSalesMainOrderId(Long salesMainOrderId) {
		this.salesMainOrderId = salesMainOrderId;
	}
	
	public List<String> getSuppCodes() {
		return suppCodes;
	}

	public void setSuppCodes(List<String> suppCodes) {
		this.suppCodes = suppCodes;
	}

	public FlightOrderCPSInfoDto getFlightOrderCPSInfoDto() {
		return flightOrderCPSInfoDto;
	}

	public void setFlightOrderCPSInfoDto(FlightOrderCPSInfoDto flightOrderCPSInfoDto) {
		this.flightOrderCPSInfoDto = flightOrderCPSInfoDto;
	}
}
