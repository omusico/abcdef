/**
 * Project Name:lvfit-online-hotel
 * File Name:HotelDetailControllerImpl.java
 * Package Name:com.lvmama.lvfit.online.hotel
 * Date:2015-12-3下午2:32:20
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.online.hotel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvfit.common.client.FitDpClient;
import com.lvmama.lvfit.common.dto.hotel.FitCommentDto;
import com.lvmama.lvfit.common.dto.hotel.FitHotelDto;
import com.lvmama.lvfit.common.dto.request.FitCommentRequest;
import com.lvmama.lvfit.common.dto.request.FitHotelRequest;
import com.lvmama.lvfit.common.form.hotel.HotelDetailForm;
import com.lvmama.lvfit.online.hotel.controller.HotelController;

/**
 * ClassName:HotelDetailControllerImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-12-3 下午2:32:20 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Controller
@RequestMapping("hotel")
public class HotelDetailControllerImpl implements HotelController {
	@Autowired
	private FitDpClient fitDpClient;
	
	private static Logger logger = LoggerFactory.getLogger(HotelDetailControllerImpl.class);
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String show() {
		return "fh-select-hotel";
	}
	
	/**
	 * 获得酒店信息
	 */
	@Override
	@RequestMapping("/showHotelDetail")
	@ResponseBody
	public FitHotelDto showHotelDetail(Model model,HotelDetailForm hotelDetailForm) {
		FitHotelRequest request = hotelDetailForm.getRequest();
		FitHotelDto product = null;
		try {
			product = fitDpClient.getHotelDetail(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("hotel", product);
		return product;
	}
	
	@RequestMapping("/querycmtpage")
    @ResponseBody
	public FitCommentDto showComments(Model model,FitCommentRequest request,Pagination pagination) {
		FitCommentDto dto = new FitCommentDto();
		 request.setPagination(pagination);
		try {
			dto = fitDpClient.getCommentPage(request);
			dto.setIsSuccess(true);
		} catch (Exception e) {
			logger.error("HotelCommentControllerImpl:showComments"+e.getMessage());
			dto.setIsSuccess(false);
			dto.setErrorMessage("查询点评信息出现异常");
		}             		
		return dto;
		/*request.setPagination(pagination);
		request.setPlaceId(43L);
		request.setProductId(89467L);*/
		//cmtRequest.setProductId(89467L);
		//////////////
	}
	
}

