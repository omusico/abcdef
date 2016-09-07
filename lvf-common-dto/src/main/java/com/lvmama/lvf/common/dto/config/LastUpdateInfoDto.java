package com.lvmama.lvf.common.dto.config;

import java.io.Serializable;
import java.util.Date;

import com.lvmama.lvf.common.dto.BusinessType;
import com.lvmama.lvf.common.dto.Entity;

/**
 * 最后更新信息
 * 
 * @author yuanweihong
 * @date 2015-6-15
 */
public class LastUpdateInfoDto extends Entity implements Serializable {

    private static final long serialVersionUID = 5941864647769867202L;

    /** 业务类型 */
	private BusinessType businessType;
	
	/** 业务类型Id */
	private String businessId;
	
	/** 业务编号 */
	private String businessNo;
	
	/** 最后更新时间 */
	private Date lastUpdateTime;

	public BusinessType getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	
	

}
