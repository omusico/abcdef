package com.lvmama.lvf.common.form.booking;

import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.form.Form;

public class BookingVerifyRForm implements Form{
	
	public BookingVerifyRForm() {
		super();
	}
	
	public BookingVerifyRForm(List<BookingVerifyDetailRForm> detailRForms) {
		super();
		this.detailRForms = detailRForms;
	}

	private List<BookingVerifyDetailRForm> detailRForms = new ArrayList<BookingVerifyDetailRForm>();

	public List<BookingVerifyDetailRForm> getDetailRForms() {
		return detailRForms;
	}

	public void setDetailRForms(List<BookingVerifyDetailRForm> detailRForms) {
		this.detailRForms = detailRForms;
	}

	
}
