package com.lvmama.lvf.common.dto.md;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.NameCode;

public class AirplaneCompany extends NameCode implements Serializable{
	
	public Boolean isForeign=true;

	public Boolean getIsForeign() {
		return isForeign;
	}

	public void setIsForeign(Boolean isForeign) {
		this.isForeign = isForeign;
	}

	
	
}
