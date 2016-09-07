package com.lvmama.lvfit.common.dto.search.hotel;

import java.util.ArrayList;
import java.util.List;

public enum HotelFacetType {

	byPromotion("促销"), 
	commentDown("点评降序"), 
	notPromotion("无促销"),
	adviseSort("建议排序"), 
	priceDown("价格降序"), 
	priceUp("价格升序"),
	searchvo("searchvo"),
	selectMap("selectMap");
	private String cnName;

	private HotelFacetType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return this.cnName;
	}
	
	/**
	 * 获取该类型的枚举Name
	 * @return
	 */
	public static List<String> getNameList() {
		List<String> names = new ArrayList<String>();
		for (HotelFacetType a : HotelFacetType.values()) {
			names.add(a.name());
		}
		return names;
	}

}
