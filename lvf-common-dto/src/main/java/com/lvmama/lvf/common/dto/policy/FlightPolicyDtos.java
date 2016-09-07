package com.lvmama.lvf.common.dto.policy;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.Pagination;

/**
 * 机票政策基本信息Info
 * 
 * @author yuanweihong
 * @date 2015-1-14
 */
@XmlRootElement
public class FlightPolicyDtos implements Serializable {

	private static final long serialVersionUID = 8905941849238402840L;

	/** 机票政策基本信息 */
	private List<FlightPolicyDto> flightPolicys;

	/** 最后更新时间 */
	private Date lastUpdateTime;

	/** 同步政策最后更新时间 */
	private String lastUpdatePolicyId;

	/** 分页对象 */
	private Pagination pagination = new Pagination();

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public List<FlightPolicyDto> getFlightPolicys() {
		return flightPolicys;
	}

	public void setFlightPolicys(List<FlightPolicyDto> flightPolicys) {
		this.flightPolicys = flightPolicys;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getLastUpdatePolicyId() {
		return lastUpdatePolicyId;
	}

	public void setLastUpdatePolicyId(String lastUpdatePolicyId) {
		this.lastUpdatePolicyId = lastUpdatePolicyId;
	}

}
