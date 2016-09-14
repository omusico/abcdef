package com.lvmama.lvf.common.dto.ticket;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.enums.RefundmentType;
import com.lvmama.lvf.common.dto.order.result.list.FlightOrderListFlightInfoDto;
import com.lvmama.lvf.common.dto.status.detail.DetailTicketStatus;
import com.lvmama.lvf.common.utils.DateUtils;

/**
 * 客票明细
 * @author majun
 * @date 2015-6-17
 */
public class FlightTicketDetailDto implements Dto,Serializable 
{
	private static final long serialVersionUID = -8472162125747195372L;

	/** 票号 */
	private String ticketNo;
	
	/** 票号状态 */
	private DetailTicketStatus detailTicketStatus;
	
	/** PNR编码 */
	private String pnr;
	
	/** 订单航班信息 */
	private FlightOrderListFlightInfoDto flightOrderListFlightInfoDto;
	
	/** 乘机人 */
	private String passengerName;
	
	/** 乘客类型 */
	private PassengerType passengerType;
	
	/** 应收款 */
    private BigDecimal receivableAmount;
	
	/** 支付方式 */
	private PaymentType paymentType;
	
	/** 退款方式 */
    private RefundmentType refundmentType;
    
    /** 下单时间 */
    private Date orderCreateTime;

	/** 订单来源（渠道） */
	private BookingSource bookingSource;
	
	/** 订单号 */
	private String orderNo;
	
	/** 订单类型 */
	private OrderType orderType;

	/** 主订单主键 */
	private Long orderMainId;
	
	/** 订单主键 */
	private Long orderId;
	
	/** 票号主键 */
	private Long ticketId;
	
	/** 供应商 */
	private String suppCode;

	private String saleType;

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public DetailTicketStatus getDetailTicketStatus() {
		return detailTicketStatus;
	}

	public void setDetailTicketStatus(DetailTicketStatus detailTicketStatus) {
		this.detailTicketStatus = detailTicketStatus;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public FlightOrderListFlightInfoDto getFlightOrderListFlightInfoDto() {
		return flightOrderListFlightInfoDto;
	}

	public void setFlightOrderListFlightInfoDto(
			FlightOrderListFlightInfoDto flightOrderListFlightInfoDto) {
		this.flightOrderListFlightInfoDto = flightOrderListFlightInfoDto;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public BigDecimal getReceivableAmount() {
		return receivableAmount;
	}

	public void setReceivableAmount(BigDecimal receivableAmount) {
		this.receivableAmount = receivableAmount;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public RefundmentType getRefundmentType() {
		return refundmentType;
	}

	public void setRefundmentType(RefundmentType refundmentType) {
		this.refundmentType = refundmentType;
	}

	public Date getOrderCreateTime() {
		return orderCreateTime;
	}

	public void setOrderCreateTime(Date orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}

	public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
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
	
	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * 构造客票明细String
	 * @return
	 */
	public String constructTicketDetailString()
	{
		StringBuffer ticketDetailStr = new StringBuffer();
		ticketDetailStr.append("'" + this.getTicketNo()).append(",");
		ticketDetailStr.append(this.getDetailTicketStatus().getCnName()).append(",");
		ticketDetailStr.append(this.getPnr()).append(",");
		  
		String flightSegment = StringUtils.EMPTY;//航程
		String flightNo = StringUtils.EMPTY;//航班号
		String flightTime = StringUtils.EMPTY;//乘机时间
		
		FlightOrderListFlightInfoDto flightOrderListFlightInfoDto = this.getFlightOrderListFlightInfoDto();
		if(flightOrderListFlightInfoDto != null)
		{
			if(StringUtils.isNotBlank(flightOrderListFlightInfoDto.getDepCode()))
			{
				if(flightOrderListFlightInfoDto.getDepCode().contains(",") && flightOrderListFlightInfoDto.getArrCode().contains(",")){
					String[] depCodes = flightOrderListFlightInfoDto.getDepCode().split(",");
					String[] arrCodes = flightOrderListFlightInfoDto.getArrCode().split(",");
					flightSegment = depCodes[0] + "-" + arrCodes[0];
					flightSegment += "~" + depCodes[1] + "-" + arrCodes[1];
				}else{
					flightSegment = flightOrderListFlightInfoDto.getDepCode() + "-" + flightOrderListFlightInfoDto.getArrCode();
				}
			}
			if(StringUtils.isNotBlank(flightOrderListFlightInfoDto.getFlightNo()))
			{
				if(flightOrderListFlightInfoDto.getFlightNo().contains(",") && flightOrderListFlightInfoDto.getSeatClassCode().contains(",")){
					String[] flightNos = flightOrderListFlightInfoDto.getFlightNo().split(",");
					String[] seatCodes = flightOrderListFlightInfoDto.getSeatClassCode().split(",");
					flightNo = flightNos[0] + "(" + seatCodes[0] + ")";
					flightNo += "~" + flightNos[1] + "(" + seatCodes[1] + ")";
				}else{
					flightNo += flightOrderListFlightInfoDto.getFlightNo() + "(" + flightOrderListFlightInfoDto.getSeatClassCode() + ")";
				}
			}
			if(flightOrderListFlightInfoDto.getDepTime() != null)
			{
				flightTime += DateUtils.formatDate(flightOrderListFlightInfoDto.getDepTime(), DateUtils.YYYY_MM_DD_HH_MM);
				if(this.getFlightOrderListFlightInfoDto().getReturnDepTime() != null 
						&& !this.getFlightOrderListFlightInfoDto().getReturnDepTime().equals(this.getFlightOrderListFlightInfoDto().getDepTime()))
				{
					flightTime += "~" + DateUtils.formatDate(this.getFlightOrderListFlightInfoDto().getReturnDepTime(), DateUtils.YYYY_MM_DD_HH_MM);
				}
			}
		}
		ticketDetailStr.append(flightSegment).append(",");
		ticketDetailStr.append(flightNo).append(",");
		ticketDetailStr.append(flightTime).append(",");
		ticketDetailStr.append(this.getPassengerName()).append(",");
		if(null != this.getPassengerType()){
			ticketDetailStr.append(this.getPassengerType().getCnName()).append(",");
		}else{
			ticketDetailStr.append(",");
		}
		ticketDetailStr.append(this.getReceivableAmount()).append(",");
		
		//支付方式设置
		String paymentMethod = StringUtils.EMPTY;//支付方式
		OrderType orderType = this.getOrderType();
		if(orderType == OrderType.NORMAL || orderType == OrderType.CTMT)
		{
			if(this.getPaymentType() != null)
				paymentMethod = this.getPaymentType().getCnName();
		}
		else
		{
			if(this.getRefundmentType() != null)
				paymentMethod = this.getRefundmentType().getCnName();
		}
		ticketDetailStr.append(paymentMethod).append(",");
		ticketDetailStr.append(DateUtils.formatDate(this.getOrderCreateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS)).append(",");
		ticketDetailStr.append(this.getBookingSource().getCnName()).append(",");
		ticketDetailStr.append(null==this.getSaleType()?"":this.getSaleType()).append(",");
		ticketDetailStr.append(this.getSuppCode()).append(",");
		ticketDetailStr.append("'" + this.getOrderNo()).append(",");
		
		return ticketDetailStr.toString();
	}

	@Override
	public Long getId() {
		return null;
	}

	public PassengerType getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
}
