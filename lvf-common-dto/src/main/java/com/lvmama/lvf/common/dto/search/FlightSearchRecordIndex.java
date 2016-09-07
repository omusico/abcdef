package com.lvmama.lvf.common.dto.search;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.enums.BookingSource;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.solr.json.DynamicIndex;


/**
 * 机票查询记录索引
 * @author leizhengwei
 * 2015年10月30日
 */
public class FlightSearchRecordIndex  extends  DynamicIndex  implements  Serializable{
	
	private static final long serialVersionUID = 6860129629032714372L;
	
	private Map fields = new HashMap();

	/*	查询日期 	查询时间 	始发地 	目的地 	出发日期 	查询结果成功失败	耗时 	返回记录数 	渠道 	客户账号 	客户code 	客户名 	客户IP*/
	
	private String indexId;
	
	private  String selectDate;
	
	private  Long selectTime;
	
	private String departureCityCode;
	
	private String arrivalCityCode;
	
	private String departureDate;
	
	private ResultStatus resultStatus;
	
	private Long usedTime;
	
	private Integer returnCount;
	
	private BookingSource  bookingSource;
	
	private String customerId;
	
	private String customerCode;
	
	private String customerName;
	
	private String customerIp;
	
	private Boolean isHitCache;
	
	private Boolean isFlightSearch;

	public String getIndexId() {
		return this.indexId;
	}

	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}

	public String getSelectDate() {
		return selectDate;
	}

	public void setSelectDate(String selectDate) {
		this.selectDate = selectDate;
		fields.put("selectDate", selectDate);
	}

	public Long getSelectTime() {
		return selectTime;
	}

	public void setSelectTime(Long selectTime) {
		this.selectTime = selectTime;
		fields.put("selectTime", selectTime);
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

	
	public Boolean getIsFlightSearch() {
		return isFlightSearch;
	}

	public void setIsFlightSearch(Boolean isFlightSearch) {
		this.isFlightSearch = isFlightSearch;
		fields.put("isFlightSearch", isFlightSearch);
	}

	@Override
	@JsonIgnore
	public Map getFields() {
		fields.put("indexId",getIndexId());
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
	

	/**
	 * 将类的所有属性按逗号分隔，方便EXCEL导出
	 * @return
	 */
    public String build() {
    	StringBuffer sb = new StringBuffer();
    	sb.append(this.getIndexId()).append(",");
    	sb.append(this.getSelectDate()).append(",");
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String selectTime = formatter.format(new Date(this.getSelectTime()));
    	sb.append(selectTime).append(",")
    		.append(this.getDepartureCityCode()).append(",")
    		.append(this.getArrivalCityCode()).append(",")
    		.append(this.getDepartureDate()).append(",")
    		.append(this.getResultStatus()).append(",")
    		.append(this.getUsedTime()).append(",")
    		.append(this.getReturnCount()).append(",")
    		.append(this.getIsHitCache()).append(",")
    		.append(this.getIsFlightSearch()).append(",")
    		.append(this.getBookingSource()).append(",")
    		.append(this.getCustomerId()).append(",")
    		.append(this.getCustomerCode()).append(",")
    		.append(this.getCustomerName()).append(",")
    		.append(this.getCustomerIp());
    	return sb.toString();
    }
    
    
	
}
