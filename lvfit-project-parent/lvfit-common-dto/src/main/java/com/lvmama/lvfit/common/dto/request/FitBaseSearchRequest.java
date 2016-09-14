package com.lvmama.lvfit.common.dto.request;

import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.VSTDistrictCityEnum;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/6.
 */
public class FitBaseSearchRequest implements Serializable {

    private static final long serialVersionUID = 6329538375789931821L;

    //目的地的三字码
    private String arrivalCityCode;
    //出发地的三字码
    private String departureCityCode;
    //入住城市三字码
    private String cityCode;
    //去程时间
    private String departureTime;
    //返程时间
    private String returnTime;
    //入住时间
    private String checkInTime;
    //离店时间
    private String checkOutTime;
    //成人数
    private int adultsCount;
    //儿童数
    private int childCount;
    //UUID
    private String shoppingUUID;
    //出行类型
    private String tripType;

    private BookingSource bookingSource = BookingSource.FIT_FRONT;

    public String getArrivalCityCode() {
        return arrivalCityCode;
    }

    public void setArrivalCityCode(String arrivalCityCode) {
        this.arrivalCityCode = arrivalCityCode;
    }

    public String getDepartureCityCode() {
        return departureCityCode;
    }

    public void setDepartureCityCode(String departureCityCode) {
        this.departureCityCode = departureCityCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDepartureCityName() {
        VSTDistrictCityEnum cityEnum = VSTDistrictCityEnum.getByCode(departureCityCode);
        return cityEnum.getCnName();
    }

    public String getArrivalCityName() {
        VSTDistrictCityEnum cityEnum = VSTDistrictCityEnum.getByCode(arrivalCityCode);
        return cityEnum.getCnName();
    }

    public String getCityName() {
        VSTDistrictCityEnum cityEnum = VSTDistrictCityEnum.getByCode(cityCode);
        return cityEnum.getCnName();
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public int getAdultsCount() {
        return adultsCount;
    }

    public void setAdultsCount(int adultsCount) {
        this.adultsCount = adultsCount;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public String getShoppingUUID() {
        return shoppingUUID;
    }

    public void setShoppingUUID(String shoppingUUID) {
        this.shoppingUUID = shoppingUUID;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public BookingSource getBookingSource() {
        return bookingSource;
    }

    public void setBookingSource(BookingSource bookingSource) {
        this.bookingSource = bookingSource;
    }
}
