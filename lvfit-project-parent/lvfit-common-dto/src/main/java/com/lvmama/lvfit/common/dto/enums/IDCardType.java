package com.lvmama.lvfit.common.dto.enums;

/**
 * 证件类型枚举
 * @author majun
 * @date   2015-1-13
 */
public enum IDCardType 
{
	ID("身份证"),
	PASSPORT("护照"),
	OFFICER("军官证"),
	SOLDIER("士兵证"),
	TAIBAO("台胞证"),
	OTHER("其他");
	
	private String cnName;

	private IDCardType(String cnName) {
		this.cnName = cnName;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	
	public static IDCardType getIDCardTypeByName(String name) {
		if(name==null||"".equals(name)){
			return null;
		}
		for (IDCardType idCardType : IDCardType.values()) {
			if (name.equals(idCardType.name())) {
				return idCardType;
			}
		}
		return null;
	}
	
	public static IDCardType getIDCardTypeByCnName(String name) {
        if(name==null||"".equals(name)){
            return null;
        }
        for (IDCardType idCardType : IDCardType.values()) {
            if (name.equals(idCardType.getCnName())) {
                return idCardType;
            }
        }
        return null;
    }
}
