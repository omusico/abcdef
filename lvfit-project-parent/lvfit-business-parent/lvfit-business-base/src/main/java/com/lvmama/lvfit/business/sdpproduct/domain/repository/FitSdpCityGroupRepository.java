package com.lvmama.lvfit.business.sdpproduct.domain.repository;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvf.common.domain.DomainByFkIdRepository;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvfit.business.sdpproduct.domain.FitSdpCityGroup;
import com.lvmama.lvfit.business.sdpproduct.domain.FitSdpProductFeeRules;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductFeeRulesDto;


/**
 * 自主打包产品加价规则Repository
 * @author leizhengwei
 *
 */
public interface FitSdpCityGroupRepository extends DomainBaseRepository<FitSdpCityGroup, FitSdpCityGroupDto>,
 DomainByFkIdRepository<FitSdpCityGroupDto>{

	int updateCityUseFlag(FitSdpCityGroupDto dto);

	List<FitSdpCityGroupDto> queryAllCitysByFkId(Long productId);
	
	FitSdpCityGroupDto queryOneCityById(Long id);

	List<FitSdpCityGroupDto> queryCityGroupByDto(BaseQueryDto<FitSdpCityGroupDto> dto);
	
	/** DomainBaseRepository.save()  */ 
	
	/** DomainBaseRepository.queryByFkId()  */ 
	
}
