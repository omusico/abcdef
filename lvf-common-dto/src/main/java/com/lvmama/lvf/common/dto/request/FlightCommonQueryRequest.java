package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.OrderFlag;
import com.lvmama.lvf.common.dto.enums.OrderNoType;
import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.order.FlightOrderContacterDto;
import com.lvmama.lvf.common.dto.order.FlightOrderCustomerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;
import com.lvmama.lvf.common.dto.order.status.FlightOrderStatusDto;
import com.lvmama.lvf.common.dto.status.OpSource;

@XmlRootElement
public class FlightCommonQueryRequest implements Serializable, Dto {

    private static final long serialVersionUID = -6917426056315381405L;

    /**************************** 订单信息 *********************************/

    /**
     * 主订单id
     */
   private Long orderMainId;
    
   /**
    * 订单id
    */
    private Long orderId;
    
    /** 订单号类型 */
    private OrderNoType orderNoType;
    
    /**
     * 子订单号
     */
    private String orderNo;
    /**
     * 主订单号
     */
    private String orderMainNo;
    /**
     * 采购订单
     */
    private String purOrderNo;
    /**
     * 供应订单
     */
    private String suppOrderNo;

    /**
     * 下单人工号
     */
    private String bookingManualNo;

    /**
     * 下单查询开始时间
     */
    private String orderBookingQueryBegTime;

    /**
     * 下单查询截止时间
     */
    private String orderBookingQueryEndTime;

    /**
     * 订单类型
     */
    private OrderType orderType;

    /**
     * 订单状态集合
     */
    @XmlTransient
    private FlightOrderStatusDto flightOrderStatus;

    /**
     * 支付查询开始时间
     */
    private String payQueryBegTime;

    /**
     * 支付查询截止时间
     */
    private String payQueryEndTime;

    /**
     * 预订来源
     */
    private List<BookingSource> bookingSources = new ArrayList<BookingSource>();

    /**
     * 支付方式
     */
    private List<PaymentType> paymentType = new ArrayList<PaymentType>();
    
    /**
     * 支付单号
     */
    private String paymentNo;

    /**************************** 产品信息 *********************************/

	/**
     * PNR编码
     */
    private String pnr;

    /**
     * 票号
     */
    private String ticketNo;

    /**
     * 航班号
     */
    private String flightNo;
    
    /**航班公司名称 */
	private String carrierName;

    /**
     * 供应商名称
     */
    private String suppName;

    /**
     * 出发城市
     */
    private String departureCity;

    /**
     * 到达城市
     */
    private String arriveCity;

    /**
     * 乘机开始查询时间
     */
    private String flightQueryBegTime;

    /**
     * 乘机截止查询时间
     */
    private String flightQueryEndTime;

    /**************************** 游客信息 *********************************/

    /** 客户信息 */
    private FlightOrderCustomerDto flightOrderCustomer;

    /**
     * 乘机人信息
     */
    private FlightOrderPassengerDto flightOrderPassenger;

    /**
     * 联系人信息
     */
    private FlightOrderContacterDto flightOrderContacter;

    /**
     * 操作源
     */
    private OpSource opSource;
    
    private String isDirectReduct;

    private String saleType;

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

	public OrderNoType getOrderNoType() {
		return orderNoType;
	}

	public String getOrderMainNo() {
		return orderMainNo;
	}

	public void setOrderMainNo(String orderMainNo) {
		this.orderMainNo = orderMainNo;
	}

	public String getPurOrderNo() {
		return purOrderNo;
	}

	public void setPurOrderNo(String purOrderNo) {
		this.purOrderNo = purOrderNo;
	}

	public String getSuppOrderNo() {
		return suppOrderNo;
	}

	public void setSuppOrderNo(String suppOrderNo) {
		this.suppOrderNo = suppOrderNo;
	}

	public void setOrderNoType(OrderNoType orderNoType) {
		this.orderNoType = orderNoType;
	}

	public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getBookingManualNo() {
        return bookingManualNo;
    }

    public void setBookingManualNo(String bookingManualNo) {
        this.bookingManualNo = bookingManualNo;
    }

    public String getOrderBookingQueryBegTime() {
        return orderBookingQueryBegTime;
    }

    public void setOrderBookingQueryBegTime(String orderBookingQueryBegTime) {
        this.orderBookingQueryBegTime = orderBookingQueryBegTime;
    }

    public String getOrderBookingQueryEndTime() {
        return orderBookingQueryEndTime;
    }

    public void setOrderBookingQueryEndTime(String orderBookingQueryEndTime) {
        this.orderBookingQueryEndTime = orderBookingQueryEndTime;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public FlightOrderStatusDto getFlightOrderStatus() {
        return flightOrderStatus;
    }

    public void setFlightOrderStatus(FlightOrderStatusDto flightOrderStatus) {
        this.flightOrderStatus = flightOrderStatus;
    }

    public String getPayQueryBegTime() {
        return payQueryBegTime;
    }

    public void setPayQueryBegTime(String payQueryBegTime) {
        this.payQueryBegTime = payQueryBegTime;
    }

    public String getPayQueryEndTime() {
        return payQueryEndTime;
    }

    public void setPayQueryEndTime(String payQueryEndTime) {
        this.payQueryEndTime = payQueryEndTime;
    }

    public List<BookingSource> getBookingSources() {
		return bookingSources;
	}

	public void setBookingSources(List<BookingSource> bookingSources) {
		this.bookingSources = bookingSources;
	}

	public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArriveCity() {
        return arriveCity;
    }

    public void setArriveCity(String arriveCity) {
        this.arriveCity = arriveCity;
    }

    public String getFlightQueryBegTime() {
        return flightQueryBegTime;
    }

    public void setFlightQueryBegTime(String flightQueryBegTime) {
        this.flightQueryBegTime = flightQueryBegTime;
    }

    public String getFlightQueryEndTime() {
        return flightQueryEndTime;
    }

    public void setFlightQueryEndTime(String flightQueryEndTime) {
        this.flightQueryEndTime = flightQueryEndTime;
    }
    
    public FlightOrderCustomerDto getFlightOrderCustomer() {
		return flightOrderCustomer;
	}

	public void setFlightOrderCustomer(FlightOrderCustomerDto flightOrderCustomer) {
		this.flightOrderCustomer = flightOrderCustomer;
	}

	public FlightOrderPassengerDto getFlightOrderPassenger() {
        return flightOrderPassenger;
    }

    public void setFlightOrderPassenger(
            FlightOrderPassengerDto flightOrderPassenger) {
        this.flightOrderPassenger = flightOrderPassenger;
    }

    public FlightOrderContacterDto getFlightOrderContacter() {
        return flightOrderContacter;
    }

    public void setFlightOrderContacter(
            FlightOrderContacterDto flightOrderContacter) {
        this.flightOrderContacter = flightOrderContacter;
    }

    public OpSource getOpSource() {
        return opSource;
    }

    public void setOpSource(OpSource opSource) {
        this.opSource = opSource;
    }

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
    public List<PaymentType> getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(List<PaymentType> paymentType) {
		this.paymentType = paymentType;
	}
	

    public String getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}

	@JsonIgnore
    @Override
    public Long getId() {
        return null;
    }

	public final String getIsDirectReduct() {
		return isDirectReduct;
	}

	public final void setIsDirectReduct(String isDirectReduct) {
		this.isDirectReduct = isDirectReduct;
	}

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }
}
