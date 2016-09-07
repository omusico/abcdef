package com.lvmama.lvfit.common.dto.sdp.product;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;

/**
 * 自主打包产品搜索索引对象
 * 
 * @author dingli
 *
 */

public class FitSdpProductSynMsg extends  Entity implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -7348689480178224215L;

	 private Long productId;

	 private Date synBasicinfoStart;

	 private Date synBasicinfoEnd;
	 
	 private String synBasicinfoStatus;
	 
	 private Date synSearchindexStart;
	 
	 private Date synSearchindexEnd;
	 
	 private String synSearchindexStatus;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Date getSynBasicinfoStart() {
		return synBasicinfoStart;
	}

	public void setSynBasicinfoStart(Date synBasicinfoStart) {
		this.synBasicinfoStart = synBasicinfoStart;
	}

	public Date getSynBasicinfoEnd() {
		return synBasicinfoEnd;
	}

	public void setSynBasicinfoEnd(Date synBasicinfoEnd) {
		this.synBasicinfoEnd = synBasicinfoEnd;
	}


	public Date getSynSearchindexStart() {
		return synSearchindexStart;
	}

	public void setSynSearchindexStart(Date synSearchindexStart) {
		this.synSearchindexStart = synSearchindexStart;
	}

	public Date getSynSearchindexEnd() {
		return synSearchindexEnd;
	}

	public void setSynSearchindexEnd(Date synSearchindexEnd) {
		this.synSearchindexEnd = synSearchindexEnd;
	}

	public String getSynSearchindexStatus() {
		return synSearchindexStatus;
	}

	public void setSynSearchindexStatus(String synSearchindexStatus) {
		this.synSearchindexStatus = synSearchindexStatus;
	}

	public String getSynBasicinfoStatus() {
		return synBasicinfoStatus;
	}

	public void setSynBasicinfoStatus(String synBasicinfoStatus) {
		this.synBasicinfoStatus = synBasicinfoStatus;
	}
	
}

