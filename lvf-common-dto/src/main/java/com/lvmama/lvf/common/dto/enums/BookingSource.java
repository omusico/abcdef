package com.lvmama.lvf.common.dto.enums;

/**
 * 订单预订来源
 * @author majun
 * @date   2015-3-16
 */
public enum BookingSource 
{
	DEFAULT("默认",BookingSourceType.DEFAULT),
	LVMAMA_FRONT("机票前台",BookingSourceType.FRONT),
	LVMAMA_ANDROID("机票Android",BookingSourceType.APP),
	LVMAMA_WINPHONE("机票Winphone",BookingSourceType.APP),
	LVMAMA_IOS("机票IOS",BookingSourceType.APP),
	LVMAMA_H5("机票H5",BookingSourceType.H5),
	LVMAMA_WAP("机票WAP",BookingSourceType.WAP),
	LAMAMA_BACK("机票后台",BookingSourceType.BACK),
	LAMAMA_DISTRIBUTION("机票分销",BookingSourceType.SALES),
	VST_PACKAGE_FRONT("VST打包前台",BookingSourceType.VST),
	VST_PACKAGE_ANDROID("VST打包Android",BookingSourceType.VST),
	VST_PACKAGE_IOS("VST打包IOS",BookingSourceType.VST),
	VST_PACKAGE_H5("VST打包H5",BookingSourceType.VST),
	VST_PACKAGE_BACK("VST打包后台",BookingSourceType.VST_BACK),
	VST_DISTRIBUTION("VST分销",BookingSourceType.VST),
	FIT_FRONT("交通X_前台",BookingSourceType.FIT),
	FIT_ANDROID("交通X_Android",BookingSourceType.FIT),
	FIT_IOS("交通X_IOS",BookingSourceType.FIT),
	FIT_WAP("交通X_WAP",BookingSourceType.FIT),
	FIT_BACK("交通X_后台",BookingSourceType.VST_BACK),
	FIT_DISTRIBUTION("交通X_分销",BookingSourceType.FIT);

	
	private String cnName;
	private BookingSourceType sourceType;
		
	
	
	private BookingSource(String cnName, BookingSourceType sourceType) {
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
