/**
 * Project Name:lvfit-common-dto
 * File Name:ChangeHotelRequest.java
 * Package Name:com.lvmama.lvfit.common.dto.request
 * Date:2015-12-13下午2:54:48
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;


/**
 * 选择门票景点参数
 * @author leizhengwei
 *
 */
public class ChangeTicketRequest implements Serializable {

	private static final long serialVersionUID = -725545293776239083L;
    
	private String shoppingUUID;

	/**景点Id */
	private String spotId;

	/**景点门票Id */
	private String spotTicketId;
	
	/**游玩日期 */
	private String playDate;
	
	/**所选商品预订份数 */
	private Integer quantity;

	public String getShoppingUUID() {
		return shoppingUUID;
	}

	public void setShoppingUUID(String shoppingUUID) {
		this.shoppingUUID = shoppingUUID;
	}

	public String getSpotId() {
		return spotId;
	}

	public void setSpotId(String spotId) {
		this.spotId = spotId;
	}

	public String getSpotTicketId() {
		return spotTicketId;
	}

	public void setSpotTicketId(String spotTicketId) {
		this.spotTicketId = spotTicketId;
	}

	public String getPlayDate() {
		return playDate;
	}

	public void setPlayDate(String playDate) {
		this.playDate = playDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

}
