package com.lvmama.lvfit.adapter.search.adapter;

import com.lvmama.lvfit.common.dto.search.spot.SpotQueryRequest;
import com.lvmama.lvfit.common.dto.search.spot.SpotSearchResult;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;

/**
 * 景点搜索适配接口
 * @author leizhengwei
 *
 */
public interface SpotSearchAdapter {
	
	
	public SpotSearchResult<SpotSearchSpotDto> searchSpot(SpotQueryRequest spotQueryRequest);

}
