package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdMapper;
import com.lvmama.lvf.common.domain.DomainEntityByNoMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.order.FitOrderHotelDto;

/**
 * @author qihuisong
 */
public interface FitOrderHotelMapper extends
		DomainEntityBaseMapper<FitOrderHotelDto, BaseQueryDto<? extends Dto>>,
		DomainEntityByNoMapper<FitOrderHotelDto>,DomainEntityByFkIdMapper<FitOrderHotelDto>{
	
	List<FitOrderHotelDto> getByPlanIdAndCheckIn(@Param("planId")String planId,@Param("checkin")Date checkin);

}
