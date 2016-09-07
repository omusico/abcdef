package com.lvmama.lvfit.aggregate.core.sdp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvfit.aggregate.sdp.service.FitSdpCalendarService;
import com.lvmama.lvfit.common.client.FitSearchClient;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductCalendarDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductGroupQueryRequest;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;

@Service
public class FitSdpCalendarServiceImpl implements FitSdpCalendarService{
	@Autowired
	private FitSearchClient fitSearchClient;
	
	@Override
	public FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> findProdGroupDateByParam(FitSdpProductGroupQueryRequest fitProductGroupQueryRequest) {
		FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> searchProductGroupFromVst = fitSearchClient.searchProductGroupFromVst(fitProductGroupQueryRequest);
		return searchProductGroupFromVst;
	}

}
