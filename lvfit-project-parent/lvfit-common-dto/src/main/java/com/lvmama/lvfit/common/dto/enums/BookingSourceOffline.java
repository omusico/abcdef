package com.lvmama.lvfit.common.dto.enums;

/**
 * 订单预订来源
 * @author spinach
 * @date   2015-3-16
 */
public enum BookingSourceOffline {
	FIT_FRONT("交通X_前台",BookingSourceType.FRONT),
	FIT_BACK("交通X_后台",BookingSourceType.BACK),
	FIT_IOS("交通X_IOS",BookingSourceType.APP),
	FIT_ANDROID("交通X_Android",BookingSourceType.APP),
	FIT_WAP("交通X_WAP",BookingSourceType.WAP),
	FIT_DISTRIBUTION("交通X_分销",BookingSourceType.SALES);

	private String cnName;
	private BookingSourceType sourceType;
	
	private BookingSourceOffline(String cnName, BookingSourceType sourceType) {
		this.cnName = cnName;
		this.sourceType = sourceType;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public BookingSourceType getSourceType() {
		return sourceType;
	}

	public void setSourceType(BookingSourceType sourceType) {
		this.sourceType = sourceType;
	}

	public static BookingSourceOffline getBookingSourceOfflineName(String name) {
		if(name==null||"".equals(name)){
			return null;
		}
		for (BookingSourceOffline bookingSource : BookingSourceOffline.values()) {
			if (name.equals(bookingSource.name())) {
				return bookingSource;
			}
		}
		return null;
	}
}
