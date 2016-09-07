package com.lvmama.lvfit.common.dto.search;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.solr.json.DynamicIndex;
import com.lvmama.lvfit.common.dto.enums.BookingSource;

public class FitRecordSearchIndex extends DynamicIndex implements Serializable {

    private static final long serialVersionUID = 1388691481380022051L;

    private Map fields = new HashMap();
    // Index
    private String indexId;
    // traceId
    private String traceId;
    // 查询时间
    private String queryDate;
    // 查询时间
    private Long queryTime;
    // 出发城市码
    private String departureCityCode;
    // 到达城市码
    private String arrivalCityCode;
    // 去程时间
    private String departureDate;
    // 返程时间
    private String returnDate;
    // 入住城市
    private String stayCityCode;
    // 入住时间
    private String checkInDate;
    // 离店时间
    private String checkOutDate;
    // 成人人数
    private int adultCount;
    // 儿童人数
    private int childrenCount;
    // 查询结果
    private ResultStatus resultStatus;
    // 耗费时间
    private Long usedTime;
    // 查询记录数
    private Integer returnCount;
    // 预定来源
    private BookingSource bookingSource;
    // 用户ID
    private String customerId;
    // 用户CODE
    private String customerCode;
    // 用户名
    private String customerName;
    // 用户IP
    private String customerIp;
    // 是否击中缓存
    private Boolean isHitCache;
    // 错误信息
    private String errMsg;
    // IP地址
    private String ip;

    public String getIndexId() {
        return this.indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        fields.put("traceId", traceId);
        this.traceId = traceId;
    }

    public String getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(String queryDate) {
		fields.put("queryDate", queryDate);
		this.queryDate = queryDate;
	}

	public Long getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(Long queryTime) {
        fields.put("queryTime", queryTime);
        this.queryTime = queryTime;
    }

    public String getDepartureCityCode() {
        return departureCityCode;
    }

    public void setDepartureCityCode(String departureCityCode) {
        this.departureCityCode = departureCityCode;
        fields.put("departureCityCode", departureCityCode);
    }

    public String getArrivalCityCode() {
        return arrivalCityCode;
    }

    public void setArrivalCityCode(String arrivalCityCode) {
        this.arrivalCityCode = arrivalCityCode;
        fields.put("arrivalCityCode", arrivalCityCode);
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
        fields.put("departureDate", departureDate);
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
        fields.put("returnDate", returnDate);
    }

    public String getStayCityCode() {
        return stayCityCode;
    }

    public void setStayCityCode(String stayCityCode) {
        this.stayCityCode = stayCityCode;
        fields.put("stayCityCode", stayCityCode);
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
        fields.put("checkInDate", checkInDate);
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
        fields.put("checkOutDate", checkOutDate);
    }

    public int getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(int adultCount) {
        this.adultCount = adultCount;
        fields.put("adultCount", adultCount);
    }

    public int getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(int childrenCount) {
        this.childrenCount = childrenCount;
        fields.put("childrenCount", childrenCount);
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
        fields.put("resultStatus", resultStatus);
    }

    public Long getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(Long usedTime) {
        this.usedTime = usedTime;
        fields.put("usedTime", usedTime);
    }

    public Integer getReturnCount() {
        return returnCount;
    }

    public void setReturnCount(Integer returnCount) {
        this.returnCount = returnCount;
        fields.put("returnCount", returnCount);
    }

    public BookingSource getBookingSource() {
        return bookingSource;
    }

    public void setBookingSource(BookingSource bookingSource) {
        this.bookingSource = bookingSource;
        fields.put("bookingSource", bookingSource);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
        fields.put("customerId", customerId);
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
        fields.put("customerCode", customerCode);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
        fields.put("customerName", customerName);
    }

    public String getCustomerIp() {
        return customerIp;
    }

    public void setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
        fields.put("customerIp", customerIp);
    }

    public Boolean getIsHitCache() {
        return isHitCache;
    }

    public void setIsHitCache(Boolean isHitCache) {
        this.isHitCache = isHitCache;
        fields.put("isHitCache", isHitCache);
    }


    @Override
    public Map getFields() {
        fields.put("indexId", indexId);
        return fields;
    }

    @Override
    public void setFields(Map map) {
        // TODO Auto-generated method stub

    }

    @Override
    public void initDynamicBase(String dynamicBase) {
        // TODO Auto-generated method stub

    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
