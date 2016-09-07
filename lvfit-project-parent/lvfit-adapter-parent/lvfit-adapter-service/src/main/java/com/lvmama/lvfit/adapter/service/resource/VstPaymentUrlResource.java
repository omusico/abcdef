/**
 * Project Name:lvfit-adapter-service
 * File Name:VstUserMemberResource.java
 * Package Name:com.lvmama.lvfit.adapter.service.resource
 * Date:2015-12-10下午11:39:24
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvfit.adapter.vst.adapter.UrlProxyServiceAdapter;
import com.lvmama.lvfit.common.client.path.VstClientPath;
import com.lvmama.lvfit.common.dto.adapter.request.FlightBookingSuccessRequest;

/**
 * ClassName:VstPaymentUrlResource <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-15 下午18:39:24 <br/>
 * 
 * @author wanghuihui
 * @version
 * @since JDK 1.6
 * @see
 */
@Component
@Path("")
public class VstPaymentUrlResource {
	@Autowired
	private UrlProxyServiceAdapter urlProxyServiceAdapter;

	/**
	 *  获得订单审核参数
	 * @author wanghuihui
	 * @date:2015年12月25日 下午6:25:15
	 * @param flightBookingSuccessRequest
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(VstClientPath.Path.ORDER_SUCCESS_AUDIT)
	public Response getPaymentUrl(FlightBookingSuccessRequest flightBookingSuccessRequest) {
		String resultStatus = urlProxyServiceAdapter.getPaymentUrl(flightBookingSuccessRequest.getFitPaymentUrlDto());
		return Response.ok(resultStatus).build();
	}

}
