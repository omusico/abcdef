package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.domain.FkId;
import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.AutoPrintTicket;
import com.lvmama.lvf.common.dto.enums.FlightTicketType;
import com.lvmama.lvf.common.dto.enums.NeedAuth;
import com.lvmama.lvf.common.dto.enums.NeedSwitchPNR;
import com.lvmama.lvf.common.dto.enums.PolicyType;
import com.lvmama.lvf.common.dto.flight.price.FlightPricePolicyDto;
import com.lvmama.lvf.common.dto.md.FlightOfficeDto;
import com.lvmama.lvf.common.dto.policy.FlightPolicyDto;
import com.lvmama.lvf.common.dto.policy.FlightPolicyProfitRuleDto;
import com.lvmama.lvf.common.dto.policy.FlightPolicyRemarkDto;
import com.lvmama.lvf.common.dto.supp.Supp;

/**
 * 订单政策信息
 * @author majun
 * @date   2015-1-13
 */
@XmlRootElement
public class FlightOrderFlightPolicyDto extends Entity implements Serializable 
{
	private static final long serialVersionUID = 6201740402463173176L;
	
	/** 航班政策信息 */
	@FkId
	private FlightPolicyDto flightPolicy;
	
	/** 订单航班组合明细主键*/
	private Long combinationDetailId;

	/** 供应商信息 */
	@FkId
	private Supp supp;
	
	/** 供应商政策编号 */
	private String suppPolicyNo;
	
	/** 政策类型 */
	private PolicyType policyType;
	
	/** 机票采购类型 */
	private List<FlightTicketType> flightTicketTypes;
	
	/** 机票采购类型(对应数据库字段) */
	private String flightTicketType;
	
	/** 是否更换PNR出票 */
	private NeedSwitchPNR needSwitchPNR;
	
	/** 编码是否需要授权 */
	private NeedAuth needAuth;
	
	/** 出票类型 */
	private AutoPrintTicket autoPrintTicket;
	
	/** 出票OFFICE信息 */
	private FlightOfficeDto flightOffice;
	
	/** 政策利润规则 */
	private FlightPolicyProfitRuleDto flightPolicyProfitRule;
	
	/** 政策备注 */
	private FlightPolicyRemarkDto flightPolicyRemark;
	
	/** 销售类型 */
	private  String saleType;
	
	/** 销售类型 */
	private  String pid;
	
    /** 航班运价政策信息 */
	@FkId
    private FlightPricePolicyDto flightPricePolicy;
	
	/** 政策来源  */
	private String policySource; //用于包机切位政策
    
	public FlightPolicyDto getFlightPolicy() {
		return flightPolicy;
	}

	public void setFlightPolicy(FlightPolicyDto flightPolicy) {
		this.flightPolicy = flightPolicy;
	}

	public Long getCombinationDetailId() {
		return combinationDetailId;
	}

	public void setCombinationDetailId(Long combinationDetailId) {
		this.combinationDetailId = combinationDetailId;
	}

	public Supp getSupp() {
		return supp;
	}

	public void setSupp(Supp supp) {
		this.supp = supp;
	}

	public String getSuppPolicyNo() {
		return suppPolicyNo;
	}

	public void setSuppPolicyNo(String suppPolicyNo) {
		this.suppPolicyNo = suppPolicyNo;
	}

	public PolicyType getPolicyType() {
		return policyType;
	}

	public void setPolicyType(PolicyType policyType) {
		this.policyType = policyType;
	}

	public List<FlightTicketType> getFlightTicketTypes() {
		return flightTicketTypes;
	}

	public void setFlightTicketTypes(List<FlightTicketType> flightTicketTypes) {
		this.flightTicketTypes = flightTicketTypes;
	}

	public String getFlightTicketType() {
		return flightTicketType;
	}

	public void setFlightTicketType(String flightTicketType) {
		this.flightTicketType = flightTicketType;
	}

	public NeedSwitchPNR getNeedSwitchPNR() {
		return needSwitchPNR;
	}

	public void setNeedSwitchPNR(NeedSwitchPNR needSwitchPNR) {
		this.needSwitchPNR = needSwitchPNR;
	}

	public NeedAuth getNeedAuth() {
		return needAuth;
	}

	public void setNeedAuth(NeedAuth needAuth) {
		this.needAuth = needAuth;
	}

	public AutoPrintTicket getAutoPrintTicket() {
		return autoPrintTicket;
	}

	public void setAutoPrintTicket(AutoPrintTicket autoPrintTicket) {
		this.autoPrintTicket = autoPrintTicket;
	}

	public FlightOfficeDto getFlightOffice() {
		return flightOffice;
	}

	public void setFlightOffice(FlightOfficeDto flightOffice) {
		this.flightOffice = flightOffice;
	}

	public FlightPolicyProfitRuleDto getFlightPolicyProfitRule() {
		return flightPolicyProfitRule;
	}

	public void setFlightPolicyProfitRule(
			FlightPolicyProfitRuleDto flightPolicyProfitRule) {
		this.flightPolicyProfitRule = flightPolicyProfitRule;
	}

	public FlightPolicyRemarkDto getFlightPolicyRemark() {
		return flightPolicyRemark;
	}

	public void setFlightPolicyRemark(FlightPolicyRemarkDto flightPolicyRemark) {
		this.flightPolicyRemark = flightPolicyRemark;
	}
	
	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
	
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
	
	public FlightPricePolicyDto getFlightPricePolicy() {
        return flightPricePolicy;
    }

    public void setFlightPricePolicy(FlightPricePolicyDto flightPricePolicy) {
        this.flightPricePolicy = flightPricePolicy;
    }

    @Override
	@JsonIgnore
	public String getSequence() {
		return "S_FORD_FLIGHT_POLICY";
	}

	public String getPolicySource() {
		return policySource;
	}

	public void setPolicySource(String policySource) {
		this.policySource = policySource;
	}

}
