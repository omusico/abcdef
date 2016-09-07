package com.lvmama.lvf.common.dto.coupon;

import java.io.Serializable;
import java.util.Date;

public class FlightUserCouponDto implements Serializable {


	private static final long serialVersionUID = -2841778135213010548L;
	private Long couponCodeId ;
	private String couponName;
    private String couponCode;
    private Float discountAmount;//优惠金额
    private Date startTime;//优惠券的生效日期
    private Date endTime;//优惠券有效期
    private String expiredDate;//有效期-失效期格式:"yyyy-MM-dd至yyyy-MM-dd"



    private String validInfo;



	public Date getStartTime() {
		return startTime;
	}



	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}



	public Long getCouponCodeId() {
		return couponCodeId;
	}



	public void setCouponCodeId(Long couponCodeId) {
		this.couponCodeId = couponCodeId;
	}



	public String getCouponName() {
		return couponName;
	}



	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}



	public String getCouponCode() {
		return couponCode;
	}



	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}



	public Float getDiscountAmount() {
		return discountAmount;
	}



	public void setDiscountAmount(Float discountAmount) {
		this.discountAmount = discountAmount;
	}



	public Date getEndTime() {
		return endTime;
	}



	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}



	public String getExpiredDate() {
		return expiredDate;
	}



	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}



	public String getValidInfo() {
		return validInfo;
	}



	public void setValidInfo(String validInfo) {
		this.validInfo = validInfo;
	}
    
    
    
    
    }