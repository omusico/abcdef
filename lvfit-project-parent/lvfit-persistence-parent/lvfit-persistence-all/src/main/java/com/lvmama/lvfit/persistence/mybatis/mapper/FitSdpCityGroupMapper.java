package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;

public interface FitSdpCityGroupMapper 
	extends 
	DomainEntityBaseMapper<FitSdpCityGroupDto, BaseQueryDto<? extends FitSdpCityGroupDto>>,
	DomainEntityByFkIdMapper<FitSdpCityGroupDto>{
	
	/**	批量更新城市使用状态
	 * @param list
	 * @return
	 */
	int updateUseFlag(FitSdpCityGroupDto dto);
	
	/**根据productId查询所有城市组城市
	 * @param fkId
	 * @return
	 */
	List<FitSdpCityGroupDto> queryAllCitysByFkId(Long fkId);
}
