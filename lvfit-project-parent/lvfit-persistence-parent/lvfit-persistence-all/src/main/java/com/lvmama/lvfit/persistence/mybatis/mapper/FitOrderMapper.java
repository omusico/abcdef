package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdMapper;
import com.lvmama.lvf.common.domain.DomainEntityByNoMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.order.FitOrderDto;

/**
 * 订单信息Mapper
 * @author qihuisong
 */
public interface FitOrderMapper
		extends
		DomainEntityBaseMapper<FitOrderDto, BaseQueryDto<? extends Dto>>,
		DomainEntityByNoMapper<FitOrderDto>,
		DomainEntityByFkIdMapper<FitOrderDto> {

	void updateByOrderNo(Long id, FitOrderDto fitOrderDto);
	public List<FitOrderDto> getFlightByOrderMainId(Long orderMainId);
	public List<FitOrderDto> getHotelByOrderMainId(Long orderMainId);
}
