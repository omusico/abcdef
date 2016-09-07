/**
 * Project Name:lvfit-business-base
 * File Name:ShoppingViewService.java
 * Package Name:com.lvmama.lvfit.business.shopping.service
 * Date:2015-12-3下午3:52:21
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.dp.shopping.service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;

/**
 * ClassName:ShoppingViewService <br/>
 * Function: 查看购物车. <br/>
 * Date:     2015-12-3 下午3:52:21 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface ShoppingViewService {
	/**
	 * 
	 * getShoppingByShoppingId:根据shoppingId加载购物车. <br/>
	 *
	 * @author liuweiguo
	 * @param shoppingId
	 * @return
	 * @since JDK 1.6
	 */
	public BaseSingleResultDto<FitShoppingDto> getShoppingByShoppingUUID(String shoppingUUID);
	
	
	/**
	 * 
	 * putShoppingInfo:根据shoppingId重新还原购物车. <br/>
	 *
	 * @author zengzhimin
	 * @param shoppingId
	 * @return
	 * @since JDK 1.6
	 */
	public BaseSingleResultDto putShoppingInfo(String shoppingUUID);
	
	
	
	/**
	 * 
	 * getShoppingRequestByShoppingId:根据shoppingId加载查询条件. <br/>
	 *
	 * @author 
	 * @param shoppingId
	 * @return
	 * @since JDK 1.6
	 */
	public BaseSingleResultDto<FitSearchRequest> getShoppingRequestByShoppingUUID(String shoppingUUID);
}

