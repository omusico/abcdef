package com.lvmama.lvf.common.dto.adapter.request.supp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.adapter.request.supp.base.SuppRequest;
import com.lvmama.lvf.common.dto.enums.SuppSaleType;
import com.lvmama.lvf.common.dto.request.FlightQueryRequest;

/**
 * @author mashengwen
 * AV3 AV4 PQ1 PQ2 PQ5 RC6 PQ3 PQ7
 */

@XmlRootElement
public class FlightSuppFlightQueryRequest extends SuppRequest implements Serializable 
{
	/** serialVersionUID */
	private static final long serialVersionUID = -3631603742717114422L;
	
	/** 分页信息 */
	private Pagination pagination;
	
	/** 航班查询信息 */
	private FlightQueryRequest flightQueryRequest;
	
	/** 是否需要本地政策 */
	private String needLocalPolicy;
	
	/** 是否包括特殊政策 */
	private String needSpeRulePolicy;
	
	/** 是否包括特价政策 */
	private String needSpePricePolicy;
	
	/** 是否只返回在工作时间内政策 */
	private String onlyOnWorking;
	
	/**是否只返回可用舱位 */
	private String onlyAvailableSeat;
	
	/** 是是否可更换PNR出票(PQ5):0、只用自己的PNR出票、1可以更换PNR后出票*/
	private String allowSwitchPnr;
	
	/** 最后更新时间 */
	private Date lastUpdateTime;
	
	/** 最后更新政策ID */
	private String lastUpdatePolicyId;
	
	/** 是否可更换PNR出票(AV3)：0可以更换PNR后出票 1、只用自己的PNR出票 */
	private String onlySelfPNR;
	
	/** 政策销售类型 */
	private List<SuppSaleType> saleTypes;
	
	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public FlightQueryRequest getFlightQueryRequest() {
		return flightQueryRequest;
	}

	public void setFlightQueryRequest(FlightQueryRequest flightQueryRequest) {
		this.flightQueryRequest = flightQueryRequest;
	}

	public String getNeedLocalPolicy() {
		return needLocalPolicy;
	}

	public void setNeedLocalPolicy(String needLocalPolicy) {
		this.needLocalPolicy = needLocalPolicy;
	}

	public String getNeedSpeRulePolicy() {
		return needSpeRulePolicy;
	}

	public void setNeedSpeRulePolicy(String needSpeRulePolicy) {
		this.needSpeRulePolicy = needSpeRulePolicy;
	}

	public String getNeedSpePricePolicy() {
		return needSpePricePolicy;
	}

	public void setNeedSpePricePolicy(String needSpePricePolicy) {
		this.needSpePricePolicy = needSpePricePolicy;
	}

	public String getOnlyOnWorking() {
		return onlyOnWorking;
	}

	public void setOnlyOnWorking(String onlyOnWorking) {
		this.onlyOnWorking = onlyOnWorking;
	}
	
	public String getOnlyAvailableSeat() {
		return onlyAvailableSeat;
	}

	public void setOnlyAvailableSeat(String onlyAvailableSeat) {
		this.onlyAvailableSeat = onlyAvailableSeat;
	}

	public String getAllowSwitchPnr() {
		return allowSwitchPnr;
	}

	public void setAllowSwitchPnr(String allowSwitchPnr) {
		this.allowSwitchPnr = allowSwitchPnr;
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

	public String getOnlySelfPNR() {
		return onlySelfPNR;
	}

	public void setOnlySelfPNR(String onlySelfPNR) {
		this.onlySelfPNR = onlySelfPNR;
	}

	public List<SuppSaleType> getSaleTypes() {
		return saleTypes;
	}

	public void setSaleTypes(List<SuppSaleType> saleTypes) {
		this.saleTypes = saleTypes;
	}
}
