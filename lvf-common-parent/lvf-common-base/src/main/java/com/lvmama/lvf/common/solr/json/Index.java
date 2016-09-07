package com.lvmama.lvf.common.solr.json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.lvmama.lvf.common.utils.JSONMapper;

public abstract class Index {
	
	public String toJsonString() throws JsonGenerationException, JsonMappingException, IOException {
		return JSONMapper.getInstance().writeValueAsString(this);
	}
	
	public abstract String getIndexId();

}
