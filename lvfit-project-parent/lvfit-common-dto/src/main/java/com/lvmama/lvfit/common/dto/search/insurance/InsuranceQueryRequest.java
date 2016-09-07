package com.lvmama.lvfit.common.dto.search.insurance;

import java.io.Serializable;
import java.util.Date;

public class InsuranceQueryRequest  implements Serializable{

	private static final long serialVersionUID = 4009862099543575281L;
	/** 产品ID  **/
	private Long currentProductId;
	/** 渠道ID  **/
	private Long distributorId;
	/** 游玩日期  **/
	private Date vistorDate;
	/** 游玩天数  **/
	private Long insuranceDays;
	
	private Integer personNum;
	
	public final Long getCurrentProductId() {
		return currentProductId;
	}
	public final void setCurrentProductId(Long currentProductId) {
		this.currentProductId = currentProductId;
	}
	public final Long getDistributorId() {
		return distributorId;
	}
	public final void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}
	public final Date getVistorDate() {
		return vistorDate;
	}
	public final void setVistorDate(Date vistorDate) {
		this.vistorDate = vistorDate;
	}
	public final Long getInsuranceDays() {
		return insuranceDays;
	}
	public final void setInsuranceDays(Long insuranceDays) {
		this.insuranceDays = insuranceDays;
	}
	public Integer getPersonNum() {
		return personNum;
	}
	public void setPersonNum(Integer personNum) {
		this.personNum = personNum;
	}
	
	
}
