package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.List;

import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSynMsg;

public interface FitSdpProductSynMsgMapper{
	/**
	 * 更新索引同步状态
	 * @param id
	 * @param curSyncFlag
	 * @return
	 */
	int saveSynMsgInfo(FitSdpProductSynMsg ssm);
	
	/**
	 * 查询同步信息列表
	 * @param id
	 * @param curSyncFlag
	 * @return
	 */
	List<FitSdpProductSynMsg> querySynMsgList(Long productId);
	
}
