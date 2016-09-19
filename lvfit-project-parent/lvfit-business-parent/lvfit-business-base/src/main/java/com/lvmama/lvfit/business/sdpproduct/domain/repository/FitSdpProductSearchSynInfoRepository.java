package com.lvmama.lvfit.business.sdpproduct.domain.repository;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvf.common.domain.DomainByFkIdRepository;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvfit.business.sdpproduct.domain.FitSdpProductSynMsgDomain;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSyncMsgDto;


/**
 * 自主打包产品加价规则Repository
 * @author leizhengwei
 *
 */
public interface FitSdpProductSearchSynInfoRepository extends DomainBaseRepository<FitSdpProductSynMsgDomain, FitSdpProductSyncMsgDto>,
DomainByFkIdRepository<FitSdpProductSyncMsgDto>{

	void saveSyncMsgDto(FitSdpProductSyncMsgDto syncMsgDto);

	List<FitSdpProductSyncMsgDto> querySdpProductSynMsgInfo(BaseQueryDto<FitSdpProductSyncMsgDto> baseQuery);

	int countSdpProductSynMsg(BaseQueryDto<FitSdpProductSyncMsgDto> baseQuery);
}
