package com.lvmama.lvfit.offline.sdpproduct.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.codehaus.jackson.type.JavaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvmama.lvf.common.dto.BaseQueryDto;
import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.Pagination;
import com.lvmama.lvf.common.dto.status.ResultStatus;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvf.common.utils.csv.CsvUtils;
import com.lvmama.lvfit.common.client.FitBatchClient;
import com.lvmama.lvfit.common.client.FitBusinessClient;
import com.lvmama.lvfit.common.client.FitVstServiceClient;
import com.lvmama.lvfit.common.dto.enums.BizEnum;
import com.lvmama.lvfit.common.dto.enums.BizEnum.BIZ_CATEGORY_TYPE;
import com.lvmama.lvfit.common.dto.enums.JudgeType;
import com.lvmama.lvfit.common.dto.enums.VSTDistrictCityEnum;
import com.lvmama.lvfit.common.dto.order.FitSuppOrderForFlightCallBackDto;
import com.lvmama.lvfit.common.dto.request.FitFliBookingCallBackRequest;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpCityGroupDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductBasicInfoDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductFeeRulesDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSearchIndexTraffic;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductSyncMsgDto;
import com.lvmama.lvfit.common.dto.sdp.product.FitSdpProductTrafficRulesDto;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductBasicInfoRequest;
import com.lvmama.lvfit.common.dto.sdp.product.request.FitSdpProductBasicInfoRequestForm;
import com.lvmama.lvfit.common.dto.vst.VstPushRecord;
import com.lvmama.lvfit.common.form.product.FitSdpCityGroupForm;
import com.lvmama.lvfit.common.form.product.FitSdpProductBasicInfoForm;
import com.lvmama.lvfit.common.form.product.FitSdpProductSearchIndexForm;
import com.lvmama.lvfit.common.form.product.FitSdpProductSearchIndexTrafficForm;
import com.lvmama.lvfit.common.form.product.FitSdpProductSyncMsgForm;
import com.lvmama.lvfit.common.form.product.FitSuppOrderForFlightCallBackForm;
import com.lvmama.lvfit.common.form.product.FitSuppOrderForFlightCallBackRequest;
import com.lvmama.lvfit.common.form.product.VstPushRecordForm;
import com.lvmama.lvfit.common.utils.FitCsvConfig;
import com.lvmama.lvfit.offline.sdpproduct.SdpProductController;

@Controller
public class SdpProductControllerImpl  implements SdpProductController{
	
	 private static final Logger logger = LoggerFactory.getLogger(SdpProductControllerImpl.class);

	@Autowired
	private FitBusinessClient fitBusinessClient;
	
	@Autowired
	private FitVstServiceClient fitVstServiceClient;
	
	@Autowired
	private FitBatchClient fitBatchClient;
	 
	@Override
	@RequestMapping(value = "sdpProduct/query", method = { RequestMethod.POST, RequestMethod.GET })
	public String showSdpProductList(Model model) {
		buildOrderModel(model);
		return "product/product_list";
	}
	@Override
	@RequestMapping(value = "sdpProduct/syncQuery", method = { RequestMethod.POST, RequestMethod.GET })
	public String showSdpProductSyncList(Model model) {
		buildOrderModel(model);
		return "product/product_syn_index_list";
	}
	
	@Override
	@RequestMapping(value = "sdpProduct/searchIndex", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchIdIndex(Model model,Long productId) {
		buildOrderModel(model);
		model.addAttribute("productId", productId);
		return "product/product_search_index";
	}
	
	@Override
	@RequestMapping(value = "sdpProduct/searchSynInfo", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchSynInfo(Model model,Long productId) {
		buildOrderModel(model);
		model.addAttribute("productId", productId);
		return "product/product_syn_msg_list";
	}
	
	@Override
	@RequestMapping(value = "sdpProduct/searchPushInfo", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchPushInfo(Model model,Long productId) {
		buildOrderModel(model);
		model.addAttribute("productId", productId);
		return "product/product_push_info_list";
	}
	
	@Override
	@RequestMapping(value = "sdpProduct/searchTrafficIndex", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchTrafficIndex(Model model,Long productId) {
		buildOrderModel(model);
		model.addAttribute("productId", productId);
		return "product/product_traffic_index_list";
	}
	
	@Override
	@RequestMapping(value = "sdpProduct/departureCity", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchDepartCity(Model model,Long productId) {
		buildOrderModel(model);
		model.addAttribute("productId", productId);
		model.addAttribute("cityGroup", VSTDistrictCityEnum.values());
		return "product/product_departure_city_list";
	}
	
	@Override
	@RequestMapping(value = "sdpProduct/suppCallBack", method = { RequestMethod.POST, RequestMethod.GET })
	public String suppFlightCallBack(Model model) {
		buildOrderModel(model);
		return "supp_flight_call_back";
	}
	
	private void buildOrderModel(Model model) {
		model.addAttribute("JudgeType", JudgeType.values());   //订单状态
		List<BIZ_CATEGORY_TYPE> categoryTypeList = new ArrayList<BIZ_CATEGORY_TYPE>();
		categoryTypeList.add(BizEnum.BIZ_CATEGORY_TYPE.category_route_group);
		categoryTypeList.add(BizEnum.BIZ_CATEGORY_TYPE.category_route_freedom);

		model.addAttribute("BIZ_CATEGORY_TYPE",categoryTypeList);
	}

	@ResponseBody
	@RequestMapping(value = "sdpProduct/querySearchIndexList", method = { RequestMethod.POST, RequestMethod.GET })
	public BaseResultDto<FitSdpProductSearchIndexForm> querySdpProductList(Model model, Long productId,Pagination pg) {
		BaseResultDto<FitSdpProductSearchIndexForm> result = new BaseResultDto<FitSdpProductSearchIndexForm>();
		try {
			if(productId!=null){
				BaseQueryDto<Long> baseQuery = new BaseQueryDto<Long>();
				baseQuery.setPagination(pg);
				baseQuery.setCondition(productId);
				BaseResultDto<FitSdpProductSearchIndexDto> searchIndexDtos = fitBusinessClient.querySdpProductSearchIndexList(baseQuery);
				List<FitSdpProductSearchIndexDto> dtoList = searchIndexDtos.getResults();
				List<FitSdpProductSearchIndexForm> resultForm = new ArrayList<FitSdpProductSearchIndexForm>();
				for(int i=0;i<dtoList.size();i++){
					FitSdpProductSearchIndexForm elementForm = new FitSdpProductSearchIndexForm();
					elementForm.setFitSdpProductSearchIndexDto(dtoList.get(i));
					resultForm.add(elementForm);
				}
				result.setResults(resultForm);
				result.setPagination(searchIndexDtos.getPagination());
				return result;
			}
		} catch (Exception e) {
			logger.error("查询产品Id索引失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/queryAllSynInfo", method = { RequestMethod.POST, RequestMethod.GET })
	public BaseResultDto<FitSdpProductSyncMsgDto> queryAllSynInfo(Model model,Pagination pg,FitSdpProductSyncMsgDto syncMsgDto) {
		BaseResultDto<FitSdpProductSyncMsgDto> result = new BaseResultDto<FitSdpProductSyncMsgDto>();
		try {
				BaseQueryDto<FitSdpProductSyncMsgDto> baseQuery = new BaseQueryDto<FitSdpProductSyncMsgDto>();
				baseQuery.setCondition(syncMsgDto);
				baseQuery.setPagination(pg);
				result = fitBusinessClient.querySdpProductSynMsgInfo(baseQuery);
				return result;
		} catch (Exception e) {
			logger.error("查询产品同步信息失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/queryTrafficIndexList", method = { RequestMethod.POST, RequestMethod.GET })
	public BaseResultDto<FitSdpProductSearchIndexTrafficForm> queryTrafficIndexList(Model model,Long productId,Pagination pg) {
		BaseResultDto<FitSdpProductSearchIndexTrafficForm> result = new BaseResultDto<FitSdpProductSearchIndexTrafficForm>();
		try {
			if(productId!=null){
				BaseQueryDto<Long> baseQuery = new BaseQueryDto<Long>();
				baseQuery.setPagination(pg);
				baseQuery.setCondition(productId);
				BaseResultDto<FitSdpProductSearchIndexTraffic> dtos = fitBusinessClient.querySdpProductIndexTrafficList(baseQuery);
				List<FitSdpProductSearchIndexTraffic> dtoList = dtos.getResults();
				List<FitSdpProductSearchIndexTrafficForm> resultForm = new ArrayList<FitSdpProductSearchIndexTrafficForm>();
				for(int i=0;i<dtoList.size();i++){
					FitSdpProductSearchIndexTrafficForm dtoForm = new FitSdpProductSearchIndexTrafficForm();
					dtoForm.setFitSdpProductSearchIndexTraffic(dtoList.get(i));
					resultForm.add(dtoForm);
				}
				result.setResults(resultForm);
				result.setPagination(dtos.getPagination());
				return result;
			}
		} catch (Exception e) {
			logger.error("查询产品索引规则失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/queryDepartureCityList", method = { RequestMethod.POST, RequestMethod.GET })
	public BaseResultDto<FitSdpCityGroupForm> queryDepartCityList(Model model, FitSdpCityGroupDto dto,Pagination pg) {
		BaseResultDto<FitSdpCityGroupForm> result = new BaseResultDto<FitSdpCityGroupForm>();
		try {
			if(dto!=null){
				BaseQueryDto<FitSdpCityGroupDto> baseQuery = new BaseQueryDto<FitSdpCityGroupDto>();
				baseQuery.setPagination(pg);
				baseQuery.setCondition(dto);
				BaseResultDto<FitSdpCityGroupDto> cityGroupDto = fitBusinessClient.querySdpProductDepartureCityList(baseQuery);
				List<FitSdpCityGroupDto> dtoList = cityGroupDto.getResults();
				List<FitSdpCityGroupForm> resultForm = new ArrayList<FitSdpCityGroupForm>();
				for(int i=0;i<dtoList.size();i++){
					FitSdpCityGroupForm dtoForm = new FitSdpCityGroupForm();
					dtoForm.setFitSdpCityGroupDto(dtoList.get(i));
					resultForm.add(dtoForm);
				}
				result.setResults(resultForm);
				result.setPagination(cityGroupDto.getPagination());
				return result;
			}
		} catch (Exception e) {
			logger.error("查询产品Id索引失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/querySearchPushInfoList", method = { RequestMethod.POST, RequestMethod.GET })
	public BaseResultDto<VstPushRecordForm> querySearchPushInfoList(Model model, Long productId,Pagination pg) {
		BaseResultDto<VstPushRecordForm> result = new BaseResultDto<VstPushRecordForm>();
		try {
			if(productId!=null){
				BaseQueryDto<Long> baseQuery = new BaseQueryDto<Long>();
				baseQuery.setPagination(pg);
				baseQuery.setCondition(productId);
				BaseResultDto<VstPushRecord> vstDtos = fitVstServiceClient.queryPushInfoList(baseQuery);
				List<VstPushRecord> vstlist = vstDtos.getResults();
				List<VstPushRecordForm> resultForm = new ArrayList<VstPushRecordForm>();
				for(int i=0;i<vstlist.size();i++){
					VstPushRecordForm dtoForm = new VstPushRecordForm();
					dtoForm.setVstPushRecord(vstlist.get(i));
					resultForm.add(dtoForm);
				}
				result.setResults(resultForm);
				result.setPagination(vstDtos.getPagination());
				return result;
			}
		} catch (Exception e) {
			logger.error("查询产品Id索引失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	@ResponseBody
	@RequestMapping(value = "sdpProduct/productQuery", method = { RequestMethod.POST, RequestMethod.GET })
	public BaseResultDto<FitSdpProductBasicInfoForm> querySdpProductList(Model model, FitSdpProductBasicInfoRequestForm requestForm) {
		
		BaseQueryDto<FitSdpProductBasicInfoRequest> baseQuery = new BaseQueryDto<FitSdpProductBasicInfoRequest>();
				//new Pagination(),fitSdpProductBasicInfoRequest);
		baseQuery.setPagination(requestForm.getPagination());
		baseQuery.setCondition(requestForm.getRequest());
		
		BaseResultDto<FitSdpProductBasicInfoForm>  baseResponse = new BaseResultDto<FitSdpProductBasicInfoForm>();
		try {
			BaseResultDto<FitSdpProductBasicInfoDto> baseResultDto = fitBusinessClient.querySdpProductBasicInfoList(baseQuery);
			List<FitSdpProductBasicInfoDto> results = baseResultDto.getResults();
			List<FitSdpProductBasicInfoForm> resultFormList = new ArrayList<FitSdpProductBasicInfoForm>();
			if(CollectionUtils.isNotEmpty(results)){
				for(FitSdpProductBasicInfoDto dto : results){
					FitSdpProductBasicInfoForm form = new FitSdpProductBasicInfoForm();
					form.setFitSdpProductBasicInfoDto(dto);
					resultFormList.add(form);
				}
				baseResponse.setResults(resultFormList);
				baseResponse.setPagination(baseResultDto.getPagination());
			}
		} catch (Exception e) {
			logger.error("自主打包产品查询失败！");
			e.printStackTrace();
		}
		return baseResponse;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/deleteProductInfo", method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,String> deleteProductInfo(Model model, Long productId){
		try {
			if(productId!=null){
				ResultStatus returnStr = fitBusinessClient.deleteSdpProductInfoByProductId(productId);
				Map<String,String> map = new HashMap<String,String>();map.put("returnStr", returnStr.name());
				return map;
			}
		} catch (Exception e) {
			logger.error("自主打包产品信息删除失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/trafficRulesQuery", method = { RequestMethod.POST, RequestMethod.GET })
	public List<FitSdpProductTrafficRulesDto> queryTrafficRules(Model model, Long productId) {
		try {
			List<FitSdpProductTrafficRulesDto> baseResultDto = fitBusinessClient.getProductTrafficRulesByProductId(productId);
			
			if(baseResultDto != null)	{
				return baseResultDto;
			}
		} catch (Exception e) {
			logger.error("自主打包产品查询失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/trafficRulesSave", method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,String> saveOrUpdateProductTrafficRules(Model model,String productTrafficRulesDtosStr){
		try {
			JavaType javaType = JSONMapper.getInstance().getTypeFactory().constructParametricType(ArrayList.class, FitSdpProductTrafficRulesDto.class);
			List<FitSdpProductTrafficRulesDto> list = new ArrayList<FitSdpProductTrafficRulesDto>();
			list = JSONMapper.getInstance().readValue(productTrafficRulesDtosStr, javaType);
			String returnStr = fitBusinessClient.saveOrUpdateProductTrafficRules(list);
			this.updateSdpProductSearchIndex(list.get(0).getProductId());
			Map<String,String> map = new HashMap<String,String>();map.put("returnStr", returnStr);
			return map;
		} catch (Exception e) {
			logger.error("自主打包产品交通规则保存失败！");
			e.printStackTrace();
		}
		return null;//'Success'：成功
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/feeRulesQuery", method = { RequestMethod.POST, RequestMethod.GET })
	public List<FitSdpProductFeeRulesDto> queryFeeRules(Model model, Long productId) {
		try {
			List<FitSdpProductFeeRulesDto> baseResultDto = fitBusinessClient.getProductFeeRulesByProductId(productId);
			
			if(baseResultDto != null)	{
				return baseResultDto;
			}
		} catch (Exception e) {
			logger.error("自主打包产品加价规则查询失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/feeRulesSave", method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,String> saveOrUpdateProductFeeRules(Model model,FitSdpProductFeeRulesDto fitSdpProductFeeRulesDto){
	    try {
			List<FitSdpProductFeeRulesDto> list = new ArrayList<FitSdpProductFeeRulesDto>();
			list.add(fitSdpProductFeeRulesDto);
			String returnStr = fitBusinessClient.saveOrUpdateProductFeeRules(list);
			this.updateSdpProductSearchIndex(fitSdpProductFeeRulesDto.getProductId());
			Map<String,String> map = new HashMap<String,String>();map.put("returnStr", returnStr);
			return map;
		} catch (Exception e) {
			logger.error("自主打包产品加价规则保存失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/cityGroupQuery", method = { RequestMethod.POST, RequestMethod.GET })
	public List<FitSdpCityGroupDto> queryCityGroup(Model model, Long productId) {
		try {
			List<FitSdpCityGroupDto> baseResultDto = fitBusinessClient.getSelectProductCityGroupByProductId(productId);
			
			if(baseResultDto != null)	{
				return baseResultDto;
			}
		} catch (Exception e) {
			logger.error("自主打包产品城市组查询失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/queryOneCity", method = { RequestMethod.POST, RequestMethod.GET })
	public FitSdpCityGroupDto queryOneCity(Model model, Long id) {
		try {
			FitSdpCityGroupDto resultDto = fitBusinessClient.getProductCityGroupById(id);
			
			if(resultDto != null)	{
				return resultDto;
			}
		} catch (Exception e) {
			logger.error("自主打包产品城市查询失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/updateCitysUseFlag", method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,String> updateCityGroupUseFlag(Model model,String cityGroupDtosStr){
	    try {
	    	JavaType javaType = JSONMapper.getInstance().getTypeFactory().constructParametricType(ArrayList.class, FitSdpCityGroupDto.class);
			List<FitSdpCityGroupDto> list = new ArrayList<FitSdpCityGroupDto>();
			list = JSONMapper.getInstance().readValue(cityGroupDtosStr, javaType);
			
			ResultStatus returnStr = fitBusinessClient.updateCityUseFlagBatch(list);
			this.updateSdpProductSearchIndex(list.get(0).getProductId());
			Map<String,String> map = new HashMap<String,String>();map.put("returnStr", returnStr.name());
			return map;
		} catch (Exception e) {
			logger.error("自主打包产品加价规则保存失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/updateCityGroup", method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,String> updateCityGroup(Model model,FitSdpCityGroupDto cityGroupDto){
		Map<String,String> map = new HashMap<String,String>();
		try {
			ResultStatus returnStr = fitBusinessClient.updateOneCityGroup(cityGroupDto);
			map.put("returnStr", returnStr.name());
			return map;
		} catch (Exception e) {
			logger.error("自主打包产品加价规则保存失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	
   @Async
	private void updateSdpProductSearchIndex(Long productId) {
		try {
			fitBatchClient.syncSdpProductSearchIndex(productId);
		} catch (Exception e) {
			logger.error("自主打包产品【"+productId+"】同步索引失败败！");
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/syncSearchIndex", method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,String> syncSdpProductSearchIndex(Model model,Long productId){
		try {
			if(productId!=null){
				ResultStatus returnStr = fitBatchClient.syncSdpProductSearchIndex(productId);
				Map<String,String> map = new HashMap<String,String>();
				map.put("returnStr", returnStr.name());
				return map;
			}
			
		} catch (Exception e) {
			logger.error("自主打包产品加价规则保存失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = "sdpProduct/productExportCsv", method = { RequestMethod.POST, RequestMethod.GET })
	public void productExportCsv(FitSdpProductBasicInfoRequestForm requestForm,HttpServletResponse response){
		
		BaseQueryDto<FitSdpProductBasicInfoRequest> baseQuery = new BaseQueryDto<FitSdpProductBasicInfoRequest>();
		baseQuery.setPagination(requestForm.getPagination());
		baseQuery.setCondition(requestForm.getRequest());
		/**
         * 加载数据
         */
        List<String> revenueReportStrings = fitBusinessClient.querySdpProductExportCsv(baseQuery);
        
        /**
         * 输出流
         */  
        CsvUtils.createCsvStream(FitCsvConfig.FIT_PRODUCT_REPORT_LIST, revenueReportStrings, response);
		
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/suppCallBackQuery", method = { RequestMethod.POST, RequestMethod.GET })
	public BaseResultDto<FitSuppOrderForFlightCallBackForm> suppOrderFlightCallBack(Model model,Pagination pg,FitSuppOrderForFlightCallBackRequest request) {
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
	@RequestMapping(value = "sdpProduct/queryOneTrafficIndex", method = { RequestMethod.POST, RequestMethod.GET })
	public FitSdpProductSearchIndexTraffic queryOneTrafficIndex(Model model, Long id) {
		try {
			FitSdpProductSearchIndexTraffic resultDto = fitBusinessClient.getTrafficIndexById(id);
			
			if(resultDto != null)	{
				return resultDto;
			}
		} catch (Exception e) {
			logger.error("自主打包产品城市查询失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/updateTrafficIndex", method = { RequestMethod.POST, RequestMethod.GET })
	public Map<String,String> updateTrafficIndex(Model model, FitSdpProductSearchIndexTraffic dto) {
		
		Map<String,String> map = new HashMap<String,String>();
		try {
			ResultStatus returnStr = fitBusinessClient.updateTrafficIndex(dto);
			map.put("returnStr", returnStr.name());
			return map;
		} catch (Exception e) {
			logger.error("自主打包产品加价规则保存失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "sdpProduct/handleSuppFlightCallBack", method = { RequestMethod.POST, RequestMethod.GET })
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
