package com.lvmama.lvf.common.dto.flight.price.index;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Entity;

/**
 * 航班运价基本信息最大版本号
 * @author jiacheng
 * @date 2015-10-13
 */
public class FlightPriceInfoIndexDto extends Entity implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7631657719079823504L;

	/** 供应商CODE */
	private String suppCode;
	
	/** 出发城市代码 */
	private String departureCityCode;
	
	/** 到达城市代码 */
	private String arrivalCityCode;
	
	/** 出发日期毫秒数 */
	private Long departureDate;
	
	/** 版本号 */
	private Long versionNo;
	
	@Override
    @JsonIgnore
    public String getSequence() {
        return "S_FFLI_PRICE_INFO_INDEX";
    }

	public Long getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(Long versionNo) {
		this.versionNo = versionNo;
	}

	public String getDepartureCityCode() {
		return departureCityCode;
	}

	public void setDepartureCityCode(String departureCityCode) {
		this.departureCityCode = departureCityCode;
	}

	public String getArrivalCityCode() {
		return arrivalCityCode;
	}

	public void setArrivalCityCode(String arrivalCityCode) {
		this.arrivalCityCode = arrivalCityCode;
	}

	public Long getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Long departureDate) {
		this.departureDate = departureDate;
	}

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}
}
