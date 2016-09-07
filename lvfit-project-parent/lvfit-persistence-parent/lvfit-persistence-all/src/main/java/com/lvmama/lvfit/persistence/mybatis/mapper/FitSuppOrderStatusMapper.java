package com.lvmama.lvfit.persistence.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdMapper;
import com.lvmama.lvf.common.domain.DomainEntityByNoMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderStatusDto;

/**
 * 订单信息Mapper
 * @author qihuisong
 */
public interface FitSuppOrderStatusMapper
		extends
		DomainEntityBaseMapper<FitSuppOrderStatusDto, BaseQueryDto<? extends Dto>>,
		DomainEntityByNoMapper<FitSuppOrderStatusDto>,
		DomainEntityByFkIdMapper<FitSuppOrderStatusDto> {
	
	/**
	 * 根据vstOrderNo更新供应商主订单状态
	 * @param suppOrderStatusDto
	 * @return
	 */
	int updateByVstOrderNo(@Param("vstOrderNo")Long vstOrderNo,@Param("i")FitSuppOrderStatusDto suppOrderStatusDto);
	
	/**
	 * 根据vstOrderNo查询供应商订单状态
	 * @param FitSuppOrderStatusDto
	 * @return
	 */
	FitSuppOrderStatusDto getByVstOrderNo(@Param("vstOrderNo")Long vstOrderNo);

}
