/**
 * Project Name:lvfit-adapter-service
 * File Name:VstProdcutResource.java
 * Package Name:com.lvmama.lvfit.adapter.service.resource
 * Date:2015-11-26下午2:47:56
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.adapter.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvfit.adapter.search.adapter.InsuranceSearchAdapter;
import com.lvmama.lvfit.common.client.path.SearchClientPath;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceQueryRequest;
import com.lvmama.lvfit.common.dto.search.insurance.InsuranceSearchResult;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;

/**
 * ClassName:VstInsuranceResource <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-11-26 下午2:47:56 <br/>
 * @author   wanghuihui
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Component
@Path("")
public class VstInsuranceResource {
	private static final Logger logger = LoggerFactory.getLogger(VstInsuranceResource.class);
	@Autowired
	InsuranceSearchAdapter insuranceSearchAdapter;
	/**
	 * 保险相关信息
	 * @author wanghuihui
	 * @date:2016年2月26日 下午5:04:53
	 * @param request
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(SearchClientPath.Path.INSURANCE_INFO_SEARCH)
	public Response getVstProductDetail(InsuranceQueryRequest request) {
		try {
			InsuranceSearchResult<InsuranceDto> result = insuranceSearchAdapter.searchInsurance(request);
			return Response.ok(result).build();
		} catch (Exception e) {
			logger.error("保险相关信息查询失败-------", e);
		}
		return null;
	}
	
}

