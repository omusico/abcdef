/**
 * Project Name:lvfit-common-dto
 * File Name:HotelDetailForm.java
 * Package Name:com.lvmama.lvfit.common.form.hotel
 * Date:2015-12-3上午11:55:18
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.common.form.hotel;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.request.FitHotelRequest;

/**
 * ClassName:HotelDetailForm <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-12-3 上午11:55:18 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
/**
 * @author wanghuihui
 * @date:2015年12月11日 上午11:17:22
 */
public class HotelDetailForm implements Serializable , Form{
	/**
	 * serialVersionUID:TODO().
	 * @since JDK 1.6
	 */
	private static final long serialVersionUID = 3335317145220332260L;
	
	FitHotelRequest request = new FitHotelRequest();
	
	public void setRequest(FitHotelRequest request) {
		this.request = request;
	}
	
	public FitHotelRequest getRequest() {
		return request;
	}

	public Long getHotelId() {
		return request.getHotelId();
	}

	public void setHotelId(Long hotelId) {
		request.setHotelId(hotelId);
	}

	public Date getStartDate() {
		return request.getStartDate();
	}

	public void setStartDate(String startDate) {
		if(StringUtils.isNotEmpty(startDate)){
			request.setStartDate(DateUtils.parseDate(startDate));
		}
	}

	public Date getEndDate() {
		return request.getEndDate();
	}

	public void setEndDate(String endDate) {
		if(StringUtils.isNotEmpty(endDate)){
			request.setEndDate(DateUtils.parseDate(endDate));
		}
	}

}

