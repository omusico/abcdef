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

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.online.shopping.form.ChangeFlightRequestForm;

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
public interface ShoppingFlightController <I extends Form, R extends BaseResponseDto<? extends Form>>{

	/**
	 * 
	 * 1.航班list==>(页面 ajax 调用changeFlight==>更新shopping信息==>succ==>页面跳转到:searchByShoppingUUID) 
	 * (searchByShoppingUUID根据shoppingUUID重新加载产品选择页-->重新算价调用calucateAmount)
	 * 
	 * 2.更换舱位==>(1.jQuery更新页面舱位数据/页面 ajax 调用changeFlight==>更新shopping信息==>succ-->重新算价调用calucateAmount)
	 * 
	 * 
	 * 
	 * changeTempOrder:修改shopping(选择机票触发，更新shopping信息). <br/>
	 * 
	 * @author liuweiguo
	 * @param model
	 * @param input
	 * @return
	 * @since JDK 1.6
	 */
	public R changeFlight(Model model, ChangeFlightRequestForm form);
	
}
