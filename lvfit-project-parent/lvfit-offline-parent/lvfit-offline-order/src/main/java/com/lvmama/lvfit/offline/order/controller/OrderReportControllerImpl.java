/**
 * Project Name:lvfit-offline-report
 * File Name:RevenueReportControllerImpl.java
 * Package Name:com.lvmama.lvfit.offline.report.controller
 * Date:2016-1-5下午9:33:22
 * Copyright (c) 2016, www.lvmama.com All Rights Reserved.
 *
*/

package com.lvmama.lvfit.offline.order.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.utils.csv.CsvUtils;
import com.lvmama.lvfit.common.client.FitBusinessClient;
import com.lvmama.lvfit.common.dto.request.FitOrderQueryRequest;
import com.lvmama.lvfit.common.utils.FitCsvConfig;
import com.lvmama.lvfit.offline.report.form.RevenueReportInputForm;
import com.lvmama.lvfit.offline.report.form.RevenueReportResultForm;

/**
 * 订单相关报表导出
 * @author wanghuihui
 * @date:2016年1月22日 上午11:43:11
 */
@Controller
@RequestMapping("order")
public class OrderReportControllerImpl implements OrderReportController<RevenueReportInputForm, BaseResponseDto<RevenueReportResultForm>>{
	@Autowired
	private FitBusinessClient fitBusinessClient;
	
    /**
     * 导出 机酒报表
     * @author wanghuihui
     * @date:2016年1月22日 上午11:44:16
     * @param input
     * @param response
     */
	@Override
    @RequestMapping(value = "orderAllExportCsv")
    public void orderAllExportCsv(FitOrderQueryRequest fitOrderQueryRequest, HttpServletResponse response) {
        /**
         * 设置request
         */
        Pagination pagination = new Pagination(1, 50000);
        BaseQueryDto<FitOrderQueryRequest> baseQueryDto = new BaseQueryDto<FitOrderQueryRequest>(pagination, fitOrderQueryRequest);
        baseQueryDto.setPagination(fitOrderQueryRequest.getPagination());
        baseQueryDto.setCondition(fitOrderQueryRequest);
        /**
         * 加载数据
         */
        List<String> revenueReportStrings = fitBusinessClient.queryOrderAllExportCsv(baseQueryDto);
        /**
         * 输出流
         */  
        CsvUtils.createCsvStream(FitCsvConfig.ORDER_ALL_REPORT_LIST, revenueReportStrings, response);
    }
    /**
     * 导出机票报表
     * @author wanghuihui
     * @date:2016年1月22日 上午11:44:48
     * @param input
     * @param response
     */
    @RequestMapping(value = "orderFlightExportCsv")
    public void orderFlightExportCsv(FitOrderQueryRequest fitOrderQueryRequest, HttpServletResponse response) {
    	/**
         * 设置request
         */
        Pagination pagination = new Pagination(1, 50000);
        BaseQueryDto<FitOrderQueryRequest> baseQueryDto = new BaseQueryDto<FitOrderQueryRequest>(pagination, fitOrderQueryRequest);
        baseQueryDto.setPagination(fitOrderQueryRequest.getPagination());
        baseQueryDto.setCondition(fitOrderQueryRequest);
        /**
         * 加载数据
         */
        List<String> revenueReportStrings = fitBusinessClient.orderFlightExportCsv(baseQueryDto);
    	/**
    	 * 输出流
    	 */
    	CsvUtils.createCsvStream(FitCsvConfig.ORDER_FLIGHT_REPORT_LIST, revenueReportStrings, response);
    }
    /**
     * 导出酒店报表
     * @author wanghuihui
     * @date:2016年1月22日 上午11:45:05
     * @param input
     * @param response
     */
    @RequestMapping(value = "orderHotelExportCsv")
    public void orderHotelExportCsv(FitOrderQueryRequest fitOrderQueryRequest, HttpServletResponse response) {
    	 /**
         * 设置request
         */
        Pagination pagination = new Pagination(1, 50000);
        BaseQueryDto<FitOrderQueryRequest> baseQueryDto = new BaseQueryDto<FitOrderQueryRequest>(pagination, fitOrderQueryRequest);
        baseQueryDto.setPagination(fitOrderQueryRequest.getPagination());
        baseQueryDto.setCondition(fitOrderQueryRequest);
        /**
         * 加载数据
         */
        List<String> revenueReportStrings = fitBusinessClient.orderHotelExportCsv(baseQueryDto);
        /**
         * 输出流
         */  
        CsvUtils.createCsvStream(FitCsvConfig.ORDER_HOTEL_REPORT_LIST, revenueReportStrings, response);
    }

}

