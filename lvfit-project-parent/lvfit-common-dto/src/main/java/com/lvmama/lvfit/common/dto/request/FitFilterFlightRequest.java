package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;

/**
 * 航班筛选请求
 */
public class FitFilterFlightRequest implements Serializable {

    private static final long serialVersionUID = 8425350904892741231L;

    private String shoppingUuid;

    private String flightTripType;

    private String depTimeSegmentKey;

    private String arvTimeSegmentKey;

    private String carrierNameCodeKey;

    private String depAirportNameCodeKey;

    private String arvAirportNameCodeKey;

    private String sortField;

    private String sortType;

    public String getShoppingUuid() {
        return shoppingUuid;
    }

    public void setShoppingUuid(String shoppingUuid) {
        this.shoppingUuid = shoppingUuid;
    }

    public String getFlightTripType() {
        return flightTripType;
    }

    public void setFlightTripType(String flightTripType) {
        this.flightTripType = flightTripType;
    }

    public String getDepTimeSegmentKey() {
        return depTimeSegmentKey;
    }

    public void setDepTimeSegmentKey(String depTimeSegmentKey) {
        this.depTimeSegmentKey = depTimeSegmentKey;
    }

    public String getArvTimeSegmentKey() {
        return arvTimeSegmentKey;
    }

    public void setArvTimeSegmentKey(String arvTimeSegmentKey) {
        this.arvTimeSegmentKey = arvTimeSegmentKey;
    }

    public String getCarrierNameCodeKey() {
        return carrierNameCodeKey;
    }

    public void setCarrierNameCodeKey(String carrierNameCodeKey) {
        this.carrierNameCodeKey = carrierNameCodeKey;
    }

    public String getDepAirportNameCodeKey() {
        return depAirportNameCodeKey;
    }

    public void setDepAirportNameCodeKey(String depAirportNameCodeKey) {
        this.depAirportNameCodeKey = depAirportNameCodeKey;
    }

    public String getArvAirportNameCodeKey() {
        return arvAirportNameCodeKey;
    }

    public void setArvAirportNameCodeKey(String arvAirportNameCodeKey) {
        this.arvAirportNameCodeKey = arvAirportNameCodeKey;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }
}
