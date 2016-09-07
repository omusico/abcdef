package com.lvmama.lvfit.common.dto.search.flight;

import java.util.ArrayList;
import java.util.List;

public enum FlightFacetType {

	departureTimeSegment("起飞时段"), 
	arrivalTimeSegment("到达时段"), 
	carrierNameCode("航空公司"),
	seatClassType("舱位等级"), 
	seatLevel("服务级别"), 
	directType("直飞"), 
	departureAirportCode("起飞机场"), 
	arrivalAirportCode("到达机场"),
	departureAirportNameCode("起飞机场名字和编码"),
	arrivalAirportNameCode("到达机场名字和编码");


	private String cnName;

	private FlightFacetType(String cnName) {
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
		for (FlightFacetType a : FlightFacetType.values()) {
			names.add(a.name());
		}
		return names;
	}

}
