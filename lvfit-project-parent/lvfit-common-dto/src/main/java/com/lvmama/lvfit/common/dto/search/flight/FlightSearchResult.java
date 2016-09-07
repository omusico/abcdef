package com.lvmama.lvfit.common.dto.search.flight;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.solr.json.base.select.SolrFacetFields;

@SuppressWarnings("serial")
@XmlRootElement
public class FlightSearchResult<T> extends BaseResultDto<T> {

	private Map<FlightFacetType, SolrFacetFields> facetMap = new HashMap<FlightFacetType, SolrFacetFields>();

	public Map<FlightFacetType, SolrFacetFields> getFacetMap() {
		return facetMap;
	}

	public void setFacetMap(Map<FlightFacetType, SolrFacetFields> facetMap) {
		this.facetMap = facetMap;
	}
	
}
