package com.lvmama.lvf.common.form.api;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.request.ApiCacheConfigRequest;
import com.lvmama.lvf.common.form.Form;
/**
 * Api的缓存配置Form
 * @author zzs
 *
 */
public class ApiCacheConfigForm implements Serializable, Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7220451383636738670L;
	
	private ApiCacheConfigRequest apiCacheConfigRequest= new ApiCacheConfigRequest();
	    
	private Pagination pagination = new Pagination();

	public ApiCacheConfigRequest getApiCacheConfigRequest() {
		return apiCacheConfigRequest;
	}

	public void setApiCacheConfigRequest(ApiCacheConfigRequest apiCacheConfigRequest) {
		this.apiCacheConfigRequest = apiCacheConfigRequest;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public String getStartTime() {
		return apiCacheConfigRequest.getStartTime();
	}

	public void setStartTime(String startTime) {
		apiCacheConfigRequest.setStartTime(startTime);
	}

	public String getEndTime() {
		return apiCacheConfigRequest.getEndTime();
	}

	public void setEndTime(String endTime) {
		apiCacheConfigRequest.setEndTime(endTime);
	}

	public Long getId() {
		return apiCacheConfigRequest.getId();
	}

	public int getPage() {
		return pagination.getPage();
	}

	public void setPage(int page) {
		pagination.setPage(page);
	}

	public int getRows() {
		return pagination.getRows();
	}

	public void setRows(int rows) {
		pagination.setRows(rows);
	}

	public void setRowsByCustom(int customRows) {
		pagination.setRowsByCustom(customRows);
	}

	public int getRecords() {
		return pagination.getRecords();
	}

	public void setRecords(int records) {
		pagination.setRecords(records);
	}

	public void countRecords(int records) {
		pagination.countRecords(records);
	}

	public int getTotal() {
		return pagination.getTotal();
	}

	public void setTotal(int total) {
		pagination.setTotal(total);
	}

	public String getSidx() {
		return pagination.getSidx();
	}

	public void setSidx(String sidx) {
		pagination.setSidx(sidx);
	}

	public String getSord() {
		return pagination.getSord();
	}

	public void setSord(String sord) {
		pagination.setSord(sord);
	}

	public int getStartRow() {
		return pagination.getStartRow();
	}

	public int getEndRow() {
		return pagination.getEndRow();
	}

	public boolean isSearch() {
		return pagination.isSearch();
	}

	public void setSearch(boolean search) {
		pagination.setSearch(search);
	}
	
	public Long getQueryApiPeriodTimeLimit() {
		return apiCacheConfigRequest.getQueryApiPeriodTimeLimit();
	}

	public void setQueryApiPeriodTimeLimit(Long queryApiPeriodTimeLimit) {
		apiCacheConfigRequest.setQueryApiPeriodTimeLimit(queryApiPeriodTimeLimit);
	}

	public void setId(Long id) {
		apiCacheConfigRequest.setId(id);
	}

	public String getCacheKey() {
		return apiCacheConfigRequest.getCacheKey();
	}

	public void setCacheKey(String cacheKey) {
		apiCacheConfigRequest.setCacheKey(cacheKey);
	}

	public Long getQueryApiCountLimit() {
		return apiCacheConfigRequest.getQueryApiCountLimit();
	}

	public void setQueryApiCountLimit(Long queryApiCountLimit) {
		apiCacheConfigRequest.setQueryApiCountLimit(queryApiCountLimit);
	}

	public String getQueryKey() {
		return apiCacheConfigRequest.getQueryKey();
	}

	public void setQueryKey(String queryKey) {
		apiCacheConfigRequest.setQueryKey(queryKey);
	}

	public String getQueryKeyMD5() {
		return apiCacheConfigRequest.getQueryKeyMD5();
	}

	public void setQueryKeyMD5(String queryKeyMD5) {
		apiCacheConfigRequest.setQueryKeyMD5(queryKeyMD5);
	}

	public Date getLastQueryTime() {
		return apiCacheConfigRequest.getLastQueryTime();
	}

	public void setLastQueryTime(Date lastQueryTime) {
		apiCacheConfigRequest.setLastQueryTime(lastQueryTime);
	}

	public Date getLastQueryApiTime() {
		return apiCacheConfigRequest.getLastQueryApiTime();
	}

	public void setLastQueryApiTime(Date lastQueryApiTime) {
		apiCacheConfigRequest.setLastQueryApiTime(lastQueryApiTime);
	}

	public Long getAccCount() {
		return apiCacheConfigRequest.getAccCount();
	}

	public void setAccCount(Long accCount) {
		apiCacheConfigRequest.setAccCount(accCount);
	}

	public Long getApiCount() {
		return apiCacheConfigRequest.getApiCount();
	}

	public void setApiCount(Long apiCount) {
		apiCacheConfigRequest.setApiCount(apiCount);
	}

	public String getQueryApiTimeLimit() {
		return apiCacheConfigRequest.getQueryApiTimeLimit();
	}

	public void setQueryApiTimeLimit(String queryApiTimeLimit) {
		apiCacheConfigRequest.setQueryApiTimeLimit(queryApiTimeLimit);
	}

	public List<Long> getApiCacheList() {
		return apiCacheConfigRequest.getApiCacheList();
	}

	public void setApiCacheList(List<Long> apiCacheList) {
		apiCacheConfigRequest.setApiCacheList(apiCacheList);
	}


}
