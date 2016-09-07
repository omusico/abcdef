package com.lvmama.lvfit.aggregate.sdp.service;

import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;

public interface FitSdpProductService {

    FitSdpProductBasicInfoDto searchProductBasicInfo(Long productId);
    
    FitSdpProductBasicInfoDto searchProductInfoOnly(Long productId);  
}
