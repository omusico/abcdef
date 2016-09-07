/**
 * Project Name:lvfit-common-dto
 * File Name:ChangeFlightRequest.java
 * Package Name:com.lvmama.lvfit.common.dto.request
 * Date:2015-12-13下午2:54:38
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;

/**
 * ClassName:ChangeFlightRequest <br/>
 * Function: 修改航班请求参数. <br/>
 * Date: 2015-12-13 下午2:54:38 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public class ChangeFlightRequest implements Serializable {
	private static final long serialVersionUID = -1796735503152280226L;

	private String shoppingUUID;
	/** 航班号 */
	private String flightNo;
	private String seatCode;
	/**去程/返程*/
	private String flightType;
	
	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}
	public String getShoppingUUID() {
		return shoppingUUID;
	}
	public void setShoppingUUID(String shoppingUUID) {
		this.shoppingUUID = shoppingUUID;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getSeatCode() {
		return seatCode;
	}
	public void setSeatCode(String seatCode) {
		this.seatCode = seatCode;
	}
	
}
