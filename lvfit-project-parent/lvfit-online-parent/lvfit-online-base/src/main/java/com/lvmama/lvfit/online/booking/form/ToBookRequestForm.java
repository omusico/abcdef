/**
 * Project Name:lvfit-online-base
 * File Name:ToBookRequestForm.java
 * Package Name:com.lvmama.lvfit.online.booking.form
 * Date:2015-12-15下午2:59:19
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.online.booking.form;

import com.lvmama.lvf.common.form.Form;

/**
 * ClassName:ToBookRequestForm <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-12-15 下午2:59:19 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class ToBookRequestForm implements Form{
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

