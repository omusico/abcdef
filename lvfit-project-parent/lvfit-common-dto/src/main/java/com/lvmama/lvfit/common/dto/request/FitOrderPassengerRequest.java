/**
 * Project Name:lvfit-common-dto
 * File Name:FitOrderPassengerRequest.java
 * Package Name:com.lvmama.lvfit.common.dto.request
 * Date:2015-12-10下午10:16:47
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvfit.common.dto.member.FitPassengerInfoDto;

/**
 * ClassName:FitOrderPassengerRequest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2015-12-10 下午10:16:47 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public class FitOrderPassengerRequest implements Serializable {
	private static final long serialVersionUID = 3257336525470379987L;
	/**   当前用户登陆人：参数必填  **/
	private String userId;

	private List<FitPassengerInfoDto> fitPassengers = new ArrayList<FitPassengerInfoDto>();

	/**
	 * userId.
	 * 
	 * @return the userId
	 * @since JDK 1.6
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * userId.
	 * 
	 * @param userId the userId to set
	 * @since JDK 1.6
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * fitPassengers.
	 * 
	 * @return the fitPassengers
	 * @since JDK 1.6
	 */
	public List<FitPassengerInfoDto> getFitPassengers() {
		return fitPassengers;
	}

	/**
	 * fitPassengers.
	 * 
	 * @param fitPassengers the fitPassengers to set
	 * @since JDK 1.6
	 */
	public void setFitPassengers(List<FitPassengerInfoDto> fitPassengers) {
		this.fitPassengers = fitPassengers;
	}

}
