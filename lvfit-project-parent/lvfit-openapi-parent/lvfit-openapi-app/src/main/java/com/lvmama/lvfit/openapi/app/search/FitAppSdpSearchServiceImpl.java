package com.lvmama.lvfit.openapi.app.search;

import com.lvmama.lvfit.common.client.FitSdpClient;
import com.lvmama.lvfit.common.dto.app.FitAppGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpGoodsRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductCalendarDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductCalendarRequest;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FitAppSdpSearchServiceImpl implements FitAppSdpSearchService {

	private static final Logger logger = LoggerFactory.getLogger(FitAppSdpSearchServiceImpl.class);

	@Autowired
	private FitSdpClient fitSdpClient;
	
	@Override
	public FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> searchCalendarInfo(FitSdpProductCalendarRequest calendarRequest) {
		return fitSdpClient.searchProductLowPriceCalendar(calendarRequest);
	}

	@Override
	public FitAppGoodsDto searchGoodsInfo(FitSdpGoodsRequest goodsRequest) {
		FitSdpGoodsDto sdpGoodsDto = fitSdpClient.searchProductGoodsInfo(goodsRequest);
		FitAppGoodsDto appGoodsDto = new FitAppGoodsDto();
		appGoodsDto.setDepfacetMap(sdpGoodsDto.getDepfacetMap());
		appGoodsDto.setArvfacetMap(sdpGoodsDto.getArvfacetMap());
		appGoodsDto.setDepFlightInfos(sdpGoodsDto.getDepFlightInfos());
		appGoodsDto.setArvFlightInfos(sdpGoodsDto.getArvFlightInfos());
		return appGoodsDto;
	}



}
