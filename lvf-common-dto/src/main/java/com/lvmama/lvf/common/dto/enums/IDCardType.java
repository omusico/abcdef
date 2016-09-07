package com.lvmama.lvf.common.dto.enums;

/**
 * 证件类型枚举
 * @author majun
 * @date   2015-1-13
 */
public enum IDCardType 
{
	ID("身份证","ID"),
	PASSPORT("护照","PASSPORT"),
	GANGAO("港澳通行证","HMP"),
	HUIXIANG("回乡证","RP"),
	TAIBAO("台湾通行证","TP"),
	OFFICER("军官证","MTC"),
	SOLDIER("士兵证","SOC"),
	TAIBAOZHENG("台胞证","MTP"),
	OTHER("其他","OTHER");
	
	private String cnName;
	private String ctripValue;

	private IDCardType(String cnName) {
		this.cnName = cnName;
	}

	private IDCardType(String cnName,String ctripValue) {
		this.cnName = cnName;
		this.ctripValue = ctripValue;
	}
	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	
	public String getCtripValue() {
		return ctripValue;
	}

	public void setCtripValue(String ctripValue) {
		this.ctripValue = ctripValue;
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
	
	public static String getCnNameByName(String name){
		for(IDCardType iDCardType : IDCardType.values()){
			if(name.equals(iDCardType.name())){
				return iDCardType.getCnName();
			}
		}
		return null;
	}
}
