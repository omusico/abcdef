/**
 * Project Name:lvfit-dp-core
 * File Name:ShoppingFlightServiceImpl.java
 * Package Name:com.lvmama.lvfit.dp.shopping.service.impl
 * Date:2015-12-11下午2:41:26
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.dp.shopping.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvfit.common.dto.request.ChangeFlightRequest;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.dp.shopping.service.ShoppingFlightService;
import com.lvmama.lvfit.dp.shopping.service.ShoppingService;

/**
 * ClassName:ShoppingFlightServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-11 下午2:41:26 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
@Service
public class ShoppingFlightServiceImpl implements ShoppingFlightService {
	
	private static Logger logger = LoggerFactory.getLogger(ShoppingFlightServiceImpl.class);
	
	@Autowired
	private ShoppingService shoppingService;
	
	@Override
	public BaseSingleResultDto<FitShoppingDto> changeFlight(ChangeFlightRequest request) {
		
		try{
			FitShoppingDto shoppingDto = shoppingService.changedFlight(request);
			BaseSingleResultDto<FitShoppingDto> result = new BaseSingleResultDto<FitShoppingDto>();
			result.setResult(shoppingDto);
			result.setStatus(ResultStatus.SUCCESS);
			return result;
		} catch(ExceptionWrapper ew){
			throw ew;
		}
	}
	
}
