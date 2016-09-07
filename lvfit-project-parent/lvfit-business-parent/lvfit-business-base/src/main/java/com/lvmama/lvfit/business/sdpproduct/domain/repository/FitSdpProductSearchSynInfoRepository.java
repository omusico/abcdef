package com.lvmama.lvfit.business.sdpproduct.domain.repository;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvf.common.domain.DomainByFkIdRepository;
import com.lvmama.lvfit.business.sdpproduct.domain.FitSdpProductSynMsgDomain;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSynMsg;


/**
 * 自主打包产品加价规则Repository
 * @author leizhengwei
 *
 */
public interface FitSdpProductSearchSynInfoRepository extends DomainBaseRepository<FitSdpProductSynMsgDomain, FitSdpProductSynMsg>,
DomainByFkIdRepository<FitSdpProductSynMsg>{
	/**
	 * 根据产品Id查询索引信息
	 * @return
	 */
	List<FitSdpProductSynMsg> querySynMsgList(Long productId);
}
