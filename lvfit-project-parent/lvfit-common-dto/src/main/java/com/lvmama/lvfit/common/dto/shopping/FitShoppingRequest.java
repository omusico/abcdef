/**
 * Project Name:lvfit-common-dto
 * File Name:FitShoppingRequest.java
 * Package Name:com.lvmama.lvfit.common.dto.shopping
 * Date:2015-12-3下午9:54:50
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.common.dto.shopping;
/**
 * ClassName:FitShoppingRequest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-12-3 下午9:54:50 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class FitShoppingRequest {
	

	/**
	 * shoppingUUID
	 */
	private String shoppingUUID;
	   //更换酒店传以下字段
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
		
		
		//更换航班
		/**航班号Id */
		private Long flightId;
		
		/**航班号 */
		private String flightNo;
		
		/**舱位Id */
		private Long seatId;

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

		public Long getFlightId() {
			return flightId;
		}

		public void setFlightId(Long flightId) {
			this.flightId = flightId;
		}

		public String getFlightNo() {
			return flightNo;
		}

		public void setFlightNo(String flightNo) {
			this.flightNo = flightNo;
		}

		public Long getSeatId() {
			return seatId;
		}

		public void setSeatId(Long seatId) {
			this.seatId = seatId;
		}
		
		
        
}

