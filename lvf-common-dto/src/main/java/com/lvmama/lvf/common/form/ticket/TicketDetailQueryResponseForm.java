package com.lvmama.lvf.common.form.ticket;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.enums.RefundmentType;
import com.lvmama.lvf.common.dto.order.result.list.FlightOrderListFlightInfoDto;
import com.lvmama.lvf.common.dto.status.detail.DetailTicketStatus;
import com.lvmama.lvf.common.dto.ticket.FlightTicketDetailDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;

/**
 * 客票明细ResponseFrom
 * 
 * @author zzs
 *
 */
public class TicketDetailQueryResponseForm implements Serializable, Form 
{
	private static final long serialVersionUID = -8381555604510025491L;

	private FlightTicketDetailDto flightTicketDetailDto;
	
	/** 机票状态名称 */
	private String detailTicketStatusName;
	
	/** 航程 */
	private String flightSegment = StringUtils.EMPTY;
	
	/** 航班号 */
	private String flightNo = StringUtils.EMPTY;
	
	/** 乘机时间 */
	private String flightTime = StringUtils.EMPTY;
	
	/** 支付方式 */
	private String paymentMethod = StringUtils.EMPTY;
	
	/** 预订来源名称 */
	private String bookingSourceName;
	
	private String passengerTypeCnName;
	
	public TicketDetailQueryResponseForm(FlightTicketDetailDto flightTicketDetailDto) 
	{
		this.flightTicketDetailDto = flightTicketDetailDto;
		FlightOrderListFlightInfoDto flightOrderListFlightInfoDto = flightTicketDetailDto.getFlightOrderListFlightInfoDto();
		if(flightOrderListFlightInfoDto != null)
		{
			//航程
			if(StringUtils.isNotBlank(flightOrderListFlightInfoDto.getDepCode()))
			{
				this.flightSegment = flightOrderListFlightInfoDto.getDepCode() + "-" + flightOrderListFlightInfoDto.getArrCode();
			}
			//航班号
			if(StringUtils.isNotBlank(flightOrderListFlightInfoDto.getFlightNo()))
			{
				this.flightNo += flightOrderListFlightInfoDto.getFlightNo() + "(" + flightOrderListFlightInfoDto.getSeatClassCode() + ")";
			}
		}
		
		//支付方式设置
		OrderType orderType = this.getOrderType();
		if(orderType == OrderType.NORMAL || orderType == OrderType.CTMT)
		{
			if(this.getPaymentType() != null)
				this.paymentMethod = this.getPaymentType().getCnName();
		}
		else
		{
			if(this.getRefundmentType() != null)
				this.paymentMethod = this.getRefundmentType().getCnName();
		}
	}
	
	public TicketDetailQueryResponseForm() {
	}

	public String getTicketNo() {
		return flightTicketDetailDto.getTicketNo();
	}

	public void setTicketNo(String ticketNo) {
		flightTicketDetailDto.setTicketNo(ticketNo);
	}

	public DetailTicketStatus getDetailTicketStatus() {
		return flightTicketDetailDto.getDetailTicketStatus();
	}

	public void setDetailTicketStatus(DetailTicketStatus detailTicketStatus) {
		flightTicketDetailDto.setDetailTicketStatus(detailTicketStatus);
	}

	public String getPnr() {
		return flightTicketDetailDto.getPnr();
	}

	public void setPnr(String pnr) {
		flightTicketDetailDto.setPnr(pnr);
	}

	public FlightOrderListFlightInfoDto getFlightOrderListFlightInfoDto() {
		return flightTicketDetailDto.getFlightOrderListFlightInfoDto();
	}

	public void setFlightOrderListFlightInfoDto(
			FlightOrderListFlightInfoDto flightOrderListFlightInfoDto) {
		flightTicketDetailDto
				.setFlightOrderListFlightInfoDto(flightOrderListFlightInfoDto);
	}

	public String getPassengerName() {
		return flightTicketDetailDto.getPassengerName();
	}

	public void setPassengerName(String passengerName) {
		flightTicketDetailDto.setPassengerName(passengerName);
	}

	public BigDecimal getReceivableAmount() {
		return flightTicketDetailDto.getReceivableAmount();
	}

	public void setReceivableAmount(BigDecimal receivableAmount) {
		flightTicketDetailDto.setReceivableAmount(receivableAmount);
	}

	public PaymentType getPaymentType() {
		return flightTicketDetailDto.getPaymentType();
	}

	public void setPaymentType(PaymentType paymentType) {
		flightTicketDetailDto.setPaymentType(paymentType);
	}

	public RefundmentType getRefundmentType() {
		return flightTicketDetailDto.getRefundmentType();
	}

	public void setRefundmentType(RefundmentType refundmentType) {
		flightTicketDetailDto.setRefundmentType(refundmentType);
	}

	public String getOrderCreateTime() {
		return DateUtils.formatCnHmDate(flightTicketDetailDto.getOrderCreateTime());
	}

	public void setOrderCreateTime(Date orderCreateTime) {
		flightTicketDetailDto.setOrderCreateTime(orderCreateTime);
	}

	public BookingSource getBookingSource() {
		return flightTicketDetailDto.getBookingSource();
	}

	public void setBookingSource(BookingSource bookingSource) {
		flightTicketDetailDto.setBookingSource(bookingSource);
	}

	public String getOrderNo() {
		return flightTicketDetailDto.getOrderNo();
	}

	public void setOrderNo(String orderNo) {
		flightTicketDetailDto.setOrderNo(orderNo);
	}

	public OrderType getOrderType() {
		return flightTicketDetailDto.getOrderType();
	}

	public void setOrderType(OrderType orderType) {
		flightTicketDetailDto.setOrderType(orderType);
	}
	
	public String getSuppCode() {
		return flightTicketDetailDto.getSuppCode();
	}

	public void setSuppCode(String suppCode) {
		flightTicketDetailDto.setSuppCode(suppCode);
	}

	public Long getId() {
		return flightTicketDetailDto.getId();
	}
	
	public String getBookingSourceName() {
		if(this.getBookingSource() != null)
			return this.getBookingSource().getCnName();
		return bookingSourceName;
	}

	public void setBookingSourceName(String bookingSourceName) {
		this.bookingSourceName = bookingSourceName;
	}

	public String getDetailTicketStatusName() {
		if(this.getDetailTicketStatus() !=null)
			return this.getDetailTicketStatus().getCnName();
		return detailTicketStatusName;
	}

	public void setDetailTicketStatusName(String detailTicketStatusName) {
		this.detailTicketStatusName = detailTicketStatusName;
	}

	public FlightTicketDetailDto getFlightTicketDetailDto() {
		return flightTicketDetailDto;
	}

	public void setFlightTicketDetailDto(FlightTicketDetailDto flightTicketDetailDto) {
		this.flightTicketDetailDto = flightTicketDetailDto;
	}

	public String getFlightSegment() {
		return flightSegment;
	}

	public void setFlightSegment(String flightSegment) {
		this.flightSegment = flightSegment;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getFlightTime() {
		//乘机时间
		if(this.getFlightOrderListFlightInfoDto() != null && this.getFlightOrderListFlightInfoDto().getDepTime() != null)
		{
			this.flightTime += DateUtils.formatDate(this.getFlightOrderListFlightInfoDto().getDepTime(), DateUtils.YYYY_MM_DD_HH_MM);
		}
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Long getOrderMainId() {
		return flightTicketDetailDto.getOrderMainId();
	}

	public void setOrderMainId(Long orderMainId) {
		flightTicketDetailDto.setOrderMainId(orderMainId);
	}

	public Long getOrderId() {
		return flightTicketDetailDto.getOrderId();
	}

	public void setOrderId(Long orderId) {
		flightTicketDetailDto.setOrderId(orderId);
	}

	public PassengerType getPassengerType() {
		return flightTicketDetailDto.getPassengerType();
	}

	public void setPassengerType(PassengerType passengerType) {
		flightTicketDetailDto.setPassengerType(passengerType);
	}

	public String getPassengerTypeCnName() {
		if(null != flightTicketDetailDto.getPassengerType()){
			return flightTicketDetailDto.getPassengerType().getCnName();
		}else{
			return StringUtils.EMPTY;
		}
	}

	public void setPassengerTypeCnName(String passengerTypeCnName) {
		this.passengerTypeCnName = passengerTypeCnName;
	}

	public String getSaleType() {
		return flightTicketDetailDto.getSaleType();
	}

	public void setSaleType(String saleType) {
		flightTicketDetailDto.setSaleType(saleType);
	}
}
