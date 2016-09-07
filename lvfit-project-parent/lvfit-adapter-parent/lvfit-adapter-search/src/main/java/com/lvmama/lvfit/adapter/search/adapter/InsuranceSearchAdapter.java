package com.lvmama.lvfit.adapter.search.adapter;

import java.util.List;

import com.lvmama.lvfit.common.dto.search.insurance.InsuranceQueryRequest;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceSearchResult;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;

/**
 * 保险搜索适配接口
 * @author wanghuihui
 *
 */
public interface InsuranceSearchAdapter {
	/**
	 * 获得保险相关信息
	 * @author wanghuihui
	 * @date:2016年2月25日 上午11:01:58
	 * @param insuranceQueryRequest
	 * @return
	 */
	public InsuranceSearchResult<InsuranceDto>  searchInsurance(InsuranceQueryRequest insuranceQueryRequest);

}
