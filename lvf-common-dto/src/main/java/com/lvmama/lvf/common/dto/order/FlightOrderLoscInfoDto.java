package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

public class FlightOrderLoscInfoDto implements Serializable{
	 private static final long serialVersionUID = -6917426056315381405L;
	 
	 private String oic;
	 
	 private String ouc;

	public String getOic() {
		return oic;
	}

	public void setOic(String oic) {
		this.oic = oic;
	}

	public String getOuc() {
		return ouc;
	}

	public void setOuc(String ouc) {
		this.ouc = ouc;
	}
	 
	 
	 
}
