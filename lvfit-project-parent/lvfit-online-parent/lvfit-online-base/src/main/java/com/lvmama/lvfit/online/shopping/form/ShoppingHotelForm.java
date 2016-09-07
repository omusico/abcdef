package com.lvmama.lvfit.online.shopping.form;

import java.io.Serializable;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;

public class ShoppingHotelForm implements Serializable,Form{
	
	
   /* // 产品ID
	private String productId;
	// 产品名称
	private String productName;

	//房型名称
	private String branchName;
	
	//房型id
	private String branchId;
	
	// 床型
	private String bedType;
	// 是否可以加床
	private String extraBed;
	// 宽带（有、无、收费）
	private String broadband;
	
	private Integer breakfast;//入住早餐情况

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public String getExtraBed() {
		return extraBed;
	}

	public void setExtraBed(String extraBed) {
		this.extraBed = extraBed;
	}

	public String getBroadband() {
		return broadband;
	}

	public void setBroadband(String broadband) {
		this.broadband = broadband;
	}

	public Integer getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(Integer breakfast) {
		this.breakfast = breakfast;
	}*/
    
	private HotelSearchHotelDto hotelSearchHotelDto;

	public HotelSearchHotelDto getHotelSearchHotelDto() {
		return hotelSearchHotelDto;
	}

	public void setHotelSearchHotelDto(HotelSearchHotelDto hotelSearchHotelDto) {
		this.hotelSearchHotelDto = hotelSearchHotelDto;
	}
	
	
}
