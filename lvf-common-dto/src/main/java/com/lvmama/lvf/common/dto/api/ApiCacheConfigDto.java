package com.lvmama.lvf.common.dto.api;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.request.ApiCacheConfigRequest;
import com.lvmama.lvf.common.utils.DateUtils;

public class ApiCacheConfigDto extends Entity implements Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 5730253855398850667L;
	/**查询key值*/
	private String queryKey;
	/**查询keyMD5值*/
	private String queryKeyMD5;
	/**最后查询时间*/
	private Date lastQueryTime;
	/**最后查询Api时间*/
	private Date lastQueryApiTime;
	/**查询次数*/
	private Long accCount;
	/**查询api的次数*/
	private Long apiCount;
	/**查询Api数量限制*/
	private Long queryApiCountLimit;
	/**查询Api时间限制*/
	private Date queryApiTimeLimit;
	/**cacheKey的值*/
	private String cacheKey;
	/**查询Api有效期限制*/
	private Long queryApiPeriodTimeLimit;
	
	public String getQueryKey() {
		return queryKey;
	}
	public void setQueryKey(String queryKey) {
		this.queryKey = queryKey;
	}
	public String getQueryKeyMD5() {
		return queryKeyMD5;
	}
	public void setQueryKeyMD5(String queryKeyMD5) {
		this.queryKeyMD5 = queryKeyMD5;
	}
	public Date getLastQueryTime() {
		return lastQueryTime;
	}
	public void setLastQueryTime(Date lastQueryTime) {
		this.lastQueryTime = lastQueryTime;
	}
	public Date getLastQueryApiTime() {
		return lastQueryApiTime;
	}
	public void setLastQueryApiTime(Date lastQueryApiTime) {
		this.lastQueryApiTime = lastQueryApiTime;
	}
	public Long getAccCount() {
		return accCount;
	}
	public void setAccCount(Long accCount) {
		this.accCount = accCount;
	}
	public Long getQueryApiCountLimit() {
		return queryApiCountLimit;
	}
	public void setQueryApiCountLimit(Long queryApiCountLimit) {
		this.queryApiCountLimit = queryApiCountLimit;
	}
	public String getCacheKey() {
		return cacheKey;
	}
	public void setCacheKey(String cacheKey) {
		this.cacheKey = cacheKey;
	}
	public Date getQueryApiTimeLimit() {
		return queryApiTimeLimit;
	}
	public void setQueryApiTimeLimit(Date queryApiTimeLimit) {
		this.queryApiTimeLimit = queryApiTimeLimit;
	}
	public Long getApiCount() {
		return apiCount;
	}
	public void setApiCount(Long apiCount) {
		this.apiCount = apiCount;
	}
	
	public Long getQueryApiPeriodTimeLimit() {
		return queryApiPeriodTimeLimit;
	}
	public void setQueryApiPeriodTimeLimit(Long queryApiPeriodTimeLimit) {
		this.queryApiPeriodTimeLimit = queryApiPeriodTimeLimit;
	}
	public void copyFromRequest(ApiCacheConfigRequest request){
		this.setId(request.getId());
		this.setQueryApiCountLimit(request.getQueryApiCountLimit());
		this.setQueryApiPeriodTimeLimit(request.getQueryApiPeriodTimeLimit());
		
		this.setAccCount(request.getAccCount());
		this.setApiCount(request.getApiCount());
		this.setCacheKey(request.getCacheKey());
		this.setQueryKey(request.getQueryKey());
		this.setLastQueryApiTime(request.getLastQueryApiTime());
		this.setLastQueryTime(request.getLastQueryTime());
		this.setQueryApiTimeLimit(DateUtils.parseCnHmDate(request.getQueryApiTimeLimit()));
	}
	
}
