package com.lvmama.lvfit.common.dto.search.hotel;

import java.util.HashMap;
import java.util.Map;

import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.Pagination;


public class HotelSearchResult<T> extends BaseResultDto<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1404392930268775872L;
	
	private Pagination pagination;
	
	private Map<HotelFacetType, Object> facetMap = new HashMap<HotelFacetType, Object>();

	public Map<HotelFacetType, Object> getFacetMap() {
		return facetMap;
	}

	public void setFacetMap(Map<HotelFacetType, Object> facetMap) {
		this.facetMap = facetMap;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
}