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
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedTicketDto;


/**
 * 
 * @author leizhengwei
 *
 */
public class FitSpotTicketPriceRequest implements Serializable {
	
	private static final long serialVersionUID = -7156001318448894274L;

    private List<FitShoppingSelectedTicketDto> selectTicketInfos = new ArrayList<FitShoppingSelectedTicketDto>();

	public List<FitShoppingSelectedTicketDto> getSelectTicketInfos() {
		return selectTicketInfos;
	}

	public void setSelectTicketInfos(
			List<FitShoppingSelectedTicketDto> selectTicketInfos) {
		this.selectTicketInfos = selectTicketInfos;
	}

	
    
}
