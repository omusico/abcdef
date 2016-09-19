package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.List;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSyncMsgDto;

public interface FitSdpProductSynMsgMapper{
	/**
	 * 更新索引同步状态
	 * @param id
	 * @param curSyncFlag
	 * @return
	 */
	void insert(FitSdpProductSyncMsgDto syncMsgDto);
	
	
	/**
	 * 查询所有同步信息
	 * @param 
	 * @return
	 */
	List<FitSdpProductSyncMsgDto> querySdpProductSynMsgInfo(BaseQueryDto<FitSdpProductSyncMsgDto> baseQuery);

	/**
	 * 查询所有同步记录数
	 * @param 
	 * @return
	 */
	int countSdpProductSynMsg(BaseQueryDto<FitSdpProductSyncMsgDto> baseQuery);

	
}
