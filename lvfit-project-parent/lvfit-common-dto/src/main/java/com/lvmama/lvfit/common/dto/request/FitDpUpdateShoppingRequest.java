package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;

public class FitDpUpdateShoppingRequest implements Serializable {
	 
	private static final long serialVersionUID = -2786941613646520857L;

	// 购物车ID
    private String shoppingUuid;
    
    FitShoppingDto shoppingDto;

	public String getShoppingUuid() {
		return shoppingUuid;
	}

	public void setShoppingUuid(String shoppingUuid) {
		this.shoppingUuid = shoppingUuid;
	}

	public FitShoppingDto getShoppingDto() {
		return shoppingDto;
	}

	public void setShoppingDto(FitShoppingDto shoppingDto) {
		this.shoppingDto = shoppingDto;
	}
}
