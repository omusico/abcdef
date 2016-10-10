package com.lvmama.lvfit.common.dto.request;

import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedInsuranceDto;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FitShoppingInsuranceRequest implements Serializable {

    private static final long serialVersionUID = 7501178250424247851L;
    // 购物车ID
    private String shoppingUuid;
    private List<FitShoppingSelectedInsuranceDto> insuranceDtoList = new ArrayList<FitShoppingSelectedInsuranceDto>();
    private String insuranceStr;

    public String getShoppingUuid() {
        return shoppingUuid;
    }
    public void setShoppingUuid(String shoppingUuid) {
        this.shoppingUuid = shoppingUuid;
    }
	public List<FitShoppingSelectedInsuranceDto> getInsuranceDtoList() {
		return insuranceDtoList;
	}
	public void setInsuranceDtoList(
			List<FitShoppingSelectedInsuranceDto> insuranceDtoList) {
		this.insuranceDtoList = insuranceDtoList;
	}

    public String getInsuranceStr() {
        return insuranceStr;
    }

    public void setInsuranceStr(String insuranceStr) {
        this.insuranceStr = insuranceStr;
        try {
            insuranceDtoList = JSONMapper.getInstance().readValue(insuranceStr, new TypeReference<List<FitShoppingSelectedInsuranceDto>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
