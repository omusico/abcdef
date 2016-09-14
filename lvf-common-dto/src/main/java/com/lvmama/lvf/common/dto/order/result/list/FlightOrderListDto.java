package com.lvmama.lvf.common.dto.order.result.list;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.enums.PassengerType;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.enums.RefundmentType;
import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.order.status.FlightOrderStatusDto;
import com.lvmama.lvf.common.dto.status.Op;
import com.lvmama.lvf.common.dto.supp.Supp;
import com.lvmama.lvf.common.utils.DateUtils;

/**
 * 订单查询列表
 * @author majun
 * @date   2015-3-13
 */
public class FlightOrderListDto implements Serializable, Dto
{
	private static final long serialVersionUID = 4527223916960574686L;

	/** 主订单主键 */
	private Long orderMainId;

	/**订单主键 */
    private Long orderId;
    
    /** 前一个订单主键 */
    private Long orderPreId;

	/**订单号 */
    private String orderNo;

    /** 订单类型 */
    private OrderType orderType;
    
    /** 保留时限 */
    private Date limitTime;

	/** PNR信息 */
    private String pnr;

    /** 订单列表航班信息列表 */
    private List<FlightOrderListFlightInfoDto> flightOrderListFlightInfos;

    /** 预订人数(乘客数量) */
    private Integer passengerCount;

    /**应收款 */
    private BigDecimal receivableAmount;
    
    /** 支付方式 */
    private List<PaymentType> paymentTypes;
    
    /** 支付方式原始值 */
    private String paymentTypeStr;
    
    /** 退款方式 */
    private List<RefundmentType> refundmentTypes;

    /** 联系人 */
    private String contactName;

    /** 下单时间 */
    private Date orderCreateTime;

    /** 预订来源 */
    private BookingSource bookingSource;

    /** 订单状态集合 */
    @XmlTransient
    private FlightOrderStatusDto flightOrderStatus;

    /** 订单可操作状态集合 */
    private List<Op> orderOps;
    
    /** 供应商 */
    private Supp supp;
    
    /**
     * 供应商订单号
     * 飞机票项目:TASK#27559::订单查询列表添加新字段
     */
    private String SuppOrderNo;
    
    /** 采购主单号 */
    private String salesMainOrderId;
    
    /** 采购子单号 */
    private String salesOrderId;
    
    /**乘客类型 */
    private PassengerType passengerType;
    
    private BigDecimal orderDirectReductionAmount;
    /**会员名称 **/
    private String customerName;

	private String saleType;

    private List<FlightOrderDetailDto> orderDetailDtos;
    
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

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public List<FlightOrderListFlightInfoDto> getFlightOrderListFlightInfos() {
		return flightOrderListFlightInfos;
	}

	public void setFlightOrderListFlightInfos(
			List<FlightOrderListFlightInfoDto> flightOrderListFlightInfos) {
		this.flightOrderListFlightInfos = flightOrderListFlightInfos;
	}

	public Integer getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(Integer passengerCount) {
		this.passengerCount = passengerCount;
	}

	public BigDecimal getReceivableAmount() {
		return receivableAmount;
	}

	public void setReceivableAmount(BigDecimal receivableAmount) {
		this.receivableAmount = receivableAmount;
	}

	public List<PaymentType> getPaymentTypes() {
		return paymentTypes;
	}

	public void setPaymentTypes(List<PaymentType> paymentTypes) {
		this.paymentTypes = paymentTypes;
	}

	public List<RefundmentType> getRefundmentTypes() {
		return refundmentTypes;
	}

	public void setRefundmentTypes(List<RefundmentType> refundmentTypes) {
		this.refundmentTypes = refundmentTypes;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
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

	public FlightOrderStatusDto getFlightOrderStatus() {
		return flightOrderStatus;
	}

	public void setFlightOrderStatus(FlightOrderStatusDto flightOrderStatus) {
		this.flightOrderStatus = flightOrderStatus;
	}

    public List<Op> getOrderOps() {
        return orderOps;
    }

    public void setOrderOps(List<Op> orderOps) {
        this.orderOps = orderOps;
    }
    
    /**
     * 构造订单列表String
     * @return 
     */
    public String constructOrderListStr()
    {
    	StringBuffer orderListStr = new StringBuffer();
    	orderListStr.append("\t").append(this.getOrderNo()).append(",");
    	orderListStr.append("\t").append(this.getSalesMainOrderId()==null?"":this.getSalesMainOrderId()).append(",");
    	orderListStr.append("\t").append(this.getSalesOrderId()==null?"":this.getSalesOrderId()).append(",");
    	orderListStr.append(this.getOrderType().getCnName()).append(",");
    	orderListStr.append(this.getSaleType()==null?"":this.getSaleType()).append(",");
    	if(this.getSupp() != null)
    	{
    		orderListStr.append(this.getSupp().getCode()).append(",");
    	}
    	else 
    	{
    		orderListStr.append(",");
		}
		if(StringUtils.isNotBlank(this.getSuppOrderNo()))
    	{
    		orderListStr.append("\t").append(this.getSuppOrderNo()).append(",");
    	}else
    	{
    		orderListStr.append(",");
    	}
    	if(StringUtils.isNotBlank(this.getPnr()))
    	{
    		orderListStr.append(this.getPnr()).append(",");
    	}
    	else
    	{
    		orderListStr.append(",");
    	}
    	//航程、航班号
    	String flightSegments = StringUtils.EMPTY;
    	String flightNos = StringUtils.EMPTY;
    	String flightTimes = StringUtils.EMPTY;
    	List<FlightOrderListFlightInfoDto> flightInfoDtos = this.getFlightOrderListFlightInfos();
		if(CollectionUtils.isNotEmpty(flightInfoDtos))
		{
			for(FlightOrderListFlightInfoDto flightInfoDto : flightInfoDtos)
			{
				if(StringUtils.isNotBlank(flightInfoDto.getDepCode()))
				{
					flightSegments = flightInfoDto.getDepCode() + "-" + flightInfoDto.getArrCode() + " ";
				}
				if(StringUtils.isNotBlank(flightInfoDto.getFlightNo()))
				{
					flightNos += flightInfoDto.getFlightNo() + "(" + flightInfoDto.getSeatClassCode() + ") ";
				}
				if(flightInfoDto.getDepTime() != null)
				{
					flightTimes += DateUtils.formatDate(flightInfoDto.getDepTime(), DateUtils.YYYY_MM_DD_HH_MM) + " ";
				}
				
				//返程航程
				if(StringUtils.isNotBlank(flightInfoDto.getReturnDepAirportCode())){
					flightSegments += "~" + flightInfoDto.getReturnDepAirportCode() + "-" + flightInfoDto.getReturnArrAirportCode();
				}
				//返程航班号
				if(StringUtils.isNotBlank(flightInfoDto.getReturnFlightNo())){
					flightNos += "~" + flightInfoDto.getReturnFlightNo() + "(" + flightInfoDto.getReturnSeatClassCode() + ")";
				}
				//返程乘机时间
				if(null != flightInfoDto.getReturnDepTime()){
					flightTimes += "~" + DateUtils.formatDate(flightInfoDto.getReturnDepTime(), DateUtils.YYYY_MM_DD_HH_MM);
				}
			}
		}
		orderListStr.append(flightSegments).append(",");
		orderListStr.append(flightNos).append(",");
		orderListStr.append(flightTimes).append(",");
		//预订人数
		String passengerCountDetail="";
		if(this.getPassengerCount()!=null){
			passengerCountDetail = String.valueOf(this.getPassengerCount());
			/*PassengerType passengerType = this.getPassengerType();
			passengerCountDetail+="("+passengerType.getCnName()+")";*/
		}
		orderListStr.append(passengerCountDetail).append(",");
		if(this.getPassengerType()!=null){
			orderListStr.append(this.getPassengerType().getCnName()).append(",");
		}
//		orderListStr.append(this.getPassengerCount()).append(",");
		//支付直减金额
		if (null == this.getOrderDirectReductionAmount()) {
			orderListStr.append(BigDecimal.ZERO).append(",");
		}else {
			orderListStr.append(this.getOrderDirectReductionAmount()).append(",");
		}
		orderListStr.append(this.getReceivableAmount()).append(",");
		//支付方式设置
		String paymentMethod = "";
		OrderType orderType = this.getOrderType();
		if(orderType == OrderType.NORMAL || orderType == OrderType.CTMT)
		{
			List<PaymentType> paymentTypes = this.getPaymentTypes();
			if(CollectionUtils.isNotEmpty(paymentTypes))
			{
				for(PaymentType paymentType : paymentTypes)
				{
					paymentMethod += paymentType.getCnName() + ",";
				}
				paymentMethod = paymentMethod.substring(0, paymentMethod.length() - 1);
			}
		}
		else
		{
			List<RefundmentType> refundmentTypes = this.getRefundmentTypes();
			if(CollectionUtils.isNotEmpty(refundmentTypes))
			{
				for(RefundmentType refundmentType : refundmentTypes)
				{
					paymentMethod += refundmentType.getCnName() + ",";
				}
				paymentMethod = paymentMethod.substring(0, paymentMethod.length() - 1);
			}
		}
		orderListStr.append(paymentMethod).append(",");
		orderListStr.append(paymentTypeStr).append(",");
		
		orderListStr.append(this.getContactName()).append(",");
		if(!StringUtils.isEmpty(this.getCustomerName())){
			orderListStr.append(this.getCustomerName().replaceAll("[,]", "")).append(",");
		}else{
			orderListStr.append(",");
		}
		
		orderListStr.append(DateUtils.formatDate(this.getOrderCreateTime(), DateUtils.YYYY_MM_DD_HH_MM_SS)).append(",");
		orderListStr.append(this.getBookingSource().getCnName()).append(",");
		//当前状态字符串设置
		FlightOrderStatusDto flightOrderStatusDto = this.getFlightOrderStatus();
		StringBuffer statusStr = new StringBuffer();
		if(flightOrderStatusDto != null)
		{
			if(null!=this.getFlightOrderStatus().getOrderBackStatus()){
				statusStr.append(this.getFlightOrderStatus().getOrderBackStatus().getCnName()).append("|");
			}
			if(null!=this.getFlightOrderStatus().getOrderAuditStatus()){
				statusStr.append(this.getFlightOrderStatus().getOrderAuditStatus().getCnName()).append("|");
			}
			if(null!=this.getFlightOrderStatus().getOrderTicketStatus()){
				statusStr.append(this.getFlightOrderStatus().getOrderTicketStatus().getCnName()).append("|");
			}
			if(null!=this.getFlightOrderStatus().getOrderPayStatus()){
				statusStr.append(this.getFlightOrderStatus().getOrderPayStatus().getCnName()).append("|");
			}
		}
		orderListStr.append(statusStr.toString().substring(0, statusStr.length() - 1));
		return orderListStr.toString();
    }

    @JsonIgnore
	@Override
	public Long getId() {
		return null;
	}

	public Supp getSupp() {
		return supp;
	}

	public void setSupp(Supp supp) {
		this.supp = supp;
	}

	public Long getOrderPreId() {
		return orderPreId;
	}

	public void setOrderPreId(Long orderPreId) {
		this.orderPreId = orderPreId;
	}
	
	public String getSuppOrderNo() {
		return SuppOrderNo;
	}

	public void setSuppOrderNo(String suppOrderNo) {
		SuppOrderNo = suppOrderNo;
	}

	public String getSalesMainOrderId() {
		return salesMainOrderId;
	}

	public void setSalesMainOrderId(String salesMainOrderId) {
		this.salesMainOrderId = salesMainOrderId;
	}

	public String getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(String salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public BigDecimal getOrderDirectReductionAmount() {
		return orderDirectReductionAmount;
	}

	public void setOrderDirectReductionAmount(BigDecimal orderDirectReductionAmount) {
		this.orderDirectReductionAmount = orderDirectReductionAmount;
	}


	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
		


	public Date getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(Date limitTime) {
		this.limitTime = limitTime;
	}

	public PassengerType getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}

	public List<FlightOrderDetailDto> getOrderDetailDtos() {
		return orderDetailDtos;
	}

	public void setOrderDetailDtos(List<FlightOrderDetailDto> orderDetailDtos) {
		this.orderDetailDtos = orderDetailDtos;
	}

	public String getPaymentTypeStr() {
		return paymentTypeStr;
	}

	public void setPaymentTypeStr(String paymentTypeStr) {
		this.paymentTypeStr = paymentTypeStr;
	}

	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
}
