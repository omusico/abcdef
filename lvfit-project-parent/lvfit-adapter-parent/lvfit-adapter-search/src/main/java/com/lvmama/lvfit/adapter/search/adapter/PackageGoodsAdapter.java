package com.lvmama.lvfit.adapter.search.adapter;

import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpGoodsRequest;

public interface PackageGoodsAdapter {

    public FitSdpGoodsDto getVstPackageGoodsInfo(FitSdpGoodsRequest productId);
}
