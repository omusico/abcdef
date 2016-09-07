package com.lvmama.lvfit.common.dto.search;

import java.io.Serializable;


public class FitPassengerRequest implements Serializable{
	
	private static final long serialVersionUID = -1718281417122694414L;
	private int adultCount;
	private int childCount;

	public int getAdultCount() {
		return adultCount;
	}

	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
	}

	public int getChildCount() {
		return childCount;
	}

	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}
}
