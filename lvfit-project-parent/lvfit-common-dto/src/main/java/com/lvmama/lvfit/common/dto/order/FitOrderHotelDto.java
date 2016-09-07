package com.lvmama.lvfit.common.dto.order;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.ProductResource;

import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 订单酒店快照
 * @author qihuisong
 */
public class FitOrderHotelDto extends Entity {

    private static final long serialVersionUID = -8259059085145108297L;

    private String hotelId;
    private String hotelName;
    private String roomId;
    private String roomName;
    private String planId;
    private String planName;
    private Date checkin;
    private Date checkout;
    private BigDecimal salesPrice;
    private ProductResource productResource;
    private int roomCount;
    private String bedType;
    /** 宽带（有、无、收费） */
    private String broadband;
    /** 早餐 */
    private Integer breakfast;
    /** 入住城市 */
    private String checkInCity;
    
    private String detailId;


    @JsonIgnore
    public String getBranchDesc() {
        String bedType = null == this.getBedType() ? "" : "床型：" + this.getBedType();
        Integer con = this.getBreakfast();
        String breakfast = null == con ? "" : "早餐：" + (0 == con ? "无" : (1 == con ? "单早" : (2 == con ? "双早" : con)));
        String wifi = null == this.getBroadband() ? "" : "宽带：" + this.getBroadband();
        return bedType + " " + breakfast + " " + wifi;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public ProductResource getProductResource() {
        return productResource;
    }

    public void setProductResource(ProductResource productResource) {
        this.productResource = productResource;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
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
    }

	public final String getCheckInCity() {
		return checkInCity;
	}

	public final void setCheckInCity(String checkInCity) {
		this.checkInCity = checkInCity;
	}

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}
	
}
