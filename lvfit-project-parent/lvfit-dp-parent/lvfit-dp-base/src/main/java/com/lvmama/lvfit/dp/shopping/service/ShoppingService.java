package com.lvmama.lvfit.dp.shopping.service;

import java.util.List;
import java.util.Map;

import com.lvmama.lvfit.common.dto.request.ChangeFlightRequest;
import com.lvmama.lvfit.common.dto.request.ChangeHotelRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;

public interface ShoppingService{

	
	public FitSearchRequest getFitSearchRequest(String shoppingUUID);
	
	public FitShoppingDto getFitShopping(String shoppingUUID);
	public boolean putShoppingCache(String shoppingUUID, FitShoppingDto dto);
	
	public FitSearchResult getFlightSearchResult(String shoppingUUID);
	public boolean putFlightSearchResult(String shoppingUUID,FitSearchResult infos);
	public FitShoppingDto changedFlight(ChangeFlightRequest request);

	public List<HotelSearchHotelDto> getHotelSearchResult(String shoppingUUID);
	public boolean putHotelSearchResult(String shoppingUUID,List<HotelSearchHotelDto> infos);
	public FitShoppingDto changedHotel(ChangeHotelRequest request);
	
	public Map<String,Object> getHotelCondition(String shoppingUUID);
	public boolean putHotelCondition(String shoppingUUID,Map<String,Object> conditionMap);
	
}
