/**
 * Project Name:lvfit-dp-service
 * File Name:ShoppingResource.java
 * Package Name:com.lvmama.lvfit.dp.service.resource
 * Date:2015-12-11下午2:44:36
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
 */

package com.lvmama.lvfit.dp.service.resource;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvfit.common.client.path.DpClientPath;
import com.lvmama.lvfit.common.dto.calculator.request.CalculateAmountDetailRequest;
import com.lvmama.lvfit.common.dto.insurance.InsuranceInfoDto;
import com.lvmama.lvfit.common.dto.request.CalculateAmountRequest;
import com.lvmama.lvfit.common.dto.request.ChangeFlightRequest;
import com.lvmama.lvfit.common.dto.request.ChangeHotelRequest;
import com.lvmama.lvfit.common.dto.request.FitDpUpdateShoppingRequest;
import com.lvmama.lvfit.common.dto.request.FitShoppingFliInsRequest;
import com.lvmama.lvfit.common.dto.request.FitShoppingInsuranceRequest;
import com.lvmama.lvfit.common.dto.request.FitShoppingTicketRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceDto;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceProdProduct;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceProdProductBranch;
import com.lvmama.lvfit.common.dto.search.insurance.result.InsuranceSuppGoods;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchSpotDto;
import com.lvmama.lvfit.common.dto.search.spot.result.SpotSearchTicketDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingAmountDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedInsuranceDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedTicketDto;
import com.lvmama.lvfit.common.dto.shopping.FlightInsuranceDto;
import com.lvmama.lvfit.dp.service.FitDpService;
import com.lvmama.lvfit.dp.shopping.service.ShopingCalculateService;
import com.lvmama.lvfit.dp.shopping.service.ShoppingFlightService;
import com.lvmama.lvfit.dp.shopping.service.ShoppingHotelService;
import com.lvmama.lvfit.dp.shopping.service.ShoppingService;
import com.lvmama.lvfit.dp.shopping.service.ShoppingViewService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:ShoppingResource <br/>
 * Function: 购物车服务. <br/>
 * Date: 2015-12-11 下午2:44:36 <br/>
 * 
 * @author liuweiguo
 * @version
 * @since JDK 1.6
 * @see
 */
@Component
@Path("")
public class ShoppingResource {

	@Autowired
	public ShoppingFlightService shoppingFlightService;

	@Autowired
	private ShoppingHotelService shoppingHotelService;

	@Autowired
	private ShoppingViewService shoppingViewService;

	@Autowired
	private ShopingCalculateService shoppingCalculateService;
	
	@Autowired
	private ShoppingService shoppingService;
	
	@Autowired
	FitDpService fitDpService;

	/**
	 * 
	 * changeFlight:刷新机票缓存. <br/>
	 * 
	 * @author liuweiguo
	 * @param request
	 * @return
	 * @since JDK 1.6
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(DpClientPath.Path.CHANGE_SHOPPING_FLIGHT)
	public Response changeFlight(ChangeFlightRequest request) {
		List<FlightSearchFlightInfoDto> result = shoppingFlightService.changeFlight(request);
		return Response.ok(result).build();
	}

	/**
	 * 
	 * changeHotel:刷新酒店缓存. <br/>
	 * 
	 * @author liuweiguo
	 * @param request
	 * @return
	 * @since JDK 1.6
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(DpClientPath.Path.CHANGE_SHOPPING_HOTEL)
	public Response changeHotel(ChangeHotelRequest request) {
		List<HotelSearchHotelDto> hotels = shoppingHotelService.changeHotel(request);
		BaseSingleResultDto<List<HotelSearchHotelDto>> result = new BaseSingleResultDto<List<HotelSearchHotelDto>>();
		result.setResult(hotels);
		return Response.ok(result).build();
	}

	/**
	 * 
	 * getShoppingByShoppingUUID:加载购物车数据. <br/>
	 * 
	 * @author liuweiguo
	 * @param shoppingUUID
	 * @return
	 * @since JDK 1.6
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(DpClientPath.Path.GET_SHOPPING_BY_UUID)
	public Response getShoppingByShoppingUUID(String shoppingUUID) {
		BaseSingleResultDto<FitShoppingDto> result = shoppingViewService.getShoppingByShoppingUUID(shoppingUUID);
		return Response.ok(result).build();
	}

	/**
	 * 
	 * calculatPrice:计算购物车价格. <br/>
	 *
	 * @author liuweiguo
	 * @param request
	 * @return
	 * @since JDK 1.6
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(DpClientPath.Path.CALCULAT_SHOPPING_AMOUNT)
	public Response calculatAmount(CalculateAmountRequest request) {
		BaseSingleResultDto<FitShoppingAmountDto> result = shoppingCalculateService.calculateAmount(request);
		return Response.ok(result).build();
	}
	
	/**
	 * 
	 * calculatPrice:计算购物车价格. <br/>
	 *
	 * @author liuweiguo
	 * @param request
	 * @return
	 * @since JDK 1.6
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(DpClientPath.Path.CALCULAT_SHOPPING_AMOUNT_BY_DETAIL)
	public Response calculatAmountByDetail(CalculateAmountDetailRequest request) {
		BaseSingleResultDto<FitShoppingAmountDto> result = shoppingCalculateService.calculateAmountByDetail(request);
		return Response.ok(result).build();
	}
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(DpClientPath.Path.APP_UPDATE_GOODS_TO_CACHE)
    public Response updateGoodToCache(FitDpUpdateShoppingRequest req) {
		FitShoppingDto shoppingDto= req.getShoppingDto();
		Boolean result = shoppingService.putShoppingCache(req.getShoppingUuid(), shoppingDto);
		
		return Response.ok(result).build();
	}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(DpClientPath.Path.UPD_SELECT_TICKET_INFO)
    public Response updSelectedTicketInfo(FitShoppingTicketRequest req) {
        String shoppingUuid = req.getShoppingUuid();
        FitShoppingDto fitShoppingDto = shoppingService.getFitShopping(shoppingUuid);
        // 购物车信息在缓存中不存在，返回null
        if (fitShoppingDto == null) {
            throw new ExceptionWrapper(ExceptionCode.GET_NO_CACHE_SHOPPING);
        }
        List<FitShoppingSelectedTicketDto> selectTickets = fitShoppingDto.getSelectTicketInfo();
        FitShoppingSelectedTicketDto ticketDto = new FitShoppingSelectedTicketDto();
        String suppGoodsId = req.getSuppGoodsId();
        
        ticketDto = req.getTicketDto();
        for (SpotSearchSpotDto spot : fitShoppingDto.getSpots()) {
            for (SpotSearchTicketDto ticket : spot.getSpotTickets()) {
                if (suppGoodsId.equals(ticket.getSuppGoodsId())) {
                    ticketDto.setTicketDtl(ticket.getTicketGoodsDetailDto());
                }
            }
        }
        for (int i = 0; i < selectTickets.size(); i++) {
            // 如果门票信息存在，删除门票信息
            if (selectTickets.get(i).getSuppGoodsId().equals(suppGoodsId)) {
                // 如果门票信息没有变化，返回null
                if (selectTickets.get(i).equals(ticketDto)) {
                    Response.ok(false).build();
                }
                selectTickets.remove(i);
            }
        }
        if (ticketDto.getTicketDate() != null && ticketDto.getTicketCount() > 0) {
            selectTickets.add(ticketDto);
        }
        
        fitShoppingDto.setSelectTicketInfo(selectTickets);
        boolean result = shoppingService.putShoppingCache(shoppingUuid, fitShoppingDto);
        return Response.ok(result).build();
    }
    
    /**
     *  更新缓存中的保险信息
     * @author wanghuihui
     * @date:2016年3月28日 下午5:52:39
     * @param req
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(DpClientPath.Path.UPD_SELECT_INSURANCE_INFO)
    public Response updSelectedInsuranceInfo(FitShoppingInsuranceRequest req) {
    	String shoppingUuid = req.getShoppingUuid();
    	FitShoppingDto fitShoppingDto = shoppingService.getFitShopping(shoppingUuid);
    	// 购物车信息在缓存中不存在，返回null
    	if (fitShoppingDto == null) {
    	    throw new ExceptionWrapper(ExceptionCode.GET_NO_CACHE_SHOPPING);
    	}

    	for (FitShoppingSelectedInsuranceDto selectedInsuranceDto : req.getInsuranceDtoList()) {
			for (InsuranceDto insuranceDto : fitShoppingDto.getInsurances()) {
				if (selectedInsuranceDto.getSuppGoodsId().equals(insuranceDto.getSuppGoodsId().toString())) {
					selectedInsuranceDto.setInsuranceDetail(insuranceDto.getBranchDesc());
				}
			}
    	}
    	
    	fitShoppingDto.setSelectInsuranceInfo(req.getInsuranceDtoList());
    	boolean result = shoppingService.putShoppingCache(shoppingUuid, fitShoppingDto);
    	return Response.ok(result).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(DpClientPath.Path.UPD_SELECT_FLI_INS_INFO)
    public Response updSelectedFliInsInfo(FitShoppingFliInsRequest req) {
        String shoppingUuid = req.getShoppingUuid();
        FitShoppingDto fitShoppingDto = shoppingService.getFitShopping(shoppingUuid);
        // 购物车信息在缓存中不存在，返回null
        if (fitShoppingDto == null) {
            throw new ExceptionWrapper(ExceptionCode.GET_NO_CACHE_SHOPPING);
        }
        List<FlightInsuranceDto> selectFlightInsInfo = fitShoppingDto.getSelectFlightInsInfo();
        
        if (CollectionUtils.isNotEmpty(selectFlightInsInfo)) {
            for (int i = 0; i < selectFlightInsInfo.size(); i++) {
                // 如果信息存在，删除信息
                if (selectFlightInsInfo.get(i).getInsuranceId().equals(req.getInsuranceId())) {
                    // 如果信息没有变化，返回null
                    if (selectFlightInsInfo.get(i).getInsuranceCount() == req.getInsuranceCount()) {
                        return Response.ok(false).build();
                    }
                    selectFlightInsInfo.remove(i);
                    fitShoppingDto.setFliInsDelFlag(true); // 如果flag为true，搜索后的结果，不在设置默认航意险
                }
            }
        }

        if (req.getInsuranceCount() > 0) {
            FlightInsuranceDto flightInsuranceDto = req.getFlightInsuranceDto();
            for (InsuranceInfoDto fliInsurance : fitShoppingDto.getFlightInsuranceInfos()) {
                if (flightInsuranceDto.getInsuranceId().equals(fliInsurance.getId())) {
                    flightInsuranceDto.setInsuranceDesc(fliInsurance.getInsuranceDesc());
                    flightInsuranceDto.setInsuranceClassCode(fliInsurance.getInsuranceClass().getCode());
                }
            }
            selectFlightInsInfo.add(flightInsuranceDto);
            fitShoppingDto.setFliInsDelFlag(false);
        }
        fitShoppingDto.setSelectFlightInsInfo(selectFlightInsInfo);
        boolean result = shoppingService.putShoppingCache(shoppingUuid, fitShoppingDto);
        return Response.ok(result).build();
    }
    
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path(DpClientPath.Path.HOTEL_CONDITION)
	public Response getHotelCondition(String shoppingUUID){
		Map<String, Object> hotelCondition = shoppingService.getHotelCondition(shoppingUUID);
		return Response.ok(hotelCondition).build();
	}
}
