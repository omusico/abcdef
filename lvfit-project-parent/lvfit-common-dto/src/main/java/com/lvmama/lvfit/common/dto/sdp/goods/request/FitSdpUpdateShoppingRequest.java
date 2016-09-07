package com.lvmama.lvfit.common.dto.sdp.goods.request;

import java.io.Serializable;

import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpShoppingDto;

public class FitSdpUpdateShoppingRequest implements Serializable {
	
	private static final long serialVersionUID = 5144639179370576929L;
	// 购物车ID
    private String ShoppingUuid;
    //商品信息
    private FitSdpShoppingDto shoppingDto;
    
	public String getShoppingUuid() {
		return ShoppingUuid;
	}
	public void setShoppingUuid(String shoppingUuid) {
		ShoppingUuid = shoppingUuid;
	}
	public FitSdpShoppingDto getShoppingDto() {
		return shoppingDto;
	}
	public void setShoppingDto(FitSdpShoppingDto shoppingDto) {
		this.shoppingDto = shoppingDto;
	}
}
