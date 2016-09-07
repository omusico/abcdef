package com.lvmama.lvfit.common.dto.sdp.product;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvfit.common.dto.enums.SortRuleType;
import com.lvmama.lvfit.common.dto.enums.TrafficTripeType;

public class FitSdpProductTrafficRulesDto extends Entity {

	private static final long serialVersionUID = -8805145561024400018L;
	
	/**自主打包产品Id */
	private Long productId;
	
	/** 行程第*天 */
	private Integer routeDayNum;
	
	/**排序规则 */
	private SortRuleType sortRuleType;

	/**出发开始时间 */
	private String depBegTime;
	
	/**出发结束时间 */
	private String depEndTime;
	
	/**到达开始时间 */
	private String arrBegTime;
	
	/**到达开始时间 */
	private String arrEndTime;
	
	/**交通行程类型 */
    private TrafficTripeType trafficTripeType;
    
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getRouteDayNum() {
		return routeDayNum;
	}

	public void setRouteDayNum(Integer routeDayNum) {
		this.routeDayNum = routeDayNum;
	}

	public SortRuleType getSortRuleType() {
		return sortRuleType;
	}

	public void setSortRuleType(SortRuleType sortRuleType) {
		this.sortRuleType = sortRuleType;
	}

	public String getDepBegTime() {
		return depBegTime;
	}

	public void setDepBegTime(String depBegTime) {
		this.depBegTime = depBegTime;
	}

	public String getDepEndTime() {
		return depEndTime;
	}

	public void setDepEndTime(String depEndTime) {
		this.depEndTime = depEndTime;
	}

	public String getArrBegTime() {
		return arrBegTime;
	}

	public void setArrBegTime(String arrBegTime) {
		this.arrBegTime = arrBegTime;
	}

	public String getArrEndTime() {
		return arrEndTime;
	}

	public void setArrEndTime(String arrEndTime) {
		this.arrEndTime = arrEndTime;
	}

	public TrafficTripeType getTrafficTripeType() {
		return trafficTripeType;
	}

	public void setTrafficTripeType(TrafficTripeType trafficTripeType) {
		this.trafficTripeType = trafficTripeType;
	}
	
	
	
}
