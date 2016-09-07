package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.BalanceType;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.OrderType;

/**
 * 财务报表查询列表请求对象
 * 
 * @author zengzhimin
 * @date 2016-07-26
 */
@XmlRootElement
public class FinancialReportRequest implements Serializable, Dto {

    private static final long serialVersionUID = -4052919843468489581L;
    
    /** 主订单NO */
    private String orderMainNo;
    
    /** 订单NO */
    private String orderNo;

    /** 预定开始时间 */
    private String bookingQueryBegTime;

    /** 预定截止时间 */
    private String bookingQueryEndTime;
    
    /** 航空公司 */
    private String carrierCode;

    /** 供应商 */
    private String suppCode;

    /** 销售渠道 */
    private List<BookingSource> bookingSources = new ArrayList<BookingSource>();

	/** 航班开始日期 */
    private String flightQueryBegTime;

    /** 航班截止时间 */
    private String flightQueryEndTime;

    /** 订单类型 */
    private OrderType orderType;
    /**收支类型**/
    private BalanceType balanceType;
    /** 支付/退款 订单号**/
    private String payRefundNo;
    
    public String getBookingQueryBegTime() {
        return bookingQueryBegTime;
    }

    public void setBookingQueryBegTime(String bookingQueryBegTime) {
        this.bookingQueryBegTime = bookingQueryBegTime;
    }

    public String getBookingQueryEndTime() {
        return bookingQueryEndTime;
    }

    public void setBookingQueryEndTime(String bookingQueryEndTime) {
        this.bookingQueryEndTime = bookingQueryEndTime;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public List<BookingSource> getBookingSources() {
    	return bookingSources;
    }
    
    public void setBookingSources(List<BookingSource> bookingSources) {
    	this.bookingSources = bookingSources;
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

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
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

	 
	public BalanceType getBalanceType() {
		return balanceType;
	}

	public void setBalanceType(BalanceType balanceType) {
		this.balanceType = balanceType;
	}

	public String getPayRefundNo() {
		return payRefundNo;
	}

	public void setPayRefundNo(String payRefundNo) {
		this.payRefundNo = payRefundNo;
	}

	@JsonIgnore
    @Override
    public Long getId() {
        return null;
    }

}
