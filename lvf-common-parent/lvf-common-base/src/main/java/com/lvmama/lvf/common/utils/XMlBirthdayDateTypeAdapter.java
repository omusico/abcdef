package com.lvmama.lvf.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class XMlBirthdayDateTypeAdapter extends XmlAdapter<String, Date> {
	
	@Override
	public String marshal(Date value) throws Exception {
		SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(value); 
	}

	@Override
	public Date unmarshal(String value) throws Exception {
		SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.parse(value);    
	}

}
