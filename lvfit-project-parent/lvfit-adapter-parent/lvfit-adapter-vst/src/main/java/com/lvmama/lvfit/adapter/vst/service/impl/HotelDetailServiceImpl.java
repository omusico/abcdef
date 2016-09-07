/**
 * Project Name:lvfit-adapter-vst
 * File Name:HotelDetailServiceImpl.java
 * Package Name:com.lvmama.lvfit.adapter.vst.service.impl
 * Date:2015-12-3下午5:39:45
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.adapter.vst.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.utils.BeanUtils;
import com.lvmama.lvfit.adapter.vst.adapter.CommentStatServiceAdapter;
import com.lvmama.lvfit.adapter.vst.adapter.GoodsServiceAdapter;
import com.lvmama.lvfit.adapter.vst.adapter.ProductServiceAdapter;
import com.lvmama.lvfit.adapter.vst.service.HotelDetailService;
import com.lvmama.lvfit.common.dto.hotel.FitHotelDto;
import com.lvmama.lvfit.common.dto.hotel.FitHotelPicDto;
import com.lvmama.lvfit.common.dto.hotel.FitHotelPlanDto;
import com.lvmama.lvfit.common.dto.hotel.FitHotelRoomDto;
import com.lvmama.lvfit.common.dto.request.FitHotelRequest;
import com.lvmama.lvfit.common.dto.vst.VstPicProduct;
import com.lvmama.lvfit.common.dto.vst.VstProdProductBranch;
import com.lvmama.lvfit.common.dto.vst.VstProduct;
import com.lvmama.lvfit.common.dto.vst.VstPropValue;
import com.lvmama.lvfit.common.dto.vst.VstSuppGoods;
import com.lvmama.vst.back.prod.po.PropValue;

/**
 * ClassName:HotelDetailServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-12-3 下午5:39:45 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Service
public class HotelDetailServiceImpl implements HotelDetailService{
	private static final Logger logger=LoggerFactory.getLogger(HotelDetailServiceImpl.class);
	/**
	 *  产品适配器
	 */
	@Autowired
	private ProductServiceAdapter productServiceAdapter;
	/**
	 *  商品适配器
	 */
	@Autowired
	private GoodsServiceAdapter goodsServiceAdapter;
	/**
	 *  评论适配器
	 */
	@Autowired
	private CommentStatServiceAdapter commentStatServiceAdapter;
	
	
	@Override
	public FitHotelDto getHotelDetailByHotelId(FitHotelRequest request) throws IllegalAccessException, InvocationTargetException {
		VstProduct product = productServiceAdapter.getHotelProductDetail(request,true,true);
		 FitHotelDto hotelDto = getHotelDto(product);
		/**
		 * 等好好评率稳定了再打开
		 */
		/*if(null != hotelDto.getId()){
			//新增好评率相关信息 根据地点ID
			VstCommentStat vstCommentStat = null;
			try {
				vstCommentStat = commentStatServiceAdapter.getVstCommentStatByPlaceId(hotelDto.getPlaceId(), "N");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//根据产品ID
			//VstCommentStat vstCommentStat = commentStatServiceAdapter.getVstCommentStatByProductId(product.getProductId());
			if(null != vstCommentStat && vstCommentStat.getProductId() != null){
				product.setVstCommentStat(vstCommentStat);
			}
		}*/
		/**
		 *  户型规格
		 */
		/*try {
			 List<VstProdProductBranch> branchList = goodsServiceAdapter.findHotelProductListForFront( request);
			 List<FitHotelRoomDto> roomList = getRoomList(branchList);
			 hotelDto.setHotelRooms(roomList);
		} catch (IllegalAccessException e) {
			logger.error("酒店详情获得房型规格出错！");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			logger.error("酒店详情获得房型规格出错！");
			e.printStackTrace();
		}*/
		return hotelDto;
	}

	/**
	 *  获得 规格列表
	 * @author wanghuihui
	 * @date:2015年12月8日 下午5:15:34
	 * @param branchList
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@SuppressWarnings("unchecked")
	private List<FitHotelRoomDto> getRoomList(List<VstProdProductBranch> branchList)
			throws IllegalAccessException, InvocationTargetException {
		if(null == branchList || branchList.size() == 0){	return null; }
		List<FitHotelRoomDto> list = new ArrayList<FitHotelRoomDto>();
		for(VstProdProductBranch branch:branchList){
			FitHotelRoomDto room = new FitHotelRoomDto();
			Map<String, Object> map = branch.getPropValue();
			if(map != null){
				room.setArea(map.get("area") != null ? map.get("area")+"":null);
				room.setFloor(map.get("floor") != null ? map.get("floor")+"":null);
				room.setBranchDesc(map.get("branch_desc") != null ? map.get("branch_desc")+"":null);
				
				room.setArea(map.get("area") != null ? map.get("area")+"":null);
				if(map.get("bed_type") != null){
					List<PropValue> origList = (List<PropValue>) map.get("bed_type");
					List<VstPropValue> destList = getDistList(origList);
					room.setBedType(destList);
				}
				if(map.get("internet") != null){
					List<PropValue> origList = (List<PropValue>) map.get("internet");
					List<VstPropValue> destList = getDistList(origList);
					room.setInternet(destList);
				}
			}
			if(branch.getVstSuppGoods() != null){
				List<FitHotelPlanDto> planList = getFitHotelPlanDto(branch.getVstSuppGoods());
				room.setHotelPlans(planList);
			}
			List<VstPicProduct> picList = branch.getPicList();
			if(picList != null && picList.size() >0){
				List<FitHotelPicDto> picDtoList = new ArrayList<FitHotelPicDto>();
				FitHotelPicDto picDto = new FitHotelPicDto();
				for(VstPicProduct pic : picList){
					picDto.setPhotoId(pic.getPhotoId());
					picDto.setPhotoUrl(pic.getPhotoUrl());
					picDtoList.add(picDto);
				}
				room.setPhoto(picDtoList);
			}
			room.setHotelId(branch.getProductBranchId());
			room.setRoomId(branch.getBranchId());
			room.setRoomName(branch.getBranchName());
			room.setRecommendLevel(branch.getRecommendLevel());
			room.setMaxVisitor(branch.getMaxVisitor());
			room.setSaleFlag(branch.getSaleFlag());
			room.setCancelFlag(branch.getCancelFlag());
			list.add(room);
		}
		return list;
	}

	
	private List<VstPropValue> getDistList(List<PropValue> origList) throws IllegalAccessException, InvocationTargetException {
		if(null != origList && origList.size() > 0){
			List<VstPropValue> destList = new ArrayList<VstPropValue>();
			for(PropValue orig : origList){
				VstPropValue dest = new VstPropValue();
				BeanUtils.copyProperties(dest, orig);
				destList.add(dest);
			}
			return destList;
		}
		return null;
	}

	/**
	 *  实体转换
	 * @author wanghuihui
	 * @date:2015年12月9日 上午10:13:34
	 * @param vstSuppGoods
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	private List<FitHotelPlanDto> getFitHotelPlanDto(
			List<VstSuppGoods> vstSuppGoods) throws IllegalAccessException, InvocationTargetException {
		if(vstSuppGoods == null || vstSuppGoods.size() ==0){
			return null;
		}
		List<FitHotelPlanDto> list = new ArrayList<FitHotelPlanDto>();
		FitHotelPlanDto planDto = null;
		for(int i=0;i<vstSuppGoods.size();i++){
			planDto = new FitHotelPlanDto();
			VstSuppGoods good = vstSuppGoods.get(i);
			BeanUtils.copyProperties(planDto, good);
			list.add(planDto);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	private FitHotelDto getHotelDto(VstProduct product) throws IllegalAccessException, InvocationTargetException {
		if(null == product || product.getProductId() == null){
			return null;
		}
		FitHotelDto hotelDto =  new FitHotelDto();
		hotelDto.setId(product.getProductId());
		hotelDto.setName(product.getProductName());
		if(null != product.getPropValue()){
			Map<String, Object> propValue = product.getPropValue();
			hotelDto.setAddress(propValue.get("address") != null ? propValue.get("address")+"":null);
			hotelDto.setDescription(propValue.get("description") != null ? propValue.get("description")+"":null);
			hotelDto.setEarliestArriveTime(propValue.get("earliest_arrive_time") != null ? propValue.get("earliest_arrive_time")+"":null);
			hotelDto.setLatestLeaveTime(propValue.get("latest_leave_time") != null ? propValue.get("latest_leave_time")+"":null);
			if(propValue.get("facilities") != null){
				List<Map<String,Object>> facilities = (List<Map<String, Object>>) propValue.get("");
				List<PropValue> origList = (List<PropValue>) propValue.get("facilities");
				List<VstPropValue> destList = getDistList(origList);
				hotelDto.setFacilities(destList);
			}
			hotelDto.setTraffic(propValue.get("traffic") != null ? propValue.get("traffic")+"":null);
			if(null != propValue.get("baidu_geo") && (propValue.get("baidu_geo")+"").indexOf(',')>0){
				String baidu_geo = propValue.get("baidu_geo")+"";
				hotelDto.setLongitude(baidu_geo.split(",")[0]);
				hotelDto.setLatitude(baidu_geo.split(",")[1]);
			}
			if(propValue.get("star_rate") != null){
				List<PropValue> stars = (List<PropValue>) propValue.get("star_rate");
				if(stars != null && stars.size()>0){
					hotelDto.setStar(stars.get(0).getName());
				}
			}
			hotelDto.setTelephone(propValue.get("telephone") != null ? propValue.get("telephone")+"":null);
			hotelDto.setDescription(propValue.get("description") != null ? propValue.get("description")+"":null);
			
			List<VstPicProduct> picList1 = product.getPicProductList();
			if(null != picList1 && picList1.size() > 0){
				List<FitHotelPicDto> picList2 = new ArrayList<FitHotelPicDto>();
				for(VstPicProduct pic : picList1){
					FitHotelPicDto pic2 = new FitHotelPicDto();
					BeanUtils.copyProperties(pic2, pic);
					picList2.add(pic2);
				}
				hotelDto.setPicList(picList2);
			}
		}
		return hotelDto;
	}

}

