/**
 * Project Name:lvfit-common-dto
 * File Name:FitReportClient.java
 * Package Name:com.lvmama.lvfit.common.client
 * Date:2016-1-5下午3:32:32
 * Copyright (c) 2016, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.common.client;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.client.RestClient;
import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.path.ReportClientPath;
import com.lvmama.lvfit.common.dto.report.FitRevenueReportDto;
import com.lvmama.lvfit.common.dto.request.FitRevenueReportRequest;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingAmountDto;

/**
 * ClassName:FitReportClient <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2016-1-5 下午3:32:32 <br/>
 * @author   liuweiguo
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Component
public class FitReportClient {
    @Value("lvfit.report.baseurl")
    private String baseUrl;

    @Autowired
    private RestClient restClient;

    public static final Logger logger = Logger.getLogger(FitReportClient.class);
	/**
     * 查询营收报表
     * 
     * @param request
     * @return BaseResultDto<FlightOrderAuditOpDto>
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public BaseResultDto<FitRevenueReportDto> queryRevenueReport(
            BaseQueryDto<FitRevenueReportRequest> request) throws JsonParseException,
            JsonMappingException, IOException {
        ReportClientPath command = ReportClientPath.QUERY_REVENUE_REPORT;
        String url = command.url(baseUrl);
        try {
			String result = restClient.post(url, String.class, request);
			if (StringUtils.isNotBlank(result)) {
				ObjectMapper objectMapper = JSONMapper.getInstance();
				BaseResultDto<FitRevenueReportDto> dto = objectMapper.readValue(result, new TypeReference<BaseResultDto<FitRevenueReportDto>>() {
				});
				return dto;
			}
			return null;
		} catch (ExceptionWrapper ew) {
			throw ew;
		}
    }
    
    /**
     * 导出营收报表
     * @param query
     * @return
     */
    public List<String> queryRevenueReportForExport(
			BaseQueryDto<FitRevenueReportRequest> query) {
    	ReportClientPath command = ReportClientPath.QUERY_REVENUE_REPORT_FOR_EXPORT;
		String url = command.url(baseUrl);
		try {
			ObjectMapper objectMapper = JSONMapper.getInstance();
			String jsonResult = restClient.post(url, String.class, query);
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

