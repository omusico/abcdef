package com.lvmama.lvfit.aggregate.core.sdp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.aggregate.sdp.service.FitSdpGoodsService;
import com.lvmama.lvfit.common.client.FitSearchClient;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpGoodsRequest;

@Service
public class FitSdpGoodsServiceImpl implements FitSdpGoodsService {

    @Autowired
    private FitSearchClient fitSearchClient;
    
    @Override
    public BaseSingleResultDto<FitSdpGoodsDto> searchProductGoodsInfo(FitSdpGoodsRequest req) {
        return fitSearchClient.searchProductGoodsInfo(req);
    }

}
