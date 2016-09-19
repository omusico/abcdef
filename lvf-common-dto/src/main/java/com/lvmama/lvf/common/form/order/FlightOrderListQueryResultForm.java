package com.lvmama.lvf.common.form.order;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.enums.RefundmentType;
import com.lvmama.lvf.common.dto.order.result.list.FlightOrderListDto;
import com.lvmama.lvf.common.dto.order.result.list.FlightOrderListFlightInfoDto;
import com.lvmama.lvf.common.dto.order.status.FlightOrderStatusDto;
import com.lvmama.lvf.common.dto.status.Op;
import com.lvmama.lvf.common.dto.status.OpCommandBack;
import com.lvmama.lvf.common.dto.supp.Supp;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;

public class FlightOrderListQueryResultForm implements Serializable,Form 
{
	private static final long serialVersionUID = 8129756951965204178L;
	
	private FlightOrderListDto flightOrderListDto;

	/** 航程 */
	private String flightSegments = StringUtils.EMPTY;
	
	/** 航班号 */
	private String flightNos = StringUtils.EMPTY;
	
	/** 乘机时间 */
	private String flightTimes = StringUtils.EMPTY;
	
	/** 订单类型名称 */
	private String orderTypeName;
	
	/** 预订来源名称 */
	private String bookingSourceName;
	
	/** 当前状态字符串 */
	private String currentStatusStr = StringUtils.EMPTY;
	
	/** 支付方式 */
	private String paymentMethod = StringUtils.EMPTY;
	
	/** 支付方式 */
	private String orgPaymentMethod = StringUtils.EMPTY;
	
	/**处理后要显示预订人数字段*/
	private String passengerCountDetail;
	
	private String passengerType;
	
	public FlightOrderListQueryResultForm(){}

	public FlightOrderListQueryResultForm(FlightOrderListDto flightOrderListDto) 
	{
		//航程、航班号、乘机时间设置
		this.flightOrderListDto = flightOrderListDto;
		List<FlightOrderListFlightInfoDto> flightInfoDtos = flightOrderListDto.getFlightOrderListFlightInfos();
		if(CollectionUtils.isNotEmpty(flightInfoDtos))
		{
			Collections.sort(flightInfoDtos, new  Comparator<FlightOrderListFlightInfoDto>(){
				@Override
				public int compare(FlightOrderListFlightInfoDto o1,FlightOrderListFlightInfoDto o2) {
					if(null != o1.getFlightTripType() ){
						switch(o1.getFlightTripType()){
						case DEPARTURE:
							return -1;
						case RETURN:
							return 1;
						default:
							return 0;
						}
					}
					return 0;
				}
			});
			for(FlightOrderListFlightInfoDto flightInfoDto : flightInfoDtos)
			{
				if(StringUtils.isNotBlank(flightInfoDto.getDepCode()))
				{
					//航程
					this.flightSegments += flightInfoDto.getDepCode() + "-" + flightInfoDto.getArrCode() + ",";
				}	
				
				if(StringUtils.isNotBlank(flightInfoDto.getFlightNo()))
				{
					//航班号
					this.flightNos += flightInfoDto.getFlightNo() + "(" + flightInfoDto.getSeatClassCode() + "),";
				}	
				
				//乘机时间
				if(flightInfoDto.getDepTime() != null)
				{
					this.flightTimes += DateUtils.formatDate(flightInfoDto.getDepTime(), DateUtils.YYYY_MM_DD_HH_MM) + ",";
				}
				
				//返程航程
				if(StringUtils.isNotBlank(flightInfoDto.getReturnDepAirportCode())){
					this.flightSegments += flightInfoDto.getReturnDepAirportCode() + "-" + flightInfoDto.getReturnArrAirportCode() + ",";
				}
				//返程航班号
				if(StringUtils.isNotBlank(flightInfoDto.getReturnFlightNo())){
					this.flightNos += flightInfoDto.getReturnFlightNo() + "(" + flightInfoDto.getReturnSeatClassCode() + "),";
				}
				//返程乘机时间
				if(null != flightInfoDto.getReturnDepTime()){
					this.flightTimes += DateUtils.formatDate(flightInfoDto.getReturnDepTime(), DateUtils.YYYY_MM_DD_HH_MM) + ",";
				}
				
			}
			if(StringUtils.isNotBlank(this.flightSegments))
			{
				this.flightSegments = this.flightSegments.substring(0, this.flightSegments.length() - 1);
			}	
			if(StringUtils.isNotBlank(this.flightNos))
			{
				this.flightNos = this.flightNos.substring(0, this.flightNos.length() - 1);
			}	
			if(StringUtils.isNotBlank(this.flightTimes))
			{
				this.flightTimes = this.flightTimes.substring(0, this.flightTimes.length() - 1);
			}
		}
		
		//当前状态字符串设置
		FlightOrderStatusDto flightOrderStatusDto = this.getFlightOrderStatus();
		if(flightOrderStatusDto != null)
		{
			StringBuffer sb = new StringBuffer();
			if(null!=this.getFlightOrderStatus().getOrderBackStatus()){
				sb.append(this.getFlightOrderStatus().getOrderBackStatus().getCnName()).append("|");
			}
			if(null!=this.getFlightOrderStatus().getOrderAuditStatus()){
				sb.append(this.getFlightOrderStatus().getOrderAuditStatus().getCnName()).append("|");
			}
			if(null!=this.getFlightOrderStatus().getOrderTicketStatus()){
				sb.append(this.getFlightOrderStatus().getOrderTicketStatus().getCnName()).append("|");
			}
			if(null!=this.getFlightOrderStatus().getOrderPayStatus()){
				sb.append(this.getFlightOrderStatus().getOrderPayStatus().getCnName()).append("|");
			}
			this.currentStatusStr = sb.toString().substring(0, sb.length() - 1);
		}
		
		//支付方式设置
		OrderType orderType = this.getOrderType();
		if(orderType == OrderType.NORMAL || orderType == OrderType.CTMT)
		{
			List<PaymentType> paymentTypes = flightOrderListDto.getPaymentTypes();
			if(CollectionUtils.isNotEmpty(paymentTypes))
			{
				for(PaymentType paymentType : paymentTypes)
				{
					this.paymentMethod += paymentType.getCnName() + ",";
				}
				this.paymentMethod = this.paymentMethod.substring(0, this.paymentMethod.length() - 1);
			}
		}
		else
		{
			List<RefundmentType> refundmentTypes = flightOrderListDto.getRefundmentTypes();
			if(CollectionUtils.isNotEmpty(refundmentTypes))
			{
				for(RefundmentType refundmentType : refundmentTypes)
				{
					this.paymentMethod += refundmentType.getCnName() + ",";
				}
				this.paymentMethod = this.paymentMethod.substring(0, this.paymentMethod.length() - 1);
			}
		}
		if(StringUtils.isNotBlank(flightOrderListDto.getPaymentTypeStr())){
			this.orgPaymentMethod = flightOrderListDto.getPaymentTypeStr();
		}
	}
	
	public FlightOrderListDto getFlightOrderListDto() {
		return flightOrderListDto;
	}
	
	public void setFlightOrderListDto(FlightOrderListDto flightOrderListDto) {
		this.flightOrderListDto = flightOrderListDto;
	}
	
	public String getFlightSegments() {
		return flightSegments;
	}

	public void setFlightSegments(String flightSegments) {
		this.flightSegments = flightSegments;
	}

	public String getFlightNos() {
		return flightNos;
	}

	public void setFlightNos(String flightNos) {
		this.flightNos = flightNos;
	}

	public String getFlightTimes() {
		return flightTimes;
	}

	public void setFlightTimes(String flightTimes) {
		this.flightTimes = flightTimes;
	}
	
	public String getOrderTypeName() {
		if(this.getOrderType() != null)
			return this.getOrderType().getCnName();
		return orderTypeName;
	}

	public void setOrderTypeName(String orderTypeName) {
		this.orderTypeName = orderTypeName;
	}

	public String getBookingSourceName() {
		if(this.getBookingSource() != null)
			return this.getBookingSource().getCnName();
		return bookingSourceName;
	}

	public void setBookingSourceName(String bookingSourceName) {
		this.bookingSourceName = bookingSourceName;
	}
	
	public String getCurrentStatusStr() {
		return currentStatusStr;
	}

	public void setCurrentStatusStr(String currentStatusStr) {
		this.currentStatusStr = currentStatusStr;
	}

	public Long getOrderId() {
		return flightOrderListDto.getOrderId();
	}

	public void setOrderId(Long orderId) {
		flightOrderListDto.setOrderId(orderId);
	}

	public String getOrderNo() {
		return flightOrderListDto.getOrderNo();
	}

	public void setOrderNo(String orderNo) {
		flightOrderListDto.setOrderNo(orderNo);
	}

	
	public String getOrderMainNo() {
		return flightOrderListDto.getOrderMainNo();
	}

	public void setOrderMainNo(String orderMainNo) {
		flightOrderListDto.setOrderMainNo(orderMainNo);
	}
	public OrderType getOrderType() {
		return flightOrderListDto.getOrderType();
	}

	public void setOrderType(OrderType orderType) {
		flightOrderListDto.setOrderType(orderType);
	}

	public String getPnr() {
		return flightOrderListDto.getPnr();
	}

	public void setPnr(String pnr) {
		flightOrderListDto.setPnr(pnr);
	}

	public List<FlightOrderListFlightInfoDto> getFlightOrderListFlightInfos() {
		return flightOrderListDto.getFlightOrderListFlightInfos();
	}

	public void setFlightOrderListFlightInfos(
			List<FlightOrderListFlightInfoDto> flightOrderListFlightInfos) {
		flightOrderListDto
				.setFlightOrderListFlightInfos(flightOrderListFlightInfos);
	}

	public Integer getPassengerCount() {
		return flightOrderListDto.getPassengerCount();
	}

	public void setPassengerCount(Integer passengerCount) {
		flightOrderListDto.setPassengerCount(passengerCount);
	}

	public BigDecimal getReceivableAmount() {
		return flightOrderListDto.getReceivableAmount();
	}

	public void setReceivableAmount(BigDecimal receivableAmount) {
		flightOrderListDto.setReceivableAmount(receivableAmount);
	}
	
	public List<PaymentType> getPaymentTypes() {
		return flightOrderListDto.getPaymentTypes();
	}

	public void setPaymentTypes(List<PaymentType> paymentTypes) {
		flightOrderListDto.setPaymentTypes(paymentTypes);
	}

	public List<RefundmentType> getRefundmentTypes() {
		return flightOrderListDto.getRefundmentTypes();
	}

	public void setRefundmentTypes(List<RefundmentType> refundmentTypes) {
		flightOrderListDto.setRefundmentTypes(refundmentTypes);
	}

	public List<Op> getOrderOps() {
		return flightOrderListDto.getOrderOps();
	}

	public void setOrderOps(List<Op> orderOps) {
		flightOrderListDto.setOrderOps(orderOps);
	}

	public String getContactName() {
		return flightOrderListDto.getContactName();
	}

	public void setContactName(String contactName) {
		flightOrderListDto.setContactName(contactName);
	}

	public Date getOrderCreateTime() {
		return flightOrderListDto.getOrderCreateTime();
	}

	public void setOrderCreateTime(Date orderCreateTime) {
		flightOrderListDto.setOrderCreateTime(orderCreateTime);
	}

	public BookingSource getBookingSource() {
		return flightOrderListDto.getBookingSource();
	}

	public void setBookingSource(BookingSource bookingSource) {
		flightOrderListDto.setBookingSource(bookingSource);
	}

	public FlightOrderStatusDto getFlightOrderStatus() {
		return flightOrderListDto.getFlightOrderStatus();
	}

	public void setFlightOrderStatus(FlightOrderStatusDto flightOrderStatus) {
		flightOrderListDto.setFlightOrderStatus(flightOrderStatus);
	}

	public Long getId() {
		return Long.parseLong(flightOrderListDto.getOrderNo());
	}

	public Long getOrderMainId() {
		return flightOrderListDto.getOrderMainId();
	}

	public void setOrderMainId(Long orderMainId) {
		flightOrderListDto.setOrderMainId(orderMainId);
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public Supp getSupp() {
		return flightOrderListDto.getSupp();
	}

	public void setSupp(Supp supp) {
		flightOrderListDto.setSupp(supp);
	}
	
	public String getOrderCreateTimeStr() {
		if(this.getOrderCreateTime() != null)
			return DateUtils.formatDate(this.getOrderCreateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS);;
		return null;
	}
	
	public String getSuppOrderNo() {
		return flightOrderListDto.getSuppOrderNo();
	}

	public void setSuppOrderNo(String suppOrderNo) {
		flightOrderListDto.setSuppOrderNo(suppOrderNo);
	}

	public String getSalesMainOrderId() {
		return flightOrderListDto.getSalesMainOrderId();
	}

	public void setSalesMainOrderId(String salesMainOrderId) {
		flightOrderListDto.setSalesMainOrderId(salesMainOrderId);
	}

	public String getSalesOrderId() {
		return flightOrderListDto.getSalesOrderId();
	}

	public void setSalesOrderId(String salesOrderId) {
		flightOrderListDto.setSalesOrderId(salesOrderId);
	}
	
	/**
	 * 判断当前记录是否可支付
	 * @return
	 */
	public boolean isCanPay(){
		List<Op> opList = this.getFlightOrderListDto().getOrderOps();
		if(CollectionUtils.isNotEmpty(opList)){
			return opList.contains(OpCommandBack.APPLY_PAY);
		}else{
			return false;
		}
	}

	public BigDecimal getOrderDirectReductionAmount() {
		return flightOrderListDto.getOrderDirectReductionAmount();
	}

	public void setOrderDirectReductionAmount(
			BigDecimal orderDirectReductionAmount) {
		flightOrderListDto
				.setOrderDirectReductionAmount(orderDirectReductionAmount);
	}

	public String getPassengerCountDetail() {
		String passengerCountDetail="";
		if(flightOrderListDto.getPassengerCount()!=null){
			passengerCountDetail = String.valueOf(flightOrderListDto.getPassengerCount());
			/*PassengerType passengerType = flightOrderListDto.getPassengerType();
			passengerCountDetail+="("+passengerType.getCnName()+")";*/
		}
		return passengerCountDetail;
	}

	public void setPassengerCountDetail(String passengerCountDetail) {
		this.passengerCountDetail = passengerCountDetail;
	}

	public String getPassengerType() {
		return flightOrderListDto.getPassengerType().getCnName();
	}

	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}

	public String getOrgPaymentMethod() {
		return orgPaymentMethod;
	}

	public void setOrgPaymentMethod(String orgPaymentMethod) {
		this.orgPaymentMethod = orgPaymentMethod;
	}

	public String getSaleType() {
		return flightOrderListDto.getSaleType();
	}

	public void setSaleType(String saleType) {
		flightOrderListDto.setSaleType(saleType);
	}
	
	public String getCpsId() {
		return flightOrderListDto.getCpsId();
	}

	public void setCpsId(String cpsId) {
		flightOrderListDto.setCpsId(cpsId);
	}
		
}
