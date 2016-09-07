package com.lvmama.lvfit.aggregate.core.sdp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.aggregate.sdp.service.FitSdpContractsService;
import com.lvmama.lvfit.common.client.FitSearchClient;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;

@Service
public class FitSdpContractsServiceImpl implements FitSdpContractsService{

	@Autowired
    private FitSearchClient fitSearchClient;
	
	@Override
	public BaseSingleResultDto<String> getContractsHtml(FitOrderBookingRequest bookingRequest) {
		return fitSearchClient.getContracts(bookingRequest);
	}

}
