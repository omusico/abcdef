package com.lvmama.lvfit.adapter.vst.adapter.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.comm.pet.po.seo.RecommendInfo;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.common.utils.MemcachedUtil;
import com.lvmama.lvfit.adapter.vst.adapter.CommHeaderServiceAdapter;
import com.lvmama.lvfit.common.dto.request.CommHeaderRequest;
import com.lvmama.vst.comm.vo.Constant;
import com.lvmama.vst.pet.adapter.ICommHeaderServiceAdapter;

@Service
public class CommHeaderServiceAdapterImpl  implements CommHeaderServiceAdapter{
    
    private static final Logger logger = LoggerFactory.getLogger(CommHeaderServiceAdapterImpl.class);
    
	@Autowired
	private  ICommHeaderServiceAdapter commHeaderService;

	@Override
	public String getCommHead(CommHeaderRequest commHeaderRequest) {
		
		 String commHeader = null;
		 if(StringUtils.isNotBlank(commHeaderRequest.getType())
				 &&null!=commHeaderRequest.getIsNew()
				 &&StringUtils.isNotBlank(commHeaderRequest.getProvinceId())
				 &&StringUtils.isNotBlank(commHeaderRequest.getCityId())
				 &&StringUtils.isNotBlank(commHeaderRequest.getStationName())) {
	            Object type = commHeaderRequest.getType();
	            Object isNew = commHeaderRequest.getIsNew();
	            Object provinceId = commHeaderRequest.getProvinceId();
	            Object cityId = commHeaderRequest.getCityId();
	            Object stationName = commHeaderRequest.getStationName();
	            Object pageType = commHeaderRequest.getPageType();

	            commHeader = MemcachedUtil.getInstance().get(Constant.MEM_CACH_KEY.VST_HEADER_.toString() + type + "_" + isNew + "_" + provinceId + "_" + cityId+"_"+pageType);
	            if(null == commHeader){
	                Map<String,List<RecommendInfo>> recommendInfoMap = commHeaderService.getNewHeadContent( provinceId!=null?(String)provinceId:null, cityId!=null?(String)cityId:null, stationName!=null?(String)stationName:null);
	                try {
	                	if(logger.isInfoEnabled()){
	                		logger.info("从接口中取头部信息" + JSONMapper.getInstance().writeValueAsString(recommendInfoMap));
	                	}
                    } catch (Exception e) {
                    	logger.error(e.getMessage());
                    }
	                Boolean isFirstAccept = (stationName==null);
	                commHeader = commHeaderService.getHeadContent((String) type, (String) stationName, Boolean.valueOf(isNew.toString()), recommendInfoMap, isFirstAccept);

	                MemcachedUtil.getInstance().set(Constant.MEM_CACH_KEY.VST_HEADER_.toString() + type + "_" + isNew + "_" + provinceId + "_" + cityId+"_"+pageType,commHeader);
	            }else{
                   //System.out.print("从缓存中取头部信息！！！");
	            }
	        }else if(StringUtils.isNotBlank(commHeaderRequest.getType())
					 &&null!=commHeaderRequest.getIsNew()){
	            Object type =commHeaderRequest.getType();
	            Object isNew = commHeaderRequest.getIsNew();
	            commHeader = commHeaderService.getHeadContent((String)type,Boolean.valueOf(isNew.toString()));
	        }
	        else{
	            commHeader = commHeaderService.getCommHeaderText();
	        }

			return commHeader;
		
	}
	

}
