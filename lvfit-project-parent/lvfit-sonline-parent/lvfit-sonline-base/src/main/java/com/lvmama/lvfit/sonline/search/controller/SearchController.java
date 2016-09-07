package com.lvmama.lvfit.sonline.search.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpGoodsRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductCalendarDto;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;

public interface SearchController<I extends Form,R  extends Form> {
	
	

	/**
	 * 查询产品详情页低价日历信息
	 * @param model
	 * @param input
	 * @return
	 */
	FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> getCalendarInfo(Model model,I input);
	
	/**
	 * 查询产品详情页自主打包产品预订初始信息及商品信息
	 * @param model
	 * @param req
	 * @return
	 */
	String searchGoodsInfo(Model model, FitSdpGoodsRequest req);
	
	/**
	 * 查询产品详情页底部说明信息
	 * @param model
	 * @param productId bizCategoryId
	 * @return
	 */
	String searchProductBottomDescInfo(Model model,@PathVariable("productId")String productId,Long bizCategoryId);
	
	/**
	 * 查询产品详情页底部说明驴友点评信息
	 * @param model
	 * @param input
	 * @return
	 */
	String searchProductCommentPageInfo(Model model,I input);
	
	/**
	 * 查询产品详情页底部说明相关游记信息
	 * @param model
	 * @param input
	 * @return
	 */
	String searchProductNotesPageInfo(Model model,I input);



	/**跨域访问数据时的代理
	 * @param model
	 * @param requestStr 请求url包含QueryString
	 * @return
	 */
	String serverProxy(Model model, String requestStr);
	
}
