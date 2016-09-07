package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2016/8/2.
 */
public class FitSdpCalculateProductRequest implements Serializable {
    private static final long serialVersionUID = -1891489422434510450L;
    // 产品ID
    Long productId;
    // 出发城市CODE
    String departureCityCode;
    // 到达城市CODE
    String arrivalCityCode;

    //-----------非必须-----------
    /// 品类CODE
    String categoryCode = null;
    // 出发开始第几天
    Integer goRouteDayNum = null;
    // 返程开始第几天
    Integer backRouteDayNum = null;
    // 加价
    BigDecimal increasedPrice = null;
    // 成人数
    Long adultQuantity = null;
    // 儿童数
    Long childQuantity = null;

    BigDecimal peopleCount = BigDecimal.ZERO;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getDepartureCityCode() {
        return departureCityCode;
    }

    public void setDepartureCityCode(String departureCityCode) {
        this.departureCityCode = departureCityCode;
    }

    public String getArrivalCityCode() {
        return arrivalCityCode;
    }

    public void setArrivalCityCode(String arrivalCityCode) {
        this.arrivalCityCode = arrivalCityCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Integer getGoRouteDayNum() {
        return goRouteDayNum;
    }

    public void setGoRouteDayNum(Integer goRouteDayNum) {
        this.goRouteDayNum = goRouteDayNum;
    }

    public Integer getBackRouteDayNum() {
        return backRouteDayNum;
    }

    public void setBackRouteDayNum(Integer backRouteDayNum) {
        this.backRouteDayNum = backRouteDayNum;
    }

    public BigDecimal getIncreasedPrice() {
        return increasedPrice;
    }

    public void setIncreasedPrice(BigDecimal increasedPrice) {
        this.increasedPrice = increasedPrice;
    }


    public Long getAdultQuantity() {
        return adultQuantity;
    }

    public void setAdultQuantity(Long adultQuantity) {
        this.adultQuantity = adultQuantity;
    }

    public Long getChildQuantity() {
        return childQuantity;
    }

    public void setChildQuantity(Long childQuantity) {
        this.childQuantity = childQuantity;
    }

    public BigDecimal getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(BigDecimal peopleCount) {
        this.peopleCount = peopleCount;
    }
}
