package com.lvmama.lvfit.common.dto.search.spot;

import java.util.ArrayList;
import java.util.List;

public enum SpotFacetType {
	
	adviseSort("建议排序"), 
	priceDown("价格降序"), 
	priceUp("价格升序");

	private String cnName;

	private SpotFacetType(String cnName) {
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
		for (SpotFacetType a : SpotFacetType.values()) {
			names.add(a.name());
		}
		return names;
	}
}
