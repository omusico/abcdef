package com.lvmama.lvfit.common.dto.request;

import com.lvmama.lvfit.common.dto.app.FitAppHotelRequest;

import java.io.Serializable;

/**
 * 该类包含被选中的酒店基本信息和搜索酒店的请求
 */
public class FitFilterHotelRequest implements Serializable {
    private static final long serialVersionUID = 5785446689793043637L;
    // 酒店搜索请求
    private FitAppHotelRequest hotelRequest = new FitAppHotelRequest();
    // 选中的酒店产品ID
    private String selHotelId;
    // 选中的酒店房间ID
    private String selHotelRoomId;
    // 选中的酒店规格ID
    private String selHotelPlanId;
    // 选中的酒店基准价
    private double hotelBasePrice;

    public FitAppHotelRequest getHotelRequest() {
        return hotelRequest;
    }

    public void setHotelRequest(FitAppHotelRequest hotelRequest) {
        this.hotelRequest = hotelRequest;
    }

    public String getSelHotelId() {
        return selHotelId;
    }

    public void setSelHotelId(String selHotelId) {
        this.selHotelId = selHotelId;
    }

    public String getSelHotelRoomId() {
        return selHotelRoomId;
    }

    public void setSelHotelRoomId(String selHotelRoomId) {
        this.selHotelRoomId = selHotelRoomId;
    }

    public String getSelHotelPlanId() {
        return selHotelPlanId;
    }

    public void setSelHotelPlanId(String selHotelPlanId) {
        this.selHotelPlanId = selHotelPlanId;
    }

    public double getHotelBasePrice() {
        return hotelBasePrice;
    }

    public void setHotelBasePrice(double hotelBasePrice) {
        this.hotelBasePrice = hotelBasePrice;
    }

    public void setChildCount(int childCount) {
        hotelRequest.setChildCount(childCount);
    }

    public String getKeywords() {
        return hotelRequest.getKeywords();
    }

    public void setKeywords(String keywords) {
        hotelRequest.setKeywords(keywords);
    }

    public String getCityCode() {
        return hotelRequest.getCityCode();
    }

    public void setCityCode(String cityCode) {
        hotelRequest.setCityCode(cityCode);
    }

    public String getDepartureDate() {
        return hotelRequest.getDepartureDate();
    }

    public void setDepartureDate(String departureDate) {
        hotelRequest.setDepartureDate(departureDate);
    }

    public String getReturnDate() {
        return hotelRequest.getReturnDate();
    }

    public void setReturnDate(String returnDate) {
        hotelRequest.setReturnDate(returnDate);
    }

    public String getParams() {
        return hotelRequest.getParams();
    }

    public void setParams(String params) {
        hotelRequest.setParams(params);
    }

    public String getQueryId() {
        return hotelRequest.getQueryId();
    }

    public void setQueryId(String queryId) {
        hotelRequest.setQueryId(queryId);
    }

    public Boolean getHotelFromRecommendedOnly() {
        return hotelRequest.getHotelFromRecommendedOnly();
    }

    public void setHotelFromRecommendedOnly(Boolean hotelFromRecommendedOnly) {
        hotelRequest.setHotelFromRecommendedOnly(hotelFromRecommendedOnly);
    }

    public int getAdultCount() {
        return hotelRequest.getAdultCount();
    }

    public void setAdultCount(int adultCount) {
        hotelRequest.setAdultCount(adultCount);
    }

    public int getChildCount() {
        return hotelRequest.getChildCount();
    }
}
