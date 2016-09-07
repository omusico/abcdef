/**
 * Project Name:lvfit-online-base
 * File Name:ChangeFlightRequestForm.java
 * Package Name:com.lvmama.lvfit.online.shopping.form
 * Date:2015-12-15下午3:54:32
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.online.shopping.form;

import com.lvmama.lvf.common.form.Form;

/**
 * ClassName:ChangeFlightRequestForm <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-15 下午3:54:32 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public class ChangeFlightRequestForm implements Form {
	
	private String shoppingUUID;
	private String flightUUID;

	/** 航班号Id */
	private Long flightId;

	/** 航班号 */
	private String flightNo;

	/** 舱位Id */
	private Long seatId;
	
	/** 舱位code*/
	private String seatCode;

	 /**内部政策Id */
	private Long policyId;
	
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

	public String getFlightUUID() {
		return flightUUID;
	}

	public void setFlightUUID(String flightUUID) {
		this.flightUUID = flightUUID;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public String getSeatCode() {
		return seatCode;
	}

	public void setSeatCode(String seatCode) {
		this.seatCode = seatCode;
	}

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}
	
	

}
