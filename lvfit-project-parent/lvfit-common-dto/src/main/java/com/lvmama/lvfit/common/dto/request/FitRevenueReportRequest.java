/**
 * Project Name:lvfit-common-dto
 * File Name:FitRevenueReportRequest.java
 * Package Name:com.lvmama.lvfit.common.dto.request
 * Date:2016-1-4下午3:24:22
 * Copyright (c) 2016, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.status.order.OrderBackStatus;
import com.lvmama.lvfit.common.dto.status.order.OrderPayStatus;

/**
 * ClassName:FitRevenueReportRequest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2016-1-4 下午3:24:22 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public class FitRevenueReportRequest implements Serializable, Dto {

	private static final long serialVersionUID = 8267328501392934639L;
	/** 主订单NO */
	private String orderMainNo;

	/** 订单NO */
	private String orderNo;

	/** 预定开始时间 */
	private String bookingBeginTime;

	/** 预定截止时间 */
	private String bookingEndTime;

	/** 销售渠道 */
	private BookingSource bookingSource;
	/**
	 * 订单后台状态
	 */
	private OrderBackStatus orderBackStatus;

	/** 订单支付状态 */
	private OrderPayStatus orderPayStatus;

	@Override
	public Long getId() {
		return null;
	}

	/**
	 * orderMainNo.
	 *
	 * @return  the orderMainNo
	 * @since   JDK 1.6
	 */
	public String getOrderMainNo() {
		return orderMainNo;
	}

	/**
	 * orderMainNo.
	 *
	 * @param   orderMainNo    the orderMainNo to set
	 * @since   JDK 1.6
	 */
	public void setOrderMainNo(String orderMainNo) {
		this.orderMainNo = orderMainNo;
	}

	/**
	 * orderNo.
	 *
	 * @return  the orderNo
	 * @since   JDK 1.6
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * orderNo.
	 *
	 * @param   orderNo    the orderNo to set
	 * @since   JDK 1.6
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * bookingBeginTime.
	 *
	 * @return  the bookingBeginTime
	 * @since   JDK 1.6
	 */
	public String getBookingBeginTime() {
		return bookingBeginTime;
	}

	/**
	 * bookingBeginTime.
	 *
	 * @param   bookingBeginTime    the bookingBeginTime to set
	 * @since   JDK 1.6
	 */
	public void setBookingBeginTime(String bookingBeginTime) {
		this.bookingBeginTime = bookingBeginTime;
	}

	/**
	 * bookingEndTime.
	 *
	 * @return  the bookingEndTime
	 * @since   JDK 1.6
	 */
	public String getBookingEndTime() {
		return bookingEndTime;
	}

	/**
	 * bookingEndTime.
	 *
	 * @param   bookingEndTime    the bookingEndTime to set
	 * @since   JDK 1.6
	 */
	public void setBookingEndTime(String bookingEndTime) {
		this.bookingEndTime = bookingEndTime;
	}

	/**
	 * bookingSource.
	 *
	 * @return  the bookingSource
	 * @since   JDK 1.6
	 */
	public BookingSource getBookingSource() {
		return bookingSource;
	}

	/**
	 * bookingSource.
	 *
	 * @param   bookingSource    the bookingSource to set
	 * @since   JDK 1.6
	 */
	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}

	/**
	 * orderBackStatus.
	 *
	 * @return  the orderBackStatus
	 * @since   JDK 1.6
	 */
	public OrderBackStatus getOrderBackStatus() {
		return orderBackStatus;
	}

	/**
	 * orderBackStatus.
	 *
	 * @param   orderBackStatus    the orderBackStatus to set
	 * @since   JDK 1.6
	 */
	public void setOrderBackStatus(OrderBackStatus orderBackStatus) {
		this.orderBackStatus = orderBackStatus;
	}

	/**
	 * orderPayStatus.
	 *
	 * @return  the orderPayStatus
	 * @since   JDK 1.6
	 */
	public OrderPayStatus getOrderPayStatus() {
		return orderPayStatus;
	}

	/**
	 * orderPayStatus.
	 *
	 * @param   orderPayStatus    the orderPayStatus to set
	 * @since   JDK 1.6
	 */
	public void setOrderPayStatus(OrderPayStatus orderPayStatus) {
		this.orderPayStatus = orderPayStatus;
	}
	
	

}
