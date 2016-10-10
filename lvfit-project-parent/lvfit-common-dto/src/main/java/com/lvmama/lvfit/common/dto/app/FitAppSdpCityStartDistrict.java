package com.lvmama.lvfit.common.dto.app;

import java.io.Serializable;
import java.math.BigDecimal;
import com.lvmama.lvfit.common.dto.enums.JudgeType;


public class FitAppSdpCityStartDistrict implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8464410841711062689L;

	
	/**自主打包城市Id*/
	private Long productId;
	
	/**出发城市起价*/
	private BigDecimal startPrice;
	
	/**出发城市区域Id*/
	private Long startCityDistrictId;
	
	/**出发城市区短拼音*/
	private String startCityShortPinYin;
	
	/**出发城市code*/
	private String startCityCode;
	
	/**出发城市名称*/
	private String startCityName;
	
	/**是否为选中出发地*/
	private JudgeType isSelectedDeparture;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public BigDecimal getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(BigDecimal startPrice) {
		this.startPrice = startPrice;
	}

	public Long getStartCityDistrictId() {
		return startCityDistrictId;
	}

	public void setStartCityDistrictId(Long startCityDistrictId) {
		this.startCityDistrictId = startCityDistrictId;
	}

	public String getStartCityShortPinYin() {
		return startCityShortPinYin;
	}

	public void setStartCityShortPinYin(String startCityShortPinYin) {
		this.startCityShortPinYin = startCityShortPinYin;
	}

	public String getStartCityCode() {
		return startCityCode;
	}

	public void setStartCityCode(String startCityCode) {
		this.startCityCode = startCityCode;
	}

	public String getStartCityName() {
		return startCityName;
	}

	public void setStartCityName(String startCityName) {
		this.startCityName = startCityName;
	}

	public JudgeType getIsSelectedDeparture() {
		return isSelectedDeparture;
	}

	public void setIsSelectedDeparture(JudgeType isSelectedDeparture) {
		this.isSelectedDeparture = isSelectedDeparture;
	}

}
