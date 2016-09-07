package com.lvmama.lvf.common.dto.sales;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.PayBalanceType;
import com.lvmama.lvf.common.dto.enums.SalesType;
import com.lvmama.lvf.common.dto.order.FlightOrderDto;

public class FlightOrderSalesOrderDto  extends Entity implements Serializable {
	
	private Sales sales;
	private String salesOrderId;
	private String salesOrderNo;
	private FlightOrderDto flightOrder;
	private FlightOrderSalesOrderAmountDto flightOrderSalesOrderAmount;
	public Sales getSales() {
		return sales;
	}
	public void setSales(Sales sales) {
		this.sales = sales;
	}
	public String getSalesOrderId() {
		return salesOrderId;
	}
	public void setSalesOrderId(String salesOrderId) {
		this.salesOrderId = salesOrderId;
	}
	public String getSalesOrderNo() {
		return salesOrderNo;
	}
	public void setSalesOrderNo(String salesOrderNo) {
		this.salesOrderNo = salesOrderNo;
	}
	public FlightOrderDto getFlightOrder() {
		return flightOrder;
	}
	public void setFlightOrder(FlightOrderDto flightOrder) {
		this.flightOrder = flightOrder;
	}
	public FlightOrderSalesOrderAmountDto getFlightOrderSalesOrderAmount() {
		return flightOrderSalesOrderAmount;
	}
	public void setFlightOrderSalesOrderAmount(
			FlightOrderSalesOrderAmountDto flightOrderSalesOrderAmount) {
		this.flightOrderSalesOrderAmount = flightOrderSalesOrderAmount;
	}
	
	
	
}
