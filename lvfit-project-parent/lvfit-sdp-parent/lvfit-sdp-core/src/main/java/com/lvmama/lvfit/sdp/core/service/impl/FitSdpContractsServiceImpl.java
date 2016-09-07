package com.lvmama.lvfit.sdp.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.client.FitAggregateClient;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;
import com.lvmama.lvfit.sdp.core.service.FitSdpContractsService;

@Service
public class FitSdpContractsServiceImpl implements FitSdpContractsService{

	@Autowired
	private FitAggregateClient aggregateClient;
	
	@Override
	public BaseSingleResultDto<String> getContractsHtml(FitOrderBookingRequest bookingRequest) {
		return aggregateClient.getContracts(bookingRequest);
	}

}
