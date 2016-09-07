package com.lvmama.lvf.common.client;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.solr.json.DynamicIndex;
import com.lvmama.lvf.common.solr.json.DynamicIndexConverter;
import com.lvmama.lvf.common.solr.json.Index;
import com.lvmama.lvf.common.solr.json.IndexConverter;
import com.lvmama.lvf.common.solr.json.ext.SolrQueryCriteria;
import com.lvmama.lvf.common.solr.json.ext.select.SolrObject;
import com.lvmama.lvf.common.trace.profile.Profile;
import com.lvmama.lvf.common.trace.profile.ProfilePoint;

public abstract class SolrClient {

    @Autowired
    private RestClient client;

    public abstract String getSolrUrl();
    
    public String getSolrUrl(String coreSplitKey){
    	return getSolrUrl()+coreSplitKey;
    };

    private enum SolrSearchCommand {

        UPDATE("/update?commit=true"),
        SELECT("/search/flight/flight?"),
        SELECT_FACET("/search/flight/facet?"),
        SELECT_DETAIL("/search/flight/detail?"),
        SELECT_RECORD_DETAIL("/search/flight/record/detail?"),
        SELECT_FIT_RECORD_DETAIL("/search/fit/record/detail?");

        public String command;

        public String getCommand() {
            return command;
        }

        private SolrSearchCommand(String command) {
            this.command = command;
        }

    }

  //add or update
//    public <T> SolrObject<T> singleCommit(Class<T> responseType) throws Exception {
//        String url = getSolrUrl() + SolrSearchCommand.UPDATE.getCommand();
////        System.out.println(url);
////        System.out.println(DynamicIndexConverter.ActionType.ADD_BY_DYNAMIC_BASE.converToJsonString(indexs));
//        String result = client.post(url, String.class, DynamicIndexConverter.ActionType.COMMIT.converToJsonString(null));
//        SolrObject<T> object = new SolrObject<T>(result,responseType);
//        return object;
//    }
    
    //add or update
    public <T> SolrObject<T> addDynamic(List<? extends DynamicIndex> indexs, Class<T> responseType) throws Exception {
        String url = getSolrUrl() + SolrSearchCommand.UPDATE.getCommand();
//        System.out.println(url);
//        System.out.println(DynamicIndexConverter.ActionType.ADD_BY_DYNAMIC_BASE.converToJsonString(indexs));
        String result = client.post(url, String.class, DynamicIndexConverter.ActionType.ADD_BY_DYNAMIC_BASE.converToJsonString(indexs));
        SolrObject<T> object = new SolrObject<T>(result, responseType);
        return object;
    }

    //add or update
    public <T> SolrObject<T> add(List<? extends Index> indexs, Class<T> responseType) throws Exception {
        String url = getSolrUrl() + SolrSearchCommand.UPDATE.getCommand();
        String result = client.post(url, String.class, IndexConverter.ActionType.ADD.converToJsonString(indexs));
        SolrObject<T> object = new SolrObject<T>(result, responseType);
        return object;
    }

    //delete
    public <T> SolrObject<T> delete(List<? extends Index> indexs, Class<T> responseType) throws Exception {
        String url = getSolrUrl() + SolrSearchCommand.UPDATE.getCommand();
        String result = client.post(url, String.class, IndexConverter.ActionType.DELETE.converToJsonString(indexs));
        SolrObject<T> object = new SolrObject<T>(result, responseType);
        return object;
    }
    
    public <T> SolrObject<T> delete(Map<String,String> query, Class<T> responseType) throws Exception {
        String url = getSolrUrl() + SolrSearchCommand.UPDATE.getCommand();
 //       System.out.println(IndexConverter.ActionType.DELETE_BY_QUERY.deleteByQuery(query));
        String result = client.post(url, String.class, IndexConverter.ActionType.DELETE_BY_QUERY.deleteByQuery(query));
        SolrObject<T> object = new SolrObject<T>(result, responseType);
        return object;
    }
    
    //select
    @ProfilePoint(Profile.SELECT_WITH_FACET_FROM_SOLR_CLIENT)
    public <S, T> SolrObject<T> selectWithFacet(BaseQueryDto<S> queryDto, Class<T> responseType) throws Exception {
        SolrQueryCriteria criteria = new SolrQueryCriteria(queryDto);
        String url = getSolrUrl() + SolrSearchCommand.SELECT_FACET.getCommand() + criteria.getSolrSelectWithFacet();
//        System.out.println(url);
        String result = client.get(url, String.class);
        SolrObject<T> object = new SolrObject<T>(result, responseType);
        return object;
    }

    @ProfilePoint(Profile.SELECT_WITH_GROUP_FROM_SOLR_CLIENT)
    public <S, T> SolrObject<T> selectWithGroup(BaseQueryDto<S> queryDto, Class<T> responseType) throws Exception {
        SolrQueryCriteria criteria = new SolrQueryCriteria(queryDto);
        String url = getSolrUrl() + SolrSearchCommand.SELECT.getCommand() + criteria.getSolrSelectWithCollapse();
//        System.out.println(url);
        String result = client.get(url, String.class);
        SolrObject<T> object = new SolrObject<T>(result, responseType);
        return object;
    }

    @ProfilePoint(Profile.SELECT_WITH_PAGE_FROM_SOLR_CLIENT)
    public <S, T> SolrObject<T> selectWithPage(BaseQueryDto<S> queryDto, Class<T> responseType) throws Exception {
        SolrQueryCriteria criteria = new SolrQueryCriteria(queryDto);
        String date = null;
        try{
        	date = criteria.getDynamicBases().get("(day)").toArray()[0]+"";
        }catch(Exception ex){
        }
        String url = getSolrUrl() + SolrSearchCommand.SELECT_DETAIL.getCommand() + criteria.getSolrSelectWithPage();
        String result = client.get(url, String.class);
        SolrObject<T> object = new SolrObject<T>(result,date,responseType);
        return object;
    }
    
    public <S, T> SolrObject<T> selectRecordWithPage(BaseQueryDto<S> queryDto, Class<T> responseType) throws Exception {
        SolrQueryCriteria criteria = new SolrQueryCriteria(queryDto);
        String url = getSolrUrl() + SolrSearchCommand.SELECT_RECORD_DETAIL.getCommand() + criteria.getSolrSelectWithPage();
        String result = client.get(url, String.class);
        SolrObject<T> object = new SolrObject<T>(result,responseType);
        return object;
    }
    
    public <S, T> SolrObject<T> selectFitRecordWithPage(BaseQueryDto<S> queryDto, Class<T> responseType) throws Exception {
        SolrQueryCriteria criteria = new SolrQueryCriteria(queryDto);
        String url = getSolrUrl() + SolrSearchCommand.SELECT_FIT_RECORD_DETAIL.getCommand() + criteria.getSolrSelectWithPage();
        String result = client.get(url, String.class);
        SolrObject<T> object = new SolrObject<T>(result,responseType);
        return object;
    }



}
