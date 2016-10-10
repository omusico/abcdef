package com.lvmama.lvfit.sonline.search.controller.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvmama.lvf.common.client.RestClient;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.FitBusinessClient;
import com.lvmama.lvfit.common.client.FitSdpClient;
import com.lvmama.lvfit.common.dto.enums.BizEnum;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.JudgeType;
import com.lvmama.lvfit.common.dto.enums.ProductAuditType;
import com.lvmama.lvfit.common.dto.enums.TrafficTripeType;
import com.lvmama.lvfit.common.dto.enums.VSTDistrictCityEnum;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelComboGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelGroupDto;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitChangeFlightRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitChangeHotelComboRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitChangeHotelGroupRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpGoodsRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpUpdShoppingRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSequenceFlightRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductCalendarDto;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpShoppingDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.request.FitSdpBookingNoticeRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightFacetType;
import com.lvmama.lvfit.common.dto.search.flight.result.CharterFlightFilterUtil;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.vst.VstSeoFriendLinkDto;
import com.lvmama.lvfit.common.dto.vst.VstSeoInnerLinkDto;
import com.lvmama.lvfit.sonline.base.BaseController;
import com.lvmama.lvfit.sonline.search.controller.SearchController;
import com.lvmama.lvfit.sonline.search.controller.form.BottomDescInfoType;
import com.lvmama.lvfit.sonline.search.controller.form.SearchGoodsResponseForm;
import com.lvmama.lvfit.sonline.search.controller.form.SearchRequestForm;
import com.lvmama.lvfit.sonline.search.controller.form.SearchResponseForm;
import com.lvmama.lvfit.sonline.utils.IpCityUtil;

@Controller
public class SearchControllerImpl extends BaseController implements SearchController<SearchRequestForm, SearchResponseForm> {
	
    private static final Logger logger = LoggerFactory.getLogger(SearchControllerImpl.class);
	
    @Value("seoDestId")
	private String seoDestId ;
	
	@Value("seoFuZhuZhi")
	private String seoFuZhuZhi ;
	
	@Value("seoOutKey")
	private String seoOutKey ;
	
	@Value("seoInKey")
	private String seoInKey ;
	
	@Autowired
	private RestClient restClient;
	@Autowired
	private FitSdpClient sdpClient;
	@Autowired
	private FitBusinessClient businessClient;
	@Autowired
	private IpCityUtil  ipCityUtil;
	
	public static final String splitKey ="-D";
	
	public static final String freetour_key ="freetour";
	
	public static final String group_key ="group";

	public static final String preview_key ="preview";
	
	
	@RequestMapping(value = "/{fromStr}", method = { RequestMethod.POST, RequestMethod.GET })
	public String showDetail(Model model,@PathVariable("fromStr")String fromStr,HttpServletRequest request){
		  boolean isNotPreview = true;
		  String returnTo = "";
		  try {
			if(fromStr.contains(freetour_key)||fromStr.contains(group_key)){
				int splitIndex = fromStr.indexOf("-", 0);
				String toKey = fromStr.substring(0, splitIndex);
				String infoStr =  fromStr.substring(splitIndex+1);
				if(infoStr.contains(preview_key)){
					isNotPreview = false;
					infoStr = infoStr.substring(0, infoStr.lastIndexOf("-"));
				}
				if(toKey.equals(freetour_key)){
					returnTo = "detail/freetour";
				}
				if(toKey.equals(group_key)){
					returnTo = "detail/group";
				}
				model.addAttribute("isNotPreview",String.valueOf(isNotPreview));
				getProductInfoAndSetModel(model, infoStr, request,isNotPreview);
				return returnTo;
			}
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			if (isNotPreview) {
				return "error";
			}
			return  returnTo;
		}
		return "error";
	}



    private void getProductInfoAndSetModel(Model model, String infoStr, HttpServletRequest request,boolean isNotPreview) throws Exception {

		Long curSelectCityId = super.initModelData(model, request);
		Long defaultCityId = null;
		Long productIdL = null;
		if (StringUtils.isNotBlank(infoStr)) {
			if (infoStr.contains("-D")) {
				productIdL = Long.valueOf(infoStr.split(splitKey)[0]);
				defaultCityId = Long.valueOf(infoStr.split(splitKey)[1]);
			} else {
				productIdL = Long.valueOf(infoStr);
			}
		}
		model.addAttribute("productId", productIdL);
		FitSdpProductBasicInfoDto basicInfo = this.searchBasicProductInfo(productIdL,isNotPreview);
	 
		if (basicInfo.getPackageTrafficFlag() == JudgeType.Y
			&& basicInfo.getCancelFlag() == JudgeType.Y && basicInfo.getSaleFlag() == JudgeType.Y
			&& basicInfo.getAuditType() == ProductAuditType.AUDITTYPE_PASS) {
			model.addAttribute("isCanBooking", String.valueOf(true));
		} else {
			model.addAttribute("isCanBooking", String.valueOf(false));
		} 
		
		Long packagedProdCatId = basicInfo.getPackagedCategoryId(); 
		if(packagedProdCatId==null){
			packagedProdCatId = 0L;
		}
 
		SearchResponseForm respForm = new SearchResponseForm(basicInfo); 
		if (CollectionUtils.isNotEmpty(basicInfo.getCityGroups())) {
			if (basicInfo.getCityGroups().size() > 1) {

				if (defaultCityId == null) {
					defaultCityId = curSelectCityId;
					if (!respForm.getDistrictIds().contains(defaultCityId)) {
						defaultCityId = ipCityUtil.getDefaultIpCityCode(request);
					}
					if ((respForm.getDistrictIds().contains(defaultCityId))) {
						basicInfo.setDefDeparture(initCityGroupByCityId(defaultCityId, basicInfo));
					} else {
						if (CollectionUtils.isNotEmpty(basicInfo.getCityGroups())) {
							basicInfo.setDefDeparture(basicInfo.getCityGroups().get(0));
						}
					}
				} else {
					basicInfo.setDefDeparture(initCityGroupByCityId(defaultCityId, basicInfo));
				}
			} else {
				basicInfo.setDefDeparture(basicInfo.getCityGroups().get(0));
			}
		}

		//1. 产品基本信息
		model.addAttribute("basicInfo", respForm.getBasicInfo());
		model.addAttribute("shoppingUuid", UUID.randomUUID().toString().replace("-",""));
		if(StringUtils.isNotBlank(respForm.getBasicInfo().getProductShowName())){
			String[] titles = basicInfo.getProductShowName().split(",");
			model.addAttribute("mainTitle", titles[0]);
			model.addAttribute("subTitle", titles[1]);
		}
		model.addAttribute("productTypeName", respForm.getProductTypeName());
		model.addAttribute("packagedProdCatId", packagedProdCatId);
		model.addAttribute("packagedProductId", basicInfo.getPackagedProductId());
		model.addAttribute("photoUrls", respForm.getPhotoUrls());
		model.addAttribute("additional", respForm.getBasicInfo().getAdditionalInfoDto());
		model.addAttribute("depCities", respForm.getCityMaps());
		//如果被打包产品的类型是酒店套餐
		if(packagedProdCatId.equals(BizEnum.BIZ_CATEGORY_TYPE.category_route_hotelcomb.getCategoryId())){
			model.addAttribute("maxQuantityLimit", respForm.getMaxQuantityLimit());
		}else{
			model.addAttribute("adultMaxQuantity", respForm.getAdultMaxQuantity());
			model.addAttribute("adultMinQuantity", respForm.getAdultMinQuantity());
			model.addAttribute("childMaxQuantity", respForm.getChildMaxQuantity());
			model.addAttribute("childMinQuantity", respForm.getChildMinQuantity());
		} 

		List<VstSeoFriendLinkDto> friendList = this.querySeoFriendLink();
		List<VstSeoInnerLinkDto> innerList = this.querySeoInnerLink();
		model.addAttribute("friendList", friendList);
		model.addAttribute("innerList", innerList);

		// 获取TDK的信息
		String tdkStr = this.queryTDK(productIdL.toString(), basicInfo.getBizCategoryId(),basicInfo.getDefDeparture().getDepartureCityName());
		model.addAttribute("tdkStr", tdkStr);
		// 获取友链和内链信息
		String bottomLinksHtmlStr = this.queryInnerLinkAndFriendLink(productIdL.toString(), basicInfo.getBizCategoryId());
		model.addAttribute("bottomLinksHtmlStr", bottomLinksHtmlStr);
	}

	private FitSdpCityGroupDto initCityGroupByCityId(Long defaultCityId, FitSdpProductBasicInfoDto basicInfo) {
		FitSdpCityGroupDto initCityGroupDto = new FitSdpCityGroupDto();
		VSTDistrictCityEnum city = VSTDistrictCityEnum.getByDistrictId(defaultCityId);
		initCityGroupDto.setDepartureCityDistrictId(defaultCityId);
		initCityGroupDto.setDepartureCityCode(city.getCode());
		initCityGroupDto.setDepartureCityName(city.getCnName());
		initCityGroupDto.setDepartureCityShortPinYin(city.getPinYin().toUpperCase());
		initCityGroupDto.setArrivalCityDistrictId(basicInfo.getCityGroups().get(0).getArrivalCityDistrictId());
		initCityGroupDto.setArrivalCityCode(basicInfo.getCityGroups().get(0).getArrivalCityCode());
		initCityGroupDto.setArrivalCityName(basicInfo.getCityGroups().get(0).getArrivalCityName());
		initCityGroupDto.setArrivalCityShortPinYin(basicInfo.getCityGroups().get(0).getArrivalCityShortPinYin());
		basicInfo.setDefDeparture(initCityGroupDto);
		return initCityGroupDto;
	}
    
    private FitSdpProductBasicInfoDto searchBasicProductInfo(Long productId,boolean isNotPreview) {
    	FitSdpProductBasicInfoDto basicInfo = null;
    	if(isNotPreview){
    		basicInfo = sdpClient.searchProductBasicInfo(productId);
    	}else{
    		basicInfo = sdpClient.searchProductBasicInfoPreview(productId);
    	}
        return basicInfo;
    } 
    
    @RequestMapping(value = "bottom/{productId}", method = { RequestMethod.POST, RequestMethod.GET })
	public String showbottom(Model model,@PathVariable("productId")String productId){
	    model.addAttribute("productId", productId);
		return "detail/bottom";
	}
    

	@Override
	@ResponseBody
	@RequestMapping(value = "getCaclendarData", method = { RequestMethod.POST, RequestMethod.GET })
	public FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> getCalendarInfo(Model model, SearchRequestForm input) {
		// 构造跟团游页面日期下拉框所需元素
		FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> result = new FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto>();
		try {
			result = sdpClient.searchProductLowPriceCalendar(input.getCalendarRequest());
    		if (result != null && CollectionUtils.isNotEmpty(result.getResults())) {
    		    List<FitSdpProductCalendarDto> calendarDtos = result.getResults();
    		    for (FitSdpProductCalendarDto calendarDto : calendarDtos) {
    		        Date specDate = calendarDto.getSpecDate();
    		        calendarDto.setMonthAndDay(DateUtils.formatDate(specDate, "MM-dd"));
    		        calendarDto.setDayOfWeek(DateUtils.getWeekOfDate(specDate));
    		    }
    		}
    	} catch (Exception e) {
    		logger.error(ExceptionUtils.getStackTrace(e));
    	}
		return result;
	}
	
 
	/**
	 * 初始进入页面设置选择的航班，根据产品里面的是否非对接优先字段进行控制。
	 * 如果非对接优先展示包机切位航班。
	 * 否则，展示价格最低的往返程航班。
	 * @param respForm
	 * @param req
	 */
	private SearchGoodsResponseForm setSumFlights(SearchGoodsResponseForm respForm,FitSdpGoodsRequest req){
		//包机信息
		FitSdpGoodsDto goods = new FitSdpGoodsDto();
		goods.setCharterFlightInfos(respForm.getCharterFlightInfos());
		goods.setDepFlightInfos(respForm.getDepFlightInfos());
		goods.setArvFlightInfos(respForm.getArvFlightInfos());
		 
		List<FlightSearchFlightInfoDto> flights = CharterFlightFilterUtil.setSumFlights(goods, req);
		
		List<FlightSearchFlightInfoDto> deps = new ArrayList<FlightSearchFlightInfoDto>();
		deps.add(flights.get(0));
		List<FlightSearchFlightInfoDto> arvs = new ArrayList<FlightSearchFlightInfoDto>();
		arvs.add(flights.get(1));
		
		respForm.setSumArvFlightInfos(arvs);
		respForm.setSumDepFlightInfos(deps);
		 
		return respForm;
	}
	 
	@Override
	@RequestMapping(value = "loadsGoods", method = { RequestMethod.POST ,RequestMethod.GET})
	public String searchGoodsInfo(Model model, FitSdpGoodsRequest req) {  
		req.setBookingSource(BookingSource.FIT_SDP_FRONT);
		req.setDistributorId(3L);
	    FitSdpGoodsDto goodsInfo = sdpClient.searchProductGoodsInfo(req); 
	    SearchGoodsResponseForm respForm = new SearchGoodsResponseForm(goodsInfo);
	    //设置最低价航班.根据参数是否非对接优先，决定当前选择的航班是包机还是全部价格最低.找到默认选择的航班.
	    respForm = setSumFlights(respForm,req);
	    
	    model.addAttribute("charterFlightInfos", respForm.getCharterFlightInfos()); 
	    //酒店
	    model.addAttribute("hotelGroups", respForm.getHotelGroups()); 
	    model.addAttribute("hotelCombos", respForm.getHotelCombo());
	    model.addAttribute("localTrip", respForm.getLocalTrip());
	    model.addAttribute("additional", respForm.getAdditional());
	    model.addAttribute("otherTicketMap", respForm.getOtherTicketMaps());
	    model.addAttribute("insProducts", goodsInfo.getInsProducts());
	    if(respForm.getAdditional()!=null){
	    	model.addAttribute("roomDiff", respForm.getAdditional().getRoomDiff());
	    }

	    model.addAttribute("depFlightInfos", respForm.getDepFlightInfos());
	    model.addAttribute("arvFlightInfos", respForm.getArvFlightInfos());
	    
	    model.addAttribute("sumDepFlightInfos", respForm.getSumDepFlightInfos());
	    model.addAttribute("sumArvFlightInfos", respForm.getSumArvFlightInfos()); 
	    
	    if (MapUtils.isNotEmpty(goodsInfo.getDepfacetMap())) {
	        model.addAttribute("toCarrierCode", goodsInfo.getDepfacetMap().get(FlightFacetType.carrierNameCode));
	        model.addAttribute("toDepTime", respForm.getTimeSegmentsFilter(goodsInfo.getDepfacetMap().get(FlightFacetType.departureTimeSegment)));
	        model.addAttribute("toSeatClassType", respForm.getSeatClassCodeFilter(goodsInfo.getDepfacetMap().get(FlightFacetType.seatClassType)));
	    }
	    if (MapUtils.isNotEmpty(goodsInfo.getArvfacetMap())) {
            model.addAttribute("backCarrierCode", goodsInfo.getArvfacetMap().get(FlightFacetType.carrierNameCode));
            model.addAttribute("backDepTime", respForm.getTimeSegmentsFilter(goodsInfo.getArvfacetMap().get(FlightFacetType.departureTimeSegment)));
            model.addAttribute("backSeatClassType", respForm.getSeatClassCodeFilter(goodsInfo.getArvfacetMap().get(FlightFacetType.seatClassType)));
        }
	    if (goodsInfo.getTrafficRuleMap() != null) {
            model.addAttribute("toSortRule", goodsInfo.getTrafficRuleMap().get(TrafficTripeType.GO_WAY.name()));
            model.addAttribute("backSortRule", goodsInfo.getTrafficRuleMap().get(TrafficTripeType.BACK_WAY.name()));
        }
	    
	    model.addAttribute("adultQuantity", req.getAdultQuantity());
	    model.addAttribute("childQuantity", req.getChildQuantity());
	    model.addAttribute("totalQuantity", (req.getAdultQuantity().longValue() + req.getChildQuantity().longValue())*req.getQuantity().intValue());
	    
	    //设置是否使用包机的开关
	    model.addAttribute("queryCharsetFlightFlag", CharterFlightFilterUtil.getQueryCharsetFlight());
	    if(respForm.getCharterFlightInfos()!=null){
	    	model.addAttribute("charterSize", respForm.getCharterFlightInfos().size());
	    }
	    else
	    	model.addAttribute("charterSize", 0);
	    
		return "detail/product_goods";
	}
	
	@Override
	@RequestMapping(value = "searchProductBottomDescInfo", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchProductBottomDescInfo(Model model, String productId,Long bizCategoryId) {
		String bottomDescInfo = StringUtils.EMPTY;
		Map<String,String> map = new HashMap<String,String>();
		try {
			bottomDescInfo = this.searchProductBottomDescInfoFromVst(productId, BottomDescInfoType.All,bizCategoryId,map);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
		//1. check product 是否需要去被打包产品的费用说明以及形成明细，是的话做相应的逻辑处理
		model.addAttribute("productId", productId);
		model.addAttribute("bottomDescInfo", bottomDescInfo);
		if(map.containsKey("packagedProductId")){
			model.addAttribute("packagedProductId", map.get("packagedProductId"));}
		if(map.containsKey("routeDetailUseFlag")){
			model.addAttribute("routeDetailUseFlag", map.get("routeDetailUseFlag"));}
		if(map.containsKey("feeExplainUseFlag")){
			model.addAttribute("feeExplainUseFlag", map.get("feeExplainUseFlag"));}
		return "detail/bottom_desc";
	}
	
	@Override
	public String searchProductCommentPageInfo(Model model, SearchRequestForm input) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String searchProductNotesPageInfo(Model model, SearchRequestForm input) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据产品Id以及获取类型获取底部描述信息
	 * @param productId
	 * @param getType
	 * @return
	 */
	private String searchProductBottomDescInfoFromVst(String productId,BottomDescInfoType getType,Long bizCategoryId,Map<String,String> map){
		String returnStr = this.getProductHtml(productId, bizCategoryId);
		//产品基本信息元素
		int startIndx = returnStr.indexOf("<div id=\"nav-height-holder\" class=\"nav-height-holder\">");
		int endIndx = returnStr.indexOf("<div class=\"booking-way\">");
		if(endIndx<0){
			endIndx = returnStr.indexOf("<div class=\"common_box pro_box1\" id=\"scenic_recommendation\">");
		}
		//地图坐标信息
		int startdituJson = returnStr.indexOf("var jsonArray");
		int endDituJson = 	returnStr.indexOf("if(jsonArray == null");
		//推荐信息方法调用截取
		String bottomDescAllInfo = returnStr.substring(startIndx, endIndx) +
				"<script>"+returnStr.substring(startdituJson,endDituJson)+"</script>";
		/*if(getType==BottomDescInfoType.All){
			return bottomDescAllInfo;
		}*/
		BaseSingleResultDto<FitSdpProductBasicInfoDto>  productBasicInfoRslt = businessClient.getSdpProductBasicInfoByProductId(Long.parseLong(productId));
		FitSdpProductBasicInfoDto productBasicInfoDto = productBasicInfoRslt.getResult();
		if(productBasicInfoDto==null){
			productBasicInfoDto =  sdpClient.searchProductBasicInfoPreview(Long.parseLong(productId));
		}
		Long packagedProductId = productBasicInfoDto.getPackagedProductId();
		if(packagedProductId==null){
			packagedProductId = 0L;
		}
		map.put("packagedProductId", String.valueOf(packagedProductId));
		map.put("routeDetailUseFlag", productBasicInfoDto.getRouteDetailUseFlag().name());
		map.put("feeExplainUseFlag", productBasicInfoDto.getFeeExplainUseFlag().name());
		//是否使用被打包产品行程介绍
		if(JudgeType.Y == productBasicInfoDto.getRouteDetailUseFlag()){
			if(packagedProductId!=null){
				String tripdescStr = restClient.get("http://dujia.lvmama.com/package/"+packagedProductId+"/preview?isOldUrl=Y", String.class);
				String tripResult = this.getNewString(tripdescStr, "<div class=\"product-detail-instance\" id=\"product-travel\">", "<div class=\"product-detail-instance\" id=\"product-map\">");
				if(StringUtils.isNotBlank(tripResult) && tripResult.contains("id=\"product-travel\">")){
					tripResult = tripResult.replace("id=\"product-travel\">", "id=\"product-travel\" packagedProductId=\""+packagedProductId+"\">");
				}else if(StringUtils.isBlank(tripResult)){
					//兼容酒店套餐改版
					tripResult = this.getNewString(tripdescStr, "<div class=\"xingcheng_all\">", "<h3 class=\"line_tit\" id=\"jiaotong\">");
					if(StringUtils.isNotBlank(tripResult) && tripResult.contains("class=\"xingcheng_all\">")){
						tripResult = tripResult.replace("class=\"xingcheng_all\">", "id=\"xingcheng_all\" packagedProductId=\""+packagedProductId+"\">");
					}
				}
				String bottomDescString = this.getNewString(bottomDescAllInfo, "<div class=\"product-detail-instance\" id=\"product-travel\">", 
						"<div class=\"product-detail-instance\" id=\"product-map\">");
				if(null != tripResult){
					if(null != bottomDescString){
						bottomDescAllInfo = bottomDescAllInfo.replace(bottomDescString, tripResult);
					}else{
						bottomDescAllInfo = bottomDescAllInfo + tripResult;
					}
				}
				String packagedPreorderNote = this.getNewString(tripdescStr, "<div class=\"product-detail-instance\" id=\"product-preorder-note\">", "<div class=\"product-detail-instance\" id=\"product-recommend\"");
				if(StringUtils.isNotBlank(packagedPreorderNote) && packagedPreorderNote.contains("id=\"product-preorder-note\">")){
					packagedPreorderNote = packagedPreorderNote.replace("id=\"product-preorder-note\">", "id=\"packageproduct-preorder-note\"  style=\"display:none\">");
					bottomDescAllInfo = bottomDescAllInfo + packagedPreorderNote;
				}
				//跟团游产品详情->产品摘要 根据routeDetailUseFlag=Y，取被打包产品的摘要
				if(bizCategoryId!=null && BizEnum.BIZ_CATEGORY_TYPE.category_route_group.getCategoryId().equals(bizCategoryId)){
					String  productSummary  = this.getNewString(tripdescStr, "<div class=\"product-summary\">", "<div class=\"detail-instance-body\">");
					if(StringUtils.isNotBlank(productSummary)){
						String oldProductSummary = this.getNewString(bottomDescAllInfo,"<div class=\"product-summary\">","<div class=\"detail-instance-body\">");
						if(StringUtils.isNotBlank(oldProductSummary)){
							bottomDescAllInfo = bottomDescAllInfo.replace(oldProductSummary, productSummary);
						}else{
							bottomDescAllInfo = bottomDescAllInfo + productSummary;
						}
					}
					
				}
			}
		}
		//是否使用被打包产品费用说明
		if(JudgeType.Y == productBasicInfoDto.getFeeExplainUseFlag()){
			if(packagedProductId!=null){
				String bottomDescString = this.getNewString(bottomDescAllInfo, "<div class=\"instance_list2_box\" id=\"product-cost\">", 
						"<div class=\"product-detail-instance\" id=\"product-preorder-note\">");
					String newFeedResult = getPackageProductFeeExplain(packagedProductId);
					if(bottomDescString != null  && StringUtils.isNotBlank(newFeedResult)){
						bottomDescAllInfo = bottomDescAllInfo.replace(bottomDescString, newFeedResult);
					}else{
						bottomDescAllInfo = bottomDescAllInfo + newFeedResult;
					}
			}
		}
		return bottomDescAllInfo;
	}

	private String getPackageProductFeeExplain(Long packagedProductId){
		if(packagedProductId!=null){
			String feeddescStr = restClient.get("http://dujia.lvmama.com/package/"+packagedProductId+"/preview?isOldUrl=Y", String.class);
			String feedResult = this.getNewString(feeddescStr, "<div class=\"instance_list2_box\" id=\"product-cost\">", 
					"<div class=\"product-detail-instance\" id=\"product-preorder-note\">");
			String newFeedResult = "";
			if(null != feedResult){
				int feeIncludeInx = feedResult.lastIndexOf("<div class=\"operate\">费用包含</div>");
				if(feeIncludeInx>0){//有费用包含时
						int includeDetailInx = feedResult.indexOf("<div class=\"detail\">");
						if(includeDetailInx>0){
							int includeEndDiv  = feedResult.substring(includeDetailInx).indexOf("</div>");
							if(includeEndDiv>0){
								newFeedResult = feedResult.substring(0,includeDetailInx)+feedResult.substring(includeDetailInx).substring(0, includeEndDiv)+
								"<br>成人、2-12周岁儿童均含往返机票 ；<br>以上报价已包含机票税和燃油附加费。"+
								feedResult.substring(includeDetailInx).substring(includeEndDiv);}
							}
					}else{//无费用包含时
						String[] feedArry = feedResult.split("<div class=\"detail-instance-body\">");
						if(feedArry.length>1){
							feedArry[1] = "<div class=\"detail-instance-body\"><div class=\"detail-desc-item\"><div class=\"operate\">费用包含</div>"
								+"<div class=\"detail\"><br>成人、2-12周岁儿童均含往返机票 ；<br>以上报价已包含机票税和燃油附加费。</div></div>"
								+feedArry[1];
							for (int i = 0; i < feedArry.length; i++) {
								newFeedResult = newFeedResult + feedArry[i];
							}
						}else{
							int list2Idx = feedResult.indexOf("</div>");
							if(list2Idx>0){
							newFeedResult = feedResult.substring(0,list2Idx)+"<div class=\"product-detail-instance\"><div class=\"instance-title clearfix\">"
                                +"<div class=\"title-icon-container\"><i class=\"product-cost-icon\"></i></div><h3>费用说明</h3></div>"
                                +"<div class=\"detail-instance-body\"><div class=\"detail-desc-item\"><div class=\"operate\">费用包含</div>"
								+"<div class=\"detail\">成人、2-12周岁儿童均含往返机票 ；<br>以上报价已包含机票税和燃油附加费。</div></div></div>"
								+feedResult.substring(list2Idx);
							}
						}
					}
				}else{
				//兼容酒店套餐改版
				feedResult = this.getNewString(feeddescStr, "<div class=\"feiyong_all detail-info\">", "<h3 class=\"line_tit\" id=\"xuzhi\">");
				if(StringUtils.isNotBlank(feedResult) && feedResult.contains("<div class=\"feiyong_all")){
					int feeIncludeInx = feedResult.lastIndexOf("<strong class=\"detail-info-stit\">费用包含</strong>");
					if(feeIncludeInx>0){//有费用包含时
						int includeDetailInx = feedResult.indexOf("<p>");
						if(includeDetailInx>0){
							int includeEndDiv =  feedResult.substring(includeDetailInx).indexOf("</p>");
							if(includeEndDiv>0){
								newFeedResult = feedResult.substring(0,includeDetailInx)+feedResult.substring(includeDetailInx).substring(0, includeEndDiv)+
								"<br>成人、2-12周岁儿童均含往返机票 ；<br>以上报价已包含机票税和燃油附加费。"+
								feedResult.substring(includeDetailInx).substring(includeEndDiv);}
						}
					}else{//无费用包含时
						String[] feedArry = feedResult.split("<div class=\"detail-infoWrap\">");
						if(feedArry.length>1){
							feedArry[1] = "<div class=\"detail-infoWrap\"><strong class=\"detail-info-stit\">费用包含</strong>"
									+"<p>成人、2-12周岁儿童均含往返机票 ；<br>以上报价已包含机票税和燃油附加费。</p></div>"
									+feedArry[1];
							for (int i = 0; i < feedArry.length; i++) {
								newFeedResult = newFeedResult + feedArry[i];
							}
						}else{
							newFeedResult = "<div class=\"feiyong_all detail-info\"><div class=\"detail-infoWrap\"> "+
                                "<strong class=\"detail-info-stit\">费用包含</strong><p>成人、2-12周岁儿童均含往返机票 ；"
                                + "<br>以上报价已包含机票税和燃油附加费。</p></div></div></div></div>";
						}
					}
					newFeedResult ="<div class=\"instance_list2_box\"><div class=\"instance_list2\" style=\"display:block;\">"+newFeedResult;
							
				}
			}
			return newFeedResult;
		}
		return null;
	}
	
	private String getNewString(String oldString,String startStr,String endStr){
		int startIndx = oldString.indexOf(startStr);
		int endIndx = oldString.indexOf(endStr);
		if(startIndx > -1 && endIndx>-1){
			String result = oldString.substring(startIndx, endIndx);
			return result;
		}
		return null;
	}
	
	/**跨域访问数据时的代理
	 * @param model
	 * @param requestStr 请求url包含QueryString
	 * @return
	 */
	@Override
	@RequestMapping(value="serverProxy",method ={ RequestMethod.POST, RequestMethod.GET })
	public String serverProxy(Model model, String requestStr){
			String returnStr = restClient.get(requestStr, String.class);
			model.addAttribute("returnStr", returnStr);
			return "detail/serverProxy";
		
	}

	
	@RequestMapping(value = "searchSome", method = { RequestMethod.POST, RequestMethod.GET })
	public String search() {
		return "detail/calendar";
	}
	
	@RequestMapping(value = "changeHotelCombo", method = { RequestMethod.POST })
	public String changeHotelCombo(Model model, FitChangeHotelComboRequest req) {
	     List<FitSdpHotelComboGoodsDto> hotelCombos = sdpClient.changeHotelCombo(req);
	     SearchGoodsResponseForm form = new SearchGoodsResponseForm();
	     hotelCombos = form.setDiffPriceOfHotelCombo(hotelCombos);
	     model.addAttribute("hotelCombos", hotelCombos);
	     return "detail/item/hotel_combo";
	}
	 
	 
	@RequestMapping(value = "changeHotel", method = { RequestMethod.POST })
	public String changeHotelGroup(Model model, FitChangeHotelGroupRequest req) { 
		 //将变化的选择的信息保存到缓存.
	     List<FitSdpHotelGroupDto> hotelGroups = sdpClient.changeHotelGroup(req);
	     SearchGoodsResponseForm form = new SearchGoodsResponseForm();
	     //计算最新的差价--设置room里面的diffprice字段.---只重新计算当前所选分组中的差价.
	     hotelGroups = form.setDiffPriceOfHotelGroup(hotelGroups);
	     model.addAttribute("hotelGroups", hotelGroups);
	     return "detail/item/hotelinfo";
	}
	
	@RequestMapping(value = "changeFlight", method = { RequestMethod.POST })
	public String changeFlight(Model model, FitChangeFlightRequest req) {
        List<FlightSearchFlightInfoDto> returnFlightInfos = sdpClient.changeFlight(req);
        if (req.getFlightTripType().equals(FlightTripType.DEPARTURE.name())) {
            model.addAttribute("depFlightInfos", returnFlightInfos);
            return "detail/item/flight_list/to_flight_list";
        } else if (req.getFlightTripType().equals(FlightTripType.RETURN.name())) {
            model.addAttribute("arvFlightInfos", returnFlightInfos);
            return "detail/item/flight_list/back_flight_list";
        }else {
            model.addAttribute("charterFlightInfos", returnFlightInfos);
            return "detail/item/flight_list/charter_flight_list";
        }
        
    }
	@RequestMapping(value="sequenceFlight",method={RequestMethod.POST,RequestMethod.GET})
	public String sequenceFlight(Model model, FitSequenceFlightRequest req){
		try {  
			FitSdpShoppingDto SdpShoppingDto = sdpClient.getShoppingByUUID(req.getShoppingUuid());
			//得到选择的航班. 
			List<FlightSearchFlightInfoDto>  selectedFlight = SdpShoppingDto.getSelectedFlightInfos();
			//判断当前是否选择的包机切位航班
			String saleType =  selectedFlight.get(0).getSaleType() ;
			if (req.getFlightTripType().equals(FlightTripType.DEPARTURE.name())) {
				List<FlightSearchFlightInfoDto> depFlightInfos = SdpShoppingDto.getDepFlightInfos();
				depFlightInfos = sortFlight(depFlightInfos,req);
				model.addAttribute("depFlightInfos", depFlightInfos);
				model.addAttribute("depFlightNo", selectedFlight.get(0).getFlightNo()); 
		        model.addAttribute("saleType", saleType);
	            return "detail/item/flight_list/to_flight_list";
	        } else if (req.getFlightTripType().equals(FlightTripType.RETURN.name())) {
	        	List<FlightSearchFlightInfoDto> arvFlightInfos = SdpShoppingDto.getArvFlightInfos();
	        	arvFlightInfos = sortFlight(arvFlightInfos,req);
	            model.addAttribute("arvFlightInfos", arvFlightInfos);
	            model.addAttribute("arvFlightNo", selectedFlight.get(1).getFlightNo()); 
	            model.addAttribute("saleType", saleType);
	            return "detail/item/flight_list/back_flight_list";
	        }
			//包机
	        else {
	        	List<FlightSearchFlightInfoDto> charterFlightInfos = SdpShoppingDto.getCharterFlightInfos();
	        	charterFlightInfos = sortFlight(charterFlightInfos,req);
	            model.addAttribute("charterFlightInfos", charterFlightInfos);
	            model.addAttribute("depFlightNo", selectedFlight.get(0).getFlightNo()); 
	            model.addAttribute("arvFlightNo", selectedFlight.get(1).getFlightNo()); 
	            model.addAttribute("saleType", saleType);
	            return "detail/item/flight_list/charter_flight_list";
	        }
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
		return null;
		
	}
	public List<FlightSearchFlightInfoDto> sortFlight(List<FlightSearchFlightInfoDto> depFlightInfos,final FitSequenceFlightRequest req){
		//不是包机的情况，进行差价排序.
		if(!req.getFlightTripType().equals(FlightTripType.CHARTER.name())){
			Collections.sort(depFlightInfos,new Comparator<FlightSearchFlightInfoDto>(){
				@Override
				public int compare(FlightSearchFlightInfoDto dto1, FlightSearchFlightInfoDto dto2) {
					if("departureTime".equals(req.getSortStr())){//比较当地起飞时间
						try { 
							String departureTime1 = dto1.getDepartureTime();
							String departureTime2 = dto2.getDepartureTime();
							DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							Date dt1= format.parse(departureTime1);
							Date dt2= format.parse(departureTime2);
							
							if("ASC".equals(req.getSortType().toUpperCase())){
								return dt1.compareTo(dt2);
							}else{
								return dt2.compareTo(dt1);
							}
						} catch (ParseException e) {
							logger.error(ExceptionUtils.getStackTrace(e));
						}
					}else if("differentPrice".equals(req.getSortStr())){//比较差价 
						if(CollectionUtils.isNotEmpty(dto1.getSeats())&& CollectionUtils.isNotEmpty(dto2.getSeats())){
							BigDecimal  diffPrice1 = dto1.getSeats().get(0).getDifferentPrice();
							BigDecimal  diffPrice2 = dto2.getSeats().get(0).getDifferentPrice();
							if("ASC".equals(req.getSortType().toUpperCase())){
								return diffPrice1.compareTo(diffPrice2);
							}else{
								return diffPrice2.compareTo(diffPrice1);
							}
						}
						return 0; 
					}
					return 0;
				}
			});
		}else{
			//包机的比较，实际要比较里面的带有返程的全部的价格.
			Collections.sort(depFlightInfos,new Comparator<FlightSearchFlightInfoDto>(){
				@Override
				public int compare(FlightSearchFlightInfoDto dto1, FlightSearchFlightInfoDto dto2) {
					if("departureTime".equals(req.getSortStr())){//比较当地起飞时间
						try { 
							String departureTime1 = dto1.getDepartureTime();
							String departureTime2 = dto2.getDepartureTime();
							DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							Date dt1= format.parse(departureTime1);
							Date dt2= format.parse(departureTime2);
							
							if("ASC".equals(req.getSortType().toUpperCase())){
								return dt1.compareTo(dt2);
							}else{
								return dt2.compareTo(dt1);
							}
						} catch (ParseException e) {
							logger.error(ExceptionUtils.getStackTrace(e));
						}
					}else if("differentPrice".equals(req.getSortStr())){//比较差价    
						BigDecimal basePrice1 = dto1.getSeats().get(0).getSalesPrice();
						BigDecimal basePrice2 = dto2.getSeats().get(0).getSalesPrice();
					 	if("ASC".equals(req.getSortType().toUpperCase())){
							return basePrice1.compareTo(basePrice2);
						}else{
							return basePrice2.compareTo(basePrice1);
						}  
					}
					return 0;
				}
			});
		}
		return depFlightInfos;
	}
	
	@RequestMapping(value = "seo/queryTDK", method = RequestMethod.GET)
	@ResponseBody
	public String queryTDK(HttpServletRequest request) {
		String key = request.getParameter("key");
		String seoTdkStr = restClient.get("http://www.lvmama.com/pet_topic/tdk/queryTDK.do?key="+key, String.class);
		return seoTdkStr;
	}
	
	public List<VstSeoFriendLinkDto> querySeoFriendLink() throws Exception { 
		String seoKey =getSeoOutKey();
		String seoDestId =getSeoDestId();
		String seoFuZhuZhi =getSeoFuZhuZhi();
		String seoTdkStr = "";
		List<VstSeoFriendLinkDto> list = new ArrayList<VstSeoFriendLinkDto>();
		try{
			String url = "http://www.lvmama.com/pet_topic/seoFriendLink/querySeoFriendLink.do?seoKey="+seoKey+"&destId="+seoDestId+"&fuZhuZhi="+seoFuZhuZhi;
			seoTdkStr = restClient.get(url , String.class);
			if (StringUtils.isNotBlank(seoTdkStr)) {
				ObjectMapper objectMapper = JSONMapper.getInstance();
				list = objectMapper.readValue(seoTdkStr, new TypeReference<List<VstSeoFriendLinkDto>>() {
				});
				if(CollectionUtils.isNotEmpty(list) && null != list.get(0)){
					return list;
				}
				return null;
			}
		}catch(Exception e){
			return list;
		}
		return list;
	}
	
	public List<VstSeoInnerLinkDto> querySeoInnerLink() throws Exception{
		String seoKey =getSeoInKey();
		String seoDestId ="";
		String seoTdkStr = "";
		List<VstSeoInnerLinkDto> list = new ArrayList<VstSeoInnerLinkDto>();
		try{
			String url = "http://www.lvmama.com/pet_topic/seoInnerLink/querySeoInnerLink.do?seoKey="+seoKey+"&destId="+seoDestId;
			seoTdkStr =restClient.get(url, String.class);
			if (StringUtils.isNotBlank(seoTdkStr)) {
				ObjectMapper objectMapper = JSONMapper.getInstance();
				list = objectMapper.readValue(seoTdkStr, new TypeReference<List<VstSeoInnerLinkDto>>() {
				});
				if(CollectionUtils.isNotEmpty(list) && null != list.get(0)){
					return list;
				}
				return null;
			}
		}catch(Exception e){
			return list;
		}
		return list;
	}
	private String getSeoDestId(){
		return CustomizedPropertyPlaceholderConfigurer.getContextProperty(seoDestId);
	}
	
	private String getSeoFuZhuZhi(){
		return CustomizedPropertyPlaceholderConfigurer.getContextProperty(seoFuZhuZhi);
	}
	
	private String getSeoInKey(){
		return CustomizedPropertyPlaceholderConfigurer.getContextProperty(seoInKey);
	}
	
	private String getSeoOutKey(){
		return CustomizedPropertyPlaceholderConfigurer.getContextProperty(seoOutKey);
	}
		
	@RequestMapping(value = "saveToCache", method = { RequestMethod.POST })
    @ResponseBody
    public Boolean saveToCache(FitSdpUpdShoppingRequest req) {
	    return sdpClient.saveGoodsToCache(req);
    }

	@RequestMapping(value = "getBookingNotice", method = { RequestMethod.POST })
    @ResponseBody
	public Map<String,String> getBookingNotice(FitSdpBookingNoticeRequest req) {
		String bottomDescInfo = StringUtils.EMPTY;
		try {
			bottomDescInfo = this.searchProductBottomDescInfoFromVst(req.getProductId(), BottomDescInfoType.All,Long.valueOf(req.getBizCategoryId()),new HashMap<String,String>());
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
	   }
		//费用说明
		String feedResult = this.getNewString(bottomDescInfo, "<div class=\"instance_list2_box\" id=\"product-cost\">", 
				"<!-- 费用说明结束 -->");
		//处理费用说明
		if(null != feedResult){
			if(feedResult.contains("<div class=\"operate\">费用包含</div>")){
				feedResult = feedResult.replace("<h3>费用说明</h3>","");
				feedResult = feedResult.replace("<div class=\"operate\">费用包含</div>", "<h4>费用包含</h4>");
			}
			if(feedResult.contains("<div class=\"operate\">费用不包含</div>")){
				feedResult = feedResult.replace("<div class=\"operate\">费用不包含</div>", "<h4>费用不包含</h4>");
			}
		}else{
			feedResult = this.getNewString(bottomDescInfo,"<div class=\"feiyong_all detail-info\">","<div class=\"product-detail-instance\" id=\"product-preorder-note\">");
			feedResult = feedResult.substring(0, feedResult.substring(0,feedResult.lastIndexOf("</div>")).lastIndexOf("</div>"));
			if(feedResult.contains("<strong class=\"detail-info-stit\">费用包含</strong>"));{
				feedResult = feedResult.replace("<strong class=\"detail-info-stit\">费用包含</strong>", "<h4>费用包含</h4>");
			}
			if(feedResult.contains("<strong class=\"detail-info-stit\">费用不包含</strong>"));{
				feedResult = feedResult.replace("<strong class=\"detail-info-stit\">费用不包含</strong>", "<h4>费用不包含</h4>");
			}
		}
		//预定须知
		String bookingNotice = this.getNewString(bottomDescInfo, "<div class=\"product-detail-instance\" id=\"product-preorder-note\">", 
				"<!-- 预订须知结束 -->");
		if(null != bookingNotice){
			bookingNotice = bookingNotice.replace("<h3>预订须知</h3>", "");
			bookingNotice = bookingNotice.replace("<div class=\"operate\">出行警示及说明</div>", "<h4>出行警示及说明</h4>");
			bookingNotice = bookingNotice.replace("<div class=\"operate\">退改说明</div>", "<h4>退改说明</h4>");
		}
		
		if(null  != feedResult && null != bookingNotice){
			bookingNotice = feedResult + bookingNotice;
		}
		Map<String,String> map = new HashMap<String, String>();
		map.put("bookingNotice", bookingNotice);
		return map;
	}
	
	private String queryTDK(String productId,Long bizCategoryId,String curCityName) {
		try {
			String returnStr = this.getProductHtml(productId, bizCategoryId);
			int startIndex = returnStr.indexOf("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/>");
			int endIndex = returnStr.indexOf("<meta name=\"mobile-agent");
			returnStr = returnStr.substring(startIndex, endIndex);
			//String oldCityName = returnStr.substring(returnStr.indexOf("<title>")+7,returnStr.indexOf("</title>",0));
			//returnStr = returnStr.replace(oldCityName,curCityName);
			return  returnStr;
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
		return null;
	}
	
	private String getProductHtml(String productId, Long bizCategoryId) {
		return sdpClient.getBottomInfo(Long.valueOf(productId), bizCategoryId);
	}
	
	private String queryInnerLinkAndFriendLink(String productId,Long bizCategoryId) {
        try {
            String returnStr = this.getProductHtml(productId, bizCategoryId);
            int startIndex = returnStr.indexOf("<div class=\"hh_cooperate\">");
            int endIndex = returnStr.indexOf("<div class=\"app-float-flow\"");
            if(startIndex > -1 && endIndex > -1){
            	String result = returnStr.substring(startIndex,endIndex);
            	int endDivIndx = result.lastIndexOf("</div>");
            	if(endDivIndx>-1){
            		return result.substring(0,endDivIndx); 
            	}
    		}
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return null;
    }
	
}
