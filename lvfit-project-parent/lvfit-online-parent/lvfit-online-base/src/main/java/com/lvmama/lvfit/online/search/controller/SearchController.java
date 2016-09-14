package com.lvmama.lvfit.online.search.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.online.search.form.SearchConditionForm;

public interface SearchController<I extends Form
,R extends BaseResponseDto<? extends Form>> {
	
	/**
	 * 页面点击“搜索”按钮 -->跳转产品选择页,触发dp的search==>获取shoppingUUID+状态
	 * ==>已经初始化完毕，页面跳转页面跳转到:searchByShoppingUUID
	 * ==>未初始化完毕，页面跳转过渡页,Gif,ajax轮训ShoppingUUID的状态==>如果变为初始化完毕，跳转到:searchByShoppingUUID
	 * 机+酒
	 * @param model
	 * @param input
	 * @return
	 */
	public String search(Model model, SearchConditionForm input,HttpServletRequest request);
	
}
