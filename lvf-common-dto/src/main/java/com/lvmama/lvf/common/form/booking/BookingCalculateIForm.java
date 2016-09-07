package com.lvmama.lvf.common.form.booking;

import java.util.List;

import com.lvmama.lvf.common.dto.calculator.AmountCalculatorRequest;
import com.lvmama.lvf.common.dto.calculator.ExpressInfoRequest;
import com.lvmama.lvf.common.dto.calculator.BookingDetailDto;
import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.form.Form;

public class BookingCalculateIForm implements Form{

	
	private AmountCalculatorRequest request = new AmountCalculatorRequest();

	public AmountCalculatorRequest getRequest() {
		return request;
	}

	public void setRequest(AmountCalculatorRequest request) {
		this.request = request;
	}

	public List<BookingDetailDto> getPassengerDetailDtos() {
		return request.getPassengerDetailDtos();
	}

	public void setPassengerDetailDtos(
			List<BookingDetailDto> passengerDetailDtos) {
		request.setPassengerDetailDtos(passengerDetailDtos);
	}

	public ExpressInfoRequest getExpressRequest() {
		return request.getExpressRequest();
	}

	public void setExpressRequest(ExpressInfoRequest expressRequest) {
		request.setExpressRequest(expressRequest);
	}

	public BookingSource getBookingSource() {
		return request.getBookingSource();
	}

	public void setBookingSource(BookingSource bookingSource) {
		request.setBookingSource(bookingSource);
	}

    

	
	
	
}
