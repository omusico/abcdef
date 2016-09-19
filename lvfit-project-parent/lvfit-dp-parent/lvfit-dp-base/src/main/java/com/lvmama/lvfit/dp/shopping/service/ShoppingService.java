package com.lvmama.lvfit.dp.shopping.service;

import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;

public interface ShoppingService{

	FitShoppingDto getFitShopping(String shoppingUUID);
	boolean putShoppingCache(String shoppingUUID, FitShoppingDto dto);
}
