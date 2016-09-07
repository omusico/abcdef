package com.lvmama.lvfit.adapter.search.adapter;


import java.util.List;

import com.lvmama.lvfit.common.dto.sdp.product.FitSdpInstalmentDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductCalendarDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductGroupQueryRequest;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;

public interface VstProductCalendarSearchAdapter {
	FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> findProdGroupDateByParam(FitSdpProductGroupQueryRequest fitProductGroupQueryRequest);
	List<FitSdpInstalmentDto> getInstalmentInfo(String productId, String categoryCode);
}
