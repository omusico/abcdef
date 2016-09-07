package com.lvmama.lvfit.sonline.booking.controller.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.lvmama.lvfit.common.dto.order.*;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelRoomtypeDto;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvmama.lvf.common.client.RestClient;
import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.client.FitSdpClient;
import com.lvmama.lvfit.common.client.FitVstClient;
import com.lvmama.lvfit.common.dto.enums.BizEnum;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.member.FitMemUserDto;
import com.lvmama.lvfit.common.dto.member.FitUserContacterDto;
import com.lvmama.lvfit.common.dto.request.FitOrderBookingRequest;
import com.lvmama.lvfit.common.dto.request.MemUserRequest;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpHotelComboGoodsDto;
import com.lvmama.lvfit.common.dto.sdp.goods.FitSdpLocalTripProductDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpSelectInsuranceDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpSelectOtherTicketDto;
import com.lvmama.lvfit.common.dto.sdp.shopping.FitSdpShoppingDto;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.sonline.booking.ToBookingController;
import com.lvmama.lvfit.sonline.booking.controller.form.FitSdpShoppingResponseForm;
import com.lvmama.lvfit.sonline.utils.ServletUtil;

@Controller
public class ToBookingCotrollerImpl implements ToBookingController<Form, BaseResponseDto<? extends Form>>{
	private static final Logger logger = LoggerFactory.getLogger(ToBookingCotrollerImpl.class);
	@Autowired
    private FitVstClient vstClient;
	
	@Autowired
	private FitSdpClient fitSdpClient;
	
	@Autowired
	private RestClient restClient;
	
	@Override
    @RequestMapping(value="order/toBooking",method = {RequestMethod.POST, RequestMethod.GET})
	public String toBooking(Model model, HttpServletRequest request) {
		String shoppingUUID = request.getParameter("shoppingUuid");
		String productId = request.getParameter("productId");
		String bizCategoryId = request.getParameter("bizCategoryId");
		String redirectPath = StringUtils.EMPTY;
		 if(StringUtils.isNotBlank(bizCategoryId)&&Long.valueOf(bizCategoryId)==BizEnum.BIZ_CATEGORY_TYPE.category_route_group.getCategoryId()){
			 redirectPath = "group-"+productId;
		 }
		 if(StringUtils.isNotBlank(bizCategoryId)&&Long.valueOf(bizCategoryId)==BizEnum.BIZ_CATEGORY_TYPE.category_route_freedom.getCategoryId()){
			 redirectPath = "freetour-"+productId;
		 }
		if(StringUtils.isEmpty(shoppingUUID)){
			 return "redirect:/"+redirectPath;
		}
		// 从缓存中获取数据
		FitSdpShoppingDto fitSdpShoppingDto = null;
		try {
			fitSdpShoppingDto = fitSdpClient.getShoppingByUUID(shoppingUUID);
			if (null == fitSdpShoppingDto){
				throw new ExceptionWrapper(ExceptionCode.GET_NO_CACHE_SHOPPING);
			}
		} catch (Exception e) {
			logger.error("点击立即预定到订单填写页异常",e);
			if(e instanceof ExceptionWrapper){
				ExceptionWrapper e1 = (ExceptionWrapper)e;
				model.addAttribute("errorMsgOutTime",e1.getErrMessage());
				model.addAttribute("shoppingUUID",shoppingUUID);
			}
			 return "redirect:/"+redirectPath;
		}
		FitSdpShoppingResponseForm resultForm = new FitSdpShoppingResponseForm(fitSdpShoppingDto);
		//1.航班信息
		model.addAttribute("flightInfos", resultForm.getSelectedFlightInfos());
		//2.酒店套餐信息
		model.addAttribute("hotelInfo", resultForm.getSelectedHotelComboGoods());
		//3.当地游信息、房差
		model.addAttribute("localTripInfo", resultForm.getSelectLocalTripPrduct());
		//4.其他票
		model.addAttribute("otherTickets", resultForm.getSelectOtherTickets());
		//5.保险
		model.addAttribute("insuranceInfos", resultForm.getSelectInsurances());
		//6.人数信息
		model.addAttribute("passengers", resultForm.getFitSdpShoppingRequest().getFitPassengerRequest());
		//7.产品名
		model.addAttribute("productName", resultForm.getProductName());
		//8.购物车uuid
		model.addAttribute("shoppingUUID", shoppingUUID);
		//9.游玩日期
		model.addAttribute("visitDate", resultForm.getFitSdpShoppingRequest().getVisitDate());
		//10.产品id
		model.addAttribute("productId", resultForm.getFitSdpShoppingRequest().getProductId());
		//
		model.addAttribute("bizCategoryId", bizCategoryId);
		//
		model.addAttribute("quantity", resultForm.getFitSdpShoppingRequest().getQuantity());
		//酒店信息
		model.addAttribute("hotels", resultForm.getSelectedRoomtypes());
		return "order/to-booking";
	}

	
	/**
	 * 获取常用联系人信息
	 */
	@Override
	@ResponseBody
    @RequestMapping(value="getVstPassengers", method = RequestMethod.POST)
	public List<FitUserContacterDto> getVstPassengers(HttpServletRequest request) {
		try{
			String lvSessionId = ServletUtil.getLvSessionId(request, null);
	    	MemUserRequest userRequest = new MemUserRequest();
	    	userRequest.setLvSessionId(lvSessionId);
			List<FitUserContacterDto> contactList = vstClient.getUserReceiverByLvSessionId(userRequest);
			
			/*try {
				String str = FileUtils.getStringFromResourceAsStream("/calender.json");
				contactList = JSONMapper.getInstance().readValue(str,new TypeReference<List<FitUserContacterDto>>() {
				});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			return contactList;
		}catch(Exception e){
			logger.error("获取常用联系人异常：");
			return new ArrayList<FitUserContacterDto>();
		}
		
	}
	
	/**
     * 查询当前用户
     * @param request
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping(value="getUserByLvSessionId", method = RequestMethod.POST)
    public FitMemUserDto getUserByLvSessionId(HttpServletRequest request) {
        try {
        	String lvSessionId = ServletUtil.getLvSessionId(request, null);
        	MemUserRequest userRequest = new MemUserRequest();
        	userRequest.setLvSessionId(lvSessionId);
        	BaseSingleResultDto<FitMemUserDto> result = new BaseSingleResultDto<FitMemUserDto>();  // vstClient.getUserByLvSessionId(sessionId);
        	/** 根据sessionId 获得常用联系人信息 */
        	result= vstClient.getUserByLvSessionId(userRequest);
        	FitMemUserDto user = result.getResult();
            return user;
        } catch (Exception e) {
            logger.error("查询当前用户异常：", e);
            return null;
        }
    }

    @Override
    @ResponseBody
    @RequestMapping(value="getContractsHtml", method = RequestMethod.POST)
    public Map<String,BaseSingleResultDto<String>> getContractsHtml(HttpServletRequest request){
    	String shoppingUUID = request.getParameter("shoppingUUID");
		// 从缓存中获取数据
		FitSdpShoppingDto fitSdpShoppingDto = null;
		try {
			fitSdpShoppingDto = fitSdpClient.getShoppingByUUID(shoppingUUID);
			if (null == fitSdpShoppingDto){
				throw new ExceptionWrapper(ExceptionCode.GET_NO_CACHE_SHOPPING);
			}
		} catch (Exception e) {
			logger.error("获取缓存异常",e);
		}
		//构建获取合同的request
		FitOrderBookingRequest booingRequest = this.buildBookingRequest(fitSdpShoppingDto);
		BaseSingleResultDto<String> contracts = new BaseSingleResultDto<String>();
		try{
			contracts = fitSdpClient.getContracts(booingRequest);
		}catch(Exception e1){
			logger.error("获取合同异常",e1);
		}
		Map<String,BaseSingleResultDto<String>> map = new HashMap<String, BaseSingleResultDto<String>>();
		map.put("contracts", contracts);
    	return map;
    }


    /**
     * 构建获取合同的request
     * @param fitSdpShoppingDto
     * @return
     */
	private FitOrderBookingRequest buildBookingRequest(FitSdpShoppingDto fitSdpShoppingDto) {
		FitOrderBookingRequest booingRequest = new FitOrderBookingRequest();
		booingRequest.setBookingSource(BookingSource.FIT_SDP_FRONT);
		booingRequest.setAdultQuantity(fitSdpShoppingDto.getFitSdpShoppingRequest().getFitPassengerRequest().getAdultCount());
		booingRequest.setVisitTime(fitSdpShoppingDto.getFitSdpShoppingRequest().getVisitDate());
		booingRequest.setProductId(Long.valueOf(fitSdpShoppingDto.getFitSdpShoppingRequest().getProductId()));
		booingRequest.setLineRouteId(Long.valueOf(fitSdpShoppingDto.getFitSdpShoppingRequest().getLineRouteId()));
		booingRequest.setChildQuantity(fitSdpShoppingDto.getFitSdpShoppingRequest().getFitPassengerRequest().getChildCount());
		this.completeBookingRequest(booingRequest,fitSdpShoppingDto);
		
		return booingRequest;
	}


	private void completeBookingRequest(FitOrderBookingRequest booingRequest,FitSdpShoppingDto fitSdpShoppingDto) {
		//酒店套餐信息
		FitSdpHotelComboGoodsDto selectedHotelComboGoods = fitSdpShoppingDto.getSelectedHotelComboGoods();
		if(null != selectedHotelComboGoods){
			FitOrderHotelComboDto fitOrderHotelComboDto = new FitOrderHotelComboDto();
			//BeanUtils.copyProperties(selectedHotelComboGoods, fitOrderHotelComboDto);
			fitOrderHotelComboDto.setGoodsId(selectedHotelComboGoods.getSuppGoodsId());
			fitOrderHotelComboDto.setQuantity(selectedHotelComboGoods.getQuantity());
			fitOrderHotelComboDto.setCheckIn(selectedHotelComboGoods.getStartDay());
			fitOrderHotelComboDto.setDetailId(selectedHotelComboGoods.getDetailId());
			booingRequest.setFitOrderHotelComboDto(fitOrderHotelComboDto);
		}

		//酒店套餐信息
		List<FitSdpHotelRoomtypeDto> selectHotels = fitSdpShoppingDto.getSelectedRoomtypes();
		if(null != selectHotels){
			List<FitOrderHotelDto> orderHotelDtos = new ArrayList<FitOrderHotelDto>();
			for(FitSdpHotelRoomtypeDto hotelRoomtypeDto : selectHotels){
				FitOrderHotelDto hotelDto = new FitOrderHotelDto();
				hotelDto.setPlanId(hotelRoomtypeDto.getRoomId().toString());
				hotelDto.setRoomCount(hotelRoomtypeDto.getRoomCount());
				hotelDto.setCheckin(DateUtils.parseDate(hotelRoomtypeDto.getCheckIn()));
				hotelDto.setDetailId(hotelRoomtypeDto.getDetailId().toString());
				orderHotelDtos.add(hotelDto);
				booingRequest.setFitOrderHotelDtos(orderHotelDtos);
			}
		}

		if(null != selectedHotelComboGoods && CollectionUtils.isNotEmpty(selectHotels)){
			booingRequest.setFitOrderHotelDtos(null);
		}
		
		//当地游
		FitSdpLocalTripProductDto selectLocalTripPrduct = fitSdpShoppingDto.getSelectLocalTripPrduct();
		if(null != selectLocalTripPrduct){
			FitOrderLocalTripProductDto fitOrderLocalTripProductDto = new FitOrderLocalTripProductDto();
			fitOrderLocalTripProductDto.setGoodsId(Long.valueOf(selectLocalTripPrduct.getSuppGoodsId()));
			fitOrderLocalTripProductDto.setVisitDate(selectLocalTripPrduct.getVisitDate());
			fitOrderLocalTripProductDto.setDetailId(selectLocalTripPrduct.getDetailId());
			booingRequest.setFitOrderLocalTripProductDto(fitOrderLocalTripProductDto);
		}
		
		//其他票
		List<FitSdpSelectOtherTicketDto> selectOtherTickets = fitSdpShoppingDto.getSelectOtherTickets();
		if(CollectionUtils.isNotEmpty(selectOtherTickets)){
			List<FitOrderOtherTicketDto> otherTicketList = new ArrayList<FitOrderOtherTicketDto>();
			for (FitSdpSelectOtherTicketDto fitSdpOtherTicketDto : selectOtherTickets) {
				FitOrderOtherTicketDto fitOrderOtherTicketDto = new FitOrderOtherTicketDto();
				fitOrderOtherTicketDto.setProductId(booingRequest.getProductId());
				fitOrderOtherTicketDto.setProductName(fitSdpOtherTicketDto.getProductName());
				fitOrderOtherTicketDto.setSelectDate(DateUtils.parseDate(fitSdpOtherTicketDto.getSelectDate()));
				fitOrderOtherTicketDto.setSelectCount(fitSdpOtherTicketDto.getSelectCount());
				fitOrderOtherTicketDto.setBranchDesc(fitSdpOtherTicketDto.getBranchDesc());
				fitOrderOtherTicketDto.setGoodsId(fitSdpOtherTicketDto.getSuppGoodsId());
				fitOrderOtherTicketDto.setSelectDate(DateUtils.parseDate(fitSdpOtherTicketDto.getSelectDate()));
				fitOrderOtherTicketDto.setSelectPrice(fitSdpOtherTicketDto.getSelectPrice());
				otherTicketList.add(fitOrderOtherTicketDto);
			}
			booingRequest.setFitOrderOtherTicketDtos(otherTicketList);
		}
		
		//保险
		List<FitSdpSelectInsuranceDto> selectInsurances = fitSdpShoppingDto.getSelectInsurances();
		if(CollectionUtils.isNotEmpty(selectInsurances)){
			List<FitOrderInsuranceDto> insuranceList = new ArrayList<FitOrderInsuranceDto>();
			for (FitSdpSelectInsuranceDto fitSdpInsuranceDto : selectInsurances) {
				FitOrderInsuranceDto fitOrderInsuranceDto = new FitOrderInsuranceDto();
				fitOrderInsuranceDto.setInsuranceSuppGoodsId(String.valueOf(fitSdpInsuranceDto.getSuppGoodsId()));
				fitOrderInsuranceDto.setInsuranceCount(Integer.parseInt(String.valueOf(fitSdpInsuranceDto.getSelectCount())));
				fitOrderInsuranceDto.setVisitDate(DateUtils.parseDate(fitSdpShoppingDto.getFitSdpShoppingRequest().getVisitDate()));
				insuranceList.add(fitOrderInsuranceDto);
			}
			booingRequest.setFitOrderInsuranceDtos(insuranceList);
		}
		//机票
		List<FlightSearchFlightInfoDto> selectedFlightInfos = fitSdpShoppingDto.getSelectedFlightInfos();
		if(CollectionUtils.isNotEmpty(selectedFlightInfos)){
			List<FitOrderFlightDto> flightList = new ArrayList<FitOrderFlightDto>();
			for (FlightSearchFlightInfoDto fitSdpFlightDto : selectedFlightInfos) {
				FitOrderFlightDto fitOrderFlightDto = new FitOrderFlightDto();
				//BeanUtils.copyProperties(fitSdpFlightDto,fitOrderFlightDto);
				fitOrderFlightDto.setDepartureDate(fitSdpFlightDto.getDepartureDate());
				fitOrderFlightDto.setDepartureAirportName(fitSdpFlightDto.getDepartureAirportName());
				fitOrderFlightDto.setArrivalAirportName(fitSdpFlightDto.getArrivalAirportName());
				fitOrderFlightDto.setDepartureCityName(fitSdpFlightDto.getDepartureCityName());
				fitOrderFlightDto.setArrivalCityName(fitSdpFlightDto.getArrivalCityName());
				fitOrderFlightDto.setFlightNo(fitSdpFlightDto.getFlightNo());
				fitOrderFlightDto.setDepartureTime(fitSdpFlightDto.getDepartureTime());
				flightList.add(fitOrderFlightDto);
			}
			booingRequest.setFitOrderFlightDtos(flightList);
		}
	}
}
