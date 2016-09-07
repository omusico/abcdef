package com.lvmama.lvfit.adapter.search.adapter;

import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductAdditionalInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductAdditionalInfoRequest;

public interface PackageProductAdditionalAdapter {

    public FitSdpProductAdditionalInfoDto searchPackageProductAdditionalInfo(FitSdpProductAdditionalInfoRequest req, FitSdpProductAdditionalInfoDto additional);
}
