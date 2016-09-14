package com.lvmama.lvfit.aggregate.resource.insurance.service;

import com.lvmama.lvfit.common.dto.search.insurance.InsuranceQueryRequest;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;

import java.util.List;

public interface InsuranceService {
	/**
	 *  动态打包保险相关信息查询
	 * @author wanghuihui
	 * @date:2016年3月22日 下午5:41:03
	 * @return
	 */
	List<InsuranceDto> searchInsuranceFromVst(InsuranceQueryRequest request);
}
