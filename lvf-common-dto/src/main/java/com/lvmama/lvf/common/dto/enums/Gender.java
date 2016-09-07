package com.lvmama.lvf.common.dto.enums;
/**
 * @author lutianyu
 * @date   2015-2-25
 */
public enum Gender {
	MALE("男"),
	FEMALE("女");
	
	private Gender(String cnName) {
		this.cnName = cnName;
	}

	private String cnName;

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	
	public static Gender getGenderByName(String name) {
		if(name==null||"".equals(name)){
			return null;
		}
		for (Gender gender : Gender.values()) {
			if (name.equals(gender.name())) {
				return gender;
			}
		}
		return null;
	}
	
	public static String getCnNameByName(String name){
		for(Gender gender : Gender.values()){
			if(name.equals(gender.name())){
				return gender.getCnName();
			}
		}
		return null;
	}
}
