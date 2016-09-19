package com.lvmama.lvfit.business.sdpproduct.domain.repository;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvf.common.domain.DomainByFkIdRepository;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvfit.business.sdpproduct.domain.FitSdpProductSearchIndexDomain;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexDto;


/**
 * 自主打包产品加价规则Repository
 * @author leizhengwei
 *
 */
public interface FitSdpProductSearchIndexRepository extends DomainBaseRepository<FitSdpProductSearchIndexDomain, FitSdpProductSearchIndexDto>,
 DomainByFkIdRepository<FitSdpProductSearchIndexDto>{
	/**
	 * 根据产品Id查询索引信息
	 * @return
	 */
	List<FitSdpProductSearchIndexDto> queryIndexInfoList(BaseQueryDto<Long> baseQuery);

	int countSearchIndex(BaseQueryDto<Long> baseQuery);
}
