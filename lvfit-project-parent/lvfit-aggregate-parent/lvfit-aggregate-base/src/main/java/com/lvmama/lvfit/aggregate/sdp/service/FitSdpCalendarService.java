package com.lvmama.lvfit.aggregate.sdp.service;

import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductCalendarDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductGroupQueryRequest;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;


public interface FitSdpCalendarService {
	public FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> findProdGroupDateByParam(FitSdpProductGroupQueryRequest fitProductGroupQueryRequest);
}
