package com.lvmama.lvf.common.dto.enums;

public enum ChannelWap {
	
	ANDROID("ANDROID"),
	IPHONE ("IOS"),
	TOUCH("WAP");

	private String cnName;

	public String getCnName() {
		return cnName;
	}

	private ChannelWap(String cnName) {
		this.cnName = cnName;
	}
	
	public static String getWapFromVst(String channelValue){
		
		if(channelValue.contains(ChannelWap.ANDROID.name())){
			return BookingSource.VST_PACKAGE_ANDROID.name();
		}
		if(channelValue.contains(ChannelWap.IPHONE.name())){
			return BookingSource.VST_PACKAGE_IOS.name();
		}
		if(channelValue.contains(ChannelWap.TOUCH.name())){
			return BookingSource.VST_PACKAGE_H5.name();
		}
		return null;
	}
	
}
