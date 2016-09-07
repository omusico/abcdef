package com.lvmama.lvfit.aggregate.resource.hotel.service;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;

public interface HotelService {

	//hotelSearch 调用酒店搜索接口，获取酒店数据--原始数据
	public HotelSearchResult searchHotel(HotelQueryRequest hotelQueryRequest);
	//hotelShow 酒店Front展现
	
	//hotelDianping  酒店点评
	
}
