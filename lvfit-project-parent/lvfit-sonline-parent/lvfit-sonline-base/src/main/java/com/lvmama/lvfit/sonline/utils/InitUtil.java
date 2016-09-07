package com.lvmama.lvfit.sonline.utils;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.lvmama.comm.pet.po.pub.ComIps;
import com.lvmama.lvfit.common.client.FitVstClient;
import com.lvmama.lvfit.sonline.vo.Constant;
import com.lvmama.lvfit.sonline.vo.IPMap;

public class InitUtil {

	protected String cityId;

	protected String provinceId;

	protected String stationName;
	
	protected String isNew;
	
	

	public InitUtil getProvinceIdCityIdStationName(HttpServletRequest request,FitVstClient fitVstClient) {

		
		// 1.从cookie中获取
		if (StringUtils.isBlank(this.getCityId())&& StringUtils.isBlank(this.getProvinceId())&& StringUtils.isBlank(this.getStationName())) {
			String cookie_cityId = ServletUtil.getCookieValue(request,Constant._IP_CITY_PLACE_ID);
			String cookie_provinceId = ServletUtil.getCookieValue(request,Constant._IP_PROVINCE_PLACE_ID);
			String cookie_stationName = ServletUtil.getCookieValue(request,Constant._IP_CITY_NAME);
			if (StringUtils.isNotBlank(cookie_stationName)) {
					try {
						cookie_stationName = java.net.URLDecoder.decode(cookie_stationName, "utf-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			if (StringUtils.isNotBlank(cookie_cityId)&& StringUtils.isNotBlank(cookie_provinceId)&& StringUtils.isNotBlank(cookie_stationName)) {
				this.setCityId(cookie_cityId);
				this.setProvinceId(cookie_provinceId);
				this.setStationName(cookie_stationName);
			}
		}

		// 2.从ip中获取
		if (StringUtils.isBlank(this.getCityId())&& StringUtils.isBlank(this.getProvinceId())&& StringUtils.isBlank(this.getStationName())) {
			 String ipStr = request.getHeader("X-Real-IP");
	        if (ipStr == null) {
	        	ipStr =request.getRemoteAddr();
	        }
		    long ip = IPMap.stringToLong(ipStr);
			ComIps comIps = fitVstClient.getComIps(String.valueOf(ip));
			if (comIps != null&&StringUtils.isNotBlank(comIps.getCityId())) {
				this.setCityId(comIps.getCityId());
				this.setProvinceId(comIps.getProvinceId());
				this.setStationName(comIps.getCityName());
			}
		}

		// 3.从默认值中获取
		if (StringUtils.isBlank(this.getCityId())) {
			this.setCityId(PindaoPageUtils.CITY.shanghai.getCode());
		}
		if (StringUtils.isBlank(this.getProvinceId())) {
			this.setProvinceId(PindaoPageUtils.PROVINCE.shanghai.getCode());
		}
		if (StringUtils.isBlank(this.getStationName())) {
			this.setStationName(PindaoPageUtils.CITY.shanghai.getCnName());
		}
		return this;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getIsNew() {
		return isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	
    

}
