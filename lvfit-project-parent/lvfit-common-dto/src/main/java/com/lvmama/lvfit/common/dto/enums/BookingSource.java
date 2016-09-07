package com.lvmama.lvfit.common.dto.enums;

/**
 * 订单预订来源
 * @author majun
 * @date   2015-3-16
 */
public enum BookingSource {
	
	DEFAULT("默认",BookingSourceType.DEFAULT,com.lvmama.lvf.common.dto.enums.BookingSource.DEFAULT,BookingBusinessType.DEFAUL),
	FIT_FRONT("交通+X_前台",BookingSourceType.FRONT,com.lvmama.lvf.common.dto.enums.BookingSource.FIT_FRONT,BookingBusinessType.FIT),
	FIT_ANDROID("交通+X_Android",BookingSourceType.APP,com.lvmama.lvf.common.dto.enums.BookingSource.FIT_ANDROID,BookingBusinessType.FIT),
	FIT_IOS("交通+X_IOS",BookingSourceType.APP,com.lvmama.lvf.common.dto.enums.BookingSource.FIT_IOS,BookingBusinessType.FIT),
	FIT_WAP("交通+X_WAP",BookingSourceType.WAP,com.lvmama.lvf.common.dto.enums.BookingSource.FIT_WAP,BookingBusinessType.FIT),
	FIT_BACK("交通+X_后台",BookingSourceType.BACK,com.lvmama.lvf.common.dto.enums.BookingSource.FIT_BACK,BookingBusinessType.FIT),
	FIT_DISTRIBUTION("交通+X_分销",BookingSourceType.SALES,com.lvmama.lvf.common.dto.enums.BookingSource.FIT_DISTRIBUTION,BookingBusinessType.FIT),
	FIT_SDP_FRONT("交通+地接_前台",BookingSourceType.FRONT,com.lvmama.lvf.common.dto.enums.BookingSource.FIT_FRONT,BookingBusinessType.FIT_SDP),
	FIT_SDP_ANDROID("交通+地接_ANDROID",BookingSourceType.APP,com.lvmama.lvf.common.dto.enums.BookingSource.FIT_ANDROID,BookingBusinessType.FIT_SDP),
	FIT_SDP_IOS("交通+地接_IOS",BookingSourceType.APP,com.lvmama.lvf.common.dto.enums.BookingSource.FIT_IOS,BookingBusinessType.FIT_SDP),
	FIT_SDP_WAP("交通+地接_WAP",BookingSourceType.WAP,com.lvmama.lvf.common.dto.enums.BookingSource.FIT_WAP,BookingBusinessType.FIT_SDP),
	FIT_SDP_DISTRIBUTION("交通+地接_分销",BookingSourceType.SALES,com.lvmama.lvf.common.dto.enums.BookingSource.FIT_DISTRIBUTION,BookingBusinessType.FIT_SDP),
	FIT_SDP_BACK("交通+地接_后台",BookingSourceType.BACK,com.lvmama.lvf.common.dto.enums.BookingSource.FIT_BACK,BookingBusinessType.FIT_SDP);

	private String cnName;
	private BookingSourceType sourceType;
	private com.lvmama.lvf.common.dto.enums.BookingSource parentSource;
	private BookingBusinessType bookingBusinessType;
	
	private BookingSource(String cnName, BookingSourceType sourceType,com.lvmama.lvf.common.dto.enums.BookingSource parentSource,BookingBusinessType bookingBusinessType) {
		this.cnName = cnName;
		this.sourceType = sourceType;
		this.parentSource = parentSource;
		this.bookingBusinessType = bookingBusinessType;
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


	public com.lvmama.lvf.common.dto.enums.BookingSource getParentSource() {
		return parentSource;
	}

	public void setParentSource(com.lvmama.lvf.common.dto.enums.BookingSource parentSource) {
		this.parentSource = parentSource;
	}

	public BookingBusinessType getBookingBusinessType() {
		return bookingBusinessType;
	}

	public void setBookingBusinessType(BookingBusinessType bookingBusinessType) {
		this.bookingBusinessType = bookingBusinessType;
	}

	public static BookingSource getBookingSourceName(String name) {
		if(name==null||"".equals(name)){
			return null;
		}
		for (BookingSource bookingSource : BookingSource.values()) {
			if (name.equals(bookingSource.name())) {
				return bookingSource;
			}
		}
		return null;
	}
	
	
}
