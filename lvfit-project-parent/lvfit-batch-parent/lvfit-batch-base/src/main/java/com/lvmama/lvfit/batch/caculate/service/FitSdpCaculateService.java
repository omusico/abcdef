package com.lvmama.lvfit.batch.caculate.service;

import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSyncMsgDto;

/**
 * 自主打包产品计算Service
 * @author leizhengwei
 *
 */
public interface FitSdpCaculateService {
	
	
	
     /**
      * 根据自主打包产品Id生产或者更新索引
      * @param productId
      * @return
      */
	 void  syncSdpProductSearchIndex(Long productId,boolean isSyncAll);
	 
	 
	 /**
      * 获取素有需要更新的索引
      * @return
      */
	 void syncSdpProductIndexsByModValue(Integer modValue);

	/**
	 * 取得产品信息表中未同步的产品，同步到索引
	 *
	 * @return
	 */
	void syncUnfinishedProductsToIndex();

	/**
	 * 存产品同步时间信息到数据库
	 *
	 * @return
	 */
	ResultStatus saveSynMsgInfo(FitSdpProductSyncMsgDto request);

}
