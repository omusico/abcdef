/**
 * Project Name:lvfit-online-hotel
 * File Name:CommentControllerImpl.java
 * Package Name:com.lvmama.lvfit.online.hotel
 * Date:2015-12-3下午2:32:46
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.online.hotel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvmama.lvfit.common.client.FitDpClient;
import com.lvmama.lvfit.common.dto.hotel.FitCommentDto;
import com.lvmama.lvfit.common.dto.request.FitCommentRequest;
import com.lvmama.lvfit.online.comment.controller.CommentController;

/**
 * ClassName:CommentControllerImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-12-3 下午2:32:46 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Controller
public class CommentControllerImpl implements CommentController<FitCommentRequest>{

	private final static Logger logger = LoggerFactory.getLogger(CommentControllerImpl.class);
	@Autowired
	private FitDpClient fitDpClient;
	@Override
	@RequestMapping("querycmtpage")
    @ResponseBody
	public FitCommentDto showComments(Model model,
			FitCommentRequest request) {
		FitCommentRequest cmtRequest = new FitCommentRequest();
		Long productId = request.getProductId();
		FitCommentDto dto = new FitCommentDto();
		try {
			cmtRequest.setProductId(productId);
			if(StringUtils.isEmpty(request.getPlaceId())){
				cmtRequest.setPlaceId(request.getPlaceId());
			}
			cmtRequest.setPagination(request.getPagination());
			dto = fitDpClient.getCommentPage(cmtRequest);
			dto.setIsSuccess(true);
		} catch (Exception e) {
			logger.error("HotelCommentControllerImpl:showComments"+e.getMessage());
			dto.setIsSuccess(false);
			dto.setErrorMessage("查询点评信息出现异常");
		}             		
		return dto;
	}

}
