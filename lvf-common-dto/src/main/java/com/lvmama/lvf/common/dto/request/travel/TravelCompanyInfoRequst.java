package com.lvmama.lvf.common.dto.request.travel;

import java.io.Serializable;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvf.common.dto.travel.TravelCompanyInfoDto;

/**
 * @author lutianyu
 * @date   2016年1月20日
 */
public class TravelCompanyInfoRequst implements Serializable,Dto{
	private static final long serialVersionUID = 2500972469543017032L;

	private TravelCompanyInfoDto travelCompanyInfoDto = new TravelCompanyInfoDto();
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return travelCompanyInfoDto.getId();
	}

	public void setId(Long id) {
		travelCompanyInfoDto.setId(id);
	}

	public String getCompanyName() {
		return travelCompanyInfoDto.getCompanyName();
	}

	public void setCompanyName(String companyName) {
		travelCompanyInfoDto.setCompanyName(companyName);
	}

	public String getCompanyCode() {
		return travelCompanyInfoDto.getCompanyCode();
	}

	public void setCompanyCode(String companyCode) {
		travelCompanyInfoDto.setCompanyCode(companyCode);
	}

	public TravelCompanyInfoDto getParentCompany() {
		return travelCompanyInfoDto.getParentCompany();
	}

	public void setParentCompany(TravelCompanyInfoDto parentCompany) {
		travelCompanyInfoDto.setParentCompany(parentCompany);
	}

	public TravelCompanyInfoDto getTravelCompanyInfoDto() {
		return travelCompanyInfoDto;
	}

	public void setTravelCompanyInfoDto(TravelCompanyInfoDto travelCompanyInfoDto) {
		this.travelCompanyInfoDto = travelCompanyInfoDto;
	}
	
}
