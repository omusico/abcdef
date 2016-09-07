package com.lvmama.lvfit.common.dto.sdp.product.result;

import java.math.BigDecimal;
import java.util.List;

import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpInstalmentDto;

public class FitSdpGroupCalendarSearchResult<T> extends BaseResultDto<T> {
	
	private static final long serialVersionUID = 7211765475694165205L;
	
	/**当前起价 */
	private BigDecimal startPrice;
	
	/**分期付款信息 */
    private List<FitSdpInstalmentDto> instalments;

	public BigDecimal getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(BigDecimal startPrice) {
		this.startPrice = startPrice;
	}

    public List<FitSdpInstalmentDto> getInstalments() {
        return instalments;
    }

    public void setInstalments(List<FitSdpInstalmentDto> instalments) {
        this.instalments = instalments;
    }
}
