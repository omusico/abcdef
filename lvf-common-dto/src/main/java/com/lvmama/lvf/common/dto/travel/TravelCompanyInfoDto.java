package com.lvmama.lvf.common.dto.travel;

import com.lvmama.lvf.common.dto.AEEntity;

/**
 * 商旅公司信息
 * @author lutianyu
 * @date   2016年1月19日
 */
public class TravelCompanyInfoDto extends AEEntity{
	private static final long serialVersionUID = 1L;
	
	/** 公司名称 */
	private String companyName;
	
	/** 公司代码 */
	private String companyCode;
	
	/** 父公司 */
	private TravelCompanyInfoDto parentCompany;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public TravelCompanyInfoDto getParentCompany() {
		return parentCompany;
	}
	public void setParentCompany(TravelCompanyInfoDto parentCompany) {
		this.parentCompany = parentCompany;
	}
}
