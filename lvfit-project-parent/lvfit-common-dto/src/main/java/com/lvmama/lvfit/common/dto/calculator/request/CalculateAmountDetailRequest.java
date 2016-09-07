package com.lvmama.lvfit.common.dto.calculator.request;

import java.io.Serializable;

import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;

public class CalculateAmountDetailRequest implements Serializable {

	private static final long serialVersionUID = 2681313174605457359L;
	
	private FitShoppingDto fitShoppingDto;
	
	private BookingSource bookingSource;

	public FitShoppingDto getFitShoppingDto() {
		return fitShoppingDto;
	}

	public void setFitShoppingDto(FitShoppingDto fitShoppingDto) {
		this.fitShoppingDto = fitShoppingDto;
	}

	public BookingSource getBookingSource() {
		return bookingSource;
	}

	public void setBookingSource(BookingSource bookingSource) {
		this.bookingSource = bookingSource;
	}

}
