/*
 * Copyright by Lvmama and the original author or authors.
 * 
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about Lvmama from
 *
 *      http://www.lvmama.com
 *
 */ 
package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;

/**
 * T_FORD_PASSENGER  旅客信息请求 request
 * <p style="display:none">modifyRecord</p>
 * <p style="display:none">version:V1.0,author:yangxiaolong,
 *		date:2016-8-19 上午10:03:49,content: </p>
 * @author yangxiaolong
 * @date 2016-8-19 上午10:03:49
 * @since
 * @version
 */
public class FlightPassengerRequest implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1736634405905876253L;
	
	private FlightOrderPassengerDto flightOrderPassengerDto;

	/**
	 * @return  the flightOrderPassengerDto
	 */
	public FlightOrderPassengerDto getFlightOrderPassengerDto() {
		return flightOrderPassengerDto;
	}

	/**
	 * @param flightOrderPassengerDto the flightOrderPassengerDto to set
	 */
	public void setFlightOrderPassengerDto(
			FlightOrderPassengerDto flightOrderPassengerDto) {
		this.flightOrderPassengerDto = flightOrderPassengerDto;
	}
	
}
