package com.lvmama.lvf.common.solr.json.ext.select;

import org.apache.commons.lang.StringUtils;

import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.solr.json.base.select.SolrBaseObject;

public class SolrObject<T> extends SolrBaseObject<T> {

    public SolrObject(String solrResponse, Class dto) throws Exception {
		super(solrResponse,dto);
	}
	public SolrObject(String solrResponse, String dynamicBase, Class<T> dto)  throws Exception {
		super(solrResponse,dynamicBase,dto);
	}

	public Pagination getPagination() {
		
		Pagination pagination=new Pagination();
		
		pagination.setRecords(this.getResponse().getNumFound());
		
		if(0!=this.getResponseHeader().getParams().getRows()){
			pagination.setRows(this.getResponseHeader().getParams().getRows());
		}
		
		if(0!=this.getResponseHeader().getParams().getStart()
				&&0!=this.getResponseHeader().getParams().getRows()){
			pagination.setPage(1+(this.getResponseHeader().getParams().getStart())/this.getResponseHeader().getParams().getRows());
		}
		
		pagination.countRecords(this.getResponse().getNumFound());

		String sorts=this.getResponseHeader().getParams().getSort();
		
		if(StringUtils.isNotEmpty(sorts)){
			String[] strs = sorts.split(",");
			for(String sort:strs){
				String[] str=sort.split(" ");
				pagination.setSidx(str[0]);
				pagination.setSord(str[1]);
			}
		}
		
		return pagination;
    }
	
	 public BaseResultDto<T> getResultDto() {
		 return new BaseResultDto<T>(this.getPagination(),this.getResults());
	 }
	
}
