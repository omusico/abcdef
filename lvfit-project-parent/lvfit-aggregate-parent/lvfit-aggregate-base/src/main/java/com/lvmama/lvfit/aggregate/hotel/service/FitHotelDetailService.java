/**
 * Project Name:lvfit-aggregate-base
 * File Name:FitHotelDetailService.java
 * Package Name:com.lvmama.lvfit.aggregate.hotel.service
 * Date:2015-12-3下午4:46:53
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.aggregate.hotel.service;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.lvmama.lvfit.common.dto.hotel.FitHotelDto;
import com.lvmama.lvfit.common.dto.request.FitHotelRequest;

/**
 * ClassName:FitHotelDetailService <br/>
 * Function: 酒店详情. <br/>
 * Date:     2015-12-3 下午4:46:53 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface FitHotelDetailService {
	/**
	 *  获得酒店详情   调用酒店搜索接口，获取酒店数据--原始数据
	 * @author wanghuihui
	 * @date:2015年12月3日 下午3:10:34
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public FitHotelDto getHotelDetail(FitHotelRequest request) throws JsonParseException, JsonMappingException, IOException;

}

