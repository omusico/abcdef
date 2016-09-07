/**
 * Project Name:lvfit-business-base
 * File Name:FitShoppingRemoveService.java
 * Package Name:com.lvmama.lvfit.business.shopping.service
 * Date:2015-12-3下午3:51:46
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.business.shopping.service;

import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingRequest;

/**
 * ClassName:FitShoppingRemoveService <br/>
 * Function: 清除过期的购物车，例如T+N，未形成订单的购物车. <br/>
 * Date:     2015-12-3 下午3:51:46 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface FitShoppingRemoveService {
	
	public FitShoppingDto removeShoppingByShoppingId(FitShoppingRequest request);

}

