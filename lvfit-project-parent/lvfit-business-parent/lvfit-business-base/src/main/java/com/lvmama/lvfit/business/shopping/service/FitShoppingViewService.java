/**
 * Project Name:lvfit-business-base
 * File Name:FitShoppingViewService.java
 * Package Name:com.lvmama.lvfit.business.shopping.service
 * Date:2015-12-3下午3:52:21
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.business.shopping.service;

import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingRequest;

/**
 * ClassName:FitShoppingViewService <br/>
 * Function: 查看购物车. <br/>
 * Date:     2015-12-3 下午3:52:21 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface FitShoppingViewService {
	/**
	 * 
	 * getShoppingByShoppingId:根据shoppingUUID从DB加载购物车. <br/>
	 *
	 * @author liuweiguo
	 * @param shoppingId
	 * @return
	 * @since JDK 1.6
	 */
	public FitShoppingDto getShoppingByShoppingId(FitShoppingRequest request);
}

