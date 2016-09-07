package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedInsuranceDto;

public class FitShoppingInsuranceRequest implements Serializable, Dto {

    private static final long serialVersionUID = 7501178250424247851L;
    // 购物车ID
    private String shoppingUuid;
    private List<FitShoppingSelectedInsuranceDto> insuranceDtoList = new ArrayList<FitShoppingSelectedInsuranceDto>();
    private String insuranceList;
    public String getShoppingUuid() {
        return shoppingUuid;
    }
    public void setShoppingUuid(String shoppingUuid) {
        this.shoppingUuid = shoppingUuid;
    }
	public final List<FitShoppingSelectedInsuranceDto> getInsuranceDtoList() {
		return insuranceDtoList;
	}
	public final void setInsuranceDtoList(
			List<FitShoppingSelectedInsuranceDto> insuranceDtoList) {
		this.insuranceDtoList = insuranceDtoList;
	}
	public final String getInsuranceList() {
		return insuranceList;
	}
	public final void setInsuranceList(String insuranceList) {
		this.insuranceList = insuranceList;
	}
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}



}
