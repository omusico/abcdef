package com.lvmama.lvf.common.client;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.client.path.ReportClientPath;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.report.FinancialReportDto;
import com.lvmama.lvf.common.dto.report.RevenueReportDto;
import com.lvmama.lvf.common.dto.report.TicketRemindReportDto;
import com.lvmama.lvf.common.dto.request.FinancialReportRequest;
import com.lvmama.lvf.common.dto.request.FlightOrderSuppPaymentRequest;
import com.lvmama.lvf.common.dto.request.RevenueReportRequest;
import com.lvmama.lvf.common.dto.request.TicketRemindReportRequest;
import com.lvmama.lvf.common.dto.supp.FlightOrderSuppPaymentDto;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.form.md.FlightOrderSuppPaymentRequestForm;
import com.lvmama.lvf.common.utils.JSONMapper;

@Component
public class ReportClient {

    @Value("report.baseurl")
    private String baseUrl;

    @Autowired
    private RestClient restClient;

    public static final Logger logger = Logger.getLogger(ReportClient.class);
    
    
    public BaseResultDto<TicketRemindReportDto> queryTicketRemindReportList(
            BaseQueryDto<TicketRemindReportRequest> request) throws JsonParseException,
            JsonMappingException, IOException {
        ReportClientPath command = ReportClientPath.QUERY_TICKET_REMIND_REPORT;
        String url = command.url(baseUrl);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonRequest = objectMapper.writeValueAsString(request);
            String jsonResult = restClient.post(url, String.class, jsonRequest);
            return objectMapper.readValue(jsonResult,
                    new TypeReference<BaseResultDto<TicketRemindReportDto>>() {
                    });
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (Exception e) {
            ExceptionWrapper ew = new ExceptionWrapper();
            ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }

    /**
     * 查询营收报表
     * 
     * @param request
     * @return BaseResultDto<FlightOrderAuditOpDto>
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public BaseResultDto<RevenueReportDto> queryRevenueReportList(
            BaseQueryDto<RevenueReportRequest> request) throws JsonParseException,
            JsonMappingException, IOException {
        ReportClientPath command = ReportClientPath.QUERY_REVENUE_REPORT;
        String url = command.url(baseUrl);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonRequest = objectMapper.writeValueAsString(request);
            String jsonResult = restClient.post(url, String.class, jsonRequest);
            return objectMapper.readValue(jsonResult,
                    new TypeReference<BaseResultDto<RevenueReportDto>>() {
                    });
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (Exception e) {
            ExceptionWrapper ew = new ExceptionWrapper();
            ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
    
    /**
     * 导出营收报表
     * @param baseQueryDto
     * @return
     */
    public List<String> queryRevenueReportExport(
			BaseQueryDto<RevenueReportRequest> baseQueryDto) {
    	ReportClientPath command = ReportClientPath.QUERY_REVENUE_REPORT_LIST_OF_EXPORT;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<List<String>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    /**
     * 查询对账单报表
     */
    public BaseResultDto<FlightOrderSuppPaymentDto> queryFlightOrderInfo(
            BaseQueryDto<FlightOrderSuppPaymentRequest> baseQueryDto) throws JsonParseException,
            JsonMappingException, IOException {
    	ReportClientPath command = ReportClientPath.QUERY_SUPPPAYMENT_REPORT;
        String url = command.url(baseUrl);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
            String jsonResult = restClient.post(url, String.class, jsonRequest);
            return objectMapper.readValue(jsonResult,
                    new TypeReference<BaseResultDto<FlightOrderSuppPaymentDto>>() {
                    });
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (Exception e) {
            ExceptionWrapper ew = new ExceptionWrapper();
            ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
    /**
     * 批量导入对账单数据
     */
    public Boolean batchSaveSupPayment(FlightOrderSuppPaymentRequestForm requestform){
    	ReportClientPath command = ReportClientPath.SUPPAYMENT_BATCH_SAVE;
		String url = command.url(baseUrl);
		try {
			return restClient.post(url, Boolean.class,requestform);
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		}
    }
    
    
    /**
     * 财务对账报表
     * 
     * @param request
     * @return BaseResultDto<FinancialReportDto>
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public BaseResultDto<FinancialReportDto> queryFinancialReportList(
            BaseQueryDto<FinancialReportRequest> request) throws JsonParseException,
            JsonMappingException, IOException {
        ReportClientPath command = ReportClientPath.QUERY_FINANCIAL_REPORT;
        String url = command.url(baseUrl);
        try {
            ObjectMapper objectMapper = JSONMapper.getInstance();
            String jsonRequest = objectMapper.writeValueAsString(request);
            String jsonResult = restClient.post(url, String.class, jsonRequest);
            return objectMapper.readValue(jsonResult,
                    new TypeReference<BaseResultDto<FinancialReportDto>>() {
                    });
        } catch (ExceptionWrapper ew) {
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        } catch (Exception e) {
            ExceptionWrapper ew = new ExceptionWrapper();
            ew.setExceptionCode(ExceptionCode.REMOTE_INVOKE);
            ew.setErrMessage(ExceptionCode.REMOTE_INVOKE.errMessage(command.cnName, url) + ExceptionUtils.getFullStackTrace(e));
            logger.error(ew.getErrMessage(), ew);
            throw ew;
        }
    }
    
    
    /**
     * 导出财务对账报表
     * @param baseQueryDto
     * @return
     */
    public List<String> queryFinancialReportExport(
			BaseQueryDto<FinancialReportRequest> baseQueryDto) {
    	ReportClientPath command = ReportClientPath.QUERY_FINANCIAL_REPORT_LIST_OF_EXPORT;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonRequest = objectMapper.writeValueAsString(baseQueryDto);
			String jsonResult = restClient.post(url, String.class, jsonRequest);
			return objectMapper.readValue(jsonResult,
					new TypeReference<List<String>>() {
					});
		} catch (ExceptionWrapper ew) {
			logger.error(ew.getErrMessage(),ew);
			throw ew;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
