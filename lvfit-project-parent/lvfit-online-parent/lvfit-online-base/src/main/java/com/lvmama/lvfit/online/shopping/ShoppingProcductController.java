package com.lvmama.lvfit.online.shopping;

import com.lvmama.lvf.common.dto.Dto;
import com.lvmama.lvfit.common.dto.request.FitShoppingFliInsRequest;
import com.lvmama.lvfit.common.dto.request.FitShoppingInsuranceRequest;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;

public interface ShoppingProcductController<D extends Dto>  {

    public void updSelectedTicket(D d);
    public FitShoppingDto getShoppingDtoByCache(String shoppingUuid);
    public void updSelectedInsurance(FitShoppingInsuranceRequest req);
	public void updSelectedTicket(FitShoppingFliInsRequest req);
}
