package com.lvmama.lvf.common.dto.order;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.lvmama.lvf.common.dto.Entity;

/**
 * 订单合同信息
 * @author majun
 * @date   2015-1-19
 */
public class FlightOrderAgreementDto extends Entity implements Serializable 
{	
	private static final long serialVersionUID = -3862118458422540878L;
	
	/** 主订单主键 */
	private Long orderMainId;
	
	/** 合同名称 */
	private String contractName;

	public Long getOrderMainId() {
		return orderMainId;
	}

	public void setOrderMainId(Long orderMainId) {
		this.orderMainId = orderMainId;
	}

	/**
	 * @return the contractName
	 */
	public String getContractName() {
		return contractName;
	}

	/**
	 * @param contractName the contractName to set
	 */
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

    @Override
    @JsonIgnore
    public String getSequence() {
    	return super.getSequence();
    }
}
