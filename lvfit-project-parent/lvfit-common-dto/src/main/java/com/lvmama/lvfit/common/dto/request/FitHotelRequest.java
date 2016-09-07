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
import java.util.HashMap;
import java.util.Map;

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
public class FitHotelRequest implements Serializable {
	/**
	 * serialVersionUID:TODO().
	 * 
	 * @since JDK 1.6
	 */
	private static final long serialVersionUID = 6499294250473006012L;
	/**
	 *  ID
	 *  @author hui
	 */
	private Long hotelId;
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
	
	private static Map<String, Object>  conditionMap = new HashMap<String, Object>();
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	static{
		conditionMap.put("getTopTwo", "false");
		conditionMap.put("getPropInfo", "false");
		conditionMap.put("hasProp", Boolean.TRUE);
		conditionMap.put("hasPropValue", Boolean.TRUE);
		conditionMap.put("removeRepeat", Boolean.TRUE);
		conditionMap.put("followOrder", "lvmamaRecommd");
		conditionMap.put("orderProdBranchFlag", Boolean.TRUE);
		conditionMap.put("orderProdFlag", Boolean.TRUE);
	}
	
	public static Map<String, Object> getConditionMap() {
		return conditionMap;
	}
	public static void setConditionMap(Map<String, Object> conditionMap) {
		FitHotelRequest.conditionMap = conditionMap;
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
}
