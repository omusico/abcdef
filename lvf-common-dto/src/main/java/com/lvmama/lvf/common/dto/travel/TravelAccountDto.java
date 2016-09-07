package com.lvmama.lvf.common.dto.travel;

import com.lvmama.lvf.common.dto.AEEntity;
import com.lvmama.lvf.common.dto.enums.travel.TravelAccountType;

public class TravelAccountDto extends AEEntity{
	
	private static final long serialVersionUID = -8223238928735616099L;
	
	//super登录账号
	private String accountNumber;
	//所属公司
	private TravelCompanyInfoDto company;
	//账号类型（个人，内部客户，外部客户）
	private TravelAccountType accountType;
	//所属公司ID
	private Long companyId;
	
	public boolean needSetCompany(){
		return !TravelAccountType.PERSONAL.equals(this.getAccountType());
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public TravelCompanyInfoDto getCompany() {
		return company;
	}

	public void setCompany(TravelCompanyInfoDto company) {
		this.company = company;
	}

	public TravelAccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(TravelAccountType accountType) {
		this.accountType = accountType;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

}
