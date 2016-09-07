package com.lvmama.lvf.common.dto.search;

import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.solr.json.base.select.SolrFacetFields;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

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
