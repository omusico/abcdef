package com.lvmama.lvfit.adapter.search.adapter.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.comm.pet.po.seo.RecommendInfo;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.adapter.search.adapter.RecommendInfoAdapter;
import com.lvmama.lvfit.common.dto.recommend.FitRecommendInfo;
import com.lvmama.vst.pet.adapter.RecommendInfoServiceAdapter;

@Service
public class RecommendInfoAdapterImpl implements RecommendInfoAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecommendInfoAdapterImpl.class);
    
    @Autowired
    private RecommendInfoServiceAdapter recommendInfoServiceAdapter;
    
    @Override
    public Map<String, List<FitRecommendInfo>> getRecommendInfoMap(Long fromPlaceId) {
        String containerCode = "CHANNEL_FIT_RECOMMEND";
        Long commonBlockId = null;
        String channelPage = "fit";
        Map<String, List<RecommendInfo>> infoMap = recommendInfoServiceAdapter.getRecommendInfoMap(containerCode, commonBlockId, fromPlaceId, channelPage);
        if (MapUtils.isEmpty(infoMap)) {
            LOGGER.error("推荐信息infoMap为空!");
            return null;
        }
        try {
            LOGGER.info("推荐信息infoMap" + JSONMapper.getInstance().writeValueAsString(infoMap));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, List<FitRecommendInfo>>  returnMap = new HashMap<String, List<FitRecommendInfo>>();
        for (String key : infoMap.keySet()) {
            List<RecommendInfo> list = infoMap.get(key);
            List<FitRecommendInfo> infoList = new ArrayList<FitRecommendInfo>();
            if (CollectionUtils.isNotEmpty(list)) {
                for (RecommendInfo info : list) {
                    FitRecommendInfo recommendInfo = new FitRecommendInfo();
                    recommendInfo.setRecommendInfoId(info.getRecommendInfoId());
                    recommendInfo.setRecommendBlockId(info.getRecommendBlockId());
                    recommendInfo.setParentRecommendBlockId(info.getParentRecommendBlockId());
                    recommendInfo.setDataCode(info.getDataCode());
                    recommendInfo.setImgUrl(info.getImgUrl());
                    recommendInfo.setPrice(info.getMemberPrice());
                    recommendInfo.setTitle(info.getTitle());
                    recommendInfo.setUrl(info.getUrl());
                    recommendInfo.setSeq(info.getSeq());
                    recommendInfo.setBakWord1(info.getBakWord1());
                    recommendInfo.setBakWord2(info.getBakWord2());
                    recommendInfo.setBakWord3(info.getBakWord3());
                    recommendInfo.setBakWord4(info.getBakWord4());
                    recommendInfo.setBakWord5(info.getBakWord5());
                    recommendInfo.setBakWord6(info.getBakWord6());
                    recommendInfo.setBakWord7(info.getBakWord7());
                    recommendInfo.setBakWord8(info.getBakWord8());
                    recommendInfo.setBakWord9(info.getBakWord9());
                    recommendInfo.setBakWord10(info.getBakWord10());
                    infoList.add(recommendInfo);
                }
            }
            returnMap.put(key, infoList);
        }
        return returnMap;
    }

}
