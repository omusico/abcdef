/**
 * Project Name:lvfit-online-base
 * File Name:ShoppingController.java
 * Package Name:com.lvmama.lvfit.online.shopping
 * Date:2015-12-3下午1:38:20
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.dp.shopping.service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.dto.request.ChangeFlightRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;

import java.util.List;

/**
 * ClassName:ShoppingController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-3 下午1:38:20 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public interface ShoppingFlightService{

	/**
	 * 
	 * changeFlight:更换航班刷新缓存. <br/>
	 *
	 * @author liuweiguo
	 * @param shoppingUUID
	 * @param dto
	 * @return
	 * @since JDK 1.6
	 */
	List<FlightSearchFlightInfoDto> changeFlight(ChangeFlightRequest request);

}
