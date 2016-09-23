package com.lvmama.lvfit.openapi.app.search;

import com.lvmama.lvfit.common.dto.app.FitAppGoodsDto;
import com.lvmama.lvfit.common.dto.app.FitAppSdpCityDepartInfo;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpGoodsRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductCalendarDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductCalendarRequest;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;

import java.util.List;

public interface FitAppSdpSearchService {
	
	/**查询低价日历信息.
	 * @param calendarRequest
	 * @return
	 */
	FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> searchCalendarInfo(FitSdpProductCalendarRequest calendarRequest);

	/**获取被打包产品商品信息.
	 * @param goodsRequest
	 * @return
	 */
	FitAppGoodsDto searchGoodsInfo(FitSdpGoodsRequest goodsRequest);


    /**
	 * 根据产品id查询出发城市信息
	 * @param productId
	 * @return
     */
	List<FitAppSdpCityDepartInfo> searchSdpCityDepartInfo(Long productId);



}
