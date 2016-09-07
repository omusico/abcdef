package com.lvmama.lvfit.common.dto.enums;

/**
 * 乘客类型枚举
 */
public enum PassengerType
{
	ADULT("成人"),
	CHILDREN("儿童"),
	ALL("所有");
	
	private String cnName;

	private PassengerType(String name) {
		this.cnName = name;
	}

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }
    
	public static PassengerType getPassengerTypeByName(String name) {
		if(name==null||"".equals(name)){
			return null;
		}
		for (PassengerType passengerType : PassengerType.values()) {
			if (name.equals(passengerType.name())) {
				return passengerType;
			}
		}
		return null;
	}
	
	public static PassengerType getPassengerTypeByCnName(String name) {
        if(name==null||"".equals(name)){
            return null;
        }
        for (PassengerType passengerType : PassengerType.values()) {
            if (name.equals(passengerType.getCnName())) {
                return passengerType;
            }
        }
        return null;
    }
    
}
