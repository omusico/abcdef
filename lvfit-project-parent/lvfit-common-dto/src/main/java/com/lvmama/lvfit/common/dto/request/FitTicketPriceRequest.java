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
import java.util.Date;
import java.util.List;

/**
 * yueyufan
 * 
 */
public class FitTicketPriceRequest implements Serializable {
	/**
	 * serialVersionUID:TODO().
	 * 
	 * @since JDK 1.6
	 */
	private static final long serialVersionUID = 6499294250473006012L;
	
	private List<Long> suppGoodIds;
	/**
	 * 开始时期
	 */
	
	private Date startDate;
	
	/**
	 * 结束时期
	 */
	private Date endDate;
	
	public List<Long> getSuppGoodIds() {
		return suppGoodIds;
	}
	public void setSuppGoodIds(List<Long> suppGoodIds) {
		this.suppGoodIds = suppGoodIds;
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

}
