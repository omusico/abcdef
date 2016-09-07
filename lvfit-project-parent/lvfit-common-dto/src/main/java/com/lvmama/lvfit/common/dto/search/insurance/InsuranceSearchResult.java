package com.lvmama.lvfit.common.dto.search.insurance;

import java.util.HashMap;
import java.util.Map;

import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.Pagination;

public class InsuranceSearchResult<T> extends BaseResultDto<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7211765475694165205L;
	
	private Pagination pagination;
	
	private Map<InsuranceFacetType, Object> facetMap = new HashMap<InsuranceFacetType, Object>();

	public Map<InsuranceFacetType, Object> getFacetMap() {
		return facetMap;
	}

	public void setFacetMap(Map<InsuranceFacetType, Object> facetMap) {
		this.facetMap = facetMap;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
}
