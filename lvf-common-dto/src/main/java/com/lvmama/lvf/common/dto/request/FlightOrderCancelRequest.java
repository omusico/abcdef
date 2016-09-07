package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.order.FlightOrderRemarkDto;

/**
 * 取消订单信息请求对象
 * 
 * @author yuanweihong
 * @date 2015-3-20
 */
public class FlightOrderCancelRequest implements Serializable {

    private static final long serialVersionUID = 8380741742529659948L;

    /** 订单主键 */
    private Long orderMainId;

    /** 子订单主键 */
    private Long orderId;

    /** 订单备注信息 */
    private FlightOrderRemarkDto flightOrderRemarkDto;
    
    /** 订单取消时间 */
    private String limitTime;
    
    /** 订单取消渠道 */
	private BookingSource bookingSource;
    

    public String getLimitTime() {
		return limitTime;
	}

	public void setLimitTime(String limitTime) {
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

    public FlightOrderRemarkDto getFlightOrderRemarkDto() {
        return flightOrderRemarkDto;
    }

    public void setFlightOrderRemarkDto(FlightOrderRemarkDto flightOrderRemarkDto) {
        this.flightOrderRemarkDto = flightOrderRemarkDto;
    }

	public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}

}
