package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityByFkIdMapper;
import com.lvmama.lvf.common.domain.DomainEntityByNoMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderStatusDto;

/**
 * 订单信息Mapper
 * @author qihuisong
 */
public interface FitSuppMainOrderStatusMapper
		extends
		DomainEntityBaseMapper<FitSuppMainOrderStatusDto, BaseQueryDto<? extends Dto>>,
		DomainEntityByNoMapper<FitSuppMainOrderStatusDto>,
		DomainEntityByFkIdMapper<FitSuppMainOrderStatusDto> {
	
	/**
	 * 根据vstMainOrderNo更新供应商主订单状态
	 * @param suppMainOrderStatusDto
	 * @return
	 */
	int updateByVstOrderMainNo(@Param("vstOrderMainNo")Long vstOrderMainNo,@Param("i")FitSuppMainOrderStatusDto suppMainOrderStatusDto);
	
	/**
	 * 获取需同步的vst主订单状态信息
	 * @return
	 */
	List<FitSuppMainOrderStatusDto> queryNeedToSync();

}
