package com.lvmama.lvfit.adapter.search.adapter.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.comm.pet.po.perm.PermUser;
import com.lvmama.comm.pet.po.user.UserUser;
import com.lvmama.comm.pet.service.perm.PermUserService;
import com.lvmama.comm.search.vst.vo.VstRouteSearchVO;
import com.lvmama.lvf.common.client.RestClient;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.adapter.search.adapter.PackageProductAdditionalAdapter;
import com.lvmama.lvfit.adapter.vst.adapter.CommentStatServiceAdapter;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProdTagDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductAdditionalInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductAdditionalInfoRequest;
import com.lvmama.lvfit.common.dto.vst.VstCommentStat;
import com.lvmama.vst.api.prom.service.VstPromotionService;
import com.lvmama.vst.back.client.biz.service.ProdTagClientService;
import com.lvmama.vst.back.client.prod.service.ProdProductAdditionClientService;
import com.lvmama.vst.back.client.prom.service.BuyPresentClientService;
import com.lvmama.vst.back.client.prom.service.PromotionService;
import com.lvmama.vst.back.prod.po.ProdProductAddtional;
import com.lvmama.vst.back.prod.vo.ProdTagVO;
import com.lvmama.vst.back.prom.po.PromBuyPresenter;
import com.lvmama.vst.back.prom.po.PromPromotion;
import com.lvmama.vst.comm.utils.Constants;
import com.lvmama.vst.comm.utils.web.HttpServletLocalThread;
import com.lvmama.vst.comm.utils.web.ServletUtil;
import com.lvmama.vst.comm.vo.Constant;
import com.lvmama.vst.comm.vo.ResultHandleT;
import com.lvmama.vst.comm.vo.order.BuyPresentActivityInfo;
import com.lvmama.vst.newsearch.service.LvmamaClientService;
import com.lvmama.vst.pet.adapter.PermUserServiceAdapter;
import com.lvmama.vst.search.api.vo.SearchResultVo;

@Service
public class PackageProductAdditionalAdapterImpl implements PackageProductAdditionalAdapter {

    private static final Logger logger = LoggerFactory.getLogger(PackageProductAdditionalAdapterImpl.class);

    @Autowired
    private ProdProductAdditionClientService prodProductAdditionClientService;
    @Autowired
    private PermUserServiceAdapter permUserServiceAdapter;
    @Autowired
    private ProdTagClientService prodTagClientService;
    @Autowired
    private BuyPresentClientService buyPresentClientService;
    @Autowired
    private PromotionService promotionService;
    @Autowired
    private CommentStatServiceAdapter commentStatServiceAdapter;
    @Autowired
    private VstPromotionService vstPromotionService;
    @Autowired
    private LvmamaClientService lvmamaClientService;
    
    @Autowired
    private RestClient restClient;
    
    @Override
    public FitSdpProductAdditionalInfoDto searchPackageProductAdditionalInfo(FitSdpProductAdditionalInfoRequest req, FitSdpProductAdditionalInfoDto aditional) {
        FitSdpProductAdditionalInfoDto pkAdditionalInfo = null;
        if (aditional == null) {
            pkAdditionalInfo = new FitSdpProductAdditionalInfoDto();
        } else {
            pkAdditionalInfo = aditional;
        }
        // 额外信息
        ProdProductAddtional prodProductAddtional = this.getProdProductAdditional(req);
        
        // 成人儿童数量限制
        if(prodProductAddtional!=null){
        	 pkAdditionalInfo.setAdultMinQuantity(prodProductAddtional.getAdultMinQuantity());
             pkAdditionalInfo.setAdultMaxQuantity(prodProductAddtional.getAdultMaxQuantity());
             pkAdditionalInfo.setChildMinQuantity(prodProductAddtional.getChildMinQuantity());
             pkAdditionalInfo.setChildMaxQuantity(prodProductAddtional.getChildMaxQuantity());
             pkAdditionalInfo.setHotel(prodProductAddtional.getHotel());
             pkAdditionalInfo.setChangeHotelFlag(prodProductAddtional.getChangeHotelFlag());
        }
        
        // 头部标签
        pkAdditionalInfo.setTitleTags(this.getTitleTagsInfo(req.getProductId()));
        // 点评
        pkAdditionalInfo.setFeedBackRate(this.getCommentInfo(req.getProductId()));
        List<FitSdpProdTagDto> tags = new ArrayList<FitSdpProdTagDto>();
//        // 买赠信息
//        FitSdpProdTagDto buyPresentActivityTag = this.getBuyPresentActivityTag(req.getProductId());
//        if (buyPresentActivityTag != null) {
//            tags.add(buyPresentActivityTag);
//        }
        // 返现
        List<FitSdpProdTagDto> returnCashTag = this.getReturnCashTag(req.getProductId());
        if (CollectionUtils.isNotEmpty(returnCashTag)) {
            tags.addAll(returnCashTag);
        }
        // 游记返现
        FitSdpProdTagDto travelReturnCashTag = this.getTravelReturnCashTag(req.getCategoryCode());
        if (travelReturnCashTag != null) {
            tags.add(travelReturnCashTag);
        }
        pkAdditionalInfo.setDiscountActivityTags(tags);
//        // 促销
//        pkAdditionalInfo.setPromotionInfo(this.getPromotion(req.getProductId()));
//        try {
//            com.lvmama.vst.api.vo.ResultHandleT<PageVo<PromPromotionVo>> promotions = vstPromotionService.getPromotions(req.getProductId(), "PRODUCT", 3L);
//            LOGGER.info("VST优惠信息" + JSONMapper.getInstance().writeValueAsString(promotions.getReturnContent()));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        // 查询产品经理头像URL
        pkAdditionalInfo.setPmUrl(this.getPMPortraitUrl(req.getManagerId()));
        PermUser pmUser = this.getPMUser(req.getManagerId());
        if (pmUser != null) {
            pkAdditionalInfo.setPmUserName(pmUser.getRealName());
        }
        
        return pkAdditionalInfo;
    }

    private ProdProductAddtional getProdProductAdditional(FitSdpProductAdditionalInfoRequest req) {
        ProdProductAddtional prodProductAddtional = null;
        try {
            Map<String, Long> params = new HashMap<String, Long>();
            params.put("productId", req.getProductId());
            params.put("startDistrictId", req.getStartDistrictId());
            prodProductAddtional = prodProductAdditionClientService.selectByConditon(params);
            if (prodProductAddtional != null) {
                try {
                	if(logger.isInfoEnabled()){
                		logger.info("从VST获取ProdProductAddtional：" + JSONMapper.getInstance().writeValueAsString(prodProductAddtional));
                	}
                } catch (Exception e) {
                    logger.error("instalmentList 转换JSON失败：" + e);
                }
            }
        } catch (Exception e) {
            logger.error("从VST获取ProdProductAddtional失败：" + e);
        }
        return prodProductAddtional;
    }

    

    private Float getCommentInfo(Long productId) {
        try {
            VstCommentStat commentStat = commentStatServiceAdapter.getVstCommentStatByProductId(productId);
            try {
            	if(logger.isInfoEnabled()){
            		logger.info("从VST获取打包产品点评信息：" + JSONMapper.getInstance().writeValueAsString(commentStat));
            	}
            } catch (Exception e) {
                logger.error("commentStat转换JSON失败：" + e);
            }
            return (commentStat.getAvgScore() + 5) * 10;
        } catch (Exception e) {
            logger.error("获取打包产品点评信息失败：" + e);
        }
        return null;
    }

    private String getPMPortraitUrl(Long managerId) {
        try {
            String productManagePic = permUserServiceAdapter.getProductManagePic(managerId);
            return productManagePic;
        } catch (Exception e) {
            logger.error("查询产品经理头像URL失败：" + e);
        }
        return null;
    }
    
    /**
     * 设置头部的促销的信息
     */
    private String getPromotion(Long productId){
        try {
            StringBuffer promotionStr = new StringBuffer("");
            List<PromPromotion> promPromotionList = promotionService.getPromotions(productId, Constants.PROM_PRODUCT, Long.valueOf(3));
            try {
            	if(logger.isInfoEnabled()){
            		logger.info("从VST获取头部促销信息：" + JSONMapper.getInstance().writeValueAsString(promPromotionList));
            	}
            } catch (Exception e) {
                logger.error("promPromotionList转换JSON失败：" + e);
            }
            if (CollectionUtils.isNotEmpty(promPromotionList)){
                for (PromPromotion promPromotion : promPromotionList){
                    String title = promPromotion.getTitle();
                    promotionStr.append(title + "<br/>");
                    if (null != promPromotion.getInstrs()) {
                        promotionStr.append(promPromotion.getInstrs()).append("<br/>");
                    }
                }
            }
            return promotionStr.toString();
        } catch (Exception e) {
            logger.error("设置头部的促销的信息失败：" + e);
        }
        return null;
    }

    private FitSdpProdTagDto getTravelReturnCashTag(String categoryCode) {
        try {
            String url = "http://www.lvmama.com/trip/ajax/getAmtByType?code=" + categoryCode;
            Map<String, HashMap<String, String>> map = restClient.get(url, Map.class);
            try {
            	if(logger.isInfoEnabled()){
            		logger.info("从VST获取游记返现信息fitTripBonus：" + JSONMapper.getInstance().writeValueAsString(map));
            	}
            } catch (Exception e) {
                logger.error("fitTripBonus转换JSON失败：" + e);
            }
            FitSdpProdTagDto tag = new FitSdpProdTagDto();
            HashMap<String, String> hashMap = map.get("data");
            if (MapUtils.isNotEmpty(hashMap)) {
                String amt = hashMap.get("amt");
                String startTime = hashMap.get("start_time");
                String endTime = hashMap.get("end_time");
                String hotTrip = hashMap.get("hot_trip");
                
                String startTimeStr = null;
                String endTimeStr = null;
                if (StringUtils.isNotBlank(startTime)) {
                    Long startTimeL = Long.valueOf(startTime);
                    Date startTimeD = new Date(startTimeL);
                    startTimeStr = DateUtils.formatDate(startTimeD, "yyyy年MM月dd日");
                }
                if (StringUtils.isNotBlank(endTime)) {
                    Long endTimeL = Long.valueOf(endTime);
                    Date endTimeD = new Date(endTimeL);
                    endTimeStr = DateUtils.formatDate(endTimeD, "yyyy年MM月dd日");
                }
                if (StringUtils.isNotBlank(hotTrip)) {
                    Double totalValue = Double.parseDouble(amt) + Double.parseDouble(hotTrip);
                    DecimalFormat df = new DecimalFormat("0.00"); 
                    String totalValueStr = df.format(totalValue);
                    
                    tag.setTagName("游记返现");
                    tag.setTagContent("从" + startTimeStr + "起到" + endTimeStr + "发表订单游记，审核通过即返" + amt + "元，精华游记即返" + totalValueStr + "元。更多精彩活动请查看游记频道。");
                } else {
                    tag.setTagName("游记返现");
                    tag.setTagContent("从" + startTimeStr + "起到" + endTimeStr + "发表订单游记，审核通过即返" + amt + "。更多精彩活动请查看游记频道。");
                }
            }
            return tag;
        } catch (Exception e) {
            logger.error("获取游记返现信息失败：" + e);
        }
        return null;
    }

    private  List<FitSdpProdTagDto> getReturnCashTag(Long productId) {
        try {
            ProdProductAddtional prodProductAddtional = prodProductAdditionClientService.selectByPrimaryKey(productId);
            if (prodProductAddtional == null) {
                return null;
            }
            try {
            	if(logger.isInfoEnabled()){
            		logger.info("从VST获取返现信息ProdProductAddtional：" + JSONMapper.getInstance().writeValueAsString(prodProductAddtional));
            	}
            } catch (Exception e) {
                logger.error("ProdProductAddtional转换JSON失败：" + e.getMessage());
            }
            List<FitSdpProdTagDto> returnTags = new ArrayList<FitSdpProdTagDto>();
            if (prodProductAddtional.getPcRebate() != null && prodProductAddtional.getPcRebate() > 0) {
                long num = prodProductAddtional.getPcRebate() / 100;
                FitSdpProdTagDto pcTag = new FitSdpProdTagDto();
                pcTag.setTagName("<em>返现</em>");
                pcTag.setTagContent("预订此产品，游玩后发表点评，内容通过审核，即可获得约" + num + "元奖金。最终返奖金额，以实际订单产生的奖金额为准。");
                returnTags.add(pcTag);
            }
//            if (prodProductAddtional.getMobileRebate() != null) {
//                long num = prodProductAddtional.getPcRebate() == null ? 0 : prodProductAddtional.getPcRebate() / 100;
//                long moblileNum = prodProductAddtional.getMobileRebate() / 100 - num;
//                if (moblileNum != 0) {
//                    FitSdpProdTagDto mobileTag = new FitSdpProdTagDto();
//                    mobileTag.setTagName("<em>返现<i>&yen;"+ moblileNum + "</i></em>");
//                    mobileTag.setTagContent("通过驴妈妈旅游客户端预订，发表点评即可多返" + moblileNum + "元奖金。");
//                    returnTags.add(mobileTag);
//                }
//            }
            return returnTags;
        } catch (Exception e) {
            logger.error("获取返现信息失败：" + e);
        }
        return null;
    }

    private FitSdpProdTagDto getBuyPresentActivityTag(Long productId) {
        try {
            List<Long> ids = new ArrayList<Long>();
            ids.add(productId);
            UserUser user = (UserUser)ServletUtil.getSession(HttpServletLocalThread.getRequest(), HttpServletLocalThread.getResponse(), Constant.SESSION_FRONT_USER);
            ResultHandleT<Map<String, BuyPresentActivityInfo>> resultHandleT = null;
            if (user != null) {
                resultHandleT = buyPresentClientService.gainToListDetailsActivity(ids, 0, user.getId());
            } else {
                resultHandleT = buyPresentClientService.gainToListDetailsActivity(ids, 0);
            }
            if (resultHandleT.hasNull()) {
                return null;
            }
            Map<String, BuyPresentActivityInfo> returnContent = resultHandleT.getReturnContent();
            try {
            	if(logger.isInfoEnabled()){
            		logger.info("从VST获取买赠信息Map<String, BuyPresentActivityInfo>：" + JSONMapper.getInstance().writeValueAsString(returnContent));
            	}
            } catch (Exception e) {
                logger.error("买赠信息Map<String, BuyPresentActivityInfo>转换JSON失败：" + e);
            }
            BuyPresentActivityInfo donation = returnContent.get(productId);//从接口返回的map中，根据当前产品ID取出对应的买赠信息
            if (null != donation){
                if(null != donation.getActivityTypeMoney()) {                  //重置页面买赠金额
                    donation.setActivityTypeMoney(donation.getActivityTypeMoney() / 100);
                }
            }
            
            Short donateType = donation.getActivityType();
            StringBuffer donateTagInfo = new StringBuffer();
            if (0 == donateType) {
                donateTagInfo.append("买就送:<br/>");
            } else if (1 == donateType) {
                donateTagInfo.append("满" + donation.getActivityTypeMoney() + "元就送:<br/>");
            } else if (2 == donateType) {
                donateTagInfo.append("购满" + donation.getActivityTypeCount() + "件就送:<br/>");
            }
    
            if (CollectionUtils.isNotEmpty(donation.getPresents())) {
                for (PromBuyPresenter presenter : donation.getPresents()) {
                    donateTagInfo.append("&nbsp;&nbsp;&nbsp;");
                    donateTagInfo.append(presenter.getPresentName());
                    donateTagInfo.append("<br/>");
                }
            }
            FitSdpProdTagDto returnTag = new FitSdpProdTagDto();
            returnTag.setTagName(donation.getActivityName());
            returnTag.setTagContent(donateTagInfo.toString());
            return returnTag;
        } catch (Exception e) {
            logger.error("获取买赠标签信息失败：" + e);
        }
        return null;
    }

    private List<FitSdpProdTagDto> getTitleTagsInfo(Long productId) {
        try {
            Map<String,Object> parameters = new HashMap<String,Object>();
            parameters.put("objectId",productId);
            parameters.put("objectType","PROD_PRODUCT");
            parameters.put("currentDate",new Date());
            parameters.put("_orderby","BT.SEQ");
            parameters.put("_start", 1);
            parameters.put("_end", 3);
            ResultHandleT<List<ProdTagVO>> resultHandleT = prodTagClientService.findProdTagList(parameters);
            if (resultHandleT.hasNull()) {
                return null;
            }
            try {
            	if(logger.isInfoEnabled()){
            		logger.info("从VST获取产品头部信息List<FitProdTagDto>：" + JSONMapper.getInstance().writeValueAsString(resultHandleT.getReturnContent()));
            	}
            } catch (Exception e) {
                logger.error("List<ProdTagVO>转换JSON报错：" + e);
            }
            List<ProdTagVO> prodTagVOs = resultHandleT.getReturnContent();
            List<FitSdpProdTagDto> returnTags = new ArrayList<FitSdpProdTagDto>();
            for (ProdTagVO prodTagVo : prodTagVOs) {
                FitSdpProdTagDto tag = new FitSdpProdTagDto();
                tag.setTagName(prodTagVo.getTagName());
                if (prodTagVo.getTag() != null) {
                    tag.setTagContent(prodTagVo.getTag().getMemo());
                }
                returnTags.add(tag);
            }
            return returnTags;
        } catch (Exception e) {
            logger.error("获取头部标签信息失败：" + e);
        }
        return null;
    }

    private PermUser getPMUser(Long managerId) {
        try {
            PermUser permUser = permUserServiceAdapter.getPermUserByUserId(managerId);
            return permUser;
        } catch (Exception e) {
            logger.error("查询产品经理头像URL失败：" + e);
        }
        return null;
    }
}
