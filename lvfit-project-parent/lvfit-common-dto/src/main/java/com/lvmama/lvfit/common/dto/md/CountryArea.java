package com.lvmama.lvfit.common.dto.md;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.NameCode;

public class CountryArea extends NameCode implements Serializable {

	public Boolean isForeign=true;

	public Boolean getIsForeign() {
		return isForeign;
	}

	public void setIsForeign(Boolean isForeign) {
		this.isForeign = isForeign;
	}
	
}
