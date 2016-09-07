/**
 * Project Name:lvfit-adapter-vst
 * File Name:GoodsServiceAdapterImpl.java
 * Package Name:com.lvmama.lvfit.adapter.vst.adapter.impl
 * Date:2015-11-12下午3:30:47
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.adapter.vst.adapter.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.utils.BeanUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.adapter.vst.adapter.GoodsServiceAdapter;
import com.lvmama.lvfit.common.dto.request.FitHotelPriceRequest;
import com.lvmama.lvfit.common.dto.request.FitHotelRequest;
import com.lvmama.lvfit.common.dto.request.FitHotelRoomRequest;
import com.lvmama.lvfit.common.dto.vst.VstPicProduct;
import com.lvmama.lvfit.common.dto.vst.VstProdProductBranch;
import com.lvmama.lvfit.common.dto.vst.VstSuppGoodPrice;
import com.lvmama.lvfit.common.dto.vst.VstSuppGoods;
import com.lvmama.vst.back.client.goods.service.SuppGoodsClientService;
import com.lvmama.vst.back.client.goods.service.SuppGoodsTimePriceClientService;
import com.lvmama.vst.back.client.prod.service.HotelProductClientService;
import com.lvmama.vst.back.goods.po.SuppGoods;
import com.lvmama.vst.back.goods.po.SuppGoodsTimePrice;
import com.lvmama.vst.back.goods.vo.HotelSuppGoodsVO;
import com.lvmama.vst.back.goods.vo.SuppGoodsParam;
import com.lvmama.vst.back.prod.vo.HotelProductBranchVO;
import com.lvmama.vst.back.prod.vo.HotelProductVO;
import com.lvmama.vst.back.pub.vo.ComPhotoVO;
import com.lvmama.vst.comm.vo.ResultHandleT;

/**
 * ClassName:GoodsServiceAdapterImpl <br/>
 * Function: vst商品适配器. <br/>
 * Date: 2015-11-12 下午3:30:47 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
@Service
public class GoodsServiceAdapterImpl implements GoodsServiceAdapter {


	private static final Logger logger = LoggerFactory.getLogger(GoodsServiceAdapterImpl.class);

	
	@Autowired
	private SuppGoodsClientService suppGoodsClientService;
	
	@Autowired
	private HotelProductClientService hotelProductClientService;
	
	@Autowired
	private  SuppGoodsTimePriceClientService suppGoodsTimePriceClientService;
	
	/**
	 * 根据商品Id查询商品详情
	 * 
	 * @param suppGoodsId 商品ID
	 * @return 商品详情
	 */
	@Override
	public VstSuppGoods getSuppGoodsById(FitHotelRoomRequest request) {
		VstSuppGoods vstSuppGoods = new VstSuppGoods();
		try {
			Long suppGoodsId = request.getRoomId();
			
			 SuppGoodsParam param = new SuppGoodsParam();
			BeanUtils.copyProperties(param, request);
			ResultHandleT<SuppGoods> resultHandleT = suppGoodsClientService.findSuppGoodsById(suppGoodsId, param);
			SuppGoods suppGoods = resultHandleT.getReturnContent();
			BeanUtils.copyProperties(vstSuppGoods, suppGoods);			
		} catch (Exception e) {
			logger.error("调用Vst根据id获取商品信息出现异常",e);
		}
		return vstSuppGoods;
	}

	@Override
	public List<VstSuppGoods> querySuppGoodsListByProductId(Long productId,
			Date startDate, Date endDate) {
		/*List<Long> goodsIds = new ArrayList<Long>();
		List<VstSuppGoods> resultList = new ArrayList<VstSuppGoods>();
		try {
			ResultHandleT<List<SuppGoods>> resultT = suppGoodsClientService.findSuppGoodsByProductId(productId);
			List<SuppGoods> suppGoodsList = resultT.getReturnContent();
			for (SuppGoods suppGoods : suppGoodsList) {
				VstSuppGoods vstSuppGoods = new VstSuppGoods();
				goodsIds.add(suppGoods.getSuppGoodsId());
				BeanUtils.copyProperties(vstSuppGoods, suppGoods);
				resultList.add(vstSuppGoods);
			}
			Map<String, Object> param= new HashMap<String, Object>();
			param.put("goodsIds", goodsIds);
			param.put("startDate", startDate);
			param.put("endDate", endDate);
			Map<String, Object>  conditionMap = new HashMap<String, Object>();
			conditionMap.put("getTopTwo", "false");
			conditionMap.put("getPropInfo", "false");
			conditionMap.put("hasProp", Boolean.TRUE);
			conditionMap.put("hasPropValue", Boolean.TRUE);
			conditionMap.put("removeRepeat", Boolean.TRUE);
			conditionMap.put("followOrder", "lvmamaRecommd");
			conditionMap.put("orderProdBranchFlag", Boolean.TRUE);
			conditionMap.put("orderProdFlag", Boolean.TRUE);
			List<HotelProductVO> list =	findHotelProductListForFront(goodsIds,startDate,endDate,conditionMap);	
			List<SuppGoodsTimePrice> list =	new ArrayList<SuppGoodsTimePrice>();
			for(HotelProductVO suppGoodsTimePrice:list){
				for(VstSuppGoods bean:resultList){
					if(bean.getSuppGoodsId().toString().equals(suppGoodsTimePrice.getSuppGoodsId().toString())){
						VstSuppGoodPrice vstSuppGoodPrice = new VstSuppGoodPrice();
						BeanUtils.copyProperties(vstSuppGoodPrice, suppGoodsTimePrice);
						bean.getSuppGoodPrices().add(vstSuppGoodPrice);
					}
				}				
			}			
		} catch (Exception e) {
			logger.error("调用Vst根据产品id获取商品列表出现异常",e);
			
		}*/
		return null;
	}
	
	
	
	
	/**
	 * 查询商品时间价格信息
	 * @param parameters
	 * @return
	 */
	public List<VstSuppGoodPrice> findTimePriceBySpecDate(FitHotelPriceRequest request){
		
		List<VstSuppGoodPrice> list = new ArrayList<VstSuppGoodPrice>();
		Map<String,Object> requestMap = new HashMap<String,Object>();
		List<Long> hotelIds = new ArrayList<Long>();
		hotelIds.add(request.getPricePlanId());
		requestMap.put("goodsIds", hotelIds);
		requestMap.put("startDate", request.getStartDate());
		requestMap.put("endDate", request.getEndDate());
		requestMap.put("isSale", Boolean.TRUE);// 是否可售
		ResultHandleT<List<SuppGoodsTimePrice>> resultT = suppGoodsTimePriceClientService.findTimePriceBySpecDate(requestMap);
		try {
			logger.info("调用vst方法(findTimePriceBySpecDate)"+JSONMapper.getInstance().writeValueAsString(resultT));
		} catch (JsonGenerationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(resultT.getReturnContent().size()>0){
			for(SuppGoodsTimePrice suppGoodsTimePrice:resultT.getReturnContent()){
				VstSuppGoodPrice vstSuppGoodPrice = new VstSuppGoodPrice();
				try {
					BeanUtils.copyProperties(vstSuppGoodPrice, suppGoodsTimePrice);
					list.add(vstSuppGoodPrice);
				} catch (Exception e) {
					logger.info("获取vst商品时间价格异常",e);
				} 
			}
		}		
		return list;
	}

	/**
	 * 查询产品规格，属性及商品信息
	 * @param productIdList
	 * @param startDate
	 * @param endDate
	 * @param conditionMap
	 * @return
	 */
	public  List<VstProdProductBranch> findHotelProductListForFront(FitHotelRequest request){
		List<Long> hotelIds = new ArrayList<Long>();
		hotelIds.add(request.getHotelId());
		if(null == request.getHotelId() || null == request.getStartDate() || null == request.getEndDate()){
			logger.error("获得产品规格时，参数出错!");
			return null;
		}
		ResultHandleT<List<HotelProductVO>> resultT = hotelProductClientService.findHotelProductListForFront(hotelIds, 
				request.getStartDate(), request.getEndDate(), request.getConditionMap() );
		//logger.info("调用vst方法(findHotelProductListForFront)返回值"+JSON.toJSONString(resultT));
		List<VstProdProductBranch> resultList = new ArrayList<VstProdProductBranch>();
		List<HotelProductVO> vstResultList = resultT.getReturnContent();
		try{
			for(HotelProductVO hotelProductVO:vstResultList){
				List<HotelProductBranchVO> listHotel = hotelProductVO.getHotelProductBranchList();
				for(HotelProductBranchVO hotelProductBranchVO:listHotel){
					VstProdProductBranch vstProductBranch = new VstProdProductBranch();
					Map<String, Object> maps = hotelProductBranchVO.getPropValue();
					Map<String, Object> resultValue = new HashMap<String,Object>();
					Iterator<Entry<String, Object>> iterator = maps.entrySet().iterator();
					while (iterator.hasNext()) {  
			            Map.Entry<String, Object> entry = iterator.next();
			            resultValue.put(entry.getKey(), entry.getValue());
					}
					BeanUtils.copyProperties(vstProductBranch, hotelProductBranchVO);
					List<VstSuppGoods> vstSuppGoods = new ArrayList<VstSuppGoods>();
					List<HotelSuppGoodsVO> vstHotelList =hotelProductBranchVO.getHotelSuppGoodsList();
					if(null != vstHotelList && vstHotelList.size() >0){
						for(HotelSuppGoodsVO hotelSuppGoodsVO:vstHotelList){
							VstSuppGoods vstGoods = new VstSuppGoods();
							BeanUtils.copyProperties(vstGoods,hotelSuppGoodsVO);
							vstSuppGoods.add(vstGoods);
						}
					}
					List<ComPhotoVO> list = hotelProductBranchVO.getPhotoList();
					if(null != list && list.size() >0){
						List<VstPicProduct> picList = new ArrayList<VstPicProduct>();
						for(ComPhotoVO photo:list){
							VstPicProduct pic = new VstPicProduct();
							pic.setPhotoId(photo.getPhotoId());
							pic.setPhotoUrl(photo.getPhotoUrl());
							picList.add(pic);
						}
						vstProductBranch.setPicList(picList);
					}
					vstProductBranch.setVstSuppGoods(vstSuppGoods);
					vstProductBranch.setPropValue(resultValue);
					resultList.add(vstProductBranch);
				}
			}
			
		}catch(Exception e){
			logger.info("调用vst获取产品规格及规格下的商品出现异常",e);
		}
		return resultList;
		
	}

}
