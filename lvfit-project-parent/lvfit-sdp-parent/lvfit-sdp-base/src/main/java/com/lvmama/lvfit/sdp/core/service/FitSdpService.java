package com.lvmama.lvfit.sdp.core.service;

import java.math.BigDecimal;
import java.util.Map;

import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpGoodsRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductCalendarDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductCalendarRequest;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;


public interface FitSdpService {

	/**
	 * 获取自主打包基本信息
	 * @param productId
	 * @return
	 */
	public FitSdpProductBasicInfoDto searchProductBasicInfo(Long productId);

	/**
	 * 仅仅获取自主打包基本信息
	 * @param productId
	 * @return
	 */
	public FitSdpProductBasicInfoDto searchProductInfoOnly(Long productId);

	
	/**
	 * 根据被打包产品id和出发城市code获取低价日历信息
	 * @param calendarRequest
	 * @return
     */
	public FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> searchCalendarInfo(FitSdpProductCalendarRequest calendarRequest);


	/**
	 * 根据产品Id获取城市区域对应的价格信息
	 * @param productId
	 * @return
	 */
	public Map<Long,BigDecimal> searchCalendarInfoByProductId(Long productId);


	/**
	 * 聚合packagedProductId对应的商品信息，以及根据出发地和目的地以及出发时间匹配出对应的航班信息
	 * @param goodsRequest
	 * @return
	 */
	public FitSdpGoodsDto searchGoodsInfo(FitSdpGoodsRequest goodsRequest);
	
	/**
	 * 获取自主打包预览基本信息
	 * @param productId
	 * @return
	 */
	FitSdpProductBasicInfoDto searchProductBasicInfoPreview(Long productId);
	
}
