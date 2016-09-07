package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.shopping.FitProductDto;

public class CalculateProductPriceRequest implements Serializable, Dto {

    private static final long serialVersionUID = 8523183517977574642L;
    
    List<FitProductDto> products = new ArrayList<FitProductDto>();

    public List<FitProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<FitProductDto> products) {
        this.products = products;
    }

    @Override
    public Long getId() {
        // TODO Auto-generated method stub
        return null;
    }


}
