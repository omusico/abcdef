package com.lvmama.lvf.common.dto.sales;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.OpLog;
import com.lvmama.lvf.common.dto.enums.Status;

/**
 * @Title: SalesRuleDisableDto.java
 * @Package com.lvmama.lvf.common.dto.sales
 * @Description: 禁售规则DTO
 * @author Chase_lv
 * @date 2015年8月5日 下午5:28:49
 */
public class SalesRuleDisableDto extends AEEntity implements Serializable {

	private static final long serialVersionUID = 7732805921335447590L;

	/** 航空公司二字码 */
	private String carrierCode;

	/** 提前起售时间 1-48小时 */
	private Long leadTime;

	/** 优先级0-9 */
	private Long priority;

	/** 出发城市三字码 */
	private String departureCityCode;
 
	/** 到达城市三字码 */
	private String arriveCityCode;

	/** 是否有效,默认无效*/
	private Status status;

	/** 航班号 */
	private String flightNo;

	/** 备注 */
	private String remark;

	/** 操作日志 */
	private List<OpLog> opLogs = new ArrayList<OpLog>();

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public String getDepartureCityCode() {
		return departureCityCode;
	}

	public void setDepartureCityCode(String departureCityCode) {
		this.departureCityCode = departureCityCode;
	}

	public String getArriveCityCode() {
		return arriveCityCode;
	}

	public void setArriveCityCode(String arriveCityCode) {
		this.arriveCityCode = arriveCityCode;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<OpLog> getOpLogs() {
		return opLogs;
	}

	public void setOpLogs(List<OpLog> opLogs) {
		this.opLogs = opLogs;
	}

	public Long getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(Long leadTime) {
		this.leadTime = leadTime;
	}

}
