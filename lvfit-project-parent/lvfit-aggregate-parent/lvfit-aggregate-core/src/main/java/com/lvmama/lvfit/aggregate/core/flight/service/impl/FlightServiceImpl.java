package com.lvmama.lvfit.aggregate.core.flight.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.adapter.request.insurance.InsuranceInfoRequest;
import com.lvmama.lvf.common.dto.enums.Product;
import com.lvmama.lvfit.aggregate.resource.flight.service.FlightService;
import com.lvmama.lvfit.common.client.FitFlightClient;
import com.lvmama.lvfit.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvfit.common.dto.request.FlightInsuranceRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightQueryRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;

@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	private FitFlightClient fitFlightClient;

	@Override
	public FlightSearchResult<FlightSearchFlightInfoDto> searchFlightInfo(FlightQueryRequest request,boolean lowprice) {
		return fitFlightClient.getSearchFlights(request);
	}

    @Override
    public List<InsuranceInfoDto> viewValidFlightInsurances(FlightInsuranceRequest req) { 
        InsuranceInfoRequest insReq = new InsuranceInfoRequest();
        insReq.setStatus(req.getStatus());
        insReq.setProductTypes(Product.I_FLIGHT.name());
        BaseQueryDto<InsuranceInfoRequest> bq = new BaseQueryDto<InsuranceInfoRequest>(new Pagination(), insReq);
        BaseResultDto<InsuranceInfoDto> baseResult = fitFlightClient.queryInsurance(bq);
        return baseResult.getResults();
    }

}
