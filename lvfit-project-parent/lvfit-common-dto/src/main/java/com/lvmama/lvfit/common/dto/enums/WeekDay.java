package com.lvmama.lvfit.common.dto.enums;

public enum WeekDay {
	
	SUNDAY("0","周日"),
	MONDAY("1","周一"),
	TUESDAY("2","周二"),
	WEDNESDAY("3","周三"),
	THURSDAY("4","周四"),
	FRIDAY("5","周五"),
	SATURDAY("6","周六");
	
	private String cnName;
	private String desc;

	public String getCnName() {
		return cnName;
	}

	public String getDesc() {
		return desc;
	}

	private WeekDay(String cnName,String desc) {
		this.cnName = cnName;
		this.desc = desc;
	}
	
	public static WeekDay getWeekDayBycnName(String name) {
		if(name==null||"".equals(name)){
			return null;
		}
		for (WeekDay weekDay : WeekDay.values()) {
			if (name.equals(weekDay.getCnName())) {
				return weekDay;
			}
		}
		return null;
	}
	
}
