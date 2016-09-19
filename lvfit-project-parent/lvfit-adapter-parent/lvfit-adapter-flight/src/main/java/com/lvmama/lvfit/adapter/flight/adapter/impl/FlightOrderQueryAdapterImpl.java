package com.lvmama.lvfit.adapter.flight.adapter.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lvmama.lvf.common.client.BusinessClient;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.enums.FlightTripType;
import com.lvmama.lvf.common.dto.order.FlightOrderAmountDto;
import com.lvmama.lvf.common.dto.order.FlightOrderDetailDto;
import com.lvmama.lvf.common.dto.order.FlightOrderInsuranceDto;
import com.lvmama.lvf.common.dto.order.FlightOrderPassengerDto;
import com.lvmama.lvf.common.dto.order.FlightOrderSalesOrderRelationDto;
import com.lvmama.lvf.common.dto.order.FlightOrderTicketInfoDto;
import com.lvmama.lvf.common.dto.order.result.detail.FlightOrderDetailInfoDto;
import com.lvmama.lvf.common.dto.order.result.detail.FlightOrderDetailViewDto;
import com.lvmama.lvf.common.utils.CustomizedPropertyPlaceholderConfigurer;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.adapter.flight.adapter.FlightOrderQueryAdapter;
import com.lvmama.lvfit.common.dto.adapter.request.FlightOrderQueryRequest;
import com.lvmama.lvfit.common.dto.enums.BizEnum;
import com.lvmama.lvfit.common.dto.enums.PassengerType;
import com.lvmama.lvfit.common.dto.order.FitOrderAmountDto;
import com.lvmama.lvfit.common.dto.order.FitSuppFlightOrderDetailDto;
import com.lvmama.lvfit.common.dto.order.FitSuppFlightOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderDto;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderTicketInfoDto;
import com.lvmama.lvfit.common.dto.search.flight.result.CharterFlightFilterUtil;
import com.lvmama.lvfit.common.dto.status.order.OrderBookingStatus;

/**
 * 机票单品订单查询
 * @author qihuisong
 */
@Service
public class FlightOrderQueryAdapterImpl implements FlightOrderQueryAdapter{

    private static final Logger logger = LoggerFactory.getLogger(FlightOrderQueryAdapterImpl.class);

    @Autowired
    private BusinessClient businessClient;

    @Value("queryCharsetFlight")
	private String queryCharsetFlight;

	public Boolean getQueryCharsetFlight() {
		return Boolean.valueOf(
			 CustomizedPropertyPlaceholderConfigurer.getContextProperty(queryCharsetFlight)+"");
	}
	
    /**
     * 判断是不是包机的请求信息.
     * @param queryRequest
     * @return
     */
    private boolean isCharterFlight(FlightOrderQueryRequest queryRequest){
    	FitSuppMainOrderDto suppMainOrderDto = queryRequest.getFitSuppMainOrderDto();
    	//如果打开了包机查询的开关，就进行下面的逻辑判断。否则就默认不是包机查询的代码.
    	if(getQueryCharsetFlight()){
	    	//判断主单里面的航班子单中是否有订单信息
	    	if(CollectionUtils.isEmpty(suppMainOrderDto.getFitSuppOrderDtos().get(0).getSuppFlightOrderDtos())){
	    		return true;
	    	}
    	}
    	return false;
    }
    
    @Override
    public FitSuppMainOrderDto completeSuppFlightInfo(FlightOrderQueryRequest queryRequest) {

        FitSuppMainOrderDto suppMainOrderDto = queryRequest.getFitSuppMainOrderDto();
        List<FlightOrderInsuranceDto> flightInsDtos = new ArrayList<FlightOrderInsuranceDto>();
        try {
            logger.info("查询机票单品请求参数：getQueryCharsetFlight==" + getQueryCharsetFlight());
            Map<String,String> tickeNoMap = new HashMap<String, String>();
            List<FitSuppFlightOrderDetailDto> suppFlightOrderDetailDtos = new ArrayList<FitSuppFlightOrderDetailDto>();
            if(!isCharterFlight(queryRequest)){
            	//以前默认的情况.
	            //获取乘客key对应的票号信息
	            for (FitSuppOrderDto suppOrder : suppMainOrderDto.getFitSuppOrderDtos()) {
	            	if (0 == BizEnum.BIZ_CATEGORY_TYPE.category_traffic_aero_other.getCategoryId().compareTo(suppOrder.getCategoryId())){
	            		//1. 获取乘客key对应的票号信息
	            		FlightOrderSalesOrderRelationDto salesOrderRelation = new FlightOrderSalesOrderRelationDto();
	                    salesOrderRelation.setSalesMainOrderId(Long.valueOf(suppMainOrderDto.getVstMainOrderNo()));
	                    salesOrderRelation.setSalesOrderId(Long.valueOf(suppOrder.getVstOrderNo()));
	                    logger.info("查询机票关联关系：salesOrderRelation=" + JSONMapper.getInstance().writeValueAsString(salesOrderRelation));
	                    //根据主单号，子单号，查询对应的“航班订单详情视图对象信息”.
	                    BaseResultDto<FlightOrderDetailViewDto> lvfResultDto = businessClient.queryDetailViewListBySalesOrderRelation(salesOrderRelation);
	                       
	                    for (FlightOrderDetailViewDto viewDto : lvfResultDto.getResults()) {
	                    	//找到当前用户类型对应的子单.
	                	    FitSuppFlightOrderDto suppFlightOrderDto = suppOrder.getByPassengerType(PassengerType.valueOf(
	                	    viewDto.getFlightOrderDetailInfo().getFlightOrderDetails().get(0).getFlightOrderPassenger().getPassengerType().name()));
	                	    suppFlightOrderDto.setFlightOrderNo(viewDto.getFlightOrderDetailInfo().getOrderNo());
	                	    suppFlightOrderDto.setBookingStatus(OrderBookingStatus.valueOf(viewDto.getFlightOrderDetailInfo().getFlightOrderDetails().get(0).getDetailBookingStatus().name()));
	                	    suppFlightOrderDto.setOrderAmount(this.getFitOrderAmount(viewDto.getFlightOrderDetailInfo().getFlightOrderAmount()));
	                        
	                	    //设置航意险列表
	                	    for (FlightOrderDetailDto flightOrderDetail : viewDto.getFlightOrderDetailInfo().getFlightOrderDetails()) {
	                            FlightOrderTicketInfoDto flightTicket = flightOrderDetail.getFlightOrderTicketInfo();
	                            if(null != flightTicket && StringUtils.isNotBlank(flightTicket.getTicketNo())){
	                        	    tickeNoMap.put(this.passengerKey(flightOrderDetail.getFlightOrderPassenger(),flightOrderDetail.getCombinationDetail().getFlightTripType()), flightTicket.getTicketNo());
	                            }
	                            // 取得保险保单号信息
	                            FlightOrderPassengerDto passenger = flightOrderDetail.getFlightOrderPassenger();
	                            flightInsDtos.addAll(passenger.getFlightOrderInsurances());
	                        }
	                    }
	                    
	                    //2.  获取供应商订单航班信息详情信息
	                    List<FitSuppFlightOrderDto> suppFlightOrderDtos = suppOrder.getSuppFlightOrderDtos();
	                    for (FitSuppFlightOrderDto suppFlightOrderDto : suppFlightOrderDtos) {
	                        if(CollectionUtils.isNotEmpty(suppFlightOrderDto.getSuppFlightOrderDetailDtos())){
	                            for (FitSuppFlightOrderDetailDto suppFlightOrderDetailDto : suppFlightOrderDto.getSuppFlightOrderDetailDtos()) {
	                                suppFlightOrderDetailDto.setTripType(suppFlightOrderDto.getTripType());
								}
	                    		suppFlightOrderDetailDtos.addAll(suppFlightOrderDto.getSuppFlightOrderDetailDtos());
	                    	}	
						}
	                    
	            	}
	            }
	            
	            //补全供应商订单航班信息详情信息中的票号信息
	            for (FitSuppFlightOrderDetailDto suppFlightOrderDetailDto : suppFlightOrderDetailDtos) {
	            	FitSuppOrderTicketInfoDto suppOrderTicketInfoDto = new FitSuppOrderTicketInfoDto(); 
	            	String passengerKey = suppFlightOrderDetailDto.getFitOrderPassenger().passengerKey(suppFlightOrderDetailDto.getTripType());
	            	suppOrderTicketInfoDto.setTicketNo(tickeNoMap.get(passengerKey));
	            	suppFlightOrderDetailDto.setFitSuppOrderTicketInfoDto(suppOrderTicketInfoDto);
				}
            }
            //包机的处理方式，补全订单.
            else{
            	List<FitSuppFlightOrderDto> suppFlightOrderDtos = new ArrayList<FitSuppFlightOrderDto>();
            	 
            	//循环主单对应的子单.
	            for (FitSuppOrderDto suppOrder : suppMainOrderDto.getFitSuppOrderDtos()) {
	            	if (0 == BizEnum.BIZ_CATEGORY_TYPE.category_traffic_aero_other.getCategoryId().compareTo(suppOrder.getCategoryId())){
	            		//1. 获取乘客key对应的票号信息
	            		FlightOrderSalesOrderRelationDto salesOrderRelation = new FlightOrderSalesOrderRelationDto();
	                    salesOrderRelation.setSalesMainOrderId(Long.valueOf(suppMainOrderDto.getVstMainOrderNo()));
//	                    salesOrderRelation.setSalesOrderId(Long.valueOf(suppOrder.getVstOrderNo()));
	                    logger.info("包机。。查询机票关联关系：salesOrderRelation=" + JSONMapper.getInstance().writeValueAsString(salesOrderRelation));
	                    BaseResultDto<FlightOrderDetailViewDto> lvfResultDto = businessClient.queryDetailViewListBySalesOrderRelation(salesOrderRelation);
	                       
	                    for (FlightOrderDetailViewDto viewDto : lvfResultDto.getResults()) {
	                    	FlightOrderDetailInfoDto detailInfoDto = viewDto.getFlightOrderDetailInfo();
	                    	//直接设置机票子单对象，就设置在去程上面看下.返程的先不设置。
	                    	FitSuppFlightOrderDto suppFlightOrderDto = new FitSuppFlightOrderDto();
	                    	suppFlightOrderDto.setSuppMainOrderId(suppMainOrderDto.getVstMainOrderNo());
	                    	suppFlightOrderDto.setSuppOrderId(Long.valueOf(suppOrder.getVstOrderNo()));
	                    	suppFlightOrderDto.setTripType(com.lvmama.lvfit.common.dto.enums.FlightTripType.DEPARTURE);
//	                    	FitSuppFlightOrderDto suppFlightOrderDto = suppOrder.getByPassengerType(PassengerType.valueOf(
//	                    			detailInfoDto.getFlightOrderDetails().get(0).getFlightOrderPassenger().getPassengerType().name()));
	                    	//机票订单号
	                	    suppFlightOrderDto.setFlightOrderNo(detailInfoDto.getOrderNo());
	                	    //订单支付状态
	                	    suppFlightOrderDto.setBookingStatus(OrderBookingStatus.valueOf(detailInfoDto.getFlightOrderDetails().get(0).getDetailBookingStatus().name()));
	                	    //计算订单的金额
	                	    suppFlightOrderDto.setOrderAmount(this.getFitOrderAmount(detailInfoDto.getFlightOrderAmount()));
	                	    //设置航意险.
	                        for (FlightOrderDetailDto flightOrderDetail : detailInfoDto.getFlightOrderDetails()) {
	                        	//机票的出票信息.
	                            FlightOrderTicketInfoDto flightTicket = flightOrderDetail.getFlightOrderTicketInfo();
	                            if(null != flightTicket && StringUtils.isNotBlank(flightTicket.getTicketNo())){
	                        	    tickeNoMap.put(this.passengerKey(flightOrderDetail.getFlightOrderPassenger(),flightOrderDetail.getCombinationDetail().getFlightTripType()), flightTicket.getTicketNo());
	                            }
	                            // 取得保险保单号信息
	                            FlightOrderPassengerDto passenger = flightOrderDetail.getFlightOrderPassenger();
	                            flightInsDtos.addAll(passenger.getFlightOrderInsurances());
	                        }
	                        
	                        suppFlightOrderDtos.add(suppFlightOrderDto);
	                    }
	                    
	                    
	                    //2.  获取供应商订单航班信息详情信息 
	                    for (FitSuppFlightOrderDto suppFlightOrderDto : suppFlightOrderDtos) {
	                        if(CollectionUtils.isNotEmpty(suppFlightOrderDto.getSuppFlightOrderDetailDtos())){
	                            for (FitSuppFlightOrderDetailDto suppFlightOrderDetailDto : suppFlightOrderDto.getSuppFlightOrderDetailDtos()) {
	                                suppFlightOrderDetailDto.setTripType(suppFlightOrderDto.getTripType());
								}
	                    		suppFlightOrderDetailDtos.addAll(suppFlightOrderDto.getSuppFlightOrderDetailDtos());
	                    	}	
						}
	                    
	                    break;//包机的话，只需要查询一次就可以了。
	            	}
	            }
	            
	          //补全供应商订单航班信息详情信息中的票号信息
	            for (FitSuppFlightOrderDetailDto suppFlightOrderDetailDto : suppFlightOrderDetailDtos) {
	            	FitSuppOrderTicketInfoDto suppOrderTicketInfoDto = new FitSuppOrderTicketInfoDto(); 
	            	String passengerKey = suppFlightOrderDetailDto.getFitOrderPassenger().passengerKey(suppFlightOrderDetailDto.getTripType());
	            	suppOrderTicketInfoDto.setTicketNo(tickeNoMap.get(passengerKey));
	            	suppFlightOrderDetailDto.setFitSuppOrderTicketInfoDto(suppOrderTicketInfoDto);
				}
	            
	            //设置包机的航班信息.一对多。一个主单对应多个机票子单.
	            suppMainOrderDto.setSuppFlightOrderDtos(suppFlightOrderDtos);
            }
        } catch (Exception e) {
            logger.error("查询机票单品详情异常：", e);
        }
       
        suppMainOrderDto.setFlightInsDtos(flightInsDtos);
        return suppMainOrderDto;
    }
    
    /**
	 * 获取乘机人key
	 * @param flightOrderPassengerDto
	 * @return
	 */
	public String passengerKey(FlightOrderPassengerDto flightOrderPassengerDto,FlightTripType flightTripType){
		  StringBuffer passengerStr = new StringBuffer();
    	  passengerStr.append(flightOrderPassengerDto.getPassengerName());
    	  passengerStr.append(flightOrderPassengerDto.getPassengerType().name());
    	  passengerStr.append(flightOrderPassengerDto.getPassengerIDCardType().name());
    	  passengerStr.append(flightOrderPassengerDto.getPassengerIDCardNo());
    	  passengerStr.append(flightTripType.name());
          return passengerStr.toString();
	}
	
	/**
	 * 订单金额转换
	 * @param flightOrderAmount
	 * @return
	 */
	private FitOrderAmountDto getFitOrderAmount(
			FlightOrderAmountDto flightOrderAmount) {
    	FitOrderAmountDto fitOrderAmount = new FitOrderAmountDto();
    	fitOrderAmount.setPayedAmount(flightOrderAmount.getOrderPayedAmount());
    	fitOrderAmount.setPrepaidAmount(flightOrderAmount.getOrderPrepaidAmount());
    	fitOrderAmount.setProfitAmount(flightOrderAmount.getOrderProfitAmount());
    	fitOrderAmount.setTotalAmount(flightOrderAmount.getOrderTotalAmount());
    	fitOrderAmount.setTotalDiscountAmount(flightOrderAmount.getOrderDiscountTotalAmount());
    	fitOrderAmount.setTotalSalesAmount(flightOrderAmount.getOrderTotalSalesAmount());
		return fitOrderAmount;
	}
    
}
