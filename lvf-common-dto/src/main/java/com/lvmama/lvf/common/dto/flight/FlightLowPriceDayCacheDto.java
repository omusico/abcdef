package com.lvmama.lvf.common.dto.flight;

import java.io.Serializable;
import java.math.BigDecimal;

public class FlightLowPriceDayCacheDto implements Serializable{

	private static final long serialVersionUID = -8707687775057633963L;

	/**匹配key（departureCityCode+"_"+arrivalCityCode+"_"+departureDate） */
	private String matchKey;
	
	/**每日航线最低价 */
	private BigDecimal lowPrice;
	

	public FlightLowPriceDayCacheDto() {
		super();
	}

	public FlightLowPriceDayCacheDto(String matchKey, BigDecimal lowPrice) {
		super();
		this.matchKey = matchKey;
		this.lowPrice = lowPrice;
	}

	public String getMatchKey() {
		return matchKey;
	}

	public void setMatchKey(String matchKey) {
		this.matchKey = matchKey;
	}

	public BigDecimal getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(BigDecimal lowPrice) {
		this.lowPrice = lowPrice;
	}
    	
}
