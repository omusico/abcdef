package com.lvmama.lvfit.sonline.shopping;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingAmountDto;
import com.lvmama.lvfit.sonline.shopping.form.FitSdpCalucateAmountRequestForm;

public interface FitSdpShoppingCalucatorController <I extends Form, R extends BaseResponseDto<? extends Form>>{
	public BaseSingleResultDto<FitShoppingAmountDto> calucateAmount(FitSdpCalucateAmountRequestForm form);
}
