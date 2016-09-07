package com.lvmama.lvfit.adapter.search.adapter.impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.comm.search.vst.vo.BranchBean;
import com.lvmama.comm.search.vst.vo.GoodsBean;
import com.lvmama.comm.search.vst.vo.HotelBean;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.RequestResponse;
import com.lvmama.lvf.common.dto.enums.InterfaceKey;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.adapter.search.adapter.HotelServiceAdapter;
import com.lvmama.lvfit.common.dto.price.FitHotelPlanPriceDto;
import com.lvmama.lvfit.common.dto.search.hotel.HotelFacetType;
import com.lvmama.lvfit.common.dto.search.hotel.HotelQueryRequest;
import com.lvmama.lvfit.common.dto.search.hotel.HotelSearchResult;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchPlanDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchRoomDto;
import com.lvmama.lvfit.common.utils.FitLoggerHandler;
import com.lvmama.vst.back.client.goods.service.SuppGoodsTimePriceClientService;
import com.lvmama.vst.back.client.pub.service.ComPhotoQueryClientService;
import com.lvmama.vst.back.goods.po.SuppGoodsTimePrice;
import com.lvmama.vst.back.pub.po.ComPhoto;
import com.lvmama.vst.comm.utils.MemcachedUtil;
import com.lvmama.vst.comm.vo.MemcachedEnum;
import com.lvmama.vst.newsearch.service.LvmamaFlightService;
import com.lvmama.vst.search.api.vo.PageConfigVo;
import com.lvmama.vst.search.api.vo.ResultHandleT;
import com.lvmama.vst.search.api.vo.SearchResultVo;

/**
 * 
 * 获取酒店信息
 * 
 * */
@Service
public class HotelServiceAdapterImpl implements HotelServiceAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(HotelServiceAdapterImpl.class);
	/**
	 * 度假酒店
	 * 
	 * **/
	@Autowired
	LvmamaFlightService lvmamaFlightService;
	
	@Autowired
	private  SuppGoodsTimePriceClientService suppGoodsTimePriceClientService;
	
	@Autowired
	private FitLoggerHandler fitLoggerHandler;
	/**
	 * 第一个 paramStr：比如你搜目的地上海，入住20151110，离店20151120， 第一个参数就是U9C201510O201529，
	 * 第二个参数 sessionId 当前浏览器的sessionId
	 * 第三个参数 keyword 入住城市 比如上海 keyword="上海" 没有则传空
	 */
	@Override
	public HotelSearchResult<HotelSearchHotelDto> searchHotel(String paramStr,String sessionId,String keyword,HotelQueryRequest hotelQueryRequest) {
		
		logger.info("[adapter-search-hotel]调用主站酒店查询接口参数paramStr：" + paramStr+"sessionId:"+sessionId+"keyword:"+keyword);
		//查询时间是价格表的参数
		Map<String,Object> requestMap = new HashMap<String,Object>();
		
		Date startDate = DateUtils.parseDate(hotelQueryRequest.getDepartureDate());
		Date endDate = DateUtils.parseDate(hotelQueryRequest.getReturnDate());
		
		StringBuilder vaildDates =new StringBuilder();
		Long c = startDate.getTime();
		Long endTime = endDate.getTime();
		while(c<endTime){
			vaildDates.append(DateUtils.formatDate(new Date(c),DateUtils.YYYYMMDD)+",");
			c+=1000L*60*60*24;
		}
		
		String vaildDate = vaildDates.substring(0,vaildDates.length()-1);
		
		requestMap.put("startDate",startDate);
		requestMap.put("endDate", endDate);
		requestMap.put("isSale", Boolean.TRUE);// 是否可售
		//获取总共入驻几晚
		Long days = DateUtils.getDateDiffByDay(hotelQueryRequest.getReturnDate(), hotelQueryRequest.getDepartureDate());
		//成人数  --判断最小预定分数
		int adultsCount = hotelQueryRequest.getAdultCount();
		List<HotelSearchHotelDto> hotels = new ArrayList<HotelSearchHotelDto>();
		HotelSearchResult<HotelSearchHotelDto> hotelSearchResult = new HotelSearchResult<HotelSearchHotelDto>();
		
		//调用vst接口时记录日志
		String gid= UUID.randomUUID().toString();
		Map<String,String> inputMap = new HashMap<String, String>();
		inputMap.put("paramStr",paramStr);
		inputMap.put("sessionId",sessionId);
		inputMap.put("keyword",keyword);
		Object returnObj = null;
		
		fitLoggerHandler.addFitLog(RequestResponse.RE.toString(), InterfaceKey.SearchHotelFromVst.name(), hotelQueryRequest, StringUtils.EMPTY, gid);
		ResultHandleT<SearchResultVo> resultHandle = null;
		try {
			resultHandle = lvmamaFlightService.searchHotel(paramStr, sessionId, keyword,20);
			returnObj = resultHandle;
		} catch (Exception e) {
			returnObj = ExceptionUtils.getFullStackTrace(e);
			throw new RuntimeException(e);
		}finally{
			fitLoggerHandler.addFitLog(RequestResponse.RS.toString(), InterfaceKey.SearchHotelFromVst.name(), returnObj, StringUtils.EMPTY, gid);
		}
		
		if (resultHandle == null ) {
			return null;
		}
//		try {
//			//logger.info("[adapter-search-hotel]调用主站酒店查询接口返回结果"+JSONMapper.getInstance().writeValueAsString(resultHandle));
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
		
		PageConfigVo<?> pageConfig = resultHandle.getReturnContent().getPageConfig();
		Map<String, Object> resultMap = resultHandle.getReturnContent().getResultMap();
		Map<HotelFacetType,Object> facetMap = new HashMap<HotelFacetType,Object>();
		
		Pagination pagination = new Pagination();
		pagination.setPage(pageConfig.getCurrentPage());
		pagination.setRows(pageConfig.getPageSize());//每页显示条数
		pagination.setRecords(pageConfig.getTotalResultSize());//总记录数
		
		//保证每页都有数据
//		int totalPage = 0;
//		totalPage = pageConfig.getTotalPageNum() >= 5 ? 5 : pageConfig.getTotalPageNum();
//		totalPage = totalPage <=1 ? totalPage : totalPage -1;
		pagination.setTotal(pageConfig.getTotalPageNum());//总页数
		
		hotelSearchResult.setPagination(pagination);
		
		for(Entry<String,Object> entry : resultMap.entrySet()){
			facetMap.put(HotelFacetType.valueOf(entry.getKey()), entry.getValue());
		}
		
		hotelSearchResult.setFacetMap(facetMap);

		//这里拿到goodsList、和product是同一个级别的
		List<Map<String,Object>> items = (List<Map<String, Object>>) pageConfig.getItems();
			
		if(items == null){
			return null;
		}
		
		Map<String,HotelSearchPlanDto> pricePlans = new HashMap<String,HotelSearchPlanDto>();
		List<Long> goodsIds = new ArrayList<Long>();

		for(Map<String,Object> item:items){
			
			//获取返回结果中的“product”
			if(null == item.get("product")){
				continue;
			}
			
			HotelBean hotelIndex = (HotelBean) item.get("product");
			
			//将无效酒店过滤掉
			if(hotelIndex.getCancelFlag().equals("N")||hotelIndex.getSaleFlag().equals("N")){
				continue;
			}
			
			//将包含长隆的酒店过滤掉
			/*if(hotelIndex.getProductName().contains("长隆")){
				continue;
			}*/
			
			HotelSearchHotelDto hotelBean = new HotelSearchHotelDto(); 
			//将结果中的产品转换为我们的产品信息
			
			BeanUtils.copyProperties(hotelIndex, hotelBean);
			//如果酒店的sellingdates为空，则该酒店不可卖 ,不进行下面操作
			if(StringUtils.isEmpty(hotelIndex.getSellingDates())){
				continue;
			}
			
			if(!hotelIndex.getSellingDates().contains(vaildDate)){
				continue;
			}
			//这里拿到goods、和product是同一个级别的
			if(null == item.get("goods")){
				continue;
			}
			
			Map<String,Map<String, Object>> vstRooms = (Map<String, Map<String, Object>>) item.get("goods");
			
			List<HotelSearchRoomDto> roomList = new ArrayList<HotelSearchRoomDto>();

			for(Map<String, Object> vstRoom:vstRooms.values()){
				
				if(null == vstRoom.get("branch")){
					continue;
				}
				if(CollectionUtils.isEmpty((ArrayList)vstRoom.get("goodsList"))){
					continue;
				}
				
				BranchBean vstRoomInfo = (BranchBean)vstRoom.get("branch");
				HotelSearchRoomDto room = new HotelSearchRoomDto();
				
				BeanUtils.copyProperties(vstRoomInfo,room);
				
				List<GoodsBean> vstPlans = (List<GoodsBean>)vstRoom.get("goodsList");
				List<HotelSearchPlanDto> planList = new ArrayList<HotelSearchPlanDto>();
				for(GoodsBean vstPlan:vstPlans){
					HotelSearchPlanDto plan = new HotelSearchPlanDto();
					BeanUtils.copyProperties(vstPlan, plan);
					if(!plan.getPayTarget().equals("PREPAID")){
						continue;
					}
					goodsIds.add(Long.valueOf(plan.getSuppGoodsId()));
					planList.add(plan);
					pricePlans.put(vstPlan.getSuppGoodsId(),plan);						
				}
				
				if(CollectionUtils.isNotEmpty(planList)){
					room.setPlans(planList);
					roomList.add(room);
				}
			}
			
			if(CollectionUtils.isNotEmpty(roomList)){//房间为空的话该产品不展示
				hotelBean.setRooms(roomList);
				hotels.add(hotelBean);
			}
		}
		requestMap.put("goodsIds", goodsIds);

		Map<String,List<FitHotelPlanPriceDto>> prices =  loadDayPrices(requestMap,days);
		for(Entry<String,List<FitHotelPlanPriceDto>> entrys : prices.entrySet()){
			HotelSearchPlanDto plan = pricePlans.get(entrys.getKey());
			if(entrys.getValue().size()==days){
				plan.setDayPrice(entrys.getValue());
				List<FitHotelPlanPriceDto> fitHotelPlanPriceDtos = plan.getDayPrice();
				//判断商品是否可卖
				Boolean isGoodsSale=isGoodsSaleAble(plan, Integer.parseInt(String.valueOf(days)), (int)hotelQueryRequest.getRoomCounts(),adultsCount);
				if(isGoodsSale){
					plan.setDayPrice(fitHotelPlanPriceDtos);
				}else{
					plan.setDayPrice(null);
				}
			}
		}
		
		hotelSearchResult.setResults(hotels);
		return hotelSearchResult;
		
	}
	
	private Map<String,List<FitHotelPlanPriceDto>> loadDayPrices(Map<String,Object> requestMap,Long days){
		logger.info("[adapter-search-hotel-loadDayPrices]调用主站查询时间价格表接口参数:requestMap:"+requestMap);
		//根据商品id查询时间价格表
		com.lvmama.vst.comm.vo.ResultHandleT<List<SuppGoodsTimePrice>> resultT = suppGoodsTimePriceClientService.findTimePriceBySpecDate(requestMap);
		/*try {
			logger.info("调用vst方法(findTimePriceBySpecDate)"+JSONMapper.getInstance().writeValueAsString(resultT));
		} catch (Exception e1) {
			e1.printStackTrace();
		}*/
		
		Map<String,List<FitHotelPlanPriceDto>>  dayPrices = new HashMap<String,List<FitHotelPlanPriceDto>>();

		//获取的时间价格表不为空，商品是预付的，并且符合入住几晚的要求
		if(null==resultT || null==resultT.getReturnContent() || resultT.getReturnContent().size() == 0){
			return dayPrices;
		}
		
		Date today = new Date();
		for(SuppGoodsTimePrice suppGoodsTimePrice:resultT.getReturnContent()){
			FitHotelPlanPriceDto fitHotelPlanPriceDto = new FitHotelPlanPriceDto();
			fitHotelPlanPriceDto.setInventoryCount(suppGoodsTimePrice.getStock()==null?0:suppGoodsTimePrice.getStock().intValue());//库存数量
			BigDecimal salePrice = suppGoodsTimePrice.getPrice()==null?new BigDecimal(0):new BigDecimal(suppGoodsTimePrice.getPrice());
			BigDecimal divideSale = salePrice.divide(new BigDecimal(100));//123.1--->124  产品要求
			fitHotelPlanPriceDto.setSalesPrice(divideSale.setScale(0, BigDecimal.ROUND_UP));//销售价
			BigDecimal settlePrice = suppGoodsTimePrice.getSettlementPrice()==null?new BigDecimal(0):new BigDecimal(suppGoodsTimePrice.getSettlementPrice());
			BigDecimal divide = settlePrice.divide(new BigDecimal(100));//123.1--->124  产品要求
			fitHotelPlanPriceDto.setSettlePrice(divide);//结算价---改为销售价  二期：结算价就是结算价
			fitHotelPlanPriceDto.setOriginalSalesPrice(fitHotelPlanPriceDto.getSalesPrice());//原始销售金额 
			fitHotelPlanPriceDto.setPromotion(fitHotelPlanPriceDto.getSalesPrice().subtract(fitHotelPlanPriceDto.getSalesPrice()));//优惠金额
			fitHotelPlanPriceDto.setPriceEveryDay(suppGoodsTimePrice.getSpecDate());//时间
			fitHotelPlanPriceDto.setOnsaleFlag(suppGoodsTimePrice.getOnsaleFlag());//房间是否可售
			fitHotelPlanPriceDto.setSpecDate(suppGoodsTimePrice.getSpecDate());//时间
			//判断是否在提前预定时间之前
			fitHotelPlanPriceDto.setIsBeforeAheadBookTime(suppGoodsTimePrice.isBeforeAheadBookTime(today));
			//判断是否过了最晚预定时间
			fitHotelPlanPriceDto.setIsBeforeLastHoldTime(suppGoodsTimePrice.isBeforeLastHoldTime(today));
			fitHotelPlanPriceDto.setFreeSaleFlag(suppGoodsTimePrice.getFreeSaleFlag());//是否保留库存
			fitHotelPlanPriceDto.setOversellFlag(suppGoodsTimePrice.getOvershellFlag());//是否可以超卖
			fitHotelPlanPriceDto.setAheadBookTime(suppGoodsTimePrice.getAheadBookTime());
			fitHotelPlanPriceDto.setLatestHoldTime(suppGoodsTimePrice.getLatestHoldTime());
			fitHotelPlanPriceDto.setStockFlag(suppGoodsTimePrice.getStockFlag());//是否保留库存（是否是非保留房）
			fitHotelPlanPriceDto.setStockStatus(suppGoodsTimePrice.getStockStatus());//房态
			fitHotelPlanPriceDto.setBookLimitType(suppGoodsTimePrice.getBookLimitType());//预定限制
			//添加到list中
			fitHotelPlanPriceDto.setBreakfast(suppGoodsTimePrice.getBreakfast());
			if(null==dayPrices.get(suppGoodsTimePrice.getSuppGoodsId()+"")){
				dayPrices.put(suppGoodsTimePrice.getSuppGoodsId()+"",new ArrayList<FitHotelPlanPriceDto>());
			}
			dayPrices.get(suppGoodsTimePrice.getSuppGoodsId()+"").add(fitHotelPlanPriceDto);
		}
		logger.info("spinach测试获得loadDayPrices成功");

		return dayPrices;
	}
	
	
	/**
	 * 商品是否可售
	 * @param adultsCount 
	 * @return
	 */
	private boolean isGoodsSaleAble(HotelSearchPlanDto plan,int days,int roomCounts, int adultsCount){
		List<FitHotelPlanPriceDto> timePriceList = plan.getDayPrice();
		//1.判断是否有时间价格,如果没有时间价格则不可售
		if(CollectionUtils.isEmpty(timePriceList)){
			return Boolean.FALSE;
		}
		//2.判断入住时间和时间价格数量是否相等
		if(days!=timePriceList.size()){
			return Boolean.FALSE;
		}
		//3.判断最少入住天数
		if(days < plan.getMinStayDay()){
			return Boolean.FALSE;
		}
		//4.判断最多入住天数
		if(days > plan.getMaxStayDay()){
			return Boolean.FALSE;
		}
		//5.判断最小预定量(成人数小于最小的预定分数)
		if(adultsCount < plan.getMinQuantity()){
			return Boolean.FALSE;
		}
		//6.判断最大预定量(默认推荐的房间数大于最大的预定分数)
		if(roomCounts > plan.getMaxQuantity()){
			return Boolean.FALSE;
		}
		//2.判断禁售+卖价+库存
		for(FitHotelPlanPriceDto timePrice : timePriceList){
			//1.可售性
			if(!"Y".equalsIgnoreCase(timePrice.getOnsaleFlag())){
				return Boolean.FALSE;
			}
			//2.是否有价格
			if(timePrice.getSettlePrice()==null){
				return Boolean.FALSE;
			}
			//3.判断提前预定时间
			if(!timePrice.getIsBeforeAheadBookTime()){
				return Boolean.FALSE;
			}
			//4.如果房态为满房
			if(FitHotelPlanPriceDto.STOCKSTATUS.FULL.name().equalsIgnoreCase(timePrice.getStockStatus())){
				return Boolean.FALSE;
			}
			//5.过滤掉预授权的商品
			/*if(timePrice.getBookLimitType().equals("PREAUTH")){
				return Boolean.FALSE;
			}*/
			//3.判断库存
			//1.如果是FreeSale
			if("Y".equalsIgnoreCase(timePrice.getFreeSaleFlag())){
				continue;
			}else {
				//2.如果是非保留房	
				if("N".equalsIgnoreCase(timePrice.getStockFlag())){
					continue;
				//3.如果是保留房
				}else if("Y".equalsIgnoreCase(timePrice.getStockFlag())){
					//如果保留房不可超卖并且超过最晚预订时间, 则不可售
					if("N".equals(timePrice.getOversellFlag()) && !timePrice.getIsBeforeLastHoldTime()){
						return Boolean.FALSE;
					}
					//1.有库存，并且库存不为0  则为可售
					if(timePrice.getInventoryCount()!=null&&timePrice.getInventoryCount()>=roomCounts){
						continue;
					//2.没有库存，但是可以超卖	
					}else if("Y".equals(timePrice.getOversellFlag())){
						return Boolean.FALSE;//应产品要求，库存为0，即使状态为可以超卖，也是不可售
						//continue;
					//3.都不符合，则不可卖	
					}else {
						return Boolean.FALSE;
					}
				//4.其余条件不可售	
				}else {
					return Boolean.FALSE;
				}
			}
		}
		return Boolean.TRUE;
	}

	@Autowired
	protected ComPhotoQueryClientService comPhotoQueryClientRemote;

	@Override
	public String findHotelImageUrl(Long hotelId) {
		List<ComPhoto> photoList = null;
		Object productPhotoCache = MemcachedUtil.getInstance().get(
				MemcachedEnum.ComPhotoList.getKey()
						+ ComPhoto.OBJECT_TYPE.PRODUCT_ID.getName() + hotelId);
		if (null != productPhotoCache) {
			photoList = (List<ComPhoto>) productPhotoCache;
		} else {
			photoList = comPhotoQueryClientRemote.findImageList(
					ComPhoto.OBJECT_TYPE.PRODUCT_ID.getName(), hotelId)
					.getReturnContent();
		}
		if (photoList != null && photoList.size() > 0) {
			return photoList.get(0).getPhotoUrl();
		}
		return "";
	}

}
