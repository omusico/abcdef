package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByNoMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.order.FitOrderBasicInfoDto;

/**
 * 订单主信息Mapper
 * @author qihuisong
 */
public interface FitOrderBasicInfoMapper extends DomainEntityBaseMapper<FitOrderBasicInfoDto, BaseQueryDto<? extends Dto>>,
	DomainEntityByNoMapper<FitOrderBasicInfoDto>
{

	List<FitOrderBasicInfoDto> getByOrderMainId(Long id);
	
}
