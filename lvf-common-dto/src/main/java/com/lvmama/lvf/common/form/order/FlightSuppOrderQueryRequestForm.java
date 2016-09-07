package com.lvmama.lvf.common.form.order;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.enums.PaymentType;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;
import com.lvmama.lvf.common.dto.order.status.FlightOrderStatusDto;
import com.lvmama.lvf.common.dto.request.FlightSuppOrderQueryRequest;
import com.lvmama.lvf.common.form.Form;

public class FlightSuppOrderQueryRequestForm implements Serializable,Form {

	private static final long serialVersionUID = 1L;
	private FlightSuppOrderQueryRequest flightSuppOrderQueryRequest = new FlightSuppOrderQueryRequest();
	private Pagination pagination = new Pagination();
	
	public FlightSuppOrderQueryRequest getFlightSuppOrderQueryRequest() {
		return flightSuppOrderQueryRequest;
	}
	public void setFlightSuppOrderQueryRequest(
			FlightSuppOrderQueryRequest flightSuppOrderQueryRequest) {
		this.flightSuppOrderQueryRequest = flightSuppOrderQueryRequest;
	}
	//供应商驴妈妈编号
	public String getSuppOrderLvNo() {
		return flightSuppOrderQueryRequest.getSuppOrderLvNo();
	}
	public void setSuppOrderLvNo(String suppOrderLvNo) {
		flightSuppOrderQueryRequest.setSuppOrderLvNo(suppOrderLvNo);
	}
	//供应商OfficeNo
	public String getSuppOfficeNo() {
		return flightSuppOrderQueryRequest.getSuppOfficeNo();
	}
	public void setSuppOfficeNo(String suppOfficeNo) {
		flightSuppOrderQueryRequest.setSuppOfficeNo(suppOfficeNo);
	}
	//供应商订单号
	public String getSuppOrderNo() {
		return flightSuppOrderQueryRequest.getSuppOrderNo();
	}

	public void setSuppOrderNo(String suppOrderNo) {
		flightSuppOrderQueryRequest.setSuppOrderNo(suppOrderNo);
	}
	//pnr
	public String getPnr() {
        return flightSuppOrderQueryRequest.getPnr();
    }

    public void setPnr(String pnr) {
    	flightSuppOrderQueryRequest.setPnr(pnr);
    }
    //供应商
	public String getSuppCode() {
		return flightSuppOrderQueryRequest.getSuppCode();
	}
	public void setSuppCode(String suppCode) {
		flightSuppOrderQueryRequest.setSuppCode(suppCode);
	}
	//下单开始时间
    public String getOrderBookingQueryBegTime() {
        return flightSuppOrderQueryRequest.getOrderBookingQueryBegTime();
    }

    public void setOrderBookingQueryBegTime(String orderBookingQueryBegTime) {
    	flightSuppOrderQueryRequest.setOrderBookingQueryBegTime(orderBookingQueryBegTime);
    }
    //下单结束时间
    public String getOrderBookingQueryEndTime() {
    	return flightSuppOrderQueryRequest.getOrderBookingQueryEndTime();
    }
    
    public void setOrderBookingQueryEndTime(String orderBookingQueryEndTime) {
    	flightSuppOrderQueryRequest.setOrderBookingQueryEndTime(orderBookingQueryEndTime);
    }
    // 订单状态集合
	public FlightOrderStatusDto getFlightOrderStatus() {
		return flightSuppOrderQueryRequest.getFlightOrderStatus();
	}
	public void setFlightOrderStatus(FlightOrderStatusDto flightOrderStatus) {
		flightSuppOrderQueryRequest.setFlightOrderStatus(flightOrderStatus);
	}
	//支付方式
	public List<PaymentType> getPaymentType() {
		return flightSuppOrderQueryRequest.getPaymentType();
	}
	public void setPaymentType(List<PaymentType> paymentType) {
		flightSuppOrderQueryRequest.setPaymentType(paymentType);
	}
	//票号
	public String getTicketNo() {
		return flightSuppOrderQueryRequest.getTicketNo();
	}
	public void setTicketNo(String ticketNo) {
		flightSuppOrderQueryRequest.setTicketNo(ticketNo);
	}
	//航班号
	public String getFlightNo() {
		return flightSuppOrderQueryRequest.getFlightNo();
	}
	public void setFlightNo(String flightNo) {
		flightSuppOrderQueryRequest.setFlightNo(flightNo);
	}
	//航空公司
	public String getCarrierName() {
		return flightSuppOrderQueryRequest.getCarrierName();
	}
	public void setCarrierName(String carrierName) {
		flightSuppOrderQueryRequest.setCarrierName(carrierName);
	}
	//始发城市
	public String getDepartureCity() {
		return flightSuppOrderQueryRequest.getDepartureCity();
	}
	public void setDepartureCity(String departureCity) {
		flightSuppOrderQueryRequest.setDepartureCity(departureCity);
	}
	//到达城市
	public String getArriveCity() {
		return flightSuppOrderQueryRequest.getArriveCity();
	}
	public void setArriveCity(String arriveCity) {
		flightSuppOrderQueryRequest.setArriveCity(arriveCity);
	}
	//乘机开始时间
	public String getFlightQueryBegTime() {
		return flightSuppOrderQueryRequest.getFlightQueryBegTime();
	}
	public void setFlightQueryBegTime(String flightQueryBegTime) {
		flightSuppOrderQueryRequest.setFlightQueryBegTime(flightQueryBegTime);
	}
	//乘机结束时间
	public String getFlightQueryEndTime() {
		return flightSuppOrderQueryRequest.getFlightQueryEndTime();
	}
	public void setFlightQueryEndTime(String flightQueryEndTime) {
		flightSuppOrderQueryRequest.setFlightQueryEndTime(flightQueryEndTime);
	}
	//乘客信息
	public FlightOrderPassengerDto getFlightOrderPassenger() {
		return flightSuppOrderQueryRequest.getFlightOrderPassenger();
	}
	public void setFlightOrderPassenger(
			FlightOrderPassengerDto flightOrderPassenger) {
		flightSuppOrderQueryRequest
				.setFlightOrderPassenger(flightOrderPassenger);
	}
	//
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public void countRecords(int records) {
		pagination.countRecords(records);
	}

	public boolean equals(Object obj) {
		return pagination.equals(obj);
	}

	public int getPage() {
		return pagination.getPage();
	}

	public void setPage(int page) {
		pagination.setPage(page);
	}

	public int getRows() {
		return pagination.getRows();
	}

	public void setRows(int rows) {
		pagination.setRows(rows);
	}

	public void setRowsByCustom(int customRows) {
		pagination.setRowsByCustom(customRows);
	}

	public int getRecords() {
		return pagination.getRecords();
	}

	public void setRecords(int records) {
		pagination.setRecords(records);
	}

	public int getTotal() {
		return pagination.getTotal();
	}

	public void setTotal(int total) {
		pagination.setTotal(total);
	}

	public String getSidx() {
		return pagination.getSidx();
	}

	public void setSidx(String sidx) {
		pagination.setSidx(sidx);
	}

	public String getSord() {
		return pagination.getSord();
	}

	public void setSord(String sord) {
		pagination.setSord(sord);
	}

	public int getStartRow() {
		return pagination.getStartRow();
	}

	public int getEndRow() {
		return pagination.getEndRow();
	}

	public boolean isSearch() {
		return pagination.isSearch();
	}

	public void setSearch(boolean search) {
		pagination.setSearch(search);
	}
}
