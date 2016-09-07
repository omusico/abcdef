/**
 * Project Name:lvfit-adapter-vst
 * File Name:ProductServiceAdapter.java
 * Package Name:com.lvmama.lvfit.adapter.vst.adapter
 * Date:2015-11-12下午3:24:42
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.adapter.vst.adapter;

import java.util.List;
import java.util.Map;

import com.lvmama.lvfit.common.dto.request.FitHotelRequest;
import com.lvmama.lvfit.common.dto.vst.VstProduct;

/**
 * ClassName:ProductServiceAdapter <br/>
 * Function: vst产品适配器. <br/>
 * Date: 2015-11-12 下午3:24:42 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public interface ProductServiceAdapter {
	/**
	 * 
	 * getHotelProductDetail:酒店产品详情. <br/>
	 * 
	 * @author liuweiguo
	 * @param productId
	 * @param hasProp
	 * @param hasPropValue
	 * @return
	 * @since JDK 1.6
	 */
	public VstProduct getHotelProductDetail(FitHotelRequest request, Boolean hasProp, Boolean hasPropValue);

	/**
	 * 
	 * queryProdProductList:查询洒店商品列表<br/>
	 * 
	 * @author liuweiguo
	 * @param params
	 * @return
	 * @since JDK 1.6
	 */
	public List<VstProduct> queryHotelProdProductList(Map<String, Object> params);


}
