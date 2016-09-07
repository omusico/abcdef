package com.lvmama.lvfit.common.dto.sdp.shopping.request;

import java.io.Serializable;

public class FitSdpBookingNoticeRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3554554899831770753L;
	private String productId;
	private String bizCategoryId;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getBizCategoryId() {
		return bizCategoryId;
	}
	public void setBizCategoryId(String bizCategoryId) {
		this.bizCategoryId = bizCategoryId;
	}

}
