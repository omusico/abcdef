package com.lvmama.lvfit.batch.product.service;

import com.lvmama.lvf.common.dto.status.ResultStatus;

/**
 * 自主打包信息同步
 * @author leizhengwei
 *
 */
public interface FitSdpProductBasicInfoSyncService {
     
	/**
	 * 同步自主打包产品基本信息（新增或者修改）
	 * @param productId
	 */
	ResultStatus syncSdpProductBasicInfo(Long productId);
	
}
