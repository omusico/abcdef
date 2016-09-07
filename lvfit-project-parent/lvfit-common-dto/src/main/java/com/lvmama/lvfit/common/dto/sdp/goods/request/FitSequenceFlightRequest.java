package com.lvmama.lvfit.common.dto.sdp.goods.request;

import java.io.Serializable;

public class FitSequenceFlightRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5614837235377233852L;
	
	private String shoppingUuid;
	
	private String flightTripType;
	//排序字段
	private String sortStr;
	//排序规则
	private String sortType;
	
	public String getShoppingUuid() {
		return shoppingUuid;
	}
	public void setShoppingUuid(String shoppingUuid) {
		this.shoppingUuid = shoppingUuid;
	}
	public String getFlightTripType() {
		return flightTripType;
	}
	public void setFlightTripType(String flightTripType) {
		this.flightTripType = flightTripType;
	}
	public String getSortStr() {
		return sortStr;
	}
	public void setSortStr(String sortStr) {
		this.sortStr = sortStr;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	
}
