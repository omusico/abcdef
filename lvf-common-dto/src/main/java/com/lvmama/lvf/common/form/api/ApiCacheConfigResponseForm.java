package com.lvmama.lvf.common.form.api;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.api.ApiCacheConfigDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;
/**
 * Api的缓存配置ResponseForm
 * @author zzs
 *
 */
public class ApiCacheConfigResponseForm implements Serializable, Form {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6259556730573934101L;
	
	private ApiCacheConfigDto apiCacheConfig=new  ApiCacheConfigDto();

	public ApiCacheConfigResponseForm() {
	}
	
	public ApiCacheConfigResponseForm(ApiCacheConfigDto apiCacheConfig) {
		this.apiCacheConfig = apiCacheConfig; 
			
	}
	
	public ApiCacheConfigDto getApiCacheConfig() {
		return apiCacheConfig;
	}

	public void setApiCacheConfig(ApiCacheConfigDto apiCacheConfig) {
		this.apiCacheConfig = apiCacheConfig;
	}

	public String getSequence() {
		return apiCacheConfig.getSequence();
	}

	public Long getId() {
		return apiCacheConfig.getId();
	}

	public String getQueryKey() {
		return apiCacheConfig.getQueryKey();
	}

	public void setId(Long id) {
		apiCacheConfig.setId(id);
	}

	public void setQueryKey(String queryKey) {
		apiCacheConfig.setQueryKey(queryKey);
	}

	public String getQueryKeyMD5() {
		return apiCacheConfig.getQueryKeyMD5();
	}

	public String getCreateTime() {
		return DateUtils.formatCnHmDate(apiCacheConfig.getCreateTime());
	}

	public void setQueryKeyMD5(String queryKeyMD5) {
		apiCacheConfig.setQueryKeyMD5(queryKeyMD5);
	}

	public void setCreateTime(Date createTime) {
		apiCacheConfig.setCreateTime(createTime);
	}

	public String getLastQueryTime() {
		return DateUtils.formatCnHmDate(apiCacheConfig.getLastQueryTime());
	}

	public Date getUpdateTime() {
		return apiCacheConfig.getUpdateTime();
	}

	public void setLastQueryTime(Date lastQueryTime) {
		apiCacheConfig.setLastQueryTime(lastQueryTime);
	}

	public void setUpdateTime(Date updateTime) {
		apiCacheConfig.setUpdateTime(updateTime);
	}

	public String getLastQueryApiTime() {
		return DateUtils.formatCnHmDate(apiCacheConfig.getLastQueryApiTime());
	}

	public void setLastQueryApiTime(Date lastQueryApiTime) {
		apiCacheConfig.setLastQueryApiTime(lastQueryApiTime);
	}

	public Long getAccCount() {
		return apiCacheConfig.getAccCount();
	}

	public void setAccCount(Long accCount) {
		apiCacheConfig.setAccCount(accCount);
	}

	public Long getQueryApiCountLimit() {
		return apiCacheConfig.getQueryApiCountLimit();
	}

	public void setQueryApiCountLimit(Long queryApiCountLimit) {
		apiCacheConfig.setQueryApiCountLimit(queryApiCountLimit);
	}

	public String getCacheKey() {
		return apiCacheConfig.getCacheKey();
	}

	public void setCacheKey(String cacheKey) {
		apiCacheConfig.setCacheKey(cacheKey);
	}

	public String getQueryApiTimeLimit() {
		return DateUtils.formatCnHmDate(apiCacheConfig.getQueryApiTimeLimit());
	}

	public void setQueryApiTimeLimit(Date queryApiTimeLimit) {
		apiCacheConfig.setQueryApiTimeLimit(queryApiTimeLimit);
	}

	public Long getApiCount() {
		return apiCacheConfig.getApiCount();
	}

	public void setApiCount(Long apiCount) {
		apiCacheConfig.setApiCount(apiCount);
	}

	public Long getQueryApiPeriodTimeLimit() {
		return apiCacheConfig.getQueryApiPeriodTimeLimit();
	}

	public void setQueryApiPeriodTimeLimit(Long queryApiPeriodTimeLimit) {
		apiCacheConfig.setQueryApiPeriodTimeLimit(queryApiPeriodTimeLimit);
	}

}
