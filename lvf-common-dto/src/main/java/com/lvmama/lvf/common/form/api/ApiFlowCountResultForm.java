package com.lvmama.lvf.common.form.api;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.api.ApiFlowCountDto;
import com.lvmama.lvf.common.dto.enums.InterfaceKey;
import com.lvmama.lvf.common.form.Form;


public class ApiFlowCountResultForm implements Serializable, Form {
	
	private static final long serialVersionUID = 960191370658049132L;
	
	private ApiFlowCountDto apiFlowCountDto;
	
	private String interfaceKeyCnName;
	
		
	public ApiFlowCountResultForm(ApiFlowCountDto apiFlowCountDto) {
		super();
		this.apiFlowCountDto = apiFlowCountDto;
	}

	public InterfaceKey getInterfaceKey() {
		return apiFlowCountDto.getInterfaceKey();
	}

	public void setInterfaceKey(InterfaceKey interfaceKey) {
		apiFlowCountDto.setInterfaceKey(interfaceKey);
	}

	public Integer getCount() {
		return apiFlowCountDto.getCount();
	}

	public void setCount(Integer count) {
		apiFlowCountDto.setCount(count);
	}
	public String getInterfaceKeyCnName() {
		return apiFlowCountDto.getInterfaceKey().getCnName();
	}

	public void setInterfaceKeyCnName(String interfaceKeyCnName) {
		this.interfaceKeyCnName = interfaceKeyCnName;
	}

	public String getStartTime() {
		return apiFlowCountDto.getStartTime();
	}

	public void setStartTime(String startTime) {
		apiFlowCountDto.setStartTime(startTime);
	}

	public String getEndTime() {
		return apiFlowCountDto.getEndTime();
	}

	public void setEndTime(String endTime) {
		apiFlowCountDto.setEndTime(endTime);
	}

	public Long getId() {
		return apiFlowCountDto.getId();
	}
	
	public void setResult(String result) {
		apiFlowCountDto.setResult(result);
	}
	
	public String getResult() {
		return apiFlowCountDto.getResult();
	}

	public Long getSuccCount() {
		return apiFlowCountDto.getSuccCount();
	}

	public void setSuccCount(Long succCount) {
		apiFlowCountDto.setSuccCount(succCount);
	}

	public Long getFailCount() {
		return apiFlowCountDto.getFailCount();
	}

	public void setFailCount(Long failCount) {
		apiFlowCountDto.setFailCount(failCount);;
	}

	public Long getTotal() {
		return apiFlowCountDto.getTotal();
	}

	public void setTotal(Long total) {
		apiFlowCountDto.setTotal(total);;
	}

	public BigDecimal getFailRate() {
		return apiFlowCountDto.getFailRate();
	}

	public void setFailRate(BigDecimal failRate) {
		apiFlowCountDto.setFailRate(failRate);;
	}
	
	public String getSearchTime() {
		return apiFlowCountDto.getSearchTime();
	}

	public void setSearchTime(String searchTime) {
		apiFlowCountDto.setSearchTime(searchTime);
	}
	
	public ApiFlowCountDto getApiFlowCountDto() {
		return apiFlowCountDto;
	}

	public void setApiFlowCountDto(ApiFlowCountDto apiFlowCountDto) {
		this.apiFlowCountDto = apiFlowCountDto;
	}
}
