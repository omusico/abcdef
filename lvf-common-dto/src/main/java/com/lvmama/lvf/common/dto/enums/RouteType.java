package com.lvmama.lvf.common.dto.enums;

public  enum RouteType {
	
	OW("单程"),
	RT("往返"),
	CT("联程"),
	OJ("缺口程"),
	OTHER("其他"),
	ALL("所有");
	
	private String cnName;

	public  String getCnName() {
		return cnName;
	}

	private RouteType(String cnName) {
		this.cnName = cnName;
	}
	
	public static RouteType getRouteTypeByName(String name) {
		if(name==null||"".equals(name)){
			return null;
		}
		for (RouteType routeType : RouteType.values()) {
			if (name.equals(routeType.name())) {
				return routeType;
			}
		}
		return null;
	}
	
/*	public static void main(String[] args) {
		System.out.println(RouteType.getRouteTypeByName("ALL"));
		System.out.println(RouteType.ALL.name());
		System.out.println(RouteType.valueOf("OW"));
	}*/
}
