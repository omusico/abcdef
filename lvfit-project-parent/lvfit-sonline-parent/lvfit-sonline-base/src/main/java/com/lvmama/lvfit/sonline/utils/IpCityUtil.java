package com.lvmama.lvfit.sonline.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.comm.pet.po.pub.ComIps;
import com.lvmama.lvfit.common.client.FitVstClient;
import com.lvmama.lvfit.sonline.vo.IPMap;

@Component
public class IpCityUtil {

	@Autowired
	private FitVstClient fitVstClient;
	
	public static final Long DEFAULT_CITY_DISTRICTID = 9L;//多出发地默认推荐城市上海

	public  Long getDefaultIpCityCode(HttpServletRequest request) {

		    //从ip中获取
			String ipStr = request.getHeader("X-Real-IP");
	        if (ipStr == null) {
	        	ipStr =request.getRemoteAddr();
	        }
		    long ip = IPMap.stringToLong(ipStr);
			ComIps comIps = fitVstClient.getComIps(String.valueOf(ip));
			if (comIps != null&&StringUtils.isNotBlank(comIps.getCityId())) {
				return Long.valueOf(comIps.getCityId());
			}
		return DEFAULT_CITY_DISTRICTID;
	}


}
