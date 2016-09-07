/**
 * Project Name:lvfit-common-dto
 * File Name:FitHotelDetailRequest.java
 * Package Name:com.lvmama.lvfit.common.dto.hotel
 * Date:2015-12-4下午5:07:22
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;

/**
 * ClassName:FitHotelDetailRequest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-12-4 下午5:07:22 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class FitHotelDetailRequest implements Serializable{

	/**
	 * serialVersionUID.
	 * @since JDK 1.6
	 */
	private static final long serialVersionUID = -5236223445758622165L;
	/**
	 * 酒店id(对应vstProductId)
	 */
	private Long hotelId;
	private boolean hasProp ;
	private boolean hasPropValue ;
	
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public boolean isHasProp() {
		return hasProp;
	}
	public void setHasProp(boolean hasProp) {
		this.hasProp = hasProp;
	}
	public boolean isHasPropValue() {
		return hasPropValue;
	}
	public void setHasPropValue(boolean hasPropValue) {
		this.hasPropValue = hasPropValue;
	}

}

