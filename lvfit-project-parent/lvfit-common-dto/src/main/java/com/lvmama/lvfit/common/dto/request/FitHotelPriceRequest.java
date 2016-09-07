/**
 * Project Name:lvfit-common-dto
 * File Name:FitHotelRequest.java
 * Package Name:com.lvmama.lvfit.common.dto.hotel
 * Date:2015-12-4下午5:35:22
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ClassName:FitHotelRequest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-4 下午5:35:22 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public class FitHotelPriceRequest implements Serializable {
	/**
	 * serialVersionUID:TODO().
	 * 
	 * @since JDK 1.6
	 */
	private static final long serialVersionUID = 6499294250473006012L;
	/**
	 *  ID
	 *  @author zengzhimin
	 */
	private Long pricePlanId;
	/**
	 * 开始时期
	 */
	private Date startDate;
	/**
	 * 结束时期
	 */
	private Date endDate;
	/**
	 *  是否可售
	 */
	private String isSale;
	
	/**
	 *  所需的总房间数
	 */
	private BigDecimal roomCount;
	
	public Long getPricePlanId() {
		return pricePlanId;
	}
	public void setPricePlanId(Long pricePlanId) {
		this.pricePlanId = pricePlanId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getIsSale() {
		return isSale;
	}
	public void setIsSale(String isSale) {
		this.isSale = isSale;
	}
	public BigDecimal getRoomCount() {
		return roomCount;
	}
	public void setRoomCount(BigDecimal roomCount) {
		this.roomCount = roomCount;
	}
	
	
}
