package com.lvmama.lvf.common.dto.supp;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 供应商订单金额信息
 * @author majun
 * @date   2015-1-13
 */
public class FlightOrderSuppOrderAmountDto implements Serializable 
{
	private static final long serialVersionUID = -394637358815122035L;
	
	/** 供应商票面总价 */
	private BigDecimal suppTotalParPrice;
	
	/** 供应商燃油总价 */
	private BigDecimal suppTotalFuelTax;
	
	/** 供应商机建总价 */
	private BigDecimal suppTotalAirportTax;
	
	/** 供应商总结算价 */
	private BigDecimal suppSettlePrice;
	
	public BigDecimal getSuppTotalParPrice() {
		return suppTotalParPrice;
	}

	public void setSuppTotalParPrice(BigDecimal suppTotalParPrice) {
		this.suppTotalParPrice = suppTotalParPrice;
	}

	public BigDecimal getSuppTotalFuelTax() {
		return suppTotalFuelTax;
	}

	public void setSuppTotalFuelTax(BigDecimal suppTotalFuelTax) {
		this.suppTotalFuelTax = suppTotalFuelTax;
	}

	public BigDecimal getSuppTotalAirportTax() {
		return suppTotalAirportTax;
	}

	public void setSuppTotalAirportTax(BigDecimal suppTotalAirportTax) {
		this.suppTotalAirportTax = suppTotalAirportTax;
	}

	public BigDecimal getSuppSettlePrice() {
		return suppSettlePrice;
	}

	public void setSuppSettlePrice(BigDecimal suppSettlePrice) {
		this.suppSettlePrice = suppSettlePrice;
	}
}