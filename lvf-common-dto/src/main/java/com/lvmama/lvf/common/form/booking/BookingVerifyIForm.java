package com.lvmama.lvf.common.form.booking;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.form.Form;

public class BookingVerifyIForm implements Form{
	
	private List<BookingVerifyDetailIForm> iForms = new ArrayList<BookingVerifyDetailIForm>();

	public List<BookingVerifyDetailIForm> getiForms() {
		return iForms;
	}

	public void setiForms(List<BookingVerifyDetailIForm> iForms) {
		this.iForms = iForms;
	}
	
}
