package com.lvmama.lvfit.adapter.search.adapter;



import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;


public interface HotelServiceAdapter {

	//hotelSearch 调用酒店搜索接口，获取酒店数据--原始数据
	
	/**
	 * 搜索度假酒店
	 * 
	 * */
	public HotelSearchResult searchHotel(String paramStr,String sessionId,String keyword,HotelQueryRequest hotelQueryRequest);
	
	/**
	 * 查询酒店的展示图
	 * @param parameters
	 * @return
	 */
	public String findHotelImageUrl(Long hotelId);
}
