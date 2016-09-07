package com.lvmama.lvfit.aggregate.core.insurance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvfit.aggregate.resource.insurance.service.InsuranceService;
import com.lvmama.lvfit.common.client.FitSearchClient;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceQueryRequest;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceSearchResult;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;

@Service
public class InsuranceServiceImpl implements InsuranceService{
	
	@Autowired
	private FitSearchClient fitSearchClient;

	@Override
	public InsuranceSearchResult<InsuranceDto> searchInsuranceFromVst(InsuranceQueryRequest request) {
		InsuranceSearchResult<InsuranceDto> result ;
		result = fitSearchClient.searchInsuranceFromVst(request);
		return result;
	}

}
