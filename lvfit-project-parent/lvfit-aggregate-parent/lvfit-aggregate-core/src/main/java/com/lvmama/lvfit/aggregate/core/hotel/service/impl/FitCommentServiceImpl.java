/**
 * Project Name:lvfit-aggregate-core
 * File Name:FitCommentServiceImpl.java
 * Package Name:com.lvmama.lvfit.aggregate.core.hotel.service.impl
 * Date:2015-12-6下午3:17:05
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.aggregate.core.hotel.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvfit.aggregate.hotel.service.FitCommentService;
import com.lvmama.lvfit.common.client.FitVstClient;
import com.lvmama.lvfit.common.dto.hotel.FitCommentDto;
import com.lvmama.lvfit.common.dto.request.FitCommentRequest;

/**
 * ClassName:FitCommentServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-12-6 下午3:17:05 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Service
public class FitCommentServiceImpl implements FitCommentService{

	private final Logger logger=LoggerFactory.getLogger(getClass());

	@Autowired
	private FitVstClient fitVstClient;
	@Override
	public FitCommentDto getCommentPage(FitCommentRequest request) {
		FitCommentDto fitCommentDto = new FitCommentDto();
		try {
			fitCommentDto = fitVstClient.getCommentPage(request);
		} catch (Exception e) {
			logger.info("queryHotelCommentPageList:"+e.getMessage());
	  }
		return fitCommentDto;
	}
}

