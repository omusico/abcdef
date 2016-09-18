package com.lvmama.lvfit.common.dto.sdp.product;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.status.ResultStatus;

/**
 * 自主打包产品搜索索引对象
 * 
 * @author dingli
 *
 */

public class FitSdpProductSyncMsgDto extends Entity{
	

	 private static final long serialVersionUID = -7348689480178224215L;

	 private Long productId;

	 private Long productSyncTime;//毫秒
	 
	 private ResultStatus productSyncStatus;
	 
	 private Long indexSyncTime;//毫秒
	 
	 private ResultStatus indexSyncStatus;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public Long getProductSyncTime() {
		return productSyncTime;
	}

	public void setProductSyncTime(Long productSyncTime) {
		this.productSyncTime = productSyncTime;
	}


	public Long getIndexSyncTime() {
		return indexSyncTime;
	}

	public void setIndexSyncTime(Long indexSyncTime) {
		this.indexSyncTime = indexSyncTime;
	}

	public ResultStatus getProductSyncStatus() {
		return productSyncStatus;
	}

	public void setProductSyncStatus(ResultStatus productSyncStatus) {
		this.productSyncStatus = productSyncStatus;
	}

	public ResultStatus getIndexSyncStatus() {
		return indexSyncStatus;
	}

	public void setIndexSyncStatus(ResultStatus indexSyncStatus) {
		this.indexSyncStatus = indexSyncStatus;
	}

	
}

