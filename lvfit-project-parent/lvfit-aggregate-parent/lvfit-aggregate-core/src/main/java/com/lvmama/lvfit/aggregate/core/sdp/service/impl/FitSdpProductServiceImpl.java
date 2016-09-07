package com.lvmama.lvfit.aggregate.core.sdp.service.impl;

import com.lvmama.lvfit.aggregate.sdp.service.FitSdpProductService;
import com.lvmama.lvfit.common.cache.CacheKey;
import com.lvmama.lvfit.common.client.FitSearchClient;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FitSdpProductServiceImpl implements FitSdpProductService {

    @Autowired
    private FitSearchClient fitSearchClient;
    
    @Override
    public FitSdpProductBasicInfoDto searchProductBasicInfo(@CacheKey Long productId) {
        return fitSearchClient.searchProductBasicInfo(productId);
    }

	@Override
	public FitSdpProductBasicInfoDto searchProductInfoOnly(Long productId) {
		return fitSearchClient.searchProductInfoOnly(productId);
	}
}
