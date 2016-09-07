package com.lvmama.lvfit.aggregate.sdp.service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpGoodsRequest;

public interface FitSdpGoodsService {

    public BaseSingleResultDto<FitSdpGoodsDto> searchProductGoodsInfo(FitSdpGoodsRequest req);

}
   