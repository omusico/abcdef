package com.lvmama.lvfit.business.order.service;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.insurance.InsuranceOrderDto;
import com.lvmama.lvf.common.dto.order.FlightOrderInsuranceDto;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.common.utils.StringUtil;
import com.lvmama.lvf.common.utils.ZipUnZipUtils;
import com.lvmama.lvfit.business.booking.service.FitBookingFinService;
import com.lvmama.lvfit.business.booking.service.FitBookingService;
import com.lvmama.lvfit.business.order.domain.repository.*;
import com.lvmama.lvfit.common.client.FitVstClient;
import com.lvmama.lvfit.common.dto.adapter.request.FlightOrderQueryRequest;
import com.lvmama.lvfit.common.dto.enums.*;
import com.lvmama.lvfit.common.dto.order.*;
import com.lvmama.lvfit.common.dto.request.FitFlightOrderQueryRequest;
import com.lvmama.lvfit.common.dto.request.FitOrderQueryRequest;
import com.lvmama.lvfit.common.dto.search.flight.result.CharterFlightFilterUtil;
import com.lvmama.lvfit.common.dto.status.order.OrderBookingStatus;
import com.lvmama.lvfit.common.form.order.FitOrderOpLogForm;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 *  后台订单查询
 * @author wanghuihui
 * @date:2016年1月5日 下午10:38:23
 */
@Service
@Transactional
public class OrderQueryServiceImpl implements OrderQueryService {
	
	private static Logger logger = LoggerFactory.getLogger(OrderQueryServiceImpl.class);
	
	@Autowired
	private FitVstClient fitVstClient;
	
	@Autowired
	FitOrderBackQueryRepository fitOrderBackQueryRepository;
	
	@Autowired
    private FitOrderMainRepository fitOrderMainRepository;
    
	@Autowired
    private FitOrderPassengerRepository fitOrderPassengerRepository;
	
	@Autowired
	private FitOrderOpLogRepository fitOrderOpLogRepository;
	
	@Autowired
	private FitSuppFlightOrderRepository fitSuppFlightOrderRepository;
	
	@Autowired
	private OrderSyncService  orderSyncService;
	
	@Autowired
	private FitOrderHotelRepository fitOrderHotelRepository;
	
	@Autowired
	private FitBookingService fitBookingService;
	
	@Autowired
	private FitBookingFinService fitBookingFinService;
	
	@Autowired
	private FitOrderFlightRepository fitOrderFlightRepository;

	@Autowired
	private FitSuppOrderForFlightCallBackRepository fitSuppOrderForFlightCallBackRepository;
    
	@Override
	public List<FitOrderQueryListDto> queryOrderList(
			BaseQueryDto<FitOrderQueryRequest> baseQueryDto) {
		List<FitOrderQueryListDto> list = fitOrderBackQueryRepository.query(baseQueryDto);
        //处理每条订单的操作信息
        if (CollectionUtils.isNotEmpty(list)) {
    		BookingSourceOffline[] bookingSourceOffline = BookingSourceOffline.values();  //下单来源
            for (int i=0;i<list.size();i++) {
            	FitOrderQueryListDto orderListDto = list.get(i);
            	orderListDto.setPayType("预付(驴妈妈)");
            	orderListDto.setDetailCount(orderListDto.getAdultQuantity()+orderListDto.getChildQuantity());
            	FitSuppMainOrderStatusDto suppMainStatus = orderListDto.getFitSuppMainOrderStatusDto();
            	String allStatus = "";
            	if(null != suppMainStatus.getOrderStatus()){
            		allStatus += suppMainStatus.getOrderStatus().getCnName() + " | ";
            	}
            	if(null != suppMainStatus.getAuditStatus()){
            		allStatus += suppMainStatus.getAuditStatus().getCnName()+ " | ";
            	}
            	if(null != suppMainStatus.getPaymentStatus()){
            		allStatus += suppMainStatus.getPaymentStatus().getCnName();
            	}
            	orderListDto.setAllStatus(allStatus);
            	String source = orderListDto.getBookingSource();
            	//预定来源
            	if(StringUtil.isNotEmptyString(source)){
					orderListDto.setBookingSource(BookingSource.valueOf(source).getParentSource().getCnName());
            	}
            	if(orderListDto.getCreateTime() != null){
            		orderListDto.setCreateDate(DateUtils.formatDateByFormat(orderListDto.getCreateTime(),"yyyy-MM-dd HH:mm:ss"));
            	}
            	list.set(i, orderListDto);
            }
        }
        
        return list;
	}


	@Override
	public int countOrderListRecords(
			BaseQueryDto<FitOrderQueryRequest> baseQueryDto) {
		return fitOrderBackQueryRepository.count(baseQueryDto);
	}

	@Override
	public FitOrderMainDto queryOrderMainByVstOrderMainNo(Long vstOrderMainNo) {
        

		//1. 获取机酒主单信息
		FitOrderMainDto orderMainDto = fitOrderMainRepository.getByVstOrderMainNo(vstOrderMainNo);
		
		if(orderMainDto==null){
		    return null;
		}
		
		//2. 补全供应商机票订单的相关信息
		FlightOrderQueryRequest flightOrderQueryRequest = new FlightOrderQueryRequest();
		FitSuppMainOrderDto suppMainOrderDto = orderMainDto.getFitSuppMainOrderDto();
		flightOrderQueryRequest.setFitSuppMainOrderDto(suppMainOrderDto);
		
		/*List<FitSuppOrderDto> noUpdateSuppOrderDtos = suppMainOrderDto.getFitSuppOrderDtos();
		Map<String,Boolean> isNeedUpdateMap = new HashMap<String, Boolean>();
		 if(CollectionUtils.isNotEmpty(noUpdateSuppOrderDtos)){
			 for (FitSuppOrderDto suppOrderDto : noUpdateSuppOrderDtos) {
					if (0 == BizEnum.BIZ_CATEGORY_TYPE.category_traffic_aero_other.getCategoryId().compareTo(suppOrderDto.getCategoryId())){
						List<FitSuppFlightOrderDto> suppFlightOrderDtos = suppOrderDto.getSuppFlightOrderDtos();
						for (FitSuppFlightOrderDto fitSuppFlightOrderDto : suppFlightOrderDtos) {
								isNeedUpdateMap.put(fitSuppFlightOrderDto.getId().toString(), Boolean.valueOf(fitSuppFlightOrderDto.isNeedUpdate(fitSuppFlightOrderDto.getSuppFlightOrderDetailDtos())));
						}
					}
			 }
		 }*/
		
		//是否包机
		boolean isCharter = false;
		try {
			suppMainOrderDto = fitVstClient.completeSuppFlightInfo(flightOrderQueryRequest);
			orderMainDto.setFitSuppMainOrderDto(suppMainOrderDto);
			//如果打开的包机查询的开关，就进行下面的判断处理.否则默认前台不显示包机的相关逻辑.
			if(CharterFlightFilterUtil.getQueryCharsetFlight()){
				if(CollectionUtils.isEmpty(suppMainOrderDto.getSuppFlightOrderDtos())){
					isCharter = false;
				}else{
					isCharter = true;
				}
			} 
			 
		 	// 根据从机票端返回的保险单号信息，设置在fitOrderMainDto中
			// 处理航意险的信息.
			if (CollectionUtils.isNotEmpty(orderMainDto.getFlightInsuranceDtos()) 
			        && CollectionUtils.isNotEmpty(suppMainOrderDto.getFlightInsDtos())) {
    			for (FitOrderFliInsuranceDto orderInsDto : orderMainDto.getFlightInsuranceDtos()) {
        			for (FlightOrderInsuranceDto flightInsDto : suppMainOrderDto.getFlightInsDtos()) {
        			    InsuranceOrderDto insuranceOrderDto = flightInsDto.getInsuranceOrderDto();
        			    if (insuranceOrderDto != null) {
        			        // 通过身份证号航班号匹配保险单号
        			        if (orderInsDto.getIdCardNo().equals(insuranceOrderDto.getIdCardNo())
        			                && orderInsDto.getFlightNo().equals(insuranceOrderDto.getFlightNo())) {
        			            orderInsDto.setInsuranceOrderNo(insuranceOrderDto.getInsuranceNo());
        			        }
        			    }
         			}
    			}
			} 
		} catch (Exception e1) {
			logger.error(ExceptionUtils.getFullStackTrace(e1));
		}
		//不是包机，以前的逻辑处理方式.
		if(!isCharter){
			 List<FitSuppOrderDto> fitSuppOrderDtos = suppMainOrderDto.getFitSuppOrderDtos();
			 if(CollectionUtils.isNotEmpty(fitSuppOrderDtos)){
				 for (FitSuppOrderDto suppOrderDto : fitSuppOrderDtos) {
						if (0 == BizEnum.BIZ_CATEGORY_TYPE.category_traffic_aero_other.getCategoryId().compareTo(suppOrderDto.getCategoryId())){
							List<FitSuppFlightOrderDto> suppFlightOrderDtos = suppOrderDto.getSuppFlightOrderDtos();
							for (FitSuppFlightOrderDto fitSuppFlightOrderDto : suppFlightOrderDtos) {
									fitSuppFlightOrderRepository.save(fitSuppFlightOrderDto);
							}
						}
				 }
			 }
		}
		//是包机
		else{ 
			//保存包机的航班子单信息到数据库
			List<FitSuppFlightOrderDto> suppFlightOrderDtos = suppMainOrderDto.getSuppFlightOrderDtos();
			for (FitSuppFlightOrderDto fitSuppFlightOrderDto : suppFlightOrderDtos) { 
				fitSuppFlightOrderDto.setSaleType(SuppSaleType.DomesticProduct.name()); 
				Long newOrderId = 0-fitSuppFlightOrderDto.getSuppOrderId();
				fitSuppFlightOrderDto.setSuppOrderId(newOrderId);
				fitSuppFlightOrderRepository.save(fitSuppFlightOrderDto); 
			}
		}
		 
	   try {
			FitSuppMainOrderStatusDto  suppMainOrderStatusDto = orderSyncService.syncSuppMainOrderStatus(suppMainOrderDto.getFitSuppMainOrderStatus().getVstMainOrderNo());
			 suppMainOrderDto.setFitSuppMainOrderStatus(suppMainOrderStatusDto);
		} catch (Exception e2) {
			logger.error(ExceptionUtils.getFullStackTrace(e2));
		}
		 
		try {
			logger.info("订单详情orderMainDto="+JSONMapper.getInstance().writeValueAsString(orderMainDto));
		} catch (Exception e) {
			logger.error(ExceptionUtils.getFullStackTrace(e));
		}
        return orderMainDto;
	} 

	@Override
	public List<FitOrderOpLogForm> queryOrderLogList(
			FitOrderQueryRequest fitOrderQueryRequest) {
		BaseQueryDto<FitOrderQueryRequest> baseQuery = new BaseQueryDto<FitOrderQueryRequest>(fitOrderQueryRequest.getPagination(), fitOrderQueryRequest);
		List<FitOrderOpLogDto> list = fitOrderOpLogRepository.query(baseQuery);
		List<FitOrderOpLogForm> listResult = new ArrayList<FitOrderOpLogForm>();
        //处理每条订单的操作信息
        if (CollectionUtils.isNotEmpty(list)) {
            for (int i=0;i<list.size();i++) {
            	FitOrderOpLogForm form = new FitOrderOpLogForm();
            	FitOrderOpLogDto orderOpListDto = list.get(i);
            	form.setFitOrderOpLogDto(orderOpListDto);
            	form.setOperType(orderOpListDto.getOperType().getCnName());
            	listResult.add(form);
            }
        }
        return listResult;
	}

	@Override
	public int countOrderLogListRecords(
			FitOrderQueryRequest fitOrderQueryRequest) {
		BaseQueryDto<FitOrderQueryRequest> baseQuery = new BaseQueryDto<FitOrderQueryRequest>();
		baseQuery.setCondition(fitOrderQueryRequest);
		return fitOrderOpLogRepository.count(baseQuery);
	}

	@Override
	public List<String> queryOrderAllReport(
			BaseQueryDto<FitOrderQueryRequest> baseQueryDto) {
		List<String> result = new ArrayList<String>();
		List<FitOrderQueryListDto> list = fitOrderBackQueryRepository.queryOrderAllReport(baseQueryDto);
        //处理每条订单的操作信息
        if (CollectionUtils.isNotEmpty(list)) {
        	StringBuilder sb = new StringBuilder();
        	//订单号、VST主单号、产品名称、预订人数、下单时间、订单状态、支付状态、审核状态、支付方式、订单来源、订单金额
            for (int i=0;i<list.size();i++) {
            	sb.delete(0, sb.length());
            	FitOrderQueryListDto orderListDto = list.get(i);
            	
            	sb.append(orderListDto.getMainOrderNo() != null ?"\t"+orderListDto.getMainOrderNo()+",":",");
            	sb.append(orderListDto.getVstMainOrderNo() != null ?"\t"+orderListDto.getVstMainOrderNo()+" ,":",");
            	sb.append(orderListDto.getProductName() != null ?orderListDto.getProductName()+",":",");
            	sb.append("\t"+(orderListDto.getAdultQuantity()+orderListDto.getChildQuantity())+",");
            	sb.append(orderListDto.getCreateTime() != null ?"\t"+DateUtils.formatCnHmDate(orderListDto.getCreateTime())+",":",");
            	
            	if(orderListDto.getFitSuppMainOrderStatusDto() != null){
            		FitSuppMainOrderStatusDto suppMainStatus = orderListDto.getFitSuppMainOrderStatusDto();
            		sb.append(suppMainStatus.getOrderStatus() != null ?suppMainStatus.getOrderStatus().getCnName()+",":",");
            		sb.append(suppMainStatus.getPaymentStatus() != null ?suppMainStatus.getPaymentStatus().getCnName()+",":",");
            		sb.append(suppMainStatus.getAuditStatus() != null ?suppMainStatus.getAuditStatus().getCnName()+",":",");
            	}else{
            		sb.append(" , , ,");
            	}
            	
            	sb.append("预付(驴妈妈),");
            	sb.append("交通X_前台,");
            	sb.append(orderListDto.getOrderTotalAmount() != null ?orderListDto.getOrderTotalAmount()+",":",");  //最后一条不加逗号
            	sb.append(BizEnum.BIZ_CATEGORY_TYPE.getCnName(orderListDto.getCategoryId()));
            	result.add(sb.toString());
            }
        }
		return result;
	}

	@Override
	public List<String> queryOrderFlightReport(
			BaseQueryDto<FitOrderQueryRequest> baseQueryDto) {
		List<String> result = new ArrayList<String>();
		List<FitOrderQueryListDto> mainIdList = fitOrderBackQueryRepository.queryNoPage(baseQueryDto);
		String mainIds = "";
		if(CollectionUtils.isNotEmpty(mainIdList)){
			for(int i=0;i<mainIdList.size();i++){
				FitOrderQueryListDto queryList = mainIdList.get(i);
				if(i==0){
					mainIds += queryList.getMainId();
				}else{
					mainIds += ","+queryList.getMainId();
				}
			}
			baseQueryDto.getCondition().setMainIds(mainIds);
		}else{
			return result;
		}
		List<FitOrderQueryListDto> list = fitOrderBackQueryRepository.queryOrderFlightReport(baseQueryDto);
        //处理每条订单的操作信息
        if (CollectionUtils.isNotEmpty(list)) {
        	StringBuilder sb = new StringBuilder();
        	// 机酒主单号	VST主单号	机酒子单号	VST子单号	订单类型	  /**  供应商	供应商订单号	PNR  **/ 	
        	// 航程	航班号	乘机时间	预订人数	应收款	支付方式	联系人	下单时间	订单来源	当前状态
            for (int i=0;i<list.size();i++) {
            	sb.delete(0, sb.length());
            	FitOrderQueryListDto orderListDto = list.get(i);
            	FitOrderFlightDto flightDto = orderListDto.getFitOrderFlightDto();
            	
            	sb.append(orderListDto.getMainOrderNo() != null ?"\t"+orderListDto.getMainOrderNo()+",":",");
            	sb.append(orderListDto.getVstMainOrderNo() != null ?"\t"+orderListDto.getVstMainOrderNo()+",":",");
            	
            	sb.append(orderListDto.getOrderNo() != null ?"\t"+orderListDto.getOrderNo()+"\t,":",");
            	sb.append(orderListDto.getVstOrderNo() != null ?"\t"+orderListDto.getVstOrderNo()+"\t,":",");
            	sb.append("正常,");
            	sb.append(",,,");    // 暂没有： 供应商	供应商订单号	PNR 
            	
            	sb.append(flightDto.getDepartureAirportCode()+"-"+flightDto.getArrivalAirportCode()+"\t,");
            	if(flightDto.getFlightNo() != null){
            		sb.append(flightDto.getFlightNo());
            		if(flightDto.getSeatClassCode() != null){
            			sb.append("("+flightDto.getSeatClassCode()+"),");
            		}else{
            			sb.append(",");
            		}
            	}else{
            		sb.append(",");
            	}
            	sb.append(flightDto.getDepartureTime() != null ?"\t"+flightDto.getDepartureTime()+",":",");
            	sb.append(orderListDto.getDetailCount() != null ?orderListDto.getDetailCount()+",":"0,");
            	sb.append(orderListDto.getOrderTotalAmount() != null ?orderListDto.getOrderTotalAmount()+",":"0,");
            	sb.append("预付(驴妈妈),");
            	sb.append(orderListDto.getContactName() != null ?orderListDto.getContactName()+",":",");
            	sb.append(flightDto.getCreateTime() != null ?"\t"+DateUtils.formatCnHmDate(flightDto.getCreateTime())+",":",");
            	sb.append("交通X_前台,");
            	sb.append(orderListDto.getOrderBookingStatus() != null ? orderListDto.getOrderBookingStatus().getCnName() : "预订失败"); //最后一条当前状态
            	result.add(sb.toString());
            }
        }
		return result;
	}
	
	/**
	 *  酒店报表
	 * @author wanghuihui
	 * @date:2016年1月25日 下午6:27:59
	 * @param baseQueryDto
	 * @return
	 */
	@Override
	public List<String> queryOrderHotelReport(BaseQueryDto<FitOrderQueryRequest> baseQueryDto) {
		List<String> result = new ArrayList<String>();
		List<FitOrderQueryListDto> mainIdList = fitOrderBackQueryRepository.queryNoPage(baseQueryDto);
		String mainIds = "";
		if(CollectionUtils.isNotEmpty(mainIdList)){
			for(int i=0;i<mainIdList.size();i++){
				FitOrderQueryListDto queryList = mainIdList.get(i);
				if(i==0){
					mainIds += queryList.getMainId();
				}else{
					mainIds += ","+queryList.getMainId();
				}
			}
			baseQueryDto.getCondition().setMainIds(mainIds);
		}else{
			return result;
		}
		List<FitOrderQueryListDto> list = fitOrderBackQueryRepository.queryOrderHotelReport(baseQueryDto);
        //处理每条订单的操作信息
        if (CollectionUtils.isNotEmpty(list)) {
        	StringBuilder sb = new StringBuilder();
        	// "机酒主订单号,VST主单号,VST子单号,入住城市,酒店名称,房型信息,间数,预订人数,支付金额,支付方式,联系人,下单时间,订单来源,当前状态";
            for (int i=0;i<list.size();i++) {
            	sb.delete(0, sb.length());
            	FitOrderQueryListDto orderListDto = list.get(i);
            	FitOrderHotelDto hotelDto = orderListDto.getFitOrderHotelDto();
            	
            	sb.append(orderListDto.getMainOrderNo() != null ?"\t"+orderListDto.getMainOrderNo()+",":",");
            	sb.append(orderListDto.getVstMainOrderNo() != null ?"\t"+orderListDto.getVstMainOrderNo()+",":",");
            	sb.append(orderListDto.getVstOrderNo() != null ?"\t"+orderListDto.getVstOrderNo() +",":",");
            	
				if(hotelDto.getCheckInCity() != null){
					sb.append(VSTDistrictCityEnum.getCnName(hotelDto.getCheckInCity().trim())+",");
				}else{
					sb.append(",");
				}
				sb.append(hotelDto.getHotelName() != null ?hotelDto.getHotelName()+",":",");
				sb.append(hotelDto.getBranchDesc()+",");
				sb.append(hotelDto.getRoomCount()+",");
				sb.append(orderListDto.getDetailCount() != null ?orderListDto.getDetailCount()+",":"0,");
				sb.append(orderListDto.getOrderTotalAmount() != null ?orderListDto.getOrderTotalAmount()+",":"0,");
				sb.append("预付(驴妈妈),");
				sb.append(orderListDto.getContactName() != null ?orderListDto.getContactName()+",":",");
				sb.append(hotelDto.getCreateTime() != null ?"\t"+DateUtils.formatCnHmDate(hotelDto.getCreateTime())+",":",");
				sb.append("交通X_前台");
				//sb.append("订位成功"); //最后一条当前状态
            	result.add(sb.toString());
            }
        }
		return result;
	}
	
    @Override
    @Transactional
    public FitOrderDetail getMainOrder4VSTByOrderMainNo(Long vstOrderMainNo) {
        FitOrderDetail result = fitVstClient.getFitOrderMainDtoByOrderMainNo(vstOrderMainNo);
        List<FitOrderHotelDto> hotels = result.getHotels();
        // 从酒店快照表取得酒店信息
        if(CollectionUtils.isNotEmpty(hotels)){
            for (FitOrderHotelDto fitOrderHotelDto : hotels) {
                List<FitOrderHotelDto> fitOrderHotelDtos = fitOrderHotelRepository.getByPlanIdAndCheckIn(fitOrderHotelDto.getPlanId(), fitOrderHotelDto.getCheckin());
                try {
                    logger.error("从数据库中查询酒店快照信息" + JSONMapper.getInstance().writeValueAsString(fitOrderHotelDtos));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (CollectionUtils.isNotEmpty(fitOrderHotelDtos)) {
                    List<FitOrderHotelDto> selectHotelDtos = new ArrayList<FitOrderHotelDto>();
                    selectHotelDtos.add(fitOrderHotelDtos.get(0));
                    result.setHotels(selectHotelDtos);
                }
            }
        }
        // 从机票快照表取得快照信息
        if (CollectionUtils.isEmpty(result.getFlights())) {
            List<FitOrderFlightDto> fitOrderFlightDtos = fitOrderFlightRepository.getOldFitOrderMainData(vstOrderMainNo.toString());
            try {
                logger.error("从数据库中查询酒店快照信息" + JSONMapper.getInstance().writeValueAsString(fitOrderFlightDtos));
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 返回机票信息去重
            List<FitOrderFlightDto> resultFlights = new ArrayList<FitOrderFlightDto>();
            for (FitOrderFlightDto fitOrderFlightDto : fitOrderFlightDtos) {
                if (fitOrderFlightDto.getTripType().equals(FlightTripType.DEPARTURE)) {
                    resultFlights.add(fitOrderFlightDto);
                    break;
                }
            }
            for (FitOrderFlightDto fitOrderFlightDto : fitOrderFlightDtos) {
                if (fitOrderFlightDto.getTripType().equals(FlightTripType.RETURN)) {
                    resultFlights.add(fitOrderFlightDto);
                    break;
                }
            }
            result.setFlights(resultFlights);
        }
        
        // 从机票快照表中取得数据
        FitOrderMainDto fitOrderMainDto = this.convertFitOrderDetail2FitOrderMainDto(result);
        List<FitOrderPassengerDto> passengers = fitOrderMainDto.getFitOrderPassengers();
        for (FitOrderPassengerDto passenger : passengers) {
            passenger.setId(null);
        }
        try {
            logger.error("需要迁移的FitOrderMainDto：" + JSONMapper.getInstance().writeValueAsString(fitOrderMainDto));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (fitOrderMainDto != null) {
            fitOrderMainDto.setId(null);
            fitOrderMainDto.setFitOrderBasicInfoDto(this.genOrderBasicInfo(fitOrderMainDto, result, passengers));
            fitBookingService.storeOrder(fitOrderMainDto);
            
            fitOrderMainDto.setFitSuppMainOrderDto(this.genSuppOrderInfo(fitOrderMainDto, result, vstOrderMainNo, passengers));
            fitBookingFinService.finishBooking(fitOrderMainDto);
            
            fitOrderMainRepository.updateSucOldOrderMainDto(vstOrderMainNo);
        }
        return result;
    }
    
    private FitOrderMainDto convertFitOrderDetail2FitOrderMainDto(FitOrderDetail fitOrderDetail) {
        String vstOrderMainNo = fitOrderDetail.getVstOrderMainNo();
        // 构建主单和子单信息
        FitOrderMainDto fitOrderMainDto = fitOrderMainRepository.getOldByVstOrderMainNo(Long.valueOf(vstOrderMainNo));
        fitOrderMainDto.setProductName(fitOrderDetail.getProductName());
        fitOrderMainDto.setFitOrderPassengers(fitOrderPassengerRepository.queryByFkId(fitOrderMainDto.getId()));
        FitOrderCustomerDto customerDto = fitOrderMainDto.getFitOrderCustomer();
        String customerCode = customerDto.getCustomerCode();
        String customerId = customerDto.getCustomerId();
        customerDto.setCustomerCode(customerId);
        customerDto.setCustomerId(customerCode);
        fitOrderMainDto.setFitOrderFlightDtos(fitOrderDetail.getFlights());
        fitOrderMainDto.setFitOrderHotelDtos(fitOrderDetail.getHotels());
        try {
            System.out.println(JSONMapper.getInstance().writeValueAsString(fitOrderMainDto));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fitOrderMainDto;
    }
    
    private FitSuppMainOrderDto genSuppOrderInfo(FitOrderMainDto fitOrderMainDto, FitOrderDetail fitOrderDetail, Long vstOrderMainNo, List<FitOrderPassengerDto> passengers) {
        FitSuppMainOrderDto fitSuppMainOrderDto = new FitSuppMainOrderDto();
        fitSuppMainOrderDto.setCreateTime(fitOrderMainDto.getCreateTime());
        fitSuppMainOrderDto.setUpdateTime(fitOrderMainDto.getUpdateTime());
        fitSuppMainOrderDto.setFitMainOrderId(fitOrderMainDto.getId());
        fitSuppMainOrderDto.setFitMainOrderNo(fitOrderMainDto.getFitOrderNo().getOrderNo());
        fitSuppMainOrderDto.setVstMainOrderNo(vstOrderMainNo);
        fitSuppMainOrderDto.setBindingStatus(BindingStatus.BINDING);
        FitOrderAmountDto fitOrderAmountDto = new FitOrderAmountDto();
        fitOrderAmountDto.setTotalAmount(fitOrderDetail.getTotalAmount());
        fitSuppMainOrderDto.setOrderAmount(fitOrderAmountDto);
        fitSuppMainOrderDto.setVisitTime(fitOrderDetail.getVisitTime());
        fitSuppMainOrderDto.setPaymentTarget(fitOrderDetail.getPaytarget());
        FitSuppMainOrderStatusDto mainOrderStatus = new FitSuppMainOrderStatusDto();
        
        mainOrderStatus.setVstMainOrderNo(vstOrderMainNo);
        mainOrderStatus.setOrderViewStatus(SuppVstOrderViewStatus.APPROVING);
        mainOrderStatus.setOrderStatus(SuppVstOrderStatus.CANCEL);
        mainOrderStatus.setAuditStatus(SuppVstAuditStatus.INFOFAIL);
        mainOrderStatus.setPaymentStatus(SuppVstPaymentStatus.PART_PAY);
        
        fitSuppMainOrderDto.setFitSuppMainOrderStatus(mainOrderStatus);
        List<FitOrderDto> fitOrderDtos = fitOrderMainDto.getFitOrders();
        List<FitSuppOrderDto> suppOrders = fitOrderDetail.getSuppOrders();
        
        Set<PassengerType> typeSet = new HashSet<PassengerType>();
        
        for (FitOrderPassengerDto passenger : passengers) {
            typeSet.add(passenger.getPassengerType());
        }
        
        for (FitSuppOrderDto suppOrder : suppOrders) {
            suppOrder.setCreateTime(fitOrderMainDto.getCreateTime());
            suppOrder.setUpdateTime(fitOrderMainDto.getUpdateTime());
            if (suppOrder.getCategoryId().longValue() == 21L) {
                List<FitSuppFlightOrderDto> suppFlightOrderDtos = new ArrayList<FitSuppFlightOrderDto>();
                for (Iterator<PassengerType> it = typeSet.iterator(); it.hasNext();) {
                    FitSuppFlightOrderDto suppFlightOrder = new FitSuppFlightOrderDto();
                    suppFlightOrder.setBookingStatus(OrderBookingStatus.BOOKING_SUCC);
                    suppFlightOrder.setPassengerType(it.next());
                    suppFlightOrder.setTripType(suppOrder.getTripType());
                    
                    List<FitSuppFlightOrderDetailDto> suppFlightOrderDetailDtos = new ArrayList<FitSuppFlightOrderDetailDto>();
                    for (FitOrderPassengerDto passenger : passengers) {
                        FitSuppFlightOrderDetailDto suppFlightDtl = new FitSuppFlightOrderDetailDto();
                        suppFlightDtl.setTripType(suppOrder.getTripType());
                        suppFlightDtl.setFitOrderPassenger(passenger);
                        
                        suppFlightOrderDetailDtos.add(suppFlightDtl);
                    }
                    suppFlightOrder.setSuppFlightOrderDetailDtos(suppFlightOrderDetailDtos);
                    suppFlightOrderDtos.add(suppFlightOrder);
                }
                suppOrder.setSuppFlightOrderDtos(suppFlightOrderDtos);
            }
        }
        
        for (int i = 0; i < fitOrderDtos.size(); i++) {
            Long id = fitOrderDtos.get(i).getId();
            suppOrders.get(i).setFitOrderId(id);
        }
        
        fitSuppMainOrderDto.setFitSuppOrderDtos(suppOrders);
        
        return fitSuppMainOrderDto;
    }
    
    private FitOrderBasicInfoDto genOrderBasicInfo(FitOrderMainDto fitOrderMainDto, FitOrderDetail fitOrderDetail, List<FitOrderPassengerDto> passengers) {
        FitOrderBasicInfoDto basicInfo = new FitOrderBasicInfoDto();
        List<FitOrderFlightDto> flights = fitOrderDetail.getFlights();
        List<FitOrderHotelDto> hotels = fitOrderDetail.getHotels();
        basicInfo.setDepCityCode(flights.get(0).getDepartureAirportCode());
        basicInfo.setArriCityCode(flights.get(0).getArrivalAirportCode());
        basicInfo.setCheckInCityCode(flights.get(0).getArrivalAirportCode());
        basicInfo.setToTime(DateUtils.parseDate(flights.get(0).getDepartureDate()));
        basicInfo.setReturnTime(DateUtils.parseDate(flights.get(0).getArrivalTime()));
        basicInfo.setCheckInTime(hotels.get(0).getCheckin());
        basicInfo.setCheckOutTime(hotels.get(0).getCheckout());
        int adultCount = 0;
        int chdCount = 0;
        for (FitOrderPassengerDto passenger : passengers) {
            if (passenger.getPassengerType().equals(PassengerType.ADULT)) {
                adultCount++;
            }
            if (passenger.getPassengerType().equals(PassengerType.CHILDREN)) {
                chdCount++;
            }
        }
        basicInfo.setAdultQuantity(adultCount);
        basicInfo.setChildQuantity(chdCount);
        return basicInfo;
    }
    
    @Override
    public List<FitSuppMainOrderDto> getOldOrderMainData() {
        return fitOrderMainRepository.getAllOldOrderMainDto();
    }

    /**
     * 简化mainDto返回一个只含有机票相关的dto对象.
     * @param orderMainDto
     * @return
     */
    private FitFlightOrderDto changeMainDto(FitOrderMainDto orderMainDto,Long vstOrderNo){
    	FitFlightOrderDto flightOrder = new FitFlightOrderDto();
    	//联系人信息
    	flightOrder.setFitOrderContacter(orderMainDto.getFitOrderContacter());
    	//订单来源
    	flightOrder.setBookingSource(orderMainDto.getBookingSource());
    	flightOrder.setCreateTime(orderMainDto.getCreateTime());
    	flightOrder.setDistributionChannel(orderMainDto.getDistributionChannel());
    	flightOrder.setFitFlightBookingType(orderMainDto.getFitFlightBookingType());
    	flightOrder.setFitOrderNo(orderMainDto.getFitOrderNo());
    	flightOrder.setUuid(orderMainDto.getUuid());
    	flightOrder.setFitFlightBookingType(orderMainDto.getFitFlightBookingType());
    	//乘机人信息列表
    	flightOrder.setFitOrderPassengers(orderMainDto.getFitOrderPassengers());
    	//机票航班信息列表
    	flightOrder.setFitOrderFlightDtos(orderMainDto.getFitOrderFlightDtos());
    	//订单关联关系.
    	FitSuppMainOrderDto   suppMainOrderDto = orderMainDto.getFitSuppMainOrderDto();
    	
    	List<FitSuppOrderDto> suppOrderDtos = suppMainOrderDto.getFitSuppOrderDtos();
    	
    	List<FitSuppOrderDto> ansOrderDtos = new ArrayList<FitSuppOrderDto>();
    	//根据vst子单进行筛选
    	if(vstOrderNo!=null&&suppOrderDtos!=null&&suppOrderDtos.size()>0){
    		for(FitSuppOrderDto dto:suppOrderDtos){
    			if(vstOrderNo.equals(dto.getVstOrderNo())){
    				ansOrderDtos.add(dto);
    			}
    		}
    		suppMainOrderDto.setFitSuppOrderDtos(ansOrderDtos);
    	}
    	 
    	flightOrder.setFitSuppMainOrderDto(orderMainDto.getFitSuppMainOrderDto());
    	return flightOrder;
    }

	@Override
	public List<String> queryFlightOrderByVstOrderMainNo(FitFlightOrderQueryRequest request) {

		String vstOrderMainNo = request.getVstMainOrderId()==null?null:request.getVstMainOrderId().toString();
		String vstOrderNo = request.getVstFlightOrderId()==null?null:request.getVstFlightOrderId().toString();
		List<String> callRequestStrs = fitSuppOrderForFlightCallBackRepository.loadCallRequestStrByVstNo(vstOrderMainNo,vstOrderNo);
		List<String> results = new ArrayList<String>();
		if(callRequestStrs!=null&&callRequestStrs.size()>0){
			for(String str:callRequestStrs){
				try {
					results.add(ZipUnZipUtils.getInstance().unzipBase642String(str));
				} catch (Exception e) {  
					logger.error("解压缩失败",e);
					results.add(str); 
				}
			}
		}  
        return results;
	}
}
