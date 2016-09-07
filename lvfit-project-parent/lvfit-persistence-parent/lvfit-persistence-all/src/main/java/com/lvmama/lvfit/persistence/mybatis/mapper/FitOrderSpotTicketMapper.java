package com.lvmama.lvfit.persistence.mybatis.mapper;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdMapper;
import com.lvmama.lvf.common.domain.DomainEntityByNoMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.order.FitOrderSpotTicketDto;


/**
 * 景点门票订单Mapper
 * @author leizhengwei
 *
 */
public interface FitOrderSpotTicketMapper
		extends
		DomainEntityBaseMapper<FitOrderSpotTicketDto, BaseQueryDto<? extends Dto>>,
		DomainEntityByNoMapper<FitOrderSpotTicketDto>,
		DomainEntityByFkIdMapper<FitOrderSpotTicketDto>{
}
