package com.lvmama.lvfit.adapter.search.adapter.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.comm.search.vst.vo.GoodsBean;
import com.lvmama.comm.search.vst.vo.GoodsIndexBean;
import com.lvmama.comm.search.vst.vo.TicketBean;
import com.lvmama.comm.search.vst.vo.TicketIndexBean;
import com.lvmama.lvf.common.dto.RequestResponse;
import com.lvmama.lvf.common.dto.enums.InterfaceKey;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.adapter.search.adapter.SpotSearchAdapter;
import com.lvmama.lvfit.adapter.vst.adapter.TicketServiceAdapter;
import com.lvmama.lvfit.common.dto.price.FitTicketAddTimePriceDto;
import com.lvmama.lvfit.common.dto.request.FitTicketDetailRequest;
import com.lvmama.lvfit.common.dto.request.FitTicketPriceRequest;
import com.lvmama.lvfit.common.dto.search.spot.SpotQueryRequest;
import com.lvmama.lvfit.common.dto.search.spot.SpotSearchResult;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchTicketDto;
import com.lvmama.lvfit.common.dto.ticket.FitTicketGoodsDetailDto;
import com.lvmama.lvfit.common.utils.FitLoggerHandler;
import com.lvmama.vst.newsearch.service.LvmamaFlightService;
import com.lvmama.vst.search.api.vo.PageConfigVo;
import com.lvmama.vst.search.api.vo.ResultHandleT;
import com.lvmama.vst.search.api.vo.SearchResultVo;

/**
 * 景点搜索适配接口实现
 * @author leizhengwei
 *
 */
@Service
public class SpotSearchAdapterImpl implements SpotSearchAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(SpotSearchAdapterImpl.class);
	
	@Autowired
	private LvmamaFlightService lvmamaFlightService;
	
	@Autowired
	private TicketServiceAdapter ticketServiceAdapter;
	
	@Autowired
	private FitLoggerHandler fitLoggerHandler;
	
	private static final String ITEM_KEY_PRODUCT = "product"; 
	
	private static final String ITEM_KEY_GOODS = "goods"; 
	
	private static final String ITEM_KEY_LVMAMAPRODUCT = "lvmamaProduct";
	
	private static final String ITEM_KEY_SUPPGOODS = "suppgoods";
	

	@SuppressWarnings("unchecked")
	@Override
	public SpotSearchResult<SpotSearchSpotDto> searchSpot(SpotQueryRequest spotQueryRequest) {

		SpotSearchResult<SpotSearchSpotDto> spotSearchResult = new SpotSearchResult<SpotSearchSpotDto>();
		List<SpotSearchSpotDto> searchSpotDtos = new ArrayList<SpotSearchSpotDto>();
		List<String> ticketsList = new ArrayList<String>();
		ticketsList.add(ITEM_KEY_GOODS);
		ticketsList.add(ITEM_KEY_SUPPGOODS);
		//int days = DateUtils.getDateDiffByDay(spotQueryRequest.getStartDate(), spotQueryRequest.getEndDate());
		//1. 从vst搜索接口获取景点门票数据
		//ResultHandleT<SearchResultVo> resultHandle = lvmamaFlightService.searchAroundTicket(spotQueryRequest.getHotelId(), spotQueryRequest.getSize(), spotQueryRequest.getDistance(), spotQueryRequest.getSortNum());
		//根据木的地查询
		try {
			logger.error("spotSearchResult:["+JSONMapper.getInstance().writeValueAsString(spotQueryRequest)+"]");
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
		}
		String gid= UUID.randomUUID().toString();
		Object returnObj = null;
		fitLoggerHandler.addFitLog(RequestResponse.RE.toString(), InterfaceKey.SearchSpotTicketFormVst.name(), spotQueryRequest, StringUtils.EMPTY, gid);
		ResultHandleT<SearchResultVo> resultHandle = null;
		try {
			resultHandle =lvmamaFlightService.getTicketIndexBeansByDestId(spotQueryRequest.getDestinationId(), spotQueryRequest.getSize(), 0);
			returnObj = resultHandle;
		} catch (Exception e) {
			returnObj = ExceptionUtils.getFullStackTrace(e);
			throw new RuntimeException(e);
		}finally{
			fitLoggerHandler.addFitLog(RequestResponse.RS.toString(), InterfaceKey.SearchSpotTicketFormVst.name(), returnObj, StringUtils.EMPTY, gid);
		}
		if(resultHandle == null){
			return spotSearchResult;
		}
		if(null == resultHandle.getReturnContent()){
			return spotSearchResult;
		}
		if(null == resultHandle.getReturnContent().getPageConfig()){
			return spotSearchResult;
		}
		PageConfigVo<?> pageConfig = resultHandle.getReturnContent().getPageConfig();
		
		//2. 解析景点门票数据
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> items = (List<Map<String, Object>>) pageConfig.getItems();
		if(CollectionUtils.isEmpty(items)){
			return null;
		}
		for(Map<String,Object> item:items){
		
			//2.1. 获取产品
			if(null == item.get(ITEM_KEY_PRODUCT)){
				continue;
			}
			TicketBean ticketBean = (TicketBean) item.get(ITEM_KEY_PRODUCT);
			
			//2.1.1 过滤产品中的“品类为12”的其他门票
			if(ticketBean.getCategoryId().equals("12")){
				continue;
			}
			SpotSearchSpotDto  searchSpotDto = new SpotSearchSpotDto(); 
			BeanUtils.copyProperties(ticketBean, searchSpotDto);
			
			//2.2. 获取商品
			if(null == item.get(ITEM_KEY_GOODS) && null == item.get(ITEM_KEY_SUPPGOODS)){
				continue;
			}
			
			List<GoodsBean> goodsBeans = new ArrayList<GoodsBean>();
			List<Long> suppGoodIds = new ArrayList<Long>();
			List<SpotSearchTicketDto> spotSearchTicketDtos = new ArrayList<SpotSearchTicketDto>();
			List<SpotSearchTicketDto> delSpotSearchTicketDtos = new ArrayList<SpotSearchTicketDto>();
			
			for (String ticket : ticketsList) {
				if(null == item.get(ticket)){
					continue;
				}else{
					List<GoodsBean> newGoodsBeans = (List<GoodsBean>)item.get(ticket);
					goodsBeans.addAll(newGoodsBeans);
				}
			}
			
			for (GoodsBean goodsBean : goodsBeans) {
				//目前只过滤现付的门票
				if(!goodsBean.getPayTarget().equals("PREPAID")){
					continue;
				}
				//if(goodsBean.getCategoryId().equals("12")){
				//	continue;
				//}
				if(1 > goodsBean.getMaxQuantity()){//最小的订购量都按照1来过滤，
					continue;
				}
				if(spotQueryRequest.getVisitorNum() < goodsBean.getMinQuantity()){//总人数小于最小订购量
					continue;
				}
				SpotSearchTicketDto searchTicketDto = new SpotSearchTicketDto();
				BeanUtils.copyProperties(goodsBean, searchTicketDto);
				searchTicketDto.setMaxQuantity(searchTicketDto.getMaxQuantity()>spotQueryRequest.getVisitorNum()?spotQueryRequest.getVisitorNum():searchTicketDto.getMaxQuantity());
				//searchTicketDto.setMinQuantity(0);
				//searchTicketDto.setMaxQuantity(spotQueryRequest.getVisitorNum());
				spotSearchTicketDtos.add(searchTicketDto);
				suppGoodIds.add(Long.valueOf(searchTicketDto.getSuppGoodsId()));
			}
			
			//2.3 过滤门票数据
			Map<Long,List<FitTicketAddTimePriceDto>>  usefulTicketTimePriceMap = new HashMap<Long, List<FitTicketAddTimePriceDto>>();
			
			FitTicketPriceRequest ticketPriceRequest = new FitTicketPriceRequest(); 
			ticketPriceRequest.setSuppGoodIds(suppGoodIds);
			ticketPriceRequest.setStartDate(spotQueryRequest.getStartDate());
			ticketPriceRequest.setEndDate(spotQueryRequest.getEndDate());
			try {
				logger.debug("调用时间价格表参数:["+JSONMapper.getInstance().writeValueAsString(ticketPriceRequest)+"]");
			} catch (Exception e) {
				logger.error(ExceptionUtils.getStackTrace(e));
			}
			List<FitTicketAddTimePriceDto> ticketAddTimePriceDtos =  ticketServiceAdapter.findGoodsAddTimePrice(ticketPriceRequest);
			try {
				logger.debug("时间价格表:["+JSONMapper.getInstance().writeValueAsString(ticketAddTimePriceDtos)+"]");
			} catch (Exception e) {
				logger.error(ExceptionUtils.getStackTrace(e));
			}
			Map<Long,List<FitTicketAddTimePriceDto>>  ticketTimePriceMap = new HashMap<Long, List<FitTicketAddTimePriceDto>>();
			if(CollectionUtils.isNotEmpty(ticketAddTimePriceDtos)){
				
				//2.3.1 过滤出未返回时间价格表的商品
				for (FitTicketAddTimePriceDto ticketAddTimePriceDto : ticketAddTimePriceDtos) {
					   Long key = ticketAddTimePriceDto.getSuppGoodsId();
						if(ticketTimePriceMap.keySet().contains(key)){
							ticketTimePriceMap.get(key).add(ticketAddTimePriceDto);
						}else{
							List<FitTicketAddTimePriceDto> timePriceDtos = new ArrayList<FitTicketAddTimePriceDto>();	
							timePriceDtos.add(ticketAddTimePriceDto);
							ticketTimePriceMap.put(key, timePriceDtos);
						}
				}
				for (Long suppGoodId : suppGoodIds) {
					if(ticketTimePriceMap.keySet().contains(suppGoodId)){
						usefulTicketTimePriceMap.put(suppGoodId, ticketTimePriceMap.get(suppGoodId));
					}
				}
				//2.3.1 根据时间价格过滤出不符合条件的商品
				try {
					logger.debug("【"+searchSpotDto.getProductId()+"】未过滤spotSearchTicketDtos:["+JSONMapper.getInstance().writeValueAsString(spotSearchTicketDtos)+"]");
				} catch (Exception e) {
					logger.error(ExceptionUtils.getStackTrace(e));
				} 
				for (SpotSearchTicketDto searchTicketDto : spotSearchTicketDtos) {
					
					if(usefulTicketTimePriceMap.containsKey(Long.valueOf(searchTicketDto.getSuppGoodsId()))){
						List<FitTicketAddTimePriceDto> timePriceDtos = usefulTicketTimePriceMap.get(Long.valueOf(searchTicketDto.getSuppGoodsId()));
						//过滤时间价格表 
						timePriceDtos = filterTimePriceDtos(timePriceDtos);
						if(CollectionUtils.isNotEmpty(timePriceDtos)){
							searchTicketDto.setDayTimePriceDtos(timePriceDtos);
							// 查找门票详情
							FitTicketDetailRequest dtlReq = new FitTicketDetailRequest();
							dtlReq.setSuppGoodsId(Long.valueOf(searchTicketDto.getSuppGoodsId()));
							FitTicketGoodsDetailDto ticketDetailDto = ticketServiceAdapter.findGoodsDetail(dtlReq);
							if(null!=ticketDetailDto.getDays()&&ticketDetailDto.getDays()>0){
								searchTicketDto.setTicketGoodsDetailDto(ticketDetailDto);
							}else{
								delSpotSearchTicketDtos.add(searchTicketDto);
							}
						}else{
							delSpotSearchTicketDtos.add(searchTicketDto);
						}
					}else{
						delSpotSearchTicketDtos.add(searchTicketDto);
					}
				}
				try {
					logger.debug("【"+searchSpotDto.getProductId()+"】未过滤delSpotSearchTicketDtos:["+JSONMapper.getInstance().writeValueAsString(delSpotSearchTicketDtos)+"]");
				} catch (Exception e) {
					logger.debug(ExceptionUtils.getStackTrace(e));
				} 
				spotSearchTicketDtos.removeAll(delSpotSearchTicketDtos);
				try {
					logger.debug("【"+searchSpotDto.getProductId()+"】已过滤spotSearchTicketDtos:["+JSONMapper.getInstance().writeValueAsString(spotSearchTicketDtos)+"]");
				} catch (Exception e) {
					logger.debug(ExceptionUtils.getStackTrace(e));
				} 
				
				if(CollectionUtils.isNotEmpty(spotSearchTicketDtos)){
					searchSpotDto.setSpotTickets(spotSearchTicketDtos);
					searchSpotDtos.add(searchSpotDto);
				}
			}
			try {
				logger.error("最终searchSpotDtos:["+JSONMapper.getInstance().writeValueAsString(searchSpotDtos)+"]");
			} catch (Exception e) {
				logger.error(ExceptionUtils.getStackTrace(e));
			}
			spotSearchResult.setResults(searchSpotDtos);
		}
		return spotSearchResult;
	}
	/**
	 * 过滤时间价格表
	 * @param timePriceDtos
	 * @return
	 */
	private List<FitTicketAddTimePriceDto> filterTimePriceDtos(List<FitTicketAddTimePriceDto> timePriceDtos) {
		List<FitTicketAddTimePriceDto> result = new ArrayList<FitTicketAddTimePriceDto>();
		for (FitTicketAddTimePriceDto fitTicketAddTimePriceDto : timePriceDtos) {
			//过滤掉预授权的商品
			if(!fitTicketAddTimePriceDto.getBookLimitType().equals("PREAUTH")){
				result.add(fitTicketAddTimePriceDto);
			}
		}
		return result;
	}

	/**
	 * 判断商品是否可售
	 * @param timePriceDtos
	 * @param spotQueryRequest
	 * @return
	 */
	private  boolean isGoodsSaleAble(List<FitTicketAddTimePriceDto> timePriceDtos){
		
		if(CollectionUtils.isNotEmpty(timePriceDtos)){
			for (FitTicketAddTimePriceDto fitTicketAddTimePriceDto : timePriceDtos) {
				//过滤掉预授权的商品
				if(fitTicketAddTimePriceDto.getBookLimitType().equals("PREAUTH")){
					return Boolean.FALSE;
				}
			}
		}
		return Boolean.TRUE;
	}
	
	public static void main(String[] args) {
		
		
		Map<Long,List<FitTicketAddTimePriceDto>>  usefulTicketTimePriceMap = new HashMap<Long, List<FitTicketAddTimePriceDto>>();
		Long key = 1610033L;
		usefulTicketTimePriceMap.put(key, new ArrayList<FitTicketAddTimePriceDto>());
		
		System.out.println(usefulTicketTimePriceMap.containsKey(key));
		
	}
	
}
