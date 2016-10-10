package com.lvmama.lvfit.adapter.search.adapter.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.lvmama.vst.back.dujia.group.prod.vo.ProdProductNameVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.adapter.search.adapter.PackageProductAdapter;
import com.lvmama.lvfit.adapter.search.adapter.VstSearchInterfaceWrapper;
import com.lvmama.lvfit.common.dto.enums.JudgeType;
import com.lvmama.lvfit.common.dto.enums.ProductAuditType;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpDestDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductAdditionalInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductPropDto;
import com.lvmama.lvfit.common.utils.ShortPinYinUtil;
import com.lvmama.vst.api.route.prod.service.VstRouteService;
import com.lvmama.vst.api.route.prod.vo.ProdLineRouteDetailVo;
import com.lvmama.vst.api.route.prod.vo.ProdLineRouteVo;
import com.lvmama.vst.api.route.prod.vo.ProdRouteDetailActivityVo;
import com.lvmama.vst.api.route.prod.vo.ProdRouteDetailGroupVo;
import com.lvmama.vst.api.route.prod.vo.ProdRouteDetailScenicVo;
import com.lvmama.vst.back.biz.po.BizDistrict;
import com.lvmama.vst.back.client.prod.service.ProdProductPropClientService;
import com.lvmama.vst.back.dujia.comm.route.detail.po.ProdRouteDetailGroup;
import com.lvmama.vst.back.goods.vo.ProdProductParam;
import com.lvmama.vst.back.prod.po.ProdDestRe;
import com.lvmama.vst.back.prod.po.ProdProduct;
import com.lvmama.vst.back.prod.po.ProdProductProp;
import com.lvmama.vst.back.prod.po.ProdTraffic;
import com.lvmama.vst.back.prod.po.PropValue;
import com.lvmama.vst.back.prod.vo.ProdLineRouteVO;
import com.lvmama.vst.back.pub.po.ComPhoto;
import com.lvmama.vst.comm.utils.ExceptionUtil;
import com.lvmama.vst.comm.vo.ResultHandleT;

@Service
public class PackageProductAdapterImpl implements PackageProductAdapter {

    private static final Logger logger = LoggerFactory.getLogger(PackageProductAdapterImpl.class);
    
    @Autowired
    private VstSearchInterfaceWrapper prodProductClientService;
    @Autowired
    private VstRouteService vstRouteService;
    @Autowired
    private ProdProductPropClientService prodProductPropClientService;
    
    @Override
    public FitSdpProductBasicInfoDto getPackageProductBasicInfo(Long productId) {
        ProdProductParam param = this.genProductParam();
        ResultHandleT<ProdProduct> resultHandleT = prodProductClientService.findLineProductByProductId(productId, param);
        if (resultHandleT==null || resultHandleT.hasNull()) {
        	 throw new ExceptionWrapper(ExceptionCode.GET_NO_SDP_PRODUCT, productId);
        }
        ProdProduct product = resultHandleT.getReturnContent();
        return this.getBasicInfo(product);
    }
    
    public List<List<String>> getProdLineRouteList(Long productId) {
        // 线路概况
        com.lvmama.vst.api.vo.ResultHandleT<ArrayList<ProdLineRouteVo>> handleT = vstRouteService.findCacheLineRouteListByProductId(productId);
        if (CollectionUtils.isEmpty(handleT.getReturnContent())) {
            logger.info("未查询到线路概况信息!");
            return null;
        }
        try {
        	if(logger.isInfoEnabled()){
        		logger.info("从VST得到的线路概况信息：" + JSONMapper.getInstance().writeValueAsString(handleT.getReturnContent()));
        	}
        } catch (Exception e) {
            logger.error(e.getMessage());;
        }
        ArrayList<ProdLineRouteVo> routes = handleT.getReturnContent();
        //行程概要
        List<List<String>> routeInfo = buildRouteSurvey(routes.get(0));
        return routeInfo;
    }
    
    private List<List<String>> buildRouteSurvey(ProdLineRouteVo prodLineRoute) {
        List<List<String>> dayLists = new ArrayList<List<String>>();
        //用于判断是否行程中每天都没有线路概况（景点+线路）,如果是 则清空列表(判断hasSurverFlag是否大于0)
        int hasSurverFlag  = 0;
        if(prodLineRoute != null){
            List<ProdLineRouteDetailVo> details = prodLineRoute.getProdLineRouteDetailVoList();
            if(CollectionUtils.isNotEmpty(details)){
                for(ProdLineRouteDetailVo detail: details) {
                    List<ProdRouteDetailGroupVo> groups = detail.getProdRouteDetailGroupList();
                    List<ProdRouteDetailGroupVo> sortGroups = new ArrayList<ProdRouteDetailGroupVo>();
                    if(CollectionUtils.isNotEmpty(groups)){
                        for(ProdRouteDetailGroupVo group : groups){
                            String moduleType = group.getModuleType();
                            if(ProdRouteDetailGroup.MODULE_TYPE.SCENIC.getCode().equalsIgnoreCase(moduleType) || 
                                    ProdRouteDetailGroup.MODULE_TYPE.FREE_ACTIVITY.getCode().equalsIgnoreCase(moduleType)){
                                sortGroups.add(group);
                            }
                        }
                        if(CollectionUtils.isNotEmpty(sortGroups)){
                            List<ProdRouteDetailGroupVo> wantSorts = sortFilterGroup(sortGroups);
                            List<String> listStr = buildRouteList(wantSorts);
                            dayLists.add(listStr);
                            hasSurverFlag++;
                        }else{
                            List<String> notGroupList = new ArrayList<String>();
                            String title = detail.getTitle();
                            title = title.length()<=15?title:(title.substring(0, 14)+"...");
                            notGroupList.add(title);
                            dayLists.add(notGroupList);
                        }
                    }
                }
            }   
        }
        //如果每一天都没有线路概况则清空
        if(hasSurverFlag<=0){
            dayLists.clear();
        }
        return dayLists;
    }
    
    /**
     * ProdRouteDetailGroup 模块排序 ，并过滤掉自由活动连续的自由活动
     * 
     * */
    private  List<ProdRouteDetailGroupVo> sortFilterGroup(List<ProdRouteDetailGroupVo> groups) {
        Collections.sort(groups, new Comparator<ProdRouteDetailGroupVo>() {
            @Override
            public int compare(ProdRouteDetailGroupVo o1, ProdRouteDetailGroupVo o2) {
                if(o1.getSortValue() > o2.getSortValue()){
                    return 1;
                }
                return -1;
            }
        });
        //过滤掉连续挨着的自由活动
        boolean lastIsActivity = false;
        List<ProdRouteDetailGroupVo> resultGroups = new ArrayList<ProdRouteDetailGroupVo>();
        for(ProdRouteDetailGroupVo group: groups) {
            String moduleType = group.getModuleType();
            if(ProdRouteDetailGroup.MODULE_TYPE.FREE_ACTIVITY.getCode().equalsIgnoreCase(moduleType)){
                if(lastIsActivity == false){//上一个group 不为自由活动
                    lastIsActivity = true;
                }else{
                    continue;
                }
            }else{
                lastIsActivity = false;
            }
            resultGroups.add(group);
        }
        return resultGroups;
    }
    
    /**
     * 构建前台详情页展示的产品线路概况数据(行程+自由活动)
     * */
    private  List<String> buildRouteList(List<ProdRouteDetailGroupVo> groups){
        List<String> strs = new ArrayList<String>();
        boolean lastIsScenic = false;
        String lastOne = "";
        Long lastGroupId = 0L;
        for(ProdRouteDetailGroupVo group : groups){
            
            String moduleType = group.getModuleType();
            if(ProdRouteDetailGroup.MODULE_TYPE.SCENIC.getCode().equalsIgnoreCase(moduleType)){
                List<ProdRouteDetailScenicVo> scenics = group.getProdRouteDetailScenicList();
                Collections.sort(scenics, new Comparator<ProdRouteDetailScenicVo>() {
                    @Override
                    public int compare(ProdRouteDetailScenicVo o1, ProdRouteDetailScenicVo o2) {
                        if (o1.getScenicId() > o2.getScenicId()) {
                            return 1;
                        }
                        return -1;
                    }
                });
                
                for(ProdRouteDetailScenicVo scenic: scenics){
                    StringBuffer sb = new StringBuffer();
                    if(lastGroupId.intValue() == group.getGroupId().intValue() && lastIsScenic ){
                        String logicRelation = scenic.getLogicRelateion();
                        if(StringUtils.isNotBlank(logicRelation)){
                            //如果是或 并且是当前group 且是景点  则拼接最后一 个元素（或）景点名 
                            if(logicRelation.equals("OR")){
                                if(!strs.isEmpty()){
                                    lastOne = strs.get(strs.size()-1);
                                    sb.append(lastOne);
                                    sb.append("（或）");
                                    sb.append(scenic.getScenicName());
                                    strs.set(strs.size()-1, sb.toString()); 
                                    continue;
                                }
                            }
                        }
                    }
                    
                    sb.append(scenic.getScenicName());
                    strs.add(sb.toString());
                    lastIsScenic = true;
                    lastGroupId =  group.getGroupId();
                }
            }
            
            if(ProdRouteDetailGroup.MODULE_TYPE.FREE_ACTIVITY.getCode().equalsIgnoreCase(moduleType)){
                List<ProdRouteDetailActivityVo> activitys = group.getProdRouteDetailActivityList();
                if(CollectionUtils.isNotEmpty(activitys)){
                    strs.add("自由活动");
                    lastOne = "自由活动";
                    lastIsScenic = false;
                }
            }
        }
        return strs;
    }
    
    /**
     * 添加一个最简单的返回产品基本信息的方法.
     * @param product
     * @return
     */
    private FitSdpProductBasicInfoDto getBasicInfoSimple(ProdProduct product) {
        FitSdpProductBasicInfoDto basicInfoDto = new FitSdpProductBasicInfoDto();
        basicInfoDto.setProductId(product.getProductId());
        basicInfoDto.setAttributionId(product.getAttributionId());
        basicInfoDto.setProductName(product.getProductName());
        basicInfoDto.setBizCategoryId(product.getBizCategoryId());
        basicInfoDto.setRecommendLevel(product.getRecommendLevel());
        basicInfoDto.setProductType(product.getProductType());
        basicInfoDto.setPackageType(product.getPackageType());
        return basicInfoDto;
    }

    private FitSdpProductBasicInfoDto getBasicInfo(ProdProduct product) {
        FitSdpProductBasicInfoDto basicInfoDto = new FitSdpProductBasicInfoDto();
        basicInfoDto.setProductId(product.getProductId());
        basicInfoDto.setAttributionId(product.getAttributionId());
        basicInfoDto.setProductName(product.getProductName());
        basicInfoDto.setBizCategoryId(product.getBizCategoryId());
        basicInfoDto.setRecommendLevel(product.getRecommendLevel());
        basicInfoDto.setProductType(product.getProductType());
        basicInfoDto.setPackageType(product.getPackageType());
        try {
            com.lvmama.vst.comm.vo.ResultHandleT<ProdProductNameVO> productNameVOResultHandleT
                 = prodProductClientService.findProdProductNameVOByProductId(product.getProductId());
            if (productNameVOResultHandleT!=null && !productNameVOResultHandleT.hasNull()) {
                String productShowName = productNameVOResultHandleT.getReturnContent().getMainTitle()+","+productNameVOResultHandleT.getReturnContent().getSubTitle();
                basicInfoDto.setProductShowName(productShowName);
            }
        } catch (Exception e) {
           logger.error(e.getMessage(),e);
        }

        if(CollectionUtils.isNotEmpty(product.getProdLineRouteList())){
        	basicInfoDto.setLineRouteId(product.getProdLineRouteList().get(0).getLineRouteId());
        }
        
        // 设置景点图片
        StringBuffer photoUrls = new StringBuffer();
        if (CollectionUtils.isNotEmpty(product.getComPhotoList())) {
        	List<ComPhoto> comPhotos = product.getComPhotoList();
        	if(CollectionUtils.isNotEmpty(comPhotos)){
        		Collections.sort(comPhotos,new Comparator<ComPhoto>() {
    				@Override
    				public int compare(ComPhoto o1,ComPhoto o2) {
    					if (o2.getPhotoSeq().compareTo(o1.getPhotoSeq()) <0) {  
                            return 1;  
                        } else if (o2.getPhotoSeq().equals(o1.getPhotoSeq())) {  
                            return 0;  
                        } else {  
                            return -1;  
                        }
    				}
    			});
        		basicInfoDto.setPhotoUrl(comPhotos.get(0).getPhotoUrl());
            	basicInfoDto.setPhotoContent(comPhotos.get(0).getPhotoContent());
                for (ComPhoto photo : comPhotos) {
                    photoUrls.append(photo.getPhotoUrl());
                    photoUrls.append(",");
                }
        	}
        }
        basicInfoDto.setPhotoUrls(photoUrls.toString());
     
        
        FitSdpProductAdditionalInfoDto additonal = new FitSdpProductAdditionalInfoDto();
        // 交通往返信息
        ProdTraffic prodTraffic = product.getProdTraffic();
        if(prodTraffic != null){
            String toTraffic = prodTraffic.getToType();
            String backTraffic = prodTraffic.getBackType();
            if(toTraffic != null){
                toTraffic = "去程"+"-"+ProdTraffic.TRAFFICTYPE.getCnName(toTraffic);
                additonal.setToTraffic(toTraffic);
            }
            if(backTraffic != null){
                backTraffic = "返程"+"-"+ProdTraffic.TRAFFICTYPE.getCnName(backTraffic);
                additonal.setBackTraffic(backTraffic);
            }
        }
        // 如果为单出发地，设置默认出发地
        if (product.getMuiltDpartureFlag().equals(JudgeType.N.name())) {
            BizDistrict bizDistrict = product.getBizDistrict();
            FitSdpCityGroupDto defCityGroup = new FitSdpCityGroupDto();
            defCityGroup.setDepartureCityDistrictId(bizDistrict.getDistrictId());
            defCityGroup.setDepartureCityName(bizDistrict.getDistrictName());
            defCityGroup.setDepartureCityShortPinYin(bizDistrict.getShortPinyin());
            basicInfoDto.setDefDeparture(defCityGroup);
        }
        // 目的地
        List<FitSdpDestDto> destinations = new ArrayList<FitSdpDestDto>();
        List<ProdDestRe> prodDestReList = product.getProdDestReList();
        if (CollectionUtils.isNotEmpty(prodDestReList)) {
            for (ProdDestRe prodDestRe : prodDestReList) {
                FitSdpDestDto destination = new FitSdpDestDto();
                destination.setDistricId(prodDestRe.getDestrictId());
                destination.setDistrictName(prodDestRe.getDestName());
                destination.setDestId(prodDestRe.getDestId().toString());
                destination.setDestType(prodDestRe.getDestTypeCode());
                destination.setDestName(prodDestRe.getDestName());
                destination.setEnName(prodDestRe.getEnName());
                destination.setPinyin(prodDestRe.getPinyin());
                destination.setShortPinyin(ShortPinYinUtil.getAllFirstLetter(destination.getDestName()));
                destinations.add(destination);
            }
        }
        additonal.setDestination(destinations);
        // 包含项目
        try {
            StringBuffer containedItems = new StringBuffer();
            Map<String, Object> propValueMap = product.getPropValue();
            List<PropValue> propValueList = null;
            if(product.getBizCategoryId()==17L || product.getBizCategoryId()==18L){
                propValueList = (List<PropValue>)propValueMap.get("combo_contained");
            }else {
                propValueList = (List<PropValue>)propValueMap.get("contained_item");
            }
            if(propValueList != null && propValueList.size() > 0){
                for(PropValue propValue : propValueList) {
                    containedItems.append(propValue.getName()).append("、");
                }
            }
            if (StringUtils.isNotBlank(containedItems.toString())) {
                // 去掉字符串末尾的"、"号
                String str = containedItems.toString().substring(0, containedItems.toString().length() - 1);
                additonal.setContainItems(str);
            }
        } catch (Exception e) {
            logger.error("包含项目获取失败：" + e);
        }
      
        Map<String, Object> propValue = product.getPropValue();
       
        //是否自动打包交通、是否使用被打包产品的行程明细、是否使用被打包产品的费用说明、被打包产品Id(自主打包附加字段)
        basicInfoDto.setPackageTrafficFlag(propValue.get("auto_pack_traffic") == null? null : JudgeType.valueOf(propValue.get("auto_pack_traffic").toString()));
        //设置是否非对接优先标志.用于判断是否查询包机切位.如果是，就展示包机切位机票，否则就展示最低机票.
        basicInfoDto.setPackCharterFlightFlag(propValue.get("pack_traffic_flag") == null? null : JudgeType.valueOf(propValue.get("pack_traffic_flag").toString()));
        basicInfoDto.setRouteDetailUseFlag(propValue.get("isuse_packed_route_details") == null? null : JudgeType.valueOf(propValue.get("isuse_packed_route_details").toString()));
        basicInfoDto.setFeeExplainUseFlag(propValue.get("isuse_packed_cost_explanation") == null? null : JudgeType.valueOf(propValue.get("isuse_packed_cost_explanation").toString()));
        basicInfoDto.setPackagedProductId(propValue.get("packed_product_id") == null? null : Long.valueOf(propValue.get("packed_product_id").toString()));
        
        // 产品经理推荐信息
        additonal.setPmRecommendInfo(propValue.get("recommend") == null? null : propValue.get("recommend").toString());
        basicInfoDto.setAdditionalInfoDto(additonal);
        // 设置品类CODE和产品经理ID供查询额外信息使用
        if (product.getBizCategory() != null) {
            basicInfoDto.setCategoryCode(product.getBizCategory().getCategoryCode());
        }
        basicInfoDto.setManagerId(product.getManagerId());
        // 成人数和儿童数
        basicInfoDto.setAdultQuantity(product.getBaseAdultQuantity());
        basicInfoDto.setChildQuantity(product.getBaseChildQuantity());
        // 是否多出发地
        if (product.getMuiltDpartureFlag() != null) {
            basicInfoDto.setMuiltDpartureFlag(JudgeType.valueOf(product.getMuiltDpartureFlag()));
        }
        // 产品审核状态
        if (StringUtils.isNotBlank(product.getAuditStatus())) {
            basicInfoDto.setAuditType(ProductAuditType.valueOf(product.getAuditStatus()));
        }
        // 是否有效
        if (StringUtils.isNotBlank(product.getCancelFlag())) {
            basicInfoDto.setCancelFlag(JudgeType.valueOf(product.getCancelFlag()));
        }
        // 是否可售
        if (StringUtils.isNotBlank(product.getSaleFlag())) {
            basicInfoDto.setSaleFlag(JudgeType.valueOf(product.getSaleFlag()));
        }
        //行程天数, 入住天数
        if (CollectionUtils.isNotEmpty(product.getProdLineRouteList())) {
            ProdLineRouteVO routeVO = product.getProdLineRouteList().get(0);
            basicInfoDto.setRouteNum(routeVO.getRouteNum().intValue());
            basicInfoDto.setStayNum(routeVO.getStayNum().intValue());
        }
        // 是否含有酒店套餐
        if (StringUtils.isNotBlank(product.getHotelCombFlag())) {
            basicInfoDto.setHomeComboFlag(JudgeType.valueOf(product.getHotelCombFlag()));
        }
        // 儿童价说明
        Object obj = null;
		try {
			obj = product.getProp("child_price_desc");
		} catch (Exception e1) {
		}
        String childPriceDesc = null;
        if(null != obj && obj instanceof String){
            childPriceDesc = (String) obj;
        }
        basicInfoDto.setChildPriceDesc(childPriceDesc);
        // 线路概况
        try {
            Long key = null;
            if (basicInfoDto.getRouteDetailUseFlag().equals(JudgeType.Y)) {
                key = basicInfoDto.getPackagedProductId();
            } else {
                key = product.getProductId();
            }
            List<List<String>> routeList = getProdLineRouteList(key);
            basicInfoDto.setRouteList(routeList);
        } catch (Exception e) {
            logger.error("获取线路概况失败：" + ExceptionUtil.getExceptionDetails(e));
        }
        
        return basicInfoDto;
    }

    private ProdProductParam genProductParam() {
        ProdProductParam param = new ProdProductParam();
        param.setActivity(true);
        param.setComPhoto(true);
        param.setFeature(true);
        param.setViewSpot(true);
        param.setServiceRe(true);
        param.setHotelCombFlag(true);//用来判断酒店套餐，如果没有，不进行判断
        param.setLineRoute(true);//加载行程的东西
        param.setDest(true);
        param.setBizDistrict(true);
        param.setTraffic(true);
        param.setAddtion(true);
        param.setProdEcontract(true);
        param.setProdGroup(true);//产品关联
        param.setBizDistrictId(null);//出发地ID，多出发地使用
        return param;
    }
    
    public JudgeType getProdProductProp(Long productId) {
        ResultHandleT<ProdProductProp> resultHandleT = prodProductPropClientService.findProdProductPropById(productId);
        if (resultHandleT.hasNull()) {
            logger.error("未获得产品属性!");
            return JudgeType.N;
        }
        ProdProductProp prop =resultHandleT.getReturnContent();
        if(StringUtils.isNotBlank(prop.getPropValue()) && prop.getPropValue().equals(JudgeType.Y.name())){
            return JudgeType.Y;
        }
        return JudgeType.N;
    }

	@Override
	public FitSdpProductBasicInfoDto getPackageProductSimpleInfo(Long productId) {
		ProdProductParam param = this.genProductParam();
        ResultHandleT<ProdProduct> resultHandleT = prodProductClientService.findLineProductByProductId(productId, param);
        if (resultHandleT==null || resultHandleT.hasNull()) {
        	 throw new ExceptionWrapper(ExceptionCode.GET_NO_SDP_PRODUCT, productId);
        }
        ProdProduct product = resultHandleT.getReturnContent();
        return this.getBasicInfoSimple(product);
	}
}
