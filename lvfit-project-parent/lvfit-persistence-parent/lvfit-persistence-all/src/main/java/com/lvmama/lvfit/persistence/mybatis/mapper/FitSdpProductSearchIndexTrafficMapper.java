package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainByFkIdRepository;
import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexTraffic;


/**
 * 自主打包产品索引交通信息Mapper
 * @author leizhengwei
 *
 */
public interface FitSdpProductSearchIndexTrafficMapper extends DomainEntityBaseMapper<FitSdpProductSearchIndexTraffic, BaseQueryDto<? extends Dto>>,
        DomainByFkIdRepository<FitSdpProductSearchIndexTraffic>
{

	List<FitSdpProductSearchIndexTraffic> queryIndexTrafficList(BaseQueryDto<Long> baseQuery);
	
	FitSdpProductSearchIndexTraffic queryTrafficIndexById(Long id);

	void updateOneTrafficIndex(FitSdpProductSearchIndexTraffic dto);
	
}
