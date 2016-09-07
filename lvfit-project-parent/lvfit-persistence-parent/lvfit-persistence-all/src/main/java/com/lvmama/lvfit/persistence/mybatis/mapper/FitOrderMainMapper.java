package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByNoMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;

/**
 * 订单主信息Mapper
 * @author qihuisong
 */
public interface FitOrderMainMapper extends DomainEntityBaseMapper<FitOrderMainDto, BaseQueryDto<? extends Dto>>,
	DomainEntityByNoMapper<FitOrderMainDto> {
	
	
	FitOrderMainDto getByVstOrderMainNo(@Param("vstOrderMainNo")Long vstOrderMainNo);

	public FitOrderMainDto getOldByVstOrderMainNo(Long vstOrderMainNo);


	int getOrderCountByProductId(@Param("productId")Long productId);
}
