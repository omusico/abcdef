package com.lvmama.lvfit.openapi.app.calculate;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.dto.app.FitAppShoppingRequest;
import com.lvmama.lvfit.common.dto.sdp.calculator.FitSdpShoppingAmountDto;

public interface FitAppSdpCalculateService {

	/**计算购物商品总价.
	 * @param request
	 * @return
	 */
	BaseSingleResultDto<FitSdpShoppingAmountDto> calculateAmount(FitAppShoppingRequest request);

}
