/**
 * Project Name:lvfit-online-base
 * File Name:CalucateAmountRequestForm.java
 * Package Name:com.lvmama.lvfit.online.shopping.form
 * Date:2015-12-15下午3:09:38
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.online.shopping.form;

import java.util.Date;

import com.lvmama.lvf.common.form.Form;

/**
 * ClassName:CalucateAmountRequestForm <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-15 下午3:09:38 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public class CalucateAmountRequestForm implements Form {
	/**
	 * shoppingUUID
	 */
	private String shoppingUUID;

	/**
	 * shoppingUUID.
	 *
	 * @return  the shoppingUUID
	 * @since   JDK 1.6
	 */
	public String getShoppingUUID() {
		return shoppingUUID;
	}

	/**
	 * shoppingUUID.
	 *
	 * @param   shoppingUUID    the shoppingUUID to set
	 * @since   JDK 1.6
	 */
	public void setShoppingUUID(String shoppingUUID) {
		this.shoppingUUID = shoppingUUID;
	}
	
}
