package com.lvmama.lvfit.aggregate.core.spot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvfit.aggregate.resource.spot.SpotService;
import com.lvmama.lvfit.common.client.FitSearchClient;
import com.lvmama.lvfit.common.dto.search.spot.SpotQueryRequest;
import com.lvmama.lvfit.common.dto.search.spot.SpotSearchResult;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;

/**
 * 查询景点信息聚合service实现
 * @author leizhengwei
 *
 */
@Service
public class SpotServiceImpl implements SpotService {
	
	@Autowired
	private FitSearchClient fitSearchClient;

	@Override
	public SpotSearchResult<SpotSearchSpotDto> searchSpot(SpotQueryRequest spotQueryRequest) {

			SpotSearchResult<SpotSearchSpotDto> result = fitSearchClient.searchSpot(spotQueryRequest);
			return result;
	}

}
