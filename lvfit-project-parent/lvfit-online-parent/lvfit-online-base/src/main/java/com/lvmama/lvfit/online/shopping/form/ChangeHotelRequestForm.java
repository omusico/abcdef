/**
 * Project Name:lvfit-online-base
 * File Name:ChangeHotelRequestForm.java
 * Package Name:com.lvmama.lvfit.online.shopping.form
 * Date:2015-12-15下午3:55:09
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.online.shopping.form;

import com.lvmama.lvf.common.form.Form;

/**
 * ClassName:ChangeHotelRequestForm <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-12-15 下午3:55:09 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class ChangeHotelRequestForm implements Form{
	private String shoppingUUID;
	private String hotelUUID;
	/**
	 * 酒店id
	 */
	private String hotelId;
	
	/**
	 * 房间id
	 */
	private String roomId;
	
	/**
	 * planId
	 */
	private String planId;

	/**
	 * 所选房间数
	 * */
	private int roomCount;
	
	/**
	 * hotelUUID.
	 *
	 * @return  the hotelUUID
	 * @since   JDK 1.6
	 */
	public String getHotelUUID() {
		return hotelUUID;
	}

	/**
	 * hotelUUID.
	 *
	 * @param   hotelUUID    the hotelUUID to set
	 * @since   JDK 1.6
	 */
	public void setHotelUUID(String hotelUUID) {
		this.hotelUUID = hotelUUID;
	}

	/**
	 * hotelId.
	 *
	 * @return  the hotelId
	 * @since   JDK 1.6
	 */
	public String getHotelId() {
		return hotelId;
	}

	/**
	 * hotelId.
	 *
	 * @param   hotelId    the hotelId to set
	 * @since   JDK 1.6
	 */
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	/**
	 * roomId.
	 *
	 * @return  the roomId
	 * @since   JDK 1.6
	 */
	public String getRoomId() {
		return roomId;
	}

	/**
	 * roomId.
	 *
	 * @param   roomId    the roomId to set
	 * @since   JDK 1.6
	 */
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	/**
	 * planId.
	 *
	 * @return  the planId
	 * @since   JDK 1.6
	 */
	public String getPlanId() {
		return planId;
	}

	/**
	 * planId.
	 *
	 * @param   planId    the planId to set
	 * @since   JDK 1.6
	 */
	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getShoppingUUID() {
		return shoppingUUID;
	}

	public void setShoppingUUID(String shoppingUUID) {
		this.shoppingUUID = shoppingUUID;
	}

	public int getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}
	
	
}

