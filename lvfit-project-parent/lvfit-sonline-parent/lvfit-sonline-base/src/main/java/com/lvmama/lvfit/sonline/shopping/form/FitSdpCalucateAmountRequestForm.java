package com.lvmama.lvfit.sonline.shopping.form;

import com.lvmama.lvf.common.form.Form;

public class FitSdpCalucateAmountRequestForm implements Form{
	
	/**购物车id*/
	private String shoppingUUID;

	public final String getShoppingUUID() {
		return shoppingUUID;
	}

	public final void setShoppingUUID(String shoppingUUID) {
		this.shoppingUUID = shoppingUUID;
	}
	
}
