package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.List;

/**
 * 1.获取用户下所有满足该笔订单优惠券（不传couponCodes）
 * 2.根据用户输入优惠券号（集合）check是否满足该笔订单若满足返回优惠券信息（集合）(需要传couponCodes)
 *
 */
public class FlightOrderCouponsRequest implements Serializable {


	private static final long serialVersionUID = 6975440809183664882L;
	
	/**用户短id customrCode**/
	private String userId;
	
	/**订单应付金额**/
	private Long oughtPay;
	
	/**订单份数**/
	private Long quantity;
	
	
	
	/**   根据用户输入优惠券号（集合）**/
	private  List<String> couponCodes;
	
	

	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getOughtPay() {
		return oughtPay;
	}

	public void setOughtPay(Long oughtPay) {
		this.oughtPay = oughtPay;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}



	public List<String> getCouponCodes() {
		return couponCodes;
	}

	public void setCouponCodes(List<String> couponCodes) {
		this.couponCodes = couponCodes;
	}
	
	
	
	
	
	
}
