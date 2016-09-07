package com.lvmama.lvfit.dp.service.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.trace.TraceContext;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.path.DpClientPath;
import com.lvmama.lvfit.common.dto.enums.FitBusinessExceptionType;
import com.lvmama.lvfit.common.dto.search.FitRecordSearchIndex;
import com.lvmama.lvfit.common.dto.search.FitSearchRequest;
import com.lvmama.lvfit.common.dto.search.flight.FlightSearchResult;
import com.lvmama.lvfit.common.dto.search.flight.result.FlightSearchFlightInfoDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.dto.trace.FitOpLogTraceContext;
import com.lvmama.lvfit.dp.service.FitDpService;
import com.lvmama.lvfit.solrClient.extend.FitMainSearchSolrClient;
/**
 * 机票及酒店搜索 yueyufan
 * 
 * @date 2015-11-26
 */

@Component
@Path("")
public class FlightHotelResultResource {
    
    private static Logger logger = LoggerFactory.getLogger(FlightHotelResultResource.class);

    @Autowired
    FitDpService fitDpService;
    
    @Autowired
    FitMainSearchSolrClient fitMainSearchSolrClient;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path(DpClientPath.Path.GET_FLIGHT_AND_HOTEL)
    public Response searchFlightAndHotel(FitSearchRequest fitSearchRequest) {
        String uuid = fitDpService.search(fitSearchRequest);
        return Response.ok(uuid).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("tempTest")
    public Response tempTest(String requestString) {
    	FlightSearchResult<FlightSearchFlightInfoDto> searchResult = new FlightSearchResult<FlightSearchFlightInfoDto>();
		try {
			searchResult = JSONMapper.getInstance().readValue(requestString, new TypeReference<FlightSearchResult<FlightSearchFlightInfoDto>>() {
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	FlightSearchResult<FlightSearchFlightInfoDto> searchResults= fitDpService.handleFlights(searchResult);
        return Response.ok(searchResults).build();
    }
    
    
    /**
	  * 用于获取产品选择页默认加载的信息
	  * 
	  * */
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 @Path(DpClientPath.Path.GET_SHOPPING_RESULT)
	public Response searchShoppingResult(FitSearchRequest fitSearchRequest){
	     long start = System.currentTimeMillis();
	     String errMsg = "";
	     ResultStatus result = ResultStatus.SUCCESS;
	     FitShoppingDto shoppingDto = new FitShoppingDto();
	     try {
	         shoppingDto = fitDpService.getShoppingResult(fitSearchRequest);
	         // 处理查询过程中的异常信息，记录在errmsg中，抛出机票相关异常，其他异常不抛出
	         List<ExceptionWrapper> ewList = FitOpLogTraceContext.getExThreadLocal();
	         if (ewList != null) {
	             result = ResultStatus.FAIL;
	             errMsg = "";
                 for (ExceptionWrapper ew : ewList) {
                     errMsg += StringUtils.isNotBlank(ew.getOriginErrMsg()) ? ew.getOriginErrMsg() : ew.getErrMessage();
                     errMsg += "~~~";
                 }
                 for (ExceptionWrapper ew : ewList) {
                     if (ew.getExceptionCode()==ExceptionCode.GET_NO_RESULT) {
                         throw new ExceptionWrapper(errMsg, ExceptionCode.GET_NO_RESULT);
                     }
                 }
	         }
	     } catch (Exception e) {
	         FitOpLogTraceContext.setFitOpLog(fitSearchRequest,e, TraceContext.getTraceId(), FitBusinessExceptionType.FIT_Q_E);
	         logger.error(ExceptionUtils.getStackTrace(e));
	    	 result = ResultStatus.FAIL;
	    	 if(e instanceof ExceptionWrapper){
	    		 ExceptionWrapper ew = (ExceptionWrapper)e;
	    		 errMsg = StringUtils.isNotBlank(ew.getOriginErrMsg()) ? ew.getOriginErrMsg() : ew.getErrMessage();
	             throw ew;
	    	 }else{
	    	     errMsg = ExceptionUtils.getStackTrace(e);
	    		 throw new RuntimeException(e);
	    	 }
	     } finally {
	         List<FitRecordSearchIndex> indexs = this.genFitRecordSearchIndex(fitSearchRequest, start, errMsg, result);
	         try {
                fitMainSearchSolrClient.add(indexs, FitRecordSearchIndex.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
	         FitOpLogTraceContext.clearExThreadLocal();
	     }
	     return Response.ok(shoppingDto).build();
	}

    private List<FitRecordSearchIndex> genFitRecordSearchIndex(FitSearchRequest fitSearchRequest, long start, String errMsg, ResultStatus result) {
         long end = System.currentTimeMillis();
         long usedTime = end-start;
         FitRecordSearchIndex recordIndex = new FitRecordSearchIndex();
         recordIndex.setQueryDate(DateUtils.formatDate(new Date()));
         recordIndex.setQueryTime(System.currentTimeMillis());
         recordIndex.setDepartureCityCode(fitSearchRequest.getFlightSearchRequests().get(0).getDepartureCityCode());
         recordIndex.setArrivalCityCode(fitSearchRequest.getFlightSearchRequests().get(0).getArrivalCityCode());
         Date depDate = fitSearchRequest.getFlightSearchRequests().get(0).getDepartureDate();
         recordIndex.setDepartureDate(DateUtils.formatDate(depDate));
         recordIndex.setReturnDate(fitSearchRequest.getFlightSearchRequests().get(0).getReturnDate());
         recordIndex.setStayCityCode(fitSearchRequest.getHotelSearchRequests().get(0).getCityCode());
         recordIndex.setCheckInDate(fitSearchRequest.getHotelSearchRequests().get(0).getDepartureDate());
         recordIndex.setCheckOutDate(fitSearchRequest.getHotelSearchRequests().get(0).getReturnDate());
         recordIndex.setIndexId(recordIndex.getDepartureCityCode()+ "_"+recordIndex.getArrivalCityCode()+ "_" + System.nanoTime());
         recordIndex.setAdultCount(fitSearchRequest.getFitPassengerRequest().getAdultCount());
         recordIndex.setChildrenCount(fitSearchRequest.getFitPassengerRequest().getChildCount());
         recordIndex.setResultStatus(result);
         recordIndex.setUsedTime(usedTime);
         recordIndex.setTraceId(TraceContext.getTraceId());
         if(StringUtils.isNotBlank(errMsg)){
          	  byte[] errMsgBytes = errMsg.getBytes();
                if (errMsgBytes.length > 2000) {
                    byte[] newBytes = Arrays.copyOfRange(errMsgBytes, 0, 2000);
                    errMsg = new String(newBytes);
                }
            }
         recordIndex.setErrMsg(errMsg);
         recordIndex.setIp(TraceContext.getIp());
         List<FitRecordSearchIndex> indexs = new ArrayList<FitRecordSearchIndex>();
         indexs.add(recordIndex);
         return indexs;
    }
}
