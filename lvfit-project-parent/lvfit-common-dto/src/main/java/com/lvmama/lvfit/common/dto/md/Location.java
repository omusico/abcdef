package com.lvmama.lvfit.common.dto.md;

import java.io.Serializable;
import java.math.BigDecimal;

public class Location implements Serializable {
	
	/**经度*/
	private BigDecimal longitude;
	
	/**维度*/
	private BigDecimal latitude;
	
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	
	
	
}
