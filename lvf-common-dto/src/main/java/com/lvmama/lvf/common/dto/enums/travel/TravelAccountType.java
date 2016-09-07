package com.lvmama.lvf.common.dto.enums.travel;


/**
 * 账户类型
 * @author zhoubinbin
 *
 */
public enum TravelAccountType {
	
	PERSONAL("个人账户"),
	INTERNAL("内部账户"),
	EXTERNAL("外部客户");
	
	private String cnName;
	TravelAccountType(){}
	
	TravelAccountType(String cnName) {
		this.cnName = cnName;
	}
	
	public String getCnName(){
		return this.cnName;
	}
	
	public String getType(){
		return this.name();
	}
	
	/*public static String getCnName(String code) {
		for (TravelAccountType item : TravelAccountType.values()) {
			if (item.getCode().equals(code)) {
				return item.getCnName();
			}
		}
		return null;
	}*/
	@Override
	public String toString(){
		return this.name();
	}
	
}
