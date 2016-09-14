package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.enums.OrderType;
import com.lvmama.lvf.common.dto.status.order.OrderPayStatus;

/**
 * 营收查询列表请求对象
 * 
 * @author hedandan
 * @date 2015-7-14
 */
@XmlRootElement
public class RevenueReportRequest implements Serializable, Dto {

    private static final long serialVersionUID = -4052919843468489581L;
    
    /** 主订单NO */
    private String orderMainNo;
    
    /** 订单NO */
    private String orderNo;

    /** 预定开始时间 */
    private String bookingQueryBegTime;

    /** 预定截止时间 */
    private String bookingQueryEndTime;
    
    /** 处理开始时间 */
    private String commitBegTime;

    /** 处理截止时间 */
    private String commitEndTime;

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

    /** 出发机场三字代码 */
    private String depCode;

    /** 出发机场名称 */
    private String depName;

    /** 到达机场三字代码 */
    private String arrCode;

    /** 到达机场名称 */
    private String arrName;
    
    /** 订单支付状态 */
    private OrderPayStatus orderPayStatus;
    
    /** 子订单id*/
    private Long orderId;

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

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getArrCode() {
        return arrCode;
    }

    public void setArrCode(String arrCode) {
        this.arrCode = arrCode;
    }

    public String getArrName() {
        return arrName;
    }

    public void setArrName(String arrName) {
        this.arrName = arrName;
    }

    
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCommitBegTime() {
        return commitBegTime;
    }

    public void setCommitBegTime(String commitBegTime) {
        this.commitBegTime = commitBegTime;
    }

    public String getCommitEndTime() {
        return commitEndTime;
    }

    public void setCommitEndTime(String commitEndTime) {
        this.commitEndTime = commitEndTime;
    }

    public OrderPayStatus getOrderPayStatus() {
        return orderPayStatus;
    }

    public void setOrderPayStatus(OrderPayStatus orderPayStatus) {
        this.orderPayStatus = orderPayStatus;
    }

    public String getOrderMainNo() {
		return orderMainNo;
	}

	public void setOrderMainNo(String orderMainNo) {
		this.orderMainNo = orderMainNo;
	}

	@JsonIgnore
    @Override
    public Long getId() {
        return null;
    }

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

}
