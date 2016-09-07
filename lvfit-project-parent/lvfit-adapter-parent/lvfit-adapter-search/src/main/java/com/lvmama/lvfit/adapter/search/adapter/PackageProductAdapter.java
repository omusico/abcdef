package com.lvmama.lvfit.adapter.search.adapter;

import com.lvmama.lvfit.common.dto.enums.JudgeType;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;

public interface PackageProductAdapter {

    public FitSdpProductBasicInfoDto getPackageProductBasicInfo(Long productId);
    
    public FitSdpProductBasicInfoDto getPackageProductSimpleInfo(Long productId);
    
    public JudgeType getProdProductProp(Long productId);
}
