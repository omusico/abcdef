package com.lvmama.lvfit.openapi.app.calculate;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.dto.app.FitAppShoppingRequest;
import com.lvmama.lvfit.common.dto.sdp.calculator.FitSdpShoppingAmountDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingAmountDto;

public interface FitAppDpCalculateService {

	/**计算购物商品总价.
	 * @param request
	 * @return
	 */
	BaseSingleResultDto<FitShoppingAmountDto> calculateAmount(FitAppShoppingRequest request);

}
