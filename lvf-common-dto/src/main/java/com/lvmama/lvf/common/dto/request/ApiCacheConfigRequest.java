package com.lvmama.lvf.common.dto.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.Dto;

public class ApiCacheConfigRequest implements Serializable, Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5183979307319512370L;
	/** 请求修改入库id */
	private Long id;
	/** 起始日期 */
    private String startTime;
    /** 截至日期 */
	private String endTime;

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
	private String queryApiTimeLimit;
	/**cacheKey的值*/
	private String cacheKey;
	/**查询Api有效期限制*/
	private Long queryApiPeriodTimeLimit;
	
	private List<Long> apiCacheList;
	
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Long getQueryApiPeriodTimeLimit() {
		return queryApiPeriodTimeLimit;
	}

	public void setQueryApiPeriodTimeLimit(Long queryApiPeriodTimeLimit) {
		this.queryApiPeriodTimeLimit = queryApiPeriodTimeLimit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCacheKey() {
		return cacheKey;
	}

	public void setCacheKey(String cacheKey) {
		this.cacheKey = cacheKey;
	}

	public Long getQueryApiCountLimit() {
		return queryApiCountLimit;
	}

	public void setQueryApiCountLimit(Long queryApiCountLimit) {
		this.queryApiCountLimit = queryApiCountLimit;
	}

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

	public Long getApiCount() {
		return apiCount;
	}

	public void setApiCount(Long apiCount) {
		this.apiCount = apiCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getQueryApiTimeLimit() {
		return queryApiTimeLimit;
	}

	public void setQueryApiTimeLimit(String queryApiTimeLimit) {
		this.queryApiTimeLimit = queryApiTimeLimit;
	}

	public List<Long> getApiCacheList() {
		return apiCacheList;
	}

	public void setApiCacheList(List<Long> apiCacheList) {
		this.apiCacheList = apiCacheList;
	}

}
