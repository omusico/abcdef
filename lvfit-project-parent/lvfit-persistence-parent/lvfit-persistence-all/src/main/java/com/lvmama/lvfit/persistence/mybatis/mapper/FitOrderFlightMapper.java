package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainByFkIdRepository;
import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByNoMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.order.FitOrderFlightDto;

/**
 * @author qihuisong
 */
public interface FitOrderFlightMapper
		extends
		DomainEntityBaseMapper<FitOrderFlightDto, BaseQueryDto<? extends Dto>>,
		DomainEntityByNoMapper<FitOrderFlightDto>,
		DomainByFkIdRepository<FitOrderFlightDto> {
    public List<FitOrderFlightDto> loadByVstOrderMainNo(String vstOrderMainNo);
}
