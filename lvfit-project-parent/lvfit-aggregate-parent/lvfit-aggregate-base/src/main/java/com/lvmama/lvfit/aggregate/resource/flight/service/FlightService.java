package com.lvmama.lvfit.aggregate.resource.flight.service;

import java.util.List;

import com.lvmama.lvfit.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvfit.common.dto.request.FlightInsuranceRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightQueryRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;

public interface FlightService {

	//flightSearch 直接调用机票接口，查询机票数据--原始数据
	public FlightSearchResult<FlightSearchFlightInfoDto> searchFlightInfo(FlightQueryRequest request,boolean lowprice);

	public List<InsuranceInfoDto> viewValidFlightInsurances(FlightInsuranceRequest req);
}
