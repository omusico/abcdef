package com.lvmama.lvfit.common.dto.calculator;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvfit.common.dto.enums.BookingSource;

public class AmountCalculatorRequest {

	/**乘客相关信息 */
	private List<BookingDetailDto> passengerDetailDtos = new ArrayList<BookingDetailDto>();
	
	/**快递信息请求对象 */
	private ExpressInfoRequest expressRequest = new ExpressInfoRequest();
	
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

    
	
}
