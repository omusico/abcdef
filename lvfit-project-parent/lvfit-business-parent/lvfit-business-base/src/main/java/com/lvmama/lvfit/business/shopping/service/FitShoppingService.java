/**
 * Project Name:lvfit-business-base
 * File Name:FitShoppingService.java
 * Package Name:com.lvmama.lvfit.business.shopping.service
 * Date:2015-12-3下午3:40:20
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.business.shopping.service;

import java.util.List;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.dto.request.FitShoppingListRequest;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingDbDto;
import com.lvmama.lvfit.common.dto.shopping.ShoppingDetailDto;

/**
 * ClassName:FitShoppingService <br/>
 * Function: 购物车添加和修改. <br/>
 * Date:     2015-12-3 下午3:40:20 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface FitShoppingService {
	/**
	 * 
	 * saveShopping:添加或更新购物车. <br/>
	 *
	 * @author liuweiguo
	 * @param dto
	 * @since JDK 1.6
	 */
	public BaseSingleResultDto saveOrUpdateShopping(FitShoppingDto dto);
	
	/**
	 * 
	 * loadShoppingDpInfoByUuId:从数据库加载shoppingDb信息. <br/>
	 *
	 * @author zengzhimin
	 * @param dto
	 * @since JDK 1.6
	 */
	public ShoppingDbDto loadShoppingDbInfoByUuId(String shoppingUuId);
	
	
	/**
	 * 查询购物车列表
	 * @param 	baseQueryDto						查询对象
	 * @return	List<ShoppingDetailDto>		购物车结果列表	
	 */
	List<ShoppingDetailDto> queryShoppingList(BaseQueryDto<FitShoppingListRequest> baseQueryDto);
	
	/**
	 * 查询购物车列表总记录数
	 * @param 	baseQueryDto	查询对象	
	 * @return	int				总记录数
	 */
	int countShoppingListRecords(BaseQueryDto<FitShoppingListRequest> baseQueryDto);
	

    /**
     * 根据UUID获取购物车信息
     * @param shoppingUuId
     * @return
     */
    public ShoppingDetailDto getShoppingInfoByUuid(String shoppingUuId);

    /**
     * 保存或更新购物车信息
     * @param dtlDto
     * @return
     */
    public int updShoppingInfo(ShoppingDetailDto dtlDto);
	
}

