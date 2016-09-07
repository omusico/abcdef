package com.lvmama.lvf.common.dto.policy;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.PolicyBelongTo;
import com.lvmama.lvf.common.dto.enums.PolicyModifyType;
import com.lvmama.lvf.common.dto.enums.PolicyStatus;
import com.lvmama.lvf.common.dto.enums.PolicyWorkType;
import com.lvmama.lvf.common.dto.md.FlightOfficeDto;
import com.lvmama.lvf.common.dto.md.TimeRange;
import com.lvmama.lvf.common.dto.supp.Supp;

/**
 * 供应商政策基本信息
 * 
 * @author majun
 * @date 2015-1-13
 */
@XmlRootElement
public class FlightPolicySuppDto extends AEEntity implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -4545230987456768953L;

    /** 政策Id */
    private Long policyId;

    /** 供应商基本信息 */
    private Supp supp;

    /** 供应商的政策ID编号 */
    private String suppPolicyNo;

    /** 供应商的Office信息 */
    private FlightOfficeDto suppOffice;

    /** 供应商工作时间 */
    private TimeRange workTime;

    /** 废票时间 */
    private TimeRange vtWorkTime;

    /** 供应商当前是否在工作时间 */
    private PolicyWorkType policyWorkType;

    /** 出票效率 */
    private String ticketSpeed;

    /** 政策状态枚举 */
    private PolicyStatus suppPolicyStatus;

    /** 政策归属 */
    private PolicyBelongTo policyBelongTo;

    /** 修改标志枚举 */
    private PolicyModifyType suppPolicyModifyFlag;

    /** 政策修改时间 */
    private Date suppModifyTime;
    
    /** 供应商销售类型（目前针对携程） */
    private String suppSaleType;
    
    /** 传入指定查询返回唯一Productid（目前针对携程） */
    private String suppPid;

    public Supp getSupp() {
        return supp;
    }

    public void setSupp(Supp supp) {
        this.supp = supp;
    }

    public TimeRange getWorkTime() {
        return workTime;
    }

    public void setWorkTime(TimeRange workTime) {
        this.workTime = workTime;
    }

    public TimeRange getVtWorkTime() {
        return vtWorkTime;
    }

    public void setVtWorkTime(TimeRange vtWorkTime) {
        this.vtWorkTime = vtWorkTime;
    }

    public String getTicketSpeed() {
        return ticketSpeed;
    }

    public void setTicketSpeed(String ticketSpeed) {
        this.ticketSpeed = ticketSpeed;
    }

    public PolicyStatus getSuppPolicyStatus() {
        return suppPolicyStatus;
    }

    public void setSuppPolicyStatus(PolicyStatus suppPolicyStatus) {
        this.suppPolicyStatus = suppPolicyStatus;
    }

    public FlightOfficeDto getSuppOffice() {
        return suppOffice;
    }

    public void setSuppOffice(FlightOfficeDto suppOffice) {
        this.suppOffice = suppOffice;
    }

    public PolicyBelongTo getPolicyBelongTo() {
        return policyBelongTo;
    }

    public void setPolicyBelongTo(PolicyBelongTo policyBelongTo) {
        this.policyBelongTo = policyBelongTo;
    }

    public PolicyModifyType getSuppPolicyModifyFlag() {
        return suppPolicyModifyFlag;
    }

    public void setSuppPolicyModifyFlag(PolicyModifyType suppPolicyModifyFlag) {
        this.suppPolicyModifyFlag = suppPolicyModifyFlag;
    }

    public Date getSuppModifyTime() {
        return suppModifyTime;
    }

    public void setSuppModifyTime(Date suppModifyTime) {
        this.suppModifyTime = suppModifyTime;
    }

    public String getSuppPolicyNo() {
        return suppPolicyNo;
    }

    public void setSuppPolicyNo(String suppPolicyNo) {
        this.suppPolicyNo = suppPolicyNo;
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public PolicyWorkType getPolicyWorkType() {
        return policyWorkType;
    }

    public void setPolicyWorkType(PolicyWorkType policyWorkType) {
        this.policyWorkType = policyWorkType;
    }

	public String getSuppSaleType() {
		return suppSaleType;
	}

	public void setSuppSaleType(String suppSaleType) {
		this.suppSaleType = suppSaleType;
	}
	
    @Override
    @JsonIgnore
    public String getSequence() {
        return "S_FFLI_POLICY_SUPP";
    }

	public String getSuppPid() {
		return suppPid;
	}

	public void setSuppPid(String suppPid) {
		this.suppPid = suppPid;
	}

}
