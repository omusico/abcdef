package com.lvmama.lvf.common.solr.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.lvmama.lvf.common.utils.JSONMapper;

public class DynamicIndexConverter {
	
	public static final Logger logger=Logger.getLogger(DynamicIndexConverter.class);
	
	
    public enum ActionType {
    	 ADD_BY_DYNAMIC_BASE {
             @Override
             public String converToJsonString(List<? extends DynamicIndex> indexs) throws Exception {
            	 
                 if(logger.isDebugEnabled()){
                     logger.debug("indexs:"+JSONMapper.getInstance().writeValueAsString(indexs));
                 }
            	 StringBuilder builder=new StringBuilder("{");
                 
            	 Map<String,Map> indexMaps = new  HashMap<String,Map>();
            	 
                 for(DynamicIndex dynamicIndex:indexs){
                     if(null==indexMaps.get(dynamicIndex.getIndexId())){
                         if(logger.isDebugEnabled()){
                             logger.debug("indexId:"+dynamicIndex.getIndexId());
                         }
                    	 indexMaps.put(dynamicIndex.getIndexId(),new HashMap());
                     }
                     indexMaps.get(dynamicIndex.getIndexId()).putAll(dynamicIndex.getFields());
                 }
                 boolean f=false;
                 if(logger.isDebugEnabled()){
                     logger.debug("indexMaps:"+JSONMapper.getInstance().writeValueAsString(indexMaps));
                 }
                 
            	 for(Map index:indexMaps.values()) {
                     if(f){
                         builder.append(",");
                     }
                     builder.append("\"add\": {\"doc\":" + JSONMapper.getInstance().writeValueAsString(index)+ "} ");
                     f=true;
                 }
                 String options = "";
                 builder.append( options + "}");
//                 logger.error( builder.toString());
                 return builder.toString();
             }
        },
        ADD {
            @Override
            public String converToJsonString(List<? extends DynamicIndex> indexs) throws Exception {
            	return IndexConverter.ActionType.ADD.converToJsonString(indexs);
            }
        },
        COMMIT {
            @Override
            public String converToJsonString(List<? extends DynamicIndex> indexs) throws Exception {
            	return "\"{commit:{}}\"";
            }
        },
        DELETE {
            @Override
            public String converToJsonString(List<? extends DynamicIndex> indexs)  throws Exception  {
            	return IndexConverter.ActionType.DELETE.converToJsonString(indexs);
            }
        };
        public abstract String converToJsonString(List<? extends DynamicIndex> indexs)  throws Exception ;
    }

	
}
