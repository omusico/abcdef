package com.lvmama.lvfit.business.service.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.request.FlightOrderBookingRequest;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.business.order.service.OrderQueryService;
import com.lvmama.lvfit.common.client.path.BussinessClientPath;
import com.lvmama.lvfit.common.client.path.ReportClientPath;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;
import com.lvmama.lvfit.common.dto.order.FitOrderQueryListDto;
import com.lvmama.lvfit.common.dto.order.FitSuppMainOrderDto;
import com.lvmama.lvfit.common.dto.request.FitFlightOrderQueryRequest;
import com.lvmama.lvfit.common.dto.request.FitOrderQueryRequest;
import com.lvmama.lvfit.common.form.order.FitOrderOpLogForm;

@Component
@Path("")
public class FitOrderQueryResource {
	private static Logger logger = LoggerFactory.getLogger(FitOrderQueryResource.class);

	@Autowired
	private OrderQueryService orderQueryService;
	
	/**
	 *  后台 订单查询 列表 
	 * @author wanghuihui
	 * @date:2016年1月5日 下午10:24:25
	 * @param fitOrderBookingRequest
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.BACK_ORDER_QUERY_LIST)
	public Response orderQueryList(String jsonRequest) {
		try
		{
			//1、获取订单列表查询对象
			ObjectMapper objectMapper = JSONMapper.getInstance();
			BaseQueryDto<FitOrderQueryRequest> baseQueryDto = objectMapper.readValue(jsonRequest, 
					new TypeReference<BaseQueryDto<FitOrderQueryRequest>>(){});
			
			//2、查询订单列表、记录总数 BaseResultDto<FitOrderQueryListDto>
			List<FitOrderQueryListDto> flightOrderListResultDtos = orderQueryService.queryOrderList(baseQueryDto);
			int records = orderQueryService.countOrderListRecords(baseQueryDto);
			
			//3、构造订单列表查询结果对象
			Pagination pagination = baseQueryDto.getPagination();
			pagination.setRecords(records);
			pagination.countRecords(records);
			BaseResultDto<FitOrderQueryListDto> baseResultDto = new BaseResultDto<FitOrderQueryListDto>
				(pagination, flightOrderListResultDtos);
			String jsonResult = objectMapper.writeValueAsString(baseResultDto); 
			return Response.ok(jsonResult).build();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *   后台  订单详情
	 * @author wanghuihui
	 * @date:2016年1月5日 下午10:24:28
	 * @param fitOrderBookingRequest
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.QUERY_ORDER_MAIN_BY_VST_ORDER_MAIN_NO)
	public Response queryOrderMainByVstOrderMainNo(@PathParam("vstOrderMainNo")Long vstOrderMainNo) {
		FitOrderMainDto mainDto = null;
        try {
        	mainDto = orderQueryService.queryOrderMainByVstOrderMainNo(vstOrderMainNo);
        } catch (Exception e) {
            logger.error("查询订单详情出错：", e);
        }
        if (mainDto == null) {
            mainDto = new FitOrderMainDto();
        }
        return Response.ok(mainDto).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.QUERY_ORDER_FLIGHT_ORDER_BY_VST_ORDER_MAIN_NO)
	public Response queryFlightOrderInfoByVstOrderMainNo(FitFlightOrderQueryRequest fitFlightOrderQueryRequest) {
		List<FlightOrderBookingRequest> result = new ArrayList<FlightOrderBookingRequest>();
		List<String> flightOrderBookingRequests = new ArrayList<String>();
        try {
			flightOrderBookingRequests = orderQueryService.queryFlightOrderByVstOrderMainNo(fitFlightOrderQueryRequest);
			if(flightOrderBookingRequests!=null&&flightOrderBookingRequests.size()>0){
				for(String str:flightOrderBookingRequests){
					FlightOrderBookingRequest req = JSONMapper.getInstance().readValue(str,FlightOrderBookingRequest.class);
					result.add(req);
				}
			}
			
        } catch (Exception e) {
			logger.error("查询订单详情出错：", e);
		}
        return Response.ok(result).build();
	}
	
	/**
	 *   后台  日志列表
	 * @author wanghuihui
	 * @date:2016年1月5日 下午10:24:28
	 * @param fitOrderBookingRequest
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(BussinessClientPath.Path.BACK_ORDER_QUERY_LOG_LIST)
	public Response orderLogQuery(FitOrderQueryRequest fitOrderQueryRequest) {
		try
		{
			//1、获取订单日志列表查询对象
			ObjectMapper objectMapper = JSONMapper.getInstance();
			
			//2、查询订单日志列表、记录总数 BaseResultDto<FitOrderQueryListDto>
			List<FitOrderOpLogForm> flightOrderListResultDtos = orderQueryService.queryOrderLogList(fitOrderQueryRequest);
			int records = orderQueryService.countOrderLogListRecords(fitOrderQueryRequest);
			
			//3、构造订单日志列表查询结果对象
			Pagination pagination = fitOrderQueryRequest.getPagination();
			pagination.setRecords(records);
			pagination.countRecords(records);
			BaseResultDto<FitOrderOpLogForm> baseResultDto = new BaseResultDto<FitOrderOpLogForm>
				(pagination, flightOrderListResultDtos);
			String jsonResult = objectMapper.writeValueAsString(baseResultDto); 
			return Response.ok(jsonResult).build();
			
		}
		catch(Exception e)
		{
			logger.error("后台  日志列表出错：", e);
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询 机酒订单 列表(导出)
	 * @param jsonRequest
	 * @return
	 * @throws Exception 
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(ReportClientPath.Path.QUERY_ORDER_ALL_REPORT)
	public Response queryOrderAllReport(BaseQueryDto<FitOrderQueryRequest> baseQueryDto) throws Exception
	{
		try{
			//1、获取订单列表查询对象
			ObjectMapper objectMapper = JSONMapper.getInstance();
			//2、查询列表
			List<String> flightOrderListResultDtos = orderQueryService.queryOrderAllReport(baseQueryDto);
			String jsonResult = objectMapper.writeValueAsString(flightOrderListResultDtos); 
			return Response.ok(jsonResult).build();
		} catch(Exception e)	 {
			logger.error("查询 机酒订单 列表(导出)出错：", e);
			throw e;
		}
	}
	/**
	 * 查询 机票订单 列表(导出)
	 * @param jsonRequest
	 * @return
	 * @throws Exception 
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(ReportClientPath.Path.QUERY_ORDER_FLIGHT_REPORT)
	public Response queryOrderFightReport(BaseQueryDto<FitOrderQueryRequest> baseQueryDto) throws Exception
	{
		try
		{
			//1、获取订单列表查询对象
			ObjectMapper objectMapper = JSONMapper.getInstance();
			//2、查询列表
			List<String> flightOrderListResultDtos = orderQueryService.queryOrderFlightReport(baseQueryDto);
			String jsonResult = objectMapper.writeValueAsString(flightOrderListResultDtos); 
			return Response.ok(jsonResult).build();
		}
		catch(Exception e)
		{
			logger.error("查询 机票订单 列表(导出)出错：", e);
			throw e;
		}
	}
	/**
	 * 查询 酒店订单 列表(导出)
	 * @param jsonRequest
	 * @return
	 * @throws Exception 
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path(ReportClientPath.Path.QUERY_ORDER_HOTEL_REPORT)
	public Response queryOrderHotelReport(BaseQueryDto<FitOrderQueryRequest> baseQueryDto) throws Exception
	{
		try{
			//1、获取订单列表查询对象
			ObjectMapper objectMapper = JSONMapper.getInstance();
			//2、查询列表
			List<String> flightOrderListResultDtos = orderQueryService.queryOrderHotelReport(baseQueryDto);
			String jsonResult = objectMapper.writeValueAsString(flightOrderListResultDtos); 
			return Response.ok(jsonResult).build();
		}catch(Exception e){
			logger.error("查询 酒店订单 列表(导出)出错：", e);
			throw e;
		}
	}
	
	@POST
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(BussinessClientPath.Path.OLD_ORDER_DATA_TRANSFER)
    public void getMainOrder4VSTByOrderMainNo() {
        List<FitSuppMainOrderDto> fitSuppMainOrderDtos = orderQueryService.getOldOrderMainData();
        for (FitSuppMainOrderDto suppMainOrderDto : fitSuppMainOrderDtos) {
            Long vstOrderMainNo = suppMainOrderDto.getVstMainOrderNo();
            try {
                orderQueryService.getMainOrder4VSTByOrderMainNo(vstOrderMainNo);
            } catch (Exception e) {
                
            }
        }
    }
	
	@POST
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(BussinessClientPath.Path.OLD_SINGLE_ORDER_DATA_TRANSFER)
    public Response getMainOrder4VSTByOrderMainNo1(@PathParam("vstOrderMainNo")Long vstOrderMainNo) {
        orderQueryService.getMainOrder4VSTByOrderMainNo(vstOrderMainNo);
        return Response.ok().build();
    }
}
