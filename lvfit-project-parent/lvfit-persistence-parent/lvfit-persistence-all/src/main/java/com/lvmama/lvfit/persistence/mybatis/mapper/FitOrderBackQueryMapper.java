package com.lvmama.lvfit.persistence.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lvmama.lvf.common.domain.DomainEntityBaseMapper;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.order.FitOrderQueryListDto;
import com.lvmama.lvfit.common.dto.request.FitOrderQueryRequest;

/**
 * 后台订单查询 Mapper
 * @author wanghuihui
 */
public interface FitOrderBackQueryMapper extends	DomainEntityBaseMapper<FitOrderQueryListDto,BaseQueryDto<? extends Dto>>{
	/**
	 *  台后订单详情
	 * @author wanghuihui
	 * @date:2016年1月22日 下午2:02:25
	 * @param mainOrderId
	 * @return
	 */
	FitOrderMainDto viewOffline(@Param("vstOrderId")Long mainOrderId);
	/**
	 *  台后 机酒订单导出
	 * @author wanghuihui
	 * @date:2016年1月22日 下午2:02:50
	 * @param baseQueryDto
	 * @return
	 */
	List<FitOrderQueryListDto> queryOrderAllReport(BaseQueryDto<FitOrderQueryRequest> baseQueryDto);
	/**
	 * 台后 机票 订单导出
	 * @author wanghuihui
	 * @date:2016年1月25日 上午10:57:08
	 * @param baseQueryDto
	 * @return
	 */
	List<FitOrderQueryListDto> queryOrderFlightReport(
			BaseQueryDto<FitOrderQueryRequest> baseQueryDto);
	/**
	 * 台后 酒店 订单导出
	 * @author wanghuihui
	 * @date:2016年1月25日 上午10:57:14
	 * @param baseQueryDto
	 * @return
	 */
	List<FitOrderQueryListDto> queryOrderHotelReport(
			BaseQueryDto<FitOrderQueryRequest> baseQueryDto);
	/**
	 *  订单查询 没有分页
	 * @author wanghuihui
	 * @date:2016年1月25日 下午4:33:02
	 * @param baseQueryDto
	 * @return
	 */
	List<FitOrderQueryListDto> queryNoPage(
			BaseQueryDto<FitOrderQueryRequest> baseQueryDto);

}

