package com.lvmama.lvfit.adapter.search.adapter.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.adapter.search.adapter.PackageGoodsAdapter;
import com.lvmama.lvfit.adapter.search.adapter.VstSearchInterfaceWrapper;
import com.lvmama.lvfit.common.aspect.exception.ExceptionPoint;
import com.lvmama.lvfit.common.client.FitSearchClient;
import com.lvmama.lvfit.common.dto.enums.BizEnum;
import com.lvmama.lvfit.common.dto.enums.FitBusinessExceptionType;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpAdditonalDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelComboGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelGroupDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelRoomtypeDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelTimePriceDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpInsuranceDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpLocalTripProductDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpOtherTicketDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpRoomDiff;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpGoodsRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.vst.api.route.prod.vo.ProdLineRouteVo;
import com.lvmama.vst.api.route.prod.vo.RouteProductVo;
import com.lvmama.vst.api.vo.ResultHandleT;
import com.lvmama.vst.api.vo.prod.GoodsBaseVo;
import com.lvmama.vst.api.vo.prod.ProdPackageDetailVo;
import com.lvmama.vst.api.vo.prod.ProdPackageGroupLineVo;
import com.lvmama.vst.api.vo.prod.ProdPackageGroupVo;
import com.lvmama.vst.api.vo.prod.ProdProductBranchPropBaseVo;
import com.lvmama.vst.api.vo.prod.ProdProductPropBaseVo;
import com.lvmama.vst.api.vo.prod.ProductBaseVo;
import com.lvmama.vst.api.vo.prod.ProductBranchBaseVo;
import com.lvmama.vst.api.vo.prod.SuppGoodsBaseTimePriceVo;
import com.lvmama.vst.api.vo.prod.SuppGoodsSaleReVo;

@Service
public class PackageGoodsAdapterImpl implements PackageGoodsAdapter {

    private static final Logger logger = LoggerFactory.getLogger(PackageGoodsAdapterImpl.class);
    
    @Autowired
    private VstSearchInterfaceWrapper vstRouteService;
     
    
    @Override
    @ExceptionPoint(FitBusinessExceptionType.FIT_SDP_SEARCH_GOODS_E)
    public FitSdpGoodsDto getVstPackageGoodsInfo(FitSdpGoodsRequest req) {
    	
    	Long startDistrictId = null;
		if(req.getIsMuiltDeparture() != null && req.getIsMuiltDeparture().equals("Y")){
		    startDistrictId = req.getStartDistrictId();
		}
        ResultHandleT<RouteProductVo> returnT = vstRouteService.findOnSaleGoodsByParam(req.getProductId(), req.getDepartDate(), req.getAdultQuantity(), req.getChildQuantity(), req.getDistributorId(), startDistrictId, req.getQuantity());
        if (returnT==null || returnT.getReturnContent() == null) {
        	return null;
        }
        RouteProductVo routeProductVo = returnT.getReturnContent();
        FitSdpGoodsDto pakgGoods = new FitSdpGoodsDto();
        //成人数
        Long adult = req.getAdultQuantity();//routeProductVo.getBaseAdultQuantity();
        //小孩数
        Long child = req.getChildQuantity();//routeProductVo.getBaseChildQuantity();
        List<ProdPackageGroupVo> packageGroupVoList = routeProductVo.getProdPackageGroupVoList();
        //得到被打包产品id        
        Long packedCatId = req.getPackagedProdCatId();
        List<FitSdpHotelGroupDto> allHotelGroups = new LinkedList<FitSdpHotelGroupDto>();
        if (CollectionUtils.isNotEmpty(packageGroupVoList)) {
        	for(ProdPackageGroupVo groupVo:packageGroupVoList){ 
	            if (groupVo.getCategoryId().equals(BizEnum.BIZ_CATEGORY_TYPE.category_route_hotelcomb.getCategoryId())) {
	                // 酒店套餐以前的方式，不用计算份数，传来的多少分就是多少分
	            	if(packedCatId.equals(BizEnum.BIZ_CATEGORY_TYPE.category_route_hotelcomb.getCategoryId())){ 
	            		pakgGoods.setHotelCombo(this.getHotelComboInfo(groupVo, req.getDepartDate(), req.getQuantity(),-1L));
	            	}
	            	//按照人数计算份数.
	            	else{ 
	            		pakgGoods.setHotelCombo(this.getHotelComboInfo(groupVo, req.getDepartDate(), adult,child));
	            	}
	             }
	            
	            //查询酒店信息(非套餐)
	            if (groupVo.getCategoryId().equals(BizEnum.BIZ_CATEGORY_TYPE.category_hotel.getCategoryId())) {
                    // 酒店信息
                    FitSdpHotelGroupDto group = getHotelGroupInfo(groupVo, req.getDepartDate(),adult,child);
                    if (group != null) {
                        allHotelGroups.add(group);
                    }
	            }
	            
	            if (groupVo.getCategoryId().equals(BizEnum.BIZ_CATEGORY_TYPE.category_route_local.getCategoryId())) {
	                // 当地游
	                pakgGoods.setLocalTrip(this.getLocalInfo(groupVo, req.getDepartDate()));
	            }
	           
	            // 可选服务信息
	            FitSdpAdditonalDto additional = getAdditionalInfo(routeProductVo, pakgGoods, req.getDepartDate());
	            pakgGoods.setAdditional(additional);
        	}
        	
        	//如果有酒店信息就添加到酒店分组列表.
        	if(CollectionUtils.isNotEmpty(allHotelGroups)){
        		pakgGoods.setHotelInfos(allHotelGroups);
        	}
        }
        return pakgGoods;
    }
 
    private FitSdpAdditonalDto getAdditionalInfo(RouteProductVo pkTourProductVo, FitSdpGoodsDto pakgGoods, Date depDate) {
        // 行程天数
        ProdLineRouteVo lineRouteVo = pkTourProductVo.getProdLineRouteVo();
        Short routeNum = lineRouteVo.getRouteNum();
        
        // 保险和其他门票
        FitSdpAdditonalDto additional = new FitSdpAdditonalDto();
        List<SuppGoodsSaleReVo> suppGoodsSaleReList = pkTourProductVo.getSuppGoodsSaleReVoList();
        if (CollectionUtils.isNotEmpty(suppGoodsSaleReList)) {
            List<FitSdpOtherTicketDto> otherTickets = new ArrayList<FitSdpOtherTicketDto>();
            List<FitSdpInsuranceDto> insurances = new ArrayList<FitSdpInsuranceDto>();
            String selectDate = DateUtils.formatDate(depDate, "yyyy-MM-dd");
            for (SuppGoodsSaleReVo suppGoodsSaleRe : suppGoodsSaleReList) {
                // 处理门票信息
                if (CollectionUtils.isNotEmpty(suppGoodsSaleRe.getGoodsVOList())) {
                    GoodsBaseVo baseVo = suppGoodsSaleRe.getGoodsVOList().get(0);
                    if (baseVo.getCategoryId().equals(BizEnum.BIZ_CATEGORY_TYPE.category_other_ticket.getCategoryId())) {
                        FitSdpOtherTicketDto otherTicketInfo = this.getOtherTicketInfo(suppGoodsSaleRe, selectDate);
                        if (otherTicketInfo != null) {
                            otherTickets.add(otherTicketInfo);
                        }
                        continue;
                    }
                    // 处理保险信息
                    if (baseVo.getCategoryId().equals(BizEnum.BIZ_CATEGORY_TYPE.category_insurance.getCategoryId())) {
                        List<FitSdpInsuranceDto> insuranceInfo = this.getInsuranceInfo(suppGoodsSaleRe.getGoodsVOList(), selectDate, routeNum);
                        if (CollectionUtils.isNotEmpty(insuranceInfo)) {
                            insurances.addAll(insuranceInfo);
                        }
                        continue;
                    }
                }
            }
            additional.setOtherTicketDto(otherTickets);
            additional.setInsuranceDto(insurances);
        }
        // 房差
        if (pakgGoods.getLocalTrip() != null) {
            BigDecimal roomDiffPrice = pakgGoods.getLocalTrip().getRoomDiffPrice();
            FitSdpRoomDiff roomDiff = new FitSdpRoomDiff();
            roomDiff.setRoomDiffPrice(roomDiffPrice);
            additional.setRoomDiff(roomDiff);
        }
        return additional;
    }
    
     
    private List<FitSdpInsuranceDto> getInsuranceInfo(List<GoodsBaseVo> baseVoList, String selectDate, int routNum) {
        List<FitSdpInsuranceDto> insurances = new ArrayList<FitSdpInsuranceDto>();
        baseVoList = this.filterLessDayInsurance(baseVoList, routNum);
        // 保险只取最近的团期
        int remainDay = this.getRemainDay(baseVoList);
        
        for (GoodsBaseVo baseVo : baseVoList) {
            ProductBaseVo productBaseVo = baseVo.getProductBaseVo();
            
            List<ProdProductPropBaseVo> propList = productBaseVo.getProductPropList();
            if (CollectionUtils.isEmpty(propList) || propList.size() != 2) {
                continue;
            }
            int dayOfInsurance = 0;
            for (ProdProductPropBaseVo prodProductPropBaseVo : propList) {
                if (prodProductPropBaseVo.getCode().equals("days_of_insurance")) {
                    if (StringUtils.isNotEmpty(prodProductPropBaseVo.getValue())) {
                        dayOfInsurance = Integer.valueOf(prodProductPropBaseVo.getValue());
                    }
                }
            }
            
            if (dayOfInsurance > remainDay) {
                continue;
            }
            
            FitSdpInsuranceDto insurance = new FitSdpInsuranceDto();
            insurance.setProductId(productBaseVo.getProductId());
            insurance.setProductName(productBaseVo.getProductName());
            insurance.setGoodsName(baseVo.getGoodsName());
            insurance.setSuppGoodsId(baseVo.getSuppGoodsId());
            insurance.setMinQuantity(baseVo.getMinQuantity());
            insurance.setMaxQuantity(baseVo.getMaxQuantity());
            
            ProductBranchBaseVo prodProductBranch = baseVo.getProductBranchBaseVo();
            insurance.setBranchId(prodProductBranch.getBranchId());
            insurance.setBranchName(prodProductBranch.getBranchName());
            if (prodProductBranch.getPropValue() != null 
                    && prodProductBranch.getPropValue().get("branch_desc") != null) {
                insurance.setBranchDesc(prodProductBranch.getPropValue().get("branch_desc").toString());
            }

            Map<String, Long> priceMap = baseVo.getSelectPriceMap();
            Long price = priceMap.get(selectDate);
            if (price != null) {
                BigDecimal priceBig = BigDecimal.valueOf(price);
                insurance.setPrice(priceBig.divide(BigDecimal.valueOf(100)));
            }
            // 产品推荐级别
            insurance.setProRecommendLvl(productBaseVo.getRecommendLevel().intValue());
            // 商品推荐级别
            insurance.setBranchRecommendLvl(prodProductBranch.getRecommendLevel().intValue());
            // 产品类型
            insurance.setProductType(productBaseVo.getProductType());
            
            insurances.add(insurance);
        }
        return insurances;
    }
    // 过滤保险天数小于团期的保险
    private List<GoodsBaseVo> filterLessDayInsurance(List<GoodsBaseVo> baseVoList, int routeNum) {
        List<GoodsBaseVo> returnList = new ArrayList<GoodsBaseVo>();
        for (GoodsBaseVo baseVo : baseVoList) {
            ProductBaseVo productBaseVo = baseVo.getProductBaseVo();
            
            List<ProdProductPropBaseVo> propList = productBaseVo.getProductPropList();
            if (CollectionUtils.isEmpty(propList) || propList.size() != 2) {
                continue;
            }
            
            for (ProdProductPropBaseVo prodProductPropBaseVo : propList) {
                if (prodProductPropBaseVo.getCode().equals("days_of_insurance")) {
                    if (StringUtils.isNotEmpty(prodProductPropBaseVo.getValue())) {
                        int dayOfInsurance = Integer.valueOf(prodProductPropBaseVo.getValue());
                        if (dayOfInsurance >= routeNum) {
                            returnList.add(baseVo);
                        }
                    }
                }
            }
        }
        return returnList;
    }
    
    // 取得离团期最近的保险天数
    private int getRemainDay(List<GoodsBaseVo> baseVoList) {
        int remainDay = 0;
        for (GoodsBaseVo baseVo : baseVoList) {
            ProductBaseVo productBaseVo = baseVo.getProductBaseVo();
            
            List<ProdProductPropBaseVo> propList = productBaseVo.getProductPropList();
            if (CollectionUtils.isEmpty(propList) || propList.size() != 2) {
                continue;
            }
            
            for (ProdProductPropBaseVo prodProductPropBaseVo : propList) {
                if (prodProductPropBaseVo.getCode().equals("days_of_insurance")) {
                    if (StringUtils.isNotEmpty(prodProductPropBaseVo.getValue())) {
                        int dayOfInsurance = Integer.valueOf(prodProductPropBaseVo.getValue());
                        if (remainDay == 0 || dayOfInsurance < remainDay) {
                            remainDay = dayOfInsurance;
                        } 
                    }
                }
            }
        }
        return remainDay;
    }

    private FitSdpOtherTicketDto getOtherTicketInfo(SuppGoodsSaleReVo suppGoodsVo, String selectDate) {
        ProductBaseVo reProduct = suppGoodsVo.getReProduct();
        GoodsBaseVo baseVo = suppGoodsVo.getGoodsVOList().get(0);
        
        FitSdpOtherTicketDto ticketDto = new FitSdpOtherTicketDto();
        ticketDto.setProductId(reProduct.getProductId());
        ticketDto.setProductName(reProduct.getProductName());
        
        ticketDto.setSuppGoodsId(baseVo.getSuppGoodsId());
        ticketDto.setGoodsName(baseVo.getGoodsName());
        ticketDto.setMinQuantity(baseVo.getMinQuantity());
        ticketDto.setMaxQuantity(baseVo.getMaxQuantity());
        Map<String, Long> selectPriceMap = baseVo.getSelectPriceMap();
        Map<String, BigDecimal> newPriceMap = new TreeMap<String, BigDecimal>();
        for (String key : selectPriceMap.keySet()) {
            Long priceLongVal = selectPriceMap.get(key);
            BigDecimal priceBig = new BigDecimal(priceLongVal.toString());
            BigDecimal temp = priceBig.divide(BigDecimal.valueOf(100));
            newPriceMap.put(key, temp);
        }
        ticketDto.setPriceMap(newPriceMap);
        ticketDto.setDefaultSelectPrice(ticketDto.getPriceMap().get(selectDate));

        return ticketDto;
    }
    
    private FitSdpLocalTripProductDto getLocalInfo(ProdPackageGroupVo pkGroup, Date specDate) {

        ProdPackageGroupLineVo prodPackageGroupLine = pkGroup.getProdPackageGroupLineVo();
        
        String dayOfDuration = prodPackageGroupLine.getStartDay();//出发时间，出发的第几天
        Long travelDays = prodPackageGroupLine.getTravelDays();//行程天数这个组占的行程天数
        Long stayDays = prodPackageGroupLine.getStayDays();//入住晚数，这个组点的入住晚数
        
        FitSdpLocalTripProductDto localTripProduct = new FitSdpLocalTripProductDto();

        localTripProduct.setTravelDays(travelDays);
        localTripProduct.setStayDays(stayDays);
        localTripProduct.setDayOfDuration(dayOfDuration);
        localTripProduct.setGroupName(pkGroup.getGroupName());
        Date visitDate = DateUtils.addDays(specDate, Long.valueOf(dayOfDuration).intValue() -1);
        
        if (CollectionUtils.isEmpty(pkGroup.getProdPackageDetails())) {
            return null;
        }
        
        ProductBaseVo prodProduct = pkGroup.getProdPackageDetails().get(0).getProductVo();
        localTripProduct.setProductId(prodProduct.getProductId());
        localTripProduct.setProductName(prodProduct.getProductName());
        localTripProduct.setVisitDate(visitDate);
        localTripProduct.setDetailId(pkGroup.getProdPackageDetails().get(0).getDetailId());
        List<ProductBranchBaseVo> productBranchList = pkGroup.getProdPackageDetails().get(0).getProductBranchList();
        if (CollectionUtils.isNotEmpty(productBranchList)) {
            // 房差
            ProductBranchBaseVo prodProductBranch = productBranchList.get(0);
            Map<String, Long> gapPriceMap = prodProductBranch.getSelectGapPriceMap();
            String key = DateUtils.formatDate(visitDate, "yyyy-MM-dd");
            Long dateLongVal = gapPriceMap.get(key);
            if (dateLongVal != null) {
                BigDecimal dateBig = new BigDecimal(dateLongVal.toString());
                BigDecimal temp = dateBig.divide(BigDecimal.valueOf(100));
                localTripProduct.setRoomDiffPrice(temp);
            }
            // 价格
            Long lowestPrice = prodProductBranch.getDailyLowestPrice();
            if (lowestPrice != null) {
                BigDecimal priceBig = new BigDecimal(lowestPrice.toString());
                BigDecimal priceTemp = priceBig.divide(BigDecimal.valueOf(100));
                localTripProduct.setPrice(priceTemp);
            }
            // 商品ID
            List<GoodsBaseVo> baseVoList = prodProductBranch.getGoodsBaseVoList();
            if (CollectionUtils.isNotEmpty(baseVoList)) {
                localTripProduct.setSuppGoodsId(baseVoList.get(0).getSuppGoodsId());
            }
        }

        return localTripProduct;
    }

    /**
     * 根据传输进来的儿童，成人进行计算份数.
     * @param hotelComboVo
     * @param specDate
     * @param adult
     * @param child
     * @return
     */
    private List<FitSdpHotelComboGoodsDto> getHotelComboInfo(ProdPackageGroupVo hotelComboVo ,Date specDate, Long adult,Long child) {
        if (hotelComboVo == null) {
            if (logger.isInfoEnabled()) {
            	logger.info("打包产品中没有酒店套餐产品信息!");
            }
            return null;
        }
        
        ProdPackageGroupLineVo prodPackageGroupLine = hotelComboVo.getProdPackageGroupLineVo();
        Long baseAdult = 2L;
        Long baseChild = 0L;
        
        String dayOfDuration = prodPackageGroupLine.getStartDay();//出发时间，出发的第几天
        Long travelDays = prodPackageGroupLine.getTravelDays();//行程天数这个组占的行程天数
        Long stayDays = prodPackageGroupLine.getStayDays();//入住晚数，这个组点的入住晚数
        Date date = DateUtils.addDays(specDate, Long.valueOf(dayOfDuration).intValue() -1);
        
        List<FitSdpHotelComboGoodsDto> hotelGoods = new ArrayList<FitSdpHotelComboGoodsDto>();
        
        if (CollectionUtils.isEmpty(hotelComboVo.getProdPackageDetails())) {
            return null;
        }
        
        for (ProdPackageDetailVo prodPackageDetail : hotelComboVo.getProdPackageDetails()) {
            FitSdpHotelComboGoodsDto hotelCombo = new FitSdpHotelComboGoodsDto();
            
            hotelCombo.setTravelDays(travelDays);
            hotelCombo.setStayDays(stayDays);
            hotelCombo.setStartDay(date);
            hotelCombo.setDayOfDuration(dayOfDuration);
            hotelCombo.setGroupName(hotelComboVo.getGroupName());
            
            hotelCombo.setProductId(prodPackageDetail.getProductVo().getProductId());
            hotelCombo.setProductName(prodPackageDetail.getProductVo().getProductName());
            hotelCombo.setDetailId(prodPackageDetail.getDetailId());
            
            if (CollectionUtils.isNotEmpty(prodPackageDetail.getProductBranchList())) {
                ProductBranchBaseVo prodProductBranch = prodPackageDetail.getProductBranchList().get(0);
                
                hotelCombo.setBranchId(prodProductBranch.getBranchId());
                hotelCombo.setBranchName(prodProductBranch.getBranchName());
                if (MapUtils.isNotEmpty(prodProductBranch.getPropValue())) {
                    String branch_desc = prodProductBranch.getPropValue().get("branch_desc").toString();
                    hotelCombo.setBranchDesc(branch_desc);
                }
                
                List<GoodsBaseVo> baseVoList = prodProductBranch.getRecommendBaseVoList();
                if (CollectionUtils.isNotEmpty(baseVoList)) {
                    GoodsBaseVo baseVo = baseVoList.get(0);
                    baseAdult = baseVo.getAdult();
                    baseChild = baseVo.getChild();
                    hotelCombo.setSuppGoodsId(baseVo.getSuppGoodsId());
                    BigDecimal lowestPrice = new BigDecimal(baseVo.getDailyLowestPrice().toString());
                    BigDecimal temp = lowestPrice.divide(BigDecimal.valueOf(100));
                    hotelCombo.setPrice(temp);
                }
            }
            
            //如果儿童数量小于0，说明是传入的份数，直接返回就可以了。
            if(child<0){ 
	            hotelCombo.setQuantity(adult);
            }else{
          	  	Long allIn = adult+child;
           		Long allBase = baseAdult+baseChild; 
            	 //公式：份数=选择总人数÷打包总人数 (规则1.打包总人数包括成人+儿童，2如有余数进1取整数)
	            hotelCombo.setQuantity(new Double(Math.ceil(allIn.doubleValue()/allBase.doubleValue())).longValue());
            }
            hotelGoods.add(hotelCombo);
        }
        
        return hotelGoods;
    } 
      
    private String getJsonStr(Object obj){
    	try {
			return JSONMapper.getInstance().writeValueAsString(obj);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
    	return null;
    } 
    
    public static void main(String[] args){
//	  	Long a = 0L;
//    	System.out.println(a==0);
//    	Long a = 4L;
//    	Long b = 2L;
//    	System.out.println(a+b/2);
//    	try {
//			String json = FileUtils.readFileToString(new File("d:\\productVO测试数据.txt"),"GBK");
//			 ObjectMapper objectMapper = JSONMapper.getInstance();
//			 objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
//			 HashMap returnT = objectMapper.readValue(json, new TypeReference<HashMap>() {});
//			 //propValue
//			 Map m = (Map)returnT.get("propValue");
//			 //star_rate
//			 List star_rate = (List)m.get("star_rate");
//			 System.out.println(((Map)(star_rate.get(0))).get("name")); 
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
    
    /**
     * 从ProductBaseVo中的propValue里面取出复合对象类型.
     * @param propValue
     * @param propName
     * @return
     */
    private Map getPropMap(Map propValue,String propName){
    	if(propValue!=null){
    		//下面是根据报文结构而来的.
    		List prop = (List)propValue.get(propName);
    		if(prop!=null){
    			return (Map)(prop.get(0));
    		}
    	}
    	return null;
    }
    /**
     * 自己解析json串得到里面的属性信息.
     * @param hotelBaseVo
     * @return
     */
    private Map getPropValue(ProductBaseVo hotelBaseVo){
		String json = getJsonStr(hotelBaseVo);
		ObjectMapper objectMapper = JSONMapper.getInstance();
		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS,
				true);
		HashMap returnT;
		try { 
			returnT = objectMapper.readValue(json, new TypeReference<HashMap>() {});
			Map m = (Map)returnT.get("propValue");
			return m;
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		} 
		return null;
    }
    
    /**
     * 将时间价格转换为map对象
     * @param timePrice
     * @return
     */
    private Map getTimePrice(SuppGoodsBaseTimePriceVo timePrice){
		String json = getJsonStr(timePrice);
		ObjectMapper objectMapper = JSONMapper.getInstance();
		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS,
				true);
		HashMap returnT;
		try { 
			returnT = objectMapper.readValue(json, new TypeReference<HashMap>() {}); 
			return returnT;
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		} 
		return null;
    }
    
    @Autowired
	private FitSearchClient fitSearchClient;
    
    private String getHotelImage(Long hotelId){
    	try{ 
			HotelQueryRequest hotelQueryRequest = new HotelQueryRequest();
			hotelQueryRequest.setQueryId(hotelId.toString());
			String url = fitSearchClient.searchHotelImage(hotelQueryRequest, null);
			return url; 
		}catch(Exception e){
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 解析vst接口得到酒店的相关信息
     * @param hotelVo
     * @param specDate 选择的日期 
     * @return
     */
    private FitSdpHotelGroupDto getHotelGroupInfo(ProdPackageGroupVo hotelVo ,Date specDate,Long adult,Long child ) { 
		if (hotelVo == null) {
			if (logger.isInfoEnabled()) {
				logger.info("打包产品中没有酒店产品信息!");
			}
			return null;
		} 
		 
		if (CollectionUtils.isEmpty(hotelVo.getProdPackageDetails())) {
			return null;
		}
 
		
		FitSdpHotelGroupDto groupDto = new FitSdpHotelGroupDto();    
		// 循环全部的房型信息
		if (CollectionUtils.isNotEmpty(hotelVo.getProdPackageDetails())){
			for (ProdPackageDetailVo prodPackageDetail : hotelVo.getProdPackageDetails()) {
				ProductBaseVo hotelBaseVo = prodPackageDetail.getProductVo();  
				
				//解析属性生产room对象
				Object[] ans  = setRoomAndHotel(hotelVo,specDate,prodPackageDetail,adult,child);
				
				FitSdpHotelRoomtypeDto room =(FitSdpHotelRoomtypeDto) ans[1];
				//得到对应的酒店信息
				FitSdpHotelDto hotel= (FitSdpHotelDto) ans[0];
				
				//自己写方法解析json串得到酒店相关属性信息.
				Map propValue = getPropValue(hotelBaseVo);
				if(propValue!=null){ 
					if(hotel.getAddress()==null){  
						hotel.setAddress(""+propValue.get("address"));
					}
					if(hotel.getDescription()==null){  
						hotel.setDescription(""+propValue.get("description"));
					} 
					//解析报文取到里面的早餐信息
					Map breakfast = getPropMap(propValue,"breakfast_price");
					if(breakfast!=null){
						hotel.setBreakfast(notNullString(breakfast.get("name")));
						hotel.setBreakfastAddValue(notNullString(breakfast.get("addValue")));
						
						room.setBreakfast(hotel.getBreakfast());
						room.setBreakfastAddValue(hotel.getBreakfastAddValue());
					}
				}
				//得到对应的酒店id.
				Long hotelId = hotel.getHotelId();
				//得到对应的分组信息.
				Long groupId = hotel.getGroupId(); 
				//设置酒店主图片.
				hotel.setHotelPhoto(getHotelImage(hotelId));
				//如果没有组名，就新建group，hotel，room
				if(groupDto.getGroupId()==null){ 
					//组装room列表
					LinkedList<FitSdpHotelRoomtypeDto> allRooms = new LinkedList<FitSdpHotelRoomtypeDto>();
					allRooms.add(room);
					hotel.setFangXinList(allRooms);
					
					//组装hotel列表
					LinkedList<FitSdpHotelDto> hotels = new LinkedList<FitSdpHotelDto>(); 
					hotels.add(hotel); 
					
					groupDto = new FitSdpHotelGroupDto();
					groupDto.setCheckIn(hotel.getCheckIn());
					groupDto.setCheckOut(hotel.getCheckOut()); 
					groupDto.setStayDays(hotel.getStayDays());
					groupDto.setTravelDays(hotel.getTravelDays());
					groupDto.setGroupId(groupId);
					groupDto.setHotels(hotels); 
				}else{
					//找到对应的group下面的hotel列表
					LinkedList<FitSdpHotelDto> hotels =groupDto.getHotels();
					
					FitSdpHotelDto _h = findHotelInList(hotels,hotelId); 
					
					//如果当前分组中没有对应的酒店,就添加到当前分组的酒店列表中..
					if(_h==null){
						//组装room列表
						LinkedList<FitSdpHotelRoomtypeDto> allRooms = new LinkedList<FitSdpHotelRoomtypeDto>();
						allRooms.add(room);
						hotel.setFangXinList(allRooms);
						
						hotels.add(hotel);
					}else{
						//如果当前分组中有对应的酒店，就直接添加room到指定hotel下面的room列表.
						LinkedList<FitSdpHotelRoomtypeDto> allRooms = _h.getFangXinList();
						allRooms.add(room);
					} 
				} 
			}
			
		} 
		
		if(groupDto!=null){
			logger.info("487...!"+JSON.toJSONString(groupDto));
		}
		return groupDto;
    }
     
    
    /**
     * 在group列表中查找对应的group.
     * @param groups
     * @param groupId
     * @return
     */
    private FitSdpHotelGroupDto findGroupInList(LinkedList<FitSdpHotelGroupDto> groups,Long groupId){ 
		Iterator<FitSdpHotelGroupDto> it = groups.iterator();
		while(it.hasNext()){
			FitSdpHotelGroupDto g = it.next();
			if(groupId.equals(g.getGroupId())){
				return g;
			}
		}
		return null;
    }
    
    /**
     * 查找list中的指定id的酒店
     * @param hotelGoods
     * @param hotelId
     * @return
     */
    private FitSdpHotelDto findHotelInList(LinkedList<FitSdpHotelDto> hotelGoods,Long hotelId){ 
		Iterator<FitSdpHotelDto> it = hotelGoods.iterator();
		while(it.hasNext()){
			FitSdpHotelDto hotel = it.next();
			if(hotelId.equals(hotel.getHotelId())){
				return hotel;
			}
		}
		return null;
    }
    
    /**
     * 价格除以100
     * @param num
     * @return
     */
    private BigDecimal divide100(Object num){ 
		if (num != null) {
			BigDecimal bigd = new BigDecimal(num.toString());
			BigDecimal temp = bigd.divide(BigDecimal.valueOf(100));
			return temp;
		}
		return null;
    }
    
    /**
     * 非空转换.
     * @param obj
     * @return
     */
    private String notNullString(Object obj){ 
		if (obj != null) {
			return obj.toString();
		}
		return null;
    }
    
    /**
     * 从入住的晚数例如"2,3,4"得到从第几晚开始入住
     * @param stayDays
     * @return
     */
    private String getStartDayStr(String stayDays){
    	if(stayDays!=null){
	    	String[] ds = stayDays.split(","); 
	    	int small = Integer.MAX_VALUE;
	    	for(String s:ds){
	    		int temp = Integer.parseInt(s);
	    		if(small>temp)
	    			small = temp;
	    	}
	    	return small+"";
    	}
    	//默认都是从第一晚开始住
    	return "1";
    }
      
    /**
     * 组装房型相关的属性信息
     * @param prodPackageDetail
     * @param room
     */
    private Object[] setRoomAndHotel(ProdPackageGroupVo hotelVo,Date specDate,ProdPackageDetailVo prodPackageDetail,Long adult,Long child){
    		Object[] ans = new Object[2];
    	    FitSdpHotelRoomtypeDto room = new FitSdpHotelRoomtypeDto();
			FitSdpHotelDto hotel = new FitSdpHotelDto(); 
			//团期：停留的夜数.
			hotel.setStayDays(hotelVo.getProdPackageGroupHotelVo().getStayDays());
			// 入住晚数，这个酒店的入住晚数 
			Long stayDays = Long.valueOf(hotel.getStayDays().split(",").length);
			hotel.setGroupId(hotelVo.getGroupId());
			hotel.setGroupName(hotelVo.getGroupName()); 
			hotel.setDayOfDuration(getStartDayStr(hotel.getStayDays())); 
			hotel.setStartDayStr(hotel.getStartDayStr()); 
			//停留几晚
			hotel.setStartDays(stayDays);
			//得到从第几个晚上开始入住
			Long startIn = Long.parseLong(hotel.getDayOfDuration());
			//计算得到入住的日期
			Date in = DateUtils.addDays(specDate,startIn.intValue() - 1);
			//入住日期
			hotel.setCheckIn(DateUtils.formatDate(in, DateUtils.YYYY_MM_DD));
			//退房日期,默认在入住之后一天			
			hotel.setCheckOut(DateUtils.formatDate(DateUtils.addDays(in,stayDays.intValue()), DateUtils.YYYY_MM_DD)); 
			
			ProductBaseVo productVo = prodPackageDetail.getProductVo();
			List<ProdProductPropBaseVo> allProdProps = productVo.getProductPropList();
			if (allProdProps != null) {
				for (ProdProductPropBaseVo p : allProdProps) { 
					// 设置地址
					if ("address".equals(p.getCode())) {
						hotel.setAddress(p.getValue());
					} 
				}
			} 
			//酒店id
			hotel.setHotelId(productVo.getProductId());
			//酒店名字
			hotel.setHotelName(productVo.getProductName());
			hotel.setProductId(productVo.getProductId());
			hotel.setProductName(productVo.getProductName());
			//酒店地址
			if(hotel.getAddress()==null){
				hotel.setAddress(productVo.getAddress());
			} 
			//酒店星级
			hotel.setStartRate(productVo.getStarRated());   
			//打包关系id
			room.setDetailId(prodPackageDetail.getDetailId());
			//分组id
			room.setGroupId(prodPackageDetail.getGroupId()); 
			hotel.setSaleFlag(productVo.getSaleFlag());
			hotel.setCancelFlag(productVo.getCancelFlag());
			hotel.setUrlId(productVo.getUrlId()); 
		    
			room.setTravelDays(hotel.getTravelDays());
			room.setStayDays(hotel.getStartDays().toString());
			room.setCheckIn(hotel.getCheckIn());
			room.setCheckOut(hotel.getCheckOut());
			// 得到打包情况里面的具体打包的规格信息
			if (CollectionUtils.isNotEmpty(prodPackageDetail
					.getProductBranchList())) {
				ProductBranchBaseVo prodProductBranch = prodPackageDetail
						.getProductBranchList().get(0); 
				//room里面保存酒店名字
				room.setHotelName(productVo.getProductName());
				//room里面保存一个酒店id.
				room.setHotelId(productVo.getProductId());
				//room 名称
				room.setRoomName(prodProductBranch.getBranchName());
				//room id
				room.setRoomId(prodProductBranch.getProductBranchId());
				//room是否可销售
				room.setSaleFlag(productVo.getSaleFlag()); 
				//room是否可以取消
				room.setCancelFlag(productVo.getCancelFlag());
				//最多人数
				room.setMaxVisitor(prodProductBranch.getMaxVisitor());  
				
				List<ProdProductBranchPropBaseVo> props = prodProductBranch
						.getProductBranchPropList();
				if (CollectionUtils.isNotEmpty(props)) {
					for (ProdProductBranchPropBaseVo p : props) {
						// 设置床类型
						if ("bed_type".equals(p.getCode())) {
							room.setBedType(p.getValue());
						}
						// 设置可以加床标志
						if ("add_bed_flag".equals(p.getCode())) {
							room.setAddBedFlag(p.getValue());
						}
						// 设置吸烟房
						if ("smokeless_room".equals(p.getCode())) {
							room.setSmokelessRoom(p.getValue());
						}
						// 设置是否有窗
						if ("window".equals(p.getCode())) {
							room.setWindow(p.getValue());
						}
						//设置网络
						if ("internet".equals(p.getCode())) {
							if(p.getValue()!=null){ 
								//接口对方传来：收费，无，免费，自动加上两个字"宽带"
								if(p.getValue().length()<3){
									room.setInternet("宽带"+p.getValue());
								}else{
									//否则就不变.不知道对方会传什么其他东西过来.
									room.setInternet(p.getValue());
								}
							}
						}
					}
				}
				 
				room.setDescription(notNullString(prodProductBranch.getPropValue().get("branch_desc"))); 
				room.setArea(notNullString(prodProductBranch.getPropValue().get("area"))); 
				room.setFloor(notNullString(prodProductBranch.getPropValue().get("floor"))); 
				room.setDesc(notNullString(prodProductBranch.getPropValue().get("branch_desc")));  

				if(CollectionUtils.isNotEmpty(prodProductBranch.getRecommendBaseVoList())){
					GoodsBaseVo goods = prodProductBranch.getRecommendBaseVoList().get(0);
					
					room.setDailyLowestPrice(divide100(goods.getDailyLowestPrice()));
					//room.setPrice(divide100(goods.getDailyLowestPrice()));
					List<SuppGoodsBaseTimePriceVo>  baseTimePriceList = goods.getSuppGoodsBaseTimePriceVoList();  
					//默认设置为第一个库存日历的
					room.setStock(baseTimePriceList.get(0).getStock());
					room.setTotalStock(baseTimePriceList.get(0).getTotalStock());
					BigDecimal sumPrice  = new BigDecimal(0);
					if(CollectionUtils.isNotEmpty(baseTimePriceList)){
						Long stock = Long.MAX_VALUE;
						Long totalStock = Long.MAX_VALUE;
						
						List<FitSdpHotelTimePriceDto> timeprices  = new ArrayList<FitSdpHotelTimePriceDto>();
						for(SuppGoodsBaseTimePriceVo tp:baseTimePriceList){
							Map timePrice = getTimePrice(tp);
							FitSdpHotelTimePriceDto dto = new FitSdpHotelTimePriceDto();
							dto.setDateStr(""+timePrice.get("specDateStr"));  
							dto.setPrice(divide100(timePrice.get("price")));
							sumPrice = sumPrice.add(dto.getPrice());
							dto.setSettlementPrice(divide100(timePrice.get("settlementPrice")));
							dto.setStockFlag(notNull(timePrice.get("stockFlag"),"N")); 
							dto.setStock(Long.parseLong(notNull(timePrice.get("stock"),"0")));
							dto.setTotalStock(Long.parseLong(notNull(timePrice.get("totalStock"),"0")));
							//如果有库存，就设置房间的库存数量。取最小的一天的库存为准
							if(dto.getStock()!=0 &&stock.compareTo(dto.getStock())>0){
								stock = dto.getStock();
							}
							if(dto.getTotalStock()!=0 &&totalStock.compareTo(dto.getTotalStock())>0){
								totalStock = dto.getTotalStock();
							}
							timeprices.add(dto);
						}
						room.setTimePrice(timeprices);
						//设置房间价格为价格日历数据之和.
						if(sumPrice.compareTo(new BigDecimal(0))>0){
							room.setPrice(sumPrice);
						}else{
							room.setPrice(divide100(goods.getDailyLowestPrice()));
						}
						
						//设置价格日历里面的有效库存为房间库存，后面计算最多间数要用到.
						if(stock!=Long.MAX_VALUE){
							room.setStock(stock);
						}else{
							room.setStock(0L);
						}
						if(totalStock!=Long.MAX_VALUE){
							room.setTotalStock(totalStock);
						}else{
							room.setTotalStock(0L);
						}
					}
					room.setGoodsId(goods.getSuppGoodsId());
					room.setGoodsLowestPrice(divide100(goods.getDailyLowestPrice()));
					room.setGoodsName(goods.getGoodsName()); 
				} 
				
				//房间最低价-等于price
				room.setDailyLowestPrice(room.getPrice());
				
				//房间最小数量为(成人/maxVisitor)
				if(room.getMaxVisitor()!=null&&room.getMaxVisitor()>0){ 
					//如果房间最大入住人数为1，那么最小住的房间数就等于成人数。因为儿童不可以自己住一个房间.
					if(room.getMaxVisitor()==1L){
						room.setMinCount(adult);
					}else{
						Long sum = adult+ child/2;
						room.setMinCount(new Double(Math.ceil(sum.doubleValue()/room.getMaxVisitor().doubleValue())).longValue());
					}
				}else{
					room.setMinCount(1L);
				}
				
				//房间最大数量为成人
				room.setMaxCount(adult); 
				
				//下面进行最大间数和最小间数的修正，不可以超过库存数量
				if(room.getStock()>0){ 
					if(room.getStock().compareTo(room.getMinCount())<0) {
						room.setMinCount(room.getStock());
					} 
					if(room.getStock().compareTo(room.getMaxCount())<0) {
						room.setMaxCount(room.getStock());
					}
				}
				
				//设置默认销售的数量是最小销售数量
				room.setRoomCount(room.getMinCount().intValue());
			}
			ans[0] = hotel;
			ans[1] = room; 
			return ans;
		} 
    
    private String notNull(Object obj,String dflt){
    	if(obj==null){
    		return dflt;
    	}
    	return obj.toString();
    }
}
