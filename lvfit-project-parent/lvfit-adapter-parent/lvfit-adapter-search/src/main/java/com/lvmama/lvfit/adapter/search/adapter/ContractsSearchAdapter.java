package com.lvmama.lvfit.adapter.search.adapter;


import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;

public interface ContractsSearchAdapter {
	/**
	 * 获取合同模板的code
	 * @param bookingRequest
	 * @return
	 */
	public BaseSingleResultDto<String> getContractHtml(FitOrderBookingRequest bookingRequest);
	
	/**
	 * 根据合同模板code获取相应合同模板
	 * @param templateCode
	 * @return
	 */
	public BaseSingleResultDto<String> getContractTemplateHtml(String templateCode);
}
