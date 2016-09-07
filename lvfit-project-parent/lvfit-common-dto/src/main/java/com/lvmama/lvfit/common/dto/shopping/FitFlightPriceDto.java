/**
 * Project Name:lvfit-common-dto
 * File Name:FitFlightPriceDto.java
 * Package Name:com.lvmama.lvfit.common.dto.shopping
 * Date:2015-12-24下午8:29:27
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.common.dto.shopping;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ClassName:FitFlightPriceDto <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-12-24 下午8:29:27 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class FitFlightPriceDto implements Serializable{
	private static final long serialVersionUID = -998894254095104056L;
	/**
	 * 单价
	 */
	private BigDecimal salesPrice;
	/**
	 * 优惠价
	 */
	private BigDecimal promotionPrice;
	/**
	 * salesPrice.
	 *
	 * @return  the salesPrice
	 * @since   JDK 1.6
	 */
	public BigDecimal getSalesPrice() {
		return salesPrice;
	}
	/**
	 * salesPrice.
	 *
	 * @param   salesPrice    the salesPrice to set
	 * @since   JDK 1.6
	 */
	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}
	/**
	 * promotionPrice.
	 *
	 * @return  the promotionPrice
	 * @since   JDK 1.6
	 */
	public BigDecimal getPromotionPrice() {
		return promotionPrice;
	}
	/**
	 * promotionPrice.
	 *
	 * @param   promotionPrice    the promotionPrice to set
	 * @since   JDK 1.6
	 */
	public void setPromotionPrice(BigDecimal promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

}

