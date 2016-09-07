package com.lvmama.lvfit.sdp.shopping;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.dto.calculator.AmountCalculatorRequest;
import com.lvmama.lvfit.common.dto.sdp.calculator.FitSdpShoppingAmountDto;
import com.lvmama.lvfit.common.dto.sdp.calculator.request.FitSdpCalculateAmountDetailRequest;
import com.lvmama.lvfit.common.dto.sdp.calculator.request.FitSdpCalculateAmountRequest;
import com.lvmama.lvfit.common.dto.shopping.FitFlightAmountDto;

/**
 * 购物车金额计算service
 * @author leizhengwei
 *
 */
public interface FitSdpShopingCalculateService {

	/**
	 * 通过购物车UUID算价
	 * @param request
	 * @return
	 */
	BaseSingleResultDto<FitSdpShoppingAmountDto> calculateAmount(FitSdpCalculateAmountRequest request);
	
	/**
	 * 机票金额计算
	 * @param request
	 * @return
	 */
	FitFlightAmountDto calculateFlightAmount(AmountCalculatorRequest request);


	/**
	 * 通过购物车请求明细算价
	 * @param request
	 * @return
	 */
	BaseSingleResultDto<FitSdpShoppingAmountDto> calculateAmountByDetail(FitSdpCalculateAmountDetailRequest request);
}
