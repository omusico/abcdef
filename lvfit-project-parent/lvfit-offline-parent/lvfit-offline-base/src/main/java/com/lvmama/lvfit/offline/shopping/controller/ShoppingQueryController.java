package com.lvmama.lvfit.offline.shopping.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.form.shopping.ShoppingListQueryRequestForm;

/**
 * shopping查询Controller
 * @author zengzhimin
 * @date 2016-01-04
 */
public interface ShoppingQueryController<I extends Form, R extends BaseResponseDto<? extends Form>> 
{
	/**
	 * 进入shopping查询页
	 * @param model
	 * @return
	 */
	String toShoppingList(Model model); 
	
	
	/**
	 * ajax 返回查询结果 页面用jqgrid,
	 * @param model
	 * @param i
	 * @return
	 */
	R queryShoppingList(Model model,I i);
	
	
	/**
	 * 查询购物车明细
	 * @param 	model
	 * @param 	shoppingUUId 主订单主键
	 * @return	String
	 */
	String queryShoppingDetail(Model model, String shoppingUUId); 
	
	/**
	 * 导出购物车信息
	 * @param requestForm
	 * @param response
	 */
	void exportCsv(ShoppingListQueryRequestForm requestForm, HttpServletResponse response);

}
