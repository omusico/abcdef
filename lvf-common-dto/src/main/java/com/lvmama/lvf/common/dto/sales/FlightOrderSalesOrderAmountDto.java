package com.lvmama.lvf.common.dto.sales;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.enums.SalesType;
import com.lvmama.lvf.common.dto.md.PriceFormula;

public class FlightOrderSalesOrderAmountDto implements Serializable {
		
	private BigDecimal salesOrderTotalAmount;

	public BigDecimal getSalesOrderTotalAmount() {
		return salesOrderTotalAmount;
	}

	public void setSalesOrderTotalAmount(BigDecimal salesOrderTotalAmount) {
		this.salesOrderTotalAmount = salesOrderTotalAmount;
	}
	
}
