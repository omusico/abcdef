/**
 * Project Name:lvfit-common-dto
 * File Name:FitHotelRoomRequest.java
 * Package Name:com.lvmama.lvfit.common.dto.hotel
 * Date:2015-12-4下午5:09:32
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;

/**
 * ClassName:FitHotelRoomRequest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-12-4 下午5:09:32 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class FitHotelRoomRequest implements Serializable {
	
	/**
	 * serialVersionUID:TODO().
	 * @since JDK 1.6
	 */
	private static final long serialVersionUID = 5691592928940255106L;
	
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	private Long roomId;

}

