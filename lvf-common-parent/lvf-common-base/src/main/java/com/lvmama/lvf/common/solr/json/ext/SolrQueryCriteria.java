package com.lvmama.lvf.common.solr.json.ext;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.solr.json.base.SolrJSONUtils;
import com.lvmama.lvf.common.solr.json.base.criteria.SolrOrderField;
import com.lvmama.lvf.common.solr.json.base.criteria.enums.SolrOrderTYPE;
import com.lvmama.lvf.common.solr.json.ext.dynamic.criteria.SolrDynamicCriteria;

public class SolrQueryCriteria extends SolrDynamicCriteria {

	public SolrQueryCriteria(BaseQueryDto queryDto) throws Exception {
		super();
		init(queryDto.getCondition());
		initPagination(queryDto.getPagination());
		create();
	}
	
	public void initPagination(Pagination pagination){
		if(null==pagination){
			return;
		}
		this.setStart(pagination.getStartRow()-1);
		this.setRows(pagination.getRows());
		if(!checkSort(pagination)){
			return;
		}

        putSorts(pagination);

	}

    private void putSorts(Pagination pagination) {
        String [] sidxs = pagination.getSidx().split("\\|");
        String [] sords = pagination.getSord().split("\\|");
        for (int i = 0; i < sidxs.length; i++) {
            String sidx = sidxs[i];
            String sord = "ASC";
            if(i < sords.length){
                sord = sords[i];
            }
            this.getSorts().put(sidx,new SolrOrderField(sidx, SolrOrderTYPE.valueOf(sord.toUpperCase())));
        }
    }

    private boolean checkSort(Pagination pagination) {
        return !(SolrJSONUtils.assertEmpty(pagination.getSidx()) ||
                SolrJSONUtils.assertEmpty(pagination.getSord()));
    }
	
}
