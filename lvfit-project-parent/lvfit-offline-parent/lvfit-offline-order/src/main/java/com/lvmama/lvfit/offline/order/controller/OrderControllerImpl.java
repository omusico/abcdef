package com.lvmama.lvfit.offline.order.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvfit.common.dto.order.*;
import com.lvmama.lvfit.common.dto.request.FitFliBookingCallBackRequest;
import com.lvmama.lvfit.common.form.product.FitSuppOrderForFlightCallBackForm;
import com.lvmama.lvfit.common.form.product.FitSuppOrderForFlightCallBackRequest;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.OperType;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.StringUtil;
import com.lvmama.lvfit.common.client.FitBusinessClient;
import com.lvmama.lvfit.common.client.FitVstClient;
import com.lvmama.lvfit.common.dto.enums.BizEnum;
import com.lvmama.lvfit.common.dto.enums.BizEnum.BIZ_CATEGORY_TYPE;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.enums.BookingSourceOffline;
import com.lvmama.lvfit.common.dto.enums.FlightTripType;
import com.lvmama.lvfit.common.dto.enums.IDCardType;
import com.lvmama.lvfit.common.dto.enums.InsuranceType;
import com.lvmama.lvfit.common.dto.enums.PassengerType;
import com.lvmama.lvfit.common.dto.enums.SuppVstAuditStatus;
import com.lvmama.lvfit.common.dto.enums.SuppVstOrderStatus;
import com.lvmama.lvfit.common.dto.enums.SuppVstPaymentStatus;
import com.lvmama.lvfit.common.dto.request.FitOrderQueryRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.CharterFlightFilterUtil;
import com.lvmama.lvfit.common.form.order.FitOrderOpLogForm;
import com.lvmama.lvfit.common.form.order.FitOrderQueryListForm;

@Controller
public class OrderControllerImpl implements OrderController{
	private final static Logger logger = org.slf4j.LoggerFactory.getLogger(OrderControllerImpl.class);
	
	@Autowired
	private FitBusinessClient fitBusinessClient;
	@Autowired
	private FitVstClient fitVstClient;

	
	@Override
	@RequestMapping("order/toOrderQuery")
	public String toOrderQuery(Model model, HttpServletRequest request,HttpServletResponse response) {
		buildOrderModel(model);
		return "order/order_list";
	}

	@Override
	@ResponseBody
	@RequestMapping("order/OrderQuery")
	public BaseResultDto<FitOrderQueryListForm> OrderQuery(HttpServletRequest request,FitOrderQueryRequest fitOrderQueryRequest) {
		//1、设置查询条件
		BaseQueryDto<FitOrderQueryRequest> baseQuery = new BaseQueryDto<FitOrderQueryRequest>(
				fitOrderQueryRequest.getPagination(), fitOrderQueryRequest);
		BaseResultDto<FitOrderQueryListForm> baseResponse = new BaseResultDto<FitOrderQueryListForm>(); 
		//2、查询订单列表
		try {
			BaseResultDto<FitOrderQueryListDto> baseResultDto = fitBusinessClient.queryOrderList(baseQuery);
			List<FitOrderQueryListDto> results = baseResultDto.getResults();
			List<FitOrderQueryListForm> resultFormList = new ArrayList<FitOrderQueryListForm>();
			if(CollectionUtils.isNotEmpty(results)){
				for(FitOrderQueryListDto dto : results){
					FitOrderQueryListForm form = new FitOrderQueryListForm();
					form.setFitOrderQueryListDto(dto);
					resultFormList.add(form);
				}
				baseResponse.setResults(resultFormList);
				baseResponse.setPagination(baseResultDto.getPagination());
			}
			
		} catch (Exception e) {
			logger.error("后台订单查询失败！");
			e.printStackTrace();
		}
		
		
		return baseResponse ; 
	}

	private void buildOrderModel(Model model) {
		model.addAttribute("orderBookingStatus", SuppVstOrderStatus.values());   //订单状态
		model.addAttribute("orderAuditStatusEnum", SuppVstAuditStatus.values()); //order_audit_status -审核状态
		model.addAttribute("orderPayStatusEnum", SuppVstPaymentStatus.values()); //order_pay_status --支付状态 4 
		
		/*model.addAttribute("orderBookingStatus", OrderBookingStatus.values());   //订单状态
		model.addAttribute("orderAuditStatusEnum", OrderAuditStatus.values()); //order_audit_status -审核状态
		model.addAttribute("orderPayStatusEnum", OrderPayStatus.values()); //order_pay_status --支付状态 4 
		 */		
		model.addAttribute("bookingSourceEnum", BookingSourceOffline.values());  //下单来源
		model.addAttribute("passengerTypeEnum", PassengerType.values());  //乘客类型
		model.addAttribute("IDCardTypeEnum", IDCardType.values());  //乘客类型
		model.addAttribute("insuranceTypeEnum", InsuranceType.values());  //乘客类型
		
		List<BIZ_CATEGORY_TYPE> categoryTypeList = new ArrayList<BIZ_CATEGORY_TYPE>();
		categoryTypeList.add(BizEnum.BIZ_CATEGORY_TYPE.category_route_group);
		categoryTypeList.add(BizEnum.BIZ_CATEGORY_TYPE.category_route_freedom);
		categoryTypeList.add(BizEnum.BIZ_CATEGORY_TYPE.category_route_aero_hotel);
		model.addAttribute("bizCategoryType",categoryTypeList);//产品品类
	}
	
	@Override
	@RequestMapping("order/queryOrderDetail/{vstOrderId}/{mainOrderId}")
	public String toOrderDetail(Model model,@PathVariable("vstOrderId")Long vstOrderId, @PathVariable("mainOrderId")Long mainOrderId,
			FitOrderQueryRequest fitOrderQueryRequest) {
		//1 构建参数
		buildOrderModel(model);
		
		try {
			FitOrderMainDto baseResultDto = fitBusinessClient.queryOrderMainByVstOrderMainNo(vstOrderId);
			FitSuppMainOrderDto fitSuppMainOrderDto= baseResultDto.getFitSuppMainOrderDto();
			//如果打开了包机开关.
			if(CharterFlightFilterUtil.getQueryCharsetFlight()){
				//通过是否有“(真往返)子单关联信息 ”判断是不是包机补全信息.
				if(CollectionUtils.isEmpty(fitSuppMainOrderDto.getSuppFlightOrderDtos())){
					model.addAttribute("isCharter", "false"); 
				}else{
					model.addAttribute("isCharter", "true"); 
					
					//去掉一个detail里面重复的passenger的数据.
					List<FitSuppFlightOrderDto>  allSuppFlightOrderDtos = fitSuppMainOrderDto.getSuppFlightOrderDtos();
					Set<String> allPassengerNos = new HashSet<String>();
					if(!CollectionUtils.isEmpty(allSuppFlightOrderDtos)){
						for(FitSuppFlightOrderDto fitSuppFlightOrderDto:allSuppFlightOrderDtos){							 
							 List<FitSuppFlightOrderDetailDto> details = fitSuppFlightOrderDto.getSuppFlightOrderDetailDtos();
							 List<FitSuppFlightOrderDetailDto> newDetails = new ArrayList<FitSuppFlightOrderDetailDto>();
							 for(FitSuppFlightOrderDetailDto detail:details){
								 FitOrderPassengerDto p = detail.getFitOrderPassenger();
								 if(!allPassengerNos.contains(p.getPassengerIDCardNo())){
									 allPassengerNos.add(p.getPassengerIDCardNo());
									 newDetails.add(detail);
								 } 
							 }
							 fitSuppFlightOrderDto.setSuppFlightOrderDetailDtos(newDetails);
						}
					}
				}
			}else{
				//未打开开关，就设置前台不显示包机的东西.
				model.addAttribute("isCharter", "false"); 
			}
			baseResultDto.setBookingSource(BookingSource.getBookingSourceName(baseResultDto.getBookingSource().getParentSource().name()));
			model.addAttribute("base", baseResultDto);
			//3：构建飞机快照信息
			buildFlightInfo(model,baseResultDto);
			 
			//4: 构建酒店快照信息
			List<FitOrderHotelDto> hotels = baseResultDto.getFitOrderHotelDtos();
			if(hotels != null && hotels.size()>0){
				FitOrderHotelDto hotel = hotels.get(0);
				model.addAttribute("hotel", hotel);
				model.addAttribute("branchDesc", hotel.getBranchDesc());
			}
				
		} catch (Exception e) {
			logger.error("台后详情查询出错！");
			e.printStackTrace();
		}
		return "order/orderdetail/main";

	}
    
	/**
	 *  构建 机票相关信息
	 * @author wanghuihui
	 * @date:2016年3月9日 下午2:19:03
	 * @param model
	 * @param baseResultDto
	 * @throws Exception
	 */
	private void buildFlightInfo(Model model, FitOrderMainDto baseResultDto) throws Exception {
		if(null == baseResultDto){
			return ;
		}
		List<FitOrderFlightDto> infos = baseResultDto.getFitOrderFlightDtos();
		boolean isReturn = false;  //默认是单程
		for(FitOrderFlightDto flight:infos){
			if(FlightTripType.RETURN.name().equals(flight.getTripType().name())){
				isReturn = true;
				break;
			}
		}
		if(null != infos && (infos.size() >= 2) && isReturn){//往返程：去程和返程
			model.addAttribute("fligthSize", 2);
			FitOrderFlightDto flightInfoGo = null ;
			FitOrderFlightDto flightInfoBack = null  ;
			for(FitOrderFlightDto flight:infos){
				if(FlightTripType.DEPARTURE.name().equals(flight.getTripType().name())){
					flightInfoGo = flight;
				}
				if(FlightTripType.RETURN.name().equals(flight.getTripType().name())){
					flightInfoBack = flight;
				}
			}
			if(flightInfoGo == null || flightInfoBack == null){
				throw new Exception("机票航班数据出错！");
			}
			String goDate = flightInfoGo.getDepartureDate();
			String backDate = flightInfoBack.getDepartureDate();
			if(StringUtil.isNotEmptyString(goDate) && StringUtil.isNotEmptyString(backDate)){
				if(goDate.compareTo(backDate) > 0){
					FitOrderFlightDto temp = flightInfoGo;
					flightInfoGo = flightInfoBack;
					flightInfoBack = temp;
				}
			}
			
			flightInfoGo.setFlyTimeMins(getFlyTime(flightInfoGo.getDepartureTime(),flightInfoGo.getArrivalTime()));
			flightInfoBack.setFlyTimeMins(getFlyTime(flightInfoBack.getDepartureTime(),flightInfoBack.getArrivalTime()));
			//去程
			String departTime = flightInfoGo.getDepartureTime();
			String arriveTime = flightInfoGo.getArrivalTime();
			if(StringUtils.isNotEmpty(departTime) && departTime.length()>16){
				model.addAttribute("go_departTime", departTime.substring(11, 16));
				model.addAttribute("go_departDate", departTime.substring(5, 10));
			}
			if(StringUtils.isNotEmpty(arriveTime) && arriveTime.length()>16){
				model.addAttribute("go_arriveTime", arriveTime.substring(11, 16));
			}
			String ddepartureDate = flightInfoGo.getDepartureTime().substring(0, 10);
			String darrivalDate = flightInfoGo.getArrivalTime().substring(0, 10);
			if(!ddepartureDate.equals(darrivalDate)){
				model.addAttribute("go_add", true);
			}
			
			//返程
			String back_departTime = flightInfoBack.getDepartureTime();
			String back_arriveTime = flightInfoBack.getArrivalTime();
			String rdepartureDate = back_departTime.substring(0, 10);
			String rarrivalDate = back_arriveTime.substring(0, 10);
			if(StringUtils.isNotEmpty(back_departTime) && back_departTime.length()>16){
				model.addAttribute("back_departTime", back_departTime.substring(11, 16));
				model.addAttribute("back_departDate", back_departTime.substring(5, 10));
			}
			if(StringUtils.isNotEmpty(back_arriveTime) && back_arriveTime.length()>16){
				model.addAttribute("back_arriveTime", back_arriveTime.substring(11, 16));
			}
			if(!rdepartureDate.equals(rarrivalDate)){
				model.addAttribute("back_add", true);
			}
			model.addAttribute("flight0", flightInfoGo);
			model.addAttribute("flight1", flightInfoBack);
		}else if(null != infos && infos.size() > 0){  //单程机票
			model.addAttribute("fligthSize", 1);
			FitOrderFlightDto flightInfoGo = infos.get(0);
			flightInfoGo.setFlyTimeMins(getFlyTime(flightInfoGo.getDepartureTime(),flightInfoGo.getArrivalTime()));
			String departTime = flightInfoGo.getDepartureTime();
			String arriveTime = flightInfoGo.getArrivalTime();
			if(StringUtils.isNotEmpty(departTime) && departTime.length()>16){
				model.addAttribute("go_departTime", departTime.substring(11, 16));
				model.addAttribute("go_departDate", departTime.substring(5, 10));
			}
			if(StringUtils.isNotEmpty(arriveTime) && arriveTime.length()>16){
				model.addAttribute("go_arriveTime", arriveTime.substring(11, 16));
			}
			String ddepartureDate = flightInfoGo.getDepartureTime().substring(0, 10);
			String darrivalDate = flightInfoGo.getArrivalTime().substring(0, 10);
			if(!ddepartureDate.equals(darrivalDate)){
				model.addAttribute("go_add", true);
			}
			model.addAttribute("flight0", flightInfoGo);
		}
	}
	
	
	/**
	 * 获得两个时间的时差 : 3h:2m
	 * @author wanghuihui
	 * @date:2015年12月20日 下午2:11:35
	 * @param departTime 'yyyy-MM-dd hh:mm:ss'
	 * @param arriveTime 'yyyy-MM-dd hh:mm:ss'
	 * @return
	 */
    private String getFlyTime(String departTime, String arriveTime) {
		if(StringUtils.isEmpty(departTime) || StringUtils.isEmpty(arriveTime)){
			logger.error("获得飞行时长参数出错！");
			return ""; 
		}
		Date startDate = DateUtils.parseCnHmDate(departTime);
		Date endDate = DateUtils.parseCnHmDate(arriveTime);
		Long between = (endDate.getTime() - startDate.getTime());
		int h = (int) (between / (3600L * 1000));  //小时
		int m = (int) ((between) / (60 * 1000)) - h*60;		  //分钟
		return (h>0?h+"h":"") + (m>0?m+"m":"0m");
	}
    
    /**
     * 跳转到订单日志列表
     * @author wanghuihui
     * @date:2016年1月18日 下午3:08:37
     * @return
     */
    @Override
	@RequestMapping("order/toOrderLog/{mainOrderId}")
	public String toOrderLog(Model model,@PathVariable("mainOrderId") Long mainOrderId) {
    	model.addAttribute("mainOrderId", mainOrderId);
    	model.addAttribute("operTypeEnum", OperType.values());   //订单类型
		return "order/order_log_list";
	}
    
    /**
     *  订单日志列表查询
     * @author wanghuihui
     * @date:2016年1月18日 下午3:09:14
     * @param model
     * @param mainOrderId
     * @param fitOrderQueryRequest
     * @return
     */
    @Override
    @RequestMapping("order/orderLog")
    @ResponseBody
    public BaseResultDto<FitOrderOpLogForm> toOrderLog(Model model,FitOrderQueryRequest fitOrderQueryRequest) {
    	//2、查询订单列表
    	try {
    		BaseResultDto<FitOrderOpLogForm> baseResultDto = fitBusinessClient.queryOrderLogList(fitOrderQueryRequest);
    		if(baseResultDto != null)	{
    			return baseResultDto;
    		}
    	} catch (Exception e) {
    		logger.error("后台订单查询失败！");
    		e.printStackTrace();
    	}
		return null;
    }

	@Override
	@RequestMapping(value = "order/suppCallBack", method = { RequestMethod.POST, RequestMethod.GET })
	public String suppFlightCallBack(Model model) {
		buildOrderModel(model);
		return "supp_flight_call_back";
	}

	@ResponseBody
	@RequestMapping(value = "order/suppCallBackQuery", method = { RequestMethod.POST, RequestMethod.GET })
	public BaseResultDto<FitSuppOrderForFlightCallBackForm> suppOrderFlightCallBack(Model model, Pagination pg, FitSuppOrderForFlightCallBackRequest request) {
		try {
			BaseQueryDto<FitSuppOrderForFlightCallBackRequest> baseQuery = new BaseQueryDto<FitSuppOrderForFlightCallBackRequest>();
			baseQuery.setPagination(pg);
			baseQuery.setCondition(request);
			BaseResultDto<FitSuppOrderForFlightCallBackDto> baseResult = fitBusinessClient.getSuppOrderForFlightCallBack(baseQuery);
			List<FitSuppOrderForFlightCallBackDto> results = baseResult.getResults();
			List<FitSuppOrderForFlightCallBackForm> formList = new ArrayList<FitSuppOrderForFlightCallBackForm>();
			for(int i=0;i<results.size();i++){
				FitSuppOrderForFlightCallBackDto callBackDto = results.get(i);
				FitSuppOrderForFlightCallBackForm callBackForm = new FitSuppOrderForFlightCallBackForm();
				callBackForm.setCallBackDto(callBackDto);
				formList.add(callBackForm);
			}
			BaseResultDto<FitSuppOrderForFlightCallBackForm> baseResultForm = new BaseResultDto<FitSuppOrderForFlightCallBackForm>();
			baseResultForm.setResults(formList);
			baseResultForm.setPagination(baseResult.getPagination());
			return baseResultForm;
		} catch (Exception e) {
			logger.error("自主打包产品城市组查询失败！");
			e.printStackTrace();
		}
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "order/handleSuppFlightCallBack", method = { RequestMethod.POST, RequestMethod.GET })
	public Object handleSuppFlightCallBack(Model model, Long vstOrderMainNo,Long vstOrderNo) {
		BaseQueryDto<FitFliBookingCallBackRequest> baseQuery = new BaseQueryDto<FitFliBookingCallBackRequest>();
		FitFliBookingCallBackRequest request = new FitFliBookingCallBackRequest();
		request.setVstOrderMainNo(vstOrderMainNo);
		request.setVstOrderNo(vstOrderNo);
		baseQuery.setCondition(request);
		String fliBookingCallBack = fitBusinessClient.getFitFliBookingCallBackByVstMainNo(baseQuery);
		try {
			String returnStr = fitBusinessClient.flightCallBackBooking(fliBookingCallBack);
			return returnStr;
		} catch (Exception e) {
			logger.error("自主打包产品加价规则保存失败！");
			e.printStackTrace();
		}
		return null;
	}
}

