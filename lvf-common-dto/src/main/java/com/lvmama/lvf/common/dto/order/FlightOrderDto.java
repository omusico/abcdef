package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.Oper;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.enums.Product;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderPaymentDto;
import com.lvmama.lvf.common.dto.order.pay.FlightOrderRefundDto;
import com.lvmama.lvf.common.dto.order.status.FlightOrderStatusDto;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppOrderDto;

/**
 * 订单信息
 * 
 * @author majun
 * @date 2015-1-13
 */
public class FlightOrderDto extends Entity implements Serializable {
    private static final long serialVersionUID = -3470485440368662800L;

    /** 订单号信息 */
    private FlightOrderNoDto flightOrderNo;

    /** 主订单主键 */
    private Long orderMainId;

    /** 前一个订单主键 */
    private Long orderPreId;

    /** 订单Root主键(用于标记同一订单的后续退改签关联关系) */
    private Long orderRootId;
    
    /** 审核操作主键 */
    private Long auditOpId;
    
    /** 订单金额信息 */
    private FlightOrderAmountDto flightOrderAmount;

    /** 订单类型 */
    private OrderType orderType;
    
    /** 产品名称 */
    private Product product;
    
    /** 订单排序编码*/
    private String orderSortCode;
    
    /** 供应商订单信息 */
    @XmlTransient
    private List<FlightOrderSuppOrderDto> flightOrderSuppOrders = new ArrayList<FlightOrderSuppOrderDto>();
    
    /** 订单备注信息 */
	private List<FlightOrderRemarkDto> flightOrderRemarks = new ArrayList<FlightOrderRemarkDto>();

    /** 关联订单信息 */
    private List<FlightOrderLinkInfoDto> flightOrderLinkInfos = new ArrayList<FlightOrderLinkInfoDto>();

    /** 订单操作者信息 */
    private FlightOrderOperDto flightOrderOper;

    /** 订单操作状态信息 */
    //private FlightOrderOpStatusDto flightOrderOpStatus;

    /** 订单状态 */
    private FlightOrderStatusDto flightOrderStatus;

    /** 订单明细信息 */
    private List<FlightOrderDetailDto> flightOrderDetails = new ArrayList<FlightOrderDetailDto>();

    /** 订单操作日志 */
    private List<OrderOpLogDto> orderOpLogDto = new ArrayList<OrderOpLogDto>();
    
    /** 订单支付信息 */
    private List<FlightOrderPaymentDto> flightOrderPayments = new ArrayList<FlightOrderPaymentDto>();
    
    /** 订单退款信息 */
    private List<FlightOrderRefundDto> flightOrderRefunds = new ArrayList<FlightOrderRefundDto>();
    
	/** 订单预订来源 */
	private BookingSource bookingSource; 
	
	/**预定完成时间*/
	private Date finishBookingTime;
	
	/** 支付完成时间 */
	private Date payedTime;
	
	/**支付等待时间*/
	private Date limitTime;
	
	/** 操作提交者 */
	private Oper oper;
	/** 分销信息dto*/
	private FlightOrderCPSInfoDto flightOrderCPSInfoDto;
	/**主订单号**/
	private String orderMainNo;
	
	//优惠券金额
	private BigDecimal couponPrice;
	
	public BigDecimal getCouponPrice() {
		return couponPrice;
	}

	public void setCouponPrice(BigDecimal couponPrice) {
		this.couponPrice = couponPrice;
	}

	public Date getPayedTime() {
		return payedTime;
	}

	public void setPayedTime(Date payedTime) {
		this.payedTime = payedTime;
	}

	public Date getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(Date limitTime) {
		this.limitTime = limitTime;
	}

	public Date getFinishBookingTime() {
		return finishBookingTime;
	}

	public void setFinishBookingTime(Date finishBookingTime) {
		this.finishBookingTime = finishBookingTime;
	}

	public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}

	public FlightOrderNoDto getFlightOrderNo() {
        return flightOrderNo;
    }

    public void setFlightOrderNo(FlightOrderNoDto flightOrderNo) {
        this.flightOrderNo = flightOrderNo;
    }

    public Long getOrderMainId() {
        return orderMainId;
    }

    public void setOrderMainId(Long orderMainId) {
        this.orderMainId = orderMainId;
    }

    public Long getOrderPreId() {
        return orderPreId;
    }

    public void setOrderPreId(Long orderPreId) {
        this.orderPreId = orderPreId;
    }

    public Long getOrderRootId() {
        return orderRootId;
    }

    public void setOrderRootId(Long orderRootId) {
        this.orderRootId = orderRootId;
    }

    public Long getAuditOpId() {
        return auditOpId;
    }

    public void setAuditOpId(Long auditOpId) {
        this.auditOpId = auditOpId;
    }

    public FlightOrderAmountDto getFlightOrderAmount() {
        return flightOrderAmount;
    }

    public void setFlightOrderAmount(FlightOrderAmountDto flightOrderAmount) {
        this.flightOrderAmount = flightOrderAmount;
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

	public String getOrderSortCode() {
		return orderSortCode;
	}

	public void setOrderSortCode(String orderSortCode) {
		this.orderSortCode = orderSortCode;
	}

	public List<FlightOrderSuppOrderDto> getFlightOrderSuppOrders() {
        return flightOrderSuppOrders;
    }

    public void setFlightOrderSuppOrders(List<FlightOrderSuppOrderDto> flightOrderSuppOrders) {
        this.flightOrderSuppOrders = flightOrderSuppOrders;
    }

    public List<FlightOrderRemarkDto> getFlightOrderRemarks() {
		return flightOrderRemarks;
	}

	public void setFlightOrderRemarks(List<FlightOrderRemarkDto> flightOrderRemarks) {
		this.flightOrderRemarks = flightOrderRemarks;
	}

	public List<FlightOrderLinkInfoDto> getFlightOrderLinkInfos() {
        return flightOrderLinkInfos;
    }

    public void setFlightOrderLinkInfos(List<FlightOrderLinkInfoDto> flightOrderLinkInfos) {
        this.flightOrderLinkInfos = flightOrderLinkInfos;
    }

    public FlightOrderOperDto getFlightOrderOper() {
        return flightOrderOper;
    }

    public void setFlightOrderOper(FlightOrderOperDto flightOrderOper) {
        this.flightOrderOper = flightOrderOper;
    }

    public FlightOrderStatusDto getFlightOrderStatus() {
        return flightOrderStatus;
    }

    public void setFlightOrderStatus(FlightOrderStatusDto flightOrderStatus) {
        this.flightOrderStatus = flightOrderStatus;
    }

    public List<FlightOrderDetailDto> getFlightOrderDetails() {
        return flightOrderDetails;
    }

    public void setFlightOrderDetails(List<FlightOrderDetailDto> flightOrderDetails) {
        this.flightOrderDetails = flightOrderDetails;
    }

    public List<OrderOpLogDto> getOrderOpLogDto() {
        return orderOpLogDto;
    }

    public void setOrderOpLogDto(List<OrderOpLogDto> orderOpLogDto) {
        this.orderOpLogDto = orderOpLogDto;
    }

    public List<FlightOrderPaymentDto> getFlightOrderPayments() {
		return flightOrderPayments;
	}

	public void setFlightOrderPayments(
			List<FlightOrderPaymentDto> flightOrderPayments) {
		this.flightOrderPayments = flightOrderPayments;
	}

	public List<FlightOrderRefundDto> getFlightOrderRefunds() {
		return flightOrderRefunds;
	}

	public void setFlightOrderRefunds(List<FlightOrderRefundDto> flightOrderRefunds) {
		this.flightOrderRefunds = flightOrderRefunds;
	}

	@Override
    @JsonIgnore
    public String getSequence() {
        return "S_FORD_ORDER";
    }

	public Oper getOper() {
		return oper;
	}

	public void setOper(Oper oper) {
		this.oper = oper;
	}

	public FlightOrderCPSInfoDto getFlightOrderCPSInfoDto() {
		return flightOrderCPSInfoDto;
	}

	public void setFlightOrderCPSInfoDto(FlightOrderCPSInfoDto flightOrderCPSInfoDto) {
		this.flightOrderCPSInfoDto = flightOrderCPSInfoDto;
	}

	public String getOrderMainNo() {
		return orderMainNo;
	}

	public void setOrderMainNo(String orderMainNo) {
		this.orderMainNo = orderMainNo;
	}

	

	
	
	
}
