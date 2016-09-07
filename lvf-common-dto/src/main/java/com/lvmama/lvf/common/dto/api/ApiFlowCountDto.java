package com.lvmama.lvf.common.dto.api;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.enums.InterfaceKey;
import com.lvmama.lvf.common.dto.request.ApiFlowQueryRequest;

public class ApiFlowCountDto  implements Serializable,Dto{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4210658484543844467L;

	/**接口名*/
	private InterfaceKey interfaceKey;
	
	private Integer count;
	
	private String startTime;
	
	private String endTime;
	
	private String searchTime;
	
	private String result;
	/**调用成功的数量*/
	private Long succCount;
	/**调用失败的数量*/
	private Long failCount;
	/**调用总数量*/
	private Long total;
	/**失败率*/
	private BigDecimal failRate;

	public InterfaceKey getInterfaceKey() {
		return interfaceKey;
	}

	public void setInterfaceKey(InterfaceKey interfaceKey) {
		this.interfaceKey = interfaceKey;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	

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

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Long getSuccCount() {
		return succCount;
	}

	public void setSuccCount(Long succCount) {
		this.succCount = succCount;
	}

	public Long getFailCount() {
		return failCount;
	}

	public void setFailCount(Long failCount) {
		this.failCount = failCount;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getSearchTime() {
		return searchTime;
	}

	public void setSearchTime(String searchTime) {
		this.searchTime = searchTime;
	}

	public BigDecimal getFailRate() {
		if(null!=this.getFailCount()&&null!=this.getTotal()&&this.getTotal()!=0){
			return BigDecimal.valueOf(this.getFailCount()).divide(BigDecimal.valueOf(this.getTotal()), 2, BigDecimal.ROUND_HALF_UP);
		}else{
			return BigDecimal.ZERO;
		}
	}

	public void setFailRate(BigDecimal failRate) {
		this.failRate=failRate;
	}
	
	/***
	 * 构造流量统计Dto字符串
	 */
	public String constructApiFlowCountStr(ApiFlowQueryRequest apiFlowQueryRequest){
		StringBuffer apiFlowCountStr = new StringBuffer();
		/**调用日期*/
		if(apiFlowQueryRequest!=null){
			if(apiFlowQueryRequest.getQueryByDay()){
				apiFlowCountStr.append("\t"+this.getSearchTime()).append(",");
			}else{
				apiFlowCountStr.append(apiFlowQueryRequest.getStartTime().substring(0, 10) + "~~" + apiFlowQueryRequest.getEndTime().substring(0, 10)).append(",");
			}
		}
		/**调用次数*/
		apiFlowCountStr.append("\t"+this.getTotal()).append(",");
		/**接口*/
		apiFlowCountStr.append(this.getInterfaceKey().getCnName()).append(",");
		/**成功次数*/
		apiFlowCountStr.append("\t"+this.getSuccCount()).append(",");
		/**失败次数*/
		apiFlowCountStr.append("\t"+this.getFailCount()).append(",");
		/**失败率*/
		if(this.getFailRate()!=null){
			apiFlowCountStr.append("\t"+new java.text.DecimalFormat("#").format(this.getFailRate().doubleValue()*100)+"%").append(",");
		}
		return apiFlowCountStr.toString().replaceAll("null", "");
	}
	
}



