/**
 * Project Name:lvfit-adapter-vst
 * File Name:GoodsServiceAdapter.java
 * Package Name:com.lvmama.lvfit.adapter.vst.adapter
 * Date:2015-11-12下午3:26:18
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.adapter.vst.adapter;

import java.util.Date;
import java.util.List;

import com.lvmama.lvfit.common.dto.request.FitHotelPriceRequest;
import com.lvmama.lvfit.common.dto.request.FitHotelRequest;
import com.lvmama.lvfit.common.dto.request.FitHotelRoomRequest;
import com.lvmama.lvfit.common.dto.vst.VstProdProductBranch;
import com.lvmama.lvfit.common.dto.vst.VstSuppGoodPrice;
import com.lvmama.lvfit.common.dto.vst.VstSuppGoods;

/**
 * ClassName:GoodsServiceAdapter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-11-12 下午3:26:18 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public interface GoodsServiceAdapter {

	/**
	 * 根据商品Id查询商品详情
	 * 
	 * @param suppGoodsId 商品ID
	 * @return 商品详情
	 */
	public VstSuppGoods getSuppGoodsById(FitHotelRoomRequest request);
	
	
	/**
	 * 查询商品时间价格信息
	 * @param parameters
	 * @return
	 */
	public List<VstSuppGoodPrice> findTimePriceBySpecDate(FitHotelPriceRequest request);	
	/**
	 * 查询产品规格，属性及商品信息
	 * @param productIdList
	 * @param startDate
	 * @param endDate
	 * @param conditionMap
	 * @return
	 */
	public   List<VstProdProductBranch> findHotelProductListForFront(FitHotelRequest request);

	/**
	 *   查看单品
	 * @author zengzhimin
	 * @date:2015年12月7日 下午9:03:09
	 * @param productId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	List<VstSuppGoods> querySuppGoodsListByProductId(Long productId,
			Date startDate, Date endDate);
}
