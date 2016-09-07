package com.lvmama.lvf.common.dto.calculator;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.enums.BookingSource;

public class AmountCalculatorRequest {

	/**乘客相关信息 */
	private List<BookingDetailDto> passengerDetailDtos = new ArrayList<BookingDetailDto>();
	
	/**快递信息请求对象 */
	private ExpressInfoRequest expressRequest = new ExpressInfoRequest();
	
	//用于整单换供应商
    private String suppCode;
    //用于整单换供应商
    private boolean changeSupp = false;
	
	/**
	 * 
	 * @return
	 */
	private BookingSource bookingSource = BookingSource.DEFAULT;
	
	public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}

	public List<BookingDetailDto> getPassengerDetailDtos() {
		return passengerDetailDtos;
	}

	public void setPassengerDetailDtos(List<BookingDetailDto> passengerDetailDtos) {
		this.passengerDetailDtos = passengerDetailDtos;
	}

	public ExpressInfoRequest getExpressRequest() {
		return expressRequest;
	}

	public void setExpressRequest(ExpressInfoRequest expressRequest) {
		this.expressRequest = expressRequest;
	}

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public boolean isChangeSupp() {
		return changeSupp;
	}

	public void setChangeSupp(boolean changeSupp) {
		this.changeSupp = changeSupp;
	}
}
