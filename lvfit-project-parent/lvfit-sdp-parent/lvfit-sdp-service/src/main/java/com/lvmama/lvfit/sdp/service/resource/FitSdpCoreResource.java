package com.lvmama.lvfit.sdp.service.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lvmama.lvf.common.dto.flight.FlightLowPriceDayCacheDto;
import com.lvmama.lvfit.common.utils.FliMemcachedUtil;
import org.apache.commons.collections.CollectionUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.path.SdpClientPath;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.JudgeType;
import com.lvmama.lvfit.common.dto.enums.Product;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelComboGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelGroupDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelRoomtypeDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpInsuranceDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpOtherTicketDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpRoomDiff;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitChangeFlightRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitChangeHotelComboRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitChangeHotelGroupRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpGoodsRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpUpdShoppingRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.request.FitSdpUpdateShoppingRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpInstalmentDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductCalendarDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductCalendarRequest;
import com.lvmama.lvfit.common.dto.sdp.product.result.FitSdpGroupCalendarSearchResult;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpSelectInsuranceDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpSelectOtherTicketDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpShoppingDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.request.FitSdpShoppingRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchSeatDto;
import com.lvmama.lvfit.common.dto.search.flight.result.MockUtil;
import com.lvmama.lvfit.sdp.core.service.FitSdpService;
import com.lvmama.lvfit.sdp.core.service.impl.FitSdpServiceImpl;
import com.lvmama.lvfit.sdp.shopping.FitSdpShoppingService;

@Component
@Path("")
public class FitSdpCoreResource {

    @Autowired
    private FitSdpService fitSdpService;

    @Autowired
    private FitSdpShoppingService fitSdpShoppingService;

    @POST
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(SdpClientPath.Path.PACKAGE_PRODUCT_BASIC_INFO_SEARCH)
    public Response getProductInfo(@PathParam("productId") Long productId) {
        FitSdpProductBasicInfoDto basicInfo = fitSdpService.searchProductBasicInfo(productId);
        return Response.ok(basicInfo).build();
    }
    
    @POST
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(SdpClientPath.Path.PACKAGE_PRODUCT_BASIC_INFO_SEARCH_PREVIEW)
    public Response getProductInfoPreview(@PathParam("productId") Long productId) {
        FitSdpProductBasicInfoDto basicInfo = fitSdpService.searchProductBasicInfoPreview(productId);
        return Response.ok(basicInfo).build();
    }
    
    @POST
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(SdpClientPath.Path.PACKAGE_PRODUCT_INFO_ONLY_SEARCH)
    public Response getProductInfoOnly(@PathParam("productId") Long productId) {
        FitSdpProductBasicInfoDto basicInfo = fitSdpService.searchProductInfoOnly(productId);
        return Response.ok(basicInfo).build();
    }
    
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(SdpClientPath.Path.PACKAGE_GOODS_INFO_SEARCH)
    public Response getGoodsInfo(FitSdpGoodsRequest goodsRequest) {
        // 搜索商品信息
        FitSdpGoodsDto searchGoodsInfo = fitSdpService.searchGoodsInfo(goodsRequest);
        return Response.ok(searchGoodsInfo).build();
    }

    

    @POST
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(SdpClientPath.Path.SEARCH_CALENDAR_INFO_BY_PRODUCT_ID)
    public Response searchCalendarInfoByProductId(@PathParam("productId") Long productId) {
    	Map<Long,BigDecimal>startPriceMap = fitSdpService.searchCalendarInfoByProductId(productId);
        return Response.ok(startPriceMap).build();
    }

   
	 
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path(SdpClientPath.Path.PRODUCT_CLENDAR_SEARCH)
	public Response searchCalendarInfo(FitSdpProductCalendarRequest calendarRequest){
		FitSdpGroupCalendarSearchResult<FitSdpProductCalendarDto> result = fitSdpService.searchCalendarInfo(calendarRequest);
		// 根据起价和分期价规则设置分期价
		List<FitSdpInstalmentDto> instalments = result.getInstalments();
		BigDecimal startPrice = result.getStartPrice();
		if (CollectionUtils.isNotEmpty(instalments)) {
		    for (FitSdpInstalmentDto instalment: instalments) {
		        BigDecimal periods = instalment.getTerm();
		        BigDecimal rate = instalment.getInterestRate().divide(BigDecimal.valueOf(100));
		        BigDecimal price = startPrice.divide(periods, 3, BigDecimal.ROUND_HALF_UP).add(startPrice.multiply(rate)).setScale(2, BigDecimal.ROUND_HALF_UP);
		        instalment.setPrice(price);
		    }
		}
		return Response.ok(result).build();
	}
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(SdpClientPath.Path.CHANGE_HOTEL_COMBO)
    public Response changeHotelCombo(FitChangeHotelComboRequest req) {
	    FitSdpShoppingDto shoppingDto = fitSdpShoppingService.getFitSdpShoppingDto(req.getShoppingUuid());
	    for (FitSdpHotelComboGoodsDto hotelCombo : shoppingDto.getHotelCombos()) {
	        if (hotelCombo.getSuppGoodsId().equals(req.getSuppGoodsId())) {
	            shoppingDto.setSelectedHotelComboGoods(hotelCombo);
	            hotelCombo.setIsBeSelected(JudgeType.Y.name());
	        } else {
	            hotelCombo.setIsBeSelected(JudgeType.N.name());
	        }
	    }
	    fitSdpShoppingService.putShoppingCache(req.getShoppingUuid(), shoppingDto);
	    return Response.ok(shoppingDto.getHotelCombos()).build();
    }
	
	/**
	 * 替换原有的已经选中的酒店的列表.
	 * @param selectedRoomtypes
	 * @param room
	 */
	private void exchangeSelectedRoom(List<FitSdpHotelRoomtypeDto> selectedRoomtypes,FitSdpHotelRoomtypeDto newRoom){
		Long groupId = newRoom.getGroupId();
		int selectIndex = 0;
		for(int i=0,j=selectedRoomtypes.size();i<j;i++){
			FitSdpHotelRoomtypeDto r = selectedRoomtypes.get(i);
			if(r.getGroupId().equals(groupId)){
				selectIndex = i;
				break;
			}
		}
		//先移除原有位置上面的对象
		selectedRoomtypes.remove(selectIndex);
		//添加新的选择的房型
		selectedRoomtypes.add(newRoom);
	}
	
	/**
	 * 更新缓存中的三级数据结构里面的选择状态.
	 * @param groups
	 * @param req
	 */
	private List<FitSdpHotelGroupDto> exchangeSelectRoomInGroups(List<FitSdpHotelGroupDto> groups,FitChangeHotelGroupRequest req){
		for(int i=0,j=groups.size();i<j;i++){
			FitSdpHotelGroupDto g = groups.get(i);
			//只更新一个组下面的被选中状态.因为不可能一次更新两个分组下面的选择状态
			if(g.getGroupId().equals(req.getGroupId())){
				LinkedList<FitSdpHotelDto> hotels = g.getHotels();
				for(int ii=0,jj=hotels.size();ii<jj;ii++){
					FitSdpHotelDto h = hotels.get(ii);
					if(h.getHotelId().equals(req.getHotelId())){
						h.setIsBeSelected("Y");
						LinkedList<FitSdpHotelRoomtypeDto> rooms = h.getFangXinList();
						for(int iii=0,jjj=rooms.size();iii<jjj;iii++){
							FitSdpHotelRoomtypeDto r  = rooms.get(iii);
							if(r.getGoodsId().equals(req.getSuppGoodsId())){
								r.setRoomCount(req.getRoomCount());//设置入住的房间数量
								r.setIsBeSelected("Y");
							}else{
								r.setRoomCount(r.getMinCount().intValue());//默认入住最少的数量
								r.setIsBeSelected("N");
							} 
						}
					}else{
						h.setIsBeSelected("N");
						LinkedList<FitSdpHotelRoomtypeDto> rooms = h.getFangXinList();
						for(int iii=0,jjj=rooms.size();iii<jjj;iii++){
							FitSdpHotelRoomtypeDto r  = rooms.get(iii);
							r.setRoomCount(r.getMinCount().intValue());//默认入住最少的数量
							r.setIsBeSelected("N");
						}
					}
				}
			}
		}
		return groups;
	}
	
	/**
	 * 重新设置已经选中的房型列表
	 * @param allGroups
	 * @return
	 */
	private List<FitSdpHotelRoomtypeDto> resetSelectedRooms(List<FitSdpHotelGroupDto> allGroups){
		List<FitSdpHotelRoomtypeDto> allSeletedRooms= new ArrayList<FitSdpHotelRoomtypeDto>();
		for(int i=0,j=allGroups.size();i<j;i++){
			FitSdpHotelGroupDto group = allGroups.get(i);
			LinkedList<FitSdpHotelDto> allHotels = group.getHotels();
			for(int ii=0,jj=allHotels.size();ii<jj;ii++){
				FitSdpHotelDto hotel = allHotels.get(ii);
				if("Y".equals(hotel.getIsBeSelected())){
					LinkedList<FitSdpHotelRoomtypeDto> allRooms = hotel.getFangXinList();
					for(int iii=0,jjj=allRooms.size();iii<jjj;iii++){
						FitSdpHotelRoomtypeDto room =allRooms.get(iii);
						if("Y".equals(room.getIsBeSelected())){
							allSeletedRooms.add(room);   
						}
					} 
				}
			}
		}
		return allSeletedRooms;
	}
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(SdpClientPath.Path.CHANGE_HOTEL_GROUP)
    public Response changeHotelGroup(FitChangeHotelGroupRequest req) {
		FitSdpShoppingDto shoppingDto = fitSdpShoppingService.getFitSdpShoppingDto(req.getShoppingUuid());
	     
	    //下面更新缓存中的三级数据结构里面的房型被选中的数据.
	    List<FitSdpHotelGroupDto> allGroups = shoppingDto.getHotelGroups(); 
	    allGroups = exchangeSelectRoomInGroups(allGroups,req);
	    //更新为新的数据
	    shoppingDto.setHotelGroups(allGroups); 
	    
	    //更新当前选中的酒店房型信息.
	    shoppingDto.setSelectedRoomtypes(resetSelectedRooms(shoppingDto.getHotelGroups())); 
	    
	    fitSdpShoppingService.putShoppingCache(req.getShoppingUuid(), shoppingDto);
	    return Response.ok(shoppingDto.getHotelGroups()).build();
    }
	
	  
	
	/**
	 * 清除缓冲中已经选中的往返程航班信息.
	 * @param shoppingDto
	 * @param cleanChoosedFlight 是否是包机中选中航班的信息.
	 */
	private void clearSelectFlight(FitSdpShoppingDto shoppingDto,boolean cleanChoosedFlight){
		//清除包机航班中的选择的往返程信息.
		if(cleanChoosedFlight){
			 List<FlightSearchFlightInfoDto> flightInfos = shoppingDto.getCharterFlightInfos();
			 if(CollectionUtils.isNotEmpty(flightInfos)){
				 for(FlightSearchFlightInfoDto dto:flightInfos){
					 dto.setBackOrTo(null);
					 dto.getReturnFlightInfoDto().get(0).setBackOrTo(null);
				 }
			 }
		}else{
			List<FlightSearchFlightInfoDto> arvFlightInfos = shoppingDto.getArvFlightInfos();
			List<FlightSearchFlightInfoDto> depFlightInfos = shoppingDto.getDepFlightInfos();
			if(CollectionUtils.isNotEmpty(arvFlightInfos)){
				 for(FlightSearchFlightInfoDto dto:arvFlightInfos){
					 dto.setBackOrTo(null); 
				 }
			 }
			
			if(CollectionUtils.isNotEmpty(depFlightInfos)){
				 for(FlightSearchFlightInfoDto dto:depFlightInfos){
					 dto.setBackOrTo(null); 
				 }
			 }
		}
	}
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(SdpClientPath.Path.CHANGE_FLIGHT)
    public Response changeFlight(FitChangeFlightRequest req) {
//        FitSdpShoppingDto shoppingDto = fitSdpShoppingService.getFitSdpShoppingDto(req.getShoppingUuid());
        FitSdpShoppingDto shoppingDto = MockUtil.morkShoppingDto();
        List<FlightSearchFlightInfoDto> selectedFlightInfos = shoppingDto.getSelectedFlightInfos();
        
        FitSdpShoppingRequest shoppingRequest = shoppingDto.getFitSdpShoppingRequest();
        // 基准价=成人数*成人价+儿童数*儿童价
        BigDecimal adultQuantity = BigDecimal.valueOf(shoppingRequest.getFitPassengerRequest().getAdultCount());
        BigDecimal childQuantity = BigDecimal.valueOf(shoppingRequest.getFitPassengerRequest().getChildCount());
        Long quantity = shoppingRequest.getQuantity();
        BigDecimal basePrice = BigDecimal.ZERO;
        
        List<FlightSearchFlightInfoDto> flightInfos = null;
        if (req.getFlightTripType().equals(FlightTripType.DEPARTURE.name())) {
            flightInfos = shoppingDto.getDepFlightInfos();
        }
        if (req.getFlightTripType().equals(FlightTripType.RETURN.name())) {
            flightInfos = shoppingDto.getArvFlightInfos();
        }
        if (req.getFlightTripType().equals(FlightTripType.CHARTER.name())) {
            flightInfos = shoppingDto.getCharterFlightInfos();
        }
        if (CollectionUtils.isNotEmpty(flightInfos)) {
        	//如果是往返程，就按照以前的逻辑
        	if (!req.getFlightTripType().equals(FlightTripType.CHARTER.name())) {
        		 for (FlightSearchFlightInfoDto flightInfo : flightInfos) {
	                if (flightInfo.getFlightNo().equals(req.getFlightNo())) {
	                    BigDecimal iniAdultPrice = flightInfo.getSeats().get(0).getSalesPrice();
	                    BigDecimal iniChildPrice = flightInfo.getSeats().get(0).getChildrenPrice();
	                    
	                    basePrice = iniAdultPrice.multiply(adultQuantity).add(iniChildPrice.multiply(childQuantity));
	                    if (req.getFlightTripType().equals(FlightTripType.DEPARTURE.name())) {
	                    	flightInfo.setBackOrTo(FlightTripType.DEPARTURE.name());
	                        selectedFlightInfos.set(0, flightInfo);
	                    }
	                    if (req.getFlightTripType().equals(FlightTripType.RETURN.name())) {
	                    	flightInfo.setBackOrTo(FlightTripType.RETURN.name());
	                        selectedFlightInfos.set(1, flightInfo);
	                    }
	                    break;
	                }
	            }
        		 
	            for (FlightSearchFlightInfoDto searchFlight : flightInfos) {
	                for (FlightSearchSeatDto seat : searchFlight.getSeats()) {
	                    BigDecimal curPrice = seat.getSalesPrice().multiply(adultQuantity).add(seat.getChildrenPrice().multiply(childQuantity));
	                    seat.setDifferentPrice((curPrice.subtract(basePrice)).multiply(BigDecimal.valueOf(quantity)));
	                }
	            }
	            
	            clearSelectFlight(shoppingDto,true); 
        	}
        	//包机的逻辑        	
        	else{
        		//循环全部的包机的航班
        		for (FlightSearchFlightInfoDto flightInfo : flightInfos) {
        			//去程航班号匹配
        			if (flightInfo.getFlightNo().equals(req.getFlightNo())) { 
             			FlightSearchFlightInfoDto backFlight = flightInfo.getReturnFlightInfoDto().get(0);
             			//返程航班号匹配.
             			if(backFlight.getFlightNo().equals(req.getCharsetBackflightNo())){
	     	                BigDecimal goAdultPrice = flightInfo.getSeats().get(0).getSalesPrice();
		                    BigDecimal backAdultPrice = backFlight.getSeats().get(0).getSalesPrice();
		                    //往返程成人价格
		                    BigDecimal allAdultPrice = goAdultPrice.add(backAdultPrice);
		                    basePrice = allAdultPrice.multiply(adultQuantity).add(allAdultPrice.multiply(childQuantity));
		                    
		                    flightInfo.setBackOrTo(FlightTripType.DEPARTURE.name()); 
		                    backFlight.setBackOrTo(FlightTripType.RETURN.name()); 
		                    
		                    selectedFlightInfos.set(0, flightInfo); 
		                    selectedFlightInfos.set(1, backFlight);
		                    break;
             			}
	                }
	            }
        		
        		clearSelectFlight(shoppingDto,false);
        	}
            if (req.getFlightTripType().equals(FlightTripType.DEPARTURE.name())) {
                shoppingDto.setDepFlightInfos(flightInfos);
            }
            if (req.getFlightTripType().equals(FlightTripType.RETURN.name())) {
                shoppingDto.setArvFlightInfos(flightInfos);
            }
            if (req.getFlightTripType().equals(FlightTripType.CHARTER.name())) {
                shoppingDto.setCharterFlightInfos(flightInfos);
            }
            shoppingDto.setSelectedFlightInfos(selectedFlightInfos);
        }
//        fitSdpShoppingService.putShoppingCache(req.getShoppingUuid(), shoppingDto);
        MockUtil.morkCacheShoopingDto(shoppingDto);
        return Response.ok(flightInfos).build();
    }
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(SdpClientPath.Path.SAVE_GOODS_TO_CACHE)
    public Response saveGoodsToCache(FitSdpUpdShoppingRequest req) {
        FitSdpShoppingDto shoppingDto = fitSdpShoppingService.getFitSdpShoppingDto(req.getShoppingUuid());
        String productType = req.getProductType();
        
        if (req.getSuppGoodsId() == null) {
            FitSdpRoomDiff roomDiff = shoppingDto.getSelectRoomDiffs();
            roomDiff.setCount(req.getSelectCount().intValue());
        } else {
            // 其他票 
            if (productType.equals(Product.I_OTHER_TICKET.name())) {
                List<FitSdpOtherTicketDto> otherTickets = shoppingDto.getOtherTickets();
                List<FitSdpSelectOtherTicketDto> selectTickets = shoppingDto.getSelectOtherTickets();
                if (CollectionUtils.isEmpty(selectTickets)) {
                    selectTickets = new ArrayList<FitSdpSelectOtherTicketDto>();
                }
                // 如果选择的其他票信息中已经存在请求的记录信息，更新数据
                boolean existFlag = false;
                for (int i = 0; i < selectTickets.size(); i++) {
                    if (selectTickets.get(i).getSuppGoodsId().equals(req.getSuppGoodsId())) {
                        // 如果份数为0，删除缓存中的记录
                        if (req.getSelectCount() == 0) {
                            selectTickets.remove(i);
                        } else {
                            // 如果份数>0，设置份数
                            selectTickets.get(i).setSelectCount(req.getSelectCount());
                            selectTickets.get(i).setSelectDate(req.getSelectDate());
                        }
                        existFlag = true;
                    }
                }
                if (!existFlag) {
                    // 如果缓存中不存在保存的其他票信息，保存
                    if (req.getSelectCount() > 0) {
                        for (FitSdpOtherTicketDto ticket : otherTickets) {
                            if (ticket.getSuppGoodsId().equals(req.getSuppGoodsId())) {
                                FitSdpSelectOtherTicketDto selectTicket = new FitSdpSelectOtherTicketDto();
                                selectTicket.setProductName(ticket.getProductName());
                                selectTicket.setSuppGoodsId(ticket.getSuppGoodsId());
                                selectTicket.setGoodsName(ticket.getGoodsName());
                                selectTicket.setBranchDesc(ticket.getBranchDesc());
                                selectTicket.setSelectDate(req.getSelectDate());
                                selectTicket.setSelectCount(req.getSelectCount());
                                selectTicket.setSelectPrice(req.getSelectPrice());
                                selectTickets.add(selectTicket);
                            }
                        }
                    }
                }

                shoppingDto.setSelectOtherTickets(selectTickets);
            }
            // 保险
            if (productType.equals(Product.INSURANCE.name())) {
                List<FitSdpInsuranceDto> insurances = shoppingDto.getInsurances();
                List<FitSdpSelectInsuranceDto> selectInsurances = shoppingDto.getSelectInsurances();
                if (CollectionUtils.isEmpty(selectInsurances)) {
                    selectInsurances = new ArrayList<FitSdpSelectInsuranceDto>();
                }
                // 如果选择的其他票信息中已经存在请求的记录信息，更新数据
                boolean existFlag = false;
                for (int i = 0; i < selectInsurances.size(); i++) {
                    if (selectInsurances.get(i).getSuppGoodsId().equals(req.getSuppGoodsId())) {
                        // 如果份数为0，删除缓存中的记录
                        if (req.getSelectCount() == 0) {
                            selectInsurances.remove(i);
                        } else {
                            // 如果份数>0，设置份数
                            selectInsurances.get(i).setSelectCount(req.getSelectCount());
                        }
                        existFlag = true;
                    }
                }
                if (!existFlag) {
                    // 如果缓存中不存在保存的其他票信息，保存
                    if (req.getSelectCount() > 0) {
                        for (FitSdpInsuranceDto insurance : insurances) {
                            if (insurance.getSuppGoodsId().equals(req.getSuppGoodsId())) {
                                FitSdpSelectInsuranceDto selectInsurance = new FitSdpSelectInsuranceDto();
                                selectInsurance.setProductName(insurance.getProductName());
                                selectInsurance.setSuppGoodsId(insurance.getSuppGoodsId());
                                selectInsurance.setBranchName(insurance.getBranchName());
                                selectInsurance.setGoodsName(insurance.getGoodsName());
                                selectInsurance.setBranchDesc(insurance.getBranchDesc());
                                selectInsurance.setSelectCount(req.getSelectCount());
                                selectInsurance.setPrice(insurance.getPrice());
                                selectInsurances.add(selectInsurance);
                            }
                        }
                    }
                }
                
                shoppingDto.setSelectInsurances(selectInsurances);
            }
        }
        
        Boolean result = fitSdpShoppingService.putShoppingCache(req.getShoppingUuid(), shoppingDto);
        return Response.ok(result).build();
    }
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(SdpClientPath.Path.APP_UPDATE_GOODS_TO_CACHE)
    public Response updateGoodToCache(FitSdpUpdateShoppingRequest req) {
		FitSdpShoppingDto shoppingDto= req.getShoppingDto();
		
		Boolean result = fitSdpShoppingService.putShoppingCache(req.getShoppingUuid(), shoppingDto);
		return Response.ok(result).build();
	}

    @POST
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getCacheByKey/{cacheKey}")
    public Response getCacheByKey(@PathParam("cacheKey") String cacheKey) {
        return Response.ok(FliMemcachedUtil.getInstance().get(cacheKey)).build();
    }
}
