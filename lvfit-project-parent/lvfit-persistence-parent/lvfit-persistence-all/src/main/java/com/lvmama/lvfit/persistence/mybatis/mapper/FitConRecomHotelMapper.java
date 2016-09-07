package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.Map;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.domain.DomainEntityBatchMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.hotel.FitConRecomHotelDto;

/**
 * 默认酒店数据的增删改查
 *
 * @author zhoubinbin
 * @date 2016年1月5日
 */
public interface FitConRecomHotelMapper extends DomainEntityBaseMapper<FitConRecomHotelDto, BaseQueryDto<? extends Dto>>,
DomainEntityBatchMapper<FitConRecomHotelDto, BaseQueryDto<? extends Dto>>   {

	//设置默认推荐的酒店
	void setDefaultHotel(Map<String, Object> updateMap);

	//并将其它和选中酒店一样城市行政id的酒店设为非默认推荐的酒店
	void setOtherNotDefault(Map<String, Object> updateMap);
	
	
}
