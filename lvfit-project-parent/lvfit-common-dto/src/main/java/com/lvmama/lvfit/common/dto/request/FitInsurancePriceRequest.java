package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedInsuranceDto;

public class FitInsurancePriceRequest implements Serializable{
	
	private static final long serialVersionUID = 5217040330141708053L;
	
	private List<FitShoppingSelectedInsuranceDto> selectInsuranceInfos = new ArrayList<FitShoppingSelectedInsuranceDto>();

	public List<FitShoppingSelectedInsuranceDto> getSelectInsuranceInfos() {
		return selectInsuranceInfos;
	}

	public void setSelectInsuranceInfos(
			List<FitShoppingSelectedInsuranceDto> selectInsuranceInfos) {
		this.selectInsuranceInfos = selectInsuranceInfos;
	}
}
