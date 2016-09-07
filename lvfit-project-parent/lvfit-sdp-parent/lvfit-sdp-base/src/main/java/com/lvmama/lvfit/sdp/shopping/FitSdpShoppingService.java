package com.lvmama.lvfit.sdp.shopping;

import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpShoppingDto;

public interface FitSdpShoppingService {

	/**
	 * 产品购物车信息入缓存
	 * @param sdpShoppingDto
	 * @return
	 */
	boolean putShoppingCache(String shoppingUUID,FitSdpShoppingDto sdpShoppingDto);
	
	/**
	 * 根据购物车id从缓存获取购物车商品信息
	 * @param shoppingUUID
	 * @return
	 */
	FitSdpShoppingDto getFitSdpShoppingDto(String shoppingUuid);
	
	/**
	 * 更换航班信息
	 * @return
	 */
	boolean updateFlightInfo();
	
	/**
	 * 更换酒店套餐信息
	 * @return
	 */
	boolean updateHotelComboGoods();
	
	
	/**..................................................更换其他品类信息，待补全------------------------------------ */
	
	
	
	
	
}
