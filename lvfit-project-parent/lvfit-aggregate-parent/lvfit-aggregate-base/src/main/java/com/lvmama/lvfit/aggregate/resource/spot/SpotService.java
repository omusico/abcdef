package com.lvmama.lvfit.aggregate.resource.spot;

import com.lvmama.lvfit.common.dto.search.spot.SpotQueryRequest;
import com.lvmama.lvfit.common.dto.search.spot.SpotSearchResult;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;

/**
 * 查询景点信息聚合service
 * @author leizhengwei
 *
 */
public interface SpotService {

	 SpotSearchResult<SpotSearchSpotDto> searchSpot(SpotQueryRequest spotQueryRequest);
	
}
