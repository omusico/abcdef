package com.lvmama.lvfit.common.dto.insurance;

import java.io.Serializable;
import java.math.BigDecimal;

import com.lvmama.lvf.common.dto.Entity;
import com.lvmama.lvf.common.dto.enums.DefaultRule;
import com.lvmama.lvf.common.dto.enums.InsuranceType;
import com.lvmama.lvfit.common.dto.enums.DefaultSupp;
import com.lvmama.lvfit.common.dto.enums.Status;
import com.lvmama.lvfit.common.dto.enums.SystemApi;
import com.lvmama.lvfit.common.dto.md.InsuranceClass;
import com.lvmama.lvfit.common.dto.supp.Supp;

/**
 * 
 * 保险供应商信息
 *
 */
public class InsuranceInfoDto extends Entity implements Serializable {

	private static final long serialVersionUID = 8001956082502680475L;
	
	/**保险种类*/
	private InsuranceClass insuranceClass;
	
	/**保险价格*/
	private BigDecimal insurancePrice;
	
	/**理赔信息描述*/
	private String insuranceDesc;
	
	/**投保限制*/
	private String insuranceLimit;
	
	/**供应商*/
	private Supp supp;
	
	/**是否系统对接*/
	private SystemApi systemApi;
	
	/**是否默认保险供应商*/
	private DefaultSupp defaultSupp;
	
	/**保险起订份数*/
	private Integer minInsureNum = 1;
	
	/**保险最大可预订份数*/
	private Integer maxInsureNum = 99;
	
	/**结算价*/
	private BigDecimal settleAccounts;
	
	/**产品状态*/
	private Status status;
    
	/**适用产品类型*/
    private String productTypes;
    
    /**保险类型*/
    private InsuranceType insuranceType;
    
    /**保险简介*/
    private String insuranceRemark;
    
    /** 保险成本价*/
    private BigDecimal costPrice;
    
    /** 是否默认产品*/
    private DefaultRule defaultRule;
    
	
	public InsuranceClass getInsuranceClass() {
		return insuranceClass;
	}

	public void setInsuranceClass(InsuranceClass insuranceClass) {
		this.insuranceClass = insuranceClass;
	}

	public String getInsuranceLimit() {
		return insuranceLimit;
	}

	public void setInsuranceLimit(String insuranceLimit) {
		this.insuranceLimit = insuranceLimit;
	}

	public Supp getSupp() {
		return supp;
	}

	public void setSupp(Supp supp) {
		this.supp = supp;
	}


	public BigDecimal getInsurancePrice() {
		return insurancePrice;
	}

	public void setInsurancePrice(BigDecimal insurancePrice) {
		this.insurancePrice = insurancePrice;
	}

	public Integer getMinInsureNum() {
		return minInsureNum;
	}

	public void setMinInsureNum(Integer minInsureNum) {
		this.minInsureNum = minInsureNum;
	}

	public Integer getMaxInsureNum() {
		return maxInsureNum;
	}

	public void setMaxInsureNum(Integer maxInsureNum) {
		this.maxInsureNum = maxInsureNum;
	}

	public String getInsuranceDesc() {
		return insuranceDesc;
	}

	public void setInsuranceDesc(String insuranceDesc) {
		this.insuranceDesc = insuranceDesc;
	}

	public SystemApi getSystemApi() {
		return systemApi;
	}

	public void setSystemApi(SystemApi systemApi) {
		this.systemApi = systemApi;
	}

	public DefaultSupp getDefaultSupp() {
		return defaultSupp;
	}

	public void setDefaultSupp(DefaultSupp defaultSupp) {
		this.defaultSupp = defaultSupp;
	}

	public BigDecimal getSettleAccounts() {
		return settleAccounts;
	}

	public void setSettleAccounts(BigDecimal settleAccounts) {
		this.settleAccounts = settleAccounts;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

    public String getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(String productTypes) {
        this.productTypes = productTypes;
    }

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(InsuranceType insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getInsuranceRemark() {
        return insuranceRemark;
    }

    public void setInsuranceRemark(String insuranceRemark) {
        this.insuranceRemark = insuranceRemark;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public DefaultRule getDefaultRule() {
        return defaultRule;
    }

    public void setDefaultRule(DefaultRule defaultRule) {
        this.defaultRule = defaultRule;
    }

}
