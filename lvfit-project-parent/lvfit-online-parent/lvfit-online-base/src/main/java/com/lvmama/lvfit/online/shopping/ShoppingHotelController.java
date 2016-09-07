/**
 * Project Name:lvfit-online-base
 * File Name:ShoppingController.java
 * Package Name:com.lvmama.lvfit.online.shopping
 * Date:2015-12-3下午1:38:20
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.online.shopping;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.online.shopping.form.ChangeHotelRequestForm;

/**
 * ClassName:ShoppingController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-3 下午1:38:20 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public interface ShoppingHotelController<I extends Form, R extends BaseResponseDto<? extends Form>> {

	/**
	 * 
	 * changeTempOrder:修改shopping(选择酒店时触发,更新shopping信息). <br/>
	 * 
	 * @author liuweiguo
	 * @param model
	 * @param input
	 * @return
	 * @since JDK 1.6
	 */
	public R changeHotel(Model model, ChangeHotelRequestForm form);

}
