/**
 * Project Name:lvfit-online-base
 * File Name:ShoppingController.java
 * Package Name:com.lvmama.lvfit.online.shopping
 * Date:2015-12-3下午1:38:20
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.online.shopping;

import com.lvmama.lvfit.common.dto.request.ChangeHotelRequest;
import org.springframework.ui.Model;

public interface ShoppingHotelController {

	String changePlan(Model model, ChangeHotelRequest request);

	String changeHotel(Model model, ChangeHotelRequest request);
}
