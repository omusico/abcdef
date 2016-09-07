package com.lvmama.lvfit.common.utils;

import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.OrderType;
import com.lvmama.lvfit.common.dto.enums.Product;

public interface FitGeneratorOrderNo {

	/**
	 * 产品2位
	 * 年月日 yyMMdd
	 * 出退改1位
	 * 订单号序列6位
	 * @return
	 */
	String generateFitOrderNo(BookingSource source, Product product, OrderType orderType);

}
