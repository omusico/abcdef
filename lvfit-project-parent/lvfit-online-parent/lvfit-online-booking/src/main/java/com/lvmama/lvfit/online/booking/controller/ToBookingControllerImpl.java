/**
 * Project Name:lvfit-online-booking
 * File Name:ToBookingControllerImpl.java
 * Package Name:com.lvmama.lvfit.online.booking.controller
 * Date:2015-12-15下午2:27:02
 * Copyright (c) 2015, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.online.booking.controller;

import com.lvmama.lvfit.common.dto.request.FitBaseSearchRequest;
import org.codehaus.jackson.type.TypeReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.FileUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.FitDpClient;
import com.lvmama.lvfit.common.client.FitVstClient;
import com.lvmama.lvfit.common.dto.member.FitMemUserDto;
import com.lvmama.lvfit.common.dto.member.FitUserContacterDto;
import com.lvmama.lvfit.common.dto.order.FitOrderPassengerDto;
import com.lvmama.lvfit.common.dto.request.MemUserRequest;
import com.lvmama.lvfit.common.dto.search.FitPassengerRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchHotelDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchPlanDto;
import com.lvmama.lvfit.common.dto.search.hotel.result.HotelSearchRoomDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.form.booking.ToBookingInputForm;
import com.lvmama.lvfit.online.base.BaseController;
import com.lvmama.lvfit.online.base.utils.DateUtil;
import com.lvmama.lvfit.online.utils.ServletUtil;

/**
 *  跳转到订单填写页
 * ClassName:ToBookingControllerImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2015-12-15 下午2:27:02 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Controller
public class ToBookingControllerImpl extends BaseController implements ToBookingController{
	private final static Logger logger = org.slf4j.LoggerFactory.getLogger(ToBookingControllerImpl.class);
	
	@Autowired
	private FitDpClient dpclient;
	
    @Autowired
    private FitVstClient vstClient;
	
	/**
	 * 跳转到订单填写页
	 * @author wanghuihui
	 * @date:2015年12月16日 下午1:50:36
	 * @param model
	 * @param
	 * @return
	 */
	@Override
	@RequestMapping("/order/toBookingLogin")
	@ResponseBody
	public Map<String, Object> toBookingLogin(Model model,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String,Object>();
        try {
        	MemUserRequest userRequest = new MemUserRequest();
        	String lvSessionId = ServletUtil.getLvSessionId(request, null);
        	userRequest.setLvSessionId(lvSessionId);
        	BaseSingleResultDto<FitMemUserDto> result = new BaseSingleResultDto<FitMemUserDto>();  // vstClient.getUserByLvSessionId(sessionId);
        	/** 根据sessionId 获得常用联系人信息 */
        	result= vstClient.getUserByLvSessionId(userRequest);
        	FitMemUserDto user = result.getResult();
        	if(null == user || user.getUserId() == null){
    			logger.info("用户没有登陆，跳转到登陆页面！");
    			map.put("success", false);
    			map.put("desc", "用户没有登陆，跳转到登陆页面！");
    			return map;
    		}else{
    			map.put("success", true);
    			map.put("desc", "用户没有登陆，跳转到登陆页面！");
    			return map;
    		}
		} catch (Exception e) {
			logger.error("机+酒订单填写页跳转页获得 登陆用户 失败！");
			map.put("success", true);
			map.put("desc", "机+酒订单填写页跳转页获得 登陆用户 失败！");
			e.printStackTrace();
			return map;
		}
	}
	
	@Override
	@RequestMapping("/order/toBooking")
	public String toBooking(Model model,HttpServletRequest request,ToBookingInputForm form,
			@RequestParam(required=false) String shopingUUID,@RequestParam(required=false) String userId) {
			
	    model.addAttribute("shopingUUID",form.getShopingUUID());

		if(this.getIsBackBooking(request).booleanValue()) {
			model.addAttribute("isBackBooking", "true");
		}		
		if(null == form || null == form.getShopingUUID()){
			logger.error("机+洒 跳转到订单填写页参数出错！");
			return "";
		}
		// 根据UUID加载 航班和酒店信息
		FitShoppingDto shoppingDto = null ;
		BaseSingleResultDto<FitShoppingDto> shoppingResult ;
		try {
			shoppingResult = dpclient.getShoppingByUUID(form.getShopingUUID());
			shoppingDto = shoppingResult.getResult();
		} catch (Exception e) {
			if(e instanceof ExceptionWrapper){
				ExceptionWrapper e1 = (ExceptionWrapper)e;
				model.addAttribute("errorMsgOutTime",e1.getErrMessage());
			}else{
				model.addAttribute("errorMsgOutTime",e.getMessage());
			}
			return "order/fh-order";
		}
		if(null != shoppingDto){
			//从选中的信息中获取机票、酒店、门票、保险等相关信息
			String productName = "";
			//机票信息
			model.addAttribute("flightInfos", shoppingDto.getFlightInfos());
			//酒店信息
			List<HotelSearchHotelDto> hotels = shoppingDto.getHotels().getResults();
			if(CollectionUtils.isNotEmpty(hotels)){
				HotelSearchHotelDto hotel = hotels.get(0);
				HotelSearchRoomDto room = hotel.getRooms().get(0);
				HotelSearchPlanDto plan = room.getPlans().get(0);
				String bedType = null == room.getBedType() ? "" : "床型：" + room.getBedType();
				Integer con = plan.getBreakfast();
				String breakfast = null == con ? "" : "早餐：" + (0== con ?"无":(1== con ?"单早":(2== con ?"双早": con)));
				String wifi = null == room.getBroadband() ? "" : "宽带：" + room.getBroadband();
				room.setBranchDesc(bedType + " " + breakfast + " " + wifi);
				model.addAttribute("hotel", hotel);
				
				// 入住天数
				String depDateStr = shoppingDto.getSearchRequest().getCheckInTime();
				String reDateStr = shoppingDto.getSearchRequest().getCheckOutTime();
				Date depDate = DateUtils.parseDate(depDateStr);
				Date reDate = DateUtils.parseDate(reDateStr);
				model.addAttribute("roomDate", DateUtil.getDaysBetween(depDate, reDate));
				model.addAttribute("checkInDate", depDateStr);
				model.addAttribute("checkOutDate", reDateStr);
			}
			
			//成人儿童数
			model.addAttribute("adultCount", shoppingDto.getSearchRequest().getAdultsCount());
			model.addAttribute("childCount", shoppingDto.getSearchRequest().getChildCount());
			
			//乘客回填
			if(!CollectionUtils.isEmpty(shoppingDto.getPassenger())){
				String receiveIds= "";
				for (FitOrderPassengerDto passerger : shoppingDto.getPassenger()) {
					receiveIds = receiveIds + passerger.getPassengerId() + ",";
				}
				model.addAttribute("passengers", shoppingDto.getPassenger());
				model.addAttribute("receiveIds", receiveIds);
			}else{
				model.addAttribute("passengers", new ArrayList<FitOrderPassengerDto>());
			}
			//购买人回填
			if(shoppingDto.getContacter()!=null){
				model.addAttribute("contacter", shoppingDto.getContacter());
			}
			//旅程类型
			model.addAttribute("tripType", shoppingDto.getSearchRequest().getTripType());
			//门票信息
			model.addAttribute("selTickets", shoppingDto.getSelectTicketInfo());
			//国内游保险信息
			model.addAttribute("selInsurances", shoppingDto.getSelectInsuranceInfo());
			//航空意外险
			model.addAttribute("insuranceInfos", shoppingDto.getSelectFlightInsInfo());
			//产品名称
			productName = bulidProductName(shoppingDto.getSearchRequest());
			model.addAttribute("productName", productName);
			return "order/fh-order";
		}else{
		     return "redirect:/index";
		}
	}
	
    private String bulidProductName(FitBaseSearchRequest request) {
    	String productName;
    	String adultStr = request.getAdultsCount() == 0 ? "" : request.getAdultsCount() + "成人";
    	String childStr = request.getChildCount()==0? "" : request.getChildCount() + "儿童";
		if (request.getTripType().equalsIgnoreCase("WF")) {
			productName = request.getDepartureCityName() +" 往返 "+ request.getArrivalCityName() +" 自由行（"
					      + request.getDepartureTime() +"至" + request.getReturnTime() + "，" + adultStr + childStr+"）";
		} else {
			productName = request.getDepartureCityName() + " — " + request.getArrivalCityName() +" 自由行（"
						  + request.getDepartureTime() + "，" + adultStr + " " + childStr + "）";
		}
    	return productName;
	}

	/**
	 * 用户点击预订下一步前预定前记录用户请求信息
	 * @param
	 * @param request
	 * @param shopingUUID
	 */
	@Override
	@RequestMapping("/order/recordBookingLogNoLogin")
	@ResponseBody
	public Map<String, Object>  recordBookingLogNoLogin(HttpServletRequest request,@RequestParam String shopingUUID) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			dpclient.recordBookingLogNoLogin(shopingUUID);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			if(e instanceof ExceptionWrapper){
				ExceptionWrapper e1 = (ExceptionWrapper)e;
				map.put("isSuccess", ResultStatus.FAIL.name());
				map.put("errMessage", e1.getErrMessage());
			}else{
				map.put("isSuccess", ResultStatus.FAIL.name());
				map.put("errMessage", e.getMessage());
			}
			return map;
		}
		map.put("isSuccess",ResultStatus.SUCCESS.name());
		return map;
	}
	
	/**
	 * 获取常用联系人信息
	 */
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
}

