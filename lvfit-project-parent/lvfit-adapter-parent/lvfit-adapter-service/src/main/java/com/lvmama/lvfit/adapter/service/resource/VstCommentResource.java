/**
 * Project Name:lvfit-adapter-service
 * File Name:VstCommentResource.java
 * Package Name:com.lvmama.lvfit.adapter.service.resource
 * Date:2015-11-26下午8:20:05
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

import com.lvmama.lvfit.adapter.vst.service.CommentService;
import com.lvmama.lvfit.common.client.path.VstClientPath;
import com.lvmama.lvfit.common.dto.hotel.FitCommentDto;
import com.lvmama.lvfit.common.dto.request.FitCommentRequest;


/**
 * ClassName:VstCommentResource <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-11-26 下午8:20:05 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */

@Component
@Path("")
public class VstCommentResource {
	private static final Logger logger = LoggerFactory.getLogger(VstCommentResource.class);
	

	@Autowired
	private CommentService hotelCommentServvice;

	/**
	 * 
	 * queryCommentPageList:查询点评分页列表. <br/>
	 *
	 * @author zengzhimin
	 * @param commentRequest
	 * @return
	 * @since JDK 1.6
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(VstClientPath.Path.QUERY_VST_COMMENT_LIST)
	public Response queryFitHotelCommentPageList(FitCommentRequest request){
		try {
			FitCommentDto fitCommentDto = hotelCommentServvice.getCommentPage(request);
		   return Response.ok(fitCommentDto).build();			
		} catch (Exception e) {
			logger.error("查询vst酒店点评分页信息-------", e);
		}
		return null;
	}

}

