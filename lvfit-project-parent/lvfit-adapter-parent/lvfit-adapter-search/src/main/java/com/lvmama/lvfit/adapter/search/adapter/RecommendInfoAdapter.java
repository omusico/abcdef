package com.lvmama.lvfit.adapter.search.adapter;

import java.util.List;
import java.util.Map;

import com.lvmama.lvfit.common.dto.recommend.FitRecommendInfo;

public interface RecommendInfoAdapter {

    public Map<String, List<FitRecommendInfo>> getRecommendInfoMap(Long fromPlaceId);
}
