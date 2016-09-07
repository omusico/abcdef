/**
 * Project Name:lvfit-dp-base
 * File Name:ShopingCalculateService.java
 * Package Name:com.lvmama.lvfit.dp.shopping.service
 * Date:2015-12-3下午10:04:39
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.dp.shopping.service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.dto.calculator.AmountCalculatorRequest;
import com.lvmama.lvfit.common.dto.calculator.request.CalculateAmountDetailRequest;
import com.lvmama.lvfit.common.dto.request.CalculateAmountRequest;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.shopping.FitFlightAmountDto;
import com.lvmama.lvfit.common.dto.shopping.FitFlightPriceDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingAmountDto;

/**
 * ClassName:ShopingCalculateService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-3 下午10:04:39 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public interface ShopingCalculateService {
	/**
	 * 
	 * calculatePrice:计算购物车总金额. <br/>
	 * 
	 * @author liuweiguo
	 * @param fitShoppingDto
	 * @return
	 * @since JDK 1.6
	 */
	public BaseSingleResultDto<FitShoppingAmountDto> calculateAmount(CalculateAmountRequest request);
	/**
	 * 
	 * calculateFlightPrice:计算机票单价. <br/>
	 *
	 * @author liuweiguo
	 * @param flight
	 * @return
	 * @since JDK 1.6
	 */
	public FitFlightPriceDto calculateSingelFlightPrice(AmountCalculatorRequest request);
	
	/**
	 * 
	 * calculateFlightAmount:计算机票单程金额. <br/>
	 *
	 * @author liuweiguo
	 * @param shoppingDto
	 * @param searchRequest
	 * @return
	 * @since JDK 1.6
	 */
	public FitFlightAmountDto calculateFlightAmount(AmountCalculatorRequest request);
	
	/**
	 * @param amountRequest
	 * @return
	 */
	BaseSingleResultDto<FitShoppingAmountDto> calculateAmountByDetail(CalculateAmountDetailRequest amountRequest);

}
