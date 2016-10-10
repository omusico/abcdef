package com.lvmama.lvfit.openapi.app.search;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.client.FitBusinessClient;
import com.lvmama.lvfit.common.client.FitSdpClient;
import com.lvmama.lvfit.common.dto.app.FitAppGoodsDto;
import com.lvmama.lvfit.common.dto.app.FitAppSdpCityDepartInfo;
import com.lvmama.lvfit.common.dto.app.FitAppSdpCityStartDistrict;
import com.lvmama.lvfit.common.dto.enums.BizEnum;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpGoodsRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductCalendarDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductCalendarRequest;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FitAppSdpSearchServiceImpl implements FitAppSdpSearchService {

	private static final Logger logger = LoggerFactory.getLogger(FitAppSdpSearchServiceImpl.class);

	@Autowired
	private FitSdpClient fitSdpClient;

	@Autowired
	FitBusinessClient fitBusinessClient;
	
	@Override
	public FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> searchCalendarInfo(FitSdpProductCalendarRequest calendarRequest) {
		return fitSdpClient.searchProductLowPriceCalendar(calendarRequest);
	}

	@Override
	public FitAppGoodsDto searchGoodsInfo(FitSdpGoodsRequest goodsRequest) {
		BaseSingleResultDto<FitSdpProductBasicInfoDto> productResultDto =
				fitBusinessClient.getSdpProductBasicInfoByProductId(goodsRequest.getProductId());

		if(productResultDto != null && productResultDto.getResult() != null) {
			FitSdpProductBasicInfoDto productBasic = productResultDto.getResult();
			goodsRequest.setPackagedProdCatId(productBasic.getPackagedCategoryId());
			if(productBasic.getPackagedCategoryId()!=null&& BizEnum.BIZ_CATEGORY_TYPE.category_route_freedom.getCategoryId().equals(productBasic.getBizCategoryId())){
				goodsRequest.setQuantity(1L);
			}
		}

		FitSdpGoodsDto sdpGoodsDto = fitSdpClient.searchProductGoodsInfo(goodsRequest);
		FitAppGoodsDto appGoodsDto = new FitAppGoodsDto();
		appGoodsDto.setDepfacetMap(sdpGoodsDto.getDepfacetMap());
		appGoodsDto.setArvfacetMap(sdpGoodsDto.getArvfacetMap());
		appGoodsDto.setDepFlightInfos(sdpGoodsDto.getDepFlightInfos());
		appGoodsDto.setArvFlightInfos(sdpGoodsDto.getArvFlightInfos());
		return appGoodsDto;
	}

	@Override
	public List<FitAppSdpCityStartDistrict> searchSdpCityDepartInfo(Long productId) {
		List<FitAppSdpCityStartDistrict> cityDepartInfoList = new ArrayList<FitAppSdpCityStartDistrict>();
		List<FitSdpCityGroupDto> cityGroupDtos = fitBusinessClient.getSelectProductCityGroupByProductId(productId);
        Map<Long,BigDecimal> startPriceMap = fitSdpClient.searchCalendarInfoByProductId(productId);
		for(FitSdpCityGroupDto dto : cityGroupDtos){
			FitAppSdpCityStartDistrict cityDepartInfo = new FitAppSdpCityStartDistrict();
			cityDepartInfo.setProductId(dto.getProductId());
			cityDepartInfo.setStartCityCode(dto.getDepartureCityCode());
			cityDepartInfo.setStartCityDistrictId(dto.getDepartureCityDistrictId());
			cityDepartInfo.setStartCityName(dto.getDepartureCityName());
			cityDepartInfo.setStartCityShortPinYin(dto.getDepartureCityShortPinYin());
			cityDepartInfo.setIsSelectedDeparture(dto.getIsSelectedDeparture());
			BigDecimal startPrice = startPriceMap.get(dto.getDepartureCityDistrictId());
			cityDepartInfo.setStartPrice(startPrice);
			cityDepartInfoList.add(cityDepartInfo);
		}
		return cityDepartInfoList;
	}


}
