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
import java.util.Date;

/**
 * 
 * yueyufan	 
 */
public class FitTicketDetailRequest implements Serializable{

	/**
	 * serialVersionUID.
	 * @since JDK 1.6
	 */
	private static final long serialVersionUID = -5236223445758622165L;
	
	/**
	 * 商品Id
	 */
	private Long suppGoodsId;

	public Long getSuppGoodsId() {
		return suppGoodsId;
	}

	public void setSuppGoodsId(Long suppGoodsId) {
		this.suppGoodsId = suppGoodsId;
	}

}

