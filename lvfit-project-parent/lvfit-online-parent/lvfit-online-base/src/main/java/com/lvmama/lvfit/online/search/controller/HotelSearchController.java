package com.lvmama.lvfit.online.search.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.form.Form;

public interface HotelSearchController<I extends Form
,R extends BaseResponseDto<? extends Form>> {
	
	/**
	 * 页面点击“更换酒店”按钮  
	 * 
	 * @param model
	 * @param input
	 * @return
	 */
	//public String queryHotels(Model model,SearchConditionForm input,HttpServletRequest request);
	/**
	 * 页面点击“更换酒店”按钮  
	 * 
	 * @param model
	 * @param input
	 * @return
	 */
	public String queryHotels(Model model
			,@PathVariable("uuid")String uuid
			,@PathVariable("l")String l
			,@PathVariable("r")String r
			,@PathVariable("f")String f
			,@PathVariable("b")String b
			,@PathVariable("s")String s
			,@PathVariable("p")String p,HttpServletRequest request);
	public String queryHotels(Model model
			,@PathVariable("uuid")String uuid
			,@PathVariable("l")String l
			,@PathVariable("r")String r
			,@PathVariable("f")String f
			,@PathVariable("b")String b
			,@PathVariable("s")String s
			,@PathVariable("p")String p
			,@PathVariable("queryId")String queryId
			,HttpServletRequest request);
}
