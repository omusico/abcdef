package com.lvmama.lvfit.common.form.shopping;

import java.io.Serializable;
import java.util.List;

import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.request.CalculateProductPriceRequest;
import com.lvmama.lvfit.common.dto.shopping.FitProductDto;

public class CalculateProductPriceRequestForm implements Serializable,Form {

    private static final long serialVersionUID = -370737919811991707L;

    private CalculateProductPriceRequest req = new CalculateProductPriceRequest();

    public CalculateProductPriceRequest getReq() {
        return req;
    }

    public void setReq(CalculateProductPriceRequest req) {
        this.req = req;
    }

    public List<FitProductDto> getProducts() {
        return req.getProducts();
    }

    public void setProducts(List<FitProductDto> products) {
        req.setProducts(products);
    }
}
