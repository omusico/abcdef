package com.lvmama.lvfit.business.order.domain.repository;

import java.util.List;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.order.FitOrderQueryListDto;
import com.lvmama.lvfit.common.dto.request.FitOrderQueryRequest;

public interface FitOrderBackQueryRepository  {
	/**
	 * 后台订单查询 列表
	 * @author wanghuihui
	 * @date:2016年1月22日 下午1:59:57
	 * @param baseQueryDto
	 * @return
	 */
	List<FitOrderQueryListDto> query(BaseQueryDto<FitOrderQueryRequest> baseQueryDto);
	/**
	 *  同上：订单查询没有分页，取 mainOrderId
	 * @author wanghuihui
	 * @date:2016年1月25日 下午4:31:26
	 * @param baseQueryDto
	 * @return
	 */
	List<FitOrderQueryListDto> queryNoPage(BaseQueryDto<FitOrderQueryRequest> baseQueryDto);
	/**
	 * 后台订单查询 数量 
	 * @author wanghuihui
	 * @date:2016年1月22日 下午2:00:14
	 * @param q
	 * @return
	 */
	int count(BaseQueryDto<FitOrderQueryRequest> q);
	
	/**
	 * 后台订单详情
	 * @author wanghuihui
	 * @date:2016年1月22日 下午2:00:33
	 * @param mainOrderId
	 * @return
	 */
	FitOrderMainDto viewOffline(Long mainOrderId);
	
	/**
	 *  后台 机酒订单 报表导出
	 * @author wanghuihui
	 * @date:2016年1月22日 下午2:00:53
	 * @param baseQueryDto
	 * @return
	 */
	List<FitOrderQueryListDto> queryOrderAllReport(BaseQueryDto<FitOrderQueryRequest> baseQueryDto);
	/**
	 *  后台 机票订单 报表导出
	 * @author wanghuihui
	 * @date:2016年1月25日 上午10:55:21
	 * @param baseQueryDto
	 * @return
	 */
	List<FitOrderQueryListDto> queryOrderFlightReport(BaseQueryDto<FitOrderQueryRequest> baseQueryDto);
	/**
	 *  后台 酒店订单 报表导出
	 * @author wanghuihui
	 * @date:2016年1月25日 上午10:55:45
	 * @param baseQueryDto
	 * @return
	 */
	List<FitOrderQueryListDto> queryOrderHotelReport(	BaseQueryDto<FitOrderQueryRequest> baseQueryDto);


}
