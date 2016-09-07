package com.lvmama.lvfit.business.order.domain.repository;

import java.util.List;

import com.lvmama.lvf.common.domain.DomainBaseRepository;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvfit.business.order.domain.FitOrderOpLog;
import com.lvmama.lvfit.common.dto.order.FitOrderOpLogDto;
import com.lvmama.lvfit.common.dto.request.FitOrderQueryRequest;

/**
 * 订单Repository
 */
public interface FitOrderOpLogRepository extends DomainBaseRepository<FitOrderOpLog, FitOrderOpLogDto>{
	/**
	 *  订单列表日志查询
	 * @author wanghuihui
	 * @date:2016年1月18日 下午3:54:04
	 * @param baseQuery
	 * @return
	 */
	List<FitOrderOpLogDto> query(BaseQueryDto<FitOrderQueryRequest> baseQuery);
	/**
	 *  订单列表日志查询 数量
	 * @author wanghuihui
	 * @date:2016年1月18日 下午4:21:54
	 * @param baseQueryDto
	 * @return
	 */
	int count(BaseQueryDto<FitOrderQueryRequest> baseQueryDto);
}
