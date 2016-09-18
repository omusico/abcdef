package com.lvmama.lvfit.common.dto.sdp.product;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.Entity;

/**
 * 自主打包产品搜索索引对象
 * 
 * @author leizhengwei
 *
 */

public class FitSdpProductSearchIndexDto  extends  Entity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4329696300655676007L;

	private Long productId;

	 private Long startDistrictId;
	 
	 private String startDistrict;

	 private BigDecimal lowestMarketPrice;

	 private BigDecimal lowestSaledPrice;

	 private BigDecimal appLowestMarketPrice;

	 private BigDecimal appLowestSaledPrice;

	 private BigDecimal wapLowestMarketPrice;

	 private BigDecimal wapLowestSaledPrice;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getStartDistrictId() {
		return startDistrictId;
	}

	public void setStartDistrictId(Long startDistrictId) {
		this.startDistrictId = startDistrictId;
	}

	public BigDecimal getLowestMarketPrice() {
		return lowestMarketPrice;
	}

	public void setLowestMarketPrice(BigDecimal lowestMarketPrice) {
		this.lowestMarketPrice = lowestMarketPrice;
	}

	public BigDecimal getLowestSaledPrice() {
		return lowestSaledPrice;
	}

	public void setLowestSaledPrice(BigDecimal lowestSaledPrice) {
		this.lowestSaledPrice = lowestSaledPrice;
	}

	public BigDecimal getAppLowestMarketPrice() {
		return appLowestMarketPrice;
	}

	public void setAppLowestMarketPrice(BigDecimal appLowestMarketPrice) {
		this.appLowestMarketPrice = appLowestMarketPrice;
	}

	public BigDecimal getAppLowestSaledPrice() {
		return appLowestSaledPrice;
	}

	public void setAppLowestSaledPrice(BigDecimal appLowestSaledPrice) {
		this.appLowestSaledPrice = appLowestSaledPrice;
	}

	public BigDecimal getWapLowestMarketPrice() {
		return wapLowestMarketPrice;
	}

	public void setWapLowestMarketPrice(BigDecimal wapLowestMarketPrice) {
		this.wapLowestMarketPrice = wapLowestMarketPrice;
	}

	public BigDecimal getWapLowestSaledPrice() {
		return wapLowestSaledPrice;
	}

	public void setWapLowestSaledPrice(BigDecimal wapLowestSaledPrice) {
		this.wapLowestSaledPrice = wapLowestSaledPrice;
	}

	public String getStartDistrict() {
		return startDistrict;
	}

	public void setStartDistrict(String startDistrict) {
		this.startDistrict = startDistrict;
	}
}
