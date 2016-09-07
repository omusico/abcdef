package com.lvmama.lvfit.common.dto.enums;

public enum InsuranceType {
	
	GNYYWX(730L, "国内旅游意外险"),
	CJYYWX(731L, "出境旅游意外险"),
	HKYWX(732L, "航空意外险"),
	JTYWX(733L, "交通意外险"),
	YLX(734L, "邮轮险"),
	CX(735L, "车险"),
	JQYWX(736L, "景区门票意外险"),
	QZX(737L, "签证险"),
	HBYWX(20442L, "签证险"),
	HCQXX(738L, "旅行取消险");
	
	private Long longValue;
	private String cnName;

	public String getCode() {
		return this.name();
	}
	
	public Long getLongValue() {
		return longValue;
	}
	
	public String getCnName() {
		return cnName;
	}
	
	InsuranceType(Long longValue, String cnName){
		this.cnName = cnName;
		this.longValue = longValue;
	}
	
	public static String getCnName(Long code) {
		for (InsuranceType item : InsuranceType.values()) {
			if (item.getLongValue().equals(code)) {
				return item.getCnName();
			}
		}
		return null;
	}
	public static void main(String[] args) {
		String cnName2 = InsuranceType.getCnName(730L);
		System.out.println(cnName2);
	}
}
