package com.lvmama.lvfit.common.dto.search.spot;

import java.util.HashMap;
import java.util.Map;

import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.Pagination;

public class SpotSearchResult<T> extends BaseResultDto<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7211765475694165205L;
	
	private Pagination pagination;
	
	private Map<SpotFacetType, Object> facetMap = new HashMap<SpotFacetType, Object>();

	public Map<SpotFacetType, Object> getFacetMap() {
		return facetMap;
	}

	public void setFacetMap(Map<SpotFacetType, Object> facetMap) {
		this.facetMap = facetMap;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
}
