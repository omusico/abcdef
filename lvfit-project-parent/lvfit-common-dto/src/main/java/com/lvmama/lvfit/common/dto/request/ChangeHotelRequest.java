/**
 * Project Name:lvfit-common-dto
 * File Name:ChangeHotelRequest.java
 * Package Name:com.lvmama.lvfit.common.dto.request
 * Date:2015-12-13下午2:54:48
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;

/**
 * ClassName:ChangeHotelRequest <br/>
 * Function: 修改酒店请求参数. <br/>
 * Date: 2015-12-13 下午2:54:48 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
public class ChangeHotelRequest implements Serializable {
	private static final long serialVersionUID = -825898291266989910L;
	
	private String shoppingUUID;

	private String hotelId;

	private String roomId;

	private String planId;
    
	/**
	 * 所选房间数
	 * */
	private int roomCount;
	public String getShoppingUUID() {
		return shoppingUUID;
	}

	public void setShoppingUUID(String shoppingUUID) {
		this.shoppingUUID = shoppingUUID;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public int getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}

    	

}
