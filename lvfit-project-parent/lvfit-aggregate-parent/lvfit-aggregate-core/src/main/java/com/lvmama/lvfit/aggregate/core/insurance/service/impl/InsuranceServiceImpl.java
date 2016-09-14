package com.lvmama.lvfit.aggregate.core.insurance.service.impl;

import com.lvmama.lvfit.aggregate.resource.insurance.service.InsuranceService;
import com.lvmama.lvfit.common.client.FitSearchClient;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceQueryRequest;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceServiceImpl implements InsuranceService{
	
	@Autowired
	private FitSearchClient fitSearchClient;

	@Override
	public List<InsuranceDto> searchInsuranceFromVst(InsuranceQueryRequest request) {
		return fitSearchClient.searchInsuranceFromVst(request);
	}

}
