/**
 * Project Name:lvfit-adapter-vst
 * File Name:HotelDetailService.java
 * Package Name:com.lvmama.lvfit.adapter.vst.service
 * Date:2015-11-23下午9:32:37
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.adapter.vst.service;

import java.lang.reflect.InvocationTargetException;

import com.lvmama.lvfit.common.dto.hotel.FitHotelDto;
import com.lvmama.lvfit.common.dto.request.FitHotelRequest;

/**
 * ClassName:HotelDetailService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-11-23 下午9:32:37 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface HotelDetailService {
	/**
	 * getHotelDetailByProductId:根据产品id查询酒店详情. <br/>
	 *
	 * @author liuweiguo
	 * @param productId
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @since JDK 1.6
	 */
	public FitHotelDto getHotelDetailByHotelId(FitHotelRequest request) throws IllegalAccessException, InvocationTargetException ;
	
}

